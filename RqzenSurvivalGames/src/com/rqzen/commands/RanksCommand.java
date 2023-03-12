package com.rqzen.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.rqzen.survival.games.main;
public class RanksCommand implements Listener,CommandExecutor{
	
	public boolean onCommand(CommandSender Sender, Command Cmd, String Alias, String[] Args) {
	    Player p = (Player)Sender;
	    if (Cmd.getName().equalsIgnoreCase("ranks")) {
	      p.sendMessage(main.color("&8&m------------&eSurvival&9Games&8&m------------"));
	      p.sendMessage(main.color("&8" + main.OneRank + main.color(" &8&e100 Kills")));
	      p.sendMessage(main.color("&8" + main.TwoRank + main.color(" &8&e300 Kills")));
	      p.sendMessage(main.color("&8" + main.ThreeRank + main.color(" &8&e500 Kills")));
	      p.sendMessage(main.color("&8" + main.FourRank + main.color(" &8&e700 Kills")));
	      p.sendMessage(main.color("&8" + main.FiveRank + main.color(" &8&e900 Kills")));
	      p.sendMessage(main.color("&8" + main.SixRank + main.color(" &8&e1100 Kills")));
	      p.sendMessage(main.color("&8" + main.SevenRank + main.color(" &8&e1300 Kills")));
	      p.sendMessage(main.color("&8" + main.EightRank + main.color(" &8&e1500 Kills")));
	      p.sendMessage(main.color("&8" + main.NineRank + main.color(" &8&e1700 Kills")));
	      p.sendMessage(main.color("&8" + main.TenRank + main.color(" &8&e2500 Kills")));
	      p.sendMessage(main.color("&8" + main.ElevenRank + main.color(" &8&e3000 Kills")));
	      p.sendMessage(main.color("&8&m-------------------------------------"));
	    } 
	    return false;
	  }

}
