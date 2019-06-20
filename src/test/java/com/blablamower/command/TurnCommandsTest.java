package com.blablamower.command;

import com.blablamower.domain.Orientation;
import com.blablamower.domain.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.blablamower.domain.Orientation.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnCommandsTest {

    @Autowired
    TurnLeftCommand turnLeftComand;

    @Autowired
    TurnRightCommand turnRightCommand;

    @Test
    public void testLeft() {
        checkTurn(turnLeftComand, N, W);
        checkTurn(turnLeftComand, W, S);
        checkTurn(turnLeftComand, S, E);
        checkTurn(turnLeftComand, E, N);
    }

    @Test
    public void testRight() {
        final ICommand turnRightComand = new TurnRightCommand();
        checkTurn(turnRightComand, W, N);
        checkTurn(turnRightComand, S, W);
        checkTurn(turnRightComand, E, S);
        checkTurn(turnRightComand, N, E);
    }

    private void checkTurn(final ICommand turnComand, final Orientation initial, final Orientation expectedOrientation) {

        final Position actual = turnComand.execute(null, Position.builder().orientation(initial).build());
        final Position expected = Position.builder().orientation(expectedOrientation).build();

        assertThat(actual).isEqualToComparingFieldByField(expected);
    }


}
