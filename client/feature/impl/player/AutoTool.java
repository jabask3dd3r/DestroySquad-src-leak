/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventBlockInteract;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;

public class AutoTool
extends Feature {
    public AutoTool() {
        super("AutoTool", "Automatically picks up the best tool when breaking a block", Type.Player);
        AutoTool \u0445\u0445\u0445LLL\u0445\u0445\u0445LLLL\u0445L;
    }

    @EventTarget
    public void onBlockInteract(EventBlockInteract LL\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445L) {
        BlockPos \u0445L\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445L = AutoTool.mc.objectMouseOver.getBlockPos();
        Block L\u0445\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445L = AutoTool.mc.world.getBlockState(\u0445L\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445L).getBlock();
        float \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445L = 1.0f;
        int LLL\u0445\u0445L\u0445\u0445\u0445LLLL\u0445L = -1;
        int L\u0445LL\u0445L\u0445\u0445\u0445LLLL\u0445L = 0;
        if (L\u0445LL\u0445L\u0445\u0445\u0445LLLL\u0445L < 9) {
            ItemStack LLLL\u0445L\u0445\u0445\u0445LLLL\u0445L = AutoTool.mc.player.inventory.mainInventory.get(L\u0445LL\u0445L\u0445\u0445\u0445LLLL\u0445L);
            ItemStack \u0445LLL\u0445L\u0445\u0445\u0445LLLL\u0445L = AutoTool.mc.player.inventory.getCurrentItem();
            if (LLLL\u0445L\u0445\u0445\u0445LLLL\u0445L.getStrVsBlock(L\u0445\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445L.getDefaultState()) > \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445L && !(\u0445LLL\u0445L\u0445\u0445\u0445LLLL\u0445L.getStrVsBlock(L\u0445\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445L.getDefaultState()) > \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445L)) {
                \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445L = LLLL\u0445L\u0445\u0445\u0445LLLL\u0445L.getStrVsBlock(L\u0445\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445L.getDefaultState());
                LLL\u0445\u0445L\u0445\u0445\u0445LLLL\u0445L = L\u0445LL\u0445L\u0445\u0445\u0445LLLL\u0445L;
            }
            ++L\u0445LL\u0445L\u0445\u0445\u0445LLLL\u0445L;
            return;
        }
        if (LLL\u0445\u0445L\u0445\u0445\u0445LLLL\u0445L != -1) {
            AutoTool.mc.player.inventory.currentItem = LLL\u0445\u0445L\u0445\u0445\u0445LLLL\u0445L;
        }
    }
}

