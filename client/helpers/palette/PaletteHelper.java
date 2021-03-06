/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.palette;

import java.awt.Color;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.feature.impl.hud.HUD;
import org.Destroy.client.helpers.Helper;

public class PaletteHelper
implements Helper {
    public PaletteHelper() {
        PaletteHelper \u0445\u0445\u0445LLLLLL\u0445LLL\u0445L;
    }

    public static int getHealthColor(float \u0445\u0445L\u0445LLLLL\u0445LLL\u0445L, float LL\u0445\u0445LLLLL\u0445LLL\u0445L) {
        return Color.HSBtoRGB(Math.max(0.0f, Math.min(\u0445\u0445L\u0445LLLLL\u0445LLL\u0445L, LL\u0445\u0445LLLLL\u0445LLL\u0445L) / LL\u0445\u0445LLLLL\u0445LLL\u0445L) / 3.0f, 1.0f, 0.8f) | 0xFF000000;
    }

    public static int getColor(Color LLLL\u0445LLLL\u0445LLL\u0445L) {
        return PaletteHelper.getColor(LLLL\u0445LLLL\u0445LLL\u0445L.getRed(), LLLL\u0445LLLL\u0445LLL\u0445L.getGreen(), LLLL\u0445LLLL\u0445LLL\u0445L.getBlue(), LLLL\u0445LLLL\u0445LLL\u0445L.getAlpha());
    }

    public static int getColor(int \u0445\u0445LL\u0445LLLL\u0445LLL\u0445L) {
        return PaletteHelper.getColor(\u0445\u0445LL\u0445LLLL\u0445LLL\u0445L, \u0445\u0445LL\u0445LLLL\u0445LLL\u0445L, \u0445\u0445LL\u0445LLLL\u0445LLL\u0445L, 255);
    }

    public static int getColor(int L\u0445L\u0445\u0445LLLL\u0445LLL\u0445L, int \u0445\u0445L\u0445\u0445LLLL\u0445LLL\u0445L, int LL\u0445\u0445\u0445LLLL\u0445LLL\u0445L, int \u0445L\u0445\u0445\u0445LLLL\u0445LLL\u0445L) {
        int L\u0445\u0445\u0445\u0445LLLL\u0445LLL\u0445L = 0;
        L\u0445\u0445\u0445\u0445LLLL\u0445LLL\u0445L |= \u0445L\u0445\u0445\u0445LLLL\u0445LLL\u0445L << 24;
        L\u0445\u0445\u0445\u0445LLLL\u0445LLL\u0445L |= L\u0445L\u0445\u0445LLLL\u0445LLL\u0445L << 16;
        L\u0445\u0445\u0445\u0445LLLL\u0445LLL\u0445L |= \u0445\u0445L\u0445\u0445LLLL\u0445LLL\u0445L << 8;
        return L\u0445\u0445\u0445\u0445LLLL\u0445LLL\u0445L |= LL\u0445\u0445\u0445LLLL\u0445LLL\u0445L;
    }

    public static int getColor(int L\u0445\u0445LL\u0445LLL\u0445LLL\u0445L, int \u0445\u0445\u0445LL\u0445LLL\u0445LLL\u0445L) {
        return PaletteHelper.getColor(L\u0445\u0445LL\u0445LLL\u0445LLL\u0445L, L\u0445\u0445LL\u0445LLL\u0445LLL\u0445L, L\u0445\u0445LL\u0445LLL\u0445LLL\u0445L, \u0445\u0445\u0445LL\u0445LLL\u0445LLL\u0445L);
    }

    public static Color rainbow(int L\u0445\u0445\u0445L\u0445LLL\u0445LLL\u0445L, float \u0445\u0445\u0445\u0445L\u0445LLL\u0445LLL\u0445L, float LLLL\u0445\u0445LLL\u0445LLL\u0445L) {
        double \u0445LLL\u0445\u0445LLL\u0445LLL\u0445L = Math.ceil((System.currentTimeMillis() + (long)L\u0445\u0445\u0445L\u0445LLL\u0445LLL\u0445L) / 16L);
        return Color.getHSBColor((float)((\u0445LLL\u0445\u0445LLL\u0445LLL\u0445L %= 360.0) / 360.0), \u0445\u0445\u0445\u0445L\u0445LLL\u0445LLL\u0445L, LLLL\u0445\u0445LLL\u0445LLL\u0445L);
    }

    public static int fadeColor(int \u0445LL\u0445\u0445\u0445LLL\u0445LLL\u0445L, int L\u0445L\u0445\u0445\u0445LLL\u0445LLL\u0445L, float \u0445\u0445L\u0445\u0445\u0445LLL\u0445LLL\u0445L) {
        if (\u0445\u0445L\u0445\u0445\u0445LLL\u0445LLL\u0445L > 1.0f) {
            \u0445\u0445L\u0445\u0445\u0445LLL\u0445LLL\u0445L = 1.0f - \u0445\u0445L\u0445\u0445\u0445LLL\u0445LLL\u0445L % 1.0f;
        }
        return PaletteHelper.fade(\u0445LL\u0445\u0445\u0445LLL\u0445LLL\u0445L, L\u0445L\u0445\u0445\u0445LLL\u0445LLL\u0445L, \u0445\u0445L\u0445\u0445\u0445LLL\u0445LLL\u0445L);
    }

    public static int fade(int \u0445\u0445\u0445LLL\u0445LL\u0445LLL\u0445L, int LLL\u0445LL\u0445LL\u0445LLL\u0445L, float \u0445LL\u0445LL\u0445LL\u0445LLL\u0445L) {
        float L\u0445L\u0445LL\u0445LL\u0445LLL\u0445L = 1.0f - \u0445LL\u0445LL\u0445LL\u0445LLL\u0445L;
        int \u0445\u0445L\u0445LL\u0445LL\u0445LLL\u0445L = (int)((float)(\u0445\u0445\u0445LLL\u0445LL\u0445LLL\u0445L >> 16 & 0xFF) * L\u0445L\u0445LL\u0445LL\u0445LLL\u0445L + (float)(LLL\u0445LL\u0445LL\u0445LLL\u0445L >> 16 & 0xFF) * \u0445LL\u0445LL\u0445LL\u0445LLL\u0445L);
        int LL\u0445\u0445LL\u0445LL\u0445LLL\u0445L = (int)((float)(\u0445\u0445\u0445LLL\u0445LL\u0445LLL\u0445L >> 8 & 0xFF) * L\u0445L\u0445LL\u0445LL\u0445LLL\u0445L + (float)(LLL\u0445LL\u0445LL\u0445LLL\u0445L >> 8 & 0xFF) * \u0445LL\u0445LL\u0445LL\u0445LLL\u0445L);
        int \u0445L\u0445\u0445LL\u0445LL\u0445LLL\u0445L = (int)((float)(\u0445\u0445\u0445LLL\u0445LL\u0445LLL\u0445L & 0xFF) * L\u0445L\u0445LL\u0445LL\u0445LLL\u0445L + (float)(LLL\u0445LL\u0445LL\u0445LLL\u0445L & 0xFF) * \u0445LL\u0445LL\u0445LL\u0445LLL\u0445L);
        int L\u0445\u0445\u0445LL\u0445LL\u0445LLL\u0445L = (int)((float)(\u0445\u0445\u0445LLL\u0445LL\u0445LLL\u0445L >> 24 & 0xFF) * L\u0445L\u0445LL\u0445LL\u0445LLL\u0445L + (float)(LLL\u0445LL\u0445LL\u0445LLL\u0445L >> 24 & 0xFF) * \u0445LL\u0445LL\u0445LL\u0445LLL\u0445L);
        return (L\u0445\u0445\u0445LL\u0445LL\u0445LLL\u0445L & 0xFF) << 24 | (\u0445\u0445L\u0445LL\u0445LL\u0445LLL\u0445L & 0xFF) << 16 | (LL\u0445\u0445LL\u0445LL\u0445LLL\u0445L & 0xFF) << 8 | \u0445L\u0445\u0445LL\u0445LL\u0445LLL\u0445L & 0xFF;
    }

    public static Color astolfo(boolean \u0445\u0445L\u0445\u0445L\u0445LL\u0445LLL\u0445L, int LL\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L) {
        float \u0445L\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L = \u0445\u0445L\u0445\u0445L\u0445LL\u0445LLL\u0445L ? ClickGui.speed.getNumberValue() * 100.0f : HUD.time.getNumberValue() * 100.0f;
        float L\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L = System.currentTimeMillis() % (long)((int)\u0445L\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L) + (long)LL\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L;
        if (L\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L > \u0445L\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L) {
            L\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L -= \u0445L\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L;
        }
        if ((L\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L /= \u0445L\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L) > 0.5f) {
            L\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L = 0.5f - (L\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L - 0.5f);
        }
        return Color.getHSBColor(L\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L += 0.5f, 0.4f, 1.0f);
    }
}

