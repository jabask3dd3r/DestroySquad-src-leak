/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd;

import org.Destroy.client.cmd.Command;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.misc.ChatHelper;

public abstract class CommandAbstract
implements Command,
Helper {
    private final String name;
    private final String description;
    private final String usage;
    private final String[] aliases;

    public CommandAbstract(String L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL, String \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL, String LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL, String ... \u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL) {
        CommandAbstract \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL;
        \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL.name = L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL;
        \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL.description = \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL;
        \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL.aliases = \u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL;
        \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL.usage = LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL;
    }

    public void usage() {
        CommandAbstract LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL;
        ChatHelper.addChatMessage("\u00c2\u00a7cInvalid usage, try: " + LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL.usage + " or .help");
    }

    public String getUsage() {
        CommandAbstract \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL;
        return \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL.usage;
    }

    public String getName() {
        CommandAbstract LLLLLLL\u0445\u0445\u0445\u0445\u0445LL;
        return LLLLLLL\u0445\u0445\u0445\u0445\u0445LL.name;
    }

    public String getDescription() {
        CommandAbstract \u0445\u0445L\u0445LLL\u0445\u0445\u0445\u0445\u0445LL;
        return \u0445\u0445L\u0445LLL\u0445\u0445\u0445\u0445\u0445LL.description;
    }

    public String[] getAliases() {
        CommandAbstract \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445LL;
        return \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445LL.aliases;
    }
}

