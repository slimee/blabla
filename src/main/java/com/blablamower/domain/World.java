package com.blablamower.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@EqualsAndHashCode
@Builder
@Getter
public class World {
    private Lawn lawn;
    private List<MowerJob> mowerJobs;
}
