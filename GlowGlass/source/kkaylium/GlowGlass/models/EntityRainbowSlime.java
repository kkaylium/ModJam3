package kkaylium.GlowGlass.models;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityRainbowSlime extends EntityAnimal{

	public EntityRainbowSlime(World par1World) {
		super(par1World);
		
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}

}
