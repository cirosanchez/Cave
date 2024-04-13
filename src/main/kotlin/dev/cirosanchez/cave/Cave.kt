/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */


package dev.cirosanchez.cave

import dev.cirosanchez.cave.configuration.ConfigurationProvider
import net.kyori.adventure.platform.bukkit.BukkitAudiences
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
        fun getAudiences(): BukkitAudiences {
            return get().audiences
        }
    }

    private lateinit var configurationProvider: ConfigurationProvider
    private lateinit var commandHandler: BukkitCommandHandler
    private lateinit var audiences: BukkitAudiences

    override fun onEnable() {

        // Configuration
        audiences = BukkitAudiences.create(this)
        configurationProvider = ConfigurationProvider(this).init()

        // Commands
        commandHandler = BukkitCommandHandler.create(this)
    }
}