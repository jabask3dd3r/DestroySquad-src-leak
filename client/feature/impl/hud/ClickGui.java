/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.hud;

import java.awt.Color;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class ClickGui
extends Feature {
    public static BooleanSetting background;
    public static BooleanSetting blur;
    public static ListSetting clickGuiColor;
    public static ColorSetting color;
    public static ColorSetting colorTwo;
    public static NumberSetting speed;
    public static BooleanSetting enableScroll;
    public static NumberSetting scrollSpeed;
    public static BooleanSetting glow;
    public ListSetting mode = new ListSetting("ClickGui Mode", "New", () -> true, "New");

    public ClickGui() {
        super("ClickGui", "Opens click gui cheat", Type.Hud);
        ClickGui \u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L\u0445L;
        \u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L\u0445L.setBind(54);
        color = new ColorSetting("Color One", new Color(77, 73, 73, 216).getRGB(), () -> ClickGui.clickGuiColor.currentMode.equals("Fade") || ClickGui.clickGuiColor.currentMode.equals("Color Two") || ClickGui.clickGuiColor.currentMode.equals("Static"));
        colorTwo = new ColorSetting("Color Two", new Color(239, 19, 83, 216).getRGB(), () -> ClickGui.clickGuiColor.currentMode.equals("Color Two"));
        background = new BooleanSetting("Background", true, () -> true);
        \u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L\u0445L.addSettings(\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L\u0445L.mode, enableScroll, scrollSpeed, clickGuiColor, color, colorTwo, speed, background, blur, glow);
    }

    @Override
    public void onEnable() {
        ClickGui L\u0445LL\u0445LL\u0445\u0445L\u0445\u0445L\u0445L;
        if (L\u0445LL\u0445LL\u0445\u0445L\u0445\u0445L\u0445L.mode.currentMode.equals("New")) {
            mc.displayGuiScreen(Destroy.instance.newClickGui);
        } else if (L\u0445LL\u0445LL\u0445\u0445L\u0445\u0445L\u0445L.mode.currentMode.equals("Old")) {
            mc.displayGuiScreen(Destroy.instance.clickGui);
        }
        Destroy.instance.featureManager.getFeatureByClass(ClickGui.class).setState(false);
        super.onEnable();
    }

    static {
        blur = new BooleanSetting("Blur", true, () -> true);
        clickGuiColor = new ListSetting("ClickGui Color", "Client", () -> true, "Astolfo", "Rainbow", "Static", "Color Two", "Client", "Fade");
        speed = new NumberSetting("Speed", 45.0f, 10.0f, 100.0f, 1.0f, () -> true);
        enableScroll = new BooleanSetting("Enable Scroll", true, () -> true);
        scrollSpeed = new NumberSetting("ScrollSpeed", 60.0f, 1.0f, 100.0f, 1.0f, () -> enableScroll.getBoolValue());
        glow = new BooleanSetting("Glow Effect", false, () -> true);
    }
}

