package com.blablamower.command;

import com.blablamower.domain.Lawn;
import com.blablamower.domain.Orientation;
import com.blablamower.domain.Position;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.blablamower.domain.Orientation.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoForwardCommandTest {

    @Autowired
    GoForwardCommand command;

    private Lawn lawn;

    @Before
    public void before() {
        lawn = Lawn.builder().width(5).height(5).build();
    }

    @Test
    public void testGoToNorth() {
        checkGoForward(
                Position.builder().x(1).y(1).orientation(N).build(),
                Position.builder().x(1).y(2).orientation(N).build()
        );
    }

    @Test
    public void testGoBehindNorth() {
        checkGoForward(
                Position.builder().x(1).y(5).orientation(N).build(),
                Position.builder().x(1).y(5).orientation(N).build()
        );
    }

    @Test
    public void testMany() {
        quickCheck(N, 1, 1, 1, 2);
        quickCheck(N, 1, 4, 1, 5);
        quickCheck(N, 1, 5, 1, 5);

        quickCheck(S, 1, 1, 1, 1);
        quickCheck(S, 1, 2, 1, 1);
        quickCheck(S, 1, 5, 1, 4);

        quickCheck(E, 1, 1, 2, 1);
        quickCheck(E, 4, 1, 5, 1);
        quickCheck(E, 5, 1, 5, 1);

        quickCheck(W, 1, 1, 1, 1);
        quickCheck(W, 2, 1, 1, 1);
        quickCheck(W, 5, 1, 4, 1);
    }

    private void checkGoForward(final Position position, final Position expected) {
        final Position actual = command.execute(lawn, position);

        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    private void quickCheck(final Orientation o, final int x1, final int y1, final int x2, final int y2) {
        checkGoForward(
                Position.builder().x(x1).y(y1).orientation(o).build(),
                Position.builder().x(x2).y(y2).orientation(o).build()
        );
    }

}
