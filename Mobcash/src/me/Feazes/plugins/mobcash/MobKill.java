package me.Feazes.plugins.mobcash;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobKill implements Listener {
	
public static Mobcash plugin;
	
	public MobKill(Mobcash instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void playerKill(EntityDeathEvent event) {
		
		Entity et = event.getEntity();
		Entity p = event.getEntity().getKiller();
		
		if (p instanceof Player) {
			Player player = (Player)p;
				if (!plugin.spawnedMobs.contains(event.getEntity().getUniqueId())) {
					String mobName = EntityName.readEntity(et);
					if (mobName != null) {
					double cash = 0;
					if (plugin.getConfig().getBoolean("Mobcash.Mobs.Group Settings.Enabled") == true) {
						if (plugin.getConfig().contains("Mobcash.Mobs.Friendly Mobs." + mobName)) {
							cash = plugin.getConfig().getDouble("Mobcash.Mobs.Group Settings.Friendly Mobs");
						} else if (plugin.getConfig().contains("Mobcash.Mobs.Agressive Mobs." + mobName)) {
							cash = plugin.getConfig().getDouble("Mobcash.Mobs.Group Settings.Agressive Mobs");
						} else if (plugin.getConfig().contains("Mobcash.Mobs.Bosses." + mobName)) {
							cash = plugin.getConfig().getDouble("Mobcash.Mobs.Group Settings.Bosses");
						}
					} else if (plugin.getConfig().getBoolean("Mobcash.Mobs.Group Settings.Enabled") == false) {
						if (plugin.getConfig().contains("Mobcash.Mobs.Friendly Mobs." + mobName)) {
							cash = plugin.getConfig().getDouble("Mobcash.Mobs.Friendly Mobs." + mobName);
						} else if (plugin.getConfig().contains("Mobcash.Mobs.Agressive Mobs." + mobName)) {
							cash = plugin.getConfig().getDouble("Mobcash.Mobs.Agressive Mobs." + mobName);
						} else if (plugin.getConfig().contains("Mobcash.Mobs.Bosses." + mobName)) {
							cash = plugin.getConfig().getDouble("Mobcash.Mobs.Bosses." + mobName);
						}
					}
					if (cash != 0) {	
					plugin.economy.depositPlayer(player.getName(), cash);
						
					//array to hold replacements
					
					String[][] replacements = {{"&0", ChatColor.BLACK + ""}, 
					                           {"&1", ChatColor.DARK_BLUE + ""},
					                           {"&2", ChatColor.DARK_GREEN + ""},
					                           {"&3", ChatColor.DARK_AQUA + ""},
					                           {"&4", ChatColor.DARK_RED + ""},
					                           {"&5", ChatColor.DARK_PURPLE + ""},
					                           {"&6", ChatColor.GOLD + ""},
					                           {"&7", ChatColor.GRAY + ""},
					                           {"&8", ChatColor.DARK_GRAY + ""},
					                           {"&9", ChatColor.BLUE + ""},
					                           {"&a", ChatColor.GREEN + ""},
					                           {"&b", ChatColor.AQUA + ""},
					                           {"&c", ChatColor.RED + ""},
					                           {"&d", ChatColor.LIGHT_PURPLE + ""},
					                           {"&e", ChatColor.YELLOW + ""},
					                           {"&f", ChatColor.WHITE + ""},
					                           {"&money", "$" + (double)cash},
					                           {"&player", player.getName()},
					                           {"&mob", mobName}};

					//loop over the array and replace
					String playerMessage = plugin.getConfig().getString("Mobcash.Message");
					for(String[] replacement: replacements) {
						playerMessage = playerMessage.replace(replacement[0], replacement[1]);
						}
					player.sendMessage(playerMessage);
					}
				}
				}
			}
	}
}
