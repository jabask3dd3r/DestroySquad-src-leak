/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.hud;

import java.awt.Color;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.math.Vec2f;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender2D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.hud.HUD;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public final class FeatureList
extends Feature {
    public static final NumberSetting rainbowSaturation = new NumberSetting("Rainbow Saturation", 0.8f, 0.1f, 1.0f, 0.1f, () -> HUD.colorList.currentMode.equals("Rainbow"));
    public static final NumberSetting rainbowBright = new NumberSetting("Rainbow Bright", 1.0f, 0.1f, 1.0f, 0.1f, () -> HUD.colorList.currentMode.equals("Rainbow"));
    private final ColorSetting bgColor = new ColorSetting("Background Color", Integer.MIN_VALUE, () -> true);
    private final NumberSetting lineThickness = new NumberSetting("Line Thickness", 1.0f, 0.0f, 5.0f, 0.1f, () -> true);
    private final NumberSetting xOffset = new NumberSetting("X Offset", 4.0f, 0.0f, 50.0f, 0.25f, () -> true);
    private final NumberSetting yOffset = new NumberSetting("Y Offset", 3.0f, 0.0f, 50.0f, 0.25f, () -> true);
    private final NumberSetting xPosition = new NumberSetting("X Position", 0.0f, 0.0f, 500.0f, 5.0f, () -> true);
    private final NumberSetting yPosition = new NumberSetting("Y Position", 40.0f, 0.0f, 500.0f, 5.0f, () -> true);
    public static ListSetting sortMode;
    public static ListSetting fontRenderType;
    public static ListSetting borderMode;
    public static BooleanSetting backGround;
    public static BooleanSetting backGroundGradient;
    public static ColorSetting backGroundColor2;
    public static ColorSetting backGroundColor;
    public static BooleanSetting border;
    public static BooleanSetting rightBorder;
    public static NumberSetting x;
    public static NumberSetting y;
    public static NumberSetting offset;
    public static NumberSetting size;
    public static NumberSetting fontX;
    public static NumberSetting fontY;
    public static BooleanSetting blur;
    public static BooleanSetting suffix;
    public static ListSetting colorSuffixMode;
    public static ColorSetting suffixColor;
    public static ListSetting position;

    public FeatureList() {
        super("FeatureList", "View all actives modules", Type.Hud);
        FeatureList \u0445LLLLL\u0445\u0445\u0445LLL;
        \u0445LLLLL\u0445\u0445\u0445LLL.addSettings(\u0445LLLLL\u0445\u0445\u0445LLL.bgColor, \u0445LLLLL\u0445\u0445\u0445LLL.lineThickness, \u0445LLLLL\u0445\u0445\u0445LLL.xOffset, \u0445LLLLL\u0445\u0445\u0445LLL.yOffset, \u0445LLLLL\u0445\u0445\u0445LLL.xPosition, \u0445LLLLL\u0445\u0445\u0445LLL.yPosition);
    }

    @EventTarget
    public void onRender2D(EventRender2D L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL) {
        FeatureList \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL;
        Vec2f \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL = new Vec2f(\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.xPosition.getNumberValue(), \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.yPosition.getNumberValue());
        List LLLL\u0445L\u0445\u0445\u0445LLL = Destroy.instance.featureManager.getFeatureList().stream().filter(L\u0445\u0445LL\u0445\u0445\u0445\u0445LLL -> L\u0445\u0445LL\u0445\u0445\u0445\u0445LLL.getState()).sorted(Comparator.comparingInt(\u0445\u0445LLL\u0445\u0445\u0445\u0445LLL -> ClientHelper.getFontRender().getStringWidth(((Feature)\u0445\u0445LLL\u0445\u0445\u0445\u0445LLL).getSuffix().toLowerCase())).reversed()).collect(Collectors.toList());
        Gui.drawRect((float)(L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.getResolution().getScaledWidth() - ClientHelper.getFontRender().getStringWidth(((Feature)LLLL\u0445L\u0445\u0445\u0445LLL.get(0)).getSuffix().toLowerCase().replace("- ", "\u00a77"))) - \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.xOffset.getNumberValue() - \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.x, \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.y, (float)L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.getResolution().getScaledWidth() - \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.x, \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.y + \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.lineThickness.getNumberValue(), \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.getMainColor(0));
        float \u0445LLL\u0445L\u0445\u0445\u0445LLL = \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.yOffset.getNumberValue() / 2.0f + \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.lineThickness.getNumberValue();
        Iterator \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLL = LLLL\u0445L\u0445\u0445\u0445LLL.iterator();
        if (\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLL.hasNext()) {
            Feature LL\u0445\u0445LL\u0445\u0445\u0445LLL = (Feature)\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLL.next();
            String \u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = LL\u0445\u0445LL\u0445\u0445\u0445LLL.getSuffix().toLowerCase().replace("- ", "\u00a77");
            Gui.drawRect((float)(L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.getResolution().getScaledWidth() - ClientHelper.getFontRender().getStringWidth(\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL)) - \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.x - \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.xOffset.getNumberValue(), \u0445LLL\u0445L\u0445\u0445\u0445LLL + \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.y - \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.yOffset.getNumberValue() / 2.0f, (float)L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.getResolution().getScaledWidth() - \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.x, \u0445LLL\u0445L\u0445\u0445\u0445LLL + \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.y + (float)ClientHelper.getFontRender().getFontHeight() + 1.0f + \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.yOffset.getNumberValue() / 2.0f, \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.bgColor.getColorValue());
            ClientHelper.getFontRender().drawStringWithShadow(\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL, (float)(L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.getResolution().getScaledWidth() - ClientHelper.getFontRender().getStringWidth(\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL)) - \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.x - \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.xOffset.getNumberValue() / 2.0f - 0.1f, \u0445LLL\u0445L\u0445\u0445\u0445LLL + \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.y + 0.8f, \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.getMainColor((int)\u0445LLL\u0445L\u0445\u0445\u0445LLL));
            \u0445LLL\u0445L\u0445\u0445\u0445LLL += (float)(ClientHelper.getFontRender().getFontHeight() + 1) + \u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.yOffset.getNumberValue();
            return;
        }
    }

    private int getMainColor(int L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLL) {
        switch (HUD.colorList.currentMode) {
            case "Astolfo": {
                return PaletteHelper.astolfo(false, L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLL * 10).getRGB();
            }
            case "Fade": {
                return PaletteHelper.fadeColor(HUD.onecolor.getColorValue(), new Color(HUD.onecolor.getColorValue()).darker().darker().getRGB(), (float)Math.abs(Math.sin((double)(System.currentTimeMillis() + (long)L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLL * 30L) / 1000.0)));
            }
            case "Rainbow": {
                return PaletteHelper.rainbow(L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLL * 10, rainbowSaturation.getNumberValue(), rainbowBright.getNumberValue()).getRGB();
            }
            case "Custom": {
                return PaletteHelper.fadeColor(HUD.onecolor.getColorValue(), HUD.twocolor.getColorValue(), (float)Math.abs(Math.sin((double)(System.currentTimeMillis() + (long)L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLL * 30L) / 1000.0)));
            }
        }
        return ClientHelper.getClientColor().getRGB();
    }

    static {
        backGroundGradient = new BooleanSetting("BackGround Gradient", false, () -> backGround.getBoolValue());
        backGroundColor2 = new ColorSetting("BackGround Color Two", Color.BLACK.getRGB(), () -> backGround.getBoolValue() && backGroundGradient.getBoolValue());
        backGroundColor = new ColorSetting("BackGround Color", Color.BLACK.getRGB(), () -> backGround.getBoolValue());
        blur = new BooleanSetting("Blur", false, () -> backGround.getBoolValue());
        colorSuffixMode = new ListSetting("Suffix Mode Color", "Default", () -> suffix.getBoolValue(), "Astolfo", "Default", "Static", "Rainbow", "Custom", "Category");
        suffixColor = new ColorSetting("Suffix Color", Color.GRAY.getRGB(), () -> FeatureList.colorSuffixMode.currentMode.equals("Custom") || FeatureList.colorSuffixMode.currentMode.equals("Static") && suffix.getBoolValue());
        position = new ListSetting("Position", "Right", () -> true, "Right", "Left");
    }
}

