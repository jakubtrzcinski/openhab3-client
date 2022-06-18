package io.trzcinski.openhabclient;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import lombok.RequiredArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author Jakub Trzcinski jakub@trzcinski.io
 * @since 12-06-2022
 */
@RequiredArgsConstructor
public class OpenhabClientImpl implements OpenhabClient {
    private final String url;
    private final String authHeader;

    private EventClient eventClient;

    public OpenhabClientImpl(String url, String login, String password) {
        this.url = url;
        this.authHeader = "Basic "+ new String(Base64.getEncoder().encode((login+":"+password).getBytes(StandardCharsets.UTF_8)));
    }

    public ItemClient item(){
        return createClient(ItemClient.class);
    }

    public EventClient event(){
        if(eventClient == null) {
            eventClient = new EventClientImpl(
                    url,
                    authHeader
            );
        }
        return eventClient;
    }

    private<T> T createClient(Class<T> clazz) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .requestInterceptor(requestTemplate -> requestTemplate.header("Authorization", authHeader))
                .target(clazz, url);
    }


}
