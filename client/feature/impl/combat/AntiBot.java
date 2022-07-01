/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.ListSetting;

public class AntiBot
extends Feature {
    public static List<Entity> isBotPlayer = new ArrayList<Entity>();
    public ListSetting antiBotMode = new ListSetting("AntiBot Mode", "Packet", () -> true, "Packet");

    public AntiBot() {
        super("AntiBot", "Remove Bots", Type.Combat);
        AntiBot LL\u0445\u0445\u0445LL\u0445L\u0445LLL\u0445L;
        LL\u0445\u0445\u0445LL\u0445L\u0445LLL\u0445L.addSettings(LL\u0445\u0445\u0445LL\u0445L\u0445LLL\u0445L.antiBotMode);
    }

    @EventTarget
    public void onPreMotion(EventPreMotion \u0445L\u0445LL\u0445L\u0445L\u0445LLL\u0445L) {
        Iterator \u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL\u0445L = AntiBot.mc.world.loadedEntityList.iterator();
        if (\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL\u0445L.hasNext()) {
            AntiBot LL\u0445LL\u0445L\u0445L\u0445LLL\u0445L;
            Entity \u0445\u0445LLL\u0445L\u0445L\u0445LLL\u0445L = (Entity)\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL\u0445L.next();
            switch (LL\u0445LL\u0445L\u0445L\u0445LLL\u0445L.antiBotMode.currentMode) {
                case "Packet": {
                    if (\u0445\u0445LLL\u0445L\u0445L\u0445LLL\u0445L == AntiBot.mc.player || \u0445\u0445LLL\u0445L\u0445L\u0445LLL\u0445L.ticksExisted >= 5 || !(\u0445\u0445LLL\u0445L\u0445L\u0445LLL\u0445L instanceof EntityOtherPlayerMP) || ((EntityOtherPlayerMP)\u0445\u0445LLL\u0445L\u0445L\u0445LLL\u0445L).hurtTime <= 0 || !(AntiBot.mc.player.getDistanceToEntity(\u0445\u0445LLL\u0445L\u0445L\u0445LLL\u0445L) <= 25.0f) || AntiBot.mc.player.connection.getPlayerInfo(\u0445\u0445LLL\u0445L\u0445L\u0445LLL\u0445L.getUniqueID()).getResponseTime() == 0) break;
                    isBotPlayer.add(\u0445\u0445LLL\u0445L\u0445L\u0445LLL\u0445L);
                }
            }
            return;
        }
    }
}

