package kkaylium.GlowGlass.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockJukeBox;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemNyanCatRecord extends ItemRecord{

	@SuppressWarnings("rawtypes")
	private static final Map records = new HashMap();
	
	@SuppressWarnings("unchecked")
	public ItemNyanCatRecord(int par1, String par2Str) {
		super(par1, par2Str);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabMisc);
        records.put(par2Str, this);
	}
	
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par3World.getBlockId(par4, par5, par6) == Block.jukebox.blockID && par3World.getBlockMetadata(par4, par5, par6) == 0)
        {
            if (par3World.isRemote)
            {
                return true;
            }
            else
            {
                ((BlockJukeBox)Block.jukebox).insertRecord(par3World, par4, par5, par6, par1ItemStack);
                par3World.playAuxSFXAtEntity((EntityPlayer)null, 1005, par4, par5, par6, this.itemID);
                --par1ItemStack.stackSize;
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add(this.getRecordTitle());
    }

    @SideOnly(Side.CLIENT)
    public String getRecordTitle()
    {
        return "Awesomeness Of - Nyan Cat";
    }

//    @SideOnly(Side.CLIENT)
//    public static ItemRecord getRecord(String par0Str)
//    {
//        return (ItemRecord)records.get(par0Str);
//    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
    	this.itemIcon = iconRegister.registerIcon("glowglass:NyanRecord");
    	//return this.getIcon(iconRegister.registerIcon("glowglass:NyanRecord"));
    }
    
    public String getSoundFile()
    {
    	return "nyan.ogg";
    			//"return "glowglass:nyan.ogg";
    }

}