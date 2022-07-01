/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.hud;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender2D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;

public class Keystrokes
extends Feature {
    public int lastA = 0;
    public int lastW = 0;
    public int lastS = 0;
    public int lastD = 0;
    public long deltaAnim = 0L;

    public Keystrokes() {
        super("Keystrokes", "\u00d0\u009f\u00d0\u00be\u00d0\u00ba\u00d0\u00b0\u00d0\u00b7\u00d1\u008b\u00d0\u00b2\u00d0\u00b0\u00d0\u00b5\u00d1\u0082 \u00d0\u00bd\u00d0\u00b0\u00d0\u00b6\u00d0\u00b0\u00d1\u0082\u00d1\u008b\u00d0\u00b5 \u00d0\u00ba\u00d0\u00bb\u00d0\u00b0\u00d0\u00b2\u00d0\u00b8\u00d1\u0088\u00d0\u00b8", Type.Hud);
        Keystrokes LLL\u0445LLL\u0445\u0445\u0445\u0445LLLL;
    }

    @EventTarget
    public void onRender2D(EventRender2D \u0445LL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL) {
        Keystrokes LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL;
        int \u0445LLLL\u0445L\u0445\u0445\u0445\u0445LLLL;
        boolean L\u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL = Keystrokes.mc.gameSettings.keyBindLeft.pressed;
        boolean \u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL = Keystrokes.mc.gameSettings.keyBindForward.pressed;
        boolean LL\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL = Keystrokes.mc.gameSettings.keyBindBack.pressed;
        boolean \u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL = Keystrokes.mc.gameSettings.keyBindRight.pressed;
        int L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL = L\u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL ? 255 : 0;
        int \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL = \u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL ? 255 : 0;
        int LLLLL\u0445L\u0445\u0445\u0445\u0445LLLL = LL\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL ? 255 : 0;
        int n2 = \u0445LLLL\u0445L\u0445\u0445\u0445\u0445LLLL = \u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL ? 255 : 0;
        if (LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastA != L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL) {
            float LL\u0445L\u0445LL\u0445\u0445\u0445\u0445LLLL = L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL - LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastA;
            LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastA = (int)((float)LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastA + LL\u0445L\u0445LL\u0445\u0445\u0445\u0445LLLL / 40.0f);
        }
        if (LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastW != \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL) {
            float \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445LLLL = \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL - LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastW;
            LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastW = (int)((float)LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastW + \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445LLLL / 40.0f);
        }
        if (LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastS != LLLLL\u0445L\u0445\u0445\u0445\u0445LLLL) {
            float L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445LLLL = LLLLL\u0445L\u0445\u0445\u0445\u0445LLLL - LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastS;
            LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastS = (int)((float)LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastS + L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445LLLL / 40.0f);
        }
        if (LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastD != \u0445LLLL\u0445L\u0445\u0445\u0445\u0445LLLL) {
            float \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445LLLL = \u0445LLLL\u0445L\u0445\u0445\u0445\u0445LLLL - LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastD;
            LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastD = (int)((float)LLL\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL.lastD + \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445LLLL / 40.0f);
        }
    }
}

