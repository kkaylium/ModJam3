package kkaylium.GlowGlass.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import kkaylium.GlowGlass.blocks.GGBlocks;
import kkaylium.GlowGlass.items.GGItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class GGRecipes {
	
	public static ItemStack glass = new ItemStack(Block.glass);
	public static ItemStack glowGlassWHITE = new ItemStack(GGBlocks.GlowGlass, 1, 0);
	public static ItemStack glowGlassBLACK = new ItemStack(GGBlocks.GlowGlass, 1, 1);
	public static ItemStack glowGlassRED = new ItemStack(GGBlocks.GlowGlass, 1, 2);
	public static ItemStack glowCrystalWHITE = new ItemStack(GGItems.glowCrystal, 1, 0);
	public static ItemStack glowCrystalBLACK = new ItemStack(GGItems.glowCrystal, 1, 1);
	public static ItemStack glowCrystalRED = new ItemStack(GGItems.glowCrystal, 1, 2);
	public static ItemStack glowCrystalORANGE = new ItemStack(GGItems.glowCrystal, 1, 3);
	public static ItemStack glowCrystalYELLOW = new ItemStack(GGItems.glowCrystal, 1, 4);
	public static ItemStack glowCrystalGREEN = new ItemStack(GGItems.glowCrystal, 1, 5);
	public static ItemStack glowCrystalLIGHTBLUE = new ItemStack(GGItems.glowCrystal, 1, 9);
	public static ItemStack glowCrystalBLUE = new ItemStack(GGItems.glowCrystal, 1, 6);
	public static ItemStack glowCrystalPURPLE = new ItemStack(GGItems.glowCrystal, 1, 7);
	public static ItemStack glowCrystalPINK = new ItemStack(GGItems.glowCrystal, 1, 8);
	public static ItemStack glowCrystalSPECIAL = new ItemStack(GGItems.glowCrystal, 1, 10);
	
	public static void initRecipes()
	{
		//Glowing Glass Recipes
		GameRegistry.addRecipe(new ItemStack(GGBlocks.GlowGlass, 4, 0), " # ", "#*#", " # ", '#', glass, '*', glowCrystalWHITE);
		GameRegistry.addRecipe(new ItemStack(GGBlocks.GlowGlass, 4, 1), " # ", "#*#", " # ", '#', glass, '*', glowCrystalBLACK);
		GameRegistry.addRecipe(new ItemStack(GGBlocks.GlowGlass, 4, 2), " # ", "#*#", " # ", '#', glass, '*', glowCrystalRED);
		GameRegistry.addRecipe(new ItemStack(GGBlocks.GlowGlass, 4, 3), " # ", "#*#", " # ", '#', glass, '*', glowCrystalORANGE);
		GameRegistry.addRecipe(new ItemStack(GGBlocks.GlowGlass, 4, 4), " # ", "#*#", " # ", '#', glass, '*', glowCrystalYELLOW);
		GameRegistry.addRecipe(new ItemStack(GGBlocks.GlowGlass, 4, 5), " # ", "#*#", " # ", '#', glass, '*', glowCrystalGREEN);
		GameRegistry.addRecipe(new ItemStack(GGBlocks.GlowGlass, 4, 9), " # ", "#*#", " # ", '#', glass, '*', glowCrystalLIGHTBLUE);
		GameRegistry.addRecipe(new ItemStack(GGBlocks.GlowGlass, 4, 6), " # ", "#*#", " # ", '#', glass, '*', glowCrystalBLUE);
		GameRegistry.addRecipe(new ItemStack(GGBlocks.GlowGlass, 4, 7), " # ", "#*#", " # ", '#', glass, '*', glowCrystalPURPLE);
		GameRegistry.addRecipe(new ItemStack(GGBlocks.GlowGlass, 4, 8), " # ", "#*#", " # ", '#', glass, '*', glowCrystalPINK);
		GameRegistry.addRecipe(new ItemStack(GGBlocks.GlowGlass, 4, 10), " # ", "#*#", " # ", '#', glass, '*', glowCrystalSPECIAL);
		//Glowing Fence Recipes
		
		
		//Glowing Gate Recipes
		
		//Other Recipes
	}

}
