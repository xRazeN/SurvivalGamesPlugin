package com.rqzen.survival.games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.rqzen.commands.AddTokens;
import com.rqzen.commands.RanksCommand;
import com.rqzen.commands.StatsCommand;
import com.rqzen.events.Events;
import com.rqzen.events.ExitGame;
import com.rqzen.events.GameStartEvent;
import com.rqzen.events.ItemStacks;
import com.rqzen.events.MapVotes;
import com.rqzen.events.SpectatorCompass;
import com.rqzen.events.SurvivalGamesTab;

public class main extends JavaPlugin implements Listener{
	
	public static Map<String, Integer> playerpoints = new HashMap<>();
	  
	  public static Map<String, Integer> playerwins = new HashMap<>();
	  
	  public static Map<String, Integer> playergamesplayed = new HashMap<>();
	  
	  public static Map<String, Integer> playertokens = new HashMap<>();
	  
	  public static Map<String, Integer> playerkills = new HashMap<>();
	  
	  public static Map<String, Integer> SignPerk = new HashMap<>();
	  
	  public static Map<String, Integer> DeathPerk = new HashMap<>();
	  
	  public static Map<String, Integer> LightningPerk = new HashMap<>();
	  
	  public static Map<String, Integer> FlowersPerk = new HashMap<>();
	  
	  public static Map<String, Integer> TntPerk = new HashMap<>();

	  public static Map<String, Integer> HeartParticlesPerk = new HashMap<>();

	  public static Map<String, Integer> SmokeParticlesPerk = new HashMap<>();

	  
	  public static main plugin;
	  
	  
	  public static String color(String c) {
	    return ChatColor.translateAlternateColorCodes('&', c);
	  }
	  
	  public static String prefix = color("&7[&aSurvival&bGames&7] &f");
	  
	  public static String OneRank = color("&eBRONZE");
	  
	  public static String TwoRank = color("&6GOLD");
	  
	  public static String ThreeRank = color("&fIRON");
	  
	  public static String FourRank = color("&bDIAMOND");
	  
	  public static String FiveRank = color("&9CHAMPION");
	  
	  public static String SixRank = color("&1WARRIOR");
	  
	  public static String SevenRank = color("&2FIGHTER");
	  
	  public static String EightRank = color("&3PHENOMENAL");
	  
	  public static String NineRank = color("&4EXPERIENCE");
	  
	  public static String TenRank = color("&5GOAT");
	  
	  public static String ElevenRank = color("&cSALVATORE");
	  
	  
	  public void onEnable() {
	    Bukkit.getPluginManager().registerEvents((Listener)new GameStartEvent(), (Plugin)this);
	    Bukkit.getPluginManager().registerEvents((Listener)new Events(), (Plugin)this);
	    Bukkit.getPluginManager().registerEvents((Listener)new MapVotes(), (Plugin)this);
	    Bukkit.getPluginManager().registerEvents((Listener)new ExitGame(), (Plugin)this);
	    Bukkit.getPluginManager().registerEvents((Listener)new SpectatorCompass(), (Plugin)this);
	    Bukkit.getPluginManager().registerEvents(new SurvivalGamesTab(), this);
	    getCommand("stats").setExecutor((CommandExecutor)new StatsCommand());
	    getCommand("ranks").setExecutor((CommandExecutor)new RanksCommand());
	    getCommand("addtokens").setExecutor(new AddTokens());
        World world = Bukkit.getWorlds().get(0);
        world.setDifficulty(Difficulty.PEACEFUL);   
        world.setTime(10);
        plugin = this;
	    getConfig().options().copyDefaults(true);
	    saveDefaultConfig();
	    saveConfig();
	    getServer().getPluginManager().registerEvents(this, this);
	    if (getConfig().contains("data")) {
	      restorePoints();
	      getConfig().set("data", null);
	      saveConfig();
	    }
	    if (getConfig().contains("winsdata")) {
	      restoreWins();
	      getConfig().set("winsdata", null);
	      saveConfig();
	    } 
	    if (getConfig().contains("playergameplaydata")) {
	      restoregameplayed();
	      getConfig().set("playergameplaydata", null);
	      saveConfig();
	    } 
	    if (getConfig().contains("playertokensdata")) {
	      restoretokens();
	      getConfig().set("playertokensdata", null);
	      saveConfig();
	    }
	    if (getConfig().contains("SignPerk")) {
	    	restoreSignPerk();
	    	getConfig().set("SignPerk", null);
	    	saveConfig();
	    }
	    if (getConfig().contains("ChestDeathPerk")) {
	    	restoreChestDeathPerk();
	    	getConfig().set("ChestDeathPerk", null);
	    	saveConfig();
	    }
	    if (getConfig().contains("LightningPerk")) {
	    	restoreLightningPerk();
	    	getConfig().set("LightningPerk", null);
	    	saveConfig();
	    }
	    if (getConfig().contains("FlowerPerk")) {
	    	restoreFlowersPerk();
	    	getConfig().set("FlowerPerk", null);
	    	saveConfig();
	    }
	    if (getConfig().contains("TntPerk")) {
	    	restoreTntPerk();
	    	getConfig().set("TntPerk", null);
	    	saveConfig();
	    }
	    if (getConfig().contains("HeartParticlePerk")) {
	    	restoreHeartParticlePerk();
	    	getConfig().set("HeartParticlePerk", null);
	    	saveConfig();
	    }
	    if (getConfig().contains("SmokeParticlePerk")) {
	    	restoreSmokeParticlePerk();
	    	getConfig().set("SmokeParticlePerk", null);
	    	saveConfig();
	    }
	    if (getConfig().contains("PlayerKills")) {
	    	restoreKills();
	    	getConfig().set("PlayerKills", null);
	    	saveConfig();
	    }
	  }
	  
	  public void onDisable() {
		  getConfig().set("signList", signList);
		  getConfig().set("ChestDeathList", ChestDeathList);
		  getConfig().set("LightningList", LightningList);
		  getConfig().set("FlowersList", FlowersList);
		  getConfig().set("TntList", TntList);
		  getConfig().set("HeartParticleList", HeartParticleList);
		  getConfig().set("SmokeParticleList", SmokeParticleList);

		  saveConfig();
	    if (!playerpoints.isEmpty())
	      savePoints(); 
	    if (!playerwins.isEmpty())
	      saveWins(); 
	    if (!playergamesplayed.isEmpty())
	      savegameplayed(); 
	    if (!playertokens.isEmpty())
	      savetokens(); 
	    if (!SignPerk.isEmpty()) {
	    	saveSignPerk();
	    }
	    if (!DeathPerk.isEmpty()) {
	    	saveChestDeathPerk();
	    }
	    if (!LightningPerk.isEmpty()) {
	    	saveLightningPerk();
	    }
	    if (!FlowersPerk.isEmpty()) {
	    	saveFlowersPerk();
	    }
	    if (!TntPerk.isEmpty()) {
	    	saveTntPerk();
	    }
	    if (!HeartParticlesPerk.isEmpty()) {
	    	saveHeartParticlePerk();
	    }
	    if (!SmokeParticlesPerk.isEmpty()) {
	    	saveSmokeParticlePerk();
	    }
	    if (!playerkills.isEmpty()) {
	    	saveKills();
	    }
	  }
	  
	  public void savePoints() {
	    for (Map.Entry<String, Integer> entry : playerpoints.entrySet())
	      getConfig().set("data." + (String)entry.getKey(), entry.getValue()); 
	    saveConfig();
	  }
	  
	  public void restorePoints() {
	    ConfigurationSection dataSection = getConfig().getConfigurationSection("data");
	    if (dataSection == null)
	      return; 
	    Set<String> keys = dataSection.getKeys(false);
	    for (String key : keys) {
	      int points = getConfig().getInt("data." + key, 0);
	      playerpoints.put(key, Integer.valueOf(points));
	    } 
	  }
	  
	  public void saveWins() {
	    for (Map.Entry<String, Integer> entry : playerwins.entrySet())
	      getConfig().set("winsdata." + (String)entry.getKey(), entry.getValue()); 
	    saveConfig();
	  }
	  
	  public void restoreWins() {
	    ConfigurationSection dataSection = getConfig().getConfigurationSection("winsdata");
	    if (dataSection == null)
	      return; 
	    Set<String> keys = dataSection.getKeys(false);
	    for (String key : keys) {
	      int wins = getConfig().getInt("winsdata." + key, 0);
	      playerwins.put(key, Integer.valueOf(wins));
	    } 
	  }
	  
	  public void savegameplayed() {
	    for (Map.Entry<String, Integer> entry : playergamesplayed.entrySet())
	      getConfig().set("playergameplaydata." + (String)entry.getKey(), entry.getValue()); 
	    saveConfig();
	  }
	  
	  public void restoregameplayed() {
	    ConfigurationSection dataSection = getConfig().getConfigurationSection("playergameplaydata");
	    if (dataSection == null)
	      return; 
	    Set<String> keys = dataSection.getKeys(false);
	    for (String key : keys) {
	      int gameplayed = getConfig().getInt("playergameplaydata." + key, 0);
	      playergamesplayed.put(key, Integer.valueOf(gameplayed));
	    } 
	  }
	  
	  public void savetokens() {
	    for (Map.Entry<String, Integer> entry : playertokens.entrySet())
	      getConfig().set("playertokensdata." + (String)entry.getKey(), entry.getValue()); 
	    saveConfig();
	  }
	  
	  public void restoretokens() {
	    ConfigurationSection dataSection = getConfig().getConfigurationSection("playertokensdata");
	    if (dataSection == null)
	      return; 
	    Set<String> keys = dataSection.getKeys(false);
	    for (String key : keys) {
	      int playertokenss = getConfig().getInt("playertokensdata." + key, 0);
	      playertokens.put(key, Integer.valueOf(playertokenss));
	    } 
	  }
	  
	  public void saveSignPerk() {
		    for (Map.Entry<String, Integer> entry : SignPerk.entrySet())
		      getConfig().set("SignPerk." + (String)entry.getKey(), entry.getValue()); 
		    saveConfig();
		  }
		  
		  public void restoreSignPerk() {
		    ConfigurationSection dataSection = getConfig().getConfigurationSection("SignPerk");
		    if (dataSection == null)
		      return; 
		    Set<String> keys = dataSection.getKeys(false);
		    for (String key : keys) {
		      int SignPerkk = getConfig().getInt("SignPerk." + key, 0);
		      SignPerk.put(key, Integer.valueOf(SignPerkk));
		    } 
		  }
		  public void saveChestDeathPerk() {
			    for (Map.Entry<String, Integer> entry : DeathPerk.entrySet())
			      getConfig().set("ChestDeathPerk." + (String)entry.getKey(), entry.getValue()); 
			    saveConfig();
			  }
			  
			  public void restoreChestDeathPerk() {
			    ConfigurationSection dataSection = getConfig().getConfigurationSection("ChestDeathPerk");
			    if (dataSection == null)
			      return; 
			    Set<String> keys = dataSection.getKeys(false);
			    for (String key : keys) {
			      int DeathPerkk = getConfig().getInt("ChestDeathPerk." + key, 0);
			      DeathPerk.put(key, Integer.valueOf(DeathPerkk));
			    } 
			  }
			  
			  public void saveLightningPerk() {
				    for (Map.Entry<String, Integer> entry : LightningPerk.entrySet())
				      getConfig().set("LightningPerk." + (String)entry.getKey(), entry.getValue()); 
				    saveConfig();
				  }
				  
				  public void restoreLightningPerk() {
				    ConfigurationSection dataSection = getConfig().getConfigurationSection("LightningPerk");
				    if (dataSection == null)
				      return; 
				    Set<String> keys = dataSection.getKeys(false);
				    for (String key : keys) {
				      int LightningPerkk = getConfig().getInt("LightningPerk." + key, 0);
				      LightningPerk.put(key, Integer.valueOf(LightningPerkk));
				    } 
				  }
				  
				  public void saveFlowersPerk() {
					    for (Map.Entry<String, Integer> entry : FlowersPerk.entrySet())
					      getConfig().set("FlowerPerk." + (String)entry.getKey(), entry.getValue()); 
					    saveConfig();
					  }
					  
					  public void restoreFlowersPerk() {
					    ConfigurationSection dataSection = getConfig().getConfigurationSection("FlowerPerk");
					    if (dataSection == null)
					      return; 
					    Set<String> keys = dataSection.getKeys(false);
					    for (String key : keys) {
					      int FlowerPerk = getConfig().getInt("FlowerPerk." + key, 0);
					      FlowersPerk.put(key, Integer.valueOf(FlowerPerk));
					    } 
					  }
					  
					  public void saveTntPerk() {
						    for (Map.Entry<String, Integer> entry : TntPerk.entrySet())
						      getConfig().set("TntPerk." + (String)entry.getKey(), entry.getValue()); 
						    saveConfig();
						  }
						  
						  public void restoreTntPerk() {
						    ConfigurationSection dataSection = getConfig().getConfigurationSection("TntPerk");
						    if (dataSection == null)
						      return; 
						    Set<String> keys = dataSection.getKeys(false);
						    for (String key : keys) {
						      int TntPerkk = getConfig().getInt("TntPerk." + key, 0);
						      TntPerk.put(key, Integer.valueOf(TntPerkk));
						    } 
						  }
						  
						  public void saveHeartParticlePerk() {
							    for (Map.Entry<String, Integer> entry : HeartParticlesPerk.entrySet())
							      getConfig().set("HeartParticlePerk." + (String)entry.getKey(), entry.getValue()); 
							    saveConfig();
							  }
							  
							  public void restoreHeartParticlePerk() {
							    ConfigurationSection dataSection = getConfig().getConfigurationSection("HeartParticlePerk");
							    if (dataSection == null)
							      return; 
							    Set<String> keys = dataSection.getKeys(false);
							    for (String key : keys) {
							      int HeartParticlePerkk = getConfig().getInt("HeartParticlePerk." + key, 0);
							      HeartParticlesPerk.put(key, Integer.valueOf(HeartParticlePerkk));
							    } 
							  }
							  
							  public void saveSmokeParticlePerk() {
								    for (Map.Entry<String, Integer> entry : SmokeParticlesPerk.entrySet())
								      getConfig().set("SmokeParticlePerk." + (String)entry.getKey(), entry.getValue()); 
								    saveConfig();
								  }
								  
								  public void restoreSmokeParticlePerk() {
								    ConfigurationSection dataSection = getConfig().getConfigurationSection("SmokeParticlePerk");
								    if (dataSection == null)
								      return; 
								    Set<String> keys = dataSection.getKeys(false);
								    for (String key : keys) {
								      int SmokeParticlePerkk = getConfig().getInt("SmokeParticlePerk." + key, 0);
								      SmokeParticlesPerk.put(key, Integer.valueOf(SmokeParticlePerkk));
								    } 
								  }
				  
				  public void saveKills() {
					    for (Map.Entry<String, Integer> entry : playerkills.entrySet())
					      getConfig().set("PlayerKills." + (String)entry.getKey(), entry.getValue()); 
					    saveConfig();
					  }
					  
					  public void restoreKills() {
					    ConfigurationSection dataSection = getConfig().getConfigurationSection("PlayerKills");
					    if (dataSection == null)
					      return; 
					    Set<String> keys = dataSection.getKeys(false);
					    for (String key : keys) {
					      int playerkillss = getConfig().getInt("PlayerKills." + key, 0);
					      playerkills.put(key, Integer.valueOf(playerkillss));
					    } 
					  }
	  
	  public static void createBoard(Player p) {
	    int CurrentPoints = ((Integer)playerpoints.getOrDefault(p.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	    int CurrentWins = ((Integer)playerwins.getOrDefault(p.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	    int CurrentGamesPlayed = ((Integer)playergamesplayed.getOrDefault(p.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	    int CurrentKills = playerkills.getOrDefault(p.getUniqueId().toString(), 0);
	    ScoreboardManager manager = Bukkit.getScoreboardManager();
	    Scoreboard board = manager.getNewScoreboard();
	    Objective obj = board.registerNewObjective("RqzenScoreBoard", "dummy");
	    obj.setDisplayName(main.color("&aSurvival&bGames"));
	    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	    Score score14 = obj.getScore(main.color("&8&m----------------"));
	    score14.setScore(11);
	    Score score99 = obj.getScore(main.color("&2"));
	    score99.setScore(10);
	    Score score13 = obj.getScore(main.color("&cRank"));
	    score13.setScore(9);
	    if (CurrentKills >= 100) {
	    Score score12 = obj.getScore(main.color("  ") + OneRank);
	    score12.setScore(8);
	    } else if (CurrentKills >= 300) {
	    Score score12 = obj.getScore(main.color("  ") + TwoRank);
		score12.setScore(8);
	    } else if (CurrentKills >= 500) {
		Score score12 = obj.getScore(main.color("  ") + ThreeRank);
		score12.setScore(8);
		} else if (CurrentKills >= 700) {
		Score score12 = obj.getScore(main.color("  ") + FourRank);
		score12.setScore(8);
		} else if (CurrentKills >= 900) {
		Score score12 = obj.getScore(main.color("  ") + FiveRank);
		score12.setScore(8);
		} else if (CurrentKills >= 1100) {
		Score score12 = obj.getScore(main.color("  ") + SixRank);
		score12.setScore(8);
		} else if (CurrentKills >= 1300) {
		Score score12 = obj.getScore(main.color("  ") + SevenRank);
		score12.setScore(8);
		} else if (CurrentKills >= 1500) {
		Score score12 = obj.getScore(main.color("  ") + EightRank);
		score12.setScore(8);
		} else if (CurrentKills >= 1700) {
		Score score12 = obj.getScore(main.color("  ") + NineRank);
		score12.setScore(8);
		} else if (CurrentKills >= 2500) {
		Score score12 = obj.getScore(main.color("  ") + TenRank);
		score12.setScore(8);
		} else if (CurrentKills >= 3000) {
		Score score12 = obj.getScore(main.color("  ") + ElevenRank);
		score12.setScore(8);
		} else {
		Score score12 = obj.getScore(main.color("  &fUnRanked"));
		score12.setScore(8);
		}
	    Score score11 = obj.getScore(main.color("&8"));
	    score11.setScore(7);
	    Score score10 = obj.getScore(main.color("&bStatistic"));
	    score10.setScore(6);
	    Score score9 = obj.getScore(main.color("  &7Kills&8» &f") + CurrentKills);
	    score9.setScore(4);
	    Score score8 = obj.getScore(main.color("  &7Points&8» &f") + CurrentPoints);
	    score8.setScore(5);
	    Score score7 = obj.getScore(main.color("  &7Victories&8» &f") + CurrentWins);
	    score7.setScore(3);
	    Score score6 = obj.getScore(main.color("  &7GamesPlayed&8» &f") + CurrentGamesPlayed);
	    score6.setScore(2);
	    Score score5 = obj.getScore(main.color("&f"));
	    score5.setScore(1);
	    Score score4 = obj.getScore(main.color("&aplay.&fHevixMC.&aclub"));
	    score4.setScore(0);
	    p.setScoreboard(board);
	  }
	
	
	    public static List<String> signList = new ArrayList<String>();
	    public static  List<String> ChestDeathList = new ArrayList<String>();
	    public static List<String> LightningList = new ArrayList<String>();
	    public static List<String> FlowersList = new ArrayList<String>();
	    public static List<String> TntList = new ArrayList<String>();
	    public static List<String> HeartParticleList = new ArrayList<String>();
	    public static List<String> SmokeParticleList = new ArrayList<String>();


	    
	    public static void SurvivalGamesPerks(Player p) {
  		    String playerName = p.getName();
		    Inventory SGPerks = Bukkit.createInventory((InventoryHolder)p, 27, ChatColor.GREEN + "Perks");
		    SGPerks.setItem(26, ItemStacks.ResetPerks());
		    if (SignPerk.containsKey(p.getUniqueId().toString())) {
		    	if (signList.contains(playerName)) {
		    		SGPerks.setItem(11, ItemStacks.SelectedSignPerk());
		    	} else {
		    		SGPerks.setItem(11, ItemStacks.BoughtSignPerk());
		    	}
		    }
		    if (DeathPerk.containsKey(p.getUniqueId().toString())) {
		    	if (ChestDeathList.contains(playerName)) {
		    		SGPerks.setItem(10, ItemStacks.SelectedDeathPerk());
		    	} else {
		    		SGPerks.setItem(10, ItemStacks.BoughtDeathPerk());
		    	}
		    }
		    if (LightningPerk.containsKey(p.getUniqueId().toString())) {
		    	if (LightningList.contains(playerName)) {
		    		SGPerks.setItem(12, ItemStacks.SelectedLightningPerk());
		    	} else {
		    		SGPerks.setItem(12, ItemStacks.BoughtLightningPerk());
		    	}
		    }
		    if (FlowersPerk.containsKey(p.getUniqueId().toString())) {
		    	if (FlowersList.contains(playerName)) {
		    		SGPerks.setItem(13, ItemStacks.SelectedFlowersPerk());
		    	} else {
		    		SGPerks.setItem(13, ItemStacks.BoughtFlowersPerk());
		    	}
		    }
		    if (TntPerk.containsKey(p.getUniqueId().toString())) {
		    	if (TntList.contains(playerName)) {
		    		SGPerks.setItem(14, ItemStacks.SelectedTntPerk());
		    	} else {
		    		SGPerks.setItem(14, ItemStacks.BoughtTntPerk());
		    	}
		    }
		    if (HeartParticlesPerk.containsKey(p.getUniqueId().toString())) {
		    	if (HeartParticleList.contains(playerName)) {
		    		SGPerks.setItem(15, ItemStacks.SelectedHeartParticlesPerk());
		    	} else {
		    		SGPerks.setItem(15, ItemStacks.BoughtHeartParticlesPerk());
		    	}
		    }
		    if (SmokeParticlesPerk.containsKey(p.getUniqueId().toString())) {
		    	if (SmokeParticleList.contains(playerName)) {
		    		SGPerks.setItem(16, ItemStacks.SelectedSmokeParticlePerk());
		    	} else {
		    		SGPerks.setItem(16, ItemStacks.BoughtSmokeParticlePerk());
		    	}
		    }
		    if (!SignPerk.containsKey(p.getUniqueId().toString())) {
		    		SGPerks.setItem(11, ItemStacks.SignPerk());
		    }
		    if (!DeathPerk.containsKey(p.getUniqueId().toString())) {
	    		SGPerks.setItem(10, ItemStacks.ChestDeathPerk());
		    }
		    if (!LightningPerk.containsKey(p.getUniqueId().toString())) {
		    	SGPerks.setItem(12, ItemStacks.LightningPerk());
		    }
		    if (!FlowersPerk.containsKey(p.getUniqueId().toString())) {
		    	SGPerks.setItem(13, ItemStacks.FlowersPerk());
		    }
		    if (!TntPerk.containsKey(p.getUniqueId().toString())) {
		    	SGPerks.setItem(14, ItemStacks.TntPerk());
		    }
		    if (!HeartParticlesPerk.containsKey(p.getUniqueId().toString())) {
		    	SGPerks.setItem(15, ItemStacks.HeartParticlesPerk());
		    }
		    if (!SmokeParticlesPerk.containsKey(p.getUniqueId().toString())) {
		    	SGPerks.setItem(16, ItemStacks.SmokeParticlePerk());
		    }
		    
		    p.openInventory(SGPerks);
		  }
		  
		  @EventHandler
		  public void onClickAtGUI1(InventoryClickEvent event) {
		    Player p = (Player)event.getWhoClicked();
		    ItemStack i = event.getCurrentItem();
		    Inventory inv = event.getInventory();
		    int playertokens = main.playertokens.getOrDefault(p.getUniqueId().toString(), 0);
		    if (inv.getName().equalsIgnoreCase(ChatColor.GREEN + "Perks")) {
		      event.setCancelled(true);
		      if (event.getCurrentItem().equals(ItemStacks.SignPerk()) && event.isShiftClick()) {
	                ItemStack stair = event.getCurrentItem();
	                ItemMeta stairMeta = stair.getItemMeta();
	                List<String> lore = stairMeta.getLore();

	                if (lore == null) {
	                    lore = new ArrayList<String>();
	                }
	                if (lore.contains(main.color("&8"))) {
	                    lore.remove(main.color("&8"));
	                } else {
	                    lore.add(main.color("&8"));
	                }
	                if (lore.contains(main.color("&6Info:"))) {
	                    lore.remove(main.color("&6Info:"));
	                } else {
	                    lore.add(main.color("&6Info:"));
	                }
	                if (lore.contains(main.color("  &f&l- &aThis perk is a perk that spawns"))) {
	                    lore.remove(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                } else {
	                    lore.add(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                }
	                if (lore.contains(main.color("  &aa &fsign&a with your name if"))) {
	                    lore.remove(main.color("  &aa &fsign&a with your name if"));
	                } else {
	                    lore.add(main.color("  &aa &fsign&a with your name if"));
	                }
	                if (lore.contains(main.color("  &ayou kill someone! &fRIP SIGN"))) {
	                    lore.remove(main.color("  &ayou kill someone! &fRIP SIGN"));
	                } else {
	                    lore.add(main.color("  &ayou kill someone! &fRIP SIGN"));
	                }
	                if (lore.contains(main.color("&2"))) {
	                    lore.remove(main.color("&2"));
	                } else {
	                    lore.add(main.color("&2"));
	                }
	                if (lore.contains(main.color("&7Exit Perk Inventory"))) {
	                    lore.remove(main.color("&7Exit Perk Inventory"));
	                } else {
	                    lore.add(main.color("&7Exit Perk Inventory"));
	                }
	                if (lore.contains(main.color("&fto hide info"))) {
	                    lore.remove(main.color("&fto hide info"));
	                } else {
	                    lore.add(main.color("&fto hide info"));
	                }

	                stairMeta.setLore(lore);
	                stair.setItemMeta(stairMeta);

	            } else if (event.getCurrentItem().equals(ItemStacks.ChestDeathPerk()) && event.isShiftClick()) {
	                ItemStack stair = event.getCurrentItem();
	                ItemMeta stairMeta = stair.getItemMeta();
	                List<String> lore = stairMeta.getLore();

	                if (lore == null) {
	                    lore = new ArrayList<String>();
	                }

	                if (lore.contains(main.color("&1"))) {
	                    lore.remove(main.color("&1"));
	                } else {
	                    lore.add(main.color("&1"));
	                }
	                if (lore.contains(main.color("&6Info:"))) {
	                    lore.remove(main.color("&6Info:"));
	                } else {
	                    lore.add(main.color("&6Info:"));
	                }
	                if (lore.contains(main.color("  &f&l- &aThis perk is a perk that spawns"))) {
	                    lore.remove(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                } else {
	                    lore.add(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                }
	                if (lore.contains(main.color("  &aa &fChest&a with your enemy's"))) {
	                    lore.remove(main.color("  &aa &fChest&a with your enemy's"));
	                } else {
	                    lore.add(main.color("  &aa &fChest&a with your enemy's"));
	                }
	                if (lore.contains(main.color("  &aitems, &fRELAX and LOOT!"))) {
	                    lore.remove(main.color("  &aitems, &fRELAX and LOOT!"));
	                } else {
	                    lore.add(main.color("  &aitems, &fRELAX and LOOT!"));
	                }
	                if (lore.contains(main.color("&3"))) {
	                    lore.remove(main.color("&3"));
	                } else {
	                    lore.add(main.color("&3"));
	                }
	                if (lore.contains(main.color("&7Exit Perk Inventory"))) {
	                    lore.remove(main.color("&7Exit Perk Inventory"));
	                } else {
	                    lore.add(main.color("&7Exit Perk Inventory"));
	                }
	                if (lore.contains(main.color("&fto hide info"))) {
	                    lore.remove(main.color("&fto hide info"));
	                } else {
	                    lore.add(main.color("&fto hide info"));
	                }

	                stairMeta.setLore(lore);
	                stair.setItemMeta(stairMeta);

	            } else if (event.getCurrentItem().equals(ItemStacks.LightningPerk()) && event.isShiftClick()) {
	                ItemStack stair = event.getCurrentItem();
	                ItemMeta stairMeta = stair.getItemMeta();
	                List<String> lore = stairMeta.getLore();

	                if (lore == null) {
	                    lore = new ArrayList<String>();
	                }

	                if (lore.contains(main.color("&2"))) {
	                    lore.remove(main.color("&2"));
	                } else {
	                    lore.add(main.color("&2"));
	                }
	                if (lore.contains(main.color("&6Info:"))) {
	                    lore.remove(main.color("&6Info:"));
	                } else {
	                    lore.add(main.color("&6Info:"));
	                }
	                if (lore.contains(main.color("  &f&l- &aThis perk is a perk that spawns"))) {
	                    lore.remove(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                } else {
	                    lore.add(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                }
	                if (lore.contains(main.color("  &aa &fLightning&a when you kill"))) {
	                    lore.remove(main.color("  &aa &fLightning&a when you kill"));
	                } else {
	                    lore.add(main.color("  &aa &fLightning&a when you kill"));
	                }
	                if (lore.contains(main.color("  &asomeone, &fENJOY IT"))) {
	                    lore.remove((main.color("  &asomeone, &fENJOY IT")));
	                } else {
	                    lore.add((main.color("  &asomeone, &fENJOY IT")));
	                }
	                if (lore.contains(main.color("&1"))) {
	                    lore.remove(main.color("&1"));
	                } else {
	                    lore.add(main.color("&1"));
	                }
	                if (lore.contains(main.color("&7Exit Perk Inventory"))) {
	                    lore.remove(main.color("&7Exit Perk Inventory"));
	                } else {
	                    lore.add(main.color("&7Exit Perk Inventory"));
	                }
	                if (lore.contains(main.color("&fto hide info"))) {
	                    lore.remove(main.color("&fto hide info"));
	                } else {
	                    lore.add(main.color("&fto hide info"));
	                }

	                stairMeta.setLore(lore);
	                stair.setItemMeta(stairMeta);

	            }  else if (event.getCurrentItem().equals(ItemStacks.FlowersPerk()) && event.isShiftClick()) {
	                ItemStack stair = event.getCurrentItem();
	                ItemMeta stairMeta = stair.getItemMeta();
	                List<String> lore = stairMeta.getLore();

	                if (lore == null) {
	                    lore = new ArrayList<String>();
	                }

	                if (lore.contains(main.color("&2"))) {
	                    lore.remove(main.color("&2"));
	                } else {
	                    lore.add(main.color("&2"));
	                }
	                if (lore.contains(main.color("&6Info:"))) {
	                    lore.remove(main.color("&6Info:"));
	                } else {
	                    lore.add(main.color("&6Info:"));
	                }
	                if (lore.contains(main.color("  &f&l- &aThis perk is a perk that spawns"))) {
	                    lore.remove(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                } else {
	                    lore.add(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                }
	                if (lore.contains(main.color("  &fFlowers&a when you kill"))) {
	                    lore.remove(main.color("  &fFlowers&a when you kill"));
	                } else {
	                    lore.add(main.color("  &fFlowers&a when you kill"));
	                }
	                if (lore.contains(main.color("  &asomeone, &fENJOY IT"))) {
	                    lore.remove((main.color("  &asomeone, &fENJOY IT")));
	                } else {
	                    lore.add((main.color("  &asomeone, &fENJOY IT")));
	                }
	                if (lore.contains(main.color("&8"))) {
	                    lore.remove(main.color("&8"));
	                } else {
	                    lore.add(main.color("&8"));
	                }
	                if (lore.contains(main.color("&7Exit Perk Inventory"))) {
	                    lore.remove(main.color("&7Exit Perk Inventory"));
	                } else {
	                    lore.add(main.color("&7Exit Perk Inventory"));
	                }
	                if (lore.contains(main.color("&fto hide info"))) {
	                    lore.remove(main.color("&fto hide info"));
	                } else {
	                    lore.add(main.color("&fto hide info"));
	                }

	                stairMeta.setLore(lore);
	                stair.setItemMeta(stairMeta);

	            }  else if (event.getCurrentItem().equals(ItemStacks.TntPerk()) && event.isShiftClick()) {
	                ItemStack stair = event.getCurrentItem();
	                ItemMeta stairMeta = stair.getItemMeta();
	                List<String> lore = stairMeta.getLore();

	                if (lore == null) {
	                    lore = new ArrayList<String>();
	                }

	                if (lore.contains(main.color("&2"))) {
	                    lore.remove(main.color("&2"));
	                } else {
	                    lore.add(main.color("&2"));
	                }
	                if (lore.contains(main.color("&6Info:"))) {
	                    lore.remove(main.color("&6Info:"));
	                } else {
	                    lore.add(main.color("&6Info:"));
	                }
	                if (lore.contains(main.color("  &f&l- &aThis perk is a perk that spawns"))) {
	                    lore.remove(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                } else {
	                    lore.add(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                }
	                if (lore.contains(main.color("  &aa &fTnt&a when you kill"))) {
	                    lore.remove(main.color("  &aa &fTnt&a when you kill"));
	                } else {
	                    lore.add(main.color("  &aa &fTnt&a when you kill"));
	                }
	                if (lore.contains(main.color("  &asomeone, &fENJOY IT"))) {
	                    lore.remove((main.color("  &asomeone, &fENJOY IT")));
	                } else {
	                    lore.add((main.color("  &asomeone, &fENJOY IT")));
	                }
	                if (lore.contains(main.color("&3"))) {
	                    lore.remove(main.color("&3"));
	                } else {
	                    lore.add(main.color("&3"));
	                }
	                if (lore.contains(main.color("&7Exit Perk Inventory"))) {
	                    lore.remove(main.color("&7Exit Perk Inventory"));
	                } else {
	                    lore.add(main.color("&7Exit Perk Inventory"));
	                }
	                if (lore.contains(main.color("&fto hide info"))) {
	                    lore.remove(main.color("&fto hide info"));
	                } else {
	                    lore.add(main.color("&fto hide info"));
	                }

	                stairMeta.setLore(lore);
	                stair.setItemMeta(stairMeta);

	            }  else if (event.getCurrentItem().equals(ItemStacks.HeartParticlesPerk()) && event.isShiftClick()) {
	                ItemStack stair = event.getCurrentItem();
	                ItemMeta stairMeta = stair.getItemMeta();
	                List<String> lore = stairMeta.getLore();

	                if (lore == null) {
	                    lore = new ArrayList<String>();
	                }

	                if (lore.contains(main.color("&2"))) {
	                    lore.remove(main.color("&2"));
	                } else {
	                    lore.add(main.color("&2"));
	                }
	                if (lore.contains(main.color("&6Info:"))) {
	                    lore.remove(main.color("&6Info:"));
	                } else {
	                    lore.add(main.color("&6Info:"));
	                }
	                if (lore.contains(main.color("  &f&l- &aThis perk is a perk that spawns"))) {
	                    lore.remove(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                } else {
	                    lore.add(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                }
	                if (lore.contains(main.color("  &aa &fHeart Particle&a when you kill"))) {
	                    lore.remove(main.color("  &aa &fHeart Particle&a when you kill"));
	                } else {
	                    lore.add(main.color("  &aa &fHeart Particle&a when you kill"));
	                }
	                if (lore.contains(main.color("  &asomeone, &fENJOY IT"))) {
	                    lore.remove((main.color("  &asomeone, &fENJOY IT")));
	                } else {
	                    lore.add((main.color("  &asomeone, &fENJOY IT")));
	                }
	                if (lore.contains(main.color("&4"))) {
	                    lore.remove(main.color("&4"));
	                } else {
	                    lore.add(main.color("&4"));
	                }
	                if (lore.contains(main.color("&7Exit Perk Inventory"))) {
	                    lore.remove(main.color("&7Exit Perk Inventory"));
	                } else {
	                    lore.add(main.color("&7Exit Perk Inventory"));
	                }
	                if (lore.contains(main.color("&fto hide info"))) {
	                    lore.remove(main.color("&fto hide info"));
	                } else {
	                    lore.add(main.color("&fto hide info"));
	                }

	                stairMeta.setLore(lore);
	                stair.setItemMeta(stairMeta);

	            }  else if (event.getCurrentItem().equals(ItemStacks.SmokeParticlePerk()) && event.isShiftClick()) {
	                ItemStack stair = event.getCurrentItem();
	                ItemMeta stairMeta = stair.getItemMeta();
	                List<String> lore = stairMeta.getLore();

	                if (lore == null) {
	                    lore = new ArrayList<String>();
	                }

	                if (lore.contains(main.color("&2"))) {
	                    lore.remove(main.color("&2"));
	                } else {
	                    lore.add(main.color("&2"));
	                }
	                if (lore.contains(main.color("&6Info:"))) {
	                    lore.remove(main.color("&6Info:"));
	                } else {
	                    lore.add(main.color("&6Info:"));
	                }
	                if (lore.contains(main.color("  &f&l- &aThis perk is a perk that spawns"))) {
	                    lore.remove(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                } else {
	                    lore.add(main.color("  &f&l- &aThis perk is a perk that spawns"));
	                }
	                if (lore.contains(main.color("  &aa &fSmoke Particle&a when you kill"))) {
	                    lore.remove(main.color("  &aa &fSmoke Particle&a when you kill"));
	                } else {
	                    lore.add(main.color("  &aa &fSmoke Particle&a when you kill"));
	                }
	                if (lore.contains(main.color("  &asomeone, &fENJOY IT"))) {
	                    lore.remove((main.color("  &asomeone, &fENJOY IT")));
	                } else {
	                    lore.add((main.color("  &asomeone, &fENJOY IT")));
	                }
	                if (lore.contains(main.color("&0"))) {
	                    lore.remove(main.color("&0"));
	                } else {
	                    lore.add(main.color("&0"));
	                }
	                if (lore.contains(main.color("&7Exit Perk Inventory"))) {
	                    lore.remove(main.color("&7Exit Perk Inventory"));
	                } else {
	                    lore.add(main.color("&7Exit Perk Inventory"));
	                }
	                if (lore.contains(main.color("&fto hide info"))) {
	                    lore.remove(main.color("&fto hide info"));
	                } else {
	                    lore.add(main.color("&fto hide info"));
	                }

	                stairMeta.setLore(lore);
	                stair.setItemMeta(stairMeta);

	            }
		      
		      if (i.equals(ItemStacks.SignPerk())) {
		    	  if (playertokens >= 440) {
		    		  playertokens -= 440;
		    		  main.playertokens.put(p.getUniqueId().toString(), playertokens);
		    		  p.sendMessage(main.prefix + main.color("&aSuccessfully Bought This Perk."));
		    		  String playerName = p.getName();
			          signList.add(playerName);
			          int signperkhashmap = main.SignPerk.getOrDefault(p.getUniqueId().toString(), 0);
			          signperkhashmap ++;
			          main.SignPerk.put(p.getUniqueId().toString(), signperkhashmap);
			          if (ChestDeathList.contains(playerName)) {
			        	  ChestDeathList.remove(playerName);
			          }
			          if (LightningList.contains(playerName)) {
		    			   LightningList.remove(playerName);
		    		   }
			          if (FlowersList.contains(playerName)) {
			        	  FlowersList.remove(playerName);
			          }
			          if (TntList.contains(playerName)) {
			        	  TntList.remove(playerName);
			          }
			          if (HeartParticleList.contains(playerName)) {
			        	  HeartParticleList.remove(playerName);
			          }
			          if (SmokeParticleList.contains(playerName)) {
			        	  SmokeParticleList.remove(playerName);
			          }
		    	  } else {
		    		  p.sendMessage(main.prefix + main.color("&cYou Dont Have Enough Tokens To Buy This Perk."));
		    		  p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.f, 10.f);
		    	  }
		    	  }
		    	  
		       if (i.equals(ItemStacks.ChestDeathPerk())) {
		    	   if (playertokens >= 300) {
		    		   playertokens -= 300;
		    		   main.playertokens.put(p.getUniqueId().toString(), playertokens);
		    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Bought This Perk."));
		    		   String playerName = p.getName();
		    		   ChestDeathList.add(playerName);
		    		   int deathperkhashmap = main.DeathPerk.getOrDefault(p.getUniqueId().toString(), 0);
				          deathperkhashmap ++;
				          main.DeathPerk.put(p.getUniqueId().toString(), deathperkhashmap);
				          if (signList.contains(playerName)) {
				        	  signList.remove(playerName);
				          }
				          if (LightningList.contains(playerName)) {
			    			   LightningList.remove(playerName);
			    		   }
				          if (FlowersList.contains(playerName)) {
				        	  FlowersList.remove(playerName);
				          }
				          if (TntList.contains(playerName)) {
				        	  TntList.remove(playerName);
				          }
				          if (HeartParticleList.contains(playerName)) {
				        	  HeartParticleList.remove(playerName);
				          }
				          if (SmokeParticleList.contains(playerName)) {
				        	  SmokeParticleList.remove(playerName);
				          }
		    	   } else {
			    		  p.sendMessage(main.prefix + main.color("&cYou Dont Have Enough Tokens To Buy This Perk."));
			    		  p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.f, 10.f);
			    	  }
		       }
		       if (i.equals(ItemStacks.LightningPerk())) {
		    	   if (playertokens >= 155) {
		    		   playertokens -= 155;
		    		   main.playertokens.put(p.getUniqueId().toString(), playertokens);
		    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Bought This Perk."));
		    		   String playerName = p.getName();
		    		   LightningList.add(playerName);
		    		   int LightningPerk = main.LightningPerk.getOrDefault(p.getUniqueId().toString(), 0);
				          LightningPerk ++;
				          main.LightningPerk.put(p.getUniqueId().toString(), LightningPerk);
				          if (ChestDeathList.contains(playerName)) {
				        	  ChestDeathList.remove(playerName);
				          }
				          if (signList.contains(playerName)) {
			    			   signList.remove(playerName);
			    		   }
				          if (FlowersList.contains(playerName)) {
				        	  FlowersList.remove(playerName);
				          }
				          if (TntList.contains(playerName)) {
				        	  TntList.remove(playerName);
				          }
				          if (HeartParticleList.contains(playerName)) {
				        	  HeartParticleList.remove(playerName);
				          }
				          if (SmokeParticleList.contains(playerName)) {
				        	  SmokeParticleList.remove(playerName);
				          }
		    	   } else {
			    		  p.sendMessage(main.prefix + main.color("&cYou Dont Have Enough Tokens To Buy This Perk."));
			    		  p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.f, 10.f);
			    	  }
		       }
		       if (i.equals(ItemStacks.FlowersPerk())) {
		    	   if (playertokens >= 230) {
		    		   playertokens -= 230;
		    		   main.playertokens.put(p.getUniqueId().toString(), playertokens);
		    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Bought This Perk."));
		    		   String playerName = p.getName();
		    		   FlowersList.add(playerName);
		    		   int FlowersPerk = main.FlowersPerk.getOrDefault(p.getUniqueId().toString(), 0);
				          FlowersPerk ++;
				          main.FlowersPerk.put(p.getUniqueId().toString(), FlowersPerk);
				          if (ChestDeathList.contains(playerName)) {
				        	  ChestDeathList.remove(playerName);
				          }
				          if (signList.contains(playerName)) {
			    			   signList.remove(playerName);
			    		   }
				          if (LightningList.contains(playerName)) {
				        	  LightningList.remove(playerName);
				          }
				          if (TntList.contains(playerName)) {
				        	  TntList.remove(playerName);
				          }
				          if (HeartParticleList.contains(playerName)) {
				        	  HeartParticleList.remove(playerName);
				          }
				          if (SmokeParticleList.contains(playerName)) {
				        	  SmokeParticleList.remove(playerName);
				          }
		    	   } else {
			    		  p.sendMessage(main.prefix + main.color("&cYou Dont Have Enough Tokens To Buy This Perk."));
			    		  p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.f, 10.f);
			    	  }
		       }
		       if (i.equals(ItemStacks.TntPerk())) {
		    	   if (playertokens >= 200) {
		    		   playertokens -= 200;
		    		   main.playertokens.put(p.getUniqueId().toString(), playertokens);
		    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Bought This Perk."));
		    		   String playerName = p.getName();
		    		   TntList.add(playerName);
		    		   int TntPerkk = main.TntPerk.getOrDefault(p.getUniqueId().toString(), 0);
				          TntPerkk ++;
				          main.TntPerk.put(p.getUniqueId().toString(), TntPerkk);
				          if (ChestDeathList.contains(playerName)) {
				        	  ChestDeathList.remove(playerName);
				          }
				          if (signList.contains(playerName)) {
			    			   signList.remove(playerName);
			    		   }
				          if (FlowersList.contains(playerName)) {
				        	  FlowersList.remove(playerName);
				          }
				          if (LightningList.contains(playerName)) {
				        	  LightningList.remove(playerName);
				          }
				          if (HeartParticleList.contains(playerName)) {
				        	  HeartParticleList.remove(playerName);
				          }
				          if (SmokeParticleList.contains(playerName)) {
				        	  SmokeParticleList.remove(playerName);
				          }
		    	   } else {
			    		  p.sendMessage(main.prefix + main.color("&cYou Dont Have Enough Tokens To Buy This Perk."));
			    		  p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.f, 10.f);
			    	  }
		       }
		       if (i.equals(ItemStacks.HeartParticlesPerk())) {
		    	   if (playertokens >= 355) {
		    		   playertokens -= 355;
		    		   main.playertokens.put(p.getUniqueId().toString(), playertokens);
		    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Bought This Perk."));
		    		   String playerName = p.getName();
		    		   HeartParticleList.add(playerName);
		    		   int HeartParticlePerk = main.HeartParticlesPerk.getOrDefault(p.getUniqueId().toString(), 0);
				          HeartParticlePerk ++;
				          main.HeartParticlesPerk.put(p.getUniqueId().toString(), HeartParticlePerk);
				          if (ChestDeathList.contains(playerName)) {
				        	  ChestDeathList.remove(playerName);
				          }
				          if (signList.contains(playerName)) {
			    			   signList.remove(playerName);
			    		   }
				          if (FlowersList.contains(playerName)) {
				        	  FlowersList.remove(playerName);
				          }
				          if (TntList.contains(playerName)) {
				        	  TntList.remove(playerName);
				          }
				          if (LightningList.contains(playerName)) {
				        	  LightningList.remove(playerName);
				          }
				          if (SmokeParticleList.contains(playerName)) {
				        	  SmokeParticleList.remove(playerName);
				          }
		    	   } else {
			    		  p.sendMessage(main.prefix + main.color("&cYou Dont Have Enough Tokens To Buy This Perk."));
			    		  p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.f, 10.f);
			    	  }
		       }
		       if (i.equals(ItemStacks.SmokeParticlePerk())) {
		    	   if (playertokens >= 155) {
		    		   playertokens -= 155;
		    		   main.playertokens.put(p.getUniqueId().toString(), playertokens);
		    		   p.sendMessage(main.prefix + main.color("&aSuccessfully Bought This Perk."));
		    		   String playerName = p.getName();
		    		   SmokeParticleList.add(playerName);
		    		   int SmokeParticlePerk = main.SmokeParticlesPerk.getOrDefault(p.getUniqueId().toString(), 0);
				          SmokeParticlePerk ++;
				          main.SmokeParticlesPerk.put(p.getUniqueId().toString(), SmokeParticlePerk);
				          if (ChestDeathList.contains(playerName)) {
				        	  ChestDeathList.remove(playerName);
				          }
				          if (signList.contains(playerName)) {
			    			   signList.remove(playerName);
			    		   }
				          if (FlowersList.contains(playerName)) {
				        	  FlowersList.remove(playerName);
				          }
				          if (TntList.contains(playerName)) {
				        	  TntList.remove(playerName);
				          }
				          if (HeartParticleList.contains(playerName)) {
				        	  HeartParticleList.remove(playerName);
				          }
				          if (LightningList.contains(playerName)) {
				        	  LightningList.remove(playerName);
				          }
		    	   } else {
			    		  p.sendMessage(main.prefix + main.color("&cYou Dont Have Enough Tokens To Buy This Perk."));
			    		  p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.f, 10.f);
			    	  }
		       }
		      
		       if (i.equals(ItemStacks.BoughtSignPerk())) {
	    		   String playerName = p.getName();
	    		   if (ChestDeathList.contains(playerName)) {
			        	  ChestDeathList.remove(playerName);
			          }
			          if (SmokeParticleList.contains(playerName)) {
		    			   SmokeParticleList.remove(playerName);
		    		   }
			          if (FlowersList.contains(playerName)) {
			        	  FlowersList.remove(playerName);
			          }
			          if (TntList.contains(playerName)) {
			        	  TntList.remove(playerName);
			          }
			          if (HeartParticleList.contains(playerName)) {
			        	  HeartParticleList.remove(playerName);
			          }
			          if (LightningList.contains(playerName)) {
			        	  LightningList.remove(playerName);
			          }
		    	   
	    			   signList.add(playerName);
		    		   p.sendMessage(main.prefix + main.color("&aPerk Successfully Selected."));
		    	   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.BoughtDeathPerk())) {
	    		   String playerName = p.getName();
	    		   if (SmokeParticleList.contains(playerName)) {
			        	  SmokeParticleList.remove(playerName);
			          }
			          if (signList.contains(playerName)) {
		    			   signList.remove(playerName);
		    		   }
			          if (FlowersList.contains(playerName)) {
			        	  FlowersList.remove(playerName);
			          }
			          if (TntList.contains(playerName)) {
			        	  TntList.remove(playerName);
			          }
			          if (HeartParticleList.contains(playerName)) {
			        	  HeartParticleList.remove(playerName);
			          }
			          if (LightningList.contains(playerName)) {
			        	  LightningList.remove(playerName);
			          }
			          ChestDeathList.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aPerk Successfully Selected."));
	    		   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.BoughtLightningPerk())) {
	    		   String playerName = p.getName();
	    		   if (ChestDeathList.contains(playerName)) {
			        	  ChestDeathList.remove(playerName);
			          }
			          if (signList.contains(playerName)) {
		    			   signList.remove(playerName);
		    		   }
			          if (FlowersList.contains(playerName)) {
			        	  FlowersList.remove(playerName);
			          }
			          if (TntList.contains(playerName)) {
			        	  TntList.remove(playerName);
			          }
			          if (HeartParticleList.contains(playerName)) {
			        	  HeartParticleList.remove(playerName);
			          }
			          if (SmokeParticleList.contains(playerName)) {
			        	  SmokeParticleList.remove(playerName);
			          }
	    		   LightningList.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aPerk Successfully Selected."));
	    		   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.BoughtTntPerk())) {
	    		   String playerName = p.getName();
	    		   if (ChestDeathList.contains(playerName)) {
			        	  ChestDeathList.remove(playerName);
			          }
			          if (signList.contains(playerName)) {
		    			   signList.remove(playerName);
		    		   }
			          if (FlowersList.contains(playerName)) {
			        	  FlowersList.remove(playerName);
			          }
			          if (LightningList.contains(playerName)) {
			        	  LightningList.remove(playerName);
			          }
			          if (HeartParticleList.contains(playerName)) {
			        	  HeartParticleList.remove(playerName);
			          }
			          if (SmokeParticleList.contains(playerName)) {
			        	  SmokeParticleList.remove(playerName);
			          }
	    		   TntList.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aPerk Successfully Selected."));
	    		   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.BoughtFlowersPerk())) {
	    		   String playerName = p.getName();
	    		   if (ChestDeathList.contains(playerName)) {
			        	  ChestDeathList.remove(playerName);
			          }
			          if (signList.contains(playerName)) {
		    			   signList.remove(playerName);
		    		   }
			          if (LightningList.contains(playerName)) {
			        	  LightningList.remove(playerName);
			          }
			          if (TntList.contains(playerName)) {
			        	  TntList.remove(playerName);
			          }
			          if (HeartParticleList.contains(playerName)) {
			        	  HeartParticleList.remove(playerName);
			          }
			          if (SmokeParticleList.contains(playerName)) {
			        	  SmokeParticleList.remove(playerName);
			          }
	    		   FlowersList.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aPerk Successfully Selected."));
	    		   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.BoughtHeartParticlesPerk())) {
	    		   String playerName = p.getName();
	    		   if (ChestDeathList.contains(playerName)) {
			        	  ChestDeathList.remove(playerName);
			          }
			          if (signList.contains(playerName)) {
		    			   signList.remove(playerName);
		    		   }
			          if (FlowersList.contains(playerName)) {
			        	  FlowersList.remove(playerName);
			          }
			          if (TntList.contains(playerName)) {
			        	  TntList.remove(playerName);
			          }
			          if (LightningList.contains(playerName)) {
			        	  LightningList.remove(playerName);
			          }
			          if (SmokeParticleList.contains(playerName)) {
			        	  SmokeParticleList.remove(playerName);
			          }
	    		   HeartParticleList.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aPerk Successfully Selected."));
	    		   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.BoughtSmokeParticlePerk())) {
	    		   String playerName = p.getName();
	    		   if (ChestDeathList.contains(playerName)) {
			        	  ChestDeathList.remove(playerName);
			          }
			          if (signList.contains(playerName)) {
		    			   signList.remove(playerName);
		    		   }
			          if (FlowersList.contains(playerName)) {
			        	  FlowersList.remove(playerName);
			          }
			          if (TntList.contains(playerName)) {
			        	  TntList.remove(playerName);
			          }
			          if (HeartParticleList.contains(playerName)) {
			        	  HeartParticleList.remove(playerName);
			          }
			          if (LightningList.contains(playerName)) {
			        	  LightningList.remove(playerName);
			          }
	    		   SmokeParticleList.add(playerName);
	    		   p.sendMessage(main.prefix + main.color("&aPerk Successfully Selected."));
	    		   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.SelectedSignPerk())) {
		    	   p.sendMessage(main.prefix + main.color("&cYouve Already Using This Perk"));
		    	   p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
		    	   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.SelectedDeathPerk())) {
		    	   p.sendMessage(main.prefix + main.color("&cYouve Already Using This Perk"));
		    	   p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
		    	   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.SelectedLightningPerk())) {
		    	   p.sendMessage(main.prefix + main.color("&cYouve Already Using This Perk"));
		    	   p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
		    	   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.SelectedTntPerk())) {
		    	   p.sendMessage(main.prefix + main.color("&cYouve Already Using This Perk"));
		    	   p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
		    	   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.SelectedFlowersPerk())) {
		    	   p.sendMessage(main.prefix + main.color("&cYouve Already Using This Perk"));
		    	   p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
		    	   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.SelectedHeartParticlesPerk())) {
		    	   p.sendMessage(main.prefix + main.color("&cYouve Already Using This Perk"));
		    	   p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
		    	   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.SelectedSmokeParticlePerk())) {
		    	   p.sendMessage(main.prefix + main.color("&cYouve Already Using This Perk"));
		    	   p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
		    	   p.closeInventory();
		       }
		       if (i.equals(ItemStacks.ResetPerks())) {
	    		   String playerName = p.getName();
		    	   if (signList.contains(playerName)) {
		    		   signList.remove(playerName);
			    	   p.sendMessage(main.prefix + main.color("&cYouve Left Your Perk!"));
			    	   p.closeInventory();
		    	   } else if (LightningList.contains(playerName)) {
		    		   LightningList.remove(playerName);
			    	   p.sendMessage(main.prefix + main.color("&cYouve Left Your Perk!"));
			    	   p.closeInventory();
		    	   } else if (ChestDeathList.contains(playerName)) {
		    		   ChestDeathList.remove(playerName);
			    	   p.sendMessage(main.prefix + main.color("&cYouve Left Your Perk!"));
			    	   p.closeInventory();
		    	   } else if (FlowersList.contains(playerName)) {
		    		   FlowersList.remove(playerName);
		    		   p.sendMessage(main.prefix + main.color("&cYouve Left Your Perk!"));
			    	   p.closeInventory();
		    	   } else if (TntList.contains(playerName)) {
		    		   TntList.remove(playerName);
		    		   p.sendMessage(main.prefix + main.color("&cYouve Left Your Perk!"));
			    	   p.closeInventory();
		    	   } else if (HeartParticleList.contains(playerName)) {
		    		   HeartParticleList.remove(playerName);
		    		   p.sendMessage(main.prefix + main.color("&cYouve Left Your Perk!"));
			    	   p.closeInventory();
		    	   } else if (SmokeParticleList.contains(playerName)) {
		    		   SmokeParticleList.remove(playerName);
		    		   p.sendMessage(main.prefix + main.color("&cYouve Left Your Perk!"));
			    	   p.closeInventory();
		    	   } else {
			    	   p.sendMessage(main.prefix + main.color("&cYour not Using any Perks"));
			    	   p.closeInventory();
		    	   }
		       }
		      
		  }
	}
		    
	    @Override
	    public void onLoad() {
	        List<String> savedSignList = getConfig().getStringList("signList");
	        if (savedSignList != null) {
	            signList = savedSignList;
	        }

	        List<String> savedDeathList = getConfig().getStringList("ChestDeathList");
	        if (savedDeathList != null) {
	            ChestDeathList = savedDeathList;
	        }
	        
	        List<String> savedLightningList = getConfig().getStringList("LightningList");
	        if (savedLightningList != null) {
	        	LightningList = savedLightningList;
	        }
	        List<String> savedFlowersList = getConfig().getStringList("FlowersList");
	        if (savedFlowersList != null) {
	        	FlowersList = savedFlowersList;
	        }
	        List<String> savedTntList = getConfig().getStringList("TntList");
	        if (savedTntList != null) {
	        	TntList = savedTntList;
	        }
	        List<String> savedHeartParticleList = getConfig().getStringList("HeartParticleList");
	        if (savedHeartParticleList != null) {
	        	HeartParticleList = savedHeartParticleList;
	        }
	        List<String> savedSmokeParticleList = getConfig().getStringList("SmokeParticleList");
	        if (savedSmokeParticleList != null) {
	        	SmokeParticleList = savedSmokeParticleList;
	        }
	    }
	    
	    
	    @EventHandler
		  public void onInt(PlayerInteractEvent e) {
		    Player p = e.getPlayer();
		    Action action = e.getAction();
		    ItemStack Hand = p.getItemInHand();
		    if (action == Action.RIGHT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK || action == Action.RIGHT_CLICK_BLOCK) {
		      if (Hand.equals(ItemStacks.SGPerks())) {
		    	  SurvivalGamesPerks(p);
		      }
		    }
		  }
	
	    @EventHandler
		  public void onPlayerDeath(PlayerDeathEvent event) {
		    Player victim = event.getEntity();
		    Player killer = event.getEntity().getKiller();
		    String KillerName = killer.getName();
		    if (signList.contains(KillerName)) {
		    	if (killer != null) {
			        Location location = victim.getLocation();
			        location.setY(location.getY() + 1.0D);
			        Block block = location.getBlock();
			        if (block.getType() == Material.AIR) {
			          block.setType(Material.WALL_SIGN);
			          Sign sign = (Sign)block.getState();
			          sign.setLine(0, "RIP");
			          sign.setLine(1, "Killed By " + killer.getName());
			          sign.update();
			      } 
			    } 	
		    }
		    if (ChestDeathList.contains(KillerName)) {
		    Location playerLocation = victim.getLocation();
		      playerLocation.getBlock().setType(Material.CHEST);
		      Chest chestBlock = (Chest)playerLocation.getBlock().getState();
		      Inventory chest = chestBlock.getBlockInventory();
		      byte b;
		      int j;
		      ItemStack[] arrayOfItemStack1;
		      for (j = (arrayOfItemStack1 = victim.getInventory().getContents()).length, b = 0; b < j; ) {
		        ItemStack item = arrayOfItemStack1[b];
		        if (item != null)
		          chest.addItem(new ItemStack[] { item }); 
		        b++;
		      }
		      for (Entity entity : victim.getWorld().getEntities()) {
		          if (entity instanceof Item) {
		              Item item = (Item) entity;
		              if (item.getPickupDelay() == 0) {
		                  entity.remove();
		              }
		          }
		      }
		      chestBlock.update();
		    }
		    if (LightningList.contains(KillerName)) {
		    	 Player killedPlayer = event.getEntity();
		         Location deathLocation = killedPlayer.getLocation();
		         killedPlayer.getWorld().strikeLightningEffect(deathLocation);
		         for (Player player : Bukkit.getOnlinePlayers()) {
		             player.playSound(deathLocation, Sound.AMBIENCE_THUNDER, 1, 1);
		         }
		    }
		    if (FlowersList.contains(KillerName)) {
		    	if (killer != null) {
		            Location loc = victim.getLocation().add(0, 1.5, 0);
		            World world = loc.getWorld();
		            for (int i = 0; i < 24; i++) {
		                world.dropItem(loc, new ItemStack(Material.RED_ROSE, 1));
		                world.dropItem(loc, new ItemStack(Material.YELLOW_FLOWER, 1));
		                world.dropItem(loc, new ItemStack(Material.BLAZE_POWDER, 1));
		            }
		            
		            
		            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
		                public void run() {
		                    for (Entity entity : world.getEntities()) {
		                        if (entity instanceof Item) {
		                            Item item = (Item) entity;
		                            if (item.getItemStack().getType() == Material.RED_ROSE) {
		                                item.remove();
		                            }
		                            if (item.getItemStack().getType() == Material.YELLOW_FLOWER) {
		                                item.remove();
		                            }
		                            if (item.getItemStack().getType() == Material.BLAZE_POWDER) {
		                                item.remove();
		                            }
		                        }
		                    }
		                }
		            }, 100L);
		        }
		    }
		    if (TntList.contains(KillerName)) {
		    	if (killer != null) {
		            Location loc = victim.getLocation().add(0, 1.5, 0);
		            TNTPrimed tnt = (TNTPrimed) loc.getWorld().spawnEntity(loc.add(0.5D, 0.5D, 0.5D), EntityType.PRIMED_TNT);
			        tnt.setFuseTicks(20);
			        tnt.setYield(0.0F);
			        tnt.setIsIncendiary(false);

		        }
		    }
		    if (HeartParticleList.contains(KillerName)) {
		    	if (killer != null) {
		            Location loc = victim.getLocation().add(0, 1.5, 0); 
		            World world = loc.getWorld();
		            world.playEffect(loc, Effect.HEART, 0); 
		            
		            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
		                public void run() {
		                    world.playEffect(loc, Effect.EXPLOSION, 0);
		                }
		            }, 100L);
		        }
		    }
		    if (SmokeParticleList.contains(KillerName)) {
		    	if (killer != null) {
		            Location loc = victim.getLocation().add(0, 1.5, 0);
		            World world = loc.getWorld();
		            world.playEffect(loc, Effect.SMOKE, 4);
		            
		  
		            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
		                public void run() {
		                    world.playEffect(loc, Effect.SMOKE, 4);
		                }
		            }, 20L); 
		        }
		    
		    }
		    }
	    }


