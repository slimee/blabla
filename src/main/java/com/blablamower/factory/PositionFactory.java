package com.blablamower.factory;

import com.blablamower.domain.Orientation;
import com.blablamower.domain.Position;
import com.blablamower.exception.InvalidPositionBuildingException;
import com.blablamower.exception.NoPositionBuildingException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creates {@link Position} from other representations.
 */
@Component
public class PositionFactory {

    /**
     * Regex to match position string
     */
    private final static Pattern positionPattern = Pattern.compile("^(?<x>\\d+) (?<y>\\d+) (?<o>[NEWS])$");

    /**
     * Build {@link Position} from string
     * @param line the raw string
     * @return {@link Position} matching the raw string
     */
    public Position toPosition(final String line) {
        if (line == null) {
            throw new NoPositionBuildingException("No position line");
        }
        final Position.PositionBuilder builder = Position.builder();

        final Matcher matcher = positionPattern.matcher(line);
        if (matcher.matches()) {
            builder.x(Integer.parseInt(matcher.group("x")));
            builder.y(Integer.parseInt(matcher.group("y")));
            builder.orientation(Orientation.valueOf(matcher.group("o")));
        } else {
            throw new InvalidPositionBuildingException("Problem in position line '" + line + "'. Should match '" + positionPattern.toString() + "'");
        }

        return builder.build();
    }

}
