package kkaylium.GlowGlass.blocks;

import java.util.List;

import kkaylium.GlowGlass.GlowGlass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockGlowOre extends Block{

	public static final String[] oreNames = new String[]{"WHITE", "BLACK", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "PURPLE", "PINK"};
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public BlockGlowOre(int par1) {
		super(par1, Material.rock);
		this.setTextureName("GlowOre");
		this.setCreativeTab(GlowGlass.GGTab);
		this.setLightValue(0.1F);
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		if(par2 < 0 || par2 >= this.icons.length)
		{
			par2 = 0;
		}
		return this.icons[par2];
	}
	
	public int damageDropped(int par1)
	{
		return par1;
	}
	
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
		par3List.add(new ItemStack(par1, 1, 4));
		par3List.add(new ItemStack(par1, 1, 5));
		par3List.add(new ItemStack(par1, 1, 6));
		par3List.add(new ItemStack(par1, 1, 7));
		par3List.add(new ItemStack(par1, 1, 8));
	}
	 
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.icons = new Icon[oreNames.length];
		
		for(int i = 0; i < this.icons.length; i++)
		{
			this.icons[i] = iconRegister.registerIcon("glowglass:" + this.getTextureName() + oreNames[i]);
		}
	}
	
	
}
