/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.motion;

import org.Destroy.client.event.events.callables.EventCancellable;

public class EventStrafe
extends EventCancellable {
    private float yaw;
    private float strafe;
    private float forward;
    private float friction;

    public EventStrafe(float L\u0445L\u0445\u0445L\u0445LLL\u0445LLL, float \u0445\u0445L\u0445\u0445L\u0445LLL\u0445LLL, float LL\u0445\u0445\u0445L\u0445LLL\u0445LLL, float \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LLL) {
        EventStrafe \u0445LL\u0445\u0445L\u0445LLL\u0445LLL;
        \u0445LL\u0445\u0445L\u0445LLL\u0445LLL.yaw = L\u0445L\u0445\u0445L\u0445LLL\u0445LLL;
        \u0445LL\u0445\u0445L\u0445LLL\u0445LLL.strafe = \u0445\u0445L\u0445\u0445L\u0445LLL\u0445LLL;
        \u0445LL\u0445\u0445L\u0445LLL\u0445LLL.forward = LL\u0445\u0445\u0445L\u0445LLL\u0445LLL;
        \u0445LL\u0445\u0445L\u0445LLL\u0445LLL.friction = \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LLL;
    }

    public float getStrafe() {
        EventStrafe LL\u0445LL\u0445\u0445LLL\u0445LLL;
        return LL\u0445LL\u0445\u0445LLL\u0445LLL.strafe;
    }

    public void setStrafe(float \u0445LL\u0445L\u0445\u0445LLL\u0445LLL) {
        LLL\u0445L\u0445\u0445LLL\u0445LLL.strafe = \u0445LL\u0445L\u0445\u0445LLL\u0445LLL;
    }

    public float getForward() {
        EventStrafe \u0445L\u0445\u0445L\u0445\u0445LLL\u0445LLL;
        return \u0445L\u0445\u0445L\u0445\u0445LLL\u0445LLL.forward;
    }

    public void setForward(float L\u0445LL\u0445\u0445\u0445LLL\u0445LLL) {
        \u0445LLL\u0445\u0445\u0445LLL\u0445LLL.forward = L\u0445LL\u0445\u0445\u0445LLL\u0445LLL;
    }

    public float getFriction() {
        EventStrafe L\u0445\u0445L\u0445\u0445\u0445LLL\u0445LLL;
        return L\u0445\u0445L\u0445\u0445\u0445LLL\u0445LLL.friction;
    }

    public void setFriction(float \u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LLL) {
        L\u0445L\u0445\u0445\u0445\u0445LLL\u0445LLL.friction = \u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LLL;
    }

    public float getYaw() {
        EventStrafe \u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL;
        return \u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL.yaw;
    }

    public void setYaw(float LL\u0445LLLL\u0445LL\u0445LLL) {
        \u0445\u0445LLLLL\u0445LL\u0445LLL.yaw = LL\u0445LLLL\u0445LL\u0445LLL;
    }
}

