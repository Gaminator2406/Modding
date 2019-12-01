package gami.gm.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig {
	
	public static ForgeConfigSpec.IntValue marble_chance;
	public static ForgeConfigSpec.BooleanValue generate_overworld;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) 
	{
		server.comment("Oregen config");
		
		marble_chance = server.comment("Maximum number of marble veins that can spawn in one chunk.")
				.defineInRange("oregen.marble_chance", 20, 1, 100);
		generate_overworld = server.comment("Should marble spawn in the overworld.")
				.define("oregen.generate_overworld", true);
	}

}
