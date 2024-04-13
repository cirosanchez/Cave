/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */


package dev.cirosanchez.cave.extension

import org.bukkit.entity.Player


fun Player.sendColorizedMessage(message: String) {
    this.sendMessage(message.colorize())
}