/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.draggable.impl;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import org.Destroy.client.feature.impl.hud.HUD;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.ui.components.draggable.DraggableModule;

public class InfoComponent
extends DraggableModule {
    public InfoComponent() {
        super("InfoComponent", 100, 200);
        InfoComponent \u0445LLLL\u0445\u0445L\u0445\u0445\u0445LL\u0445L;
    }

    @Override
    public int getWidth() {
        return 75;
    }

    @Override
    public int getHeight() {
        return 27;
    }

    @Override
    public void render(int \u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L, int LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L) {
        InfoComponent L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L;
        if (HUD.worldInfo.getBoolValue()) {
            String \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445L = String.format("%.2f " + (Object)((Object)ChatFormatting.WHITE) + "BPS", Float.valueOf(MovementHelper.getSpeed() * 16.0f * InfoComponent.mc.timer.timerSpeed));
            String L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445L = "" + Minecraft.getDebugFPS();
            String \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445L = "" + Math.round(InfoComponent.mc.player.posX);
            String LLLL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L = "" + Math.round(InfoComponent.mc.player.posY);
            String \u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L = "" + Math.round(InfoComponent.mc.player.posZ);
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow("X: ", L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getX(), L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getY(), ClientHelper.getClientColor().getRGB());
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow(\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445L, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getX() + 10, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getY(), -1);
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow("Y: ", L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getX() + 30 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445L) - 17, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getY(), ClientHelper.getClientColor().getRGB());
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow(LLLL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getX() + 40 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445L) - 17, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getY(), -1);
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow("Z: ", L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getX() + 66 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445L) - 23 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(LLLL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L) - 17, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getY(), ClientHelper.getClientColor().getRGB());
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow(\u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getX() + 76 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445L) - 23 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(LLLL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L) - 17, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getY(), -1);
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow("FPS: ", L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getX(), L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getY() + 11, ClientHelper.getClientColor().getRGB());
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow(L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445L, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getX() + 22, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getY() + 11, -1);
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow(\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445L, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getX() + InfoComponent.mc.robotoRegularFontRender.getStringWidth(L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LL\u0445L) + 25, L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L.getY() + 11, ClientHelper.getClientColor().getRGB());
        }
        super.render(\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L, LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445L);
    }

    @Override
    public void draw() {
        InfoComponent L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L;
        if (HUD.worldInfo.getBoolValue()) {
            String \u0445LL\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L = String.format("%.2f " + (Object)((Object)ChatFormatting.WHITE) + "BPS", Float.valueOf(MovementHelper.getSpeed() * 16.0f * InfoComponent.mc.timer.timerSpeed));
            String \u0445\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L = "" + Minecraft.getDebugFPS();
            String \u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L = "" + Math.round(InfoComponent.mc.player.posX);
            String \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L = "" + Math.round(InfoComponent.mc.player.posY);
            String \u0445LLL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L = "" + Math.round(InfoComponent.mc.player.posZ);
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow("X: ", L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getX(), L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getY(), ClientHelper.getClientColor().getRGB());
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow(\u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getX() + 10, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getY(), -1);
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow("Y: ", L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getX() + 30 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(\u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L) - 17, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getY(), ClientHelper.getClientColor().getRGB());
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow(\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getX() + 40 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(\u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L) - 17, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getY(), -1);
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow("Z: ", L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getX() + 66 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(\u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L) - 23 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L) - 17, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getY(), ClientHelper.getClientColor().getRGB());
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow(\u0445LLL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getX() + 76 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(\u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L) - 23 + InfoComponent.mc.robotoRegularFontRender.getStringWidth(\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L) - 17, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getY(), -1);
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow("FPS: ", L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getX(), L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getY() + 11, ClientHelper.getClientColor().getRGB());
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow(\u0445\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getX() + 22, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getY() + 11, -1);
            InfoComponent.mc.robotoRegularFontRender.drawStringWithShadow(\u0445LL\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getX() + InfoComponent.mc.robotoRegularFontRender.getStringWidth(\u0445\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L) + 25, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445LL\u0445L.getY() + 11, ClientHelper.getClientColor().getRGB());
            InfoComponent.mc.fontRenderer.drawCenteredStringWithShadow(\u0445LL\u0445LLL\u0445\u0445\u0445\u0445LL\u0445L, sr.getScaledWidth() + 45, 10.0f, -1);
        }
        super.draw();
    }
}

