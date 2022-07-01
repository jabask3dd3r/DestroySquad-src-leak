/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.clickgui.component.impl;

import java.awt.Color;
import java.util.Iterator;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.Setting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.ui.clickgui.component.Component;
import org.Destroy.client.ui.clickgui.component.ExpandableComponent;
import org.Destroy.client.ui.clickgui.component.PropertyComponent;

public class ListSettingComponent
extends ExpandableComponent
implements PropertyComponent {
    private final ListSetting listSetting;

    public ListSettingComponent(Component LL\u0445\u0445LLL\u0445\u0445LLLLLL, ListSetting \u0445L\u0445\u0445LLL\u0445\u0445LLLLLL, int L\u0445\u0445\u0445LLL\u0445\u0445LLLLLL, int \u0445\u0445\u0445\u0445LLL\u0445\u0445LLLLLL, int LLLL\u0445LL\u0445\u0445LLLLLL, int \u0445LLL\u0445LL\u0445\u0445LLLLLL) {
        super(LL\u0445\u0445LLL\u0445\u0445LLLLLL, \u0445L\u0445\u0445LLL\u0445\u0445LLLLLL.getName(), L\u0445\u0445\u0445LLL\u0445\u0445LLLLLL, \u0445\u0445\u0445\u0445LLL\u0445\u0445LLLLLL, LLLL\u0445LL\u0445\u0445LLLLLL, \u0445LLL\u0445LL\u0445\u0445LLLLLL);
        ListSettingComponent \u0445\u0445L\u0445LLL\u0445\u0445LLLLLL;
        \u0445\u0445L\u0445LLL\u0445\u0445LLLLLL.listSetting = \u0445L\u0445\u0445LLL\u0445\u0445LLLLLL;
    }

    @Override
    public Setting getSetting() {
        ListSettingComponent L\u0445L\u0445\u0445LL\u0445\u0445LLLLLL;
        return L\u0445L\u0445\u0445LL\u0445\u0445LLLLLL.listSetting;
    }

    @Override
    public void drawComponent(ScaledResolution LLL\u0445L\u0445L\u0445\u0445LLLLLL, int \u0445LL\u0445L\u0445L\u0445\u0445LLLLLL, int L\u0445L\u0445L\u0445L\u0445\u0445LLLLLL) {
        ListSettingComponent \u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL;
        super.drawComponent(LLL\u0445L\u0445L\u0445\u0445LLLLLL, \u0445LL\u0445L\u0445L\u0445\u0445LLLLLL, L\u0445L\u0445L\u0445L\u0445\u0445LLLLLL);
        int \u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL = \u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.getX();
        int LL\u0445\u0445L\u0445L\u0445\u0445LLLLLL = \u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.getY();
        int \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLLLL = \u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.getWidth();
        int L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLLLL = \u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.getHeight();
        String \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LLLLLL = \u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.listSetting.getCurrentMode();
        int LLLL\u0445\u0445L\u0445\u0445LLLLLL = LL\u0445\u0445L\u0445L\u0445\u0445LLLLLL + 10;
        int \u0445LLL\u0445\u0445L\u0445\u0445LLLLLL = 0xFFFFFF;
        Gui.drawRect(\u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL, LL\u0445\u0445L\u0445L\u0445\u0445LLLLLL, \u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL + \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLLLL, LL\u0445\u0445L\u0445L\u0445\u0445LLLLLL + L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLLLL, new Color(15, 15, 15).getRGB());
        ListSettingComponent.mc.smallfontRenderer.drawStringWithShadow(\u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.getName(), \u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL + 2, LL\u0445\u0445L\u0445L\u0445\u0445LLLLLL + 3, \u0445LLL\u0445\u0445L\u0445\u0445LLLLLL);
        Gui.drawRect(\u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL + 2, LLLL\u0445\u0445L\u0445\u0445LLLLLL, \u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL + \u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.getWidth() - 2, (int)((double)LLLL\u0445\u0445L\u0445\u0445LLLLLL + 10.5), new Color(30, 30, 30).getRGB());
        RectHelper.drawRect((double)\u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL + 2.5, (double)LLLL\u0445\u0445L\u0445\u0445LLLLLL + 0.5, (double)(\u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL + \u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.getWidth()) - 2.5, LLLL\u0445\u0445L\u0445\u0445LLLLLL + 10, -12828863);
        ListSettingComponent.mc.circleregularSmall.drawStringWithShadow(\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LLLLLL, (float)\u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL + 3.5f, (float)LLLL\u0445\u0445L\u0445\u0445LLLLLL + 2.5f, -1);
        if (\u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.isExpanded()) {
            Gui.drawRect(\u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL + 1, LL\u0445\u0445L\u0445L\u0445\u0445LLLLLL + L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLLLL, \u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL + \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLLLL - 1, LL\u0445\u0445L\u0445L\u0445\u0445LLLLLL + \u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.getHeightWithExpand(), new Color(30, 30, 30).getRGB());
            \u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.handleRender(\u0445\u0445L\u0445L\u0445L\u0445\u0445LLLLLL, LL\u0445\u0445L\u0445L\u0445\u0445LLLLLL + \u0445\u0445\u0445LL\u0445L\u0445\u0445LLLLLL.getHeight() + 2, \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLLLL, \u0445LLL\u0445\u0445L\u0445\u0445LLLLLL);
        }
    }

    @Override
    public void onMouseClick(int L\u0445LLLL\u0445\u0445\u0445LLLLLL, int \u0445\u0445LLLL\u0445\u0445\u0445LLLLLL, int LL\u0445LLL\u0445\u0445\u0445LLLLLL) {
        ListSettingComponent \u0445LLLLL\u0445\u0445\u0445LLLLLL;
        super.onMouseClick(L\u0445LLLL\u0445\u0445\u0445LLLLLL, \u0445\u0445LLLL\u0445\u0445\u0445LLLLLL, LL\u0445LLL\u0445\u0445\u0445LLLLLL);
        if (\u0445LLLLL\u0445\u0445\u0445LLLLLL.isExpanded()) {
            \u0445LLLLL\u0445\u0445\u0445LLLLLL.handleClick(L\u0445LLLL\u0445\u0445\u0445LLLLLL, \u0445\u0445LLLL\u0445\u0445\u0445LLLLLL, \u0445LLLLL\u0445\u0445\u0445LLLLLL.getX(), \u0445LLLLL\u0445\u0445\u0445LLLLLL.getY() + \u0445LLLLL\u0445\u0445\u0445LLLLLL.getHeight() + 2, \u0445LLLLL\u0445\u0445\u0445LLLLLL.getWidth());
        }
    }

    private void handleRender(int L\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL, int \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL, int LLL\u0445\u0445L\u0445\u0445\u0445LLLLLL, int \u0445LL\u0445\u0445L\u0445\u0445\u0445LLLLLL) {
        ListSettingComponent \u0445L\u0445L\u0445L\u0445\u0445\u0445LLLLLL;
        int L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL = 0;
        Color \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL = new Color(ClickGui.color.getColorValue());
        Color LL\u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL = new Color(ClickGui.colorTwo.getColorValue());
        double \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL = ClickGui.speed.getNumberValue();
        switch (ClickGui.clickGuiColor.currentMode) {
            case "Client": {
                L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL = PaletteHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL / \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL + (double)((long)\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL * 6L / 60L * 2L)) % 2.0 - 1.0));
                break;
            }
            case "Fade": {
                L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL = PaletteHelper.fadeColor(\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL.getRGB(), \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL.darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL / \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL + (double)((float)((long)\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Color Two": {
                L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL = PaletteHelper.fadeColor(\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL.getRGB(), LL\u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL / \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL + (double)((float)((long)\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Astolfo": {
                L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL = PaletteHelper.astolfo(true, \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL).getRGB();
                break;
            }
            case "Static": {
                L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL = \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL.getRGB();
                break;
            }
            case "Rainbow": {
                L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
        Object \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLLLL = \u0445L\u0445L\u0445L\u0445\u0445\u0445LLLLLL.listSetting.getModes().iterator();
        if (\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLLLL.hasNext()) {
            String LL\u0445L\u0445L\u0445\u0445\u0445LLLLLL = (String)\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLLLL.next();
            if (\u0445L\u0445L\u0445L\u0445\u0445\u0445LLLLLL.listSetting.currentMode.equals(LL\u0445L\u0445L\u0445\u0445\u0445LLLLLL)) {
                GlStateManager.pushMatrix();
                GlStateManager.disableBlend();
                RectHelper.drawGradientRect(L\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL + 1, \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL - 2, L\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL + LLL\u0445\u0445L\u0445\u0445\u0445LLLLLL - 1, \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL + 15 - 6, L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL, new Color(L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLLLL).darker().getRGB());
                GlStateManager.popMatrix();
            }
            ListSettingComponent.mc.fontRenderer.drawStringWithShadow(LL\u0445L\u0445L\u0445\u0445\u0445LLLLLL, L\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL + 1 + 4, \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL + 1, \u0445LL\u0445\u0445L\u0445\u0445\u0445LLLLLL);
            \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LLLLLL += 12;
            return;
        }
    }

    private void handleClick(int \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLLLL, int LL\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL, int \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL, int L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL, int \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL) {
        ListSettingComponent L\u0445LL\u0445\u0445\u0445\u0445\u0445LLLLLL;
        Iterator<String> L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLLLL = L\u0445LL\u0445\u0445\u0445\u0445\u0445LLLLLL.listSetting.getModes().iterator();
        if (L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLLLL.hasNext()) {
            String \u0445LLL\u0445\u0445\u0445\u0445\u0445LLLLLL = L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLLLL.next();
            if (\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLLLL >= \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL && LL\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL >= L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL && \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLLLL <= \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL + \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL && LL\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL <= L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL + 15 - 3) {
                L\u0445LL\u0445\u0445\u0445\u0445\u0445LLLLLL.listSetting.setListMode(\u0445LLL\u0445\u0445\u0445\u0445\u0445LLLLLL);
            }
            L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL += 12;
            return;
        }
    }

    @Override
    public int getHeightWithExpand() {
        ListSettingComponent \u0445LLLLLLLL\u0445LLLLL;
        return \u0445LLLLLLLL\u0445LLLLL.getHeight() + \u0445LLLLLLLL\u0445LLLLL.listSetting.getModes().toArray().length * 12;
    }

    @Override
    public void onPress(int LL\u0445LLLLLL\u0445LLLLL, int \u0445L\u0445LLLLLL\u0445LLLLL, int L\u0445\u0445LLLLLL\u0445LLLLL) {
    }

    @Override
    public boolean canExpand() {
        ListSettingComponent LLL\u0445LLLLL\u0445LLLLL;
        return LLL\u0445LLLLL\u0445LLLLL.listSetting.getModes().toArray().length > 0;
    }
}

