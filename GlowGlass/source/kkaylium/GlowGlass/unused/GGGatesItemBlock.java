package kkaylium.GlowGlass.unused;

import kkaylium.GlowGlass.blocks.GGBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class GGGatesItemBlock extends ItemBlock{

	public GGGatesItemBlock(int par1) {
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
		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 10);
		
		unlocalizedName.append("item.");
		unlocalizedName.append("glowglass:");
		unlocalizedName.append("GlowFence");
		unlocalizedName.append(GGGateSuperType.gateNames[meta]);
		
		return unlocalizedName.toString();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamage(int metadata)
	{
		
		return GGBlocks.GlowGateTemp.getIcon(0, metadata);
	}
}
