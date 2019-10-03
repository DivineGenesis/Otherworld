package com.divinegenesis.otherworld.common.item;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemEnderPouch extends ItemBase
{
    public ItemEnderPouch(String name) {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerEntity, Hand hand)
    {
        TextComponent name = new TranslationTextComponent("container.enderpouch", new Object[0]);

        playerEntity.openContainer(new SimpleNamedContainerProvider((p_220114_1_, p_220114_2_, p_220114_3_) -> {
            return ChestContainer.createGeneric9X3(p_220114_1_, p_220114_2_, playerEntity.getInventoryEnderChest());
        }, name));
        playerEntity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);

        return super.onItemRightClick(world, playerEntity, hand);
    }
}
