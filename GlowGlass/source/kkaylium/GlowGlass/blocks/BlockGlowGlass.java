package kkaylium.GlowGlass.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGlowGlass extends Block{

	public BlockGlowGlass(int par1) {
		super(par1, Material.glass);
		this.setLightValue(0.1F);
		this.setTextureName("glowglass:GlowGlass");
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
