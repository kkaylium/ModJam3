package kkaylium.GlowGlass.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class GGBlocks {
	
	public static Block GlowGlass_WHITE;
	
	public static void initBlocks()
	{
		GlowGlass_WHITE = new BlockGlowGlass(500).setUnlocalizedName("WhiteGlowGlass").setCreativeTab(CreativeTabs.tabBlock);
			GameRegistry.registerBlock(GlowGlass_WHITE, "WhiteGlowGlass");
			LanguageRegistry.addName(GlowGlass_WHITE, "Glow Glass: White");
		
	}

}
