/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import net.minecraft.network.play.client.CPacketUseEntity;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventSendPacket;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;

public class NoFriendDamage
extends Feature {
    public NoFriendDamage() {
        super("NoFriendDamage", "Doesn't let you hit your friend", Type.Combat);
        NoFriendDamage LLL\u0445L\u0445L\u0445\u0445LLLLLL;
    }

    @EventTarget
    public void onSendPacket(EventSendPacket \u0445\u0445LL\u0445\u0445L\u0445\u0445LLLLLL) {
        CPacketUseEntity \u0445LLL\u0445\u0445L\u0445\u0445LLLLLL;
        if (\u0445\u0445LL\u0445\u0445L\u0445\u0445LLLLLL.getPacket() instanceof CPacketUseEntity && (\u0445LLL\u0445\u0445L\u0445\u0445LLLLLL = (CPacketUseEntity)\u0445\u0445LL\u0445\u0445L\u0445\u0445LLLLLL.getPacket()).getAction().equals((Object)CPacketUseEntity.Action.ATTACK) && Destroy.instance.friendManager.isFriend(NoFriendDamage.mc.objectMouseOver.entityHit.getName())) {
            \u0445\u0445LL\u0445\u0445L\u0445\u0445LLLLLL.setCancelled(true);
        }
    }
}

