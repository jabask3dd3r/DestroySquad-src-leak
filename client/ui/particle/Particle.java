/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.particle;

import java.util.Random;
import javax.vecmath.Vector2f;
import org.Destroy.client.ui.util.MathUtil;
import org.lwjgl.opengl.Display;

public class Particle {
    private static final Random random = new Random();
    private Vector2f velocity;
    private Vector2f pos;
    private float size;
    private float alpha;

    public Particle(Vector2f L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L, float LLLL\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L, float L\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L, float LL\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L) {
        Particle \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L;
        \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L.velocity = L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L;
        \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L.pos = new Vector2f(LLLL\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L, L\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L);
        \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L.size = LL\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L;
    }

    public static Particle generateParticle() {
        Vector2f L\u0445L\u0445LLLLL\u0445L\u0445\u0445\u0445L = new Vector2f((float)(Math.random() * 2.0 - 1.0), (float)(Math.random() * 2.0 - 1.0));
        float \u0445\u0445L\u0445LLLLL\u0445L\u0445\u0445\u0445L = random.nextInt(Display.getWidth());
        float \u0445L\u0445\u0445LLLLL\u0445L\u0445\u0445\u0445L = random.nextInt(Display.getHeight());
        float \u0445\u0445\u0445\u0445LLLLL\u0445L\u0445\u0445\u0445L = (float)(Math.random() * 4.0) + 1.0f;
        return new Particle(L\u0445L\u0445LLLLL\u0445L\u0445\u0445\u0445L, \u0445\u0445L\u0445LLLLL\u0445L\u0445\u0445\u0445L, \u0445L\u0445\u0445LLLLL\u0445L\u0445\u0445\u0445L, \u0445\u0445\u0445\u0445LLLLL\u0445L\u0445\u0445\u0445L);
    }

    public float getAlpha() {
        Particle \u0445LL\u0445\u0445LLLL\u0445L\u0445\u0445\u0445L;
        return \u0445LL\u0445\u0445LLLL\u0445L\u0445\u0445\u0445L.alpha;
    }

    public Vector2f getVelocity() {
        Particle LLLLL\u0445LLL\u0445L\u0445\u0445\u0445L;
        return LLLLL\u0445LLL\u0445L\u0445\u0445\u0445L.velocity;
    }

    public void setVelocity(Vector2f L\u0445L\u0445L\u0445LLL\u0445L\u0445\u0445\u0445L) {
        LLL\u0445L\u0445LLL\u0445L\u0445\u0445\u0445L.velocity = L\u0445L\u0445L\u0445LLL\u0445L\u0445\u0445\u0445L;
    }

    public float getX() {
        Particle L\u0445LL\u0445\u0445LLL\u0445L\u0445\u0445\u0445L;
        return L\u0445LL\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.pos.getX();
    }

    public void setX(float L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L) {
        Particle LLL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L;
        LLL\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L.pos.setX(L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L);
    }

    public float getY() {
        Particle LLLLLL\u0445LL\u0445L\u0445\u0445\u0445L;
        return LLLLLL\u0445LL\u0445L\u0445\u0445\u0445L.pos.getY();
    }

    public void setY(float \u0445L\u0445LLL\u0445LL\u0445L\u0445\u0445\u0445L) {
        Particle LL\u0445LLL\u0445LL\u0445L\u0445\u0445\u0445L;
        LL\u0445LLL\u0445LL\u0445L\u0445\u0445\u0445L.pos.setY(\u0445L\u0445LLL\u0445LL\u0445L\u0445\u0445\u0445L);
    }

    public float getSize() {
        Particle \u0445LL\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L;
        return \u0445LL\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L.size;
    }

    public void setSize(float L\u0445\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L) {
        \u0445L\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L.size = L\u0445\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445L;
    }

    public void tick(int \u0445L\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L, float L\u0445\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L) {
        Particle LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L;
        LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.pos.x += LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.velocity.getX() * (float)\u0445L\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L * L\u0445\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L;
        LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.pos.y += LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.velocity.getY() * (float)\u0445L\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L * L\u0445\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L;
        if (LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.alpha < 255.0f) {
            LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.alpha += 0.05f * (float)\u0445L\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L;
        }
        if (LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.pos.getX() > (float)Display.getWidth()) {
            LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.pos.setX(0.0f);
        }
        if (LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.pos.getX() < 0.0f) {
            LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.pos.setX(Display.getWidth());
        }
        if (LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.pos.getY() > (float)Display.getHeight()) {
            LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.pos.setY(0.0f);
        }
        if (LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.pos.getY() < 0.0f) {
            LL\u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.pos.setY(Display.getHeight());
        }
    }

    public float getDistanceTo(Particle \u0445L\u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L) {
        Particle LL\u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L;
        return LL\u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.getDistanceTo(\u0445L\u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.getX(), \u0445L\u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L.getY());
    }

    public float getDistanceTo(float LL\u0445LL\u0445\u0445LL\u0445L\u0445\u0445\u0445L, float \u0445L\u0445LL\u0445\u0445LL\u0445L\u0445\u0445\u0445L) {
        Particle \u0445\u0445LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L;
        return (float)MathUtil.distance(\u0445\u0445LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L.getX(), \u0445\u0445LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L.getY(), LL\u0445LL\u0445\u0445LL\u0445L\u0445\u0445\u0445L, \u0445L\u0445LL\u0445\u0445LL\u0445L\u0445\u0445\u0445L);
    }
}

