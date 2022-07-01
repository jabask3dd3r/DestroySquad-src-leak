/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.shader.shaders;

import org.Destroy.client.ui.shader.FramebufferShader;
import org.lwjgl.opengl.GL20;

public class GlowShader
extends FramebufferShader {
    public static final GlowShader GLOW_SHADER = new GlowShader();

    public GlowShader() {
        super("glow.frag");
        GlowShader \u0445\u0445\u0445\u0445LLL\u0445LL\u0445L;
    }

    @Override
    public void setupUniforms() {
        GlowShader L\u0445LL\u0445LL\u0445LL\u0445L;
        L\u0445LL\u0445LL\u0445LL\u0445L.setupUniform("texture");
        L\u0445LL\u0445LL\u0445LL\u0445L.setupUniform("texelSize");
        L\u0445LL\u0445LL\u0445LL\u0445L.setupUniform("color");
        L\u0445LL\u0445LL\u0445LL\u0445L.setupUniform("radius");
        L\u0445LL\u0445LL\u0445LL\u0445L.setupUniform("direction");
    }

    @Override
    public void updateUniforms() {
        GlowShader \u0445L\u0445L\u0445LL\u0445LL\u0445L;
        GL20.glUniform1i(\u0445L\u0445L\u0445LL\u0445LL\u0445L.getUniform("texture"), 0);
        GL20.glUniform2f(\u0445L\u0445L\u0445LL\u0445LL\u0445L.getUniform("texelSize"), 1.0f / (float)GlowShader.mc.displayWidth * (\u0445L\u0445L\u0445LL\u0445LL\u0445L.radius * \u0445L\u0445L\u0445LL\u0445LL\u0445L.quality), 1.0f / (float)GlowShader.mc.displayHeight * (\u0445L\u0445L\u0445LL\u0445LL\u0445L.radius * \u0445L\u0445L\u0445LL\u0445LL\u0445L.quality));
        GL20.glUniform3f(\u0445L\u0445L\u0445LL\u0445LL\u0445L.getUniform("color"), \u0445L\u0445L\u0445LL\u0445LL\u0445L.red, \u0445L\u0445L\u0445LL\u0445LL\u0445L.green, \u0445L\u0445L\u0445LL\u0445LL\u0445L.blue);
        GL20.glUniform1f(\u0445L\u0445L\u0445LL\u0445LL\u0445L.getUniform("radius"), \u0445L\u0445L\u0445LL\u0445LL\u0445L.radius);
        GL20.glUniform2f(\u0445L\u0445L\u0445LL\u0445LL\u0445L.getUniform("direction"), 1.0f, 1.0f);
    }
}

