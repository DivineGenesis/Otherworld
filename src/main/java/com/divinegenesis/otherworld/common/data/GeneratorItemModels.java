package com.divinegenesis.otherworld.common.data;

import com.divinegenesis.otherworld.Otherworld;
import com.divinegenesis.otherworld.common.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;

public class GeneratorItemModels extends ItemModelProvider
{
    public GeneratorItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, Otherworld.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        ModItems.ITEMS.forEach(item ->
        {
            String path = item.getRegistryName().getPath();
            singleTexture(path, mcLoc("item/handheld"), "layer0", mcLoc("item/"+path));
        });
    }

    @Override
    public String getName() {
        return "Item Models";
    }
}
