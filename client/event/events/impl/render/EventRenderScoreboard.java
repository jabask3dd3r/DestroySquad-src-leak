/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.render;

import org.Destroy.client.event.events.Event;
import org.Destroy.client.event.types.EventType;

public class EventRenderScoreboard
implements Event {
    private EventType state;

    public EventRenderScoreboard(EventType \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL) {
        EventRenderScoreboard L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL;
        L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.state = \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL;
    }

    public EventType getState() {
        EventRenderScoreboard \u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL;
        return \u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL.state;
    }

    public void setState(EventType LLL\u0445\u0445L\u0445L\u0445\u0445\u0445LL) {
        \u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.state = LLL\u0445\u0445L\u0445L\u0445\u0445\u0445LL;
    }

    public boolean isPre() {
        EventRenderScoreboard LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL;
        return LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.state == EventType.PRE;
    }
}

