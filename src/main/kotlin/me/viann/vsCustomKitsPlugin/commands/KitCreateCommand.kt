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

class KitCreateCommand : CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false

        val inventory = Bukkit.createInventory(sender, 9, Component.text("GUI").color(TextColor.color(0, 255, 75)))

        // creates Close button
        val closeGUIButton = ItemStack(Material.BARRIER)
        val closeGUIButtonMeta = closeGUIButton.itemMeta
        closeGUIButtonMeta.displayName(Component.text("Close").color(TextColor.color(255, 0, 0)))
        closeGUIButton.itemMeta = closeGUIButtonMeta

        // create New kit button
        val createKitButton = ItemStack(Material.WRITTEN_BOOK)
        val createKitButtonMeta = createKitButton.itemMeta
        createKitButtonMeta.displayName(Component.text("Create New Kit").color(TextColor.color(50, 0, 100)))
        createKitButton.itemMeta = createKitButtonMeta

        inventory.setItem(0, createKitButton)
        inventory.setItem(7, closeGUIButton)

        VsCustomKitsPlugin.guiMap[sender.uniqueId] = inventory

        sender.openInventory(inventory)

        return false;
    }

}