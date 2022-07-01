/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.MathematicHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class KeepSprint
extends Feature {
    public static NumberSetting speed;
    public static BooleanSetting setSprinting;

    public KeepSprint() {
        super("KeepSprint", "\nAllows you to edit the speed of the player on impact", Type.Combat);
        KeepSprint LLL\u0445\u0445\u0445\u0445LL;
        speed = new NumberSetting("Keep Speed", 1.0f, 0.5f, 2.0f, 0.01f, () -> true);
        setSprinting = new BooleanSetting("Set Sprinting", true, () -> true);
        LLL\u0445\u0445\u0445\u0445LL.addSettings(setSprinting, speed);
    }

    @EventTarget
    public void onUpdate(EventUpdate L\u0445\u0445\u0445\u0445\u0445\u0445LL) {
        KeepSprint \u0445L\u0445\u0445\u0445\u0445\u0445LL;
        \u0445L\u0445\u0445\u0445\u0445\u0445LL.setSuffix("" + MathematicHelper.round(speed.getNumberValue(), 2));
    }
}

