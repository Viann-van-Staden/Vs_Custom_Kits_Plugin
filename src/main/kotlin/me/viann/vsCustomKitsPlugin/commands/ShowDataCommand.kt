package me.viann.vsCustomKitsPlugin.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.FileConfiguration

class ShowDataCommand(private val config: FileConfiguration) : CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val playerName = sender.name
        val data = config.getString(playerName)

        if(data.isNullOrEmpty()) {
            sender.sendMessage("No data found for you.")
        }
        else {
            sender.sendMessage("Your data: $data")
        }

        return false
    }

}