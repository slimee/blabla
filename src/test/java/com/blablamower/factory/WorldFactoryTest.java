package com.blablamower.factory;

import com.blablamower.domain.World;
import com.blablamower.fixtures.WorldFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class WorldFactoryTest {

    @Autowired
    private WorldFactory worldFactory;

    @Test
    public void testWorldFactory() {
        final World expected = new WorldFixture().getSimple();
        final World actual = worldFactory.toWorld("src/test/java/resources/simple.world");

        assertThat(expected).isEqualToComparingFieldByField(actual);
    }


}
