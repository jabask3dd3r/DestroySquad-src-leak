/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.draggable.impl;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import optifine.CustomColors;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.impl.combat.KillAura;
import org.Destroy.client.feature.impl.misc.NameProtected;
import org.Destroy.client.helpers.math.MathematicHelper;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.render.AnimationHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.ui.components.draggable.DraggableModule;
import org.Destroy.client.ui.font.MCFontRenderer;
import org.lwjgl.opengl.GL11;

public class TargetHUDComponent
extends DraggableModule {
    private final MCFontRenderer font = new MCFontRenderer(new Font("Arial Bold", 0, 18), true, true);
    private final MCFontRenderer font18 = new MCFontRenderer(new Font("Arial Bold", 0, 18), true, true);
    private final MCFontRenderer font24 = new MCFontRenderer(new Font("Arial Bold", 0, 20), true, true);
    private final MCFontRenderer font20 = new MCFontRenderer(new Font("Segou UI", 0, 20), true, true);
    private float healthBarWidth;
    private long changeTime;
    private float displayPercent;
    private long lastUpdate;

    public TargetHUDComponent() {
        super("TargetHUDComponent", 200, 200);
        TargetHUDComponent L\u0445L\u0445\u0445L\u0445LLL\u0445LLL;
    }

    @Override
    public int getWidth() {
        return 155;
    }

    @Override
    public int getHeight() {
        return 87;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public void render(int LLLL\u0445L\u0445\u0445LL\u0445LLL, int \u0445LLL\u0445L\u0445\u0445LL\u0445LLL) {
        block65: {
            block68: {
                block67: {
                    block66: {
                        block64: {
                            L\u0445LL\u0445L\u0445\u0445LL\u0445LLL = KillAura.targetHudMode.getOptions();
                            \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL = TargetHUDComponent.mc.player;
                            LL\u0445L\u0445L\u0445\u0445LL\u0445LLL = KillAura.targetHudColor.getColorValue();
                            if (!L\u0445LL\u0445L\u0445\u0445LL\u0445LLL.equalsIgnoreCase("Astolfo")) break block64;
                            L\u0445LLLLL\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX();
                            \u0445\u0445LLLLL\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY();
                            LL\u0445LLLL\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() / \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getMaxHealth() * 120.0f;
                            LL\u0445LLLL\u0445LL\u0445LLL = MathHelper.clamp(LL\u0445LLLL\u0445LL\u0445LLL, 0.0, 120.0);
                            \u0445L\u0445LLLL\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() < 18.0f && \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() > 1.0f ? 8.0 : 0.0;
                            \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth = AnimationHelper.calculateCompensation((float)LL\u0445LLLL\u0445LL\u0445LLL, \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth, 0L, 0.005);
                            RectHelper.drawRectBetter(L\u0445LLLLL\u0445LL\u0445LLL, \u0445\u0445LLLLL\u0445LL\u0445LLL, 155.0, 60.0, new Color(20, 20, 20, 200).getRGB());
                            if (!\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName().isEmpty()) {
                                TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName(), L\u0445LLLLL\u0445LL\u0445LLL + 31.0f, \u0445\u0445LLLLL\u0445LL\u0445LLL + 5.0f, -1);
                            }
                            GlStateManager.pushMatrix();
                            GlStateManager.translate(L\u0445LLLLL\u0445LL\u0445LLL, \u0445\u0445LLLLL\u0445LL\u0445LLL, 1.0f);
                            GlStateManager.scale(2.5f, 2.5f, 2.5f);
                            GlStateManager.translate(-L\u0445LLLLL\u0445LL\u0445LLL - 3.0f, -\u0445\u0445LLLLL\u0445LL\u0445LLL - 2.0f, 1.0f);
                            TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(MathematicHelper.round(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() / 2.0f, 1) + " \u2764", L\u0445LLLLL\u0445LL\u0445LLL + 16.0f, \u0445\u0445LLLLL\u0445LL\u0445LLL + 10.0f, new Color(LL\u0445L\u0445L\u0445\u0445LL\u0445LLL).getRGB());
                            GlStateManager.popMatrix();
                            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                            TargetHUDComponent.mc.getRenderItem().renderItemOverlays(TargetHUDComponent.mc.fontRendererObj, \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)L\u0445LLLLL\u0445LL\u0445LLL + 137, (int)\u0445\u0445LLLLL\u0445LL\u0445LLL + 7);
                            TargetHUDComponent.mc.getRenderItem().renderItemIntoGUI(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)L\u0445LLLLL\u0445LL\u0445LLL + 137, (int)\u0445\u0445LLLLL\u0445LL\u0445LLL + 1);
                            GuiInventory.drawEntityOnScreen(L\u0445LLLLL\u0445LL\u0445LLL + 16.0f, \u0445\u0445LLLLL\u0445LL\u0445LLL + 55.0f, 25, \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.rotationYaw, -\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.rotationPitch, \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL);
                            RectHelper.drawRectBetter(L\u0445LLLLL\u0445LL\u0445LLL + 30.0f, \u0445\u0445LLLLL\u0445LL\u0445LLL + 48.0f, 120.0, 8.0, new Color(LL\u0445L\u0445L\u0445\u0445LL\u0445LLL).darker().darker().darker().getRGB());
                            RectHelper.drawRectBetter(L\u0445LLLLL\u0445LL\u0445LLL + 30.0f, \u0445\u0445LLLLL\u0445LL\u0445LLL + 48.0f, (float)((double)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth + \u0445L\u0445LLLL\u0445LL\u0445LLL), 8.0, new Color(LL\u0445L\u0445L\u0445\u0445LL\u0445LLL).darker().getRGB());
                            RectHelper.drawRectBetter(L\u0445LLLLL\u0445LL\u0445LLL + 30.0f, \u0445\u0445LLLLL\u0445LL\u0445LLL + 48.0f, (float)LL\u0445LLLL\u0445LL\u0445LLL, 8.0, new Color(LL\u0445L\u0445L\u0445\u0445LL\u0445LLL).getRGB());
                            break block65;
                        }
                        if (!L\u0445LL\u0445L\u0445\u0445LL\u0445LLL.equalsIgnoreCase("Novoline Old")) break block66;
                        if (\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL == null) {
                            return;
                        }
                        if (\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() < 0.0f) {
                            return;
                        }
                        LLL\u0445LLL\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX();
                        \u0445LL\u0445LLL\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY();
                        L\u0445L\u0445LLL\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() / \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getMaxHealth() * (float)(40 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()));
                        L\u0445L\u0445LLL\u0445LL\u0445LLL = MathHelper.clamp(L\u0445L\u0445LLL\u0445LL\u0445LLL, 0.0f, 124.0f);
                        \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth = AnimationHelper.calculateCompensation(L\u0445L\u0445LLL\u0445LL\u0445LLL, \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth, 0L, 0.0);
                        \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth = MathHelper.clamp(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth, 0.0f, 124.0f);
                        RectHelper.drawRectBetter(LLL\u0445LLL\u0445LL\u0445LLL, \u0445LL\u0445LLL\u0445LL\u0445LLL, 65 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()) + 25, 40.0, new Color(19, 19, 19, 255).getRGB());
                        RectHelper.drawRectBetter(LLL\u0445LLL\u0445LL\u0445LLL + 1.0f, \u0445LL\u0445LLL\u0445LL\u0445LLL + 1.0f, 65 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()) + 23, 38.0, new Color(41, 41, 41, 255).getRGB());
                        if (!\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName().isEmpty()) {
                            TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName(), LLL\u0445LLL\u0445LL\u0445LLL + 42.0f, \u0445LL\u0445LLL\u0445LL\u0445LLL + 5.0f, -1);
                        }
                        GlStateManager.pushMatrix();
                        GlStateManager.translate(LLL\u0445LLL\u0445LL\u0445LLL, \u0445LL\u0445LLL\u0445LL\u0445LLL, 1.0f);
                        GlStateManager.scale(1.05f, 1.05f, 1.05f);
                        GlStateManager.translate(-LLL\u0445LLL\u0445LL\u0445LLL + 24.0f, -\u0445LL\u0445LLL\u0445LL\u0445LLL + 18.0f, 1.0f);
                        \u0445\u0445L\u0445LLL\u0445LL\u0445LLL = MathematicHelper.round(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() / 2.0f, 1) + "";
                        TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(\u0445\u0445L\u0445LLL\u0445LL\u0445LLL, LLL\u0445LLL\u0445LL\u0445LLL + 17.0f, \u0445LL\u0445LLL\u0445LL\u0445LLL + 10.0f, -1);
                        TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(" \u2764", LLL\u0445LLL\u0445LL\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringWidth(\u0445\u0445L\u0445LLL\u0445LL\u0445LLL) + 16.0f, \u0445LL\u0445LLL\u0445LL\u0445LLL + 10.0f, new Color(LL\u0445L\u0445L\u0445\u0445LL\u0445LLL).getRGB());
                        GlStateManager.popMatrix();
                        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                        GlStateManager.pushMatrix();
                        GlStateManager.translate(LLL\u0445LLL\u0445LL\u0445LLL, \u0445LL\u0445LLL\u0445LL\u0445LLL, 1.0f);
                        GlStateManager.scale(0.8f, 0.8f, 0.8f);
                        GlStateManager.translate(-LLL\u0445LLL\u0445LL\u0445LLL + 148.0f, -\u0445LL\u0445LLL\u0445LL\u0445LLL + 38.0f, 1.0f);
                        v0 = LL\u0445\u0445LLL\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItemOffhand().isStackable() != false && \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItemOffhand().isEmpty() == false;
                        if (LL\u0445\u0445LLL\u0445LL\u0445LLL) {
                            TargetHUDComponent.mc.getRenderItem().renderItemOverlays(TargetHUDComponent.mc.fontRendererObj, \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)(LLL\u0445LLL\u0445LL\u0445LLL - 39.0f + (float)TargetHUDComponent.mc.fontRenderer.getStringWidth(\u0445\u0445L\u0445LLL\u0445LL\u0445LLL) - 21.0f), (int)(\u0445LL\u0445LLL\u0445LL\u0445LLL - 8.0f));
                            TargetHUDComponent.mc.getRenderItem().renderItemIntoGUI(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)(LLL\u0445LLL\u0445LL\u0445LLL - 49.0f + (float)TargetHUDComponent.mc.fontRenderer.getStringWidth(\u0445\u0445L\u0445LLL\u0445LL\u0445LLL) - 21.0f), (int)\u0445LL\u0445LLL\u0445LL\u0445LLL - 5);
                        }
                        GlStateManager.popMatrix();
                        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                        LLLLL\u0445\u0445\u0445LL\u0445LLL = TargetHUDComponent.mc.player.connection.getPlayerInfoMap().iterator();
                        if (LLLLL\u0445\u0445\u0445LL\u0445LLL.hasNext()) {
                            \u0445\u0445\u0445LLLL\u0445LL\u0445LLL = LLLLL\u0445\u0445\u0445LL\u0445LLL.next();
                            if (TargetHUDComponent.mc.world.getPlayerEntityByUUID(\u0445\u0445\u0445LLLL\u0445LL\u0445LLL.getGameProfile().getId()) == \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL) {
                                TargetHUDComponent.mc.getTextureManager().bindTexture(\u0445\u0445\u0445LLLL\u0445LL\u0445LLL.getLocationSkin());
                                L\u0445\u0445LLLL\u0445LL\u0445LLL = TargetHUDComponent.getHurtPercent(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL);
                                GL11.glPushMatrix();
                                GL11.glColor4f(1.0f, 1.0f - L\u0445\u0445LLLL\u0445LL\u0445LLL, 1.0f - L\u0445\u0445LLLL\u0445LL\u0445LLL, 1.0f);
                                Gui.drawScaledCustomSizeModalRect((int)LLL\u0445LLL\u0445LL\u0445LLL + 1, (int)\u0445LL\u0445LLL\u0445LL\u0445LLL + 1, 8.0f, 8.0f, 8.0f, 8.0f, 38.0f, 38.0f, 64.0f, 64.0f);
                                GL11.glPopMatrix();
                                GlStateManager.bindTexture(0);
                            }
                            GL11.glDisable(3089);
                            return;
                        }
                        RectHelper.drawRectBetter(LLL\u0445LLL\u0445LL\u0445LLL + 42.0f, \u0445LL\u0445LLL\u0445LL\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()) + 9.0f, 40 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()), 8.0, new Color(35, 35, 35, 255).getRGB());
                        RectHelper.drawRectBetter(LLL\u0445LLL\u0445LL\u0445LLL + 42.0f, \u0445LL\u0445LLL\u0445LL\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()) + 9.0f, \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() > 18.0f ? (double)L\u0445L\u0445LLL\u0445LL\u0445LLL : (double)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth + 4.0f), 8.0, new Color(LL\u0445L\u0445L\u0445\u0445LL\u0445LLL).darker().getRGB());
                        RectHelper.drawRectBetter(LLL\u0445LLL\u0445LL\u0445LLL + 42.0f, \u0445LL\u0445LLL\u0445LL\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()) + 9.0f, L\u0445L\u0445LLL\u0445LL\u0445LLL, 8.0, new Color(LL\u0445L\u0445L\u0445\u0445LL\u0445LLL).getRGB());
                        break block65;
                    }
                    if (!L\u0445LL\u0445L\u0445\u0445LL\u0445LLL.equalsIgnoreCase("Novoline New")) break block67;
                    if (\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL == null) {
                        return;
                    }
                    if (\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() < 0.0f) {
                        return;
                    }
                    \u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX();
                    LLLL\u0445LL\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY();
                    \u0445LLL\u0445LL\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() / \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getMaxHealth() * (float)(40 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()));
                    \u0445LLL\u0445LL\u0445LL\u0445LLL = (float)MathHelper.clamp((double)\u0445LLL\u0445LL\u0445LL\u0445LLL, 0.0, 124.0);
                    \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth = AnimationHelper.calculateCompensation(\u0445LLL\u0445LL\u0445LL\u0445LLL, \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth, 0L, 0.0);
                    \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth = MathHelper.clamp(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth, 0.0f, 124.0f);
                    RectHelper.drawRectBetter(\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL, LLLL\u0445LL\u0445LL\u0445LLL, 65 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()) + 25, 40.0, new Color(19, 19, 19, 255).getRGB());
                    RectHelper.drawRectBetter(\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL + 1.0f, LLLL\u0445LL\u0445LL\u0445LLL + 1.0f, 65 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()) + 23, 38.0, new Color(41, 41, 41, 255).getRGB());
                    if (!\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName().isEmpty()) {
                        TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName(), \u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL + 42.0f, LLLL\u0445LL\u0445LL\u0445LLL + 5.0f, -1);
                    }
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL, LLLL\u0445LL\u0445LL\u0445LLL, 1.0f);
                    GlStateManager.scale(1.05f, 1.05f, 1.05f);
                    GlStateManager.translate(-\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL + 24.0f, -LLLL\u0445LL\u0445LL\u0445LLL + 18.0f, 1.0f);
                    GlStateManager.popMatrix();
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL, LLLL\u0445LL\u0445LL\u0445LLL, 1.0f);
                    GlStateManager.scale(0.8f, 0.8f, 0.8f);
                    GlStateManager.translate(-\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL + 148.0f, -LLLL\u0445LL\u0445LL\u0445LLL + 38.0f, 1.0f);
                    v1 = L\u0445LL\u0445LL\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItemOffhand().isStackable() != false && \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItemOffhand().isEmpty() == false;
                    if (L\u0445LL\u0445LL\u0445LL\u0445LLL) {
                        TargetHUDComponent.mc.getRenderItem().renderItemOverlays(TargetHUDComponent.mc.fontRendererObj, \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)(\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL - 88.0f), (int)(LLLL\u0445LL\u0445LL\u0445LLL - 8.0f));
                        TargetHUDComponent.mc.getRenderItem().renderItemIntoGUI(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)(\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL - 98.0f), (int)LLLL\u0445LL\u0445LL\u0445LLL - 5);
                    }
                    GlStateManager.popMatrix();
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    LL\u0445\u0445LLL\u0445LL\u0445LLL = TargetHUDComponent.mc.player.connection.getPlayerInfoMap().iterator();
                    if (LL\u0445\u0445LLL\u0445LL\u0445LLL.hasNext()) {
                        L\u0445\u0445\u0445LLL\u0445LL\u0445LLL = LL\u0445\u0445LLL\u0445LL\u0445LLL.next();
                        if (TargetHUDComponent.mc.world.getPlayerEntityByUUID(L\u0445\u0445\u0445LLL\u0445LL\u0445LLL.getGameProfile().getId()) == \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL) {
                            TargetHUDComponent.mc.getTextureManager().bindTexture(L\u0445\u0445\u0445LLL\u0445LL\u0445LLL.getLocationSkin());
                            \u0445L\u0445\u0445LLL\u0445LL\u0445LLL = TargetHUDComponent.getHurtPercent(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL);
                            GL11.glPushMatrix();
                            GL11.glColor4f(1.0f, 1.0f - \u0445L\u0445\u0445LLL\u0445LL\u0445LLL, 1.0f - \u0445L\u0445\u0445LLL\u0445LL\u0445LLL, 1.0f);
                            Gui.drawScaledCustomSizeModalRect((int)\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL + 1, (int)LLLL\u0445LL\u0445LL\u0445LLL + 1, 8.0f, 8.0f, 8.0f, 8.0f, 38.0f, 38.0f, 64.0f, 64.0f);
                            GL11.glPopMatrix();
                            GlStateManager.bindTexture(0);
                        }
                        GL11.glDisable(3089);
                        return;
                    }
                    \u0445\u0445LL\u0445LL\u0445LL\u0445LLL = MathematicHelper.round(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() / \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getMaxHealth() * 100.0f, 1) + "%";
                    RectHelper.drawRectBetter(\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL + 42.0f, LLLL\u0445LL\u0445LL\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()) + 9.0f, 40 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()), 10.0, new Color(35, 35, 35, 255).getRGB());
                    RectHelper.drawRectBetter(\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL + 42.0f, LLLL\u0445LL\u0445LL\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()) + 9.0f, \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() > 18.0f ? (double)\u0445LLL\u0445LL\u0445LL\u0445LLL : (double)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth + 4.0f), 10.0, new Color(LL\u0445L\u0445L\u0445\u0445LL\u0445LLL).darker().getRGB());
                    RectHelper.drawRectBetter(\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL + 42.0f, LLLL\u0445LL\u0445LL\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()) + 9.0f, \u0445LLL\u0445LL\u0445LL\u0445LLL, 10.0, new Color(LL\u0445L\u0445L\u0445\u0445LL\u0445LLL).getRGB());
                    TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(\u0445\u0445LL\u0445LL\u0445LL\u0445LLL, \u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName()) / 2.0f + 50.0f, LLLL\u0445LL\u0445LL\u0445LLL + 19.0f, -1);
                    break block65;
                }
                if (!L\u0445LL\u0445L\u0445\u0445LL\u0445LLL.equalsIgnoreCase("Dev")) break block68;
                \u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX();
                L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY();
                \u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX();
                LLLLL\u0445L\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY();
                \u0445LLLL\u0445L\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() / \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getMaxHealth() * 120.0f;
                \u0445LLLL\u0445L\u0445LL\u0445LLL = MathHelper.clamp(\u0445LLLL\u0445L\u0445LL\u0445LLL, 0.0, 120.0);
                if (\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL == null) ** GOTO lbl-1000
                v2 = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth();
                v3 = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL instanceof EntityPlayer != false ? 18 : 10;
                if (v2 < (float)v3 && \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() > 1.0f) {
                    v4 = 8.0;
                } else lbl-1000:
                // 2 sources

                {
                    v4 = 0.0;
                }
                L\u0445LLL\u0445L\u0445LL\u0445LLL = v4;
                \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth = AnimationHelper.calculateCompensation((float)\u0445LLLL\u0445L\u0445LL\u0445LLL, \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth, 0L, 0.005);
                RectHelper.drawRectBetter(\u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL, L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL, 145.0, 50.0, new Color(23, 23, 25, 203).getRGB());
                if (!\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName().isEmpty()) {
                    TargetHUDComponent.mc.robotoRegularFontRender.drawStringWithShadow(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName(), \u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL + 37.0f, L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL + 5.0f, -1);
                }
                GlStateManager.pushMatrix();
                GlStateManager.translate(\u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL, L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL, 1.0f);
                GlStateManager.scale(1.5f, 1.5f, 1.5f);
                GlStateManager.translate(-\u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL - 14.0f, -L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL + 14.0f, 1.0f);
                TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow("\u00c2\u00a7c\u2764", \u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL + 16.0f, L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL + 10.0f, -1);
                GlStateManager.popMatrix();
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                TargetHUDComponent.mc.getRenderItem().renderItemOverlays(TargetHUDComponent.mc.fontRendererObj, \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)\u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL + 125, (int)L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL + 7);
                TargetHUDComponent.mc.getRenderItem().renderItemIntoGUI(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)\u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL + 125, (int)L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL + 1);
                \u0445\u0445LLL\u0445L\u0445LL\u0445LLL = new ArrayList<ItemStack>();
                \u0445L\u0445L\u0445LL\u0445LL\u0445LLL = 0;
                if (\u0445L\u0445L\u0445LL\u0445LL\u0445LLL < 5) {
                    LL\u0445L\u0445LL\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getEquipmentInSlot(\u0445L\u0445L\u0445LL\u0445LL\u0445LLL);
                    if (LL\u0445L\u0445LL\u0445LL\u0445LLL != null) {
                        \u0445\u0445LLL\u0445L\u0445LL\u0445LLL.add(LL\u0445L\u0445LL\u0445LL\u0445LLL);
                    }
                    ++\u0445L\u0445L\u0445LL\u0445LL\u0445LLL;
                    return;
                }
                \u0445L\u0445L\u0445LL\u0445LL\u0445LLL /* !! */  = \u0445\u0445LLL\u0445L\u0445LL\u0445LLL.iterator();
                if (\u0445L\u0445L\u0445LL\u0445LL\u0445LLL /* !! */ .hasNext()) {
                    L\u0445\u0445L\u0445LL\u0445LL\u0445LLL = (ItemStack)\u0445L\u0445L\u0445LL\u0445LL\u0445LLL /* !! */ .next();
                    net.minecraft.client.renderer.RenderHelper.enableGUIStandardItemLighting();
                    RenderHelper.renderItem(L\u0445\u0445L\u0445LL\u0445LL\u0445LLL, (int)\u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL + 36, (int)(L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL + 16.0f));
                    \u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL += 16.0f;
                    return;
                }
                \u0445L\u0445L\u0445LL\u0445LL\u0445LLL /* !! */  = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getActivePotionEffects().iterator();
                if (\u0445L\u0445L\u0445LL\u0445LL\u0445LLL /* !! */ .hasNext()) {
                    L\u0445L\u0445\u0445LL\u0445LL\u0445LLL = (PotionEffect)\u0445L\u0445L\u0445LL\u0445LL\u0445LLL /* !! */ .next();
                    \u0445\u0445\u0445L\u0445LL\u0445LL\u0445LLL = Potion.getPotionById(CustomColors.getPotionId(L\u0445L\u0445\u0445LL\u0445LL\u0445LLL.getEffectName()));
                    if (!TargetHUDComponent.$assertionsDisabled && \u0445\u0445\u0445L\u0445LL\u0445LL\u0445LLL == null) {
                        throw new AssertionError();
                    }
                    LLL\u0445\u0445LL\u0445LL\u0445LLL = I18n.format(\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LLL.getName(), new Object[0]);
                    \u0445LL\u0445\u0445LL\u0445LL\u0445LLL = "";
                    if (L\u0445L\u0445\u0445LL\u0445LL\u0445LLL.getAmplifier() == 1) {
                        LLL\u0445\u0445LL\u0445LL\u0445LLL = LLL\u0445\u0445LL\u0445LL\u0445LLL + " 2";
                    } else if (L\u0445L\u0445\u0445LL\u0445LL\u0445LLL.getAmplifier() == 2) {
                        LLL\u0445\u0445LL\u0445LL\u0445LLL = LLL\u0445\u0445LL\u0445LL\u0445LLL + " 3";
                    } else if (L\u0445L\u0445\u0445LL\u0445LL\u0445LLL.getAmplifier() == 3) {
                        LLL\u0445\u0445LL\u0445LL\u0445LLL = LLL\u0445\u0445LL\u0445LL\u0445LLL + " 4";
                    }
                    if (L\u0445L\u0445\u0445LL\u0445LL\u0445LLL.getDuration() < 600 && L\u0445L\u0445\u0445LL\u0445LL\u0445LLL.getDuration() > 300) {
                        \u0445LL\u0445\u0445LL\u0445LL\u0445LLL = \u0445LL\u0445\u0445LL\u0445LL\u0445LLL + " " + Potion.getDurationString(L\u0445L\u0445\u0445LL\u0445LL\u0445LLL);
                    } else if (L\u0445L\u0445\u0445LL\u0445LL\u0445LLL.getDuration() < 300) {
                        \u0445LL\u0445\u0445LL\u0445LL\u0445LLL = \u0445LL\u0445\u0445LL\u0445LL\u0445LLL + " " + Potion.getDurationString(L\u0445L\u0445\u0445LL\u0445LL\u0445LLL);
                    } else if (L\u0445L\u0445\u0445LL\u0445LL\u0445LLL.getDuration() > 600) {
                        \u0445LL\u0445\u0445LL\u0445LL\u0445LLL = \u0445LL\u0445\u0445LL\u0445LL\u0445LLL + " " + Potion.getDurationString(L\u0445L\u0445\u0445LL\u0445LL\u0445LLL);
                    }
                    GlStateManager.pushMatrix();
                    GlStateManager.disableBlend();
                    TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(LLL\u0445\u0445LL\u0445LL\u0445LLL + ": " + (Object)ChatFormatting.GRAY + \u0445LL\u0445\u0445LL\u0445LL\u0445LLL, \u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL + 1.0f, LLLLL\u0445L\u0445LL\u0445LLL - 9.0f, \u0445\u0445\u0445L\u0445LL\u0445LL\u0445LLL.getLiquidColor());
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    GlStateManager.popMatrix();
                    LLLLL\u0445L\u0445LL\u0445LLL -= 10.0f;
                    return;
                }
                \u0445L\u0445L\u0445LL\u0445LL\u0445LLL /* !! */  = TargetHUDComponent.mc.player.connection.getPlayerInfoMap().iterator();
                if (\u0445L\u0445L\u0445LL\u0445LL\u0445LLL /* !! */ .hasNext()) {
                    LL\u0445\u0445\u0445LL\u0445LL\u0445LLL = (NetworkPlayerInfo)\u0445L\u0445L\u0445LL\u0445LL\u0445LLL /* !! */ .next();
                    if (TargetHUDComponent.mc.world.getPlayerEntityByUUID(LL\u0445\u0445\u0445LL\u0445LL\u0445LLL.getGameProfile().getId()) == \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL) {
                        TargetHUDComponent.mc.getTextureManager().bindTexture(LL\u0445\u0445\u0445LL\u0445LL\u0445LLL.getLocationSkin());
                        \u0445\u0445L\u0445\u0445LL\u0445LL\u0445LLL = TargetHUDComponent.getHurtPercent(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL);
                        GL11.glPushMatrix();
                        GL11.glColor4f(1.0f, 1.0f - \u0445\u0445L\u0445\u0445LL\u0445LL\u0445LLL, 1.0f - \u0445\u0445L\u0445\u0445LL\u0445LL\u0445LLL, 1.0f);
                        Gui.drawScaledCustomSizeModalRect((int)\u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL + 1, (int)L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL + 1, 8.0f, 8.0f, 8.0f, 8.0f, 34.0f, 34.0f, 64.0f, 64.0f);
                        GL11.glPopMatrix();
                        GlStateManager.bindTexture(0);
                    }
                    GL11.glDisable(3089);
                    return;
                }
                RectHelper.drawRectBetter(\u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL + 18.0f, L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL + 41.0f, 120.0, 3.0, new Color(20, 221, 32).darker().darker().darker().getRGB());
                RectHelper.drawRectBetter(\u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL + 18.0f, L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL + 41.0f, (double)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth + L\u0445LLL\u0445L\u0445LL\u0445LLL, 3.0, new Color(new Color(255, 55, 55).darker().getRGB()).getRGB());
                RectHelper.drawRectBetter(\u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLL + 18.0f, L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL + 41.0f, \u0445LLLL\u0445L\u0445LL\u0445LLL, 3.0, new Color(new Color(20, 221, 32).getRGB()).getRGB());
                break block65;
            }
            if (L\u0445LL\u0445L\u0445\u0445LL\u0445LLL.equalsIgnoreCase("Minecraft")) {
                if (\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL == null) {
                    return;
                }
                \u0445\u0445\u0445LL\u0445L\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX();
                LLL\u0445L\u0445L\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY();
                GlStateManager.pushMatrix();
                RectHelper.drawOutlineRect(\u0445\u0445\u0445LL\u0445L\u0445LL\u0445LLL - 2.0f, LLL\u0445L\u0445L\u0445LL\u0445LLL - 7.0f, 155.0f, 38.0f, new Color(20, 20, 20, 255), new Color(255, 255, 255, 255));
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName(), \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 37, \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() - 2, -1);
                \u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL = TargetHUDComponent.mc.player.connection.getPlayerInfoMap().iterator();
                if (\u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL.hasNext()) {
                    LL\u0445LL\u0445L\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLL.next();
                    if (TargetHUDComponent.mc.world.getPlayerEntityByUUID(LL\u0445LL\u0445L\u0445LL\u0445LLL.getGameProfile().getId()) == \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL) {
                        TargetHUDComponent.mc.getTextureManager().bindTexture(LL\u0445LL\u0445L\u0445LL\u0445LLL.getLocationSkin());
                        Gui.drawScaledCustomSizeModalRect((int)\u0445\u0445\u0445LL\u0445L\u0445LL\u0445LLL, (int)LLL\u0445L\u0445L\u0445LL\u0445LLL - 5, 8.0f, 8.0f, 8.0f, 8.0f, 34.0f, 34.0f, 64.0f, 64.0f);
                        GlStateManager.bindTexture(0);
                    }
                    GL11.glDisable(3089);
                    return;
                }
                TargetHUDComponent.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
                \u0445LL\u0445L\u0445L\u0445LL\u0445LLL = 0;
                if ((float)\u0445LL\u0445L\u0445L\u0445LL\u0445LLL < \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getMaxHealth() / 2.0f) {
                    TargetHUDComponent.mc.ingameGUI.drawTexturedModalRect((float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 86) - \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getMaxHealth() / 2.0f * 10.0f / 2.0f + (float)(\u0445LL\u0445L\u0445L\u0445LL\u0445LLL * 8), (float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 9), 16, 0, 9, 9);
                    ++\u0445LL\u0445L\u0445L\u0445LL\u0445LLL;
                    return;
                }
                \u0445LL\u0445L\u0445L\u0445LL\u0445LLL = 0;
                if ((float)\u0445LL\u0445L\u0445L\u0445LL\u0445LLL < \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() / 2.0f) {
                    TargetHUDComponent.mc.ingameGUI.drawTexturedModalRect((float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 86) - \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getMaxHealth() / 2.0f * 10.0f / 2.0f + (float)(\u0445LL\u0445L\u0445L\u0445LL\u0445LLL * 8), (float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 9), 52, 0, 9, 9);
                    ++\u0445LL\u0445L\u0445L\u0445LL\u0445LLL;
                    return;
                }
                L\u0445L\u0445L\u0445L\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getTotalArmorValue();
                L\u0445\u0445LL\u0445L\u0445LL\u0445LLL = 0;
                if (L\u0445\u0445LL\u0445L\u0445LL\u0445LLL < 10) {
                    if (L\u0445L\u0445L\u0445L\u0445LL\u0445LLL > 0) {
                        \u0445L\u0445LL\u0445L\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 36 + L\u0445\u0445LL\u0445L\u0445LL\u0445LLL * 8;
                        if (L\u0445\u0445LL\u0445L\u0445LL\u0445LLL * 2 + 1 < L\u0445L\u0445L\u0445L\u0445LL\u0445LLL) {
                            TargetHUDComponent.mc.ingameGUI.drawTexturedModalRect(\u0445L\u0445LL\u0445L\u0445LL\u0445LLL, \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 20, 34, 9, 9, 9);
                        }
                        if (L\u0445\u0445LL\u0445L\u0445LL\u0445LLL * 2 + 1 == L\u0445L\u0445L\u0445L\u0445LL\u0445LLL) {
                            TargetHUDComponent.mc.ingameGUI.drawTexturedModalRect(\u0445L\u0445LL\u0445L\u0445LL\u0445LLL, \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 20, 25, 9, 9, 9);
                        }
                        if (L\u0445\u0445LL\u0445L\u0445LL\u0445LLL * 2 + 1 > L\u0445L\u0445L\u0445L\u0445LL\u0445LLL) {
                            TargetHUDComponent.mc.ingameGUI.drawTexturedModalRect(\u0445L\u0445LL\u0445L\u0445LL\u0445LLL, \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 20, 16, 9, 9, 9);
                        }
                    }
                    ++L\u0445\u0445LL\u0445L\u0445LL\u0445LLL;
                    return;
                }
                GlStateManager.popMatrix();
            } else if (L\u0445LL\u0445L\u0445\u0445LL\u0445LLL.equalsIgnoreCase("Flux")) {
                \u0445L\u0445\u0445L\u0445L\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX();
                L\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY();
                \u0445\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getTotalArmorValue() * 6;
                LLLL\u0445\u0445L\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() / \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getMaxHealth() * 120.0f;
                LLLL\u0445\u0445L\u0445LL\u0445LLL = MathHelper.clamp(LLLL\u0445\u0445L\u0445LL\u0445LLL, 0.0, 120.0);
                RectHelper.drawRectBetter(\u0445L\u0445\u0445L\u0445L\u0445LL\u0445LLL, L\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL, 125.0, 55.0, new Color(39, 39, 37, 235).getRGB());
                \u0445LLL\u0445\u0445L\u0445LL\u0445LLL = "";
                if (TargetHUDComponent.mc.player.getHealth() == \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth()) {
                    \u0445LLL\u0445\u0445L\u0445LL\u0445LLL = "Finish Him!";
                } else if (TargetHUDComponent.mc.player.getHealth() < \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth()) {
                    \u0445LLL\u0445\u0445L\u0445LL\u0445LLL = "Losing Fight";
                } else if (TargetHUDComponent.mc.player.getHealth() > \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth()) {
                    \u0445LLL\u0445\u0445L\u0445LL\u0445LLL = "Winning Fight";
                }
                if (!\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName().isEmpty()) {
                    TargetHUDComponent.mc.robotoRegularFontRender.drawStringWithShadow(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() != false && NameProtected.otherNames.getBoolValue() != false ? "Protected" : \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName(), \u0445L\u0445\u0445L\u0445L\u0445LL\u0445LLL + 38.0f, L\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL + 6.0f, -1);
                    TargetHUDComponent.mc.clickguismall.drawStringWithShadow(\u0445LLL\u0445\u0445L\u0445LL\u0445LLL, \u0445L\u0445\u0445L\u0445L\u0445LL\u0445LLL + 38.0f, L\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL + 17.0f, -1);
                }
                if ((L\u0445\u0445LLLL\u0445LL\u0445LLL = TargetHUDComponent.mc.player.connection.getPlayerInfoMap().iterator()).hasNext()) {
                    LL\u0445\u0445L\u0445L\u0445LL\u0445LLL = L\u0445\u0445LLLL\u0445LL\u0445LLL.next();
                    if (TargetHUDComponent.mc.world.getPlayerEntityByUUID(LL\u0445\u0445L\u0445L\u0445LL\u0445LLL.getGameProfile().getId()) == \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL) {
                        TargetHUDComponent.mc.getTextureManager().bindTexture(LL\u0445\u0445L\u0445L\u0445LL\u0445LLL.getLocationSkin());
                        \u0445\u0445L\u0445L\u0445L\u0445LL\u0445LLL = TargetHUDComponent.getHurtPercent(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL);
                        GL11.glPushMatrix();
                        GL11.glColor4f(1.0f, 1.0f - \u0445\u0445L\u0445L\u0445L\u0445LL\u0445LLL, 1.0f - \u0445\u0445L\u0445L\u0445L\u0445LL\u0445LLL, 1.0f);
                        Gui.drawScaledCustomSizeModalRect(\u0445L\u0445\u0445L\u0445L\u0445LL\u0445LLL + 1.5f, L\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL + 1.5f, 8.0f, 8.0f, 8.0f, 8.0f, 34.0f, 34.0f, 64.0f, 64.0f);
                        GL11.glPopMatrix();
                        GlStateManager.bindTexture(0);
                    }
                    GL11.glDisable(3089);
                    return;
                }
                RectHelper.drawRectBetter(\u0445L\u0445\u0445L\u0445L\u0445LL\u0445LLL + 1.5f, L\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL + 39.0f, 120.0, 4.0, new Color(26, 28, 25, 255).getRGB());
                RectHelper.drawRectBetter(\u0445L\u0445\u0445L\u0445L\u0445LL\u0445LLL + 1.5f, L\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL + 39.0f, LLLL\u0445\u0445L\u0445LL\u0445LLL, 4.0, new Color(2, 145, 98, 255).getRGB());
                RectHelper.drawRectBetter(\u0445L\u0445\u0445L\u0445L\u0445LL\u0445LLL + 1.5f, L\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL + 47.0f, 120.0, 4.0, new Color(26, 28, 25, 255).getRGB());
                RectHelper.drawRectBetter(\u0445L\u0445\u0445L\u0445L\u0445LL\u0445LLL + 1.5f, L\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL + 47.0f, \u0445\u0445\u0445\u0445L\u0445L\u0445LL\u0445LLL, 4.0, new Color(65, 138, 195, 255).getRGB());
            } else if (L\u0445LL\u0445L\u0445\u0445LL\u0445LLL.equalsIgnoreCase("Lite")) {
                \u0445\u0445LL\u0445\u0445L\u0445LL\u0445LLL = 160.0f;
                LL\u0445L\u0445\u0445L\u0445LL\u0445LLL = 48.0f;
                L\u0445\u0445L\u0445\u0445L\u0445LL\u0445LLL = 11.0f;
                \u0445\u0445\u0445L\u0445\u0445L\u0445LL\u0445LLL = new Color(25, 25, 25, 150);
                RectHelper.drawRectBetter(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX(), \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY(), 160.0, 48.0, \u0445\u0445\u0445L\u0445\u0445L\u0445LL\u0445LLL.getRGB());
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
                TargetHUDComponent.mc.getTextureManager().bindTexture(TargetHUDComponent.mc.player.getLocationSkin());
                Gui.drawScaledCustomSizeModalRect(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX(), \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY(), 8.0f, 8.0f, 8.0f, 8.0f, 48.0f, 48.0f, 64.0f, 64.0f);
                \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font.drawStringWithShadow(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName(), (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 48.0f + 5.0f, \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 10, -1);
                if (!TargetHUDComponent.mc.player.getHeldItemMainhand().isEmpty()) {
                    GL11.glPushMatrix();
                    GL11.glScalef(0.5f, 0.5f, 1.0f);
                    TargetHUDComponent.mc.getRenderItem().renderItemAndEffectIntoGUI(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItemMainhand(), (int)(((float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 48.0f + 5.0f) / 0.5f), (int)((float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 10 + \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font.getFontHeight() + 3) / 0.5f));
                    GL11.glPopMatrix();
                    \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font.drawStringWithShadow(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItemMainhand().getCount() + "x", (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 48.0f + 5.0f + 8.0f + 2.5f, (float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 10 + \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font.getFontHeight()) + 4.25f, -1);
                }
                if (!TargetHUDComponent.mc.player.getHeldItemOffhand().isEmpty()) {
                    L\u0445LL\u0445\u0445L\u0445LL\u0445LLL = TargetHUDComponent.mc.player.getHeldItemMainhand().isEmpty() != false ? 0.0f : 30.0f;
                    GL11.glPushMatrix();
                    GL11.glScalef(0.5f, 0.5f, 1.0f);
                    TargetHUDComponent.mc.getRenderItem().renderItemAndEffectIntoGUI(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItemOffhand(), (int)(((float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 48.0f + 5.0f + L\u0445LL\u0445\u0445L\u0445LL\u0445LLL) / 0.5f), (int)((float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 10 + \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font.getFontHeight() + 3) / 0.5f));
                    GL11.glPopMatrix();
                    \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font.drawStringWithShadow(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHeldItemOffhand().getCount() + "x", (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 48.0f + 5.0f + 8.0f + 2.5f + L\u0445LL\u0445\u0445L\u0445LL\u0445LLL, (float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 10 + \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font.getFontHeight()) + 4.25f, -1);
                }
                RectHelper.drawRectBetter((float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 48.0f + 5.0f, (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 48.0f - 6.0f - 11.0f, 102.0, 11.0, \u0445\u0445\u0445L\u0445\u0445L\u0445LL\u0445LLL.getRGB());
                \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font.drawCenteredStringWithShadow(Double.toString(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth()), (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 48.0f + 5.0f + 51.0f, (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 48.0f - 6.0f - 5.5f - 2.5f, -1);
                RectHelper.drawRectBetter((float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 48.0f + 5.0f, (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 48.0f - 6.0f - 11.0f, 102.0f * (\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() / \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getMaxHealth()), 11.0, -1);
            } else if (L\u0445LL\u0445L\u0445\u0445LL\u0445LLL.equalsIgnoreCase("Akrien")) {
                \u0445LL\u0445\u0445\u0445L\u0445LL\u0445LLL = TargetHUDComponent.mc.player;
                L\u0445L\u0445\u0445\u0445L\u0445LL\u0445LLL = new Color(26, 26, 26, 170);
                LL\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL = new Color(128, 241, 132);
                L\u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL = new Color(62, 134, 192);
                LLLLLL\u0445\u0445LL\u0445LLL = 130.0f;
                L\u0445LLLL\u0445\u0445LL\u0445LLL = 48.0f;
                \u0445\u0445LLLL\u0445\u0445LL\u0445LLL = 25.0f;
                LL\u0445LLL\u0445\u0445LL\u0445LLL = 2.0f;
                RectHelper.drawRectBetter(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX(), \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY(), LLLLLL\u0445\u0445LL\u0445LLL, L\u0445LLLL\u0445\u0445LL\u0445LLL, L\u0445L\u0445\u0445\u0445L\u0445LL\u0445LLL.getRGB());
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
                TargetHUDComponent.mc.getTextureManager().bindTexture(\u0445LL\u0445\u0445\u0445L\u0445LL\u0445LLL.getLocationSkin());
                Gui.drawScaledCustomSizeModalRect((float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 2.5f, (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 2.5f, 8.0f, 8.0f, 8.0f, 8.0f, \u0445\u0445LLLL\u0445\u0445LL\u0445LLL, \u0445\u0445LLLL\u0445\u0445LL\u0445LLL, 64.0f, 64.0f);
                RectHelper.drawRectBetter((float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 2.5f, (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + \u0445\u0445LLLL\u0445\u0445LL\u0445LLL + 8.0f, (LLLLLL\u0445\u0445LL\u0445LLL - 5.0f) * (\u0445LL\u0445\u0445\u0445L\u0445LL\u0445LLL.getHealth() / \u0445LL\u0445\u0445\u0445L\u0445LL\u0445LLL.getMaxHealth()), LL\u0445LLL\u0445\u0445LL\u0445LLL, L\u0445L\u0445\u0445\u0445L\u0445LL\u0445LLL.getRGB());
                RectHelper.drawGradientRectBetter((float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 2.5f, (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + \u0445\u0445LLLL\u0445\u0445LL\u0445LLL + 8.0f, (LLLLLL\u0445\u0445LL\u0445LLL - 5.0f) * (\u0445LL\u0445\u0445\u0445L\u0445LL\u0445LLL.getHealth() / \u0445LL\u0445\u0445\u0445L\u0445LL\u0445LLL.getMaxHealth()), LL\u0445LLL\u0445\u0445LL\u0445LLL, LL\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL.getRGB() - -536870912, LL\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL.getRGB());
                RectHelper.drawRectBetter((float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 2.5f, (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + \u0445\u0445LLLL\u0445\u0445LL\u0445LLL + 16.0f, (LLLLLL\u0445\u0445LL\u0445LLL - 5.0f) * (\u0445LL\u0445\u0445\u0445L\u0445LL\u0445LLL.getHealth() / \u0445LL\u0445\u0445\u0445L\u0445LL\u0445LLL.getMaxHealth()), LL\u0445LLL\u0445\u0445LL\u0445LLL, L\u0445L\u0445\u0445\u0445L\u0445LL\u0445LLL.getRGB());
                RectHelper.drawGradientRectBetter((float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 2.5f, (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + \u0445\u0445LLLL\u0445\u0445LL\u0445LLL + 16.0f, (LLLLLL\u0445\u0445LL\u0445LLL - 5.0f) * ((float)\u0445LL\u0445\u0445\u0445L\u0445LL\u0445LLL.getTotalArmorValue() / 20.0f), LL\u0445LLL\u0445\u0445LL\u0445LLL, L\u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL.getRGB() - -536870912, L\u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445LLL.getRGB());
                \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font24.drawStringWithShadow(\u0445LL\u0445\u0445\u0445L\u0445LL\u0445LLL.getName(), (float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 8) + \u0445\u0445LLLL\u0445\u0445LL\u0445LLL, (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 3.5f, -1);
                \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font20.drawStringWithShadow("Health: " + Math.round(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() * 10.0f) / 10, (float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 8) + \u0445\u0445LLLL\u0445\u0445LL\u0445LLL, (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + 0.2f + (float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font24.getFontHeight() + L\u0445LLLL\u0445\u0445LL\u0445LLL / 7.0f, -1);
                \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font20.drawStringWithShadow("Distance: " + Math.round(TargetHUDComponent.mc.player.getDistanceToEntity(\u0445LL\u0445\u0445\u0445L\u0445LL\u0445LLL) * 10.0f) / 10, (float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 8) + \u0445\u0445LLLL\u0445\u0445LL\u0445LLL, (float)(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() + \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.font24.getFontHeight() * 2) + 0.3f + L\u0445LLLL\u0445\u0445LL\u0445LLL / 10.0f + 2.0f, -1);
            } else if (L\u0445LL\u0445L\u0445\u0445LL\u0445LLL.equalsIgnoreCase("Celestial")) {
                if (\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL == null) {
                    return;
                }
                if (\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth() < 0.0f) {
                    return;
                }
                L\u0445\u0445LLL\u0445\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() - 127;
                \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL = \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY();
                \u0445LL\u0445LL\u0445\u0445LL\u0445LLL = 28.0f;
                RectHelper.drawRectBetter(L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 125.0f, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL - 25.0f, 151.0, 50.0, new Color(26, 26, 26, 170).getRGB());
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                TargetHUDComponent.mc.getTextureManager().bindTexture(TargetHUDComponent.mc.player.getLocationSkin());
                Gui.drawScaledCustomSizeModalRect((float)\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getX() + 0.5f, \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.getY() - 11 + 5, 8.0f, 8.0f, 8.0f, 8.0f, \u0445LL\u0445LL\u0445\u0445LL\u0445LLL, \u0445LL\u0445LL\u0445\u0445LL\u0445LLL, 64.0f, 64.0f);
                L\u0445L\u0445LL\u0445\u0445LL\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getHealth();
                \u0445\u0445L\u0445LL\u0445\u0445LL\u0445LLL = L\u0445L\u0445LL\u0445\u0445LL\u0445LLL / \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getMaxHealth();
                \u0445\u0445L\u0445LL\u0445\u0445LL\u0445LLL = MathHelper.clamp(\u0445\u0445L\u0445LL\u0445\u0445LL\u0445LLL, 0.0, 1.0);
                LL\u0445\u0445LL\u0445\u0445LL\u0445LLL = 110.0 * \u0445\u0445L\u0445LL\u0445\u0445LL\u0445LLL;
                \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth = (float)MathHelper.clampedLerp(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth, (float)LL\u0445\u0445LL\u0445\u0445LL\u0445LLL, 7.0f * TargetHUDComponent.mc.getRenderPartialTicks());
                RectHelper.drawRect((double)L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 127.5, (double)\u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL - 11.5, L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 273.0f, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL - 11.0f, ClientHelper.getClientColor().getRGB());
                RectHelper.drawSmoothRect(L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 162.0f, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 16.0f, L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 272.0f, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 21.0f, new Color(26, 26, 26, 170).getRGB());
                RectHelper.drawSmoothRect(L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 162.0f, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 16.0f, L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 162.0f + \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL.healthBarWidth, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 21.0f, ClientHelper.getClientColor().getRGB());
                TargetHUDComponent.mc.sfuiFontRender.drawStringWithShadow("Ground: " + \u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.onGround, L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 162.0f, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL - 3.0f, -1);
                TargetHUDComponent.mc.sfuiFontRender.drawStringWithShadow("HurtTime", L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 162.5f, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 7.0f, -1);
                TargetHUDComponent.mc.sfuiFontRender.drawCenteredString(\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.getName(), (float)((double)L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 200.71942446043167), \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL - 19.5f, -1);
                RectHelper.drawRect(L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 217.0f, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 9.0f, L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 270.0f, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 11.0f, new Color(26, 26, 26, 170).getRGB());
                \u0445L\u0445\u0445LL\u0445\u0445LL\u0445LLL = MathHelper.clamp((double)\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.hurtTime, 1.0, 0.3);
                L\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL = 53.0 * \u0445L\u0445\u0445LL\u0445\u0445LL\u0445LLL;
                RectHelper.drawRectBetter(L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 217.0f, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 9.0f, L\u0445\u0445\u0445LL\u0445\u0445LL\u0445LLL, 2.0, ClientHelper.getClientColor().getRGB());
                RectHelper.drawSmoothRect((float)((double)L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 125.5), \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL - 25.0f, L\u0445\u0445LLL\u0445\u0445LL\u0445LLL + 275.0f, \u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL - 24.0f, ClientHelper.getClientColor().getRGB());
            }
        }
        super.render(LLLL\u0445L\u0445\u0445LL\u0445LLL, \u0445LLL\u0445L\u0445\u0445LL\u0445LLL);
    }

    @Override
    public void draw() {
        TargetHUDComponent L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL;
        String \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL = KillAura.targetHudMode.getOptions();
        EntityLivingBase LLLLL\u0445\u0445L\u0445L\u0445LLL = KillAura.target;
        int \u0445LLLL\u0445\u0445L\u0445L\u0445LLL = KillAura.targetHudColor.getColorValue();
        long L\u0445LLL\u0445\u0445L\u0445L\u0445LLL = System.currentTimeMillis();
        float \u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL = (float)(L\u0445LLL\u0445\u0445L\u0445L\u0445LLL - L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.lastUpdate) / 1000.0f;
        L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.lastUpdate = System.currentTimeMillis();
        if (LLLLL\u0445\u0445L\u0445L\u0445LLL != null) {
            if (L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.displayPercent < 1.0f) {
                L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.displayPercent += \u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL;
            }
            if (L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.displayPercent > 1.0f) {
                L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.displayPercent = 1.0f;
            }
        } else {
            if (L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.displayPercent > 0.0f) {
                L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.displayPercent -= \u0445\u0445LLL\u0445\u0445L\u0445L\u0445LLL;
            }
            if (L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.displayPercent < 0.0f) {
                L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.displayPercent = 0.0f;
            }
        }
        if (\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.equalsIgnoreCase("Astolfo")) {
            float \u0445\u0445LLL\u0445LL\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX();
            float LL\u0445LL\u0445LL\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY();
            double \u0445L\u0445LL\u0445LL\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() / LLLLL\u0445\u0445L\u0445L\u0445LLL.getMaxHealth() * 120.0f;
            \u0445L\u0445LL\u0445LL\u0445L\u0445LLL = MathHelper.clamp(\u0445L\u0445LL\u0445LL\u0445L\u0445LLL, 0.0, 120.0);
            double L\u0445\u0445LL\u0445LL\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() < 18.0f && LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() > 1.0f ? 8.0 : 0.0;
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth = AnimationHelper.calculateCompensation((float)\u0445L\u0445LL\u0445LL\u0445L\u0445LLL, L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth, 0L, 0.005);
            RectHelper.drawRectBetter(\u0445\u0445LLL\u0445LL\u0445L\u0445LLL, LL\u0445LL\u0445LL\u0445L\u0445LLL, 155.0, 60.0, new Color(20, 20, 20, 200).getRGB());
            if (!LLLLL\u0445\u0445L\u0445L\u0445LLL.getName().isEmpty()) {
                TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName(), \u0445\u0445LLL\u0445LL\u0445L\u0445LLL + 31.0f, LL\u0445LL\u0445LL\u0445L\u0445LLL + 5.0f, -1);
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(\u0445\u0445LLL\u0445LL\u0445L\u0445LLL, LL\u0445LL\u0445LL\u0445L\u0445LLL, 1.0f);
            GlStateManager.scale(2.5f, 2.5f, 2.5f);
            GlStateManager.translate(-\u0445\u0445LLL\u0445LL\u0445L\u0445LLL - 3.0f, -LL\u0445LL\u0445LL\u0445L\u0445LLL - 2.0f, 1.0f);
            TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(MathematicHelper.round(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() / 2.0f, 1) + " \u2764", \u0445\u0445LLL\u0445LL\u0445L\u0445LLL + 16.0f, LL\u0445LL\u0445LL\u0445L\u0445LLL + 10.0f, new Color(\u0445LLLL\u0445\u0445L\u0445L\u0445LLL).getRGB());
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            mc.getRenderItem().renderItemOverlays(TargetHUDComponent.mc.fontRendererObj, LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)\u0445\u0445LLL\u0445LL\u0445L\u0445LLL + 137, (int)LL\u0445LL\u0445LL\u0445L\u0445LLL + 7);
            mc.getRenderItem().renderItemIntoGUI(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)\u0445\u0445LLL\u0445LL\u0445L\u0445LLL + 137, (int)LL\u0445LL\u0445LL\u0445L\u0445LLL + 1);
            GuiInventory.drawEntityOnScreen(\u0445\u0445LLL\u0445LL\u0445L\u0445LLL + 16.0f, LL\u0445LL\u0445LL\u0445L\u0445LLL + 55.0f, 25, LLLLL\u0445\u0445L\u0445L\u0445LLL.rotationYaw, -LLLLL\u0445\u0445L\u0445L\u0445LLL.rotationPitch, LLLLL\u0445\u0445L\u0445L\u0445LLL);
            RectHelper.drawRectBetter(\u0445\u0445LLL\u0445LL\u0445L\u0445LLL + 30.0f, LL\u0445LL\u0445LL\u0445L\u0445LLL + 48.0f, 120.0, 8.0, new Color(\u0445LLLL\u0445\u0445L\u0445L\u0445LLL).darker().darker().darker().getRGB());
            RectHelper.drawRectBetter(\u0445\u0445LLL\u0445LL\u0445L\u0445LLL + 30.0f, LL\u0445LL\u0445LL\u0445L\u0445LLL + 48.0f, (double)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth + L\u0445\u0445LL\u0445LL\u0445L\u0445LLL, 8.0, new Color(\u0445LLLL\u0445\u0445L\u0445L\u0445LLL).darker().getRGB());
            RectHelper.drawRectBetter(\u0445\u0445LLL\u0445LL\u0445L\u0445LLL + 30.0f, LL\u0445LL\u0445LL\u0445L\u0445LLL + 48.0f, \u0445L\u0445LL\u0445LL\u0445L\u0445LLL, 8.0, new Color(\u0445LLLL\u0445\u0445L\u0445L\u0445LLL).getRGB());
        } else if (\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.equalsIgnoreCase("Small")) {
            float \u0445LL\u0445L\u0445LL\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX();
            float L\u0445L\u0445L\u0445LL\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY();
            double \u0445\u0445L\u0445L\u0445LL\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() / LLLLL\u0445\u0445L\u0445L\u0445LLL.getMaxHealth() * 100.0f;
            \u0445\u0445L\u0445L\u0445LL\u0445L\u0445LLL = MathHelper.clamp(\u0445\u0445L\u0445L\u0445LL\u0445L\u0445LLL, 0.0, 100.0);
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth = AnimationHelper.calculateCompensation((float)\u0445\u0445L\u0445L\u0445LL\u0445L\u0445LLL, L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth, 0L, 0.005);
            RectHelper.drawRectBetter(\u0445LL\u0445L\u0445LL\u0445L\u0445LLL, L\u0445L\u0445L\u0445LL\u0445L\u0445LLL, 140.0, 34.0, new Color(20, 20, 20).getRGB());
            if (!LLLLL\u0445\u0445L\u0445L\u0445LLL.getName().isEmpty()) {
                TargetHUDComponent.mc.fontRenderer.drawStringWithShadow(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName(), \u0445LL\u0445L\u0445LL\u0445L\u0445LLL + 38.0f, L\u0445L\u0445L\u0445LL\u0445L\u0445LLL + 5.0f, -1);
            }
            TargetHUDComponent.mc.fontRenderer.drawStringWithShadow(TargetHUDComponent.mc.player.connection.getPlayerInfo(LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()).getResponseTime() + "ms", \u0445LL\u0445L\u0445LL\u0445L\u0445LLL + 38.0f, L\u0445L\u0445L\u0445LL\u0445L\u0445LLL + 15.0f, -1);
            RectHelper.drawRectBetter(\u0445LL\u0445L\u0445LL\u0445L\u0445LLL + 38.0f, L\u0445L\u0445L\u0445LL\u0445L\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 15.0f, 10 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()), 8.0, new Color(35, 35, 35, 255).getRGB());
            RectHelper.drawRectBetter(\u0445LL\u0445L\u0445LL\u0445L\u0445LLL + 38.0f, L\u0445L\u0445L\u0445LL\u0445L\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 15.0f, LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() > 18.0f ? \u0445\u0445L\u0445L\u0445LL\u0445L\u0445LLL : (double)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth + 4.0f), 8.0, new Color(\u0445LLLL\u0445\u0445L\u0445L\u0445LLL).darker().getRGB());
            RectHelper.drawRectBetter(\u0445LL\u0445L\u0445LL\u0445L\u0445LLL + 38.0f, L\u0445L\u0445L\u0445LL\u0445L\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 15.0f, \u0445\u0445L\u0445L\u0445LL\u0445L\u0445LLL, 8.0, new Color(\u0445LLLL\u0445\u0445L\u0445L\u0445LLL).getRGB());
            mc.getRenderItem().renderItemOverlays(TargetHUDComponent.mc.fontRendererObj, LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)\u0445LL\u0445L\u0445LL\u0445L\u0445LLL + 137, (int)L\u0445L\u0445L\u0445LL\u0445L\u0445LLL + 7);
            mc.getRenderItem().renderItemIntoGUI(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)\u0445LL\u0445L\u0445LL\u0445L\u0445LLL + 137, (int)L\u0445L\u0445L\u0445LL\u0445L\u0445LLL + 1);
            Iterator<NetworkPlayerInfo> L\u0445\u0445LL\u0445LL\u0445L\u0445LLL = TargetHUDComponent.mc.player.connection.getPlayerInfoMap().iterator();
            if (L\u0445\u0445LL\u0445LL\u0445L\u0445LLL.hasNext()) {
                NetworkPlayerInfo LLL\u0445L\u0445LL\u0445L\u0445LLL = L\u0445\u0445LL\u0445LL\u0445L\u0445LLL.next();
                if (TargetHUDComponent.mc.world.getPlayerEntityByUUID(LLL\u0445L\u0445LL\u0445L\u0445LLL.getGameProfile().getId()) == LLLLL\u0445\u0445L\u0445L\u0445LLL) {
                    mc.getTextureManager().bindTexture(LLL\u0445L\u0445LL\u0445L\u0445LLL.getLocationSkin());
                    float \u0445\u0445\u0445LL\u0445LL\u0445L\u0445LLL = TargetHUDComponent.getHurtPercent(LLLLL\u0445\u0445L\u0445L\u0445LLL);
                    GL11.glPushMatrix();
                    GL11.glColor4f(1.0f, 1.0f - \u0445\u0445\u0445LL\u0445LL\u0445L\u0445LLL, 1.0f - \u0445\u0445\u0445LL\u0445LL\u0445L\u0445LLL, 1.0f);
                    Gui.drawScaledCustomSizeModalRect((int)\u0445LL\u0445L\u0445LL\u0445L\u0445LLL + 1, (int)L\u0445L\u0445L\u0445LL\u0445L\u0445LLL + 1, 8.0f, 8.0f, 8.0f, 8.0f, 32.0f, 32.0f, 64.0f, 64.0f);
                    GL11.glPushMatrix();
                    GlStateManager.bindTexture(0);
                }
                GL11.glDisable(3089);
                return;
            }
        } else if (\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.equalsIgnoreCase("Novoline Old")) {
            boolean L\u0445LL\u0445\u0445LL\u0445L\u0445LLL;
            if (LLLLL\u0445\u0445L\u0445L\u0445LLL == null) {
                return;
            }
            if (LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() < 0.0f) {
                return;
            }
            float L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX();
            float \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY();
            float LLLL\u0445\u0445LL\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() / LLLLL\u0445\u0445L\u0445L\u0445LLL.getMaxHealth() * (float)(40 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()));
            LLLL\u0445\u0445LL\u0445L\u0445LLL = (float)MathHelper.clamp((double)LLLL\u0445\u0445LL\u0445L\u0445LLL, 0.0, 124.0);
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth = AnimationHelper.calculateCompensation(LLLL\u0445\u0445LL\u0445L\u0445LLL, L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth, 0L, 0.0);
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth = MathHelper.clamp(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth, 0.0f, 124.0f);
            RectHelper.drawRectBetter(L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL, \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL, 65 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 25, 40.0, new Color(19, 19, 19, 255).getRGB());
            RectHelper.drawRectBetter(L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 1.0f, \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 1.0f, 65 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 23, 38.0, new Color(41, 41, 41, 255).getRGB());
            if (!LLLLL\u0445\u0445L\u0445L\u0445LLL.getName().isEmpty()) {
                TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName(), L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 42.0f, \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 5.0f, -1);
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL, \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL, 1.0f);
            GlStateManager.scale(1.05f, 1.05f, 1.05f);
            GlStateManager.translate(-L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 24.0f, -\u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 18.0f, 1.0f);
            String \u0445LLL\u0445\u0445LL\u0445L\u0445LLL = MathematicHelper.round(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() / 2.0f, 1) + "";
            TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(\u0445LLL\u0445\u0445LL\u0445L\u0445LLL, L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 17.0f, \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 10.0f, -1);
            TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(" \u2764", L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringWidth(\u0445LLL\u0445\u0445LL\u0445L\u0445LLL) + 16.0f, \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 10.0f, new Color(\u0445LLLL\u0445\u0445L\u0445L\u0445LLL).getRGB());
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.pushMatrix();
            GlStateManager.translate(L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL, \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL, 1.0f);
            GlStateManager.scale(0.8f, 0.8f, 0.8f);
            GlStateManager.translate(-L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 148.0f, -\u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 38.0f, 1.0f);
            boolean bl2 = L\u0445LL\u0445\u0445LL\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItemOffhand().isStackable() && !LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItemOffhand().isEmpty();
            if (L\u0445LL\u0445\u0445LL\u0445L\u0445LLL) {
                mc.getRenderItem().renderItemOverlays(TargetHUDComponent.mc.fontRendererObj, LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)(L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL - 39.0f + (float)TargetHUDComponent.mc.fontRenderer.getStringWidth(\u0445LLL\u0445\u0445LL\u0445L\u0445LLL) - 21.0f), (int)(\u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL - 8.0f));
                mc.getRenderItem().renderItemIntoGUI(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)(L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL - 49.0f + (float)TargetHUDComponent.mc.fontRenderer.getStringWidth(\u0445LLL\u0445\u0445LL\u0445L\u0445LLL) - 21.0f), (int)\u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL - 5);
            }
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            Iterator<NetworkPlayerInfo> LLL\u0445L\u0445LL\u0445L\u0445LLL = TargetHUDComponent.mc.player.connection.getPlayerInfoMap().iterator();
            if (LLL\u0445L\u0445LL\u0445L\u0445LLL.hasNext()) {
                NetworkPlayerInfo \u0445L\u0445\u0445L\u0445LL\u0445L\u0445LLL = LLL\u0445L\u0445LL\u0445L\u0445LLL.next();
                if (TargetHUDComponent.mc.world.getPlayerEntityByUUID(\u0445L\u0445\u0445L\u0445LL\u0445L\u0445LLL.getGameProfile().getId()) == LLLLL\u0445\u0445L\u0445L\u0445LLL) {
                    mc.getTextureManager().bindTexture(\u0445L\u0445\u0445L\u0445LL\u0445L\u0445LLL.getLocationSkin());
                    float LL\u0445\u0445L\u0445LL\u0445L\u0445LLL = TargetHUDComponent.getHurtPercent(LLLLL\u0445\u0445L\u0445L\u0445LLL);
                    GL11.glPushMatrix();
                    GL11.glColor4f(1.0f, 1.0f - LL\u0445\u0445L\u0445LL\u0445L\u0445LLL, 1.0f - LL\u0445\u0445L\u0445LL\u0445L\u0445LLL, 1.0f);
                    Gui.drawScaledCustomSizeModalRect((int)L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 1, (int)\u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 1, 8.0f, 8.0f, 8.0f, 8.0f, 38.0f, 38.0f, 64.0f, 64.0f);
                    GL11.glPopMatrix();
                    GlStateManager.bindTexture(0);
                }
                GL11.glDisable(3089);
                return;
            }
            RectHelper.drawRectBetter(L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 42.0f, \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 9.0f, 40 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()), 8.0, new Color(35, 35, 35, 255).getRGB());
            RectHelper.drawRectBetter(L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 42.0f, \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 9.0f, LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() > 18.0f ? (double)LLLL\u0445\u0445LL\u0445L\u0445LLL : (double)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth + 4.0f), 8.0, new Color(\u0445LLLL\u0445\u0445L\u0445L\u0445LLL).darker().getRGB());
            RectHelper.drawRectBetter(L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + 42.0f, \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 9.0f, LLLL\u0445\u0445LL\u0445L\u0445LLL, 8.0, new Color(\u0445LLLL\u0445\u0445L\u0445L\u0445LLL).getRGB());
        } else if (\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.equalsIgnoreCase("Novoline New")) {
            boolean LLL\u0445\u0445\u0445LL\u0445L\u0445LLL;
            if (LLLLL\u0445\u0445L\u0445L\u0445LLL == null) {
                return;
            }
            if (LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() < 0.0f) {
                return;
            }
            float \u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX();
            float L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY();
            float \u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() / LLLLL\u0445\u0445L\u0445L\u0445LLL.getMaxHealth() * (float)(40 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()));
            \u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL = (float)MathHelper.clamp((double)\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL, 0.0, 124.0);
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth = AnimationHelper.calculateCompensation(\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL, L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth, 0L, 0.0);
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth = MathHelper.clamp(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth, 0.0f, 124.0f);
            RectHelper.drawRectBetter(\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL, L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL, 65 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 25, 40.0, new Color(19, 19, 19, 255).getRGB());
            RectHelper.drawRectBetter(\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL + 1.0f, L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL + 1.0f, 65 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 23, 38.0, new Color(41, 41, 41, 255).getRGB());
            if (!LLLLL\u0445\u0445L\u0445L\u0445LLL.getName().isEmpty()) {
                TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName(), \u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL + 42.0f, L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL + 5.0f, -1);
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL, L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL, 1.0f);
            GlStateManager.scale(1.05f, 1.05f, 1.05f);
            GlStateManager.translate(-\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL + 24.0f, -L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL + 18.0f, 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.pushMatrix();
            GlStateManager.translate(\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL, L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL, 1.0f);
            GlStateManager.scale(0.8f, 0.8f, 0.8f);
            GlStateManager.translate(-\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL + 148.0f, -L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL + 38.0f, 1.0f);
            boolean bl3 = LLL\u0445\u0445\u0445LL\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItemOffhand().isStackable() && !LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItemOffhand().isEmpty();
            if (LLL\u0445\u0445\u0445LL\u0445L\u0445LLL) {
                mc.getRenderItem().renderItemOverlays(TargetHUDComponent.mc.fontRendererObj, LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)(\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL - 88.0f), (int)(L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL - 8.0f));
                mc.getRenderItem().renderItemIntoGUI(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItem(EnumHand.OFF_HAND), (int)(\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL - 98.0f), (int)L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL - 5);
            }
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            Iterator<NetworkPlayerInfo> L\u0445LL\u0445\u0445LL\u0445L\u0445LLL = TargetHUDComponent.mc.player.connection.getPlayerInfoMap().iterator();
            if (L\u0445LL\u0445\u0445LL\u0445L\u0445LLL.hasNext()) {
                NetworkPlayerInfo LL\u0445L\u0445\u0445LL\u0445L\u0445LLL = L\u0445LL\u0445\u0445LL\u0445L\u0445LLL.next();
                if (TargetHUDComponent.mc.world.getPlayerEntityByUUID(LL\u0445L\u0445\u0445LL\u0445L\u0445LLL.getGameProfile().getId()) == LLLLL\u0445\u0445L\u0445L\u0445LLL) {
                    mc.getTextureManager().bindTexture(LL\u0445L\u0445\u0445LL\u0445L\u0445LLL.getLocationSkin());
                    float \u0445\u0445LL\u0445\u0445LL\u0445L\u0445LLL = TargetHUDComponent.getHurtPercent(LLLLL\u0445\u0445L\u0445L\u0445LLL);
                    GL11.glPushMatrix();
                    GL11.glColor4f(1.0f, 1.0f - \u0445\u0445LL\u0445\u0445LL\u0445L\u0445LLL, 1.0f - \u0445\u0445LL\u0445\u0445LL\u0445L\u0445LLL, 1.0f);
                    Gui.drawScaledCustomSizeModalRect((int)\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL + 1, (int)L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL + 1, 8.0f, 8.0f, 8.0f, 8.0f, 38.0f, 38.0f, 64.0f, 64.0f);
                    GL11.glPopMatrix();
                    GlStateManager.bindTexture(0);
                }
                GL11.glDisable(3089);
                return;
            }
            String \u0445LL\u0445\u0445\u0445LL\u0445L\u0445LLL = MathematicHelper.round(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() / LLLLL\u0445\u0445L\u0445L\u0445LLL.getMaxHealth() * 100.0f, 1) + "%";
            RectHelper.drawRectBetter(\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL + 42.0f, L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 9.0f, 40 + TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()), 10.0, new Color(35, 35, 35, 255).getRGB());
            RectHelper.drawRectBetter(\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL + 42.0f, L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 9.0f, LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() > 18.0f ? (double)\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL : (double)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth + 4.0f), 10.0, new Color(\u0445LLLL\u0445\u0445L\u0445L\u0445LLL).darker().getRGB());
            RectHelper.drawRectBetter(\u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL + 42.0f, L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringHeight(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) + 9.0f, \u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL, 10.0, new Color(\u0445LLLL\u0445\u0445L\u0445L\u0445LLL).getRGB());
            TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(\u0445LL\u0445\u0445\u0445LL\u0445L\u0445LLL, \u0445L\u0445L\u0445\u0445LL\u0445L\u0445LLL + (float)TargetHUDComponent.mc.fontRendererObj.getStringWidth(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName()) / 2.0f + 50.0f, L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL + 19.0f, -1);
        } else if (\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.equalsIgnoreCase("dfgopkododfg")) {
            if (LLLLL\u0445\u0445L\u0445L\u0445LLL == null) {
                return;
            }
            float \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX();
            float L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY();
            GlStateManager.pushMatrix();
            RectHelper.drawOutlineRect(\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL - 2.0f, L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL - 7.0f, 155.0f, 38.0f, new Color(20, 20, 20, 255), new Color(255, 255, 255, 255));
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            TargetHUDComponent.mc.fontRendererObj.drawStringWithShadow(LLLLL\u0445\u0445L\u0445L\u0445LLL.getName(), L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 37, L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() - 2, -1);
            Iterator<NetworkPlayerInfo> \u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL = TargetHUDComponent.mc.player.connection.getPlayerInfoMap().iterator();
            if (\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL.hasNext()) {
                NetworkPlayerInfo L\u0445L\u0445\u0445\u0445LL\u0445L\u0445LLL = \u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445LLL.next();
                if (TargetHUDComponent.mc.world.getPlayerEntityByUUID(L\u0445L\u0445\u0445\u0445LL\u0445L\u0445LLL.getGameProfile().getId()) == LLLLL\u0445\u0445L\u0445L\u0445LLL) {
                    mc.getTextureManager().bindTexture(L\u0445L\u0445\u0445\u0445LL\u0445L\u0445LLL.getLocationSkin());
                    Gui.drawScaledCustomSizeModalRect((int)\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL, (int)L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL - 5, 8.0f, 8.0f, 8.0f, 8.0f, 34.0f, 34.0f, 64.0f, 64.0f);
                    GlStateManager.bindTexture(0);
                }
                GL11.glDisable(3089);
                return;
            }
            mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
            int \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL = 0;
            if ((float)\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL < LLLLL\u0445\u0445L\u0445L\u0445LLL.getMaxHealth() / 2.0f) {
                TargetHUDComponent.mc.ingameGUI.drawTexturedModalRect((float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 86) - LLLLL\u0445\u0445L\u0445L\u0445LLL.getMaxHealth() / 2.0f * 10.0f / 2.0f + (float)(\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL * 8), (float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 9), 16, 0, 9, 9);
                ++\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL;
                return;
            }
            \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL = 0;
            if ((float)\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL < LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() / 2.0f) {
                TargetHUDComponent.mc.ingameGUI.drawTexturedModalRect((float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 86) - LLLLL\u0445\u0445L\u0445L\u0445LLL.getMaxHealth() / 2.0f * 10.0f / 2.0f + (float)(\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL * 8), (float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 9), 52, 0, 9, 9);
                ++\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL;
                return;
            }
            int LLLLLL\u0445L\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getTotalArmorValue();
            int LL\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL = 0;
            if (LL\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL < 10) {
                if (LLLLLL\u0445L\u0445L\u0445LLL > 0) {
                    int \u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 36 + LL\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL * 8;
                    if (LL\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL * 2 + 1 < LLLLLL\u0445L\u0445L\u0445LLL) {
                        TargetHUDComponent.mc.ingameGUI.drawTexturedModalRect(\u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445LLL, L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 20, 34, 9, 9, 9);
                    }
                    if (LL\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL * 2 + 1 == LLLLLL\u0445L\u0445L\u0445LLL) {
                        TargetHUDComponent.mc.ingameGUI.drawTexturedModalRect(\u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445LLL, L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 20, 25, 9, 9, 9);
                    }
                    if (LL\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL * 2 + 1 > LLLLLL\u0445L\u0445L\u0445LLL) {
                        TargetHUDComponent.mc.ingameGUI.drawTexturedModalRect(\u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445LLL, L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 20, 16, 9, 9, 9);
                    }
                }
                ++LL\u0445\u0445\u0445\u0445LL\u0445L\u0445LLL;
                return;
            }
            GlStateManager.popMatrix();
        } else if (\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.equalsIgnoreCase("Flux")) {
            Iterator<NetworkPlayerInfo> LL\u0445\u0445L\u0445LL\u0445L\u0445LLL;
            float \u0445\u0445LLLL\u0445L\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX();
            float LL\u0445LLL\u0445L\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY();
            double \u0445L\u0445LLL\u0445L\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getTotalArmorValue() * 6;
            double L\u0445\u0445LLL\u0445L\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() / LLLLL\u0445\u0445L\u0445L\u0445LLL.getMaxHealth() * 120.0f;
            L\u0445\u0445LLL\u0445L\u0445L\u0445LLL = MathHelper.clamp(L\u0445\u0445LLL\u0445L\u0445L\u0445LLL, 0.0, 120.0);
            RectHelper.drawRectBetter(\u0445\u0445LLLL\u0445L\u0445L\u0445LLL, LL\u0445LLL\u0445L\u0445L\u0445LLL, 125.0, 55.0, new Color(39, 39, 37, 235).getRGB());
            String \u0445\u0445\u0445LLL\u0445L\u0445L\u0445LLL = "";
            if (TargetHUDComponent.mc.player.getHealth() == LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth()) {
                \u0445\u0445\u0445LLL\u0445L\u0445L\u0445LLL = "Finish Him!";
            } else if (TargetHUDComponent.mc.player.getHealth() < LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth()) {
                \u0445\u0445\u0445LLL\u0445L\u0445L\u0445LLL = "Losing Fight";
            } else if (TargetHUDComponent.mc.player.getHealth() > LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth()) {
                \u0445\u0445\u0445LLL\u0445L\u0445L\u0445LLL = "Winning Fight";
            }
            if (!LLLLL\u0445\u0445L\u0445L\u0445LLL.getName().isEmpty()) {
                TargetHUDComponent.mc.robotoRegularFontRender.drawStringWithShadow(Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue() ? "Protected" : LLLLL\u0445\u0445L\u0445L\u0445LLL.getName(), \u0445\u0445LLLL\u0445L\u0445L\u0445LLL + 38.0f, LL\u0445LLL\u0445L\u0445L\u0445LLL + 6.0f, -1);
                TargetHUDComponent.mc.clickguismall.drawStringWithShadow(\u0445\u0445\u0445LLL\u0445L\u0445L\u0445LLL, \u0445\u0445LLLL\u0445L\u0445L\u0445LLL + 38.0f, LL\u0445LLL\u0445L\u0445L\u0445LLL + 17.0f, -1);
            }
            if ((LL\u0445\u0445L\u0445LL\u0445L\u0445LLL = TargetHUDComponent.mc.player.connection.getPlayerInfoMap().iterator()).hasNext()) {
                NetworkPlayerInfo L\u0445LLLL\u0445L\u0445L\u0445LLL = LL\u0445\u0445L\u0445LL\u0445L\u0445LLL.next();
                mc.getTextureManager().bindTexture(L\u0445LLLL\u0445L\u0445L\u0445LLL.getLocationSkin());
                float \u0445LLLLL\u0445L\u0445L\u0445LLL = TargetHUDComponent.getHurtPercent(LLLLL\u0445\u0445L\u0445L\u0445LLL);
                GL11.glPushMatrix();
                GL11.glColor4f(1.0f, 1.0f - \u0445LLLLL\u0445L\u0445L\u0445LLL, 1.0f - \u0445LLLLL\u0445L\u0445L\u0445LLL, 1.0f);
                Gui.drawScaledCustomSizeModalRect(\u0445\u0445LLLL\u0445L\u0445L\u0445LLL + 1.5f, LL\u0445LLL\u0445L\u0445L\u0445LLL + 1.5f, 8.0f, 8.0f, 8.0f, 8.0f, 34.0f, 34.0f, 64.0f, 64.0f);
                GL11.glPopMatrix();
                return;
            }
            RectHelper.drawRectBetter(\u0445\u0445LLLL\u0445L\u0445L\u0445LLL + 1.5f, LL\u0445LLL\u0445L\u0445L\u0445LLL + 39.0f, 120.0, 4.0, new Color(26, 28, 25, 255).getRGB());
            RectHelper.drawRectBetter(\u0445\u0445LLLL\u0445L\u0445L\u0445LLL + 1.5f, LL\u0445LLL\u0445L\u0445L\u0445LLL + 39.0f, L\u0445\u0445LLL\u0445L\u0445L\u0445LLL, 4.0, new Color(2, 145, 98, 255).getRGB());
            RectHelper.drawRectBetter(\u0445\u0445LLLL\u0445L\u0445L\u0445LLL + 1.5f, LL\u0445LLL\u0445L\u0445L\u0445LLL + 47.0f, 120.0, 4.0, new Color(26, 28, 25, 255).getRGB());
            RectHelper.drawRectBetter(\u0445\u0445LLLL\u0445L\u0445L\u0445LLL + 1.5f, LL\u0445LLL\u0445L\u0445L\u0445LLL + 47.0f, \u0445L\u0445LLL\u0445L\u0445L\u0445LLL, 4.0, new Color(65, 138, 195, 255).getRGB());
        } else if (\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.equalsIgnoreCase("Lite") && LLLLL\u0445\u0445L\u0445L\u0445LLL instanceof EntityOtherPlayerMP) {
            float \u0445LL\u0445LL\u0445L\u0445L\u0445LLL = 160.0f;
            float L\u0445L\u0445LL\u0445L\u0445L\u0445LLL = 48.0f;
            float \u0445\u0445L\u0445LL\u0445L\u0445L\u0445LLL = 11.0f;
            Color LL\u0445\u0445LL\u0445L\u0445L\u0445LLL = new Color(25, 25, 25, 150);
            RectHelper.drawRectBetter(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX(), L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY(), 160.0, 48.0, LL\u0445\u0445LL\u0445L\u0445L\u0445LLL.getRGB());
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            mc.getTextureManager().bindTexture(((EntityOtherPlayerMP)LLLLL\u0445\u0445L\u0445L\u0445LLL).getLocationSkin());
            Gui.drawScaledCustomSizeModalRect(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX(), L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY(), 8.0f, 8.0f, 8.0f, 8.0f, 48.0f, 48.0f, 64.0f, 64.0f);
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font.drawStringWithShadow(LLLLL\u0445\u0445L\u0445L\u0445LLL.getName(), (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 48.0f + 5.0f, L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 10, -1);
            if (!LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItemMainhand().isEmpty()) {
                GL11.glPushMatrix();
                GL11.glScalef(0.5f, 0.5f, 1.0f);
                mc.getRenderItem().renderItemAndEffectIntoGUI(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItemMainhand(), (int)(((float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 48.0f + 5.0f) / 0.5f), (int)((float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 10 + L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font.getFontHeight() + 3) / 0.5f));
                GL11.glPopMatrix();
                L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font.drawStringWithShadow(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItemMainhand().getCount() + "x", (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 48.0f + 5.0f + 8.0f + 2.5f, (float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 10 + L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font.getFontHeight()) + 4.25f, -1);
            }
            if (!LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItemOffhand().isEmpty()) {
                float LLL\u0445LL\u0445L\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItemMainhand().isEmpty() ? 0.0f : 30.0f;
                GL11.glPushMatrix();
                GL11.glScalef(0.5f, 0.5f, 1.0f);
                mc.getRenderItem().renderItemAndEffectIntoGUI(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItemOffhand(), (int)(((float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 48.0f + 5.0f + LLL\u0445LL\u0445L\u0445L\u0445LLL) / 0.5f), (int)((float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 10 + L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font.getFontHeight() + 3) / 0.5f));
                GL11.glPopMatrix();
                L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font.drawStringWithShadow(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHeldItemOffhand().getCount() + "x", (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 48.0f + 5.0f + 8.0f + 2.5f + LLL\u0445LL\u0445L\u0445L\u0445LLL, (float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 10 + L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font.getFontHeight()) + 4.25f, -1);
            }
            RectHelper.drawRectBetter((float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 48.0f + 5.0f, (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 48.0f - 6.0f - 11.0f, 102.0, 11.0, LL\u0445\u0445LL\u0445L\u0445L\u0445LLL.getRGB());
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font.drawCenteredStringWithShadow(Double.toString(Math.round(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() * 10.0f) / 10), (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 48.0f + 5.0f + 51.0f, (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 48.0f - 6.0f - 5.5f - 2.5f, -1);
            RectHelper.drawRectBetter((float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 48.0f + 5.0f, (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 48.0f - 6.0f - 11.0f, 102.0f * (LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() / LLLLL\u0445\u0445L\u0445L\u0445LLL.getMaxHealth()), 11.0, -1);
        } else if (\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.equalsIgnoreCase("Akrien") && LLLLL\u0445\u0445L\u0445L\u0445LLL instanceof EntityOtherPlayerMP) {
            EntityOtherPlayerMP \u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL = (EntityOtherPlayerMP)LLLLL\u0445\u0445L\u0445L\u0445LLL;
            Color L\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL = new Color(26, 26, 26, 170);
            Color \u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL = new Color(128, 241, 132);
            Color LLLL\u0445L\u0445L\u0445L\u0445LLL = new Color(62, 134, 192);
            float \u0445LLL\u0445L\u0445L\u0445L\u0445LLL = 130.0f;
            float L\u0445LL\u0445L\u0445L\u0445L\u0445LLL = 48.0f;
            float \u0445\u0445LL\u0445L\u0445L\u0445L\u0445LLL = 25.0f;
            float LL\u0445L\u0445L\u0445L\u0445L\u0445LLL = 2.0f;
            RectHelper.drawRectBetter(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX(), L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY(), \u0445LLL\u0445L\u0445L\u0445L\u0445LLL, L\u0445LL\u0445L\u0445L\u0445L\u0445LLL, L\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL.getRGB());
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            mc.getTextureManager().bindTexture(\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL.getLocationSkin());
            Gui.drawScaledCustomSizeModalRect((float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 2.5f, (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 2.5f, 8.0f, 8.0f, 8.0f, 8.0f, \u0445\u0445LL\u0445L\u0445L\u0445L\u0445LLL, \u0445\u0445LL\u0445L\u0445L\u0445L\u0445LLL, 64.0f, 64.0f);
            RectHelper.drawRectBetter((float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 2.5f, (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + \u0445\u0445LL\u0445L\u0445L\u0445L\u0445LLL + 8.0f, (\u0445LLL\u0445L\u0445L\u0445L\u0445LLL - 5.0f) * (\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL.getHealth() / \u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL.getMaxHealth()), LL\u0445L\u0445L\u0445L\u0445L\u0445LLL, L\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL.getRGB());
            RectHelper.drawGradientRectBetter((float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 2.5f, (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + \u0445\u0445LL\u0445L\u0445L\u0445L\u0445LLL + 8.0f, (\u0445LLL\u0445L\u0445L\u0445L\u0445LLL - 5.0f) * (\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL.getHealth() / \u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL.getMaxHealth()), LL\u0445L\u0445L\u0445L\u0445L\u0445LLL, \u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL.getRGB() - -536870912, \u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL.getRGB());
            RectHelper.drawRectBetter((float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 2.5f, (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + \u0445\u0445LL\u0445L\u0445L\u0445L\u0445LLL + 16.0f, (\u0445LLL\u0445L\u0445L\u0445L\u0445LLL - 5.0f) * (\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL.getHealth() / \u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL.getMaxHealth()), LL\u0445L\u0445L\u0445L\u0445L\u0445LLL, L\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL.getRGB());
            RectHelper.drawGradientRectBetter((float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 2.5f, (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + \u0445\u0445LL\u0445L\u0445L\u0445L\u0445LLL + 16.0f, (\u0445LLL\u0445L\u0445L\u0445L\u0445LLL - 5.0f) * ((float)\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL.getTotalArmorValue() / 20.0f), LL\u0445L\u0445L\u0445L\u0445L\u0445LLL, LLLL\u0445L\u0445L\u0445L\u0445LLL.getRGB() - -536870912, LLLL\u0445L\u0445L\u0445L\u0445LLL.getRGB());
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font24.drawStringWithShadow(\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL.getName(), (float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 8) + \u0445\u0445LL\u0445L\u0445L\u0445L\u0445LLL, (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 3.5f, -1);
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font20.drawStringWithShadow("Health: " + Math.round(LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() * 10.0f) / 10, (float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 8) + \u0445\u0445LL\u0445L\u0445L\u0445L\u0445LLL, (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + 0.2f + (float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font24.getFontHeight() + L\u0445LL\u0445L\u0445L\u0445L\u0445LLL / 7.0f, -1);
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font20.drawStringWithShadow("Distance: " + Math.round(TargetHUDComponent.mc.player.getDistanceToEntity(\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL) * 10.0f) / 10, (float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 8) + \u0445\u0445LL\u0445L\u0445L\u0445L\u0445LLL, (float)(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() + L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.font24.getFontHeight() * 2) + 0.3f + L\u0445LL\u0445L\u0445L\u0445L\u0445LLL / 10.0f + 2.0f, -1);
        } else if (\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.equalsIgnoreCase("Celestial") && LLLLL\u0445\u0445L\u0445L\u0445LLL instanceof EntityOtherPlayerMP) {
            if (LLLLL\u0445\u0445L\u0445L\u0445LLL == null) {
                return;
            }
            if (LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth() < 0.0f) {
                return;
            }
            EntityOtherPlayerMP \u0445L\u0445L\u0445L\u0445L\u0445L\u0445LLL = (EntityOtherPlayerMP)LLLLL\u0445\u0445L\u0445L\u0445LLL;
            float L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() - 127;
            float \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY();
            float LLL\u0445\u0445L\u0445L\u0445L\u0445LLL = 28.0f;
            RectHelper.drawRectBetter(L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 125.0f, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL - 25.0f, 151.0, 50.0, new Color(26, 26, 26, 170).getRGB());
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            mc.getTextureManager().bindTexture(\u0445L\u0445L\u0445L\u0445L\u0445L\u0445LLL.getLocationSkin());
            Gui.drawScaledCustomSizeModalRect((float)L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getX() + 0.5f, L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.getY() - 11 + 5, 8.0f, 8.0f, 8.0f, 8.0f, LLL\u0445\u0445L\u0445L\u0445L\u0445LLL, LLL\u0445\u0445L\u0445L\u0445L\u0445LLL, 64.0f, 64.0f);
            float \u0445LL\u0445\u0445L\u0445L\u0445L\u0445LLL = LLLLL\u0445\u0445L\u0445L\u0445LLL.getHealth();
            double L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LLL = \u0445LL\u0445\u0445L\u0445L\u0445L\u0445LLL / LLLLL\u0445\u0445L\u0445L\u0445LLL.getMaxHealth();
            L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LLL = MathHelper.clamp(L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LLL, 0.0, 1.0);
            double \u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LLL = 110.0 * L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LLL;
            L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth = (float)MathHelper.clampedLerp(L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth, (float)\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445LLL, 7.0f * mc.getRenderPartialTicks());
            RectHelper.drawRect((double)L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 127.5, (double)\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL - 11.5, L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 273.0f, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL - 11.0f, ClientHelper.getClientColor().getRGB());
            RectHelper.drawSmoothRect(L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 162.0f, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 16.0f, L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 272.0f, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 21.0f, new Color(26, 26, 26, 170).getRGB());
            RectHelper.drawSmoothRect(L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 162.0f, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 16.0f, L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 162.0f + L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL.healthBarWidth, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 21.0f, ClientHelper.getClientColor().getRGB());
            TargetHUDComponent.mc.sfuiFontRender.drawStringWithShadow("Ground: " + LLLLL\u0445\u0445L\u0445L\u0445LLL.onGround, L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 162.0f, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL - 3.0f, -1);
            TargetHUDComponent.mc.sfuiFontRender.drawStringWithShadow("HurtTime", L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 162.5f, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 7.0f, -1);
            TargetHUDComponent.mc.sfuiFontRender.drawCenteredString(LLLLL\u0445\u0445L\u0445L\u0445LLL.getName(), (float)((double)L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 200.71942446043167), \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL - 19.5f, -1);
            RectHelper.drawRect(L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 217.0f, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 9.0f, L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 270.0f, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 11.0f, new Color(26, 26, 26, 170).getRGB());
            double LL\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL = MathHelper.clamp((double)LLLLL\u0445\u0445L\u0445L\u0445LLL.hurtTime, 1.0, 0.3);
            double \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL = 53.0 * LL\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL;
            RectHelper.drawRectBetter(L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 217.0f, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 9.0f, \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LLL, 2.0, ClientHelper.getClientColor().getRGB());
            RectHelper.drawSmoothRect((float)((double)L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 125.5), \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL - 25.0f, L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL + 275.0f, \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL - 24.0f, ClientHelper.getClientColor().getRGB());
        }
        super.draw();
    }

    public static float getRenderHurtTime(EntityLivingBase L\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL) {
        return (float)L\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL.hurtTime - (L\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL.hurtTime != 0 ? TargetHUDComponent.mc.timer.renderPartialTicks : 0.0f);
    }

    public static float getHurtPercent(EntityLivingBase \u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL) {
        return TargetHUDComponent.getRenderHurtTime(\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL) / 10.0f;
    }
}

