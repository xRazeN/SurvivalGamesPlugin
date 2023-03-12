package com.rqzen.events;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import com.rqzen.survival.games.main;

public class Events implements Listener{
	
	public static final List<ItemStack> ITEMS = Arrays.asList(
            new ItemStack[] {
                    new ItemStack(Material.LEATHER_HELMET),
                    new ItemStack(Material.LEATHER_CHESTPLATE),
                    new ItemStack(Material.LEATHER_LEGGINGS),
                    new ItemStack(Material.LEATHER_BOOTS),
                    new ItemStack(Material.IRON_HELMET),
                    new ItemStack(Material.IRON_CHESTPLATE),
                    new ItemStack(Material.IRON_LEGGINGS),
                    new ItemStack(Material.IRON_BOOTS),
                    new ItemStack(Material.GOLD_HELMET),
                    new ItemStack(Material.GOLD_CHESTPLATE),
                    new ItemStack(Material.GOLD_LEGGINGS),
                    new ItemStack(Material.GOLD_BOOTS),
                    new ItemStack(Material.STONE_SWORD),
                    new ItemStack(Material.WOOD_SWORD),
                    new ItemStack(Material.GOLD_SWORD),
                    new ItemStack(Material.STONE_AXE),
                    new ItemStack(Material.WOOD_AXE),
                    new ItemStack(Material.GOLD_AXE),
                    new ItemStack(Material.COOKED_BEEF),
                    new ItemStack(Material.COOKED_CHICKEN),
                    new ItemStack(Material.APPLE),
                    new ItemStack(Material.COOKED_MUTTON),
                    new ItemStack(Material.RAW_FISH),
                    new ItemStack(Material.COOKED_RABBIT),
                    new ItemStack(Material.RAW_BEEF),
                    new ItemStack(Material.BREAD),
                    new ItemStack(Material.STICK),
                    new ItemStack(Material.ARROW),
                    new ItemStack(Material.BOW),
                    new ItemStack(Material.FISHING_ROD),
                    new ItemStack(Material.TNT),
                    new ItemStack(Material.FLINT),
                    new ItemStack(Material.FLINT_AND_STEEL),
                    new ItemStack(Material.COOKED_BEEF),
                    new ItemStack(Material.CHAINMAIL_HELMET),
                    new ItemStack(Material.CHAINMAIL_CHESTPLATE),
                    new ItemStack(Material.CHAINMAIL_LEGGINGS),
                    new ItemStack(Material.CHAINMAIL_BOOTS)
            }
    );
	
	
	private Set<Location> filledChests = new HashSet<>();

	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) {
	    Inventory inventory = event.getInventory();
	    if (inventory != null && inventory.getType() == InventoryType.CHEST) {
	        Location chestLocation = ((Chest) inventory.getHolder()).getLocation();
	        if (!filledChests.contains(chestLocation)) {
	        	inventory.clear();
	            Collections.shuffle(ITEMS);
	            for (int i = 0; i < 4; i++) {
	                inventory.setItem(new Random().nextInt(27), ITEMS.get(i));
	            }
	            filledChests.add(chestLocation);
	        }
	    }
	}

	@EventHandler
	public void onInt(PlayerInteractEvent e) {
		Action action = e.getAction();
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();
		if (!(b.getType() == Material.CHEST)) {
			return;
		}
		if (!(action == Action.RIGHT_CLICK_BLOCK)) {
			return;
		}
		if (p.getGameMode().equals(GameMode.ADVENTURE)) {
			e.setCancelled(true);
		}
	}


	
	
	
	
	@EventHandler
	public void onItemPickUp(PlayerPickupItemEvent event) {
		Player p = event.getPlayer();
		ItemStack item = event.getItem().getItemStack();
		if (p.getGameMode().equals(GameMode.ADVENTURE)) {
			event.setCancelled(true);
		}
		if (item.getType() == Material.RED_ROSE || item.getType() == Material.YELLOW_FLOWER || item.getType() == Material.BLAZE_POWDER) {
            event.setCancelled(true);
        }
	}
	
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (p.isOp()) {
			return;
		}
		e.setCancelled(true);
	}
	
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
	    Player player = (Player) event.getEntity();
	    if (player.getGameMode().equals(GameMode.ADVENTURE)) {
	        event.setCancelled(true);
	    }
	}
	
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
	    if (e.getBlockPlaced().getType() == Material.TNT) {
	        e.setCancelled(true);
	        Player p = e.getPlayer();
	        ItemStack i = p.getItemInHand();
	        if (i.getAmount() == 1) {
	            p.getInventory().remove(i);
	        } else {
	            i.setAmount(i.getAmount() - 1);
	        }

	        final Location loc = e.getBlock().getLocation();
	        TNTPrimed tnt = (TNTPrimed) loc.getWorld().spawnEntity(loc.add(0.5D, 0.5D, 0.5D), EntityType.PRIMED_TNT);
	        tnt.setFuseTicks(60);
	        tnt.setYield(0.0F);
	        tnt.setIsIncendiary(false);

	        Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) main.plugin, new Runnable() {
	            public void run() {
	                for (Player player : loc.getWorld().getPlayers()) {
	                    if (player.getLocation().distance(loc) <= 5.0D) {
	                        double distance = player.getLocation().distance(loc);
	                        double multiplier = (5 - distance + 1) / 5;
	                        Vector direction = player.getLocation().subtract(tnt.getLocation()).toVector().normalize();
	                        direction.setX(direction.getX() * multiplier);
	                        direction.setZ(direction.getZ() * multiplier);
	                        double yVelocity = 1.0D + 0.5D * multiplier;
	                        direction.setY(yVelocity);

	                        player.setVelocity(direction);
	                        player.damage(6.0D - distance);
	                    }
	                }
	            }
	        }, 60L);
	    }
	}

	  
	 @EventHandler
	    public void onPlayerInteract(PlayerInteractEvent event) {
	        ItemStack item = event.getItem();
	        Action action = event.getAction();
	        if (item != null && item.getType() == Material.FLINT_AND_STEEL) {
	        	if (!(action == Action.RIGHT_CLICK_BLOCK)) {
	        		return;
	        	}
	            int uses = item.getDurability();
	            if (uses >= 4) {
	                event.getPlayer().getInventory().removeItem(item);
	            } else {
	                item.setDurability((short) (uses + 1));
	            }
	        }
	    }
	  
	  @EventHandler
	  public void onClickAtGUI1(InventoryClickEvent event) {
	    ItemStack i = event.getCurrentItem();
	    if (i.equals(ItemStacks.SGPerks())) {
	      event.setCancelled(true);
	    } else if (i.equals(ItemStacks.VotingBook())) {
	      event.setCancelled(true);
	    } else if (i.getType() == Material.COMPASS) {
	      event.setCancelled(true);
	    } 
	  }
	  
	  @EventHandler
	  public void onDrop(PlayerDropItemEvent e) {
		  Player p = e.getPlayer();
		  if (p.getGameMode().equals(GameMode.ADVENTURE)) {
			  e.setCancelled(true);
		  }
	    ItemStack i = e.getItemDrop().getItemStack();
	    if (i.equals(ItemStacks.VotingBook())) {
	      e.setCancelled(true);
	    } else if (i.equals(ItemStacks.SGPerks())) {
	      e.setCancelled(true);
	    } else if (i.getType() == Material.COMPASS) {
	      e.setCancelled(true);
	    }
	  }
	  
	    
	    @EventHandler
	    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
	        if (!(event.getDamager() instanceof Player)) {
	            return;
	        }

	        Player player = (Player) event.getDamager();
	        Player player2 = (Player) event.getEntity();
	        if (player.getGameMode() == GameMode.ADVENTURE) {
	            event.setCancelled(true);
	        }
	        if (player2.getGameMode() == GameMode.ADVENTURE) {
	        	event.setCancelled(true);
	        }
	    }
	    @EventHandler
	    public void onPlayerDamage(EntityDamageEvent event) {
	        if (event.getEntity() instanceof Player) {
	            Player player = (Player) event.getEntity();
	            if (player.getGameMode() == GameMode.ADVENTURE) {
	                event.setCancelled(true);
	            }
	        }
	    }
	    
}
