package kkaylium.GlowGlass.blocks;

import java.util.List;
import java.util.Random;

import kkaylium.GlowGlass.GlowGlass;
import kkaylium.GlowGlass.items.GGItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockGlowOre extends Block{

	public static final String[] oreNames = new String[]{"WHITE", "BLACK", "RED", "ORANGE", "YELLOW", "GREEN", "LIGHTBLUE", "BLUE", "PURPLE", "PINK"};
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public BlockGlowOre(int par1) {
		super(par1, Material.rock);
		this.setTextureName("GlowOre");
		this.setCreativeTab(GlowGlass.GGTab);
		this.setLightValue(0.1F);
		this.setHardness(1.6F);
		this.setResistance(10.0F);
		this.setStepSound(soundStoneFootstep);
		this.setTickRandomly(true);
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
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		switch (par3)
		{
		case 0:
			return GGItems.glowCrystal.itemID;
		default:
			return GGItems.glowCrystal.itemID;
		}		
	}
	
	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 3 + random.nextInt(3);
	}
	
	public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }
	
	@Override
	public boolean canSilkHarvest()
	{
		return true;
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
		
	public void randomDisplayTick(World world, int par2, int par3, int par4, Random random)
	{
		this.sparkle(world, par2, par3, par4);
	}
	
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
				switch(oreNames.length)
				{
				case 0:
					world.spawnParticle("reddust", d1, d2, d3, 0.7D, 0.9D, 1.0D);
					break;
				case 1:
					world.spawnParticle("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
					break;
				case 2:
					world.spawnParticle("reddust", d1, d2, d3, 1.0D, 0.0D, 0.0D);
					break;
				case 3:
					world.spawnParticle("reddust", d1, d2, d3, 0.9D, 0.2D, 0.0D);
					break;
				case 4:
					world.spawnParticle("reddust", d1, d2, d3, 0.8D, 0.4D, 0.1D);
					break;
				case 5:
					world.spawnParticle("reddust", d1, d2, d3, 0.5D, 1.0D, 0.4D);
					break;
				case 6:
					world.spawnParticle("reddust", d1, d2, d3, 0.3D, 0.7D, 0.5D);
					break;
				case 7:
					world.spawnParticle("reddust", d1, d2, d3, 0.1D, 0.0D, 0.0D);
					break;
				case 8:
					world.spawnParticle("reddust", d1, d2, d3, 0.7D, 0.9D, 1.0D);
					break;
				default:
					world.spawnParticle("reddust", d1, d2, d3, 0.7D, 0.9D, 1.0D);	
					break;
				}
				
			}
			
		}
		
	}
	
}
