/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.player;

import org.Destroy.client.event.events.callables.EventCancellable;

public class EventPlayerState
extends EventCancellable {
    private final boolean isPre;
    private float yaw;
    private float pitch;
    private double x;
    private double y;
    private double z;
    private boolean onGround;

    public EventPlayerState(double L\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL, double LLLL\u0445\u0445L\u0445LL\u0445LLL, double L\u0445LL\u0445\u0445L\u0445LL\u0445LLL, float \u0445\u0445LL\u0445\u0445L\u0445LL\u0445LLL, float LL\u0445L\u0445\u0445L\u0445LL\u0445LLL, boolean L\u0445\u0445L\u0445\u0445L\u0445LL\u0445LLL) {
        EventPlayerState LL\u0445\u0445L\u0445L\u0445LL\u0445LLL;
        LL\u0445\u0445L\u0445L\u0445LL\u0445LLL.y = LLLL\u0445\u0445L\u0445LL\u0445LLL;
        LL\u0445\u0445L\u0445L\u0445LL\u0445LLL.x = L\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL;
        LL\u0445\u0445L\u0445L\u0445LL\u0445LLL.z = L\u0445LL\u0445\u0445L\u0445LL\u0445LLL;
        LL\u0445\u0445L\u0445L\u0445LL\u0445LLL.isPre = true;
        LL\u0445\u0445L\u0445L\u0445LL\u0445LLL.yaw = \u0445\u0445LL\u0445\u0445L\u0445LL\u0445LLL;
        LL\u0445\u0445L\u0445L\u0445LL\u0445LLL.pitch = LL\u0445L\u0445\u0445L\u0445LL\u0445LLL;
        LL\u0445\u0445L\u0445L\u0445LL\u0445LLL.onGround = L\u0445\u0445L\u0445\u0445L\u0445LL\u0445LLL;
    }

    public EventPlayerState() {
        EventPlayerState LLL\u0445LL\u0445\u0445LL\u0445LLL;
        LLL\u0445LL\u0445\u0445LL\u0445LLL.isPre = false;
    }

    public boolean isPre() {
        EventPlayerState \u0445L\u0445\u0445LL\u0445\u0445LL\u0445LLL;
        return \u0445L\u0445\u0445LL\u0445\u0445LL\u0445LLL.isPre;
    }

    public boolean isPost() {
        EventPlayerState LLLL\u0445L\u0445\u0445LL\u0445LLL;
        return !LLLL\u0445L\u0445\u0445LL\u0445LLL.isPre;
    }

    public float getYaw() {
        EventPlayerState \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL;
        return \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.yaw;
    }

    public void setYaw(float LL\u0445\u0445\u0445L\u0445\u0445LL\u0445LLL) {
        \u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLL.yaw = LL\u0445\u0445\u0445L\u0445\u0445LL\u0445LLL;
    }

    public float getPitch() {
        EventPlayerState L\u0445LLL\u0445\u0445\u0445LL\u0445LLL;
        return L\u0445LLL\u0445\u0445\u0445LL\u0445LLL.pitch;
    }

    public void setPitch(float \u0445\u0445L\u0445L\u0445\u0445\u0445LL\u0445LLL) {
        \u0445LL\u0445L\u0445\u0445\u0445LL\u0445LLL.pitch = \u0445\u0445L\u0445L\u0445\u0445\u0445LL\u0445LLL;
    }

    public double getX() {
        EventPlayerState \u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL;
        return \u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL.x;
    }

    public void setX(double L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL) {
        \u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.x = L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL;
    }

    public double getY() {
        EventPlayerState L\u0445LLLLLL\u0445L\u0445LLL;
        return L\u0445LLLLLL\u0445L\u0445LLL.y;
    }

    public void setY(double \u0445LL\u0445LLLL\u0445L\u0445LLL) {
        LLL\u0445LLLL\u0445L\u0445LLL.y = \u0445LL\u0445LLLL\u0445L\u0445LLL;
    }

    public double getZ() {
        EventPlayerState \u0445L\u0445\u0445LLLL\u0445L\u0445LLL;
        return \u0445L\u0445\u0445LLLL\u0445L\u0445LLL.z;
    }

    public void setZ(double L\u0445LL\u0445LLL\u0445L\u0445LLL) {
        \u0445LLL\u0445LLL\u0445L\u0445LLL.z = L\u0445LL\u0445LLL\u0445L\u0445LLL;
    }

    public boolean isOnGround() {
        EventPlayerState L\u0445L\u0445\u0445LLL\u0445L\u0445LLL;
        return L\u0445L\u0445\u0445LLL\u0445L\u0445LLL.onGround;
    }

    public void setOnGround(boolean \u0445\u0445\u0445\u0445\u0445LLL\u0445L\u0445LLL) {
        L\u0445\u0445\u0445\u0445LLL\u0445L\u0445LLL.onGround = \u0445\u0445\u0445\u0445\u0445LLL\u0445L\u0445LLL;
    }
}

