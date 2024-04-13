/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */


package dev.cirosanchez.cave.configuration

import dev.cirosanchez.cave.configuration.impl.Messages
import org.bukkit.plugin.Plugin

class ConfigurationProvider(private val plugin: Plugin) {
    lateinit var messages: Configuration
    fun init(): ConfigurationProvider {
        plugin.saveDefaultConfig()
        messages = Messages()
        return this
    }

    fun save(){
        plugin.saveConfig()
    }
}