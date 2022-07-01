/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.draggable;

import java.util.Iterator;
import net.minecraft.client.gui.GuiScreen;
import org.Destroy.client.Destroy;
import org.Destroy.client.ui.components.draggable.DraggableModule;

public class GuiHudEditor
extends GuiScreen {
    public GuiHudEditor() {
        GuiHudEditor L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L;
    }

    @Override
    public void drawScreen(int LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L, int \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L, float L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L) {
        GuiHudEditor \u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
        \u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L.drawWorldBackground(0);
        Iterator<DraggableModule> \u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L = Destroy.instance.draggableManager.getMods().iterator();
        if (\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L.hasNext()) {
            DraggableModule L\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L = \u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L.next();
            L\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L.render(LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L, \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L);
            return;
        }
        super.drawScreen(LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L, \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L, L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L);
    }
}

