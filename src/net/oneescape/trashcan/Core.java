package net.oneescape.trashcan;

import net.oneescape.trashcan.Command.TrashcanCommand;
import net.oneescape.trashcan.Event.InteractEvent;
import org.bukkit.plugin.java.*;
import org.bukkit.plugin.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Core extends JavaPlugin {
    public static Plugin pl;

    public void onEnable() {
        Core.pl = (Plugin)this;
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        this.getCommand("trashcan").setExecutor(new TrashcanCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new InteractEvent(), Core.pl);
    }
}
