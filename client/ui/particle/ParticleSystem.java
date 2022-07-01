/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.particle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.ui.particle.Particle;
import org.Destroy.client.ui.util.MathUtil;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class ParticleSystem {
    private static final float SPEED = 0.1f;
    private List<Particle> particleList = new ArrayList<Particle>();
    private boolean mouse;
    private boolean rainbow;
    private int dist;

    public ParticleSystem(int L\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L, boolean \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L, boolean LL\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L, int \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L) {
        ParticleSystem \u0445LL\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L;
        \u0445LL\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L.addParticles(L\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L);
        \u0445LL\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L.mouse = \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L;
        \u0445LL\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L.dist = \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L;
        \u0445LL\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L.rainbow = LL\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L;
    }

    public void addParticles(int LLL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L) {
        int L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L = 0;
        if (L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L < LLL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L) {
            ParticleSystem \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L;
            \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L.particleList.add(Particle.generateParticle());
            ++L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L;
            return;
        }
    }

    public void tick(int L\u0445LLLLLLL\u0445L\u0445L\u0445L) {
        Iterator<Particle> \u0445L\u0445LLLLLL\u0445L\u0445L\u0445L;
        ParticleSystem \u0445LLLLLLLL\u0445L\u0445L\u0445L;
        if (Mouse.isButtonDown(0)) {
            \u0445LLLLLLLL\u0445L\u0445L\u0445L.addParticles(1);
        }
        if ((\u0445L\u0445LLLLLL\u0445L\u0445L\u0445L = \u0445LLLLLLLL\u0445L\u0445L\u0445L.particleList.iterator()).hasNext()) {
            Particle LLLLLLLLL\u0445L\u0445L\u0445L = \u0445L\u0445LLLLLL\u0445L\u0445L\u0445L.next();
            LLLLLLLLL\u0445L\u0445L\u0445L.tick(L\u0445LLLLLLL\u0445L\u0445L\u0445L, 0.1f);
            return;
        }
    }

    public void render(float LL\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445L, float \u0445L\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445L, ScaledResolution L\u0445\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445L) {
        ParticleSystem \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L;
        Iterator<Particle> L\u0445LLL\u0445LLL\u0445L\u0445L\u0445L = \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.particleList.iterator();
        if (L\u0445LLL\u0445LLL\u0445L\u0445L\u0445L.hasNext()) {
            Particle L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L = L\u0445LLL\u0445LLL\u0445L\u0445L\u0445L.next();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getAlpha() / 255.0f);
            GL11.glPointSize(L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getSize());
            GL11.glBegin(0);
            GL11.glVertex2f(L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getX(), L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getY());
            GL11.glEnd();
            if (\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.mouse) {
                float \u0445\u0445LL\u0445LLLL\u0445L\u0445L\u0445L;
                Color L\u0445LL\u0445LLLL\u0445L\u0445L\u0445L = null;
                if (\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.rainbow) {
                    L\u0445LL\u0445LLLL\u0445L\u0445L\u0445L = org.Destroy.client.ui.util.Color.rainbow(50.0f, 0.0f);
                }
                if ((\u0445\u0445LL\u0445LLLL\u0445L\u0445L\u0445L = (float)MathUtil.distance(L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getX(), L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getY(), LL\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445L, \u0445L\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445L)) < (float)\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.dist) {
                    float \u0445LLL\u0445LLLL\u0445L\u0445L\u0445L = Math.min(1.0f, Math.min(0.0f, 1.0f - \u0445\u0445LL\u0445LLLL\u0445L\u0445L\u0445L / (float)\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.dist));
                    \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.drawLine(L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getX(), L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getY(), LL\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445L, \u0445L\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445L, \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.rainbow ? (float)L\u0445LL\u0445LLLL\u0445L\u0445L\u0445L.getRed() / 255.0f : 1.0f, \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.rainbow ? (float)L\u0445LL\u0445LLLL\u0445L\u0445L\u0445L.getGreen() / 255.0f : 1.0f, \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.rainbow ? (float)L\u0445LL\u0445LLLL\u0445L\u0445L\u0445L.getBlue() / 255.0f : 1.0f, \u0445LLL\u0445LLLL\u0445L\u0445L\u0445L);
                }
            } else {
                float LLL\u0445\u0445LLLL\u0445L\u0445L\u0445L = 0.0f;
                Particle \u0445LL\u0445\u0445LLLL\u0445L\u0445L\u0445L = null;
                Iterator<Particle> \u0445LLL\u0445LLLL\u0445L\u0445L\u0445L = \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.particleList.iterator();
                if (\u0445LLL\u0445LLLL\u0445L\u0445L\u0445L.hasNext()) {
                    Particle \u0445L\u0445L\u0445LLLL\u0445L\u0445L\u0445L = \u0445LLL\u0445LLLL\u0445L\u0445L\u0445L.next();
                    float LL\u0445L\u0445LLLL\u0445L\u0445L\u0445L = L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getDistanceTo(\u0445L\u0445L\u0445LLLL\u0445L\u0445L\u0445L);
                    if (LL\u0445L\u0445LLLL\u0445L\u0445L\u0445L <= (float)\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.dist && MathUtil.distance(L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getX(), L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getY(), \u0445L\u0445L\u0445LLLL\u0445L\u0445L\u0445L.getX(), \u0445L\u0445L\u0445LLLL\u0445L\u0445L\u0445L.getY()) <= (double)\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.dist && (LLL\u0445\u0445LLLL\u0445L\u0445L\u0445L <= 0.0f || LL\u0445L\u0445LLLL\u0445L\u0445L\u0445L <= LLL\u0445\u0445LLLL\u0445L\u0445L\u0445L)) {
                        LLL\u0445\u0445LLLL\u0445L\u0445L\u0445L = LL\u0445L\u0445LLLL\u0445L\u0445L\u0445L;
                        \u0445LL\u0445\u0445LLLL\u0445L\u0445L\u0445L = \u0445L\u0445L\u0445LLLL\u0445L\u0445L\u0445L;
                    }
                    return;
                }
                if (\u0445LL\u0445\u0445LLLL\u0445L\u0445L\u0445L != null) {
                    Color L\u0445\u0445L\u0445LLLL\u0445L\u0445L\u0445L = null;
                    if (\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.rainbow) {
                        L\u0445\u0445L\u0445LLLL\u0445L\u0445L\u0445L = org.Destroy.client.ui.util.Color.rainbow(50.0f, 0.0f);
                    }
                    float \u0445\u0445\u0445L\u0445LLLL\u0445L\u0445L\u0445L = Math.min(1.0f, Math.min(1.0f, 1.0f - LLL\u0445\u0445LLLL\u0445L\u0445L\u0445L / (float)\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.dist));
                    \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.drawLine(L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getX(), L\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.getY(), \u0445LL\u0445\u0445LLLL\u0445L\u0445L\u0445L.getX(), \u0445LL\u0445\u0445LLLL\u0445L\u0445L\u0445L.getY(), \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.rainbow ? (float)L\u0445\u0445L\u0445LLLL\u0445L\u0445L\u0445L.getRed() / 255.0f : 1.0f, \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.rainbow ? (float)L\u0445\u0445L\u0445LLLL\u0445L\u0445L\u0445L.getGreen() / 255.0f : 1.0f, \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445L\u0445L.rainbow ? (float)L\u0445\u0445L\u0445LLLL\u0445L\u0445L\u0445L.getBlue() / 255.0f : 1.0f, \u0445\u0445\u0445L\u0445LLLL\u0445L\u0445L\u0445L);
                }
            }
            return;
        }
    }

    private void drawLine(float L\u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445L, float \u0445\u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445L, float LL\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445L, float \u0445L\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445L, float L\u0445\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445L, float \u0445\u0445\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445L, float LLL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445L, float \u0445LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445L) {
        GL11.glEnable(2848);
        GL11.glEnable(3042);
        GL11.glColor4f(L\u0445\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445L, \u0445\u0445\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445L, LLL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445L, \u0445LL\u0445\u0445\u0445LLL\u0445L\u0445L\u0445L);
        GL11.glLineWidth(0.5f);
        GL11.glBegin(1);
        GL11.glVertex2f(L\u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445L, \u0445\u0445LL\u0445\u0445LLL\u0445L\u0445L\u0445L);
        GL11.glVertex2f(LL\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445L, \u0445L\u0445L\u0445\u0445LLL\u0445L\u0445L\u0445L);
        GL11.glEnd();
        GL11.glDisable(2848);
    }
}

