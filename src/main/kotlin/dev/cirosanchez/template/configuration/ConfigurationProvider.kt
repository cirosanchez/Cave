package dev.cirosanchez.template.configuration

import org.bukkit.plugin.Plugin

class ConfigurationProvider(val plugin: Plugin) {
    fun init(): ConfigurationProvider {
        plugin.saveDefaultConfig()
        return this
    }
}