/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.settings.impl;

import java.util.function.Supplier;
import org.Destroy.client.settings.Setting;

public class ColorSetting
extends Setting {
    private int color;

    public ColorSetting(String LLL\u0445LL\u0445LL\u0445LLLL, int \u0445LL\u0445LL\u0445LL\u0445LLLL, Supplier<Boolean> L\u0445L\u0445LL\u0445LL\u0445LLLL) {
        ColorSetting \u0445\u0445\u0445LLL\u0445LL\u0445LLLL;
        \u0445\u0445\u0445LLL\u0445LL\u0445LLLL.name = LLL\u0445LL\u0445LL\u0445LLLL;
        \u0445\u0445\u0445LLL\u0445LL\u0445LLLL.color = \u0445LL\u0445LL\u0445LL\u0445LLLL;
        \u0445\u0445\u0445LLL\u0445LL\u0445LLLL.setVisible(L\u0445L\u0445LL\u0445LL\u0445LLLL);
    }

    public int getColorValue() {
        ColorSetting LLLL\u0445L\u0445LL\u0445LLLL;
        return LLLL\u0445L\u0445LL\u0445LLLL.color;
    }

    public void setColorValue(int \u0445L\u0445L\u0445L\u0445LL\u0445LLLL) {
        LL\u0445L\u0445L\u0445LL\u0445LLLL.color = \u0445L\u0445L\u0445L\u0445LL\u0445LLLL;
    }
}

