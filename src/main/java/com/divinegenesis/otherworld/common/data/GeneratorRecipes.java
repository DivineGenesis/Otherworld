package com.divinegenesis.otherworld.common.data;

import com.divinegenesis.otherworld.common.objects.items.ModItems;
import com.divinegenesis.otherworld.common.recipes.PoppetShapelessRecipe;
import com.divinegenesis.otherworld.common.recipes.ShapelessNBTRecipeBuilder;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class GeneratorRecipes extends RecipeProvider
{
    public GeneratorRecipes(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.BONE_NEEDLE, 2)
                .addIngredient(Items.BONE, 2)
                .addCriterion("bone", InventoryChangeTrigger.Instance.forItems(Items.BONE))
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(ModItems.TAGLOCK)
                .addIngredient(Items.GLASS_BOTTLE, 1)
                .addIngredient(ModItems.BONE_NEEDLE, 1)
                .addCriterion("bone_needles", InventoryChangeTrigger.Instance.forItems(ModItems.BONE_NEEDLE))
                .build(consumer);

        ShapelessNBTRecipeBuilder.shapelessRecipe(ModItems.POPPET)
                .addIngredient(ModItems.TAGLOCK)
                .addIngredient(ModItems.MANDRAKE_ROOT)
                .addCriterion("taglock", InventoryChangeTrigger.Instance.forItems(ModItems.TAGLOCK))
                .build(consumer);


    }
}