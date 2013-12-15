package kkaylium.GlowGlass.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import kkaylium.GlowGlass.blocks.GGBlocks;
import kkaylium.GlowGlass.items.GGItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class GGRecipes {
	
	public ItemStack glass = new ItemStack(Block.glass);
	public ItemStack glowGlassWHITE = new ItemStack(GGBlocks.GlowGlass, 1, 0);
	public ItemStack glowCrystalWHITE = new ItemStack(GGItems.glowCrystal, 1, 0);
	public ItemStack glowCrystalBLACK = new ItemStack(GGItems.glowCrystal, 1, 1);
	public ItemStack glowCrystalRED = new ItemStack(GGItems.glowCrystal, 1, 2);
	
	public void initRecipes()
	{
		//Glowing Glass Recipes
		GameRegistry.addRecipe(glowGlassWHITE, 4, " # ", "#*#", " # ", '#', glass '*', glowCrystalWHITE);
		//Glowing Fence Recipes
		
		//Glowing Gate Recipes
		
		//Other Recipes
	}

}
