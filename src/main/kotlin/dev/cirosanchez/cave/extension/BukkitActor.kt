/*
 * Copyright (c) Ciro Sánchez B. 2024.
 */
@file:Suppress
package dev.cirosanchez.cave.extension

import dev.cirosanchez.cave.Cave
import dev.cirosanchez.cave.messages.Messenger
import net.kyori.adventure.text.Component
import revxrsal.commands.bukkit.core.BukkitActor


fun BukkitActor.error(component: Component){
    Messenger.send(this.sender, Cave.mm.serialize(component))
}