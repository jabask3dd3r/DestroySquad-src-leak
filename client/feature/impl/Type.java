/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl;

import java.awt.Color;

public enum Type {
    Combat(new Color(220, 20, 60).getRGB(), new Color(137, 3, 42).getRGB(), "Combat"),
    Movement(new Color(123, 104, 238).getRGB(), new Color(73, 63, 151).getRGB(), "Movement"),
    Visuals(new Color(0, 206, 209).getRGB(), new Color(2, 121, 123).getRGB(), "Visuals"),
    Player(new Color(244, 164, 96).getRGB(), new Color(132, 68, 9).getRGB(), "Player"),
    Misc(new Color(60, 179, 113).getRGB(), new Color(28, 88, 57).getRGB(), "Misc"),
    Hud(new Color(186, 85, 211).getRGB(), new Color(91, 41, 102).getRGB(), "Hud");

    private final int color;
    private final int color2;
    public String name;

    private Type(int L\u0445LLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L, int \u0445\u0445LLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L, String LL\u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L) {
        Type \u0445LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L;
        \u0445LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L.color = L\u0445LLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L;
        \u0445LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L.color2 = \u0445\u0445LLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L;
        \u0445LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L.name = LL\u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L;
    }

    public String getName() {
        Type LL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L;
        return LL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L.name;
    }

    public int getColor() {
        Type \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L;
        return \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L.color;
    }

    public int getColor2() {
        Type L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L;
        return L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L.color2;
    }
}

