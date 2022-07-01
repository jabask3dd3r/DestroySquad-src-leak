/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.lwjgl.opengl.GL11;

public class Trajectories
extends Feature {
    public Trajectories() {
        super("Trajectories", "Draws a line of any objects", Type.Visuals);
        Trajectories L\u0445\u0445LL\u0445\u0445\u0445LLL\u0445LLL;
    }

    @EventTarget
    public void onRender(EventRender3D L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL) {
        Trajectories \u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL;
        ItemStack \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL = Trajectories.mc.player.getHeldItem(EnumHand.MAIN_HAND);
        Trajectories trajectories = \u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL;
        if (\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL != false) {
            return;
        }
        boolean LLLLLLLL\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL.getItem() instanceof ItemBow;
        double \u0445LLLLLLL\u0445LL\u0445LLL = Trajectories.mc.player.rotationYaw;
        double L\u0445LLLLLL\u0445LL\u0445LLL = Trajectories.mc.player.rotationPitch;
        double \u0445\u0445LLLLLL\u0445LL\u0445LLL = Trajectories.mc.getRenderManager().renderPosX - Math.cos(Math.toRadians(\u0445LLLLLLL\u0445LL\u0445LLL)) * (double)0.16f;
        double LL\u0445LLLLL\u0445LL\u0445LLL = Trajectories.mc.getRenderManager().renderPosY + (double)Trajectories.mc.player.getEyeHeight();
        double \u0445L\u0445LLLLL\u0445LL\u0445LLL = Trajectories.mc.getRenderManager().renderPosZ - Math.sin(Math.toRadians(\u0445LLLLLLL\u0445LL\u0445LLL)) * (double)0.16f;
        double L\u0445\u0445LLLLL\u0445LL\u0445LLL = -Math.sin(Math.toRadians(\u0445LLLLLLL\u0445LL\u0445LLL)) * Math.cos(Math.toRadians(L\u0445LLLLLL\u0445LL\u0445LLL)) * (LLLLLLLL\u0445LL\u0445LLL ? 1.0 : 0.4);
        double \u0445\u0445\u0445LLLLL\u0445LL\u0445LLL = -Math.sin(Math.toRadians(L\u0445LLLLLL\u0445LL\u0445LLL - (double)(\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL.isThrowablePotion(\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL) ? 20 : 0))) * (LLLLLLLL\u0445LL\u0445LLL ? 1.0 : 0.4);
        double LLL\u0445LLLL\u0445LL\u0445LLL = Math.cos(Math.toRadians(\u0445LLLLLLL\u0445LL\u0445LLL)) * Math.cos(Math.toRadians(L\u0445LLLLLL\u0445LL\u0445LLL)) * (LLLLLLLL\u0445LL\u0445LLL ? 1.0 : 0.4);
        double \u0445LL\u0445LLLL\u0445LL\u0445LLL = Trajectories.mc.player.getItemInUseDuration();
        if (LLLLLLLL\u0445LL\u0445LLL) {
            \u0445LL\u0445LLLL\u0445LL\u0445LLL /= 20.0;
            if ((\u0445LL\u0445LLLL\u0445LL\u0445LLL = (\u0445LL\u0445LLLL\u0445LL\u0445LLL * \u0445LL\u0445LLLL\u0445LL\u0445LLL + \u0445LL\u0445LLLL\u0445LL\u0445LLL * 2.0) / 3.0) < 0.1) {
                return;
            }
            if (\u0445LL\u0445LLLL\u0445LL\u0445LLL > 1.0) {
                \u0445LL\u0445LLLL\u0445LL\u0445LLL = 1.0;
            }
        }
        double L\u0445L\u0445LLLL\u0445LL\u0445LLL = Math.sqrt(L\u0445\u0445LLLLL\u0445LL\u0445LLL * L\u0445\u0445LLLLL\u0445LL\u0445LLL + \u0445\u0445\u0445LLLLL\u0445LL\u0445LLL * \u0445\u0445\u0445LLLLL\u0445LL\u0445LLL + LLL\u0445LLLL\u0445LL\u0445LLL * LLL\u0445LLLL\u0445LL\u0445LLL);
        L\u0445\u0445LLLLL\u0445LL\u0445LLL /= L\u0445L\u0445LLLL\u0445LL\u0445LLL;
        \u0445\u0445\u0445LLLLL\u0445LL\u0445LLL /= L\u0445L\u0445LLLL\u0445LL\u0445LLL;
        LLL\u0445LLLL\u0445LL\u0445LLL /= L\u0445L\u0445LLLL\u0445LL\u0445LLL;
        L\u0445\u0445LLLLL\u0445LL\u0445LLL *= (LLLLLLLL\u0445LL\u0445LLL ? \u0445LL\u0445LLLL\u0445LL\u0445LLL : 0.5) * 3.0;
        \u0445\u0445\u0445LLLLL\u0445LL\u0445LLL *= (LLLLLLLL\u0445LL\u0445LLL ? \u0445LL\u0445LLLL\u0445LL\u0445LLL : 0.5) * 3.0;
        LLL\u0445LLLL\u0445LL\u0445LLL *= (LLLLLLLL\u0445LL\u0445LLL ? \u0445LL\u0445LLLL\u0445LL\u0445LLL : 0.5) * 3.0;
        boolean \u0445\u0445L\u0445LLLL\u0445LL\u0445LLL = false;
        RayTraceResult LL\u0445\u0445LLLL\u0445LL\u0445LLL = null;
        GlStateManager.resetColor();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GlStateManager.disableTexture2D();
        RenderHelper.setColor(ClientHelper.getClientColor().getRGB());
        GL11.glLineWidth(1.5f);
        GL11.glBegin(3);
        if (!\u0445\u0445L\u0445LLLL\u0445LL\u0445LLL && LL\u0445LLLLL\u0445LL\u0445LLL > 0.0) {
            Vec3d L\u0445L\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL = new Vec3d(\u0445\u0445LLLLLL\u0445LL\u0445LLL, LL\u0445LLLLL\u0445LL\u0445LLL, \u0445L\u0445LLLLL\u0445LL\u0445LLL);
            Vec3d \u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL = new Vec3d(\u0445\u0445LLLLLL\u0445LL\u0445LLL + L\u0445\u0445LLLLL\u0445LL\u0445LLL, LL\u0445LLLLL\u0445LL\u0445LLL + \u0445\u0445\u0445LLLLL\u0445LL\u0445LLL, \u0445L\u0445LLLLL\u0445LL\u0445LLL + LLL\u0445LLLL\u0445LL\u0445LLL);
            RayTraceResult LL\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL = Trajectories.mc.world.rayTraceBlocks(L\u0445L\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL, \u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL, false, true, false);
            if (LL\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL != null && LL\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL.typeOfHit != RayTraceResult.Type.MISS) {
                LL\u0445\u0445LLLL\u0445LL\u0445LLL = LL\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL;
                \u0445\u0445L\u0445LLLL\u0445LL\u0445LLL = true;
            }
            \u0445\u0445LLLLLL\u0445LL\u0445LLL += L\u0445\u0445LLLLL\u0445LL\u0445LLL;
            LL\u0445LLLLL\u0445LL\u0445LLL += \u0445\u0445\u0445LLLLL\u0445LL\u0445LLL;
            \u0445L\u0445LLLLL\u0445LL\u0445LLL += LLL\u0445LLLL\u0445LL\u0445LLL;
            L\u0445\u0445LLLLL\u0445LL\u0445LLL *= 0.99;
            \u0445\u0445\u0445LLLLL\u0445LL\u0445LLL *= 0.99;
            LLL\u0445LLLL\u0445LL\u0445LLL *= 0.99;
            \u0445\u0445\u0445LLLLL\u0445LL\u0445LLL -= LLLLLLLL\u0445LL\u0445LLL ? 0.05 : (\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL.isThrowablePotion(\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LLL) ? 0.05 : 0.03);
            GL11.glVertex3d(\u0445\u0445LLLLLL\u0445LL\u0445LLL - Trajectories.mc.getRenderManager().renderPosX, LL\u0445LLLLL\u0445LL\u0445LLL - Trajectories.mc.getRenderManager().renderPosY, \u0445L\u0445LLLLL\u0445LL\u0445LLL - Trajectories.mc.getRenderManager().renderPosZ);
            return;
        }
        GL11.glEnd();
        GlStateManager.enableTexture2D();
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        GlStateManager.resetColor();
        if (LL\u0445\u0445LLLL\u0445LL\u0445LLL != null && LL\u0445\u0445LLLL\u0445LL\u0445LLL.typeOfHit == RayTraceResult.Type.BLOCK) {
            RenderHelper.blockEsp(LL\u0445\u0445LLLL\u0445LL\u0445LLL.getBlockPos(), ClientHelper.getClientColor(), true);
        }
    }

    private boolean isThrowablePotion(ItemStack \u0445\u0445\u0445LL\u0445LL\u0445LL\u0445LLL) {
        return \u0445\u0445\u0445LL\u0445LL\u0445LL\u0445LLL.getItem() instanceof ItemPotion;
    }
}

