/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.callables;

import org.Destroy.client.event.events.Cancellable;
import org.Destroy.client.event.events.Event;

public abstract class EventCancellable
implements Event,
Cancellable {
    private boolean cancelled;

    public EventCancellable() {
        EventCancellable \u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445L;
    }

    @Override
    public boolean isCancelled() {
        EventCancellable LLL\u0445\u0445\u0445\u0445L\u0445L\u0445L;
        return LLL\u0445\u0445\u0445\u0445L\u0445L\u0445L.cancelled;
    }

    @Override
    public void setCancelled(boolean \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L) {
        LL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.cancelled = \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L;
    }
}

