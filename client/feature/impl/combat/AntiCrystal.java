/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.RotationHelper;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.helpers.player.InventoryHelper;
import org.Destroy.client.helpers.world.BlockHelper;
import org.Destroy.client.helpers.world.EntityHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class AntiCrystal
extends Feature {
    private final NumberSetting rangeToBlock;
    private final NumberSetting delay;
    private final BooleanSetting throughWalls;
    private final BooleanSetting bedrockCheck;
    private final BooleanSetting obsidianCheck;
    private final TimerHelper timerHelper = new TimerHelper();
    private final ArrayList<BlockPos> invalidPositions = new ArrayList();

    public AntiCrystal() {
        super("AntiCrystal", "Automatically blocks obsidian/bedrock in radius", Type.Combat);
        AntiCrystal LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L;
        LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.throughWalls = new BooleanSetting("Through Walls", true, () -> true);
        LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.obsidianCheck = new BooleanSetting("Obsidian Check", true, () -> true);
        LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.bedrockCheck = new BooleanSetting("Bedrock Check", false, () -> true);
        LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.rangeToBlock = new NumberSetting("Range To Block", 5.0f, 1.0f, 4.0f, 0.1f, () -> true);
        LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.delay = new NumberSetting("Place Delay", 0.0f, 0.0f, 2000.0f, 100.0f, () -> true);
        LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.addSettings(LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.obsidianCheck, LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.bedrockCheck, LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.throughWalls, LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.rangeToBlock, LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.delay);
    }

    public static int getSlotWithBlock() {
        int \u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L = 0;
        if (\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L < 9) {
            AntiCrystal.mc.player.inventory.getStackInSlot(\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L);
            if (AntiCrystal.mc.player.inventory.getStackInSlot(\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L).getItem() instanceof ItemBlock) {
                return \u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L;
            }
            ++\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L;
            return 0;
        }
        return -1;
    }

    private boolean IsValidBlockPos(BlockPos \u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L) {
        AntiCrystal LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L;
        IBlockState L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L = AntiCrystal.mc.world.getBlockState(\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L);
        if (L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.getBlock() instanceof BlockObsidian && LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.obsidianCheck.getBoolValue() || L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.getBlock() == Block.getBlockById(7) && LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.bedrockCheck.getBoolValue()) {
            return AntiCrystal.mc.world.getBlockState(\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L.up()).getBlock() == Blocks.AIR;
        }
        return false;
    }

    @EventTarget
    public void onPreMotion(EventPreMotion \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L) {
        AntiCrystal \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
        \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.setSuffix("" + (int)\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.rangeToBlock.getNumberValue());
        int \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L = AntiCrystal.mc.player.inventory.currentItem;
        BlockPos LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L = BlockHelper.getSphere(BlockHelper.getPlayerPos(), \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.rangeToBlock.getNumberValue(), 6, false, true).stream().filter(\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L::IsValidBlockPos).min(Comparator.comparing(\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L -> EntityHelper.getDistanceOfEntityToBlock(AntiCrystal.mc.player, \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L))).orElse(null);
        if (InventoryHelper.doesHotbarHaveBlock() && LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L != null && \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.timerHelper.hasReached(\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.delay.getNumberValue()) && AntiCrystal.getSlotWithBlock() != -1) {
            Iterator \u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
            if (!AntiCrystal.mc.world.isAirBlock(LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.up(1))) {
                \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.invalidPositions.add(LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L);
            }
            if ((\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L = AntiCrystal.mc.world.loadedEntityList.iterator()).hasNext()) {
                Entity LLL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L = (Entity)\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.next();
                if (LLL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L instanceof EntityEnderCrystal && LLL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getPosition().getX() == LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getX() && LLL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getPosition().getZ() == LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getZ()) {
                    return;
                }
                return;
            }
            if (!\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.invalidPositions.contains(LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L)) {
                if (AntiCrystal.mc.world.rayTraceBlocks(new Vec3d(AntiCrystal.mc.player.posX, AntiCrystal.mc.player.posY + (double)AntiCrystal.mc.player.getEyeHeight(), AntiCrystal.mc.player.posZ), new Vec3d(LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getX(), LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getY(), LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getZ()), false, true, false) != null && !\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.throughWalls.getBoolValue()) {
                    return;
                }
                float[] \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L = RotationHelper.getRotationVector(new Vec3d((double)LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getX() + 0.5, (double)LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getY() + 1.4, (double)LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getZ() + 0.5), true, 2.0f, 2.0f, 360.0f);
                \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.setYaw(\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L[0]);
                \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.setPitch(\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L[1]);
                AntiCrystal.mc.player.renderYawOffset = \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L[0];
                AntiCrystal.mc.player.rotationYawHead = \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L[0];
                AntiCrystal.mc.player.rotationPitchHead = \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L[1];
                AntiCrystal.mc.player.inventory.currentItem = AntiCrystal.getSlotWithBlock();
                AntiCrystal.mc.playerController.processRightClickBlock(AntiCrystal.mc.player, AntiCrystal.mc.world, LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L, EnumFacing.UP, new Vec3d(LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getX(), LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getY(), LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getZ()), EnumHand.MAIN_HAND);
                AntiCrystal.mc.player.swingArm(EnumHand.MAIN_HAND);
                AntiCrystal.mc.player.inventory.currentItem = \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
                \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.timerHelper.reset();
            }
        }
    }
}

