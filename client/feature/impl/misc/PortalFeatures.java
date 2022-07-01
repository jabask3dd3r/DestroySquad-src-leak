/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import net.minecraft.network.play.client.CPacketConfirmTeleport;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventSendPacket;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;

public class PortalFeatures
extends Feature {
    public static BooleanSetting chat = new BooleanSetting("Chat", true, () -> true);
    public static BooleanSetting cancelTeleport = new BooleanSetting("Cancel Teleport", true, () -> true);

    public PortalFeatures() {
        super("PortalFeatures", "Allows you to open a chat in the portal", Type.Misc);
        PortalFeatures L\u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445L;
        L\u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445L.addSettings(chat, cancelTeleport);
    }

    @EventTarget
    public void onSendPacket(EventSendPacket L\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445L) {
        if (L\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445L.getPacket() instanceof CPacketConfirmTeleport && cancelTeleport.getBoolValue()) {
            L\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445L.setCancelled(true);
        }
    }
}

