package kkaylium.GlowGlass.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class GGGemItemBlock extends ItemBlock{
	

	public GGGemItemBlock(int par1) {
		super(par1);
		this.setHasSubtypes(true);
		
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
		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 10);
		
		unlocalizedName.append("item.");
		unlocalizedName.append("glowglass:");
		unlocalizedName.append("GlowBlock");
		unlocalizedName.append(GGGemBlock.blockNames[meta]);
		
		return unlocalizedName.toString();
	}

}
