/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.player;

import net.minecraft.block.BlockLiquid;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.events.callables.EventCancellable;

public class EventLiquidSolid
extends EventCancellable {
    private final BlockLiquid blockLiquid;
    private final BlockPos pos;

    public EventLiquidSolid(BlockLiquid \u0445L\u0445L\u0445\u0445LLLLL\u0445LLL, BlockPos L\u0445\u0445L\u0445\u0445LLLLL\u0445LLL) {
        EventLiquidSolid LL\u0445L\u0445\u0445LLLLL\u0445LLL;
        LL\u0445L\u0445\u0445LLLLL\u0445LLL.blockLiquid = \u0445L\u0445L\u0445\u0445LLLLL\u0445LLL;
        LL\u0445L\u0445\u0445LLLLL\u0445LLL.pos = L\u0445\u0445L\u0445\u0445LLLLL\u0445LLL;
    }

    public BlockLiquid getBlock() {
        EventLiquidSolid \u0445\u0445L\u0445\u0445\u0445LLLLL\u0445LLL;
        return \u0445\u0445L\u0445\u0445\u0445LLLLL\u0445LLL.blockLiquid;
    }

    public BlockPos getPos() {
        EventLiquidSolid L\u0445\u0445\u0445\u0445\u0445LLLLL\u0445LLL;
        return L\u0445\u0445\u0445\u0445\u0445LLLLL\u0445LLL.pos;
    }
}

