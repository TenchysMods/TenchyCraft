package me.TenchysMods.TenchyCraft.tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class TabTCGems extends CreativeTabs {
	public TabTCGems(int par1, String par2Str) {
		super(par1, par2Str);
	}
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return me.TenchysMods.TenchyCraft.TenchyCraft.blueDiamond.itemID;
	}
	public String getTranslatedTabLabel() {
		return "TenchyCraft Gems";
	}
}
