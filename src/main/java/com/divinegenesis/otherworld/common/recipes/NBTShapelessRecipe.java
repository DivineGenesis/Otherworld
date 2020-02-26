package com.divinegenesis.otherworld.common.recipes;

import com.google.gson.JsonObject;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class NBTShapelessRecipe implements ICraftingRecipe
{
    @Override
    public boolean matches(CraftingInventory inv, World worldIn) {
        return false;
    }

    @Override
    public ItemStack getCraftingResult(CraftingInventory inv)
    {
        return null;
    }

    @Override
    public boolean canFit(int width, int height) {
        return this.canFit(width, height);
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }

    @Override
    public ResourceLocation getId() {
        return null;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return RecipeSerializer.NBT_SHAPELESS;
    }

    public static class Serializer extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<NBTShapelessRecipe>
    {

        @Override
        public NBTShapelessRecipe read(ResourceLocation recipeId, JsonObject json) {
            return null;
        }

        @Nullable
        @Override
        public NBTShapelessRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            return null;
        }

        @Override
        public void write(PacketBuffer buffer, NBTShapelessRecipe recipe)
        {

        }
    }
}
