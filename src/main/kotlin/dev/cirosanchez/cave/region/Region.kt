/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.region

import dev.cirosanchez.cave.region.flag.Flag

data class Region(val identificator: String, val name: String) {
    private val flags: MutableList<Flag> = mutableListOf()

    fun addFlag(flag: Flag){
        this.flags.add(flag)
    }
}
