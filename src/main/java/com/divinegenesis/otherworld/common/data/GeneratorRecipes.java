package com.divinegenesis.otherworld.common.data;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.blocks.ModBlocks;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
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
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.ARCANE_PEDESTAL)
                .patternLine("###")
                .patternLine(" # ")
                .patternLine("###")
                .key('#', Blocks.COBBLESTONE)
                .setGroup(Otherworld.MODID)
                .addCriterion("cobblestone", InventoryChangeTrigger.Instance.forItems(Blocks.COBBLESTONE))
                .build(consumer);
    }
}