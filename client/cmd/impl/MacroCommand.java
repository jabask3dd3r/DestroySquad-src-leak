/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd.impl;

import com.mojang.realmsclient.gui.ChatFormatting;
import org.Destroy.client.Destroy;
import org.Destroy.client.cmd.CommandAbstract;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.macro.Macro;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;
import org.lwjgl.input.Keyboard;

public class MacroCommand
extends CommandAbstract {
    public MacroCommand() {
        super("macros", "macro", ".macro" + (Object)((Object)ChatFormatting.DARK_AQUA) + " add <key> /home_home " + (Object)((Object)ChatFormatting.WHITE) + "| .macro" + (Object)((Object)ChatFormatting.DARK_AQUA) + " remove  <key> | .macro" + (Object)((Object)ChatFormatting.DARK_AQUA) + " clear " + (Object)((Object)ChatFormatting.WHITE) + "| .macro" + (Object)((Object)ChatFormatting.DARK_AQUA) + " list", ".macro" + (Object)((Object)ChatFormatting.DARK_AQUA) + " add <key> </home_home> | .macro" + (Object)((Object)ChatFormatting.DARK_AQUA) + " remove <key> | .macro" + (Object)((Object)ChatFormatting.RED) + " clear | .macro" + (Object)((Object)ChatFormatting.RED) + " list", "macro");
        MacroCommand \u0445LLL\u0445\u0445L\u0445L\u0445\u0445\u0445LL;
    }

    @Override
    public void execute(String ... L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL) {
        try {
            if (L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.length > 1) {
                if (L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[0].equals("macro")) {
                    if (L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[1].equals("add")) {
                        StringBuilder LLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL = new StringBuilder();
                        int \u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445LL = 3;
                        if (\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445LL < L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.length) {
                            LLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.append(L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445LL]).append(" ");
                            ++\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445LL;
                            return;
                        }
                        Destroy.instance.macroManager.addMacro(new Macro(Keyboard.getKeyIndex(L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[2].toUpperCase()), LLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.toString()));
                        ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Added macros for key" + (Object)((Object)ChatFormatting.RED) + " \"" + L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[2].toUpperCase() + (Object)((Object)ChatFormatting.RED) + "\" " + (Object)((Object)ChatFormatting.WHITE) + "with value " + (Object)((Object)ChatFormatting.RED) + LLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL);
                        NotificationManager.publicity("Macro Manager", (Object)((Object)ChatFormatting.GREEN) + "Added macro for key" + (Object)((Object)ChatFormatting.RED) + " \"" + L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[2].toUpperCase() + (Object)((Object)ChatFormatting.RED) + "\" " + (Object)((Object)ChatFormatting.WHITE) + "with value " + (Object)((Object)ChatFormatting.RED) + LLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL, 4, NotificationType.SUCCESS);
                    }
                    if (L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[1].equals("clear")) {
                        if (Destroy.instance.macroManager.getMacros().isEmpty()) {
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Your macros list is empty!");
                            NotificationManager.publicity("Macro Manager", "Your macro list is empty!", 4, NotificationType.ERROR);
                            return;
                        }
                        Destroy.instance.macroManager.getMacros().clear();
                        ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Your macros list " + (Object)((Object)ChatFormatting.WHITE) + " successfully cleared!");
                        NotificationManager.publicity("Macro Manager", (Object)((Object)ChatFormatting.GREEN) + "Your macros list " + (Object)((Object)ChatFormatting.WHITE) + " successfully cleared!", 4, NotificationType.SUCCESS);
                    }
                    if (L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[1].equals("remove")) {
                        Destroy.instance.macroManager.deleteMacroByKey(Keyboard.getKeyIndex(L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[2].toUpperCase()));
                        ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Macro " + (Object)((Object)ChatFormatting.WHITE) + "was deleted from key " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[2].toUpperCase() + "\"");
                        NotificationManager.publicity("Macro Manager", (Object)((Object)ChatFormatting.GREEN) + "Macro " + (Object)((Object)ChatFormatting.WHITE) + "was deleted from key " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[2].toUpperCase() + "\"", 4, NotificationType.SUCCESS);
                    }
                    if (L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL[1].equals("list")) {
                        if (Destroy.instance.macroManager.getMacros().isEmpty()) {
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Your macros list is empty!");
                            NotificationManager.publicity("Macro Manager", "Your macros list is empty!", 4, NotificationType.ERROR);
                            return;
                        }
                        Destroy.instance.macroManager.getMacros().forEach(LLLLLL\u0445\u0445L\u0445\u0445\u0445LL -> ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Macros list: " + (Object)((Object)ChatFormatting.WHITE) + "Macros Name: " + (Object)((Object)ChatFormatting.RED) + LLLLLL\u0445\u0445L\u0445\u0445\u0445LL.getValue() + (Object)((Object)ChatFormatting.WHITE) + ", Macro Bind: " + (Object)((Object)ChatFormatting.RED) + Keyboard.getKeyName(LLLLLL\u0445\u0445L\u0445\u0445\u0445LL.getKey())));
                    }
                }
            } else {
                MacroCommand \u0445LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL;
                ChatHelper.addChatMessage(\u0445LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.getUsage());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

