package kkaylium.GlowGlass.rainbowSlimes;

import kkaylium.GlowGlass.items.GGItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class DropRainbowCrystal {
	@ForgeSubscribe
    public void onEntityDrop(LivingDropsEvent event) {
	if(event.entity instanceof EntityRainbowSlime) {
  		  event.entity.entityDropItem(new ItemStack(GGItems.glowCrystal, 1, 10), 0.0F);
  	  }
    }
}
