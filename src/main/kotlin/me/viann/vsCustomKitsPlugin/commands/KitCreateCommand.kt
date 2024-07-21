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

class KitCreateCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player) return false

        val inventory = Bukkit.createInventory(sender, 36, Component.text("Create New Kit").color(TextColor.color(0, 255, 75)))

        // Function to create an item stack with custom display name
        fun createItemStack(material: Material, displayName: String, color: TextColor): ItemStack {
            val item = ItemStack(material)
            val meta = item.itemMeta
            meta.displayName(Component.text(displayName).color(color))
            item.itemMeta = meta
            return item
        }

        // Close button
        val closeGUIButton = createItemStack(Material.BARRIER, "Close", TextColor.color(255, 0, 0))

        // Create New Kit button
        val createKitButton = createItemStack(Material.WRITTEN_BOOK, "Create New Kit", TextColor.color(50, 0, 100))

        // Leather armor
        val equipArmourLeatherHelmet = createItemStack(Material.LEATHER_HELMET, "Equip Leather Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourLeatherChestplate = createItemStack(Material.LEATHER_CHESTPLATE, "Equip Leather Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourLeatherLeggings = createItemStack(Material.LEATHER_LEGGINGS, "Equip Leather Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourLeatherBoots = createItemStack(Material.LEATHER_BOOTS, "Equip Leather Armour Kit", TextColor.color(0, 180, 255))

        // Chainmail armor
        val equipArmourChainmailHelmet = createItemStack(Material.CHAINMAIL_HELMET, "Equip ChainMail Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourChainMailArmor = createItemStack(Material.CHAINMAIL_CHESTPLATE, "Equip ChainMail Armour Kit", TextColor.color(0, 180, 255))

        // Iron armor
        val equipArmourIronHelmet = createItemStack(Material.IRON_HELMET, "Equip Iron Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourIronArmor = createItemStack(Material.IRON_CHESTPLATE, "Equip Iron Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourIronLeggings = createItemStack(Material.IRON_LEGGINGS, "Equip Iron Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourIronBoots = createItemStack(Material.IRON_BOOTS, "Equip Iron Armour Kit", TextColor.color(0, 180, 255))

        // Gold armor
        val equipArmourGoldHelmet = createItemStack(Material.GOLDEN_HELMET, "Equip Gold Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourGoldArmor = createItemStack(Material.GOLDEN_CHESTPLATE, "Equip Gold Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourGoldLeggings = createItemStack(Material.GOLDEN_LEGGINGS, "Equip Gold Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourGoldBoots = createItemStack(Material.GOLDEN_BOOTS, "Equip Gold Armour Kit", TextColor.color(0, 180, 255))

        // Diamond armor
        val equipArmourDiamondHelmet = createItemStack(Material.DIAMOND_HELMET, "Equip Diamond Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourDiamond = createItemStack(Material.DIAMOND_CHESTPLATE, "Equip Diamond Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourDiamondLeggings = createItemStack(Material.DIAMOND_LEGGINGS, "Equip Diamond Armour Kit", TextColor.color(0, 180, 255))
        val equipArmourDiamondBoots = createItemStack(Material.DIAMOND_BOOTS, "Equip Diamond Armour Kit", TextColor.color(0, 180, 255))

        // Netherite armor
        val equipArmourNetherite = createItemStack(Material.NETHERITE_CHESTPLATE, "Equip Netherite Armour Kit", TextColor.color(0, 180, 255))

        // Separator button
        val separatorButton = createItemStack(Material.BLACK_STAINED_GLASS_PANE, "Close", TextColor.color(255, 0, 0))

        // Confirm button
        val confirmButton = createItemStack(Material.GREEN_STAINED_GLASS_PANE, "CONFIRM", TextColor.color(255, 0, 0))

        // Leather Armor
        inventory.setItem(0, equipArmourLeatherHelmet)
        inventory.setItem(1, equipArmourLeatherChestplate)
        inventory.setItem(2, equipArmourLeatherLeggings)
        inventory.setItem(3, equipArmourLeatherBoots)

        // Iron Armor
        inventory.setItem(9, equipArmourIronHelmet)
        inventory.setItem(10, equipArmourIronArmor)
        inventory.setItem(11, equipArmourIronLeggings)
        inventory.setItem(12, equipArmourIronBoots)

        // Gold Armor
        inventory.setItem(18, equipArmourGoldHelmet)
        inventory.setItem(19, equipArmourGoldArmor)
        inventory.setItem(20, equipArmourGoldLeggings)
        inventory.setItem(21, equipArmourGoldBoots)

        // Diamond Armor
        inventory.setItem(27, equipArmourDiamondHelmet)
        inventory.setItem(28, equipArmourDiamond)
        inventory.setItem(29, equipArmourDiamondLeggings)
        inventory.setItem(30, equipArmourDiamondBoots)

        // Black Stained Glass Pane
        inventory.setItem(4, separatorButton)
        inventory.setItem(5, separatorButton)
        inventory.setItem(7, separatorButton)
        inventory.setItem(8, separatorButton)
        inventory.setItem(13, separatorButton)
        inventory.setItem(14, separatorButton)
        inventory.setItem(16, separatorButton)
        inventory.setItem(17, separatorButton)
        inventory.setItem(22, separatorButton)
        inventory.setItem(23, separatorButton)
        inventory.setItem(25, separatorButton)
        inventory.setItem(26, separatorButton)
        inventory.setItem(31, separatorButton)
        inventory.setItem(32, separatorButton)
        inventory.setItem(34, separatorButton)
        inventory.setItem(35, confirmButton)

        sender.openInventory(inventory)

        VsCustomKitsPlugin.guiMap[sender.uniqueId] = inventory

        return true // Command was successful
    }
}
