package gami.gm.items;

import net.minecraft.entity.LivingEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class MagicMirror extends Item{
	public MagicMirror(Properties properties) {
		super(properties);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand){
		ItemStack stack = player.getHeldItem(hand);
		ItemStack equippedMain = player.getHeldItemMainhand();
        if(equippedMain == stack) {
			if (!world.isRemote) {
				if(player instanceof LivingEntity) {
					LivingEntity livingentity = player;
					
					if(livingentity instanceof ServerPlayerEntity) {
				           		//Set the target values for the event to the location the player is looking
						if(player.getBedLocation(player.dimension) != null) {
							float x = player.getBedLocation(player.dimension).getX();
			           		float y = player.getBedLocation(player.dimension).getY();
			           		float z = player.getBedLocation(player.dimension).getZ();
			           		livingentity.setPositionAndUpdate(x, y, z);
						}
				           		else
				           			livingentity.setPositionAndUpdate(world.getSpawnPoint().getX(), world.getSpawnPoint().getY(), world.getSpawnPoint().getZ());
			                    world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
			                    return ActionResult.newResult(ActionResultType.SUCCESS, stack);
			                }
			            }		 
					}
				}
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
	}

}
