/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.newclickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.ScreenHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.Setting;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.Destroy.client.settings.impl.StringSetting;
import org.Destroy.client.ui.newclickgui.ClickGuiScreen;
import org.Destroy.client.ui.newclickgui.Theme;
import org.Destroy.client.ui.newclickgui.settings.BooleanSettingComponent;
import org.Destroy.client.ui.newclickgui.settings.ColorPickerComponent;
import org.Destroy.client.ui.newclickgui.settings.Component;
import org.Destroy.client.ui.newclickgui.settings.KeybindButton;
import org.Destroy.client.ui.newclickgui.settings.ListSettingComponent;
import org.Destroy.client.ui.newclickgui.settings.NumberSettingComponent;
import org.lwjgl.input.Mouse;

public class FeaturePanel
implements Helper {
    public ArrayList<Component> components = new ArrayList();
    public ArrayList<KeybindButton> keybindButtons = new ArrayList();
    public Feature feature;
    public int x;
    public int y;
    public int width;
    public int height;
    public Theme theme = new Theme();
    public int scrollY;
    public int scrollOffset;
    public int yOffset;
    public boolean usingSettings = false;
    public ScreenHelper screenHelper;

    public FeaturePanel(Feature \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL) {
        FeaturePanel \u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL;
        \u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL.feature = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL;
        \u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL.screenHelper = new ScreenHelper(0.0f, 0.0f);
        \u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL.keybindButtons.add(new KeybindButton(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL));
        Iterator<Setting> LL\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL.getSettings().iterator();
        if (LL\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LL.hasNext()) {
            Setting LL\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL = LL\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LL.next();
            if (LL\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL instanceof BooleanSetting) {
                \u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL.components.add(new BooleanSettingComponent(\u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL, (BooleanSetting)LL\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL));
            } else if (LL\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL instanceof NumberSetting) {
                \u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL.components.add(new NumberSettingComponent(\u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL, (NumberSetting)LL\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL));
            } else if (LL\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL instanceof ListSetting) {
                \u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL.components.add(new ListSettingComponent(\u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL, (ListSetting)LL\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL));
            } else if (LL\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL instanceof ColorSetting) {
                \u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL.components.add(new ColorPickerComponent(\u0445L\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL, (ColorSetting)LL\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL));
            } else if (LL\u0445\u0445LL\u0445\u0445LL\u0445L\u0445LL instanceof StringSetting) {
                // empty if block
            }
            throw null;
        }
    }

    public void drawScreen(int \u0445L\u0445LL\u0445LL\u0445L\u0445L\u0445LL, int L\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL) {
        FeaturePanel LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL;
        ScaledResolution \u0445\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL = new ScaledResolution(Minecraft.getInstance());
        RectHelper.drawRect((double)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.x - 0.5, LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y, (double)(LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.x + LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.width) + 0.5, LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y + LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.height, new Color(24, 24, 24, 230).getRGB());
        FeaturePanel featurePanel = LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL;
        int n2 = \u0445L\u0445LL\u0445LL\u0445L\u0445L\u0445LL;
        if (L\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL != 0 && !Destroy.instance.newClickGui.usingSetting) {
            RectHelper.drawRect(LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.x, LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y, LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.x + LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.width, LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y + LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.height, new Color(20, 20, 20).getRGB());
        }
        if (!ClickGuiScreen.search.getText().isEmpty() && !LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.feature.getLabel().toLowerCase().contains(ClickGuiScreen.search.getText().toLowerCase())) {
            return;
        }
        int LLL\u0445L\u0445LL\u0445L\u0445L\u0445LL = 0;
        Color L\u0445L\u0445L\u0445LL\u0445L\u0445L\u0445LL = new Color(ClickGui.color.getColorValue());
        Color LL\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL = new Color(ClickGui.colorTwo.getColorValue());
        double \u0445L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL = ClickGui.speed.getNumberValue();
        switch (ClickGui.clickGuiColor.currentMode) {
            case "Client": {
                LLL\u0445L\u0445LL\u0445L\u0445L\u0445LL = PaletteHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL / \u0445L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL + (double)((long)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y * 6L / 60L * 2L)) % 2.0 - 1.0));
                break;
            }
            case "Fade": {
                LLL\u0445L\u0445LL\u0445L\u0445L\u0445LL = PaletteHelper.fadeColor(L\u0445L\u0445L\u0445LL\u0445L\u0445L\u0445LL.getRGB(), L\u0445L\u0445L\u0445LL\u0445L\u0445L\u0445LL.darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL / \u0445L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL + (double)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y + (double)((float)((long)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.height * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Color Two": {
                LLL\u0445L\u0445LL\u0445L\u0445L\u0445LL = PaletteHelper.fadeColor(L\u0445L\u0445L\u0445LL\u0445L\u0445L\u0445LL.getRGB(), LL\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL / \u0445L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL + (double)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y + (double)((float)((long)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.height * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Astolfo": {
                LLL\u0445L\u0445LL\u0445L\u0445L\u0445LL = PaletteHelper.astolfo(true, LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y).getRGB();
                break;
            }
            case "Static": {
                LLL\u0445L\u0445LL\u0445L\u0445L\u0445LL = L\u0445L\u0445L\u0445LL\u0445L\u0445L\u0445LL.getRGB();
                break;
            }
            case "Rainbow": {
                LLL\u0445L\u0445LL\u0445L\u0445L\u0445LL = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
        boolean L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL = LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.isHovering(\u0445L\u0445LL\u0445LL\u0445L\u0445L\u0445LL, L\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL);
        if (L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LL && LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.feature.getDesc() != null && !LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.usingSettings && !Destroy.instance.newClickGui.usingSetting) {
            RectHelper.drawSmoothRect(LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.x + LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.width + 14, (float)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y + (float)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.height / 1.5f + 3.5f, LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.x + LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.width + 19 + FeaturePanel.mc.fontRendererObj.getStringWidth(LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.feature.getDesc()), LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y + 1, new Color(30, 30, 30, 255).getRGB());
            FeaturePanel.mc.fontRendererObj.drawStringWithOutline(LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.feature.getDesc(), LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.x + LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.width + 17, (float)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y + (float)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.height / 1.35f - 7.5f, -1);
        }
        if (LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.components.size() > 0) {
            FeaturePanel.mc.fontRenderer.drawStringWithShadow(LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.usingSettings ? "<" : ">", LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.x + LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.width - 10, (float)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y + (float)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.height / 2.0f - (float)FeaturePanel.mc.fontRenderer.getFontHeight() / 2.0f - 1.0f, Color.GRAY.getRGB());
        }
        FeaturePanel.mc.circleregular.drawStringWithShadow(LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.feature.getLabel(), LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.x + 7, (float)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.y + (float)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.height / 2.0f - (float)FeaturePanel.mc.circleregular.getFontHeight() / 2.0f + 1.0f, LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.feature.getState() ? LLL\u0445L\u0445LL\u0445L\u0445L\u0445LL : Color.LIGHT_GRAY.getRGB());
        int LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL = 0;
        if (LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.usingSettings) {
            Iterator<Helper> \u0445L\u0445LLL\u0445L\u0445L\u0445L\u0445LL = LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.keybindButtons.iterator();
            if (\u0445L\u0445LLL\u0445L\u0445L\u0445L\u0445LL.hasNext()) {
                KeybindButton L\u0445\u0445L\u0445LLL\u0445L\u0445L\u0445LL = \u0445L\u0445LLL\u0445L\u0445L\u0445L\u0445LL.next();
                L\u0445\u0445L\u0445LLL\u0445L\u0445L\u0445LL.setPosition(\u0445\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL.getScaledWidth() / 2 - 140, 90 + LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL - LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollY, 276, 15);
                LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL += 20;
                return;
            }
            \u0445L\u0445LLL\u0445L\u0445L\u0445L\u0445LL = LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.components.iterator();
            if (\u0445L\u0445LLL\u0445L\u0445L\u0445L\u0445LL.hasNext()) {
                Component \u0445LLLL\u0445LL\u0445L\u0445L\u0445LL = (Component)\u0445L\u0445LLL\u0445L\u0445L\u0445L\u0445LL.next();
                if (\u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setting.isVisible()) {
                    if (\u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setting instanceof ColorSetting) {
                        \u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setInformations((float)\u0445\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL.getScaledWidth() / 2.0f + 55.0f, 90 + LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL - LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollY, 276.0f, 15.0f);
                        LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL += 80;
                    }
                    if (\u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setting instanceof NumberSetting) {
                        \u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setInformations((float)\u0445\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL.getScaledWidth() / 2.0f + 50.0f, 90 + LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL - LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollY, 97.0f, 15.0f);
                    } else if (\u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setting instanceof BooleanSetting) {
                        \u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setInformations((float)\u0445\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL.getScaledWidth() / 2.0f - 140.0f, 90 + LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL - LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollY, 276.0f, 15.0f);
                    } else if (!(\u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setting instanceof StringSetting) && \u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setting instanceof ListSetting) {
                        Iterator<String> \u0445L\u0445\u0445LL\u0445L\u0445L\u0445L\u0445LL;
                        ArrayList<String> \u0445\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445LL = new ArrayList<String>(((ListSetting)\u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setting).getModes());
                        String \u0445L\u0445\u0445\u0445LLL\u0445L\u0445L\u0445LL = Collections.max(\u0445\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445LL, Comparator.comparing(String::length));
                        int \u0445\u0445\u0445\u0445\u0445LLL\u0445L\u0445L\u0445LL = FeaturePanel.mc.fontRenderer.getStringWidth(\u0445L\u0445\u0445\u0445LLL\u0445L\u0445L\u0445LL + "") + FeaturePanel.mc.fontRenderer.getStringWidth("V");
                        \u0445\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445LL.clear();
                        \u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setInformations((float)\u0445\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL.getScaledWidth() / 2.0f + 148.0f, 90 + LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL - LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollY, \u0445\u0445\u0445\u0445\u0445LLL\u0445L\u0445L\u0445LL, 15.0f);
                        if (\u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.extended && (\u0445L\u0445\u0445LL\u0445L\u0445L\u0445L\u0445LL = ((ListSetting)\u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setting).getModes().iterator()).hasNext()) {
                            String \u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL = \u0445L\u0445\u0445LL\u0445L\u0445L\u0445L\u0445LL.next();
                            if (!((ListSetting)\u0445LLLL\u0445LL\u0445L\u0445L\u0445LL.setting).getCurrentMode().equals(\u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445LL)) {
                                LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL += 20;
                            }
                            return;
                        }
                    }
                    LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL += 20;
                }
                return;
            }
            int L\u0445LLL\u0445LL\u0445L\u0445L\u0445LL = Mouse.getDWheel();
            if (L\u0445LLL\u0445LL\u0445L\u0445L\u0445LL > 0 && LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollOffset > 0) {
                LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollOffset = (int)((float)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollOffset - ClickGui.scrollSpeed.getNumberValue());
            }
            if (L\u0445LLL\u0445LL\u0445L\u0445L\u0445LL < 0 && LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollOffset < LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL - \u0445\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL.getScaledHeight() / 2 - 40 && LLLL\u0445\u0445LL\u0445L\u0445L\u0445LL + 25 > \u0445\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445LL.getScaledHeight() - 150) {
                LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollOffset = (int)((float)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollOffset + ClickGui.scrollSpeed.getNumberValue());
            }
            LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.screenHelper.interpolate(LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollOffset, 0.0f, 1.0);
            LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.scrollY = (int)LL\u0445LL\u0445LL\u0445L\u0445L\u0445LL.screenHelper.getX();
        }
    }

    public void mouseReleased(int \u0445LLLL\u0445\u0445L\u0445L\u0445L\u0445LL, int \u0445\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LL, int \u0445L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LL) {
        FeaturePanel \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL;
        Iterator<Component> L\u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL = \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.components.iterator();
        if (L\u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.hasNext()) {
            Component \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL = L\u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.next();
            \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.mouseReleased(\u0445LLLL\u0445\u0445L\u0445L\u0445L\u0445LL, \u0445\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LL, \u0445L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LL);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public void mouseClicked(int \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LL, int \u0445LLL\u0445\u0445L\u0445\u0445L\u0445L\u0445LL, int L\u0445LL\u0445\u0445L\u0445\u0445L\u0445L\u0445LL) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl70 : RETURN - null : trying to set 4 previously set to 0
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:207)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1559)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:434)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void keyTyped(char \u0445LL\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL, int L\u0445L\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL) throws IOException {
        Iterator<Helper> L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL;
        FeaturePanel LLL\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL;
        if (Destroy.instance.newClickGui.usingSetting && LLL\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL.usingSettings && (L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL = LLL\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL.components.iterator()).hasNext()) {
            Component L\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445LL = L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL.next();
            L\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445LL.keyTyped(\u0445LL\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL, L\u0445L\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL);
            return;
        }
        if (Destroy.instance.newClickGui.usingSetting) {
            if (L\u0445L\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL == 1) {
                Destroy.instance.newClickGui.usingSetting = false;
                LLL\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL.usingSettings = false;
            } else {
                L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL = LLL\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL.keybindButtons.iterator();
                if (L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL.hasNext()) {
                    KeybindButton \u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445LL = (KeybindButton)L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL.next();
                    \u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445LL.keyTyped(L\u0445L\u0445LL\u0445\u0445\u0445L\u0445L\u0445LL);
                    return;
                }
            }
        }
    }

    public void setPosition(int \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LL, int LLLLL\u0445\u0445\u0445\u0445L\u0445L\u0445LL, int \u0445LLLL\u0445\u0445\u0445\u0445L\u0445L\u0445LL, int L\u0445LLL\u0445\u0445\u0445\u0445L\u0445L\u0445LL) {
        L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LL.x = \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LL;
        L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LL.y = LLLLL\u0445\u0445\u0445\u0445L\u0445L\u0445LL;
        L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LL.width = \u0445LLLL\u0445\u0445\u0445\u0445L\u0445L\u0445LL;
        L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LL.height = L\u0445LLL\u0445\u0445\u0445\u0445L\u0445L\u0445LL;
    }
}

