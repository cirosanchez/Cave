/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.region.flag.impl.block

import dev.cirosanchez.cave.region.flag.Flag
import org.bukkit.event.Event
import org.bukkit.event.block.BlockBreakEvent

class BlockBreakFlag : Flag {
    override fun getName(): String {
        return "block-break"
    }

    override fun event(event: Event) {
        if (event !is BlockBreakEvent) return
    }
}