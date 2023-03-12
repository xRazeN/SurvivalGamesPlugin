package com.rqzen.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.rqzen.survival.games.main;

public class MapVotes implements Listener{
	
    public static List<String> RevolutionMap = new ArrayList<String>();
    public static List<String> SurvivalGamesMap = new ArrayList<String>();
    public static List<String> Mn7OSMap = new ArrayList<String>();
    public static List<String> TheivesOfSeaMap = new ArrayList<String>();
    public static List<String> HevixMap = new ArrayList<String>();
    public static List<String> FiiiFooMap = new ArrayList<String>();
    public static List<String> DVOSMap = new ArrayList<String>();

	
	public static void MapVote(Player p) {
	    Inventory inventory = Bukkit.createInventory((InventoryHolder)p, 27, ChatColor.GREEN + "MapVotes");
	    inventory.setItem(10, ItemStacks.RevolutionMap());
	    inventory.setItem(11, ItemStacks.SurvivalGamesMap());
	    inventory.setItem(12, ItemStacks.Mn7OSMap());
	    inventory.setItem(13, ItemStacks.TheivesOfSeaMap());
	    inventory.setItem(14, ItemStacks.HeviXMap());
	    inventory.setItem(15, ItemStacks.FiiiFooMap());
	    inventory.setItem(16, ItemStacks.DVOSMap());
	    p.openInventory(inventory);
	  }
	  
	  @EventHandler
	  public void onInt(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    Action action = e.getAction();
	    ItemStack Hand = p.getItemInHand();
	    if (action == Action.RIGHT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK || action == Action.RIGHT_CLICK_BLOCK) {
	      if (Hand.equals(ItemStacks.VotingBook())) {
	        MapVote(p);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onClickAtGUI1(InventoryClickEvent event) {
	    Player p = (Player)event.getWhoClicked();
	    String playerName = p.getName();
	    ItemStack i = event.getCurrentItem();
	    Inventory inv = event.getInventory();
	    if (inv.getName().equalsIgnoreCase(ChatColor.GREEN + "MapVotes")) {
	      event.setCancelled(true);
	      if (i.equals(ItemStacks.RevolutionMap())) {
	    	  if (RevolutionMap.contains(playerName)) {
	    		   p.sendMessage(main.prefix + main.color("&cYouve Already Voted To This Map."));
	    	   } else {
	    		   RevolutionMap.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Voted To This Map."));
	    	   }
	    	  if (SurvivalGamesMap.contains(playerName)) {
	    		   SurvivalGamesMap.remove(playerName);
	    	   }
	    	  if (Mn7OSMap.contains(playerName)) {
	    		   Mn7OSMap.remove(playerName);
	    	   }
	    	  if (HevixMap.contains(playerName)) {
	    		   HevixMap.remove(playerName);
	    	   }
	    	  if (FiiiFooMap.contains(playerName)) {
	    		   FiiiFooMap.remove(playerName);
	    	   }
	    	  if (DVOSMap.contains(playerName)) {
	    		   DVOSMap.remove(playerName);
	    	   }
	    	  if (TheivesOfSeaMap.contains(playerName)) {
	    		   TheivesOfSeaMap.remove(playerName);
	    	   }
	      }
	      if (i.equals(ItemStacks.HeviXMap())) {
	    	  if (RevolutionMap.contains(playerName)) {
	    		   RevolutionMap.remove(playerName);
	    	   }
	    	  if (SurvivalGamesMap.contains(playerName)) {
	    		   SurvivalGamesMap.remove(playerName);
	    	   }
	    	  if (Mn7OSMap.contains(playerName)) {
	    		   Mn7OSMap.remove(playerName);
	    	   }
	    	  if (HevixMap.contains(playerName)) {
	    		  p.sendMessage(main.prefix + main.color("&cYouve Already Voted To This Map."));
	    	  } else {
	    		   HevixMap.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Voted To This Map."));
	    	  }
	    	  if (FiiiFooMap.contains(playerName)) {
	    		   FiiiFooMap.remove(playerName);
	    	   }
	    	  if (DVOSMap.contains(playerName)) {
	    		   DVOSMap.remove(playerName);
	    	   }
	    	  if (TheivesOfSeaMap.contains(playerName)) {
	    		   TheivesOfSeaMap.remove(playerName);
	    	   }
	      }
	      if (i.equals(ItemStacks.Mn7OSMap())) {
	    	  if (RevolutionMap.contains(playerName)) {
	    		   RevolutionMap.remove(playerName);
	    	   }
	    	  if (SurvivalGamesMap.contains(playerName)) {
	    		   SurvivalGamesMap.remove(playerName);
	    	   }
	    	  if (Mn7OSMap.contains(playerName)) {
	    		  p.sendMessage(main.prefix + main.color("&cYouve Already Voted To This Map."));
	    	   } else {
	    		   Mn7OSMap.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Voted To This Map."));
	    	  }
	    	  if (HevixMap.contains(playerName)) {
	    		  HevixMap.remove(playerName);
	    	  } 
	    	  if (FiiiFooMap.contains(playerName)) {
	    		   FiiiFooMap.remove(playerName);
	    	   }
	    	  if (DVOSMap.contains(playerName)) {
	    		   DVOSMap.remove(playerName);
	    	   }
	    	  if (TheivesOfSeaMap.contains(playerName)) {
	    		   TheivesOfSeaMap.remove(playerName);
	    	   }
	      }
	      if (i.equals(ItemStacks.DVOSMap())) {
	    	  if (RevolutionMap.contains(playerName)) {
	    		   RevolutionMap.remove(playerName);
	    	   }
	    	  if (SurvivalGamesMap.contains(playerName)) {
	    		   SurvivalGamesMap.remove(playerName);
	    	   }
	    	  if (Mn7OSMap.contains(playerName)) {
	    		   Mn7OSMap.remove(playerName);
	    	  }
	    	  if (HevixMap.contains(playerName)) {
	    		  HevixMap.remove(playerName);
	    	  } 
	    	  if (FiiiFooMap.contains(playerName)) {
	    		   FiiiFooMap.remove(playerName);
	    	   }
	    	  if (DVOSMap.contains(playerName)) {
	    		  p.sendMessage(main.prefix + main.color("&cYouve Already Voted To This Map."));
	    	   } else {
	    		   DVOSMap.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Voted To This Map."));
	    	   }
	    	  if (TheivesOfSeaMap.contains(playerName)) {
	    		   TheivesOfSeaMap.remove(playerName);
	    	   }
	      }
	      if (i.equals(ItemStacks.SurvivalGamesMap())) {
	    	  if (RevolutionMap.contains(playerName)) {
	    		   RevolutionMap.remove(playerName);
	    	   }
	    	  if (SurvivalGamesMap.contains(playerName)) {
	    		  p.sendMessage(main.prefix + main.color("&cYouve Already Voted To This Map."));
	    	   } else {
	    		   SurvivalGamesMap.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Voted To This Map."));
	    	   }
	    	  if (Mn7OSMap.contains(playerName)) {
	    		   Mn7OSMap.remove(playerName);
	    	  }
	    	  if (HevixMap.contains(playerName)) {
	    		  HevixMap.remove(playerName);
	    	  } 
	    	  if (FiiiFooMap.contains(playerName)) {
	    		   FiiiFooMap.remove(playerName);
	    	   }
	    	  if (DVOSMap.contains(playerName)) {
	    		   DVOSMap.remove(playerName);
	    	   }
	    	  if (TheivesOfSeaMap.contains(playerName)) {
	    		   TheivesOfSeaMap.remove(playerName);
	    	   }
	      }
	      if (i.equals(ItemStacks.FiiiFooMap())) {
	    	  if (RevolutionMap.contains(playerName)) {
	    		   RevolutionMap.remove(playerName);
	    	   }
	    	  if (SurvivalGamesMap.contains(playerName)) {
	    		   SurvivalGamesMap.remove(playerName);
	    	   }
	    	  if (Mn7OSMap.contains(playerName)) {
	    		   Mn7OSMap.remove(playerName);
	    	  }
	    	  if (HevixMap.contains(playerName)) {
	    		  HevixMap.remove(playerName);
	    	  } 
	    	  if (FiiiFooMap.contains(playerName)) {
	    		  p.sendMessage(main.prefix + main.color("&cYouve Already Voted To This Map."));
	    	   } else {
	    		   FiiiFooMap.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Voted To This Map."));
	    	   }
	    	  if (DVOSMap.contains(playerName)) {
	    		   DVOSMap.remove(playerName);
	    	   }
	    	  if (TheivesOfSeaMap.contains(playerName)) {
	    		   TheivesOfSeaMap.remove(playerName);
	    	   }
	      }
	      if (i.equals(ItemStacks.TheivesOfSeaMap())) {
	    	  if (RevolutionMap.contains(playerName)) {
	    		   RevolutionMap.remove(playerName);
	    	   }
	    	  if (SurvivalGamesMap.contains(playerName)) {
	    		   SurvivalGamesMap.remove(playerName);
	    	   }
	    	  if (Mn7OSMap.contains(playerName)) {
	    		   Mn7OSMap.remove(playerName);
	    	  }
	    	  if (HevixMap.contains(playerName)) {
	    		  HevixMap.remove(playerName);
	    	  } 
	    	  if (FiiiFooMap.contains(playerName)) {
	    		   FiiiFooMap.remove(playerName);
	    	   }
	    	  if (DVOSMap.contains(playerName)) {
	    		   DVOSMap.remove(playerName);
	    	   }
	    	  if (TheivesOfSeaMap.contains(playerName)) {
	    		  p.sendMessage(main.prefix + main.color("&cYouve Already Voted To This Map."));
	    	   } else {
	    		   TheivesOfSeaMap.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Voted To This Map."));
	    	   }
	      }
	    }
	  }

}
