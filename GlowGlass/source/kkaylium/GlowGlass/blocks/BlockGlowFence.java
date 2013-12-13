package kkaylium.GlowGlass.blocks;

import java.util.List;

import kkaylium.GlowGlass.GlowGlass;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlowFence extends Block{

	private final String field_94464_a;
	
	public BlockGlowFence(int par1, String par2String) {
		super(par1, Material.glass);
		this.setCreativeTab(GlowGlass.GGTab);
		this.field_94464_a = par2String;
	}
	
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
			return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock()
		}
	}
}