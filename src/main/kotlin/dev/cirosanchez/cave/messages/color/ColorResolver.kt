/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.messages.color

import org.bukkit.entity.Player

interface ColorResolver {
    fun send(player: Player, string: String)
}