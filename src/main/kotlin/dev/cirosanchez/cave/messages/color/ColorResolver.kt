/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.messages.color

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

interface ColorResolver {
    fun sendToPlayer(player: Player, string: String)
    fun sendToCommandSender(commandSender: CommandSender, string: String)
}