/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import net.minecraft.client.gui.GuiGameOver;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;

public class DeathCoordinates
extends Feature {
    public DeathCoordinates() {
        super("DeathCoordinates", "Shows the player's death coordinates", Type.Misc);
        DeathCoordinates \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L;
    }

    @EventTarget
    public void onUpdate(EventUpdate L\u0445LL\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L) {
        if (DeathCoordinates.mc.player.getHealth() < 1.0f && DeathCoordinates.mc.currentScreen instanceof GuiGameOver) {
            int L\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L = DeathCoordinates.mc.player.getPosition().getX();
            int \u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L = DeathCoordinates.mc.player.getPosition().getY();
            int LLLL\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L = DeathCoordinates.mc.player.getPosition().getZ();
            if (DeathCoordinates.mc.player.ticksExisted % 20 == 0) {
                NotificationManager.publicity("Death Coordinates", "X: " + L\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L + " Y: " + \u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L + " Z: " + LLLL\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L, 10, NotificationType.INFO);
                ChatHelper.addChatMessage("Death Coordinates: X: " + L\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L + " Y: " + \u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L + " Z: " + LLLL\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L);
            }
        }
    }
}

