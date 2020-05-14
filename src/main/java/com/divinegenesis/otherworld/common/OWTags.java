package com.divinegenesis.otherworld.common;

import com.divinegenesis.otherworld.Otherworld;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class OWTags
{
    public static class Blocks
    {
        public static final Tag<Block>
                INSANITY = makeWrapperTag("insanity"),
                SANITY = makeWrapperTag("sanity");

        private static Tag<Block> makeWrapperTag(String id)
        {
            return new BlockTags.Wrapper(new ResourceLocation(Otherworld.MODID, id));
        }
    }

    public static class Items
    {
        public static final Tag<Item>
                INSANITY = makeWrapperTag("insanity"),
                SANITY = makeWrapperTag("sanity");

        private static Tag<Item> makeWrapperTag(String id)
        {
            return new ItemTags.Wrapper(new ResourceLocation(Otherworld.MODID, id));
        }
    }
}
