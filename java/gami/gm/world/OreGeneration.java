package gami.gm.world;

import gami.gm.config.OreGenConfig;
import gami.gm.lists.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration 
{
	
	public static void setupOreGeneration() 
	{
		if(OreGenConfig.generate_overworld.get() == true) {
			for(Biome biome : ForgeRegistries.BIOMES) 
			{	
				biome.addFeature(Decoration.UNDERGROUND_ORES,Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.marble.getDefaultState(),OreGenConfig.marble_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 20, 0, 100)));
			}
		}
		
	}
}
