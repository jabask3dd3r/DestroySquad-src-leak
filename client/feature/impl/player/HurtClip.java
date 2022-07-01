/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import net.minecraft.network.play.client.CPacketPlayer;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.misc.FreeCam;

public class HurtClip
extends Feature {
    public boolean damageToggle = false;

    public HurtClip() {
        super("HurtClip", "Clips you under the thigh. Not relevant.", Type.Player);
        HurtClip L\u0445LLLLL\u0445\u0445L\u0445\u0445\u0445\u0445L;
    }

    @EventTarget
    public void onUpdate(EventUpdate LLL\u0445LLL\u0445\u0445L\u0445\u0445\u0445\u0445L) {
        HurtClip \u0445\u0445\u0445LLLL\u0445\u0445L\u0445\u0445\u0445\u0445L;
        if (!\u0445\u0445\u0445LLLL\u0445\u0445L\u0445\u0445\u0445\u0445L.damageToggle) {
            int L\u0445\u0445LLLL\u0445\u0445L\u0445\u0445\u0445\u0445L = 0;
            if (L\u0445\u0445LLLL\u0445\u0445L\u0445\u0445\u0445\u0445L < 9) {
                HurtClip.mc.player.connection.sendPacket(new CPacketPlayer.Position(HurtClip.mc.player.posX, HurtClip.mc.player.posY, HurtClip.mc.player.posZ, false));
                HurtClip.mc.player.connection.sendPacket(new CPacketPlayer.Position(HurtClip.mc.player.posX, HurtClip.mc.player.posY + 0.4, HurtClip.mc.player.posZ, false));
                ++L\u0445\u0445LLLL\u0445\u0445L\u0445\u0445\u0445\u0445L;
                return;
            }
            HurtClip.mc.player.connection.sendPacket(new CPacketPlayer.Position(HurtClip.mc.player.posX, HurtClip.mc.player.posY, HurtClip.mc.player.posZ, true));
            HurtClip.mc.player.connection.sendPacket(new CPacketPlayer.Position(HurtClip.mc.player.posX, HurtClip.mc.player.posY, HurtClip.mc.player.posZ, true));
        }
        if (HurtClip.mc.player.hurtTime > 0) {
            HurtClip.mc.player.setPositionAndUpdate(HurtClip.mc.player.posX, -2.0, HurtClip.mc.player.posZ);
            \u0445\u0445\u0445LLLL\u0445\u0445L\u0445\u0445\u0445\u0445L.damageToggle = true;
            \u0445\u0445\u0445LLLL\u0445\u0445L\u0445\u0445\u0445\u0445L.toggle();
            Destroy.instance.featureManager.getFeatureByClass(FreeCam.class).setState(true);
        }
    }
}

