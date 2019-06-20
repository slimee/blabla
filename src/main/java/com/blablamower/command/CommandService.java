package com.blablamower.command;

import com.blablamower.domain.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * Commands facade. To deduce mower destinations from a world, applying needed {@link ICommand}.
 */
@Component
public class CommandService implements ICommandService {

    private final Map<CommandEnum, ICommand> commands;

    public CommandService(final Map<CommandEnum, ICommand> commands) {
        Assert.notNull(commands, "commands is not defined");
        this.commands = commands;
    }

    @Override
    public Position[] mowTheLawn(final World world) {
        final Lawn lawn = world.getLawn();
        return world.getMowerJobs().stream()
                .map(mowerJob -> getDestination(lawn, mowerJob))
                .toArray(Position[]::new);
    }

    private Position getDestination(final Lawn lawn, final MowerJob mowerJob) {
        final Position initialPosition = mowerJob.getMower().getPosition();
        final List<CommandEnum> commandEnums = mowerJob.getCommandEnums();

        return commandEnums.stream().reduce(
                initialPosition,
                (position, commandEnum) -> commands.get(commandEnum).execute(lawn, position),
                (p1, p2) -> p2
        );
    }

}
