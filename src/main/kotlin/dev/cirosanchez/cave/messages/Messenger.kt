/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.messages

import dev.cirosanchez.cave.Cave
import dev.cirosanchez.cave.exceptions.ColorResolverNotFoundException
import dev.cirosanchez.cave.exceptions.PathNotFoundException
import dev.cirosanchez.cave.messages.color.ColorResolver
import dev.cirosanchez.cave.messages.util.Placeholder
import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object Messenger {

    private val configurationProvider = Cave.configurationProvider()
    private val colorResolver: ColorResolver = getColorResolver()

    private fun getColorResolver(): ColorResolver {
        val colorResolverString = configurationProvider.messages.getString("color-resolver") ?: throw ColorResolverNotFoundException()

        when (colorResolverString.uppercase()){
            "MINIMESSAGE" -> return ColorResolver.MINIMESSAGE
            "LEGACY"-> return ColorResolver.LEGACY

            else -> {
                throw ColorResolverNotFoundException()
            }
        }
    }


    fun send(commandSender: CommandSender, path: String, vararg placeholders: Placeholder) {
        var messageString = configurationProvider.messages.getString(path) ?: throw PathNotFoundException(path)

        placeholders.forEach {
            messageString = it.replace(messageString)
        }


        if (commandSender is Player) {
            messageString = PlaceholderAPI.setPlaceholders(commandSender, messageString)
        }

        colorResolver.send(commandSender, messageString)
    }



}