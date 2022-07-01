/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.util;

public class Color {
    public Color() {
        Color \u0445\u0445\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L;
    }

    public static java.awt.Color rainbow(float LL\u0445\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L, float \u0445L\u0445\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L) {
        double L\u0445\u0445\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L = (double)System.currentTimeMillis() / (double)LL\u0445\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L;
        L\u0445\u0445\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L += (double)\u0445L\u0445\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L;
        return java.awt.Color.getHSBColor((float)((L\u0445\u0445\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L %= 255.0) / 255.0), 1.0f, 1.0f);
    }
}

