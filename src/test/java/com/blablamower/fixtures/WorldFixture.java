package com.blablamower.fixtures;

import com.blablamower.domain.*;

import java.util.Arrays;

import static com.blablamower.domain.CommandEnum.*;

public class WorldFixture {

    public static World getSimple() {
        return World
                .builder()
                .lawn(Lawn.builder()
                        .width(5)
                        .height(5)
                        .build()
                )
                .mowerJobs(Arrays.asList(
                        MowerJob.builder()
                                .mower(Mower.builder()
                                        .position(Position.builder()
                                                .x(1).y(2).orientation(Orientation.N)
                                                .build()
                                        )
                                        .build()
                                )
                                .commandEnums(Arrays.asList(L, F, L, F, L, F, L, F, F))
                                .build(),
                        MowerJob.builder()
                                .mower(Mower.builder()
                                        .position(Position.builder()
                                                .x(3).y(3).orientation(Orientation.E)
                                                .build()
                                        )
                                        .build()
                                )
                                .commandEnums(Arrays.asList(F, F, R, F, F, R, F, R, R, F))
                                .build()
                ))
                .build();
    }

}
