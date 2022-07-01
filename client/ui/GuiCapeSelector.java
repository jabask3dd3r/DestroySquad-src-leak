/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.ui.button.ImageButton;

public class GuiCapeSelector
extends GuiScreen {
    protected ArrayList<ImageButton> imageButtons = new ArrayList();
    private int width;
    private int height;
    private float spin;

    public GuiCapeSelector() {
        GuiCapeSelector LL\u0445\u0445\u0445L\u0445LLLL\u0445L;
    }

    @Override
    public void initGui() {
        GuiCapeSelector LLLLL\u0445\u0445LLLL\u0445L;
        ScaledResolution \u0445LLLL\u0445\u0445LLLL\u0445L = new ScaledResolution(LLLLL\u0445\u0445LLLL\u0445L.mc);
        LLLLL\u0445\u0445LLLL\u0445L.width = \u0445LLLL\u0445\u0445LLLL\u0445L.getScaledWidth() / 2;
        LLLLL\u0445\u0445LLLL\u0445L.height = \u0445LLLL\u0445\u0445LLLL\u0445L.getScaledHeight() / 2;
        LLLLL\u0445\u0445LLLL\u0445L.imageButtons.clear();
        LLLLL\u0445\u0445LLLL\u0445L.imageButtons.add(new ImageButton(new ResourceLocation("neverhook/close-button.png"), LLLLL\u0445\u0445LLLL\u0445L.width + 106, LLLLL\u0445\u0445LLLL\u0445L.height - 135, 8, 8, "", 19));
        LLLLL\u0445\u0445LLLL\u0445L.imageButtons.add(new ImageButton(new ResourceLocation("neverhook/arrow/arrow-right.png"), LLLLL\u0445\u0445LLLL\u0445L.width + 30, LLLLL\u0445\u0445LLLL\u0445L.height + 52, 32, 25, "", 56));
        LLLLL\u0445\u0445LLLL\u0445L.imageButtons.add(new ImageButton(new ResourceLocation("neverhook/arrow/arrow-left.png"), LLLLL\u0445\u0445LLLL\u0445L.width - 50, LLLLL\u0445\u0445LLLL\u0445L.height + 52, 32, 25, "", 55));
        super.initGui();
    }

    @Override
    public void drawScreen(int LL\u0445\u0445L\u0445\u0445LLLL\u0445L, int \u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L, float L\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L) {
        GuiCapeSelector \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L;
        \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.drawWorldBackground(0);
        GlStateManager.pushMatrix();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        RectHelper.drawSkeetRectWithoutBorder(\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.width - 70, \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.height - 80, \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.width + 80, \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.height + 20);
        RectHelper.drawSkeetButton(\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.width - 70, \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.height - 78, \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.width + 80, \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.height + 80);
        RenderHelper.drawImage(new ResourceLocation("neverhook/skeet.png"), \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.width - 110, \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.height - 140, 230.0f, 1.0f, Color.WHITE);
        \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc.circleregular.drawStringWithOutline("Cape Changer", \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.width - 100, \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.height - 133, -1);
        \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.drawEntityOnScreen(\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.width + 7, \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.height + 38, \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.spin, \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc.player);
        \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.spin = (float)((double)\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.spin + 0.9);
        Iterator<ImageButton> \u0445\u0445LL\u0445\u0445\u0445LLLL\u0445L = \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.imageButtons.iterator();
        if (\u0445\u0445LL\u0445\u0445\u0445LLLL\u0445L.hasNext()) {
            ImageButton L\u0445L\u0445L\u0445\u0445LLLL\u0445L = \u0445\u0445LL\u0445\u0445\u0445LLLL\u0445L.next();
            L\u0445L\u0445L\u0445\u0445LLLL\u0445L.draw(LL\u0445\u0445L\u0445\u0445LLLL\u0445L, \u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L, Color.LIGHT_GRAY);
            return;
        }
        GlStateManager.popMatrix();
        super.drawScreen(LL\u0445\u0445L\u0445\u0445LLLL\u0445L, \u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L, L\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L);
    }

    @Override
    protected void mouseClicked(int \u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L, int L\u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445L, int \u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445L) throws IOException {
        GuiCapeSelector LL\u0445\u0445\u0445\u0445\u0445LLLL\u0445L;
        Iterator<ImageButton> LL\u0445LLLL\u0445LLL\u0445L;
        if (\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445L == 0 && (LL\u0445LLLL\u0445LLL\u0445L = LL\u0445\u0445\u0445\u0445\u0445LLLL\u0445L.imageButtons.iterator()).hasNext()) {
            ImageButton \u0445\u0445L\u0445\u0445\u0445\u0445LLLL\u0445L = LL\u0445LLLL\u0445LLL\u0445L.next();
            \u0445\u0445L\u0445\u0445\u0445\u0445LLLL\u0445L.onClick(\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L, L\u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445L);
            return;
        }
        super.mouseClicked(\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L, L\u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445L, \u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445L);
    }

    private void drawEntityOnScreen(float \u0445LLL\u0445LL\u0445LLL\u0445L, float L\u0445LL\u0445LL\u0445LLL\u0445L, float \u0445\u0445LL\u0445LL\u0445LLL\u0445L, EntityLivingBase LL\u0445L\u0445LL\u0445LLL\u0445L) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate(\u0445LLL\u0445LL\u0445LLL\u0445L, L\u0445LL\u0445LL\u0445LLL\u0445L, 50.0f);
        GlStateManager.scale(-80.0f, 80.0f, 80.0f);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        float \u0445L\u0445L\u0445LL\u0445LLL\u0445L = LL\u0445L\u0445LL\u0445LLL\u0445L.renderYawOffset;
        float L\u0445\u0445L\u0445LL\u0445LLL\u0445L = LL\u0445L\u0445LL\u0445LLL\u0445L.rotationYaw;
        float \u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L = LL\u0445L\u0445LL\u0445LLL\u0445L.rotationPitchHead;
        float LLL\u0445\u0445LL\u0445LLL\u0445L = LL\u0445L\u0445LL\u0445LLL\u0445L.prevRotationYawHead;
        float \u0445LL\u0445\u0445LL\u0445LLL\u0445L = LL\u0445L\u0445LL\u0445LLL\u0445L.rotationYawHead;
        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
        net.minecraft.client.renderer.RenderHelper.enableStandardItemLighting();
        LL\u0445L\u0445LL\u0445LLL\u0445L.renderYawOffset = \u0445\u0445LL\u0445LL\u0445LLL\u0445L;
        LL\u0445L\u0445LL\u0445LLL\u0445L.rotationYaw = \u0445\u0445LL\u0445LL\u0445LLL\u0445L;
        LL\u0445L\u0445LL\u0445LLL\u0445L.rotationPitchHead = 0.0f;
        LL\u0445L\u0445LL\u0445LLL\u0445L.rotationYawHead = LL\u0445L\u0445LL\u0445LLL\u0445L.rotationYaw;
        LL\u0445L\u0445LL\u0445LLL\u0445L.prevRotationYawHead = LL\u0445L\u0445LL\u0445LLL\u0445L.rotationYaw;
        LL\u0445L\u0445LL\u0445LLL\u0445L.prevRotationPitchHead = 0.0f;
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        RenderManager L\u0445L\u0445\u0445LL\u0445LLL\u0445L = Minecraft.getInstance().getRenderManager();
        L\u0445L\u0445\u0445LL\u0445LLL\u0445L.setPlayerViewY(180.0f);
        L\u0445L\u0445\u0445LL\u0445LLL\u0445L.setRenderShadow(false);
        L\u0445L\u0445\u0445LL\u0445LLL\u0445L.doRenderEntity(LL\u0445L\u0445LL\u0445LLL\u0445L, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        L\u0445L\u0445\u0445LL\u0445LLL\u0445L.setRenderShadow(true);
        LL\u0445L\u0445LL\u0445LLL\u0445L.renderYawOffset = \u0445L\u0445L\u0445LL\u0445LLL\u0445L;
        LL\u0445L\u0445LL\u0445LLL\u0445L.rotationYaw = L\u0445\u0445L\u0445LL\u0445LLL\u0445L;
        LL\u0445L\u0445LL\u0445LLL\u0445L.rotationPitchHead = \u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L;
        LL\u0445L\u0445LL\u0445LLL\u0445L.prevRotationPitchHead = \u0445\u0445\u0445L\u0445LL\u0445LLL\u0445L;
        LL\u0445L\u0445LL\u0445LLL\u0445L.prevRotationYawHead = LLL\u0445\u0445LL\u0445LLL\u0445L;
        LL\u0445L\u0445LL\u0445LLL\u0445L.rotationYawHead = \u0445LL\u0445\u0445LL\u0445LLL\u0445L;
        GlStateManager.popMatrix();
        net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    public static class Selector {
        public static String capeName;

        public Selector() {
            Selector \u0445\u0445LLLLLL\u0445\u0445L\u0445L\u0445L;
        }

        public static String getCapeName() {
            return capeName;
        }

        public static void setCapeName(String \u0445LLL\u0445LLL\u0445\u0445L\u0445L\u0445L) {
            capeName = \u0445LLL\u0445LLL\u0445\u0445L\u0445L\u0445L;
        }
    }
}

