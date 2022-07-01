/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.misc.NameProtected;
import org.Destroy.client.helpers.math.MathematicHelper;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.lwjgl.opengl.GL11;

public class NameTags
extends Feature {
    public BooleanSetting armor;
    public BooleanSetting backGround;
    public NumberSetting opacity;
    public NumberSetting size;
    public ListSetting hpMode = new ListSetting("Health Mode", "HP", () -> true, "HP", "Percentage");

    public NameTags() {
        super("NameTags", "Shows players, nickname, armor and their health through walls", Type.Visuals);
        NameTags L\u0445L\u0445LLLL\u0445LL\u0445\u0445L;
        L\u0445L\u0445LLLL\u0445LL\u0445\u0445L.size = new NumberSetting("NameTags Size", 0.8f, 0.2f, 2.0f, 0.01f, () -> true);
        L\u0445L\u0445LLLL\u0445LL\u0445\u0445L.backGround = new BooleanSetting("NameTags Background", true, () -> true);
        L\u0445L\u0445LLLL\u0445LL\u0445\u0445L.opacity = new NumberSetting("Background Opacity", 120.0f, 0.0f, 255.0f, 10.0f, () -> {
            NameTags \u0445LL\u0445LLLLL\u0445L\u0445\u0445L;
            return \u0445LL\u0445LLLLL\u0445L\u0445\u0445L.backGround.getBoolValue();
        });
        L\u0445L\u0445LLLL\u0445LL\u0445\u0445L.armor = new BooleanSetting("Show Armor", true, () -> true);
        L\u0445L\u0445LLLL\u0445LL\u0445\u0445L.addSettings(L\u0445L\u0445LLLL\u0445LL\u0445\u0445L.hpMode, L\u0445L\u0445LLLL\u0445LL\u0445\u0445L.size, L\u0445L\u0445LLLL\u0445LL\u0445\u0445L.backGround, L\u0445L\u0445LLLL\u0445LL\u0445\u0445L.opacity, L\u0445L\u0445LLLL\u0445LL\u0445\u0445L.armor);
    }

    @EventTarget
    public void onRender3d(EventRender3D \u0445LLL\u0445L\u0445L\u0445LL\u0445\u0445L) {
        Iterator \u0445\u0445\u0445L\u0445L\u0445L\u0445LL\u0445\u0445L = NameTags.mc.world.playerEntities.iterator();
        if (\u0445\u0445\u0445L\u0445L\u0445L\u0445LL\u0445\u0445L.hasNext()) {
            EntityPlayer L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L = (EntityPlayer)\u0445\u0445\u0445L\u0445L\u0445L\u0445LL\u0445\u0445L.next();
            if (L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L != null) {
                String L\u0445\u0445LLL\u0445L\u0445LL\u0445\u0445L;
                NameTags LLLL\u0445L\u0445L\u0445LL\u0445\u0445L;
                String L\u0445LLLL\u0445L\u0445LL\u0445\u0445L;
                double \u0445L\u0445\u0445\u0445\u0445LL\u0445LL\u0445\u0445L = L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.lastTickPosX + (L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.posX - L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.lastTickPosX) * (double)\u0445LLL\u0445L\u0445L\u0445LL\u0445\u0445L.getPartialTicks() - NameTags.mc.getRenderManager().renderPosX;
                double \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445\u0445L = L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.lastTickPosY + (L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.posY - L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.lastTickPosY) * (double)\u0445LLL\u0445L\u0445L\u0445LL\u0445\u0445L.getPartialTicks() - NameTags.mc.getRenderManager().renderPosY;
                double LLLLLL\u0445L\u0445LL\u0445\u0445L = L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.lastTickPosZ + (L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.posZ - L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.lastTickPosZ) * (double)\u0445LLL\u0445L\u0445L\u0445LL\u0445\u0445L.getPartialTicks() - NameTags.mc.getRenderManager().renderPosZ;
                if (Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.otherNames.getBoolValue()) {
                    String \u0445LL\u0445\u0445\u0445LL\u0445LL\u0445\u0445L = "Protected";
                } else if (Destroy.instance.friendManager.isFriend(L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.getName())) {
                    String \u0445\u0445L\u0445\u0445\u0445LL\u0445LL\u0445\u0445L = (Object)((Object)ChatFormatting.GREEN) + "[F] " + (Object)((Object)ChatFormatting.RESET) + L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.getDisplayName().getUnformattedText();
                } else {
                    L\u0445LLLL\u0445L\u0445LL\u0445\u0445L = L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.getDisplayName().getUnformattedText();
                }
                \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445\u0445L += (double)(L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.isSneaking() ? 0.5f : 0.7f);
                float LL\u0445LLL\u0445L\u0445LL\u0445\u0445L = Math.min(Math.max(1.2f * (NameTags.mc.player.getDistanceToEntity(L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L) * 0.15f), 1.25f), 6.0f) * 0.015f;
                int \u0445L\u0445LLL\u0445L\u0445LL\u0445\u0445L = (int)L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.getHealth();
                if ((float)\u0445L\u0445LLL\u0445L\u0445LL\u0445\u0445L <= L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.getMaxHealth() * 0.25f) {
                    L\u0445LLLL\u0445L\u0445LL\u0445\u0445L = L\u0445LLLL\u0445L\u0445LL\u0445\u0445L + "\u00a74";
                } else if ((float)\u0445L\u0445LLL\u0445L\u0445LL\u0445\u0445L <= L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.getMaxHealth() * 0.5f) {
                    L\u0445LLLL\u0445L\u0445LL\u0445\u0445L = L\u0445LLLL\u0445L\u0445LL\u0445\u0445L + "\u00a76";
                } else if ((float)\u0445L\u0445LLL\u0445L\u0445LL\u0445\u0445L <= L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.getMaxHealth() * 0.75f) {
                    L\u0445LLLL\u0445L\u0445LL\u0445\u0445L = L\u0445LLLL\u0445L\u0445LL\u0445\u0445L + "\u00a7e";
                } else if ((float)\u0445L\u0445LLL\u0445L\u0445LL\u0445\u0445L <= L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.getMaxHealth()) {
                    L\u0445LLLL\u0445L\u0445LL\u0445\u0445L = L\u0445LLLL\u0445L\u0445LL\u0445\u0445L + "\u00a72";
                }
                if (LLLL\u0445L\u0445L\u0445LL\u0445\u0445L.hpMode.currentMode.equals("Percentage")) {
                    String LL\u0445\u0445\u0445\u0445LL\u0445LL\u0445\u0445L = MathematicHelper.round(L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.getHealth() / L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.getMaxHealth() * 100.0f, 1) + "% ";
                } else {
                    L\u0445\u0445LLL\u0445L\u0445LL\u0445\u0445L = MathematicHelper.round(L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L.getHealth(), 1) + " ";
                }
                L\u0445LLLL\u0445L\u0445LL\u0445\u0445L = L\u0445LLLL\u0445L\u0445LL\u0445\u0445L + " " + L\u0445\u0445LLL\u0445L\u0445LL\u0445\u0445L;
                float \u0445LL\u0445LL\u0445L\u0445LL\u0445\u0445L = LL\u0445LLL\u0445L\u0445LL\u0445\u0445L;
                \u0445LL\u0445LL\u0445L\u0445LL\u0445\u0445L *= LLLL\u0445L\u0445L\u0445LL\u0445\u0445L.size.getNumberValue();
                GL11.glPushMatrix();
                GL11.glTranslatef((float)\u0445L\u0445\u0445\u0445\u0445LL\u0445LL\u0445\u0445L, (float)\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445\u0445L + 1.4f, (float)LLLLLL\u0445L\u0445LL\u0445\u0445L);
                GL11.glNormal3f(1.0f, 1.0f, 1.0f);
                float L\u0445L\u0445LL\u0445L\u0445LL\u0445\u0445L = NameTags.mc.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f;
                GL11.glRotatef(-NameTags.mc.getRenderManager().playerViewY, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(NameTags.mc.getRenderManager().playerViewX, L\u0445L\u0445LL\u0445L\u0445LL\u0445\u0445L, 0.0f, 0.0f);
                GL11.glScalef(-\u0445LL\u0445LL\u0445L\u0445LL\u0445\u0445L, -\u0445LL\u0445LL\u0445L\u0445LL\u0445\u0445L, \u0445LL\u0445LL\u0445L\u0445LL\u0445\u0445L);
                GL11.glDisable(2929);
                int LL\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L = NameTags.mc.fontRendererObj.getStringWidth(L\u0445LLLL\u0445L\u0445LL\u0445\u0445L) / 2;
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                if (LLLL\u0445L\u0445L\u0445LL\u0445\u0445L.backGround.getBoolValue()) {
                    RectHelper.drawRect(-LL\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L - 2, -(NameTags.mc.fontRendererObj.FONT_HEIGHT + 1), LL\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L + 2, 2.0, PaletteHelper.getColor(0, (int)LLLL\u0445L\u0445L\u0445LL\u0445\u0445L.opacity.getNumberValue()));
                }
                ClientHelper.getFontRender().drawStringWithShadow(L\u0445LLLL\u0445L\u0445LL\u0445\u0445L, MathematicHelper.getMiddle(-LL\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L - 2, LL\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L + 2) - LL\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L, -(NameTags.mc.fontRendererObj.FONT_HEIGHT - 1), Color.WHITE.getRGB());
                if (LLLL\u0445L\u0445L\u0445LL\u0445\u0445L.armor.getBoolValue()) {
                    LLLL\u0445L\u0445L\u0445LL\u0445\u0445L.renderArmor(L\u0445\u0445\u0445LL\u0445L\u0445LL\u0445\u0445L, 0, -(NameTags.mc.fontRendererObj.FONT_HEIGHT + 1) - 20);
                }
                GL11.glEnable(2929);
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
            return;
        }
    }

    public void renderArmor(EntityPlayer \u0445L\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L, int \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L, int LLLLL\u0445L\u0445\u0445LL\u0445\u0445L) {
        InventoryPlayer L\u0445LLL\u0445L\u0445\u0445LL\u0445\u0445L = \u0445L\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L.inventory;
        ItemStack LL\u0445LL\u0445L\u0445\u0445LL\u0445\u0445L = \u0445L\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L.getHeldItemOffhand();
        ItemStack L\u0445\u0445LL\u0445L\u0445\u0445LL\u0445\u0445L = \u0445L\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L.getHeldItemMainhand();
        ItemStack LLL\u0445L\u0445L\u0445\u0445LL\u0445\u0445L = L\u0445LLL\u0445L\u0445\u0445LL\u0445\u0445L.armorItemInSlot(0);
        ItemStack \u0445LL\u0445L\u0445L\u0445\u0445LL\u0445\u0445L = L\u0445LLL\u0445L\u0445\u0445LL\u0445\u0445L.armorItemInSlot(1);
        ItemStack \u0445\u0445L\u0445L\u0445L\u0445\u0445LL\u0445\u0445L = L\u0445LLL\u0445L\u0445\u0445LL\u0445\u0445L.armorItemInSlot(2);
        ItemStack \u0445L\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445L = L\u0445LLL\u0445L\u0445\u0445LL\u0445\u0445L.armorItemInSlot(3);
        ItemStack[] \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445L = new ItemStack[]{LL\u0445LL\u0445L\u0445\u0445LL\u0445\u0445L, L\u0445\u0445LL\u0445L\u0445\u0445LL\u0445\u0445L, \u0445L\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445L, \u0445\u0445L\u0445L\u0445L\u0445\u0445LL\u0445\u0445L, \u0445LL\u0445L\u0445L\u0445\u0445LL\u0445\u0445L, LLL\u0445L\u0445L\u0445\u0445LL\u0445\u0445L};
        ArrayList<ItemStack> LLLL\u0445\u0445L\u0445\u0445LL\u0445\u0445L = new ArrayList<ItemStack>();
        ItemStack[] L\u0445LL\u0445\u0445L\u0445\u0445LL\u0445\u0445L = \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445L;
        int LLL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L = 0;
        int \u0445\u0445LL\u0445\u0445L\u0445\u0445LL\u0445\u0445L = \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445L.length;
        if (LLL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L < \u0445\u0445LL\u0445\u0445L\u0445\u0445LL\u0445\u0445L) {
            ItemStack L\u0445\u0445L\u0445LL\u0445\u0445LL\u0445\u0445L = L\u0445LL\u0445\u0445L\u0445\u0445LL\u0445\u0445L[LLL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L];
            if (L\u0445\u0445L\u0445LL\u0445\u0445LL\u0445\u0445L != null) {
                L\u0445\u0445L\u0445LL\u0445\u0445LL\u0445\u0445L.getItem();
                LLLL\u0445\u0445L\u0445\u0445LL\u0445\u0445L.add(L\u0445\u0445L\u0445LL\u0445\u0445LL\u0445\u0445L);
            }
            ++LLL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L;
            return;
        }
        int LL\u0445L\u0445\u0445L\u0445\u0445LL\u0445\u0445L = 18 * LLLL\u0445\u0445L\u0445\u0445LL\u0445\u0445L.size() / 2;
        \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L -= LL\u0445L\u0445\u0445L\u0445\u0445LL\u0445\u0445L;
        GlStateManager.disableDepth();
        Iterator iterator = LLLL\u0445\u0445L\u0445\u0445LL\u0445\u0445L.iterator();
        if (iterator.hasNext()) {
            NameTags \u0445\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L;
            ItemStack \u0445LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L = (ItemStack)iterator.next();
            \u0445\u0445L\u0445\u0445LL\u0445\u0445LL\u0445\u0445L.renderItem(\u0445L\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L, \u0445LL\u0445\u0445LL\u0445\u0445LL\u0445\u0445L, \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L, LLLLL\u0445L\u0445\u0445LL\u0445\u0445L);
            \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445L += 18;
            return;
        }
        GlStateManager.enableDepth();
    }

    public void renderItem(EntityPlayer \u0445\u0445LLL\u0445\u0445\u0445\u0445LL\u0445\u0445L, ItemStack \u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L, int L\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L, int \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L) {
        if (\u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L != null) {
            NameTags \u0445LLLL\u0445\u0445\u0445\u0445LL\u0445\u0445L;
            RenderItem LLLLL\u0445\u0445\u0445\u0445LL\u0445\u0445L = mc.getRenderItem();
            GlStateManager.pushMatrix();
            GlStateManager.translate(L\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L - 3, \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L + 10, 0.0f);
            GlStateManager.popMatrix();
            LLLLL\u0445\u0445\u0445\u0445LL\u0445\u0445L.zLevel = -100.0f;
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GL11.glEnable(3008);
            RenderHelper.enableGUIStandardItemLighting();
            GL11.glDisable(2929);
            LLLLL\u0445\u0445\u0445\u0445LL\u0445\u0445L.renderItemIntoGUI(\u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L, L\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L, \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L);
            LLLLL\u0445\u0445\u0445\u0445LL\u0445\u0445L.renderItemOverlayIntoGUI(ClientHelper.getFontRender(), \u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L, L\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L, \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L + 2, null);
            RenderHelper.disableStandardItemLighting();
            GL11.glEnable(2929);
            LLLLL\u0445\u0445\u0445\u0445LL\u0445\u0445L.zLevel = 0.0f;
            GlStateManager.pushMatrix();
            GL11.glEnable(3008);
            GL11.glDisable(2929);
            \u0445LLLL\u0445\u0445\u0445\u0445LL\u0445\u0445L.renderEnchant(\u0445L\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L, L\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L + 2, \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445LL\u0445\u0445L - 18);
            GL11.glEnable(2929);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
            GlStateManager.disableLighting();
            GlStateManager.popMatrix();
        }
    }

    public void renderEnchant(ItemStack \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L, float LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L, int \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L) {
        int L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L = \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L + 5;
        Map<Enchantment, Integer> \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L = EnchantmentHelper.getEnchantments(\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L);
        Iterator<Enchantment> \u0445L\u0445LLLLLL\u0445L\u0445\u0445L = \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L.keySet().iterator();
        if (\u0445L\u0445LLLLLL\u0445L\u0445\u0445L.hasNext()) {
            Enchantment \u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L = \u0445L\u0445LLLLLL\u0445L\u0445\u0445L.next();
            int LLL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L = EnchantmentHelper.getEnchantmentLevel(\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L, \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L);
            ClientHelper.getFontRender().drawStringWithShadow(String.valueOf(\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L.getName().substring(12).charAt(0)).toUpperCase() + LLL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L, LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L, L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L, 0xFFFFFF);
            L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L -= 12;
            return;
        }
    }
}

