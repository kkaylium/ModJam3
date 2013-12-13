package kkaylium.GlowGlass.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GGNormalWorldGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId)
		{	
			case: -1
			generateNether();
			break;
			case: 0
			generateOverworld(world random, chunkX * 16, chunkZ * 16);
			break;
			case: 1
			generateEnd();
			break;
		}
		
		public void generateNether()
		{
			
		}
		
		public void generateOverworld(World world, Random random, int chunkX, int chunkZ)
		{
			for(int i = 0; i < 20; i++)
			{
				int oreX = chunkX + random.nextInt(16);
				int oreY = random.nextInt(40);
				int oreZ = chunkZ + random.nextInt(16);
				
				
			}
		}
		
		public void generateEnd()
		{
			
		}
	}

}
