plugins {
    kotlin("jvm") version "1.9.21"
    id("com.github.johnrengelman.shadow") version("8.1.1")
    id("xyz.jpenilla.run-paper") version "2.2.2"
}

//TODO: Change group and version.
group = "me.cirosanchez.template"
version = "1.0-SNAPSHOT"

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
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")

    // Commands
    implementation("com.github.Revxrsal.Lamp:common:3.1.9")
    implementation("com.github.Revxrsal.Lamp:bukkit:3.1.9")

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