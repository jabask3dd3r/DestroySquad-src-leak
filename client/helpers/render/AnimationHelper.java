/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.render;

import net.minecraft.client.Minecraft;

public class AnimationHelper {
    public AnimationHelper() {
        AnimationHelper L\u0445\u0445LLLLL\u0445\u0445LL\u0445\u0445L;
    }

    public static float animation(float LL\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L, float L\u0445\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L, float \u0445\u0445\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L) {
        float \u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L = (L\u0445\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L - LL\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L) / Math.max((float)Minecraft.getDebugFPS(), 5.0f) * 15.0f;
        if (\u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L > 0.0f) {
            \u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L = Math.max(\u0445\u0445\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L, \u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L);
            \u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L = Math.min(L\u0445\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L - LL\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L, \u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L);
        } else if (\u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L < 0.0f) {
            \u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L = Math.min(-\u0445\u0445\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L, \u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L);
            \u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L = Math.max(L\u0445\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L - LL\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L, \u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L);
        }
        return LL\u0445L\u0445LLL\u0445\u0445LL\u0445\u0445L + \u0445LL\u0445\u0445LLL\u0445\u0445LL\u0445\u0445L;
    }

    public static float calculateCompensation(float \u0445\u0445LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L, float \u0445L\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L, long \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L, double LLL\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L) {
        float L\u0445L\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L = \u0445L\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L - \u0445\u0445LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L;
        if (\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L < 1L) {
            \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L = 1L;
        }
        if (\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L > 1000L) {
            \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L = 16L;
        }
        double LL\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L = Math.max(LLL\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L * (double)\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L / 16.66666603088379, 0.5);
        if ((double)L\u0445L\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L > LLL\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L) {
            if ((\u0445L\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L = (float)((double)\u0445L\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L - LL\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L)) < \u0445\u0445LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L) {
                \u0445L\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L = \u0445\u0445LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L;
            }
        } else if ((double)L\u0445L\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L < -LLL\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L) {
            if ((\u0445L\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L = (float)((double)\u0445L\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L + LL\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L)) > \u0445\u0445LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L) {
                \u0445L\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L = \u0445\u0445LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L;
            }
        } else {
            \u0445L\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L = \u0445\u0445LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L;
        }
        return \u0445L\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L;
    }
}

