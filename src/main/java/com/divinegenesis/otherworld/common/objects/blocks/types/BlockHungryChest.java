package com.divinegenesis.otherworld.common.objects.blocks.types;

import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import com.divinegenesis.otherworld.common.objects.blocks.tileentities.types.HungryChestTE;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class BlockHungryChest extends ContainerBlock implements IWaterLoggable
{
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private final Supplier<TileEntityType<? extends HungryChestTE>> tileEntityTypeSupplier;

    public BlockHungryChest(Material material, Supplier<TileEntityType<? extends HungryChestTE>> supplier)
    {
        super(Block.Properties.create(material));
        this.tileEntityTypeSupplier = supplier;
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new HungryChestTE();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        if (!world.isRemote) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof INamedContainerProvider) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
            } else {
                throw new IllegalStateException("Our named container provider is missing!");
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);
    }

    public TileEntityMerger.ICallbackWrapper<? extends HungryChestTE> getWrapper(BlockState blockState, World world, BlockPos blockPos, boolean p_225536_4_) {
        BiPredicate<IWorld, BlockPos> biPredicate;
        if (p_225536_4_) {
            biPredicate = (p_226918_0_, p_226918_1_) -> false;
        }
        else {
            biPredicate = BlockHungryChest::isBlocked;
        }

        return TileEntityMerger.func_226924_a_(this.tileEntityTypeSupplier.get(), BlockHungryChest::getMergerType, BlockHungryChest::getDirectionToAttached, FACING, blockState, world, blockPos, biPredicate);
    }

    public static TileEntityMerger.Type getMergerType(BlockState blockState) {
        return TileEntityMerger.Type.SINGLE;
    }

    private static boolean isBlocked(IWorld iWorld, BlockPos blockPos) {
        return isBelowSolidBlock(iWorld, blockPos);
    }

    private static boolean isBelowSolidBlock(IBlockReader iBlockReader, BlockPos worldIn) {
        BlockPos blockpos = worldIn.up();
        return iBlockReader.getBlockState(blockpos).isNormalCube(iBlockReader, blockpos);
    }

    public static Direction getDirectionToAttached(BlockState state) {
        Direction direction = state.get(FACING);
        return direction.rotateYCCW();
    }

    @OnlyIn(Dist.CLIENT)
    public static TileEntityMerger.ICallback<HungryChestTE, Float2FloatFunction> getLid(final IChestLid p_226917_0_) {
        return new TileEntityMerger.ICallback<HungryChestTE, Float2FloatFunction>() {
            @Override
            public Float2FloatFunction func_225539_a_(HungryChestTE p_225539_1_, HungryChestTE p_225539_2_) {
                return (p_226921_2_) -> {
                    return Math.max(p_225539_1_.getLidAngle(p_226921_2_), p_225539_2_.getLidAngle(p_226921_2_));
                };
            }

            @Override
            public Float2FloatFunction func_225538_a_(HungryChestTE p_225538_1_) {
                return p_225538_1_::getLidAngle;
            }

            @Override
            public Float2FloatFunction func_225537_b_() {
                return p_226917_0_::getLidAngle;
            }
        };
    }

    @Override
    public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int id, int param) {
        super.eventReceived(state, worldIn, pos, id, param);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
    }
}
