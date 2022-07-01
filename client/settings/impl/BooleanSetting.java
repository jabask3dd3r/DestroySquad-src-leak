/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.settings.impl;

import java.util.function.Supplier;
import org.Destroy.client.settings.Setting;

public class BooleanSetting
extends Setting {
    private boolean state;
    private String desc;

    public BooleanSetting(String \u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445LL, String LLL\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL, boolean \u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL, Supplier<Boolean> L\u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL) {
        BooleanSetting L\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445LL;
        L\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445LL.name = \u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445LL;
        L\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445LL.desc = LLL\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL;
        L\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445LL.state = \u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL;
        L\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445LL.setVisible(L\u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL);
    }

    public BooleanSetting(String \u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL, boolean L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL, Supplier<Boolean> \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL) {
        BooleanSetting LL\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL;
        LL\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL.name = \u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL;
        LL\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL.state = L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL;
        LL\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL.setVisible(\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL);
    }

    public String getDesc() {
        BooleanSetting \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LL;
        return \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LL.desc;
    }

    public void setDesc(String L\u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LL) {
        \u0445LLLL\u0445\u0445\u0445\u0445\u0445LL\u0445LL.desc = L\u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LL;
    }

    public boolean getBoolValue() {
        BooleanSetting L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LL;
        return L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LL.state;
    }

    public void setBoolValue(boolean \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LL) {
        L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LL.state = \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LL;
    }
}

