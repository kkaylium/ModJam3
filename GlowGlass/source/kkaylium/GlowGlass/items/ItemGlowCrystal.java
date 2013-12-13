package kkaylium.GlowGlass.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class ItemGlowCrystal extends Item{

	private String[] crystalNames = new String[] {"WHITE", "BLACK"};
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemGlowCrystal(int par1) {
		super(par1);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		StringBuilder unlocalizedName = new StringBuilder();
		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 1);
		
		unlocalizedName.append("item.");
		unlocalizedName.append("glowglass:");
		unlocalizedName.append("GlowCrystal");
		unlocalizedName.append(crystalNames[meta]);
		
		return unlocalizedName.toString();
		
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
	{
		int i = MathHelper.clamp_int(par1, 0, 1);
		return this.icons[i];
	}
	
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for(int i = 0; i < 2; i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.icons = new Icon[crystalNames.length];
		
		for(int i = 0; i < crystalNames.length; i++)
		{
			icons[i] = iconRegister.registerIcon("glowglass:GlowCrystal"+ crystalNames[i]);
		}
	}
	
}
