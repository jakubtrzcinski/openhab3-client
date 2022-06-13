package io.trzcinski.openhabclient;

import com.google.gson.Gson;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.trzcinski.openhabclient.dto.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * @author Jakub Trzcinski jakub@trzcinski.io
 * @since 12-06-2022
 */
@Slf4j
@RequiredArgsConstructor
class EventClientImpl implements EventClient {

    private final String url;
    private final String auth;
    private final Gson gson = new Gson();

    @Getter
    private Thread listener;

    @SneakyThrows
    public Subject<Event> all(){
        var pub = PublishSubject.<Event>create();
        listener = new Thread(()->{
            while(true) {
                Event prev = null;
                try {
                    URL website = new URL(url+"/rest/events");
                    URLConnection connection = website.openConnection();
                    connection.addRequestProperty("Authorization", auth);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream()));

                    String inputLine;

                    while ((inputLine = in.readLine()) != null) {
                        var event = processMessage(inputLine);
                        if (event != null && !event.equals(prev)) {
                            pub.onNext(event);
                        }
                        prev = event;
                    }
                    in.close();
                } catch (Exception ex) {
                    log.error("An error occued while listening for an events, retrying to connect", ex);
                }
            }
        });
        listener.start();

        return pub;
    }

    private Event processMessage(String message){
        if(!message.startsWith("data: ")){
            return null;
        }
        message = message.substring(5);
        var map = gson.fromJson(message, Map.class);
        return new Event(
                (String)map.getOrDefault("topic", "unknown"),
                gson.fromJson((String)map.getOrDefault("payload", "{}"), Event.Payload.class),
                Event.Type.valueOf((String)map.getOrDefault("type", ""))
        );

    }

}
