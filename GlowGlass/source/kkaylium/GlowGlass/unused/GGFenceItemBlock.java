package kkaylium.GlowGlass.unused;

import kkaylium.GlowGlass.blocks.GGBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Icon;

public class GGFenceItemBlock extends ItemBlock{

	public GGFenceItemBlock(int par1) {
		super(par1);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata (int meta)
	{
	    return meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage (int meta)
	{
	    return GGBlocks.GlowFence.getIcon(0, meta);
	}

}
