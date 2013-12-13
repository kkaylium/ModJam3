package kkaylium.GlowGlass.items;

import java.util.Random;

import net.minecraft.item.Item;

public class ItemGlowCrystal extends Item{

	public ItemGlowCrystal(int par1) {
		super(par1);
		
	}
	
	public int quantityDropped(Random par1Random)
    {
        return 1;
    }

}
