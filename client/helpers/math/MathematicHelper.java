/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import net.minecraft.util.math.MathHelper;
import org.Destroy.client.helpers.Helper;

public class MathematicHelper
implements Helper {
    public MathematicHelper() {
        MathematicHelper L\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445L;
    }

    public static BigDecimal round(float \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445L, int LLLLLL\u0445L\u0445L\u0445\u0445L\u0445L) {
        BigDecimal \u0445LLLLL\u0445L\u0445L\u0445\u0445L\u0445L = new BigDecimal(Float.toString(\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445L));
        \u0445LLLLL\u0445L\u0445L\u0445\u0445L\u0445L = \u0445LLLLL\u0445L\u0445L\u0445\u0445L\u0445L.setScale(LLLLLL\u0445L\u0445L\u0445\u0445L\u0445L, RoundingMode.HALF_UP);
        return \u0445LLLLL\u0445L\u0445L\u0445\u0445L\u0445L;
    }

    public static int getMiddle(int \u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L\u0445L, int LLL\u0445LL\u0445L\u0445L\u0445\u0445L\u0445L) {
        return (\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L\u0445L + LLL\u0445LL\u0445L\u0445L\u0445\u0445L\u0445L) / 2;
    }

    public static double round(double \u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L\u0445L, double LLLL\u0445L\u0445L\u0445L\u0445\u0445L\u0445L) {
        double \u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L\u0445L = (double)Math.round(\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L\u0445L / LLLL\u0445L\u0445L\u0445L\u0445\u0445L\u0445L) * LLLL\u0445L\u0445L\u0445L\u0445\u0445L\u0445L;
        BigDecimal L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445L = new BigDecimal(\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L\u0445L);
        L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445L = L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445L.setScale(2, RoundingMode.HALF_UP);
        return L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445L.doubleValue();
    }

    public static float checkAngle(float \u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L, float LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L, float \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L) {
        float L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L = MathHelper.wrapDegrees(\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L - LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L);
        if (L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L < -\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L) {
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L = -\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L;
        }
        if (L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L >= \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L) {
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L = \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L;
        }
        return \u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L - L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L;
    }

    public static float clamp(float L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L\u0445L, float \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L\u0445L, float LLL\u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L) {
        if (L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L\u0445L <= \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L\u0445L) {
            L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L\u0445L = \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L\u0445L;
        }
        if (L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L\u0445L >= LLL\u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L) {
            L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L\u0445L = LLL\u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L;
        }
        return L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L\u0445L;
    }

    public static float randomizeFloat(float L\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L, float \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L) {
        return (float)((double)L\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L + (double)(\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L - L\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L) * Math.random());
    }
}

