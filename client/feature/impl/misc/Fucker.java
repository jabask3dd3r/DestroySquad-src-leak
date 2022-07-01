/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import java.awt.Color;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.RotationHelper;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class Fucker
extends Feature {
    public static NumberSetting rad;
    private final NumberSetting fuckerDelay;
    private final ListSetting mode;
    private final TimerHelper timerUtils = new TimerHelper();
    private int xPos;
    private int yPos;
    private int zPos;
    private int blockid;

    public Fucker() {
        super("Fucker", "\nAutomatically destroys beds and cakes through blocks", Type.Misc);
        Fucker LLLLLLLL\u0445\u0445LLLLL;
        LLLLLLLL\u0445\u0445LLLLL.mode = new ListSetting("Block", "Bed", () -> true, "Bed", "Cake");
        rad = new NumberSetting("Fucker Radius", 4.0f, 1.0f, 6.0f, 0.5f, () -> true);
        LLLLLLLL\u0445\u0445LLLLL.fuckerDelay = new NumberSetting("Fucker Delay", 100.0f, 0.0f, 1000.0f, 50.0f, () -> true);
        LLLLLLLL\u0445\u0445LLLLL.addSettings(LLLLLLLL\u0445\u0445LLLLL.mode, rad, LLLLLLLL\u0445\u0445LLLLL.fuckerDelay);
    }

    @EventTarget
    public void onPreMotion(EventPreMotion \u0445\u0445LL\u0445LLL\u0445\u0445LLLLL) {
        float LL\u0445L\u0445LLL\u0445\u0445LLLLL = rad.getNumberValue();
        int \u0445LLL\u0445LLL\u0445\u0445LLLLL = (int)(-LL\u0445L\u0445LLL\u0445\u0445LLLLL);
        if ((float)\u0445LLL\u0445LLL\u0445\u0445LLLLL < LL\u0445L\u0445LLL\u0445\u0445LLLLL) {
            int LLLL\u0445LLL\u0445\u0445LLLLL = (int)LL\u0445L\u0445LLL\u0445\u0445LLLLL;
            if ((float)LLLL\u0445LLL\u0445\u0445LLLLL > -LL\u0445L\u0445LLL\u0445\u0445LLLLL) {
                int \u0445\u0445\u0445\u0445LLLL\u0445\u0445LLLLL = (int)(-LL\u0445L\u0445LLL\u0445\u0445LLLLL);
                if ((float)\u0445\u0445\u0445\u0445LLLL\u0445\u0445LLLLL < LL\u0445L\u0445LLL\u0445\u0445LLLLL) {
                    Fucker L\u0445LL\u0445LLL\u0445\u0445LLLLL;
                    L\u0445LL\u0445LLL\u0445\u0445LLLLL.xPos = (int)Fucker.mc.player.posX + \u0445LLL\u0445LLL\u0445\u0445LLLLL;
                    L\u0445LL\u0445LLL\u0445\u0445LLLLL.yPos = (int)Fucker.mc.player.posY + LLLL\u0445LLL\u0445\u0445LLLLL;
                    L\u0445LL\u0445LLL\u0445\u0445LLLLL.zPos = (int)Fucker.mc.player.posZ + \u0445\u0445\u0445\u0445LLLL\u0445\u0445LLLLL;
                    BlockPos \u0445L\u0445\u0445LLLL\u0445\u0445LLLLL = new BlockPos(L\u0445LL\u0445LLL\u0445\u0445LLLLL.xPos, L\u0445LL\u0445LLL\u0445\u0445LLLLL.yPos, L\u0445LL\u0445LLL\u0445\u0445LLLLL.zPos);
                    Block L\u0445\u0445\u0445LLLL\u0445\u0445LLLLL = Fucker.mc.world.getBlockState(\u0445L\u0445\u0445LLLL\u0445\u0445LLLLL).getBlock();
                    switch (L\u0445LL\u0445LLL\u0445\u0445LLLLL.mode.getOptions()) {
                        case "Bed": {
                            L\u0445LL\u0445LLL\u0445\u0445LLLLL.blockid = 26;
                            break;
                        }
                        case "Cake": {
                            L\u0445LL\u0445LLL\u0445\u0445LLLLL.blockid = 354;
                        }
                    }
                    if (Block.getIdFromBlock(L\u0445\u0445\u0445LLLL\u0445\u0445LLLLL) == L\u0445LL\u0445LLL\u0445\u0445LLLLL.blockid && (L\u0445\u0445\u0445LLLL\u0445\u0445LLLLL != null || \u0445L\u0445\u0445LLLL\u0445\u0445LLLLL != null)) {
                        float[] LL\u0445\u0445LLLL\u0445\u0445LLLLL = RotationHelper.getRotationVector(new Vec3d((float)\u0445L\u0445\u0445LLLL\u0445\u0445LLLLL.getX() + 0.5f, (float)\u0445L\u0445\u0445LLLL\u0445\u0445LLLLL.getY() + 0.5f, (float)\u0445L\u0445\u0445LLLL\u0445\u0445LLLLL.getZ() + 0.5f), true, 2.0f, 2.0f, 360.0f);
                        \u0445\u0445LL\u0445LLL\u0445\u0445LLLLL.setYaw(LL\u0445\u0445LLLL\u0445\u0445LLLLL[0]);
                        \u0445\u0445LL\u0445LLL\u0445\u0445LLLLL.setPitch(LL\u0445\u0445LLLL\u0445\u0445LLLLL[1]);
                        Fucker.mc.player.renderYawOffset = LL\u0445\u0445LLLL\u0445\u0445LLLLL[0];
                        Fucker.mc.player.rotationYawHead = LL\u0445\u0445LLLL\u0445\u0445LLLLL[0];
                        Fucker.mc.player.rotationPitchHead = LL\u0445\u0445LLLL\u0445\u0445LLLLL[1];
                        Fucker.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, \u0445L\u0445\u0445LLLL\u0445\u0445LLLLL, Fucker.mc.player.getHorizontalFacing()));
                        if (L\u0445LL\u0445LLL\u0445\u0445LLLLL.timerUtils.hasReached(L\u0445LL\u0445LLL\u0445\u0445LLLLL.fuckerDelay.getNumberValue())) {
                            Fucker.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, \u0445L\u0445\u0445LLLL\u0445\u0445LLLLL, Fucker.mc.player.getHorizontalFacing()));
                            Fucker.mc.player.swingArm(EnumHand.MAIN_HAND);
                            L\u0445LL\u0445LLL\u0445\u0445LLLLL.timerUtils.reset();
                        }
                    }
                    ++\u0445\u0445\u0445\u0445LLLL\u0445\u0445LLLLL;
                    return;
                }
                --LLLL\u0445LLL\u0445\u0445LLLLL;
                return;
            }
            ++\u0445LLL\u0445LLL\u0445\u0445LLLLL;
            return;
        }
    }

    @EventTarget
    public void onRender3D(EventRender3D LL\u0445\u0445L\u0445LL\u0445\u0445LLLLL) {
        int \u0445L\u0445\u0445L\u0445LL\u0445\u0445LLLLL = (int)Fucker.mc.player.posX;
        int L\u0445\u0445\u0445L\u0445LL\u0445\u0445LLLLL = (int)Fucker.mc.player.posZ;
        int \u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445LLLLL = (int)Fucker.mc.player.posY;
        int LLLL\u0445\u0445LL\u0445\u0445LLLLL = (int)rad.getNumberValue();
        int L\u0445L\u0445L\u0445LL\u0445\u0445LLLLL = \u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445LLLLL - LLLL\u0445\u0445LL\u0445\u0445LLLLL;
        if (L\u0445L\u0445L\u0445LL\u0445\u0445LLLLL <= \u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445LLLLL + LLLL\u0445\u0445LL\u0445\u0445LLLLL) {
            int \u0445LL\u0445L\u0445LL\u0445\u0445LLLLL = \u0445L\u0445\u0445L\u0445LL\u0445\u0445LLLLL - LLLL\u0445\u0445LL\u0445\u0445LLLLL;
            if (\u0445LL\u0445L\u0445LL\u0445\u0445LLLLL <= \u0445L\u0445\u0445L\u0445LL\u0445\u0445LLLLL + LLLL\u0445\u0445LL\u0445\u0445LLLLL) {
                int LLL\u0445L\u0445LL\u0445\u0445LLLLL = L\u0445\u0445\u0445L\u0445LL\u0445\u0445LLLLL - LLLL\u0445\u0445LL\u0445\u0445LLLLL;
                if (LLL\u0445L\u0445LL\u0445\u0445LLLLL <= L\u0445\u0445\u0445L\u0445LL\u0445\u0445LLLLL + LLLL\u0445\u0445LL\u0445\u0445LLLLL) {
                    BlockPos \u0445\u0445\u0445LL\u0445LL\u0445\u0445LLLLL = new BlockPos(\u0445LL\u0445L\u0445LL\u0445\u0445LLLLL, L\u0445L\u0445L\u0445LL\u0445\u0445LLLLL, LLL\u0445L\u0445LL\u0445\u0445LLLLL);
                    if (Fucker.mc.world.getBlockState(\u0445\u0445\u0445LL\u0445LL\u0445\u0445LLLLL).getBlock() == Blocks.BED && \u0445\u0445\u0445LL\u0445LL\u0445\u0445LLLLL != null && Fucker.mc.world.getBlockState(\u0445\u0445\u0445LL\u0445LL\u0445\u0445LLLLL).getBlock() != Blocks.AIR) {
                        RenderHelper.blockEsp(\u0445\u0445\u0445LL\u0445LL\u0445\u0445LLLLL, Color.RED, true);
                    }
                    ++LLL\u0445L\u0445LL\u0445\u0445LLLLL;
                    return;
                }
                ++\u0445LL\u0445L\u0445LL\u0445\u0445LLLLL;
                return;
            }
            ++L\u0445L\u0445L\u0445LL\u0445\u0445LLLLL;
            return;
        }
    }
}

