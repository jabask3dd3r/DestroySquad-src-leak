/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd.impl;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import org.Destroy.client.Destroy;
import org.Destroy.client.cmd.CommandAbstract;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;

public class FriendCommand
extends CommandAbstract {
    public FriendCommand() {
        super("friend", "friend list", ".friend" + (Object)((Object)ChatFormatting.DARK_AQUA) + " add <nickname> " + (Object)((Object)ChatFormatting.WHITE) + "| .friend" + (Object)((Object)ChatFormatting.DARK_AQUA) + " del <nickname> " + (Object)((Object)ChatFormatting.WHITE) + "| .friend" + (Object)((Object)ChatFormatting.DARK_AQUA) + " list " + (Object)((Object)ChatFormatting.WHITE) + "| .friend" + (Object)((Object)ChatFormatting.DARK_AQUA) + " clear", "friend");
        FriendCommand LLL\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L;
    }

    @Override
    public void execute(String ... \u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L) {
        FriendCommand LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L;
        try {
            if (\u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L.length > 1) {
                if (\u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L[0].equalsIgnoreCase("friend")) {
                    String L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L;
                    if (\u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L[1].equalsIgnoreCase("add")) {
                        String \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L = \u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L[2];
                        if (\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L.equals(Minecraft.getInstance().player.getName())) {
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "You can't add yourself!");
                            NotificationManager.publicity("Friend Manager", "You can't add yourself!", 4, NotificationType.ERROR);
                            return;
                        }
                        if (!Destroy.instance.friendManager.isFriend(\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L)) {
                            Destroy.instance.friendManager.addFriend(\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L);
                            ChatHelper.addChatMessage("Friend " + (Object)((Object)ChatFormatting.GREEN) + \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L + (Object)((Object)ChatFormatting.WHITE) + " successfully added to your friend list!");
                            NotificationManager.publicity("Friend Manager", "Friend " + (Object)((Object)ChatFormatting.RED) + \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L + (Object)((Object)ChatFormatting.WHITE) + " deleted from your friend list!", 4, NotificationType.SUCCESS);
                        }
                    }
                    if (\u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L[1].equalsIgnoreCase("del") && Destroy.instance.friendManager.isFriend(L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L = \u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L[2])) {
                        Destroy.instance.friendManager.removeFriend(L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L);
                        ChatHelper.addChatMessage("Friend " + (Object)((Object)ChatFormatting.RED) + L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L + (Object)((Object)ChatFormatting.WHITE) + " deleted from your friend list!");
                        NotificationManager.publicity("Friend Manager", "Friend " + (Object)((Object)ChatFormatting.RED) + L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L + (Object)((Object)ChatFormatting.WHITE) + " deleted from your friend list!", 4, NotificationType.SUCCESS);
                    }
                    if (\u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L[1].equalsIgnoreCase("clear")) {
                        if (Destroy.instance.friendManager.getFriends().isEmpty()) {
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Your friend list is empty!");
                            NotificationManager.publicity("Friend Manager", "Your friend list is empty!", 4, NotificationType.ERROR);
                            return;
                        }
                        Destroy.instance.friendManager.getFriends().clear();
                        ChatHelper.addChatMessage("Your " + (Object)((Object)ChatFormatting.GREEN) + "friend list " + (Object)((Object)ChatFormatting.WHITE) + "was cleared!");
                        NotificationManager.publicity("Friend Manager", "Your " + (Object)((Object)ChatFormatting.GREEN) + "friend list " + (Object)((Object)ChatFormatting.WHITE) + "was cleared!", 4, NotificationType.SUCCESS);
                    }
                    if (\u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L[1].equalsIgnoreCase("list")) {
                        if (Destroy.instance.friendManager.getFriends().isEmpty()) {
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Your friend list is empty!");
                            NotificationManager.publicity("Friend Manager", "Your friend list is empty!", 4, NotificationType.ERROR);
                            return;
                        }
                        Destroy.instance.friendManager.getFriends().forEach(L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L -> ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Friend list: " + (Object)((Object)ChatFormatting.RED) + L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L.getName()));
                    }
                }
            } else {
                ChatHelper.addChatMessage(LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L.getUsage());
            }
        }
        catch (Exception \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L) {
            ChatHelper.addChatMessage("\u00c2\u00a7cNo, no, no. Usage: " + LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L.getUsage());
        }
    }
}

