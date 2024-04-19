/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.region.flag

import org.bukkit.event.Event

interface Flag {
    fun getName(): String
    fun event(event: Event)
}