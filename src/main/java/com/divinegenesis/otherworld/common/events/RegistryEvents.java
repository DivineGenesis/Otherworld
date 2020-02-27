package com.divinegenesis.otherworld.common.events;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.types.HungryChestTE;
import com.divinegenesis.otherworld.common.objects.enchants.ModEnchants;
import com.divinegenesis.otherworld.common.objects.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
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
        ModBlocks.BLOCKS.forEach(block -> event.getRegistry()
                .register(new BlockItem(block, new Item.Properties().group(Otherworld.OWTAB)).setRegistryName(block.getRegistryName())));

        Otherworld.LOGGER.info("Registering items...");
        ModItems.ITEMS.forEach(item -> event.getRegistry().register(item));
    }

    @SubscribeEvent
    public static void OnEnchantRegistry(final RegistryEvent.Register<Enchantment> event)
    {
        ModEnchants.ENCHANTS.forEach(enchantment -> event.getRegistry().register(enchantment));
    }

    @SubscribeEvent
    public static void OnTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event)
    {
        event.getRegistry().registerAll(
                ModTileEntities.HUNGRY_CHEST = TileEntityType.Builder.create(HungryChestTE::new, ModBlocks.HUNGRY_CHEST).build(null).setRegistryName(new ResourceLocation(Otherworld.MODID, "hungrychest_te"))
        );
    }

    @SubscribeEvent
    public static void OnContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event)
    {
        event.getRegistry().registerAll();
    }
}
