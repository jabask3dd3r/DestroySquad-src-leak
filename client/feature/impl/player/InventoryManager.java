/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class InventoryManager
extends Feature {
    public static NumberSetting cap;
    public static BooleanSetting archer;
    public static NumberSetting delay1;
    public static BooleanSetting food;
    public static BooleanSetting sword;
    public static BooleanSetting cleaner;
    public static BooleanSetting openinv;
    public static BooleanSetting nomoveswap;
    public static int weaponSlot;
    public static int pickaxeSlot;
    public static int axeSlot;
    public static int shovelSlot;
    public static List<Block> invalidBlocks;
    private final TimerHelper timer = new TimerHelper();

    public InventoryManager() {
        super("InventoryManager", "Clear, sorts inventory for you", Type.Player);
        InventoryManager LL\u0445\u0445LL\u0445L\u0445LLLLL;
        cap = new NumberSetting("Block Cap", 128.0f, 8.0f, 256.0f, 8.0f, () -> true);
        delay1 = new NumberSetting("Sort Delay", 1.0f, 0.0f, 10.0f, 0.1f, () -> true);
        archer = new BooleanSetting("Archer", false, () -> true);
        food = new BooleanSetting("Food", false, () -> true);
        sword = new BooleanSetting("Sword", true, () -> true);
        cleaner = new BooleanSetting("Inv Cleaner", true, () -> true);
        openinv = new BooleanSetting("Open Inv", true, () -> true);
        nomoveswap = new BooleanSetting("No Moving Swap", false, () -> true);
        LL\u0445\u0445LL\u0445L\u0445LLLLL.addSettings(cap, delay1, archer, food, sword, cleaner, openinv, nomoveswap);
    }

    /*
     * Exception decompiling
     */
    @EventTarget
    public void onPreMotion(EventPreMotion \u0445L\u0445L\u0445L\u0445L\u0445LLLLL) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl146 : IINC - null : trying to set 0 previously set to 2
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:207)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1559)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:434)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void swap(int L\u0445\u0445\u0445\u0445L\u0445L\u0445LLLLL, int \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445LLLLL) {
        InventoryManager.mc.playerController.windowClick(InventoryManager.mc.player.inventoryContainer.windowId, L\u0445\u0445\u0445\u0445L\u0445L\u0445LLLLL, \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445LLLLL, ClickType.SWAP, InventoryManager.mc.player);
    }

    public void drop(int LL\u0445LL\u0445\u0445L\u0445LLLLL) {
        InventoryManager.mc.playerController.windowClick(InventoryManager.mc.player.inventoryContainer.windowId, LL\u0445LL\u0445\u0445L\u0445LLLLL, 1, ClickType.THROW, InventoryManager.mc.player);
    }

    public void getBestWeapon(int LL\u0445\u0445\u0445\u0445\u0445L\u0445LLLLL) {
        int L\u0445L\u0445\u0445\u0445\u0445L\u0445LLLLL = 9;
        if (L\u0445L\u0445\u0445\u0445\u0445L\u0445LLLLL < 45) {
            ItemStack \u0445LL\u0445\u0445\u0445\u0445L\u0445LLLLL;
            InventoryManager \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLLLL;
            if (InventoryManager.mc.player.inventoryContainer.getSlot(L\u0445L\u0445\u0445\u0445\u0445L\u0445LLLLL).getHasStack() && \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLLLL < (\u0445LL\u0445\u0445\u0445\u0445L\u0445LLLLL = InventoryManager.mc.player.inventoryContainer.getSlot(L\u0445L\u0445\u0445\u0445\u0445L\u0445LLLLL).getStack()) && \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLLLL.getDamage(\u0445LL\u0445\u0445\u0445\u0445L\u0445LLLLL) > 0.0f && (\u0445LL\u0445\u0445\u0445\u0445L\u0445LLLLL.getItem() instanceof ItemSword || !sword.getBoolValue())) {
                \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLLLL.swap(L\u0445L\u0445\u0445\u0445\u0445L\u0445LLLLL, LL\u0445\u0445\u0445\u0445\u0445L\u0445LLLLL - 36);
                \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLLLL.timer.reset();
            } else {
                ++L\u0445L\u0445\u0445\u0445\u0445L\u0445LLLLL;
                return;
            }
        }
    }

    private float getDamage(ItemStack LLL\u0445LLL\u0445\u0445LLLLL) {
        float \u0445LL\u0445LLL\u0445\u0445LLLLL = 0.0f;
        Item L\u0445L\u0445LLL\u0445\u0445LLLLL = LLL\u0445LLL\u0445\u0445LLLLL.getItem();
        if (L\u0445L\u0445LLL\u0445\u0445LLLLL instanceof ItemTool) {
            ItemTool \u0445L\u0445LLLL\u0445\u0445LLLLL = (ItemTool)L\u0445L\u0445LLL\u0445\u0445LLLLL;
            \u0445LL\u0445LLL\u0445\u0445LLLLL += \u0445L\u0445LLLL\u0445\u0445LLLLL.getDamageVsEntity();
        }
        if (L\u0445L\u0445LLL\u0445\u0445LLLLL instanceof ItemSword) {
            ItemSword L\u0445\u0445LLLL\u0445\u0445LLLLL = (ItemSword)L\u0445L\u0445LLL\u0445\u0445LLLLL;
            \u0445LL\u0445LLL\u0445\u0445LLLLL += L\u0445\u0445LLLL\u0445\u0445LLLLL.getDamageVsEntity();
        }
        return \u0445LL\u0445LLL\u0445\u0445LLLLL += (float)EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(16)), LLL\u0445LLL\u0445\u0445LLLLL) * 1.25f + (float)EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(20)), LLL\u0445LLL\u0445\u0445LLLLL) * 0.01f;
    }

    private int getBlockCount() {
        int L\u0445\u0445LL\u0445L\u0445\u0445LLLLL = 0;
        int LL\u0445LL\u0445L\u0445\u0445LLLLL = 0;
        if (LL\u0445LL\u0445L\u0445\u0445LLLLL < 45) {
            if (InventoryManager.mc.player.inventoryContainer.getSlot(LL\u0445LL\u0445L\u0445\u0445LLLLL).getHasStack()) {
                ItemStack L\u0445LLL\u0445L\u0445\u0445LLLLL = InventoryManager.mc.player.inventoryContainer.getSlot(LL\u0445LL\u0445L\u0445\u0445LLLLL).getStack();
                Item \u0445\u0445LLL\u0445L\u0445\u0445LLLLL = L\u0445LLL\u0445L\u0445\u0445LLLLL.getItem();
                if (L\u0445LLL\u0445L\u0445\u0445LLLLL.getItem() instanceof ItemBlock && !invalidBlocks.contains(((ItemBlock)\u0445\u0445LLL\u0445L\u0445\u0445LLLLL).getBlock())) {
                    L\u0445\u0445LL\u0445L\u0445\u0445LLLLL += L\u0445LLL\u0445L\u0445\u0445LLLLL.stackSize;
                }
            }
            ++LL\u0445LL\u0445L\u0445\u0445LLLLL;
            return 0;
        }
        return L\u0445\u0445LL\u0445L\u0445\u0445LLLLL;
    }

    /*
     * Exception decompiling
     */
    private void getBestPickaxe() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl74 : IINC - null : trying to set 2 previously set to 1
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:207)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1559)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:434)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    private void getBestShovel() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl74 : IINC - null : trying to set 2 previously set to 1
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:207)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1559)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:434)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    private void getBestAxe() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl74 : IINC - null : trying to set 2 previously set to 1
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:207)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1559)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:434)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private float getToolEffect(ItemStack \u0445L\u0445LLLLLL\u0445LLLL) {
        float \u0445LL\u0445LLLLL\u0445LLLL;
        Item L\u0445\u0445LLLLLL\u0445LLLL = \u0445L\u0445LLLLLL\u0445LLLL.getItem();
        if (!(L\u0445\u0445LLLLLL\u0445LLLL instanceof ItemTool)) {
            return 0.0f;
        }
        String \u0445\u0445\u0445LLLLLL\u0445LLLL = L\u0445\u0445LLLLLL\u0445LLLL.getUnlocalizedName();
        ItemTool LLL\u0445LLLLL\u0445LLLL = (ItemTool)L\u0445\u0445LLLLLL\u0445LLLL;
        if (L\u0445\u0445LLLLLL\u0445LLLL instanceof ItemPickaxe) {
            float \u0445LLLLLLLL\u0445LLLL = LLL\u0445LLLLL\u0445LLLL.getStrVsBlock(\u0445L\u0445LLLLLL\u0445LLLL, Blocks.STONE.getDefaultState());
            if (\u0445\u0445\u0445LLLLLL\u0445LLLL.toLowerCase().contains("gold")) {
                \u0445LLLLLLLL\u0445LLLL -= 5.0f;
            }
        } else if (L\u0445\u0445LLLLLL\u0445LLLL instanceof ItemSpade) {
            float L\u0445LLLLLLL\u0445LLLL = LLL\u0445LLLLL\u0445LLLL.getStrVsBlock(\u0445L\u0445LLLLLL\u0445LLLL, Blocks.DIRT.getDefaultState());
            if (\u0445\u0445\u0445LLLLLL\u0445LLLL.toLowerCase().contains("gold")) {
                L\u0445LLLLLLL\u0445LLLL -= 5.0f;
            }
        } else if (L\u0445\u0445LLLLLL\u0445LLLL instanceof ItemAxe) {
            float \u0445\u0445LLLLLLL\u0445LLLL = LLL\u0445LLLLL\u0445LLLL.getStrVsBlock(\u0445L\u0445LLLLLL\u0445LLLL, Blocks.LOG.getDefaultState());
            if (\u0445\u0445\u0445LLLLLL\u0445LLLL.toLowerCase().contains("gold")) {
                \u0445\u0445LLLLLLL\u0445LLLL -= 5.0f;
            }
        } else {
            return 1.0f;
        }
        \u0445LL\u0445LLLLL\u0445LLLL = (float)((double)\u0445LL\u0445LLLLL\u0445LLLL + (double)EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(32)), \u0445L\u0445LLLLLL\u0445LLLL) * 0.0075);
        \u0445LL\u0445LLLLL\u0445LLLL = (float)((double)\u0445LL\u0445LLLLL\u0445LLLL + (double)EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(34)), \u0445L\u0445LLLLLL\u0445LLLL) / 100.0);
        return \u0445LL\u0445LLLLL\u0445LLLL;
    }

    static {
        weaponSlot = 36;
        pickaxeSlot = 37;
        axeSlot = 38;
        shovelSlot = 39;
        invalidBlocks = Arrays.asList(Blocks.ENCHANTING_TABLE, Blocks.FURNACE, Blocks.CARPET, Blocks.CRAFTING_TABLE, Blocks.TRAPPED_CHEST, Blocks.CHEST, Blocks.DISPENSER, Blocks.AIR, Blocks.WATER, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.FLOWING_LAVA, Blocks.SAND, Blocks.SNOW_LAYER, Blocks.TORCH, Blocks.ANVIL, Blocks.JUKEBOX, Blocks.STONE_BUTTON, Blocks.WOODEN_BUTTON, Blocks.LEVER, Blocks.NOTEBLOCK, Blocks.STONE_PRESSURE_PLATE, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, Blocks.WOODEN_PRESSURE_PLATE, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, Blocks.STONE_SLAB, Blocks.WOODEN_SLAB, Blocks.STONE_SLAB2, Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM, Blocks.YELLOW_FLOWER, Blocks.RED_FLOWER, Blocks.ANVIL, Blocks.GLASS_PANE, Blocks.STAINED_GLASS_PANE, Blocks.IRON_BARS, Blocks.CACTUS, Blocks.LADDER, Blocks.WEB);
    }
}

