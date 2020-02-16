package com.divinegenesis.otherworld.common.data;


import com.divinegenesis.otherworld.common.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.item.ModItems;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GeneratorLoot extends LootTableProvider
{
    public GeneratorLoot(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(Blocks::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker)
    {
        map.forEach((resourceLocation, lootTable) ->
                LootTableManager.func_227508_a_(validationtracker, resourceLocation, lootTable));
    }

    private static class Blocks extends BlockLootTables {

        @Override
        protected void addTables()
        {
            //Generates to drop self by default
            ModBlocks.BLOCKS.forEach(block -> this.registerDropSelfLootTable(block));

            this.registerDropping(ModBlocks.CRYSTAL_HEART, ModItems.HEART);
            this.registerLootTable(ModBlocks.HUNGRY_CHEST, BlockLootTables::droppingWithName);
            this.registerLootTable(ModBlocks.URN, LootTable.builder().addLootPool(LootPool.builder().rolls(ConstantRange.of(3)).addEntry(ItemLootEntry.builder(Items.EXPERIENCE_BOTTLE))));

        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
             return ModBlocks.BLOCKS.stream().collect(Collectors.toList());
        }
    }
}