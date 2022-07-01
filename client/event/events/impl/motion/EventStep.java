/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.motion;

import org.Destroy.client.event.events.Event;

public class EventStep
implements Event {
    private final boolean pre;
    private double stepHeight;

    public EventStep(boolean \u0445\u0445LLLLLL\u0445LL\u0445LL, double LL\u0445LLLLL\u0445LL\u0445LL) {
        EventStep L\u0445LLLLLL\u0445LL\u0445LL;
        L\u0445LLLLLL\u0445LL\u0445LL.pre = \u0445\u0445LLLLLL\u0445LL\u0445LL;
        L\u0445LLLLLL\u0445LL\u0445LL.stepHeight = LL\u0445LLLLL\u0445LL\u0445LL;
    }

    public boolean isPre() {
        EventStep \u0445LL\u0445LLLL\u0445LL\u0445LL;
        return \u0445LL\u0445LLLL\u0445LL\u0445LL.pre;
    }

    public double getStepHeight() {
        EventStep LL\u0445\u0445LLLL\u0445LL\u0445LL;
        return LL\u0445\u0445LLLL\u0445LL\u0445LL.stepHeight;
    }

    public void setStepHeight(double \u0445LLL\u0445LLL\u0445LL\u0445LL) {
        LLLL\u0445LLL\u0445LL\u0445LL.stepHeight = \u0445LLL\u0445LLL\u0445LL\u0445LL;
    }
}

