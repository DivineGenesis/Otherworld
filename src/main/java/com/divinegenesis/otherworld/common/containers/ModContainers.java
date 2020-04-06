package com.divinegenesis.otherworld.common.containers;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.containers.types.SoulForgeContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers
{
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Otherworld.MODID);

    public static final RegistryObject<ContainerType<SoulForgeContainer>>
        SOULFORGE_CONTAINER = CONTAINERS.register("soul_forge", () -> IForgeContainerType.create(SoulForgeContainer::new));

}
