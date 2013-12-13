package kkaylium.GlowGlass;

import kkaylium.GlowGlass.blocks.GGBlocks;
import kkaylium.GlowGlass.items.GGItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
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
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		GGBlocks.initBlocks();
		GGItems.initItems();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
}
