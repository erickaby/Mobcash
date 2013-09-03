package me.Feazes.plugins.mobcash.Reason;

import me.Feazes.plugins.mobcash.Mobcash;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class Breeding  implements Listener{
	
	public static Mobcash plugin;
	
	public Breeding(Mobcash instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void spawnEvent(CreatureSpawnEvent e) {
		if (e.getSpawnReason() == SpawnReason.BREEDING) {
			if (plugin.getConfig().getBoolean("Mobcash.Disable.Breeding") == true) {
				if (!plugin.spawnedMobs.contains(e.getEntity().getUniqueId())) {
					plugin.spawnedMobs.add(e.getEntity().getUniqueId());
				}
			}
		}
	}
}
