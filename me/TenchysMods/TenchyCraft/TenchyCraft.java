package me.TenchysMods.TenchyCraft;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import me.TenchysMods.TenchyCraft.block.BlueDiamondBlock;
import me.TenchysMods.TenchyCraft.block.WhiteBlock;
import me.TenchysMods.TenchyCraft.item.GemItems;
import me.TenchysMods.TenchyCraft.tabs.TabTCGems;
import me.TenchysMods.TenchyCraft.tools.ShinyAxe;
import me.TenchysMods.TenchyCraft.tools.ShinyHoe;
import me.TenchysMods.TenchyCraft.tools.ShinyPickaxe;
import me.TenchysMods.TenchyCraft.tools.ShinyShovel;
import me.TenchysMods.TenchyCraft.tools.ShinySword;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init; 
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "tenchycraft2", name = "TenchyCraft", version = "pre02a")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class TenchyCraft {
	
	static EnumToolMaterial shiny = net.minecraftforge.common.EnumHelper.addToolMaterial("HighPower", 2, 9000, 9.0F, 6, 15);
	
	public static Item blueDiamond;
	public static Item blueStone;
	public static Item shinyIngot;
	
	public static Item shinyPickaxe;
	public static Item shinyShovel;
	public static Item shinyAxe;
	public static Item shinySword;
	public static Item shinyHoe;
	
	public static Block blueDiamondBlock;
	public static Block whiteBlock;
	
	public static void loaderItem() {
		blueDiamond = new GemItems(701).setUnlocalizedName("blueDiamond");
		LanguageRegistry.addName(blueDiamond, "Blue Diamond");
		
		blueStone = new GemItems(702).setUnlocalizedName("blueStone");
		LanguageRegistry.addName(blueStone, "Bluestone");
		
		shinyIngot = new GemItems(703).setUnlocalizedName("shinyIngot");
		LanguageRegistry.addName(shinyIngot, "Shiny Ingot");
	}
	
	public static void loaderTools() {
		shinyPickaxe = new ShinyPickaxe(901, shiny).setUnlocalizedName("shinyPickaxe");
		LanguageRegistry.addName(shinyPickaxe, "Shiny Pickaxe");
		
		shinyShovel = new ShinyShovel(902, shiny).setUnlocalizedName("shinyShovel");
		LanguageRegistry.addName(shinyShovel, "Shiny Shovel");
		
		shinyAxe = new ShinyAxe(903, shiny).setUnlocalizedName("shinyAxe");
		LanguageRegistry.addName(shinyAxe, "Shiny Axe");
		
		shinySword = new ShinySword(904, shiny).setUnlocalizedName("shinySword");
		LanguageRegistry.addName(shinySword, "Shiny Sword");
		
		shinyHoe = new ShinyHoe(905, shiny).setUnlocalizedName("shinyHoe");
		LanguageRegistry.addName(shinyHoe, "Shiny Hoe");
	}
	
	public static void loaderBlock() {
		blueDiamondBlock = new BlueDiamondBlock(1001, "blueDiamondBlock").setUnlocalizedName("blueDiamondBlock").setHardness(2.0F).setStepSound(Block.soundMetalFootstep).setResistance(10.0F);
		GameRegistry.registerBlock(blueDiamondBlock, "blueDiamondBlock");
		LanguageRegistry.addName(blueDiamondBlock, "Blue Diamond Block");
		
		whiteBlock = new WhiteBlock(1002, "whiteBlock").setUnlocalizedName("whiteBlock").setHardness(2.0F).setStepSound(Block.soundMetalFootstep).setResistance(10.0F);
		GameRegistry.registerBlock(whiteBlock, "whiteBlock");
		LanguageRegistry.addName(whiteBlock, "White Block (Builder's Tool)");
	}
	
	public static void loaderCrafting() {
		GameRegistry.addRecipe(new ItemStack(blueDiamondBlock, 1), new Object[]{"ddd", "ddd", "ddd", 'd', blueDiamond});
		GameRegistry.addRecipe(new ItemStack(shinyIngot, 1), new Object[]{"iii", "ddd", "iii", 'i', Item.ingotIron, 'd', blueDiamondBlock});
		GameRegistry.addRecipe(new ItemStack(blueDiamond, 1), new Object[]{"sss", "sds", "sss", 's', blueStone, 'd', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(whiteBlock, 1), new Object[]{"did", "www", "sss", 's', Block.stone, 'w', Block.blockNetherQuartz, 'd', blueDiamond, 'i', Item.ingotIron});
		GameRegistry.addShapelessRecipe(new ItemStack(blueStone, 2), new Object[]{Item.redstone, Block.ice});
	}
	
	public static CreativeTabs tabTCGems = new TabTCGems(CreativeTabs.getNextID(), "TenchyCraft");
	
	// SidedProxy code, required by forge.
	@SidedProxy(clientSide = "me.TenchysMods.TenchyCraft.ClientProxy", serverSide = "me.TenchysMods.TenchyCraft.CommonProxy")
	public static CommonProxy proxy;
	
	@Init()
	public static void TCLoad(FMLInitializationEvent event){
		proxy.registerRenderers();
		loaderItem();
		loaderBlock();
		loaderCrafting();
		loaderTools();
	}
	
}
