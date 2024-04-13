/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */


package dev.cirosanchez.cave

import dev.cirosanchez.cave.configuration.ConfigurationProvider
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.bukkit.BukkitCommandHandler


class Cave : JavaPlugin() {


    companion object{
        val mm = MiniMessage.miniMessage()
        fun get(): Cave = getPlugin(Cave::class.java)
        fun configurationProvider(): ConfigurationProvider {
            return get().configurationProvider
        }
    }

    private lateinit var configurationProvider: ConfigurationProvider
    private lateinit var commandHandler: BukkitCommandHandler

    override fun onEnable() {

        // Configuration
        configurationProvider = ConfigurationProvider(this).init()

        // Commands
        commandHandler = BukkitCommandHandler.create(this)
    }
}