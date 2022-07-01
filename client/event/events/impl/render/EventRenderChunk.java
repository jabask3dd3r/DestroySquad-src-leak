/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.render;

import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.events.callables.EventCancellable;

public class EventRenderChunk
extends EventCancellable {
    public BlockPos blockPos;
    public RenderChunk renderChunk;

    public EventRenderChunk(RenderChunk \u0445LL\u0445LLLLLL\u0445L\u0445LL, BlockPos L\u0445L\u0445LLLLLL\u0445L\u0445LL) {
        EventRenderChunk LLL\u0445LLLLLL\u0445L\u0445LL;
        LLL\u0445LLLLLL\u0445L\u0445LL.blockPos = L\u0445L\u0445LLLLLL\u0445L\u0445LL;
        LLL\u0445LLLLLL\u0445L\u0445LL.renderChunk = \u0445LL\u0445LLLLLL\u0445L\u0445LL;
    }

    public BlockPos getBlockPos() {
        EventRenderChunk \u0445\u0445\u0445\u0445LLLLLL\u0445L\u0445LL;
        return \u0445\u0445\u0445\u0445LLLLLL\u0445L\u0445LL.blockPos;
    }

    public void setBlockPos(BlockPos LL\u0445L\u0445LLLLL\u0445L\u0445LL) {
        \u0445\u0445LL\u0445LLLLL\u0445L\u0445LL.blockPos = LL\u0445L\u0445LLLLL\u0445L\u0445LL;
    }

    public RenderChunk getRenderChunk() {
        EventRenderChunk LLL\u0445\u0445LLLLL\u0445L\u0445LL;
        return LLL\u0445\u0445LLLLL\u0445L\u0445LL.renderChunk;
    }

    public void setRenderChunk(RenderChunk \u0445L\u0445\u0445\u0445LLLLL\u0445L\u0445LL) {
        LL\u0445\u0445\u0445LLLLL\u0445L\u0445LL.renderChunk = \u0445L\u0445\u0445\u0445LLLLL\u0445L\u0445LL;
    }
}

