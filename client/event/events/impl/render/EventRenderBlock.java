/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.render;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.Destroy.client.event.events.callables.EventCancellable;

public class EventRenderBlock
extends EventCancellable {
    private final IBlockState state;
    private final BlockPos pos;
    private final IBlockAccess access;
    private final BufferBuilder bufferBuilder;

    public EventRenderBlock(IBlockState \u0445LL\u0445\u0445\u0445L\u0445LL\u0445\u0445L, BlockPos L\u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445L, IBlockAccess \u0445\u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445L, BufferBuilder LL\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445L) {
        EventRenderBlock LLL\u0445\u0445\u0445L\u0445LL\u0445\u0445L;
        LLL\u0445\u0445\u0445L\u0445LL\u0445\u0445L.state = \u0445LL\u0445\u0445\u0445L\u0445LL\u0445\u0445L;
        LLL\u0445\u0445\u0445L\u0445LL\u0445\u0445L.pos = L\u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445L;
        LLL\u0445\u0445\u0445L\u0445LL\u0445\u0445L.access = \u0445\u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445L;
        LLL\u0445\u0445\u0445L\u0445LL\u0445\u0445L.bufferBuilder = LL\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445L;
    }

    public IBlockState getState() {
        EventRenderBlock \u0445\u0445LLLL\u0445\u0445LL\u0445\u0445L;
        return \u0445\u0445LLLL\u0445\u0445LL\u0445\u0445L.state;
    }

    public BufferBuilder getBufferBuilder() {
        EventRenderBlock L\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L;
        return L\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L.bufferBuilder;
    }

    public BlockPos getPos() {
        EventRenderBlock \u0445LL\u0445LL\u0445\u0445LL\u0445\u0445L;
        return \u0445LL\u0445LL\u0445\u0445LL\u0445\u0445L.pos;
    }

    public IBlockAccess getAccess() {
        EventRenderBlock LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L;
        return LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L.access;
    }
}

