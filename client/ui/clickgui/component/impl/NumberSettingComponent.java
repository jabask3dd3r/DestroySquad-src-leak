/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.clickgui.component.impl;

import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.helpers.math.MathematicHelper;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.AnimationHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.Setting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.Destroy.client.ui.clickgui.component.Component;
import org.Destroy.client.ui.clickgui.component.PropertyComponent;

public class NumberSettingComponent
extends Component
implements PropertyComponent {
    public NumberSetting numberSetting;
    public float currentValueAnimate = 0.0f;
    private boolean sliding;

    public NumberSettingComponent(Component L\u0445\u0445L\u0445LL\u0445LL\u0445L\u0445\u0445L, NumberSetting LLL\u0445\u0445LL\u0445LL\u0445L\u0445\u0445L, int L\u0445L\u0445\u0445LL\u0445LL\u0445L\u0445\u0445L, int \u0445L\u0445\u0445\u0445LL\u0445LL\u0445L\u0445\u0445L, int \u0445LLLL\u0445L\u0445LL\u0445L\u0445\u0445L, int L\u0445LLL\u0445L\u0445LL\u0445L\u0445\u0445L) {
        super(L\u0445\u0445L\u0445LL\u0445LL\u0445L\u0445\u0445L, LLL\u0445\u0445LL\u0445LL\u0445L\u0445\u0445L.getName(), L\u0445L\u0445\u0445LL\u0445LL\u0445L\u0445\u0445L, \u0445L\u0445\u0445\u0445LL\u0445LL\u0445L\u0445\u0445L, \u0445LLLL\u0445L\u0445LL\u0445L\u0445\u0445L, L\u0445LLL\u0445L\u0445LL\u0445L\u0445\u0445L);
        NumberSettingComponent LL\u0445L\u0445LL\u0445LL\u0445L\u0445\u0445L;
        LL\u0445L\u0445LL\u0445LL\u0445L\u0445\u0445L.numberSetting = LLL\u0445\u0445LL\u0445LL\u0445L\u0445\u0445L;
    }

    @Override
    public void drawComponent(ScaledResolution L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L, int LLLLLLLL\u0445L\u0445L\u0445\u0445L, int \u0445LLLLLLL\u0445L\u0445L\u0445\u0445L) {
        NumberSettingComponent LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L;
        super.drawComponent(L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L, LLLLLLLL\u0445L\u0445L\u0445\u0445L, \u0445LLLLLLL\u0445L\u0445L\u0445\u0445L);
        int \u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L = LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.getX();
        int \u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L = LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.getY();
        int L\u0445\u0445LLLLL\u0445L\u0445L\u0445\u0445L = LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.getWidth();
        int LLL\u0445LLLL\u0445L\u0445L\u0445\u0445L = LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.getHeight();
        double L\u0445L\u0445LLLL\u0445L\u0445L\u0445\u0445L = LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getMinValue();
        double LL\u0445\u0445LLLL\u0445L\u0445L\u0445\u0445L = LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getMaxValue();
        boolean L\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445\u0445L = LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.isHovered(LLLLLLLL\u0445L\u0445L\u0445\u0445L, \u0445LLLLLLL\u0445L\u0445L\u0445\u0445L);
        if (LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.sliding) {
            LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.setValueNumber((float)MathematicHelper.round((double)(LLLLLLLL\u0445L\u0445L\u0445\u0445L - \u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L) * (LL\u0445\u0445LLLL\u0445L\u0445L\u0445\u0445L - L\u0445L\u0445LLLL\u0445L\u0445L\u0445\u0445L) / (double)L\u0445\u0445LLLLL\u0445L\u0445L\u0445\u0445L + L\u0445L\u0445LLLL\u0445L\u0445L\u0445\u0445L, LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getIncrement()));
            if ((double)LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getNumberValue() > LL\u0445\u0445LLLL\u0445L\u0445L\u0445\u0445L) {
                LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.setValueNumber((float)LL\u0445\u0445LLLL\u0445L\u0445L\u0445\u0445L);
            } else if ((double)LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getNumberValue() < L\u0445L\u0445LLLL\u0445L\u0445L\u0445\u0445L) {
                LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.setValueNumber((float)L\u0445L\u0445LLLL\u0445L\u0445L\u0445\u0445L);
            }
        }
        float LLLL\u0445LLL\u0445L\u0445L\u0445\u0445L = (float)(((double)LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getNumberValue() - L\u0445L\u0445LLLL\u0445L\u0445L\u0445\u0445L) / (LL\u0445\u0445LLLL\u0445L\u0445L\u0445\u0445L - L\u0445L\u0445LLLL\u0445L\u0445L\u0445\u0445L));
        int L\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L = 0;
        Color \u0445\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L = new Color(ClickGui.color.getColorValue());
        Color \u0445L\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L = new Color(ClickGui.colorTwo.getColorValue());
        double L\u0445\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L = ClickGui.speed.getNumberValue();
        switch (ClickGui.clickGuiColor.currentMode) {
            case "Client": {
                L\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L = PaletteHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / L\u0445\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L / L\u0445\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L + (double)((long)\u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L * 6L / 60L * 2L)) % 2.0 - 1.0));
                break;
            }
            case "Fade": {
                L\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L = PaletteHelper.fadeColor(\u0445\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L.getRGB(), \u0445\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L.darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / L\u0445\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L / L\u0445\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L + (double)((float)((long)\u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Color Two": {
                L\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L = PaletteHelper.fadeColor(\u0445\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L.getRGB(), \u0445L\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / L\u0445\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L / L\u0445\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L + (double)((float)((long)\u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Astolfo": {
                L\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L = PaletteHelper.astolfo(true, \u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L).getRGB();
                break;
            }
            case "Static": {
                L\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L = \u0445\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L.getRGB();
                break;
            }
            case "Rainbow": {
                L\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
        LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.currentValueAnimate = AnimationHelper.animation(LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.currentValueAnimate, LLLL\u0445LLL\u0445L\u0445L\u0445\u0445L, 0.0f);
        float \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L = (float)MathematicHelper.round((double)LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getNumberValue(), LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getIncrement());
        RectHelper.drawRect(\u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L, \u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L, \u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L + L\u0445\u0445LLLLL\u0445L\u0445L\u0445\u0445L, \u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L + LLL\u0445LLLL\u0445L\u0445L\u0445\u0445L, new Color(20, 20, 20, 160).getRGB());
        RectHelper.drawRect(\u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L + 3, \u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L + LLL\u0445LLLL\u0445L\u0445L\u0445\u0445L - 5, \u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L + (L\u0445\u0445LLLLL\u0445L\u0445L\u0445\u0445L - 3), \u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L + 13, new Color(40, 39, 39).getRGB());
        RectHelper.drawGradientRect(\u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L + 3, \u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L + 13, (float)(\u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L + 5) + LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.currentValueAnimate * (float)(L\u0445\u0445LLLLL\u0445L\u0445L\u0445\u0445L - 8), (float)\u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L + 15.0f, L\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L, RenderHelper.darker(L\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L, 2.0f));
        RenderHelper.drawCircle((float)(\u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L + 5) + LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.currentValueAnimate * (float)(L\u0445\u0445LLLLL\u0445L\u0445L\u0445\u0445L - 8), (float)\u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L + 14.0f, 2.0f, true, new Color(L\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L));
        String LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L = "";
        NumberSetting.NumberType \u0445\u0445\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L = LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getType();
        switch (\u0445\u0445\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L) {
            case PERCENTAGE: {
                LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L = LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L + '%';
                break;
            }
            case MS: {
                LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L = LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L + "ms";
                break;
            }
            case DISTANCE: {
                LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L = LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L + 'm';
            }
            case SIZE: {
                LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L = LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L + "SIZE";
            }
            case APS: {
                LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L = LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L + "APS";
                break;
            }
            default: {
                LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L = "";
            }
        }
        NumberSettingComponent.mc.circleregularSmall.drawStringWithShadow(LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getName(), (float)\u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L + 2.0f, (float)\u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L + (float)LLL\u0445LLLL\u0445L\u0445L\u0445\u0445L / 2.5f - 4.0f, Color.lightGray.getRGB());
        NumberSettingComponent.mc.circleregularSmall.drawStringWithShadow(\u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L + " " + LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L, \u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L + L\u0445\u0445LLLLL\u0445L\u0445L\u0445\u0445L - NumberSettingComponent.mc.circleregularSmall.getStringWidth(\u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L + " " + LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L) - 5, (float)\u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L + (float)LLL\u0445LLLL\u0445L\u0445L\u0445\u0445L / 2.5f - 4.0f, Color.GRAY.getRGB());
        if (L\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445\u0445L && LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getDesc() != null) {
            RectHelper.drawBorderedRect(\u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L + 120, (float)\u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L + (float)LLL\u0445LLLL\u0445L\u0445L\u0445\u0445L / 1.5f + 3.5f, \u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L + 138 + NumberSettingComponent.mc.fontRendererObj.getStringWidth(LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getDesc()) - 10, (float)\u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L + 3.5f, 0.5f, new Color(30, 30, 30, 255).getRGB(), L\u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445L, true);
            NumberSettingComponent.mc.fontRendererObj.drawStringWithShadow(LLL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.numberSetting.getDesc(), \u0445\u0445LLLLLL\u0445L\u0445L\u0445\u0445L + 124, (float)\u0445L\u0445LLLLL\u0445L\u0445L\u0445\u0445L + (float)LLL\u0445LLLL\u0445L\u0445L\u0445\u0445L / 1.5f - 6.0f, -1);
        }
    }

    @Override
    public void onMouseClick(int L\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445\u0445L, int LL\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L, int \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L) {
        NumberSettingComponent LLLLL\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
        if (!LLLLL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.sliding && \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L == 0 && LLLLL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.isHovered(L\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445\u0445L, LL\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L)) {
            LLLLL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.sliding = true;
        }
    }

    @Override
    public void onMouseRelease(int \u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L) {
        \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L.sliding = false;
    }

    @Override
    public Setting getSetting() {
        NumberSettingComponent LLLLLLL\u0445\u0445L\u0445L\u0445\u0445L;
        return LLLLLLL\u0445\u0445L\u0445L\u0445\u0445L.numberSetting;
    }
}

