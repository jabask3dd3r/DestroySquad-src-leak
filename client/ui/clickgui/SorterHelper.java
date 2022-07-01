/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.clickgui;

import java.util.Comparator;
import org.Destroy.client.ui.clickgui.component.Component;
import org.Destroy.client.ui.clickgui.component.impl.ModuleComponent;

public class SorterHelper
implements Comparator<Component> {
    public SorterHelper() {
        SorterHelper LL\u0445\u0445L\u0445L\u0445LLLLLLL;
    }

    @Override
    public int compare(Component \u0445LLL\u0445\u0445L\u0445LLLLLLL, Component L\u0445LL\u0445\u0445L\u0445LLLLLLL) {
        if (\u0445LLL\u0445\u0445L\u0445LLLLLLL instanceof ModuleComponent && L\u0445LL\u0445\u0445L\u0445LLLLLLL instanceof ModuleComponent) {
            return \u0445LLL\u0445\u0445L\u0445LLLLLLL.getName().compareTo(L\u0445LL\u0445\u0445L\u0445LLLLLLL.getName());
        }
        return 0;
    }
}

