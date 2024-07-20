package me.viann.vsCustomKitsPlugin.listeners


import me.viann.vsCustomKitsPlugin.VsCustomKitsPlugin
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent

class InventoryCloseListener : Listener{

    @EventHandler
    fun inventoryCloseEvent(event: InventoryCloseEvent) {
        val playerUUID = event.player.uniqueId

        if(VsCustomKitsPlugin.guiMap.containsKey(playerUUID)) VsCustomKitsPlugin.guiMap.remove(playerUUID)
    }
}