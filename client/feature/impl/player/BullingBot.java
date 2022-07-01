/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventAttackClient;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.settings.impl.NumberSetting;
import org.apache.commons.lang3.RandomStringUtils;

public class BullingBot
extends Feature {
    private final NumberSetting delay;
    public String lastMessage = "";
    TimerHelper timer = new TimerHelper();

    public BullingBot() {
        super("BullingBot", "When hit, the player sends a bullying message to his address", Type.Player);
        BullingBot \u0445\u0445L\u0445LLL\u0445\u0445LLL\u0445\u0445L;
        \u0445\u0445L\u0445LLL\u0445\u0445LLL\u0445\u0445L.delay = new NumberSetting("Bulling Delay", 6.0f, 1.0f, 20.0f, 1.0f, () -> true);
        \u0445\u0445L\u0445LLL\u0445\u0445LLL\u0445\u0445L.addSettings(\u0445\u0445L\u0445LLL\u0445\u0445LLL\u0445\u0445L.delay);
    }

    @EventTarget
    public void onPacket(EventAttackClient L\u0445\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L) {
        if (L\u0445\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L.getEntity() instanceof EntityPlayer) {
            BullingBot \u0445L\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L;
            Entity L\u0445LL\u0445LL\u0445\u0445LLL\u0445\u0445L = L\u0445\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L.getEntity();
            String[] \u0445\u0445LL\u0445LL\u0445\u0445LLL\u0445\u0445L = new String[]{"Using is the best free client, Destroy Squad | Easy HVH"};
            String LL\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L = \u0445\u0445LL\u0445LL\u0445\u0445LLL\u0445\u0445L[new Random().nextInt(\u0445\u0445LL\u0445LL\u0445\u0445LLL\u0445\u0445L.length)];
            if (\u0445L\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L.timer.hasReached(\u0445L\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L.delay.getNumberValue() * 1000.0f) && !\u0445L\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L.lastMessage.equals(LL\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L) || \u0445L\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L.lastMessage == null) {
                BullingBot.mc.player.sendChatMessage("![" + RandomStringUtils.randomAlphanumeric(5) + "] " + L\u0445LL\u0445LL\u0445\u0445LLL\u0445\u0445L.getName() + " " + LL\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L + " [" + RandomStringUtils.randomAlphanumeric(5) + "]");
                \u0445L\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L.lastMessage = LL\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L;
                \u0445L\u0445L\u0445LL\u0445\u0445LLL\u0445\u0445L.timer.reset();
            }
        }
    }
}

