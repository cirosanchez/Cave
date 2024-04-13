/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.messages.color

import dev.cirosanchez.cave.Cave
import dev.cirosanchez.cave.extension.colorize
import dev.cirosanchez.cave.extension.colorizeLegacy
import org.bukkit.command.CommandSender

interface ColorResolver {
    fun send(sender: CommandSender, message: String)

    companion object{
        val LEGACY = object : ColorResolver {
            override fun send(sender: CommandSender, message: String) {
                sender.sendMessage(message.colorizeLegacy())
            }
        }

        val MINIMESSAGE = object : ColorResolver {
            override fun send(sender: CommandSender, message: String) {
                Cave.getAudiences().sender(sender).sendMessage(message.colorize())
            }
        }
    }
}