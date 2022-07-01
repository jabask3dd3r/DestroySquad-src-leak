/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.clickgui.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.helpers.Helper;

public class Component
implements Helper {
    public final Component parent;
    protected final List<Component> components = new ArrayList<Component>();
    private final String name;
    private int x;
    private int y;
    private int width;
    private int height;

    public Component(Component \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L, String LLLLL\u0445L\u0445\u0445\u0445\u0445L, int \u0445LLLL\u0445L\u0445\u0445\u0445\u0445L, int L\u0445LLL\u0445L\u0445\u0445\u0445\u0445L, int \u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445L, int LL\u0445LL\u0445L\u0445\u0445\u0445\u0445L) {
        Component L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L;
        L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L.parent = \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L;
        L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L.name = LLLLL\u0445L\u0445\u0445\u0445\u0445L;
        L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L.x = \u0445LLLL\u0445L\u0445\u0445\u0445\u0445L;
        L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L.y = L\u0445LLL\u0445L\u0445\u0445\u0445\u0445L;
        L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L.width = \u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445L;
        L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L.height = LL\u0445LL\u0445L\u0445\u0445\u0445\u0445L;
    }

    public Component getParent() {
        Component LLLL\u0445\u0445L\u0445\u0445\u0445\u0445L;
        return LLLL\u0445\u0445L\u0445\u0445\u0445\u0445L.parent;
    }

    public void drawComponent(ScaledResolution L\u0445LLLL\u0445\u0445\u0445\u0445\u0445L, int LL\u0445LLL\u0445\u0445\u0445\u0445\u0445L, int L\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L) {
        Component \u0445LLLLL\u0445\u0445\u0445\u0445\u0445L;
        Iterator<Component> L\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L = \u0445LLLLL\u0445\u0445\u0445\u0445\u0445L.components.iterator();
        if (L\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L.hasNext()) {
            Component \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L = L\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L.next();
            \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.drawComponent(L\u0445LLLL\u0445\u0445\u0445\u0445\u0445L, LL\u0445LLL\u0445\u0445\u0445\u0445\u0445L, L\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L);
            return;
        }
    }

    public void onMouseClick(int \u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L, int \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L, int \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L) {
        Component L\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L;
        Iterator<Component> LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L = L\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L.components.iterator();
        if (LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L.hasNext()) {
            Component LLLLL\u0445\u0445\u0445\u0445\u0445\u0445L = LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L.next();
            LLLLL\u0445\u0445\u0445\u0445\u0445\u0445L.onMouseClick(\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L, \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L, \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L);
            return;
        }
    }

    public void onMouseRelease(int LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L) {
        Component \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L;
        Iterator<Component> \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L = \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L.components.iterator();
        if (\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L.hasNext()) {
            Component L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L = \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L.next();
            L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L.onMouseRelease(LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L);
            return;
        }
    }

    public void onKeyPress(int \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L) {
        Component L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L;
        Iterator<Component> L\u0445LLLLLLLLL = L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L.components.iterator();
        if (L\u0445LLLLLLLLL.hasNext()) {
            Component \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L = L\u0445LLLLLLLLL.next();
            \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L.onKeyPress(\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L);
            return;
        }
    }

    public String getName() {
        Component \u0445L\u0445LLLLLLLL;
        return \u0445L\u0445LLLLLLLL.name;
    }

    public int getX() {
        Component L\u0445L\u0445LLLLLLL;
        Component \u0445\u0445L\u0445LLLLLLL = L\u0445L\u0445LLLLLLL.parent;
        int LL\u0445\u0445LLLLLLL = L\u0445L\u0445LLLLLLL.x;
        if (\u0445\u0445L\u0445LLLLLLL != null) {
            LL\u0445\u0445LLLLLLL += \u0445\u0445L\u0445LLLLLLL.x;
            \u0445\u0445L\u0445LLLLLLL = \u0445\u0445L\u0445LLLLLLL.parent;
            return 0;
        }
        return LL\u0445\u0445LLLLLLL;
    }

    public void setX(int \u0445\u0445LL\u0445LLLLLL) {
        L\u0445LL\u0445LLLLLL.x = \u0445\u0445LL\u0445LLLLLL;
    }

    protected boolean isHovered(int \u0445L\u0445\u0445\u0445LLLLLL, int L\u0445\u0445\u0445\u0445LLLLLL) {
        int \u0445\u0445L\u0445\u0445LLLLLL;
        Component LL\u0445\u0445\u0445LLLLLL;
        int \u0445\u0445\u0445\u0445\u0445LLLLLL = LL\u0445\u0445\u0445LLLLLL.getX();
        return \u0445L\u0445\u0445\u0445LLLLLL >= \u0445\u0445\u0445\u0445\u0445LLLLLL && L\u0445\u0445\u0445\u0445LLLLLL >= (\u0445\u0445L\u0445\u0445LLLLLL = LL\u0445\u0445\u0445LLLLLL.getY()) && \u0445L\u0445\u0445\u0445LLLLLL < \u0445\u0445\u0445\u0445\u0445LLLLLL + LL\u0445\u0445\u0445LLLLLL.getWidth() && L\u0445\u0445\u0445\u0445LLLLLL < \u0445\u0445L\u0445\u0445LLLLLL + LL\u0445\u0445\u0445LLLLLL.getHeight();
    }

    public int getY() {
        Component LLL\u0445L\u0445LLLLL;
        Component \u0445LL\u0445L\u0445LLLLL = LLL\u0445L\u0445LLLLL.parent;
        int L\u0445L\u0445L\u0445LLLLL = LLL\u0445L\u0445LLLLL.y;
        if (\u0445LL\u0445L\u0445LLLLL != null) {
            L\u0445L\u0445L\u0445LLLLL += \u0445LL\u0445L\u0445LLLLL.y;
            \u0445LL\u0445L\u0445LLLLL = \u0445LL\u0445L\u0445LLLLL.parent;
            return 0;
        }
        return L\u0445L\u0445L\u0445LLLLL;
    }

    public void setY(int \u0445LLL\u0445\u0445LLLLL) {
        LLLL\u0445\u0445LLLLL.y = \u0445LLL\u0445\u0445LLLLL;
    }

    public int getWidth() {
        Component \u0445L\u0445L\u0445\u0445LLLLL;
        return \u0445L\u0445L\u0445\u0445LLLLL.width;
    }

    public void setWidth(int L\u0445L\u0445\u0445\u0445LLLLL) {
        \u0445LL\u0445\u0445\u0445LLLLL.width = L\u0445L\u0445\u0445\u0445LLLLL;
    }

    public int getHeight() {
        Component L\u0445\u0445\u0445\u0445\u0445LLLLL;
        return L\u0445\u0445\u0445\u0445\u0445LLLLL.height;
    }

    public void setHeight(int \u0445\u0445LLLL\u0445LLLL) {
        L\u0445LLLL\u0445LLLL.height = \u0445\u0445LLLL\u0445LLLL;
    }

    public List<Component> getComponents() {
        Component \u0445\u0445\u0445LLL\u0445LLLL;
        return \u0445\u0445\u0445LLL\u0445LLLL.components;
    }
}

