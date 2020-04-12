package com.divinegenesis.otherworld.common.objects.blocks.tileentities.types;

import com.divinegenesis.otherworld.common.objects.blocks.tileentities.ModTileEntities;
import com.divinegenesis.otherworld.common.objects.blocks.types.BlockHungryChest;
import net.minecraft.block.Block;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.sound.SoundEvent;

import java.util.List;


@OnlyIn(value = Dist.CLIENT, _interface = IChestLid.class)
public class HungryChestTE extends LockableLootTileEntity implements ITickableTileEntity, IChestLid
{
    private NonNullList<ItemStack> chestContents;
    private int range;

    private float prevLidAngle;
    private float lidAngle;
    private int numPlayersUsing;
    private int ticksSinceSync;

    public HungryChestTE() {
        super(ModTileEntities.HUNGRY_CHEST);
        this.chestContents = NonNullList.<ItemStack>withSize(getSizeInventory(), ItemStack.EMPTY);
        this.range = 3;
    }

    @Override
    public void tick()
    {
        if(!world.isRemote() && world.getGameTime() % 20 == 0)
        {
            int i = this.pos.getX();
            int j = this.pos.getY();
            int k = this.pos.getZ();
            ++this.ticksSinceSync;
            this.numPlayersUsing = getNumberOfPlayersUsing(this.world, this, this.ticksSinceSync, i, j, k, this.numPlayersUsing);
            this.prevLidAngle = this.lidAngle;
            float f = 0.1F;
            if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
                //this.playSound(SoundEvents.BLOCK_CHEST_OPEN);
            }

            if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
                float f1 = this.lidAngle;
                if (this.numPlayersUsing > 0) {
                    this.lidAngle += 0.1F;
                } else {
                    this.lidAngle -= 0.1F;
                }

                if (this.lidAngle > 1.0F) {
                    this.lidAngle = 1.0F;
                }

                float f2 = 0.5F;
                if (this.lidAngle < 0.5F && f1 >= 0.5F) {
                    //this.playSound(SoundEvents.BLOCK_CHEST_CLOSE);
                }

                if (this.lidAngle < 0.0F) {
                    this.lidAngle = 0.0F;
                }
            }

            AxisAlignedBB aoe = new AxisAlignedBB(
                    pos.getX()-range,
                    pos.getY()-range,
                    pos.getZ()-range,
                    pos.getX()+range,
                    pos.getY()+range,
                    pos.getZ()+range);
            List<ItemEntity> list = world.getEntitiesWithinAABB(ItemEntity.class, aoe);

            //if no items are in range
            if( list.isEmpty() )
                return;

            for (ItemEntity e : list)
            {
                for(int x = 0; x < getSizeInventory(); x++)
                {

                }
            }
        }
    }

    @Override
    public void read(CompoundNBT compound)
    {
        super.read(compound);
        this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound, this.chestContents);
        }
        this.range = compound.getInt("range");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound)
    {
        super.write(compound);
        ItemStackHelper.saveAllItems(compound, this.chestContents);
        compound.putInt("range", this.range);
        return compound;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new StringTextComponent("hungry_chest");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return ChestContainer.createGeneric9X3(id, player, this);
    }

    @Override
    public int getSizeInventory() {
        return 27;
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack stack : chestContents)
            if(!stack.isEmpty())
                return false;
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return chestContents.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.chestContents, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.chestContents, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        ItemStack itemstack = chestContents.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.chestContents.set(index, stack);
        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }
    }
    @Override
    public void clear() {
        getItems().clear();
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return chestContents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.chestContents = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < itemsIn.size(); i++) {
            if (i < this.chestContents.size()) {
                this.getItems().set(i, itemsIn.get(i));
            }
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public float getLidAngle(float partialTicks) {
        return MathHelper.lerp(partialTicks, this.prevLidAngle, this.lidAngle);
    }

    public boolean receiveClientEvent(int id, int type) {
        if (id == 1) {
            this.numPlayersUsing = type;
            return true;
        } else {
            return super.receiveClientEvent(id, type);
        }
    }

    public void openInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }

            ++this.numPlayersUsing;
            this.onOpenOrClose();
        }

    }

    public void closeInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.numPlayersUsing;
            this.onOpenOrClose();
        }

    }

    protected void onOpenOrClose() {
        Block block = this.getBlockState().getBlock();
        if (block instanceof BlockHungryChest) {
            this.world.addBlockEvent(this.pos, block, 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, block);
        }

    }

    public static int getNumberOfPlayersUsing(World worldIn, LockableTileEntity lockableTileEntity, int ticksSinceSync, int x, int y, int z, int numPlayersUsing) {
        if (!worldIn.isRemote && numPlayersUsing != 0 && (ticksSinceSync + x + y + z) % 200 == 0) {
            numPlayersUsing = getNumberOfPlayersUsing(worldIn, lockableTileEntity, x, y, z);
        }

        return numPlayersUsing;
    }

    public static int getNumberOfPlayersUsing(World world, LockableTileEntity lockableTileEntity, int x, int y, int z) {
        int i = 0;

        for (PlayerEntity playerentity : world.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB((double) ((float) x - 5.0F), (double) ((float) y - 5.0F), (double) ((float) z - 5.0F), (double) ((float) (x + 1) + 5.0F), (double) ((float) (y + 1) + 5.0F), (double) ((float) (z + 1) + 5.0F)))) {
            if (playerentity.openContainer instanceof ChestContainer) {
                ++i;
            }
        }

        return i;
    }

}