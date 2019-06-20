package com.blablamower.fixtures;

import com.blablamower.domain.Position;

import static com.blablamower.domain.Orientation.*;

public class PositionFixture {

    public static Position[] getSimple() {
        return new Position[]{
                Position.builder().x(2).y(3).orientation(N).build(),
                Position.builder().x(5).y(1).orientation(E).build()
        };
    }

}
