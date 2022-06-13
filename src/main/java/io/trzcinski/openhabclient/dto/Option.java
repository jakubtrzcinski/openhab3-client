package io.trzcinski.openhabclient.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Option{
    public final String value;
    public final String label;
}
