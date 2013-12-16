package kkaylium.GlowGlass.doors;

import java.util.Random;

import kkaylium.GlowGlass.items.GGItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GGDoor extends BlockDoor{

	public static final String[] doorNames = new String[]{};
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	@SideOnly(Side.CLIENT)
	private Icon[] field_111044_a;
	@SideOnly(Side.CLIENT)
	private Icon[] field_111043_b;
	
	public GGDoor(int par1) {
		super(par1, Material.glass);
		this.setLightValue(1.0F);
		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);	
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int par1, int par2)
	{
		return this.field_111043_b[0];
	}

	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		if(side != 1 && side != 0)
		{
			int i1 = this.getFullMetadata(blockAccess, x, y, z);
			int j1 = i1 & 3;
			boolean flag = (i1 & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (i1 & 8) != 0;
			
			if (flag)
			{
				if (j1 == 0 && side == 2)
				{
					flag1 = !flag1;
				}
				else if (j1 == 1 && side == 5)
				{
					flag1 = !flag1;
				}
				else if (j1 == 2 && side == 3)
				{
					flag1 = !flag1;
				}
				else if (j1 == 3 && side == 4)
				{
					flag1 = !flag1;
				}
			}
			else
			{
				if (j1 == 0 && side == 5)
				{
					flag1 = !flag1;
				}
				else if (j1 == 1 && side == 3)
				{
					flag1 = !flag1;
				}
				else if (j1 == 2 && side == 4)
				{
					flag1 = !flag1;
				}
				else if (j1 == 3 && side == 2)
				{
					flag1 = !flag1;
				}
				
				if ((i1 & 16) != 0)
				{
					flag1 = !flag1;
				}
			}
			
			return flag2 ? this.field_111044_a[flag1 ? 1: 0]: this.field_111043_b[flag1 ? 1 : 0];
		}
		else
		{
			return this.field_111043_b[0];
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.field_111044_a = new Icon[2];
		this.field_111043_b = new Icon[2];
		this.field_111044_a[0] = iconRegister.registerIcon(this.getTextureName() + "_upper");
		this.field_111043_b[0] = iconRegister.registerIcon(this.getTextureName() + "_lower");
		this.field_111044_a[1] = new IconFlipped(this.field_111044_a[0], true, false);
		this.field_111043_b[1] = new IconFlipped(this.field_111043_b[0], true, false);
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean getBlocksMovement(IBlockAccess blockAccess, int x, int y, int z)
	{
		int l = this.getFullMetadata(blockAccess, x, y, z);
		return (l & 4) != 0;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	public int getRenderType()
	{
		return 7;
	}
	
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
	{
		this.setBlockBoundsBasedOnState(world, x, y, z);
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World word, int x, int y, int z)
	{
		this.setBlockBoundsBasedOnState(word, x, y, z);
		return super.getCollisionBoundingBoxFromPool(word, x, y, z);
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
	{
		this.setDoorRotation(this.getFullMetadata(blockAccess, x, y, z));
	}
	
	public int getDoorOrientation(IBlockAccess blockAccess, int x, int y, int z)
	{
		return this.getFullMetadata(blockAccess, x, y, z) & 3;
	}

	public boolean isDoorOpern(IBlockAccess blockAccess, int x, int y, int z)
	{
		return (this.getFullMetadata(blockAccess, x, y, z) & 4) != 0;
	}
	
	private void setDoorRotation(int par1)
	{
		float f = 0.1875F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		int j = par1 & 3;
		boolean flag = (par1 & 4) != 0;
		boolean flag1 = (par1 & 16) != 0;
		
		if (j == 0)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
            }
        }
        else if (j == 1)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
            }
        }
        else if (j == 2)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                }
            }
            else
            {
                this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
        }
        else if (j == 3)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                }
                else
                {
                    this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
            }
        }
	
	}
	
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer entityPlayer){}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
	{
		int i1 = this.getFullMetadata(world, x, y, z);
		int j1 = i1 & 7;
		j1 ^= 4;
		
		if ((i1 & 8) == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, j1, 2);
			world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
		}
		else
		{
			world.setBlockMetadataWithNotify(x, y - 1, z, j1, 2);
			world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
		}
		
		world.playAuxSFXAtEntity(entityPlayer, 1003, x, y, z, 0);
		return true;
	}
	
	public void onPoweredBlockChange(World world, int x, int y, int z, boolean par5)
	{
		int l = this.getFullMetadata(world, x, y, z);
		boolean flag1 = (l & 4) != 0;
		
		if (flag1 != par5)
		{
			int i1 = l & 7;
			i1 ^= 4;
			
			if ((l & 8) == 0)
            {
                world.setBlockMetadataWithNotify(x, y, z, i1, 2);
                world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
            }
            else
            {
                world.setBlockMetadataWithNotify(x, y - 1, z, i1, 2);
                world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
            }

            world.playAuxSFXAtEntity((EntityPlayer)null, 1003, x, y, z, 0);
        
		}
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId)
	{
		int i1 = world.getBlockMetadata(x, y, z);
		
		if ((i1 & 8) == 0)
		{
			boolean flag = false;
			
			if (world.getBlockId(x, y + 1, z) != this.blockID)
			{
				world.setBlockToAir(x, y, z);
                flag = true;
			}
			
			if (!world.doesBlockHaveSolidTopSurface(x, y - 1, z))
			{
				world.setBlockToAir(x, y, z);
				flag = true;
				
				if (world.getBlockId(x, y + 1, z) == this.blockID)
				{
					world.setBlockToAir(x, y + 1, z);
				}
			}
			
			if (flag)
			{
				if(!world.isRemote)
				{
					this.dropBlockAsItem(world, x, y, z, i1, 0);
				}
			}
			else 
			{
				boolean flag1 = world.isBlockIndirectlyGettingPowered(x, y, z) || world.isBlockIndirectlyGettingPowered(x, y + 1, z);
				
				if ((flag1 || blockId > 0 && Block.blocksList[blockId].canProvidePower()) && blockId != this.blockID)
				{
					this.onPoweredBlockChange(world, x, y, z, flag1);
				}
			}	
		}
		else
		{
			if(world.getBlockId(x, y - 1, z) != this.blockID)
			{
				world.setBlockToAir(x, y, z);
			}
			
			if (blockId > 0 && blockId != this.blockID)
			{
				this.onNeighborBlockChange(world, x, y - 1, z, blockId);
			}
		}
	}
	
	public int idDropped(int par1, Random random, int par3)
	{
		return GGItems.glowCrystal.itemID;
	}
	
	 public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
	    {
	        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
	        return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	    }

	    /**
	     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	     */
	    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	    {
	        return par3 >= 255 ? false : par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) && super.canPlaceBlockAt(par1World, par2, par3, par4) && super.canPlaceBlockAt(par1World, par2, par3 + 1, par4);
	    }

	    /**
	     * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
	     * and stop pistons
	     */
	    public int getMobilityFlag()
	    {
	        return 1;
	    }

	    /**
	     * Returns the full metadata value created by combining the metadata of both blocks the door takes up.
	     */
	    public int getFullMetadata(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	    {
	        int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
	        boolean flag = (l & 8) != 0;
	        int i1;
	        int j1;

	        if (flag)
	        {
	            i1 = par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4);
	            j1 = l;
	        }
	        else
	        {
	            i1 = l;
	            j1 = par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4);
	        }

	        boolean flag1 = (j1 & 1) != 0;
	        return i1 & 7 | (flag ? 8 : 0) | (flag1 ? 16 : 0);
	    }

	    @SideOnly(Side.CLIENT)

	    /**
	     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	     */
	    public int idPicked(World par1World, int par2, int par3, int par4)
	    {
	        return this.blockMaterial == Material.iron ? Item.doorIron.itemID : Item.doorWood.itemID;
	    }

	    /**
	     * Called when the block is attempted to be harvested
	     */
	    public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer)
	    {
	        if (par6EntityPlayer.capabilities.isCreativeMode && (par5 & 8) != 0 && par1World.getBlockId(par2, par3 - 1, par4) == this.blockID)
	        {
	            par1World.setBlockToAir(par2, par3 - 1, par4);
	        }
	    }
}

