package io.trzcinski.openhabclient;

/**
 * @author Jakub Trzcinski jakub@trzcinski.io
 * @since 13-06-2022
 */
public interface OpenhabClient {
    ItemClient item();
    EventClient event();
}
