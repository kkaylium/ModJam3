package kkaylium.GlowGlass;

import kkaylium.GlowGlass.models.EntityRainbowSlime;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy {
	
	public void registerRenderInformation()
	{
		EntityRegistry.registerGlobalEntityID(EntityRainbowSlime.class, "RainbowSlime", EntityRegistry.findGlobalUniqueEntityId(), 10, 0);
	}

	public void initTextures() 
	{
		
	}
}
