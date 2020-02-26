package com.divinegenesis.otherworld.common.data;


import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
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
        buildCubeAll(ModBlocks.GREATWOOD_PLANK);
        buildCubeAll(ModBlocks.CRYSTAL_HEART);
    }

    private void buildCubeAll(Block block) {
        getVariantBuilder(block).forAllStates(state ->
                ConfiguredModel.builder().modelFile(cubeAll(block)).build()
        );
    }

}
