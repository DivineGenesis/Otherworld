package com.divinegenesis.otherworld.common.data;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;

public class GeneratorItemModels extends ItemModelProvider
{
    public GeneratorItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, Otherworld.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        ModBlocks.BLOCKS.forEach(block -> registerBlockModel(block));
        //ModItems.ITEMS.forEach(item -> {
        registerItemModel(ModItems.RECALL_POTION);
        registerItemModel(ModItems.WINGS);
    }

    private void registerBlockModel(Block block) {
        String path = block.getRegistryName().getPath();
        getBuilder(path).parent(new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
    }

    private void registerItemModel(Item item)
    {
        String path = item.getRegistryName().getPath();
        singleTexture(path, mcLoc("item/generated"), "layer0", modLoc("items/" + path));
    }

    @Override
    public String getName() {
        return "Item Models";
    }
}
