/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.components;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRichPresence;
import org.Destroy.client.Destroy;

public class DiscordRPC {
    private boolean running = true;
    private long created = 0L;
    final String text;

    public DiscordRPC() {
        DiscordRPC \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L;
        \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L.text = Destroy.instance.name;
    }

    public void init() {
        DiscordRPC \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L;
        \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L.running = true;
        \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L.created = System.currentTimeMillis();
        DiscordEventHandlers LL\u0445\u0445\u0445\u0445\u0445L\u0445L = new DiscordEventHandlers.Builder().setReadyEventHandler(L\u0445L\u0445LLL\u0445\u0445L -> {}).build();
        net.arikia.dev.drpc.DiscordRPC.discordInitialize("960598219690229832", LL\u0445\u0445\u0445\u0445\u0445L\u0445L, true);
        new Thread(""){
            {
                1 \u0445L\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445LLL;
                super(\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445LLL);
            }

            @Override
            public void run() {
                net.arikia.dev.drpc.DiscordRPC.discordRunCallbacks();
            }
        }.start();
    }

    public void shutdown() {
        LLLLLLL\u0445\u0445L.running = false;
        net.arikia.dev.drpc.DiscordRPC.discordShutdown();
    }

    public void update(String \u0445L\u0445LLLL\u0445\u0445L, String L\u0445\u0445LLLL\u0445\u0445L) {
        DiscordRichPresence.Builder \u0445\u0445\u0445LLLL\u0445\u0445L = new DiscordRichPresence.Builder(L\u0445\u0445LLLL\u0445\u0445L);
        \u0445\u0445\u0445LLLL\u0445\u0445L.setBigImage("large", "");
        \u0445\u0445\u0445LLLL\u0445\u0445L.setDetails("vk.com/destroy_client");
        \u0445\u0445\u0445LLLL\u0445\u0445L.setStartTimestamps(System.currentTimeMillis() / 1000L);
        net.arikia.dev.drpc.DiscordRPC.discordUpdatePresence(\u0445\u0445\u0445LLLL\u0445\u0445L.build());
    }
}

