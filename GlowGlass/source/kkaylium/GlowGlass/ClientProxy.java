package kkaylium.GlowGlass;

import kkaylium.GlowGlass.rainbowSlimes.EntityRainbowSlime;
import kkaylium.GlowGlass.rainbowSlimes.ModelRainbowSlime;
import kkaylium.GlowGlass.rainbowSlimes.RenderRainbowSlimeTwo;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	public void registerRenderInformation()
	{
		super.registerRenderInformation();
		//RenderingRegistry.registerEntityRenderingHandler(EntityRainbowSlime.class, new RenderRainbowSlime(ModelSlime(16), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRainbowSlime.class,
				new RenderRainbowSlimeTwo(new ModelRainbowSlime(16), new ModelRainbowSlime(0), 0.5F));
	}
}
