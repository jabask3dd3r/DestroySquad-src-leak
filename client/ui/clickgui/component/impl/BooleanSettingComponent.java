/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.clickgui.component.impl;

import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.AnimationHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.Setting;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.ui.clickgui.component.Component;
import org.Destroy.client.ui.clickgui.component.PropertyComponent;

public class BooleanSettingComponent
extends Component
implements PropertyComponent {
    public BooleanSetting booleanSetting;
    public float textHoverAnimate = 0.0f;
    public float leftRectAnimation = 0.0f;
    public float rightRectAnimation = 0.0f;

    public BooleanSettingComponent(Component \u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L, BooleanSetting LL\u0445L\u0445\u0445\u0445L\u0445\u0445L, int \u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L, int L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, int \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, int LLL\u0445\u0445\u0445\u0445L\u0445\u0445L) {
        super(\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L, LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.getName(), \u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L, L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, LLL\u0445\u0445\u0445\u0445L\u0445\u0445L);
        BooleanSettingComponent L\u0445LL\u0445\u0445\u0445L\u0445\u0445L;
        L\u0445LL\u0445\u0445\u0445L\u0445\u0445L.booleanSetting = LL\u0445L\u0445\u0445\u0445L\u0445\u0445L;
    }

    @Override
    public void drawComponent(ScaledResolution L\u0445L\u0445\u0445LL\u0445\u0445\u0445L, int \u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445L, int LL\u0445\u0445\u0445LL\u0445\u0445\u0445L) {
        BooleanSettingComponent \u0445LL\u0445\u0445LL\u0445\u0445\u0445L;
        if (\u0445LL\u0445\u0445LL\u0445\u0445\u0445L.booleanSetting.isVisible()) {
            int \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L = \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.getX();
            int LLLL\u0445LL\u0445\u0445\u0445L = \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.getY();
            int \u0445LLL\u0445LL\u0445\u0445\u0445L = \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.getWidth();
            int L\u0445LL\u0445LL\u0445\u0445\u0445L = \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.getHeight();
            int \u0445\u0445LL\u0445LL\u0445\u0445\u0445L = \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.getHeight() / 2;
            boolean LL\u0445L\u0445LL\u0445\u0445\u0445L = \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.isHovered(\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445L, LL\u0445\u0445\u0445LL\u0445\u0445\u0445L);
            int \u0445L\u0445L\u0445LL\u0445\u0445\u0445L = 0;
            Color L\u0445\u0445L\u0445LL\u0445\u0445\u0445L = new Color(ClickGui.color.getColorValue());
            Color \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L = new Color(ClickGui.colorTwo.getColorValue());
            double LLL\u0445\u0445LL\u0445\u0445\u0445L = ClickGui.speed.getNumberValue();
            switch (ClickGui.clickGuiColor.currentMode) {
                case "Client": {
                    \u0445L\u0445L\u0445LL\u0445\u0445\u0445L = PaletteHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / LLL\u0445\u0445LL\u0445\u0445\u0445L / LLL\u0445\u0445LL\u0445\u0445\u0445L + (double)((long)LLLL\u0445LL\u0445\u0445\u0445L * 6L / 60L * 2L)) % 2.0 - 1.0));
                    break;
                }
                case "Fade": {
                    \u0445L\u0445L\u0445LL\u0445\u0445\u0445L = PaletteHelper.fadeColor(L\u0445\u0445L\u0445LL\u0445\u0445\u0445L.getRGB(), L\u0445\u0445L\u0445LL\u0445\u0445\u0445L.darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / LLL\u0445\u0445LL\u0445\u0445\u0445L / LLL\u0445\u0445LL\u0445\u0445\u0445L + (double)LLLL\u0445LL\u0445\u0445\u0445L + (double)((float)((long)L\u0445LL\u0445LL\u0445\u0445\u0445L * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                    break;
                }
                case "Color Two": {
                    \u0445L\u0445L\u0445LL\u0445\u0445\u0445L = PaletteHelper.fadeColor(L\u0445\u0445L\u0445LL\u0445\u0445\u0445L.getRGB(), \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / LLL\u0445\u0445LL\u0445\u0445\u0445L / LLL\u0445\u0445LL\u0445\u0445\u0445L + (double)LLLL\u0445LL\u0445\u0445\u0445L + (double)((float)((long)L\u0445LL\u0445LL\u0445\u0445\u0445L * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                    break;
                }
                case "Astolfo": {
                    \u0445L\u0445L\u0445LL\u0445\u0445\u0445L = PaletteHelper.astolfo(true, LLLL\u0445LL\u0445\u0445\u0445L).getRGB();
                    break;
                }
                case "Static": {
                    \u0445L\u0445L\u0445LL\u0445\u0445\u0445L = L\u0445\u0445L\u0445LL\u0445\u0445\u0445L.getRGB();
                    break;
                }
                case "Rainbow": {
                    \u0445L\u0445L\u0445LL\u0445\u0445\u0445L = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                }
            }
            RectHelper.drawRect(\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L, LLLL\u0445LL\u0445\u0445\u0445L, \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L + \u0445LLL\u0445LL\u0445\u0445\u0445L, LLLL\u0445LL\u0445\u0445\u0445L + L\u0445LL\u0445LL\u0445\u0445\u0445L, new Color(20, 20, 20, 160).getRGB());
            BooleanSettingComponent.mc.circleregularSmall.drawStringWithShadow(\u0445LL\u0445\u0445LL\u0445\u0445\u0445L.getName(), \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L + 3, LLLL\u0445LL\u0445\u0445\u0445L + \u0445\u0445LL\u0445LL\u0445\u0445\u0445L - 2, Color.GRAY.getRGB());
            \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.textHoverAnimate = AnimationHelper.animation(\u0445LL\u0445\u0445LL\u0445\u0445\u0445L.textHoverAnimate, LL\u0445L\u0445LL\u0445\u0445\u0445L ? 2.3f : 2.0f, 0.0f);
            \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.leftRectAnimation = AnimationHelper.animation(\u0445LL\u0445\u0445LL\u0445\u0445\u0445L.leftRectAnimation, \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.booleanSetting.getBoolValue() ? 10.0f : 17.0f, 0.0f);
            \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.rightRectAnimation = AnimationHelper.animation(\u0445LL\u0445\u0445LL\u0445\u0445\u0445L.rightRectAnimation, \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.booleanSetting.getBoolValue() ? 3 : 10, 0.0f);
            RectHelper.drawSmoothRect(\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L + \u0445LLL\u0445LL\u0445\u0445\u0445L - 18, LLLL\u0445LL\u0445\u0445\u0445L + 5, \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L + \u0445LLL\u0445LL\u0445\u0445\u0445L - 2, LLLL\u0445LL\u0445\u0445\u0445L + L\u0445LL\u0445LL\u0445\u0445\u0445L - 5, new Color(14, 14, 14).getRGB());
            RectHelper.drawSmoothRect((float)(\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L + \u0445LLL\u0445LL\u0445\u0445\u0445L) - \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.leftRectAnimation, LLLL\u0445LL\u0445\u0445\u0445L + 6, (float)(\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L + \u0445LLL\u0445LL\u0445\u0445\u0445L) - \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.rightRectAnimation, LLLL\u0445LL\u0445\u0445\u0445L + L\u0445LL\u0445LL\u0445\u0445\u0445L - 6, \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.booleanSetting.getBoolValue() ? \u0445L\u0445L\u0445LL\u0445\u0445\u0445L : new Color(50, 50, 50).getRGB());
            if (LL\u0445L\u0445LL\u0445\u0445\u0445L && \u0445LL\u0445\u0445LL\u0445\u0445\u0445L.booleanSetting.getDesc() != null) {
                RectHelper.drawBorderedRect(\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L + 120, (float)LLLL\u0445LL\u0445\u0445\u0445L + (float)L\u0445LL\u0445LL\u0445\u0445\u0445L / 1.5f + 3.5f, \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L + 138 + BooleanSettingComponent.mc.fontRendererObj.getStringWidth(\u0445LL\u0445\u0445LL\u0445\u0445\u0445L.booleanSetting.getDesc()) - 10, (float)LLLL\u0445LL\u0445\u0445\u0445L + 3.5f, 0.5f, new Color(30, 30, 30, 255).getRGB(), \u0445L\u0445L\u0445LL\u0445\u0445\u0445L, true);
                BooleanSettingComponent.mc.fontRendererObj.drawStringWithShadow(\u0445LL\u0445\u0445LL\u0445\u0445\u0445L.booleanSetting.getDesc(), \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L + 124, (float)LLLL\u0445LL\u0445\u0445\u0445L + (float)L\u0445LL\u0445LL\u0445\u0445\u0445L / 1.5f - 6.0f, -1);
            }
        }
    }

    @Override
    public void onMouseClick(int \u0445LLL\u0445\u0445L\u0445\u0445\u0445L, int L\u0445LL\u0445\u0445L\u0445\u0445\u0445L, int \u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L) {
        BooleanSettingComponent LLLL\u0445\u0445L\u0445\u0445\u0445L;
        if (\u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L == 0 && LLLL\u0445\u0445L\u0445\u0445\u0445L.isHovered(\u0445LLL\u0445\u0445L\u0445\u0445\u0445L, L\u0445LL\u0445\u0445L\u0445\u0445\u0445L) && LLLL\u0445\u0445L\u0445\u0445\u0445L.booleanSetting.isVisible()) {
            LLLL\u0445\u0445L\u0445\u0445\u0445L.booleanSetting.setBoolValue(!LLLL\u0445\u0445L\u0445\u0445\u0445L.booleanSetting.getBoolValue());
        }
    }

    @Override
    public Setting getSetting() {
        BooleanSettingComponent \u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445L;
        return \u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445L.booleanSetting;
    }
}

