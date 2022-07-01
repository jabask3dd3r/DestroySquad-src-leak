/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.clickgui;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.ScaledResolution;
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
import org.Destroy.client.ui.clickgui.SorterHelper;
import org.Destroy.client.ui.clickgui.component.AnimationState;
import org.Destroy.client.ui.clickgui.component.Component;
import org.Destroy.client.ui.clickgui.component.DraggablePanel;
import org.Destroy.client.ui.clickgui.component.ExpandableComponent;
import org.Destroy.client.ui.clickgui.component.impl.ModuleComponent;

public final class Panel
extends DraggablePanel
implements Helper {
    public static final int HEADER_WIDTH = 120;
    public static final int X_ITEM_OFFSET = 1;
    public static final int ITEM_HEIGHT = 15;
    public static final int HEADER_HEIGHT = 17;
    private final List<Feature> features;
    public Type type;
    public AnimationState state;
    private int prevX;
    private int prevY;
    private boolean dragging;

    public Panel(Type \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL, int LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL, int \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL) {
        super(null, \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL.name(), LL\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL, \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL, 120, 17);
        Panel L\u0445L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL;
        int L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL = 17;
        L\u0445L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL.state = AnimationState.STATIC;
        L\u0445L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL.features = Destroy.instance.featureManager.getFeaturesForCategory(\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL);
        Iterator<Feature> LL\u0445LLLL\u0445\u0445LLL\u0445LL = L\u0445L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL.features.iterator();
        if (LL\u0445LLLL\u0445\u0445LLL\u0445LL.hasNext()) {
            Feature \u0445LL\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL = LL\u0445LLLL\u0445\u0445LLL\u0445LL.next();
            L\u0445L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL.components.add(new ModuleComponent((Component)L\u0445L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL, \u0445LL\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL, 1, L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL, 118, 15));
            L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL += 15;
            throw null;
        }
        L\u0445L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL.type = \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LL;
    }

    @Override
    public void drawComponent(ScaledResolution \u0445L\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL, int L\u0445\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL, int \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL) {
        Iterator L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL\u0445LL;
        Panel LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL;
        LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.components.sort(new SorterHelper());
        if (LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.dragging) {
            LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.setX(L\u0445\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL - LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.prevX);
            LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.setY(\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL - LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.prevY);
        }
        int LLLLL\u0445L\u0445\u0445LLL\u0445LL = LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.getX();
        int \u0445LLLL\u0445L\u0445\u0445LLL\u0445LL = LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.getY();
        int L\u0445LLL\u0445L\u0445\u0445LLL\u0445LL = LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.getWidth();
        int \u0445\u0445LLL\u0445L\u0445\u0445LLL\u0445LL = LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.getHeight();
        int \u0445L\u0445LL\u0445L\u0445\u0445LLL\u0445LL = LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.getHeightWithExpand();
        int LL\u0445LL\u0445L\u0445\u0445LLL\u0445LL = LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.isExpanded() ? \u0445L\u0445LL\u0445L\u0445\u0445LLL\u0445LL : \u0445\u0445LLL\u0445L\u0445\u0445LLL\u0445LL;
        int L\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL = 0;
        Color \u0445\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL = new Color(ClickGui.color.getColorValue());
        Color LLL\u0445L\u0445L\u0445\u0445LLL\u0445LL = new Color(ClickGui.colorTwo.getColorValue());
        double \u0445LL\u0445L\u0445L\u0445\u0445LLL\u0445LL = ClickGui.speed.getNumberValue();
        switch (ClickGui.clickGuiColor.currentMode) {
            case "Client": {
                L\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL = PaletteHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445LL\u0445L\u0445L\u0445\u0445LLL\u0445LL / \u0445LL\u0445L\u0445L\u0445\u0445LLL\u0445LL + (double)((long)\u0445LLLL\u0445L\u0445\u0445LLL\u0445LL * 6L / 60L * 2L)) % 2.0 - 1.0));
                break;
            }
            case "Fade": {
                L\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL = PaletteHelper.fadeColor(\u0445\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL.getRGB(), \u0445\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL.darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445LL\u0445L\u0445L\u0445\u0445LLL\u0445LL / \u0445LL\u0445L\u0445L\u0445\u0445LLL\u0445LL + (double)((float)((long)\u0445LLLL\u0445L\u0445\u0445LLL\u0445LL * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Color Two": {
                L\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL = PaletteHelper.fadeColor(\u0445\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL.getRGB(), LLL\u0445L\u0445L\u0445\u0445LLL\u0445LL.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445LL\u0445L\u0445L\u0445\u0445LLL\u0445LL / \u0445LL\u0445L\u0445L\u0445\u0445LLL\u0445LL + (double)((float)((long)\u0445LLLL\u0445L\u0445\u0445LLL\u0445LL * 6L) / 60.0f * 2.0f)) % 2.0 - 1.0));
                break;
            }
            case "Astolfo": {
                L\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL = PaletteHelper.astolfo(true, \u0445LLLL\u0445L\u0445\u0445LLL\u0445LL).getRGB();
                break;
            }
            case "Static": {
                L\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL = \u0445\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL.getRGB();
                break;
            }
            case "Rainbow": {
                L\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
        float L\u0445L\u0445L\u0445L\u0445\u0445LLL\u0445LL = 2.0f;
        RectHelper.drawSmoothRect(LLLLL\u0445L\u0445\u0445LLL\u0445LL, \u0445LLLL\u0445L\u0445\u0445LLL\u0445LL - 4, LLLLL\u0445L\u0445\u0445LLL\u0445LL + L\u0445LLL\u0445L\u0445\u0445LLL\u0445LL, (float)(\u0445LLLL\u0445L\u0445\u0445LLL\u0445LL + LL\u0445LL\u0445L\u0445\u0445LLL\u0445LL) - L\u0445L\u0445L\u0445L\u0445\u0445LLL\u0445LL, new Color(26, 26, 26).getRGB());
        RenderHelper.drawImage(new ResourceLocation("neverhook/clickguiicons/" + LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.type.getName() + ".png"), LLLLL\u0445L\u0445\u0445LLL\u0445LL + 4, \u0445LLLL\u0445L\u0445\u0445LLL\u0445LL - 1, 14.0f, 14.0f, new Color(L\u0445\u0445LL\u0445L\u0445\u0445LLL\u0445LL));
        Panel.mc.montserratRegular.drawStringWithShadow(LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.getName(), LLLLL\u0445L\u0445\u0445LLL\u0445LL + 22, (float)\u0445LLLL\u0445L\u0445\u0445LLL\u0445LL + 8.5f - 6.0f, Color.LIGHT_GRAY.getRGB());
        super.drawComponent(\u0445L\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL, L\u0445\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL, \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL);
        if (LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.isExpanded() && (L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL\u0445LL = LL\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL.components.iterator()).hasNext()) {
            ExpandableComponent \u0445LL\u0445\u0445LL\u0445\u0445LLL\u0445LL;
            Component \u0445\u0445L\u0445\u0445LL\u0445\u0445LLL\u0445LL = (Component)L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL\u0445LL.next();
            \u0445\u0445L\u0445\u0445LL\u0445\u0445LLL\u0445LL.setY(\u0445\u0445LLL\u0445L\u0445\u0445LLL\u0445LL);
            \u0445\u0445L\u0445\u0445LL\u0445\u0445LLL\u0445LL.drawComponent(\u0445L\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL, L\u0445\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL, \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445LLL\u0445LL);
            int L\u0445L\u0445\u0445LL\u0445\u0445LLL\u0445LL = \u0445\u0445L\u0445\u0445LL\u0445\u0445LLL\u0445LL.getHeight();
            if (\u0445\u0445L\u0445\u0445LL\u0445\u0445LLL\u0445LL instanceof ExpandableComponent && (\u0445LL\u0445\u0445LL\u0445\u0445LLL\u0445LL = (ExpandableComponent)\u0445\u0445L\u0445\u0445LL\u0445\u0445LLL\u0445LL).isExpanded()) {
                L\u0445L\u0445\u0445LL\u0445\u0445LLL\u0445LL = \u0445LL\u0445\u0445LL\u0445\u0445LLL\u0445LL.getHeightWithExpand() + 5;
            }
            \u0445\u0445LLL\u0445L\u0445\u0445LLL\u0445LL += L\u0445L\u0445\u0445LL\u0445\u0445LLL\u0445LL;
            return;
        }
    }

    @Override
    public void onPress(int \u0445\u0445LLLL\u0445\u0445\u0445LLL\u0445LL, int LL\u0445LLL\u0445\u0445\u0445LLL\u0445LL, int L\u0445\u0445LLL\u0445\u0445\u0445LLL\u0445LL) {
        Panel L\u0445LLLL\u0445\u0445\u0445LLL\u0445LL;
        if (L\u0445\u0445LLL\u0445\u0445\u0445LLL\u0445LL == 0 && !L\u0445LLLL\u0445\u0445\u0445LLL\u0445LL.dragging) {
            L\u0445LLLL\u0445\u0445\u0445LLL\u0445LL.dragging = true;
            L\u0445LLLL\u0445\u0445\u0445LLL\u0445LL.prevX = \u0445\u0445LLLL\u0445\u0445\u0445LLL\u0445LL - L\u0445LLLL\u0445\u0445\u0445LLL\u0445LL.getX();
            L\u0445LLLL\u0445\u0445\u0445LLL\u0445LL.prevY = LL\u0445LLL\u0445\u0445\u0445LLL\u0445LL - L\u0445LLLL\u0445\u0445\u0445LLL\u0445LL.getY();
        }
    }

    @Override
    public void onMouseRelease(int L\u0445\u0445L\u0445L\u0445\u0445\u0445LLL\u0445LL) {
        Panel LL\u0445L\u0445L\u0445\u0445\u0445LLL\u0445LL;
        super.onMouseRelease(L\u0445\u0445L\u0445L\u0445\u0445\u0445LLL\u0445LL);
        LL\u0445L\u0445L\u0445\u0445\u0445LLL\u0445LL.dragging = false;
    }

    @Override
    public boolean canExpand() {
        Panel \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL;
        return !\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL.features.isEmpty();
    }

    @Override
    public int getHeightWithExpand() {
        Iterator \u0445LLL\u0445\u0445\u0445\u0445\u0445LLL\u0445LL;
        Panel \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL;
        int L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL = \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL.getHeight();
        if (\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL.isExpanded() && (\u0445LLL\u0445\u0445\u0445\u0445\u0445LLL\u0445LL = \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL.components.iterator()).hasNext()) {
            ExpandableComponent L\u0445L\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL;
            Component LL\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL = (Component)\u0445LLL\u0445\u0445\u0445\u0445\u0445LLL\u0445LL.next();
            int \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL = LL\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL.getHeight();
            if (LL\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL instanceof ExpandableComponent && (L\u0445L\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL = (ExpandableComponent)LL\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL).isExpanded()) {
                \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL = L\u0445L\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL.getHeightWithExpand() + 5;
            }
            L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL += \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL;
            return 0;
        }
        return L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445LL;
    }
}

