/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.newclickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.util.ResourceLocation;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.ui.newclickgui.FeaturePanel;
import org.Destroy.client.ui.newclickgui.SorterHelper;
import org.Destroy.client.ui.newclickgui.Theme;

public class Panel
implements Helper {
    public Type type;
    public int x;
    public int y;
    public int width;
    public int height;
    public int dragX;
    public int dragY;
    public boolean drag;
    public ArrayList<FeaturePanel> featurePanel = new ArrayList();
    public Theme theme = new Theme();
    private boolean open;

    public Panel(Type L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL, int LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLL, int L\u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445LLL) {
        Panel LL\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL;
        LL\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL.type = L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL;
        LL\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL.x = LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLL;
        LL\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL.y = L\u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445LLL;
        LL\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL.width = 105;
        LL\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL.height = 21;
        LL\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL.open = false;
        Iterator<Feature> L\u0445LLL\u0445L\u0445\u0445\u0445\u0445LLL = Destroy.instance.featureManager.getFeaturesForCategory(L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL).iterator();
        if (L\u0445LLL\u0445L\u0445\u0445\u0445\u0445LLL.hasNext()) {
            Feature L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LLL = L\u0445LLL\u0445L\u0445\u0445\u0445\u0445LLL.next();
            LL\u0445L\u0445LL\u0445\u0445\u0445\u0445LLL.featurePanel.add(new FeaturePanel(L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LLL));
            throw null;
        }
    }

    public void drawScreen(int \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL, int LLLL\u0445L\u0445\u0445\u0445\u0445\u0445LLL) {
        Iterator<FeaturePanel> L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LLL;
        Panel LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL;
        LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.featurePanel.sort(new SorterHelper());
        int L\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL = 0;
        Color \u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL = new Color(ClickGui.color.getColorValue());
        Color \u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL = new Color(ClickGui.colorTwo.getColorValue());
        double \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL = ClickGui.speed.getNumberValue();
        switch (ClickGui.clickGuiColor.currentMode) {
            case "Client": {
                L\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL = PaletteHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL / \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL + (double)((long)LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.y * 6L / 60L * 2L)) % 2.0 - 1.0));
                break;
            }
            case "Fade": {
                L\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL = PaletteHelper.fadeColor(\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL.getRGB(), \u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL.darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL / \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL + (double)((float)((long)LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.y * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Color Two": {
                L\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL = PaletteHelper.fadeColor(\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL.getRGB(), \u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL / \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL + (double)((float)((long)LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.y * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Astolfo": {
                L\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL = PaletteHelper.astolfo(true, LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.y).getRGB();
                break;
            }
            case "Static": {
                L\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL.getRGB();
                break;
            }
            case "Rainbow": {
                L\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
        RectHelper.drawRoundedRect((double)LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.x - 0.5, LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.y, (double)LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.width - 1.5, LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.height, 4.0f, new Color(20, 20, 20));
        RenderHelper.drawImage(new ResourceLocation("neverhook/clickguiicons/" + LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.type.getName().toLowerCase() + ".png"), LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.x + 4, LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.y + 4, 14.0f, 14.0f, new Color(L\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445LLL));
        Panel.mc.circleregular.drawCenteredStringWithOutline(LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.type.getName(), LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.x + LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.width / 2, (float)LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.y + (float)LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.height / 2.0f - 3.5f, Color.GRAY.getRGB());
        int \u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL = 0;
        if (LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.open && (L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LLL = LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.featurePanel.iterator()).hasNext()) {
            FeaturePanel L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445LLL = L\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LLL.next();
            L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.setPosition(LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.x, LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.y + LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.height + \u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL, LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.width, 15);
            L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.drawScreen(\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL, LLLL\u0445L\u0445\u0445\u0445\u0445\u0445LLL);
            \u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL += 15;
            return;
        }
        if (LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.drag) {
            LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.x = LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.dragX + \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL;
            LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.y = LL\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.dragY + LLLL\u0445L\u0445\u0445\u0445\u0445\u0445LLL;
        }
    }

    public void mouseReleased(int LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL, int \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL, int L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL) {
        Iterator<FeaturePanel> LL\u0445LLLLLLLL\u0445LL;
        Panel \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL;
        \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL.drag = false;
        if (\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL.open && (LL\u0445LLLLLLLL\u0445LL = \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL.featurePanel.iterator()).hasNext()) {
            FeaturePanel L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL = LL\u0445LLLLLLLL\u0445LL.next();
            L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL.mouseReleased(LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL, \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL, L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL);
            return;
        }
    }

    public void mouseClicked(int L\u0445L\u0445\u0445LLLLLL\u0445LL, int LL\u0445\u0445\u0445LLLLLL\u0445LL, int L\u0445\u0445\u0445\u0445LLLLLL\u0445LL) throws IOException {
        Iterator<FeaturePanel> LLL\u0445L\u0445LLLLL\u0445LL;
        Panel \u0445LL\u0445\u0445LLLLLL\u0445LL;
        if (\u0445LL\u0445\u0445LLLLLL\u0445LL.open && (LLL\u0445L\u0445LLLLL\u0445LL = \u0445LL\u0445\u0445LLLLLL\u0445LL.featurePanel.iterator()).hasNext()) {
            FeaturePanel \u0445\u0445\u0445L\u0445LLLLLL\u0445LL = LLL\u0445L\u0445LLLLL\u0445LL.next();
            \u0445\u0445\u0445L\u0445LLLLLL\u0445LL.mouseClicked(L\u0445L\u0445\u0445LLLLLL\u0445LL, LL\u0445\u0445\u0445LLLLLL\u0445LL, L\u0445\u0445\u0445\u0445LLLLLL\u0445LL);
            return;
        }
        if (Destroy.instance.newClickGui.usingSetting) {
            return;
        }
    }

    public void keyTyped(char L\u0445LL\u0445\u0445LLLLL\u0445LL, int \u0445\u0445LL\u0445\u0445LLLLL\u0445LL) throws IOException {
        Iterator<FeaturePanel> \u0445\u0445\u0445L\u0445\u0445LLLLL\u0445LL;
        Panel \u0445LLL\u0445\u0445LLLLL\u0445LL;
        if (\u0445LLL\u0445\u0445LLLLL\u0445LL.open && (\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445LL = \u0445LLL\u0445\u0445LLLLL\u0445LL.featurePanel.iterator()).hasNext()) {
            FeaturePanel LLLL\u0445\u0445LLLLL\u0445LL = \u0445\u0445\u0445L\u0445\u0445LLLLL\u0445LL.next();
            LLLL\u0445\u0445LLLLL\u0445LL.keyTyped(L\u0445LL\u0445\u0445LLLLL\u0445LL, \u0445\u0445LL\u0445\u0445LLLLL\u0445LL);
            return;
        }
    }

    public boolean isOpen() {
        Panel LL\u0445\u0445\u0445\u0445LLLLL\u0445LL;
        return LL\u0445\u0445\u0445\u0445LLLLL\u0445LL.open;
    }

    public void setOpen(boolean \u0445\u0445\u0445LLL\u0445LLLL\u0445LL) {
        \u0445L\u0445LLL\u0445LLLL\u0445LL.open = \u0445\u0445\u0445LLL\u0445LLLL\u0445LL;
    }

    public boolean isHovering(int LLL\u0445\u0445L\u0445LLLL\u0445LL, int L\u0445L\u0445\u0445L\u0445LLLL\u0445LL) {
        Panel L\u0445\u0445L\u0445L\u0445LLLL\u0445LL;
        return LLL\u0445\u0445L\u0445LLLL\u0445LL > L\u0445\u0445L\u0445L\u0445LLLL\u0445LL.x && LLL\u0445\u0445L\u0445LLLL\u0445LL < L\u0445\u0445L\u0445L\u0445LLLL\u0445LL.x + L\u0445\u0445L\u0445L\u0445LLLL\u0445LL.width && L\u0445L\u0445\u0445L\u0445LLLL\u0445LL > L\u0445\u0445L\u0445L\u0445LLLL\u0445LL.y && L\u0445L\u0445\u0445L\u0445LLLL\u0445LL < L\u0445\u0445L\u0445L\u0445LLLL\u0445LL.y + L\u0445\u0445L\u0445L\u0445LLLL\u0445LL.height;
    }

    public boolean isWithinHeader(int \u0445\u0445\u0445LL\u0445\u0445LLLL\u0445LL, int \u0445LL\u0445L\u0445\u0445LLLL\u0445LL) {
        Panel \u0445L\u0445LL\u0445\u0445LLLL\u0445LL;
        return \u0445\u0445\u0445LL\u0445\u0445LLLL\u0445LL >= \u0445L\u0445LL\u0445\u0445LLLL\u0445LL.x && \u0445\u0445\u0445LL\u0445\u0445LLLL\u0445LL <= \u0445L\u0445LL\u0445\u0445LLLL\u0445LL.x + \u0445L\u0445LL\u0445\u0445LLLL\u0445LL.width && \u0445LL\u0445L\u0445\u0445LLLL\u0445LL >= \u0445L\u0445LL\u0445\u0445LLLL\u0445LL.y && \u0445LL\u0445L\u0445\u0445LLLL\u0445LL <= \u0445L\u0445LL\u0445\u0445LLLL\u0445LL.y + \u0445L\u0445LL\u0445\u0445LLLL\u0445LL.height;
    }

    public int getX() {
        Panel \u0445\u0445\u0445\u0445L\u0445\u0445LLLL\u0445LL;
        return \u0445\u0445\u0445\u0445L\u0445\u0445LLLL\u0445LL.x;
    }

    public void setX(int L\u0445L\u0445\u0445\u0445\u0445LLLL\u0445LL) {
        LLL\u0445\u0445\u0445\u0445LLLL\u0445LL.x = L\u0445L\u0445\u0445\u0445\u0445LLLL\u0445LL;
    }

    public int getY() {
        Panel LLLLLLL\u0445LLL\u0445LL;
        return LLLLLLL\u0445LLL\u0445LL.y;
    }

    public void setY(int \u0445\u0445\u0445LLLL\u0445LLL\u0445LL) {
        \u0445L\u0445LLLL\u0445LLL\u0445LL.y = \u0445\u0445\u0445LLLL\u0445LLL\u0445LL;
    }

    public int getWidth() {
        Panel L\u0445\u0445\u0445LLL\u0445LLL\u0445LL;
        return L\u0445\u0445\u0445LLL\u0445LLL\u0445LL.width;
    }

    public void setWidth(int LLL\u0445\u0445LL\u0445LLL\u0445LL) {
        \u0445\u0445\u0445L\u0445LL\u0445LLL\u0445LL.width = LLL\u0445\u0445LL\u0445LLL\u0445LL;
    }

    public int getHeight() {
        Panel \u0445LLLL\u0445L\u0445LLL\u0445LL;
        return \u0445LLLL\u0445L\u0445LLL\u0445LL.height;
    }

    public void setHeight(int \u0445\u0445\u0445LL\u0445L\u0445LLL\u0445LL) {
        \u0445L\u0445LL\u0445L\u0445LLL\u0445LL.height = \u0445\u0445\u0445LL\u0445L\u0445LLL\u0445LL;
    }
}

