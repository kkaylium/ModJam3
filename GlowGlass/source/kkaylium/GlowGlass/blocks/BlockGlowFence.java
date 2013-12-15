package kkaylium.GlowGlass.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import kkaylium.GlowGlass.GlowGlass;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlowFence extends BlockFence{

	//public static final String[] fenceNames = new String[]{"WHITE", "BLACK", "RED", "ORANGE", "YELLOW", "GREEN", "LIGHTBLUE", "BLUE", "PURPLE", "PINK", "RAINBOW"};
	//@SideOnly(Side.CLIENT)
	//private Icon[] icons;
	private final String field_94464_a;
	
	public BlockGlowFence(int par1, String par2String) 
	{
		super(par1, par2String, Material.glass);
		this.field_94464_a = par2String;
		this.setCreativeTab(GlowGlass.GGTab);
		this.setLightValue(1.0F);
	}
	
	//@SideOnly(Side.CLIENT)
	//@Override
	//public Icon getIcon(int par1, int par2)
	//{
	//	if(par2 < 0 || par2 >= this.icons.length)
	//	{
	//		par2 = 0;
	//	}
	//	return this.icons[par2];
	//}
	
	//public int damageDropped(int par1)
	//{
	//	return par1;
	//}
	/*
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
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
	*/
	/*@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.icons = new Icon[fenceNames.length];
		
		for(int i = 0; i < this.icons.length; i++)
		{
			this.icons[i] = iconRegister.registerIcon("glowglass:" + this.field_94464_a + fenceNames[i]);
		}
	}*/
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		iconRegister.registerIcon("glowglass:" + this.field_94464_a);
		
	}
	
	//public void randomDisplayTick(World world, int par2, int par3, int par4, Random random)
	//{
	//	this.sparkle(world, par2, par3, par4);
	//}
	
	private void sparkle(World world, int par2, int par3, int par4)
	{
		Random random = world.rand;
		double d0 = 0.0625D;
		for(int i = 0; i < 1; i++)
		{
			double d1 = (double)((float)par2 + random.nextFloat());
			double d2 = (double)((float)par3 + random.nextFloat());
			double d3 = (double)((float)par4 + random.nextFloat());
			
			if(i == 0 && !world.isBlockOpaqueCube(par2, par3 + 1, par4))
			{
				d2 = (double)(par3 + 1) + d0;
			}
			
			if(i == 1 && !world.isBlockOpaqueCube(par2, par3 - 1, par4))
			{
				d2 = (double)(par3 + 0) - d0;
			}
			
			if(i == 2 && !world.isBlockOpaqueCube(par2, par3, par4 + 1))
			{
				d3 = (double)(par4 + 1) + d0;
			}
			
			if(i == 3 && !world.isBlockOpaqueCube(par2, par3, par4 - 1))
			{
				d3 = (double)(par4 + 0) - d0;
			}
			
			if(i == 4 && !world.isBlockOpaqueCube(par2 + 1, par3, par4))
			{
				d1 = (double)(par2 + 1) + d0;
			}
			
			if(i == 5 && !world.isBlockOpaqueCube(par2 - 1, par3, par4))
			{
				d1 = (double)(par2 + 0) - d0;
			}
			
			if (d1 < (double)par2 || d1 > (double)(par2 + 1) || d2 < 0.0D || d2 > (double)(par3 + 1) || d3 < (double)par4 || d3 > (double)(par4 + 1))
			{
				world.spawnParticle("reddust", d1, d2, d3, 0.7D, 0.9D, 1.0D);
			}
			
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
	{
		boolean flag = this.canConnectFenceTo(par1World, par2, par3, par4 - 1);
		boolean flag1 = this.canConnectFenceTo(par1World, par2, par3, par4 + 1);
		boolean flag2 = this.canConnectFenceTo(par1World, par2 - 1, par3, par4);
		boolean flag3 = this.canConnectFenceTo(par1World, par2 + 1, par3, par4);
		float f = 0.375F;
		float f1 = 0.625F;
		float f2 = 0.375F;
		float f3 = 0.625F;
		
		if (flag)
		{
			f2 = 0.0F;
		}
		
		if (flag1)
		{
			f3 = 1.0F;
		}
		
		if (flag || flag1)
		{
			this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}
		
		f2 = 0.375F;
		f3 = 0.625F;
		
		if (flag2)
		{
			f = 0.0F;
		}
		
		if (flag3)
		{
			f1 = 1.0F;
		}
		
		if (flag2 || flag3 || !flag && !flag1)
		{
			this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		}
		
		if (flag)
		{
			f2 = 0.0F;
		}
		
		if(flag1)
		{
			f3 = 1.0F;
		}
		
		this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1BlockAccess, int par2, int par3, int par4)
	{
		boolean flag = this.canConnectFenceTo(par1BlockAccess, par2, par3, par4 - 1);
		boolean flag1 = this.canConnectFenceTo(par1BlockAccess, par2, par3, par4 + 1);
		boolean flag2 = this.canConnectFenceTo(par1BlockAccess, par2 - 1, par3, par4);
		boolean flag3 = this.canConnectFenceTo(par1BlockAccess, par2 + 1, par3, par4);
		float f = 0.375F;
		float f1 = 0.625F;
		float f2 = 0.375F;
		float f3 = 0.625F;
		
		if (flag)
		{
			f2 = 0.0F;
		}
		
		if (flag1)
		{
			f3 = 1.0F;
		}
		
		if (flag2)
		{
			f = 0.0F;
		}
		
		if (flag3)
		{
			f1 = 1.0F;
		}
		
		this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
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
	
	public int getRenderType()
	{
		return 11;
	}
	
	public boolean canConnectFenceTo(IBlockAccess par1BlockAccess, int par2, int par3, int par4)
	{
		int l = par1BlockAccess.getBlockId(par2, par3, par4);
		
		if(l != this.blockID && l != Block.fenceGate.blockID)
		{
			Block block = Block.blocksList[l];
			return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
		}
	    else
		{
			return true;
		}
	}
	
	public static boolean isIdAFence(int par0)
	{
		return par0 == Block.fence.blockID || par0 == Block.netherFence.blockID;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return true;
	}
	
	//@SideOnly(Side.CLIENT)
	//public void registerIcons(IconRegister iconRegister)
	//{
	//	this.blockIcon = iconRegister.registerIcon(this.field_94464_a);
	//}
}
