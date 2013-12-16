package kkaylium.GlowGlass.models;

import kkaylium.GlowGlass.items.GGItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityRainbowSlime extends EntityAnimal{

	public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    private int slimeJumpDelay;
    
	public EntityRainbowSlime(World par1World) {
		super(par1World);
		//this.texture("glowglass:RainbowSlime");
		int i = 1 << this.rand.nextInt(3);
        this.yOffset = 0.0F;
        this.slimeJumpDelay = this.rand.nextInt(20) + 10;
        this.setSlimeSize(i);
		this.getNavigator().setAvoidsWater(true);
		this.setSize(1.0F, 1.0F);
		this.isImmuneToFire = false;
		float var2 = 0.25F;
		
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 0.38F));
		this.tasks.addTask(2, new EntityAITempt(this, 0.3F, GGItems.glowCrystal.itemID, false));
		this.tasks.addTask(3, new EntityAIWander(this, var2));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		
	}
	
	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)1));
    }

    protected void setSlimeSize(int par1)
    {
        this.dataWatcher.updateObject(16, new Byte((byte)par1));
        this.setSize(0.6F * (float)par1, 0.6F * (float)par1);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute((double)(par1 * par1));
        this.setHealth(this.getMaxHealth());
        this.experienceValue = par1;
    }
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	public int getSlimeSize()
	{
	    return this.dataWatcher.getWatchableObjectByte(16);
    }
	
	protected String getSlimeParticle()
    {
        return "slime";
    }
	
	protected String getJumpSound()
    {
        return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }
	
	public void onUpdate()
    {
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == 0 && this.getSlimeSize() > 0)
        {
            this.isDead = true;
        }

        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        boolean flag = this.onGround;
        super.onUpdate();
        int i;

        if (this.onGround && !flag)
        {
            i = this.getSlimeSize();

            for (int j = 0; j < i * 8; ++j)
            {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
                float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
                this.worldObj.spawnParticle(this.getSlimeParticle(), this.posX + (double)f2, this.boundingBox.minY, this.posZ + (double)f3, 0.0D, 0.0D, 0.0D);
            }

            if (this.makesSoundOnLand())
            {
                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }

            this.squishAmount = -0.5F;
        }
        else if (!this.onGround && flag)
        {
            this.squishAmount = 1.0F;
        }

        this.alterSquishAmount();

        if (this.worldObj.isRemote)
        {
            i = this.getSlimeSize();
            this.setSize(0.6F * (float)i, 0.6F * (float)i);
        }
    }
	
	 protected void updateEntityActionState()
	    {
	        this.despawnEntity();
	        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

	        if (entityplayer != null)
	        {
	            this.faceEntity(entityplayer, 10.0F, 20.0F);
	        }

	        if (this.onGround && this.slimeJumpDelay-- <= 0)
	        {
	            this.slimeJumpDelay = this.getJumpDelay();

	            if (entityplayer != null)
	            {
	                this.slimeJumpDelay /= 3;
	            }

	            this.isJumping = true;

	            if (this.makesSoundOnJump())
	            {
	                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
	            }

	            this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
	            this.moveForward = (float)(1 * this.getSlimeSize());
	        }
	        else
	        {
	            this.isJumping = false;

	            if (this.onGround)
	            {
	                this.moveStrafing = this.moveForward = 0.0F;
	            }
	        }
	    }

	protected void alterSquishAmount()
	{
	    this.squishAmount *= 0.6F;
	}
	
	protected int getJumpDelay()
    {
        return this.rand.nextInt(20) + 10;
    }

    protected EntityRainbowSlime createInstance()
    {
        return new EntityRainbowSlime(this.worldObj);
    }
	
	protected int getDropItemId() 
	{
        return GGItems.glowCrystal.itemID;
	}
	
    public void setDead()
    {
        int i = this.getSlimeSize();

        if (!this.worldObj.isRemote && i > 1 && this.getHealth() <= 0.0F)
        {
            int j = 2 + this.rand.nextInt(3);

            for (int k = 0; k < j; ++k)
            {
                float f = ((float)(k % 2) - 0.5F) * (float)i / 4.0F;
                float f1 = ((float)(k / 2) - 0.5F) * (float)i / 4.0F;
                EntityRainbowSlime entityslime = this.createInstance();
                entityslime.setSlimeSize(i / 2);
                entityslime.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360.0F, 0.0F);
                this.worldObj.spawnEntityInWorld(entityslime);
            }
        }

        super.setDead();
    }
    
    protected String getHurtSound()
    {
        return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }
    
    protected String getDeathSound()
    {
        return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }
    
    protected float getSoundVolume()
    {
        return 0.4F * (float)this.getSlimeSize();
    }
    
    protected boolean makesSoundOnJump()
    {
        return this.getSlimeSize() > 0;
    }
	
    protected boolean makesSoundOnLand()
    {
        return this.getSlimeSize() > 0;
    } 
    
	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}

}
