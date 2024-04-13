/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */


package dev.cirosanchez.cave.configuration

import org.bukkit.plugin.Plugin

class ConfigurationProvider(private val plugin: Plugin) {
    fun init(): ConfigurationProvider {
        plugin.saveDefaultConfig()
        return this
    }

    fun save(){
        plugin.saveConfig()
    }
}