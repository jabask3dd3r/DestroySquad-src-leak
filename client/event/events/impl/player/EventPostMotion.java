/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.player;

import org.Destroy.client.event.events.callables.EventCancellable;

public class EventPostMotion
extends EventCancellable {
    public float pitch;
    private float yaw;

    public EventPostMotion(float \u0445\u0445L\u0445LLL\u0445\u0445\u0445LLL, float LL\u0445\u0445LLL\u0445\u0445\u0445LLL) {
        EventPostMotion L\u0445L\u0445LLL\u0445\u0445\u0445LLL;
        L\u0445L\u0445LLL\u0445\u0445\u0445LLL.yaw = \u0445\u0445L\u0445LLL\u0445\u0445\u0445LLL;
        L\u0445L\u0445LLL\u0445\u0445\u0445LLL.pitch = LL\u0445\u0445LLL\u0445\u0445\u0445LLL;
    }

    public float getYaw() {
        EventPostMotion \u0445LLL\u0445LL\u0445\u0445\u0445LLL;
        return \u0445LLL\u0445LL\u0445\u0445\u0445LLL.yaw;
    }

    public void setYaw(float L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL) {
        \u0445L\u0445L\u0445LL\u0445\u0445\u0445LLL.yaw = L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL;
    }

    public float getPitch() {
        EventPostMotion L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL;
        return L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.pitch;
    }

    public void setPitch(float \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL) {
        L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.pitch = \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL;
    }
}

