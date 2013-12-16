package kkaylium.GlowGlass.models;

import kkaylium.GlowGlass.items.GGItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityRainbowSlime extends EntityAnimal{

	public EntityRainbowSlime(World par1World) {
		super(par1World);
		//this.texture("glowglass:RainbowSlime");
		this.getNavigator().setAvoidsWater(true);
		this.setSize(1.0F, 1.0F);
		this.isImmuneToFire = false;
		float var2 = 0.25F;
		
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 0.38F));
		this.tasks.addTask(2, new EntityAITempt(this, 0.3F, GGItems.glowCrystal.itemID, false));
		this.tasks.addTask(3, new EntityAIWander(this, var2));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	//public int getMaxHealth()
	//{
		//return 16;
	//}
	
	protected int getDropItemId() 
	{
        return GGItems.glowCrystal.itemID;
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}

}
