/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.player;

import net.minecraft.block.BlockWeb;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.events.callables.EventCancellable;

public class EventWebSolid
extends EventCancellable {
    private final BlockWeb blockWeb;
    private final BlockPos pos;

    public EventWebSolid(BlockWeb \u0445L\u0445LL\u0445L\u0445\u0445LLLLLL, BlockPos L\u0445\u0445LL\u0445L\u0445\u0445LLLLLL) {
        EventWebSolid LL\u0445LL\u0445L\u0445\u0445LLLLLL;
        LL\u0445LL\u0445L\u0445\u0445LLLLLL.blockWeb = \u0445L\u0445LL\u0445L\u0445\u0445LLLLLL;
        LL\u0445LL\u0445L\u0445\u0445LLLLLL.pos = L\u0445\u0445LL\u0445L\u0445\u0445LLLLLL;
    }

    public BlockWeb getBlock() {
        EventWebSolid \u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL;
        return \u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL.blockWeb;
    }

    public BlockPos getPos() {
        EventWebSolid L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLLLL;
        return L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLLLL.pos;
    }
}

