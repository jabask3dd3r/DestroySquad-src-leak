/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.settings.impl.NumberSetting;

public class WaterSpeed
extends Feature {
    public NumberSetting timer = new NumberSetting("Speed", 0.46f, 0.1f, 2.0f, 0.1f, () -> true);

    public WaterSpeed() {
        super("WaterSpeed", "Increases your speed in water", Type.Movement);
        WaterSpeed LLLLLL\u0445\u0445L\u0445\u0445\u0445L;
        LLLLLL\u0445\u0445L\u0445\u0445\u0445L.addSettings(LLLLLL\u0445\u0445L\u0445\u0445\u0445L.timer);
    }

    @EventTarget
    public void onTick(EventUpdate \u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445\u0445L) {
        if (WaterSpeed.mc.player.isInWater() && WaterSpeed.mc.player.isSprinting() && MovementHelper.isMoving()) {
            WaterSpeed \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L;
            WaterSpeed.mc.player.fallDistance = 0.1f;
            MovementHelper.setSpeed(\u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L.timer.getNumberValue());
            WaterSpeed.mc.player.noClip = true;
        }
    }
}

