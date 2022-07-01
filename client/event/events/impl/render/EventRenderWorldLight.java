/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.render;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import org.Destroy.client.event.events.callables.EventCancellable;

public class EventRenderWorldLight
extends EventCancellable {
    private final EnumSkyBlock enumSkyBlock;
    private final BlockPos pos;

    public EventRenderWorldLight(EnumSkyBlock LLLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L, BlockPos \u0445LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L) {
        EventRenderWorldLight \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L;
        \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.enumSkyBlock = LLLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L;
        \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.pos = \u0445LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L;
    }

    public EnumSkyBlock getEnumSkyBlock() {
        EventRenderWorldLight L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L;
        return L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.enumSkyBlock;
    }

    public BlockPos getPos() {
        EventRenderWorldLight \u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L;
        return \u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.pos;
    }
}

