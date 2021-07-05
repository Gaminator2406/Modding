package gami.gm;

import gami.gm.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GMfood_tab extends ItemGroup{
	
	public GMfood_tab () {
		super("gm_food");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.fried_egg);
	}
	
	public boolean hasSearchBar(){
	    return false;
	}

}
