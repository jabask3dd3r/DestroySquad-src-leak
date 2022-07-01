/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.notification;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.text.TextFormatting;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.impl.hud.HUD;
import org.Destroy.client.feature.impl.hud.Notifications;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.render.ScreenHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.ui.notification.Notification;
import org.Destroy.client.ui.notification.NotificationType;

public class NotificationManager
implements Helper {
    private static final List<Notification> notifications = new CopyOnWriteArrayList<Notification>();

    public NotificationManager() {
        NotificationManager \u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL;
    }

    public static void publicity(String LLLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL, String \u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL, int L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL, NotificationType \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL) {
        FontRenderer LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL = NotificationManager.mc.fontRendererObj;
        notifications.add(new Notification(LLLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL, \u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL, \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL, L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL * 1000, LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL));
    }

    public static void renderNotification(ScaledResolution LL\u0445\u0445LLLLLLL\u0445\u0445LL) {
        if (Destroy.instance.featureManager.getFeatureByClass(Notifications.class).getState() && !notifications.isEmpty()) {
            int \u0445LL\u0445LLLLLLL\u0445\u0445LL = LL\u0445\u0445LLLLLLL\u0445\u0445LL.getScaledHeight();
            int L\u0445L\u0445LLLLLLL\u0445\u0445LL = LL\u0445\u0445LLLLLLL\u0445\u0445LL.getScaledWidth() + 10;
            int \u0445\u0445L\u0445LLLLLLL\u0445\u0445LL = \u0445LL\u0445LLLLLLL\u0445\u0445LL - 60;
            Iterator<Notification> \u0445LLL\u0445LLLLLL\u0445\u0445LL = notifications.iterator();
            if (\u0445LLL\u0445LLLLLL\u0445\u0445LL.hasNext()) {
                Notification LLL\u0445LLLLLLL\u0445\u0445LL = \u0445LLL\u0445LLLLLL\u0445\u0445LL.next();
                ScreenHelper LL\u0445LLLLLLLL\u0445\u0445LL = LLL\u0445LLLLLLL\u0445\u0445LL.getTranslate();
                int \u0445L\u0445LLLLLLLL\u0445\u0445LL = LLL\u0445LLLLLLL\u0445\u0445LL.getWidth() + 40 + NotificationManager.mc.fontRendererObj.getStringWidth(LLL\u0445LLLLLLL\u0445\u0445LL.getContent()) / 2;
                if (!LLL\u0445LLLLLLL\u0445\u0445LL.getTimer().hasReached(LLL\u0445LLLLLLL\u0445\u0445LL.getTime() - 100)) {
                    LL\u0445LLLLLLLL\u0445\u0445LL.calculateCompensation(L\u0445L\u0445LLLLLLL\u0445\u0445LL - \u0445L\u0445LLLLLLLL\u0445\u0445LL, \u0445\u0445L\u0445LLLLLLL\u0445\u0445LL, 0.12f, 5.0f);
                } else {
                    LL\u0445LLLLLLLL\u0445\u0445LL.calculateCompensation(L\u0445L\u0445LLLLLLL\u0445\u0445LL, LLL\u0445LLLLLLL\u0445\u0445LL.getTranslate().getY(), 0.12f, 5.0f);
                    if (NotificationManager.mc.player != null && NotificationManager.mc.world != null && LLL\u0445LLLLLLL\u0445\u0445LL.getTimer().getTime() > (long)(LLL\u0445LLLLLLL\u0445\u0445LL.getTime() + 500)) {
                        notifications.remove(LLL\u0445LLLLLLL\u0445\u0445LL);
                    }
                }
                float L\u0445\u0445LLLLLLLL\u0445\u0445LL = LL\u0445LLLLLLLL\u0445\u0445LL.getX();
                float \u0445\u0445\u0445LLLLLLLL\u0445\u0445LL = LL\u0445LLLLLLLL\u0445\u0445LL.getY();
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                RectHelper.drawRect(L\u0445\u0445LLLLLLLL\u0445\u0445LL, \u0445\u0445\u0445LLLLLLLL\u0445\u0445LL, L\u0445\u0445LLLLLLLL\u0445\u0445LL - 2.0f, \u0445\u0445\u0445LLLLLLLL\u0445\u0445LL + 28.0f, ClientHelper.getClientColor().getRGB());
                RectHelper.drawRect(L\u0445\u0445LLLLLLLL\u0445\u0445LL, \u0445\u0445\u0445LLLLLLLL\u0445\u0445LL, L\u0445L\u0445LLLLLLL\u0445\u0445LL, \u0445\u0445\u0445LLLLLLLL\u0445\u0445LL + 28.0f, new Color(15, 14, 14, 200).getRGB());
                if (!HUD.font.currentMode.equals("Minecraft")) {
                    NotificationManager.mc.latoBig.drawStringWithShadow((Object)((Object)TextFormatting.BOLD) + LLL\u0445LLLLLLL\u0445\u0445LL.getTitle(), L\u0445\u0445LLLLLLLL\u0445\u0445LL + 5.0f, \u0445\u0445\u0445LLLLLLLL\u0445\u0445LL + 4.0f, -1);
                    NotificationManager.mc.latoFontRender.drawStringWithShadow(LLL\u0445LLLLLLL\u0445\u0445LL.getContent(), L\u0445\u0445LLLLLLLL\u0445\u0445LL + 5.0f, \u0445\u0445\u0445LLLLLLLL\u0445\u0445LL + 17.0f, new Color(245, 245, 245).getRGB());
                } else {
                    NotificationManager.mc.fontRendererObj.drawStringWithShadow((Object)((Object)TextFormatting.BOLD) + LLL\u0445LLLLLLL\u0445\u0445LL.getTitle(), L\u0445\u0445LLLLLLLL\u0445\u0445LL + 5.0f, \u0445\u0445\u0445LLLLLLLL\u0445\u0445LL + 4.0f, -1);
                    NotificationManager.mc.fontRendererObj.drawStringWithShadow(LLL\u0445LLLLLLL\u0445\u0445LL.getContent(), L\u0445\u0445LLLLLLLL\u0445\u0445LL + 5.0f, \u0445\u0445\u0445LLLLLLLL\u0445\u0445LL + 15.0f, new Color(245, 245, 245).getRGB());
                }
                GlStateManager.popMatrix();
                if (notifications.size() > 1) {
                    \u0445\u0445L\u0445LLLLLLL\u0445\u0445LL -= 35;
                }
                return;
            }
        }
    }
}

