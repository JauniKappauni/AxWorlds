package de.jauni.axworlds;

import de.jauni.axworlds.command.CreateCommand;
import de.jauni.axworlds.command.ListCommand;
import de.jauni.axworlds.command.RemoveCommand;
import de.jauni.axworlds.command.TeleportCommand;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public final class AxWorlds extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getCommand("create").setExecutor(new CreateCommand(this));
        getCommand("list").setExecutor(new ListCommand());
        getCommand("teleport").setExecutor(new TeleportCommand());
        getCommand("remove").setExecutor(new RemoveCommand(this));
        loadWorlds();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadWorlds() {
        if (getConfig().getConfigurationSection("worlds") != null) {
            Set<String> worlds = getConfig().getConfigurationSection("worlds").getKeys(false);
            for (String w : worlds) {
                Bukkit.createWorld(new WorldCreator(w));
            }
        }
    }
}
