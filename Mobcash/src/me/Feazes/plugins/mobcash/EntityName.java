package me.Feazes.plugins.mobcash;

import org.bukkit.entity.Entity;

public class EntityName {
	
	public static String readEntity(Entity e) {
		switch (e.getType()) {
		case BAT:return"Bat";
		case BLAZE:return"Blaze";
		case CAVE_SPIDER:return"Cave Spider";
		case CHICKEN:return"Chicken";
		case COW:return"Cow";
		case CREEPER:return"Creeper";
		case ENDERMAN:return"Enderman";
		case ENDER_DRAGON:return"Ender Dragon";
		case ENDERMITE:return"Endermite";
		case GHAST:return"Ghast";
		case GIANT:return"Giant";
		case GUARDIAN:return"Guardian";
		case HORSE:return"Horse";
		case IRON_GOLEM:return"Iron Golem";
		case MAGMA_CUBE:return"Magma Cube";
		case MUSHROOM_COW:return"Mushroom Cow";
		case OCELOT:return"Ocelot";
		case PIG:return"Pig";
		case PIG_ZOMBIE:return"Pig Zombie";
		case RABBIT:return"Rabbit";
		case SHEEP:return"Sheep";
		case SILVERFISH:return"Silver Fish";
		case SKELETON:return"Skeleton";
		case SLIME:return"Slime";
		case SNOWMAN:return"Snowman";
		case SPIDER:return"Spider";
		case SQUID:return"Squid";
		case VILLAGER:return"Villager";
		case WITCH:return"Witch";
		case WITHER:return"Wither";
		case WOLF:return"Wolf";
		case ZOMBIE:return"Zombie";
		default:
			break;
		}
		return null;
	}
}
