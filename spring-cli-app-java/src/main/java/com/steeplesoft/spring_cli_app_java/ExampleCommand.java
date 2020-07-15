package com.steeplesoft.spring_cli_app_java;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.springframework.stereotype.Component;

@Component
@Parameters(commandNames = ExampleCommand.COMMAND_NAME,
        commandDescription = "Example command")
public class ExampleCommand implements Command {
    public static final String COMMAND_NAME = "example";

    @Parameter(names = "--example", description = "Example parameter")
    private String example;

    @Override
    public String commandName() {
        return COMMAND_NAME;
    }

    @Override
    public void run() {
        System.out.println("You ran the command " + COMMAND_NAME + " with the parameter --example set to " + example);
    }
}
