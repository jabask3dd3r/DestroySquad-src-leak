/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd.impl;

import com.mojang.realmsclient.gui.ChatFormatting;
import org.Destroy.client.Destroy;
import org.Destroy.client.cmd.CommandAbstract;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;
import org.lwjgl.input.Keyboard;

public class BindCommand
extends CommandAbstract {
    public BindCommand() {
        super("bind", "bind", ".bind" + (Object)((Object)ChatFormatting.DARK_AQUA) + " add // remove <name> <key> ", ".bind" + (Object)((Object)ChatFormatting.DARK_AQUA) + " add // remove <name> <key> " + (Object)((Object)ChatFormatting.DARK_AQUA) + "clear", "bind");
        BindCommand \u0445LLL\u0445\u0445LLLLLL;
    }

    @Override
    public void execute(String ... L\u0445\u0445\u0445\u0445\u0445LLLLLL) {
        try {
            if (L\u0445\u0445\u0445\u0445\u0445LLLLLL.length == 4) {
                String L\u0445L\u0445\u0445\u0445LLLLLL = L\u0445\u0445\u0445\u0445\u0445LLLLLL[2];
                String \u0445\u0445L\u0445\u0445\u0445LLLLLL = L\u0445\u0445\u0445\u0445\u0445LLLLLL[3].toUpperCase();
                Feature LL\u0445\u0445\u0445\u0445LLLLLL = Destroy.instance.featureManager.getFeatureByLabel(L\u0445L\u0445\u0445\u0445LLLLLL);
                if (L\u0445\u0445\u0445\u0445\u0445LLLLLL[0].equals("bind")) {
                    switch (L\u0445\u0445\u0445\u0445\u0445LLLLLL[1]) {
                        case "add": {
                            LL\u0445\u0445\u0445\u0445LLLLLL.setBind(Keyboard.getKeyIndex(\u0445\u0445L\u0445\u0445\u0445LLLLLL));
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + LL\u0445\u0445\u0445\u0445LLLLLL.getLabel() + (Object)((Object)ChatFormatting.WHITE) + " was set on key " + (Object)((Object)ChatFormatting.RED) + "\"" + \u0445\u0445L\u0445\u0445\u0445LLLLLL + "\"");
                            NotificationManager.publicity("Bind Manager", (Object)((Object)ChatFormatting.GREEN) + LL\u0445\u0445\u0445\u0445LLLLLL.getLabel() + (Object)((Object)ChatFormatting.WHITE) + " was set on key " + (Object)((Object)ChatFormatting.RED) + "\"" + \u0445\u0445L\u0445\u0445\u0445LLLLLL + "\"", 4, NotificationType.SUCCESS);
                            break;
                        }
                        case "remove": {
                            LL\u0445\u0445\u0445\u0445LLLLLL.setBind(0);
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + LL\u0445\u0445\u0445\u0445LLLLLL.getLabel() + (Object)((Object)ChatFormatting.WHITE) + " bind was deleted from key " + (Object)((Object)ChatFormatting.RED) + "\"" + \u0445\u0445L\u0445\u0445\u0445LLLLLL + "\"");
                            NotificationManager.publicity("Bind Manager", (Object)((Object)ChatFormatting.GREEN) + LL\u0445\u0445\u0445\u0445LLLLLL.getLabel() + (Object)((Object)ChatFormatting.WHITE) + " bind was deleted from key " + (Object)((Object)ChatFormatting.RED) + "\"" + \u0445\u0445L\u0445\u0445\u0445LLLLLL + "\"", 4, NotificationType.SUCCESS);
                            break;
                        }
                        case "clear": {
                            if (LL\u0445\u0445\u0445\u0445LLLLLL.getLabel().equals("ClickGui")) break;
                            LL\u0445\u0445\u0445\u0445LLLLLL.setBind(0);
                            break;
                        }
                        case "list": {
                            if (LL\u0445\u0445\u0445\u0445LLLLLL.getBind() == 0) {
                                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Your macros list is empty!");
                                NotificationManager.publicity("Macro Manager", "Your macros list is empty!", 4, NotificationType.ERROR);
                                return;
                            }
                            Destroy.instance.featureManager.getFeatureList().forEach(\u0445\u0445\u0445LLL\u0445LLLLL -> ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Binds list: " + (Object)((Object)ChatFormatting.WHITE) + "Binds Name: " + (Object)((Object)ChatFormatting.RED) + \u0445\u0445\u0445LLL\u0445LLLLL.getBind() + (Object)((Object)ChatFormatting.WHITE) + ", Macro Bind: " + (Object)((Object)ChatFormatting.RED) + Keyboard.getKeyName(\u0445\u0445\u0445LLL\u0445LLLLL.getBind())));
                        }
                    }
                }
            } else {
                BindCommand \u0445L\u0445\u0445\u0445\u0445LLLLLL;
                ChatHelper.addChatMessage(\u0445L\u0445\u0445\u0445\u0445LLLLLL.getUsage());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

