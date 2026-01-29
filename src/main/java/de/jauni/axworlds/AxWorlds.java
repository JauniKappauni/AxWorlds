package de.jauni.axworlds;

import de.jauni.axworlds.command.CreateCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class AxWorlds extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("create").setExecutor(new CreateCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
