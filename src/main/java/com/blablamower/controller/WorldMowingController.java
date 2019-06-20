package com.blablamower.controller;

import com.blablamower.command.ICommandService;
import com.blablamower.domain.Position;
import com.blablamower.domain.World;
import com.blablamower.domain.WorldResult;
import com.blablamower.factory.WorldFactory;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handle mowing requests.
 */
@Component
@NoArgsConstructor
public class WorldMowingController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(WorldMowingController.class);

    @Autowired
    WorldFactory worldFactory;

    @Autowired
    ICommandService commandService;

    public WorldMowingController(ICommandService commandService, WorldFactory worldFactory) {
        this.commandService = commandService;
        this.worldFactory = worldFactory;
    }

    /**
     * Mowing request that translate a filepath into a {@link WorldResult}
     * @param pathStr input file path
     * @return a world result with mower destinations.
     */
    public WorldResult getWorldResult(final String pathStr) {
        final World world = worldFactory.toWorld(pathStr);
        final Position[] positions = commandService.mowTheLawn(world);

        return WorldResult.builder()
                .initialWorld(world)
                .positions(positions)
                .build();
    }
}
