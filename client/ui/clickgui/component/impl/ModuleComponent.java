/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.clickgui.component.impl;

import java.awt.Color;
import java.util.Iterator;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.Setting;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.Destroy.client.ui.clickgui.ClickGuiScreen;
import org.Destroy.client.ui.clickgui.Panel;
import org.Destroy.client.ui.clickgui.component.AnimationState;
import org.Destroy.client.ui.clickgui.component.Component;
import org.Destroy.client.ui.clickgui.component.ExpandableComponent;
import org.Destroy.client.ui.clickgui.component.impl.BooleanSettingComponent;
import org.Destroy.client.ui.clickgui.component.impl.ColorPickerComponent;
import org.Destroy.client.ui.clickgui.component.impl.ListSettingComponent;
import org.Destroy.client.ui.clickgui.component.impl.NumberSettingComponent;
import org.Destroy.client.ui.clickgui.component.impl.VisibleComponent;
import org.lwjgl.input.Keyboard;

public final class ModuleComponent
extends ExpandableComponent
implements Helper {
    private final Feature module;
    private final AnimationState state;
    private boolean binding;
    private int buttonLeft;
    private int buttonTop;
    private int buttonRight;
    private int buttonBottom;

    public ModuleComponent(Component LLLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L, Feature \u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L, int L\u0445LL\u0445\u0445\u0445LL\u0445L\u0445\u0445L, int \u0445\u0445LL\u0445\u0445\u0445LL\u0445L\u0445\u0445L, int LL\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, int \u0445L\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L) {
        super(LLLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L, \u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L.getLabel(), L\u0445LL\u0445\u0445\u0445LL\u0445L\u0445\u0445L, \u0445\u0445LL\u0445\u0445\u0445LL\u0445L\u0445\u0445L, LL\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, \u0445L\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L);
        ModuleComponent \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L;
        \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L.module = \u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L;
        \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L.state = AnimationState.STATIC;
        int L\u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L = 1;
        Iterator<Setting> \u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L = \u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L.getSettings().iterator();
        if (\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.hasNext()) {
            Setting L\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L = \u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.next();
            if (L\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L instanceof BooleanSetting) {
                \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L.components.add(new BooleanSettingComponent((Component)\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L, (BooleanSetting)L\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L, L\u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, \u0445L\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, LL\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L - 2, 21));
            } else if (L\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L instanceof ColorSetting) {
                \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L.components.add(new ColorPickerComponent((Component)\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L, (ColorSetting)L\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L, L\u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, \u0445L\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, LL\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L - 2, 15));
            } else if (L\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L instanceof NumberSetting) {
                \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L.components.add(new NumberSettingComponent((Component)\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L, (NumberSetting)L\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L, L\u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, \u0445L\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, LL\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L - 2, 20));
            } else if (L\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L instanceof ListSetting) {
                \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L.components.add(new ListSettingComponent((Component)\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L, (ListSetting)L\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L, L\u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, \u0445L\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, LL\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L - 2, 22));
            }
            throw null;
        }
        \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L.components.add(new VisibleComponent(\u0445LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445L, \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445L, L\u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, \u0445L\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L, LL\u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L - 2, 15));
    }

    @Override
    public void drawComponent(ScaledResolution \u0445\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L, int LL\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L, int \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L) {
        ModuleComponent L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L;
        float L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L = L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.getX();
        float \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L = L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.getY() - 2;
        int LLLLL\u0445L\u0445L\u0445L\u0445\u0445L = L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.getWidth();
        int \u0445LLLL\u0445L\u0445L\u0445L\u0445\u0445L = L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.getHeight();
        if (L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.isExpanded()) {
            int LLL\u0445\u0445LL\u0445L\u0445L\u0445\u0445L = 15;
            Iterator L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L = L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.components.iterator();
            if (L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.hasNext()) {
                ExpandableComponent \u0445L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L;
                ListSettingComponent LL\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L;
                ColorPickerComponent \u0445\u0445LL\u0445LL\u0445L\u0445L\u0445\u0445L;
                Component \u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L = (Component)L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.next();
                int L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L = \u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L.getHeight();
                if (\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L instanceof BooleanSettingComponent) {
                    BooleanSettingComponent \u0445LLL\u0445LL\u0445L\u0445L\u0445\u0445L = (BooleanSettingComponent)\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L;
                    if (!\u0445LLL\u0445LL\u0445L\u0445L\u0445\u0445L.booleanSetting.isVisible()) {
                        return;
                    }
                }
                if (\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L instanceof NumberSettingComponent) {
                    NumberSettingComponent L\u0445LL\u0445LL\u0445L\u0445L\u0445\u0445L = (NumberSettingComponent)\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L;
                    if (!L\u0445LL\u0445LL\u0445L\u0445L\u0445\u0445L.numberSetting.isVisible()) {
                        return;
                    }
                }
                if (\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L instanceof ColorPickerComponent && !(\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445\u0445L = (ColorPickerComponent)\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L).getSetting().isVisible()) {
                    return;
                }
                if (\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L instanceof ListSettingComponent && !(LL\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L = (ListSettingComponent)\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L).getSetting().isVisible()) {
                    return;
                }
                if (\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L instanceof ExpandableComponent && (\u0445L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L = (ExpandableComponent)\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L).isExpanded()) {
                    L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L = \u0445L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L.getHeightWithExpand();
                }
                \u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L.setY(LLL\u0445\u0445LL\u0445L\u0445L\u0445\u0445L);
                \u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L.drawComponent(\u0445\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L, LL\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L, \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L);
                LLL\u0445\u0445LL\u0445L\u0445L\u0445\u0445L += L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L;
                return;
            }
        }
        if (!ClickGuiScreen.search.getText().isEmpty() && !L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.module.getLabel().toLowerCase().contains(ClickGuiScreen.search.getText().toLowerCase())) {
            return;
        }
        int L\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L = 0;
        Color \u0445\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L = new Color(ClickGui.color.getColorValue());
        Color LL\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L = new Color(ClickGui.colorTwo.getColorValue());
        double \u0445L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L = ClickGui.speed.getNumberValue();
        switch (ClickGui.clickGuiColor.currentMode) {
            case "Client": {
                L\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L = PaletteHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L / \u0445L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L + (double)(\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L * 6.0f / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Fade": {
                L\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L = PaletteHelper.fadeColor(\u0445\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L.getRGB(), \u0445\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L.darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L / \u0445L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L + (double)(\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L * 6.0f / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Color Two": {
                L\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L = PaletteHelper.fadeColor(\u0445\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L.getRGB(), LL\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L / \u0445L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L + (double)(\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L * 6.0f / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Astolfo": {
                L\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L = PaletteHelper.astolfo(true, (int)\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L).getRGB();
                break;
            }
            case "Rainbow": {
                L\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                break;
            }
            case "Category": {
                Panel \u0445LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445L = (Panel)L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.parent;
                L\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L = \u0445LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.type.getColor();
            }
        }
        boolean L\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L = L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.isHovered(LL\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L, \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L);
        if (L\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L) {
            RectHelper.drawBorderedRect(L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)LLLLL\u0445L\u0445L\u0445L\u0445\u0445L + 18.0f, \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)\u0445LLLL\u0445L\u0445L\u0445L\u0445\u0445L / 1.5f + 3.5f, L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)LLLLL\u0445L\u0445L\u0445L\u0445\u0445L + 25.0f + (float)ModuleComponent.mc.fontRendererObj.getStringWidth(L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.module.getDesc()), \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + 3.5f, 0.5f, new Color(30, 30, 30, 255).getRGB(), L\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L, true);
            ModuleComponent.mc.fontRendererObj.drawStringWithShadow(L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.module.getDesc(), L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)LLLLL\u0445L\u0445L\u0445L\u0445\u0445L + 22.0f, \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)\u0445LLLL\u0445L\u0445L\u0445L\u0445\u0445L / 1.35f - 6.0f, -1);
        }
        if (L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.components.size() > 1) {
            ModuleComponent.mc.buttonFontRender.drawStringWithShadow(L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.isExpanded() ? "-" : "+", L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)LLLLL\u0445L\u0445L\u0445L\u0445\u0445L - 10.0f, \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)\u0445LLLL\u0445L\u0445L\u0445L\u0445\u0445L / 2.0f - 8.0f, Color.GRAY.getRGB());
        }
        int \u0445\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L = L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.getHeight() / 2;
        int LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445L = (int)(L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + 3.0f + (float)\u0445\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L);
        RectHelper.drawRect(L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L - 1.0f, \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)\u0445LLLL\u0445L\u0445L\u0445L\u0445\u0445L / 1.5f + 5.0f, L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + 20.0f, \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L, new Color(20, 20, 20, 220).getRGB());
        L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonLeft = (int)(L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + 5.0f);
        L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonTop = (int)(\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)\u0445\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L - (float)(\u0445\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L / 2 + 1));
        L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonRight = LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445L + 3;
        L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonBottom = (int)(\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)\u0445\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L + (float)(\u0445\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L / 2) + 1.0f);
        gui.drawGradientRect(L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonLeft, L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonTop, L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonRight, L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonBottom, -9737365, new Color(-9737365).darker().darker().getRGB());
        RectHelper.drawRect((double)L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonLeft + 0.5, (double)L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonTop + 0.5, (double)L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonRight - 0.5, (double)L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonBottom - 0.5, -12828863);
        if (L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.module.getState()) {
            L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonLeft = (int)((double)L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + 6.5);
            L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonTop = (int)(\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)\u0445\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L - (float)(\u0445\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L / 2));
            L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonRight = (int)((double)LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445L + 2.5);
            L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonBottom = (int)(\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)\u0445\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L + (float)(\u0445\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L / 2));
            gui.drawGradientRect(L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonLeft, L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonTop, L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonRight, L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.buttonBottom, L\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L, new Color(L\u0445LLL\u0445L\u0445L\u0445L\u0445\u0445L).darker().darker().getRGB());
        }
        ModuleComponent.mc.montserratRegular.drawStringWithShadow(L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.binding ? "Press a key... Key: " + Keyboard.getKeyName(L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.module.getBind()) : L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.getName(), L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + 25.0f, \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L + (float)\u0445LLLL\u0445L\u0445L\u0445L\u0445\u0445L / 2.0f - 3.0f, L\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L ? Color.LIGHT_GRAY.getRGB() : (L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.module.getState() ? Color.LIGHT_GRAY.getRGB() : Color.GRAY.getRGB()));
    }

    @Override
    public boolean canExpand() {
        ModuleComponent L\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
        return !L\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L.components.isEmpty();
    }

    @Override
    public void onPress(int \u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L, int LLLLLL\u0445\u0445L\u0445L\u0445\u0445L, int \u0445LLLLL\u0445\u0445L\u0445L\u0445\u0445L) {
        switch (\u0445LLLLL\u0445\u0445L\u0445L\u0445\u0445L) {
            case 0: {
                ModuleComponent L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
                L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L.module.toggle();
                break;
            }
            case 2: {
                ModuleComponent L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
                L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L.binding = !L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L.binding;
            }
        }
    }

    @Override
    public void onKeyPress(int \u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L) {
        ModuleComponent L\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L;
        if (L\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L.binding) {
            ClickGuiScreen.escapeKeyInUse = true;
            L\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L.module.setBind(\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L == 1 ? 0 : \u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L);
            L\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L.binding = false;
        }
    }

    @Override
    public int getHeightWithExpand() {
        Iterator \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
        ModuleComponent \u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
        int LLL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L = \u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L.getHeight();
        if (\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L.isExpanded() && (\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L = \u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L.components.iterator()).hasNext()) {
            ExpandableComponent LL\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
            ListSettingComponent \u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
            ColorPickerComponent L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
            Component L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L = (Component)\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.next();
            int \u0445L\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L = L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L.getHeight();
            if (L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L instanceof BooleanSettingComponent) {
                BooleanSettingComponent LLLL\u0445L\u0445\u0445L\u0445L\u0445\u0445L = (BooleanSettingComponent)L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
                if (!LLLL\u0445L\u0445\u0445L\u0445L\u0445\u0445L.booleanSetting.isVisible()) {
                    return 0;
                }
            }
            if (L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L instanceof NumberSettingComponent) {
                NumberSettingComponent \u0445LLL\u0445L\u0445\u0445L\u0445L\u0445\u0445L = (NumberSettingComponent)L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
                if (!\u0445LLL\u0445L\u0445\u0445L\u0445L\u0445\u0445L.numberSetting.isVisible()) {
                    return 0;
                }
            }
            if (L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L instanceof ColorPickerComponent && !(L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445\u0445L = (ColorPickerComponent)L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L).getSetting().isVisible()) {
                return 0;
            }
            if (L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L instanceof ListSettingComponent && !(\u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445\u0445L = (ListSettingComponent)L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L).getSetting().isVisible()) {
                return 0;
            }
            if (L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L instanceof ExpandableComponent && (LL\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L = (ExpandableComponent)L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L).isExpanded()) {
                \u0445L\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L = LL\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L.getHeightWithExpand();
            }
            LLL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L += \u0445L\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
            return 0;
        }
        return LLL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
    }
}

