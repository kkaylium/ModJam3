package kkaylium.GlowGlass.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class GlowCrystalOresItemBlock extends ItemBlock{

	public GlowCrystalOresItemBlock(int par1) {
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
		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 1);
		
		unlocalizedName.append("item.");
		unlocalizedName.append("glowglass:");
		unlocalizedName.append("GlowGlass");
		unlocalizedName.append(BlockGlowGlass.glassNames[meta]);
		
		return unlocalizedName.toString();
	}

}
