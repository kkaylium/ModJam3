package kkaylium.GlowGlass.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GGBlocks {
	
	public static Block GlowGlass;
	public static Block GlowOre;
	public static Block GlowIceOre;
	public static Block GlowFence;
	
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
			
		GlowOre = new BlockGlowOre(501).setUnlocalizedName("GlowOre");
			GameRegistry.registerBlock(GlowOre, GlowCrystalOresItemBlock.class, "GlowOre");
			LanguageRegistry.addName(new ItemStack(GlowOre, 1, 0), "Glow Ore: White");
			LanguageRegistry.addName(new ItemStack(GlowOre, 1, 1), "Glow Ore: Black");
			LanguageRegistry.addName(new ItemStack(GlowOre, 1, 2), "Glow Ore: Red");
			LanguageRegistry.addName(new ItemStack(GlowOre, 1, 3), "Glow Ore: Orange");
			LanguageRegistry.addName(new ItemStack(GlowOre, 1, 4), "Glow Ore: Yellow");
			LanguageRegistry.addName(new ItemStack(GlowOre, 1, 5), "Glow Ore: Green");
			LanguageRegistry.addName(new ItemStack(GlowOre, 1, 6), "Glow Ore: Blue");
			LanguageRegistry.addName(new ItemStack(GlowOre, 1, 7), "Glow Ore: Purple");
			LanguageRegistry.addName(new ItemStack(GlowOre, 1, 8), "Glow Ore: Pink");
			
		GlowIceOre = new GlowIceOre(502);
			GameRegistry.registerBlock(GlowIceOre, "GlowIceOre");
			LanguageRegistry.addName(GlowIceOre, "Glow Ice Ore");
			
			//Fences Need Fixing!
		GlowFence = new BlockGlowFence(503, "GlowFence");
			GameRegistry.registerBlock(GlowFence, GlowFenceItemBlock.class, "GlowFence");
			LanguageRegistry.addName(new ItemStack(GlowFence, 1, 0), "Glow Fence: White");
			LanguageRegistry.addName(new ItemStack(GlowFence, 1, 1), "Glow Fence: Black");
			LanguageRegistry.addName(new ItemStack(GlowFence, 1, 2), "Glow Glass: Red");
			LanguageRegistry.addName(new ItemStack(GlowFence, 1, 3), "Glow Glass: Orange");
			LanguageRegistry.addName(new ItemStack(GlowFence, 1, 4), "Glow Glass: Yellow");
			LanguageRegistry.addName(new ItemStack(GlowFence, 1, 5), "Glow Glass: Green");
			LanguageRegistry.addName(new ItemStack(GlowFence, 1, 6), "Glow Glass: Light Blue");
			LanguageRegistry.addName(new ItemStack(GlowFence, 1, 7), "Glow Glass: Blue");
			LanguageRegistry.addName(new ItemStack(GlowFence, 1, 8), "Glow Glass: Purple");
			LanguageRegistry.addName(new ItemStack(GlowFence, 1, 9), "Glow Glass: Pink");
			LanguageRegistry.addName(new ItemStack(GlowFence, 1, 10), "Glow Glass: Special");
	}

}
