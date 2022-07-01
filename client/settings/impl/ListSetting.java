/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.settings.impl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import org.Destroy.client.settings.Setting;

public class ListSetting
extends Setting {
    public final List<String> modes;
    public String currentMode;
    public int index;

    public ListSetting(String \u0445LL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL, String L\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445LL, Supplier<Boolean> \u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445LL, String ... LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445LL) {
        ListSetting LLL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL;
        LLL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL.name = \u0445LL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL;
        LLL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL.modes = Arrays.asList(LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445LL);
        LLL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL.index = LLL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL.modes.indexOf(L\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445LL);
        LLL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL.currentMode = LLL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL.modes.get(LLL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL.index);
        LLL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL.setVisible(\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445LL);
        LLL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL.addSettings(LLL\u0445L\u0445\u0445L\u0445\u0445L\u0445LL);
    }

    public String getCurrentMode() {
        ListSetting \u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445LL;
        return \u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445LL.currentMode;
    }

    public void setListMode(String LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL) {
        ListSetting \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LL;
        \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LL.currentMode = LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL;
        \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LL.index = \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LL.modes.indexOf(LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL);
    }

    public List<String> getModes() {
        ListSetting LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL;
        return LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL.modes;
    }

    public String getOptions() {
        ListSetting \u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL;
        return \u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL.modes.get(\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL.index);
    }
}

