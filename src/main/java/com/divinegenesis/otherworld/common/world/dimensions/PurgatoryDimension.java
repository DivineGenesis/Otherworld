package com.divinegenesis.otherworld.common.world.dimensions;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.EndGenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class PurgatoryDimension extends Dimension
{
    @Override
    public ChunkGenerator<?> createChunkGenerator() {
    EndGenerationSettings endgenerationsettings = ChunkGeneratorType.FLOATING_ISLANDS.createSettings();
      endgenerationsettings.setDefaultBlock(Blocks.QUARTZ_BLOCK.getDefaultState());
      endgenerationsettings.setDefaultFluid(Blocks.AIR.getDefaultState());
      endgenerationsettings.setSpawnPos(this.getSpawnCoordinate());
      return
              ChunkGeneratorType.FLOATING_ISLANDS.create(
                      this.world,
                      BiomeProviderType.THE_END.create(BiomeProviderType.THE_END.func_226840_a_(this.world.getWorldInfo())),
                      endgenerationsettings);
              //create(this.world, BiomeProviderType.THE_END.create(BiomeProviderType.THE_END.createSettings().setSeed(this.world.getSeed())), endgenerationsettings);
}

    @Override
    @Nullable
    public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
        for(int i = chunkPosIn.getXStart(); i <= chunkPosIn.getXEnd(); ++i) {
            for(int j = chunkPosIn.getZStart(); j <= chunkPosIn.getZEnd(); ++j) {
                BlockPos blockpos = this.findSpawn(i, j, checkValid);
                if (blockpos != null) {
                    return blockpos;
                }
            }
        }

        return null;
    }


        /** Copied from OverworldDimension */
    @Override
    @Nullable
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable(posX, 0, posZ);
        Biome biome = this.world.getBiome(blockpos$mutableblockpos);
        BlockState blockstate = biome.getSurfaceBuilderConfig().getTop();
        if (checkValid && !blockstate.getBlock().isIn(BlockTags.VALID_SPAWN)) {
            return null;
        } else {
            Chunk chunk = this.world.getChunk(posX >> 4, posZ >> 4);
            int i = chunk.getTopBlockY(Heightmap.Type.MOTION_BLOCKING, posX & 15, posZ & 15);
            if (i < 0) {
                return null;
            } else if (chunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE, posX & 15, posZ & 15) > chunk.getTopBlockY(Heightmap.Type.OCEAN_FLOOR, posX & 15, posZ & 15)) {
                return null;
            } else {
                for(int j = i + 1; j >= 0; --j) {
                    blockpos$mutableblockpos.setPos(posX, j, posZ);
                    BlockState blockstate1 = this.world.getBlockState(blockpos$mutableblockpos);
                    if (!blockstate1.getFluidState().isEmpty()) {
                        break;
                    }

                    if (blockstate1.equals(blockstate)) {
                        return blockpos$mutableblockpos.up().toImmutable();
                    }
                }

                return null;
            }
        }
    }

        public float calculateCelestialAngle(long worldTime, float partialTicks)
        {
            double d0 = MathHelper.frac((double)worldTime / 24000.0D - 0.25D);
            double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
            return (float)(d0 * 2.0D + d1) / 3.0F;
        }

        @Override
        public boolean hasSkyLight()
        {
            return true;
        }

        /**
         * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
         */
        public boolean isSurfaceWorld()
        {
            return false;
        }

        /**
         * Return Vec3D with biome specific fog color
         */
        @OnlyIn(Dist.CLIENT)
        public Vec3d getFogColor(float celestialAngle, float partialTicks)
        {
            float f = MathHelper.cos(celestialAngle * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
            f = MathHelper.clamp(f, 0.0F, 1.0F);
            float f1 = 0.7529412F;
            float f2 = 0.84705883F;
            float f3 = 1.0F;
            f1 = f1 * (f * 0.94F + 0.06F);
            f2 = f2 * (f * 0.94F + 0.06F);
            f3 = f3 * (f * 0.91F + 0.09F);
            return new Vec3d((double)f1, (double)f2, (double)f3);
        }

        /**
         * True if the player can respawn in this dimension (true = overworld, false = nether).
         */
        public boolean canRespawnHere()
        {
            return true;
        }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return true;
    }

    public PurgatoryDimension(World p_i225788_1_, DimensionType p_i225788_2_, float p_i225788_3_) {
        super(p_i225788_1_, p_i225788_2_, p_i225788_3_);
    }
}
