package kkaylium.GlowGlass;

import kkaylium.GlowGlass.models.EntityRainbowSlime;
import kkaylium.GlowGlass.models.ModelRainbowSlime;
import kkaylium.GlowGlass.models.RenderRainbowSlime;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	public void registerRenderInformation()
	{
		super.registerRenderInformation();
		RenderingRegistry.registerEntityRenderingHandler(EntityRainbowSlime.class, new RenderRainbowSlime(new ModelRainbowSlime(16), null, 0.5F));
		
	}
}
