package me.TenchysMods.TenchyCraft.tools;

import me.TenchysMods.TenchyCraft.TenchyCraft;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class ShinyHoe extends ItemHoe {
	public ShinyHoe(int ItemID, EnumToolMaterial mat) {
		super(ItemID, mat);
		setCreativeTab(TenchyCraft.tabTCGems);
	}
}
