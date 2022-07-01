/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.MathHelper;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class Flight
extends Feature {
    public static ListSetting flyMode;
    public static NumberSetting speed;

    public Flight() {
        super("Flight", "Simulator SpiderMan", Type.Movement);
        Flight \u0445LL\u0445\u0445LLL\u0445LL\u0445\u0445L;
        flyMode = new ListSetting("Flight Mode", "Vanilla", () -> true, "Vanilla", "Matrix Web", "ReallyWorld Elytra");
        speed = new NumberSetting("Flight Speed", 5.0f, 0.1f, 15.0f, 0.1f, () -> Flight.flyMode.currentMode.equals("Vanilla") || Flight.flyMode.currentMode.equals("WellMore"));
        \u0445LL\u0445\u0445LLL\u0445LL\u0445\u0445L.addSettings(flyMode, speed);
    }

    @Override
    public void onDisable() {
        Flight LL\u0445\u0445\u0445LLL\u0445LL\u0445\u0445L;
        super.onDisable();
        Flight.mc.player.speedInAir = 0.02f;
        Flight.mc.timer.timerSpeed = 1.0f;
        Flight.mc.player.capabilities.isFlying = false;
        if (flyMode.getOptions().equalsIgnoreCase("WellMore")) {
            Flight.mc.player.motionY = 0.0;
            Flight.mc.player.motionX = 0.0;
            Flight.mc.player.motionZ = 0.0;
        }
    }

    @EventTarget
    public void onUpdate(EventUpdate LLLLL\u0445LL\u0445LL\u0445\u0445L) {
        String \u0445LLLL\u0445LL\u0445LL\u0445\u0445L = flyMode.getCurrentMode();
        if (\u0445LLLL\u0445LL\u0445LL\u0445\u0445L.equalsIgnoreCase("Matrix Glide")) {
            if (!Flight.mc.player.onGround && Flight.mc.player.fallDistance >= 1.0f) {
                Flight.mc.timer.timerSpeed = Flight.mc.player.ticksExisted % 4 == 0 ? 0.08f : 0.5f;
                Flight.mc.player.motionY *= 0.007;
                Flight.mc.player.fallDistance = 0.0f;
            } else {
                Flight.mc.timer.timerSpeed = 1.0f;
            }
        }
    }

    @EventTarget
    public void onPreMotion(EventPreMotion LL\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L) {
        Flight \u0445\u0445LL\u0445\u0445LL\u0445LL\u0445\u0445L;
        String \u0445L\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L = flyMode.getCurrentMode();
        \u0445\u0445LL\u0445\u0445LL\u0445LL\u0445\u0445L.setSuffix(flyMode.getCurrentMode());
        if (\u0445L\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L.equalsIgnoreCase("Matrix 6.3.0")) {
            double L\u0445L\u0445L\u0445LL\u0445LL\u0445\u0445L = 1.0E-12;
            Flight.mc.player.fallDistance = (float)L\u0445L\u0445L\u0445LL\u0445LL\u0445\u0445L;
            Flight.mc.player.motionY = 0.4;
            Flight.mc.player.onGround = false;
            double \u0445\u0445L\u0445L\u0445LL\u0445LL\u0445\u0445L = Math.toRadians(Flight.mc.player.rotationYaw);
            Flight.mc.player.motionX -= (double)(MathHelper.sin((float)\u0445\u0445L\u0445L\u0445LL\u0445LL\u0445\u0445L) * 0.35f);
            Flight.mc.player.motionZ += (double)(MathHelper.cos((float)\u0445\u0445L\u0445L\u0445LL\u0445LL\u0445\u0445L) * 0.35f);
            if (Flight.mc.gameSettings.keyBindSneak.isKeyDown()) {
                Flight.mc.player.motionY -= (double)speed.getNumberValue();
            } else if (Flight.mc.gameSettings.keyBindJump.isKeyDown()) {
                Flight.mc.player.motionY += (double)speed.getNumberValue();
            }
        } else if (\u0445L\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L.equals("MineLand")) {
            if (Flight.mc.gameSettings.keyBindForward.isKeyDown()) {
                float LL\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L = (float)Math.toRadians(Flight.mc.player.rotationYaw);
                double \u0445L\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L = (double)(-MathHelper.sin(LL\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L)) * 0.25;
                double L\u0445\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L = (double)MathHelper.cos(LL\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L) * 0.25;
                Flight.mc.player.connection.sendPacket(new CPacketPlayer.Position(Flight.mc.player.posX + \u0445L\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L, Flight.mc.player.posY, Flight.mc.player.posZ + L\u0445\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L, false));
                Flight.mc.player.connection.sendPacket(new CPacketPlayer.Position(Flight.mc.player.posX + \u0445L\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L, Flight.mc.player.posY - 490.0, Flight.mc.player.posZ + L\u0445\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L, true));
                Flight.mc.player.motionY = 0.0;
            }
        } else if (\u0445L\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L.equalsIgnoreCase("Wellmore")) {
            if (Flight.mc.player.onGround) {
                Flight.mc.player.jump();
            } else {
                Flight.mc.player.motionX = 0.0;
                Flight.mc.player.motionZ = 0.0;
                Flight.mc.player.motionY = -0.01;
                MovementHelper.setSpeed(speed.getNumberValue());
                Flight.mc.player.speedInAir = 0.3f;
                if (Flight.mc.gameSettings.keyBindSneak.isKeyDown()) {
                    Flight.mc.player.motionY -= (double)speed.getNumberValue();
                } else if (Flight.mc.gameSettings.keyBindJump.isKeyDown()) {
                    Flight.mc.player.motionY += (double)speed.getNumberValue();
                }
            }
        } else if (\u0445L\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L.equalsIgnoreCase("Matrix Boost 6.2.2")) {
            Flight.mc.player.motionY = 0.6;
            if (Flight.mc.gameSettings.keyBindForward.pressed && !Flight.mc.player.onGround) {
                double \u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L = Math.toRadians(Flight.mc.player.rotationYaw);
                Flight.mc.player.motionX -= (double)(MathHelper.sin((float)\u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L) * 0.27f);
                Flight.mc.player.motionZ += (double)(MathHelper.cos((float)\u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445\u0445L) * 0.27f);
            }
        } else if (\u0445L\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L.equalsIgnoreCase("Vanilla")) {
            Flight.mc.player.capabilities.isFlying = true;
            MovementHelper.setSpeed(speed.getNumberValue());
            if (Flight.mc.gameSettings.keyBindSneak.isKeyDown()) {
                Flight.mc.player.motionY -= (double)speed.getNumberValue();
            } else if (Flight.mc.gameSettings.keyBindJump.isKeyDown()) {
                Flight.mc.player.motionY += (double)speed.getNumberValue();
            }
        } else if (\u0445L\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L.equalsIgnoreCase("Matrix Web")) {
            if (Flight.mc.player.isInWeb) {
                Flight.mc.player.isInWeb = false;
                Flight.mc.player.motionY = Flight.mc.player.motionY * (Flight.mc.player.ticksExisted % 2 == 0 ? -100.0 : -0.05);
            }
        } else if (\u0445L\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L.equals("ReallyWorld Elytra")) {
            if (Flight.mc.gameSettings.keyBindJump.isKeyDown() && Flight.mc.player.ticksExisted % 4 == 0) {
                mc.getConnection().sendPacket(new CPacketEntityAction(Flight.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
                Flight.mc.player.jump();
                MovementHelper.setSpeed(0.55f);
                Flight.mc.player.capabilities.setFlySpeed(3.0f);
            }
        } else if (\u0445L\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L.equals("ReallyWorld New") && Flight.mc.player.ticksExisted % 8 == 0) {
            mc.getConnection().sendPacket(new CPacketEntityAction(Flight.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
            double LLLL\u0445\u0445LL\u0445LL\u0445\u0445L = 1.0E-12;
            double \u0445LLL\u0445\u0445LL\u0445LL\u0445\u0445L = 0.2;
            double L\u0445LL\u0445\u0445LL\u0445LL\u0445\u0445L = 0.225f;
            Flight.mc.player.fallDistance = (float)LLLL\u0445\u0445LL\u0445LL\u0445\u0445L;
            Flight.mc.player.motionY = 0.4;
            Flight.mc.player.onGround = false;
            if (Flight.mc.gameSettings.keyBindSneak.isKeyDown()) {
                Flight.mc.player.motionY -= \u0445LLL\u0445\u0445LL\u0445LL\u0445\u0445L;
            } else if (Flight.mc.gameSettings.keyBindJump.isKeyDown()) {
                Flight.mc.player.motionY += \u0445LLL\u0445\u0445LL\u0445LL\u0445\u0445L;
            }
        }
    }
}

