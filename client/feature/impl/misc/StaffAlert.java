/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventReceivePacket;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ChatHelper;

public class StaffAlert
extends Feature {
    private final ArrayList<UUID> players = new ArrayList();

    public StaffAlert() {
        super("StaffAlert", "Alerts you about people that can spectate you", Type.Misc);
        StaffAlert \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
    }

    @EventTarget
    public void onPacket(EventReceivePacket \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L) {
        StaffAlert LL\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L;
        Iterator<SPacketPlayerListItem.AddPlayerData> L\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L;
        if (!(\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getPacket() instanceof SPacketPlayerListItem)) {
            return;
        }
        SPacketPlayerListItem L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L = (SPacketPlayerListItem)\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getPacket();
        if (L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getAction() == SPacketPlayerListItem.Action.ADD_PLAYER && (L\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L = L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getEntries().iterator()).hasNext()) {
            SPacketPlayerListItem.AddPlayerData L\u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445\u0445L = L\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.next();
            LL\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.players.add(L\u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445\u0445L.getProfile().getId());
            return;
        }
        if (L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getAction() == SPacketPlayerListItem.Action.REMOVE_PLAYER && (L\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L = L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getEntries().iterator()).hasNext()) {
            SPacketPlayerListItem.AddPlayerData L\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L = L\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.next();
            EntityPlayer LLL\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L = StaffAlert.mc.world.getPlayerEntityByUUID(L\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getProfile().getId());
            if (LLL\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getDisplayName().getFormattedText().toLowerCase().contains("MODER") || LLL\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getDisplayName().getFormattedText().toLowerCase().contains("HELPER")) {
                ChatHelper.addChatMessage(L\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getProfile().getName() + "can spectate you!");
                LL\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.players.removeIf(LLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L -> LLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.equals(L\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getProfile().getId()));
            }
            return;
        }
    }
}

