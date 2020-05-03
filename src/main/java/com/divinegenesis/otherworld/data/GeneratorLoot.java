package com.divinegenesis.otherworld.data;


import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.objects.entities.ModEntities;
import com.divinegenesis.otherworld.common.objects.items.ModItems;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.functions.SetCount;

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
                Pair.of(Blocks::new, LootParameterSets.BLOCK),
                Pair.of(Entities::new, LootParameterSets.ENTITY)
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
            this.registerLootTable(ModBlocks.URN, LootTable.builder().addLootPool(LootPool.builder()
                    .rolls(RandomValueRange.of(1, 3))
                    .addEntry(ItemLootEntry.builder(Items.EXPERIENCE_BOTTLE).weight(50).acceptFunction(SetCount.builder(RandomValueRange.of(2, 5))))
                    .addEntry(ItemLootEntry.builder(ModItems.RECALL_POTION).weight(22))
                    .addEntry(ItemLootEntry.builder(Items.ENDER_PEARL).weight(8))
                    .addEntry(ItemLootEntry.builder(Items.BONE).weight(12).acceptFunction(SetCount.builder(RandomValueRange.of(1, 2))))
                    .addEntry(ItemLootEntry.builder(Items.STRING).weight(12))
                    .addEntry(ItemLootEntry.builder(Items.SPIDER_EYE).weight(12).acceptFunction(SetCount.builder(RandomValueRange.of(1, 3))))
                    .addEntry(ItemLootEntry.builder(Items.ROTTEN_FLESH).weight(17).acceptFunction(SetCount.builder(RandomValueRange.of(4, 7))))
                    .addEntry(ItemLootEntry.builder(Items.IRON_NUGGET).weight(8).acceptFunction(SetCount.builder(RandomValueRange.of(2, 8))))
                    .addEntry(ItemLootEntry.builder(Items.GOLD_NUGGET).weight(5).acceptFunction(SetCount.builder(RandomValueRange.of(2, 6))))
                    .addEntry(ItemLootEntry.builder(Items.TORCH).weight(28).acceptFunction(SetCount.builder(RandomValueRange.of(3, 8))))));

        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
             return ModBlocks.BLOCKS.stream().collect(Collectors.toList());
        }
    }

    private static class Entities extends EntityLootTables
    {
        @Override
        protected void addTables() {
            this.registerLootTable(ModEntities.MANDRAKE, LootTable.builder().addLootPool(LootPool.builder().addEntry(ItemLootEntry.builder(ModItems.MANDRAKE_ROOT))));
        }

        @Override
        protected Iterable<EntityType<?>> getKnownEntities() {
            return ModEntities.ENTITY_TYPES.stream().collect(Collectors.toList());
        }
    }
}