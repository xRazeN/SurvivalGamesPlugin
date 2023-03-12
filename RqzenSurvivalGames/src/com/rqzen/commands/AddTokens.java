package com.rqzen.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.rqzen.survival.games.main;

public class AddTokens implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender Sender, Command Cmd, String Alias, String[] Args) {
	    Player p = (Player)Sender;
	    int tokens = main.playertokens.getOrDefault(p.getUniqueId().toString(), 0);
	    if (Cmd.getName().equalsIgnoreCase("addtokens")) {
	    	if (p.isOp()) {
	    		tokens += 1000;
	    		main.playertokens.put(p.getUniqueId().toString(), tokens);
	    		p.sendMessage(main.prefix + main.color("&f&l+ &a1000 Tokens"));
	    	} else {
	    		p.sendMessage(main.prefix + main.color("&cnot enough permissions."));
	    	}
	    } 
	    return false;
	  }

}
