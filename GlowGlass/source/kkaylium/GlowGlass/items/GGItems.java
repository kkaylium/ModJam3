package kkaylium.GlowGlass.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GGItems {
	
	public static Item glowCrystal;
	
	public static int GlowCrystalDefaultID;
	
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
		
	}

}
