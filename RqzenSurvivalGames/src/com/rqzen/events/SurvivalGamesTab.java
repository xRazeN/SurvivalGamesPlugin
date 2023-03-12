package com.rqzen.events;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.rqzen.survival.games.main;

import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class SurvivalGamesTab implements Listener{
		
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		ut(p);
	}
	
	public void ut(Player p) {
		PlayerConnection con = ((CraftPlayer)p).getHandle().playerConnection;
		
		Object tabHeader = new ChatComponentText(main.color("&a&lSurvival&b&lGames"));
		Object tabFooter = new ChatComponentText(main.color(main.plugin.getConfig().getString("TabFooter")));
		
		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
		
		try {
			Field a = packet.getClass().getDeclaredField("a");
			a.setAccessible(true);
			Field b = packet.getClass().getDeclaredField("b");
			b.setAccessible(true);
			
			a.set(packet, tabHeader);
			b.set(packet, tabFooter);
			
			if (Bukkit.getOnlinePlayers().size()==0) return;
			con.sendPacket(packet);
		}catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}

