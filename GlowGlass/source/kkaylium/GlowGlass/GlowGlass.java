package kkaylium.GlowGlass;

import kkaylium.GlowGlass.blocks.GGBlocks;
import kkaylium.GlowGlass.gen.GGBiomeOreGen;
import kkaylium.GlowGlass.items.GGItems;
import kkaylium.GlowGlass.lib.GGRecipes;
import kkaylium.GlowGlass.rainbowSlimes.DropRainbowCrystal;
import kkaylium.GlowGlass.rainbowSlimes.EntityRainbowSlime;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod (modid = "glowglass", name = "GlowGlass", version = "1.1.0")
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
		
		MinecraftForge.EVENT_BUS.register(new DropRainbowCrystal());
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		//Stuff Goes Here
		GGBlocks.GlowGlassDefaultID = config.getBlock("Glow Glass", 500).getInt();
		GGBlocks.GlowOreDefaultID = config.getBlock("Glow Ore", 501).getInt();
		GGBlocks.GlowBlockDefaultID = config.getBlock("Glow Block", 524).getInt();
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
		
		//GGItems.GlowDoorItemWHITEDefaultID = config.getItem("Glow Door WHITE", 1001).getInt();
		//GGItems.GlowDoorItemBLACKDefaultID = config.getItem("Glow Door BLACK", 1002).getInt();
		//GGItems.GlowDoorItemREDDefaultID = config.getItem("Glow Door RED", 1003).getInt();
		//GGItems.GlowDoorItemORANGEDefaultID = config.getItem("Glow Door ORANGE", 1004).getInt();
		//GGItems.GlowDoorItemYELLOWDefaultID = config.getItem("Glow Door YELLOW", 1005).getInt();
		//GGItems.GlowDoorItemGREENDefaultID = config.getItem("Glow Door GREEN", 1006).getInt();
		//GGItems.GlowDoorItemLIGHTBLUEDefaultID = config.getItem("Glow Door LIGHTBLUE", 1007).getInt();
		//GGItems.GlowDoorItemBLUEDefaultID = config.getItem("Glow Door BLUE", 1008).getInt();
		//GGItems.GlowDoorItemPURPLEDefaultID = config.getItem("Glow Door PURPLE", 1009).getInt();
		//GGItems.GlowDoorItemPINKDefaultID = config.getItem("Glow Door PINK", 1010).getInt();
		
		
		//GGBlocks.GlowDoorWHITEDefaultID = config.getItem("Glow Door WHITE", 600).getInt();
		/*GGBlocks.GlowDoorBLACKDefaultID = config.getItem("Glow Door BLACK", 525).getInt();
		GGBlocks.GlowDoorREDDefaultID = config.getItem("Glow Door RED", 526).getInt();
		GGBlocks.GlowDoorORANGEDefaultID = config.getItem("Glow Door ORANGE", 527).getInt();
		GGBlocks.GlowDoorYELLOWDefaultID = config.getItem("Glow Door YELLOW", 528).getInt();
		GGBlocks.GlowDoorGREENDefaultID = config.getItem("Glow Door GREEN", 529).getInt();
		GGBlocks.GlowDoorLIGHTBLUEDefaultID = config.getItem("Glow Door LIGHTBLUE", 530).getInt();
		GGBlocks.GlowDoorBLUEDefaultID = config.getItem("Glow Door BLUE", 531).getInt();
		GGBlocks.GlowDoorPURPLEDefaultID = config.getItem("Glow Door PURPLE", 532).getInt();
		GGBlocks.GlowDoorPINKDefaultID = config.getItem("Glow Door PINK", 533).getInt();
		*/
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
		
		proxy.registerRenderInformation();
		EntityRegistry.registerModEntity(EntityRainbowSlime.class, "RainbowSlime", 2, this, 80, 3, true);
        EntityRegistry.addSpawn(EntityRainbowSlime.class, 5, 2, 6, EnumCreatureType.creature, BiomeGenBase.plains);
        LanguageRegistry.instance().addStringLocalization("entity.RainbowSlime.name", "Rainbow Slime");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
}
