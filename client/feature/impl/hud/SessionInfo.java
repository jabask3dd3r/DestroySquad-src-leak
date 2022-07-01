/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.hud;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender2D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.impl.ListSetting;

public class SessionInfo
extends Feature {
    public static ListSetting theme;

    public SessionInfo() {
        super("SessionInfo", "Shows information on the screen", Type.Hud);
        SessionInfo L\u0445LLLLL\u0445\u0445L\u0445LLL;
        theme = new ListSetting("Mods", "Dark", () -> true, "Dark");
        L\u0445LLLLL\u0445\u0445L\u0445LLL.addSettings(theme);
    }

    @EventTarget
    public void ebatkopat(EventRender2D L\u0445LL\u0445LL\u0445\u0445L\u0445LLL) {
        String \u0445\u0445LL\u0445LL\u0445\u0445L\u0445LLL = mc.isSingleplayer() ? "local" : SessionInfo.mc.getCurrentServerData().serverIP.toLowerCase();
        String LL\u0445L\u0445LL\u0445\u0445L\u0445LLL = "Name: " + SessionInfo.mc.player.getName();
        int \u0445L\u0445L\u0445LL\u0445\u0445L\u0445LLL = -1;
        int L\u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL = -1;
        int \u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL = -1;
        if (SessionInfo.theme.currentMode.equals("Dark")) {
            \u0445L\u0445L\u0445LL\u0445\u0445L\u0445LLL = -1;
            L\u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL = new Color(33, 33, 33, 215).getRGB();
            \u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL = new Color(33, 33, 33, 145).getRGB();
        }
        double LLL\u0445\u0445LL\u0445\u0445L\u0445LLL = SessionInfo.mc.player.posZ - SessionInfo.mc.player.prevPosZ;
        double \u0445LL\u0445\u0445LL\u0445\u0445L\u0445LLL = SessionInfo.mc.player.posX - SessionInfo.mc.player.prevPosX;
        double L\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL = Math.sqrt(\u0445LL\u0445\u0445LL\u0445\u0445L\u0445LLL * \u0445LL\u0445\u0445LL\u0445\u0445L\u0445LLL + LLL\u0445\u0445LL\u0445\u0445L\u0445LLL * LLL\u0445\u0445LL\u0445\u0445L\u0445LLL);
        double \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL = L\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL * 15.3571428571;
        float LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL = SessionInfo.mc.robotoRegularFontRender.getStringWidth(LL\u0445L\u0445LL\u0445\u0445L\u0445LLL);
        float \u0445L\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL = SessionInfo.mc.robotoRegularFontRender.getStringWidth("IP: " + \u0445\u0445LL\u0445LL\u0445\u0445L\u0445LLL);
        String L\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        RectHelper.drawRect(5.0, 60.0, (LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL > \u0445L\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL ? LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL : \u0445L\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL) + 45.0f, 115.0, \u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL);
        RectHelper.drawRect(5.0, 63.0, (LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL > \u0445L\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL ? LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL : \u0445L\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL) + 45.0f, 51.0, L\u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL);
        RectHelper.drawGradientRect(5.0, 60.0, (LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL > \u0445L\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL ? LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL : \u0445L\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL) + 60.0f, 59.0, new Color(1, 1, 1, 90).getRGB(), new Color(0, 0, 0, 0).getRGB());
        String \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL = String.format("%.1f bps", \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL);
        SessionInfo.mc.robotoRegularFontRender.drawString("SESSION INFO", 49.0f, 54.0f, -1);
        SessionInfo.mc.clickguismall.drawString("Time: " + L\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL, 7.0f, 68.0f, \u0445L\u0445L\u0445LL\u0445\u0445L\u0445LLL);
        SessionInfo.mc.clickguismall.drawString("Move Speed: " + \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL, 7.0f, 79.0f, \u0445L\u0445L\u0445LL\u0445\u0445L\u0445LLL);
        SessionInfo.mc.clickguismall.drawString(LL\u0445L\u0445LL\u0445\u0445L\u0445LLL, 7.0f, 91.9f, \u0445L\u0445L\u0445LL\u0445\u0445L\u0445LLL);
        SessionInfo.mc.clickguismall.drawString("IP: " + \u0445\u0445LL\u0445LL\u0445\u0445L\u0445LLL, 7.0f, 104.0f, \u0445L\u0445L\u0445LL\u0445\u0445L\u0445LLL);
    }

    @Override
    public void onEnable() {
        SessionInfo L\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445LLL;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        SessionInfo \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL;
        super.onDisable();
    }
}

