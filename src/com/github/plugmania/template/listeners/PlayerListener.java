package com.github.plugmania.template.listeners;


import org.bukkit.event.Listener;

import com.github.plugmania.template.Template;

public class PlayerListener implements Listener {

	Template plugin;
	public PlayerListener(Template instance) {
		plugin = instance;
	}

}
