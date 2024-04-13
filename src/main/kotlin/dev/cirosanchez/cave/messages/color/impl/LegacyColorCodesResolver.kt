/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.messages.color.impl

import dev.cirosanchez.cave.extension.colorizeLegacy
import dev.cirosanchez.cave.messages.color.ColorResolver
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class LegacyColorCodesResolver : ColorResolver {
    override fun sendToPlayer(player: Player, string: String) {
        player.sendMessage(string.colorizeLegacy())
    }

    override fun sendToCommandSender(commandSender: CommandSender, string: String) {
        commandSender.sendMessage(string.colorizeLegacy())
    }
}