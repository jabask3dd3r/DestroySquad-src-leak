/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.shader.shaders;

import org.Destroy.client.ui.shader.FramebufferShader;
import org.lwjgl.opengl.GL20;

public class EntityGlowShader
extends FramebufferShader {
    public static EntityGlowShader GLOW_SHADER = new EntityGlowShader();

    public EntityGlowShader() {
        super("entityGlow.frag");
        EntityGlowShader \u0445L\u0445LL\u0445LL\u0445LLL;
    }

    @Override
    public void setupUniforms() {
        EntityGlowShader LLL\u0445L\u0445LL\u0445LLL;
        LLL\u0445L\u0445LL\u0445LLL.setupUniform("texture");
        LLL\u0445L\u0445LL\u0445LLL.setupUniform("texelSize");
        LLL\u0445L\u0445LL\u0445LLL.setupUniform("color");
        LLL\u0445L\u0445LL\u0445LLL.setupUniform("divider");
        LLL\u0445L\u0445LL\u0445LLL.setupUniform("radius");
        LLL\u0445L\u0445LL\u0445LLL.setupUniform("maxSample");
    }

    @Override
    public void updateUniforms() {
        EntityGlowShader \u0445\u0445L\u0445L\u0445LL\u0445LLL;
        GL20.glUniform1i(\u0445\u0445L\u0445L\u0445LL\u0445LLL.getUniform("texture"), 0);
        GL20.glUniform2f(\u0445\u0445L\u0445L\u0445LL\u0445LLL.getUniform("texelSize"), 1.0f / (float)EntityGlowShader.mc.displayWidth * (\u0445\u0445L\u0445L\u0445LL\u0445LLL.radius * \u0445\u0445L\u0445L\u0445LL\u0445LLL.quality), 1.0f / (float)EntityGlowShader.mc.displayHeight * (\u0445\u0445L\u0445L\u0445LL\u0445LLL.radius * \u0445\u0445L\u0445L\u0445LL\u0445LLL.quality));
        GL20.glUniform3f(\u0445\u0445L\u0445L\u0445LL\u0445LLL.getUniform("color"), \u0445\u0445L\u0445L\u0445LL\u0445LLL.red, \u0445\u0445L\u0445L\u0445LL\u0445LLL.green, \u0445\u0445L\u0445L\u0445LL\u0445LLL.blue);
        GL20.glUniform1f(\u0445\u0445L\u0445L\u0445LL\u0445LLL.getUniform("divider"), 140.0f);
        GL20.glUniform1f(\u0445\u0445L\u0445L\u0445LL\u0445LLL.getUniform("radius"), \u0445\u0445L\u0445L\u0445LL\u0445LLL.radius);
        GL20.glUniform1f(\u0445\u0445L\u0445L\u0445LL\u0445LLL.getUniform("maxSample"), 10.0f);
    }
}

