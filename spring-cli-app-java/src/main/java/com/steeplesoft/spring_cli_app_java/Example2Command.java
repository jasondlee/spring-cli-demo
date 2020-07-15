package com.steeplesoft.spring_cli_app_java;

import com.beust.jcommander.Parameters;
import org.springframework.stereotype.Component;

@Component
@Parameters(commandNames = Example2Command.COMMAND_NAME,
        commandDescription = "Example command #2")
public class Example2Command implements Command {
    public static final String COMMAND_NAME = "something-else";

    @Override
    public String commandName() {
        return COMMAND_NAME;
    }

    @Override
    public void run() {
        System.out.println("You ran something else!");
    }
}
