package com.rqzen.events;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.rqzen.survival.games.main;
public class ItemStacks implements Listener{
	
	 public static ItemStack ResetPerks() {
		    ItemStack i = new ItemStack(Material.BARRIER);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&cLeave Perk"));
		    i.setItemMeta(meta);
		    return i;
		  }
	
	 public static ItemStack RevolutionMap() {
		    ItemStack i = new ItemStack(Material.COAL_BLOCK);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&a&lRevolution"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color(""));
		    lore.add(main.color("&eVotes: &fsoon"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	 public static ItemStack SurvivalGamesMap() {
		    ItemStack i = new ItemStack(Material.COAL_BLOCK);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&a&lSurvivalGames"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color(""));
		    lore.add(main.color("&eVotes: &fsoon"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	 public static ItemStack TheivesOfSeaMap() {
		    ItemStack i = new ItemStack(Material.COAL_BLOCK);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&a&lTheivesOfSea"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color(""));
		    lore.add(main.color("&eVotes: &fsoon"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	 public static ItemStack DVOSMap() {
		    ItemStack i = new ItemStack(Material.COAL_BLOCK);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&a&lDVOS"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color(""));
		    lore.add(main.color("&eVotes: &fsoon"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	 public static ItemStack Mn7OSMap() {
		    ItemStack i = new ItemStack(Material.COAL_BLOCK);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&a&lMn7OS"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color(""));
		    lore.add(main.color("&eVotes: &fsoon"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	 public static ItemStack HeviXMap() {
		    ItemStack i = new ItemStack(Material.COAL_BLOCK);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&a&lHeviX"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color(""));
		    lore.add(main.color("&eVotes: &fsoon"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	 public static ItemStack FiiiFooMap() {
		    ItemStack i = new ItemStack(Material.COAL_BLOCK);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&a&lFiiiFoo"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color(""));
		    lore.add(main.color("&eVotes: &fsoon"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	 
	 
	  public static ItemStack KillsPerks() {
	    ItemStack i = new ItemStack(Material.STONE_SWORD);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aKills Perks"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color(""));
	    lore.add(main.color(""));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  
	  
	  
	  public static ItemStack LightningPerk() {
		    ItemStack i = new ItemStack(Material.PRISMARINE_SHARD);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aLightningPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&7HoldShift &f&l+ &7Click"));
		    lore.add(main.color("  &8To Show More Options."));
		    lore.add(main.color(""));
		    lore.add(main.color("&7Left Click &f&lor &7Right Click"));
		    lore.add(main.color("  &8To Buy Perk."));
		    lore.add(main.color("&aCosts: &f155 Tokens"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack BoughtLightningPerk() {
		    ItemStack i = new ItemStack(Material.PRISMARINE_SHARD);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aLightningPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&a&lSELECT!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack SelectedLightningPerk() {
		    ItemStack i = new ItemStack(Material.PRISMARINE_SHARD);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aLightningPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&e&lSELECTED!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack FlowersPerk() {
		    ItemStack i = new ItemStack(Material.YELLOW_FLOWER);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aFlowersPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&7HoldShift &f&l+ &7Click"));
		    lore.add(main.color("  &8To Show More Options."));
		    lore.add(main.color(""));
		    lore.add(main.color("&7Left Click &f&lor &7Right Click"));
		    lore.add(main.color("  &8To Buy Perk."));
		    lore.add(main.color("&aCosts: &f230 Tokens"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack BoughtFlowersPerk() {
		    ItemStack i = new ItemStack(Material.YELLOW_FLOWER);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aFlowersPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&a&lSELECT!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack SelectedFlowersPerk() {
		    ItemStack i = new ItemStack(Material.YELLOW_FLOWER);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aFlowersPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&e&lSELECTED!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack TntPerk() {
		    ItemStack i = new ItemStack(Material.TNT);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aTntPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&7HoldShift &f&l+ &7Click"));
		    lore.add(main.color("  &8To Show More Options."));
		    lore.add(main.color(""));
		    lore.add(main.color("&7Left Click &f&lor &7Right Click"));
		    lore.add(main.color("  &8To Buy Perk."));
		    lore.add(main.color("&aCosts: &f200 Tokens"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack BoughtTntPerk() {
		    ItemStack i = new ItemStack(Material.TNT);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aTntPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&a&lSELECT!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack SelectedTntPerk() {
		    ItemStack i = new ItemStack(Material.TNT);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aTntPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&e&lSELECTED!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack HeartParticlesPerk() {
		    ItemStack i = new ItemStack(Material.RED_ROSE);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aHeartParticlePerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&7HoldShift &f&l+ &7Click"));
		    lore.add(main.color("  &8To Show More Options."));
		    lore.add(main.color(""));
		    lore.add(main.color("&7Left Click &f&lor &7Right Click"));
		    lore.add(main.color("  &8To Buy Perk."));
		    lore.add(main.color("&aCosts: &f355 Tokens"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack BoughtHeartParticlesPerk() {
		    ItemStack i = new ItemStack(Material.RED_ROSE);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aHeartParticlePerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&a&lSELECT!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack SelectedHeartParticlesPerk() {
		    ItemStack i = new ItemStack(Material.RED_ROSE);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aHeartParticlePerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&e&lSELECTED!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack SmokeParticlePerk() {
		    ItemStack i = new ItemStack(Material.COAL);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aSmokeParticlePerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&7HoldShift &f&l+ &7Click"));
		    lore.add(main.color("  &8To Show More Options."));
		    lore.add(main.color(""));
		    lore.add(main.color("&7Left Click &f&lor &7Right Click"));
		    lore.add(main.color("  &8To Buy Perk."));
		    lore.add(main.color("&aCosts: &f155 Tokens"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack BoughtSmokeParticlePerk() {
		    ItemStack i = new ItemStack(Material.COAL);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aSmokeParticlePerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&a&lSELECT!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack SelectedSmokeParticlePerk() {
		    ItemStack i = new ItemStack(Material.COAL);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aSmokeParticlePerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&e&lSELECTED!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack ChestDeathPerk() {
	    ItemStack i = new ItemStack(Material.CHEST);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aChestDeathPerk"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color("&7HoldShift &f&l+ &7Click"));
	    lore.add(main.color("  &8To Show More Options."));
	    lore.add(main.color(""));
	    lore.add(main.color("&7Left Click &f&lor &7Right Click"));
	    lore.add(main.color("  &8To Buy Perk."));
	    lore.add(main.color("&aCosts: &f155 Tokens"));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack UnAvailbleChestDeathPerk() {
	    ItemStack i = new ItemStack(Material.CHEST);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aChestDeathPerk"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color("&cYou dont own this Feature"));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack SignPerk() {
	    ItemStack i = new ItemStack(Material.SIGN);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aSignPerk"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color("&7HoldShift &f&l+ &7Click"));
	    lore.add(main.color("  &8To Show More Options."));
	    lore.add(main.color(""));
	    lore.add(main.color("&7Left Click &f&lor &7Right Click"));
	    lore.add(main.color("  &8To Buy Perk."));
	    lore.add(main.color("&aCosts: &f155 Tokens"));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack UnAvailbleSignPerk() {
	    ItemStack i = new ItemStack(Material.SIGN);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aSignPerk"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color("&cYou dont own this Feature"));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack AnvilsWinterPerk() {
		    ItemStack i = new ItemStack(Material.SIGN);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aSignPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&7// &8AnvilWinter Perk, When You win a game"));
		    lore.add(main.color("&aIt rains anvils on the top of the player head"));
		    lore.add(main.color("&2Costs: &2240 Tokens!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
		  
		  public static ItemStack UnAvailbleAnvilsWinterPerk() {
		    ItemStack i = new ItemStack(Material.SIGN);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aAnvilWinterPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&cYou dont own this Feature"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
		  
		  public static ItemStack BoughtAnvilsWinterPerk() {
			    ItemStack i = new ItemStack(Material.SIGN);
			    ItemMeta meta = i.getItemMeta();
			    meta.setDisplayName(main.color("&aAnvilWinterPerk"));
			    ArrayList<String> lore = new ArrayList();
			    lore.add(main.color("&a&lSELECT!"));
			    meta.setLore(lore);
			    i.setItemMeta(meta);
			    return i;
			  }
		  
	  public static ItemStack BoughtSignPerk() {
	    ItemStack i = new ItemStack(Material.SIGN);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aSignPerk"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color("&a&lSELECT!"));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack SelectedSignPerk() {
		    ItemStack i = new ItemStack(Material.SIGN);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aSignPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&e&lSELECTED!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack BoughtDeathPerk() {
	    ItemStack i = new ItemStack(Material.CHEST);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aDeathPerk"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color("&a&lSELECT!"));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack SelectedDeathPerk() {
		    ItemStack i = new ItemStack(Material.CHEST);
		    ItemMeta meta = i.getItemMeta();
		    meta.setDisplayName(main.color("&aDeathPerk"));
		    ArrayList<String> lore = new ArrayList();
		    lore.add(main.color("&e&lSELECTED!"));
		    meta.setLore(lore);
		    i.setItemMeta(meta);
		    return i;
		  }
	  
	  public static ItemStack SGPerks() {
	    ItemStack i = new ItemStack(Material.EMERALD);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aPerks"));
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack VotingBook() {
	    ItemStack i = new ItemStack(Material.BOOK);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aVotes"));
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack ExitGame() {
	    ItemStack i = new ItemStack(Material.SLIME_BALL);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aExit"));
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack FlamePerk() {
	    ItemStack i = new ItemStack(Material.BLAZE_POWDER);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aFireParticlesPerk"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color("&7// This Perk is a Particles Perk"));
	    lore.add(main.color("&a when you kill a player it displays"));
	    lore.add(main.color("&aa cool fire particles, &6Enjoy it!"));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack HeartPerk() {
	    ItemStack i = new ItemStack(Material.RED_ROSE);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aHeartParticlesPerk"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color("&7// This Perk is a Particles Perk"));
	    lore.add(main.color("&a when you kill a player it displays"));
	    lore.add(main.color("&aa cool heart particles, &6Enjoy it!"));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack SmokePerk() {
	    ItemStack i = new ItemStack(Material.BREWING_STAND);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aSmokeParticlesPerk"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color("&7// This Perk is a Particles Perk"));
	    lore.add(main.color("&a when you kill a player it displays"));
	    lore.add(main.color("&aa cool smoke particles, &6Enjoy it!"));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack SnowPerk() {
	    ItemStack i = new ItemStack(Material.SNOW_BALL);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aSnowParticlesPerk"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color("&7// This Perk is a Particles Perk"));
	    lore.add(main.color("&a when you kill a player it displays"));
	    lore.add(main.color("&aa cool snowy particles, &6Enjoy it!"));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }
	  
	  public static ItemStack WinPerk() {
	    ItemStack i = new ItemStack(Material.FIREWORK);
	    ItemMeta meta = i.getItemMeta();
	    meta.setDisplayName(main.color("&aFireWorksPerk"));
	    ArrayList<String> lore = new ArrayList();
	    lore.add(main.color("&7// This Perk is a win perk"));
	    lore.add(main.color("&a when you win a game it displays"));
	    lore.add(main.color("&aa cool fire works around you, &6Enjoy it!"));
	    meta.setLore(lore);
	    i.setItemMeta(meta);
	    return i;
	  }

}
