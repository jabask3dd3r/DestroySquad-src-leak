/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.packet;

import net.minecraft.network.Packet;
import org.Destroy.client.event.events.callables.EventCancellable;

public class EventReceivePacket
extends EventCancellable {
    private Packet<?> packet;

    public EventReceivePacket(Packet<?> \u0445LLLLL\u0445L\u0445L\u0445\u0445L\u0445L) {
        EventReceivePacket LLLLLL\u0445L\u0445L\u0445\u0445L\u0445L;
        LLLLLL\u0445L\u0445L\u0445\u0445L\u0445L.packet = \u0445LLLLL\u0445L\u0445L\u0445\u0445L\u0445L;
    }

    public Packet<?> getPacket() {
        EventReceivePacket \u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L\u0445L;
        return \u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L\u0445L.packet;
    }

    public void setPacket(Packet<?> L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L\u0445L) {
        \u0445LL\u0445LL\u0445L\u0445L\u0445\u0445L\u0445L.packet = L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L\u0445L;
    }
}

