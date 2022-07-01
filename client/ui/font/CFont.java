/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.font;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;

public class CFont {
    private final float imgSize = 512.0f;
    protected CharData[] charData = new CharData[256];
    protected Font font;
    protected boolean antiAlias;
    protected boolean fractionalMetrics;
    protected int fontHeight = -1;
    protected int charOffset = 0;
    protected DynamicTexture tex;

    public CFont(Font L\u0445\u0445L\u0445\u0445LL, boolean \u0445\u0445\u0445L\u0445\u0445LL, boolean LLL\u0445\u0445\u0445LL) {
        CFont \u0445L\u0445L\u0445\u0445LL;
        \u0445L\u0445L\u0445\u0445LL.font = L\u0445\u0445L\u0445\u0445LL;
        \u0445L\u0445L\u0445\u0445LL.antiAlias = \u0445\u0445\u0445L\u0445\u0445LL;
        \u0445L\u0445L\u0445\u0445LL.fractionalMetrics = LLL\u0445\u0445\u0445LL;
        \u0445L\u0445L\u0445\u0445LL.tex = \u0445L\u0445L\u0445\u0445LL.setupTexture(L\u0445\u0445L\u0445\u0445LL, \u0445\u0445\u0445L\u0445\u0445LL, LLL\u0445\u0445\u0445LL, \u0445L\u0445L\u0445\u0445LL.charData);
    }

    protected DynamicTexture setupTexture(Font L\u0445\u0445LLL\u0445L, boolean \u0445\u0445\u0445LLL\u0445L, boolean LLL\u0445LL\u0445L, CharData[] \u0445LL\u0445LL\u0445L) {
        CFont \u0445L\u0445LLL\u0445L;
        BufferedImage L\u0445L\u0445LL\u0445L = \u0445L\u0445LLL\u0445L.generateFontImage(L\u0445\u0445LLL\u0445L, \u0445\u0445\u0445LLL\u0445L, LLL\u0445LL\u0445L, \u0445LL\u0445LL\u0445L);
        try {
            return new DynamicTexture(L\u0445L\u0445LL\u0445L);
        }
        catch (Exception LL\u0445LLL\u0445L) {
            LL\u0445LLL\u0445L.printStackTrace();
            return null;
        }
    }

    protected BufferedImage generateFontImage(Font \u0445\u0445\u0445LL\u0445\u0445L, boolean LLL\u0445L\u0445\u0445L, boolean \u0445LL\u0445L\u0445\u0445L, CharData[] L\u0445L\u0445L\u0445\u0445L) {
        CFont L\u0445\u0445LL\u0445\u0445L;
        L\u0445\u0445LL\u0445\u0445L.getClass();
        int \u0445\u0445L\u0445L\u0445\u0445L = 512;
        BufferedImage LL\u0445\u0445L\u0445\u0445L = new BufferedImage(\u0445\u0445L\u0445L\u0445\u0445L, \u0445\u0445L\u0445L\u0445\u0445L, 2);
        Graphics2D \u0445L\u0445\u0445L\u0445\u0445L = (Graphics2D)LL\u0445\u0445L\u0445\u0445L.getGraphics();
        \u0445L\u0445\u0445L\u0445\u0445L.setFont(\u0445\u0445\u0445LL\u0445\u0445L);
        \u0445L\u0445\u0445L\u0445\u0445L.setColor(new Color(255, 255, 255, 0));
        \u0445L\u0445\u0445L\u0445\u0445L.fillRect(0, 0, \u0445\u0445L\u0445L\u0445\u0445L, \u0445\u0445L\u0445L\u0445\u0445L);
        \u0445L\u0445\u0445L\u0445\u0445L.setColor(Color.WHITE);
        \u0445L\u0445\u0445L\u0445\u0445L.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, \u0445LL\u0445L\u0445\u0445L ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        \u0445L\u0445\u0445L\u0445\u0445L.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, LLL\u0445L\u0445\u0445L ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        \u0445L\u0445\u0445L\u0445\u0445L.setRenderingHint(RenderingHints.KEY_ANTIALIASING, LLL\u0445L\u0445\u0445L ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        FontMetrics L\u0445\u0445\u0445L\u0445\u0445L = \u0445L\u0445\u0445L\u0445\u0445L.getFontMetrics();
        int \u0445\u0445\u0445\u0445L\u0445\u0445L = 0;
        int LLLL\u0445\u0445\u0445L = 0;
        int \u0445LLL\u0445\u0445\u0445L = 1;
        int \u0445L\u0445LL\u0445\u0445L = 0;
        if (\u0445L\u0445LL\u0445\u0445L < L\u0445L\u0445L\u0445\u0445L.length) {
            char L\u0445LLL\u0445\u0445L = (char)\u0445L\u0445LL\u0445\u0445L;
            CharData \u0445\u0445LLL\u0445\u0445L = new CharData();
            Rectangle2D LL\u0445LL\u0445\u0445L = L\u0445\u0445\u0445L\u0445\u0445L.getStringBounds(String.valueOf(L\u0445LLL\u0445\u0445L), \u0445L\u0445\u0445L\u0445\u0445L);
            \u0445\u0445LLL\u0445\u0445L.width = LL\u0445LL\u0445\u0445L.getBounds().width + 8;
            \u0445\u0445LLL\u0445\u0445L.height = LL\u0445LL\u0445\u0445L.getBounds().height;
            if (LLLL\u0445\u0445\u0445L + \u0445\u0445LLL\u0445\u0445L.width >= \u0445\u0445L\u0445L\u0445\u0445L) {
                LLLL\u0445\u0445\u0445L = 0;
                \u0445LLL\u0445\u0445\u0445L += \u0445\u0445\u0445\u0445L\u0445\u0445L;
                \u0445\u0445\u0445\u0445L\u0445\u0445L = 0;
            }
            if (\u0445\u0445LLL\u0445\u0445L.height > \u0445\u0445\u0445\u0445L\u0445\u0445L) {
                \u0445\u0445\u0445\u0445L\u0445\u0445L = \u0445\u0445LLL\u0445\u0445L.height;
            }
            \u0445\u0445LLL\u0445\u0445L.storedX = LLLL\u0445\u0445\u0445L;
            \u0445\u0445LLL\u0445\u0445L.storedY = \u0445LLL\u0445\u0445\u0445L;
            if (\u0445\u0445LLL\u0445\u0445L.height > L\u0445\u0445LL\u0445\u0445L.fontHeight) {
                L\u0445\u0445LL\u0445\u0445L.fontHeight = \u0445\u0445LLL\u0445\u0445L.height;
            }
            L\u0445L\u0445L\u0445\u0445L[\u0445L\u0445LL\u0445\u0445L] = \u0445\u0445LLL\u0445\u0445L;
            \u0445L\u0445\u0445L\u0445\u0445L.drawString(String.valueOf(L\u0445LLL\u0445\u0445L), LLLL\u0445\u0445\u0445L + 2, \u0445LLL\u0445\u0445\u0445L + L\u0445\u0445\u0445L\u0445\u0445L.getAscent());
            LLLL\u0445\u0445\u0445L += \u0445\u0445LLL\u0445\u0445L.width;
            ++\u0445L\u0445LL\u0445\u0445L;
            return null;
        }
        return LL\u0445\u0445L\u0445\u0445L;
    }

    public void drawChar(CharData[] L\u0445L\u0445LLL, char \u0445\u0445L\u0445LLL, float LL\u0445\u0445LLL, float \u0445L\u0445\u0445LLL) throws ArrayIndexOutOfBoundsException {
        try {
            CFont \u0445LL\u0445LLL;
            \u0445LL\u0445LLL.drawQuad(LL\u0445\u0445LLL, \u0445L\u0445\u0445LLL, L\u0445L\u0445LLL[\u0445\u0445L\u0445LLL].width, L\u0445L\u0445LLL[\u0445\u0445L\u0445LLL].height, L\u0445L\u0445LLL[\u0445\u0445L\u0445LLL].storedX, L\u0445L\u0445LLL[\u0445\u0445L\u0445LLL].storedY, L\u0445L\u0445LLL[\u0445\u0445L\u0445LLL].width, L\u0445L\u0445LLL[\u0445\u0445L\u0445LLL].height);
        }
        catch (Exception LLL\u0445LLL) {
            LLL\u0445LLL.printStackTrace();
        }
    }

    protected void drawQuad(float L\u0445LLL\u0445L, float \u0445\u0445LLL\u0445L, float LL\u0445LL\u0445L, float \u0445L\u0445LL\u0445L, float L\u0445\u0445LL\u0445L, float \u0445\u0445\u0445LL\u0445L, float LLL\u0445L\u0445L, float \u0445LL\u0445L\u0445L) {
        CFont \u0445LLLL\u0445L;
        float L\u0445L\u0445L\u0445L = L\u0445\u0445LL\u0445L / \u0445LLLL\u0445L.imgSize;
        float \u0445\u0445L\u0445L\u0445L = \u0445\u0445\u0445LL\u0445L / \u0445LLLL\u0445L.imgSize;
        float LL\u0445\u0445L\u0445L = LLL\u0445L\u0445L / \u0445LLLL\u0445L.imgSize;
        float \u0445L\u0445\u0445L\u0445L = \u0445LL\u0445L\u0445L / \u0445LLLL\u0445L.imgSize;
        GL11.glTexCoord2f(L\u0445L\u0445L\u0445L + LL\u0445\u0445L\u0445L, \u0445\u0445L\u0445L\u0445L);
        GL11.glVertex2d(L\u0445LLL\u0445L + LL\u0445LL\u0445L, \u0445\u0445LLL\u0445L);
        GL11.glTexCoord2f(L\u0445L\u0445L\u0445L, \u0445\u0445L\u0445L\u0445L);
        GL11.glVertex2d(L\u0445LLL\u0445L, \u0445\u0445LLL\u0445L);
        GL11.glTexCoord2f(L\u0445L\u0445L\u0445L, \u0445\u0445L\u0445L\u0445L + \u0445L\u0445\u0445L\u0445L);
        GL11.glVertex2d(L\u0445LLL\u0445L, \u0445\u0445LLL\u0445L + \u0445L\u0445LL\u0445L);
        GL11.glTexCoord2f(L\u0445L\u0445L\u0445L, \u0445\u0445L\u0445L\u0445L + \u0445L\u0445\u0445L\u0445L);
        GL11.glVertex2d(L\u0445LLL\u0445L, \u0445\u0445LLL\u0445L + \u0445L\u0445LL\u0445L);
        GL11.glTexCoord2f(L\u0445L\u0445L\u0445L + LL\u0445\u0445L\u0445L, \u0445\u0445L\u0445L\u0445L + \u0445L\u0445\u0445L\u0445L);
        GL11.glVertex2d(L\u0445LLL\u0445L + LL\u0445LL\u0445L, \u0445\u0445LLL\u0445L + \u0445L\u0445LL\u0445L);
        GL11.glTexCoord2f(L\u0445L\u0445L\u0445L + LL\u0445\u0445L\u0445L, \u0445\u0445L\u0445L\u0445L);
        GL11.glVertex2d(L\u0445LLL\u0445L + LL\u0445LL\u0445L, \u0445\u0445LLL\u0445L);
    }

    public int getStringHeight(String \u0445L\u0445\u0445\u0445\u0445L) {
        CFont LL\u0445\u0445\u0445\u0445L;
        return LL\u0445\u0445\u0445\u0445L.getFontHeight();
    }

    public int getFontHeight() {
        CFont LLLLLL;
        return (LLLLLL.fontHeight - 8) / 2;
    }

    public int getStringWidth(String \u0445\u0445L\u0445LL) {
        int LL\u0445\u0445LL = 0;
        int L\u0445LL\u0445L = 0;
        char[] LLLL\u0445L = \u0445\u0445L\u0445LL.toCharArray();
        int \u0445LLL\u0445L = LLLL\u0445L.length;
        if (L\u0445LL\u0445L < \u0445LLL\u0445L) {
            CFont L\u0445L\u0445LL;
            char \u0445LL\u0445LL = LLLL\u0445L[L\u0445LL\u0445L];
            if (\u0445LL\u0445LL < L\u0445L\u0445LL.charData.length) {
                LL\u0445\u0445LL += L\u0445L\u0445LL.charData[\u0445LL\u0445LL].width - 8 + L\u0445L\u0445LL.charOffset;
            }
            ++L\u0445LL\u0445L;
            return 0;
        }
        return LL\u0445\u0445LL / 2;
    }

    public boolean isAntiAlias() {
        CFont \u0445L\u0445L\u0445L;
        return \u0445L\u0445L\u0445L.antiAlias;
    }

    public void setAntiAlias(boolean L\u0445L\u0445\u0445L) {
        CFont \u0445LL\u0445\u0445L;
        if (\u0445LL\u0445\u0445L.antiAlias != L\u0445L\u0445\u0445L) {
            \u0445LL\u0445\u0445L.antiAlias = L\u0445L\u0445\u0445L;
            \u0445LL\u0445\u0445L.tex = \u0445LL\u0445\u0445L.setupTexture(\u0445LL\u0445\u0445L.font, L\u0445L\u0445\u0445L, \u0445LL\u0445\u0445L.fractionalMetrics, \u0445LL\u0445\u0445L.charData);
        }
    }

    public boolean isFractionalMetrics() {
        CFont L\u0445\u0445\u0445\u0445L;
        return L\u0445\u0445\u0445\u0445L.fractionalMetrics;
    }

    public void setFractionalMetrics(boolean \u0445\u0445LLL) {
        CFont L\u0445LLL;
        if (L\u0445LLL.fractionalMetrics != \u0445\u0445LLL) {
            L\u0445LLL.fractionalMetrics = \u0445\u0445LLL;
            L\u0445LLL.tex = L\u0445LLL.setupTexture(L\u0445LLL.font, L\u0445LLL.antiAlias, \u0445\u0445LLL, L\u0445LLL.charData);
        }
    }

    public Font getFont() {
        CFont \u0445\u0445\u0445LL;
        return \u0445\u0445\u0445LL.font;
    }

    public void setFont(Font LL\u0445\u0445L) {
        CFont \u0445\u0445L\u0445L;
        \u0445\u0445L\u0445L.font = LL\u0445\u0445L;
        \u0445\u0445L\u0445L.tex = \u0445\u0445L\u0445L.setupTexture(LL\u0445\u0445L, \u0445\u0445L\u0445L.antiAlias, \u0445\u0445L\u0445L.fractionalMetrics, \u0445\u0445L\u0445L.charData);
    }

    protected static class CharData {
        public int width;
        public int height;
        public int storedX;
        public int storedY;

        protected CharData() {
            CharData \u0445LL\u0445L\u0445LLLL\u0445LLLL;
        }
    }
}

