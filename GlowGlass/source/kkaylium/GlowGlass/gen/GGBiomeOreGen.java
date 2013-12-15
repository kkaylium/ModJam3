package kkaylium.GlowGlass.gen;

import java.util.LinkedList;
import java.util.Random;

import kkaylium.GlowGlass.blocks.GGBlocks;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GGBiomeOreGen implements IWorldGenerator{

	public class OreInfo
	{
		public int maxHeight;
		public int minHeight;
		public int maxCluster;
		public int minCluster;
		public int clusterPerChunk;
		public int oreType;
		public int metaOre;
		
		public OreInfo(int MaxHeight, int MinHeight, int MaxCluster, int MinCluster, int PerChunk, int OreType)
		{
			maxHeight = MaxHeight;
			minHeight = MinHeight;
			maxCluster = MaxCluster;
			minCluster = MinCluster;
			clusterPerChunk = PerChunk;
			oreType = OreType;
		}
	}
	
	private LinkedList<OreInfo> oreList;
	
	public GGBiomeOreGen()
	{
		oreList = new LinkedList<OreInfo>();
		OreInfo info;
		
		info = new OreInfo(40, 0, 10, 2, 2, GGBlocks.GlowOre.blockID);
		oreList.add(info);
		
	}
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		 
		 int x,y,z;
         int numOre;
         int numCluster;
         int tcount = 0;
         if (world.provider.dimensionId != 0) //Only generate in the main world.
         {  
        	 return;
         }
         for(OreInfo info: oreList)
         {
        	 tcount++;
        	 numCluster = random.nextInt(info.clusterPerChunk);
        	 if(numCluster == 0 && info.clusterPerChunk != 0)
        	 {
        		 numCluster = 1;
        	 }
        	 
        	 for(int count = 0; count < numCluster; count++)
        	 {
        		 x = random.nextInt(16);
        		 z = random.nextInt(16);
        		 y = random.nextInt(info.maxHeight - info.minHeight);
        		 x = x + (16 * chunkX);
        		 z = z + (16 * chunkZ);
        		 y = y + info.minHeight;
        		 numOre = MathHelper.clamp_int(random.nextInt(info.maxCluster), info.minCluster, info.maxCluster);
        		 
        		 generateOre(world, random, x, y, z, info.oreType, numOre);
        		 
        	 }
         }
		
	}
	
	private void generateOre(World world, Random random, int x, int y, int z, int blockID, int ntg)
	{
		int lx, ly, lz;
		lx = x;
		ly = y;
		lz = z;
		int id;
		id = world.getBlockId(x, y, z);
		if(id != Block.stone.blockID)
		{
			return;
		}
		for(int i = 0; i < ntg; i++)
		{
			id = world.getBlockId(lx, ly, lz);
			
			world.setBlock(lx, ly, lz, blockID, 4, 2);
			switch (random.nextInt(3))
			{
			case 0:
				 lx = lx + (random.nextInt(4) -2);
                 break;
         case 1:
                 ly = ly + (random.nextInt(4) -2);
                 break;
         case 2:
                 lz = lz + (random.nextInt(4) -2);
                 break;
			}
		}
	}

}
