/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.command.exception

import dev.cirosanchez.cave.Cave
import me.clip.placeholderapi.PlaceholderAPI
import revxrsal.commands.bukkit.exception.*
import revxrsal.commands.command.CommandActor
import revxrsal.commands.ktx.colorize

class ExceptionAdapter : BukkitExceptionAdapter() {
    val messages = Cave.configurationProvider().messages
    val plugin = Cave.get()
    override fun senderNotPlayer(actor: CommandActor, exception: SenderNotPlayerException) {
        val message = messages.getString("exceptions.must-be-player")

        if (message == null){
            plugin.logger.severe("exceptions.must-be-player doesnt exist in messages.yml!")
            return
        }

        actor.error(message)
    }

    override fun senderNotConsole(actor: CommandActor, exception: SenderNotConsoleException) {
        val message = messages.getString("exceptions.must-be-console")

        if (message == null){
            plugin.logger.severe("exceptions.must-be-console doesnt exist in messages.yml!")
            return
        }
        actor.error(message)
    }

    override fun invalidPlayer(actor: CommandActor, exception: InvalidPlayerException) {
        var message = messages.getString("exceptions.must-be-player")

        if (message == null){
            plugin.logger.severe("exceptions.must-be-player doesnt exist in messages.yml!")
            return
        }
        val input = exception.input

        message = message.replace("{input}", input)

        actor.error(message)
    }

    override fun invalidWorld(actor: CommandActor, exception: InvalidWorldException) {
        var message = messages.getString("exceptions.invalid-world")

        if (message == null){
            plugin.logger.severe("exceptions.invalid-world doesnt exist in messages.yml!")
            return
        }
        val input = exception.input

        message = message.replace("{input}", input)

        actor.error(message)
    }

    override fun malformedEntitySelector(actor: CommandActor, exception: MalformedEntitySelectorException) {
        var message = messages.getString("exceptions.invalid-selector")

        if (message == null){
            plugin.logger.severe("exceptions.invalid-selector doesnt exist in messages.yml!")
            return
        }
        val input = exception.input
        val error = exception.errorMessage

        message = message.replace("{input}", input)
        message = message.replace("{error}", error)

        actor.error(message)
    }

    override fun moreThanOnePlayer(actor: CommandActor, exception: MoreThanOnePlayerException) {
        var message = messages.getString("exceptions.only-one-player")

        if (message == null){
            plugin.logger.severe("exceptions.only-one-player doesnt exist in messages.yml!")
            return
        }
        val input = exception.input

        message = message.replace("{input}", input)

        actor.error(message)
    }

    override fun nonPlayerEntities(actor: CommandActor, exception: NonPlayerEntitiesException) {
        var message = messages.getString("exceptions.non-players-not-allowed")

        if (message == null){
            plugin.logger.severe("exceptions.non-players-not-allowed doesnt exist in messages.yml!")
            return
        }
        val input = exception.input

        message = message.replace("{input}", input)

        actor.error(message)
    }

}