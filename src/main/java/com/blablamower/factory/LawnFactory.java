package com.blablamower.factory;

import com.blablamower.domain.CommandEnum;
import com.blablamower.domain.Lawn;
import com.blablamower.exception.InvalidLawnBuildingException;
import com.blablamower.exception.NoLawnBuildingException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creates {@link Lawn} from other representations.
 */
@Component
public class LawnFactory {

    /**
     * Regex to match lawn string
     */
    private final static Pattern lawnPattern = Pattern.compile("^(?<width>\\d+) (?<height>\\d+)$");

    /**
     * Build {@link Lawn} from string
     * @param line the raw string
     * @return {@link Lawn} matching the raw string
     */
    public Lawn toLawn(final String line) {
        if (line == null) {
            throw new NoLawnBuildingException("No lawn line");
        }
        final Lawn.LawnBuilder builder = Lawn.builder();
        final Matcher matcher = lawnPattern.matcher(line);
        if (matcher.matches()) {
            builder.width(Integer.parseInt(matcher.group("width")));
            builder.height(Integer.parseInt(matcher.group("height")));
        } else {
            throw new InvalidLawnBuildingException("Problem in lawn line '" + line + "'. Should match '" + lawnPattern.toString() + "'");
        }
        return builder.build();
    }

}
