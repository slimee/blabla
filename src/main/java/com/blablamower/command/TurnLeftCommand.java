package com.blablamower.command;

import com.blablamower.domain.Lawn;
import com.blablamower.domain.Orientation;
import com.blablamower.domain.Position;

import java.util.HashMap;
import java.util.Map;

/**
 * Create a new position by applying a Turn Left operation to the current position.
 */
public class TurnLeftCommand implements ICommand {

    /**
     * For each possible {@link Orientation}, gives the matching left-turned {@link Orientation}.
     */
    private final Map<Orientation, Orientation> nextOf = new HashMap<Orientation, Orientation>() {{
        put(Orientation.N, Orientation.W);
        put(Orientation.W, Orientation.S);
        put(Orientation.S, Orientation.E);
        put(Orientation.E, Orientation.N);
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
