package kkaylium.GlowGlass.blocks;

import kkaylium.GlowGlass.GlowGlass;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GlowIceOre extends Block{

	public GlowIceOre(int par1) {
		super(par1, Material.ice);
		this.setTextureName("glowglass:GlowIceOre");
		this.setUnlocalizedName("GlowIceOre");
		this.setCreativeTab(GlowGlass.GGTab);
		this.setLightValue(0.1F);
	}
	
	

}
