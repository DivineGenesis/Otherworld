package com.divinegenesis.otherworld.common.recipes;

import com.divinegenesis.otherworld.Otherworld;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;

public class RecipeSerializer
{
    public static IRecipeSerializer<NBTShapelessRecipe>
            NBT_SHAPELESS = IRecipeSerializer.register("", new NBTShapelessRecipe.Serializer());

    public static CookingRecipeSerializer<SoulForgeRecipe> SOUL_FORGE;// = IRecipeSerializer.register("soulforge_crafting", new CookingRecipeSerializer<SoulForgeRecipe>(SoulForgeRecipe::new));
}
