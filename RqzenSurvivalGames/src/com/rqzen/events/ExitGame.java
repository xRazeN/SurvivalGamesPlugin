package com.rqzen.events;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
public class ExitGame implements Listener{
	
	@EventHandler
	  public void onInt(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    Action action = e.getAction();
	    ItemStack Hand = p.getItemInHand();
	    if (action == Action.RIGHT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK || action == Action.RIGHT_CLICK_BLOCK)
	      if (Hand.equals(ItemStacks.ExitGame()))
	        Bukkit.getServer().dispatchCommand((CommandSender)p.getPlayer(), "server hub");  
	  }

}
