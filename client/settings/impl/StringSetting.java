/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.settings.impl;

import java.util.function.Supplier;
import org.Destroy.client.settings.Setting;

public class StringSetting
extends Setting {
    public String defaultText;
    public String currentText;

    public StringSetting(String L\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L, String \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L, String LLLL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L, Supplier<Boolean> \u0445LLL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L) {
        StringSetting \u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
        \u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L.name = L\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
        \u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L.defaultText = \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
        \u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L.currentText = LLLL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
        \u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L.setVisible(\u0445LLL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L);
    }

    public String getDefaultText() {
        StringSetting LLL\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
        return LLL\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.defaultText;
    }

    public void setDefaultText(String \u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L) {
        LL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.defaultText = \u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
    }

    public String getCurrentText() {
        StringSetting \u0445LLLLL\u0445\u0445\u0445L\u0445L\u0445\u0445L;
        return \u0445LLLLL\u0445\u0445\u0445L\u0445L\u0445\u0445L.currentText;
    }

    public void setCurrentText(String L\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445\u0445L) {
        \u0445L\u0445LLL\u0445\u0445\u0445L\u0445L\u0445\u0445L.currentText = L\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445\u0445L;
    }
}

