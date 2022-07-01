/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.newclickgui;

import java.util.Comparator;
import org.Destroy.client.ui.newclickgui.FeaturePanel;

public class SorterHelper
implements Comparator<FeaturePanel> {
    public SorterHelper() {
        SorterHelper \u0445LL\u0445\u0445\u0445LL\u0445\u0445L\u0445L;
    }

    @Override
    public int compare(FeaturePanel L\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L, FeaturePanel \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L) {
        if (L\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L != null && \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L != null) {
            return L\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L.feature.getLabel().compareTo(\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L.feature.getLabel());
        }
        return 0;
    }
}

