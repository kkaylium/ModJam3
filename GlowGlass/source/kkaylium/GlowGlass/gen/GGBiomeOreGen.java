package kkaylium.GlowGlass.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GGBiomeOreGen extends WorldGenerator{

	private final int metaOre;
	
	public GGBiomeOreGen(boolean par1, int par2)
	{
		super(par1);
		this.metaOre = par2;
	}
	
	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		
		return false;
	}

}
