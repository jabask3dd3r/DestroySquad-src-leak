/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd.impl;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import org.Destroy.client.cmd.CommandAbstract;
import org.Destroy.client.feature.impl.misc.FakeHack;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;

public class FakeHackCommand
extends CommandAbstract {
    public FakeHackCommand() {
        super("fakehack", "fakehack", "\u00c2\u00a76.fakehack" + (Object)((Object)ChatFormatting.LIGHT_PURPLE) + " add | remove | clear\u00c2\u00a73<name>", "\u00c2\u00a76.fakehack" + (Object)((Object)ChatFormatting.LIGHT_PURPLE) + " add | del | clear\u00c2\u00a73<name>", "fakehack");
        FakeHackCommand LLLLLL\u0445\u0445L\u0445L\u0445LLL;
    }

    @Override
    public void execute(String ... \u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL) {
        try {
            if (\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL.length > 1) {
                if (\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL[0].equals("fakehack")) {
                    if (\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL[1].equals("add")) {
                        FakeHack.fakeHackers.add(\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL[2]);
                        ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Added player " + (Object)((Object)ChatFormatting.RED) + \u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL[2] + (Object)((Object)ChatFormatting.WHITE) + " as HACKER!");
                        NotificationManager.publicity("FakeHack Manager", (Object)((Object)ChatFormatting.GREEN) + "Added player " + (Object)((Object)ChatFormatting.RED) + \u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL[2] + (Object)((Object)ChatFormatting.WHITE) + " as HACKER!", 4, NotificationType.SUCCESS);
                    }
                    if (\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL[1].equals("remove")) {
                        EntityPlayer \u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LLL = Minecraft.getInstance().world.getPlayerEntityByName(\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL[2]);
                        if (\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LLL == null) {
                            ChatHelper.addChatMessage("\u00c2\u00a7cThat player could not be found!");
                            return;
                        }
                        if (FakeHack.isFakeHacker(\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LLL)) {
                            FakeHack.removeHacker(\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LLL);
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Hacker " + (Object)((Object)ChatFormatting.RED) + \u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LLL.getName() + " " + (Object)((Object)ChatFormatting.WHITE) + "was removed!");
                            NotificationManager.publicity("FakeHack Manager", (Object)((Object)ChatFormatting.GREEN) + "Hacker " + (Object)((Object)ChatFormatting.WHITE) + "was removed!", 4, NotificationType.SUCCESS);
                        }
                    }
                    if (\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL[1].equals("clear")) {
                        if (FakeHack.fakeHackers.isEmpty()) {
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Your FakeHack list is empty!");
                            NotificationManager.publicity("FakeHack Manager", "Your FakeHack list is empty!", 4, NotificationType.ERROR);
                            return;
                        }
                        FakeHack.fakeHackers.clear();
                        ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Your FakeHack list " + (Object)((Object)ChatFormatting.WHITE) + " successfully cleared!");
                        NotificationManager.publicity("FakeHack Manager", (Object)((Object)ChatFormatting.GREEN) + "Your FakeHack list " + (Object)((Object)ChatFormatting.WHITE) + " successfully cleared!", 4, NotificationType.SUCCESS);
                    }
                }
            } else {
                FakeHackCommand L\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL;
                ChatHelper.addChatMessage(L\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL.getUsage());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

