package com.blablamower.command;

import com.blablamower.domain.Lawn;
import com.blablamower.domain.Orientation;
import com.blablamower.domain.Position;
import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Create a new position by applying a Go Further operation to the current position.
 */
public class GoForwardCommand implements ICommand {

    /**
     * Private (x,y) coordinate. Used in {@link GoForwardCommand#moves} to represent GoForward transformations.
     */
    @Builder
    @Getter
    private static class Move {
        private int x;
        private int y;
    }

    /**
     * For each possible {@link Orientation}, gives the matching {@link Move}.
     */
    private static Map<Orientation, Move> moves = new HashMap<Orientation, Move>() {{
        put(Orientation.N, Move.builder().x(0).y(1).build());
        put(Orientation.W, Move.builder().x(-1).y(0).build());
        put(Orientation.S, Move.builder().x(0).y(-1).build());
        put(Orientation.E, Move.builder().x(1).y(0).build());
    }};

    @Override
    public Position execute(final Lawn lawn, final Position position) {
        final Move move = moves.get(position.getOrientation());
        return Position.builder()
                .x(Math.min(Math.max(position.getX() + move.getX(), 1), lawn.getWidth()))
                .y(Math.min(Math.max(position.getY() + move.getY(), 1), lawn.getHeight()))
                .orientation(position.getOrientation())
                .build();
    }

}
