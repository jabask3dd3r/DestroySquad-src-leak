/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd.impl;

import com.mojang.realmsclient.gui.ChatFormatting;
import org.Destroy.client.cmd.CommandAbstract;
import org.Destroy.client.helpers.misc.ChatHelper;

public class HelpCommand
extends CommandAbstract {
    public HelpCommand() {
        super("help", "help", ".help", "help");
        HelpCommand \u0445\u0445\u0445LL\u0445\u0445L\u0445LL\u0445\u0445\u0445L;
    }

    @Override
    public void execute(String ... L\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L) {
        if (L\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L.length == 1) {
            if (L\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L[0].equals("help")) {
                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "All Commands:");
                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.DARK_AQUA) + ".bind");
                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.DARK_AQUA) + ".macro");
                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.DARK_AQUA) + ".vclip");
                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.DARK_AQUA) + ".friend");
                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.DARK_AQUA) + ".config");
            }
        } else {
            HelpCommand LLL\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L;
            ChatHelper.addChatMessage(LLL\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L.getUsage());
        }
    }
}

