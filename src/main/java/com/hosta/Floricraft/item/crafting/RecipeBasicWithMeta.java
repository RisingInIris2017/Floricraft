package com.hosta.Floricraft.item.crafting;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeBasicWithMeta implements IRecipe {

	private final ItemStack ITEM_RESULT;
	private final ItemStack[] ITEMS;

	public RecipeBasicWithMeta(Item result, ItemStack[] items)
	{
		this(new ItemStack(result, 1), items);
	}

	public RecipeBasicWithMeta(Block result, ItemStack[] items)
	{
		this(new ItemStack(result, 1), items);
	}
	
	public RecipeBasicWithMeta(ItemStack result, ItemStack[] items)
	{
		this.ITEM_RESULT = result;
		this.ITEMS = items;
	}
	
	@Override
	public boolean matches(InventoryCrafting inv, World worldIn)
	{
		for (int i = 0; i < inv.getSizeInventory(); i++)
        {
            ItemStack itemstack = inv.getStackInSlot(i);
            
            if (itemstack.isEmpty())
            {
            	if (!ITEMS[i].isEmpty())
            	{
                	return false;
            	}
            }
            else if (itemstack.getItem() != ITEMS[i].getItem())
            {
            	return false;
            }
            else if (ITEMS[i].getMetadata() != OreDictionary.WILDCARD_VALUE && itemstack.getMetadata() != ITEMS[i].getMetadata())
            {
            	return false;
            }
        }
        
        return true;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv)
	{
		return ITEM_RESULT.copy();
	}

	@Override
	public boolean func_194133_a(int p_194133_1_, int p_194133_2_)
	{
        return p_194133_1_ >= 3 && p_194133_2_ >= 3;
	}

	@Override
	public ItemStack getRecipeOutput()
	{
        return ItemStack.EMPTY;
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv)
	{
		NonNullList<ItemStack> list = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < list.size(); i++)
        {
            ItemStack itemstack = inv.getStackInSlot(i);
            list.set(i, net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack));
        }
		
		return list;
	}
}
