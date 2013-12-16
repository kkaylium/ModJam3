package kkaylium.GlowGlass;

import kkaylium.GlowGlass.blocks.GGBlocks;
import kkaylium.GlowGlass.gen.GGBiomeOreGen;
import kkaylium.GlowGlass.items.GGItems;
import kkaylium.GlowGlass.lib.GGRecipes;
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
import cpw.mods.fml.common.registry.LanguageRegistry;


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
		GGBlocks.GlowGateWHITEDefaultID = config.getBlock("Glow Gate White", 513).getInt();
		GGBlocks.GlowGateBLACKDefaultID = config.getBlock("Glow Gate Black", 514).getInt();
		GGBlocks.GlowGateREDDefaultID = config.getBlock("Glow Gate Red", 515).getInt();
		GGBlocks.GlowGateORANGEDefaultID = config.getBlock("Glow Gate Orange", 516).getInt();
		GGBlocks.GlowGateYELLOWDefaultID = config.getBlock("Glow Gate Yellow", 517).getInt();
		GGBlocks.GlowGateGREENDefaultID = config.getBlock("Glow Gate Green", 518).getInt();
		GGBlocks.GlowGateLIGHTBLUEDefaultID = config.getBlock("Glow Gate Light Blue", 519).getInt();
		GGBlocks.GlowGateBLUEDefaultID = config.getBlock("Glow Gate Blue", 520).getInt();
		GGBlocks.GlowGatePURPLEDefaultID = config.getBlock("Glow Gate Purple", 521).getInt();
		GGBlocks.GlowGatePINKDefaultID = config.getBlock("Glow Gate Pink", 522).getInt();
		GGBlocks.GlowGateSPECIALDefaultID = config.getBlock("Glow Gate Special", 523).getInt();
		
		GGItems.GlowCrystalDefaultID = config.getItem("Glow Crystal", 1000).getInt();
		
		config.save();
		
		GGBlocks.initBlocks();
		GGItems.initItems();
		GGRecipes.initRecipes();
		
		GameRegistry.registerWorldGenerator(new GGBiomeOreGen());
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.Glow Glass", "Glow Glass");
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		OreDictionary.registerOre(GGBlocks.GlowOre.getUnlocalizedName(), new ItemStack(GGItems.glowCrystal));
		
		//proxy.registerRenderInformation();
		//EntityRegistry.registerModEntity(EntityRainbowSlime.class, "RainbowSlime", 2, this, 80, 3, true);
        //EntityRegistry.addSpawn(EntityRainbowSlime.class, 5, 2, 6, EnumCreatureType.creature, BiomeGenBase.plains);
        //LanguageRegistry.instance().addStringLocalization("entity.instance.RainbowSlime.name", "Rainbow Slime");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
}
