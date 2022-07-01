/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;

public class NoDelay
extends Feature {
    public BooleanSetting rightClickDelay = new BooleanSetting("NoRightClickDelay", false, () -> true);
    public BooleanSetting leftClickDelay = new BooleanSetting("NoLeftClickDelay", false, () -> true);
    public BooleanSetting jumpDelay = new BooleanSetting("NoJumpDelay", true, () -> true);
    public BooleanSetting blockHitDelay = new BooleanSetting("NoBlockHitDelay", false, () -> true);

    public NoDelay() {
        super("NoJumpDelay", "Removes the delay", Type.Player);
        NoDelay \u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445L\u0445LL;
        \u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445L\u0445LL.addSettings(\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445L\u0445LL.jumpDelay, \u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445L\u0445LL.blockHitDelay);
    }

    @Override
    public void onDisable() {
        NoDelay \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LL;
        NoDelay.mc.rightClickDelayTimer = 4;
        super.onDisable();
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL) {
        NoDelay \u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL;
        if (!\u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL.getState()) {
            return;
        }
        if (\u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL.rightClickDelay.getBoolValue()) {
            NoDelay.mc.rightClickDelayTimer = 0;
        }
        if (\u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL.leftClickDelay.getBoolValue()) {
            NoDelay.mc.leftClickCounter = 0;
        }
        if (\u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL.jumpDelay.getBoolValue()) {
            NoDelay.mc.player.jumpTicks = 0;
        }
        if (\u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LL.blockHitDelay.getBoolValue()) {
            NoDelay.mc.playerController.blockHitDelay = 0;
        }
    }
}

