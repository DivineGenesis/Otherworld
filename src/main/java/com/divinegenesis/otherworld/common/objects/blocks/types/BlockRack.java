package com.divinegenesis.otherworld.common.objects.blocks.types;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockRack extends BlockBase {
    public BlockRack() {
        super("rack", Material.WOOD);
    }


    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return makeCuboidShape(0, 13, 7, 16, 16, 10);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return makeCuboidShape(0, 13, 7, 16, 16, 10);
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
