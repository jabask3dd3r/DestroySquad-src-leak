/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.font;

import java.awt.Font;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class FontUtil {
    public FontUtil() {
        FontUtil \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L;
    }

    public static Font getFontFromTTF(ResourceLocation \u0445L\u0445LLLLLL\u0445\u0445\u0445L\u0445L, float L\u0445\u0445LLLLLL\u0445\u0445\u0445L\u0445L, int \u0445\u0445\u0445LLLLLL\u0445\u0445\u0445L\u0445L) {
        try {
            Font \u0445\u0445LLLLLLL\u0445\u0445\u0445L\u0445L = Font.createFont(\u0445\u0445\u0445LLLLLL\u0445\u0445\u0445L\u0445L, Minecraft.getInstance().getResourceManager().getResource(\u0445L\u0445LLLLLL\u0445\u0445\u0445L\u0445L).getInputStream());
            \u0445\u0445LLLLLLL\u0445\u0445\u0445L\u0445L = \u0445\u0445LLLLLLL\u0445\u0445\u0445L\u0445L.deriveFont(L\u0445\u0445LLLLLL\u0445\u0445\u0445L\u0445L);
            return \u0445\u0445LLLLLLL\u0445\u0445\u0445L\u0445L;
        }
        catch (Exception LL\u0445LLLLLL\u0445\u0445\u0445L\u0445L) {
            return null;
        }
    }
}

