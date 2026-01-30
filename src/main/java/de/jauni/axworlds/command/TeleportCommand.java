package de.jauni.axworlds.command;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TeleportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Nur Spieler dürfen diesen Befehl verwenden!");
        }
        Player p = (Player) sender;
        World targetWorld = Bukkit.getWorld(args[0]);
        p.teleport(targetWorld.getSpawnLocation());
        p.sendMessage("Du wurdest in die Welt" + " " + args[0] + " " + "teleportiert!");
        return true;
    }
}
