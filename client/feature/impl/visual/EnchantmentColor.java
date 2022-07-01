/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;

public class EnchantmentColor
extends Feature {
    public static ListSetting colorMode;
    public static ColorSetting customColor;

    public EnchantmentColor() {
        super("EnchantmentColor", "Changes the color of enchantments", Type.Visuals);
        EnchantmentColor \u0445L\u0445LLLLL\u0445\u0445\u0445L\u0445L;
        colorMode = new ListSetting("Crumbs Color", "Rainbow", () -> true, "Rainbow", "Client", "Custom");
        customColor = new ColorSetting("Custom Enchantment", new Color(0xFFFFFF).getRGB(), () -> EnchantmentColor.colorMode.currentMode.equals("Custom"));
        \u0445L\u0445LLLLL\u0445\u0445\u0445L\u0445L.addSettings(colorMode, customColor);
    }
}

