package gami.gm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gami.gm.blocks.CustomStairs;
import gami.gm.config.Config;
import gami.gm.items.HermesBoots;
import gami.gm.items.MagicMirror;
import gami.gm.lists.ArmorMaterialList;
import gami.gm.lists.BlockList;
import gami.gm.lists.FoodList;
import gami.gm.lists.ItemList;
import gami.gm.lists.ToolMaterialList;
import gami.gm.world.OreGeneration;
import init.WeedCrops;
import net.minecraft.block.Block;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("gm")
public class GamisMod 
{
	public static GamisMod instance;
	
	public static final String modid = "gm";
	public static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup gm_mat = new GMmat_tab();
	public static final ItemGroup gm_block = new GMblock_tab();
	public static final ItemGroup gm_food = new GMfood_tab();
	public static final ItemGroup gm_toolsarmor = new GMToolsArmor_tab();
	
	public GamisMod() 
	{
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("gamismod-client.toml").toString());
		Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("gamismod-server.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) 
	{
		OreGeneration.setupOreGeneration();
		logger.info("setup method registered.");
		
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) 
	{
		logger.info("clientRegistries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus =Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll(
					// Items
					ItemList.weed = new Item(new Item.Properties().group(gm_mat).maxStackSize(420)).setRegistryName(location("weed")),
					ItemList.grey_brick = new Item(new Item.Properties().group(gm_mat)).setRegistryName(location("grey_brick")),
					ItemList.smoked_brick = new Item(new Item.Properties().group(gm_mat)).setRegistryName(location("smoked_brick")),
					ItemList.obsidian_ingot = new Item(new Item.Properties().group(gm_mat)).setRegistryName(location("obsidian_ingot")),
					ItemList.iron_stick = new Item(new Item.Properties().group(gm_mat)).setRegistryName(location("iron_stick")),
					ItemList.mseed = new BlockNamedItem(BlockList.mplant, new Item.Properties().group(gm_mat)).setRegistryName(location("mseed")),
					
					ItemList.magic_mirror = new MagicMirror(new Item.Properties().group(gm_toolsarmor)).setRegistryName(location("magic_mirror")),
					ItemList.hermes_boots = new HermesBoots(ArmorMaterialList.hermes, EquipmentSlotType.FEET, new Item.Properties().group(gm_toolsarmor)).setRegistryName(location("hermes_boots")),
					
					ItemList.obsidian_sword = new SwordItem(ToolMaterialList.obsidian, 0, 2.0f, new Item.Properties().group(gm_toolsarmor)).setRegistryName(location("obsidian_sword")),
					ItemList.obsidian_axe = new AxeItem(ToolMaterialList.obsidian, -1.0f, 2.0f, new Item.Properties().group(gm_toolsarmor)).setRegistryName(location("obsidian_axe")),
					ItemList.obsidian_pickaxe = new PickaxeItem(ToolMaterialList.obsidian, -2, 2.0f, new Item.Properties().group(gm_toolsarmor)).setRegistryName(location("obsidian_pickaxe")),
					ItemList.obsidian_shovel = new ShovelItem(ToolMaterialList.obsidian, -3.0f, 2.0f, new Item.Properties().group(gm_toolsarmor)).setRegistryName(location("obsidian_shovel")),
					ItemList.obsidian_hoe = new HoeItem(ToolMaterialList.obsidian, 6.0f, new Item.Properties().group(gm_toolsarmor)).setRegistryName(location("obsidian_hoe")),
					
					ItemList.obsidian_helmet = new ArmorItem(ArmorMaterialList.obsidian, EquipmentSlotType.HEAD, new Item.Properties().group(gm_toolsarmor)).setRegistryName(location("obsidian_helmet")),
					ItemList.obsidian_chestplate = new ArmorItem(ArmorMaterialList.obsidian, EquipmentSlotType.CHEST, new Item.Properties().group(gm_toolsarmor)).setRegistryName(location("obsidian_chestplate")),
					ItemList.obsidian_leggings = new ArmorItem(ArmorMaterialList.obsidian, EquipmentSlotType.LEGS, new Item.Properties().group(gm_toolsarmor)).setRegistryName(location("obsidian_leggings")),
					ItemList.obsidian_boots = new ArmorItem(ArmorMaterialList.obsidian, EquipmentSlotType.FEET, new Item.Properties().group(gm_toolsarmor)).setRegistryName(location("obsidian_boots")),
					
					// Food
					ItemList.fried_egg = new Item(new Item.Properties().group(gm_food).food(FoodList.fried_egg)).setRegistryName(location("fried_egg")),
					ItemList.raw_bacon = new Item(new Item.Properties().group(gm_food).food(FoodList.raw_bacon)).setRegistryName(location("raw_bacon")),
					ItemList.cooked_bacon = new Item(new Item.Properties().group(gm_food).food(FoodList.cooked_bacon)).setRegistryName(location("cooked_bacon")),
					ItemList.bae_sandwich = new Item(new Item.Properties().group(gm_food).food(FoodList.bae_sandwich)).setRegistryName(location("bae_sandwich")),
					ItemList.fries = new Item(new Item.Properties().group(gm_food).food(FoodList.fries)).setRegistryName(location("fries")),
					ItemList.space_cookie = new Item(new Item.Properties().group(gm_food).food(FoodList.space_cookie)).setRegistryName(location("space_cookie")),
					
					// MISC
					ItemList.grey_bricks = new BlockItem(BlockList.grey_bricks, new Item.Properties().group(gm_block)).setRegistryName(BlockList.grey_bricks.getRegistryName()),
					ItemList.grey_bricks_slab = new BlockItem(BlockList.grey_bricks_slab, new Item.Properties().group(gm_block)).setRegistryName(BlockList.grey_bricks_slab.getRegistryName()),
					ItemList.grey_bricks_stairs = new BlockItem(BlockList.grey_bricks_stairs, new Item.Properties().group(gm_block)).setRegistryName(BlockList.grey_bricks_stairs.getRegistryName()),
					
					ItemList.smoked_bricks = new BlockItem(BlockList.smoked_bricks, new Item.Properties().group(gm_block)).setRegistryName(BlockList.smoked_bricks.getRegistryName()),
					ItemList.smoked_bricks_slab = new BlockItem(BlockList.smoked_bricks_slab, new Item.Properties().group(gm_block)).setRegistryName(BlockList.smoked_bricks_slab.getRegistryName()),
					ItemList.smoked_bricks_stairs = new BlockItem(BlockList.smoked_bricks_stairs, new Item.Properties().group(gm_block)).setRegistryName(BlockList.smoked_bricks_stairs.getRegistryName()),
					
					ItemList.marble = new BlockItem(BlockList.marble, new Item.Properties().group(gm_block)).setRegistryName(BlockList.marble.getRegistryName()),
					ItemList.marble_bricks = new BlockItem(BlockList.marble_bricks, new Item.Properties().group(gm_block)).setRegistryName(BlockList.marble_bricks.getRegistryName()),
					ItemList.marble_bricks_slab = new BlockItem(BlockList.marble_bricks_slab, new Item.Properties().group(gm_block)).setRegistryName(BlockList.marble_bricks_slab.getRegistryName()),
					ItemList.marble_bricks_stairs = new BlockItem(BlockList.marble_bricks_stairs, new Item.Properties().group(gm_block)).setRegistryName(BlockList.marble_bricks_stairs.getRegistryName()),
					
					ItemList.pure_glowstone = new BlockItem(BlockList.pure_glowstone, new Item.Properties().group(gm_block)).setRegistryName(BlockList.pure_glowstone.getRegistryName()),
					ItemList.pure_glowstone_lamp = new BlockItem(BlockList.pure_glowstone_lamp, new Item.Properties().group(gm_block)).setRegistryName(BlockList.pure_glowstone_lamp.getRegistryName()),
					ItemList.glowstone_lamp = new BlockItem(BlockList.glowstone_lamp, new Item.Properties().group(gm_block)).setRegistryName(BlockList.glowstone_lamp.getRegistryName()),
					ItemList.lit_glowstone_lamp = new BlockItem(BlockList.lit_glowstone_lamp, new Item.Properties().group(gm_block)).setRegistryName(BlockList.lit_glowstone_lamp.getRegistryName()),
					ItemList.lit_pure_glowstone_lamp = new BlockItem(BlockList.lit_pure_glowstone_lamp, new Item.Properties().group(gm_block)).setRegistryName(BlockList.lit_pure_glowstone_lamp.getRegistryName())
			);
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll(
					// Grey bricks
					BlockList.grey_bricks = new Block(Block.Properties
							.create(Material.ROCK)
							.hardnessAndResistance(1.5f,6.0f)
							.lightValue(0)
							.sound(SoundType.STONE))
							.setRegistryName(location("grey_bricks")),
					BlockList.grey_bricks_slab = new SlabBlock(Block.Properties
							.create(Material.ROCK)
							.hardnessAndResistance(1.5f,6.0f)
							.lightValue(0)
							.sound(SoundType.STONE))
							.setRegistryName(location("grey_bricks_slab")),
					BlockList.grey_bricks_stairs = new CustomStairs(BlockList.grey_bricks.getDefaultState(), Block.Properties
							.create(Material.ROCK)
							.hardnessAndResistance(1.5f,6.0f)
							.lightValue(0)
							.sound(SoundType.STONE))
							.setRegistryName(location("grey_bricks_stairs")),
							
					// Smoked Bricks
					BlockList.smoked_bricks = new Block(Block.Properties
							.create(Material.ROCK)
							.hardnessAndResistance(1.5f,6.0f)
							.lightValue(0)
							.sound(SoundType.STONE))
							.setRegistryName(location("smoked_bricks")),
					BlockList.smoked_bricks_slab = new SlabBlock(Block.Properties
							.create(Material.ROCK)
							.hardnessAndResistance(1.5f,6.0f)
							.lightValue(0)
							.sound(SoundType.STONE))
							.setRegistryName(location("smoked_bricks_slab")),
					BlockList.smoked_bricks_stairs = new CustomStairs(BlockList.smoked_bricks.getDefaultState(), Block.Properties
							.create(Material.ROCK)
							.hardnessAndResistance(1.5f,6.0f)
							.lightValue(0)
							.sound(SoundType.STONE))
							.setRegistryName(location("smoked_bricks_stairs")),
							
							
					BlockList.marble = new Block(Block.Properties
							.create(Material.ROCK)
							.hardnessAndResistance(1.5f,6.0f)
							.lightValue(0)
							.sound(SoundType.STONE))
							.setRegistryName(location("marble")),
					BlockList.marble_bricks = new Block(Block.Properties
							.create(Material.ROCK)
							.hardnessAndResistance(1.5f,6.0f)
							.lightValue(0)
							.sound(SoundType.STONE))
					.setRegistryName(location("marble_bricks")),
					BlockList.marble_bricks_slab = new SlabBlock(Block.Properties
							.create(Material.ROCK)
							.hardnessAndResistance(1.5f,6.0f)
							.lightValue(0)
							.sound(SoundType.STONE))
							.setRegistryName(location("marble_bricks_slab")),
					BlockList.marble_bricks_stairs = new CustomStairs(BlockList.marble_bricks.getDefaultState(), Block.Properties
							.create(Material.ROCK)
							.hardnessAndResistance(1.5f,6.0f)
							.lightValue(0)
							.sound(SoundType.STONE))
							.setRegistryName(location("marble_bricks_stairs")),
							

					BlockList.pure_glowstone = new Block(Block.Properties
							.create(Material.GLASS)
							.hardnessAndResistance(0.3f)
							.lightValue(20)
							.sound(SoundType.GLASS))
							.setRegistryName(location("pure_glowstone")),
							
					BlockList.pure_glowstone_lamp = new RedstoneLampBlock(Block.Properties
							.create(Material.GLASS)
							.hardnessAndResistance(0.3f)
							.lightValue(20)
							.sound(SoundType.GLASS))
							.setRegistryName(location("pure_glowstone_lamp")),
					BlockList.glowstone_lamp = new RedstoneLampBlock(Block.Properties
							.create(Material.GLASS)
							.hardnessAndResistance(0.3f)
							.lightValue(20)
							.sound(SoundType.GLASS))
							.setRegistryName(location("glowstone_lamp")),
							
					BlockList.lit_glowstone_lamp = new Block(Block.Properties
							.create(Material.GLASS)
							.hardnessAndResistance(0.3f)
							.lightValue(20)
							.sound(SoundType.GLASS))
					.setRegistryName(location("lit_glowstone_lamp")),
					
					BlockList.lit_pure_glowstone_lamp = new Block(Block.Properties
							.create(Material.GLASS)
							.hardnessAndResistance(0.3f)
							.lightValue(20)
							.sound(SoundType.GLASS))
					.setRegistryName(location("lit_pure_glowstone_lamp")),
					
					// Plants
					BlockList.mplant = new WeedCrops((Block.Properties
							.create(Material.PLANTS)
							.sound(SoundType.PLANT)
							.doesNotBlockMovement()
							.tickRandomly()))
							.setRegistryName(location("mplant"))
					
			);
			logger.info("Blocks registered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
	

}
