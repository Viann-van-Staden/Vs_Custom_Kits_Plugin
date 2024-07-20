package me.viann.vsCustomKitsPlugin

import me.viann.vsCustomKitsPlugin.commands.GetDataCommand
import me.viann.vsCustomKitsPlugin.commands.KitCreateCommand
import me.viann.vsCustomKitsPlugin.commands.OpenGUICommand
import me.viann.vsCustomKitsPlugin.commands.ShowDataCommand
import me.viann.vsCustomKitsPlugin.listeners.InventoryClickListener
import me.viann.vsCustomKitsPlugin.listeners.InventoryCloseListener
import org.bukkit.Bukkit
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.inventory.Inventory
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.util.UUID

class VsCustomKitsPlugin : JavaPlugin() {
    private lateinit var playerDataFile: File
    private lateinit var playerDataConfig: FileConfiguration

    companion object {

        public val guiMap: MutableMap<UUID, Inventory> = mutableMapOf()
    }

    override fun onEnable() {
        // Plugin startup logic
        logger.info("V's Custom Kits plugin has loaded")

        saveDefaultConfig()
        setupPlayerDataFile()

        registerCommands()
        registerListeners()
    }

    private fun setupPlayerDataFile() {
        playerDataFile = File(dataFolder, "playerdata.yml")
        if (!playerDataFile.exists()) {
            saveResource("playerdata.yml", false)
        }
        playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile)
    }

    private fun registerCommands() {
        getCommand("kits")!!.setExecutor(OpenGUICommand())
        getCommand("get-data")?.setExecutor(GetDataCommand(playerDataConfig, playerDataFile))
        getCommand("show-data")?.setExecutor(ShowDataCommand(playerDataConfig))
        getCommand("kit-create")!!.setExecutor(KitCreateCommand())

        logger.info("Registered commands")
    }

    private fun registerListeners() {
        Bukkit.getServer().pluginManager.registerEvents(InventoryCloseListener(), this)
        Bukkit.getServer().pluginManager.registerEvents(InventoryClickListener(), this)

        logger.info("Registered Listeners")
    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("V's Custom Kits plugin has unloaded")
    }
}
