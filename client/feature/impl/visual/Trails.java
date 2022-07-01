/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.network.play.client.CPacketPlayer;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventSendPacket;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.lwjgl.opengl.GL11;

public class Trails
extends Feature {
    public ListSetting colorMode;
    public ColorSetting customColor;
    public NumberSetting width;
    public NumberSetting height;
    public NumberSetting sizeToRemove;
    public ArrayList<Point> points = new ArrayList();
    public float pointCount = 0.0f;

    public Trails() {
        super("Trails", "Line", Type.Visuals);
        Trails \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL;
        \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL.colorMode = new ListSetting("Color", "Client", () -> true, "Rainbow", "Astolfo", "Client", "Custom");
        \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL.customColor = new ColorSetting("Custom Color", new Color(0xFFFFFF).getRGB(), () -> {
            Trails LL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL;
            return LL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.colorMode.currentMode.equals("Custom");
        });
        \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL.width = new NumberSetting("Width", 2.0f, 1.0f, 6.0f, 1.0f, () -> true);
        \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL.height = new NumberSetting("Height", 0.0f, 0.0f, 6.0f, 0.01f, () -> true);
        \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL.sizeToRemove = new NumberSetting("Time", 500.0f, 10.0f, 500.0f, 10.0f, () -> true);
        \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL.addSettings(\u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL.colorMode, \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL.customColor, \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL.width, \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL.height, \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445LLL.sizeToRemove);
    }

    @EventTarget
    public void onRender3D(EventRender3D L\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL) {
        Trails \u0445L\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL;
        String \u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL = \u0445L\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.colorMode.getOptions();
        if (!\u0445L\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.getState()) {
            return;
        }
        double LLL\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL = Trails.mc.getRenderManager().renderPosX;
        double \u0445LL\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL = Trails.mc.getRenderManager().renderPosY;
        double L\u0445L\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL = Trails.mc.getRenderManager().renderPosZ;
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glLineWidth(\u0445L\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.width.getNumberValue());
        GL11.glBlendFunc(770, 771);
        GL11.glBegin(3);
        float \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL = 2000.0f;
        long LL\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL = System.currentTimeMillis() - (long)\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL;
        Iterator<Point> \u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445LLL = \u0445L\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.points.iterator();
        if (\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445LLL.hasNext()) {
            Point LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL = \u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445LLL.next();
            float L\u0445LL\u0445LL\u0445\u0445L\u0445\u0445LLL = (float)(LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.getTime() - LL\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL) / \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL;
            if (L\u0445LL\u0445LL\u0445\u0445L\u0445\u0445LLL < 0.0f || L\u0445LL\u0445LL\u0445\u0445L\u0445\u0445LLL > 1.0f) {
                \u0445L\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.pointCount = \u0445L\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.points.indexOf(LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL);
                return;
            }
            float \u0445LLL\u0445LL\u0445\u0445L\u0445\u0445LLL = L\u0445LL\u0445LL\u0445\u0445L\u0445\u0445LLL;
            Color \u0445\u0445LL\u0445LL\u0445\u0445L\u0445\u0445LLL = Color.white;
            if (\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.equalsIgnoreCase("Rainbow")) {
                \u0445\u0445LL\u0445LL\u0445\u0445L\u0445\u0445LLL = PaletteHelper.rainbow((int)LLL\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL * 300, 1.0f, 1.0f);
            } else if (\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.equalsIgnoreCase("Client")) {
                \u0445\u0445LL\u0445LL\u0445\u0445L\u0445\u0445LLL = ClientHelper.getClientColor();
            } else if (\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.equalsIgnoreCase("Custom")) {
                \u0445\u0445LL\u0445LL\u0445\u0445L\u0445\u0445LLL = new Color(\u0445L\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.customColor.getColorValue());
            } else if (\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.equalsIgnoreCase("Astolfo")) {
                \u0445\u0445LL\u0445LL\u0445\u0445L\u0445\u0445LLL = PaletteHelper.astolfo(false, (int)\u0445LLL\u0445LL\u0445\u0445L\u0445\u0445LLL);
            }
            RenderHelper.setColor(\u0445\u0445LL\u0445LL\u0445\u0445L\u0445\u0445LLL, \u0445LLL\u0445LL\u0445\u0445L\u0445\u0445LLL);
            GL11.glVertex3d(LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.getX() - LLL\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL, LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.getY() - \u0445LL\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL + 1.0, LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.getZ() - L\u0445L\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL);
            GL11.glVertex3d(LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.getX() - LLL\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL, LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.getY() - \u0445LL\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL + 0.01, LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.getZ() - L\u0445L\u0445\u0445LL\u0445\u0445L\u0445\u0445LLL);
            return;
        }
        GL11.glEnd();
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GlStateManager.resetColor();
        GL11.glPopMatrix();
        \u0445L\u0445L\u0445LL\u0445\u0445L\u0445\u0445LLL.points.removeIf(\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL -> (\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.getTime() - System.currentTimeMillis()) / 2000L < 0L);
    }

    @EventTarget
    public void sendPacket(EventSendPacket L\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL) {
        Trails \u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL;
        if (!\u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.getState()) {
            return;
        }
        if (L\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.getPacket() instanceof CPacketPlayer) {
            CPacketPlayer LL\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL = (CPacketPlayer)L\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.getPacket();
            \u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.points.add(new Point(LL\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.getX(Trails.mc.player.posX), LL\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.getY(Trails.mc.player.posY) < 0.0 ? Trails.mc.player.posY : LL\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.getY(Trails.mc.player.posY), LL\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.getZ(Trails.mc.player.posZ), System.currentTimeMillis()));
        }
    }

    @Override
    public void onEnable() {
        Trails \u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445\u0445LLL;
        \u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.points.clear();
        \u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.pointCount = 0.0f;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        Trails L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL;
        L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.points.clear();
        L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.pointCount = 0.0f;
        super.onDisable();
    }

    public static class Point {
        public double x;
        public double y;
        public double z;
        public long time;

        public Point(double L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445LL, double \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445LL, double LLLLL\u0445L\u0445L\u0445\u0445L\u0445LL, long \u0445LLLL\u0445L\u0445L\u0445\u0445L\u0445LL) {
            Point \u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445LL;
            \u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445LL.x = L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445LL;
            \u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445LL.y = \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445LL;
            \u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445LL.z = LLLLL\u0445L\u0445L\u0445\u0445L\u0445LL;
            \u0445L\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445LL.time = \u0445LLLL\u0445L\u0445L\u0445\u0445L\u0445LL;
        }

        public double getX() {
            Point LLL\u0445L\u0445L\u0445L\u0445\u0445L\u0445LL;
            return LLL\u0445L\u0445L\u0445L\u0445\u0445L\u0445LL.x;
        }

        public double getY() {
            Point \u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445L\u0445LL;
            return \u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445L\u0445LL.y;
        }

        public double getZ() {
            Point L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445LL;
            return L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445LL.z;
        }

        public long getTime() {
            Point \u0445LLL\u0445\u0445L\u0445L\u0445\u0445L\u0445LL;
            return \u0445LLL\u0445\u0445L\u0445L\u0445\u0445L\u0445LL.time;
        }
    }
}

