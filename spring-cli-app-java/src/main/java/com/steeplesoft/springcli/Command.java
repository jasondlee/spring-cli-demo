package com.steeplesoft.springcli;

public interface Command {
    String commandName();
    void run();
}
