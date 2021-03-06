package me.TenchysMods.TenchyCraft.block;

import java.util.Random;

import me.TenchysMods.TenchyCraft.TenchyCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class WhiteBlock extends Block {
	public WhiteBlock(int par1, String texture) {
		super(par1, Material.rock);
		setCreativeTab(TenchyCraft.tabTCGems);
	}
	public int idDropped(int par1, Random par2Random, int par3) {
		return TenchyCraft.whiteBlock.blockID;
	}
	public int quantityDropped(Random rand) {
		return 9;
	}
	public String getTextureFile() {
		return"/textures/blocks/whiteBlock.png";
	}
}
