/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.newclickgui.settings;

import org.Destroy.client.helpers.Helper;
import org.Destroy.client.settings.Setting;
import org.Destroy.client.ui.newclickgui.FeaturePanel;

public class Component
implements Helper {
    public FeaturePanel featurePanel;
    public Setting setting;
    public float x;
    public float y;
    public float width;
    public float height;
    public boolean extended;

    public Component() {
        Component LLLLLLL\u0445\u0445L\u0445L\u0445LL;
    }

    public void drawScreen(int \u0445\u0445LLLLL\u0445\u0445L\u0445L\u0445LL, int LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL) {
    }

    public void setInformations(float \u0445\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL, float LL\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LL, float \u0445L\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LL, float L\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LL) {
        L\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL.x = \u0445\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL;
        L\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL.y = LL\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LL;
        L\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL.width = \u0445L\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LL;
        L\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL.height = L\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445LL;
    }

    public void mouseClicked(int \u0445L\u0445L\u0445LL\u0445\u0445L\u0445L\u0445LL, int L\u0445\u0445L\u0445LL\u0445\u0445L\u0445L\u0445LL, int \u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445L\u0445LL) {
    }

    public void keyTyped(char \u0445LL\u0445\u0445LL\u0445\u0445L\u0445L\u0445LL, int L\u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445LL) {
    }

    public void mouseReleased(int LL\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LL, int \u0445L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LL, int L\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LL) {
    }

    public boolean isSettingVisible() {
        Component LLLLL\u0445L\u0445\u0445L\u0445L\u0445LL;
        return LLLLL\u0445L\u0445\u0445L\u0445L\u0445LL.setting.isVisible();
    }

    public boolean isHovered(int L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL, int \u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL) {
        Component \u0445L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL;
        return (float)L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL >= \u0445L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL.x && (float)L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL <= \u0445L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL.x + \u0445L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL.width && (float)\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL >= \u0445L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL.y && (float)\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL <= \u0445L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL.y + \u0445L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LL.height;
    }
}

