/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.ghost;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.EnumHand;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class TriggerBot
extends Feature {
    public static NumberSetting range;
    public static BooleanSetting players;
    public static BooleanSetting mobs;
    public static BooleanSetting team;
    public static BooleanSetting onlyCrit;
    public static NumberSetting critFallDist;

    public TriggerBot() {
        super("TriggerBot", "\nAutomatically strikes when targeting an entity", Type.Combat);
        TriggerBot \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445LLL;
        players = new BooleanSetting("Players", true, () -> true);
        mobs = new BooleanSetting("Mobs", false, () -> true);
        team = new BooleanSetting("Team Check", false, () -> true);
        range = new NumberSetting("Trigger Range", 4.0f, 1.0f, 6.0f, 0.1f, () -> true);
        \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445LLL.addSettings(range, players, mobs, team, onlyCrit, critFallDist);
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL) {
        Entity LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL = TriggerBot.mc.objectMouseOver.entityHit;
        if (LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL == null || TriggerBot.mc.player.getDistanceToEntity(LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL) > range.getNumberValue() || LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL instanceof EntityEnderCrystal || LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL.isDead || ((EntityLivingBase)LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL).getHealth() <= 0.0f) {
            return;
        }
        if (MovementHelper.isBlockAboveHead() ? !(TriggerBot.mc.player.fallDistance >= critFallDist.getNumberValue()) && TriggerBot.mc.player.getCooledAttackStrength(0.8f) == 1.0f && onlyCrit.getBoolValue() && !TriggerBot.mc.player.isOnLadder() && !TriggerBot.mc.player.isInLiquid() && !TriggerBot.mc.player.isInWeb && TriggerBot.mc.player.getRidingEntity() == null : TriggerBot.mc.player.fallDistance != 0.0f && onlyCrit.getBoolValue() && !TriggerBot.mc.player.isOnLadder() && !TriggerBot.mc.player.isInLiquid() && !TriggerBot.mc.player.isInWeb && TriggerBot.mc.player.getRidingEntity() == null) {
            return;
        }
        if ((EntityLivingBase)LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL != false && TriggerBot.mc.player.getCooledAttackStrength(0.0f) == 1.0f) {
            TriggerBot.mc.playerController.attackEntity(TriggerBot.mc.player, LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL);
            TriggerBot.mc.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    static {
        onlyCrit = new BooleanSetting("Only Crits", false, () -> true);
        critFallDist = new NumberSetting("Fall Distance", 0.2f, 0.08f, 1.0f, 0.01f, () -> onlyCrit.getBoolValue());
    }
}

