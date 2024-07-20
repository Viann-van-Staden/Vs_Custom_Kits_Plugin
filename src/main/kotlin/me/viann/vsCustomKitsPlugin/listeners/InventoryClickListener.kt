package me.viann.vsCustomKitsPlugin.listeners


import me.viann.vsCustomKitsPlugin.VsCustomKitsPlugin
import me.viann.vsCustomKitsPlugin.commands.KitCreateCommand
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

class InventoryClickListener : Listener{

    private val armorMaterials = mapOf(
        "gold" to Material.GOLDEN_HELMET,
        "netherite" to Material.NETHERITE_HELMET,
        "diamond" to Material.DIAMOND_HELMET,
        "iron" to Material.IRON_HELMET,
        "chainmail" to Material.CHAINMAIL_HELMET,
        "leather" to Material.LEATHER_HELMET
    )

    @EventHandler
    fun inventoryClickEvent(event: InventoryClickEvent) {
        val player = event.whoClicked
        val playerUUID = event.whoClicked.uniqueId

        if(event.inventory == VsCustomKitsPlugin.guiMap[playerUUID]) {
            if(event.currentItem == null) return

            when(event.currentItem!!.type) {
                Material.LEATHER_CHESTPLATE -> {
                    player.inventory.helmet = ItemStack(Material.LEATHER_HELMET)
                    player.inventory.chestplate = ItemStack(Material.LEATHER_CHESTPLATE)
                    player.inventory.leggings = ItemStack(Material.LEATHER_LEGGINGS)
                    player.inventory.boots = ItemStack(Material.LEATHER_BOOTS)
                    player.sendMessage(Component.text("Equipped Leather Armour").color(TextColor.color(255, 0, 0)))
                    event.inventory.close()
                }
                Material.CHAINMAIL_CHESTPLATE -> {
                    player.inventory.helmet = ItemStack(Material.CHAINMAIL_HELMET)
                    player.inventory.chestplate = ItemStack(Material.CHAINMAIL_CHESTPLATE)
                    player.inventory.leggings = ItemStack(Material.CHAINMAIL_LEGGINGS)
                    player.inventory.boots = ItemStack(Material.CHAINMAIL_BOOTS)
                    player.sendMessage(Component.text("Equipped ChainMail Armour").color(TextColor.color(255, 0, 0)))
                    event.inventory.close()
                }
                Material.IRON_CHESTPLATE -> {
                    player.inventory.helmet = ItemStack(Material.IRON_HELMET)
                    player.inventory.chestplate = ItemStack(Material.IRON_CHESTPLATE)
                    player.inventory.leggings = ItemStack(Material.IRON_LEGGINGS)
                    player.inventory.boots = ItemStack(Material.IRON_BOOTS)
                    player.sendMessage(Component.text("Equipped Iron Armour").color(TextColor.color(255, 0, 0)))
                    event.inventory.close()
                }
                Material.GOLDEN_CHESTPLATE -> {
                    player.inventory.helmet = ItemStack(Material.GOLDEN_HELMET)
                    player.inventory.chestplate = ItemStack(Material.GOLDEN_CHESTPLATE)
                    player.inventory.leggings = ItemStack(Material.GOLDEN_LEGGINGS)
                    player.inventory.boots = ItemStack(Material.GOLDEN_BOOTS)
                    player.sendMessage(Component.text("Equipped Gold Armour").color(TextColor.color(255, 0, 0)))
                    event.inventory.close()
                }
                Material.DIAMOND_CHESTPLATE -> {
                    player.inventory.helmet = ItemStack(Material.DIAMOND_HELMET)
                    player.inventory.chestplate = ItemStack(Material.DIAMOND_CHESTPLATE)
                    player.inventory.leggings = ItemStack(Material.DIAMOND_LEGGINGS)
                    player.inventory.boots = ItemStack(Material.DIAMOND_BOOTS)
                    player.sendMessage(Component.text("Equipped Diamond Armour").color(TextColor.color(255, 0, 0)))
                    event.inventory.close()
                }
                Material.NETHERITE_CHESTPLATE -> {
                    player.inventory.helmet = ItemStack(Material.NETHERITE_HELMET)
                    player.inventory.chestplate = ItemStack(Material.NETHERITE_CHESTPLATE)
                    player.inventory.leggings = ItemStack(Material.NETHERITE_LEGGINGS)
                    player.inventory.boots = ItemStack(Material.NETHERITE_BOOTS)
                    player.sendMessage(Component.text("Equipped Netherite Armour").color(TextColor.color(255, 0, 0)))
                    event.inventory.close()
                }
                Material.WRITTEN_BOOK -> {
                    val sender = event.whoClicked
                    if(sender !is Player) return
                    val inventory = Bukkit.createInventory(sender, 36, Component.text("Create New Kit").color(TextColor.color(0, 255, 75)))

                    val equipArmourLeatherArmor = ItemStack(Material.LEATHER_CHESTPLATE)
                    val equipArmourLeatherArmorMeta = equipArmourLeatherArmor.itemMeta
                    equipArmourLeatherArmorMeta.displayName(Component.text("Equip Leather Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourLeatherArmor.itemMeta = equipArmourLeatherArmorMeta

                    // creates Chainmail armour
                    val equipArmourChainMailArmor = ItemStack(Material.CHAINMAIL_CHESTPLATE)
                    val equipArmourChainMailArmorMeta = equipArmourChainMailArmor.itemMeta
                    equipArmourChainMailArmorMeta.displayName(Component.text("Equip ChainMail Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourChainMailArmor.itemMeta = equipArmourChainMailArmorMeta

                    // creates Iron armour
                    val equipArmourIronArmor = ItemStack(Material.IRON_CHESTPLATE)
                    val equipArmourIronArmorMeta = equipArmourIronArmor.itemMeta
                    equipArmourIronArmorMeta.displayName(Component.text("Equip Iron Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourIronArmor.itemMeta = equipArmourIronArmorMeta

                    // creates Gold armour
                    val equipArmourGoldArmor = ItemStack(Material.GOLDEN_CHESTPLATE)
                    val equipArmourGoldArmorMeta = equipArmourGoldArmor.itemMeta
                    equipArmourGoldArmorMeta.displayName(Component.text("Equip Gold Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourGoldArmor.itemMeta = equipArmourGoldArmorMeta

                    // creates Diamond armour
                    val equipArmourDiamond = ItemStack(Material.DIAMOND_CHESTPLATE)
                    val equipArmourDiamondMeta = equipArmourDiamond.itemMeta
                    equipArmourDiamondMeta.displayName(Component.text("Equip Diamond Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourDiamond.itemMeta = equipArmourDiamondMeta

                    // creates Netherite armour
                    val equipArmourNetherite = ItemStack(Material.NETHERITE_CHESTPLATE)
                    val equipArmourNetheriteMeta = equipArmourNetherite.itemMeta
                    equipArmourNetheriteMeta.displayName(Component.text("Equip Diamond Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourNetherite.itemMeta = equipArmourNetheriteMeta

                    // creates Close button
                    val closeGUIButton = ItemStack(Material.BARRIER)
                    val closeGUIButtonMeta = closeGUIButton.itemMeta
                    closeGUIButtonMeta.displayName(Component.text("Close").color(TextColor.color(255, 0, 0)))
                    closeGUIButton.itemMeta = closeGUIButtonMeta

                    // creates Black_Stained_Glass_Pane button
                    val seperatorButton = ItemStack(Material.BLACK_STAINED_GLASS_PANE)
                    val seperatorButtonMeta = seperatorButton.itemMeta
                    seperatorButtonMeta.displayName(Component.text("Close").color(TextColor.color(255, 0, 0)))
                    seperatorButton.itemMeta = seperatorButtonMeta

                    // Armours
                    inventory.setItem(0, )
                    inventory.setItem(1, seperatorButton)
                    inventory.setItem(2, seperatorButton)
                    inventory.setItem(3, seperatorButton)

                    // Black Stained Glass Pane
                    inventory.setItem(4, seperatorButton)
                    inventory.setItem(5, seperatorButton)
                    inventory.setItem(7, seperatorButton)
                    inventory.setItem(8, seperatorButton)
                    inventory.setItem(13, seperatorButton)
                    inventory.setItem(14, seperatorButton)
                    inventory.setItem(16, seperatorButton)
                    inventory.setItem(17, seperatorButton)
                    inventory.setItem(22, seperatorButton)
                    inventory.setItem(23, seperatorButton)
                    inventory.setItem(25, seperatorButton)
                    inventory.setItem(26, seperatorButton)
                    inventory.setItem(31, seperatorButton)
                    inventory.setItem(32, seperatorButton)
                    inventory.setItem(34, seperatorButton)
                    inventory.setItem(35, seperatorButton)

                    sender.openInventory(inventory)
                }

                Material.BARRIER -> {
                    event.inventory.close()
                }
                else -> {}
            }
            event.isCancelled = true
        }
    }
}