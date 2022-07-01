/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.player;

import org.Destroy.client.event.events.Event;

public class EventPreMotion
implements Event {
    private float yaw;
    private float pitch;
    private double posX;
    private double posY;
    private double posZ;
    private boolean onGround;

    public EventPreMotion(float LL\u0445\u0445LLL\u0445LL\u0445\u0445\u0445LL, float \u0445L\u0445\u0445LLL\u0445LL\u0445\u0445\u0445LL, double L\u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445LL, double \u0445\u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445LL, double LLLL\u0445LL\u0445LL\u0445\u0445\u0445LL, boolean \u0445LLL\u0445LL\u0445LL\u0445\u0445\u0445LL) {
        EventPreMotion \u0445\u0445L\u0445LLL\u0445LL\u0445\u0445\u0445LL;
        \u0445\u0445L\u0445LLL\u0445LL\u0445\u0445\u0445LL.yaw = LL\u0445\u0445LLL\u0445LL\u0445\u0445\u0445LL;
        \u0445\u0445L\u0445LLL\u0445LL\u0445\u0445\u0445LL.pitch = \u0445L\u0445\u0445LLL\u0445LL\u0445\u0445\u0445LL;
        \u0445\u0445L\u0445LLL\u0445LL\u0445\u0445\u0445LL.posX = L\u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445LL;
        \u0445\u0445L\u0445LLL\u0445LL\u0445\u0445\u0445LL.posY = \u0445\u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445LL;
        \u0445\u0445L\u0445LLL\u0445LL\u0445\u0445\u0445LL.posZ = LLLL\u0445LL\u0445LL\u0445\u0445\u0445LL;
        \u0445\u0445L\u0445LLL\u0445LL\u0445\u0445\u0445LL.onGround = \u0445LLL\u0445LL\u0445LL\u0445\u0445\u0445LL;
    }

    public float getYaw() {
        EventPreMotion L\u0445L\u0445\u0445LL\u0445LL\u0445\u0445\u0445LL;
        return L\u0445L\u0445\u0445LL\u0445LL\u0445\u0445\u0445LL.yaw;
    }

    public void setYaw(float \u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445\u0445\u0445LL) {
        L\u0445\u0445\u0445\u0445LL\u0445LL\u0445\u0445\u0445LL.yaw = \u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445\u0445\u0445LL;
    }

    public float getPitch() {
        EventPreMotion \u0445\u0445LLL\u0445L\u0445LL\u0445\u0445\u0445LL;
        return \u0445\u0445LLL\u0445L\u0445LL\u0445\u0445\u0445LL.pitch;
    }

    public void setPitch(float LLL\u0445L\u0445L\u0445LL\u0445\u0445\u0445LL) {
        \u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445\u0445LL.pitch = LLL\u0445L\u0445L\u0445LL\u0445\u0445\u0445LL;
    }

    public double getPosX() {
        EventPreMotion LL\u0445\u0445L\u0445L\u0445LL\u0445\u0445\u0445LL;
        return LL\u0445\u0445L\u0445L\u0445LL\u0445\u0445\u0445LL.posX;
    }

    public void setPosX(double \u0445LLL\u0445\u0445L\u0445LL\u0445\u0445\u0445LL) {
        LLLL\u0445\u0445L\u0445LL\u0445\u0445\u0445LL.posX = \u0445LLL\u0445\u0445L\u0445LL\u0445\u0445\u0445LL;
    }

    public double getPosY() {
        EventPreMotion \u0445L\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LL;
        return \u0445L\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LL.posY;
    }

    public void setPosY(double L\u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LL) {
        \u0445LL\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LL.posY = L\u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LL;
    }

    public double getPosZ() {
        EventPreMotion L\u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LL;
        return L\u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LL.posZ;
    }

    public void setPosZ(double \u0445\u0445LLLL\u0445\u0445LL\u0445\u0445\u0445LL) {
        L\u0445LLLL\u0445\u0445LL\u0445\u0445\u0445LL.posZ = \u0445\u0445LLLL\u0445\u0445LL\u0445\u0445\u0445LL;
    }

    public boolean isOnGround() {
        EventPreMotion \u0445\u0445\u0445LLL\u0445\u0445LL\u0445\u0445\u0445LL;
        return \u0445\u0445\u0445LLL\u0445\u0445LL\u0445\u0445\u0445LL.onGround;
    }

    public void setOnGround(boolean LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445\u0445LL) {
        \u0445\u0445L\u0445LL\u0445\u0445LL\u0445\u0445\u0445LL.onGround = LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445\u0445LL;
    }
}

