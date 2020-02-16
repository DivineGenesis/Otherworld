package com.divinegenesis.otherworld.common.blocks.types;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.ProjectileImpactEvent;

import javax.annotation.Nullable;

public class BlockUrn extends BlockBase
{
    public BlockUrn(String name, Material material)
    {
        super(name, material);
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return makeCuboidShape(3, 0, 3, 13, 12, 13);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return makeCuboidShape(3, 0, 3, 13, 12, 13);
    }

    @Override
    public boolean isToolEffective(BlockState state, ToolType tool) {
        return true;
    }

    //    @Override
//    public BlockRenderLayer getRenderLayer() {
//        return BlockRenderLayer.TRANSLUCENT;
//    }

    @Override
    public int getOpacity(BlockState p_200011_1_, IBlockReader p_200011_2_, BlockPos p_200011_3_) {
        return 0;
    }

    @Override
    public boolean isNormalCube(BlockState p_220081_1_, IBlockReader p_220081_2_, BlockPos p_220081_3_) {
        return false;
    }

    @Override
    public SoundType getSoundType(BlockState state, IWorldReader world, BlockPos pos, @Nullable Entity entity) {
        return SoundType.GLASS;
    }
}
