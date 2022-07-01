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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
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

public class ChestESP
extends Feature {
    public static ListSetting chestEspMode = new ListSetting("ChestEsp Mode", "3D", () -> true, "3D", "Chams");
    public static ColorSetting chamsColor = new ColorSetting("Chams Color", Color.PINK.getRGB(), () -> ChestESP.chestEspMode.currentMode.equals("Chams"));
    private final int black = Color.BLACK.getRGB();
    private final BooleanSetting fullBox;
    private final ColorSetting colorEsp;
    public ListSetting colorMode = new ListSetting("Color Box Mode", "Custom", () -> true, "Astolfo", "Rainbow", "Client", "Custom");

    public ChestESP() {
        super("ChestESP", "Shows chests", Type.Visuals);
        ChestESP L\u0445LLL\u0445\u0445\u0445LLL\u0445LL;
        L\u0445LLL\u0445\u0445\u0445LLL\u0445LL.colorEsp = new ColorSetting("ChestEsp Color", new Color(0xFFFFFF).getRGB(), () -> {
            ChestESP L\u0445LL\u0445L\u0445L\u0445LL\u0445LL;
            return L\u0445LL\u0445L\u0445L\u0445LL\u0445LL.colorMode.currentMode.equals("Custom") && !ChestESP.chestEspMode.currentMode.equals("Chams");
        });
        L\u0445LLL\u0445\u0445\u0445LLL\u0445LL.fullBox = new BooleanSetting("Full Box", false, () -> ChestESP.chestEspMode.currentMode.equals("3D"));
        L\u0445LLL\u0445\u0445\u0445LLL\u0445LL.addSettings(chestEspMode, L\u0445LLL\u0445\u0445\u0445LLL\u0445LL.colorMode, L\u0445LLL\u0445\u0445\u0445LLL\u0445LL.colorEsp, chamsColor, L\u0445LLL\u0445\u0445\u0445LLL\u0445LL.fullBox);
    }

    @EventTarget
    public void onRender3D(EventRender3D \u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL) {
        Iterator \u0445LLL\u0445\u0445\u0445\u0445LLL\u0445LL = ChestESP.mc.world.loadedTileEntityList.iterator();
        if (\u0445LLL\u0445\u0445\u0445\u0445LLL\u0445LL.hasNext()) {
            TileEntity \u0445L\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL = (TileEntity)\u0445LLL\u0445\u0445\u0445\u0445LLL\u0445LL.next();
            if (\u0445L\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL instanceof TileEntityChest) {
                ChestESP L\u0445\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL;
                BlockPos \u0445\u0445L\u0445L\u0445\u0445\u0445LLL\u0445LL = \u0445L\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL.getPos();
                int LL\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL = 0;
                switch (L\u0445\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL.colorMode.currentMode) {
                    case "Client": {
                        LL\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL = ClientHelper.getClientColor().getRGB();
                        break;
                    }
                    case "Custom": {
                        LL\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL = L\u0445\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL.colorEsp.getColorValue();
                        break;
                    }
                    case "Astolfo": {
                        LL\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL = PaletteHelper.astolfo(false, \u0445L\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL.getPos().getY()).getRGB();
                        break;
                    }
                    case "Rainbow": {
                        LL\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                    }
                }
                if (ChestESP.chestEspMode.currentMode.equals("3D")) {
                    GlStateManager.pushMatrix();
                    RenderHelper.blockEsp(\u0445\u0445L\u0445L\u0445\u0445\u0445LLL\u0445LL, new Color(LL\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL), L\u0445\u0445\u0445L\u0445\u0445\u0445LLL\u0445LL.fullBox.getBoolValue());
                    GlStateManager.popMatrix();
                }
            }
            return;
        }
    }

    @EventTarget
    public void onRender2D(EventRender2D \u0445\u0445\u0445L\u0445LLL\u0445LL\u0445LL) {
        ChestESP L\u0445\u0445L\u0445LLL\u0445LL\u0445LL;
        String LLL\u0445\u0445LLL\u0445LL\u0445LL = chestEspMode.getOptions();
        L\u0445\u0445L\u0445LLL\u0445LL\u0445LL.setSuffix(LLL\u0445\u0445LLL\u0445LL\u0445LL);
        float \u0445LL\u0445\u0445LLL\u0445LL\u0445LL = ChestESP.mc.timer.renderPartialTicks;
        int L\u0445L\u0445\u0445LLL\u0445LL\u0445LL = \u0445\u0445\u0445L\u0445LLL\u0445LL\u0445LL.getResolution().getScaleFactor();
        double \u0445\u0445L\u0445\u0445LLL\u0445LL\u0445LL = (double)L\u0445L\u0445\u0445LLL\u0445LL\u0445LL / Math.pow(L\u0445L\u0445\u0445LLL\u0445LL\u0445LL, 2.0);
        GlStateManager.scale(\u0445\u0445L\u0445\u0445LLL\u0445LL\u0445LL, \u0445\u0445L\u0445\u0445LLL\u0445LL\u0445LL, \u0445\u0445L\u0445\u0445LLL\u0445LL\u0445LL);
        Color LL\u0445\u0445\u0445LLL\u0445LL\u0445LL = new Color(L\u0445\u0445L\u0445LLL\u0445LL\u0445LL.colorEsp.getColorValue());
        Color \u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL = new Color(LL\u0445\u0445\u0445LLL\u0445LL\u0445LL.getRed(), LL\u0445\u0445\u0445LLL\u0445LL\u0445LL.getGreen(), LL\u0445\u0445\u0445LLL\u0445LL\u0445LL.getBlue());
        int L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL = 0;
        switch (L\u0445\u0445L\u0445LLL\u0445LL\u0445LL.colorMode.currentMode) {
            case "Client": {
                L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL = ClientHelper.getClientColor().getRGB();
                break;
            }
            case "Custom": {
                L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL = \u0445L\u0445\u0445\u0445LLL\u0445LL\u0445LL.getRGB();
                break;
            }
            case "Astolfo": {
                L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL = PaletteHelper.astolfo(false, 1).getRGB();
                break;
            }
            case "Rainbow": {
                L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
        Object LLL\u0445L\u0445LL\u0445LL\u0445LL = ChestESP.mc.world.loadedTileEntityList.iterator();
        if (LLL\u0445L\u0445LL\u0445LL\u0445LL.hasNext()) {
            TileEntity \u0445L\u0445L\u0445LLL\u0445LL\u0445LL = (TileEntity)LLL\u0445L\u0445LL\u0445LL\u0445LL.next();
            if (L\u0445\u0445L\u0445LLL\u0445LL\u0445LL.isValid(\u0445L\u0445L\u0445LLL\u0445LL\u0445LL)) {
                BlockPos \u0445LLL\u0445LLL\u0445LL\u0445LL = \u0445L\u0445L\u0445LLL\u0445LL\u0445LL.getPos();
                AxisAlignedBB L\u0445LL\u0445LLL\u0445LL\u0445LL = new AxisAlignedBB(\u0445LLL\u0445LLL\u0445LL\u0445LL);
                Vector3d[] \u0445\u0445LL\u0445LLL\u0445LL\u0445LL = new Vector3d[]{new Vector3d(L\u0445LL\u0445LLL\u0445LL\u0445LL.minX, L\u0445LL\u0445LLL\u0445LL\u0445LL.minY, L\u0445LL\u0445LLL\u0445LL\u0445LL.minZ), new Vector3d(L\u0445LL\u0445LLL\u0445LL\u0445LL.minX, L\u0445LL\u0445LLL\u0445LL\u0445LL.maxY, L\u0445LL\u0445LLL\u0445LL\u0445LL.minZ), new Vector3d(L\u0445LL\u0445LLL\u0445LL\u0445LL.maxX, L\u0445LL\u0445LLL\u0445LL\u0445LL.minY, L\u0445LL\u0445LLL\u0445LL\u0445LL.minZ), new Vector3d(L\u0445LL\u0445LLL\u0445LL\u0445LL.maxX, L\u0445LL\u0445LLL\u0445LL\u0445LL.maxY, L\u0445LL\u0445LLL\u0445LL\u0445LL.minZ), new Vector3d(L\u0445LL\u0445LLL\u0445LL\u0445LL.minX, L\u0445LL\u0445LLL\u0445LL\u0445LL.minY, L\u0445LL\u0445LLL\u0445LL\u0445LL.maxZ), new Vector3d(L\u0445LL\u0445LLL\u0445LL\u0445LL.minX, L\u0445LL\u0445LLL\u0445LL\u0445LL.maxY, L\u0445LL\u0445LLL\u0445LL\u0445LL.maxZ), new Vector3d(L\u0445LL\u0445LLL\u0445LL\u0445LL.maxX, L\u0445LL\u0445LLL\u0445LL\u0445LL.minY, L\u0445LL\u0445LLL\u0445LL\u0445LL.maxZ), new Vector3d(L\u0445LL\u0445LLL\u0445LL\u0445LL.maxX, L\u0445LL\u0445LLL\u0445LL\u0445LL.maxY, L\u0445LL\u0445LLL\u0445LL\u0445LL.maxZ)};
                ChestESP.mc.entityRenderer.setupCameraTransform(\u0445LL\u0445\u0445LLL\u0445LL\u0445LL, 0);
                Vector4d LL\u0445L\u0445LLL\u0445LL\u0445LL = null;
                Vector3d[] L\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL = \u0445\u0445LL\u0445LLL\u0445LL\u0445LL;
                int \u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL = L\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL.length;
                int LLLL\u0445\u0445LL\u0445LL\u0445LL = 0;
                if (LLLL\u0445\u0445LL\u0445LL\u0445LL < \u0445\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL) {
                    Vector3d LL\u0445\u0445LLLL\u0445LL\u0445LL = L\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LL[LLLL\u0445\u0445LL\u0445LL\u0445LL];
                    LL\u0445\u0445LLLL\u0445LL\u0445LL = L\u0445\u0445L\u0445LLL\u0445LL\u0445LL.project2D(L\u0445L\u0445\u0445LLL\u0445LL\u0445LL, LL\u0445\u0445LLLL\u0445LL\u0445LL.x - ChestESP.mc.getRenderManager().renderPosX, LL\u0445\u0445LLLL\u0445LL\u0445LL.y - ChestESP.mc.getRenderManager().renderPosY, LL\u0445\u0445LLLL\u0445LL\u0445LL.z - ChestESP.mc.getRenderManager().renderPosZ);
                    if (LL\u0445\u0445LLLL\u0445LL\u0445LL != null && LL\u0445\u0445LLLL\u0445LL\u0445LL.z > 0.0 && LL\u0445\u0445LLLL\u0445LL\u0445LL.z < 1.0) {
                        if (LL\u0445L\u0445LLL\u0445LL\u0445LL == null) {
                            LL\u0445L\u0445LLL\u0445LL\u0445LL = new Vector4d(LL\u0445\u0445LLLL\u0445LL\u0445LL.x, LL\u0445\u0445LLLL\u0445LL\u0445LL.y, LL\u0445\u0445LLLL\u0445LL\u0445LL.z, 0.0);
                        }
                        LL\u0445L\u0445LLL\u0445LL\u0445LL.x = Math.min(LL\u0445\u0445LLLL\u0445LL\u0445LL.x, LL\u0445L\u0445LLL\u0445LL\u0445LL.x);
                        LL\u0445L\u0445LLL\u0445LL\u0445LL.y = Math.min(LL\u0445\u0445LLLL\u0445LL\u0445LL.y, LL\u0445L\u0445LLL\u0445LL\u0445LL.y);
                        LL\u0445L\u0445LLL\u0445LL\u0445LL.z = Math.max(LL\u0445\u0445LLLL\u0445LL\u0445LL.x, LL\u0445L\u0445LLL\u0445LL\u0445LL.z);
                        LL\u0445L\u0445LLL\u0445LL\u0445LL.w = Math.max(LL\u0445\u0445LLLL\u0445LL\u0445LL.y, LL\u0445L\u0445LLL\u0445LL\u0445LL.w);
                    }
                    ++LLLL\u0445\u0445LL\u0445LL\u0445LL;
                    return;
                }
                if (LL\u0445L\u0445LLL\u0445LL\u0445LL != null) {
                    ChestESP.mc.entityRenderer.setupOverlayRendering();
                    double \u0445L\u0445\u0445LLLL\u0445LL\u0445LL = LL\u0445L\u0445LLL\u0445LL\u0445LL.x;
                    double L\u0445\u0445\u0445LLLL\u0445LL\u0445LL = LL\u0445L\u0445LLL\u0445LL\u0445LL.y;
                    double \u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL = LL\u0445L\u0445LLL\u0445LL\u0445LL.z;
                    double LLLL\u0445LLL\u0445LL\u0445LL = LL\u0445L\u0445LLL\u0445LL\u0445LL.w;
                    if (LLL\u0445\u0445LLL\u0445LL\u0445LL.equalsIgnoreCase("2D")) {
                        RectHelper.drawRect(\u0445L\u0445\u0445LLLL\u0445LL\u0445LL - 1.0, L\u0445\u0445\u0445LLLL\u0445LL\u0445LL, \u0445L\u0445\u0445LLLL\u0445LL\u0445LL + 0.5, LLLL\u0445LLL\u0445LL\u0445LL + 0.5, L\u0445\u0445L\u0445LLL\u0445LL\u0445LL.black);
                        RectHelper.drawRect(\u0445L\u0445\u0445LLLL\u0445LL\u0445LL - 1.0, L\u0445\u0445\u0445LLLL\u0445LL\u0445LL - 0.5, \u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL + 0.5, L\u0445\u0445\u0445LLLL\u0445LL\u0445LL + 0.5 + 0.5, L\u0445\u0445L\u0445LLL\u0445LL\u0445LL.black);
                        RectHelper.drawRect(\u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL - 0.5 - 0.5, L\u0445\u0445\u0445LLLL\u0445LL\u0445LL, \u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL + 0.5, LLLL\u0445LLL\u0445LL\u0445LL + 0.5, L\u0445\u0445L\u0445LLL\u0445LL\u0445LL.black);
                        RectHelper.drawRect(\u0445L\u0445\u0445LLLL\u0445LL\u0445LL - 1.0, LLLL\u0445LLL\u0445LL\u0445LL - 0.5 - 0.5, \u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL + 0.5, LLLL\u0445LLL\u0445LL\u0445LL + 0.5, L\u0445\u0445L\u0445LLL\u0445LL\u0445LL.black);
                        RectHelper.drawRect(\u0445L\u0445\u0445LLLL\u0445LL\u0445LL - 0.5, L\u0445\u0445\u0445LLLL\u0445LL\u0445LL, \u0445L\u0445\u0445LLLL\u0445LL\u0445LL + 0.5 - 0.5, LLLL\u0445LLL\u0445LL\u0445LL, L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL);
                        RectHelper.drawRect(\u0445L\u0445\u0445LLLL\u0445LL\u0445LL, LLLL\u0445LLL\u0445LL\u0445LL - 0.5, \u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL, LLLL\u0445LLL\u0445LL\u0445LL, L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL);
                        RectHelper.drawRect(\u0445L\u0445\u0445LLLL\u0445LL\u0445LL - 0.5, L\u0445\u0445\u0445LLLL\u0445LL\u0445LL, \u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL, L\u0445\u0445\u0445LLLL\u0445LL\u0445LL + 0.5, L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL);
                        RectHelper.drawRect(\u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL - 0.5, L\u0445\u0445\u0445LLLL\u0445LL\u0445LL, \u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL, LLLL\u0445LLL\u0445LL\u0445LL, L\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LL);
                    }
                }
            }
            return;
        }
        GL11.glEnable(2929);
        ChestESP.mc.entityRenderer.setupOverlayRendering();
    }

    private Vector3d project2D(int \u0445L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LL, double L\u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LL, double \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LL, double LLLLLL\u0445L\u0445LL\u0445LL) {
        IntBuffer \u0445LLLLL\u0445L\u0445LL\u0445LL = GLAllocation.createDirectIntBuffer(16);
        FloatBuffer L\u0445LLLL\u0445L\u0445LL\u0445LL = GLAllocation.createDirectFloatBuffer(16);
        FloatBuffer \u0445\u0445LLLL\u0445L\u0445LL\u0445LL = GLAllocation.createDirectFloatBuffer(16);
        FloatBuffer LL\u0445LLL\u0445L\u0445LL\u0445LL = GLAllocation.createDirectFloatBuffer(4);
        GL11.glGetFloat(2982, L\u0445LLLL\u0445L\u0445LL\u0445LL);
        GL11.glGetFloat(2983, \u0445\u0445LLLL\u0445L\u0445LL\u0445LL);
        GL11.glGetInteger(2978, \u0445LLLLL\u0445L\u0445LL\u0445LL);
        if (GLU.gluProject((float)L\u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LL, (float)\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LL, (float)LLLLLL\u0445L\u0445LL\u0445LL, L\u0445LLLL\u0445L\u0445LL\u0445LL, \u0445\u0445LLLL\u0445L\u0445LL\u0445LL, \u0445LLLLL\u0445L\u0445LL\u0445LL, LL\u0445LLL\u0445L\u0445LL\u0445LL)) {
            return new Vector3d(LL\u0445LLL\u0445L\u0445LL\u0445LL.get(0) / (float)\u0445L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LL, ((float)Display.getHeight() - LL\u0445LLL\u0445L\u0445LL\u0445LL.get(1)) / (float)\u0445L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LL, LL\u0445LLL\u0445L\u0445LL\u0445LL.get(2));
        }
        return null;
    }

    private boolean isValid(TileEntity \u0445\u0445\u0445\u0445LL\u0445L\u0445LL\u0445LL) {
        return \u0445\u0445\u0445\u0445LL\u0445L\u0445LL\u0445LL instanceof TileEntityChest;
    }
}

