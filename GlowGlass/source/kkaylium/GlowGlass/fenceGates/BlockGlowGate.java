package kkaylium.GlowGlass.fenceGates;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kkaylium.GlowGlass.GlowGlass;
import kkaylium.GlowGlass.blocks.GGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlowGate extends BlockFenceGate{

	public BlockGlowGate(int par1) {
		super(par1);
		this.setCreativeTab(GlowGlass.GGTab);
		this.setLightValue(1.0F);
		
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		return GGBlocks.GlowFenceWHITE.getBlockTextureFromSide(par1);
	}
	
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return !world.getBlockMaterial(x, y - 1, z).isSolid() ? false : super.canPlaceBlockAt(world, x, y, z);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);
		return isFenceGateOpen(l) ? null : (l != 2 && l != 0 ? AxisAlignedBB.getAABBPool().getAABB((double) ((float)x + 0.375F), (double)y, (double)z, (double)((float)x + 0.625F), (double)((float)y + 1.5F), (double)(z + 1)) : AxisAlignedBB.getAABBPool().getAABB((double)x, (double)y, (double)((float)z + 0.375F), (double)(x + 1), (double)((float)y + 1.5F), (double)((float)z + 0.625F)));
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
	{
		int l = getDirection(blockAccess.getBlockMetadata(x, y, z));
		
		if (l != 2 && l != 0)
		{
			this.setBlockBounds(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
		}
		else
		{
			this.setBlockBounds(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
		}
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	public boolean getBlocksMovement(IBlockAccess blockAccess, int x, int y, int z)
	{
		return isFenceGateOpen(blockAccess.getBlockMetadata(x, y, z));
	}
	
	public int getRenderType()
	{
		return 21;
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack)
	{
		int l = (MathHelper.floor_double((double)(entityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
	{
		int i1 = world.getBlockMetadata(x, y, z);
		
		if(isFenceGateOpen(i1))
		{
			world.setBlockMetadataWithNotify(x, y, z, i1 & -5, 2);
		}
		else
		{
			int j1 = (MathHelper.floor_double((double)(entityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) &3) % 4;
			int k1 = getDirection(i1);
			
			if(k1 == (j1 + 2) % 4)
			{
				i1 = j1; 
			}
			
			world.setBlockMetadataWithNotify(x, y, z, i1 | 4, 2);
		}
		
		world.playAuxSFXAtEntity(entityPlayer, 1003, x, y, z, 0);
		return true;
	}
	
	 public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	    {
	        if (!par1World.isRemote)
	        {
	            int i1 = par1World.getBlockMetadata(par2, par3, par4);
	            boolean flag = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4);

	            if (flag || par5 > 0 && Block.blocksList[par5].canProvidePower())
	            {
	                if (flag && !isFenceGateOpen(i1))
	                {
	                    par1World.setBlockMetadataWithNotify(par2, par3, par4, i1 | 4, 2);
	                    par1World.playAuxSFXAtEntity((EntityPlayer)null, 1003, par2, par3, par4, 0);
	                }
	                else if (!flag && isFenceGateOpen(i1))
	                {
	                    par1World.setBlockMetadataWithNotify(par2, par3, par4, i1 & -5, 2);
	                    par1World.playAuxSFXAtEntity((EntityPlayer)null, 1003, par2, par3, par4, 0);
	                }
	            }
	        }
	    }
	 
	 public static boolean isFenceGateOpen(int par0)
	 {
		 return (par0 & 4) != 0;
	 }
	 
	 @SideOnly(Side.CLIENT)
	 public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int par5)
	 {
		return true; 
	 }
	 
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister iconRegister){}
}
