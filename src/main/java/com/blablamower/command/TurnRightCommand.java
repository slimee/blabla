package com.blablamower.command;

import com.blablamower.domain.Lawn;
import com.blablamower.domain.Orientation;
import com.blablamower.domain.Position;

import java.util.HashMap;
import java.util.Map;

/**
 * Create a new position by applying a Turn Right operation to the current position.
 */
public class TurnRightCommand implements ICommand {

    /**
     * For each possible {@link Orientation}, gives the matching right-turned {@link Orientation}.
     */
    private final Map<Orientation, Orientation> nextOf = new HashMap<Orientation, Orientation>() {{
        put(Orientation.N, Orientation.E);
        put(Orientation.E, Orientation.S);
        put(Orientation.S, Orientation.W);
        put(Orientation.W, Orientation.N);
    }};

    @Override
    public Position execute(final Lawn lawn, final Position position) {
        return Position.builder()
                .x(position.getX())
                .y(position.getY())
                .orientation(nextOf.get(position.getOrientation()))
                .build();
    }
}
