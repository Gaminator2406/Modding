package gami.gm.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class SpaceCookie extends Item{

	public SpaceCookie(Properties properties) {
		super(properties);
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity player) {
		player.addPotionEffect(new EffectInstance(Effects.LEVITATION));
		return super.onItemUseFinish(stack, world, player);
	}

}
