/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.lwjgl.opengl.GL11;

public class ChinaHat
extends Feature {
    public ListSetting colorMode = new ListSetting("Color", "Client", () -> true, "Rainbow", "Astolfo", "Client", "Custom");
    public ListSetting colorModeTop = new ListSetting("Color Top", "Client", () -> true, "Rainbow", "Astolfo", "Client", "Custom");
    public ColorSetting customColor = new ColorSetting("Custom Color", new Color(13311).getRGB(), () -> {
        ChinaHat L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445L;
        return L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445L.colorModeTop.currentMode.equals("Custom");
    });
    public ColorSetting customColorTwo = new ColorSetting("Custom Color Two", new Color(13311).getRGB(), () -> {
        ChinaHat \u0445\u0445L\u0445\u0445L\u0445LL\u0445\u0445L;
        return \u0445\u0445L\u0445\u0445L\u0445LL\u0445\u0445L.colorMode.currentMode.equals("Custom");
    });
    public NumberSetting heightValue = new NumberSetting("Height", 0.4f, 0.1f, 20.0f, 0.1f, () -> true);
    public NumberSetting widthValue = new NumberSetting("Width", 1.2f, 0.1f, 20.0f, 0.1f, () -> true);
    public NumberSetting point = new NumberSetting("Points", 32.0f, 1.0f, 60.0f, 1.0f, () -> true);
    public BooleanSetting hide = new BooleanSetting("Hide In First Person", true, () -> true);

    public ChinaHat() {
        super("ChinaHat", "View china hat", Type.Visuals);
        ChinaHat L\u0445\u0445\u0445\u0445LLLL\u0445\u0445L;
        L\u0445\u0445\u0445\u0445LLLL\u0445\u0445L.addSettings(L\u0445\u0445\u0445\u0445LLLL\u0445\u0445L.colorMode, L\u0445\u0445\u0445\u0445LLLL\u0445\u0445L.colorModeTop, L\u0445\u0445\u0445\u0445LLLL\u0445\u0445L.hide, L\u0445\u0445\u0445\u0445LLLL\u0445\u0445L.widthValue, L\u0445\u0445\u0445\u0445LLLL\u0445\u0445L.heightValue, L\u0445\u0445\u0445\u0445LLLL\u0445\u0445L.point, L\u0445\u0445\u0445\u0445LLLL\u0445\u0445L.customColor, L\u0445\u0445\u0445\u0445LLLL\u0445\u0445L.customColorTwo);
    }

    @EventTarget
    public void onRender3D(EventRender3D \u0445\u0445\u0445LLL\u0445LL\u0445\u0445L) {
        ChinaHat L\u0445\u0445LLL\u0445LL\u0445\u0445L;
        double LLL\u0445LL\u0445LL\u0445\u0445L = ChinaHat.mc.player.lastTickPosX + (ChinaHat.mc.player.posX - ChinaHat.mc.player.lastTickPosX) * (double)ChinaHat.mc.timer.renderPartialTicks - ChinaHat.mc.getRenderManager().renderPosX;
        double \u0445LL\u0445LL\u0445LL\u0445\u0445L = ChinaHat.mc.player.lastTickPosY + (ChinaHat.mc.player.posY - ChinaHat.mc.player.lastTickPosY) * (double)ChinaHat.mc.timer.renderPartialTicks - ChinaHat.mc.getRenderManager().renderPosY;
        double L\u0445L\u0445LL\u0445LL\u0445\u0445L = ChinaHat.mc.player.lastTickPosZ + (ChinaHat.mc.player.posZ - ChinaHat.mc.player.lastTickPosZ) * (double)ChinaHat.mc.timer.renderPartialTicks - ChinaHat.mc.getRenderManager().renderPosZ;
        \u0445LL\u0445LL\u0445LL\u0445\u0445L += (double)ChinaHat.mc.player.getEyeHeight() + 0.2 - (ChinaHat.mc.player.isSneaking() ? 0.25 : 0.0);
        if (ChinaHat.mc.gameSettings.thirdPersonView == 0 && L\u0445\u0445LLL\u0445LL\u0445\u0445L.hide.getBoolValue()) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glLineWidth(2.0f);
        GL11.glShadeModel(7425);
        GL11.glDisable(2884);
        GL11.glBegin(8);
        double \u0445\u0445L\u0445LL\u0445LL\u0445\u0445L = ChinaHat.mc.player.width * L\u0445\u0445LLL\u0445LL\u0445\u0445L.widthValue.getNumberValue();
        int \u0445L\u0445LLL\u0445LL\u0445\u0445L = 0;
        if ((float)\u0445L\u0445LLL\u0445LL\u0445\u0445L <= L\u0445\u0445LLL\u0445LL\u0445\u0445L.point.getNumberValue()) {
            int \u0445L\u0445\u0445\u0445\u0445LLL\u0445\u0445L = -1;
            int L\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L = -1;
            double \u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L = L\u0445\u0445LLL\u0445LL\u0445\u0445L.heightValue.getNumberValue();
            String LLLLLL\u0445LL\u0445\u0445L = L\u0445\u0445LLL\u0445LL\u0445\u0445L.colorMode.getOptions();
            if (LLLLLL\u0445LL\u0445\u0445L.equalsIgnoreCase("Rainbow")) {
                \u0445L\u0445\u0445\u0445\u0445LLL\u0445\u0445L = PaletteHelper.rainbow(\u0445L\u0445LLL\u0445LL\u0445\u0445L * 10, 0.4f, 1.0f).getRGB();
            } else if (LLLLLL\u0445LL\u0445\u0445L.equalsIgnoreCase("Client")) {
                \u0445L\u0445\u0445\u0445\u0445LLL\u0445\u0445L = ClientHelper.getClientColor().getRGB();
            } else if (LLLLLL\u0445LL\u0445\u0445L.equalsIgnoreCase("Custom")) {
                \u0445L\u0445\u0445\u0445\u0445LLL\u0445\u0445L = L\u0445\u0445LLL\u0445LL\u0445\u0445L.customColorTwo.getColorValue();
            } else if (LLLLLL\u0445LL\u0445\u0445L.equalsIgnoreCase("Astolfo")) {
                Color \u0445\u0445L\u0445\u0445\u0445LLL\u0445\u0445L = PaletteHelper.astolfo(false, \u0445L\u0445LLL\u0445LL\u0445\u0445L);
                \u0445L\u0445\u0445\u0445\u0445LLL\u0445\u0445L = new Color(\u0445\u0445L\u0445\u0445\u0445LLL\u0445\u0445L.getRed(), \u0445\u0445L\u0445\u0445\u0445LLL\u0445\u0445L.getGreen(), \u0445\u0445L\u0445\u0445\u0445LLL\u0445\u0445L.getBlue()).getRGB();
            }
            String \u0445LLLLL\u0445LL\u0445\u0445L = L\u0445\u0445LLL\u0445LL\u0445\u0445L.colorModeTop.getOptions();
            if (\u0445LLLLL\u0445LL\u0445\u0445L.equalsIgnoreCase("Rainbow")) {
                L\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L = PaletteHelper.rainbow(\u0445L\u0445LLL\u0445LL\u0445\u0445L * 10, 0.4f, 1.0f).getRGB();
            } else if (\u0445LLLLL\u0445LL\u0445\u0445L.equalsIgnoreCase("Client")) {
                L\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L = ClientHelper.getClientColor().getRGB();
            } else if (\u0445LLLLL\u0445LL\u0445\u0445L.equalsIgnoreCase("Custom")) {
                L\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L = L\u0445\u0445LLL\u0445LL\u0445\u0445L.customColorTwo.getColorValue();
            } else if (\u0445LLLLL\u0445LL\u0445\u0445L.equalsIgnoreCase("Astolfo")) {
                Color LL\u0445\u0445\u0445\u0445LLL\u0445\u0445L = PaletteHelper.astolfo(false, \u0445L\u0445LLL\u0445LL\u0445\u0445L);
                L\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L = new Color(LL\u0445\u0445\u0445\u0445LLL\u0445\u0445L.getRed(), LL\u0445\u0445\u0445\u0445LLL\u0445\u0445L.getGreen(), LL\u0445\u0445\u0445\u0445LLL\u0445\u0445L.getBlue()).getRGB();
            }
            Color L\u0445LLLL\u0445LL\u0445\u0445L = new Color(L\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L);
            RenderHelper.setColor(new Color(L\u0445LLLL\u0445LL\u0445\u0445L.getRed(), L\u0445LLLL\u0445LL\u0445\u0445L.getGreen(), L\u0445LLLL\u0445LL\u0445\u0445L.getBlue(), 120).getRGB());
            GL11.glVertex3d(LLL\u0445LL\u0445LL\u0445\u0445L, \u0445LL\u0445LL\u0445LL\u0445\u0445L + \u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L, L\u0445L\u0445LL\u0445LL\u0445\u0445L);
            RenderHelper.setColor(\u0445L\u0445\u0445\u0445\u0445LLL\u0445\u0445L);
            double \u0445\u0445LLLL\u0445LL\u0445\u0445L = LLL\u0445LL\u0445LL\u0445\u0445L - Math.sin((double)\u0445L\u0445LLL\u0445LL\u0445\u0445L * Math.PI * 2.0 / (double)L\u0445\u0445LLL\u0445LL\u0445\u0445L.point.getNumberValue()) * \u0445\u0445L\u0445LL\u0445LL\u0445\u0445L;
            double LL\u0445LLL\u0445LL\u0445\u0445L = L\u0445L\u0445LL\u0445LL\u0445\u0445L + Math.cos((double)\u0445L\u0445LLL\u0445LL\u0445\u0445L * Math.PI * 2.0 / (double)L\u0445\u0445LLL\u0445LL\u0445\u0445L.point.getNumberValue()) * \u0445\u0445L\u0445LL\u0445LL\u0445\u0445L;
            GL11.glVertex3d(\u0445\u0445LLLL\u0445LL\u0445\u0445L, \u0445LL\u0445LL\u0445LL\u0445\u0445L, LL\u0445LLL\u0445LL\u0445\u0445L);
            ++\u0445L\u0445LLL\u0445LL\u0445\u0445L;
            return;
        }
        GL11.glEnd();
        GL11.glShadeModel(7424);
        GL11.glDisable(2848);
        GL11.glEnable(2884);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GlStateManager.resetColor();
        GL11.glPopMatrix();
    }
}

