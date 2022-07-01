/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javafx.scene.effect.Glow
 */
package org.Destroy.client.helpers.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import javafx.scene.effect.Glow;
import net.minecraft.util.text.TextComponentString;
import org.Destroy.client.helpers.Helper;

public class ChatHelper
implements Helper {
    public static String chatPrefix = "\u00a77[" + (Object)((Object)ChatFormatting.WHITE) + "Destroy Squad\u00a77] " + (Object)((Object)ChatFormatting.RESET);

    public ChatHelper() {
        ChatHelper L\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL;
    }

    public static void addChatMessage(String L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL) {
        Glow \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL = new Glow();
        ChatHelper.mc.player.addChatMessage(new TextComponentString(chatPrefix + L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL));
    }
}

