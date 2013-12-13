package kkaylium.GlowGlass.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GGItems {
	
	public static Item glowCrystal_WHITE;
	
	public static void initItems()
	{
		glowCrystal_WHITE = new ItemGlowCrystal(1000).setUnlocalizedName("WhiteGlowCrystal").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(glowCrystal_WHITE, "WhiteGlowCrystal");
		LanguageRegistry.addName(glowCrystal_WHITE, "Glow Crystal: White");
		
	}

}
