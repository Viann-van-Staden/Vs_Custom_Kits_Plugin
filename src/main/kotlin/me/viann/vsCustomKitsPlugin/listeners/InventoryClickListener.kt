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

                    // creates Leather armour
                    val equipArmourLeatherHelmet = ItemStack(Material.LEATHER_HELMET)
                    val equipArmourLeatherHelmetMeta = equipArmourLeatherHelmet.itemMeta
                    equipArmourLeatherHelmetMeta.displayName(Component.text("Equip Leather Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourLeatherHelmet.itemMeta = equipArmourLeatherHelmetMeta

                    val equipArmourLeatherChestplate = ItemStack(Material.LEATHER_CHESTPLATE)
                    val equipArmourLeatherChestplateMeta = equipArmourLeatherChestplate.itemMeta
                    equipArmourLeatherChestplateMeta.displayName(Component.text("Equip Leather Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourLeatherChestplate.itemMeta = equipArmourLeatherChestplateMeta

                    // creates Chainmail armour
                    val equipArmourChainmailHelmet = ItemStack(Material.CHAINMAIL_HELMET)
                    val equipArmourChainmailHelmetHelmetMeta = equipArmourChainmailHelmet.itemMeta
                    equipArmourChainmailHelmetHelmetMeta.displayName(Component.text("Equip Leather Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourChainmailHelmet.itemMeta = equipArmourChainmailHelmetHelmetMeta

                    val equipArmourChainMailArmor = ItemStack(Material.CHAINMAIL_CHESTPLATE)
                    val equipArmourChainMailArmorMeta = equipArmourChainMailArmor.itemMeta
                    equipArmourChainMailArmorMeta.displayName(Component.text("Equip ChainMail Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourChainMailArmor.itemMeta = equipArmourChainMailArmorMeta

                    // creates Iron armour
                    val equipArmourIronHelmet = ItemStack(Material.IRON_HELMET)
                    val equipArmourIronHelmetMeta = equipArmourIronHelmet.itemMeta
                    equipArmourIronHelmetMeta.displayName(Component.text("Equip Leather Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourIronHelmet.itemMeta = equipArmourIronHelmetMeta

                    val equipArmourIronArmor = ItemStack(Material.IRON_CHESTPLATE)
                    val equipArmourIronArmorMeta = equipArmourIronArmor.itemMeta
                    equipArmourIronArmorMeta.displayName(Component.text("Equip Iron Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourIronArmor.itemMeta = equipArmourIronArmorMeta

                    // creates Gold armour
                    val equipArmourGoldHelmet = ItemStack(Material.GOLDEN_HELMET)
                    val equipArmourGoldHelmetMeta = equipArmourGoldHelmet.itemMeta
                    equipArmourGoldHelmetMeta.displayName(Component.text("Equip Leather Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourGoldHelmet.itemMeta = equipArmourGoldHelmetMeta

                    val equipArmourGoldArmor = ItemStack(Material.GOLDEN_CHESTPLATE)
                    val equipArmourGoldArmorMeta = equipArmourGoldArmor.itemMeta
                    equipArmourGoldArmorMeta.displayName(Component.text("Equip Gold Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourGoldArmor.itemMeta = equipArmourGoldArmorMeta

                    // creates Diamond armour
                    val equipArmourDiamondHelmet = ItemStack(Material.DIAMOND_HELMET)
                    val equipArmourDiamondHelmetMeta = equipArmourDiamondHelmet.itemMeta
                    equipArmourDiamondHelmetMeta.displayName(Component.text("Equip Leather Armour Kit").color(TextColor.color(0, 180, 255)))
                    equipArmourDiamondHelmet.itemMeta = equipArmourDiamondHelmetMeta

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

                    // Leather Armor
                    inventory.setItem(0, equipArmourLeatherHelmet)
                    inventory.setItem(1, equipArmourLeatherChestplate)
                    inventory.setItem(2, seperatorButton)
                    inventory.setItem(3, seperatorButton)

                    // Iron Armor
                    inventory.setItem(9,  equipArmourIronHelmet)
                    inventory.setItem(10, equipArmourIronArmor)
                    inventory.setItem(11, seperatorButton)
                    inventory.setItem(12, seperatorButton)

                    // Gold Armor
                    inventory.setItem(18, equipArmourGoldHelmet)
                    inventory.setItem(19, equipArmourGoldArmor)
                    inventory.setItem(20, seperatorButton)
                    inventory.setItem(21, seperatorButton)

                    // Diamond Armor
                    inventory.setItem(27, equipArmourDiamondHelmet)
                    inventory.setItem(28, equipArmourDiamond)
                    inventory.setItem(29, seperatorButton)
                    inventory.setItem(30, seperatorButton)

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