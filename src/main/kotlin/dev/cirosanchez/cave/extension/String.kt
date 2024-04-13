/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */


@file:Suppress("DEPRECATION")
package dev.cirosanchez.cave.extension

import dev.cirosanchez.cave.Cave
import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
import org.bukkit.ChatColor.COLOR_CHAR
import java.util.regex.Matcher
import java.util.regex.Pattern

fun String.colorize(): Component {
    return Cave.mm.deserialize(this)
}

fun String.colorizeLegacy(): String {
    val message = this
    val startTag = "&#"
    val endTag = ""
    val hexPattern: Pattern = Pattern.compile("$startTag([A-Fa-f0-9]{6})$endTag")
    val matcher: Matcher = hexPattern.matcher(message)
    val buffer = StringBuffer(message.length + 4 * 8)
    while (matcher.find()) {
        val group: String = matcher.group(1)
        matcher.appendReplacement(
            buffer, COLOR_CHAR + "x"
                    + COLOR_CHAR + group[0] + COLOR_CHAR + group[1]
                    + COLOR_CHAR + group[2] + COLOR_CHAR + group[3]
                    + COLOR_CHAR + group[4] + COLOR_CHAR + group[5]
        )
    }
    return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString())
}

