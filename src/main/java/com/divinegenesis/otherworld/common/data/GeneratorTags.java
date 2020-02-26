package com.divinegenesis.otherworld.common.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.TagsProvider;
import net.minecraft.tags.TagCollection;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.nio.file.Path;

public class GeneratorTags extends TagsProvider
{
    protected GeneratorTags(DataGenerator generator, Registry registry) {
        super(generator, registry);
    }

    @Override
    protected void registerTags()
    {

    }

    @Override
    protected void setCollection(TagCollection colectionIn)
    {

    }

    @Override
    protected Path makePath(ResourceLocation id)
    {
        return null;
    }

    @Override
    public String getName() {
        return "Tags";
    }
}
