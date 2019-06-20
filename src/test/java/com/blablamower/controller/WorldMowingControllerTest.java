package com.blablamower.controller;

import com.blablamower.command.CommandService;
import com.blablamower.domain.Position;
import com.blablamower.domain.World;
import com.blablamower.domain.WorldResult;
import com.blablamower.factory.WorldFactory;
import com.blablamower.fixtures.PositionFixture;
import com.blablamower.fixtures.WorldFixture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Example of an unit test using Mockito.
 * Only the worldMowingController is tested.
 */
@RunWith(MockitoJUnitRunner.class)
public class WorldMowingControllerTest {


    private WorldMowingController worldMowingController;

    @Mock
    WorldFactory worldFactory;

    @Mock
    CommandService commandService;

    @Before
    public void init() {
        worldMowingController = Mockito.spy(new WorldMowingController(commandService, worldFactory));
    }

    @Test
    public void testPathToLogDestination() {
        final String pathStr = "pathStr";
        final World world = WorldFixture.getSimple();
        final Position[] positions = PositionFixture.getSimple();
        final WorldResult expected = WorldResult.builder().initialWorld(world).positions(positions).build();

        when(worldFactory.toWorld(pathStr)).thenReturn(world);
        when(commandService.mowTheLawn(world)).thenReturn(positions);

        final WorldResult actual = worldMowingController.getWorldResult(pathStr);

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
        verify(worldFactory).toWorld(pathStr);
        verify(commandService).mowTheLawn(world);
    }
}
