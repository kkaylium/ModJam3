package kkaylium.GlowGlass.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import kkaylium.GlowGlass.GlowGlass;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlowFence extends BlockFence{

	private final String field_94464_a;
	
	public BlockGlowFence(int par1, String par2String) {
		super(par1, par2String, Material.glass);
		this.field_94464_a = par2String;
		this.setCreativeTab(GlowGlass.GGTab);
		this.setUnlocalizedName("GlowFence");
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
			return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
		}
	    else
		{
			return true;
		}
	}
	
	//public static boolean isIdAFence(int par0)
	//{
	//	return par0 == Block.fence.blockID || par0 == Block.netherFence.blockID;
	//}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(this.field_94464_a);
	}
}
