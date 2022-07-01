/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.draggable;

import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Mouse;

public class DraggableComponent {
    private final int width;
    private final int height;
    private int x;
    private int y;
    private int color;
    private int lastX;
    private int lastY;
    private boolean dragging;
    private boolean canRender = true;

    public DraggableComponent(int \u0445L\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L, int L\u0445\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L, int \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L, int LLL\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445L, int \u0445LL\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445L) {
        DraggableComponent LL\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L;
        LL\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L.width = \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L;
        LL\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L.height = LLL\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445L;
        LL\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L.x = \u0445L\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L;
        LL\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L.y = L\u0445\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L;
        LL\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445L.color = \u0445LL\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445L;
    }

    public boolean isCanRender() {
        DraggableComponent \u0445LLLL\u0445\u0445\u0445\u0445LL\u0445\u0445L;
        return \u0445LLLL\u0445\u0445\u0445\u0445LL\u0445\u0445L.canRender;
    }

    public void setCanRender(boolean L\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L) {
        \u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L.canRender = L\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L;
    }

    public int getXPosition() {
        DraggableComponent L\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445\u0445L;
        return L\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445\u0445L.x;
    }

    public void setXPosition(int \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445\u0445L) {
        L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445\u0445L.x = \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445\u0445L;
    }

    public int getYPosition() {
        DraggableComponent \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L;
        return \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L.y;
    }

    public void setYPosition(int LLL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L) {
        \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L.y = LLL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L;
    }

    public int getHeight() {
        DraggableComponent LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L;
        return LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L.height;
    }

    public int getWidth() {
        DraggableComponent \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L;
        return \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L.width;
    }

    public int getColor() {
        DraggableComponent L\u0445LLLLLLL\u0445L\u0445\u0445L;
        return L\u0445LLLLLLL\u0445L\u0445\u0445L.color;
    }

    public void setColor(int \u0445\u0445\u0445LLLLLL\u0445L\u0445\u0445L) {
        L\u0445\u0445LLLLLL\u0445L\u0445\u0445L.color = \u0445\u0445\u0445LLLLLL\u0445L\u0445\u0445L;
    }

    public void draw(int L\u0445LLL\u0445LLL\u0445L\u0445\u0445L, int \u0445\u0445LLL\u0445LLL\u0445L\u0445\u0445L) {
        DraggableComponent \u0445LLLL\u0445LLL\u0445L\u0445\u0445L;
        if (\u0445LLLL\u0445LLL\u0445L\u0445\u0445L.canRender) {
            boolean LLLLL\u0445LLL\u0445L\u0445\u0445L;
            \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.draggingFix(L\u0445LLL\u0445LLL\u0445L\u0445\u0445L, \u0445\u0445LLL\u0445LLL\u0445L\u0445\u0445L);
            Gui.drawRect(\u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getXPosition(), \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getYPosition() - \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getHeight() / 4, \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getXPosition() + \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getWidth(), \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getYPosition() + \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getHeight(), \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getColor());
            boolean \u0445\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445L = L\u0445LLL\u0445LLL\u0445L\u0445\u0445L >= \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getXPosition() && L\u0445LLL\u0445LLL\u0445L\u0445\u0445L <= \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getXPosition() + \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getWidth();
            boolean bl2 = LLLLL\u0445LLL\u0445L\u0445\u0445L = \u0445\u0445LLL\u0445LLL\u0445L\u0445\u0445L >= \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getYPosition() - \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getHeight() / 4 && \u0445\u0445LLL\u0445LLL\u0445L\u0445\u0445L <= \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getYPosition() - \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getHeight() / 4 + \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.getHeight();
            if (\u0445\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445L && LLLLL\u0445LLL\u0445L\u0445\u0445L && Mouse.isButtonDown(0) && !\u0445LLLL\u0445LLL\u0445L\u0445\u0445L.dragging) {
                \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.lastX = \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.x - L\u0445LLL\u0445LLL\u0445L\u0445\u0445L;
                \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.lastY = \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.y - \u0445\u0445LLL\u0445LLL\u0445L\u0445\u0445L;
                \u0445LLLL\u0445LLL\u0445L\u0445\u0445L.dragging = true;
            }
        }
    }

    private void draggingFix(int \u0445\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445L, int LL\u0445\u0445\u0445\u0445LLL\u0445L\u0445\u0445L) {
        DraggableComponent L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445L;
        if (L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445L.dragging) {
            L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445L.x = \u0445\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445L + L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445L.lastX;
            L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445L.y = LL\u0445\u0445\u0445\u0445LLL\u0445L\u0445\u0445L + L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445L.lastY;
            if (!Mouse.isButtonDown(0)) {
                L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445L.dragging = false;
            }
        }
    }
}

