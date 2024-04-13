/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.messages.color

import dev.cirosanchez.cave.Cave
import dev.cirosanchez.cave.extension.colorize
import dev.cirosanchez.cave.extension.colorizeLegacy
import org.bukkit.command.CommandSender

fun interface ColorResolver {
    fun send(sender: CommandSender, message: String)

    companion object{
        val LEGACY = ColorResolver { sender, message -> sender.sendMessage(message.colorizeLegacy()) }

        val MM = ColorResolver { sender, message -> Cave.getAudiences().sender(sender).sendMessage(message.colorize()) }
    }
}