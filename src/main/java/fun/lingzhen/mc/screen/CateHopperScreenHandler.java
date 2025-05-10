package fun.lingzhen.mc.screen;

import fun.lingzhen.mc.init.ModScreens;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class CateHopperScreenHandler extends ScreenHandler {
    public static final int SLOT_COUNT = 6;
    private final Inventory inventory;

    public CateHopperScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(6));
    }

    public CateHopperScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreens.CATE_HOPPER_SCREEN_HANDLER, syncId);
        this.inventory = inventory;
        checkSize(inventory, 6);
        inventory.onOpen(playerInventory.player);

        for(int i = 0; i < 6; ++i) {
            this.addSlot(new Slot(inventory, i, 36 + i * 18, 20));
        }

        this.addPlayerSlots(playerInventory, 8, 51);
    }

    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = (Slot)this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot < this.inventory.size()) {
                if (!this.insertItem(itemStack2, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }
        }

        return itemStack;
    }

    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.inventory.onClose(player);
    }
}

