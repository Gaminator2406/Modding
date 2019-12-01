package gami.gm.lists;

import gami.gm.GamisMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial

{
	obsidian("obsidian",500, new int[] {8,10,9,7}, 25, ItemList.obsidian_ingot, "entity.ender_dragon.growl", 0.0f),
	hermes("hermes",500, new int[] {8,10,9,7}, 25, ItemList.obsidian_ingot, "entity.ender_dragon.growl", 0.0f);
	
	private static final int[] max_damage_array = new int [] {13,15,16,11};
	
	private String name, equipSound;
	private int durability, enchantability;
	private int[] damageReductionAmounts;
	private Item repairItem;
	private float toughness;
	
private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equiSound, float toughness) {

	this.name = name;
	this.durability = durability;
	this.damageReductionAmounts = damageReductionAmounts;
	this.enchantability = enchantability;
	this.repairItem = repairItem;
	this.equipSound = equiSound;
	this.toughness = toughness;
	}

@Override
public int getDamageReductionAmount(EquipmentSlotType slot) {
	// TODO Auto-generated method stub
	return this.damageReductionAmounts[slot.getIndex()];
}

@Override
public int getDurability(EquipmentSlotType slot) {
	// TODO Auto-generated method stub
	return max_damage_array[slot.getIndex()] * this.durability;
}

@Override
public int getEnchantability() {
	// TODO Auto-generated method stub
	return this.enchantability;
}

@Override
public String getName() {
	// TODO Auto-generated method stub
	return GamisMod.modid + ":" + this.name;
}

@Override
public Ingredient getRepairMaterial() {
	// TODO Auto-generated method stub
	return Ingredient.fromItems(this.repairItem);
}

@Override
public SoundEvent getSoundEvent() {
	// TODO Auto-generated method stub
	return new SoundEvent(new ResourceLocation(equipSound));
}

@Override
public float getToughness() {
	// TODO Auto-generated method stub
	return this.toughness;
}
}
