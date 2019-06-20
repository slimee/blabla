package com.blablamower;

import com.blablamower.controller.WorldMowingController;
import com.blablamower.domain.Position;
import com.blablamower.domain.WorldResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * Entry Point for App.
 * Uses Spring ApplicationRunner wrapper.
 * Use command line args to perform a World Mow accordingly.
 */
@Slf4j
@SpringBootApplication
public class BlablaMowerApplication implements ApplicationRunner {

    @Autowired
    WorldMowingController controller;

    public BlablaMowerApplication(WorldMowingController controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(BlablaMowerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        if (args.containsOption("file")) {
            final String pathStr = args.getOptionValues("file").get(0);
            final WorldResult worldResult = controller.getWorldResult(pathStr);

            Arrays.stream(worldResult.getPositions())
                    .map(Position::toString)
                    .forEach(log::info);

        } else {
            log.info("usage: --file=file.world");
        }
    }
}
