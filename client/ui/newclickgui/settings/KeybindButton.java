/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.newclickgui.settings;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.helpers.Helper;
import org.lwjgl.input.Keyboard;

public class KeybindButton
implements Helper {
    private final Feature feature;
    public boolean isBinding;
    private int x;
    private int y;
    private int width;
    private int height;

    public KeybindButton(Feature LLL\u0445L\u0445LLLLL\u0445\u0445\u0445L) {
        KeybindButton \u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445\u0445L;
        \u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445\u0445L.feature = LLL\u0445L\u0445LLLLL\u0445\u0445\u0445L;
    }

    public void drawScreen() {
        KeybindButton \u0445\u0445\u0445\u0445L\u0445LLLLL\u0445\u0445\u0445L;
        String LLLL\u0445\u0445LLLLL\u0445\u0445\u0445L = \u0445\u0445\u0445\u0445L\u0445LLLLL\u0445\u0445\u0445L.isBinding ? "..." : Keyboard.getKeyName(\u0445\u0445\u0445\u0445L\u0445LLLLL\u0445\u0445\u0445L.feature.getBind());
        String \u0445LLL\u0445\u0445LLLLL\u0445\u0445\u0445L = ">> " + (Object)((Object)ChatFormatting.GRAY) + "Keybind: " + LLLL\u0445\u0445LLLLL\u0445\u0445\u0445L;
        ScaledResolution L\u0445LL\u0445\u0445LLLLL\u0445\u0445\u0445L = new ScaledResolution(Minecraft.getInstance());
        KeybindButton.mc.circleregular.drawStringWithShadow(\u0445LLL\u0445\u0445LLLLL\u0445\u0445\u0445L, (float)L\u0445LL\u0445\u0445LLLLL\u0445\u0445\u0445L.getScaledWidth() / 2.0f - 140.0f, (float)\u0445\u0445\u0445\u0445L\u0445LLLLL\u0445\u0445\u0445L.y + (float)\u0445\u0445\u0445\u0445L\u0445LLLLL\u0445\u0445\u0445L.height / 2.0f - (float)KeybindButton.mc.circleregular.getFontHeight() / 2.0f - 3.0f, new Color(123, 153, 183).getRGB());
    }

    public void mouseClicked(int LL\u0445\u0445\u0445\u0445LLLLL\u0445\u0445\u0445L, int \u0445L\u0445\u0445\u0445\u0445LLLLL\u0445\u0445\u0445L, int L\u0445\u0445\u0445\u0445\u0445LLLLL\u0445\u0445\u0445L) throws IOException {
        KeybindButton \u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445\u0445L;
        KeybindButton keybindButton = \u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445\u0445L;
        int n2 = LL\u0445\u0445\u0445\u0445LLLLL\u0445\u0445\u0445L;
        if (\u0445L\u0445\u0445\u0445\u0445LLLLL\u0445\u0445\u0445L != 0 && L\u0445\u0445\u0445\u0445\u0445LLLLL\u0445\u0445\u0445L == 0) {
            \u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445\u0445L.isBinding = true;
        }
    }

    public void keyTyped(int \u0445\u0445\u0445LLL\u0445LLLL\u0445\u0445\u0445L) {
        int LLL\u0445LL\u0445LLLL\u0445\u0445\u0445L;
        KeybindButton L\u0445\u0445LLL\u0445LLLL\u0445\u0445\u0445L;
        if (!L\u0445\u0445LLL\u0445LLLL\u0445\u0445\u0445L.isBinding) {
            return;
        }
        if (\u0445\u0445\u0445LLL\u0445LLLL\u0445\u0445\u0445L == 1) {
            L\u0445\u0445LLL\u0445LLLL\u0445\u0445\u0445L.isBinding = false;
        }
        int n2 = LLL\u0445LL\u0445LLLL\u0445\u0445\u0445L = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
        if (\u0445\u0445\u0445LLL\u0445LLLL\u0445\u0445\u0445L == 211) {
            L\u0445\u0445LLL\u0445LLLL\u0445\u0445\u0445L.feature.setBind(0);
        } else if (\u0445\u0445\u0445LLL\u0445LLLL\u0445\u0445\u0445L == 54) {
            L\u0445\u0445LLL\u0445LLLL\u0445\u0445\u0445L.feature.setBind(54);
        } else {
            L\u0445\u0445LLL\u0445LLLL\u0445\u0445\u0445L.feature.setBind(LLL\u0445LL\u0445LLLL\u0445\u0445\u0445L);
        }
        L\u0445\u0445LLL\u0445LLLL\u0445\u0445\u0445L.isBinding = false;
    }

    public void setPosition(int L\u0445LL\u0445L\u0445LLLL\u0445\u0445\u0445L, int \u0445\u0445LL\u0445L\u0445LLLL\u0445\u0445\u0445L, int LL\u0445L\u0445L\u0445LLLL\u0445\u0445\u0445L, int \u0445L\u0445L\u0445L\u0445LLLL\u0445\u0445\u0445L) {
        \u0445LLL\u0445L\u0445LLLL\u0445\u0445\u0445L.x = L\u0445LL\u0445L\u0445LLLL\u0445\u0445\u0445L;
        \u0445LLL\u0445L\u0445LLLL\u0445\u0445\u0445L.y = \u0445\u0445LL\u0445L\u0445LLLL\u0445\u0445\u0445L;
        \u0445LLL\u0445L\u0445LLLL\u0445\u0445\u0445L.width = LL\u0445L\u0445L\u0445LLLL\u0445\u0445\u0445L;
        \u0445LLL\u0445L\u0445LLLL\u0445\u0445\u0445L.height = \u0445L\u0445L\u0445L\u0445LLLL\u0445\u0445\u0445L;
    }
}

