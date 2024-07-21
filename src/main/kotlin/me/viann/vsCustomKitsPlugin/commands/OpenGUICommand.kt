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
        if (sender !is Player) return false

        val inventory = Bukkit.createInventory(sender, 9, Component.text("GUI").color(TextColor.color(0, 255, 75)))

        // Function to create an item stack with custom display name
        fun createItemStack(material: Material, displayName: String, color: TextColor): ItemStack {
            val item = ItemStack(material)
            val meta = item.itemMeta
            meta.displayName(Component.text(displayName).color(color))
            item.itemMeta = meta
            return item
        }

        // Create armor items
        val equipArmourLeatherArmor = createItemStack(Material.LEATHER_CHESTPLATE, "Equip Leather Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourChainMailArmor = createItemStack(Material.CHAINMAIL_CHESTPLATE, "Equip ChainMail Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourIronArmor = createItemStack(Material.IRON_CHESTPLATE, "Equip Iron Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourGoldArmor = createItemStack(Material.GOLDEN_CHESTPLATE, "Equip Gold Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourDiamond = createItemStack(Material.DIAMOND_CHESTPLATE, "Equip Diamond Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourNetherite = createItemStack(Material.NETHERITE_CHESTPLATE, "Equip Netherite Armour Kit", TextColor.color(0, 180, 255))

        // Create Close button
        val closeGUIButton = createItemStack(Material.BARRIER, "Close", TextColor.color(255, 0, 0))

        // Set items in inventory
        inventory.setItem(1, equipArmourLeatherArmor)
        inventory.setItem(2, equipArmourChainMailArmor)
        inventory.setItem(3, equipArmourIronArmor)
        inventory.setItem(4, equipArmourGoldArmor)
        inventory.setItem(5, equipArmourDiamond)
        inventory.setItem(6, equipArmourNetherite)
        inventory.setItem(7, closeGUIButton)

        VsCustomKitsPlugin.guiMap[sender.uniqueId] = inventory

        sender.openInventory(inventory)

        return true // Command was successful
    }
}
