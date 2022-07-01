/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.util.ResourceLocation;
import org.Destroy.client.helpers.render.RenderHelper;
import org.lwjgl.opengl.GL11;

public class BlurUtil {
    protected static Minecraft mc = Minecraft.getInstance();
    private final ResourceLocation resourceLocation = new ResourceLocation("neverhook/shaders/fragment/blur.json");
    private ShaderGroup shaderGroup;
    private Framebuffer framebuffer;
    private int lastFactor;
    private int lastWidth;
    private int lastHeight;

    public BlurUtil() {
        BlurUtil LL\u0445\u0445L\u0445L\u0445L\u0445L;
    }

    public void init() {
        try {
            BlurUtil L\u0445\u0445L\u0445\u0445L\u0445L\u0445L;
            L\u0445\u0445L\u0445\u0445L\u0445L\u0445L.shaderGroup = new ShaderGroup(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), L\u0445\u0445L\u0445\u0445L\u0445L\u0445L.resourceLocation);
            L\u0445\u0445L\u0445\u0445L\u0445L\u0445L.shaderGroup.createBindFramebuffers(BlurUtil.mc.displayWidth, BlurUtil.mc.displayHeight);
            L\u0445\u0445L\u0445\u0445L\u0445L\u0445L.framebuffer = L\u0445\u0445L\u0445\u0445L\u0445L\u0445L.shaderGroup.mainFramebuffer;
        }
        catch (Exception L\u0445L\u0445\u0445\u0445L\u0445L\u0445L) {
            // empty catch block
        }
    }

    public void blur(float LL\u0445\u0445\u0445L\u0445\u0445L\u0445L, float \u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445L, float L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L, float \u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L, int LLLLL\u0445\u0445\u0445L\u0445L) {
        BlurUtil \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L;
        ScaledResolution \u0445LLLL\u0445\u0445\u0445L\u0445L = new ScaledResolution(mc);
        int L\u0445LLL\u0445\u0445\u0445L\u0445L = \u0445LLLL\u0445\u0445\u0445L\u0445L.getScaleFactor();
        int \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445L = \u0445LLLL\u0445\u0445\u0445L\u0445L.getScaledWidth();
        int \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L = \u0445LLLL\u0445\u0445\u0445L\u0445L.getScaledHeight();
        BlurUtil blurUtil = \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L;
        int n2 = L\u0445LLL\u0445\u0445\u0445L\u0445L;
        int n3 = \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445L;
        if (\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L == 0 || \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L.framebuffer == null || \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L.shaderGroup == null) {
            \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L.init();
        }
        \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L.lastFactor = L\u0445LLL\u0445\u0445\u0445L\u0445L;
        \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L.lastWidth = \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445L;
        \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L.lastHeight = \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L;
        GL11.glPushMatrix();
        GL11.glEnable(3089);
        RenderHelper.scissorRect(LL\u0445\u0445\u0445L\u0445\u0445L\u0445L, \u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445L, L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L, \u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L);
        \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L.framebuffer.bindFramebuffer(true);
        \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L.shaderGroup.loadShaderGroup(BlurUtil.mc.timer.renderPartialTicks);
        int LLL\u0445\u0445L\u0445\u0445L\u0445L = 0;
        if (LLL\u0445\u0445L\u0445\u0445L\u0445L < 3) {
            \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L.shaderGroup.getShaders().get(LLL\u0445\u0445L\u0445\u0445L\u0445L).getShaderManager().getShaderUniform("Radius").set(LLLLL\u0445\u0445\u0445L\u0445L);
            ++LLL\u0445\u0445L\u0445\u0445L\u0445L;
            return;
        }
        mc.getFramebuffer().bindFramebuffer(false);
        GL11.glDisable(3089);
        GL11.glPopMatrix();
    }
}

