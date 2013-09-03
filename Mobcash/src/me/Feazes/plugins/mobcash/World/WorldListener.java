package me.Feazes.plugins.mobcash.World;


import me.Feazes.plugins.mobcash.Mobcash;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class WorldListener implements Listener{

public static Mobcash plugin;
	
	public WorldListener(Mobcash instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void spawnEvent(CreatureSpawnEvent e) {
		World w = e.getLocation().getWorld();
		if (!plugin.getConfig().getList("Mobcash.Worlds").contains(w.getName())) {
			if (!plugin.spawnedMobs.contains(e.getEntity().getUniqueId())) {
				plugin.spawnedMobs.add(e.getEntity().getUniqueId());
			}
		}
	}
}
