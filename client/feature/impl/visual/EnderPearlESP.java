/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import java.util.Iterator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.util.math.Vec3d;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.lwjgl.opengl.GL11;

public class EnderPearlESP
extends Feature {
    public BooleanSetting tracers = new BooleanSetting("Tracers", true, () -> true);

    public EnderPearlESP() {
        super("EnderPearlESP", "Shows esp pearl", Type.Visuals);
        EnderPearlESP \u0445\u0445L\u0445\u0445LL\u0445L\u0445LL;
        \u0445\u0445L\u0445\u0445LL\u0445L\u0445LL.addSettings(\u0445\u0445L\u0445\u0445LL\u0445L\u0445LL.tracers);
    }

    @EventTarget
    public void onRender3D(EventRender3D \u0445L\u0445\u0445L\u0445L\u0445L\u0445LL) {
        GlStateManager.pushMatrix();
        Iterator LLLL\u0445\u0445L\u0445L\u0445LL = EnderPearlESP.mc.world.loadedEntityList.iterator();
        if (LLLL\u0445\u0445L\u0445L\u0445LL.hasNext()) {
            Entity \u0445\u0445L\u0445L\u0445L\u0445L\u0445LL = (Entity)LLLL\u0445\u0445L\u0445L\u0445LL.next();
            if (\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL instanceof EntityEnderPearl) {
                EnderPearlESP LL\u0445\u0445L\u0445L\u0445L\u0445LL;
                boolean L\u0445L\u0445L\u0445L\u0445L\u0445LL = EnderPearlESP.mc.gameSettings.viewBobbing;
                EnderPearlESP.mc.gameSettings.viewBobbing = false;
                EnderPearlESP.mc.entityRenderer.setupCameraTransform(\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.getPartialTicks(), 0);
                EnderPearlESP.mc.gameSettings.viewBobbing = L\u0445L\u0445L\u0445L\u0445L\u0445LL;
                if (LL\u0445\u0445L\u0445L\u0445L\u0445LL.tracers.getBoolValue()) {
                    GL11.glPushMatrix();
                    GL11.glEnable(2848);
                    GL11.glDisable(2929);
                    GL11.glDisable(3553);
                    GL11.glDisable(2896);
                    GL11.glDepthMask(false);
                    GL11.glBlendFunc(770, 771);
                    GL11.glEnable(3042);
                    GL11.glLineWidth(1.0f);
                    double L\u0445\u0445LL\u0445L\u0445L\u0445LL = \u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.lastTickPosX + (\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.posX - \u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.lastTickPosX) * (double)\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.getPartialTicks() - EnderPearlESP.mc.getRenderManager().renderPosX;
                    double \u0445\u0445\u0445LL\u0445L\u0445L\u0445LL = \u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.lastTickPosY + (\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.posY - \u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.lastTickPosY) * (double)\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.getPartialTicks() - EnderPearlESP.mc.getRenderManager().renderPosY - 1.0;
                    double LLL\u0445L\u0445L\u0445L\u0445LL = \u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.lastTickPosZ + (\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.posZ - \u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.lastTickPosZ) * (double)\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.getPartialTicks() - EnderPearlESP.mc.getRenderManager().renderPosZ;
                    RenderHelper.setColor(-1);
                    Vec3d \u0445LL\u0445L\u0445L\u0445L\u0445LL = new Vec3d(0.0, 0.0, 1.0).rotatePitch((float)(-Math.toRadians(EnderPearlESP.mc.player.rotationPitch))).rotateYaw((float)(-Math.toRadians(EnderPearlESP.mc.player.rotationYaw)));
                    GL11.glBegin(2);
                    GL11.glVertex3d(\u0445LL\u0445L\u0445L\u0445L\u0445LL.xCoord, (double)EnderPearlESP.mc.player.getEyeHeight() + \u0445LL\u0445L\u0445L\u0445L\u0445LL.yCoord, \u0445LL\u0445L\u0445L\u0445L\u0445LL.zCoord);
                    GL11.glVertex3d(L\u0445\u0445LL\u0445L\u0445L\u0445LL, \u0445\u0445\u0445LL\u0445L\u0445L\u0445LL + 1.1, LLL\u0445L\u0445L\u0445L\u0445LL);
                    GL11.glEnd();
                    GL11.glDisable(3042);
                    GL11.glDepthMask(true);
                    GL11.glEnable(3553);
                    GL11.glEnable(2929);
                    GL11.glDisable(2848);
                    GL11.glPopMatrix();
                }
                RenderHelper.drawEntityBox(\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL, Color.WHITE, true, 0.2f);
            }
            return;
        }
        GlStateManager.popMatrix();
    }
}

