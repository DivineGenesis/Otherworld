package com.divinegenesis.otherworld.data;


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
    private ResourceLocation
            GREATWOOD = new ResourceLocation(Otherworld.MODID, "block/greatwood_plank"),
            WITCHWOOD = new ResourceLocation(Otherworld.MODID, "block/witchwood_plank");;
    public GeneratorBlockstates(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, Otherworld.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        buildCubeAll(ModBlocks.GREATWOOD_PLANK);
        buildCubeAll(ModBlocks.WITCHWOOD_PLANK);
        buildCubeAll(ModBlocks.TRAVELLER_PAVEMENT);
        logBlock((LogBlock) ModBlocks.GREATWOOD_LOG);
        logBlock((LogBlock) ModBlocks.WITCHWOOD_LOG);
        buildCubeAll(ModBlocks.GREATWOOD_LEAVES);
        buildCubeAll(ModBlocks.WITCHWOOD_LEAVES);
        stairsBlock((StairsBlock) ModBlocks.GREATWOOD_STAIRS, GREATWOOD);
        stairsBlock((StairsBlock) ModBlocks.WITCHWOOD_STAIRS, WITCHWOOD);
        fenceBlock((FenceBlock) ModBlocks.GREATWOOD_FENCE, GREATWOOD);
        fenceBlock((FenceBlock) ModBlocks.WITCHWOOD_FENCE, WITCHWOOD);
        slabBlock((SlabBlock) ModBlocks.GREATWOOD_SLAB, GREATWOOD, GREATWOOD);
        slabBlock((SlabBlock) ModBlocks.WITCHWOOD_SLAB, WITCHWOOD, WITCHWOOD);
        fenceGateBlock((FenceGateBlock) ModBlocks.GREATWOOD_GATE, GREATWOOD);
        fenceGateBlock((FenceGateBlock) ModBlocks.WITCHWOOD_GATE, WITCHWOOD);
    }

    private void buildCubeAll(Block block) {
        getVariantBuilder(block).forAllStates(state ->
                ConfiguredModel.builder().modelFile(cubeAll(block)).build()
        );
    }

}
