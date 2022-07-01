/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.draggable;

import java.awt.Color;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.ui.components.draggable.DraggableComponent;

public class DraggableModule
implements Helper {
    public String name;
    public int x;
    public int y;
    public DraggableComponent drag;

    public DraggableModule(String \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL, int LLL\u0445\u0445\u0445L\u0445\u0445LL\u0445LL, int \u0445LL\u0445\u0445\u0445L\u0445\u0445LL\u0445LL) {
        DraggableModule L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL;
        L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL.name = \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL;
        L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL.x = LLL\u0445\u0445\u0445L\u0445\u0445LL\u0445LL;
        L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL.y = \u0445LL\u0445\u0445\u0445L\u0445\u0445LL\u0445LL;
        L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL.drag = new DraggableComponent(L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL.x, L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL.y, L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL.getWidth(), L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LL.getHeight(), new Color(255, 255, 255, 0).getRGB());
    }

    public void draw() {
    }

    public void render(int \u0445\u0445LLLL\u0445\u0445\u0445LL\u0445LL, int LL\u0445LLL\u0445\u0445\u0445LL\u0445LL) {
        DraggableModule L\u0445LLLL\u0445\u0445\u0445LL\u0445LL;
        L\u0445LLLL\u0445\u0445\u0445LL\u0445LL.drag.draw(\u0445\u0445LLLL\u0445\u0445\u0445LL\u0445LL, LL\u0445LLL\u0445\u0445\u0445LL\u0445LL);
    }

    public int getX() {
        DraggableModule \u0445LL\u0445LL\u0445\u0445\u0445LL\u0445LL;
        return \u0445LL\u0445LL\u0445\u0445\u0445LL\u0445LL.drag.getXPosition();
    }

    public void setX(int L\u0445\u0445\u0445LL\u0445\u0445\u0445LL\u0445LL) {
        \u0445L\u0445\u0445LL\u0445\u0445\u0445LL\u0445LL.x = L\u0445\u0445\u0445LL\u0445\u0445\u0445LL\u0445LL;
    }

    public String getName() {
        DraggableModule L\u0445LL\u0445L\u0445\u0445\u0445LL\u0445LL;
        return L\u0445LL\u0445L\u0445\u0445\u0445LL\u0445LL.name;
    }

    public void setName(String \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL\u0445LL) {
        L\u0445\u0445L\u0445L\u0445\u0445\u0445LL\u0445LL.name = \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL\u0445LL;
    }

    public int getY() {
        DraggableModule \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445LL;
        return \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445LL.drag.getYPosition();
    }

    public void setY(int LLLLL\u0445\u0445\u0445\u0445LL\u0445LL) {
        \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445LL.y = LLLLL\u0445\u0445\u0445\u0445LL\u0445LL;
    }

    public int getX2() {
        DraggableModule LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL;
        return LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445LL.x;
    }

    public void setX2(int \u0445LL\u0445L\u0445\u0445\u0445\u0445LL\u0445LL) {
        DraggableModule LLL\u0445L\u0445\u0445\u0445\u0445LL\u0445LL;
        LLL\u0445L\u0445\u0445\u0445\u0445LL\u0445LL.drag.setXPosition(\u0445LL\u0445L\u0445\u0445\u0445\u0445LL\u0445LL);
    }

    public int getY2() {
        DraggableModule \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LL;
        return \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LL.y;
    }

    public void setY2(int L\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LL) {
        DraggableModule \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LL;
        \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LL.drag.setYPosition(L\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LL);
    }

    public int getWidth() {
        return 50;
    }

    public int getHeight() {
        return 50;
    }
}

