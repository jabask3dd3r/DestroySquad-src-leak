/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.ListSetting;

public class FullBright
extends Feature {
    public static ListSetting brightMode;

    public FullBright() {
        super("FullBright", "\nRemoves darkness in the game", Type.Visuals);
        FullBright \u0445L\u0445LL\u0445L\u0445\u0445\u0445LL\u0445L;
        brightMode = new ListSetting("FullBright Mode", "Gamma", () -> true, "Gamma", "Potion");
        \u0445L\u0445LL\u0445L\u0445\u0445\u0445LL\u0445L.addSettings(brightMode);
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445LL\u0445L) {
        FullBright L\u0445L\u0445L\u0445L\u0445\u0445\u0445LL\u0445L;
        if (L\u0445L\u0445L\u0445L\u0445\u0445\u0445LL\u0445L.getState()) {
            String \u0445LL\u0445L\u0445L\u0445\u0445\u0445LL\u0445L = brightMode.getOptions();
            if (\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL\u0445L.equalsIgnoreCase("Gamma")) {
                FullBright.mc.gameSettings.gammaSetting = 1000.0f;
            }
            if (\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL\u0445L.equalsIgnoreCase("Potion")) {
                FullBright.mc.player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 817, 1));
            } else {
                FullBright.mc.player.removePotionEffect(Potion.getPotionById(16));
            }
        }
    }

    @Override
    public void onDisable() {
        FullBright \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL\u0445L;
        super.onDisable();
        FullBright.mc.gameSettings.gammaSetting = 1.0f;
        FullBright.mc.player.removePotionEffect(Potion.getPotionById(16));
    }
}

