/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.clickgui.component.impl;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.Setting;
import org.Destroy.client.ui.clickgui.component.Component;
import org.Destroy.client.ui.clickgui.component.PropertyComponent;

public class VisibleComponent
extends Component
implements PropertyComponent {
    public Feature feature;

    public VisibleComponent(Feature L\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL, Component \u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL, int LL\u0445\u0445\u0445L\u0445\u0445LL\u0445LL, int \u0445L\u0445\u0445\u0445L\u0445\u0445LL\u0445LL, int L\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445LL, int \u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445LL) {
        super(\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL, "", LL\u0445\u0445\u0445L\u0445\u0445LL\u0445LL, \u0445L\u0445\u0445\u0445L\u0445\u0445LL\u0445LL, L\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445LL, \u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445LL);
        VisibleComponent \u0445LL\u0445\u0445L\u0445\u0445LL\u0445LL;
        \u0445LL\u0445\u0445L\u0445\u0445LL\u0445LL.feature = L\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL;
    }

    @Override
    public void drawComponent(ScaledResolution LLLL\u0445\u0445\u0445\u0445LL\u0445LL, int \u0445LLL\u0445\u0445\u0445\u0445LL\u0445LL, int L\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL) {
        VisibleComponent \u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445LL;
        int \u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL = \u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445LL.getX();
        int LL\u0445L\u0445\u0445\u0445\u0445LL\u0445LL = \u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445LL.getY();
        int \u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL = \u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445LL.getHeight();
        int L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LL = \u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445LL.getWidth();
        RectHelper.drawRect(\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL, LL\u0445L\u0445\u0445\u0445\u0445LL\u0445LL, \u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL + L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LL, LL\u0445L\u0445\u0445\u0445\u0445LL\u0445LL + \u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL, new Color(20, 20, 20, 160).getRGB());
        VisibleComponent.mc.circleregularSmall.drawStringWithShadow("Visible: " + (Object)((Object)ChatFormatting.WHITE) + \u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445LL.feature.visible, \u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL + 2, (float)LL\u0445L\u0445\u0445\u0445\u0445LL\u0445LL + (float)\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LL / 2.5f - 2.0f, Color.LIGHT_GRAY.getRGB());
        super.drawComponent(LLLL\u0445\u0445\u0445\u0445LL\u0445LL, \u0445LLL\u0445\u0445\u0445\u0445LL\u0445LL, L\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL);
    }

    @Override
    public void onMouseClick(int LL\u0445LLLLL\u0445L\u0445LL, int \u0445L\u0445LLLLL\u0445L\u0445LL, int L\u0445\u0445LLLLL\u0445L\u0445LL) {
        VisibleComponent \u0445\u0445LLLLLL\u0445L\u0445LL;
        if (\u0445\u0445LLLLLL\u0445L\u0445LL.isHovered(LL\u0445LLLLL\u0445L\u0445LL, \u0445L\u0445LLLLL\u0445L\u0445LL) && L\u0445\u0445LLLLL\u0445L\u0445LL == 0) {
            \u0445\u0445LLLLLL\u0445L\u0445LL.feature.setVisible(!\u0445\u0445LLLLLL\u0445L\u0445LL.feature.isVisible());
        }
        super.onMouseClick(LL\u0445LLLLL\u0445L\u0445LL, \u0445L\u0445LLLLL\u0445L\u0445LL, L\u0445\u0445LLLLL\u0445L\u0445LL);
    }

    @Override
    public void onMouseRelease(int L\u0445\u0445\u0445LLLL\u0445L\u0445LL) {
        VisibleComponent \u0445L\u0445\u0445LLLL\u0445L\u0445LL;
        super.onMouseRelease(L\u0445\u0445\u0445LLLL\u0445L\u0445LL);
    }

    @Override
    public void onKeyPress(int LL\u0445L\u0445LLL\u0445L\u0445LL) {
        VisibleComponent \u0445\u0445LL\u0445LLL\u0445L\u0445LL;
        super.onKeyPress(LL\u0445L\u0445LLL\u0445L\u0445LL);
    }

    @Override
    public Setting getSetting() {
        return null;
    }
}

