package me.Feazes.plugins.mobcash.Reason;

import me.Feazes.plugins.mobcash.Mobcash;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class Natural implements Listener{
	
	public static Mobcash plugin;
	
	public Natural(Mobcash instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void spawnEvent(CreatureSpawnEvent e) {
		if (e.getSpawnReason() == SpawnReason.NATURAL) {
			if (plugin.getConfig().getBoolean("Mobcash.Disable.Natural") == true) {
				if (!plugin.spawnedMobs.contains(e.getEntity().getUniqueId())) {
					plugin.spawnedMobs.add(e.getEntity().getUniqueId());
				}
			}
		}
	}
}
