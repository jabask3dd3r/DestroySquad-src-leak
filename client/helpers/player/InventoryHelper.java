/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.player;

import java.util.Objects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import org.Destroy.client.helpers.Helper;

public class InventoryHelper
implements Helper {
    public InventoryHelper() {
        InventoryHelper LLLL\u0445L\u0445L\u0445L\u0445L\u0445LL;
    }

    public static boolean doesHotbarHaveAxe() {
        int \u0445\u0445LL\u0445L\u0445L\u0445L\u0445L\u0445LL = 0;
        if (\u0445\u0445LL\u0445L\u0445L\u0445L\u0445L\u0445LL < 9) {
            InventoryHelper.mc.player.inventory.getStackInSlot(\u0445\u0445LL\u0445L\u0445L\u0445L\u0445L\u0445LL);
            if (InventoryHelper.mc.player.inventory.getStackInSlot(\u0445\u0445LL\u0445L\u0445L\u0445L\u0445L\u0445LL).getItem() instanceof ItemAxe) {
                return true;
            }
            ++\u0445\u0445LL\u0445L\u0445L\u0445L\u0445L\u0445LL;
            return false;
        }
        return false;
    }

    public static boolean doesHotbarHaveBlock() {
        int L\u0445\u0445L\u0445L\u0445L\u0445L\u0445L\u0445LL = 0;
        if (L\u0445\u0445L\u0445L\u0445L\u0445L\u0445L\u0445LL < 9) {
            if (InventoryHelper.mc.player.inventory.getStackInSlot(L\u0445\u0445L\u0445L\u0445L\u0445L\u0445L\u0445LL).getItem() instanceof ItemBlock) {
                return true;
            }
            ++L\u0445\u0445L\u0445L\u0445L\u0445L\u0445L\u0445LL;
            return false;
        }
        return false;
    }

    public static int getAxe() {
        int \u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL = 0;
        if (\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL < 9) {
            ItemStack L\u0445L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL = InventoryHelper.mc.player.inventory.getStackInSlot(\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL);
            if (L\u0445L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL.getItem() instanceof ItemAxe) {
                return \u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL;
            }
            ++\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL;
            return 0;
        }
        return 1;
    }

    public static int findWaterBucket() {
        int \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL = 0;
        if (\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL < 9) {
            InventoryHelper.mc.player.inventory.getStackInSlot(\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL);
            if (InventoryHelper.mc.player.inventory.getStackInSlot(\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL).getItem() == Items.WATER_BUCKET) {
                return \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL;
            }
            ++\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LL;
            return 0;
        }
        return -1;
    }

    public static int getSwordAtHotbar() {
        int LL\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LL = 0;
        if (LL\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LL < 9) {
            ItemStack \u0445\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LL = InventoryHelper.mc.player.inventory.getStackInSlot(LL\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LL);
            if (\u0445\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LL.getItem() instanceof ItemSword) {
                return LL\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LL;
            }
            ++LL\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LL;
            return 0;
        }
        return -1;
    }

    public static int getTotemAtHotbar() {
        int L\u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL = 0;
        if (L\u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL < 45) {
            ItemStack \u0445LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL = InventoryHelper.mc.player.inventoryContainer.getSlot(L\u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL).getStack();
            if (\u0445LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL.getItem() == Items.TOTEM_OF_UNDYING) {
                return L\u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL;
            }
            ++L\u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LL;
            return 0;
        }
        return -1;
    }

    public static boolean isBestArmor(ItemStack \u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL, int L\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL) {
        float \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL = InventoryHelper.getProtection(\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL);
        String LLL\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL = "";
        if (L\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL == 1) {
            LLL\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL = "helmet";
        } else if (L\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL == 2) {
            LLL\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL = "chestplate";
        } else if (L\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL == 3) {
            LLL\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL = "leggings";
        } else if (L\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL == 4) {
            LLL\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL = "boots";
        }
        if (!\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL.getUnlocalizedName().contains(LLL\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL)) {
            return false;
        }
        int LL\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL = 5;
        if (LL\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL < 45) {
            ItemStack \u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445LL;
            if (InventoryHelper.mc.player.inventoryContainer.getSlot(LL\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL).getHasStack() && InventoryHelper.getProtection(\u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445LL = InventoryHelper.mc.player.inventoryContainer.getSlot(LL\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL).getStack()) > \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL && \u0445\u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445LL.getUnlocalizedName().contains(LLL\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL)) {
                return false;
            }
            ++LL\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445LL;
            return false;
        }
        return true;
    }

    public static float getProtection(ItemStack \u0445\u0445LLLLL\u0445\u0445L\u0445L\u0445LL) {
        float LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL = 0.0f;
        if (\u0445\u0445LLLLL\u0445\u0445L\u0445L\u0445LL.getItem() instanceof ItemArmor) {
            ItemArmor L\u0445LLLLL\u0445\u0445L\u0445L\u0445LL = (ItemArmor)\u0445\u0445LLLLL\u0445\u0445L\u0445L\u0445LL.getItem();
            LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL = (float)((double)LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL + ((double)L\u0445LLLLL\u0445\u0445L\u0445L\u0445LL.damageReduceAmount + (double)((100 - L\u0445LLLLL\u0445\u0445L\u0445L\u0445LL.damageReduceAmount) * EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(0)), \u0445\u0445LLLLL\u0445\u0445L\u0445L\u0445LL)) * 0.0075));
            LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL = (float)((double)LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL + (double)EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(3)), \u0445\u0445LLLLL\u0445\u0445L\u0445L\u0445LL) / 100.0);
            LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL = (float)((double)LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL + (double)EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(1)), \u0445\u0445LLLLL\u0445\u0445L\u0445L\u0445LL) / 100.0);
            LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL = (float)((double)LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL + (double)EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(7)), \u0445\u0445LLLLL\u0445\u0445L\u0445L\u0445LL) / 100.0);
            LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL = (float)((double)LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL + (double)EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(34)), \u0445\u0445LLLLL\u0445\u0445L\u0445L\u0445LL) / 50.0);
            LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL = (float)((double)LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL + (double)EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(4)), \u0445\u0445LLLLL\u0445\u0445L\u0445L\u0445LL) / 100.0);
        }
        return LL\u0445LLLL\u0445\u0445L\u0445L\u0445LL;
    }
}

