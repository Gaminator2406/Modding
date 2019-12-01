package gami.gm.items;

import gami.gm.lists.ItemList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class HermesBoots extends ArmorItem{

	public HermesBoots(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemList.hermes_boots)
		{
			player.addPotionEffect(new EffectInstance(Effects.SPEED,0,1));
		}
	}

}
