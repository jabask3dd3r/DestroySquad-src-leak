/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.settings.impl.NumberSetting;

public class WallClimb
extends Feature {
    public static NumberSetting climbTicks;
    private final TimerHelper timerHelper = new TimerHelper();

    public WallClimb() {
        super("Spider", "Automatically climbs walls", Type.Movement);
        WallClimb \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L;
        climbTicks = new NumberSetting("Climb Ticks", 1.0f, 0.0f, 5.0f, 0.1f, () -> true);
        \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L.addSettings(climbTicks);
    }

    @EventTarget
    public void onPreMotion(EventPreMotion L\u0445LLLLLLL\u0445L\u0445L\u0445L) {
        WallClimb \u0445LLLLLLLL\u0445L\u0445L\u0445L;
        \u0445LLLLLLLL\u0445L\u0445L\u0445L.setSuffix("" + climbTicks.getNumberValue());
        if (MovementHelper.isMoving() && WallClimb.mc.player.isCollidedHorizontally && \u0445LLLLLLLL\u0445L\u0445L\u0445L.timerHelper.hasReached(climbTicks.getNumberValue() * 100.0f)) {
            L\u0445LLLLLLL\u0445L\u0445L\u0445L.setOnGround(true);
            WallClimb.mc.player.onGround = true;
            WallClimb.mc.player.isCollidedVertically = true;
            WallClimb.mc.player.isCollidedHorizontally = true;
            WallClimb.mc.player.isAirBorne = true;
            WallClimb.mc.player.jump();
            \u0445LLLLLLLL\u0445L\u0445L\u0445L.timerHelper.reset();
        }
    }
}

