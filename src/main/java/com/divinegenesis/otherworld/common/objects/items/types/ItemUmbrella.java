package com.divinegenesis.otherworld.common.objects.items.types;

import com.divinegenesis.otherworld.common.capability.CapabilityOWPlayer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemUmbrella extends Item {
    public ItemUmbrella(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {

        p_77659_2_.getCapability(CapabilityOWPlayer.DATA).ifPresent(iowPlayerStorage -> System.out.println(iowPlayerStorage.hasSoul()));
        return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
    }

    @Override
    public void onUsingTick(ItemStack stack, LivingEntity player, int count)
    {
        if(player.isAirBorne)
        {

        }
    }
}
