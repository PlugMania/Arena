package com.github.plugmania.template;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

public class Util {
	
	static Template plugin;
	
	public static Logger log = Logger.getLogger("Minecraft");
	public static PluginDescriptionFile pdfFile;
	
	public Util(Template instance){
		plugin = instance;
	}
	
	public static String formatBroadcast(String msg){
		String s = msg;
		return s;
	}
		
	public static String formatMessage(String msg){
		String s = ChatColor.BLUE + msg;
		return s;
	}
		
	public static void log(String msg){
		log.info("[" + pdfFile.getName() + "] " + msg);
	}
		
	public static void debug(String msg){
		if(plugin.debug){
			log.info("[" + pdfFile.getName() + "] [DEBUG]: " + msg);
		}
	}	

	public static void sendMessageNotPlayer(CommandSender sender) {
		sender.sendMessage(ChatColor.RED + "You must be a player to do this!");
	}

	public static void sendMessageNoPerms(CommandSender sender) {
		sender.sendMessage(ChatColor.RED + "You do not have permission to do that!");
	}

	public static void sendMessagePlayerNotOnline(CommandSender sender) {
		sender.sendMessage(ChatColor.RED + "That player is not online!");
	}
}
