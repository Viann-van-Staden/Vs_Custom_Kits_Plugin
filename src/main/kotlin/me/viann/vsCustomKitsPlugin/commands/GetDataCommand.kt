package me.viann.vsCustomKitsPlugin.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.FileConfiguration
import java.io.File

class GetDataCommand(private val config: FileConfiguration, private val file: File) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            sender.sendMessage("Please provide some data.")
            return false
        }

        val playerName = sender.name
        val data = args.joinToString(" ")

        // Store the data
        config.set(playerName, data)
        config.save(file)

        sender.sendMessage("Data stored successfully!")
        return true
    }
}