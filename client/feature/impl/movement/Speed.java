/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.MoverType;
import net.minecraft.util.math.MathHelper;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.game.EventTick;
import org.Destroy.client.event.events.impl.motion.EventMove;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;

public class Speed
extends Feature {
    public static int stage;
    private final TimerHelper pulseTimer = new TimerHelper();
    public TimerHelper timerHelper = new TimerHelper();
    public double moveSpeed;
    public ListSetting speedMode = new ListSetting("Speed Mode", "MatrixOld", () -> true, "SunRise", "MatrixOld", "StormHVH");
    public BooleanSetting autoHitDisable;
    private int boostTick;
    private boolean disableLogger;
    private float ticks = 35.0f;

    public Speed() {
        super("Speed", "Increases your speed", Type.Movement);
        Speed \u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
        \u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.addSettings(\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.speedMode);
    }

    @EventTarget
    public void onMove(EventMove L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) {
        Speed \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
        if (\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.speedMode.currentMode.equals("StormHVH") && MovementHelper.isMoving() && !Speed.mc.player.isInLiquid()) {
            if (Speed.mc.player.onGround && !Speed.mc.gameSettings.keyBindJump.isKeyDown() && Speed.mc.player.jumpTicks == 0) {
                Speed.mc.timer.timerSpeed = 1.09f;
                Speed.mc.player.motionY = 0.1;
                L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.setY(0.1);
                Speed.mc.player.jumpTicks = 10;
            } else if (L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.getY() < 0.0) {
                Speed.mc.timer.timerSpeed = 1.04f;
            }
            float \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Speed.mc.player.isSprinting() ? 0.97f : 1.0f;
            double LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Math.max(MovementHelper.getBaseMoveSpeed(), MovementHelper.getSpeed()) * \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
            MovementHelper.setEventSpeed(L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L, LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L);
        }
    }

    @EventTarget
    public void onTick(EventTick LLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) {
        Speed \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
        if (\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.getState()) {
            String L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.speedMode.getOptions();
            \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.setSuffix(L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L);
            if (\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.speedMode.currentMode.equals("MatrixOld")) {
                if (Speed.mc.gameSettings.keyBindForward.isKeyDown()) {
                    if (Speed.mc.player.onGround) {
                        Speed.mc.player.jump();
                    } else if (Speed.mc.player.fallDistance > 0.6f && Speed.mc.player.ticksExisted % 2 == 0) {
                        Speed.mc.timer.timerSpeed = 1.1f;
                    }
                }
            } else if (L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.equalsIgnoreCase("SunRise") && Speed.mc.player.onGround && Speed.mc.player.isSprinting()) {
                float \u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Speed.mc.player.rotationYaw * ((float)Math.PI / 180);
                Speed.mc.player.moveEntity(MoverType.PLAYER, Speed.mc.player.motionX -= (double)MathHelper.sin(\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) * 0.032, 0.0, Speed.mc.player.motionZ += (double)MathHelper.cos(\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) * 0.032);
            }
            if (L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.equalsIgnoreCase("Matrix")) {
                Speed.mc.gameSettings.keyBindJump.pressed = false;
                if (Speed.mc.player.isInWeb || Speed.mc.player.isOnLadder() || Speed.mc.player.isInLiquid()) {
                    return;
                }
                Speed.mc.player.jumpMovementFactor *= 1.04f;
                double L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Speed.mc.player.posX;
                double \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Speed.mc.player.posY;
                double LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Speed.mc.player.posZ;
                double \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = (double)Speed.mc.player.rotationYaw * 0.017453292;
                if (Speed.mc.player.onGround) {
                    Speed.mc.timer.timerSpeed = 1.3f;
                    \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks = 11.0f;
                    MovementHelper.strafe();
                    Speed.mc.player.jump();
                } else if (\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks < 11.0f) {
                    \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks += 1.0f;
                } else {
                    if (\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.timerHelper.hasReached(260.0f)) {
                        Minecraft.getInstance().player.onGround = false;
                        Minecraft.getInstance().player.motionX *= 1.7000000000000002;
                        Minecraft.getInstance().player.motionZ *= 1.7000000000000002;
                        Minecraft.getInstance().player.setPosition(L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L - Math.sin(\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) * 0.003, \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L, LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L + Math.cos(\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) * 0.003);
                        \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.timerHelper.reset();
                    }
                    \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks = 0.0f;
                }
            } else if (L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.equalsIgnoreCase("Matrix New")) {
                if (Speed.mc.player.isInWeb || Speed.mc.player.isOnLadder() || Speed.mc.player.isInLiquid()) {
                    return;
                }
                double L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Speed.mc.player.posX;
                double \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Speed.mc.player.posY;
                double LLLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Speed.mc.player.posZ;
                double \u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = (double)Speed.mc.player.rotationYaw * 0.017453292;
                if (Speed.mc.player.onGround) {
                    Speed.mc.player.jump();
                    Speed.mc.timer.timerSpeed = 1.3f;
                    \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks = 11.0f;
                } else if (\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks < 11.0f) {
                    \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks += 1.0f;
                }
                if (Speed.mc.player.motionY == -0.4448259643949201) {
                    Speed.mc.player.motionX *= 2.0;
                    Speed.mc.player.motionZ *= 2.0;
                    Minecraft.getInstance().player.setPosition(L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L - Math.sin(\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) * 0.003, \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L, LLLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L + Math.cos(\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) * 0.003);
                }
                \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks = 0.0f;
            } else if (L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.equalsIgnoreCase("Matrix Long")) {
                if (Speed.mc.player.isInWeb || Speed.mc.player.isOnLadder() || Speed.mc.player.isInLiquid()) {
                    return;
                }
                double L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Speed.mc.player.posX;
                double \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Speed.mc.player.posY;
                double LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = Speed.mc.player.posZ;
                double \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = (double)Speed.mc.player.rotationYaw * 0.017453292;
                if (Speed.mc.player.onGround) {
                    \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks = 11.0f;
                } else if (\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks < 11.0f) {
                    \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks += 1.0f;
                }
                if (Speed.mc.player.motionY == -0.4448259643949201) {
                    Speed.mc.player.motionX *= (double)1.8f;
                    Speed.mc.player.motionZ *= (double)1.8f;
                    Minecraft.getInstance().player.setPosition(L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L - Math.sin(\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) * 0.003, \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L, LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L + Math.cos(\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) * 0.003);
                }
                \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.ticks = 0.0f;
            } else if (L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.equalsIgnoreCase("NexusGrief") && MovementHelper.isMoving() && Speed.mc.player.hurtTime > 0) {
                MovementHelper.strafe();
                if (Speed.mc.player.onGround) {
                    Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getMoveDirection()) * 6.8 / 24.5, 0.0, Math.cos(MovementHelper.getMoveDirection()) * 6.8 / 24.5);
                    MovementHelper.strafe();
                } else if (Speed.mc.player.isInWater()) {
                    Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getMoveDirection()) * 7.5 / 24.5, 0.0, Math.cos(MovementHelper.getMoveDirection()) * 7.5 / 24.5);
                    MovementHelper.strafe();
                } else if (!Speed.mc.player.onGround) {
                    Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getMoveDirection()) * 0.11 / 24.5, 0.0, Math.cos(MovementHelper.getMoveDirection()) * 0.11 / 24.5);
                    MovementHelper.strafe();
                } else {
                    Speed.mc.player.addVelocity(-Math.sin(MovementHelper.getMoveDirection()) * 0.005 * (double)MovementHelper.getSpeed(), 0.0, Math.cos(MovementHelper.getMoveDirection()) * 0.005 * (double)MovementHelper.getSpeed());
                    MovementHelper.strafe();
                }
            }
        }
    }
}

