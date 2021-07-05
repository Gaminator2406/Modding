package gami.gm;

import gami.gm.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GMToolsArmor_tab extends ItemGroup{
	
	public GMToolsArmor_tab () {
		super("gm_toolsarmor");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.magic_mirror);
	}
	
	public boolean hasSearchBar(){
	    return false;
	}

}
