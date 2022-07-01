/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd;

import org.Destroy.client.cmd.CommandManager;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventMessage;

public class CommandHandler {
    public CommandManager commandManager;

    public CommandHandler(CommandManager L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LL) {
        CommandHandler \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LL;
        \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LL.commandManager = L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LL;
    }

    @EventTarget
    public void onMessage(EventMessage \u0445L\u0445LLL\u0445L\u0445L\u0445L\u0445LL) {
        String L\u0445\u0445LLL\u0445L\u0445L\u0445L\u0445LL = \u0445L\u0445LLL\u0445L\u0445L\u0445L\u0445LL.getMessage();
        if (L\u0445\u0445LLL\u0445L\u0445L\u0445L\u0445LL.length() > 0 && L\u0445\u0445LLL\u0445L\u0445L\u0445L\u0445LL.startsWith(".")) {
            CommandHandler LL\u0445LLL\u0445L\u0445L\u0445L\u0445LL;
            \u0445L\u0445LLL\u0445L\u0445L\u0445L\u0445LL.setCancelled(LL\u0445LLL\u0445L\u0445L\u0445L\u0445LL.commandManager.execute(L\u0445\u0445LLL\u0445L\u0445L\u0445L\u0445LL));
        }
    }
}

