/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.settings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.Destroy.client.settings.Setting;

public class Configurable {
    private final ArrayList<Setting> settingList = new ArrayList();

    public Configurable() {
        Configurable L\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L;
    }

    public final void addSettings(Setting ... \u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L) {
        Configurable L\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L;
        L\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L.settingList.addAll(Arrays.asList(\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L));
    }

    public final List<Setting> getSettings() {
        Configurable \u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L;
        return \u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L.settingList;
    }
}

