package com.divinegenesis.otherworld.common.data;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.item.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;

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

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.HUNGRY_CHEST)
                .patternLine("###")
                .patternLine("# #")
                .patternLine("###")
                .key('#', ModBlocks.GREATWOOD_PLANK)
                .setGroup(Otherworld.MODID)
                .addCriterion("mimic_core", InventoryChangeTrigger.Instance.forItems(ModItems.HEART))
                .build(consumer);
    }
}