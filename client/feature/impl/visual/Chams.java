/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;

public class Chams
extends Feature {
    public static ColorSetting colorChams;
    public static BooleanSetting clientColor;
    public static ListSetting chamsMode;

    public Chams() {
        super("WallHack", "Highlights players through walls", Type.Visuals);
        Chams \u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L;
        chamsMode = new ListSetting("Chams Mode", "Fill", () -> true, "Fill", "Outline", "Walls");
        clientColor = new BooleanSetting("Client Colored", false, () -> !Chams.chamsMode.currentMode.equals("Walls"));
        colorChams = new ColorSetting("Chams Color", new Color(0xFFFFFF).getRGB(), () -> !Chams.chamsMode.currentMode.equals("Walls") && !clientColor.getBoolValue());
        \u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L.addSettings(chamsMode, colorChams, clientColor);
    }
}

