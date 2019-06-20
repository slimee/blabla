package com.blablamower.factory;

import com.blablamower.exception.WorldBuildingException;
import com.blablamower.domain.Mower;
import com.blablamower.domain.MowerJob;
import com.blablamower.domain.World;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Creates {@link World} from other representations.
 */
@Component
public class WorldFactory {

    private LawnFactory lawnFactory;
    private PositionFactory positionFactory;
    private CommandsFactory commandsFactory;

    public WorldFactory(final LawnFactory lawnFactory, final PositionFactory positionFactory, final CommandsFactory commandsFactory) {
        Assert.notNull(lawnFactory, "lawnFactory is null");
        Assert.notNull(positionFactory, "positionFactory is null");
        Assert.notNull(commandsFactory, "commandsFactory is null");

        this.lawnFactory = lawnFactory;
        this.positionFactory = positionFactory;
        this.commandsFactory = commandsFactory;
    }

    /**
     * Build {@link World} from a filepath. The targeted file must be in the .world format.
     * @param pathStr file path
     * @return world representing the targeted .world file.
     */
    public World toWorld(final String pathStr) {
        final Path path = Paths.get(pathStr);

        final World.WorldBuilder worldBuilder = World.builder();

        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {

            worldBuilder.lawn(lawnFactory.toLawn(reader.readLine()));
            final ArrayList<MowerJob> mowerJobs = new ArrayList<>();
            worldBuilder.mowerJobs(mowerJobs);

            String positionLine;
            String commandsLine;
            while ((positionLine = reader.readLine()) != null) {
                commandsLine = reader.readLine();

                mowerJobs.add(MowerJob.builder()
                        .mower(Mower.builder().position(positionFactory.toPosition(positionLine)).build())
                        .commandEnums(commandsFactory.toCommands(commandsLine))
                        .build()
                );
            }
        } catch (IOException ex) {
            throw new WorldBuildingException("Problem reading world file '" + pathStr + "'", ex);
        }

        return worldBuilder.build();
    }

}
