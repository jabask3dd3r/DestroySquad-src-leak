/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.draggable.impl;

import java.awt.Color;
import net.minecraft.util.math.MathHelper;
import org.Destroy.client.feature.impl.hud.HUD;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.ui.components.draggable.DraggableModule;

public class MemoryIndicatorComponent
extends DraggableModule {
    private float memoryValue = 1.0f;
    private float memoryAnimValue = 1.0f;
    private final TimerHelper timer = new TimerHelper();

    public MemoryIndicatorComponent() {
        super("MemoryIndicator", sr.getScaledWidth() / 2 + 65, sr.getScaledHeight() - 150);
        MemoryIndicatorComponent L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL;
    }

    @Override
    public void render(int LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL, int \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL) {
        MemoryIndicatorComponent \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL;
        \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.draw();
        super.render(LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL, \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL);
    }

    @Override
    public void draw() {
        MemoryIndicatorComponent L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL;
        if (!HUD.indicators.getBoolValue()) {
            return;
        }
        L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.memoryValue = (float)((double)(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (double)Runtime.getRuntime().maxMemory());
        L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.memoryAnimValue += (L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.memoryValue - L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.memoryAnimValue) * (mc.getRenderPartialTicks() / 50.0f);
        Color LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL = new Color(28, 28, 28, 180);
        float \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL = (float)(L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getWidth() + L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getHeight()) / 3.6f;
        RenderHelper.drawCircle((float)L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getX() + (float)L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getWidth() / 2.0f, (float)L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getY() + (float)L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getHeight() / 2.0f, \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL, true, LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL);
        MemoryIndicatorComponent.mc.sfuiFontRender.drawStringWithShadow(MathHelper.clamp(Math.round(L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.memoryValue * 1000.0f) / 10, 0, 100) + "%", (float)L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getX() + (float)L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getWidth() / 3.0f + 1.0f, (float)L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getY() + (float)L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getHeight() / 2.0f + 3.0f, -1);
        MemoryIndicatorComponent.mc.sfuiFontRender.drawCenteredStringWithShadow("Memory", (float)L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getX() + (float)L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getWidth() / 2.0f, L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LL.getY() + 12, -1);
    }

    @Override
    public int getWidth() {
        return 50;
    }

    @Override
    public int getHeight() {
        return 55;
    }
}

