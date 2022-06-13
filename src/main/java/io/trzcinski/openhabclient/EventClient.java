package io.trzcinski.openhabclient;

import io.reactivex.rxjava3.subjects.Subject;
import io.trzcinski.openhabclient.dto.Event;

/**
 * @author Jakub Trzcinski jakub@trzcinski.io
 * @since 13-06-2022
 */
public interface EventClient {
    public Subject<Event> all();
    public Thread getListener();
}
