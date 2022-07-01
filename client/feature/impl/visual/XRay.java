/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import org.Destroy.client.cmd.impl.XrayCommand;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventReceivePacket;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.event.events.impl.render.EventRenderBlock;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.world.BlockHelper;
import org.Destroy.client.helpers.world.EntityHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class XRay
extends Feature {
    public static int done;
    public static int all;
    public static BooleanSetting brutForce;
    public static BooleanSetting diamond;
    public static BooleanSetting gold;
    public static BooleanSetting iron;
    public static BooleanSetting emerald;
    public static BooleanSetting redstone;
    public static BooleanSetting lapis;
    public static BooleanSetting coal;
    private final NumberSetting checkSpeed;
    private final NumberSetting renderDist;
    private final NumberSetting rxz;
    private final NumberSetting ry;
    private final ArrayList<BlockPos> ores = new ArrayList();
    private final ArrayList<BlockPos> toCheck = new ArrayList();
    private final List<Vec3i> blocks = new CopyOnWriteArrayList<Vec3i>();

    public XRay() {
        super("XRay", "Xray, which allows you to bypass anti-Xray on servers", Type.Misc);
        XRay \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L;
        brutForce = new BooleanSetting("BrutForce", false, () -> true);
        \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.renderDist = new NumberSetting("Render Distance", 35.0f, 15.0f, 150.0f, 5.0f, () -> !brutForce.getBoolValue());
        diamond = new BooleanSetting("Diamond", true, () -> true);
        gold = new BooleanSetting("Gold", false, () -> true);
        iron = new BooleanSetting("Iron", false, () -> true);
        emerald = new BooleanSetting("Emerald", false, () -> true);
        redstone = new BooleanSetting("Redstone", false, () -> true);
        lapis = new BooleanSetting("Lapis", false, () -> true);
        coal = new BooleanSetting("Coal", false, () -> true);
        \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.checkSpeed = new NumberSetting("CheckSpeed", 4.0f, 1.0f, 10.0f, 1.0f, brutForce::getBoolValue);
        \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.rxz = new NumberSetting("Radius XZ", 20.0f, 5.0f, 200.0f, 1.0f, brutForce::getBoolValue);
        \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.ry = new NumberSetting("Radius Y", 6.0f, 2.0f, 50.0f, 1.0f, brutForce::getBoolValue);
        \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.addSettings(\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.renderDist, brutForce, \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.checkSpeed, \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.rxz, \u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.ry, diamond, gold, iron, emerald, redstone, lapis, coal);
    }

    private ArrayList<BlockPos> getBlocks(int L\u0445LL\u0445LL\u0445\u0445L\u0445\u0445L, int \u0445\u0445LL\u0445LL\u0445\u0445L\u0445\u0445L, int LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445L) {
        BlockPos \u0445L\u0445L\u0445LL\u0445\u0445L\u0445\u0445L = new BlockPos(XRay.mc.player.posX - (double)L\u0445LL\u0445LL\u0445\u0445L\u0445\u0445L, XRay.mc.player.posY - (double)\u0445\u0445LL\u0445LL\u0445\u0445L\u0445\u0445L, XRay.mc.player.posZ - (double)LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445L);
        BlockPos L\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L = new BlockPos(XRay.mc.player.posX + (double)L\u0445LL\u0445LL\u0445\u0445L\u0445\u0445L, XRay.mc.player.posY + (double)\u0445\u0445LL\u0445LL\u0445\u0445L\u0445\u0445L, XRay.mc.player.posZ + (double)LL\u0445L\u0445LL\u0445\u0445L\u0445\u0445L);
        return BlockHelper.getAllInBox(\u0445L\u0445L\u0445LL\u0445\u0445L\u0445\u0445L, L\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L);
    }

    @Override
    public void onEnable() {
        XRay LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L;
        if (brutForce.getBoolValue()) {
            int L\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L;
            int \u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = (int)LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L.rxz.getNumberValue();
            ArrayList<BlockPos> \u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L.getBlocks(\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L, L\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = (int)LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L.ry.getNumberValue(), \u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L);
            Iterator<BlockPos> \u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L = \u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L.iterator();
            if (\u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L.hasNext()) {
                BlockPos LL\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = \u0445L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L.next();
                IBlockState \u0445\u0445LLL\u0445L\u0445\u0445L\u0445\u0445L = XRay.mc.world.getBlockState(LL\u0445LL\u0445L\u0445\u0445L\u0445\u0445L);
                XRay xRay = LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L;
                if (Block.getIdFromBlock(\u0445\u0445LLL\u0445L\u0445\u0445L\u0445\u0445L.getBlock()) != 0) {
                    LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L.toCheck.add(LL\u0445LL\u0445L\u0445\u0445L\u0445\u0445L);
                }
                return;
            }
            all = LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L.toCheck.size();
            done = 0;
        }
        super.onEnable();
    }

    @Override
    public void onDisable() {
        XRay \u0445LLL\u0445\u0445L\u0445\u0445L\u0445\u0445L;
        XRay.mc.renderGlobal.loadRenderers();
        super.onDisable();
    }

    @EventTarget
    public void onPreMotion(EventPreMotion L\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L) {
        String \u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L;
        String string = \u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L = done == all ? "Done: " + all : "" + done + " / " + all;
        if (brutForce.getBoolValue()) {
            XRay \u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L;
            \u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.setSuffix(\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L);
            int LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L = 0;
            if ((float)LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L < \u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.checkSpeed.getNumberValue()) {
                if (\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.toCheck.size() < 1) {
                    return;
                }
                BlockPos \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L = \u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.toCheck.remove(0);
                ++done;
                XRay.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, EnumFacing.UP));
                ++LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L;
                return;
            }
        }
    }

    /*
     * Exception decompiling
     */
    @EventTarget
    public void onReceivePacket(EventReceivePacket \u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445L) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl74 : RETURN - null : trying to set 0 previously set to 1
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
    public void onRenderBlock(EventRenderBlock LL\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L) {
        XRay L\u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L;
        BlockPos \u0445L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L = LL\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.getPos();
        IBlockState \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L = LL\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.getState();
        XRay xRay = L\u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L;
        if (Block.getIdFromBlock(\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.getBlock()) != 0) {
            Vec3i LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L = new Vec3i(\u0445L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.getX(), \u0445L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.getY(), \u0445L\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.getZ());
            L\u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445L.blocks.add(LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L);
        }
    }

    @EventTarget
    public void onRender3D(EventRender3D \u0445L\u0445LL\u0445LLL\u0445\u0445\u0445L) {
        XRay LL\u0445LL\u0445LLL\u0445\u0445\u0445L;
        if (brutForce.getBoolValue()) {
            for (BlockPos LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445L : LL\u0445LL\u0445LLL\u0445\u0445\u0445L.ores) {
                IBlockState LLL\u0445\u0445LLLL\u0445\u0445\u0445L = XRay.mc.world.getBlockState(LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445L);
                Block L\u0445L\u0445\u0445LLLL\u0445\u0445\u0445L = LLL\u0445\u0445LLLL\u0445\u0445\u0445L.getBlock();
                if (LL\u0445LL\u0445LLL\u0445\u0445\u0445L.toCheck.size() <= 0) continue;
                if (Block.getIdFromBlock(L\u0445L\u0445\u0445LLLL\u0445\u0445\u0445L) == 0) {
                    return;
                }
                switch (Block.getIdFromBlock(L\u0445L\u0445\u0445LLLL\u0445\u0445\u0445L)) {
                    case 56: {
                        if (!diamond.getBoolValue()) break;
                        RenderHelper.blockEspFrame(LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 0.0f, 255.0f, 255.0f);
                        break;
                    }
                    case 14: {
                        if (!gold.getBoolValue()) break;
                        RenderHelper.blockEspFrame(LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 255.0f, 215.0f, 0.0f);
                        break;
                    }
                    case 15: {
                        if (!iron.getBoolValue()) break;
                        RenderHelper.blockEspFrame(LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 213.0f, 213.0f, 213.0f);
                        break;
                    }
                    case 129: {
                        if (!emerald.getBoolValue()) break;
                        RenderHelper.blockEspFrame(LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 0.0f, 255.0f, 77.0f);
                        break;
                    }
                    case 73: {
                        if (!redstone.getBoolValue()) break;
                        RenderHelper.blockEspFrame(LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 255.0f, 0.0f, 0.0f);
                        break;
                    }
                    case 16: {
                        if (!coal.getBoolValue()) break;
                        RenderHelper.blockEspFrame(LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 0.0f, 0.0f, 0.0f);
                        break;
                    }
                    case 21: {
                        if (!lapis.getBoolValue()) break;
                        RenderHelper.blockEspFrame(LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 38.0f, 97.0f, 156.0f);
                    }
                }
                Iterator<Integer> \u0445\u0445L\u0445L\u0445LLL\u0445\u0445\u0445L = XrayCommand.blockIDS.iterator();
                if (\u0445\u0445L\u0445L\u0445LLL\u0445\u0445\u0445L.hasNext()) {
                    Integer L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445L = \u0445\u0445L\u0445L\u0445LLL\u0445\u0445\u0445L.next();
                    if (Block.getIdFromBlock(L\u0445L\u0445\u0445LLLL\u0445\u0445\u0445L) == L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445L) {
                        RenderHelper.blockEspFrame(LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, (float)ClientHelper.getClientColor().getRed() / 255.0f, (float)ClientHelper.getClientColor().getGreen() / 255.0f, (float)ClientHelper.getClientColor().getBlue() / 255.0f);
                    }
                    return;
                }
                return;
            }
        } else {
            for (Vec3i \u0445\u0445LLL\u0445LLL\u0445\u0445\u0445L : LL\u0445LL\u0445LLL\u0445\u0445\u0445L.blocks) {
                BlockPos \u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L = new BlockPos(\u0445\u0445LLL\u0445LLL\u0445\u0445\u0445L);
                IBlockState LLLLL\u0445LLL\u0445\u0445\u0445L = XRay.mc.world.getBlockState(\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L);
                Block \u0445LLLL\u0445LLL\u0445\u0445\u0445L = LLLLL\u0445LLL\u0445\u0445\u0445L.getBlock();
                Block L\u0445LLL\u0445LLL\u0445\u0445\u0445L = XRay.mc.world.getBlockState(\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L).getBlock();
                if (L\u0445LLL\u0445LLL\u0445\u0445\u0445L instanceof BlockAir) continue;
                if (Block.getIdFromBlock(L\u0445LLL\u0445LLL\u0445\u0445\u0445L) == 0) {
                    return;
                }
                if (EntityHelper.getDistance(XRay.mc.player.posX, XRay.mc.player.posZ, \u0445\u0445LLL\u0445LLL\u0445\u0445\u0445L.getX(), \u0445\u0445LLL\u0445LLL\u0445\u0445\u0445L.getZ()) > (double)LL\u0445LL\u0445LLL\u0445\u0445\u0445L.renderDist.getNumberValue()) {
                    LL\u0445LL\u0445LLL\u0445\u0445\u0445L.blocks.remove(\u0445\u0445LLL\u0445LLL\u0445\u0445\u0445L);
                    return;
                }
                switch (Block.getIdFromBlock(L\u0445LLL\u0445LLL\u0445\u0445\u0445L)) {
                    case 56: {
                        if (!diamond.getBoolValue()) break;
                        RenderHelper.blockEspFrame(\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 0.0f, 255.0f, 255.0f);
                        break;
                    }
                    case 14: {
                        if (!gold.getBoolValue()) break;
                        RenderHelper.blockEspFrame(\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 255.0f, 215.0f, 0.0f);
                        break;
                    }
                    case 15: {
                        if (!iron.getBoolValue()) break;
                        RenderHelper.blockEspFrame(\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 213.0f, 213.0f, 213.0f);
                        break;
                    }
                    case 129: {
                        if (!emerald.getBoolValue()) break;
                        RenderHelper.blockEspFrame(\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 0.0f, 255.0f, 77.0f);
                        break;
                    }
                    case 73: {
                        if (!redstone.getBoolValue()) break;
                        RenderHelper.blockEspFrame(\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 255.0f, 0.0f, 0.0f);
                        break;
                    }
                    case 16: {
                        if (!coal.getBoolValue()) break;
                        RenderHelper.blockEspFrame(\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 0.0f, 0.0f, 0.0f);
                        break;
                    }
                    case 21: {
                        if (!lapis.getBoolValue()) break;
                        RenderHelper.blockEspFrame(\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, 38.0f, 97.0f, 156.0f);
                    }
                }
                Iterator<Integer> \u0445L\u0445\u0445L\u0445LLL\u0445\u0445\u0445L = XrayCommand.blockIDS.iterator();
                if (\u0445L\u0445\u0445L\u0445LLL\u0445\u0445\u0445L.hasNext()) {
                    Integer L\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L = \u0445L\u0445\u0445L\u0445LLL\u0445\u0445\u0445L.next();
                    if (Block.getIdFromBlock(\u0445LLLL\u0445LLL\u0445\u0445\u0445L) != 0 && Block.getIdFromBlock(\u0445LLLL\u0445LLL\u0445\u0445\u0445L) == L\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L) {
                        RenderHelper.blockEspFrame(\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445L, (float)ClientHelper.getClientColor().getRed() / 255.0f, (float)ClientHelper.getClientColor().getGreen() / 255.0f, (float)ClientHelper.getClientColor().getBlue() / 255.0f);
                    }
                    return;
                }
                return;
            }
        }
    }
}

