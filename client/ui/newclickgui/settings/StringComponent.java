/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.newclickgui.settings;

import java.awt.Color;
import net.minecraft.util.ChatAllowedCharacters;
import org.Destroy.client.Destroy;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.impl.StringSetting;
import org.Destroy.client.ui.newclickgui.FeaturePanel;
import org.Destroy.client.ui.newclickgui.settings.Component;

public class StringComponent
extends Component {
    private boolean active;

    public StringComponent(FeaturePanel \u0445LLL\u0445LLL\u0445L\u0445L\u0445LL, StringSetting L\u0445LL\u0445LLL\u0445L\u0445L\u0445LL) {
        StringComponent LLLL\u0445LLL\u0445L\u0445L\u0445LL;
        LLLL\u0445LLL\u0445L\u0445L\u0445LL.featurePanel = \u0445LLL\u0445LLL\u0445L\u0445L\u0445LL;
        LLLL\u0445LLL\u0445L\u0445L\u0445LL.setting = L\u0445LL\u0445LLL\u0445L\u0445L\u0445LL;
    }

    @Override
    public void drawScreen(int L\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445LL, int \u0445\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445LL) {
        StringComponent \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL;
        RectHelper.drawSmoothRect(\u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.x - 15.0f, \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.y + 1.0f, \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.x, \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.y + \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.height - 3.0f, \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.active ? new Color(36, 36, 36).getRGB() : new Color(26, 26, 26).getRGB());
        StringComponent.mc.fontRendererObj.drawStringWithShadow(\u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.setting.getName(), \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.x, \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.y + \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.height / 2.0f - (float)StringComponent.mc.fontRendererObj.FONT_HEIGHT / 2.0f + 1.0f, new Color(255, 255, 255).getRGB());
        StringComponent.mc.fontRendererObj.drawStringWithShadow(((StringSetting)\u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.setting).currentText, \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.x + \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.width - 143.0f, \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.y + \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL.height / 2.0f - (float)StringComponent.mc.fontRendererObj.FONT_HEIGHT / 2.0f + 1.0f, new Color(255, 255, 255).getRGB());
        super.drawScreen(L\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445LL, \u0445\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445LL);
    }

    @Override
    public void mouseClicked(int LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL, int \u0445L\u0445LL\u0445LL\u0445L\u0445L\u0445LL, int L\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL) {
        StringComponent \u0445\u0445LLL\u0445LL\u0445L\u0445L\u0445LL;
        if (\u0445\u0445LLL\u0445LL\u0445L\u0445L\u0445LL.isHovered(LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL, \u0445L\u0445LL\u0445LL\u0445L\u0445L\u0445LL) && L\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL == 0 && \u0445\u0445LLL\u0445LL\u0445L\u0445L\u0445LL.featurePanel.usingSettings && Destroy.instance.newClickGui.usingSetting) {
            \u0445\u0445LLL\u0445LL\u0445L\u0445L\u0445LL.active = !\u0445\u0445LLL\u0445LL\u0445L\u0445L\u0445LL.active;
        }
        super.mouseClicked(LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL, \u0445L\u0445LL\u0445LL\u0445L\u0445L\u0445LL, L\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL);
    }

    @Override
    public void keyTyped(char \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL, int LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL) {
        StringComponent L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL;
        if (LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL == 1) {
            return;
        }
        if (28 == LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL && L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL.active) {
            L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL.enterString();
        } else if (LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL == 14 && L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL.active) {
            if (!((StringSetting)L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL.setting).currentText.isEmpty()) {
                ((StringSetting)L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL.setting).currentText = ((StringSetting)L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL.setting).currentText.substring(0, ((StringSetting)L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL.setting).currentText.length() - 1);
            }
        } else if (ChatAllowedCharacters.isAllowedCharacter((char)\u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL) && L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL.active) {
            ((StringSetting)L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL.setting).setCurrentText(((StringSetting)L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL.setting).currentText + \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL);
        }
        super.keyTyped(\u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL, LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL);
    }

    private void enterString() {
        StringComponent \u0445L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LL;
        \u0445L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LL.active = false;
        ((StringSetting)\u0445L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LL.setting).setCurrentText(((StringSetting)\u0445L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LL.setting).currentText);
    }

    @Override
    public void mouseReleased(int LL\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LL, int \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LL, int L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LL) {
        StringComponent \u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445LL;
        super.mouseReleased(LL\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LL, \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LL, L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LL);
    }
}

