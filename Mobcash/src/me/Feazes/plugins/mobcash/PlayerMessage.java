package me.Feazes.plugins.mobcash;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class PlayerMessage {
	
public static Mobcash plugin;
	
	public PlayerMessage(Mobcash instance) {
		plugin = instance;
	}
	
	public static String sendKillMessage(Entity e, Player p, Double d) {
		
		String mobName = EntityName.readEntity(e);
		String player = p.getName();
		String symbol = plugin.economy.currencyNameSingular();
		
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
	                           {"&money", symbol+d},
	                           {"&player", player},
	                           {"&mob", mobName}};

	//loop over the array and replace
	String playerMessage = plugin.getConfig().getString("Mobcash.Message");
	for(String[] replacement: replacements) {
		playerMessage = playerMessage.replace(replacement[0], replacement[1]);
		}
	return playerMessage;
	}
}
