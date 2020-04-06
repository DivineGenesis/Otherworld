package com.divinegenesis.otherworld.common.recipes;

import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class SoulForgeRecipe extends AbstractCookingRecipe {
    public SoulForgeRecipe(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
        super(ModRecipeType.SOUL_FORGE, idIn, groupIn, ingredientIn, resultIn, experienceIn, cookTimeIn);
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.SOUL_FORGE);
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return RecipeSerializer.SOUL_FORGE;
    }
}
