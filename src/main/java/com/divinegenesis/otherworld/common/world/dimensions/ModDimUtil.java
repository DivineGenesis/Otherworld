package com.divinegenesis.otherworld.common.world.dimensions;

import com.divinegenesis.otherworld.Otherworld;
import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiFunction;
import java.util.function.Supplier;
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModDimUtil
{
    public static final DeferredRegister<ModDimension> DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Otherworld.MODID);

    public static DimensionType PURGATORY_DIMENSION;
    public static final RegistryObject<ModDimension> OTHERWORLD_MOD_DIMENSION = register(
            "purgatory", ModDimUtil::dimFactory);

    private static ModDimension dimFactory()
    {
        return new ModDimension() {
            @Override
            public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
                return (p_i225788_1_, p_i225788_2_) -> new PurgatoryDimension(p_i225788_1_, p_i225788_2_, 4);
            }
        };
    }

    private static RegistryObject<ModDimension> register(final String name, final Supplier<ModDimension> sup) {
        return DIMENSIONS.register(name, sup);
    }

    @Mod.EventBusSubscriber(modid = Otherworld.MODID)
    public static class EventDimensionType {
        @SubscribeEvent
        public static void onModDimensionRegister(final RegisterDimensionsEvent event) {
            Otherworld.LOGGER.info("Just unleashing Purgatory, nothing to worry about here!");
            ResourceLocation id = new ResourceLocation(Otherworld.MODID, "purgatory");
            if (DimensionType.byName(id) == null) {
                PURGATORY_DIMENSION = DimensionManager.registerDimension(id, OTHERWORLD_MOD_DIMENSION.get(), new PacketBuffer(Unpooled.buffer()), true);
                DimensionManager.keepLoaded(PURGATORY_DIMENSION, false);
            } else {
                PURGATORY_DIMENSION = DimensionType.byName(id);
            }
        }
    }
}