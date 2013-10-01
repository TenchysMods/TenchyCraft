package me.TenchysMods.TenchyCraft.tools;

import me.TenchysMods.TenchyCraft.TenchyCraft;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ShinySword extends ItemSword {
	public ShinySword(int ItemID, EnumToolMaterial mat) {
		super(ItemID, mat);
		setCreativeTab(TenchyCraft.tabTCGems);
	}
}
