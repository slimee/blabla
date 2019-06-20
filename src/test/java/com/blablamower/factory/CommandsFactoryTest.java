package com.blablamower.factory;

import com.blablamower.exception.InvalidCommandsBuildingException;
import com.blablamower.exception.NoCommandsBuildingException;
import com.blablamower.domain.CommandEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.blablamower.domain.CommandEnum.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CommandsFactoryTest {

    @Spy
    private CommandsFactory factory;

    @Test
    public void testCommandsFromLine() {
        final List<CommandEnum> actual = factory.toCommands("LFRLFR");

        assertThat(actual).containsExactly(L, F, R, L, F, R);
    }

    @Test(expected = NoCommandsBuildingException.class)
    public void testCommandsFromNullLine() {
        factory.toCommands(null);
    }

    @Test(expected = InvalidCommandsBuildingException.class)
    public void testCommandsFromBadLine() {
        factory.toCommands("LFR9LFR");
    }

}