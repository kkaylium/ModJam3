package kkaylium.GlowGlass;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;


@Mod (modid = "glowglass", name = "GlowGlass", version = "0.0.001")
@NetworkMod (clientSideRequired = true, serverSideRequired = false)
public class GlowGlass 
{
	@Instance
	public static GlowGlass instance;
	
	@SidedProxy(clientSide = "kkaylium.GlowGlass.ClientProxy", serverSide = "kkaylium.GlowGlass.CommonProxy")
	public static CommonProxy proxy; 
	
	@EventHandler
	public void preInit()
	{
		
	}
	
	@EventHandler
	public void load()
	{
		
	}
	
	@EventHandler
	public void postInit()
	{
		
	}
	
}
