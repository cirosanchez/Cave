package dev.cirosanchez.cave.configuration

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File

abstract class Configuration(private val plugin: Plugin) : YamlConfiguration() {
    private val file by lazy {  File(plugin.dataFolder, getFileName()) }

    companion object {
        var config: Configuration? = null
    }

    fun getConfig(): Configuration {
        if (config == null){
            config = this
        }
        return config!!
    }

    fun loadConfig() : Configuration {
        if (!file.exists()) plugin.saveResource(file.name, false)

        this.reload()
        return this
    }

    abstract fun getFileName(): String

    private fun reload() {
        super.load(file)
        super.save(file)
    }

    fun save(){
        super.save(file)
    }

}