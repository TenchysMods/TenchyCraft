package me.TenchysMods.TenchyCraft.tools;

import me.TenchysMods.TenchyCraft.TenchyCraft;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ShinyPickaxe extends ItemPickaxe {
	public ShinyPickaxe(int ItemID, EnumToolMaterial mat) {
		super(ItemID, mat);
		setCreativeTab(TenchyCraft.tabTCGems);
	}
}
