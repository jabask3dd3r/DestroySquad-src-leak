/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.newclickgui.settings;

import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.ScreenHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.ui.newclickgui.FeaturePanel;
import org.Destroy.client.ui.newclickgui.Theme;
import org.Destroy.client.ui.newclickgui.settings.Component;
import org.lwjgl.opengl.GL11;

public class BooleanSettingComponent
extends Component {
    private final Theme theme = new Theme();
    private final ScreenHelper screenHelper;
    private float renderOffset;

    public BooleanSettingComponent(FeaturePanel \u0445L\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445L, BooleanSetting L\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445L) {
        BooleanSettingComponent LL\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445L;
        LL\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445L.featurePanel = \u0445L\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445L;
        LL\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445L.setting = L\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445L;
        LL\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445L.screenHelper = new ScreenHelper(0.0f, 0.0f);
    }

    @Override
    public void drawScreen(int \u0445L\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L, int L\u0445\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L) {
        BooleanSettingComponent LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L;
        ScaledResolution \u0445\u0445\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L = new ScaledResolution(mc);
        RectHelper.drawSmoothRect(LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.x + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.width - 1.0f, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.y + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height / 2.0f - 5.0f, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.x + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.width + 9.0f, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.y + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height / 2.0f + 5.0f, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.theme.guiColor3.getRGB());
        BooleanSettingComponent.mc.circleregular.drawStringWithOutline(LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.setting.getName(), LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.x, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.y + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height / 2.0f - (float)BooleanSettingComponent.mc.circleregular.getFontHeight() / 2.0f + 0.5f, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.theme.textColor.getRGB());
        BooleanSettingComponent.mc.circleregular.drawStringWithOutline(LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.setting.getName(), LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.x, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.y + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height / 2.0f - (float)BooleanSettingComponent.mc.circleregular.getFontHeight() / 2.0f + 0.5f, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.theme.textColor.getRGB());
        int LLL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L = 0;
        Color \u0445LL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L = new Color(ClickGui.color.getColorValue());
        Color L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L = new Color(ClickGui.colorTwo.getColorValue());
        double \u0445\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L = ClickGui.speed.getNumberValue();
        switch (ClickGui.clickGuiColor.currentMode) {
            case "Client": {
                LLL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L = PaletteHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L / \u0445\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L + (double)(LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height * 6.0f / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Fade": {
                LLL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L = PaletteHelper.fadeColor(\u0445LL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.getRGB(), \u0445LL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L / \u0445\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L + (double)(LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height * 6.0f / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Color Two": {
                LLL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L = PaletteHelper.fadeColor(\u0445LL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.getRGB(), L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L / \u0445\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L + (double)(LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height * 6.0f / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Astolfo": {
                LLL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L = PaletteHelper.astolfo(true, (int)LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height).getRGB();
                break;
            }
            case "Static": {
                LLL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L = \u0445LL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.getRGB();
                break;
            }
            case "Rainbow": {
                LLL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
        if (((BooleanSetting)LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.setting).getBoolValue()) {
            LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.screenHelper.interpolate(\u0445\u0445\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.getScaledWidth(), \u0445\u0445\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.getScaledHeight() + 5, 6.0);
            if (LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.renderOffset < 0.5f) {
                LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.renderOffset = (float)((double)LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.renderOffset + 0.002 * (double)RectHelper.delta);
            }
        } else {
            LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.screenHelper.interpolate(0.0f, 0.0f, 6.0);
            LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.renderOffset = 0.0f;
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.x + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.width + 2.0f, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.y + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height / 2.0f - 4.0f, 0.0f);
        GL11.glScaled(LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.screenHelper.getX() / (float)\u0445\u0445\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.getScaledWidth() - LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.renderOffset, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.screenHelper.getY() / (float)\u0445\u0445\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.getScaledHeight() - LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.renderOffset, 0.0);
        GL11.glTranslatef(-(LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.x + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.width + 2.0f), -(LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.y + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height / 2.0f - 4.0f), 0.0f);
        if (LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.screenHelper.getX() > 250.0f) {
            RectHelper.drawVerticalGradientSmoothRect(LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.x + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.width - 1.0f, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.y + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height / 2.0f - 5.0f, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.x + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.width + 9.0f, LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.y + LL\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.height / 2.0f + 5.0f, LLL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L, new Color(LLL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L).darker().getRGB());
        }
        GL11.glPopMatrix();
        super.drawScreen(\u0445L\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L, L\u0445\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L);
    }

    @Override
    public void mouseClicked(int \u0445\u0445L\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L, int LL\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L, int \u0445L\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L) {
        BooleanSettingComponent L\u0445L\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L;
        BooleanSettingComponent booleanSettingComponent = L\u0445L\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L;
        int n2 = \u0445\u0445L\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L;
        if (LL\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L != 0 && \u0445L\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L == 0) {
            ((BooleanSetting)L\u0445L\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L.setting).setBoolValue(!((BooleanSetting)L\u0445L\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L.setting).getBoolValue());
        }
        super.mouseClicked(\u0445\u0445L\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L, LL\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L, \u0445L\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L);
    }
}

