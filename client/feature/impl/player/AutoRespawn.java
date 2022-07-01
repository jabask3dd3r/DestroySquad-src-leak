/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import net.minecraft.client.gui.GuiGameOver;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;

public class AutoRespawn
extends Feature {
    public AutoRespawn() {
        super("AutoRespawn", "Auto respawn on death", Type.Player);
        AutoRespawn \u0445L\u0445LL\u0445LL\u0445LL\u0445LL;
    }

    @EventTarget
    public void onUpdate(EventUpdate LL\u0445\u0445L\u0445LL\u0445LL\u0445LL) {
        if (AutoRespawn.mc.player.getHealth() < 0.0f || !AutoRespawn.mc.player.isEntityAlive() || AutoRespawn.mc.currentScreen instanceof GuiGameOver) {
            AutoRespawn.mc.player.respawnPlayer();
            mc.displayGuiScreen(null);
        }
    }
}

