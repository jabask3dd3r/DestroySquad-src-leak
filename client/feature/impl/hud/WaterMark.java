/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.hud;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender2D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.misc.NameProtected;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.Destroy.client.ui.font.MCFontRenderer;

public final class WaterMark
extends Feature {
    private final MCFontRenderer font = new MCFontRenderer(new Font("Arial Black", 0, 26), true, true);
    private final MCFontRenderer font1 = new MCFontRenderer(new Font("Arial Black", 0, 19), true, true);
    private final ColorSetting color = new ColorSetting("Color", Color.WHITE.getRGB(), () -> true);
    private final ColorSetting bgColor = new ColorSetting("Backgrounds Color", Integer.MIN_VALUE, () -> true);
    private final NumberSetting xPosition = new NumberSetting("X Position", 5.0f, 0.0f, 500.0f, 5.0f, () -> true);
    private final NumberSetting yPosition = new NumberSetting("Y Position", 5.0f, 0.0f, 500.0f, 5.0f, () -> true);
    public static BooleanSetting name;
    public static ListSetting mode;
    public static NumberSetting speed;
    public static NumberSetting motionUp;
    public static NumberSetting boostSpeed;
    public static NumberSetting boostTicks;
    public static BooleanSetting boost;
    public static BlockPos blockPosIMP;
    public boolean start = false;
    public NumberSetting speedt;
    String server;
    String local;
    String tag;
    public String name1 = "Destroy ";
    public String type = "Squad";

    public WaterMark() {
        super("WaterMark", "WaterMark of the hack", Type.Hud);
        WaterMark \u0445L\u0445\u0445LL\u0445LL\u0445LL\u0445LL;
        mode = new ListSetting("Mods", "NeverLose", () -> true, "DestroySquad", "NeverLose");
        \u0445L\u0445\u0445LL\u0445LL\u0445LL\u0445LL.addSettings(\u0445L\u0445\u0445LL\u0445LL\u0445LL\u0445LL.color, \u0445L\u0445\u0445LL\u0445LL\u0445LL\u0445LL.bgColor, \u0445L\u0445\u0445LL\u0445LL\u0445LL\u0445LL.xPosition, \u0445L\u0445\u0445LL\u0445LL\u0445LL\u0445LL.yPosition, mode);
    }

    @EventTarget
    public void onRender2D(EventRender2D LL\u0445LL\u0445\u0445LL\u0445LL\u0445LL) {
        WaterMark \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL;
        Vec2f \u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL = new Vec2f(\u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.xPosition.getNumberValue(), \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.yPosition.getNumberValue());
        String L\u0445\u0445LL\u0445\u0445LL\u0445LL\u0445LL = (Destroy.instance.name + " Squad 1.6").toUpperCase();
        float \u0445\u0445\u0445LL\u0445\u0445LL\u0445LL\u0445LL = 2.0f;
        float LLL\u0445L\u0445\u0445LL\u0445LL\u0445LL = 1.0f;
        if (WaterMark.mode.currentMode.equals("DestroySquad")) {
            Gui.drawRect(\u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.x, \u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.y, \u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.x + (float)\u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.font.getStringWidth(L\u0445\u0445LL\u0445\u0445LL\u0445LL\u0445LL) + 2.0f, \u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.y + (float)\u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.font.getFontHeight() + 1.0f, \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.bgColor.getColorValue());
            \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.font.drawStringWithShadow(L\u0445\u0445LL\u0445\u0445LL\u0445LL\u0445LL, \u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.x + 1.0f, \u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.y + 1.0f + 0.5f, \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.color.getColorValue());
            \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.server = WaterMark.mc.getCurrentServerData().serverIP.toLowerCase();
            String[] \u0445\u0445L\u0445\u0445L\u0445LL\u0445LL\u0445LL = new String[]{"server: " + \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.server, "name: " + (Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.ownName.getBoolValue() ? "Protected" : WaterMark.mc.player.getName())};
            float LL\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL = 4.0f;
            float \u0445L\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL = 4.0f;
            float L\u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL = 0.0f;
            Iterator \u0445\u0445LL\u0445\u0445\u0445LL\u0445LL\u0445LL = new ArrayList<String>(Arrays.asList(\u0445\u0445L\u0445\u0445L\u0445LL\u0445LL\u0445LL)).stream().sorted(Comparator.comparingInt(L\u0445\u0445L\u0445\u0445\u0445LL\u0445LL\u0445LL -> ClientHelper.getFontRender().getStringWidth((String)L\u0445\u0445L\u0445\u0445\u0445LL\u0445LL\u0445LL)).reversed()).collect(Collectors.toList()).iterator();
            if (\u0445\u0445LL\u0445\u0445\u0445LL\u0445LL\u0445LL.hasNext()) {
                String L\u0445L\u0445\u0445L\u0445LL\u0445LL\u0445LL = (String)\u0445\u0445LL\u0445\u0445\u0445LL\u0445LL\u0445LL.next();
                Gui.drawRect(\u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.x, \u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.y + L\u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL + (float)\u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.font.getFontHeight() + 1.0f, \u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.x + (float)ClientHelper.getFontRender().getStringWidth(L\u0445L\u0445\u0445L\u0445LL\u0445LL\u0445LL) + 4.0f, \u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.y + (float)\u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.font.getFontHeight() + 1.0f + L\u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL + (float)ClientHelper.getFontRender().getFontHeight() + 4.0f, \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.bgColor.getColorValue());
                ClientHelper.getFontRender().drawStringWithShadow(L\u0445L\u0445\u0445L\u0445LL\u0445LL\u0445LL, \u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.x + 2.0f, \u0445L\u0445LL\u0445\u0445LL\u0445LL\u0445LL.y + L\u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL + (float)\u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.font.getFontHeight() + 1.0f + 2.0f, \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.color.getColorValue());
                L\u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL += (float)ClientHelper.getFontRender().getFontHeight() + 4.0f;
                return;
            }
        }
        String \u0445LL\u0445L\u0445\u0445LL\u0445LL\u0445LL = WaterMark.mc.player.getName();
        if (WaterMark.mode.currentMode.equals("NeverLose")) {
            \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.server = WaterMark.mc.getCurrentServerData().serverIP.toLowerCase();
            StringBuilder \u0445LLLL\u0445\u0445LL\u0445LL\u0445LL = new StringBuilder().append(\u0445LL\u0445L\u0445\u0445LL\u0445LL\u0445LL).append(" | ");
            Minecraft L\u0445LLL\u0445\u0445LL\u0445LL\u0445LL = mc;
            String LLLLL\u0445\u0445LL\u0445LL\u0445LL = \u0445LLLL\u0445\u0445LL\u0445LL\u0445LL.append(Minecraft.getDebugFPS()).append(" fps | ").append(\u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.server).toString();
            \u0445LLLL\u0445\u0445LL\u0445LL\u0445LL = new StringBuilder().append("DESTROY SQUAD | ").append(\u0445LL\u0445L\u0445\u0445LL\u0445LL\u0445LL).append(" | ");
            L\u0445LLL\u0445\u0445LL\u0445LL\u0445LL = mc;
            String \u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL = \u0445LLLL\u0445\u0445LL\u0445LL\u0445LL.append(Minecraft.getDebugFPS()).append(" fps | ").append(\u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.server).toString();
            RectHelper.drawSmoothRect(5.0f, 6.0f, WaterMark.mc.sfuiFontRender.getStringWidth(\u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL) + 12, 18.0f, new Color(10, 10, 10, 255).getRGB());
            \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.font1.drawStringWithShadow("DESTROY SQUAD", 6.5, 9.0, ClientHelper.getClientColor().getRGB());
            \u0445\u0445LLL\u0445\u0445LL\u0445LL\u0445LL.font1.drawStringWithShadow("DESTROY SQUAD", 7.0, 8.5, -1);
            WaterMark.mc.sfuiFontRender.drawStringWithShadow("| " + LLLLL\u0445\u0445LL\u0445LL\u0445LL, 7 + WaterMark.mc.sfuiFontRender.getStringWidth("DESTROY SQUAD|"), 10.5, -1);
        }
    }
}

