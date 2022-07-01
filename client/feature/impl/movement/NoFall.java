/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import net.minecraft.network.play.client.CPacketPlayer;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.settings.impl.ListSetting;

public class NoFall
extends Feature {
    public static ListSetting noFallMode;
    public TimerHelper timerHelper = new TimerHelper();

    public NoFall() {
        super("NoFallDontDamage", "Dont damage for fall", Type.Movement);
        NoFall LL\u0445\u0445L\u0445LL\u0445LLLL\u0445L;
        noFallMode = new ListSetting("NoFall Mode", "Matrix", () -> true, "Vanilla", "AAC-Flags", "Matrix");
        LL\u0445\u0445L\u0445LL\u0445LLLL\u0445L.addSettings(noFallMode);
    }

    @EventTarget
    public void onPreMotion(EventPreMotion L\u0445LL\u0445\u0445LL\u0445LLLL\u0445L) {
        NoFall \u0445LLL\u0445\u0445LL\u0445LLLL\u0445L;
        String \u0445\u0445LL\u0445\u0445LL\u0445LLLL\u0445L = noFallMode.getOptions();
        \u0445LLL\u0445\u0445LL\u0445LLLL\u0445L.setSuffix(\u0445\u0445LL\u0445\u0445LL\u0445LLLL\u0445L);
        if (\u0445\u0445LL\u0445\u0445LL\u0445LLLL\u0445L.equalsIgnoreCase("Vanilla")) {
            if (NoFall.mc.player.fallDistance > 3.0f) {
                L\u0445LL\u0445\u0445LL\u0445LLLL\u0445L.setOnGround(true);
                NoFall.mc.player.connection.sendPacket(new CPacketPlayer(true));
            }
        } else if (\u0445\u0445LL\u0445\u0445LL\u0445LLLL\u0445L.equalsIgnoreCase("Spartan")) {
            if (NoFall.mc.player.fallDistance > 3.5f) {
                if (\u0445LLL\u0445\u0445LL\u0445LLLL\u0445L.timerHelper.hasReached(150.0f)) {
                    NoFall.mc.player.connection.sendPacket(new CPacketPlayer.Position(NoFall.mc.player.posX, NoFall.mc.player.posY, NoFall.mc.player.posZ, true));
                    \u0445LLL\u0445\u0445LL\u0445LLLL\u0445L.timerHelper.reset();
                } else {
                    NoFall.mc.player.onGround = false;
                }
            }
        } else if (\u0445\u0445LL\u0445\u0445LL\u0445LLLL\u0445L.equalsIgnoreCase("AAC-Flags")) {
            NoFall.mc.player.motionY -= 0.1;
            L\u0445LL\u0445\u0445LL\u0445LLLL\u0445L.setOnGround(true);
            NoFall.mc.player.capabilities.disableDamage = true;
        } else if (\u0445\u0445LL\u0445\u0445LL\u0445LLLL\u0445L.equalsIgnoreCase("Hypixel")) {
            if ((double)NoFall.mc.player.fallDistance > 3.4) {
                L\u0445LL\u0445\u0445LL\u0445LLLL\u0445L.setOnGround(NoFall.mc.player.ticksExisted % 2 == 0);
            }
        } else if (\u0445\u0445LL\u0445\u0445LL\u0445LLLL\u0445L.equalsIgnoreCase("Matrix")) {
            if (NoFall.mc.player.fallDistance > 3.0f) {
                NoFall.mc.player.fallDistance = (float)(Math.random() * 1.0E-12);
                NoFall.mc.player.connection.sendPacket(new CPacketPlayer.PositionRotation(NoFall.mc.player.posX, NoFall.mc.player.posY, NoFall.mc.player.posZ, NoFall.mc.player.rotationYaw, NoFall.mc.player.rotationPitch, true));
                NoFall.mc.player.fallDistance = 0.0f;
            }
        } else if (\u0445\u0445LL\u0445\u0445LL\u0445LLLL\u0445L.equalsIgnoreCase("GroundCancel")) {
            L\u0445LL\u0445\u0445LL\u0445LLLL\u0445L.setOnGround(false);
        }
    }
}

