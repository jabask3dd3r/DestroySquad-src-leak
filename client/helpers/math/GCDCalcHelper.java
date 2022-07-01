/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.math;

import org.Destroy.client.helpers.Helper;

public class GCDCalcHelper
implements Helper {
    public GCDCalcHelper() {
        GCDCalcHelper \u0445L\u0445L\u0445\u0445LLLLLL\u0445\u0445L;
    }

    public static float getFixedRotation(float LLL\u0445\u0445\u0445LLLLLL\u0445\u0445L) {
        return GCDCalcHelper.getDeltaMouse(LLL\u0445\u0445\u0445LLLLLL\u0445\u0445L) * GCDCalcHelper.getGCDValue();
    }

    public static float getGCDValue() {
        return (float)((double)GCDCalcHelper.getGCD() * 0.15);
    }

    public static float getGCD() {
        float \u0445\u0445L\u0445\u0445\u0445LLLLLL\u0445\u0445L = (float)((double)GCDCalcHelper.mc.gameSettings.mouseSensitivity * 0.6 + 0.2);
        return \u0445\u0445L\u0445\u0445\u0445LLLLLL\u0445\u0445L * \u0445\u0445L\u0445\u0445\u0445LLLLLL\u0445\u0445L * \u0445\u0445L\u0445\u0445\u0445LLLLLL\u0445\u0445L * 8.0f;
    }

    public static float getDeltaMouse(float L\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445\u0445L) {
        return Math.round(L\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445\u0445L / GCDCalcHelper.getGCDValue());
    }
}

