/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.shader;

import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.shader.Framebuffer;
import org.Destroy.client.ui.shader.Shader;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public abstract class FramebufferShader
extends Shader {
    private static Framebuffer framebuffer;
    protected float red;
    protected float green;
    protected float blue;
    protected float alpha = 1.0f;
    protected float radius = 2.0f;
    protected float quality = 1.0f;
    private boolean entityShadows;

    public FramebufferShader(String L\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445LL) {
        super(L\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445LL);
        FramebufferShader \u0445LL\u0445LLL\u0445L\u0445L\u0445\u0445LL;
    }

    public void renderShader(float \u0445\u0445LL\u0445LL\u0445L\u0445L\u0445\u0445LL) {
        FramebufferShader \u0445LLL\u0445LL\u0445L\u0445L\u0445\u0445LL;
        GlStateManager.enableAlpha();
        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();
        framebuffer = \u0445LLL\u0445LL\u0445L\u0445L\u0445\u0445LL.setupFrameBuffer(framebuffer);
        framebuffer.framebufferClear();
        framebuffer.bindFramebuffer(true);
        \u0445LLL\u0445LL\u0445L\u0445L\u0445\u0445LL.entityShadows = FramebufferShader.mc.gameSettings.entityShadows;
        FramebufferShader.mc.gameSettings.entityShadows = false;
        FramebufferShader.mc.entityRenderer.setupCameraTransform(\u0445\u0445LL\u0445LL\u0445L\u0445L\u0445\u0445LL, 0);
    }

    public void stopRenderShader(Color \u0445LL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL, float L\u0445L\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL, float \u0445\u0445L\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL) {
        FramebufferShader LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL;
        FramebufferShader.mc.gameSettings.entityShadows = LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.entityShadows;
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        mc.getFramebuffer().bindFramebuffer(true);
        LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.red = (float)\u0445LL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.getRed() / 255.0f;
        LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.green = (float)\u0445LL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.getGreen() / 255.0f;
        LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.blue = (float)\u0445LL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.getBlue() / 255.0f;
        LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.alpha = (float)\u0445LL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.getAlpha() / 255.0f;
        LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.radius = L\u0445L\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL;
        LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.quality = \u0445\u0445L\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL;
        FramebufferShader.mc.entityRenderer.disableLightmap();
        RenderHelper.disableStandardItemLighting();
        LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.startShader();
        FramebufferShader.mc.entityRenderer.setupOverlayRendering();
        LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.drawFramebuffer(framebuffer);
        LLL\u0445L\u0445L\u0445L\u0445L\u0445\u0445LL.stopShader();
        FramebufferShader.mc.entityRenderer.disableLightmap();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public Framebuffer setupFrameBuffer(Framebuffer \u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445LL) {
        if (\u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445LL != null) {
            \u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445LL.deleteFramebuffer();
        }
        \u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445LL = new Framebuffer(FramebufferShader.mc.displayWidth, FramebufferShader.mc.displayHeight, true);
        return \u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445LL;
    }

    public void drawFramebuffer(Framebuffer \u0445L\u0445LLL\u0445\u0445L\u0445L\u0445\u0445LL) {
        ScaledResolution \u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445LL = new ScaledResolution(mc);
        GL11.glBindTexture(3553, \u0445L\u0445LLL\u0445\u0445L\u0445L\u0445\u0445LL.framebufferTexture);
        GL11.glBegin(7);
        GL11.glTexCoord2d(0.0, 1.0);
        GL11.glVertex2d(0.0, 0.0);
        GL11.glTexCoord2d(0.0, 0.0);
        GL11.glVertex2d(0.0, \u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445LL.getScaledHeight());
        GL11.glTexCoord2d(1.0, 0.0);
        GL11.glVertex2d(\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445LL.getScaledWidth(), \u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445LL.getScaledHeight());
        GL11.glTexCoord2d(1.0, 1.0);
        GL11.glVertex2d(\u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445LL.getScaledWidth(), 0.0);
        GL11.glEnd();
        GL20.glUseProgram(0);
    }
}

