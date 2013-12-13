package kkaylium.GlowGlass.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GGItems {
	
	public static Item glowCrystal;
	
	public static void initItems()
	{
		glowCrystal = new ItemGlowCrystal(1000).setUnlocalizedName("WhiteGlowCrystal");
		GameRegistry.registerItem(glowCrystal, "WhiteGlowCrystal");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 0), "Glow Crystal: White");
		LanguageRegistry.addName(new ItemStack(glowCrystal, 1, 1), "Glow Crystal: Black");
		
	}

}
