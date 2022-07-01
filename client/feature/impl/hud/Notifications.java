/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.hud;

import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;

public class Notifications
extends Feature {
    public static BooleanSetting state;

    public Notifications() {
        super("Notifications", "Shows necessary information about modules", Type.Hud);
        Notifications \u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL\u0445L;
        state = new BooleanSetting("Module State", true, () -> true);
        \u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL\u0445L.addSettings(state);
    }
}

