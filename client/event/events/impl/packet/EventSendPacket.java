/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.packet;

import net.minecraft.network.Packet;
import org.Destroy.client.event.events.callables.EventCancellable;

public class EventSendPacket
extends EventCancellable {
    private final Packet<?> packet;

    public EventSendPacket(Packet \u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L) {
        EventSendPacket LL\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L;
        LL\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L.packet = \u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L;
    }

    public Packet getPacket() {
        EventSendPacket \u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L;
        return \u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.packet;
    }
}

