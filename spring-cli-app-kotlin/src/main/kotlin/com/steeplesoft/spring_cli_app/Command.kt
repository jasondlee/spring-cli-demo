package com.steeplesoft.spring_cli_app

interface Command {
    fun commandName() : String
    fun run()
}
