/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import java.util.ArrayList;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventReceivePacket;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.helpers.world.BlockHelper;
import org.Destroy.client.helpers.world.EntityHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class AutoFarm
extends Feature {
    private final NumberSetting delay;
    private final NumberSetting radius;
    private final BooleanSetting autoHoe;
    private final BooleanSetting autoFarm;
    ArrayList<BlockPos> crops = new ArrayList();
    ArrayList<BlockPos> check = new ArrayList();
    TimerHelper timerHelper = new TimerHelper();
    TimerHelper timerHelper2 = new TimerHelper();

    public AutoFarm() {
        super("AutoFarm", "Plants and breaks crops automatically", Type.Misc);
        AutoFarm \u0445LLLLLL\u0445L\u0445LL;
        \u0445LLLLLL\u0445L\u0445LL.autoFarm = new BooleanSetting("Auto Farm", true, () -> true);
        \u0445LLLLLL\u0445L\u0445LL.autoHoe = new BooleanSetting("Auto Hoe", false, () -> true);
        \u0445LLLLLL\u0445L\u0445LL.delay = new NumberSetting("Farm Delay", 2.0f, 0.0f, 10.0f, 0.1f, () -> true);
        \u0445LLLLLL\u0445L\u0445LL.radius = new NumberSetting("Farm Radius", 4.0f, 1.0f, 7.0f, 0.1f, () -> true);
        \u0445LLLLLL\u0445L\u0445LL.addSettings(\u0445LLLLLL\u0445L\u0445LL.autoFarm, \u0445LLLLLL\u0445L\u0445LL.autoHoe, \u0445LLLLLL\u0445L\u0445LL.delay, \u0445LLLLLL\u0445L\u0445LL.radius);
    }

    public static int searchSeeds() {
        int \u0445LL\u0445LLL\u0445L\u0445LL = 0;
        if (\u0445LL\u0445LLL\u0445L\u0445LL < 45) {
            ItemStack LLL\u0445LLL\u0445L\u0445LL = AutoFarm.mc.player.inventoryContainer.getSlot(\u0445LL\u0445LLL\u0445L\u0445LL).getStack();
            if (LLL\u0445LLL\u0445L\u0445LL.getItem() instanceof ItemSeeds) {
                return \u0445LL\u0445LLL\u0445L\u0445LL;
            }
            ++\u0445LL\u0445LLL\u0445L\u0445LL;
            return 0;
        }
        return -1;
    }

    public static int getSlotWithSeeds() {
        int \u0445L\u0445\u0445LLL\u0445L\u0445LL = 0;
        if (\u0445L\u0445\u0445LLL\u0445L\u0445LL < 9) {
            AutoFarm.mc.player.inventory.getStackInSlot(\u0445L\u0445\u0445LLL\u0445L\u0445LL);
            if (AutoFarm.mc.player.inventory.getStackInSlot(\u0445L\u0445\u0445LLL\u0445L\u0445LL).getItem() instanceof ItemSeeds) {
                return \u0445L\u0445\u0445LLL\u0445L\u0445LL;
            }
            ++\u0445L\u0445\u0445LLL\u0445L\u0445LL;
            return 0;
        }
        return 0;
    }

    @Override
    public void onEnable() {
        AutoFarm LLLL\u0445LL\u0445L\u0445LL;
        LLLL\u0445LL\u0445L\u0445LL.crops.clear();
        LLLL\u0445LL\u0445L\u0445LL.check.clear();
        super.onEnable();
    }

    private boolean IsValidBlockPos(BlockPos \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LL) {
        IBlockState LLLLL\u0445L\u0445L\u0445LL = AutoFarm.mc.world.getBlockState(\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LL);
        if (LLLLL\u0445L\u0445L\u0445LL.getBlock() instanceof BlockFarmland || LLLLL\u0445L\u0445L\u0445LL.getBlock() instanceof BlockSand || LLLLL\u0445L\u0445L\u0445LL.getBlock() instanceof BlockSoulSand) {
            return AutoFarm.mc.world.getBlockState(\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445LL.up()).getBlock() == Blocks.AIR;
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    @EventTarget
    public void onPreMotion(EventPreMotion \u0445LL\u0445L\u0445L\u0445L\u0445LL) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: While processing lbl118 : IF_ICMPGE - null : Stack underflow
         *     at org.benf.cfr.reader.bytecode.analysis.stack.StackSim.getChange(StackSim.java:81)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:242)
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
    @EventTarget
    public void onPre(EventPreMotion L\u0445LLLL\u0445\u0445L\u0445LL) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl178 : RETURN - null : trying to set 2 previously set to 0
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
    @EventTarget
    public void onReceivePacket(EventReceivePacket L\u0445L\u0445\u0445L\u0445\u0445L\u0445LL) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl63 : RETURN - null : trying to set 0 previously set to 1
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

    private ArrayList<BlockPos> getBlocks(float L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LL, float \u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LL, float LLL\u0445\u0445\u0445\u0445\u0445L\u0445LL) {
        BlockPos \u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LL = new BlockPos(AutoFarm.mc.player.posX - (double)L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LL, AutoFarm.mc.player.posY - (double)\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LL, AutoFarm.mc.player.posZ - (double)LLL\u0445\u0445\u0445\u0445\u0445L\u0445LL);
        BlockPos L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL = new BlockPos(AutoFarm.mc.player.posX + (double)L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LL, AutoFarm.mc.player.posY + (double)\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LL, AutoFarm.mc.player.posZ + (double)LLL\u0445\u0445\u0445\u0445\u0445L\u0445LL);
        return BlockHelper.getAllInBox(\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445LL, L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL);
    }

    private static /* synthetic */ Double lambda$onPre$5(BlockPos \u0445LLLLLLL\u0445\u0445LL) {
        return EntityHelper.getDistanceOfEntityToBlock(AutoFarm.mc.player, \u0445LLLLLLL\u0445\u0445LL);
    }

    private static /* synthetic */ Double lambda$onPreMotion$4(BlockPos LL\u0445LLLLL\u0445\u0445LL) {
        return EntityHelper.getDistanceOfEntityToBlock(AutoFarm.mc.player, LL\u0445LLLLL\u0445\u0445LL);
    }
}

