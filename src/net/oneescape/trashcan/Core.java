package net.oneescape.trashcan;

import net.oneescape.trashcan.Command.TrashcanCommand;
import net.oneescape.trashcan.Event.InteractEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.*;
import org.bukkit.plugin.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.event.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Core extends JavaPlugin {
    public static Plugin pl;

    public void onEnable() {
        checkUpdate();
        Core.pl = (Plugin)this;
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        this.getCommand("trashcan").setExecutor(new TrashcanCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new InteractEvent(), Core.pl);
    }

    private static String key = "key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=";

    public static void checkUpdate() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://api.spigotmc.org/legacy/update.php?resource=63900").openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.getOutputStream().write((key + 63900).getBytes("UTF-8"));
            String version = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
            if (!version.equals("V1.2")) {
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "You're not running the newest version of Trashcan+");
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "Please download it on Spigot: https://www.spigotmc.org/resources/%EF%B8%8F-trashcan-a-simple-and-stable-trashcan-plugin-%EF%B8%8F.63900/");
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.hasPermission("rideop.rideop")) {
                        player.sendMessage(ChatColor.DARK_PURPLE + "You're not running the newest version of Trashcan+");
                        player.sendMessage(ChatColor.GRAY + "Please download it on Spigot: https://www.spigotmc.org/resources/%EF%B8%8F-trashcan-a-simple-and-stable-trashcan-plugin-%EF%B8%8F.63900/");
                    }
                }
            } else {
                Bukkit.getServer().getConsoleSender().sendMessage("You're running the newest version of Trashcan+");
            }
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage("Can't connect to SpigotMC");
            e.printStackTrace();

        }
    }
}
