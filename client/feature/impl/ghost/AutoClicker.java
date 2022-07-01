/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.ghost;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.MathematicHelper;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.settings.impl.NumberSetting;

public class AutoClicker
extends Feature {
    public NumberSetting minCps = new NumberSetting("Min", 6.0f, 1.0f, 20.0f, 1.0f, () -> true, NumberSetting.NumberType.APS);
    public NumberSetting maxCps = new NumberSetting("Max", 10.0f, 1.0f, 20.0f, 1.0f, () -> true, NumberSetting.NumberType.APS);
    public TimerHelper timerHelper = new TimerHelper();

    public AutoClicker() {
        super("AutoClicker", "Clicks a specific cps", Type.Combat);
        AutoClicker \u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLLLL;
        \u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLLLL.addSettings(\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLLLL.minCps, \u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLLLL.maxCps);
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445\u0445LLLLL\u0445L\u0445LLLLL) {
        int \u0445LLLLLL\u0445L\u0445LLLLL;
        AutoClicker L\u0445LLLLL\u0445L\u0445LLLLL;
        if (AutoClicker.mc.gameSettings.keyBindAttack.isKeyDown() && !AutoClicker.mc.player.isUsingItem() && L\u0445LLLLL\u0445L\u0445LLLLL.timerHelper.hasReached(1000 / (\u0445LLLLLL\u0445L\u0445LLLLL = (int)MathematicHelper.randomizeFloat(L\u0445LLLLL\u0445L\u0445LLLLL.maxCps.getNumberValue(), L\u0445LLLLL\u0445L\u0445LLLLL.minCps.getNumberValue())))) {
            mc.clickMouse();
            L\u0445LLLLL\u0445L\u0445LLLLL.timerHelper.reset();
        }
    }
}

