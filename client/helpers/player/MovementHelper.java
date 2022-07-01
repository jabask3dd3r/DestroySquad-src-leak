/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.player;

import net.minecraft.client.Minecraft;
import net.minecraft.init.MobEffects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import org.Destroy.client.event.events.impl.motion.EventMove;
import org.Destroy.client.event.events.impl.motion.EventStrafe;
import org.Destroy.client.helpers.Helper;

public class MovementHelper
implements Helper {
    public MovementHelper() {
        MovementHelper L\u0445\u0445L\u0445\u0445LLLL\u0445LL\u0445L;
    }

    public static boolean isMoving() {
        return MovementHelper.mc.player.movementInput.moveForward != 0.0f || MovementHelper.mc.player.movementInput.moveStrafe != 0.0f;
    }

    public static float getBaseMoveSpeed() {
        float \u0445\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445L = 0.2873f;
        if (MovementHelper.mc.player != null && MovementHelper.mc.player.isPotionActive(MobEffects.SPEED)) {
            int L\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445L = MovementHelper.mc.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
            \u0445\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445L = (float)((double)\u0445\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445L * (1.0 + 0.2 * (double)(L\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445L + 1)));
        }
        return \u0445\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445L;
    }

    public static int getSpeedEffect() {
        if (MovementHelper.mc.player.isPotionActive(MobEffects.SPEED)) {
            return MovementHelper.mc.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier() + 1;
        }
        return 0;
    }

    public static float getMoveDirection() {
        Minecraft \u0445LLLLL\u0445LLL\u0445LL\u0445L = Minecraft.getInstance();
        float L\u0445LLLL\u0445LLL\u0445LL\u0445L = Minecraft.getInstance().player.rotationYaw;
        if (Minecraft.getInstance().player.moveForward < 0.0f) {
            L\u0445LLLL\u0445LLL\u0445LL\u0445L += 180.0f;
        }
        float \u0445\u0445LLLL\u0445LLL\u0445LL\u0445L = 1.0f;
        if (Minecraft.getInstance().player.moveForward < 0.0f) {
            \u0445\u0445LLLL\u0445LLL\u0445LL\u0445L = -0.5f;
        } else if (Minecraft.getInstance().player.moveForward > 0.0f) {
            \u0445\u0445LLLL\u0445LLL\u0445LL\u0445L = 0.5f;
        }
        if (Minecraft.getInstance().player.moveStrafing > 0.0f) {
            L\u0445LLLL\u0445LLL\u0445LL\u0445L -= 90.0f * \u0445\u0445LLLL\u0445LLL\u0445LL\u0445L;
        }
        if (Minecraft.getInstance().player.moveStrafing < 0.0f) {
            L\u0445LLLL\u0445LLL\u0445LL\u0445L += 90.0f * \u0445\u0445LLLL\u0445LLL\u0445LL\u0445L;
        }
        return L\u0445LLLL\u0445LLL\u0445LL\u0445L *= (float)Math.PI / 180;
    }

    public static boolean isBlockAboveHead() {
        AxisAlignedBB LLL\u0445LL\u0445LLL\u0445LL\u0445L = new AxisAlignedBB(MovementHelper.mc.player.posX - 0.3, MovementHelper.mc.player.posY + (double)MovementHelper.mc.player.getEyeHeight(), MovementHelper.mc.player.posZ + 0.3, MovementHelper.mc.player.posX + 0.3, MovementHelper.mc.player.posY + (!MovementHelper.mc.player.onGround ? 1.5 : 2.5), MovementHelper.mc.player.posZ - 0.3);
        return MovementHelper.mc.world.getCollisionBoxes(MovementHelper.mc.player, LLL\u0445LL\u0445LLL\u0445LL\u0445L).isEmpty();
    }

    public static void calculateSilentMove(EventStrafe \u0445\u0445\u0445L\u0445L\u0445LLL\u0445LL\u0445L, float LLL\u0445\u0445L\u0445LLL\u0445LL\u0445L) {
        float \u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L;
        float \u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L = \u0445\u0445\u0445L\u0445L\u0445LLL\u0445LL\u0445L.getStrafe();
        float L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L = \u0445\u0445\u0445L\u0445L\u0445LLL\u0445LL\u0445L.getForward();
        float \u0445\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L = \u0445\u0445\u0445L\u0445L\u0445LLL\u0445LL\u0445L.getFriction();
        int LL\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = (int)((MathHelper.wrapDegrees(MovementHelper.mc.player.rotationYaw - LLL\u0445\u0445L\u0445LLL\u0445LL\u0445L - 23.5f - 135.0f) + 180.0f) / 45.0f);
        float \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = 0.0f;
        float L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = 0.0f;
        switch (LL\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L) {
            case 0: {
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = \u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                break;
            }
            case 1: {
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L += L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L -= L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L += \u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L += \u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                break;
            }
            case 2: {
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = \u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = -L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                break;
            }
            case 3: {
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L -= L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L -= L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L += \u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L -= \u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                break;
            }
            case 4: {
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = -L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = -\u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                break;
            }
            case 5: {
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L -= L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L += L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L -= \u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L -= \u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                break;
            }
            case 6: {
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = -\u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                break;
            }
            case 7: {
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L += L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L += L\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L -= \u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L += \u0445LL\u0445\u0445L\u0445LLL\u0445LL\u0445L;
            }
        }
        if (\u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L > 1.0f || \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L < 0.9f && \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L > 0.3f || \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L < -1.0f || \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L > -0.9f && \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L < -0.3f) {
            \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L *= 0.5f;
        }
        if (L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L > 1.0f || L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L < 0.9f && L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L > 0.3f || L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L < -1.0f || L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L > -0.9f && L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L < -0.3f) {
            L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L *= 0.5f;
        }
        if ((\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L * L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L + \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L * \u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L) >= 1.0E-4f) {
            \u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L = (float)((double)\u0445\u0445L\u0445\u0445L\u0445LLL\u0445LL\u0445L / Math.max(1.0, Math.sqrt(\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L)));
            float \u0445L\u0445L\u0445L\u0445LLL\u0445LL\u0445L = MathHelper.sin((float)((double)LLL\u0445\u0445L\u0445LLL\u0445LL\u0445L * Math.PI / 180.0));
            float L\u0445\u0445L\u0445L\u0445LLL\u0445LL\u0445L = MathHelper.cos((float)((double)LLL\u0445\u0445L\u0445LLL\u0445LL\u0445L * Math.PI / 180.0));
            MovementHelper.mc.player.motionX += (double)((L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L *= \u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L) * L\u0445\u0445L\u0445L\u0445LLL\u0445LL\u0445L - (\u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L *= \u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L) * \u0445L\u0445L\u0445L\u0445LLL\u0445LL\u0445L);
            MovementHelper.mc.player.motionZ += (double)(\u0445L\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L * L\u0445\u0445L\u0445L\u0445LLL\u0445LL\u0445L + L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445L * \u0445L\u0445L\u0445L\u0445LLL\u0445LL\u0445L);
        }
    }

    public static void setEventSpeed(EventMove LLLL\u0445\u0445\u0445LLL\u0445LL\u0445L, double \u0445LLL\u0445\u0445\u0445LLL\u0445LL\u0445L) {
        double L\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L = MovementHelper.mc.player.movementInput.moveForward;
        double \u0445\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L = MovementHelper.mc.player.movementInput.moveStrafe;
        float LL\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445L = MovementHelper.mc.player.rotationYaw;
        if (L\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L == 0.0 && \u0445\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L == 0.0) {
            LLLL\u0445\u0445\u0445LLL\u0445LL\u0445L.setX(0.0);
            LLLL\u0445\u0445\u0445LLL\u0445LL\u0445L.setZ(0.0);
        } else {
            if (L\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L != 0.0) {
                if (\u0445\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L > 0.0) {
                    LL\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445L += (float)(L\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L > 0.0 ? -45 : 45);
                } else if (\u0445\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L < 0.0) {
                    LL\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445L += (float)(L\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L > 0.0 ? 45 : -45);
                }
                \u0445\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L = 0.0;
                if (L\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L > 0.0) {
                    L\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L = 1.0;
                } else if (L\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L < 0.0) {
                    L\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L = -1.0;
                }
            }
            LLLL\u0445\u0445\u0445LLL\u0445LL\u0445L.setX(L\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L * \u0445LLL\u0445\u0445\u0445LLL\u0445LL\u0445L * Math.cos(Math.toRadians(LL\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445L + 90.0f)) + \u0445\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L * \u0445LLL\u0445\u0445\u0445LLL\u0445LL\u0445L * Math.sin(Math.toRadians(LL\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445L + 90.0f)));
            LLLL\u0445\u0445\u0445LLL\u0445LL\u0445L.setZ(L\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L * \u0445LLL\u0445\u0445\u0445LLL\u0445LL\u0445L * Math.sin(Math.toRadians(LL\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445L + 90.0f)) - \u0445\u0445LL\u0445\u0445\u0445LLL\u0445LL\u0445L * \u0445LLL\u0445\u0445\u0445LLL\u0445LL\u0445L * Math.cos(Math.toRadians(LL\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445L + 90.0f)));
        }
    }

    public static float getSpeed() {
        return (float)Math.sqrt(MovementHelper.mc.player.motionX * MovementHelper.mc.player.motionX + MovementHelper.mc.player.motionZ * MovementHelper.mc.player.motionZ);
    }

    public static void setSpeed(float L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L) {
        float \u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L = MovementHelper.mc.player.rotationYaw;
        float LLLLLLL\u0445LL\u0445LL\u0445L = MovementHelper.mc.player.movementInput.moveForward;
        float \u0445LLLLLL\u0445LL\u0445LL\u0445L = MovementHelper.mc.player.movementInput.moveStrafe;
        if (LLLLLLL\u0445LL\u0445LL\u0445L != 0.0f) {
            if (\u0445LLLLLL\u0445LL\u0445LL\u0445L > 0.0f) {
                \u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L += (float)(LLLLLLL\u0445LL\u0445LL\u0445L > 0.0f ? -45 : 45);
            } else if (\u0445LLLLLL\u0445LL\u0445LL\u0445L < 0.0f) {
                \u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L += (float)(LLLLLLL\u0445LL\u0445LL\u0445L > 0.0f ? 45 : -45);
            }
            \u0445LLLLLL\u0445LL\u0445LL\u0445L = 0.0f;
            if (LLLLLLL\u0445LL\u0445LL\u0445L > 0.0f) {
                LLLLLLL\u0445LL\u0445LL\u0445L = 1.0f;
            } else if (LLLLLLL\u0445LL\u0445LL\u0445L < 0.0f) {
                LLLLLLL\u0445LL\u0445LL\u0445L = -1.0f;
            }
        }
        MovementHelper.mc.player.motionX = (double)(LLLLLLL\u0445LL\u0445LL\u0445L * L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L) * Math.cos(Math.toRadians(\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L + 90.0f)) + (double)(\u0445LLLLLL\u0445LL\u0445LL\u0445L * L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L) * Math.sin(Math.toRadians(\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L + 90.0f));
        MovementHelper.mc.player.motionZ = (double)(LLLLLLL\u0445LL\u0445LL\u0445L * L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L) * Math.sin(Math.toRadians(\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L + 90.0f)) - (double)(\u0445LLLLLL\u0445LL\u0445LL\u0445L * L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L) * Math.cos(Math.toRadians(\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445L + 90.0f));
    }

    public static double getDirectionAll() {
        float LLL\u0445LLL\u0445LL\u0445LL\u0445L = MovementHelper.mc.player.rotationYaw;
        float \u0445LL\u0445LLL\u0445LL\u0445LL\u0445L = 1.0f;
        if (MovementHelper.mc.player.moveForward < 0.0f) {
            LLL\u0445LLL\u0445LL\u0445LL\u0445L += 180.0f;
        }
        if (MovementHelper.mc.player.moveForward < 0.0f) {
            \u0445LL\u0445LLL\u0445LL\u0445LL\u0445L = -0.5f;
        } else if (MovementHelper.mc.player.moveForward > 0.0f) {
            \u0445LL\u0445LLL\u0445LL\u0445LL\u0445L = 0.5f;
        }
        if (MovementHelper.mc.player.moveStrafing > 0.0f) {
            LLL\u0445LLL\u0445LL\u0445LL\u0445L -= 90.0f * \u0445LL\u0445LLL\u0445LL\u0445LL\u0445L;
        }
        if (MovementHelper.mc.player.moveStrafing < 0.0f) {
            LLL\u0445LLL\u0445LL\u0445LL\u0445L += 90.0f * \u0445LL\u0445LLL\u0445LL\u0445LL\u0445L;
        }
        return Math.toRadians(LLL\u0445LLL\u0445LL\u0445LL\u0445L);
    }

    public static void strafePlayer(float \u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL\u0445L) {
        double LLLL\u0445LL\u0445LL\u0445LL\u0445L = MovementHelper.getDirectionAll();
        float \u0445LLL\u0445LL\u0445LL\u0445LL\u0445L = \u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL\u0445L == 0.0f ? MovementHelper.getSpeed() : \u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL\u0445L;
        MovementHelper.mc.player.motionX = -Math.sin(LLLL\u0445LL\u0445LL\u0445LL\u0445L) * (double)\u0445LLL\u0445LL\u0445LL\u0445LL\u0445L;
        MovementHelper.mc.player.motionZ = Math.cos(LLLL\u0445LL\u0445LL\u0445LL\u0445L) * (double)\u0445LLL\u0445LL\u0445LL\u0445LL\u0445L;
    }

    public static void strafe() {
        if (MovementHelper.mc.gameSettings.keyBindBack.isKeyDown()) {
            return;
        }
    }
}

