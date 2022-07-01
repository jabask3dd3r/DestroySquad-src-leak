/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.shader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.Destroy.client.helpers.Helper;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public abstract class Shader
implements Helper {
    private int program;
    private Map<String, Integer> uniformsMap;

    /*
     * WARNING - void declaration
     */
    public Shader(String \u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L) {
        void \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L;
        void LL\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L;
        Shader L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L;
        try {
            InputStream \u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L = L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.getClass().getResourceAsStream("/assets/minecraft/neverhook/shaders/vertex.vert");
            int \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L = L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.createShader(IOUtils.toString(\u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L), 35633);
            IOUtils.closeQuietly(\u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L);
            InputStream L\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L = L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.getClass().getResourceAsStream("/assets/minecraft/neverhook/shaders/fragment/" + \u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L);
            int LLLL\u0445LL\u0445\u0445\u0445\u0445\u0445L = L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.createShader(IOUtils.toString(L\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L), 35632);
            IOUtils.closeQuietly(L\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L);
        }
        catch (Exception \u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L) {
            return;
        }
        if (LL\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L == false || \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L == false) {
            return;
        }
        L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.program = ARBShaderObjects.glCreateProgramObjectARB();
        if (L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.program == 0) {
            return;
        }
        ARBShaderObjects.glAttachObjectARB(L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.program, (int)LL\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L);
        ARBShaderObjects.glAttachObjectARB(L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.program, (int)\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L);
        ARBShaderObjects.glLinkProgramARB(L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.program);
        ARBShaderObjects.glValidateProgramARB(L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.program);
    }

    public void startShader() {
        Shader \u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L;
        GL11.glPushMatrix();
        GL20.glUseProgram(\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L.program);
        if (\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L.uniformsMap == null) {
            \u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L.uniformsMap = new HashMap<String, Integer>();
            \u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L.setupUniforms();
        }
        \u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445L.updateUniforms();
    }

    public void stopShader() {
        GL20.glUseProgram(0);
        GL11.glPopMatrix();
    }

    public abstract void setupUniforms();

    public abstract void updateUniforms();

    private int createShader(String L\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L, int \u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L) {
        int LLL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L = 0;
        try {
            LLL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L = ARBShaderObjects.glCreateShaderObjectARB(\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L);
            if (LLL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L == 0) {
                return 0;
            }
            ARBShaderObjects.glShaderSourceARB(LLL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L, L\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L);
            ARBShaderObjects.glCompileShaderARB(LLL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L);
            return LLL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L;
        }
        catch (Exception LL\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L) {
            ARBShaderObjects.glDeleteObjectARB(LLL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L);
            throw LL\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L;
        }
    }

    public void setUniform(String \u0445LLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L, int L\u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L) {
        Shader LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L;
        LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L.uniformsMap.put(\u0445LLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L, L\u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L);
    }

    public void setupUniform(String \u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L) {
        Shader LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L;
        LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L.setUniform(\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L, GL20.glGetUniformLocation(LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L.program, \u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L));
    }

    public int getUniform(String \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L) {
        Shader L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L;
        return L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L.uniformsMap.get(\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L);
    }
}

