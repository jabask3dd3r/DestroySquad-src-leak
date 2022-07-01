/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.hud;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.math.MathHelper;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender2D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.movement.Timer;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.Destroy.client.ui.components.draggable.DraggableModule;
import org.Destroy.client.ui.util.MathUtil;

public class HUD
extends Feature {
    public static float globalOffset;
    public static ListSetting font;
    public static BooleanSetting worldInfo;
    public static BooleanSetting rustHUD;
    public static BooleanSetting IndicatorBind;
    public static ListSetting colorList;
    public static NumberSetting time;
    public static ColorSetting onecolor;
    public static ColorSetting twocolor;
    private final BooleanSetting timerIndicator = new BooleanSetting("TimerIncicator", false, () -> true);
    public static BooleanSetting indicators;
    public float animation = 0.0f;
    private float cooledAttackStrength = 0.0f;
    private float move = 0.0f;
    private float timerValue = 1.0f;
    private float timerAnimValue = 1.0f;
    private float memoryValue = 1.0f;
    private float memoryAnimValue = 1.0f;
    private final TimerHelper timer = new TimerHelper();

    public HUD() {
        super("Display", "Shows information on the screen", Type.Hud);
        HUD L\u0445LLLLLLLL\u0445\u0445L;
        worldInfo = new BooleanSetting("World Info", false, () -> true);
        rustHUD = new BooleanSetting("Rust", false, () -> true);
        font = new ListSetting("FontList", "Product Sans", () -> true, "Minecraft", "MontserratRegular", "MontserratLight", "Menlo", "Comfortaa", "SF UI", "Calibri", "Verdana", "CircleRegular", "RobotoRegular", "JetBrains Mono", "LucidaConsole", "Corporative Sans", "Lato", "RaleWay", "Product Sans", "Arial", "Open Sans", "Kollektif", "Ubuntu");
        L\u0445LLLLLLLL\u0445\u0445L.addSettings(colorList, time, onecolor, twocolor, font, worldInfo, L\u0445LLLLLLLL\u0445\u0445L.timerIndicator, rustHUD, IndicatorBind, indicators);
    }

    @EventTarget
    public void onRender2D(EventRender2D L\u0445L\u0445LLLLLL\u0445\u0445L) {
        float LL\u0445\u0445LLLLLL\u0445\u0445L;
        Object \u0445\u0445\u0445LLLLLLL\u0445\u0445L;
        HUD \u0445LL\u0445LLLLLL\u0445\u0445L;
        if (\u0445LL\u0445LLLLLL\u0445\u0445L.timerIndicator.getBoolValue()) {
            \u0445LL\u0445LLLLLL\u0445\u0445L.timerValue = Destroy.instance.featureManager.getFeatureByClass(Timer.class).getState() ? \u0445LL\u0445LLLLLL\u0445\u0445L.timerValue - 0.9f / (float)Minecraft.getDebugFPS() * (float)(((Timer)Destroy.instance.featureManager.getFeatureByClass(Timer.class)).timer.getNumberValue() != 1.0f ? 1 : 0) : (float)((double)\u0445LL\u0445LLLLLL\u0445\u0445L.timerValue + 0.001 / (double)Minecraft.getDebugFPS());
            \u0445LL\u0445LLLLLL\u0445\u0445L.timerAnimValue += (\u0445LL\u0445LLLLLL\u0445\u0445L.timerValue - \u0445LL\u0445LLLLLL\u0445\u0445L.timerAnimValue) * (mc.getRenderPartialTicks() / 50.0f);
            if (\u0445LL\u0445LLLLLL\u0445\u0445L.timer.hasReached(8000.0f)) {
                \u0445LL\u0445LLLLLL\u0445\u0445L.timerValue = MathHelper.clamp(\u0445LL\u0445LLLLLL\u0445\u0445L.timerValue + 0.2f, 0.0f, 1.0f);
                \u0445LL\u0445LLLLLL\u0445\u0445L.timer.reset();
            }
            \u0445\u0445\u0445LLLLLLL\u0445\u0445L = new ScaledResolution(mc);
            HUD.mc.sfuiFontRender.drawCenteredStringWithShadow(MathUtil.round(\u0445LL\u0445LLLLLL\u0445\u0445L.timerValue * 100.0f, 1.0) + "%", (float)((ScaledResolution)\u0445\u0445\u0445LLLLLLL\u0445\u0445L).getScaledWidth() / 2.0f, (float)((ScaledResolution)\u0445\u0445\u0445LLLLLLL\u0445\u0445L).getScaledHeight() / 2.3f + 50.0f, -1);
        }
        if ((\u0445\u0445\u0445LLLLLLL\u0445\u0445L = Destroy.instance.draggableManager.getMods().iterator()).hasNext()) {
            DraggableModule LLL\u0445LLLLLL\u0445\u0445L = \u0445\u0445\u0445LLLLLLL\u0445\u0445L.next();
            if (\u0445LL\u0445LLLLLL\u0445\u0445L.getState() && !LLL\u0445LLLLLL\u0445\u0445L.name.equals("LogoComponent")) {
                LLL\u0445LLLLLL\u0445\u0445L.draw();
            }
            return;
        }
        float \u0445\u0445L\u0445LLLLLL\u0445\u0445L = HUD.mc.currentScreen instanceof GuiChat ? 15.0f : 0.0f;
        if (!Double.isFinite(globalOffset -= (LL\u0445\u0445LLLLLL\u0445\u0445L = globalOffset - \u0445\u0445L\u0445LLLLLL\u0445\u0445L) / (float)Math.max(1, Minecraft.getDebugFPS()) * 10.0f)) {
            globalOffset = 0.0f;
        }
        if (globalOffset > 15.0f) {
            globalOffset = 15.0f;
        }
        if (globalOffset < 0.0f) {
            globalOffset = 0.0f;
        }
    }

    static {
        IndicatorBind = new BooleanSetting("IndicatorKeybinds", true, () -> true);
        colorList = new ListSetting("Global Color", "Fade", () -> true, "Astolfo", "Static", "Fade", "Rainbow", "Custom", "None", "Category");
        time = new NumberSetting("Color Time", 30.0f, 1.0f, 100.0f, 1.0f, () -> true);
        onecolor = new ColorSetting("One Color", new Color(15665417).getRGB(), () -> HUD.colorList.currentMode.equals("Fade") || HUD.colorList.currentMode.equals("Custom") || HUD.colorList.currentMode.equals("Static"));
        twocolor = new ColorSetting("Two Color", new Color(-980470, true).getRGB(), () -> HUD.colorList.currentMode.equals("Custom"));
        indicators = new BooleanSetting("MemoryIndicator", true, () -> true);
    }
}

