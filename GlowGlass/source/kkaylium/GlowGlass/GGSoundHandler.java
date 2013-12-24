package kkaylium.GlowGlass;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class GGSoundHandler {

	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void onSoundsLoaded(SoundLoadEvent event)
	{
		SoundManager manager = event.manager;
		
		manager.soundPoolStreaming.addSound("glowglass:nyan.ogg");
	}
}
