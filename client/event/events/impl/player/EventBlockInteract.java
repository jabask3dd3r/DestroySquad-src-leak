/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.player;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.events.callables.EventCancellable;

public class EventBlockInteract
extends EventCancellable {
    private BlockPos pos;
    private EnumFacing face;

    public EventBlockInteract(BlockPos \u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLLL, EnumFacing LL\u0445\u0445L\u0445\u0445\u0445LLLLLLL) {
        EventBlockInteract L\u0445L\u0445L\u0445\u0445\u0445LLLLLLL;
        L\u0445L\u0445L\u0445\u0445\u0445LLLLLLL.pos = \u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLLL;
        L\u0445L\u0445L\u0445\u0445\u0445LLLLLLL.face = LL\u0445\u0445L\u0445\u0445\u0445LLLLLLL;
    }

    public BlockPos getPos() {
        EventBlockInteract \u0445LLL\u0445\u0445\u0445\u0445LLLLLLL;
        return \u0445LLL\u0445\u0445\u0445\u0445LLLLLLL.pos;
    }

    public void setPos(BlockPos L\u0445\u0445L\u0445\u0445\u0445\u0445LLLLLLL) {
        \u0445L\u0445L\u0445\u0445\u0445\u0445LLLLLLL.pos = L\u0445\u0445L\u0445\u0445\u0445\u0445LLLLLLL;
    }

    public EnumFacing getFace() {
        EventBlockInteract L\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLLL;
        return L\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLLL.face;
    }

    public void setFace(EnumFacing \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLLLLL) {
        L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLLLLL.face = \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLLLLL;
    }
}

