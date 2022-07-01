/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import java.awt.List;
import java.util.Collections;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.Vec3d;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.lwjgl.opengl.GL11;

public class JumpCircle
extends Feature {
    static final int TYPE = 0;
    static final byte MAX_JC_TIME = 20;
    static List circles = new List();
    public ListSetting jumpcircleMode = new ListSetting("Mode", "Disc", () -> true, "Disc");
    public static ColorSetting jumpCircleColor = new ColorSetting("JumpCircle Color", new Color(0xFFFFFF).getRGB(), () -> true);
    static float pt;

    public JumpCircle() {
        super("JumpCircles", "View circles in jump", Type.Visuals);
        JumpCircle L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL;
        L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.addSettings(L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.jumpcircleMode, jumpCircleColor);
    }

    @EventTarget
    public void onJump(EventUpdate \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445LLL) {
        if (JumpCircle.mc.player.motionY == 0.33319999363422365) {
            JumpCircle.handleEntityJump(JumpCircle.mc.player);
        }
    }

    @EventTarget
    public void onRender(EventRender3D LLL\u0445LLLL\u0445\u0445\u0445LLL) {
        JumpCircle \u0445\u0445\u0445LLLLL\u0445\u0445\u0445LLL;
        String \u0445LL\u0445LLLL\u0445\u0445\u0445LLL = \u0445\u0445\u0445LLLLL\u0445\u0445\u0445LLL.jumpcircleMode.getOptions();
        EntityPlayerSP L\u0445L\u0445LLLL\u0445\u0445\u0445LLL = JumpCircle.mc.player;
        Minecraft \u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL = Minecraft.getInstance();
        double LL\u0445\u0445LLLL\u0445\u0445\u0445LLL = -(L\u0445L\u0445LLLL\u0445\u0445\u0445LLL.lastTickPosX + (L\u0445L\u0445LLLL\u0445\u0445\u0445LLL.posX - L\u0445L\u0445LLLL\u0445\u0445\u0445LLL.lastTickPosX) * (double)\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL.getRenderPartialTicks());
        double \u0445L\u0445\u0445LLLL\u0445\u0445\u0445LLL = -(L\u0445L\u0445LLLL\u0445\u0445\u0445LLL.lastTickPosY + (L\u0445L\u0445LLLL\u0445\u0445\u0445LLL.posY - L\u0445L\u0445LLLL\u0445\u0445\u0445LLL.lastTickPosY) * (double)\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL.getRenderPartialTicks());
        double L\u0445\u0445\u0445LLLL\u0445\u0445\u0445LLL = -(L\u0445L\u0445LLLL\u0445\u0445\u0445LLL.lastTickPosZ + (L\u0445L\u0445LLLL\u0445\u0445\u0445LLL.posZ - L\u0445L\u0445LLLL\u0445\u0445\u0445LLL.lastTickPosZ) * (double)\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL.getRenderPartialTicks());
        if (\u0445LL\u0445LLLL\u0445\u0445\u0445LLL.equalsIgnoreCase("Disc")) {
            GL11.glPushMatrix();
            GL11.glTranslated(LL\u0445\u0445LLLL\u0445\u0445\u0445LLL, \u0445L\u0445\u0445LLLL\u0445\u0445\u0445LLL, L\u0445\u0445\u0445LLLL\u0445\u0445\u0445LLL);
            GL11.glDisable(2884);
            GL11.glEnable(3042);
            GL11.glDisable(3553);
            GL11.glDisable(3008);
            GL11.glDisable(2929);
            GL11.glBlendFunc(770, 771);
            GL11.glShadeModel(7425);
            Collections.reverse((java.util.List)((Object)circles));
            try {
                Iterator L\u0445\u0445LLLLL\u0445\u0445\u0445LLL = ((java.util.List)((Object)circles)).iterator();
                if (L\u0445\u0445LLLLL\u0445\u0445\u0445LLL.hasNext()) {
                    Circle L\u0445LLLLLL\u0445\u0445\u0445LLL = (Circle)L\u0445\u0445LLLLL\u0445\u0445\u0445LLL.next();
                    float L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL = (float)L\u0445LLLLLL\u0445\u0445\u0445LLL.existed / 20.0f;
                    double \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL = L\u0445LLLLLL\u0445\u0445\u0445LLL.position().xCoord;
                    double LLLLLLLL\u0445\u0445\u0445LLL = L\u0445LLLLLL\u0445\u0445\u0445LLL.position().yCoord - (double)L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL * 0.5;
                    double \u0445LLLLLLL\u0445\u0445\u0445LLL = L\u0445LLLLLL\u0445\u0445\u0445LLL.position().zCoord;
                    float \u0445\u0445LLLLLL\u0445\u0445\u0445LLL = L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL;
                    float LL\u0445LLLLL\u0445\u0445\u0445LLL = L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL + 1.0f - L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL;
                    GL11.glBegin(8);
                    int \u0445L\u0445LLLLL\u0445\u0445\u0445LLL = 0;
                    if (\u0445L\u0445LLLLL\u0445\u0445\u0445LLL <= 360) {
                        GL11.glColor4f((float)L\u0445LLLLLL\u0445\u0445\u0445LLL.color().xCoord, (float)L\u0445LLLLLL\u0445\u0445\u0445LLL.color().yCoord, (float)L\u0445LLLLLL\u0445\u0445\u0445LLL.color().zCoord, 0.2f * (1.0f - (float)L\u0445LLLLLL\u0445\u0445\u0445LLL.existed / 20.0f));
                        GL11.glVertex3d(\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL + Math.cos(Math.toRadians(\u0445L\u0445LLLLL\u0445\u0445\u0445LLL * 4)) * (double)\u0445\u0445LLLLLL\u0445\u0445\u0445LLL, LLLLLLLL\u0445\u0445\u0445LLL, \u0445LLLLLLL\u0445\u0445\u0445LLL + Math.sin(Math.toRadians(\u0445L\u0445LLLLL\u0445\u0445\u0445LLL * 4)) * (double)\u0445\u0445LLLLLL\u0445\u0445\u0445LLL);
                        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.01f * (1.0f - (float)L\u0445LLLLLL\u0445\u0445\u0445LLL.existed / 20.0f));
                        GL11.glVertex3d(\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL + Math.cos(Math.toRadians(\u0445L\u0445LLLLL\u0445\u0445\u0445LLL)) * (double)LL\u0445LLLLL\u0445\u0445\u0445LLL, LLLLLLLL\u0445\u0445\u0445LLL + Math.sin(L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL * 8.0f) * 0.5, \u0445LLLLLLL\u0445\u0445\u0445LLL + Math.sin(Math.toRadians(\u0445L\u0445LLLLL\u0445\u0445\u0445LLL) * (double)LL\u0445LLLLL\u0445\u0445\u0445LLL));
                        \u0445L\u0445LLLLL\u0445\u0445\u0445LLL += 5;
                        return;
                    }
                    GL11.glEnd();
                    return;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            Collections.reverse((java.util.List)((Object)circles));
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glShadeModel(7424);
            GL11.glEnable(2884);
            GL11.glEnable(2929);
            GL11.glEnable(3008);
            GL11.glPopMatrix();
        }
    }

    public static void handleEntityJump(EntityPlayerSP LL\u0445LL\u0445LL\u0445\u0445\u0445LLL) {
        int \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LLL = (int)((float)(jumpCircleColor.getColorValue() >> 16 & 0xFF) / 100.0f);
        int L\u0445\u0445LL\u0445LL\u0445\u0445\u0445LLL = (int)((float)(jumpCircleColor.getColorValue() >> 8 & 0xFF) / 100.0f);
        int \u0445\u0445\u0445LL\u0445LL\u0445\u0445\u0445LLL = (int)((float)(jumpCircleColor.getColorValue() & 0xFF) / 100.0f);
        Vec3d LLL\u0445L\u0445LL\u0445\u0445\u0445LLL = new Vec3d(\u0445L\u0445LL\u0445LL\u0445\u0445\u0445LLL, L\u0445\u0445LL\u0445LL\u0445\u0445\u0445LLL, \u0445\u0445\u0445LL\u0445LL\u0445\u0445\u0445LLL);
        circles.add(String.valueOf(new Circle(LL\u0445LL\u0445LL\u0445\u0445\u0445LLL.getPositionVector(), LLL\u0445L\u0445LL\u0445\u0445\u0445LLL)));
    }

    static class Circle {
        private final Vec3d vec;
        private final Vec3d color;
        byte existed;

        Circle(Vec3d LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445LLL, Vec3d \u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445LLL) {
            Circle \u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445LLL;
            \u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445LLL.vec = LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445LLL;
            \u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445LLL.color = \u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445LLL;
        }

        Vec3d position() {
            Circle L\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL;
            return L\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL.vec;
        }

        Vec3d color() {
            Circle \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL;
            return \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL.color;
        }

        boolean update() {
            Circle LLLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL;
            LLLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.existed = (byte)(LLLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.existed + 1);
            return LLLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.existed > 20;
        }
    }
}

