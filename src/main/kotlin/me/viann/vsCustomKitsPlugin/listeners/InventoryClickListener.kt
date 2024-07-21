package me.viann.vsCustomKitsPlugin.listeners

import me.viann.vsCustomKitsPlugin.VsCustomKitsPlugin
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

class InventoryClickListener : Listener {

    @EventHandler
    fun inventoryClickEvent(event: InventoryClickEvent) {
        val player = event.whoClicked as? Player ?: return
        val playerUUID = player.uniqueId

        if (event.inventory == VsCustomKitsPlugin.guiMap[playerUUID]) {
            if (event.currentItem == null) return

            when (event.currentItem!!.type) {
                Material.LEATHER_CHESTPLATE -> {
                    equipArmor(player, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, "Equipped Leather Armour")
                }
                Material.CHAINMAIL_CHESTPLATE -> {
                    equipArmor(player, Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS, "Equipped ChainMail Armour")
                }
                Material.IRON_CHESTPLATE -> {
                    equipArmor(player, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, "Equipped Iron Armour")
                }
                Material.GOLDEN_CHESTPLATE -> {
                    equipArmor(player, Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS, "Equipped Gold Armour")
                }
                Material.DIAMOND_CHESTPLATE -> {
                    equipArmor(player, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, "Equipped Diamond Armour")
                }
                Material.NETHERITE_CHESTPLATE -> {
                    equipArmor(player, Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS, "Equipped Netherite Armour")
                }
                Material.GREEN_STAINED_GLASS_PANE -> {
                    event.isCancelled = true

                    val inventory = event.clickedInventory ?: return

                    val helmetPlayer = inventory.getItem(6)
                    val chestplatePlayer = inventory.getItem(5)
                    val leggingsPlayer = inventory.getItem(24)
                    val bootsPlayer = inventory.getItem(33)

                    player.inventory.helmet = helmetPlayer
                    player.inventory.chestplate = chestplatePlayer
                    player.inventory.leggings = leggingsPlayer
                    player.inventory.boots = bootsPlayer
                    player.sendMessage(Component.text("Equipped Custom Armour").color(TextColor.color(255, 0, 0)))

                    player.closeInventory()
                }
                Material.BARRIER -> {
                    event.isCancelled = true
                    player.closeInventory()
                }
                else -> {
                    event.isCancelled = false // Allow item movements and dragging
                }
            }
        }
    }

    private fun equipArmor(player: Player, helmet: Material, chestplate: Material, leggings: Material, boots: Material, message: String) {
        player.inventory.helmet = ItemStack(helmet)
        player.inventory.chestplate = ItemStack(chestplate)
        player.inventory.leggings = ItemStack(leggings)
        player.inventory.boots = ItemStack(boots)
        player.sendMessage(Component.text(message).color(TextColor.color(255, 0, 0)))
        player.closeInventory()
    }
}