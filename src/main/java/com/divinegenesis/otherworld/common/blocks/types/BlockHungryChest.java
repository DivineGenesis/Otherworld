package com.divinegenesis.otherworld.common.blocks.types;

import com.divinegenesis.otherworld.common.blocks.tileentities.HungryChestTE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockHungryChest extends BlockBase
{
    private static final  EnumProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public BlockHungryChest(String name, Material material)
    {
        super(name, material);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new HungryChestTE();
    }
}
