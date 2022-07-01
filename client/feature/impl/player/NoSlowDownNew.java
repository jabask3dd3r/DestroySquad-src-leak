/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import net.minecraft.client.entity.EntityPlayerSP;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventSendPacket;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class NoSlowDownNew
extends Feature {
    public static NumberSetting percentage;
    public static BooleanSetting soulSand;
    public static BooleanSetting slimeBlock;
    public static ListSetting noSlowMode;
    public static BooleanSetting AutoJump;
    public static float randomizeFloat;

    public NoSlowDownNew() {
        super("NoSlowDown", "NoSlowEat", Type.Movement);
        NoSlowDownNew \u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445LLL;
        noSlowMode = new ListSetting("NoSlow Mode", "Packet", () -> true, "Packet", "SunRise dont jump");
        percentage = new NumberSetting("Perc", 100.0f, 0.0f, 100.0f, 1.0f, () -> true);
        AutoJump = new BooleanSetting("Auto Jump", false, () -> true);
        \u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445LLL.addSettings(noSlowMode);
    }

    @Override
    public void onDisable() {
        NoSlowDownNew LLL\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL;
        NoSlowDownNew.mc.timer.timerSpeed = 1.0f;
        super.onDisable();
    }

    @EventTarget
    public void onSendPacket(EventSendPacket \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL) {
        switch (NoSlowDownNew.noSlowMode.currentMode) {
            case "Packet": {
                if (!NoSlowDownNew.noSlowMode.currentMode.equals("Packet")) break;
                if (NoSlowDownNew.noSlowMode.currentMode.equals("Packet") && NoSlowDownNew.mc.player.isUsingItem()) {
                    if (NoSlowDownNew.mc.player.onGround && !NoSlowDownNew.mc.gameSettings.keyBindJump.isKeyDown()) {
                        if (NoSlowDownNew.mc.player.ticksExisted % 2 == 0) {
                            EntityPlayerSP L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL = NoSlowDownNew.mc.player;
                            L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL.motionX *= 0.46;
                            EntityPlayerSP \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL = NoSlowDownNew.mc.player;
                            \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL.motionZ *= 0.46;
                        }
                    } else if ((double)NoSlowDownNew.mc.player.fallDistance > 0.2) {
                        EntityPlayerSP LLLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = NoSlowDownNew.mc.player;
                        LLLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.motionX *= (double)0.91f;
                        EntityPlayerSP \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = NoSlowDownNew.mc.player;
                        \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.motionZ *= (double)0.91f;
                    }
                }
                switch (NoSlowDownNew.noSlowMode.currentMode) {
                    case "SunRise dont jump": {
                        if ((double)NoSlowDownNew.mc.player.fallDistance > 0.22) {
                            NoSlowDownNew.mc.player.motionX *= (double)0.91f;
                            NoSlowDownNew.mc.player.motionZ *= (double)0.91f;
                        }
                        NoSlowDownNew.mc.player.motionX *= 0.5;
                        NoSlowDownNew.mc.player.motionZ *= 0.5;
                    }
                }
            }
        }
    }
}

