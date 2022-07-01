/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import net.minecraft.util.EnumParticleTypes;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.ListSetting;

public class TrailsWater
extends Feature {
    private final ListSetting effect = new ListSetting("Effect Mode", "Dragon", () -> true, "Dragon", "Water");

    public TrailsWater() {
        super("EffectTrails", "Draws effect breath", Type.Visuals);
        TrailsWater \u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445L\u0445L;
        \u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445L\u0445L.addSettings(\u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445L\u0445L.effect);
    }

    @EventTarget
    public void onUpdate(EventUpdate LL\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445L) {
        TrailsWater \u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L;
        String \u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445L = \u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L.effect.getOptions();
        if (\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L.effect.currentMode.equals("Dragon")) {
            TrailsWater.mc.world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, TrailsWater.mc.player.posX, TrailsWater.mc.player.posY, TrailsWater.mc.player.posZ, TrailsWater.mc.player.motionX, TrailsWater.mc.player.motionY, TrailsWater.mc.player.motionZ, 9);
        } else if (\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445L.equalsIgnoreCase("Water")) {
            TrailsWater.mc.world.spawnParticle(EnumParticleTypes.DRIP_WATER, TrailsWater.mc.player.posX, TrailsWater.mc.player.posY, TrailsWater.mc.player.posZ, TrailsWater.mc.player.motionX, TrailsWater.mc.player.motionY, TrailsWater.mc.player.motionZ, 9);
        }
    }
}

