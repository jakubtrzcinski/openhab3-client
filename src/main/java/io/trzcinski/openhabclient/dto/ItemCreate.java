package io.trzcinski.openhabclient.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Jakub Trzcinski jakub@trzcinski.io
 * @since 18-06-2022
 */
@Getter
@AllArgsConstructor
public class ItemCreate {
    private String category;
    private String label;
    private List<String> tags;
    private String type;
    private String name;

    public ItemCreate(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
