package kkaylium.GlowGlass.blocks;

import net.minecraft.item.ItemBlock;

public class GGItemBlock extends ItemBlock{

	public GGItemBlock(int par1) {
		super(par1);
		
	}
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

}
