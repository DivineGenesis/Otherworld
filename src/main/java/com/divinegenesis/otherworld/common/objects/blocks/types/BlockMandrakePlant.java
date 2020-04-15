package com.divinegenesis.otherworld.common.objects.blocks.types;

import com.divinegenesis.otherworld.common.objects.blocks.ModBlocks;
import com.divinegenesis.otherworld.common.objects.entities.ModEntities;
import com.divinegenesis.otherworld.common.objects.entities.types.MandrakeEntity;
import com.divinegenesis.otherworld.common.objects.items.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMandrakePlant extends CropsBlock
{

    public BlockMandrakePlant(Properties builder) {
        super(builder);
    }

    @Override
    protected IItemProvider getSeedsItem() {
        return ModItems.MANDRAKE_SEED;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
    {
        Random rand = new Random();
        int x = rand.nextInt(100) + 1;

        if( (x <= 15 && worldIn.getDayTime() >= 12500) || (x <= 75 && worldIn.getDayTime() < 12500)) {

            MandrakeEntity mandrake = new MandrakeEntity(ModEntities.MANDRAKE, worldIn);
            mandrake.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 159, 62);
            worldIn.addEntity(mandrake);
        }
        super.onBlockHarvested(worldIn, pos, state, player);
    }
}
