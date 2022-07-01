/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.game.EventTick;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class LongPerlJump
extends Feature {
    public ListSetting mode;
    public NumberSetting boostMultiplier;
    public NumberSetting motionBoost;
    public BooleanSetting motionYBoost = new BooleanSetting("MotionY boost", false, () -> true);

    public LongPerlJump() {
        super("LongPearl", "Allows you to jump to a greater length, with damage.", Type.Movement);
        LongPerlJump LLLLLL\u0445L\u0445\u0445\u0445LLLL;
        LLLLLL\u0445L\u0445\u0445\u0445LLLL.mode = new ListSetting("LongPerlJump Mode", "PearlLeave", () -> true, "PearlLeave");
        LLLLLL\u0445L\u0445\u0445\u0445LLLL.addSettings(LLLLLL\u0445L\u0445\u0445\u0445LLLL.mode);
    }

    @EventTarget
    public void onPreUpdate(EventTick \u0445L\u0445LLL\u0445L\u0445\u0445\u0445LLLL) {
        LongPerlJump LL\u0445LLL\u0445L\u0445\u0445\u0445LLLL;
        String L\u0445\u0445LLL\u0445L\u0445\u0445\u0445LLLL = LL\u0445LLL\u0445L\u0445\u0445\u0445LLLL.mode.getOptions();
        LL\u0445LLL\u0445L\u0445\u0445\u0445LLLL.setSuffix(L\u0445\u0445LLL\u0445L\u0445\u0445\u0445LLLL);
        if (!LL\u0445LLL\u0445L\u0445\u0445\u0445LLLL.getState()) {
            return;
        }
        if (L\u0445\u0445LLL\u0445L\u0445\u0445\u0445LLLL.equalsIgnoreCase("PearlLeave") && LongPerlJump.mc.player.hurtTime > 0) {
            if (LongPerlJump.mc.gameSettings.keyBindJump.pressed) {
                // empty if block
            }
            LongPerlJump.mc.player.jump();
            LongPerlJump.mc.player.motionY += 0.73;
        }
    }

    @Override
    public void onDisable() {
        LongPerlJump L\u0445L\u0445LL\u0445L\u0445\u0445\u0445LLLL;
        LongPerlJump.mc.timer.timerSpeed = 1.0f;
        super.onDisable();
    }
}

