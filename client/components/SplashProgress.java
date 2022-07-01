/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.components;

import java.awt.Color;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;

public class SplashProgress
implements Helper {
    public static ResourceLocation resourceLocation = new ResourceLocation("neverhook/launch.png");
    public static int Progress;
    public static int maxProgress;
    public static FontRenderer fontRenderer;

    public SplashProgress() {
        SplashProgress \u0445LLL\u0445L\u0445\u0445LLL\u0445LLL;
    }

    public static void update() {
        SplashProgress.drawSplash(mc.getTextureManager());
    }

    public static void setProgress(int LL\u0445L\u0445L\u0445\u0445LLL\u0445LLL) {
        Progress = LL\u0445L\u0445L\u0445\u0445LLL\u0445LLL;
        SplashProgress.update();
    }

    public static void drawSplash(TextureManager \u0445LL\u0445\u0445L\u0445\u0445LLL\u0445LLL) {
        fontRenderer = new FontRenderer(SplashProgress.mc.gameSettings, new ResourceLocation("textures/font/ascii.png"), mc.getTextureManager(), false);
        if (SplashProgress.mc.gameSettings.language != null) {
            fontRenderer.setUnicodeFlag(mc.isUnicode());
            fontRenderer.setBidiFlag(SplashProgress.mc.mcLanguageManager.isCurrentLanguageBidirectional());
        }
        SplashProgress.mc.mcResourceManager.registerReloadListener(fontRenderer);
        int L\u0445L\u0445\u0445L\u0445\u0445LLL\u0445LLL = sr.getScaleFactor();
        Framebuffer \u0445\u0445L\u0445\u0445L\u0445\u0445LLL\u0445LLL = new Framebuffer(sr.getScaledWidth() * L\u0445L\u0445\u0445L\u0445\u0445LLL\u0445LLL, sr.getScaledHeight() * L\u0445L\u0445\u0445L\u0445\u0445LLL\u0445LLL, true);
        \u0445\u0445L\u0445\u0445L\u0445\u0445LLL\u0445LLL.bindFramebuffer(false);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, sr.getScaledWidth(), sr.getScaledHeight(), 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();
        \u0445LL\u0445\u0445L\u0445\u0445LLL\u0445LLL.bindTexture(resourceLocation);
        GlStateManager.resetColor();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Gui.drawScaledCustomSizeModalRect(0.0f, 0.0f, 0.0f, 0.0f, sr.getScaledWidth(), sr.getScaledHeight(), sr.getScaledWidth(), sr.getScaledHeight(), sr.getScaledWidth(), sr.getScaledHeight());
        SplashProgress.drawProgress();
        \u0445\u0445L\u0445\u0445L\u0445\u0445LLL\u0445LLL.unbindFramebuffer();
        \u0445\u0445L\u0445\u0445L\u0445\u0445LLL\u0445LLL.framebufferRender(sr.getScaledWidth() * L\u0445L\u0445\u0445L\u0445\u0445LLL\u0445LLL, sr.getScaledHeight() * L\u0445L\u0445\u0445L\u0445\u0445LLL\u0445LLL);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        mc.updateDisplay();
    }

    private static void drawProgress() {
        if (SplashProgress.mc.gameSettings == null) {
            return;
        }
        float \u0445LLLL\u0445\u0445\u0445LLL\u0445LLL = (float)Progress / 7.0f * (float)sr.getScaledWidth() * 0.595f;
        float L\u0445LLL\u0445\u0445\u0445LLL\u0445LLL = PaletteHelper.getHealthColor(Progress, maxProgress);
        GlStateManager.resetColor();
        GlStateManager.TextureState.textureName = -1;
        RectHelper.drawSmoothRect(84.0f, sr.getScaledHeight() - 110, sr.getScaledWidth() - 85, sr.getScaledHeight() - 95, new Color(0, 0, 0).getRGB());
        RectHelper.drawSmoothRect(86.0f, sr.getScaledHeight() - 108, sr.getScaledWidth() - 87, sr.getScaledHeight() - 97, new Color(50, 50, 50).getRGB());
        RectHelper.drawRect(86.0, sr.getScaledHeight() - 108, 86.0f + \u0445LLLL\u0445\u0445\u0445LLL\u0445LLL, sr.getScaledHeight() - 97, (int)L\u0445LLL\u0445\u0445\u0445LLL\u0445LLL);
    }

    static {
        maxProgress = 7;
    }
}

