package me.TenchysMods.TenchyCraft.tools;

import me.TenchysMods.TenchyCraft.TenchyCraft;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class ShinyShovel extends ItemSpade {
	public ShinyShovel(int ItemID, EnumToolMaterial mat) {
		super(ItemID, mat);
		setCreativeTab(TenchyCraft.tabTCGems);
		setMaxStackSize(1);
	}
}
