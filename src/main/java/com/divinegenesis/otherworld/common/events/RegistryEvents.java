package com.divinegenesis.otherworld.common.events;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.types.HungryChestTE;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.types.SoulForgeTE;
import com.divinegenesis.otherworld.common.objects.enchants.ModEnchants;
import com.divinegenesis.otherworld.common.objects.entities.ModEntities;
import com.divinegenesis.otherworld.common.objects.entities.types.MandrakeEntity;
import com.divinegenesis.otherworld.common.objects.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents
{
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> event)
    {
        Otherworld.LOGGER.info("Registering blocks...");
        ModBlocks.BLOCKS.forEach(block -> event.getRegistry().register(block));
    }

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event)
    {
        Otherworld.LOGGER.info("Registering blockitems...");
        ModBlocks.BLOCKS.forEach(block -> {
            Item.Properties properties = new Item.Properties();

            if(!(block instanceof CropsBlock))
                properties.group(Otherworld.OWTAB);

            event.getRegistry()
                    .register(new BlockItem(block, properties).setRegistryName(block.getRegistryName()));
        });

        Otherworld.LOGGER.info("Registering items...");
        ModItems.ITEMS.forEach(item -> event.getRegistry().register(item));
        ModEntities.ENTITY_TYPES.forEach(entityType -> event.getRegistry().register(new SpawnEggItem(entityType, 5, 8, new Item.Properties().group(Otherworld.OWTAB)).setRegistryName(entityType.getRegistryName()+"_egg")));
    }

    @SubscribeEvent
    public static void OnEnchantRegistry(final RegistryEvent.Register<Enchantment> event)
    {
        ModEnchants.ENCHANTS.forEach(enchantment -> event.getRegistry().register(enchantment));
    }

    @SubscribeEvent
    public static void OnTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().registerAll(
                ModTileEntities.HUNGRY_CHEST = (TileEntityType<HungryChestTE>) TileEntityType.Builder.create(HungryChestTE::new, ModBlocks.HUNGRY_CHEST).build(null).setRegistryName(new ResourceLocation(Otherworld.MODID, "hungrychest_te")),
                ModTileEntities.SOUL_FORGE = TileEntityType.Builder.create(SoulForgeTE::new, ModBlocks.SOUL_FORGE).build(null).setRegistryName(new ResourceLocation(Otherworld.MODID, "soulforge_te"))
        );
    }

    @SubscribeEvent
    public static void OnEntityRegistry(final RegistryEvent.Register<EntityType<?>> event)
    {
        ModEntities.ENTITY_TYPES.forEach(entityType -> event.getRegistry().register(entityType));
    }
}