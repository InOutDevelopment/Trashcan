package net.oneescape.trashcan.Object;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Trashcan {

    int size;

    public Trashcan(String name, int size, Player owner) {
        this.size = size;
        Inventory inv = Bukkit.createInventory(null, size, ChatColor.RED + name);
        owner.openInventory(inv);

    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
