package com.divinegenesis.otherworld;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.Tags;

public class OWGroup extends ItemGroup
{

    public static final
        ItemGroup GROUP = new OWGroup(Otherworld.MODID);


    public OWGroup(String label) { super(label);}

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.CAKE);
    }
}
