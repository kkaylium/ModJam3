package kkaylium.GlowGlass.items;

import kkaylium.GlowGlass.blocks.GGBlocks;
import kkaylium.GlowGlass.doors.GGDoorItem;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GGItems {
	
	public static Item glowCrystal;
	public static Item glowDoorItemWHITE;
	/*public static Item glowDoorItemBLACK;
	public static Item glowDoorItemRED;
	public static Item glowDoorItemORANGE;
	public static Item glowDoorItemYELLOW;
	public static Item glowDoorItemGREEN;
	public static Item glowDoorItemLIGHTBLUE;
	public static Item glowDoorItemBLUE;
	public static Item glowDoorItemPURPLE;
	public static Item glowDoorItemPINK;
	public static Item glowDoorItemSPECIAL;*/
	
	public static int GlowCrystalDefaultID = 1000;
	public static int GlowDoorItemWHITEDefaultID = 600;
	/*public static int GlowDoorItemBLACKDefaultID;
	public static int GlowDoorItemREDDefaultID;
	public static int GlowDoorItemORANGEDefaultID;
	public static int GlowDoorItemYELLOWDefaultID;
	public static int GlowDoorItemGREENDefaultID;
	public static int GlowDoorItemLIGHTBLUEDefaultID;
	public static int GlowDoorItemBLUEDefaultID;
	public static int GlowDoorItemPURPLEDefaultID;
	public static int GlowDoorItemPINKDefaultID;
	public static int GlowDoorItemSPECIALDefaultID;*/
	
	public static void initItems()
	{
		glowCrystal = new ItemGlowCrystal(GlowCrystalDefaultID);
		GameRegistry.registerItem(glowCrystal, "GlowCrystal");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 0), "Glow Crystal: White");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 1), "Glow Crystal: Black");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 2), "Glow Crystal: Red");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 3), "Glow Crystal: Orange");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 4), "Glow Crystal: Yellow");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 5), "Glow Crystal: Green");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 6), "Glow Crystal: Light Blue");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 7), "Glow Crystal: Blue");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 8), "Glow Crystal: Purple");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 9), "Glow Crystal: Pink");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 10), "Glow Crystal: Special");
		
		glowDoorItemWHITE = new GGDoorItem(GlowDoorItemWHITEDefaultID, GGBlocks.GlowDoorWHITE).setUnlocalizedName("GlowDoorItem").setTextureName("glowglass:GlowDoorWHITE");
			GameRegistry.registerItem(glowDoorItemWHITE, "GlowDoorItemWHITE");
			LanguageRegistry.addName(glowDoorItemWHITE, "Glow Door: White");
	/*	glowDoorItemBLACK = new GGDoorItem(GlowDoorItemBLACKDefaultID, GGBlocks.GlowDoorBLACK).setUnlocalizedName("GlowDoorItem").setTextureName("glowglass:GlowDoorBLACK");
			GameRegistry.registerItem(glowDoorItemBLACK, "GlowDoorItemBLACK");
			LanguageRegistry.addName(glowDoorItemBLACK, "Glow Door: Black");
		glowDoorItemRED = new GGDoorItem(GlowDoorItemREDDefaultID, GGBlocks.GlowDoorRED).setUnlocalizedName("GlowDoorItem").setTextureName("glowglass:GlowDoorRED");
			GameRegistry.registerItem(glowDoorItemRED, "GlowDoorItemRED");
			LanguageRegistry.addName(glowDoorItemRED, "Glow Door");
		glowDoorItemORANGE = new GGDoorItem(GlowDoorItemORANGEDefaultID, GGBlocks.GlowDoorORANGE).setUnlocalizedName("GlowDoorItem").setTextureName("glowglass:GlowDoorORANGE");
			GameRegistry.registerItem(glowDoorItemORANGE, "GlowDoorItemORANGE");
			LanguageRegistry.addName(glowDoorItemORANGE, "Glow Door: Orange");
			glowDoorItemYELLOW = new GGDoorItem(GlowDoorItemYELLOWDefaultID, GGBlocks.GlowDoorYELLOW).setUnlocalizedName("GlowDoorItem").setTextureName("glowglass:GlowDoorYELLOW");
			GameRegistry.registerItem(glowDoorItemYELLOW, "GlowDoorItemYELLOW");
			LanguageRegistry.addName(glowDoorItemYELLOW, "Glow Door: YELLOW");
			glowDoorItemGREEN = new GGDoorItem(GlowDoorItemGREENDefaultID, GGBlocks.GlowDoorGREEN).setUnlocalizedName("GlowDoorItem").setTextureName("glowglass:GlowDoorGREEN");
			GameRegistry.registerItem(glowDoorItemGREEN, "GlowDoorItemGREEN");
			LanguageRegistry.addName(glowDoorItemGREEN, "Glow Door: Green");
			glowDoorItemLIGHTBLUE = new GGDoorItem(GlowDoorItemLIGHTBLUEDefaultID, GGBlocks.GlowDoorLIGHTBLUE).setUnlocalizedName("GlowDoorItem").setTextureName("glowglass:GlowDoorLIGHTBLUE");
			GameRegistry.registerItem(glowDoorItemLIGHTBLUE, "GlowDoorItemLIGHTBLUE");
			LanguageRegistry.addName(glowDoorItemLIGHTBLUE, "Glow Door: Light Blue");
			glowDoorItemBLUE = new GGDoorItem(GlowDoorItemBLUEDefaultID, GGBlocks.GlowDoorBLUE).setUnlocalizedName("GlowDoorItem").setTextureName("glowglass:GlowDoorBLUE");
			GameRegistry.registerItem(glowDoorItemBLUE, "GlowDoorItemBLUE");
			LanguageRegistry.addName(glowDoorItemBLUE, "Glow Door: Blue");
			glowDoorItemPURPLE = new GGDoorItem(GlowDoorItemPURPLEDefaultID, GGBlocks.GlowDoorPURPLE).setUnlocalizedName("GlowDoorItem").setTextureName("glowglass:GlowDoorPURPLE");
			GameRegistry.registerItem(glowDoorItemPURPLE, "GlowDoorItemPURPLE");
			LanguageRegistry.addName(glowDoorItemPURPLE, "Glow Door: Purple");
			glowDoorItemPINK = new GGDoorItem(GlowDoorItemPINKDefaultID, GGBlocks.GlowDoorPINK).setUnlocalizedName("GlowDoorItem").setTextureName("glowglass:GlowDoorWHITE");
			GameRegistry.registerItem(glowDoorItemPINK, "GlowDoorItemPINK");
			LanguageRegistry.addName(glowDoorItemPINK, "Glow Door: Pink");*/
			
		
	}

}
