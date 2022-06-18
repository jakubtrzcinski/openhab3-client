package io.trzcinski.openhabclient;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.trzcinski.openhabclient.dto.Item;
import io.trzcinski.openhabclient.dto.ItemCreate;

import java.util.List;

/**
 * @author Jakub Trzcinski jakub@trzcinski.io
 * @since 12-06-2022
 */
public interface ItemClient {
    @RequestLine("GET /rest/items/")
    List<Item> getAll();

    @RequestLine("GET /rest/items/{id}")
    Item get(@Param("id") String id);

    @RequestLine("POST /rest/items/{id}")
    @Headers("Content-Type: text/plain")
    @Body("{state}")
    void setState(@Param("id") String id, @Param("state")  String state);

    default String getState(@Param("id") String id) {
        return get(id).getState();
    }

    @RequestLine("PUT /rest/items/{name}")
    @Headers("Content-Type: application/json")
    void create(@Param("name") String name, ItemCreate create);
}
