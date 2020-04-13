package com.divinegenesis.otherworld.common.data;


import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class GeneratorBlockstates extends BlockStateProvider
{
    private ResourceLocation GREATWOOD = new ResourceLocation(Otherworld.MODID, "block/greatwood_plank");
    public GeneratorBlockstates(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, Otherworld.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        buildCubeAll(ModBlocks.GREATWOOD_PLANK);
        buildCubeAll(ModBlocks.CRYSTAL_HEART);
        stairsBlock((StairsBlock) ModBlocks.GREATWOOD_STAIRS, GREATWOOD);
        fenceBlock((FenceBlock) ModBlocks.GREATWOOD_FENCE, GREATWOOD);
        slabBlock((SlabBlock) ModBlocks.GREATWOOD_SLAB, GREATWOOD, GREATWOOD);
        fenceGateBlock((FenceGateBlock) ModBlocks.GREATWOOD_GATE, GREATWOOD);
    }

    private void buildCubeAll(Block block) {
        getVariantBuilder(block).forAllStates(state ->
                ConfiguredModel.builder().modelFile(cubeAll(block)).build()
        );
    }

}
