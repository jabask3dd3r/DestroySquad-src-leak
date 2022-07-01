/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.ColorSetting;

public class WorldColor
extends Feature {
    public static ColorSetting worldColor = new ColorSetting("World Color", new Color(-3919053, true).getRGB(), () -> true);

    public WorldColor() {
        super("WorldColor", "Changes the color of the game", Type.Visuals);
        WorldColor L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445L;
        L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL\u0445L.addSettings(worldColor);
    }
}

