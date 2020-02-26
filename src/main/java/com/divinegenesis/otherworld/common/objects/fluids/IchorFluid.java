package com.divinegenesis.otherworld.common.objects.fluids;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.state.StateContainer;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class IchorFluid extends ForgeFlowingFluid {

    protected IchorFluid(Properties properties) {
        super(properties);
    }

    public static class Flowing extends IchorFluid {

        public Flowing(Properties properties) {
            super(properties);
            this.setDefaultState(this.getStateContainer().getBaseState().with(LEVEL_1_8, 7));
        }

        @Override
        protected void fillStateContainer(StateContainer.Builder<Fluid, IFluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        @Override
        public int getLevel(IFluidState state) {
            return state.get(LEVEL_1_8);
        }

        @Override
        public boolean isSource(IFluidState state) {
            return false;
        }
    }

    public static class Source extends IchorFluid {

        public Source(Properties properties) {
            super(properties);
        }

        @Override
        public int getLevel(IFluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(IFluidState state) {
            return true;
        }
    }
}