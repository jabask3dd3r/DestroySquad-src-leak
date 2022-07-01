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
import net.minecraft.entity.item.EntityItem;
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

public class ItemESP
extends Feature {
    private final int black = Color.BLACK.getRGB();
    private final BooleanSetting fullBox;
    private final ColorSetting colorEsp;
    public ListSetting colorMode = new ListSetting("Color Box Mode", "Client", () -> true, "Astolfo", "Rainbow", "Client", "Custom");
    public ListSetting itemEspMode = new ListSetting("ItemESP Mode", "2D", () -> true, "2D", "3D");
    public BooleanSetting entityName = new BooleanSetting("Entity Name", true, () -> true);

    public ItemESP() {
        super("ItemESP", "\nItem Display", Type.Visuals);
        ItemESP L\u0445L\u0445\u0445\u0445\u0445L\u0445LL;
        L\u0445L\u0445\u0445\u0445\u0445L\u0445LL.colorEsp = new ColorSetting("ESP Color", new Color(0xFFFFFF).getRGB(), () -> {
            ItemESP \u0445\u0445\u0445\u0445L\u0445LLL\u0445L;
            return \u0445\u0445\u0445\u0445L\u0445LLL\u0445L.colorMode.currentMode.equals("Custom");
        });
        L\u0445L\u0445\u0445\u0445\u0445L\u0445LL.fullBox = new BooleanSetting("Full Box", false, () -> {
            ItemESP \u0445LL\u0445L\u0445LLL\u0445L;
            return \u0445LL\u0445L\u0445LLL\u0445L.itemEspMode.currentMode.equals("3D");
        });
        L\u0445L\u0445\u0445\u0445\u0445L\u0445LL.addSettings(L\u0445L\u0445\u0445\u0445\u0445L\u0445LL.itemEspMode, L\u0445L\u0445\u0445\u0445\u0445L\u0445LL.colorMode, L\u0445L\u0445\u0445\u0445\u0445L\u0445LL.colorEsp, L\u0445L\u0445\u0445\u0445\u0445L\u0445LL.entityName, L\u0445L\u0445\u0445\u0445\u0445L\u0445LL.fullBox);
    }

    @EventTarget
    public void onRender3D(EventRender3D LL\u0445L\u0445LL\u0445\u0445LL) {
        Iterator LLL\u0445\u0445LL\u0445\u0445LL = ItemESP.mc.world.loadedEntityList.iterator();
        if (LLL\u0445\u0445LL\u0445\u0445LL.hasNext()) {
            Entity \u0445LLL\u0445LL\u0445\u0445LL = (Entity)LLL\u0445\u0445LL\u0445\u0445LL.next();
            if (\u0445LLL\u0445LL\u0445\u0445LL instanceof EntityItem) {
                ItemESP \u0445\u0445LL\u0445LL\u0445\u0445LL;
                int LLLL\u0445LL\u0445\u0445LL = 0;
                switch (\u0445\u0445LL\u0445LL\u0445\u0445LL.colorMode.currentMode) {
                    case "Client": {
                        LLLL\u0445LL\u0445\u0445LL = ClientHelper.getClientColor().getRGB();
                        break;
                    }
                    case "Custom": {
                        LLLL\u0445LL\u0445\u0445LL = \u0445\u0445LL\u0445LL\u0445\u0445LL.colorEsp.getColorValue();
                        break;
                    }
                    case "Astolfo": {
                        LLLL\u0445LL\u0445\u0445LL = PaletteHelper.astolfo(false, (int)\u0445LLL\u0445LL\u0445\u0445LL.height).getRGB();
                        break;
                    }
                    case "Rainbow": {
                        LLLL\u0445LL\u0445\u0445LL = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                    }
                }
                if (\u0445\u0445LL\u0445LL\u0445\u0445LL.itemEspMode.currentMode.equals("3D")) {
                    GlStateManager.pushMatrix();
                    RenderHelper.drawEntityBox(\u0445LLL\u0445LL\u0445\u0445LL, new Color(LLLL\u0445LL\u0445\u0445LL), \u0445\u0445LL\u0445LL\u0445\u0445LL.fullBox.getBoolValue(), \u0445\u0445LL\u0445LL\u0445\u0445LL.fullBox.getBoolValue() ? 0.15f : 0.9f);
                    GlStateManager.popMatrix();
                }
            }
            return;
        }
    }

    @EventTarget
    public void onRender2D(EventRender2D \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL) {
        ItemESP L\u0445L\u0445\u0445L\u0445\u0445\u0445LL;
        String LL\u0445\u0445\u0445L\u0445\u0445\u0445LL = L\u0445L\u0445\u0445L\u0445\u0445\u0445LL.itemEspMode.getOptions();
        L\u0445L\u0445\u0445L\u0445\u0445\u0445LL.setSuffix(LL\u0445\u0445\u0445L\u0445\u0445\u0445LL);
        float \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LL = ItemESP.mc.timer.renderPartialTicks;
        int L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL = \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL.getResolution().getScaleFactor();
        double \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL = (double)L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL / Math.pow(L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL, 2.0);
        GlStateManager.scale(\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL, \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL, \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL);
        Color LLLLL\u0445\u0445\u0445\u0445LL = new Color(L\u0445L\u0445\u0445L\u0445\u0445\u0445LL.colorEsp.getColorValue());
        Color \u0445LLLL\u0445\u0445\u0445\u0445LL = new Color(LLLLL\u0445\u0445\u0445\u0445LL.getRed(), LLLLL\u0445\u0445\u0445\u0445LL.getGreen(), LLLLL\u0445\u0445\u0445\u0445LL.getBlue());
        int L\u0445LLL\u0445\u0445\u0445\u0445LL = 0;
        switch (L\u0445L\u0445\u0445L\u0445\u0445\u0445LL.colorMode.currentMode) {
            case "Client": {
                L\u0445LLL\u0445\u0445\u0445\u0445LL = ClientHelper.getClientColor().getRGB();
                break;
            }
            case "Custom": {
                L\u0445LLL\u0445\u0445\u0445\u0445LL = \u0445LLLL\u0445\u0445\u0445\u0445LL.getRGB();
                break;
            }
            case "Astolfo": {
                L\u0445LLL\u0445\u0445\u0445\u0445LL = PaletteHelper.astolfo(false, 1).getRGB();
                break;
            }
            case "Rainbow": {
                L\u0445LLL\u0445\u0445\u0445\u0445LL = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
        float \u0445\u0445LLL\u0445\u0445\u0445\u0445LL = 1.0f;
        Iterator L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL = ItemESP.mc.world.loadedEntityList.iterator();
        if (L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL.hasNext()) {
            Entity \u0445LL\u0445\u0445L\u0445\u0445\u0445LL = (Entity)L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL.next();
            if (L\u0445L\u0445\u0445L\u0445\u0445\u0445LL.isValid(\u0445LL\u0445\u0445L\u0445\u0445\u0445LL) && RenderHelper.isInViewFrustum(\u0445LL\u0445\u0445L\u0445\u0445\u0445LL)) {
                EntityItem \u0445LLL\u0445L\u0445\u0445\u0445LL = (EntityItem)\u0445LL\u0445\u0445L\u0445\u0445\u0445LL;
                double L\u0445LL\u0445L\u0445\u0445\u0445LL = \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.lastTickPosX + (\u0445LL\u0445\u0445L\u0445\u0445\u0445LL.posX - \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.lastTickPosX) * (double)mc.getRenderPartialTicks();
                double \u0445\u0445LL\u0445L\u0445\u0445\u0445LL = \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.lastTickPosY + (\u0445LL\u0445\u0445L\u0445\u0445\u0445LL.posY - \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.lastTickPosY) * (double)mc.getRenderPartialTicks();
                double LL\u0445L\u0445L\u0445\u0445\u0445LL = \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.lastTickPosZ + (\u0445LL\u0445\u0445L\u0445\u0445\u0445LL.posZ - \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.lastTickPosZ) * (double)mc.getRenderPartialTicks();
                AxisAlignedBB \u0445L\u0445L\u0445L\u0445\u0445\u0445LL = \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.getEntityBoundingBox();
                AxisAlignedBB L\u0445\u0445L\u0445L\u0445\u0445\u0445LL = new AxisAlignedBB(\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.minX - \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.posX + L\u0445LL\u0445L\u0445\u0445\u0445LL - 0.05, \u0445L\u0445L\u0445L\u0445\u0445\u0445LL.minY - \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.posY + \u0445\u0445LL\u0445L\u0445\u0445\u0445LL, \u0445L\u0445L\u0445L\u0445\u0445\u0445LL.minZ - \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.posZ + LL\u0445L\u0445L\u0445\u0445\u0445LL - 0.05, \u0445L\u0445L\u0445L\u0445\u0445\u0445LL.maxX - \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.posX + L\u0445LL\u0445L\u0445\u0445\u0445LL + 0.05, \u0445L\u0445L\u0445L\u0445\u0445\u0445LL.maxY - \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.posY + \u0445\u0445LL\u0445L\u0445\u0445\u0445LL + 0.15, \u0445L\u0445L\u0445L\u0445\u0445\u0445LL.maxZ - \u0445LL\u0445\u0445L\u0445\u0445\u0445LL.posZ + LL\u0445L\u0445L\u0445\u0445\u0445LL + 0.05);
                Vector3d[] \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL = new Vector3d[]{new Vector3d(L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minX, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minY, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minZ), new Vector3d(L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minX, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxY, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minZ), new Vector3d(L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxX, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minY, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minZ), new Vector3d(L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxX, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxY, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minZ), new Vector3d(L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minX, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minY, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxZ), new Vector3d(L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minX, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxY, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxZ), new Vector3d(L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxX, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.minY, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxZ), new Vector3d(L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxX, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxY, L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.maxZ)};
                ItemESP.mc.entityRenderer.setupCameraTransform(\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LL, 0);
                Vector4d LLL\u0445\u0445L\u0445\u0445\u0445LL = null;
                Vector3d[] LLL\u0445\u0445\u0445\u0445\u0445\u0445LL = \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL;
                int \u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL = LLL\u0445\u0445\u0445\u0445\u0445\u0445LL.length;
                int L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL = 0;
                if (L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL < \u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL) {
                    Vector3d \u0445LL\u0445LL\u0445\u0445\u0445LL = LLL\u0445\u0445\u0445\u0445\u0445\u0445LL[L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL];
                    \u0445LL\u0445LL\u0445\u0445\u0445LL = L\u0445L\u0445\u0445L\u0445\u0445\u0445LL.project2D(L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL, \u0445LL\u0445LL\u0445\u0445\u0445LL.x - ItemESP.mc.getRenderManager().renderPosX, \u0445LL\u0445LL\u0445\u0445\u0445LL.y - ItemESP.mc.getRenderManager().renderPosY, \u0445LL\u0445LL\u0445\u0445\u0445LL.z - ItemESP.mc.getRenderManager().renderPosZ);
                    if (\u0445LL\u0445LL\u0445\u0445\u0445LL != null && \u0445LL\u0445LL\u0445\u0445\u0445LL.z > 0.0 && \u0445LL\u0445LL\u0445\u0445\u0445LL.z < 1.0) {
                        if (LLL\u0445\u0445L\u0445\u0445\u0445LL == null) {
                            LLL\u0445\u0445L\u0445\u0445\u0445LL = new Vector4d(\u0445LL\u0445LL\u0445\u0445\u0445LL.x, \u0445LL\u0445LL\u0445\u0445\u0445LL.y, \u0445LL\u0445LL\u0445\u0445\u0445LL.z, 0.0);
                        }
                        LLL\u0445\u0445L\u0445\u0445\u0445LL.x = Math.min(\u0445LL\u0445LL\u0445\u0445\u0445LL.x, LLL\u0445\u0445L\u0445\u0445\u0445LL.x);
                        LLL\u0445\u0445L\u0445\u0445\u0445LL.y = Math.min(\u0445LL\u0445LL\u0445\u0445\u0445LL.y, LLL\u0445\u0445L\u0445\u0445\u0445LL.y);
                        LLL\u0445\u0445L\u0445\u0445\u0445LL.z = Math.max(\u0445LL\u0445LL\u0445\u0445\u0445LL.x, LLL\u0445\u0445L\u0445\u0445\u0445LL.z);
                        LLL\u0445\u0445L\u0445\u0445\u0445LL.w = Math.max(\u0445LL\u0445LL\u0445\u0445\u0445LL.y, LLL\u0445\u0445L\u0445\u0445\u0445LL.w);
                    }
                    ++L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL;
                    return;
                }
                if (LLL\u0445\u0445L\u0445\u0445\u0445LL != null) {
                    ItemESP.mc.entityRenderer.setupOverlayRendering();
                    double L\u0445L\u0445LL\u0445\u0445\u0445LL = LLL\u0445\u0445L\u0445\u0445\u0445LL.x;
                    double \u0445\u0445L\u0445LL\u0445\u0445\u0445LL = LLL\u0445\u0445L\u0445\u0445\u0445LL.y;
                    double LL\u0445\u0445LL\u0445\u0445\u0445LL = LLL\u0445\u0445L\u0445\u0445\u0445LL.z;
                    double \u0445L\u0445\u0445LL\u0445\u0445\u0445LL = LLL\u0445\u0445L\u0445\u0445\u0445LL.w;
                    if (LL\u0445\u0445\u0445L\u0445\u0445\u0445LL.equalsIgnoreCase("2D")) {
                        RectHelper.drawRect(L\u0445L\u0445LL\u0445\u0445\u0445LL - 1.0, \u0445\u0445L\u0445LL\u0445\u0445\u0445LL, L\u0445L\u0445LL\u0445\u0445\u0445LL + 0.5, \u0445L\u0445\u0445LL\u0445\u0445\u0445LL + 0.5, L\u0445L\u0445\u0445L\u0445\u0445\u0445LL.black);
                        RectHelper.drawRect(L\u0445L\u0445LL\u0445\u0445\u0445LL - 1.0, \u0445\u0445L\u0445LL\u0445\u0445\u0445LL - 0.5, LL\u0445\u0445LL\u0445\u0445\u0445LL + 0.5, \u0445\u0445L\u0445LL\u0445\u0445\u0445LL + 0.5 + 0.5, L\u0445L\u0445\u0445L\u0445\u0445\u0445LL.black);
                        RectHelper.drawRect(LL\u0445\u0445LL\u0445\u0445\u0445LL - 0.5 - 0.5, \u0445\u0445L\u0445LL\u0445\u0445\u0445LL, LL\u0445\u0445LL\u0445\u0445\u0445LL + 0.5, \u0445L\u0445\u0445LL\u0445\u0445\u0445LL + 0.5, L\u0445L\u0445\u0445L\u0445\u0445\u0445LL.black);
                        RectHelper.drawRect(L\u0445L\u0445LL\u0445\u0445\u0445LL - 1.0, \u0445L\u0445\u0445LL\u0445\u0445\u0445LL - 0.5 - 0.5, LL\u0445\u0445LL\u0445\u0445\u0445LL + 0.5, \u0445L\u0445\u0445LL\u0445\u0445\u0445LL + 0.5, L\u0445L\u0445\u0445L\u0445\u0445\u0445LL.black);
                        RectHelper.drawRect(L\u0445L\u0445LL\u0445\u0445\u0445LL - 0.5, \u0445\u0445L\u0445LL\u0445\u0445\u0445LL, L\u0445L\u0445LL\u0445\u0445\u0445LL + 0.5 - 0.5, \u0445L\u0445\u0445LL\u0445\u0445\u0445LL, L\u0445LLL\u0445\u0445\u0445\u0445LL);
                        RectHelper.drawRect(L\u0445L\u0445LL\u0445\u0445\u0445LL, \u0445L\u0445\u0445LL\u0445\u0445\u0445LL - 0.5, LL\u0445\u0445LL\u0445\u0445\u0445LL, \u0445L\u0445\u0445LL\u0445\u0445\u0445LL, L\u0445LLL\u0445\u0445\u0445\u0445LL);
                        RectHelper.drawRect(L\u0445L\u0445LL\u0445\u0445\u0445LL - 0.5, \u0445\u0445L\u0445LL\u0445\u0445\u0445LL, LL\u0445\u0445LL\u0445\u0445\u0445LL, \u0445\u0445L\u0445LL\u0445\u0445\u0445LL + 0.5, L\u0445LLL\u0445\u0445\u0445\u0445LL);
                        RectHelper.drawRect(LL\u0445\u0445LL\u0445\u0445\u0445LL - 0.5, \u0445\u0445L\u0445LL\u0445\u0445\u0445LL, LL\u0445\u0445LL\u0445\u0445\u0445LL, \u0445L\u0445\u0445LL\u0445\u0445\u0445LL, L\u0445LLL\u0445\u0445\u0445\u0445LL);
                    }
                    float L\u0445\u0445\u0445LL\u0445\u0445\u0445LL = (float)(LL\u0445\u0445LL\u0445\u0445\u0445LL - L\u0445L\u0445LL\u0445\u0445\u0445LL) / 2.0f;
                    float \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LL = (float)ItemESP.mc.fontRendererObj.getStringWidth(\u0445LLL\u0445L\u0445\u0445\u0445LL.getEntityItem().getDisplayName()) * \u0445\u0445LLL\u0445\u0445\u0445\u0445LL;
                    float LLLL\u0445L\u0445\u0445\u0445LL = (float)((L\u0445L\u0445LL\u0445\u0445\u0445LL + (double)L\u0445\u0445\u0445LL\u0445\u0445\u0445LL - (double)(\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LL / 2.0f)) * (double)\u0445\u0445LLL\u0445\u0445\u0445\u0445LL);
                    if (L\u0445L\u0445\u0445L\u0445\u0445\u0445LL.entityName.getBoolValue()) {
                        ClientHelper.getFontRender().drawStringWithShadow(\u0445LLL\u0445L\u0445\u0445\u0445LL.getEntityItem().getDisplayName(), LLLL\u0445L\u0445\u0445\u0445LL, (float)\u0445\u0445L\u0445LL\u0445\u0445\u0445LL - 10.0f, -1);
                    }
                }
            }
            return;
        }
        GL11.glEnable(2929);
        ItemESP.mc.entityRenderer.setupOverlayRendering();
    }

    private Vector3d project2D(int \u0445L\u0445\u0445LLLLL\u0445L, double L\u0445\u0445\u0445LLLLL\u0445L, double \u0445\u0445\u0445\u0445LLLLL\u0445L, double LLLL\u0445LLLL\u0445L) {
        float \u0445LLL\u0445LLLL\u0445L = (float)L\u0445\u0445\u0445LLLLL\u0445L;
        float L\u0445LL\u0445LLLL\u0445L = (float)\u0445\u0445\u0445\u0445LLLLL\u0445L;
        float \u0445\u0445LL\u0445LLLL\u0445L = (float)LLLL\u0445LLLL\u0445L;
        IntBuffer LL\u0445L\u0445LLLL\u0445L = GLAllocation.createDirectIntBuffer(16);
        FloatBuffer \u0445L\u0445L\u0445LLLL\u0445L = GLAllocation.createDirectFloatBuffer(16);
        FloatBuffer L\u0445\u0445L\u0445LLLL\u0445L = GLAllocation.createDirectFloatBuffer(16);
        FloatBuffer \u0445\u0445\u0445L\u0445LLLL\u0445L = GLAllocation.createDirectFloatBuffer(4);
        GL11.glGetFloat(2982, \u0445L\u0445L\u0445LLLL\u0445L);
        GL11.glGetFloat(2983, L\u0445\u0445L\u0445LLLL\u0445L);
        GL11.glGetInteger(2978, LL\u0445L\u0445LLLL\u0445L);
        if (GLU.gluProject(\u0445LLL\u0445LLLL\u0445L, L\u0445LL\u0445LLLL\u0445L, \u0445\u0445LL\u0445LLLL\u0445L, \u0445L\u0445L\u0445LLLL\u0445L, L\u0445\u0445L\u0445LLLL\u0445L, LL\u0445L\u0445LLLL\u0445L, \u0445\u0445\u0445L\u0445LLLL\u0445L)) {
            return new Vector3d(\u0445\u0445\u0445L\u0445LLLL\u0445L.get(0) / (float)\u0445L\u0445\u0445LLLLL\u0445L, ((float)Display.getHeight() - \u0445\u0445\u0445L\u0445LLLL\u0445L.get(1)) / (float)\u0445L\u0445\u0445LLLLL\u0445L, \u0445\u0445\u0445L\u0445LLLL\u0445L.get(2));
        }
        return null;
    }

    private boolean isValid(Entity \u0445L\u0445LL\u0445LLL\u0445L) {
        return \u0445L\u0445LL\u0445LLL\u0445L instanceof EntityItem;
    }
}

