/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ChatHelper;

public class PearlLogger
extends Feature {
    private boolean canSend;

    public PearlLogger() {
        super("PearlLogger", "View cordinats for chat", Type.Player);
        PearlLogger \u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445L;
    }

    @Override
    public void onEnable() {
        L\u0445L\u0445LLL\u0445\u0445\u0445\u0445L.canSend = true;
    }

    @EventTarget
    public void onUpdate(EventUpdate LL\u0445L\u0445LL\u0445\u0445\u0445\u0445L) {
        PearlLogger \u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445L;
        Iterator \u0445LLL\u0445LL\u0445\u0445\u0445\u0445L;
        if (PearlLogger.mc.world == null || PearlLogger.mc.player == null) {
            return;
        }
        Entity \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L = null;
        Iterator \u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445L = PearlLogger.mc.world.loadedEntityList.iterator();
        if (\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445L.hasNext()) {
            \u0445LLL\u0445LL\u0445\u0445\u0445\u0445L = (Entity)\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445L.next();
            if (\u0445LLL\u0445LL\u0445\u0445\u0445\u0445L instanceof EntityEnderPearl) {
                \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L = \u0445LLL\u0445LL\u0445\u0445\u0445\u0445L;
            } else {
                return;
            }
        }
        if (\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L == null) {
            \u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445L.canSend = true;
            return;
        }
        EntityPlayer L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L = null;
        \u0445LLL\u0445LL\u0445\u0445\u0445\u0445L = PearlLogger.mc.world.playerEntities.iterator();
        if (\u0445LLL\u0445LL\u0445\u0445\u0445\u0445L.hasNext()) {
            EntityPlayer L\u0445LL\u0445LL\u0445\u0445\u0445\u0445L = (EntityPlayer)\u0445LLL\u0445LL\u0445\u0445\u0445\u0445L.next();
            if (L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L != null && L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L.getDistanceToEntity(\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L) <= L\u0445LL\u0445LL\u0445\u0445\u0445\u0445L.getDistanceToEntity(\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L)) {
                return;
            }
            L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L = L\u0445LL\u0445LL\u0445\u0445\u0445\u0445L;
            return;
        }
        String \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L = \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L.getHorizontalFacing().toString();
        if (\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L.equals("west")) {
            \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L = "east";
        } else if (\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L.equals("east")) {
            \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L = "west";
        }
        if (L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L == PearlLogger.mc.player) {
            return;
        }
        String LLL\u0445\u0445LL\u0445\u0445\u0445\u0445L = (Object)((Object)ChatFormatting.GOLD) + \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L + (Object)((Object)ChatFormatting.WHITE) + " | " + (Object)((Object)ChatFormatting.LIGHT_PURPLE) + \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L.getPosition().getX() + " " + \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L.getPosition().getY() + " " + \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L.getPosition().getZ();
        if (L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L != null && \u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445L.canSend) {
            ChatHelper.addChatMessage(Destroy.instance.friendManager.isFriend(L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L.getName()) ? (Object)((Object)ChatFormatting.GREEN) + L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L.getName() + (Object)((Object)ChatFormatting.WHITE) + " thrown pearl on " + LLL\u0445\u0445LL\u0445\u0445\u0445\u0445L : (Object)((Object)ChatFormatting.RED) + L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L.getName() + (Object)((Object)ChatFormatting.WHITE) + " thrown pearl on " + LLL\u0445\u0445LL\u0445\u0445\u0445\u0445L);
            \u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445L.canSend = false;
        }
    }
}

