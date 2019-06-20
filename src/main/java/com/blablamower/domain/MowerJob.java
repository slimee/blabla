package com.blablamower.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class MowerJob {
    private final Mower mower;
    private final List<CommandEnum> commandEnums;
}
