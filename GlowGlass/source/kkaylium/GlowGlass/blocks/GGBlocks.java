package kkaylium.GlowGlass.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GGBlocks {
	
	public static Block GlowGlass;
	public static Block GlowOre;
	public static Block GlowIceOre;
	public static Block GlowFenceWHITE;
	public static Block GlowFenceBLACK;
	public static Block GlowFenceRED;
	public static Block GlowFenceORANGE;
	public static Block GlowFenceYELLOW;
	public static Block GlowFenceGREEN;
	public static Block GlowFenceLIGHTBLUE;
	public static Block GlowFenceBLUE;
	public static Block GlowFencePURPLE;
	public static Block GlowFencePINK;
	public static Block GlowFenceSPECIAL;
	
	public static int GlowGlassDefaultID;
	public static int GlowOreDefaultID;
	public static int GlowFenceWHITEDefaultID;
	public static int GlowFenceBLACKDefaultID;
	public static int GlowFenceREDDefaultID;
	public static int GlowFenceORANGEDefaultID;
	public static int GlowFenceYELLOWDefaultID;
	public static int GlowFenceGREENDefaultID;
	public static int GlowFenceLIGHTBLUEDefaultID;
	public static int GlowFenceBLUEDefaultID;
	public static int GlowFencePURPLEDefaultID;
	public static int GlowFencePINKDefaultID;
	public static int GlowFenceSPECIALDefaultID;
	
	public static void initBlocks()
	{
		GlowGlass = new BlockGlowGlass(GlowGlassDefaultID).setUnlocalizedName("GlowGlass");
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
			
		GlowOre = new BlockGlowOre(GlowOreDefaultID).setUnlocalizedName("GlowOre");
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
			
		//GlowIceOre = new GlowIceOre(504);
			//GameRegistry.registerBlock(GlowIceOre, "GlowIceOre");
			//LanguageRegistry.addName(GlowIceOre, "Glow Ice Ore");
			
			//Fences Need Fixing!
		GlowFenceWHITE = new BlockGlowFence(GlowFenceWHITEDefaultID, "GlowFenceWHITE").setUnlocalizedName("GlowFenceWHITE");
			GameRegistry.registerBlock(GlowFenceWHITE, "GlowFenceWHITE");
			LanguageRegistry.addName(GlowFenceWHITE, "Glow Fence: White");
		GlowFenceBLACK = new BlockGlowFence(GlowFenceBLACKDefaultID, "GlowFenceBLACK").setUnlocalizedName("GlowFenceBLACK");
			GameRegistry.registerBlock(GlowFenceBLACK, "GlowFenceBLACK");
			LanguageRegistry.addName(GlowFenceBLACK, "Glow Fence: Black");
		GlowFenceRED = new BlockGlowFence(GlowFenceREDDefaultID, "GlowFenceRED").setUnlocalizedName("GlowFenceRED");
			GameRegistry.registerBlock(GlowFenceRED, "GlowFenceRED");
			LanguageRegistry.addName(GlowFenceRED, "Glow Glass: Red");
		GlowFenceORANGE = new BlockGlowFence(GlowFenceORANGEDefaultID, "GlowFenceORANGE").setUnlocalizedName("GlowFenceORANGE");
			GameRegistry.registerBlock(GlowFenceORANGE, "GlowFenceORANGE");
			LanguageRegistry.addName(GlowFenceORANGE, "Glow Glass: Orange");
		GlowFenceYELLOW = new BlockGlowFence(GlowFenceYELLOWDefaultID, "GlowFenceYELLOW").setUnlocalizedName("GlowFenceYELLOW");
			GameRegistry.registerBlock(GlowFenceYELLOW, "GlowFenceYELLOW");
			LanguageRegistry.addName(GlowFenceYELLOW, "Glow Glass: Yellow");
		GlowFenceGREEN = new BlockGlowFence(GlowFenceGREENDefaultID, "GlowFenceGREEN").setUnlocalizedName("GlowFenceGREEN");
			GameRegistry.registerBlock(GlowFenceGREEN, "GlowFenceGREEN");
			LanguageRegistry.addName(GlowFenceGREEN, "Glow Glass: Green");
		GlowFenceLIGHTBLUE = new BlockGlowFence(GlowFenceLIGHTBLUEDefaultID, "GlowFenceLIGHTBLUE").setUnlocalizedName("GlowFenceLIGHTBLUE");
			GameRegistry.registerBlock(GlowFenceLIGHTBLUE, "GlowFenceLIGHTBLUE");
			LanguageRegistry.addName(GlowFenceLIGHTBLUE, "Glow Glass: Light Blue");
		GlowFenceBLUE = new BlockGlowFence(GlowFenceBLUEDefaultID, "GlowFenceBLUE").setUnlocalizedName("GlowFenceBLUE");
			GameRegistry.registerBlock(GlowFenceBLUE, "GlowFenceBLUE");
			LanguageRegistry.addName(GlowFenceBLUE, "Glow Glass: Blue");
		GlowFencePURPLE = new BlockGlowFence(GlowFencePURPLEDefaultID, "GlowFencePURPLE").setUnlocalizedName("GlowFencePURPLE");
			GameRegistry.registerBlock(GlowFencePURPLE, "GlowFencePURPLE");
			LanguageRegistry.addName(GlowFencePURPLE, "Glow Glass: Purple");
		GlowFencePINK = new BlockGlowFence(GlowFencePINKDefaultID, "GlowFencePINK").setUnlocalizedName("GlowFencePINK");
			GameRegistry.registerBlock(GlowFencePINK, "GlowFencePINK");
			LanguageRegistry.addName(GlowFencePINK, "Glow Glass: Pink");
		GlowFenceSPECIAL = new BlockGlowFence(GlowFenceSPECIALDefaultID, "GlowFenceRAINBOW").setUnlocalizedName("GlowFenceRAINBOW");
			GameRegistry.registerBlock(GlowFenceSPECIAL, "GlowFenceRAINBOW");
			LanguageRegistry.addName(GlowFenceSPECIAL, "Glow Glass: Special");
			
	}

}
