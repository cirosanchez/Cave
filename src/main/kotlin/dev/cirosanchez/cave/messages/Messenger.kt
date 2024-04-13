/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.messages

import dev.cirosanchez.cave.Cave
import dev.cirosanchez.cave.exceptions.ColorResolverNotFoundException
import dev.cirosanchez.cave.exceptions.PathNotFoundException
import dev.cirosanchez.cave.messages.color.ColorResolver
import dev.cirosanchez.cave.messages.color.impl.LegacyColorCodesResolver
import dev.cirosanchez.cave.messages.color.impl.MiniMessageColorResolver
import dev.cirosanchez.cave.messages.util.Placeholder
import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object Messenger {

    private val plugin = Cave.get()
    private val configurationProvider = Cave.configurationProvider()
    private val colorResolver: ColorResolver = getColorResolver()

    private fun getColorResolver(): ColorResolver {
        val colorResolverString = configurationProvider.messages.getString("color-resolver") ?: throw ColorResolverNotFoundException()

        when (colorResolverString.uppercase()){
            "MINIMESSAGE" -> return MiniMessageColorResolver()
            "LEGACY"-> return LegacyColorCodesResolver()

            else -> {
                throw ColorResolverNotFoundException()
            }
        }
    }

    fun send(player: Player, path: String, vararg placeholders: Placeholder){
        var messageString = configurationProvider.messages.getString(path) ?: throw PathNotFoundException(path)
        messageString = PlaceholderAPI.setPlaceholders(player, messageString)

        placeholders.forEach {
            messageString = it.replace(messageString)
        }

        colorResolver.sendToPlayer(player, messageString)
    }


    fun send(commandSender: CommandSender, path: String, vararg placeholders: Placeholder) {
        var messageString = configurationProvider.messages.getString(path) ?: throw PathNotFoundException(path)

        placeholders.forEach {
            messageString = it.replace(messageString)
        }

        colorResolver.sendToCommandSender(commandSender, messageString)
    }



}