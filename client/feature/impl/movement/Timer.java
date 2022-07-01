/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.NumberSetting;

public class Timer
extends Feature {
    public NumberSetting timer = new NumberSetting("Timer", 2.5f, 0.1f, 10.0f, 0.1f, () -> true);

    public Timer() {
        super("Timer", "Increases game speed", Type.Movement);
        Timer L\u0445LLL\u0445LL\u0445L\u0445L;
        L\u0445LLL\u0445LL\u0445L\u0445L.addSettings(L\u0445LLL\u0445LL\u0445L\u0445L.timer);
    }

    @EventTarget
    public void onUpdate(EventUpdate L\u0445\u0445LL\u0445LL\u0445L\u0445L) {
        Timer \u0445L\u0445LL\u0445LL\u0445L\u0445L;
        if (!\u0445L\u0445LL\u0445LL\u0445L\u0445L.getState()) {
            return;
        }
        \u0445L\u0445LL\u0445LL\u0445L\u0445L.setSuffix("" + \u0445L\u0445LL\u0445LL\u0445L\u0445L.timer.getNumberValue());
        Timer.mc.timer.timerSpeed = \u0445L\u0445LL\u0445LL\u0445L\u0445L.timer.getNumberValue();
    }

    @Override
    public void onDisable() {
        Timer \u0445LL\u0445L\u0445LL\u0445L\u0445L;
        super.onDisable();
        Timer.mc.timer.timerSpeed = 1.0f;
    }
}

