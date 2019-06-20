package com.blablamower.command;

import com.blablamower.domain.Position;
import com.blablamower.domain.World;

/**
 * Describe the operations providing a position array (the mower destinations) of a world.
 */
public interface ICommandService {
    Position[] mowTheLawn(final World world);
}
