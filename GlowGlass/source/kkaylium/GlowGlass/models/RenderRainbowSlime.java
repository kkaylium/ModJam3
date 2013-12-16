package kkaylium.GlowGlass.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;

public class RenderRainbowSlime extends RenderLiving{

	private static final ResourceLocation rainbowSlimeTexture = new ResourceLocation("glowglass:assets/textures/entity/rainbowslime/RainbowSlime.png");
	public RenderRainbowSlime(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		
	}
	
	protected void scaleSlime(EntityRainbowSlime par1EntitySlime, float par2)
	{
	    float f1 = (float)par1EntitySlime.getSlimeSize();
	    float f2 = (par1EntitySlime.prevSquishFactor + (par1EntitySlime.squishFactor - par1EntitySlime.prevSquishFactor) * par2) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	}
	
	public void renderRainbowSlime(EntityRainbowSlime entityRainbowSlime, double par2, double par3, double par4, float par5, float par6)
	{
		super.doRenderLiving(entityRainbowSlime, par2, par3, par4, par5, par6);
	}
	
	public void doRenderLiving(EntityRainbowSlime entityRainbowSlime, double par2, double par3, double par4, float par5, float par6)
	{
		this.renderRainbowSlime(entityRainbowSlime, par2, par3, par4, par5, par6);
	}

	protected ResourceLocation getRainbowSlimeTextures(EntityRainbowSlime par1EntityRainbowSlime)
    {
        return rainbowSlimeTexture;
    }
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return new ResourceLocation("glowglass:textures/entity/rainbowslime/RainbowSlime.png");
		//return this.getRainbowSlimeTextures((EntityRainbowSlime)entity);
	}

}
