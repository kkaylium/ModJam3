package kkaylium.GlowGlass.items;

import kkaylium.GlowGlass.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemGlowCrystal extends Item{

	public ItemGlowCrystal(int par1) {
		super(par1);
		
	}
	
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Strings.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)));
    }
}
