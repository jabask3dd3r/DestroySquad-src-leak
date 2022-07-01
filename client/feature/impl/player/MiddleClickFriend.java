/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.entity.EntityLivingBase;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.friend.Friend;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;
import org.neverhook.client.event.events.impl.input.EventMouse;

public class MiddleClickFriend
extends Feature {
    public MiddleClickFriend() {
        super("MiddleClickFriend", "Adds a player to the friends list on mouse click", Type.Player);
        MiddleClickFriend L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L;
    }

    @EventTarget
    public void onMouseEvent(EventMouse L\u0445LLLLLLLLL\u0445\u0445\u0445L) {
        if (L\u0445LLLLLLLLL\u0445\u0445\u0445L.getKey() == 2 && MiddleClickFriend.mc.pointedEntity instanceof EntityLivingBase) {
            if (Destroy.instance.friendManager.getFriends().stream().anyMatch(\u0445L\u0445LLLLLLLL\u0445\u0445\u0445L -> \u0445L\u0445LLLLLLLL\u0445\u0445\u0445L.getName().equals(MiddleClickFriend.mc.pointedEntity.getName()))) {
                Destroy.instance.friendManager.getFriends().remove(Destroy.instance.friendManager.getFriend(MiddleClickFriend.mc.pointedEntity.getName()));
                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Removed " + (Object)((Object)ChatFormatting.RESET) + "'" + MiddleClickFriend.mc.pointedEntity.getName() + "' as Friend!");
                NotificationManager.publicity("MCF", "Removed '" + MiddleClickFriend.mc.pointedEntity.getName() + "' as Friend!", 4, NotificationType.INFO);
            } else {
                Destroy.instance.friendManager.addFriend(new Friend(MiddleClickFriend.mc.pointedEntity.getName()));
                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Added " + (Object)((Object)ChatFormatting.RESET) + MiddleClickFriend.mc.pointedEntity.getName() + " as Friend!");
                NotificationManager.publicity("MCF", "Added " + MiddleClickFriend.mc.pointedEntity.getName() + " as Friend!", 4, NotificationType.SUCCESS);
            }
        }
    }
}

