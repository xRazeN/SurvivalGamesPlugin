package com.rqzen.events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.rqzen.survival.games.main;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
public class GameStartEvent implements Listener{
	
	public static Map<UUID, Integer> playerXp = new HashMap<>();
	  
	  public static final Map<UUID, Integer> playerXp2 = new HashMap<>();
	  
	  public static final Map<String, Integer> roundkills = new HashMap<>();

	  public static final Map<String, Integer> roundtokens = new HashMap<>();

	  public static final Map<String, Integer> roundpoints = new HashMap<>();

	  
	  public static BukkitTask startCountDownTask2;
	  
	  public static BukkitTask startCountDownTask;
	  
	  public static BukkitTask DeathMatchCountDown;
	  
	  public static boolean gameStarted;
	  
	  public void Respawn(final Player player,int Time) {
			Bukkit.getScheduler().runTaskLater(main.plugin, new Runnable() {
				
				@Override
				public void run() {
					player.spigot().respawn();
				}
			},Time);
		}
	  
	  public static void checkCountdown() {
	    if (Bukkit.getOnlinePlayers().size() < 2) {
	      startCountdown();
	    } else {
	    	for (Player all : Bukkit.getOnlinePlayers()) {
	        UUID uuid = all.getUniqueId();
	        int newXpp = Math.max(0, 30);
	        playerXp2.put(uuid, Integer.valueOf(newXpp));
	        all.setLevel(newXpp);
	        all.sendMessage(String.valueOf(main.prefix) + main.color("&cTime shortened to 30 seconds"));
	      }
	    	ShortenedTime.add(1);
	    	startCountdown2();
	    }
	  }
	  
	  public static void checkCountdown2() {
	    if (Bukkit.getOnlinePlayers().size() < 2) {
	      for (Player all : Bukkit.getOnlinePlayers()) {
	        all.sendTitle(main.color("&c&lNot Enough"), main.color("&c&lPlayers"));
	        all.sendMessage(String.valueOf(main.prefix) + main.color("&cCancelled Queue, Not Enough Players"));
	      }
	      startCountdown();
	    } else {
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	            public void run() {
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                all.sendTitle(main.color("&c10"), null);
	                all.sendMessage(String.valueOf(main.prefix) + main.color("&aGame Starting in &c10"));
	                UUID uuid = all.getUniqueId();
	                int newXpp = Math.max(0, 10);
	                GameStartEvent.playerXp2.put(uuid, Integer.valueOf(newXpp));
	                all.setLevel(newXpp);
	                all.setGameMode(GameMode.SURVIVAL);
	              }
	            }
	          },20L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	            public void run() {
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                UUID uuid = all.getUniqueId();
	                int newXpp = Math.max(0, 9);
	                GameStartEvent.playerXp2.put(uuid, Integer.valueOf(newXpp));
	                all.setLevel(newXpp);
	              } 
	            }
	          },40L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	            public void run() {
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                UUID uuid = all.getUniqueId();
	                int newXpp = Math.max(0, 8);
	                GameStartEvent.playerXp2.put(uuid, Integer.valueOf(newXpp));
	                all.setLevel(newXpp);
	              } 
	            }
	          },60L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	            public void run() {
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                UUID uuid = all.getUniqueId();
	                int newXpp = Math.max(0, 7);
	                GameStartEvent.playerXp2.put(uuid, Integer.valueOf(newXpp));
	                all.setLevel(newXpp);
	              } 
	            }
	          },80L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	            public void run() {
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                UUID uuid = all.getUniqueId();
	                int newXpp = Math.max(0, 6);
	                GameStartEvent.playerXp2.put(uuid, Integer.valueOf(newXpp));
	                all.setLevel(newXpp);
	              } 
	            }
	          },100L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	            public void run() {
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                UUID uuid = all.getUniqueId();
	                int newXpp = Math.max(0, 5);
	                GameStartEvent.playerXp2.put(uuid, Integer.valueOf(newXpp));
	                all.setLevel(newXpp);
	              }
	              Location location = new Location(Bukkit.getWorld("world"),-975.5,186.5,-1057.5);
	              Block block = location.getBlock();

	              if (block.getType() == Material.AIR || block.getType() == Material.WATER || block.getType() == Material.LAVA) {
	                  block.setType(Material.CHEST);
	              }
	              Location location2 = new Location(Bukkit.getWorld("world"),-975.5,186.5,-1059.5);
	              Block block2 = location2.getBlock();

	              if (block2.getType() == Material.AIR || block2.getType() == Material.WATER || block2.getType() == Material.LAVA) {
	                  block2.setType(Material.CHEST);
	              }
	              Location location3 = new Location(Bukkit.getWorld("world"),-976.5,186.5,-1060.5);
	              Block block3 = location3.getBlock();

	              if (block3.getType() == Material.AIR || block3.getType() == Material.WATER || block3.getType() == Material.LAVA) {
	                  block3.setType(Material.CHEST);
	              }
	              Location location4 = new Location(Bukkit.getWorld("world"),-975.5,186.5,-1057.5);
	              Block block4 = location4.getBlock();

	              if (block4.getType() == Material.AIR || block4.getType() == Material.WATER || block4.getType() == Material.LAVA) {
	                  block4.setType(Material.CHEST);
	              }
	              Location location5 = new Location(Bukkit.getWorld("world"),-978.5,186.5,-1060.5);
	              Block block5 = location5.getBlock();

	              if (block5.getType() == Material.AIR || block5.getType() == Material.WATER || block5.getType() == Material.LAVA) {
	                  block5.setType(Material.CHEST);
	              }
	              Location location6 = new Location(Bukkit.getWorld("world"),-979.5,186.5,-1059.5);
	              Block block6 = location6.getBlock();

	              if (block6.getType() == Material.AIR || block6.getType() == Material.WATER || block6.getType() == Material.LAVA) {
	                  block6.setType(Material.CHEST);
	              }
	              Location location7 = new Location(Bukkit.getWorld("world"),-979.5,186.5,-1057.5);
	              Block block7 = location7.getBlock();

	              if (block7.getType() == Material.AIR || block7.getType() == Material.WATER || block7.getType() == Material.LAVA) {
	                  block7.setType(Material.CHEST);
	              }
	              Location location8 = new Location(Bukkit.getWorld("world"),-978.5,186.5,-1056.5);
	              Block block8 = location8.getBlock();

	              if (block8.getType() == Material.AIR || block8.getType() == Material.WATER || block8.getType() == Material.LAVA) {
	                  block8.setType(Material.CHEST);
	              }  
	              Location location9 = new Location(Bukkit.getWorld("world"),-976.5,186.5,-1056.5);
	              Block block9 = location9.getBlock();

	              if (block9.getType() == Material.AIR || block9.getType() == Material.WATER || block9.getType() == Material.LAVA) {
	                  block9.setType(Material.CHEST);
	              }
	            }
	          },120L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	            public void run() {
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                UUID uuid = all.getUniqueId();
	                int newXpp = Math.max(0, 4);
	                GameStartEvent.playerXp2.put(uuid, Integer.valueOf(newXpp));
	                all.setLevel(newXpp);
	              } 
	            }
	          },140L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	            public void run() {
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                all.sendTitle(main.color("&e&l3"), null);
	                all.sendMessage(String.valueOf(main.prefix) + main.color("&aGame Starting in &23"));
	                UUID uuid = all.getUniqueId();
	                int newXpp = Math.max(0, 3);
	                GameStartEvent.playerXp2.put(uuid, Integer.valueOf(newXpp));
	                all.setLevel(newXpp);
	              } 
	            }
	          },160L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	            public void run() {
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                all.sendTitle(main.color("&2&l2"), null);
	                all.sendMessage(String.valueOf(main.prefix) + main.color("&aGame Starting in &22"));
	                UUID uuid = all.getUniqueId();
	                int newXpp = Math.max(0, 2);
	                GameStartEvent.playerXp2.put(uuid, Integer.valueOf(newXpp));
	                all.setLevel(newXpp);
	              } 
	            }
	          },180L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	            public void run() {
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                all.sendTitle(main.color("&a&l1"), null);
	                all.sendMessage(String.valueOf(main.prefix) + main.color("&aGame Starting in &21"));
	                UUID uuid = all.getUniqueId();
	                int newXpp = Math.max(0, 1);
	                GameStartEvent.playerXp2.put(uuid, Integer.valueOf(newXpp));
	                all.setLevel(newXpp);
	              } 
	            }
	          },200L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	            public void run() {
	              GameStartEvent.startGame();
	            }
	          },  201L);
	    } 
	  }
	  
	    public static List<Integer> ShortenedTime = new ArrayList<Integer>();
	  
	  public static void startCountdown2() {
	    startCountDownTask2 = Bukkit.getScheduler().runTaskTimer((Plugin)main.plugin, new Runnable() {
	          int timee = 30;
	          
	          public void run() {
	        	 if (this.timee == 1) {
		            gameStarted = false;
	        	 }
	            if (this.timee == 0) {
	              GameStartEvent.startCountDownTask2.cancel();
	              List<Location> locations = Arrays.asList(new Location[] { new Location(Bukkit.getWorld("world"), -994.5,185.5,-1058.5), 
		                    new Location(Bukkit.getWorld("world"), -994.5,185.5,-1054.5), new Location(Bukkit.getWorld("world"), -992.5,185.5,-1050.5), 
		                    new Location(Bukkit.getWorld("world"), -989.5,185.5,-1046.5), new Location(Bukkit.getWorld("world"), -985.5,185.5,-1043.5),
		                    new Location(Bukkit.getWorld("world"), -981.5,185.5,-1041.5), new Location(Bukkit.getWorld("world"), -977.5,185.5,-1041.5),
		                    new Location(Bukkit.getWorld("world"), -973.5,185.5,-1041.5), new Location(Bukkit.getWorld("world"), -969.5,185.5,-1043.5),
		                    new Location(Bukkit.getWorld("world"), -965.5,185.5,-1046.5), new Location(Bukkit.getWorld("world"), -962.5,185.5,-1050.5),
		                    new Location(Bukkit.getWorld("world"), -960.5,185.5,-1054.5), new Location(Bukkit.getWorld("world"), -960.5,185.5,-1058.5),
		                    new Location(Bukkit.getWorld("world"), -960.5,185.5,-1062.5), new Location(Bukkit.getWorld("world"), -962.5,185.5,-1066.5),
		                    new Location(Bukkit.getWorld("world"), -965.5,185.5,-1070.5), new Location(Bukkit.getWorld("world"), -969.5,185.5,-1073.5),
		                    new Location(Bukkit.getWorld("world"), -973.5,185.5,-1075.5), new Location(Bukkit.getWorld("world"), -977.5,185.5,-1075.5),
		                    new Location(Bukkit.getWorld("world"), -981.5,185.5,-1075.5), new Location(Bukkit.getWorld("world"), -985.5,185.5,-1073.5),
		                    new Location(Bukkit.getWorld("world"), -989.5,185.5,-1070.5), new Location(Bukkit.getWorld("world"), -992.5,185.5,-1066.5),
		                    new Location(Bukkit.getWorld("world"), -994.5,185.5,-1062.5),});
		              int i2 = 0;
		              for (Player all : Bukkit.getOnlinePlayers()) {
		                all.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 1));
		                Location location = locations.get(i2);
		                all.teleport(location);
		                i2++;
		              }
	              GameStartEvent.checkCountdown2();
	            } else if (Bukkit.getOnlinePlayers().size() < 2) {
	            	for (Player All : Bukkit.getOnlinePlayers()) {
		                All.sendMessage(String.valueOf(main.prefix) + main.color("&cCancelled Queue, Not Enough Players")); 
		              }
	              GameStartEvent.startCountDownTask2.cancel();
	              GameStartEvent.checkCountdown();
	              if (ShortenedTime.contains(1)) {
	            	  ShortenedTime.remove(1);
	              }
	            } else {
	              for (Player player : Bukkit.getOnlinePlayers()) {
	                UUID uuid = player.getUniqueId();
	                int currentXp = ((Integer)GameStartEvent.playerXp2.getOrDefault(uuid, Integer.valueOf(0))).intValue();
	                int newXp = Math.max(0, currentXp - 1);
	                GameStartEvent.playerXp2.put(uuid, Integer.valueOf(newXp));
	                player.setLevel(newXp);
	              } 
	              this.timee--;
	            } 
	          }
	        },20L, 20L);
	  }
	  
	  public static void startCountdown() {
	    startCountDownTask = Bukkit.getScheduler().runTaskTimer((Plugin)main.plugin, new Runnable() {
	      int time = 250;
	          public void run() {
	            if (time == 0) {
	              GameStartEvent.startCountDownTask.cancel();
	              GameStartEvent.checkCountdown();
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                all.sendTitle(main.color("&c&lNot Enough"), main.color("&c&lPlayers"));
	                all.sendMessage(String.valueOf(main.prefix) + main.color("&cCancelled Queue, Not Enough Players"));
	                UUID uuid = all.getUniqueId();
	                int newXp = Math.max(0, 250);
	                GameStartEvent.playerXp.put(uuid, Integer.valueOf(newXp));
	                all.setLevel(newXp);
	              } 
	            } else if (Bukkit.getOnlinePlayers().size() >= 2) {
	              GameStartEvent.startCountDownTask.cancel();
	              GameStartEvent.checkCountdown();
	            } else {
	            	for (Player player : Bukkit.getOnlinePlayers()) {
		                UUID uuid = player.getUniqueId();
		                int currentXp = ((Integer)GameStartEvent.playerXp.getOrDefault(uuid, Integer.valueOf(0))).intValue();
		                int newXp = Math.max(0, currentXp - 1);
		                GameStartEvent.playerXp.put(uuid, Integer.valueOf(newXp));
		                player.setLevel(newXp);
		              } 

	              time--;
	            } 
	          }
	        },20L, 20L);
	    
	  }
	  
	  public static void DeathMatchCountDown() {
	    DeathMatchCountDown = Bukkit.getScheduler().runTaskTimer((Plugin)main.plugin, new Runnable() {
	          int deathmatchtime = 60;
	          
	          public void run() {
	            if (this.deathmatchtime == 0) {
	              GameStartEvent.DeathMatchCountDown.cancel();
	              List<Location> locations = Arrays.asList(new Location[] { new Location(Bukkit.getWorld("world"), -166.5D, 73.5D, -150.5D), 
	                    new Location(Bukkit.getWorld("world"), -162.5D, 73.5D, -148.5D) });
	              int i2 = 0;
	              for (Player all : Bukkit.getOnlinePlayers()) {
	                all.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 1));
	                Location location = locations.get(i2);
	                all.teleport(location);
	                i2++;
	              } 
	            } else {
	              this.deathmatchtime--;
	            } 
	          }
	        },20L, 20L);
	  }
	  
	  @EventHandler
	  public void onJoin(PlayerJoinEvent event) {
	    Player p = event.getPlayer();
	    p.setFoodLevel(20);
    	gameStarted = true;
	    event.setJoinMessage(null);
	    if (Bukkit.getOnlinePlayers().size() >= 24) {
	      p.kickPlayer(String.valueOf(main.prefix) + main.color("&cUnable to join SG server. &7[&eFull Server&7]")); 
	    }
	    UUID uuid = p.getUniqueId();
	    p.setGameMode(GameMode.ADVENTURE);
	    int onlineSurvivalPlayers = 0;
	    for (Player player : Bukkit.getOnlinePlayers()) {
	      if (player.getGameMode() == GameMode.SURVIVAL)
	        onlineSurvivalPlayers++; 
	    } 
	    if (onlineSurvivalPlayers >= 1) {
		  createBoardSpectator(p);
		  p.getInventory().setItem(4, new ItemStack(Material.COMPASS));
	      p.setAllowFlight(true);
	      for (Player player : Bukkit.getOnlinePlayers()) {
	        if (player.getGameMode() == GameMode.SURVIVAL && player != p)
	          player.hidePlayer(p); 
	      } 
	      for (Player player : Bukkit.getOnlinePlayers()) {
	        if (player.getGameMode() == GameMode.ADVENTURE && player != p) {
	          player.hidePlayer(p);
	          p.hidePlayer(player);
	        }
	      }
	      return;
	    }
	    for (Player All : Bukkit.getOnlinePlayers()) {
	      All.sendMessage(String.valueOf(main.prefix) + main.color("&8" + p.getName() + " &bIs Ready to Fight&7 (" + Bukkit.getOnlinePlayers().size() + "/24)"));
	    }
	    Location loc2 = new Location(Bukkit.getWorld("world"),-765.5,199.5,-904.5);
	    p.teleport(loc2);
	    p.getInventory().setItem(8, ItemStacks.ExitGame());
	    p.getInventory().setItem(4, ItemStacks.VotingBook());
	    p.getInventory().setItem(0, ItemStacks.SGPerks());
	    int newXp = Math.max(0, 250);
	    playerXp.put(uuid, Integer.valueOf(newXp));
	    p.setLevel(newXp);
	    if (!main.playerpoints.containsKey(p.getUniqueId().toString())) {
	      int currentPoints = ((Integer)main.playerpoints.getOrDefault(p.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	      main.playerpoints.put(p.getUniqueId().toString(), Integer.valueOf(currentPoints + 1000));
	    } 
	    main.createBoard(p);
	    
	    if (ShortenedTime.contains(1)) {
	    	int newXp1 = Math.max(0, 30);
		    playerXp2.put(uuid, Integer.valueOf(newXp));
		    p.setLevel(newXp1);
	    }
	    
	    if (GameStartEvent.startCountDownTask != null && GameStartEvent.startCountDownTask.getTaskId() != -1) {
		      return; 
		    }
		    GameStartEvent.checkCountdown();
	  }
	  
	  
	  @EventHandler
	    public void onPlayerMove(PlayerMoveEvent event) {
	        if (!gameStarted) {
	            Location from = event.getFrom();
	            Location to = event.getTo();
	            if (from.getX() != to.getX() || from.getZ() != to.getZ()) {
	                event.setTo(from);
	            }
	        }
	    }
	  
	  @EventHandler
	  public void onQuit(PlayerQuitEvent event) {
	    Player p = event.getPlayer();
	    event.setQuitMessage(null);
	    if (p.getGameMode().equals(GameMode.SURVIVAL)) {
	    	return;
	    }
	    if (p.getGameMode().equals(GameMode.SURVIVAL)) {
	    	for (Player All : Bukkit.getOnlinePlayers()) {
	    	createBoardInGame(All);
	    	}
	    	Location location = p.getLocation();
	        
	        for (ItemStack item : p.getInventory().getContents()) {
	          if (item != null) {
	            p.getWorld().dropItemNaturally(location, item);
	          }
	        }
	      p.getInventory().clear();
	      for (Player All : Bukkit.getOnlinePlayers()) {
	        All.sendMessage(String.valueOf(main.prefix) + main.color("&9" + p.getName() + main.color(" &c&lELIMINATED!"))); 
	    }
	      int points = main.playerpoints.getOrDefault(p.getUniqueId().toString(), 0);
	      points -= 15;
	      main.playerpoints.put(p.getUniqueId().toString(), points);
	      int onlineSurvivalPlayers = 0;
		    for (Player player : Bukkit.getOnlinePlayers()) {
		      if (player.getGameMode() == GameMode.SURVIVAL)
		        onlineSurvivalPlayers++; 
		    } 
		    if (onlineSurvivalPlayers == 1) {
		      endGame(); 
		    }
	    }
	  }

	  
	  @EventHandler
	  public void onChat(AsyncPlayerChatEvent event) {
	    String chatFormat;
	    Player p = event.getPlayer();
	    int PlayerPoints = ((Integer)main.playerpoints.getOrDefault(p.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	    ItemStack[] inventory = p.getInventory().getContents();
	    boolean hasCompass = false;
	    boolean hasPerks = false;
	    byte b;
	    int i;
	    ItemStack[] arrayOfItemStack1;
	    for (i = (arrayOfItemStack1 = inventory).length, b = 0; b < i; ) {
	      ItemStack item = arrayOfItemStack1[b];
	      if (item != null && item.getType() == Material.COMPASS) {
	        hasCompass = true;
	        break;
	      } 
	      b++;
	    }
	    for (i = (arrayOfItemStack1 = inventory).length, b = 0; b < i; ) {
		      ItemStack item = arrayOfItemStack1[b];
		      if (item != null && item.equals(ItemStacks.VotingBook())) {
		        hasPerks = true;
		        break;
		      } 
		      b++;
		    }
	    if (hasCompass) {
	      chatFormat = String.valueOf(main.color("&c&lSPECTATOR")) + main.color(" &7%s&8» &f%s");
	      String formattedMessage = String.format(chatFormat, new Object[] { p.getName(), event.getMessage() });
	      for (Player recipient : event.getRecipients()) {
		      if (recipient.getInventory().contains(Material.COMPASS)) {
		        recipient.sendMessage(formattedMessage); 
		      }
	      }
	    } else if (hasPerks) {
	    	chatFormat = String.valueOf(main.color("&b") + PlayerPoints + main.color("")+ main.color(" &9%s&8» &f%s"));
		      String formattedMessage = String.format(chatFormat, new Object[] { p.getName(), event.getMessage() });
		      for (Player recipient : event.getRecipients()) {
			      if (recipient.getInventory().contains(ItemStacks.VotingBook())) {
			        recipient.sendMessage(formattedMessage); 
			      }
		      }
	    } else {
	    	chatFormat = String.valueOf(main.color("&9%s&8» &f%s"));
		      String formattedMessage = String.format(chatFormat, new Object[] { p.getName(), event.getMessage() });
		      for (Player recipient : event.getRecipients()) {
			        recipient.sendMessage(formattedMessage);
		      }
	    }
	    
	    event.setCancelled(true);
	  }
	  
	  @EventHandler
  	  public void onDeaths(PlayerDeathEvent e) {
  	    Player playerr = e.getEntity().getPlayer();
  	    Player k = e.getEntity().getKiller();
		Respawn(playerr,1);
  	    e.setDeathMessage(null);
  	    if (playerr.getGameMode().equals(GameMode.SURVIVAL)) {
  	    	if (k != null) {
  	      playerr.setGameMode(GameMode.ADVENTURE);
  	      Bukkit.broadcastMessage(String.valueOf(main.prefix) + main.color("&9" + playerr.getName() + main.color(" &c&lELIMINATED!")));
  	      int playerkillss = main.playerkills.getOrDefault(k.getUniqueId().toString(), 0);
  	      playerkillss++;
  	      main.playerkills.put(k.getUniqueId().toString(), playerkillss);
  	      int roundkills = GameStartEvent.roundkills.getOrDefault(k.getUniqueId().toString(), 0);
  	      roundkills++;
  	      GameStartEvent.roundkills.put(k.getUniqueId().toString(), roundkills);
  	      int playerpoints = ((Integer)main.playerpoints.getOrDefault(playerr.getUniqueId().toString(), Integer.valueOf(0))).intValue();
  	      int killerpoints = ((Integer)main.playerpoints.getOrDefault(k.getUniqueId().toString(), Integer.valueOf(0))).intValue();
  	      int killerroundpoints = GameStartEvent.roundpoints.getOrDefault(k.getUniqueId().toString(), 0);
  	      int playerroundpoints = GameStartEvent.roundpoints.getOrDefault(playerr.getUniqueId().toString(), 0);
  	      if (playerpoints > 500 && playerpoints <= 1000) {
  	    	playerroundpoints -= 50;
  	    	roundpoints.put(playerr.getUniqueId().toString(), playerroundpoints);
  	    	killerroundpoints += 50;
  	    	roundpoints.put(k.getUniqueId().toString(), killerroundpoints);
  	        playerpoints -= 50;
  	        playerr.sendMessage(String.valueOf(main.prefix) + main.color("&cYou Got Killed By &8" + k.getName() + main.color(" &cand &f50 points &chave been taken from ur account")));
  	        main.playerpoints.put(playerr.getUniqueId().toString(), Integer.valueOf(playerpoints));
  	        killerpoints += 50;
  	        k.sendMessage(String.valueOf(main.prefix) + main.color("&a&l+ &f50 points &afor killing " + playerr.getName()));
  	        main.playerpoints.put(k.getUniqueId().toString(), Integer.valueOf(killerpoints));
  	      String message = main.color("&a&l+ &f50 points");
  	    IChatBaseComponent chatMessage = ChatSerializer.a("{\"text\":\"" + message + "\"}");
  	    PacketPlayOutChat packet = new PacketPlayOutChat(chatMessage, (byte)2);
  	    ((CraftPlayer) k).getHandle().playerConnection.sendPacket(packet);
  	      } else if (playerpoints < 500 && playerpoints > 0) {
  	    	playerroundpoints -= 20;
  	    	roundpoints.put(playerr.getUniqueId().toString(), playerroundpoints);
  	    	killerroundpoints += 20;
  	    	roundpoints.put(k.getUniqueId().toString(), killerroundpoints);
  	        playerpoints -= 20;
  	        playerr.sendMessage(String.valueOf(main.prefix) + main.color("&cYou Got Killed By &8" + k.getName() + main.color(" &cand &f20 points &chave been taken from ur account")));
  	        main.playerpoints.put(playerr.getUniqueId().toString(), Integer.valueOf(playerpoints));
  	        killerpoints += 20;
  	        k.sendMessage(String.valueOf(main.prefix) + main.color("&a&l+ &f20 points &afor killing " + playerr.getName()));
  	        main.playerpoints.put(k.getUniqueId().toString(), Integer.valueOf(killerpoints));
  	      String message = main.color("&a&l+ &f20 points");
    	    IChatBaseComponent chatMessage = ChatSerializer.a("{\"text\":\"" + message + "\"}");
    	    PacketPlayOutChat packet = new PacketPlayOutChat(chatMessage, (byte)2);
    	    ((CraftPlayer) k).getHandle().playerConnection.sendPacket(packet);
  	      } else if (playerpoints == 0) {
  	    	killerroundpoints += 10;
  	    	roundpoints.put(k.getUniqueId().toString(), killerroundpoints);
  	        killerpoints += 10;
  	        k.sendMessage(String.valueOf(main.prefix) + main.color("&a&l+ &f10 points &afor killing " + playerr.getName()));
  	        main.playerpoints.put(k.getUniqueId().toString(), Integer.valueOf(killerpoints));
  	      String message = main.color("&a&l+ &f10 points");
    	    IChatBaseComponent chatMessage = ChatSerializer.a("{\"text\":\"" + message + "\"}");
    	    PacketPlayOutChat packet = new PacketPlayOutChat(chatMessage, (byte)2);
    	    ((CraftPlayer) k).getHandle().playerConnection.sendPacket(packet);
  	      } else if (playerpoints > 1000) {
  	    	playerroundpoints -= 100;
  	    	roundpoints.put(playerr.getUniqueId().toString(), playerroundpoints);
  	    	killerroundpoints += 100;
  	    	roundpoints.put(k.getUniqueId().toString(), killerroundpoints);
  	        playerpoints -= 100;
  	        playerr.sendMessage(String.valueOf(main.prefix) + main.color("&cYou Got Killed By &8" + k.getName() + main.color(" &cand &f100 points &chave been taken from ur account")));
  	        main.playerpoints.put(playerr.getUniqueId().toString(), Integer.valueOf(playerpoints));
  	        killerpoints += 100;
  	        k.sendMessage(String.valueOf(main.prefix) + main.color("&a&l+ &f100 points &afor killing" + playerr.getName()));
  	        main.playerpoints.put(k.getUniqueId().toString(), Integer.valueOf(killerpoints));
  	      String message = main.color("&a&l+ &f100 points");
    	    IChatBaseComponent chatMessage = ChatSerializer.a("{\"text\":\"" + message + "\"}");
    	    PacketPlayOutChat packet = new PacketPlayOutChat(chatMessage, (byte)2);
    	    ((CraftPlayer) k).getHandle().playerConnection.sendPacket(packet);
  	      }
  	      int killerroundtokens = roundtokens.getOrDefault(k.getUniqueId().toString(), 0);
  	      killerroundtokens += 4;
  	      roundtokens.put(k.getUniqueId().toString(), killerroundtokens);
  	      int killertokens = ((Integer)main.playertokens.getOrDefault(k.getUniqueId().toString(), Integer.valueOf(0))).intValue();
  	      killertokens += 4;
  	      main.playertokens.put(k.getUniqueId().toString(), Integer.valueOf(killertokens));
  	    } else {
  	    	playerr.setGameMode(GameMode.ADVENTURE);
    	    Bukkit.broadcastMessage(String.valueOf(main.prefix) + main.color("&9" + playerr.getName() + main.color(" &c&lELIMINATED!")));
  	    }
  	    }
  	    createBoardInGame(k);
  	  String message = main.color("&cYou Died!");
	    IChatBaseComponent chatMessage = ChatSerializer.a("{\"text\":\"" + message + "\"}");
	    PacketPlayOutChat packet = new PacketPlayOutChat(chatMessage, (byte)2);
	    ((CraftPlayer) playerr).getHandle().playerConnection.sendPacket(packet);
        Location specloc = new Location(Bukkit.getWorld("world"),-977.5,193,-1058.5);
        playerr.getInventory().clear();
  	  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
          public void run() {
        	    playerr.getInventory().setItem(4, new ItemStack(Material.COMPASS));
          	    playerr.teleport(specloc);
            } 
          },10L);
  	  if (k == null || k != null) {
  	    createBoardSpectator(playerr);
  	      playerr.setAllowFlight(true);
  	      for (Player player : Bukkit.getOnlinePlayers()) {
  	        if (player.getGameMode() == GameMode.SURVIVAL && player != playerr)
  	          player.hidePlayer(playerr); 
  	      } 
  	      for (Player player : Bukkit.getOnlinePlayers()) {
  	        if (player.getGameMode() == GameMode.ADVENTURE && player != playerr) {
  	          player.hidePlayer(playerr);
  	          playerr.hidePlayer(player);
  	        } 
  	      }
  	    
  	    int onlineSurvivalPlayers = 0;
  	    for (Player player : Bukkit.getOnlinePlayers()) {
  	      if (player.getGameMode() == GameMode.SURVIVAL)
  	        onlineSurvivalPlayers++; 
  	    } 
  	    if (onlineSurvivalPlayers == 4) {
  	      for (Player All : Bukkit.getOnlinePlayers())
  	        All.sendMessage(String.valueOf(main.prefix) + main.color("DeathMatch Starting in 60 seconds")); 
  	      GameStartEvent.DeathMatchCountDown();
  	    } 
  	    if (onlineSurvivalPlayers == 1)
  	      GameStartEvent.endGame(); 
  	  }
  	  }
	 
	  
	  public static void startGame() {
		  gameStarted = true;
	    for (Player All : Bukkit.getOnlinePlayers()) {
	      createBoardInGame(All);
	      int gameplayed = ((Integer)main.playergamesplayed.getOrDefault(All.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	      gameplayed += 1;
	      main.playergamesplayed.put(All.getUniqueId().toString(), Integer.valueOf(gameplayed));
	      All.getInventory().clear();
	      UUID uuid = All.getUniqueId();
	      int newXp = Math.max(0, 0);
	      playerXp.put(uuid, Integer.valueOf(newXp));
	      All.setLevel(newXp);	    
	    }
    }

	  public static void endGame() {
	    Player winner = null;
	    for (Player player : Bukkit.getOnlinePlayers()) {
	      if (player.getGameMode().equals(GameMode.SURVIVAL)) {
	        winner = player;
	        break;
	      }
	    }
	    winner.setGameMode(GameMode.ADVENTURE);
	    winner.getInventory().clear();
	    Bukkit.broadcastMessage(String.valueOf(main.prefix) + main.color("&9") + winner.getName() + main.color(" &ais the winner"));
	    int playerwinss = ((Integer)main.playerwins.getOrDefault(winner.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	    playerwinss++;
	    main.playerwins.put(winner.getUniqueId().toString(), Integer.valueOf(playerwinss));
	    int playerpoints = main.playerpoints.getOrDefault(winner.getUniqueId().toString(), 0);
	    playerpoints += 30;
	    main.playerpoints.put(winner.getUniqueId().toString(), playerpoints);
	    int playertokens = main.playertokens.getOrDefault(winner.getUniqueId().toString(), 0);
	    playertokens += 10;
	    main.playertokens.put(winner.getUniqueId().toString(), playertokens);
	    winner.sendMessage(main.prefix + main.color("&a&l+ &f30 points &aand &f10 tokens &afor winning a game"));
	    winner.playSound(winner.getLocation(), Sound.NOTE_PIANO, 10.0F, 10.0F);
	    Location location = new Location(Bukkit.getWorld("world"),-975.5,186.5,-1057.5);
        Block block = location.getBlock();
        block.setType(Material.AIR);
        Location location2 = new Location(Bukkit.getWorld("world"),-975.5,186.5,-1059.5);
        Block block2 = location2.getBlock();
        block2.setType(Material.AIR);
        Location location3 = new Location(Bukkit.getWorld("world"),-976.5,186.5,-1060.5);
        Block block3 = location3.getBlock();
        block3.setType(Material.AIR);
        Location location4 = new Location(Bukkit.getWorld("world"),-975.5,186.5,-1057.5);
        Block block4 = location4.getBlock();
        block4.setType(Material.AIR);
        Location location5 = new Location(Bukkit.getWorld("world"),-978.5,186.5,-1060.5);
        Block block5 = location5.getBlock();
        block5.setType(Material.AIR);
        Location location6 = new Location(Bukkit.getWorld("world"),-979.5,186.5,-1059.5);
        Block block6 = location6.getBlock();
        block6.setType(Material.AIR);
        Location location7 = new Location(Bukkit.getWorld("world"),-979.5,186.5,-1057.5);
        Block block7 = location7.getBlock();
        block7.setType(Material.AIR);
        Location location8 = new Location(Bukkit.getWorld("world"),-978.5,186.5,-1056.5);
        Block block8 = location8.getBlock();
        block8.setType(Material.AIR);
        Location location9 = new Location(Bukkit.getWorld("world"),-976.5,186.5,-1056.5);
        Block block9 = location9.getBlock();
        block9.setType(Material.AIR);
        World world = Bukkit.getWorlds().get(0);
        for (org.bukkit.entity.Entity entity : world.getEntities()) {
            if (entity instanceof Item) {
                entity.remove();
            }
        }
	    for (Player All : Bukkit.getOnlinePlayers()) {
	      All.sendTitle(main.color("&9" + winner.getName()), main.color("&e&lWinner!"));
	    }
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	          public void run() {
	            for (Player all : Bukkit.getOnlinePlayers()) {
	              all.sendMessage(String.valueOf(main.prefix) + main.color("&cServer Shutting Down in 10 seconds."));
	            } 
	          }
	        },  80L);
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)main.plugin, new Runnable() {
	          public void run() {
	            for (Player all : Bukkit.getOnlinePlayers()) {
	              all.kickPlayer(main.color("&cGame End, Restarting Proxy"));
	              Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "restart");
	            } 
	          }
	        },280L);
	  }
	  
	  public static void createBoardSpectator(Player p) {
		  int onlineSurvivalPlayers = 0;
		    for (Player player : Bukkit.getOnlinePlayers()) {
		      if (player.getGameMode() == GameMode.SURVIVAL)
		        onlineSurvivalPlayers++; 
		    }
		    ScoreboardManager manager = Bukkit.getScoreboardManager();
		    Scoreboard board = manager.getNewScoreboard();
		    Objective obj = board.registerNewObjective("ScoreBoard", "dummy");
		    obj.setDisplayName(main.color("&aSurvival&bGames"));
		    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		    Score score14 = obj.getScore(main.color("&8&m----------------"));
		    score14.setScore(10);
		    Score score34 = obj.getScore(main.color("&1"));
		    score34.setScore(9);
		    Score score10 = obj.getScore(main.color("&cSpectator Mode!"));
		    score10.setScore(8);
		    Score score52 = obj.getScore(main.color("&9"));
		    score52.setScore(7);
		    Score score101 = obj.getScore(main.color("&aAlive Players"));
		    score101.setScore(6);
		    Score score51 = obj.getScore(main.color("  &f") + onlineSurvivalPlayers);
		    score51.setScore(5);
		    Score score5 = obj.getScore(main.color("&0"));
		    score5.setScore(4);
		    Score score13 = obj.getScore(main.color("&aGame Status"));
		    score13.setScore(3);
		    Score score12 = obj.getScore(main.color("  &fRunning."));
		    score12.setScore(2);
		    Score score11 = obj.getScore(main.color("&4"));
		    score11.setScore(1);
		    Score score4 = obj.getScore(main.color("&aplay.&fHevixMC.&aclub"));
		    score4.setScore(0);
		    p.setScoreboard(board);
	  }
	  
	  public static void createBoardInGame(Player p) {
		  int RoundPlayerKills = roundkills.getOrDefault(p.getUniqueId().toString(), 0);
		  int RoundPlayerPoints = roundpoints.getOrDefault(p.getUniqueId().toString(), 0);
		  int RoundPlayerTokens = roundtokens.getOrDefault(p.getUniqueId().toString(), 0);
		  int onlineSurvivalPlayers = 0;
		    for (Player player : Bukkit.getOnlinePlayers()) {
		      if (player.getGameMode() == GameMode.SURVIVAL)
		        onlineSurvivalPlayers++; 
		    }
		    ScoreboardManager manager = Bukkit.getScoreboardManager();
		    Scoreboard board = manager.getNewScoreboard();
		    Objective obj = board.registerNewObjective("ScoreBoardG", "dummy");
		    obj.setDisplayName(main.color("&aSurvival&bGames"));
		    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		    Score score14 = obj.getScore(main.color("&8&m----------------"));
		    score14.setScore(10);
		    Score score34 = obj.getScore(main.color("&1"));
		    score34.setScore(9);
		    Score score10 = obj.getScore(main.color("&aAlive Players"));
		    score10.setScore(8);
		    Score score52 = obj.getScore(main.color("  &f" + onlineSurvivalPlayers));
		    score52.setScore(7);
		    Score score101 = obj.getScore(main.color("&2"));
		    score101.setScore(6);
		    Score score51 = obj.getScore(main.color("&aRound Statistic"));
		    score51.setScore(5);
		    Score score5 = obj.getScore(main.color("  &7Kills&8» &f") + RoundPlayerKills);
		    score5.setScore(4);
		    Score score13 = obj.getScore(main.color("  &7Points&8» &f") + RoundPlayerPoints);
		    score13.setScore(3);
		    Score score12 = obj.getScore(main.color("  &7Tokens&8» &f") + RoundPlayerTokens);
		    score12.setScore(2);
		    Score score11 = obj.getScore(main.color("&4"));
		    score11.setScore(1);
		    Score score4 = obj.getScore(main.color("&aplay.&fHevixMC.&aclub"));
		    score4.setScore(0);
		    p.setScoreboard(board);
	  }
	  
	
}
