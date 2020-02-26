package com.divinegenesis.otherworld.common.events;


import com.divinegenesis.otherworld.common.objects.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class TaglockEvents
{
    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (!event.getWorld().isRemote) {
            if (event.getItemStack().isItemEqual(new ItemStack(ModItems.TAGLOCK))) {
                CompoundNBT nbt;
                nbt = event.getItemStack().getOrCreateTag();
                if (nbt.getString("tagged").isEmpty()) {
                    nbt.putString("tagged", "Jesus");
                    event.getItemStack().setTag(nbt);
                }
            }
        }
    }
}
