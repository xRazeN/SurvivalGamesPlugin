package com.rqzen.events;

import java.util.Collection;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SpectatorCompass implements Listener {
	
	@EventHandler
	public void onCompassRightClick(PlayerInteractEvent event) {
	    if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	        if (event.getItem() == new ItemStack(Material.COMPASS)) {
	            Inventory inv = createSurvivalPlayerHeadsInventory();
	            event.getPlayer().openInventory(inv);
	        }
	    }
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
	    if (!event.getView().getTitle().equals(ChatColor.GREEN + "Survival Players")) {
	        return;
	    }

	    event.setCancelled(true);

	    Player player = (Player) event.getWhoClicked();
	    ItemStack clickedItem = event.getCurrentItem();

	    if (clickedItem == null || clickedItem.getType() != Material.SKULL_ITEM) {
	        return;
	    }

	    SkullMeta skullMeta = (SkullMeta) clickedItem.getItemMeta();
	    String playerName = skullMeta.getOwner();

	    Player targetPlayer = Bukkit.getPlayerExact(playerName);
	    if (targetPlayer != null) {
	        player.teleport(targetPlayer.getLocation());
	    } else {
	        player.sendMessage(ChatColor.RED + "Player not found.");
	    }
	}

	private Inventory createSurvivalPlayerHeadsInventory() {
	    Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
	    onlinePlayers = onlinePlayers.stream()
	            .filter(player -> player.getWorld().getName().equals("world"))
	            .filter(player -> player.getGameMode() == GameMode.SURVIVAL)
	            .collect(Collectors.toList());

	    int inventorySize = (int) Math.ceil((double) onlinePlayers.size() / 9) * 9;
	    Inventory inv = Bukkit.createInventory(null, inventorySize, ChatColor.GREEN + "Survival Players");

	    onlinePlayers.forEach(player -> {
	        ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
	        SkullMeta skullMeta = (SkullMeta) playerHead.getItemMeta();
	        skullMeta.setOwner(player.getName());
	        skullMeta.setDisplayName(ChatColor.GOLD + player.getName());
	        playerHead.setItemMeta(skullMeta);
	        inv.addItem(playerHead);
	    });

	    return inv;
	}


}
