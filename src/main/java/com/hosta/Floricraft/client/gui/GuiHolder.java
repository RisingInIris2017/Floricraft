package com.hosta.Floricraft.client.gui;

import org.lwjgl.opengl.GL11;

import com.hosta.Floricraft.Reference;
import com.hosta.Floricraft.inventory.ContainerHolder;
import com.hosta.Floricraft.item.ItemHolder;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class GuiHolder extends GuiContainer {

    private static ResourceLocation texture;
	
	public GuiHolder(EntityPlayer player, int ID)
	{
		super(new ContainerHolder(player, ID));
		int slotCount = ((ContainerHolder) this.inventorySlots).getSlotCount();
		texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/container/holder_slot" + slotCount + ".png");
		this.ySize = slotCount * 18 + 114;
    }
 
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        if (this.mc.thePlayer.getHeldItemMainhand() != null && this.mc.thePlayer.getHeldItemMainhand().getItem() instanceof ItemHolder)
        {
        	this.fontRendererObj.drawString(this.mc.thePlayer.getHeldItemMainhand().getDisplayName(), 8, 6, 4210752);
        }
        else if (this.mc.thePlayer.getHeldItemOffhand() != null && this.mc.thePlayer.getHeldItemOffhand().getItem() instanceof ItemHolder)
        {
        	this.fontRendererObj.drawString(this.mc.thePlayer.getHeldItemOffhand().getDisplayName(), 8, 6, 4210752);
        }
        this.fontRendererObj.drawString("Inventory", 8, this.ySize - 94, 4210752);
    }
 
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}