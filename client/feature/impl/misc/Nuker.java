/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import java.awt.Color;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class Nuker
extends Feature {
    private final BooleanSetting sendRotations;
    private final BooleanSetting sortTrashBlocks;
    private final BooleanSetting autoNoBreakDelay;
    private final NumberSetting nukerHorizontal;
    private final NumberSetting nukerVertical;
    private final BooleanSetting nukerESP = new BooleanSetting("Nuker ESP", true, () -> true);
    private final ColorSetting color = new ColorSetting("Nuker Color", new Color(0xFFFFFF).getRGB(), L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.nukerESP::getBoolValue);
    private BlockPos blockPos;

    public Nuker() {
        super("Nuker", "Breaks the blocks around you", Type.Misc);
        Nuker L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL;
        L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.sendRotations = new BooleanSetting("Send Rotations", true, () -> true);
        L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.sortTrashBlocks = new BooleanSetting("Sort trash blocks", true, () -> true);
        L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.autoNoBreakDelay = new BooleanSetting("No Delay", true, () -> true);
        L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.nukerHorizontal = new NumberSetting("Nuker Horizontal", 3.0f, 1.0f, 5.0f, 1.0f, () -> true);
        L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.nukerVertical = new NumberSetting("Nuker Vertical", 3.0f, 1.0f, 5.0f, 1.0f, () -> true);
        L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.addSettings(L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.color, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.nukerESP, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.sendRotations, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.sortTrashBlocks, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.autoNoBreakDelay, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.nukerHorizontal, L\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445LL.nukerVertical);
    }

    /*
     * Exception decompiling
     */
    private BlockPos getPositionXYZ() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl73 : IINC - null : trying to set 0 previously set to 1
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

    @EventTarget
    public void onRender3D(EventRender3D LLLLLL\u0445\u0445\u0445\u0445\u0445\u0445LL) {
        Nuker \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL;
        if (Nuker.mc.player == null || Nuker.mc.world == null) {
            return;
        }
        if (!\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.nukerESP.getBoolValue()) {
            return;
        }
        if ((Nuker.mc.world.getBlockState(\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.blockPos).getBlock() == Blocks.GRASS || Nuker.mc.world.getBlockState(\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.blockPos).getBlock() == Blocks.MONSTER_EGG || Nuker.mc.world.getBlockState(\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.blockPos).getBlock() == Blocks.DIRT || Nuker.mc.world.getBlockState(\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.blockPos).getBlock() == Blocks.GRAVEL || Nuker.mc.world.getBlockState(\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.blockPos).getBlock() == Blocks.WATER || Nuker.mc.world.getBlockState(\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.blockPos).getBlock() == Blocks.LAVA) && \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.sortTrashBlocks.getBoolValue()) {
            return;
        }
        \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.blockPos = \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.getPositionXYZ();
        Color \u0445LLLLL\u0445\u0445\u0445\u0445\u0445\u0445LL = new Color(\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.color.getColorValue());
        BlockPos L\u0445LLLL\u0445\u0445\u0445\u0445\u0445\u0445LL = new BlockPos(\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.blockPos.getX(), \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.blockPos.getY(), \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL.blockPos.getZ());
        RenderHelper.blockEsp(L\u0445LLLL\u0445\u0445\u0445\u0445\u0445\u0445LL, \u0445LLLLL\u0445\u0445\u0445\u0445\u0445\u0445LL, true);
    }

    /*
     * Exception decompiling
     */
    @EventTarget
    public void onPreUpdate(EventPreMotion L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl171 : RETURN - null : trying to set 0 previously set to 1
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
}

