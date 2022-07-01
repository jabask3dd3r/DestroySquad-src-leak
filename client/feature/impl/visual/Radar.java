/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import java.util.Iterator;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender2D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.impl.NumberSetting;

public class Radar
extends Feature {
    private final NumberSetting size;
    private final NumberSetting posx = new NumberSetting("PosX", 812.0f, 0.0f, 900.0f, 1.0f, () -> true);
    private final NumberSetting posy = new NumberSetting("PosY", 99.0f, 0.0f, 350.0f, 1.0f, () -> true);
    public int scale;

    public Radar() {
        super("Radar", "View radar and player", Type.Visuals);
        Radar \u0445\u0445LL\u0445\u0445\u0445LLL\u0445L;
        \u0445\u0445LL\u0445\u0445\u0445LLL\u0445L.size = new NumberSetting("Size", 107.0f, 30.0f, 300.0f, 1.0f, () -> true);
        \u0445\u0445LL\u0445\u0445\u0445LLL\u0445L.addSettings(\u0445\u0445LL\u0445\u0445\u0445LLL\u0445L.posx, \u0445\u0445LL\u0445\u0445\u0445LLL\u0445L.posy, \u0445\u0445LL\u0445\u0445\u0445LLL\u0445L.size);
    }

    @EventTarget
    public void onRender2D(EventRender2D \u0445\u0445L\u0445L\u0445L\u0445LL\u0445L) {
        Radar \u0445LL\u0445L\u0445L\u0445LL\u0445L;
        double \u0445L\u0445\u0445L\u0445L\u0445LL\u0445L = \u0445LL\u0445L\u0445L\u0445LL\u0445L.posx.getNumberValue();
        double \u0445\u0445\u0445\u0445L\u0445L\u0445LL\u0445L = \u0445LL\u0445L\u0445L\u0445LL\u0445L.posy.getNumberValue();
        ScaledResolution LLLL\u0445\u0445L\u0445LL\u0445L = new ScaledResolution(mc);
        \u0445LL\u0445L\u0445L\u0445LL\u0445L.scale = 2;
        int L\u0445LL\u0445\u0445L\u0445LL\u0445L = (int)\u0445LL\u0445L\u0445L\u0445LL\u0445L.size.getNumberValue();
        float LL\u0445L\u0445\u0445L\u0445LL\u0445L = (float)((double)(LLLL\u0445\u0445L\u0445LL\u0445L.getScaledWidth() - L\u0445LL\u0445\u0445L\u0445LL\u0445L) - \u0445L\u0445\u0445L\u0445L\u0445LL\u0445L);
        float L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L = (float)\u0445\u0445\u0445\u0445L\u0445L\u0445LL\u0445L;
        double \u0445\u0445\u0445L\u0445\u0445L\u0445LL\u0445L = Radar.mc.player.posX;
        double LLL\u0445\u0445\u0445L\u0445LL\u0445L = Radar.mc.player.posZ;
        RectHelper.drawBorderedRect(LL\u0445L\u0445\u0445L\u0445LL\u0445L + 2.5f, L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L + 2.5f, LL\u0445L\u0445\u0445L\u0445LL\u0445L + (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L - 2.5f, L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L + (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L - 2.5f, 0.5f, PaletteHelper.getColor(2), PaletteHelper.getColor(11), false);
        RectHelper.drawBorderedRect(LL\u0445L\u0445\u0445L\u0445LL\u0445L + 3.0f, L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L + 3.0f, LL\u0445L\u0445\u0445L\u0445LL\u0445L + (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L - 3.0f, L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L + (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L - 3.0f, 0.2f, PaletteHelper.getColor(2), PaletteHelper.getColor(11), false);
        RectHelper.drawRect((double)LL\u0445L\u0445\u0445L\u0445LL\u0445L + ((double)((float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f) - 0.5), (double)L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L + 3.5, (double)LL\u0445L\u0445\u0445L\u0445LL\u0445L + ((double)((float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f) + 0.2), (double)(L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L + (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L) - 3.5, PaletteHelper.getColor(155, 100));
        RectHelper.drawRect((double)LL\u0445L\u0445\u0445L\u0445LL\u0445L + 3.5, (double)L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L + ((double)((float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f) - 0.2), (double)(LL\u0445L\u0445\u0445L\u0445LL\u0445L + (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L) - 3.5, (double)L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L + ((double)((float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f) + 0.5), PaletteHelper.getColor(155, 100));
        RenderHelper.drawImage(new ResourceLocation("neverhook/skeet.png"), LL\u0445L\u0445\u0445L\u0445LL\u0445L + 3.5f, L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L + 3.5f, L\u0445LL\u0445\u0445L\u0445LL\u0445L - 7, 1.0f, Color.WHITE);
        Iterator L\u0445LLLL\u0445\u0445LL\u0445L = Radar.mc.world.playerEntities.iterator();
        if (L\u0445LLLL\u0445\u0445LL\u0445L.hasNext()) {
            EntityPlayer LLL\u0445L\u0445L\u0445LL\u0445L = (EntityPlayer)L\u0445LLLL\u0445\u0445LL\u0445L.next();
            if (LLL\u0445L\u0445L\u0445LL\u0445L == Radar.mc.player) {
                return;
            }
            float \u0445\u0445L\u0445\u0445LL\u0445LL\u0445L = Radar.mc.timer.renderPartialTicks;
            float LL\u0445\u0445\u0445LL\u0445LL\u0445L = (float)(LLL\u0445L\u0445L\u0445LL\u0445L.posX + (LLL\u0445L\u0445L\u0445LL\u0445L.posX - LLL\u0445L\u0445L\u0445LL\u0445L.lastTickPosX) * (double)\u0445\u0445L\u0445\u0445LL\u0445LL\u0445L - \u0445\u0445\u0445L\u0445\u0445L\u0445LL\u0445L) * 2.0f;
            float \u0445L\u0445\u0445\u0445LL\u0445LL\u0445L = (float)(LLL\u0445L\u0445L\u0445LL\u0445L.posZ + (LLL\u0445L\u0445L\u0445LL\u0445L.posZ - LLL\u0445L\u0445L\u0445LL\u0445L.lastTickPosZ) * (double)\u0445\u0445L\u0445\u0445LL\u0445LL\u0445L - LLL\u0445\u0445\u0445L\u0445LL\u0445L) * 2.0f;
            int L\u0445\u0445\u0445\u0445LL\u0445LL\u0445L = Radar.mc.player.canEntityBeSeen(LLL\u0445L\u0445L\u0445LL\u0445L) ? new Color(255, 0, 0).getRGB() : new Color(255, 255, 0).getRGB();
            float \u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445L = (float)Math.cos((double)Radar.mc.player.rotationYaw * 0.017453292);
            float LLLLL\u0445L\u0445LL\u0445L = (float)Math.sin((double)Radar.mc.player.rotationYaw * 0.017453292);
            float \u0445LLLL\u0445L\u0445LL\u0445L = -(\u0445L\u0445\u0445\u0445LL\u0445LL\u0445L * \u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445L - LL\u0445\u0445\u0445LL\u0445LL\u0445L * LLLLL\u0445L\u0445LL\u0445L);
            float L\u0445LLL\u0445L\u0445LL\u0445L = -(LL\u0445\u0445\u0445LL\u0445LL\u0445L * \u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445L + \u0445L\u0445\u0445\u0445LL\u0445LL\u0445L * LLLLL\u0445L\u0445LL\u0445L);
            if (\u0445LLLL\u0445L\u0445LL\u0445L > (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f - 6.0f) {
                \u0445LLLL\u0445L\u0445LL\u0445L = (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f - 6.0f;
            } else if (\u0445LLLL\u0445L\u0445LL\u0445L < -((float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f - 8.0f)) {
                \u0445LLLL\u0445L\u0445LL\u0445L = -((float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f - 8.0f);
            }
            if (L\u0445LLL\u0445L\u0445LL\u0445L > (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f - 5.0f) {
                L\u0445LLL\u0445L\u0445LL\u0445L = (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f - 5.0f;
            } else if (L\u0445LLL\u0445L\u0445LL\u0445L < -((float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f - 5.0f)) {
                L\u0445LLL\u0445L\u0445LL\u0445L = -((float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f - 5.0f);
            }
            RectHelper.drawRect(LL\u0445L\u0445\u0445L\u0445LL\u0445L + (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f + L\u0445LLL\u0445L\u0445LL\u0445L - 1.5f, L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L + (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f + \u0445LLLL\u0445L\u0445LL\u0445L - 1.5f, LL\u0445L\u0445\u0445L\u0445LL\u0445L + (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f + L\u0445LLL\u0445L\u0445LL\u0445L + 1.5f, L\u0445\u0445L\u0445\u0445L\u0445LL\u0445L + (float)L\u0445LL\u0445\u0445L\u0445LL\u0445L / 2.0f + \u0445LLLL\u0445L\u0445LL\u0445L + 1.5f, L\u0445\u0445\u0445\u0445LL\u0445LL\u0445L);
            return;
        }
    }
}

