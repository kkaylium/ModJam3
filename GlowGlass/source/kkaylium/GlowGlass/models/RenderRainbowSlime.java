package kkaylium.GlowGlass.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderRainbowSlime extends RenderLiving{

	private static final ResourceLocation rainbowSlimeTexture = new ResourceLocation("glowglass:assets/textures/entity/rainbowslime/RainbowSlime.png");
	private ModelBase scaleAmount;
	
	public RenderRainbowSlime(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3) {
		super(par1ModelBase, par3);
		this.scaleAmount = par2ModelBase;
	}
	
	protected void scaleSlime(EntityRainbowSlime par1EntitySlime, float par2)
	{
	    float f1 = (float)par1EntitySlime.getSlimeSize();
	    float f2 = (par1EntitySlime.prevSquishFactor + (par1EntitySlime.squishFactor - par1EntitySlime.prevSquishFactor) * par2) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	}
	
	protected int shouldSlimeRenderPass(EntityRainbowSlime par1EntitySlime, int par2, float par3)
    {
        if (par1EntitySlime.isInvisible())
        {
            return 0;
        }
        else if (par2 == 0)
        {
            this.setRenderPassModel(this.scaleAmount);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            return 1;
        }
        else
        {
            if (par2 == 1)
            {
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            return -1;
        }
    }

	
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSlime((EntityRainbowSlime)par1EntityLivingBase, par2);
    }
	
	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
    {
        return this.shouldSlimeRenderPass((EntityRainbowSlime)par1EntityLivingBase, par2, par3);
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
