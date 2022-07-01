/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.event.events.impl.render.EventRender2D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.player.InventoryHelper;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class AutoTotem
extends Feature {
    public static BooleanSetting definiteHealth;
    public static NumberSetting health;
    public static BooleanSetting countTotem;
    public static BooleanSetting checkCrystal;
    public static BooleanSetting inventoryOnly;
    public static BooleanSetting noMoving;
    public static NumberSetting radiusCrystal;

    public AutoTotem() {
        super("AutoTotem", "Automatically equips a totem at a certain health", Type.Combat);
        AutoTotem L\u0445\u0445\u0445LLLLL\u0445\u0445\u0445LLL;
        definiteHealth = new BooleanSetting("Definite Health", false, () -> true);
        health = new NumberSetting("Health Amount", 10.0f, 1.0f, 20.0f, 0.5f, () -> definiteHealth.getBoolValue());
        inventoryOnly = new BooleanSetting("Only Inventory", false, () -> true);
        noMoving = new BooleanSetting("No Moving Swap", false, () -> true);
        countTotem = new BooleanSetting("Count Totem", true, () -> true);
        checkCrystal = new BooleanSetting("Check Crystal", true, () -> true);
        radiusCrystal = new NumberSetting("Distance to Crystal", 6.0f, 1.0f, 8.0f, 1.0f, () -> checkCrystal.getBoolValue());
        L\u0445\u0445\u0445LLLLL\u0445\u0445\u0445LLL.addSettings(definiteHealth, health, inventoryOnly, noMoving, countTotem, checkCrystal, radiusCrystal);
    }

    private int fountTotemCount() {
        int L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL = 0;
        int LL\u0445L\u0445LLLL\u0445\u0445\u0445LLL = 0;
        if (LL\u0445L\u0445LLLL\u0445\u0445\u0445LLL < AutoTotem.mc.player.inventory.getSizeInventory()) {
            ItemStack \u0445\u0445LL\u0445LLLL\u0445\u0445\u0445LLL = AutoTotem.mc.player.inventory.getStackInSlot(LL\u0445L\u0445LLLL\u0445\u0445\u0445LLL);
            if (\u0445\u0445LL\u0445LLLL\u0445\u0445\u0445LLL.getItem() == Items.TOTEM_OF_UNDYING) {
                ++L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL;
            }
            ++LL\u0445L\u0445LLLL\u0445\u0445\u0445LLL;
            return 0;
        }
        return L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL;
    }

    @EventTarget
    public void onRender2D(EventRender2D \u0445\u0445\u0445LL\u0445LLL\u0445\u0445\u0445LLL) {
        AutoTotem L\u0445\u0445LL\u0445LLL\u0445\u0445\u0445LLL;
        if (L\u0445\u0445LL\u0445LLL\u0445\u0445\u0445LLL.fountTotemCount() > 0 && countTotem.getBoolValue()) {
            AutoTotem.mc.sfuiFontRender.drawStringWithShadow(L\u0445\u0445LL\u0445LLL\u0445\u0445\u0445LLL.fountTotemCount() + "", (float)\u0445\u0445\u0445LL\u0445LLL\u0445\u0445\u0445LLL.getResolution().getScaledWidth() / 2.0f + 19.0f, (float)\u0445\u0445\u0445LL\u0445LLL\u0445\u0445\u0445LLL.getResolution().getScaledHeight() / 2.0f, -1);
            int \u0445L\u0445LL\u0445LLL\u0445\u0445\u0445LLL = 0;
            if (\u0445L\u0445LL\u0445LLL\u0445\u0445\u0445LLL < AutoTotem.mc.player.inventory.getSizeInventory()) {
                ItemStack LL\u0445LL\u0445LLL\u0445\u0445\u0445LLL = AutoTotem.mc.player.inventory.getStackInSlot(\u0445L\u0445LL\u0445LLL\u0445\u0445\u0445LLL);
                if (LL\u0445LL\u0445LLL\u0445\u0445\u0445LLL.getItem() == Items.TOTEM_OF_UNDYING) {
                    GlStateManager.pushMatrix();
                    GlStateManager.disableBlend();
                    mc.getRenderItem().renderItemAndEffectIntoGUI(LL\u0445LL\u0445LLL\u0445\u0445\u0445LLL, \u0445\u0445\u0445LL\u0445LLL\u0445\u0445\u0445LLL.getResolution().getScaledWidth() / 2 + 4, \u0445\u0445\u0445LL\u0445LLL\u0445\u0445\u0445LLL.getResolution().getScaledHeight() / 2 - 7);
                    GlStateManager.popMatrix();
                }
                ++\u0445L\u0445LL\u0445LLL\u0445\u0445\u0445LLL;
                return;
            }
        }
    }

    @EventTarget
    public void onUpdate(EventUpdate L\u0445\u0445\u0445L\u0445LLL\u0445\u0445\u0445LLL) {
        AutoTotem \u0445L\u0445\u0445L\u0445LLL\u0445\u0445\u0445LLL;
        if (noMoving.getBoolValue() && MovementHelper.isMoving()) {
            return;
        }
        if (inventoryOnly.getBoolValue() && !(AutoTotem.mc.currentScreen instanceof GuiInventory)) {
            return;
        }
        if (definiteHealth.getBoolValue() && AutoTotem.mc.player.getHealth() > health.getNumberValue()) {
            return;
        }
        if (AutoTotem.mc.player.getHeldItemOffhand().getItem() != Items.TOTEM_OF_UNDYING && InventoryHelper.getTotemAtHotbar() != -1) {
            AutoTotem.mc.playerController.windowClick(0, InventoryHelper.getTotemAtHotbar(), 1, ClickType.PICKUP, AutoTotem.mc.player);
            AutoTotem.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP, AutoTotem.mc.player);
        }
        if (\u0445L\u0445\u0445L\u0445LLL\u0445\u0445\u0445LLL != false && checkCrystal.getBoolValue() && AutoTotem.mc.player.getHeldItemOffhand().getItem() != Items.TOTEM_OF_UNDYING && InventoryHelper.getTotemAtHotbar() != -1) {
            AutoTotem.mc.playerController.windowClick(0, InventoryHelper.getTotemAtHotbar(), 1, ClickType.PICKUP, AutoTotem.mc.player);
            AutoTotem.mc.playerController.windowClick(0, 45, 1, ClickType.PICKUP, AutoTotem.mc.player);
        }
    }
}

