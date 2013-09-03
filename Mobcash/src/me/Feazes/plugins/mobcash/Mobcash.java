package me.Feazes.plugins.mobcash;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.Feazes.plugins.mobcash.Metrics.Metrics;
import me.Feazes.plugins.mobcash.Reason.Breeding;
import me.Feazes.plugins.mobcash.Reason.Egg;
import me.Feazes.plugins.mobcash.Reason.Natural;
import me.Feazes.plugins.mobcash.Reason.Slime_Split;
import me.Feazes.plugins.mobcash.Reason.Spawner;
import me.Feazes.plugins.mobcash.World.WorldListener;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Mobcash extends JavaPlugin {	
	
	public Economy economy = null;
	
	public List<UUID> spawnedMobs = new ArrayList<UUID>();
	
	//Listeners
	public final Breeding breeding = new Breeding(this);
	public final Egg egg = new Egg(this);
	public final Natural natural = new Natural(this);
	public final Slime_Split slimeSplit = new Slime_Split(this);
	public final Spawner spawner = new Spawner(this);
	public final WorldListener world = new WorldListener(this);
	public final MobKill mobkill = new MobKill(this);
	
	@Override
	public void onEnable() {
		
		try {
	        Metrics metrics = new Metrics(this);
	        metrics.start();
            this.getLogger().info("Now tracking stats!");
	    } catch (IOException e) {
	        // Failed to submit the stats :-(
	    }
		
		this.getLogger().info("[Mobcash] has been enabled!");
		this.getConfig().options().copyDefaults(true);
		saveConfig();
		setupEconomy();
		
		// Register events
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(breeding, this);
		pm.registerEvents(egg, this);
		pm.registerEvents(natural, this);
		pm.registerEvents(slimeSplit, this);
		pm.registerEvents(spawner, this);
		pm.registerEvents(world, this);
		pm.registerEvents(mobkill, this);
	}
	
	@Override
	public void onDisable() {
		this.getLogger().info("[Mobcash] has been disabled!");
	}
	
	private boolean setupEconomy()
    {
		
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player p = (Player) sender;
		if (label.equalsIgnoreCase("mobcash")) {
			if (p.hasPermission("mobcash.admin")) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.GOLD + "--------[Mobcash]--------");
					p.sendMessage(ChatColor.GRAY+"v2.0 created by Feazes");
					p.sendMessage(ChatColor.GRAY+"- /mobcash reload");
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("reload")) {
						reloadConfig();
						p.sendMessage(ChatColor.GOLD + "[Mobcash]"+ ChatColor.GRAY+" reloaded config!");
					}
				}
			}
		}
		return false;
	}

}
