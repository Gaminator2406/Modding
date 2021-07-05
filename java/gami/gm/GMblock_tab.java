package gami.gm;

import gami.gm.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GMblock_tab extends ItemGroup{
	
	public GMblock_tab () {
		super("gm_block");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.grey_bricks);
	}
	
	public boolean hasSearchBar(){
	    return false;
	}

}
