/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import net.minecraft.network.play.client.CPacketPlayer;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class HighJump
extends Feature {
    public ListSetting mode;
    public NumberSetting motionBoost;
    public BooleanSetting motionYBoost = new BooleanSetting("MotionY boost", false, () -> true);
    public boolean jump = false;
    public TimerHelper helper = new TimerHelper();
    private int ticks = 0;
    private boolean timerEnable = false;

    public HighJump() {
        super("HighJump", "You fly up to a high altitude when you take damage.", Type.Movement);
        HighJump \u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L;
        \u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L.mode = new ListSetting("HighJump Mode", "AntiCheatA", () -> true, "AntiCheatA", "AntiCheatB", "Matrix", "Vanilla", "Matrix 6.3.0");
        \u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L.motionBoost = new NumberSetting("Motion Boost", 0.6f, 0.1f, 8.0f, 0.1f, () -> {
            HighJump \u0445\u0445L\u0445LLLL\u0445\u0445\u0445LL\u0445L;
            return \u0445\u0445L\u0445LLLL\u0445\u0445\u0445LL\u0445L.mode.currentMode.equals("AntiCheatA") && \u0445\u0445L\u0445LLLL\u0445\u0445\u0445LL\u0445L.motionYBoost.getBoolValue() || \u0445\u0445L\u0445LLLL\u0445\u0445\u0445LL\u0445L.mode.currentMode.equals("Vanilla");
        });
        \u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L.addSettings(\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L.mode, \u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L.motionYBoost, \u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L.motionBoost);
    }

    @EventTarget
    public void onPreUpdate(EventUpdate L\u0445LLLLLL\u0445\u0445\u0445LL\u0445L) {
        HighJump \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L;
        String \u0445\u0445LLLLLL\u0445\u0445\u0445LL\u0445L = \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.mode.currentMode;
        \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.setSuffix(\u0445\u0445LLLLLL\u0445\u0445\u0445LL\u0445L);
        if (!\u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.getState()) {
            return;
        }
        if (\u0445\u0445LLLLLL\u0445\u0445\u0445LL\u0445L.equals("Matrix")) {
            if (HighJump.mc.gameSettings.keyBindJump.pressed) {
                HighJump.mc.player.motionY += 0.42;
            }
        } else if (\u0445\u0445LLLLLL\u0445\u0445\u0445LL\u0445L.equalsIgnoreCase("AntiCheatB")) {
            if (HighJump.mc.player.hurtTime > 0) {
                HighJump.mc.player.motionY += 1.3;
            }
        } else if (\u0445\u0445LLLLLL\u0445\u0445\u0445LL\u0445L.equals("Matrix 6.3.0")) {
            if (\u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.timerEnable) {
                HighJump.mc.timer.timerSpeed = 1.0f;
                \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.timerEnable = false;
            }
            if (!(HighJump.mc.world.getCollisionBoxes(HighJump.mc.player, HighJump.mc.player.getEntityBoundingBox().offset(0.0, HighJump.mc.player.motionY, 0.0).expand(0.0, 0.0, 0.0)).isEmpty() && HighJump.mc.world.getCollisionBoxes(HighJump.mc.player, HighJump.mc.player.getEntityBoundingBox().offset(0.0, -4.0, 0.0).expand(0.0, 0.0, 0.0)).isEmpty() || !(HighJump.mc.player.fallDistance > 10.0f) || HighJump.mc.player.onGround)) {
                HighJump.mc.timer.timerSpeed = 0.1f;
                \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.timerEnable = true;
            }
            if (\u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.helper.hasReached(1000.0f) && \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.ticks == 1) {
                HighJump.mc.timer.timerSpeed = 1.0f;
                HighJump.mc.player.motionX = 0.0;
                HighJump.mc.player.motionZ = 0.0;
                \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.ticks = 0;
            }
            if (\u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.ticks == 1 && HighJump.mc.player.hurtTime > 0) {
                HighJump.mc.timer.timerSpeed = 1.0f;
                HighJump.mc.player.motionY = 9.0;
                HighJump.mc.player.motionX = 0.0;
                HighJump.mc.player.motionZ = 0.0;
                \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.ticks = 0;
            }
            if (\u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.ticks == 2) {
                int LLLLLLLL\u0445\u0445\u0445LL\u0445L = 0;
                if (LLLLLLLL\u0445\u0445\u0445LL\u0445L < 9) {
                    HighJump.mc.player.connection.sendPacket(new CPacketPlayer.Position(HighJump.mc.player.posX, HighJump.mc.player.posY, HighJump.mc.player.posZ, false));
                    HighJump.mc.player.connection.sendPacket(new CPacketPlayer.Position(HighJump.mc.player.posX, HighJump.mc.player.posY + 0.399, HighJump.mc.player.posZ, false));
                    ++LLLLLLLL\u0445\u0445\u0445LL\u0445L;
                    return;
                }
                HighJump.mc.player.connection.sendPacket(new CPacketPlayer.Position(HighJump.mc.player.posX, HighJump.mc.player.posY, HighJump.mc.player.posZ, true));
                HighJump.mc.player.connection.sendPacket(new CPacketPlayer.Position(HighJump.mc.player.posX, HighJump.mc.player.posY, HighJump.mc.player.posZ, true));
                HighJump.mc.timer.timerSpeed = 0.6f;
                \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.ticks = 1;
                \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.helper.reset();
            }
            if (HighJump.mc.player.isCollidedHorizontally && \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.ticks == 0 && HighJump.mc.player.onGround) {
                \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.ticks = 2;
                HighJump.mc.timer.timerSpeed = 0.05f;
            }
            if (HighJump.mc.player.isCollidedHorizontally && HighJump.mc.player.onGround) {
                HighJump.mc.player.motionX = 0.0;
                HighJump.mc.player.motionZ = 0.0;
                HighJump.mc.player.onGround = false;
            }
        } else if (\u0445\u0445LLLLLL\u0445\u0445\u0445LL\u0445L.equalsIgnoreCase("AntiCheatA")) {
            if (HighJump.mc.player.hurtTime > 0) {
                HighJump.mc.player.motionY += (double)\u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.motionBoost.getNumberValue();
            }
        } else if (\u0445\u0445LLLLLL\u0445\u0445\u0445LL\u0445L.equalsIgnoreCase("Vanilla") && !\u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.jump) {
            \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.jump = true;
            if (HighJump.mc.gameSettings.keyBindJump.pressed) {
                HighJump.mc.player.motionY += (double)\u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.motionBoost.getNumberValue();
            }
        }
        if (HighJump.mc.player.onGround) {
            \u0445LLLLLLL\u0445\u0445\u0445LL\u0445L.jump = false;
        }
    }

    @Override
    public void onDisable() {
        HighJump LLL\u0445LLLL\u0445\u0445\u0445LL\u0445L;
        HighJump.mc.timer.timerSpeed = 1.0f;
        LLL\u0445LLLL\u0445\u0445\u0445LL\u0445L.ticks = 0;
        LLL\u0445LLLL\u0445\u0445\u0445LL\u0445L.timerEnable = false;
        super.onDisable();
    }
}

