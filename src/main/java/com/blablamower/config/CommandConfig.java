package com.blablamower.config;

import com.blablamower.domain.CommandEnum;
import com.blablamower.command.GoForwardCommand;
import com.blablamower.command.ICommand;
import com.blablamower.command.TurnLeftCommand;
import com.blablamower.command.TurnRightCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.blablamower.domain.CommandEnum.*;

@Configuration
public class CommandConfig {

    @Bean
    GoForwardCommand forwardCommand() {
        return new GoForwardCommand();
    }

    @Bean
    TurnLeftCommand turnLeftCommand() {
        return new TurnLeftCommand();
    }

    @Bean
    TurnRightCommand turnRightCommand() {
        return new TurnRightCommand();
    }

    /**
     * @return {@link CommandEnum} as key, and matching {@link ICommand} as values.
     */
    @Bean
    protected Map<CommandEnum, ICommand> commands() {
        return new HashMap<CommandEnum, ICommand>() {{
            put(F, forwardCommand());
            put(L, turnLeftCommand());
            put(R, turnRightCommand());
        }};
    }
}
