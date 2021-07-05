package gami.gm.lists;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodList {
	
	public static Food fried_egg;
	public static Food raw_bacon;
	public static Food cooked_bacon;
	public static Food bae_sandwich;
	public static Food fries;
	public static Food space_cookie;
	
	static {
		
		fried_egg = (new Food.Builder()).hunger(5).saturation(6f).fastToEat().build();
		raw_bacon = (new Food.Builder()).hunger(1).saturation(6f).fastToEat().build();
		cooked_bacon = (new Food.Builder()).hunger(5).saturation(6f).fastToEat().build();
		bae_sandwich = (new Food.Builder()).hunger(14).saturation(20).build();
		fries = (new Food.Builder()).hunger(5).saturation(6f).fastToEat().build();
		space_cookie = (new Food.Builder()).hunger(5).saturation(6f).fastToEat().effect(new EffectInstance(Effects.LEVITATION, 250), 1).effect(new EffectInstance(Effects.HUNGER, 250), 1).build();
	}

}
