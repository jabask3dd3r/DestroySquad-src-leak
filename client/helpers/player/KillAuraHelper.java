/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.impl.combat.KillAura;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.math.RotationHelper;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;

public class KillAuraHelper
implements Helper {
    public KillAuraHelper() {
        KillAuraHelper LL\u0445L\u0445LLL\u0445LLL\u0445L;
    }

    public static double angleDifference(float \u0445\u0445LL\u0445\u0445LL\u0445LLL\u0445L, float LL\u0445L\u0445\u0445LL\u0445LLL\u0445L) {
        float \u0445L\u0445L\u0445\u0445LL\u0445LLL\u0445L = Math.abs(\u0445\u0445LL\u0445\u0445LL\u0445LLL\u0445L - LL\u0445L\u0445\u0445LL\u0445LLL\u0445L) % 360.0f;
        if (\u0445L\u0445L\u0445\u0445LL\u0445LLL\u0445L > 180.0f) {
            \u0445L\u0445L\u0445\u0445LL\u0445LLL\u0445L = 360.0f - \u0445L\u0445L\u0445\u0445LL\u0445LLL\u0445L;
        }
        return \u0445L\u0445L\u0445\u0445LL\u0445LLL\u0445L;
    }

    public static void toggleOffChecks() {
        KillAura LLLLLL\u0445L\u0445LLL\u0445L = (KillAura)Destroy.instance.featureManager.getFeatureByClass(KillAura.class);
        if (KillAuraHelper.mc.currentScreen instanceof GuiGameOver && !KillAuraHelper.mc.player.isEntityAlive() || KillAuraHelper.mc.player.ticksExisted <= 1 && KillAura.autoDisable.getBoolValue()) {
            LLLLLL\u0445L\u0445LLL\u0445L.toggle();
            NotificationManager.publicity(LLLLLL\u0445L\u0445LLL\u0445L.getLabel(), "KillAura was toggled off!", 2, NotificationType.SUCCESS);
        }
    }

    public static EntityLivingBase getSortEntities() {
        ArrayList<EntityLivingBase> LLL\u0445LL\u0445L\u0445LLL\u0445L = new ArrayList<EntityLivingBase>();
        Iterator \u0445\u0445L\u0445LL\u0445L\u0445LLL\u0445L = KillAuraHelper.mc.world.loadedEntityList.iterator();
        if (\u0445\u0445L\u0445LL\u0445L\u0445LLL\u0445L.hasNext()) {
            EntityLivingBase L\u0445\u0445LLL\u0445L\u0445LLL\u0445L;
            Entity \u0445\u0445\u0445LLL\u0445L\u0445LLL\u0445L = (Entity)\u0445\u0445L\u0445LL\u0445L\u0445LLL\u0445L.next();
            if (\u0445\u0445\u0445LLL\u0445L\u0445LLL\u0445L instanceof EntityLivingBase && KillAuraHelper.mc.player.getDistanceToEntity(L\u0445\u0445LLL\u0445L\u0445LLL\u0445L = (EntityLivingBase)\u0445\u0445\u0445LLL\u0445L\u0445LLL\u0445L) < KillAura.range.getNumberValue() && L\u0445\u0445LLL\u0445L\u0445LLL\u0445L != false) {
                if (L\u0445\u0445LLL\u0445L\u0445LLL\u0445L.getHealth() > 0.0f) {
                    LLL\u0445LL\u0445L\u0445LLL\u0445L.add(L\u0445\u0445LLL\u0445L\u0445LLL\u0445L);
                } else {
                    LLL\u0445LL\u0445L\u0445LLL\u0445L.remove(L\u0445\u0445LLL\u0445L\u0445LLL\u0445L);
                }
            }
            return null;
        }
        String \u0445LL\u0445LL\u0445L\u0445LLL\u0445L = KillAura.sort.getOptions();
        if (\u0445LL\u0445LL\u0445L\u0445LLL\u0445L.equalsIgnoreCase("Angle")) {
            LLL\u0445LL\u0445L\u0445LLL\u0445L.sort((L\u0445\u0445L\u0445L\u0445L\u0445LLL\u0445L, \u0445\u0445\u0445L\u0445L\u0445L\u0445LLL\u0445L) -> (int)(Math.abs(RotationHelper.getAngleEntity(L\u0445\u0445L\u0445L\u0445L\u0445LLL\u0445L) - KillAuraHelper.mc.player.rotationYaw) - Math.abs(RotationHelper.getAngleEntity(\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL\u0445L) - KillAuraHelper.mc.player.rotationYaw)));
        } else if (\u0445LL\u0445LL\u0445L\u0445LLL\u0445L.equalsIgnoreCase("Higher Armor")) {
            LLL\u0445LL\u0445L\u0445LLL\u0445L.sort(Comparator.comparing(EntityLivingBase::getTotalArmorValue).reversed());
        } else if (\u0445LL\u0445LL\u0445L\u0445LLL\u0445L.equalsIgnoreCase("Lowest Armor")) {
            LLL\u0445LL\u0445L\u0445LLL\u0445L.sort(Comparator.comparing(EntityLivingBase::getTotalArmorValue));
        } else if (\u0445LL\u0445LL\u0445L\u0445LLL\u0445L.equalsIgnoreCase("Health")) {
            LLL\u0445LL\u0445L\u0445LLL\u0445L.sort((LLLL\u0445L\u0445L\u0445LLL\u0445L, \u0445LLL\u0445L\u0445L\u0445LLL\u0445L) -> (int)(LLLL\u0445L\u0445L\u0445LLL\u0445L.getHealth() - \u0445LLL\u0445L\u0445L\u0445LLL\u0445L.getHealth()));
        } else if (\u0445LL\u0445LL\u0445L\u0445LLL\u0445L.equalsIgnoreCase("Distance")) {
            LLL\u0445LL\u0445L\u0445LLL\u0445L.sort(Comparator.comparingDouble(KillAuraHelper.mc.player::getDistanceToEntity));
        } else if (\u0445LL\u0445LL\u0445L\u0445LLL\u0445L.equalsIgnoreCase("HurtTime")) {
            LLL\u0445LL\u0445L\u0445LLL\u0445L.sort(Comparator.comparing(EntityLivingBase::getHurtTime).reversed());
        } else if (\u0445LL\u0445LL\u0445L\u0445LLL\u0445L.equalsIgnoreCase("Blocking Status") && KillAura.target != null) {
            LLL\u0445LL\u0445L\u0445LLL\u0445L.sort(KillAura.target.isBlocking() ? Comparator.comparing(EntityLivingBase::isBlocking) : Comparator.comparingDouble(KillAuraHelper.mc.player::getDistanceToEntity));
        }
        if (LLL\u0445LL\u0445L\u0445LLL\u0445L.isEmpty()) {
            return null;
        }
        return (EntityLivingBase)LLL\u0445LL\u0445L\u0445LLL\u0445L.get(0);
    }
}

