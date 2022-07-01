/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.draggable.impl;

import java.awt.Color;
import java.util.Iterator;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.hud.HUD;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.ui.components.draggable.DraggableModule;

public class KeybindComponent
extends DraggableModule {
    public KeybindComponent() {
        super("IndicatorKeybinds", 6, 200);
        KeybindComponent \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
    }

    @Override
    public void render(int \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL, int L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL) {
        KeybindComponent LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        super.render(\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL, L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL);
        LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.draw();
    }

    @Override
    public void draw() {
        KeybindComponent LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        if (!HUD.IndicatorBind.getBoolValue()) {
            return;
        }
        ScaledResolution L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL = new ScaledResolution(mc);
        float \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL = LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getY() + 7;
        Iterator<Feature> LLLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL = Destroy.instance.featureManager.getFeatureList().iterator();
        if (LLLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.hasNext()) {
            Feature \u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL = LLLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.next();
            if (\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getBind() != 0 && !\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getLabel().equals("ClickGui") && !\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getLabel().equals("ClientFont")) {
                RectHelper.drawSmoothRectBetter(LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getX(), \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL, 105.0f, 13.0f, new Color(31, 31, 31, 182).getRGB());
                RectHelper.drawGradientRectBetter((float)LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getX() - 0.5f, LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getY() - 10, 106.0f, 2.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB());
                RectHelper.drawSmoothRectBetter(LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getX(), LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getY() - 8, 105.0f, 12.0f, new Color(31, 31, 31, 182).getRGB());
                KeybindComponent.mc.clickguismall.drawStringWithShadow("keybinds", LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getX() + 5 + KeybindComponent.mc.clickguismall.getStringWidth("keybinds"), LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getY() - 5, -1);
                String LLL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL = \u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getState() ? " [toggled]" : " [disable]";
                KeybindComponent.mc.smallfontRenderer.drawStringWithShadow(\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getLabel().toLowerCase(), LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getX() + 5, \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL + 5.0f, -1);
                KeybindComponent.mc.smallfontRenderer.drawStringWithShadow(LLL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL, LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.getX() + 70, \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL + 5.0f, -1);
                \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL += 12.0f;
            }
            return;
        }
    }
}

