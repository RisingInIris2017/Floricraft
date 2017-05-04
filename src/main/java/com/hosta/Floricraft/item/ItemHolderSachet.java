package com.hosta.Floricraft.item;

import com.hosta.Floricraft.Floricraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemHolderSachet extends ItemHolder {

	public ItemHolderSachet(String name)
	{
		super(name);
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
        playerIn.openGui(Floricraft.instance, 1, worldIn, (int)playerIn.posX, (int)playerIn.posY, (int)playerIn.posZ);
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}
}
