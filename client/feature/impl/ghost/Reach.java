/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.ghost;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.MathematicHelper;
import org.Destroy.client.settings.impl.NumberSetting;

public class Reach
extends Feature {
    public static NumberSetting reachValue;

    public Reach() {
        super("Reach", "\nIncreases hitting distance", Type.Combat);
        Reach L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L;
        reachValue = new NumberSetting("Expand", 3.2f, 3.0f, 5.0f, 0.1f, () -> true);
        L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L.addSettings(reachValue);
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445\u0445LLLLLL\u0445\u0445\u0445\u0445\u0445\u0445L) {
        Reach L\u0445LLLLLL\u0445\u0445\u0445\u0445\u0445\u0445L;
        L\u0445LLLLLL\u0445\u0445\u0445\u0445\u0445\u0445L.setSuffix("" + MathematicHelper.round(reachValue.getNumberValue(), 1));
    }
}

