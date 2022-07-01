/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.draggable.impl;

import org.Destroy.client.Destroy;
import org.Destroy.client.feature.impl.hud.HUD;
import org.Destroy.client.feature.impl.misc.Disabler;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.world.EntityHelper;
import org.Destroy.client.ui.components.draggable.DraggableModule;

public class PingComponent
extends DraggableModule {
    public PingComponent() {
        super("PingComponent", 100, 300);
        PingComponent LLLLLLLL\u0445L\u0445\u0445LL;
    }

    @Override
    public int getWidth() {
        return 55;
    }

    @Override
    public int getHeight() {
        return 12;
    }

    @Override
    public void render(int L\u0445L\u0445LLLL\u0445L\u0445\u0445LL, int \u0445\u0445L\u0445LLLL\u0445L\u0445\u0445LL) {
        PingComponent \u0445LL\u0445LLLL\u0445L\u0445\u0445LL;
        if (PingComponent.mc.player != null && PingComponent.mc.world != null) {
            int LLL\u0445LLLL\u0445L\u0445\u0445LL;
            int n2 = LLL\u0445LLLL\u0445L\u0445\u0445LL = Destroy.mc.isSingleplayer() ? 0 : EntityHelper.getPing(PingComponent.mc.player);
            if (HUD.font.currentMode.equals("Minecraft")) {
                ClientHelper.getFontRender().drawStringWithShadow("Ping: \u00c2\u00a77" + LLL\u0445LLLL\u0445L\u0445\u0445LL + "ms", \u0445LL\u0445LLLL\u0445L\u0445\u0445LL.getX(), \u0445LL\u0445LLLL\u0445L\u0445\u0445LL.getY(), -1);
            } else {
                PingComponent.mc.fontRendererObj.drawStringWithShadow("Ping: \u00c2\u00a77" + LLL\u0445LLLL\u0445L\u0445\u0445LL + "ms", \u0445LL\u0445LLLL\u0445L\u0445\u0445LL.getX(), \u0445LL\u0445LLLL\u0445L\u0445\u0445LL.getY(), -1);
            }
        }
        super.render(L\u0445L\u0445LLLL\u0445L\u0445\u0445LL, \u0445\u0445L\u0445LLLL\u0445L\u0445\u0445LL);
    }

    @Override
    public void draw() {
        PingComponent \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445LL;
        if (PingComponent.mc.player != null && PingComponent.mc.world != null) {
            int L\u0445LL\u0445LLL\u0445L\u0445\u0445LL;
            int n2 = Destroy.instance.featureManager.getFeatureByClass(Disabler.class).getState() ? 0 : (L\u0445LL\u0445LLL\u0445L\u0445\u0445LL = mc.isSingleplayer() ? 0 : EntityHelper.getPing(PingComponent.mc.player));
            if (HUD.font.currentMode.equals("Minecraft")) {
                ClientHelper.getFontRender().drawStringWithShadow("Ping: \u00c2\u00a77" + L\u0445LL\u0445LLL\u0445L\u0445\u0445LL + "ms", \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445LL.getX(), \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445LL.getY(), -1);
            } else {
                PingComponent.mc.fontRendererObj.drawStringWithShadow("Ping: \u00c2\u00a77" + L\u0445LL\u0445LLL\u0445L\u0445\u0445LL + "ms", \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445LL.getX(), \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445LL.getY(), -1);
            }
        }
        super.draw();
    }
}

