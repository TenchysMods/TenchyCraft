package me.TenchysMods.TenchyCraft.tools;

import me.TenchysMods.TenchyCraft.TenchyCraft;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class ShinyAxe extends ItemAxe {
	public ShinyAxe(int ItemID, EnumToolMaterial mat) {
		super(ItemID, mat);
		setCreativeTab(TenchyCraft.tabTCGems);
		setMaxStackSize(1);
	}
}
