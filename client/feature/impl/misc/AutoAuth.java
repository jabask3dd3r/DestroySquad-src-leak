/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventReceiveMessage;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;

public class AutoAuth
extends Feature {
    public static String password = "dontscamMamontsS44";

    public AutoAuth() {
        super("AutoAuth", "Automatics Register in servers", Type.Misc);
        AutoAuth LL\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL;
    }

    @EventTarget
    public void onReceiveMessage(EventReceiveMessage LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL) {
        if (LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL.getMessage().contains("/reg") || LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL.getMessage().contains("/register") || LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL.getMessage().contains("?????????????????")) {
            AutoAuth.mc.player.sendChatMessage("/reg " + password + " " + password);
            ChatHelper.addChatMessage("Your password: " + (Object)((Object)ChatFormatting.RED) + password);
            NotificationManager.publicity("AutoAuth", "You are successfully registered!", 4, NotificationType.SUCCESS);
        } else if (LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL.getMessage().contains("?????????????") || LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL.getMessage().contains("/l")) {
            AutoAuth.mc.player.sendChatMessage("/login " + password);
            NotificationManager.publicity("AutoAuth", "You are successfully login!", 4, NotificationType.SUCCESS);
        }
    }
}

