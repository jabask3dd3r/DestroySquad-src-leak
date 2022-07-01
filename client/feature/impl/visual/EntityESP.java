/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
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

public class EntityESP
extends Feature {
    public static ListSetting espMode;
    public static BooleanSetting tags;
    public static NumberSetting glowAlpha;
    private final int black = Color.BLACK.getRGB();
    private final ColorSetting colorEsp;
    private final BooleanSetting filled = new BooleanSetting("Filled", false, () -> EntityESP.espMode.currentMode.equals("2D"));
    private final ColorSetting filledColor = new ColorSetting("Filled Color", -663984795, () -> {
        EntityESP \u0445\u0445LL\u0445\u0445LLLL\u0445L\u0445L;
        return \u0445\u0445LL\u0445\u0445LLLL\u0445L\u0445L.filled.getBoolValue() && EntityESP.espMode.currentMode.equals("2D");
    });
    public BooleanSetting healRect = new BooleanSetting("Health Rect", false, () -> true);
    public BooleanSetting triangleESP;
    public BooleanSetting ignoreInvisible = new BooleanSetting("Ignore Invisible", true, () -> true);
    public ListSetting healcolorMode = new ListSetting("Color Health Mode", "Custom", () -> {
        EntityESP L\u0445L\u0445L\u0445LLLL\u0445L\u0445L;
        return L\u0445L\u0445L\u0445LLLL\u0445L\u0445L.healRect.getBoolValue();
    }, "Astolfo", "Health", "Rainbow", "Client", "Custom");
    private final ColorSetting healColor = new ColorSetting("Health Border Color", -1, () -> {
        EntityESP LL\u0445LL\u0445LLLL\u0445L\u0445L;
        return LL\u0445LL\u0445LLLL\u0445L\u0445L.healcolorMode.currentMode.equals("Custom");
    });
    public ListSetting csgoMode;
    public ListSetting colorMode = new ListSetting("Color Box Mode", "Custom", () -> EntityESP.espMode.currentMode.equals("Box") || EntityESP.espMode.currentMode.equals("2D"), "Astolfo", "Rainbow", "Client", "Custom");
    public ListSetting triangleMode = new ListSetting("Triangle Mode", "Custom", () -> {
        EntityESP \u0445\u0445\u0445\u0445\u0445LLLLL\u0445L\u0445L;
        return \u0445\u0445\u0445\u0445\u0445LLLLL\u0445L\u0445L.triangleESP.getBoolValue();
    }, "Astolfo", "Rainbow", "Client", "Custom");
    public NumberSetting xOffset;
    public NumberSetting yOffset;
    public NumberSetting size;

    public EntityESP() {
        super("PlayerESP", "Shows players, nick and their health through walls", Type.Visuals);
        EntityESP \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L;
        espMode = new ListSetting("ESP Mode", "2D", () -> true, "2D");
        \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L.colorEsp = new ColorSetting("ESP Color", new Color(-849912, true).getRGB(), () -> {
            EntityESP LL\u0445\u0445\u0445LLLLL\u0445L\u0445L;
            return !LL\u0445\u0445\u0445LLLLL\u0445L\u0445L.colorMode.currentMode.equals("Client") && EntityESP.espMode.currentMode.equals("2D");
        });
        \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L.addSettings(espMode, \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L.colorEsp);
    }

    @EventTarget
    public void onRender3D(EventRender3D L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L) {
        EntityESP \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L;
        if (!\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L.getState()) {
            return;
        }
        int \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L = 0;
        switch (\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L.colorMode.currentMode) {
            case "Client": {
                \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L = ClientHelper.getClientColor().getRGB();
                break;
            }
            case "Custom": {
                \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L = \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L.colorEsp.getColorValue();
                break;
            }
            case "Astolfo": {
                \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L = PaletteHelper.astolfo(false, 10).getRGB();
                break;
            }
            case "Rainbow": {
                \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
    }

    @EventTarget
    public void onRender2D(EventRender3D \u0445\u0445\u0445\u0445LLLLLL\u0445L\u0445L) {
        if (EntityESP.espMode.currentMode.equals("2D")) {
            for (Entity \u0445L\u0445\u0445LLLLLL\u0445L\u0445L : EntityESP.mc.world.loadedEntityList) {
                EntityESP L\u0445\u0445\u0445LLLLLL\u0445L\u0445L;
                if (!(\u0445L\u0445\u0445LLLLLL\u0445L\u0445L instanceof EntityPlayer)) continue;
                if (\u0445L\u0445\u0445LLLLLL\u0445L\u0445L == EntityESP.mc.player) {
                    if (EntityESP.mc.gameSettings.thirdPersonView != 1) {
                        return;
                    }
                }
                double L\u0445L\u0445LLLLLL\u0445L\u0445L = \u0445L\u0445\u0445LLLLLL\u0445L\u0445L.lastTickPosX + (\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.posX - \u0445L\u0445\u0445LLLLLL\u0445L\u0445L.lastTickPosX) * (double)mc.getRenderPartialTicks() - EntityESP.mc.getRenderManager().renderPosX;
                double \u0445\u0445L\u0445LLLLLL\u0445L\u0445L = \u0445L\u0445\u0445LLLLLL\u0445L\u0445L.lastTickPosY + (\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.posY - \u0445L\u0445\u0445LLLLLL\u0445L\u0445L.lastTickPosY) * (double)mc.getRenderPartialTicks() - EntityESP.mc.getRenderManager().renderPosY;
                double LL\u0445\u0445LLLLLL\u0445L\u0445L = \u0445L\u0445\u0445LLLLLL\u0445L\u0445L.lastTickPosZ + (\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.posZ - \u0445L\u0445\u0445LLLLLL\u0445L\u0445L.lastTickPosZ) * (double)mc.getRenderPartialTicks() - EntityESP.mc.getRenderManager().renderPosZ;
                GL11.glPushMatrix();
                GL11.glDisable(2929);
                GL11.glDisable(3553);
                GL11.glTranslatef((float)L\u0445L\u0445LLLLLL\u0445L\u0445L, (float)\u0445\u0445L\u0445LLLLLL\u0445L\u0445L, (float)LL\u0445\u0445LLLLLL\u0445L\u0445L);
                GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-EntityESP.mc.getRenderManager().playerViewY, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(EntityESP.mc.getRenderManager().playerViewX, 1.0f, 0.0f, 0.0f);
                GL11.glLineWidth(3.0f);
                GL11.glColor3f(0.0f, 0.0f, 0.0f);
                GL11.glBegin(3);
                GL11.glVertex3d((double)\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.width + 0.1, -0.4, 0.0);
                GL11.glVertex3d((double)\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.width + 0.1, (double)\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.height + 0.4, 0.0);
                GL11.glVertex3d((double)(-\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.width) - 0.1, (double)\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.height + 0.4, 0.0);
                GL11.glVertex3d((double)(-\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.width) - 0.1, -0.4, 0.0);
                GL11.glVertex3d((double)\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.width + 0.1, -0.4, 0.0);
                GL11.glEnd();
                GL11.glLineWidth(0.7f);
                RenderHelper.setColor(L\u0445\u0445\u0445LLLLLL\u0445L\u0445L.colorEsp.getColorValue());
                GL11.glBegin(3);
                GL11.glVertex3d((double)\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.width + 0.1, -0.4, 0.0);
                GL11.glVertex3d((double)\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.width + 0.1, (double)\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.height + 0.4, 0.0);
                GL11.glVertex3d((double)(-\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.width) - 0.1, (double)\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.height + 0.4, 0.0);
                GL11.glVertex3d((double)(-\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.width) - 0.1, -0.4, 0.0);
                GL11.glVertex3d((double)\u0445L\u0445\u0445LLLLLL\u0445L\u0445L.width + 0.1, -0.4, 0.0);
                GL11.glEnd();
                GL11.glEnable(2929);
                GL11.glEnable(3553);
                GL11.glColor3f(255.0f, 255.0f, 255.0f);
                GL11.glPopMatrix();
                return;
            }
        }
    }
}

