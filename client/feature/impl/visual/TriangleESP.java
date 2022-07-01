/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender2D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.settings.impl.ColorSetting;
import org.lwjgl.opengl.GL11;

public class TriangleESP
extends Feature {
    public ColorSetting customColor;

    public TriangleESP() {
        super("TriangleESP", "Line", Type.Visuals);
        TriangleESP \u0445\u0445\u0445L\u0445\u0445L\u0445L;
    }

    @EventTarget
    public void onRender2D(EventRender2D LL\u0445LL\u0445\u0445\u0445L) {
        ScaledResolution \u0445L\u0445LL\u0445\u0445\u0445L = new ScaledResolution(mc);
        int L\u0445LLL\u0445\u0445\u0445L = 0;
        if (L\u0445LLL\u0445\u0445\u0445L < TriangleESP.mc.world.playerEntities.size()) {
            EntityPlayer L\u0445LL\u0445L\u0445\u0445L = (EntityPlayer)TriangleESP.mc.world.playerEntities.get(L\u0445LLL\u0445\u0445\u0445L);
            int \u0445\u0445LL\u0445L\u0445\u0445L = 100;
            double LL\u0445L\u0445L\u0445\u0445L = (double)((float)\u0445L\u0445LL\u0445\u0445\u0445L.getScaledWidth() / 2.0f) - (double)\u0445\u0445LL\u0445L\u0445\u0445L / 2.04;
            double \u0445L\u0445L\u0445L\u0445\u0445L = (double)((float)\u0445L\u0445LL\u0445\u0445\u0445L.getScaledHeight() / 2.0f) - (double)\u0445\u0445LL\u0445L\u0445\u0445L / 1.983;
            double L\u0445\u0445L\u0445L\u0445\u0445L = TriangleESP.mc.player.posX;
            double \u0445\u0445\u0445L\u0445L\u0445\u0445L = TriangleESP.mc.player.posZ;
            double LLL\u0445\u0445L\u0445\u0445L = 0.2f;
            double \u0445LL\u0445\u0445L\u0445\u0445L = TriangleESP.mc.timer.renderPartialTicks;
            double L\u0445L\u0445\u0445L\u0445\u0445L = (L\u0445LL\u0445L\u0445\u0445L.posX + (L\u0445LL\u0445L\u0445\u0445L.posX - L\u0445LL\u0445L\u0445\u0445L.lastTickPosX) * \u0445LL\u0445\u0445L\u0445\u0445L - L\u0445\u0445L\u0445L\u0445\u0445L) * LLL\u0445\u0445L\u0445\u0445L;
            double \u0445\u0445L\u0445\u0445L\u0445\u0445L = (L\u0445LL\u0445L\u0445\u0445L.posZ + (L\u0445LL\u0445L\u0445\u0445L.posZ - L\u0445LL\u0445L\u0445\u0445L.lastTickPosZ) * \u0445LL\u0445\u0445L\u0445\u0445L - \u0445\u0445\u0445L\u0445L\u0445\u0445L) * LLL\u0445\u0445L\u0445\u0445L;
            double LL\u0445\u0445\u0445L\u0445\u0445L = Math.cos((double)TriangleESP.mc.player.rotationYaw * (Math.PI / 180));
            double \u0445L\u0445\u0445\u0445L\u0445\u0445L = Math.sin((double)TriangleESP.mc.player.rotationYaw * (Math.PI / 180));
            double L\u0445\u0445\u0445\u0445L\u0445\u0445L = -(\u0445\u0445L\u0445\u0445L\u0445\u0445L * LL\u0445\u0445\u0445L\u0445\u0445L - L\u0445L\u0445\u0445L\u0445\u0445L * \u0445L\u0445\u0445\u0445L\u0445\u0445L);
            double \u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = -(L\u0445L\u0445\u0445L\u0445\u0445L * LL\u0445\u0445\u0445L\u0445\u0445L + \u0445\u0445L\u0445\u0445L\u0445\u0445L * \u0445L\u0445\u0445\u0445L\u0445\u0445L);
            double LLLLL\u0445\u0445\u0445L = 0.0 - \u0445\u0445\u0445\u0445\u0445L\u0445\u0445L;
            double \u0445LLLL\u0445\u0445\u0445L = 0.0 - L\u0445\u0445\u0445\u0445L\u0445\u0445L;
            if (!L\u0445LL\u0445L\u0445\u0445L.isDead && L\u0445LL\u0445L\u0445\u0445L.getHealth() > 0.0f && L\u0445LL\u0445L\u0445\u0445L != null && L\u0445LL\u0445L\u0445\u0445L != TriangleESP.mc.player && MathHelper.sqrt(LLLLL\u0445\u0445\u0445L * LLLLL\u0445\u0445\u0445L + \u0445LLLL\u0445\u0445\u0445L * \u0445LLLL\u0445\u0445\u0445L) < (float)\u0445\u0445LL\u0445L\u0445\u0445L / 2.0f - 4.0f) {
                TriangleESP \u0445\u0445LLL\u0445\u0445\u0445L;
                double \u0445\u0445\u0445\u0445LL\u0445\u0445L = Math.atan2(L\u0445\u0445\u0445\u0445L\u0445\u0445L - 0.0, \u0445\u0445\u0445\u0445\u0445L\u0445\u0445L - 0.0) * 180.0 / Math.PI;
                double LLLL\u0445L\u0445\u0445L = (double)((float)\u0445\u0445LL\u0445L\u0445\u0445L / 2.0f) * Math.cos(Math.toRadians(\u0445\u0445\u0445\u0445LL\u0445\u0445L)) + LL\u0445L\u0445L\u0445\u0445L + (double)((float)\u0445\u0445LL\u0445L\u0445\u0445L / 2.0f);
                double \u0445LLL\u0445L\u0445\u0445L = (double)((float)\u0445\u0445LL\u0445L\u0445\u0445L / 2.0f) * Math.sin(Math.toRadians(\u0445\u0445\u0445\u0445LL\u0445\u0445L)) + \u0445L\u0445L\u0445L\u0445\u0445L + (double)((float)\u0445\u0445LL\u0445L\u0445\u0445L / 2.0f);
                GlStateManager.pushMatrix();
                GlStateManager.translate(LLLL\u0445L\u0445\u0445L, \u0445LLL\u0445L\u0445\u0445L, 0.0);
                GlStateManager.rotate((float)\u0445\u0445\u0445\u0445LL\u0445\u0445L, 0.0f, 0.0f, 1.0f);
                GlStateManager.scale(1.5, 1.0, 1.0);
                \u0445\u0445LLL\u0445\u0445\u0445L.triangle(0.0f, 0.0f, 2.0f, 3.0f, ClientHelper.getClientColor().getRGB());
                GlStateManager.popMatrix();
            }
            ++L\u0445LLL\u0445\u0445\u0445L;
            return;
        }
    }

    private void triangle(float L\u0445L\u0445LLLL, float \u0445\u0445L\u0445LLLL, float LL\u0445\u0445LLLL, float \u0445L\u0445\u0445LLLL, int L\u0445\u0445\u0445LLLL) {
        L\u0445L\u0445LLLL = (float)((double)L\u0445L\u0445LLLL * 2.0);
        \u0445\u0445L\u0445LLLL = (float)((double)\u0445\u0445L\u0445LLLL * 2.0);
        float \u0445\u0445\u0445\u0445LLLL = 6.283185f / \u0445L\u0445\u0445LLLL;
        float LLLL\u0445LLL = (float)Math.cos(\u0445\u0445\u0445\u0445LLLL);
        float \u0445LLL\u0445LLL = (float)Math.sin(\u0445\u0445\u0445\u0445LLLL);
        float L\u0445LL\u0445LLL = LL\u0445\u0445LLLL *= 3.0f;
        float \u0445\u0445LL\u0445LLL = 0.0f;
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        RenderHelper.setColor(L\u0445\u0445\u0445LLLL);
        GL11.glBegin(2);
        int LL\u0445L\u0445LLL = 0;
        if ((float)LL\u0445L\u0445LLL < \u0445L\u0445\u0445LLLL) {
            GL11.glVertex2f(L\u0445LL\u0445LLL + L\u0445L\u0445LLLL, \u0445\u0445LL\u0445LLL + \u0445\u0445L\u0445LLLL);
            float LLL\u0445LLLL = L\u0445LL\u0445LLL;
            L\u0445LL\u0445LLL = LLLL\u0445LLL * L\u0445LL\u0445LLL - \u0445LLL\u0445LLL * \u0445\u0445LL\u0445LLL;
            \u0445\u0445LL\u0445LLL = \u0445LLL\u0445LLL * LLL\u0445LLLL + LLLL\u0445LLL * \u0445\u0445LL\u0445LLL;
            ++LL\u0445L\u0445LLL;
            return;
        }
        GL11.glEnd();
        GL11.glPopMatrix();
    }
}

