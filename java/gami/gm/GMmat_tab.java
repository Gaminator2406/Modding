package gami.gm;

import gami.gm.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GMmat_tab extends ItemGroup{
	
	public GMmat_tab () {
		super("gm_mat");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.weed);
	}
	
	@Override
	public boolean hasSearchBar(){
	    return false;
	}

}
