package kkaylium.GlowGlass.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GGBlocks {
	
	public static Block GlowGlass;
	
	public static void initBlocks()
	{
		GlowGlass = new BlockGlowGlass(500).setUnlocalizedName("GlowGlass");
			GameRegistry.registerBlock(GlowGlass, GlowGlassItemBlock.class, "GlowGlass");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 0), "Glow Glass: White");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 1), "Glow Glass: Black");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 2), "Glow Glass: Red");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 3), "Glow Glass: Orange");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 4), "Glow Glass: Yellow");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 5), "Glow Glass: Green");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 6), "Glow Glass: Light Blue");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 7), "Glow Glass: Blue");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 8), "Glow Glass: Purple");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 9), "Glow Glass: Pink");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 10), "Glow Glass: Special");
			
			
	}

}
