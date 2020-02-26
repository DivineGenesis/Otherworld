package com.divinegenesis.otherworld.common.recipes;

import com.divinegenesis.otherworld.Otherworld;
import net.minecraft.item.crafting.IRecipeSerializer;

public class RecipeSerializer
{
    public static IRecipeSerializer<NBTShapelessRecipe>
            NBT_SHAPELESS = IRecipeSerializer.register("", new NBTShapelessRecipe.Serializer());
}
