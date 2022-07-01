/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd.impl;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Iterator;
import org.Destroy.client.Destroy;
import org.Destroy.client.cmd.CommandAbstract;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.settings.config.Config;
import org.Destroy.client.settings.config.ConfigManager;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;

public class ConfigCommand
extends CommandAbstract {
    public ConfigCommand() {
        super("config", "configurations", (Object)((Object)ChatFormatting.WHITE) + ".config" + (Object)((Object)ChatFormatting.DARK_AQUA) + " save | load | delete " + (Object)((Object)ChatFormatting.RED) + "<name>", "config");
        ConfigCommand \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L;
    }

    @Override
    public void execute(String ... L\u0445LLLLLLLLLL\u0445\u0445L) {
        try {
            if (L\u0445LLLLLLLLLL\u0445\u0445L.length >= 2) {
                String \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L = L\u0445LLLLLLLLLL\u0445\u0445L[1].toUpperCase();
                if (L\u0445LLLLLLLLLL\u0445\u0445L.length == 3) {
                    switch (\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L) {
                        case "LOAD": {
                            if (Destroy.instance.configManager.loadConfig(L\u0445LLLLLLLLLL\u0445\u0445L[2])) {
                                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "loaded config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"");
                                NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "loaded config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"", 4, NotificationType.SUCCESS);
                                break;
                            }
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "load config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"");
                            NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "load config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"", 4, NotificationType.ERROR);
                            break;
                        }
                        case "SAVE": {
                            if (Destroy.instance.configManager.saveConfig(L\u0445LLLLLLLLLL\u0445\u0445L[2])) {
                                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "saved config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"");
                                NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "saved config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"", 4, NotificationType.SUCCESS);
                                ConfigManager.getLoadedConfigs().clear();
                                Destroy.instance.configManager.load();
                                break;
                            }
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "to save config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"");
                            NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "to save config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"", 4, NotificationType.ERROR);
                            break;
                        }
                        case "DELETE": {
                            if (Destroy.instance.configManager.deleteConfig(L\u0445LLLLLLLLLL\u0445\u0445L[2])) {
                                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "deleted config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"");
                                NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "deleted config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"", 4, NotificationType.SUCCESS);
                                break;
                            }
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "to delete config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"");
                            NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "to delete config: " + (Object)((Object)ChatFormatting.RED) + "\"" + L\u0445LLLLLLLLLL\u0445\u0445L[2] + "\"", 4, NotificationType.ERROR);
                        }
                    }
                } else if (L\u0445LLLLLLLLLL\u0445\u0445L.length == 2 && \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L.equalsIgnoreCase("LIST")) {
                    ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Configs:");
                    Iterator L\u0445\u0445LLLLLLLLL\u0445\u0445L = Destroy.instance.configManager.getContents().iterator();
                    if (L\u0445\u0445LLLLLLLLL\u0445\u0445L.hasNext()) {
                        Config L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L = (Config)L\u0445\u0445LLLLLLLLL\u0445\u0445L.next();
                        ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L.getName());
                        return;
                    }
                }
            } else {
                ConfigCommand \u0445LLLLLLLLLLL\u0445\u0445L;
                ChatHelper.addChatMessage(\u0445LLLLLLLLLLL\u0445\u0445L.getUsage());
            }
        }
        catch (Exception LLLLLLLLLLLL\u0445\u0445L) {
            LLLLLLLLLLLL\u0445\u0445L.printStackTrace();
        }
    }
}

