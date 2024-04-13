/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */


package dev.cirosanchez.cave.extension

import org.bukkit.entity.Player


/*
 * Sends a MiniMessage component to the player deserialized from the given String.
 */
fun Player.send(message: String) {
    this.sendMessage(message.colorize())
}