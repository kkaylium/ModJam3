package kkaylium.GlowGlass;

import kkaylium.GlowGlass.items.GGItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class GlowGlassCreativeTab extends CreativeTabs{

	public GlowGlassCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return GGItems.glowCrystal.itemID;
	}

}
