/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.newclickgui.settings;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.Destroy.client.helpers.render.ScreenHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.ui.newclickgui.FeaturePanel;
import org.Destroy.client.ui.newclickgui.Theme;
import org.Destroy.client.ui.newclickgui.settings.Component;

public class ListSettingComponent
extends Component {
    private final ScreenHelper screenHelper;
    private final Theme theme = new Theme();

    public ListSettingComponent(FeaturePanel LLL\u0445LLLLL\u0445LL\u0445LL, ListSetting \u0445LL\u0445LLLLL\u0445LL\u0445LL) {
        ListSettingComponent \u0445\u0445\u0445LLLLLL\u0445LL\u0445LL;
        \u0445\u0445\u0445LLLLLL\u0445LL\u0445LL.featurePanel = LLL\u0445LLLLL\u0445LL\u0445LL;
        \u0445\u0445\u0445LLLLLL\u0445LL\u0445LL.setting = \u0445LL\u0445LLLLL\u0445LL\u0445LL;
        \u0445\u0445\u0445LLLLLL\u0445LL\u0445LL.screenHelper = new ScreenHelper(0.0f, 0.0f);
    }

    @Override
    public void drawScreen(int L\u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL, int \u0445\u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL) {
        ListSettingComponent \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL;
        ScaledResolution LLLLL\u0445LLL\u0445LL\u0445LL = new ScaledResolution(Minecraft.getInstance());
        RectHelper.drawSmoothRect(\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.x - (float)ListSettingComponent.mc.fontRenderer.getStringWidth(((ListSetting)\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.setting).getCurrentMode()) - 15.0f, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.y + 1.0f, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.x, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.y + \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.height - 3.0f, new Color(26, 26, 26).getRGB());
        ListSettingComponent.mc.circleregular.drawStringWithOutline(\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.setting.getName(), (float)LLLLL\u0445LLL\u0445LL\u0445LL.getScaledWidth() / 2.0f - 140.0f, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.y + \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.height / 2.0f - (float)ListSettingComponent.mc.fontRenderer.getFontHeight() / 2.0f, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.theme.textColor.getRGB());
        ListSettingComponent.mc.clickguismall.drawStringWithOutline(((ListSetting)\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.setting).getCurrentMode(), \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.x - (float)ListSettingComponent.mc.clickguismall.getStringWidth(((ListSetting)\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.setting).getCurrentMode()) - (float)ListSettingComponent.mc.fontRenderer.getStringWidth(">") - 10.0f, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.y + \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.height / 2.0f - (float)ListSettingComponent.mc.fontRenderer.getFontHeight() / 2.0f, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.theme.textColor.getRGB());
        double \u0445LLLL\u0445LLL\u0445LL\u0445LL = \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.x - (float)ListSettingComponent.mc.fontRenderer.getStringWidth(">") / 2.0f - 0.75f;
        double L\u0445LLL\u0445LLL\u0445LL\u0445LL = \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.y + \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.height / 2.0f + 0.75f;
        if (\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.extended) {
            \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.screenHelper.interpolate(0.0f, 90.0f, 4.0);
        } else {
            \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.screenHelper.interpolate(0.0f, 0.0f, 4.0);
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate(\u0445LLLL\u0445LLL\u0445LL\u0445LL, L\u0445LLL\u0445LLL\u0445LL\u0445LL, 0.0);
        GlStateManager.rotate(\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.screenHelper.getY(), 0.0f, 0.0f, 1.0f);
        GlStateManager.translate(-\u0445LLLL\u0445LLL\u0445LL\u0445LL, -L\u0445LLL\u0445LLL\u0445LL\u0445LL, 0.0);
        float \u0445\u0445LLL\u0445LLL\u0445LL\u0445LL = \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.extended ? 3.0f : 1.5f;
        float LL\u0445LL\u0445LLL\u0445LL\u0445LL = \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.extended ? 2.0f : -1.0f;
        ListSettingComponent.mc.fontRenderer.drawStringWithShadow(">", \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.x - (float)ListSettingComponent.mc.fontRenderer.getStringWidth(">") - \u0445\u0445LLL\u0445LLL\u0445LL\u0445LL, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.y + \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.height / 2.0f - (float)ListSettingComponent.mc.fontRenderer.getFontHeight() / 2.0f + LL\u0445LL\u0445LLL\u0445LL\u0445LL, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.theme.textColor.getRGB());
        GlStateManager.popMatrix();
        if (!\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.extended) {
            return;
        }
        int \u0445L\u0445LL\u0445LLL\u0445LL\u0445LL = (int)\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.height;
        Iterator<String> \u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445LL = ((ListSetting)\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.setting).getModes().iterator();
        if (\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445LL.hasNext()) {
            String LL\u0445\u0445\u0445LLLL\u0445LL\u0445LL = \u0445\u0445\u0445\u0445L\u0445LLL\u0445LL\u0445LL.next();
            if (!((ListSetting)\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.setting).getCurrentMode().equals(LL\u0445\u0445\u0445LLLL\u0445LL\u0445LL)) {
                ArrayList<String> L\u0445L\u0445\u0445LLLL\u0445LL\u0445LL = new ArrayList<String>(((ListSetting)\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.setting).getModes());
                String \u0445\u0445L\u0445\u0445LLLL\u0445LL\u0445LL = Collections.max(L\u0445L\u0445\u0445LLLL\u0445LL\u0445LL, Comparator.comparing(String::length));
                RectHelper.drawSmoothRect(\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.x - (float)ListSettingComponent.mc.clickguismall.getStringWidth(\u0445\u0445L\u0445\u0445LLLL\u0445LL\u0445LL) - 10.0f, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.y + (float)\u0445L\u0445LL\u0445LLL\u0445LL\u0445LL, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.x, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.y + \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.height + (float)\u0445L\u0445LL\u0445LLL\u0445LL\u0445LL - 1.0f, new Color(29, 29, 29).getRGB());
                ListSettingComponent.mc.clickguismall.drawStringWithOutline(LL\u0445\u0445\u0445LLLL\u0445LL\u0445LL, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.x - (float)ListSettingComponent.mc.clickguismall.getStringWidth(\u0445\u0445L\u0445\u0445LLLL\u0445LL\u0445LL) - 6.0f, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.y + (float)\u0445L\u0445LL\u0445LLL\u0445LL\u0445LL + \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.height / 2.0f - (float)ListSettingComponent.mc.fontRenderer.getFontHeight() / 2.0f + 1.0f, \u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.theme.textColor.getRGB());
                \u0445L\u0445LL\u0445LLL\u0445LL\u0445LL = (int)((float)\u0445L\u0445LL\u0445LLL\u0445LL\u0445LL + (\u0445L\u0445\u0445\u0445LLLL\u0445LL\u0445LL.height - 1.0f));
            }
            return;
        }
        super.drawScreen(L\u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL, \u0445\u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL);
    }

    @Override
    public void mouseClicked(int LL\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL, int \u0445L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL, int L\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL) {
        ListSettingComponent \u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL;
        ListSettingComponent listSettingComponent = \u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL;
        int n2 = LL\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL;
        if (\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL != 0 && L\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL == 0) {
            boolean bl2 = \u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.extended = !\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.extended;
        }
        if (!\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.extended) {
            return;
        }
        int \u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL = (int)\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.height;
        Iterator<String> \u0445L\u0445LLL\u0445LL\u0445LL\u0445LL = ((ListSetting)\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.setting).getModes().iterator();
        if (\u0445L\u0445LLL\u0445LL\u0445LL\u0445LL.hasNext()) {
            String L\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL = \u0445L\u0445LLL\u0445LL\u0445LL\u0445LL.next();
            if (!((ListSetting)\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.setting).getCurrentMode().equals(L\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL)) {
                if ((float)LL\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL > \u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.x - \u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.width - 5.0f && (float)LL\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL < \u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.x && (float)\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL > \u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.y + (float)\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL && (float)\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL < \u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.y + (float)\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL + \u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.height && L\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL == 0) {
                    ((ListSetting)\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.setting).setListMode(L\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL);
                }
                \u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL = (int)((float)\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL + \u0445\u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.height);
            }
            return;
        }
        super.mouseClicked(LL\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL, \u0445L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL, L\u0445\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL);
    }
}

