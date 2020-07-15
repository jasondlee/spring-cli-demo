package com.steeplesoft.spring_cli_app

import com.beust.jcommander.JCommander
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootCliApplication(val commands: List<Command>) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val builder = JCommander.newBuilder()
                .programName("spring-boot-cli")
        commands.forEach {
            builder.addCommand(it.commandName(), it)
        }
        val jc = builder.build();

        jc.parse(*args)

        val command = commands.firstOrNull { it.commandName() == jc.parsedCommand }
        if (command == null) {
            jc.usage()
        } else {
            command.run()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringBootCliApplication>(*args)
}
