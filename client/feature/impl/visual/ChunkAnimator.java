/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.chunk.RenderChunk;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRenderChunk;
import org.Destroy.client.event.events.impl.render.EventRenderChunkContainer;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;

public class ChunkAnimator
extends Feature {
    private final HashMap<RenderChunk, AtomicLong> renderChunkMap = new HashMap();

    public ChunkAnimator() {
        super("ChunkAnimator", "Animates your chunks", Type.Visuals);
        ChunkAnimator LLLL\u0445L\u0445L\u0445\u0445LLLL;
    }

    private double easeOutCubic(double LL\u0445L\u0445L\u0445L\u0445\u0445LLLL) {
        return (LL\u0445L\u0445L\u0445L\u0445\u0445LLLL -= 1.0) * LL\u0445L\u0445L\u0445L\u0445\u0445LLLL * LL\u0445L\u0445L\u0445L\u0445\u0445LLLL + 1.0;
    }

    @EventTarget
    private void onRenderChunk(EventRenderChunk \u0445LL\u0445\u0445L\u0445L\u0445\u0445LLLL) {
        ChunkAnimator LLL\u0445\u0445L\u0445L\u0445\u0445LLLL;
        if (ChunkAnimator.mc.player != null && !LLL\u0445\u0445L\u0445L\u0445\u0445LLLL.renderChunkMap.containsKey(\u0445LL\u0445\u0445L\u0445L\u0445\u0445LLLL.getRenderChunk())) {
            LLL\u0445\u0445L\u0445L\u0445\u0445LLLL.renderChunkMap.put(\u0445LL\u0445\u0445L\u0445L\u0445\u0445LLLL.getRenderChunk(), new AtomicLong(-1L));
        }
    }

    @EventTarget
    private void onChunkRender(EventRenderChunkContainer \u0445LL\u0445L\u0445\u0445L\u0445\u0445LLLL) {
        ChunkAnimator LLL\u0445L\u0445\u0445L\u0445\u0445LLLL;
        if (LLL\u0445L\u0445\u0445L\u0445\u0445LLLL.renderChunkMap.containsKey(\u0445LL\u0445L\u0445\u0445L\u0445\u0445LLLL.getRenderChunk())) {
            long \u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445LLLL;
            AtomicLong \u0445L\u0445LL\u0445\u0445L\u0445\u0445LLLL = LLL\u0445L\u0445\u0445L\u0445\u0445LLLL.renderChunkMap.get(\u0445LL\u0445L\u0445\u0445L\u0445\u0445LLLL.getRenderChunk());
            long L\u0445\u0445LL\u0445\u0445L\u0445\u0445LLLL = \u0445L\u0445LL\u0445\u0445L\u0445\u0445LLLL.get();
            if (L\u0445\u0445LL\u0445\u0445L\u0445\u0445LLLL == -1L) {
                L\u0445\u0445LL\u0445\u0445L\u0445\u0445LLLL = System.currentTimeMillis();
                \u0445L\u0445LL\u0445\u0445L\u0445\u0445LLLL.set(L\u0445\u0445LL\u0445\u0445L\u0445\u0445LLLL);
            }
            if ((\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445LLLL = System.currentTimeMillis() - L\u0445\u0445LL\u0445\u0445L\u0445\u0445LLLL) <= 250L) {
                double \u0445\u0445LLL\u0445\u0445L\u0445\u0445LLLL = \u0445LL\u0445L\u0445\u0445L\u0445\u0445LLLL.getRenderChunk().getPosition().getY();
                double LL\u0445LL\u0445\u0445L\u0445\u0445LLLL = \u0445\u0445LLL\u0445\u0445L\u0445\u0445LLLL * LLL\u0445L\u0445\u0445L\u0445\u0445LLLL.easeOutCubic((float)\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445LLLL / 250.0f);
                GlStateManager.translate(0.0, -\u0445\u0445LLL\u0445\u0445L\u0445\u0445LLLL + LL\u0445LL\u0445\u0445L\u0445\u0445LLLL, 0.0);
            }
        }
    }
}

