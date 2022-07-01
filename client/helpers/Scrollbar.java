/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers;

public class Scrollbar {
    public float startX;
    public float startY;
    public float endY;
    public float currentScroll;
    public float maxScroll;
    public float minScroll;

    public Scrollbar() {
        Scrollbar \u0445LLLL\u0445\u0445L\u0445L\u0445L\u0445LL;
    }

    public void drawScrollBar() {
        Scrollbar LL\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LL;
        LL\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LL.maxScroll += LL\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LL.currentScroll / 14.0f;
    }

    public void setInformation(float L\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL, float \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL, float LLLL\u0445\u0445\u0445L\u0445L\u0445L\u0445LL, float \u0445LLL\u0445\u0445\u0445L\u0445L\u0445L\u0445LL, float L\u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445LL, float \u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445LL) {
        \u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.startX = L\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL;
        \u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.startY = \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL;
        \u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.endY = LLLL\u0445\u0445\u0445L\u0445L\u0445L\u0445LL;
        \u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.currentScroll = \u0445LLL\u0445\u0445\u0445L\u0445L\u0445L\u0445LL;
        \u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.maxScroll = L\u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445LL;
        \u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.minScroll = \u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445LL;
    }

    public float getStartX() {
        Scrollbar LL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL;
        return LL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL.startX;
    }

    public float getStartY() {
        Scrollbar \u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL;
        return \u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL.startY;
    }

    public float getEndY() {
        Scrollbar L\u0445LLLLL\u0445\u0445L\u0445L\u0445LL;
        return L\u0445LLLLL\u0445\u0445L\u0445L\u0445LL.endY;
    }

    public float getCurrentScroll() {
        Scrollbar \u0445L\u0445LLLL\u0445\u0445L\u0445L\u0445LL;
        return \u0445L\u0445LLLL\u0445\u0445L\u0445L\u0445LL.currentScroll;
    }

    public float getMaxScroll() {
        Scrollbar LLL\u0445LLL\u0445\u0445L\u0445L\u0445LL;
        return LLL\u0445LLL\u0445\u0445L\u0445L\u0445LL.maxScroll;
    }

    public float getMinScroll() {
        Scrollbar \u0445\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL;
        return \u0445\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL.minScroll;
    }
}

