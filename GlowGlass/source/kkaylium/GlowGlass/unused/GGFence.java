package kkaylium.GlowGlass.unused;

import java.util.List;

import kkaylium.GlowGlass.blocks.GGBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GGFence extends BlockFence{

	//public String[] fenceNames = new String[]{"WHITE", "BLACK"};
	//@SideOnly(Side.CLIENT)
	//public Icon[] icons;
	
	public GGFence(int id) {
		super(id, "", Material.glass);
		this.setLightValue(1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return GGBlocks.GlowGlass.getIcon(side, metadata);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons (IconRegister iconRegister)
    {
		/*this.icons = new Icon[fenceNames.length];
		
		for(int i = 0; i < this.icons.length; i++)
		{
			this.icons[i] = iconRegister.registerIcon("glowglass:GlowFence" + fenceNames[i]);
		}*/
    }
	
	@Override
    public int damageDropped (int meta)
    {
        return meta;
    }
	
	public static boolean isIdAFence (int par0)
    {
        return true;
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs creativeTabs, List list)
	{
		list.add(new ItemStack(par1, 1, 0));
		list.add(new ItemStack(par1, 1, 1));
		list.add(new ItemStack(par1, 1, 2));
		list.add(new ItemStack(par1, 1, 3));
		list.add(new ItemStack(par1, 1, 4));
		list.add(new ItemStack(par1, 1, 5));
		list.add(new ItemStack(par1, 1, 6));
		list.add(new ItemStack(par1, 1, 7));
		list.add(new ItemStack(par1, 1, 8));
		list.add(new ItemStack(par1, 1, 9));
		list.add(new ItemStack(par1, 1, 10));
	}
	
	public boolean canPlaceTorchOnTop (World world, int x, int y, int z)
	{
	    return true;
	}

	public int getRenderType()
	{
	    return GGFenceRenderer.model;
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
	
	public boolean getBlocksMovement(IBlockAccess par1BlockAccess, int par2, int par3, int par4)
	{
		return false;
	}
	
	public boolean canConnectFenceTo (IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int l = par1IBlockAccess.getBlockId(par2, par3, par4);

        if (l != this.blockID)
        {
            Block block = Block.blocksList[l];
            if (block == null)
                return false;
            if (block.blockMaterial.isOpaque() && block.renderAsNormalBlock())
                return block.blockMaterial != Material.pumpkin;
            return (block instanceof BlockFenceGate);
        }
        else
        {
            return true;
        }
    }

}
