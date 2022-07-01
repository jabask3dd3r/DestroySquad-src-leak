/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import org.Destroy.client.Destroy;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;

public class Snow
extends Feature {
    public Snow() {
        super("Snow", "Makes always snow", Type.Visuals);
        Snow LL\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445LL;
    }

    public static boolean isEnabled() {
        return Destroy.instance.featureManager.getFeatureByClass(Snow.class).getState();
    }
}

