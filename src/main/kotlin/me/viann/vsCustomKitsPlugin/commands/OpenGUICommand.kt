package me.viann.vsCustomKitsPlugin.commands

import me.viann.vsCustomKitsPlugin.VsCustomKitsPlugin
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class OpenGUICommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false

        val inventory = Bukkit.createInventory(sender, 9,Component.text("GUI").color(TextColor.color(0, 255, 75)))
        // creates Leather armour
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

        inventory.setItem(1, equipArmourLeatherArmor)
        inventory.setItem(2, equipArmourChainMailArmor)
        inventory.setItem(3, equipArmourIronArmor)
        inventory.setItem(4, equipArmourGoldArmor)
        inventory.setItem(5, equipArmourDiamond)
        inventory.setItem(6, equipArmourNetherite)
        inventory.setItem(7, closeGUIButton)

        VsCustomKitsPlugin.guiMap[sender.uniqueId] = inventory

        sender.openInventory(inventory)



        return false;
    }
}