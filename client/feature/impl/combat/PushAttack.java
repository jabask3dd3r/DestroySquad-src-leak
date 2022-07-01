/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.NumberSetting;

public class PushAttack
extends Feature {
    private final NumberSetting clickCoolDown = new NumberSetting("Click CoolDown", 1.0f, 0.5f, 1.0f, 0.1f, () -> true);

    public PushAttack() {
        super("PushAttack", "\nAllows you to hit on LMB despite the use of items", Type.Combat);
        PushAttack \u0445L\u0445\u0445\u0445L\u0445\u0445LL\u0445LLL;
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445LLLL\u0445\u0445\u0445LL\u0445LLL) {
        PushAttack LLLLL\u0445\u0445\u0445LL\u0445LLL;
        if (PushAttack.mc.player.getCooledAttackStrength(0.0f) == LLLLL\u0445\u0445\u0445LL\u0445LLL.clickCoolDown.getNumberValue() && PushAttack.mc.gameSettings.keyBindAttack.pressed) {
            mc.clickMouse();
        }
    }
}

