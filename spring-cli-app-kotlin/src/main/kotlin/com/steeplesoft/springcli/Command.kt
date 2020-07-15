package com.steeplesoft.springcli

interface Command {
    fun commandName() : String
    fun run()
}
