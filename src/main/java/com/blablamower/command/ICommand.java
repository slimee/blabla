package com.blablamower.command;

import com.blablamower.domain.Lawn;
import com.blablamower.domain.Position;

/**
 * A command is a world transform.
 */
public interface ICommand {
    /**
     * Run a command
     * @param lawn the lawn of the world.
     * @param position the position of the mower.
     * @return the new position of the mower.
     */
    Position execute(final Lawn lawn, final Position position);
}
