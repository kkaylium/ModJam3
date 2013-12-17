package kkaylium.GlowGlass.blocks;

import java.util.List;

import kkaylium.GlowGlass.GlowGlass;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GGGemBlock extends Block{

	//private int[] hexValues = new int[]{0xB7FFFA, };
	public static String[] blockNames = new String[]{"WHITE", "BLACK", "RED", "ORANGE", "YELLOW", "GREEN", "LIGHTBLUE", "BLUE", "PURPLE", "PINK", "SPECIAL"};
	@SideOnly(Side.CLIENT)
	public Icon[] icons;
	
	public GGGemBlock(int par1) {
		super(par1, Material.rock);
		this.setTextureName("GlowBlock");
		this.setCreativeTab(GlowGlass.GGTab);
		this.setLightValue(1.0F);
		this.setHardness(1.6F);
		this.setResistance(10.0F);
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
		par3List.add(new ItemStack(par1, 1, 9));
		par3List.add(new ItemStack(par1, 1, 10));
	}
	 
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.icons = new Icon[blockNames.length];
		
		for(int i = 0; i < this.icons.length; i++)
		{
			this.icons[i] = iconRegister.registerIcon("glowglass:GlowBlock"+blockNames[i]);
//			if(i == 10)
//			{
//				this.icons[i] = iconRegister.registerIcon("glowglass:" + this.getTextureName() + blockNames[i]);
//			}
//			else
//			{
//				this.icons[i] = iconRegister.registerIcon("glowglass:" + this.getTextureName());
//			}
		}
	}
	
//	@Override
//	public int getRenderColor(int meta)
//	{
//		meta = 6;
//		switch(meta)
//		{
//		case 0:
//			return 0xB7FFFA;
//		case 1:
//			return 0x212121;
//		case 2:
//			return 0xD80000;
//		case 3:
//			return 0xF95B00;
//		case 4:
//			return 0xFFD323;
//		case 5:
//			return 0x77FF0F;
//		case 6:
//			return 0x7AA4FF;
//		case 7:
//			return 0x191DFF;
//		case 8:
//			return 0x9400FF;
//		case 9:
//			return 0xFF1993;
//		default:
//			return 1000;
//		}
//	}
//	
//	@Override
//	 public int colorMultiplier(IBlockAccess iBlockAccess, int x, int y, int z) 
//	 {
//		return z;
//		 
//	 }

}
