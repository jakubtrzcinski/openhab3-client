package io.trzcinski.openhabclient.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommandOption{
    public final String command;
    public final String label;
}
