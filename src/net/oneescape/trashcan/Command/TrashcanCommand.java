package net.oneescape.trashcan.Command;

import net.oneescape.trashcan.Core;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrashcanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player p = (Player)sender;
        if (strings.length == 0 && p.hasPermission("trashcan.admin")) {
            p.sendMessage(ChatColor.GRAY + "Trashcan+ Plugin " + ChatColor.RED + "V1.0");
            p.sendMessage(" ");
            p.sendMessage(ChatColor.GRAY + "- " + ChatColor.RED + ChatColor.ITALIC + "/trashcan setblock <block>");
            p.sendMessage(ChatColor.GRAY + "- " + ChatColor.RED + ChatColor.ITALIC + "/trashcan version");
            p.sendMessage(" ");
            p.sendMessage(ChatColor.GRAY + "Version " + ChatColor.RED + ChatColor.ITALIC + "1.0");
            return false;
        }
        if (strings[0].equals("setblock")) {
            if (strings.length != 2) {
                if (p.hasPermission("trashcan.admin")) {
                    p.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Trashcan+" + ChatColor.GRAY + "] " + ChatColor.RED + "Please add a block name");
                }

            } else {
                String block = Core.pl.getConfig().get("trashcan.block").toString();
                if (Material.getMaterial(strings[1].toUpperCase()) != null) {
                    Core.pl.getConfig().set("trashcan.block", strings[1].toUpperCase());
                    p.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Trashcan+" + ChatColor.GRAY + "] " + "Block has been set to: " + ChatColor.RED + strings[1]);
                    Core.pl.saveConfig();
                } else {
                    p.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Trashcan+" + ChatColor.GRAY + "] " + ChatColor.RED + ChatColor.ITALIC + strings[1] + " is not a valid block type, please enter a valid block type!");
                }
            }
        }
        if (strings[0].equals("version")) {
            if (p.hasPermission("trashcan.admin")) {
                p.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Trashcan+" + ChatColor.GRAY + "] " + "This server is running version: V1.0");
            }
        }
        return false;
    }
}
