/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.notification;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.helpers.render.ScreenHelper;
import org.Destroy.client.ui.notification.NotificationType;

public class Notification
implements Helper {
    private final ScreenHelper screenHelper;
    private final FontRenderer fontRenderer;
    private final String title;
    private final String content;
    private final int time;
    private final NotificationType type;
    private final TimerHelper timer;

    public Notification(String \u0445LLL\u0445L\u0445LLL, String L\u0445LL\u0445L\u0445LLL, NotificationType \u0445\u0445LL\u0445L\u0445LLL, int LL\u0445L\u0445L\u0445LLL, FontRenderer \u0445L\u0445L\u0445L\u0445LLL) {
        Notification LLLL\u0445L\u0445LLL;
        LLLL\u0445L\u0445LLL.title = \u0445LLL\u0445L\u0445LLL;
        LLLL\u0445L\u0445LLL.content = L\u0445LL\u0445L\u0445LLL;
        LLLL\u0445L\u0445LLL.time = LL\u0445L\u0445L\u0445LLL;
        LLLL\u0445L\u0445LLL.type = \u0445\u0445LL\u0445L\u0445LLL;
        LLLL\u0445L\u0445LLL.timer = new TimerHelper();
        LLLL\u0445L\u0445LLL.fontRenderer = \u0445L\u0445L\u0445L\u0445LLL;
        ScaledResolution L\u0445\u0445L\u0445L\u0445LLL = new ScaledResolution(mc);
        LLLL\u0445L\u0445LLL.screenHelper = new ScreenHelper(L\u0445\u0445L\u0445L\u0445LLL.getScaledWidth() - LLLL\u0445L\u0445LLL.getWidth() + LLLL\u0445L\u0445LLL.getWidth(), L\u0445\u0445L\u0445L\u0445LLL.getScaledHeight() - 60);
    }

    public int getWidth() {
        Notification \u0445\u0445\u0445\u0445\u0445L\u0445LLL;
        return Math.max(100, Math.max(\u0445\u0445\u0445\u0445\u0445L\u0445LLL.fontRenderer.getStringWidth(\u0445\u0445\u0445\u0445\u0445L\u0445LLL.title), \u0445\u0445\u0445\u0445\u0445L\u0445LLL.fontRenderer.getStringWidth(\u0445\u0445\u0445\u0445\u0445L\u0445LLL.content)) + 40);
    }

    public String getTitle() {
        Notification L\u0445LLL\u0445\u0445LLL;
        return L\u0445LLL\u0445\u0445LLL.title;
    }

    public String getContent() {
        Notification \u0445L\u0445LL\u0445\u0445LLL;
        return \u0445L\u0445LL\u0445\u0445LLL.content;
    }

    public int getTime() {
        Notification LLL\u0445L\u0445\u0445LLL;
        return LLL\u0445L\u0445\u0445LLL.time;
    }

    public NotificationType getType() {
        Notification \u0445\u0445L\u0445L\u0445\u0445LLL;
        return \u0445\u0445L\u0445L\u0445\u0445LLL.type;
    }

    public TimerHelper getTimer() {
        Notification L\u0445\u0445\u0445L\u0445\u0445LLL;
        return L\u0445\u0445\u0445L\u0445\u0445LLL.timer;
    }

    public ScreenHelper getTranslate() {
        Notification \u0445LLL\u0445\u0445\u0445LLL;
        return \u0445LLL\u0445\u0445\u0445LLL.screenHelper;
    }
}

