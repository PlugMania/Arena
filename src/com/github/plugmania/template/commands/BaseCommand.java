package com.github.plugmania.template.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.plugmania.template.Lang;
import com.github.plugmania.template.Template;
import com.github.plugmania.template.Util;

public class BaseCommand implements CommandExecutor {

	Template plugin;
	public BaseCommand(Template instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		if(command.getName().equalsIgnoreCase("template")){
			Player player = null;
			if(sender instanceof Player)
				player = (Player) sender;
			
			if(player != null){
				if(!plugin.hasPermission(player, "default")){
					Util.sendMessageNoPerms(sender);
					return true;
				}
			}
			
			if(player == null){
				sender.sendMessage(Util.formatMessage("---------------------- " + Util.pdfFile.getName() + " ----------------------"));
				sender.sendMessage(Util.formatMessage(plugin.getName() + Lang._("devBy") + Util.pdfFile.getAuthors().get(0)));
				sender.sendMessage(Util.formatMessage("To view more information visit http://plugmania.github.com/"));
				return true;
			}
			
			if(args.length == 0){
				sender.sendMessage(Util.formatMessage("---------------------- " + Util.pdfFile.getName() + " ----------------------"));
				sender.sendMessage(Util.formatMessage(plugin.getName() + Lang._("devBy") + Util.pdfFile.getAuthors().get(0)));
				sender.sendMessage(Util.formatMessage("To view more information visit http://plugmania.github.com/ (<-- You can click it!)"));
			}
			return true;
		}
		return false;
	}

}
