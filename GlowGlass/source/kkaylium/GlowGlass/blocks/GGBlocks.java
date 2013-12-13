package kkaylium.GlowGlass.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class GGBlocks {
	
	public static Block GlowGlass;
	
	public static void initBlocks()
	{
		GlowGlass = new BlockGlowGlass(500).setUnlocalizedName("GlowGlass");
			GameRegistry.registerBlock(GlowGlass, "GlowGlass");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 0), "Glow Glass: White");
			LanguageRegistry.addName(new ItemStack(GlowGlass, 1, 1), "Glow Glass: Black");
		
	}

}
