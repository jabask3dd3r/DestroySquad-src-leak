/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.newclickgui.settings;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.helpers.math.MathematicHelper;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.AnimationHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.ScreenHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.impl.NumberSetting;
import org.Destroy.client.ui.newclickgui.FeaturePanel;
import org.Destroy.client.ui.newclickgui.Theme;
import org.Destroy.client.ui.newclickgui.settings.Component;
import org.lwjgl.opengl.GL11;

public class NumberSettingComponent
extends Component {
    private final Theme theme = new Theme();
    private final ScreenHelper screenHelper;
    public float currentValueAnimate = 0.0f;
    private boolean dragging;
    private float renderOffset;

    public NumberSettingComponent(FeaturePanel \u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445LLL, NumberSetting LLL\u0445LL\u0445\u0445\u0445\u0445L\u0445LLL) {
        NumberSettingComponent L\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445LLL;
        L\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445LLL.featurePanel = \u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445LLL;
        L\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445LLL.setting = LLL\u0445LL\u0445\u0445\u0445\u0445L\u0445LLL;
        L\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445LLL.screenHelper = new ScreenHelper(0.0f, 0.0f);
    }

    @Override
    public void drawScreen(int \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL, int LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL) {
        NumberSettingComponent L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL;
        ScaledResolution \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL = new ScaledResolution(Minecraft.getInstance());
        float L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL = ((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).getMinValue();
        float \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL = ((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).getMaxValue();
        float LLLLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = (float)MathematicHelper.round((double)((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).getNumberValue(), ((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).getIncrement());
        float \u0445LLLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = (((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).getNumberValue() - L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL) / (\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL - L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL);
        int L\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = 0;
        Color \u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = new Color(ClickGui.color.getColorValue());
        Color LL\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = new Color(ClickGui.colorTwo.getColorValue());
        double \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = ClickGui.speed.getNumberValue();
        switch (ClickGui.clickGuiColor.currentMode) {
            case "Client": {
                L\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = PaletteHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL / \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL + (double)(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height * 6.0f / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Fade": {
                L\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = PaletteHelper.fadeColor(\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL.getRGB(), \u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL.darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL / \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL + (double)(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height * 6.0f / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Color Two": {
                L\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = PaletteHelper.fadeColor(\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL.getRGB(), LL\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL / \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL + (double)(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height * 6.0f / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Astolfo": {
                L\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = PaletteHelper.astolfo(true, (int)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height).getRGB();
                break;
            }
            case "Static": {
                L\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = \u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL.getRGB();
                break;
            }
            case "Rainbow": {
                L\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
        NumberSettingComponent.mc.circleregular.drawStringWithOutline(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting.getName(), (float)\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.getScaledWidth() / 2.0f - 140.0f, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.y + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height / 2.0f - (float)NumberSettingComponent.mc.circleregular.getFontHeight() / 2.0f - 1.0f, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.theme.textColor.getRGB());
        NumberSettingComponent.mc.circleregular.drawStringWithOutline(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting.getName(), (float)\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.getScaledWidth() / 2.0f - 140.0f, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.y + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height / 2.0f - (float)NumberSettingComponent.mc.circleregular.getFontHeight() / 2.0f - 1.0f, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.theme.textColor.getRGB());
        L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.currentValueAnimate = AnimationHelper.animation(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.currentValueAnimate, \u0445LLLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL, 0.0f);
        RectHelper.drawSmoothRect(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.x, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.y + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height / 2.0f - 1.0f, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.x + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.width, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.y + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height / 2.0f + 2.0f, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.theme.panelColor.getRGB());
        RectHelper.drawSmoothGradientRect(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.x, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.y + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height / 2.0f - 1.0f, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.x + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.currentValueAnimate * L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.width, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.y + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height / 2.0f + 2.0f, L\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL, new Color(L\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL).darker().getRGB());
        String L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = "";
        NumberSetting.NumberType \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = ((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).getType();
        switch (\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL) {
            case PERCENTAGE: {
                L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL + '%';
                break;
            }
            case MS: {
                L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL + "ms";
                break;
            }
            case DISTANCE: {
                L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL + 'm';
            }
            case SIZE: {
                L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL + "SIZE";
            }
            case APS: {
                L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL + "APS";
                break;
            }
            default: {
                L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL = "";
            }
        }
        NumberSettingComponent numberSettingComponent = L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL;
        int n2 = \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL;
        if (LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL == 0 || L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.dragging) {
            L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.screenHelper.interpolate(\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.getScaledWidth(), \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.getScaledHeight() + 5, 6.0);
            if (L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.renderOffset < 0.5f) {
                L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.renderOffset = (float)((double)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.renderOffset + 0.002 * (double)RectHelper.delta);
            }
        } else {
            L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.screenHelper.interpolate(0.0f, 0.0f, 6.0);
            L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.renderOffset = 0.0f;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.x + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.currentValueAnimate * L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.width, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.y + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height / 2.0f, 0.0f);
        GL11.glScaled(0.5 + (double)(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.screenHelper.getX() / (float)\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.getScaledWidth()) - (double)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.renderOffset, 0.5 + (double)(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.screenHelper.getY() / (float)\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.getScaledHeight()) - (double)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.renderOffset, 0.0);
        GL11.glTranslatef(-(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.x + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.currentValueAnimate * L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.width), -(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.y + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height / 2.0f), 0.0f);
        if (L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.screenHelper.getX() > 250.0f) {
            RenderHelper.drawCircle(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.x + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.currentValueAnimate * L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.width, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.y + L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.height / 2.0f + 0.5f, 2.0f, true, Color.WHITE);
        }
        GL11.glPopMatrix();
        NumberSettingComponent numberSettingComponent2 = L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL;
        int n3 = \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL;
        if (LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL != 0) {
            NumberSettingComponent.mc.clickguismall.drawStringWithOutline(LLLLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL + L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.x - 5.0f - (float)NumberSettingComponent.mc.clickguismall.getStringWidth(LLLLL\u0445\u0445\u0445\u0445\u0445L\u0445LLL + L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL), L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.y + 5.0f, L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.theme.textColor.getRGB());
        }
        if (L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.dragging) {
            ((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).setValueNumber((float)MathematicHelper.round((double)(((float)\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL - L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.x) * (\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL - L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL) / L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.width + L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL), ((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).getIncrement()));
            if (((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).getNumberValue() > \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL) {
                ((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).setValueNumber(\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL);
            } else if (((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).getNumberValue() < L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL) {
                ((NumberSetting)L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL.setting).setValueNumber(L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL);
            }
        }
        super.drawScreen(\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL, LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL);
    }

    @Override
    public void mouseClicked(int \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL, int LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL, int \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL) {
        NumberSettingComponent L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL;
        NumberSettingComponent numberSettingComponent = L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL;
        int n2 = \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL;
        if (LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL != 0 && \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL == 0) {
            L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL.dragging = true;
        }
        super.mouseClicked(\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL, LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL, \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL);
    }

    @Override
    public void mouseReleased(int LLLL\u0445LLLLL\u0445\u0445LLL, int \u0445LLL\u0445LLLLL\u0445\u0445LLL, int L\u0445LL\u0445LLLLL\u0445\u0445LLL) {
        NumberSettingComponent \u0445\u0445\u0445\u0445LLLLLL\u0445\u0445LLL;
        \u0445\u0445\u0445\u0445LLLLLL\u0445\u0445LLL.dragging = false;
        super.mouseReleased(LLLL\u0445LLLLL\u0445\u0445LLL, \u0445LLL\u0445LLLLL\u0445\u0445LLL, L\u0445LL\u0445LLLLL\u0445\u0445LLL);
    }
}

