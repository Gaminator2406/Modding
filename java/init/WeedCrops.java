package init;

import javax.annotation.Nonnull;

import gami.gm.lists.ItemList;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WeedCrops extends CropsBlock implements IGrowable{

	public WeedCrops(Properties properties) {
		super(properties);
		
	}

	@Override
	public void onBlockHarvested(World world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull PlayerEntity player) {
		if(!world.isRemote) 
		{
			if(!player.isCreative()) 
			{
				if(this.isMaxAge(state)) 
				{
					int nbSeeds = (int)(1 + (Math.random() * (2 - 1)));
					spawnAsEntity(world, pos, new ItemStack(ItemList.mseed, nbSeeds));
					spawnAsEntity(world, pos, new ItemStack(ItemList.weed, 1));
				}
				else{
					spawnAsEntity(world, pos, new ItemStack(ItemList.mseed, 1));
				}
			}
		}
	}
}

