/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.configuration.impl

import dev.cirosanchez.cave.Cave
import dev.cirosanchez.cave.configuration.Configuration

class Messages : Configuration(Cave.get()) {
    override fun getFileName(): String {
        return "messages.yml"
    }
}