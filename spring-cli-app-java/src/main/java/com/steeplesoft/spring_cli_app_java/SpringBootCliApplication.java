package com.steeplesoft.spring_cli_app_java;

import com.beust.jcommander.JCommander;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootCliApplication implements CommandLineRunner {
    @Autowired
    private List<Command> commands;

    @Override
    public void run(String... args) {
        JCommander.Builder builder = JCommander.newBuilder()
                .programName("spring-boot-cli");
        commands.forEach((c) -> builder.addCommand(c));
        JCommander jc = builder.build();
        jc.parse(args);

        Optional<Command> command = commands.stream().filter(c -> c.commandName().equals(jc.getParsedCommand()))
                .findFirst();

        if (command.isPresent()) {
            command.get().run();
        } else {
            jc.usage();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCliApplication.class, args);
    }
}
// commands: List<Command>) : CommandLineRunner {
//        override fun run(vararg args: String?) {
//        val builder = JCommander.newBuilder()
//        commands.forEach {
//        builder.addCommand(it.getCommandName(), it)
//        }
//        val jc = builder.build();
//
//        jc.parse(*args)
//
//        val command = commands.firstOrNull { it.getCommandName() == jc.parsedCommand }
//        if (command == null) {
//        jc.usage()
//        } else {
//        command.run()
//        }
//        }
//        }
//
//        fun main(args: Array<String>) {
//        runApplication<ShadowDocumentsApplication>(*args)
//        }
