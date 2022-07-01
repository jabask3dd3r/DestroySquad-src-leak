/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.Destroy.client.cmd.Command;
import org.Destroy.client.cmd.CommandAbstract;
import org.Destroy.client.cmd.CommandHandler;
import org.Destroy.client.cmd.impl.AesCommand;
import org.Destroy.client.cmd.impl.BindCommand;
import org.Destroy.client.cmd.impl.ClipCommand;
import org.Destroy.client.cmd.impl.ConfigCommand;
import org.Destroy.client.cmd.impl.FakeHackCommand;
import org.Destroy.client.cmd.impl.FriendCommand;
import org.Destroy.client.cmd.impl.HelpCommand;
import org.Destroy.client.cmd.impl.MacroCommand;
import org.Destroy.client.cmd.impl.XrayCommand;
import org.Destroy.client.event.EventManager;

public class CommandManager {
    private final ArrayList<Command> commands = new ArrayList();

    public CommandManager() {
        CommandManager LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L;
        EventManager.register(new CommandHandler(LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L));
        LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L.commands.add(new FakeHackCommand());
        LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L.commands.add(new BindCommand());
        LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L.commands.add(new ClipCommand());
        LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L.commands.add(new AesCommand());
        LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L.commands.add(new FriendCommand());
        LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L.commands.add(new MacroCommand());
        LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L.commands.add(new ConfigCommand());
        LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L.commands.add(new HelpCommand());
        LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L.commands.add(new XrayCommand());
    }

    public List<Command> getCommands() {
        CommandManager L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L;
        return L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LL\u0445L.commands;
    }

    public boolean execute(String LLL\u0445\u0445LLLL\u0445\u0445LL\u0445L) {
        CommandManager L\u0445\u0445L\u0445LLLL\u0445\u0445LL\u0445L;
        Iterator<Command> \u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445LL\u0445L;
        String \u0445LL\u0445\u0445LLLL\u0445\u0445LL\u0445L = LLL\u0445\u0445LLLL\u0445\u0445LL\u0445L.substring(1);
        String[] L\u0445L\u0445\u0445LLLL\u0445\u0445LL\u0445L = \u0445LL\u0445\u0445LLLL\u0445\u0445LL\u0445L.split(" ");
        if (L\u0445L\u0445\u0445LLLL\u0445\u0445LL\u0445L.length > 0 && (\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445LL\u0445L = L\u0445\u0445L\u0445LLLL\u0445\u0445LL\u0445L.commands.iterator()).hasNext()) {
            int \u0445L\u0445LL\u0445LLL\u0445\u0445LL\u0445L = 0;
            Command LL\u0445L\u0445LLLL\u0445\u0445LL\u0445L = \u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445LL\u0445L.next();
            CommandAbstract LLLL\u0445LLLL\u0445\u0445LL\u0445L = (CommandAbstract)LL\u0445L\u0445LLLL\u0445\u0445LL\u0445L;
            String[] L\u0445LL\u0445LLLL\u0445\u0445LL\u0445L = LLLL\u0445LLLL\u0445\u0445LL\u0445L.getAliases();
            String[] \u0445\u0445LLL\u0445LLL\u0445\u0445LL\u0445L = L\u0445LL\u0445LLLL\u0445\u0445LL\u0445L;
            int LL\u0445LL\u0445LLL\u0445\u0445LL\u0445L = \u0445\u0445LLL\u0445LLL\u0445\u0445LL\u0445L.length;
            if (\u0445L\u0445LL\u0445LLL\u0445\u0445LL\u0445L < LL\u0445LL\u0445LLL\u0445\u0445LL\u0445L) {
                String \u0445\u0445\u0445\u0445LLLLL\u0445\u0445LL\u0445L = \u0445\u0445LLL\u0445LLL\u0445\u0445LL\u0445L[\u0445L\u0445LL\u0445LLL\u0445\u0445LL\u0445L];
                if (L\u0445L\u0445\u0445LLLL\u0445\u0445LL\u0445L[0].equalsIgnoreCase(\u0445\u0445\u0445\u0445LLLLL\u0445\u0445LL\u0445L)) {
                    LLLL\u0445LLLL\u0445\u0445LL\u0445L.execute(L\u0445L\u0445\u0445LLLL\u0445\u0445LL\u0445L);
                    return true;
                }
                ++\u0445L\u0445LL\u0445LLL\u0445\u0445LL\u0445L;
                return false;
            }
            return false;
        }
        return false;
    }
}

