/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.packet;

import org.Destroy.client.event.events.callables.EventCancellable;

public class EventReceiveMessage
extends EventCancellable {
    public String message;
    public boolean cancelled;

    public EventReceiveMessage(String \u0445\u0445L\u0445LLLLLLL\u0445\u0445LL) {
        EventReceiveMessage L\u0445L\u0445LLLLLLL\u0445\u0445LL;
        L\u0445L\u0445LLLLLLL\u0445\u0445LL.message = \u0445\u0445L\u0445LLLLLLL\u0445\u0445LL;
    }

    public String getMessage() {
        EventReceiveMessage \u0445\u0445\u0445\u0445LLLLLLL\u0445\u0445LL;
        return \u0445\u0445\u0445\u0445LLLLLLL\u0445\u0445LL.message;
    }

    @Override
    public void setCancelled(boolean LL\u0445L\u0445LLLLLL\u0445\u0445LL) {
        \u0445\u0445LL\u0445LLLLLL\u0445\u0445LL.cancelled = LL\u0445L\u0445LLLLLL\u0445\u0445LL;
    }
}

