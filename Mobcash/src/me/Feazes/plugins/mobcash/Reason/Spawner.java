package me.Feazes.plugins.mobcash.Reason;


import me.Feazes.plugins.mobcash.Mobcash;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class Spawner  implements Listener{
	
	public static Mobcash plugin;
	
	public Spawner(Mobcash instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void spawnEvent(CreatureSpawnEvent e) {
		if (e.getSpawnReason() == SpawnReason.SPAWNER) {
			if (plugin.getConfig().getBoolean("Mobcash.Disable.Mob Spawners") == true) {
				if (!plugin.spawnedMobs.contains(e.getEntity().getUniqueId())) {
					plugin.spawnedMobs.add(e.getEntity().getUniqueId());
				}
			}
		}
	}
}
