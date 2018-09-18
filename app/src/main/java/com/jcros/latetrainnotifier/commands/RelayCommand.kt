package com.jcros.latetrainnotifier.commands

class RelayCommand(val action: () -> Unit) : ICommand {

    override fun execute() {
        action()
    }
}