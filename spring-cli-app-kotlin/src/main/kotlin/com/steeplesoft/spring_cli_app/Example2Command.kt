package com.steeplesoft.spring_cli_app

import com.beust.jcommander.Parameters
import org.springframework.stereotype.Component

@Component
@Parameters(commandNames = [Example2Command.COMMAND_NAME], commandDescription = "Example command #2")
class Example2Command : Command {
    override fun commandName(): String {
        return COMMAND_NAME
    }

    override fun run() {
        println("You ran something else!")
    }

    companion object {
        const val COMMAND_NAME = "something-else"
    }
}
