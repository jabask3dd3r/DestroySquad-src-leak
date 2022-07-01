/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class AutoArmor
extends Feature {
    public static BooleanSetting openInventory;
    private final NumberSetting delay;
    public TimerHelper timerUtils = new TimerHelper();

    public AutoArmor() {
        super("AutoArmor", "Automatics clothes armor", Type.Combat);
        AutoArmor \u0445LLLLLL\u0445LLLL\u0445L;
        \u0445LLLLLL\u0445LLLL\u0445L.delay = new NumberSetting("Equip Delay", 1.0f, 0.0f, 10.0f, 1.0f, () -> true);
        openInventory = new BooleanSetting("Open Inventory", true, () -> true);
        \u0445LLLLLL\u0445LLLL\u0445L.addSettings(\u0445LLLLLL\u0445LLLL\u0445L.delay, openInventory);
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445\u0445L\u0445\u0445LL\u0445LLLL\u0445L) {
        block12: {
            AutoArmor L\u0445L\u0445\u0445LL\u0445LLLL\u0445L;
            L\u0445L\u0445\u0445LL\u0445LLLL\u0445L.setSuffix("" + L\u0445L\u0445\u0445LL\u0445LLLL\u0445L.delay.getNumberValue());
            if (!(AutoArmor.mc.currentScreen instanceof GuiInventory) && openInventory.getBoolValue()) {
                return;
            }
            if (AutoArmor.mc.currentScreen instanceof GuiContainer && !(AutoArmor.mc.currentScreen instanceof InventoryEffectRenderer)) {
                return;
            }
            InventoryPlayer LL\u0445\u0445\u0445LL\u0445LLLL\u0445L = AutoArmor.mc.player.inventory;
            int[] \u0445L\u0445\u0445\u0445LL\u0445LLLL\u0445L = new int[4];
            int[] L\u0445\u0445\u0445\u0445LL\u0445LLLL\u0445L = new int[4];
            int \u0445LLL\u0445LL\u0445LLLL\u0445L = 0;
            if (\u0445LLL\u0445LL\u0445LLLL\u0445L < 4) {
                \u0445L\u0445\u0445\u0445LL\u0445LLLL\u0445L[\u0445LLL\u0445LL\u0445LLLL\u0445L] = -1;
                ItemStack LLLL\u0445LL\u0445LLLL\u0445L = LL\u0445\u0445\u0445LL\u0445LLLL\u0445L.armorItemInSlot(\u0445LLL\u0445LL\u0445LLLL\u0445L);
                if (LLLL\u0445LL\u0445LLLL\u0445L != null && LLLL\u0445LL\u0445LLLL\u0445L.getItem() instanceof ItemArmor) {
                    ItemArmor \u0445\u0445\u0445\u0445LLL\u0445LLLL\u0445L = (ItemArmor)LLLL\u0445LL\u0445LLLL\u0445L.getItem();
                    L\u0445\u0445\u0445\u0445LL\u0445LLLL\u0445L[\u0445LLL\u0445LL\u0445LLLL\u0445L] = L\u0445L\u0445\u0445LL\u0445LLLL\u0445L.getArmorValue(\u0445\u0445\u0445\u0445LLL\u0445LLLL\u0445L, LLLL\u0445LL\u0445LLLL\u0445L);
                }
                ++\u0445LLL\u0445LL\u0445LLLL\u0445L;
                return;
            }
            int L\u0445\u0445L\u0445LL\u0445LLLL\u0445L = 0;
            if (L\u0445\u0445L\u0445LL\u0445LLLL\u0445L < 36) {
                ItemStack \u0445L\u0445L\u0445LL\u0445LLLL\u0445L = LL\u0445\u0445\u0445LL\u0445LLLL\u0445L.getStackInSlot(L\u0445\u0445L\u0445LL\u0445LLLL\u0445L);
                if (\u0445L\u0445L\u0445LL\u0445LLLL\u0445L != null && \u0445L\u0445L\u0445LL\u0445LLLL\u0445L.getItem() instanceof ItemArmor) {
                    ItemArmor L\u0445LL\u0445LL\u0445LLLL\u0445L = (ItemArmor)\u0445L\u0445L\u0445LL\u0445LLLL\u0445L.getItem();
                    int \u0445\u0445LL\u0445LL\u0445LLLL\u0445L = L\u0445LL\u0445LL\u0445LLLL\u0445L.armorType.getIndex();
                    int LL\u0445L\u0445LL\u0445LLLL\u0445L = L\u0445L\u0445\u0445LL\u0445LLLL\u0445L.getArmorValue(L\u0445LL\u0445LL\u0445LLLL\u0445L, \u0445L\u0445L\u0445LL\u0445LLLL\u0445L);
                    if (LL\u0445L\u0445LL\u0445LLLL\u0445L > L\u0445\u0445\u0445\u0445LL\u0445LLLL\u0445L[\u0445\u0445LL\u0445LL\u0445LLLL\u0445L]) {
                        \u0445L\u0445\u0445\u0445LL\u0445LLLL\u0445L[\u0445\u0445LL\u0445LL\u0445LLLL\u0445L] = L\u0445\u0445L\u0445LL\u0445LLLL\u0445L;
                        L\u0445\u0445\u0445\u0445LL\u0445LLLL\u0445L[\u0445\u0445LL\u0445LL\u0445LLLL\u0445L] = LL\u0445L\u0445LL\u0445LLLL\u0445L;
                    }
                }
                ++L\u0445\u0445L\u0445LL\u0445LLLL\u0445L;
                return;
            }
            ArrayList<Integer> \u0445\u0445\u0445\u0445\u0445LL\u0445LLLL\u0445L = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3));
            Collections.shuffle(\u0445\u0445\u0445\u0445\u0445LL\u0445LLLL\u0445L);
            Iterator<Integer> iterator = \u0445\u0445\u0445\u0445\u0445LL\u0445LLLL\u0445L.iterator();
            if (!iterator.hasNext()) break block12;
            int \u0445LL\u0445\u0445LL\u0445LLLL\u0445L = iterator.next();
            int \u0445\u0445\u0445L\u0445LL\u0445LLLL\u0445L = \u0445L\u0445\u0445\u0445LL\u0445LLLL\u0445L[\u0445LL\u0445\u0445LL\u0445LLLL\u0445L];
            if (\u0445\u0445\u0445L\u0445LL\u0445LLLL\u0445L == -1) {
                return;
            }
            ItemStack LLL\u0445\u0445LL\u0445LLLL\u0445L = LL\u0445\u0445\u0445LL\u0445LLLL\u0445L.armorItemInSlot(\u0445LL\u0445\u0445LL\u0445LLLL\u0445L);
            if (LLL\u0445\u0445LL\u0445LLLL\u0445L != null && LL\u0445\u0445\u0445LL\u0445LLLL\u0445L.getFirstEmptyStack() == -1) {
                return;
            }
            if (\u0445\u0445\u0445L\u0445LL\u0445LLLL\u0445L < 9) {
                \u0445\u0445\u0445L\u0445LL\u0445LLLL\u0445L += 36;
            }
            if (L\u0445L\u0445\u0445LL\u0445LLLL\u0445L.timerUtils.hasReached(L\u0445L\u0445\u0445LL\u0445LLLL\u0445L.delay.getNumberValue() * 100.0f)) {
                if (LLL\u0445\u0445LL\u0445LLLL\u0445L != null) {
                    AutoArmor.mc.playerController.windowClick(0, 8 - \u0445LL\u0445\u0445LL\u0445LLLL\u0445L, 0, ClickType.QUICK_MOVE, AutoArmor.mc.player);
                }
                AutoArmor.mc.playerController.windowClick(0, \u0445\u0445\u0445L\u0445LL\u0445LLLL\u0445L, 0, ClickType.QUICK_MOVE, AutoArmor.mc.player);
                L\u0445L\u0445\u0445LL\u0445LLLL\u0445L.timerUtils.reset();
            }
        }
    }

    private int getArmorValue(ItemArmor \u0445\u0445LL\u0445\u0445L\u0445LLLL\u0445L, ItemStack LL\u0445L\u0445\u0445L\u0445LLLL\u0445L) {
        int \u0445L\u0445L\u0445\u0445L\u0445LLLL\u0445L = \u0445\u0445LL\u0445\u0445L\u0445LLLL\u0445L.damageReduceAmount;
        int L\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L = 0;
        int \u0445\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L = (int)\u0445\u0445LL\u0445\u0445L\u0445LLLL\u0445L.toughness;
        int LLL\u0445\u0445\u0445L\u0445LLLL\u0445L = \u0445\u0445LL\u0445\u0445L\u0445LLLL\u0445L.getArmorMaterial().getDamageReductionAmount(EntityEquipmentSlot.LEGS);
        Enchantment \u0445LL\u0445\u0445\u0445L\u0445LLLL\u0445L = Enchantments.PROTECTION;
        int L\u0445L\u0445\u0445\u0445L\u0445LLLL\u0445L = EnchantmentHelper.getEnchantmentLevel(\u0445LL\u0445\u0445\u0445L\u0445LLLL\u0445L, LL\u0445L\u0445\u0445L\u0445LLLL\u0445L);
        DamageSource \u0445\u0445L\u0445\u0445\u0445L\u0445LLLL\u0445L = DamageSource.causePlayerDamage(AutoArmor.mc.player);
        L\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L = \u0445LL\u0445\u0445\u0445L\u0445LLLL\u0445L.calcModifierDamage(L\u0445L\u0445\u0445\u0445L\u0445LLLL\u0445L, \u0445\u0445L\u0445\u0445\u0445L\u0445LLLL\u0445L);
        return \u0445L\u0445L\u0445\u0445L\u0445LLLL\u0445L * 5 + L\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L * 3 + \u0445\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L + LLL\u0445\u0445\u0445L\u0445LLLL\u0445L;
    }
}

