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

//    @Override
//    protected void validate(Map<ResourceLocation, LootTable> map, ValidationResults validationresults) {
//        map.forEach((name, table) -> LootTableManager.func_215302_a(validationresults, name, table, map::get));
//    }

    private static class Blocks extends BlockLootTables {

        @Override
        protected void addTables()
        {
            //Generates to drop self by default
            ModBlocks.BLOCKS.forEach(block -> this.registerDropSelfLootTable(block));

            //TODO: pretty sure this is overly complicated... maybe redesign & learn how to do this :D
            //overriders
            //this.registerLootTable(ModBlocks.CRYSTAL_HEART, (p_218496_0_) -> func_218519_a(p_218496_0_, ItemLootEntry.builder(ModItems.HEART).acceptFunction(SetCount.builder(RandomValueRange.of(1, 1)))));
            this.registerDropping(ModBlocks.CRYSTAL_HEART, ModItems.HEART);
            this.registerLootTable(ModBlocks.HUNGRY_CHEST, BlockLootTables::droppingWithName);

        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
             return ModBlocks.BLOCKS.stream().collect(Collectors.toList());
        }
    }
}