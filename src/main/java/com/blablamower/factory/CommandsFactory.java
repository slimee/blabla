package com.blablamower.factory;

import com.blablamower.exception.InvalidCommandsBuildingException;
import com.blablamower.exception.NoCommandsBuildingException;
import com.blablamower.domain.CommandEnum;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Build {@link CommandEnum}
 */
@Component
public class CommandsFactory {

    /**
     * Regex to match Commands string
     */
    private final static Pattern commandsPattern = Pattern.compile("^[LFR]+$");

    /**
     * @param line the raw string
     * @return the builded object
     */
    public List<CommandEnum> toCommands(final String line) {
        if (line == null) {
            throw new NoCommandsBuildingException("No commands line");
        }

        final Matcher matcher = commandsPattern.matcher(line);
        if (matcher.matches()) {
            return Arrays
                    .stream(line.split(""))
                    .map(CommandEnum::valueOf)
                    .collect(Collectors.toList());
        } else {
            throw new InvalidCommandsBuildingException("Problem in commands line '" + line + "'. Should match '" + commandsPattern.toString() + "'");
        }
    }
}
