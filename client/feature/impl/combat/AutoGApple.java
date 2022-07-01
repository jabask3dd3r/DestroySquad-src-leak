/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.NumberSetting;

public class AutoGApple
extends Feature {
    public static NumberSetting health;
    private boolean isActive;
    private boolean eating = false;

    public AutoGApple() {
        super("AutoGApple", "Automatic aets gapple", Type.Combat);
        AutoGApple \u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L;
        health = new NumberSetting("Health Amount", 17.0f, 4.0f, 18.0f, 1.0f, () -> true);
        \u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L.addSettings(health);
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L) {
        AutoGApple L\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L;
        L\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L.setSuffix("" + (int)health.getNumberValue());
        if ((double)(AutoGApple.mc.player.getHealth() + AutoGApple.mc.player.getAbsorptionAmount()) > (double)health.getNumberValue() && L\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L.eating) {
            L\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L.eating = false;
            L\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L.stop();
            return;
        }
        if (L\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L != false) {
            return;
        }
        AutoGApple autoGApple = L\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L;
        if (AutoGApple.mc.player.getHeldItemOffhand() != false && (double)AutoGApple.mc.player.getHealth() <= (double)health.getNumberValue() && L\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L != false) {
            KeyBinding.setKeyBindState(AutoGApple.mc.gameSettings.keyBindUseItem.getKeyCode(), true);
            L\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L.eating = true;
        }
        if (L\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L != false) {
            L\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L.stop();
        }
    }

    void stop() {
        KeyBinding.setKeyBindState(AutoGApple.mc.gameSettings.keyBindUseItem.getKeyCode(), false);
    }

    private boolean isGoldenApple(ItemStack LLLL\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L) {
        return LLLL\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L != null && !LLLL\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.isEmpty() && LLLL\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.getItem() instanceof ItemAppleGold;
    }
}

