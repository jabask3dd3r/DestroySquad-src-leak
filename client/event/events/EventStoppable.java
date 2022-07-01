/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events;

import org.Destroy.client.event.events.Event;

public abstract class EventStoppable
implements Event {
    private boolean stopped;

    public EventStoppable() {
        EventStoppable \u0445L\u0445\u0445LLL\u0445\u0445LL\u0445LLL;
    }

    public void stop() {
        LLLL\u0445LL\u0445\u0445LL\u0445LLL.stopped = true;
    }

    public boolean isStopped() {
        EventStoppable \u0445\u0445LL\u0445LL\u0445\u0445LL\u0445LLL;
        return \u0445\u0445LL\u0445LL\u0445\u0445LL\u0445LLL.stopped;
    }
}

