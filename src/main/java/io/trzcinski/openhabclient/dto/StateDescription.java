package io.trzcinski.openhabclient.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Getter
public class StateDescription{
    public final String pattern;
    public final boolean readOnly;
    public final List<Option> options;
}
