package kkaylium.GlowGlass.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kkaylium.GlowGlass.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class ItemGlowCrystal extends Item{

	public ItemGlowCrystal(int par1) {
		super(par1);
		this.setHasSubtypes(true);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		
	}
	
	public static final String[] names = new String[] {"WHITE", "BLACK"};
    
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
	    int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
	    return super.getUnlocalizedName() + "_" + names[i];
	}
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	      
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	       icons = new Icon[2];
	             
	       for(int i = 0; i < icons.length; i++)
	       {
	              icons[i] = par1IconRegister.registerIcon(Strings.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)) + i);
	       }
	}
	
	public Icon getIconFromDamage(int par1)
	{
		return icons[par1];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int x = 0; x < 2; x++)
	    {
	        par3List.add(new ItemStack(this, 1, x));
	    }
	}

	
}
