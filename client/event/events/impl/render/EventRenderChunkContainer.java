/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.render;

import net.minecraft.client.renderer.chunk.RenderChunk;
import org.Destroy.client.event.events.callables.EventCancellable;

public class EventRenderChunkContainer
extends EventCancellable {
    public RenderChunk renderChunk;

    public EventRenderChunkContainer(RenderChunk L\u0445LLL\u0445LL\u0445\u0445\u0445\u0445LLL) {
        EventRenderChunkContainer \u0445LLLL\u0445LL\u0445\u0445\u0445\u0445LLL;
        \u0445LLLL\u0445LL\u0445\u0445\u0445\u0445LLL.renderChunk = L\u0445LLL\u0445LL\u0445\u0445\u0445\u0445LLL;
    }

    public RenderChunk getRenderChunk() {
        EventRenderChunkContainer L\u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445LLL;
        return L\u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445LLL.renderChunk;
    }

    public void setRenderChunk(RenderChunk \u0445\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL) {
        L\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL.renderChunk = \u0445\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL;
    }
}

