package kkaylium.GlowGlass.blocks;

import kkaylium.GlowGlass.GlowGlass;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGlowFence extends Block{

	private final String field_94464_a;
	
	public BlockGlowFence(int par1, String par2String) {
		super(par1, Material.glass);
		this.setCreativeTab(GlowGlass.GGTab);
		this.field_94464_a = par2String;
	}

}
