package dev.cirosanchez.template

import dev.cirosanchez.template.configuration.ConfigurationProvider
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.bukkit.BukkitCommandHandler


// TODO: rename class and parent package.
class Template : JavaPlugin() {


    companion object{
        val mm = MiniMessage.miniMessage()
        fun get(): Template = getPlugin(Template::class.java)
    }

    lateinit var configurationProvider: ConfigurationProvider
    lateinit var commandHandler: BukkitCommandHandler

    override fun onEnable() {
        // Configuration
        configurationProvider = ConfigurationProvider(this).init()
        // Commands
        commandHandler = BukkitCommandHandler.create(this)
    }
}