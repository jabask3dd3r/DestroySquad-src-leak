/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventFogColor;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class FogColor
extends Feature {
    public static NumberSetting distance;
    public ListSetting colorMode = new ListSetting("Fog Color", "Client", () -> true, "Rainbow", "Client", "Custom");
    public ColorSetting customColor;

    public FogColor() {
        super("FogColor", "Changes the color of the fog", Type.Visuals);
        FogColor L\u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445L;
        distance = new NumberSetting("Distance", 0.1f, 0.001f, 2.0f, 0.01f, () -> true);
        L\u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445L.customColor = new ColorSetting("Custom Fog", new Color(0xFFFFFF).getRGB(), () -> {
            FogColor \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L;
            return \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.colorMode.currentMode.equals("Custom");
        });
        L\u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445L.addSettings(L\u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445L.colorMode, distance, L\u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445L.customColor);
    }

    @EventTarget
    public void onFogColor(EventFogColor LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L) {
        FogColor \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L;
        String \u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L = \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.colorMode.getOptions();
        if (\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.equalsIgnoreCase("Rainbow")) {
            Color LL\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L = PaletteHelper.rainbow(1, 1.0f, 1.0f);
            LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.setRed(LL\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.getRed());
            LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.setGreen(LL\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.getGreen());
            LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.setBlue(LL\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.getBlue());
        } else if (\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.equalsIgnoreCase("Client")) {
            Color \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L = ClientHelper.getClientColor();
            LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.setRed(\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.getRed());
            LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.setGreen(\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.getGreen());
            LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.setBlue(\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.getBlue());
        } else if (\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.equalsIgnoreCase("Custom")) {
            Color L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L = new Color(\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.customColor.getColorValue());
            LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.setRed(L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.getRed());
            LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.setGreen(L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.getGreen());
            LLLL\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L.setBlue(L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L.getBlue());
        }
    }
}

