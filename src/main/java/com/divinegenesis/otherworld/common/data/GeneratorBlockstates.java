package com.divinegenesis.otherworld.common.data;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.blocks.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class GeneratorBlockstates extends BlockStateProvider
{

    public GeneratorBlockstates(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, Otherworld.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(ModBlocks.GREATWOOD_PLANK);

    }

}