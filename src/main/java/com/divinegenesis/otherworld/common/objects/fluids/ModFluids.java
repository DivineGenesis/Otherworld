package com.divinegenesis.otherworld.common.objects.fluids;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.objects.fluids.types.IchorFluid;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModFluids
{
    public static final List<Fluid> FLUID = new ArrayList<Fluid>();

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Otherworld.MODID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Otherworld.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, Otherworld.MODID);

    public static RegistryObject<FlowingFluid> ichor_fluid = FLUIDS.register("ichor_fluid", () -> new IchorFluid.Source(ModFluids.ichor_fluid_properties));
    public static RegistryObject<FlowingFluid> ichor_fluid_flowing = FLUIDS.register("ichor_fluid_flowing", () -> new IchorFluid.Flowing(ModFluids.ichor_fluid_properties));
    public static RegistryObject<FlowingFluidBlock> ichor_fluid_block = BLOCKS.register("ichor_fluid_block", () -> new FlowingFluidBlock(ichor_fluid, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
    public static RegistryObject<Item> ichor_fluid_bucket = ITEMS.register("ichor_bucket", () -> new BucketItem(ichor_fluid, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(Otherworld.OWTAB)));
    public static final IchorFluid.Properties ichor_fluid_properties = new IchorFluid.Properties(ichor_fluid, ichor_fluid_flowing, FluidAttributes.builder(new ResourceLocation(""), new ResourceLocation("")).color(0xffcc4af5).density(1500).viscosity(1500).temperature(310)).explosionResistance(100.0F).bucket(ichor_fluid_bucket).block(ichor_fluid_block);

    public ModFluids() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        FLUIDS.register(modEventBus);
    }

}
