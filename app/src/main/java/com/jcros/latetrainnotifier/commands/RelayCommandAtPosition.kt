package com.jcros.latetrainnotifier.commands

class RelayCommandAtPosition(val action: (pos: Int) -> Unit) : ICommand {

    var position: Int? = null

    override fun execute() {

        action(position ?: return)
    }
}