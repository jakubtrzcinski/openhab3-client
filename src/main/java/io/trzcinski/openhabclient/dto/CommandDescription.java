package io.trzcinski.openhabclient.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class CommandDescription{
    public final List<CommandOption> commandOptions;
}
