/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.ghost;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.GCDCalcHelper;
import org.Destroy.client.helpers.math.MathematicHelper;
import org.Destroy.client.helpers.math.RotationHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class AimAssist
extends Feature {
    public static NumberSetting range;
    public static BooleanSetting players;
    public static BooleanSetting mobs;
    public static BooleanSetting team;
    public static BooleanSetting walls;
    public static BooleanSetting invis;
    public static BooleanSetting click;
    public static NumberSetting fov;
    public static NumberSetting predict;
    public static NumberSetting rotYawSpeed;
    public static NumberSetting rotPitchSpeed;
    public static NumberSetting rotYawRandom;
    public static NumberSetting rotPitchRandom;
    public static ListSetting sort;
    public static ListSetting part;

    public AimAssist() {
        super("AimAssist", "Automatic aiming at players", Type.Combat);
        AimAssist \u0445L\u0445LLLLLL\u0445L;
        sort = new ListSetting("AssistSort Mode", "Distance", () -> true, "Distance", "Higher Armor", "Lowest Armor", "Health", "Angle", "HurtTime");
        part = new ListSetting("Aim-Part Mode", "Chest", () -> true, "Chest", "Head", "Leggings", "Boots");
        range = new NumberSetting("Range", 4.0f, 1.0f, 10.0f, 0.1f, () -> true);
        players = new BooleanSetting("Players", true, () -> true);
        mobs = new BooleanSetting("Mobs", false, () -> true);
        team = new BooleanSetting("Team Check", false, () -> true);
        walls = new BooleanSetting("Walls", false, () -> true);
        invis = new BooleanSetting("Invisible", false, () -> true);
        click = new BooleanSetting("Click Only", false, () -> true);
        predict = new NumberSetting("Aim Predict", 0.5f, 0.5f, 5.0f, 0.1f, () -> true);
        fov = new NumberSetting("Assist FOV", 180.0f, 5.0f, 180.0f, 5.0f, () -> true);
        rotYawSpeed = new NumberSetting("Rotation Yaw Speed", 1.0f, 0.1f, 5.0f, 0.1f, () -> true);
        rotPitchSpeed = new NumberSetting("Rotation Pitch Speed", 1.0f, 0.1f, 5.0f, 0.1f, () -> true);
        rotYawRandom = new NumberSetting("Yaw Randomize", 1.0f, 0.0f, 3.0f, 0.1f, () -> true);
        rotPitchRandom = new NumberSetting("Pitch Randomize", 1.0f, 0.0f, 3.0f, 0.1f, () -> true);
        \u0445L\u0445LLLLLL\u0445L.addSettings(range, players, mobs, walls, invis, team, click, predict, fov, rotYawSpeed, rotPitchSpeed, rotPitchRandom, rotYawRandom, sort, part);
    }

    public static double angleDifference(double LL\u0445\u0445\u0445LLLL\u0445L, double \u0445L\u0445\u0445\u0445LLLL\u0445L) {
        float L\u0445\u0445\u0445\u0445LLLL\u0445L = (float)(Math.abs(LL\u0445\u0445\u0445LLLL\u0445L - \u0445L\u0445\u0445\u0445LLLL\u0445L) % 360.0);
        if (L\u0445\u0445\u0445\u0445LLLL\u0445L > 180.0f) {
            L\u0445\u0445\u0445\u0445LLLL\u0445L = 360.0f - L\u0445\u0445\u0445\u0445LLLL\u0445L;
        }
        return L\u0445\u0445\u0445\u0445LLLL\u0445L;
    }

    public static EntityLivingBase getSortEntities() {
        ArrayList<EntityLivingBase> LLL\u0445L\u0445LLL\u0445L = new ArrayList<EntityLivingBase>();
        Iterator \u0445L\u0445\u0445L\u0445LLL\u0445L = AimAssist.mc.world.loadedEntityList.iterator();
        if (\u0445L\u0445\u0445L\u0445LLL\u0445L.hasNext()) {
            EntityLivingBase L\u0445\u0445LL\u0445LLL\u0445L;
            Entity \u0445\u0445\u0445LL\u0445LLL\u0445L = (Entity)\u0445L\u0445\u0445L\u0445LLL\u0445L.next();
            if (\u0445\u0445\u0445LL\u0445LLL\u0445L instanceof EntityLivingBase && AimAssist.mc.player.getDistanceToEntity(L\u0445\u0445LL\u0445LLL\u0445L = (EntityLivingBase)\u0445\u0445\u0445LL\u0445LLL\u0445L) < range.getNumberValue() && L\u0445\u0445LL\u0445LLL\u0445L != false) {
                if (L\u0445\u0445LL\u0445LLL\u0445L.getHealth() > 0.0f) {
                    LLL\u0445L\u0445LLL\u0445L.add(L\u0445\u0445LL\u0445LLL\u0445L);
                } else {
                    LLL\u0445L\u0445LLL\u0445L.remove(L\u0445\u0445LL\u0445LLL\u0445L);
                }
            }
            return null;
        }
        String L\u0445L\u0445L\u0445LLL\u0445L = sort.getOptions();
        if (L\u0445L\u0445L\u0445LLL\u0445L.equalsIgnoreCase("Angle")) {
            LLL\u0445L\u0445LLL\u0445L.sort((L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L, \u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L) -> (int)(Math.abs(RotationHelper.getAngleEntity(L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L) - AimAssist.mc.player.rotationYaw) - Math.abs(RotationHelper.getAngleEntity(\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L) - AimAssist.mc.player.rotationYaw)));
        } else if (L\u0445L\u0445L\u0445LLL\u0445L.equalsIgnoreCase("Higher Armor")) {
            LLL\u0445L\u0445LLL\u0445L.sort(Comparator.comparing(EntityLivingBase::getTotalArmorValue).reversed());
        } else if (L\u0445L\u0445L\u0445LLL\u0445L.equalsIgnoreCase("Lowest Armor")) {
            LLL\u0445L\u0445LLL\u0445L.sort(Comparator.comparing(EntityLivingBase::getTotalArmorValue));
        } else if (L\u0445L\u0445L\u0445LLL\u0445L.equalsIgnoreCase("Health")) {
            LLL\u0445L\u0445LLL\u0445L.sort((LLL\u0445\u0445\u0445\u0445LL\u0445L, \u0445LL\u0445\u0445\u0445\u0445LL\u0445L) -> (int)(LLL\u0445\u0445\u0445\u0445LL\u0445L.getHealth() - \u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getHealth()));
        } else if (L\u0445L\u0445L\u0445LLL\u0445L.equalsIgnoreCase("Distance")) {
            LLL\u0445L\u0445LLL\u0445L.sort(Comparator.comparingDouble(AimAssist.mc.player::getDistanceToEntity));
        } else if (L\u0445L\u0445L\u0445LLL\u0445L.equalsIgnoreCase("HurtTime")) {
            LLL\u0445L\u0445LLL\u0445L.sort(Comparator.comparing(EntityLivingBase::getHurtTime).reversed());
        }
        if (LLL\u0445L\u0445LLL\u0445L.isEmpty()) {
            return null;
        }
        return (EntityLivingBase)LLL\u0445L\u0445LLL\u0445L.get(0);
    }

    @EventTarget
    public void onPreMotion(EventPreMotion L\u0445\u0445LLL\u0445LL\u0445L) {
        EntityLivingBase \u0445\u0445\u0445LLL\u0445LL\u0445L = AimAssist.getSortEntities();
        if (\u0445\u0445\u0445LLL\u0445LL\u0445L != null && AimAssist.mc.player.getDistanceToEntity(\u0445\u0445\u0445LLL\u0445LL\u0445L) <= range.getNumberValue() && \u0445\u0445\u0445LLL\u0445LL\u0445L != AimAssist.mc.player) {
            AimAssist \u0445L\u0445LLL\u0445LL\u0445L;
            float[] LL\u0445LLL\u0445LL\u0445L = \u0445L\u0445LLL\u0445LL\u0445L.getRotationsForAssist(\u0445\u0445\u0445LLL\u0445LL\u0445L);
            if (click.getBoolValue() && !AimAssist.mc.gameSettings.keyBindAttack.isKeyDown()) {
                return;
            }
            if (\u0445\u0445\u0445LLL\u0445LL\u0445L != false && \u0445\u0445\u0445LLL\u0445LL\u0445L.getHealth() > 0.0f) {
                AimAssist.mc.player.rotationYaw = LL\u0445LLL\u0445LL\u0445L[0];
                AimAssist.mc.player.rotationPitch = LL\u0445LLL\u0445LL\u0445L[1];
            }
        }
    }

    private float[] getRotationsForAssist(EntityLivingBase LLLL\u0445L\u0445LL\u0445L) {
        AimAssist \u0445\u0445\u0445\u0445LL\u0445LL\u0445L;
        float \u0445LLL\u0445L\u0445LL\u0445L = RotationHelper.updateRotation(GCDCalcHelper.getFixedRotation(AimAssist.mc.player.rotationYaw + MathematicHelper.randomizeFloat(-rotYawRandom.getNumberValue(), rotYawRandom.getNumberValue())), \u0445\u0445\u0445\u0445LL\u0445LL\u0445L.getRotation(LLLL\u0445L\u0445LL\u0445L, predict.getNumberValue())[0], rotYawSpeed.getNumberValue() * 10.0f);
        float L\u0445LL\u0445L\u0445LL\u0445L = RotationHelper.updateRotation(GCDCalcHelper.getFixedRotation(AimAssist.mc.player.rotationPitch + MathematicHelper.randomizeFloat(-rotPitchRandom.getNumberValue(), rotPitchRandom.getNumberValue())), \u0445\u0445\u0445\u0445LL\u0445LL\u0445L.getRotation(LLLL\u0445L\u0445LL\u0445L, predict.getNumberValue())[1], rotPitchSpeed.getNumberValue() * 10.0f);
        return new float[]{\u0445LLL\u0445L\u0445LL\u0445L, L\u0445LL\u0445L\u0445LL\u0445L};
    }

    private float[] getRotation(Entity L\u0445LLL\u0445\u0445LL\u0445L, float \u0445\u0445LLL\u0445\u0445LL\u0445L) {
        String LL\u0445LL\u0445\u0445LL\u0445L = part.getOptions();
        float \u0445L\u0445LL\u0445\u0445LL\u0445L = 0.0f;
        if (LL\u0445LL\u0445\u0445LL\u0445L.equalsIgnoreCase("Head")) {
            \u0445L\u0445LL\u0445\u0445LL\u0445L = 0.0f;
        } else if (LL\u0445LL\u0445\u0445LL\u0445L.equalsIgnoreCase("Chest")) {
            \u0445L\u0445LL\u0445\u0445LL\u0445L = 0.5f;
        } else if (LL\u0445LL\u0445\u0445LL\u0445L.equalsIgnoreCase("Leggings")) {
            \u0445L\u0445LL\u0445\u0445LL\u0445L = 0.9f;
        } else if (LL\u0445LL\u0445\u0445LL\u0445L.equalsIgnoreCase("Boots")) {
            \u0445L\u0445LL\u0445\u0445LL\u0445L = 1.3f;
        }
        double L\u0445\u0445LL\u0445\u0445LL\u0445L = L\u0445LLL\u0445\u0445LL\u0445L.posX + (L\u0445LLL\u0445\u0445LL\u0445L.posX - L\u0445LLL\u0445\u0445LL\u0445L.prevPosX) * (double)\u0445\u0445LLL\u0445\u0445LL\u0445L - AimAssist.mc.player.posX - AimAssist.mc.player.motionX * (double)\u0445\u0445LLL\u0445\u0445LL\u0445L;
        double \u0445\u0445\u0445LL\u0445\u0445LL\u0445L = L\u0445LLL\u0445\u0445LL\u0445L.posZ + (L\u0445LLL\u0445\u0445LL\u0445L.posZ - L\u0445LLL\u0445\u0445LL\u0445L.prevPosZ) * (double)\u0445\u0445LLL\u0445\u0445LL\u0445L - AimAssist.mc.player.posZ - AimAssist.mc.player.motionZ * (double)\u0445\u0445LLL\u0445\u0445LL\u0445L;
        double LLL\u0445L\u0445\u0445LL\u0445L = L\u0445LLL\u0445\u0445LL\u0445L.posY + (double)L\u0445LLL\u0445\u0445LL\u0445L.getEyeHeight() - (AimAssist.mc.player.posY + (double)AimAssist.mc.player.getEyeHeight() + (double)\u0445L\u0445LL\u0445\u0445LL\u0445L);
        double \u0445LL\u0445L\u0445\u0445LL\u0445L = MathHelper.sqrt(L\u0445\u0445LL\u0445\u0445LL\u0445L * L\u0445\u0445LL\u0445\u0445LL\u0445L + \u0445\u0445\u0445LL\u0445\u0445LL\u0445L * \u0445\u0445\u0445LL\u0445\u0445LL\u0445L);
        float L\u0445L\u0445L\u0445\u0445LL\u0445L = (float)(MathHelper.atan2(\u0445\u0445\u0445LL\u0445\u0445LL\u0445L, L\u0445\u0445LL\u0445\u0445LL\u0445L) * 180.0 / Math.PI - 90.0) + MathematicHelper.randomizeFloat(-rotYawRandom.getNumberValue(), rotYawRandom.getNumberValue());
        float \u0445\u0445L\u0445L\u0445\u0445LL\u0445L = (float)(-(MathHelper.atan2(LLL\u0445L\u0445\u0445LL\u0445L, \u0445LL\u0445L\u0445\u0445LL\u0445L) * 180.0 / Math.PI)) + MathematicHelper.randomizeFloat(-rotPitchRandom.getNumberValue(), rotPitchRandom.getNumberValue());
        L\u0445L\u0445L\u0445\u0445LL\u0445L = AimAssist.mc.player.rotationYaw + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees(L\u0445L\u0445L\u0445\u0445LL\u0445L - AimAssist.mc.player.rotationYaw));
        \u0445\u0445L\u0445L\u0445\u0445LL\u0445L = AimAssist.mc.player.rotationPitch + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees(\u0445\u0445L\u0445L\u0445\u0445LL\u0445L - AimAssist.mc.player.rotationPitch));
        \u0445\u0445L\u0445L\u0445\u0445LL\u0445L = MathHelper.clamp(\u0445\u0445L\u0445L\u0445\u0445LL\u0445L, -90.0f, 90.0f);
        return new float[]{L\u0445L\u0445L\u0445\u0445LL\u0445L, \u0445\u0445L\u0445L\u0445\u0445LL\u0445L};
    }
}

