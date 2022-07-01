/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Iterator;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector4d;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.math.AxisAlignedBB;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender2D;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class MobESP
extends Feature {
    private final int black = Color.BLACK.getRGB();
    private final BooleanSetting fullBox;
    private final ColorSetting colorEsp;
    public ListSetting colorMode = new ListSetting("Color Box Mode", "Custom", () -> true, "Astolfo", "Rainbow", "Client", "Custom");
    public ListSetting itemEspMode = new ListSetting("ItemESP Mode", "2D", () -> true, "2D", "3D");

    public MobESP() {
        super("MobESP", "Shows mobs", Type.Visuals);
        MobESP \u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L;
        \u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.colorEsp = new ColorSetting("ESP Color", new Color(0xFFFFFF).getRGB(), () -> {
            MobESP \u0445LLLLL\u0445L\u0445\u0445\u0445L;
            return \u0445LLLLL\u0445L\u0445\u0445\u0445L.colorMode.currentMode.equals("Custom");
        });
        \u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.fullBox = new BooleanSetting("Full Box", false, () -> {
            MobESP L\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L;
            return L\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L.itemEspMode.currentMode.equals("3D");
        });
        \u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.addSettings(\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.itemEspMode, \u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.colorMode, \u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.colorEsp, \u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.fullBox);
    }

    @EventTarget
    public void onRender3D(EventRender3D L\u0445L\u0445LL\u0445\u0445L\u0445\u0445L) {
        Iterator LL\u0445\u0445LL\u0445\u0445L\u0445\u0445L = MobESP.mc.world.loadedEntityList.iterator();
        if (LL\u0445\u0445LL\u0445\u0445L\u0445\u0445L.hasNext()) {
            Entity LLL\u0445LL\u0445\u0445L\u0445\u0445L = (Entity)LL\u0445\u0445LL\u0445\u0445L\u0445\u0445L.next();
            if (LLL\u0445LL\u0445\u0445L\u0445\u0445L instanceof EntityVillager || LLL\u0445LL\u0445\u0445L\u0445\u0445L instanceof EntityZombie || LLL\u0445LL\u0445\u0445L\u0445\u0445L instanceof EntityAnimal) {
                MobESP \u0445LL\u0445LL\u0445\u0445L\u0445\u0445L;
                int \u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L = 0;
                switch (\u0445LL\u0445LL\u0445\u0445L\u0445\u0445L.colorMode.currentMode) {
                    case "Client": {
                        \u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L = ClientHelper.getClientColor().getRGB();
                        break;
                    }
                    case "Custom": {
                        \u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L = \u0445LL\u0445LL\u0445\u0445L\u0445\u0445L.colorEsp.getColorValue();
                        break;
                    }
                    case "Astolfo": {
                        \u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L = PaletteHelper.astolfo(false, (int)LLL\u0445LL\u0445\u0445L\u0445\u0445L.height).getRGB();
                        break;
                    }
                    case "Rainbow": {
                        \u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                    }
                }
                if (\u0445LL\u0445LL\u0445\u0445L\u0445\u0445L.itemEspMode.currentMode.equals("3D")) {
                    GlStateManager.pushMatrix();
                    RenderHelper.drawEntityBox(LLL\u0445LL\u0445\u0445L\u0445\u0445L, new Color(\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L), \u0445LL\u0445LL\u0445\u0445L\u0445\u0445L.fullBox.getBoolValue(), \u0445LL\u0445LL\u0445\u0445L\u0445\u0445L.fullBox.getBoolValue() ? 0.15f : 0.9f);
                    GlStateManager.popMatrix();
                }
            }
            return;
        }
    }

    @EventTarget
    public void onRender2D(EventRender2D \u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L) {
        MobESP L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L;
        String LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.itemEspMode.getOptions();
        L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.setSuffix(LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L);
        float \u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = MobESP.mc.timer.renderPartialTicks;
        GlStateManager.pushMatrix();
        int L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = \u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.getResolution().getScaleFactor();
        double \u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = (double)L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L / Math.pow(L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L, 2.0);
        GlStateManager.scale(\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L, \u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L, \u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L);
        Color LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = new Color(L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.colorEsp.getColorValue());
        Color \u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = new Color(LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L.getRed(), LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L.getGreen(), LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L.getBlue(), 255);
        int L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = 0;
        switch (L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.colorMode.currentMode) {
            case "Client": {
                L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = ClientHelper.getClientColor().getRGB();
                break;
            }
            case "Custom": {
                L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = \u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L.getRGB();
                break;
            }
            case "Astolfo": {
                L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = PaletteHelper.astolfo(false, 1).getRGB();
                break;
            }
            case "Rainbow": {
                L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
        Object LLL\u0445LLLL\u0445\u0445\u0445L = MobESP.mc.world.loadedEntityList.iterator();
        if (LLL\u0445LLLL\u0445\u0445\u0445L.hasNext()) {
            Entity \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L = (Entity)LLL\u0445LLLL\u0445\u0445\u0445L.next();
            MobESP mobESP = L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L;
            if (\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L != false && RenderHelper.isInViewFrustum(\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L)) {
                double L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L = \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.lastTickPosX + (\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.posX - \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.lastTickPosX) * (double)mc.getRenderPartialTicks();
                double \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L = \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.lastTickPosY + (\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.posY - \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.lastTickPosY) * (double)mc.getRenderPartialTicks();
                double LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L = \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.lastTickPosZ + (\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.posZ - \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.lastTickPosZ) * (double)mc.getRenderPartialTicks();
                AxisAlignedBB \u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L = \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.getEntityBoundingBox();
                AxisAlignedBB L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L = new AxisAlignedBB(\u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L.minX - \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.posX + L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L - 0.05, \u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L.minY - \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.posY + \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, \u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L.minZ - \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.posZ + LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L - 0.05, \u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxX - \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.posX + L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.05, \u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxY - \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.posY + \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.15, \u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxZ - \u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.posZ + LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L + 0.05);
                Vector3d[] \u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L = new Vector3d[]{new Vector3d(L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minX, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minY, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minZ), new Vector3d(L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minX, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxY, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minZ), new Vector3d(L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxX, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minY, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minZ), new Vector3d(L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxX, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxY, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minZ), new Vector3d(L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minX, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minY, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxZ), new Vector3d(L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minX, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxY, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxZ), new Vector3d(L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxX, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.minY, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxZ), new Vector3d(L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxX, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxY, L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.maxZ)};
                MobESP.mc.entityRenderer.setupCameraTransform(\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L, 0);
                Vector4d LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L = null;
                Vector3d[] \u0445LLL\u0445LLL\u0445\u0445\u0445L = \u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L;
                int L\u0445LL\u0445LLL\u0445\u0445\u0445L = \u0445LLL\u0445LLL\u0445\u0445\u0445L.length;
                int \u0445\u0445LL\u0445LLL\u0445\u0445\u0445L = 0;
                if (\u0445\u0445LL\u0445LLL\u0445\u0445\u0445L < L\u0445LL\u0445LLL\u0445\u0445\u0445L) {
                    Vector3d \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L = \u0445LLL\u0445LLL\u0445\u0445\u0445L[\u0445\u0445LL\u0445LLL\u0445\u0445\u0445L];
                    \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L = L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.project2D(L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L, \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.x - MobESP.mc.getRenderManager().renderPosX, \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.y - MobESP.mc.getRenderManager().renderPosY, \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.z - MobESP.mc.getRenderManager().renderPosZ);
                    if (\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L != null && \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.z > 0.0 && \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.z < 1.0) {
                        if (LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L == null) {
                            LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L = new Vector4d(\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.x, \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.y, \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.z, 0.0);
                        }
                        LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.x = Math.min(\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.x, LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.x);
                        LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.y = Math.min(\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.y, LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.y);
                        LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.z = Math.max(\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.x, LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.z);
                        LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.w = Math.max(\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.y, LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.w);
                    }
                    ++\u0445\u0445LL\u0445LLL\u0445\u0445\u0445L;
                    return;
                }
                if (LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L != null) {
                    MobESP.mc.entityRenderer.setupOverlayRendering();
                    double L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.x;
                    double \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.y;
                    double LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.z;
                    double \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.w;
                    if (LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L.equalsIgnoreCase("2D")) {
                        RectHelper.drawRect(L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L - 1.0, \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L, L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.5, \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.5, L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.black);
                        RectHelper.drawRect(L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L - 1.0, \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L - 0.5, LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.5, \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.5 + 0.5, L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.black);
                        RectHelper.drawRect(LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L - 0.5 - 0.5, \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L, LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.5, \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.5, L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.black);
                        RectHelper.drawRect(L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L - 1.0, \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L - 0.5 - 0.5, LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.5, \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.5, L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.black);
                        RectHelper.drawRect(L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L - 0.5, \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L, L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.5 - 0.5, \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L);
                        RectHelper.drawRect(L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L, \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L - 0.5, LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L);
                        RectHelper.drawRect(L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L - 0.5, \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L, LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L + 0.5, L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L);
                        RectHelper.drawRect(LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L - 0.5, \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L, LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L);
                    }
                }
            }
            return;
        }
        GlStateManager.popMatrix();
        MobESP.mc.entityRenderer.setupOverlayRendering();
    }

    private Vector3d project2D(int \u0445\u0445LLL\u0445LL\u0445\u0445\u0445L, double LL\u0445LL\u0445LL\u0445\u0445\u0445L, double \u0445L\u0445LL\u0445LL\u0445\u0445\u0445L, double L\u0445\u0445LL\u0445LL\u0445\u0445\u0445L) {
        float \u0445\u0445\u0445LL\u0445LL\u0445\u0445\u0445L = (float)LL\u0445LL\u0445LL\u0445\u0445\u0445L;
        float LLL\u0445L\u0445LL\u0445\u0445\u0445L = (float)\u0445L\u0445LL\u0445LL\u0445\u0445\u0445L;
        float \u0445LL\u0445L\u0445LL\u0445\u0445\u0445L = (float)L\u0445\u0445LL\u0445LL\u0445\u0445\u0445L;
        IntBuffer L\u0445L\u0445L\u0445LL\u0445\u0445\u0445L = GLAllocation.createDirectIntBuffer(16);
        FloatBuffer \u0445\u0445L\u0445L\u0445LL\u0445\u0445\u0445L = GLAllocation.createDirectFloatBuffer(16);
        FloatBuffer LL\u0445\u0445L\u0445LL\u0445\u0445\u0445L = GLAllocation.createDirectFloatBuffer(16);
        FloatBuffer \u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445L = GLAllocation.createDirectFloatBuffer(4);
        GL11.glGetFloat(2982, \u0445\u0445L\u0445L\u0445LL\u0445\u0445\u0445L);
        GL11.glGetFloat(2983, LL\u0445\u0445L\u0445LL\u0445\u0445\u0445L);
        GL11.glGetInteger(2978, L\u0445L\u0445L\u0445LL\u0445\u0445\u0445L);
        if (GLU.gluProject(\u0445\u0445\u0445LL\u0445LL\u0445\u0445\u0445L, LLL\u0445L\u0445LL\u0445\u0445\u0445L, \u0445LL\u0445L\u0445LL\u0445\u0445\u0445L, \u0445\u0445L\u0445L\u0445LL\u0445\u0445\u0445L, LL\u0445\u0445L\u0445LL\u0445\u0445\u0445L, L\u0445L\u0445L\u0445LL\u0445\u0445\u0445L, \u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445L)) {
            return new Vector3d(\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445L.get(0) / (float)\u0445\u0445LLL\u0445LL\u0445\u0445\u0445L, ((float)Display.getHeight() - \u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445L.get(1)) / (float)\u0445\u0445LLL\u0445LL\u0445\u0445\u0445L, \u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445L.get(2));
        }
        return null;
    }
}

