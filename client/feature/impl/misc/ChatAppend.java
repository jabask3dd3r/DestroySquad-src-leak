/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventMessage;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;

public class ChatAppend
extends Feature {
    public ChatAppend() {
        super("ChatAppend", "Appends the name of the cheat to the message", Type.Misc);
        ChatAppend L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLLL;
    }

    @EventTarget
    public void onChatMessage(EventMessage L\u0445LL\u0445\u0445LL\u0445L\u0445LLLL) {
        if (L\u0445LL\u0445\u0445LL\u0445L\u0445LLLL.getMessage().startsWith("/")) {
            return;
        }
        L\u0445LL\u0445\u0445LL\u0445L\u0445LLLL.message = L\u0445LL\u0445\u0445LL\u0445L\u0445LLLL.message + " | " + Destroy.instance.name;
    }
}

