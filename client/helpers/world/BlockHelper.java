/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.world;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.helpers.Helper;

public class BlockHelper
implements Helper {
    public BlockHelper() {
        BlockHelper L\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445L\u0445L;
    }

    public static Block getBlock(BlockPos \u0445\u0445LL\u0445LLL\u0445\u0445\u0445\u0445L\u0445L) {
        return BlockHelper.mc.world.getBlockState(\u0445\u0445LL\u0445LLL\u0445\u0445\u0445\u0445L\u0445L).getBlock();
    }

    public static BlockPos getPlayerPos() {
        return new BlockPos(Math.floor(BlockHelper.mc.player.posX), Math.floor(BlockHelper.mc.player.posY), Math.floor(BlockHelper.mc.player.posZ));
    }

    public static boolean IsValidBlockPos(BlockPos \u0445\u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445L) {
        IBlockState LL\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445L = BlockHelper.mc.world.getBlockState(\u0445\u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445L);
        if (LL\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445L.getBlock() instanceof BlockDirt || LL\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445L.getBlock() instanceof BlockGrass && !(LL\u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445L.getBlock() instanceof BlockFarmland)) {
            return BlockHelper.mc.world.getBlockState(\u0445\u0445L\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445L.up()).getBlock() == Blocks.AIR;
        }
        return false;
    }

    public static List<BlockPos> getSphere(BlockPos LL\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L, float L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L, int \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L, boolean LLLL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L, boolean \u0445LLL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L) {
        ArrayList<BlockPos> L\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L = new ArrayList<BlockPos>();
        int \u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L = LL\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L.getX();
        int LL\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L = LL\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L.getY();
        int \u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L = LL\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L.getZ();
        float L\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L = (float)\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L - L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L;
        if (L\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L <= (float)\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L + L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L) {
            float \u0445LL\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L = (float)\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L - L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L;
            if (\u0445LL\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L <= (float)\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L + L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L) {
                float \u0445\u0445LLLL\u0445L\u0445\u0445\u0445\u0445L\u0445L;
                float \u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445L\u0445L = \u0445LLL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L ? (float)LL\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L - L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L : (float)LL\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L;
                float f2 = \u0445\u0445LLLL\u0445L\u0445\u0445\u0445\u0445L\u0445L = \u0445LLL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L ? (float)LL\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L + L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L : (float)(LL\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L + \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L);
                if (\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445L\u0445L < \u0445\u0445LLLL\u0445L\u0445\u0445\u0445\u0445L\u0445L) {
                    float \u0445L\u0445LLL\u0445L\u0445\u0445\u0445\u0445L\u0445L = ((float)\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L - L\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L) * ((float)\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L - L\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L) + ((float)\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L - \u0445LL\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L) * ((float)\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L - \u0445LL\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L) + (\u0445LLL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L ? ((float)LL\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L - \u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445L\u0445L) * ((float)LL\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L - \u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445L\u0445L) : 0.0f);
                    if (!(!(\u0445L\u0445LLL\u0445L\u0445\u0445\u0445\u0445L\u0445L < L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L * L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L) || LLLL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L && \u0445L\u0445LLL\u0445L\u0445\u0445\u0445\u0445L\u0445L < L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L - 1.0f * (L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L - 1.0f))) {
                        BlockPos LLLLLL\u0445L\u0445\u0445\u0445\u0445L\u0445L = new BlockPos(L\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L, \u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445L\u0445L, \u0445LL\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L);
                        L\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L.add(LLLLLL\u0445L\u0445\u0445\u0445\u0445L\u0445L);
                    }
                    \u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445L\u0445L += 1.0f;
                    return null;
                }
                \u0445LL\u0445LL\u0445L\u0445\u0445\u0445\u0445L\u0445L += 1.0f;
                return null;
            }
            L\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L += 1.0f;
            return null;
        }
        return L\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L;
    }

    public static ArrayList<BlockPos> getBlocks(int LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L, int L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L, int LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L) {
        BlockPos L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L = new BlockPos(BlockHelper.mc.player.posX - (double)LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L, BlockHelper.mc.player.posY - (double)L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L, BlockHelper.mc.player.posZ - (double)LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L);
        BlockPos \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L = new BlockPos(BlockHelper.mc.player.posX + (double)LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L, BlockHelper.mc.player.posY + (double)L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L, BlockHelper.mc.player.posZ + (double)LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L);
        return BlockHelper.getAllInBox(L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L, \u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L);
    }

    public static ArrayList<BlockPos> getAllInBox(BlockPos \u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L, BlockPos LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L) {
        ArrayList<BlockPos> L\u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L = new ArrayList<BlockPos>();
        BlockPos LL\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L = new BlockPos(Math.min(\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getX(), LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getX()), Math.min(\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getY(), LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getY()), Math.min(\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getZ(), LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getZ()));
        BlockPos \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L = new BlockPos(Math.max(\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getX(), LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getX()), Math.max(\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getY(), LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getY()), Math.max(\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getZ(), LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getZ()));
        int L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L = LL\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getX();
        if (L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L <= \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getX()) {
            int LLL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L = LL\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getY();
            if (LLL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L <= \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getY()) {
                int LL\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L = LL\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getZ();
                if (LL\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L <= \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.getZ()) {
                    L\u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.add(new BlockPos(L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L, LLL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L, LL\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L));
                    ++LL\u0445LL\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L;
                    return null;
                }
                ++LLL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L;
                return null;
            }
            ++L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L;
            return null;
        }
        return L\u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L;
    }
}

