package com.divinegenesis.otherworld.common.blocks.types;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class BlockRack extends BlockBase {
    public BlockRack() {
        super("rack", Material.WOOD);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_)
    {
        if(player.getHeldItem(hand).getItem() == Blocks.CAULDRON.asItem())
        {
            world.setBlockState(pos, Blocks.DIAMOND_ORE.getDefaultState());
        }
        return ActionResultType.CONSUME;
    }
}
