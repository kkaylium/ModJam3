package kkaylium.GlowGlass.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class GlowFenceItemBlock extends ItemBlock{
	
	public GlowFenceItemBlock(int par1) {
		super(par1);
		
	}
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		StringBuilder unlocalizedName = new StringBuilder();
		//int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 10);
		
		unlocalizedName.append("item.");
		unlocalizedName.append("glowglass:");
		unlocalizedName.append("GlowFence");
		//unlocalizedName.append(BlockGlowFence.fenceNames[meta]);
		//
		return unlocalizedName.toString();
	}
	
	//@SideOnly(Side.CLIENT)
	//@Override
	//public Icon getIconFromDamage(int metadata)
	//{
		
	//	return GGBlocks.GlowFence.getIcon(0, metadata);
	//}
}
