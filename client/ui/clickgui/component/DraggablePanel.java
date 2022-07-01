/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.clickgui.component;

import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.ui.clickgui.component.Component;
import org.Destroy.client.ui.clickgui.component.ExpandableComponent;

public abstract class DraggablePanel
extends ExpandableComponent {
    private boolean dragging;
    private int prevX;
    private int prevY;

    public DraggablePanel(Component \u0445\u0445\u0445LLL\u0445LL\u0445LLLLL, String LLL\u0445LL\u0445LL\u0445LLLLL, int \u0445LL\u0445LL\u0445LL\u0445LLLLL, int L\u0445L\u0445LL\u0445LL\u0445LLLLL, int \u0445\u0445L\u0445LL\u0445LL\u0445LLLLL, int LL\u0445\u0445LL\u0445LL\u0445LLLLL) {
        super(\u0445\u0445\u0445LLL\u0445LL\u0445LLLLL, LLL\u0445LL\u0445LL\u0445LLLLL, \u0445LL\u0445LL\u0445LL\u0445LLLLL, L\u0445L\u0445LL\u0445LL\u0445LLLLL, \u0445\u0445L\u0445LL\u0445LL\u0445LLLLL, LL\u0445\u0445LL\u0445LL\u0445LLLLL);
        DraggablePanel L\u0445\u0445LLL\u0445LL\u0445LLLLL;
        L\u0445\u0445LLL\u0445LL\u0445LLLLL.prevX = \u0445LL\u0445LL\u0445LL\u0445LLLLL;
        L\u0445\u0445LLL\u0445LL\u0445LLLLL.prevY = L\u0445L\u0445LL\u0445LL\u0445LLLLL;
    }

    @Override
    public void drawComponent(ScaledResolution LLL\u0445\u0445L\u0445LL\u0445LLLLL, int \u0445LL\u0445\u0445L\u0445LL\u0445LLLLL, int L\u0445L\u0445\u0445L\u0445LL\u0445LLLLL) {
        DraggablePanel \u0445\u0445\u0445L\u0445L\u0445LL\u0445LLLLL;
        if (\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLLLL.dragging) {
            \u0445\u0445\u0445L\u0445L\u0445LL\u0445LLLLL.setX(\u0445LL\u0445\u0445L\u0445LL\u0445LLLLL - \u0445\u0445\u0445L\u0445L\u0445LL\u0445LLLLL.prevX);
            \u0445\u0445\u0445L\u0445L\u0445LL\u0445LLLLL.setY(L\u0445L\u0445\u0445L\u0445LL\u0445LLLLL - \u0445\u0445\u0445L\u0445L\u0445LL\u0445LLLLL.prevY);
        }
    }

    @Override
    public void onPress(int \u0445\u0445LLL\u0445\u0445LL\u0445LLLLL, int LL\u0445LL\u0445\u0445LL\u0445LLLLL, int \u0445L\u0445LL\u0445\u0445LL\u0445LLLLL) {
        if (\u0445L\u0445LL\u0445\u0445LL\u0445LLLLL == 0) {
            DraggablePanel L\u0445LLL\u0445\u0445LL\u0445LLLLL;
            L\u0445LLL\u0445\u0445LL\u0445LLLLL.dragging = true;
            L\u0445LLL\u0445\u0445LL\u0445LLLLL.prevX = \u0445\u0445LLL\u0445\u0445LL\u0445LLLLL - L\u0445LLL\u0445\u0445LL\u0445LLLLL.getX();
            L\u0445LLL\u0445\u0445LL\u0445LLLLL.prevY = LL\u0445LL\u0445\u0445LL\u0445LLLLL - L\u0445LLL\u0445\u0445LL\u0445LLLLL.getY();
        }
    }

    @Override
    public void onMouseRelease(int \u0445L\u0445\u0445L\u0445\u0445LL\u0445LLLLL) {
        DraggablePanel LL\u0445\u0445L\u0445\u0445LL\u0445LLLLL;
        super.onMouseRelease(\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLLLL);
        LL\u0445\u0445L\u0445\u0445LL\u0445LLLLL.dragging = false;
    }
}

