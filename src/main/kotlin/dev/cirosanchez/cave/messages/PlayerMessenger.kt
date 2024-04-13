/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */

package dev.cirosanchez.cave.messages

import dev.cirosanchez.cave.Cave
import dev.cirosanchez.cave.messages.color.ColorResolver
import dev.cirosanchez.cave.messages.color.impl.LegacyColorCodesResolver
import dev.cirosanchez.cave.messages.color.impl.MiniMessageColorResolver
import dev.cirosanchez.cave.messages.util.Placeholder
import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.entity.Player

object PlayerMessenger {

    private val plugin = Cave.get()
    private val configurationProvider = Cave.configurationProvider()
    private val colorResolver: ColorResolver = getColorResolver()

    private fun getColorResolver(): ColorResolver {
        val colorResolverString = configurationProvider.messages.getString("color-resolver")

        if (colorResolverString == null){
            plugin.logger.severe("A Color Resolver wasn't Set! Set it up on messages.yml in color-resolver node. Defaulting to MiniMessage.")
            return MiniMessageColorResolver()
        }

        when (colorResolverString.uppercase()){
            "MINIMESSAGE" -> return MiniMessageColorResolver()
            "LEGACY"-> return LegacyColorCodesResolver()

            else -> {
                plugin.logger.severe("$colorResolverString isn't a color resolver. Defaulting to MiniMessage. Please, check messages.yml")
                return MiniMessageColorResolver()
            }
        }
    }

    fun send(player: Player, path: String, vararg placeholders: Placeholder){
        var messageString = configurationProvider.messages.getString(path) ?: run {
            Cave.get().logger.severe("$path doesn't exist on messages.yml, please, check config and set it up.")
            return
        }
        messageString = PlaceholderAPI.setPlaceholders(player, messageString)

        placeholders.forEach {
            messageString = it.replace(messageString)
        }

        colorResolver.send(player, messageString)
    }

}