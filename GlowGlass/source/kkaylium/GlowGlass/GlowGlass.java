package kkaylium.GlowGlass;

import kkaylium.GlowGlass.blocks.GGBlocks;
import kkaylium.GlowGlass.gen.GGBiomeOreGen;
import kkaylium.GlowGlass.items.GGItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod (modid = "glowglass", name = "GlowGlass", version = "0.0.001")
@NetworkMod (clientSideRequired = true, serverSideRequired = false)
public class GlowGlass 
{
	@Instance
	public static GlowGlass instance;
	
	@SidedProxy(clientSide = "kkaylium.GlowGlass.ClientProxy", serverSide = "kkaylium.GlowGlass.CommonProxy")
	public static CommonProxy proxy; 
	
	public static CreativeTabs GGTab = new GlowGlassCreativeTab(CreativeTabs.getNextID(), "Glow Glass");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		//Stuff Goes Here
		GGBlocks.GlowGlassDefaultID = config.getBlock("Glow Glass", 500).getInt();
		GGBlocks.GlowOreDefaultID = config.getBlock("Glow Ore", 501).getInt();
		GGBlocks.GlowFenceWHITEDefaultID = config.getBlock("Glow Fence White", 502).getInt();
		GGBlocks.GlowFenceBLACKDefaultID = config.getBlock("Glow Fence Black", 503).getInt();
		GGBlocks.GlowFenceREDDefaultID = config.getBlock("Glow Fence Red", 504).getInt();
		GGBlocks.GlowFenceORANGEDefaultID = config.getBlock("Glow Fence Orange", 505).getInt();
		GGBlocks.GlowFenceYELLOWDefaultID = config.getBlock("Glow Fence Yellow", 506).getInt();
		GGBlocks.GlowFenceGREENDefaultID = config.getBlock("Glow Fence Green", 507).getInt();
		GGBlocks.GlowFenceLIGHTBLUEDefaultID = config.getBlock("Glow Fence Light Blue", 508).getInt();
		GGBlocks.GlowFenceBLUEDefaultID = config.getBlock("Glow Fence Blue", 509).getInt();
		GGBlocks.GlowFencePURPLEDefaultID = config.getBlock("Glow Fence Purple", 510).getInt();
		GGBlocks.GlowFencePINKDefaultID = config.getBlock("Glow Fence Pink", 511).getInt();
		GGBlocks.GlowFenceSPECIALDefaultID = config.getBlock("Glow Fence Special", 512).getInt();
		
		GGItems.GlowCrystalDefaultID = config.getItem("Glow Crystal", 1000).getInt();
		
		config.save();
		
		GGBlocks.initBlocks();
		GGItems.initItems();
	
		GameRegistry.registerWorldGenerator(new GGBiomeOreGen());
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		OreDictionary.registerOre(GGBlocks.GlowOre.getUnlocalizedName(), new ItemStack(GGItems.glowCrystal));
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
}
