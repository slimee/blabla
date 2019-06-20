package com.blablamower.command;

import com.blablamower.domain.Orientation;
import com.blablamower.domain.Position;
import com.blablamower.fixtures.WorldFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandServiceTest {

    @Autowired
    private CommandService commandService;

    @Test
    public void testMow() {
        final Position[] actual = commandService.mowTheLawn(WorldFixture.getSimple());
        final Position[] expected = {
                //                  \/ and not 1 ;)
                Position.builder().x(2).y(3).orientation(Orientation.N).build(),
                Position.builder().x(5).y(1).orientation(Orientation.E).build()
        };
        assertThat(actual).containsExactly(expected);
    }
}
