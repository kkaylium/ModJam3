package kkaylium.GlowGlass.blocks;

import java.util.List;
import java.util.Random;

import kkaylium.GlowGlass.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockGlowGlass extends Block{

	public BlockGlowGlass(int par1) {
		super(par1, Material.glass);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightValue(0.1F);
		
	}
	
	public static final String[] names = new String[] {"WHITE", "BLACK"};
	
	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName() + "_" + names[itemstack.getItemDamage()];
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
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
	       return icons[par2];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int var4 = 0; var4 < 2; ++var4)
	    {
	        par3List.add(new ItemStack(par1, 1, var4));
	    }
	}
	
	public int damageDropped(int par1)
	{
	    return par1;

	}
	
	public int quantityDropped(Random par1Random)
    {
        return 1;
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
}
