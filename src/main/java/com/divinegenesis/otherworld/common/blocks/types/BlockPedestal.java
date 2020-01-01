package com.divinegenesis.otherworld.common.blocks.types;

import com.divinegenesis.otherworld.common.blocks.types.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class BlockPedestal extends BlockBase {
    public BlockPedestal(String name, Material material) {
        super(name, material);
    }

//    @Override
//    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
//        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
//    }
}
