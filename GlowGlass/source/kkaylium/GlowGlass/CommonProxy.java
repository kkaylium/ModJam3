package kkaylium.GlowGlass;

import kkaylium.GlowGlass.rainbowSlimes.EntityRainbowSlime;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy {
	
	public void registerRenderInformation()
	{
		EntityRegistry.registerGlobalEntityID(EntityRainbowSlime.class, "RainbowSlime", EntityRegistry.findGlobalUniqueEntityId(), 10, 0);
	}

}
