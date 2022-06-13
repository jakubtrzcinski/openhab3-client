package io.trzcinski.openhabclient.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Jakub Trzcinski jakub@trzcinski.io
 * @since 12-06-2022
 */
@RequiredArgsConstructor
@Getter
public class Item{
    public final String link;
    public final String state;
    public final StateDescription stateDescription;
    public final CommandDescription commandDescription;
    public final boolean editable;
    public final String type;
    public final String name;
    public final String label;
    public final List<Object> tags;
    public final List<Object> groupNames;
}



