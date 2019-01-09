package net.oneescape.trashcan.Event;

import net.oneescape.trashcan.Core;
import net.oneescape.trashcan.Object.Trashcan;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction() != null) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Player p = e.getPlayer();
                Material block = e.getClickedBlock().getType();
                if (Core.pl.getConfig().get("trashcan.block").equals(block.toString())) {
                    Trashcan trashcan = new Trashcan("Trashcan+", 9, p);
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Created a new Trashcan with the size: " + trashcan.getSize());
                }
            }
        }
    }

}
