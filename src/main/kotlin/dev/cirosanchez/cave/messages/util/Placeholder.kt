/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.messages.util

data class Placeholder(val target: String, val value: String) {
    fun replace(string: String): String {
        return string.replace(target, value)
    }
}