/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.util;

public class MathUtil {
    public MathUtil() {
        MathUtil L\u0445LLLL\u0445LL\u0445\u0445\u0445LLL;
    }

    public static double distance(float LLL\u0445LL\u0445LL\u0445\u0445\u0445LLL, float \u0445LL\u0445LL\u0445LL\u0445\u0445\u0445LLL, float L\u0445L\u0445LL\u0445LL\u0445\u0445\u0445LLL, float \u0445\u0445L\u0445LL\u0445LL\u0445\u0445\u0445LLL) {
        return Math.sqrt((LLL\u0445LL\u0445LL\u0445\u0445\u0445LLL - L\u0445L\u0445LL\u0445LL\u0445\u0445\u0445LLL) * (LLL\u0445LL\u0445LL\u0445\u0445\u0445LLL - L\u0445L\u0445LL\u0445LL\u0445\u0445\u0445LLL) + (\u0445LL\u0445LL\u0445LL\u0445\u0445\u0445LLL - \u0445\u0445L\u0445LL\u0445LL\u0445\u0445\u0445LLL) * (\u0445LL\u0445LL\u0445LL\u0445\u0445\u0445LLL - \u0445\u0445L\u0445LL\u0445LL\u0445\u0445\u0445LLL));
    }

    public static double round(double L\u0445LL\u0445L\u0445LL\u0445\u0445\u0445LLL, double \u0445\u0445LL\u0445L\u0445LL\u0445\u0445\u0445LLL) {
        \u0445\u0445LL\u0445L\u0445LL\u0445\u0445\u0445LLL = 1.0 / \u0445\u0445LL\u0445L\u0445LL\u0445\u0445\u0445LLL;
        return (double)Math.round(L\u0445LL\u0445L\u0445LL\u0445\u0445\u0445LLL * \u0445\u0445LL\u0445L\u0445LL\u0445\u0445\u0445LLL) / \u0445\u0445LL\u0445L\u0445LL\u0445\u0445\u0445LLL;
    }
}

