package com.steeplesoft.springcli

import com.beust.jcommander.Parameter
import com.beust.jcommander.Parameters
import org.springframework.stereotype.Component

@Component
@Parameters(commandNames = [ExampleCommand.COMMAND_NAME], commandDescription = "Example command")
class ExampleCommand : Command {
    @Parameter(names = ["--example"], description = "Example parameter")
    private var example: String? = null

    override fun commandName(): String {
        return COMMAND_NAME
    }

    override fun run() {
        println("You ran the command $COMMAND_NAME with the parameter --example set to $example")
    }

    companion object {
        const val COMMAND_NAME = "example"
    }
}
