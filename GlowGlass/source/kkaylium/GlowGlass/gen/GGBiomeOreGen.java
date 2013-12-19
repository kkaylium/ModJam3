package kkaylium.GlowGlass.gen;

import java.util.LinkedList;
import java.util.Random;

import kkaylium.GlowGlass.blocks.GGBlocks;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
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
		public BiomeGenBase spawnBiome;
		
		public OreInfo(int MaxHeight, int MinHeight, int MaxCluster, int MinCluster, int PerChunk, int OreType, int OreMetadata, BiomeGenBase spawnBiome)
		{
			maxHeight = MaxHeight;
			minHeight = MinHeight;
			maxCluster = MaxCluster;
			minCluster = MinCluster;
			clusterPerChunk = PerChunk;
			oreType = OreType;
			metaOre = OreMetadata;
			this.spawnBiome = spawnBiome;
		}
	}
	
	private LinkedList<OreInfo> oreList;
	
	public GGBiomeOreGen()
	{
		oreList = new LinkedList<OreInfo>();
		OreInfo info;
		
		//Desert
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 2, BiomeGenBase.desert);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 3, BiomeGenBase.desert);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 4, BiomeGenBase.desert);
		oreList.add(info);
		
		//Forest/Jungle
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 5, BiomeGenBase.forest);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 5, BiomeGenBase.forestHills);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 5, BiomeGenBase.jungle);
		oreList.add(info);
		
		//SnowBiomes
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 6, BiomeGenBase.taiga);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 7, BiomeGenBase.taiga);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 6, BiomeGenBase.frozenRiver);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 7, BiomeGenBase.frozenRiver);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 6, BiomeGenBase.iceMountains);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 7, BiomeGenBase.iceMountains);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 6, BiomeGenBase.icePlains);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 7, BiomeGenBase.icePlains);
		oreList.add(info);
		
		//Plains
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 8, BiomeGenBase.plains);
		oreList.add(info);
		
		info = new OreInfo(40, 1, 10, 2, 1, GGBlocks.GlowOre.blockID, 9, BiomeGenBase.plains);
		oreList.add(info);
		
		//extreme hills
		info = new OreInfo(60, 1, 10, 2, 2, GGBlocks.GlowOre.blockID, 0, BiomeGenBase.extremeHills);
		oreList.add(info);
		
		info = new OreInfo(60, 1, 10, 2, 2, GGBlocks.GlowOre.blockID, 1, BiomeGenBase.extremeHills);
		oreList.add(info);
		
		info = new OreInfo(60, 1, 10, 2, 2, GGBlocks.GlowOre.blockID, 0, BiomeGenBase.extremeHillsEdge);
		oreList.add(info);
		
		info = new OreInfo(60, 1, 10, 2, 2, GGBlocks.GlowOre.blockID, 1, BiomeGenBase.extremeHillsEdge);
		oreList.add(info);
	}
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		 
		 int x,y,z;
         int numOre;
         int numCluster;
         @SuppressWarnings("unused")
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
        		 
        		 BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
        		 if (BiomeDictionary.isBiomeOfType(biome, Type.DESERT))
        		 {
        			
        		 }
        		 if (info.spawnBiome == null ||(info.spawnBiome != null && world.getBiomeGenForCoords(x, z).equals(info.spawnBiome)))
        		 {
        		   generateOre(world, random, x, y, z, info.oreType, info.metaOre ,numOre);
        		 }
        		 
        	 }
         }
		
	}
	
	private void generateOre(World world, Random random, int x, int y, int z, int blockID, int metadata, int ntg)
	{
		int lx, ly, lz;
		lx = x;
		ly = y;
		lz = z;
		int id;
		id = world.getBlockId(x, y, z);
		int Metadata = metadata;
		if(id != Block.stone.blockID)
		{
			return;
		}
		for(int i = 0; i < ntg; i++)
		{
			id = world.getBlockId(lx, ly, lz);
			
			world.setBlock(lx, ly, lz, blockID, Metadata, 2);
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
