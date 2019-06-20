package com.blablamower.factory;

import com.blablamower.exception.InvalidPositionBuildingException;
import com.blablamower.exception.NoPositionBuildingException;
import com.blablamower.domain.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.blablamower.domain.Orientation.W;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PositionFactoryTest {

    @Spy
    private PositionFactory factory;

    @Test
    public void testPositionFromLine() {
        final Position actual = factory.toPosition("4 5 W");
        final Position expected = Position.builder().x(4).y(5).orientation(W).build();

        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test(expected = NoPositionBuildingException.class)
    public void testPositionFromNullLine() {
        factory.toPosition(null);
    }

    @Test(expected = InvalidPositionBuildingException.class)
    public void testPositionFromBadLine() {
        factory.toPosition("5 56 Qert");
    }

}
