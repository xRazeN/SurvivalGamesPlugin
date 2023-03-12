package com.rqzen.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.rqzen.survival.games.main;
public class StatsCommand implements Listener,CommandExecutor{
	
	public boolean onCommand(CommandSender Sender, Command Cmd, String Alias, String[] Args) {
	    Player p = (Player)Sender;
	    int playerpoints = ((Integer)main.playerpoints.getOrDefault(p.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	    int playerwins = ((Integer)main.playerwins.getOrDefault(p.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	    int playergamesplayed = ((Integer)main.playergamesplayed.getOrDefault(p.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	    int playertokens = ((Integer)main.playertokens.getOrDefault(p.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	    int playerkillss = main.playerkills.getOrDefault(p.getUniqueId().toString(), 0);
	    if (Cmd.getName().equalsIgnoreCase("stats")) {
	      if (Args.length == 0) {
	        p.sendMessage(main.color("&8&m-------&aSurvival&bGames&8&m-------"));
	        p.sendMessage(main.color("&7Name &8&e" + p.getName()));
	        p.sendMessage(main.color("&7Points &8&e" + playerpoints));
	        p.sendMessage(main.color("&7Tokens &8&e" + playertokens));
	        p.sendMessage(main.color("&7Kills &8&e" + playerkillss));
	        if (!main.playerwins.containsKey(p.getUniqueId().toString())) {
	          p.sendMessage(main.color("&7Victories &8&e0"));
	        } else {
	          p.sendMessage(main.color("&7Victories &8&e" + playerwins));
	        } 
	        p.sendMessage(main.color("&7GamesPlayed &8&e" + playergamesplayed));
	        p.sendMessage(main.color("&8&m---------------------------"));
	      }
	      if (Args.length == 1) {
	        Player argplayer = Bukkit.getServer().getPlayer(Args[0]);
	        if (argplayer == null) {
	          p.sendMessage(String.valueOf(main.prefix) + main.color("&cPlayer Not Found"));
	        } else {
	          int argplayerpoints = ((Integer)main.playerpoints.getOrDefault(argplayer.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	          int argplayerwins = ((Integer)main.playerwins.getOrDefault(argplayer.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	          int argplayergamesplayed = ((Integer)main.playergamesplayed.getOrDefault(argplayer.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	          int argplayertokens = ((Integer)main.playertokens.getOrDefault(argplayer.getUniqueId().toString(), Integer.valueOf(0))).intValue();
	          int argplayerkillss = main.playerkills.getOrDefault(argplayer.getUniqueId().toString(), 0);
	          p.sendMessage(main.color("&8&m-------&aSurvival&bGames&8&m-------"));
	          p.sendMessage(main.color("&7Name &8&e" + argplayer.getName()));
	          p.sendMessage(main.color("&7Points &8&e" + argplayerpoints));
	          p.sendMessage(main.color("&7Tokens &8&e" + argplayertokens));
	          p.sendMessage(main.color("&7Kills &8&e" + argplayerkillss));
	          if (!main.playerwins.containsKey(argplayer.getUniqueId().toString())) {
	            p.sendMessage(main.color("&7Victories &8&e0"));
	          } else {
	            p.sendMessage(main.color("&7Victories &8&e" + argplayerwins));
	          } 
	          p.sendMessage(main.color("&7GamesPlayed &8&e" + argplayergamesplayed));
	          p.sendMessage(main.color("&8&m---------------------------"));
	        } 
	      } 
	    } 
	    return false;
	  }

}
