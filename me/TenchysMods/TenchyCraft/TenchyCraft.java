package me.TenchysMods.TenchyCraft;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import me.TenchysMods.TenchyCraft.block.BlueDiamondBlock;
import me.TenchysMods.TenchyCraft.item.GemItems;
import me.TenchysMods.TenchyCraft.tabs.TabTCGems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init; 
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "tenchycraft2", name = "TenchyCraft", version = "2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class TenchyCraft {
	
	public static Item blueDiamond;
	public static Item blueStone;
	
	public static Block blueDiamondBlock;
	
	public static void loaderItem() {
		blueDiamond = new GemItems(701).setUnlocalizedName("blueDiamond");
		LanguageRegistry.addName(blueDiamond, "Blue Diamond");
		
		blueStone = new GemItems(702).setUnlocalizedName("blueStone");
		LanguageRegistry.addName(blueStone, "Bluestone");
	}
	
	public static void loaderBlock() {
		blueDiamondBlock = new BlueDiamondBlock(1001, "blueDiamondBlock").setUnlocalizedName("blueDiamondBlock").setHardness(2.0F).setStepSound(Block.soundMetalFootstep).setResistance(10.0F);
		GameRegistry.registerBlock(blueDiamondBlock, "blueDiamondBlock");
		LanguageRegistry.addName(blueDiamondBlock, "Blue Diamond Block");
	}
	
	public static void loaderCrafting() {
		GameRegistry.addRecipe(new ItemStack(blueDiamondBlock, 1), new Object[]{"ddd", "ddd", "ddd", 'd', blueDiamond});
		GameRegistry.addRecipe(new ItemStack(blueDiamond, 1), new Object[]{"sss", "sds", "sss", 's', blueStone, 'd', Item.diamond});
		GameRegistry.addShapelessRecipe(new ItemStack(blueStone, 2), new Object[]{Item.redstone, Block.ice});
	}
	
	public static CreativeTabs tabTCGems = new TabTCGems(CreativeTabs.getNextID(), "TenchyCraft Gems");
	
	// SidedProxy code, required by forge.
	@SidedProxy(clientSide = "me.TenchysMods.TenchyCraft.ClientProxy", serverSide = "me.TenchysMods.TenchyCraft.CommonProxy")
	public static CommonProxy proxy;
	
	@Init()
	public static void TCLoad(FMLInitializationEvent event){
		proxy.registerRenderers();
		loaderItem();
		loaderBlock();
		loaderCrafting();
	}
	
}
