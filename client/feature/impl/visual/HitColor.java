/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.ColorSetting;

public class HitColor
extends Feature {
    public static ColorSetting hitColor = new ColorSetting("Hit Color", Color.RED.getRGB(), () -> true);

    public HitColor() {
        super("HitColor", "Changes the color of the hit", Type.Visuals);
        HitColor L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L;
        L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L.addSettings(hitColor);
    }
}

