/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.draggable;

import java.util.ArrayList;
import org.Destroy.client.ui.components.draggable.DraggableModule;
import org.Destroy.client.ui.components.draggable.impl.ClientInfoComponent;
import org.Destroy.client.ui.components.draggable.impl.InfoComponent;
import org.Destroy.client.ui.components.draggable.impl.KeybindComponent;
import org.Destroy.client.ui.components.draggable.impl.MemoryIndicatorComponent;
import org.Destroy.client.ui.components.draggable.impl.TargetHUDComponent;

public class DraggableManager {
    public ArrayList<DraggableModule> mods = new ArrayList();

    public DraggableManager() {
        DraggableManager L\u0445L\u0445\u0445LL\u0445L\u0445LLLL;
        L\u0445L\u0445\u0445LL\u0445L\u0445LLLL.mods.add(new ClientInfoComponent());
        L\u0445L\u0445\u0445LL\u0445L\u0445LLLL.mods.add(new InfoComponent());
        L\u0445L\u0445\u0445LL\u0445L\u0445LLLL.mods.add(new TargetHUDComponent());
        L\u0445L\u0445\u0445LL\u0445L\u0445LLLL.mods.add(new KeybindComponent());
        L\u0445L\u0445\u0445LL\u0445L\u0445LLLL.mods.add(new MemoryIndicatorComponent());
    }

    public ArrayList<DraggableModule> getMods() {
        DraggableManager \u0445L\u0445\u0445\u0445LL\u0445L\u0445LLLL;
        return \u0445L\u0445\u0445\u0445LL\u0445L\u0445LLLL.mods;
    }

    public void setMods(ArrayList<DraggableModule> L\u0445LLL\u0445L\u0445L\u0445LLLL) {
        \u0445LLLL\u0445L\u0445L\u0445LLLL.mods = L\u0445LLL\u0445L\u0445L\u0445LLLL;
    }
}

