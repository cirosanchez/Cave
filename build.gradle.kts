import java.util.*

plugins {
    kotlin("jvm") version "1.9.21"
    id("com.github.johnrengelman.shadow") version("8.1.1")
    id("xyz.jpenilla.run-paper") version "2.2.2"
    id("pl.allegro.tech.build.axion-release") version "1.13.4"
}

group = "me.cirosanchez.cave"

val propertiesFile = file("build.properties")
val buildProperties = Properties()

if (propertiesFile.exists()) {
    buildProperties.load(propertiesFile.inputStream())
}
var buildNumber: Int = buildProperties.getProperty("buildNumber", "0").toInt()

version = "0.1.-$buildNumber"

buildProperties.setProperty("buildNumber", (buildNumber + 1).toString())
buildProperties.store(propertiesFile.outputStream(), null)

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
    maven("https://repo.flyte.gg/releases")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.16.4-R0.1-SNAPSHOT")

    // adventure
    implementation("net.kyori:adventure-platform-bukkit:4.3.2")
    implementation("net.kyori:adventure-api:4.16.0")
    implementation("net.kyori:adventure-text-minimessage:4.16.0")


    // Commands
    implementation("com.github.Revxrsal.Lamp:common:3.2.1")
    implementation("com.github.Revxrsal.Lamp:bukkit:3.2.1")

    // twilight
    implementation("gg.flyte:twilight:1.1.7")

    // PlaceholderAPI
    compileOnly("me.clip:placeholderapi:2.11.5")
}

kotlin {
    jvmToolchain(17)
}

tasks.runServer {
    minecraftVersion("1.20.4")
}

tasks.shadowJar {
    archiveFileName = "${project.name}-${project.version}.jar"
    minimize()
}