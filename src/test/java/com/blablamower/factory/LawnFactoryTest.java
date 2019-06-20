package com.blablamower.factory;

import com.blablamower.exception.*;
import com.blablamower.domain.Lawn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LawnFactoryTest {

    @Spy
    private LawnFactory factory;

    @Test
    public void testLawnFromLine() {
        final Lawn actual = factory.toLawn("4 5");
        final Lawn expected = Lawn.builder().width(4).height(5).build();

        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test(expected = NoLawnBuildingException.class)
    public void testLawnFromNullLine() {
        factory.toLawn(null);
    }

    @Test(expected = InvalidLawnBuildingException.class)
    public void testLawnFromBadLine() {
        factory.toLawn("a 56");
    }

}
