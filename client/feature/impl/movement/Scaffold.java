/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.motion.EventSafeWalk;
import org.Destroy.client.event.events.impl.motion.EventStrafe;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.event.events.impl.render.EventRender2D;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.RotationHelper;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.helpers.player.InventoryHelper;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class Scaffold
extends Feature {
    public static List<Block> invalidBlocks = Arrays.asList(Blocks.ENCHANTING_TABLE, Blocks.FURNACE, Blocks.CARPET, Blocks.CRAFTING_TABLE, Blocks.TRAPPED_CHEST, Blocks.CHEST, Blocks.DISPENSER, Blocks.AIR, Blocks.WATER, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.FLOWING_LAVA, Blocks.SAND, Blocks.SNOW_LAYER, Blocks.TORCH, Blocks.ANVIL, Blocks.JUKEBOX, Blocks.STONE_BUTTON, Blocks.WOODEN_BUTTON, Blocks.LEVER, Blocks.NOTEBLOCK, Blocks.STONE_PRESSURE_PLATE, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, Blocks.WOODEN_PRESSURE_PLATE, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, Blocks.STONE_SLAB, Blocks.WOODEN_SLAB, Blocks.STONE_SLAB2, Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM, Blocks.YELLOW_FLOWER, Blocks.RED_FLOWER, Blocks.ANVIL, Blocks.GLASS_PANE, Blocks.STAINED_GLASS_PANE, Blocks.IRON_BARS, Blocks.CACTUS, Blocks.LADDER, Blocks.WEB, Blocks.PUMPKIN);
    public static BlockData data;
    public static boolean isSneaking;
    public static BooleanSetting down;
    public static BooleanSetting sprintoff;
    public static BooleanSetting rotationRandom;
    public static NumberSetting rotationSpeed;
    private final TimerHelper time = new TimerHelper();
    private final BooleanSetting jump;
    private final BooleanSetting swing;
    private final NumberSetting delay;
    private final NumberSetting delayRandom;
    private final NumberSetting chance;
    private final NumberSetting speed;
    private final BooleanSetting rotStrafe;
    private final BooleanSetting safewalk;
    private final ListSetting blockRotation;
    private final ListSetting towerMode;
    public NumberSetting rotPitchRandom = new NumberSetting("Rotation Pitch Random", 2.0f, 0.0f, 8.0f, 0.01f, () -> rotationRandom.getBoolValue());
    public NumberSetting rotYawRandom = new NumberSetting("Rotation Yaw Random", 2.0f, 0.0f, 8.0f, 0.01f, () -> rotationRandom.getBoolValue());
    public BooleanSetting airCheck = new BooleanSetting("Check Air", true, () -> true);
    public BooleanSetting sneak = new BooleanSetting("Sneak", true, () -> true);
    public NumberSetting sneakChance = new NumberSetting("Sneak Chance", 100.0f, 0.0f, 100.0f, 1.0f, () -> {
        Scaffold L\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L;
        return L\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445L.sneak.getBoolValue();
    });
    public NumberSetting sneakSpeed = new NumberSetting("Sneak Speed", 0.05f, 0.01f, 1.0f, 0.01f, () -> {
        Scaffold \u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L;
        return \u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.sneak.getBoolValue();
    });
    public ListSetting sneakMode = new ListSetting("Sneak Mode", "Packet", () -> {
        Scaffold LLLLLL\u0445\u0445\u0445\u0445\u0445L;
        return LLLLLL\u0445\u0445\u0445\u0445\u0445L.sneak.getBoolValue();
    }, "Packet", "Client");
    public NumberSetting rotationOffset = new NumberSetting("Rotation Offset", 0.25f, 0.0f, 1.0f, 0.01f, () -> true);
    public NumberSetting placeOffset = new NumberSetting("Place Offset", 0.2f, 0.01f, 0.3f, 0.01f, () -> true);
    private int slot;

    public Scaffold() {
        super("Scaffold", "Automatically puts blocks under you", Type.Movement);
        Scaffold LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L;
        LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.blockRotation = new ListSetting("BlockRotation Mode", "Matrix", () -> true, "Matrix", "None");
        LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.towerMode = new ListSetting("Tower Mode", "Matrix", () -> true, "Matrix", "NCP", "Default");
        LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.chance = new NumberSetting("Chance", 100.0f, 0.0f, 100.0f, 1.0f, () -> true);
        LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.delay = new NumberSetting("Min Delay", 0.0f, 0.0f, 300.0f, 1.0f, () -> true);
        LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.delayRandom = new NumberSetting("Random Delay", 0.0f, 0.0f, 1000.0f, 1.0f, () -> true);
        LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.speed = new NumberSetting("Speed", 0.6f, 0.05f, 1.2f, 0.01f, () -> true);
        sprintoff = new BooleanSetting("Stop Sprinting", true, () -> true);
        LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.safewalk = new BooleanSetting("SafeWalk", true, () -> true);
        LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.jump = new BooleanSetting("Jump", false, () -> true);
        down = new BooleanSetting("DownWard", false, () -> true);
        LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.swing = new BooleanSetting("SwingHand", false, () -> true);
        LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.rotStrafe = new BooleanSetting("Rotation Strafe", false, () -> true);
        LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.addSettings(LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.blockRotation, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.towerMode, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.chance, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.delay, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.delayRandom, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.rotationOffset, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.placeOffset, rotationSpeed, rotationRandom, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.rotYawRandom, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.rotPitchRandom, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.speed, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.sneak, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.sneakMode, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.sneakChance, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.sneakSpeed, sprintoff, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.airCheck, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.safewalk, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.jump, down, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.swing, LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.rotStrafe);
    }

    public static int searchBlock() {
        int \u0445LLLL\u0445\u0445\u0445L\u0445\u0445L = 0;
        if (\u0445LLLL\u0445\u0445\u0445L\u0445\u0445L < 45) {
            ItemStack LLLLL\u0445\u0445\u0445L\u0445\u0445L = Scaffold.mc.player.inventoryContainer.getSlot(\u0445LLLL\u0445\u0445\u0445L\u0445\u0445L).getStack();
            if (LLLLL\u0445\u0445\u0445L\u0445\u0445L.getItem() instanceof ItemBlock) {
                return \u0445LLLL\u0445\u0445\u0445L\u0445\u0445L;
            }
            ++\u0445LLLL\u0445\u0445\u0445L\u0445\u0445L;
            return 0;
        }
        return -1;
    }

    @Override
    public void onEnable() {
        Scaffold \u0445\u0445LLLLLL\u0445\u0445\u0445L;
        \u0445\u0445LLLLLL\u0445\u0445\u0445L.slot = Scaffold.mc.player.inventory.currentItem;
        data = null;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        Scaffold L\u0445\u0445LLLLL\u0445\u0445\u0445L;
        Scaffold.mc.player.inventory.currentItem = L\u0445\u0445LLLLL\u0445\u0445\u0445L.slot;
        Scaffold.mc.timer.timerSpeed = 1.0f;
        Scaffold.mc.player.connection.sendPacket(new CPacketEntityAction(Scaffold.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
        Scaffold.mc.gameSettings.keyBindSneak.pressed = false;
        super.onDisable();
    }

    @EventTarget
    public void onStrafeMotion(EventStrafe \u0445\u0445L\u0445LLLL\u0445\u0445\u0445L) {
        Scaffold L\u0445L\u0445LLLL\u0445\u0445\u0445L;
        if (L\u0445L\u0445LLLL\u0445\u0445\u0445L.rotStrafe.getBoolValue()) {
            \u0445\u0445L\u0445LLLL\u0445\u0445\u0445L.setCancelled(true);
            MovementHelper.calculateSilentMove(\u0445\u0445L\u0445LLLL\u0445\u0445\u0445L, RotationHelper.Rotation.packetYaw);
        }
    }

    @EventTarget
    public void onSafe(EventSafeWalk \u0445LLL\u0445LLL\u0445\u0445\u0445L) {
        Scaffold LLLL\u0445LLL\u0445\u0445\u0445L;
        if (LLLL\u0445LLL\u0445\u0445\u0445L.safewalk.getBoolValue() && !isSneaking) {
            \u0445LLL\u0445LLL\u0445\u0445\u0445L.setCancelled(Scaffold.mc.player.onGround);
        }
    }

    @EventTarget
    public void onPreMotion(EventPreMotion L\u0445LLL\u0445LL\u0445\u0445\u0445L) {
        Scaffold \u0445LLLL\u0445LL\u0445\u0445\u0445L;
        String \u0445\u0445LLL\u0445LL\u0445\u0445\u0445L = \u0445LLLL\u0445LL\u0445\u0445\u0445L.towerMode.getCurrentMode();
        \u0445LLLL\u0445LL\u0445\u0445\u0445L.setSuffix(\u0445LLLL\u0445LL\u0445\u0445\u0445L.blockRotation.getCurrentMode());
        if (\u0445\u0445LLL\u0445LL\u0445\u0445\u0445L.equalsIgnoreCase("Matrix")) {
            if (!MovementHelper.isMoving()) {
                if (Scaffold.mc.player.onGround && Scaffold.mc.gameSettings.keyBindJump.isKeyDown()) {
                    Scaffold.mc.player.jump();
                }
                Scaffold.mc.player.motionY = Scaffold.mc.player.motionY > 0.0 && !Scaffold.mc.player.onGround ? (Scaffold.mc.player.motionY -= 0.00994) : (Scaffold.mc.player.motionY -= 0.00995);
            }
        } else if (\u0445\u0445LLL\u0445LL\u0445\u0445\u0445L.equalsIgnoreCase("NCP") && !MovementHelper.isMoving()) {
            if (Scaffold.mc.player.onGround && Scaffold.mc.gameSettings.keyBindJump.isKeyDown()) {
                Scaffold.mc.player.jump();
            }
            float LL\u0445\u0445\u0445LLL\u0445\u0445\u0445L = -2.0f;
            if (Scaffold.mc.player.motionY < 0.1 && !(Scaffold.mc.world.getBlockState(new BlockPos(Scaffold.mc.player.posX, Scaffold.mc.player.posY, Scaffold.mc.player.posZ).add(0.0, LL\u0445\u0445\u0445LLL\u0445\u0445\u0445L, 0.0)).getBlock() instanceof BlockAir)) {
                Scaffold.mc.player.motionY -= 190.0;
            }
        }
        if (Scaffold.mc.gameSettings.keyBindSneak.pressed && down.getBoolValue()) {
            Scaffold.mc.gameSettings.keyBindSneak.pressed = false;
            isSneaking = true;
        } else {
            isSneaking = false;
        }
        Scaffold.mc.player.motionX *= (double)\u0445LLLL\u0445LL\u0445\u0445\u0445L.speed.getNumberValue();
        Scaffold.mc.player.motionZ *= (double)\u0445LLLL\u0445LL\u0445\u0445\u0445L.speed.getNumberValue();
        if (!InventoryHelper.doesHotbarHaveBlock() && !(Scaffold.mc.player.getHeldItemOffhand().getItem() instanceof ItemBlock) && Scaffold.searchBlock() != -1) {
            Scaffold.mc.playerController.windowClick(0, Scaffold.searchBlock(), 1, ClickType.QUICK_MOVE, Scaffold.mc.player);
        }
        BlockPos \u0445L\u0445LL\u0445LL\u0445\u0445\u0445L = isSneaking ? new BlockPos(Scaffold.mc.player).add(1, -1, 0).down() : new BlockPos(Scaffold.mc.player).add(0, -1, 0);
        double LL\u0445LL\u0445LL\u0445\u0445\u0445L = Scaffold.mc.player.posY - 1.0;
        if (LL\u0445LL\u0445LL\u0445\u0445\u0445L > 0.0) {
            double \u0445L\u0445\u0445\u0445LLL\u0445\u0445\u0445L;
            BlockData L\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L = \u0445LLLL\u0445LL\u0445\u0445\u0445L.getBlockData(\u0445L\u0445LL\u0445LL\u0445\u0445\u0445L);
            if (L\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L != null && (\u0445L\u0445\u0445\u0445LLL\u0445\u0445\u0445L = Scaffold.mc.player.posY - LL\u0445LL\u0445LL\u0445\u0445\u0445L) <= 7.0) {
                data = L\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L;
            }
            LL\u0445LL\u0445LL\u0445\u0445\u0445L -= 1.0;
            return;
        }
        if (sprintoff.getBoolValue()) {
            Scaffold.mc.player.setSprinting(false);
        }
        if (data != null && \u0445LLLL\u0445LL\u0445\u0445\u0445L.slot != -1 && !Scaffold.mc.player.isInLiquid()) {
            Vec3d LLLLL\u0445LL\u0445\u0445\u0445L = \u0445LLLL\u0445LL\u0445\u0445\u0445L.getVectorToRotate(data);
            if (\u0445LLLL\u0445LL\u0445\u0445\u0445L.blockRotation.getOptions().equalsIgnoreCase("Matrix")) {
                float[] \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L = RotationHelper.getRotationVector(LLLLL\u0445LL\u0445\u0445\u0445L, rotationRandom.getBoolValue(), \u0445LLLL\u0445LL\u0445\u0445\u0445L.rotYawRandom.getNumberValue(), \u0445LLLL\u0445LL\u0445\u0445\u0445L.rotPitchRandom.getNumberValue(), rotationSpeed.getNumberValue());
                L\u0445LLL\u0445LL\u0445\u0445\u0445L.setYaw(\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L[0]);
                L\u0445LLL\u0445LL\u0445\u0445\u0445L.setPitch(\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L[1]);
                if (Scaffold.mc.world.getBlockState(\u0445L\u0445LL\u0445LL\u0445\u0445\u0445L).getBlock() == Blocks.AIR && !\u0445LLLL\u0445LL\u0445\u0445\u0445L.airCheck.getBoolValue()) {
                    Scaffold.mc.player.renderYawOffset = \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L[0];
                    Scaffold.mc.player.rotationYawHead = \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L[0];
                    Scaffold.mc.player.rotationPitchHead = \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L[1];
                } else {
                    Scaffold.mc.player.renderYawOffset = \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L[0];
                    Scaffold.mc.player.rotationYawHead = \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L[0];
                    Scaffold.mc.player.rotationPitchHead = \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L[1];
                }
            }
        }
    }

    /*
     * Exception decompiling
     */
    @EventTarget
    public void onUpdate(EventUpdate LL\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: While processing lbl85 : IF_ACMPNE - null : Stack underflow
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

    @EventTarget
    public void onRender(EventRender3D LLLL\u0445L\u0445L\u0445\u0445\u0445L) {
        Scaffold \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445L;
        if (data != null && \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445L.slot != -1) {
            double L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L = Scaffold.mc.player.posX;
            double \u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L = Scaffold.mc.player.posY;
            double LL\u0445\u0445LL\u0445L\u0445\u0445\u0445L = Scaffold.mc.player.posZ;
            double \u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445L = (double)Scaffold.mc.player.rotationYaw * 0.017453292;
            BlockPos L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445L = new BlockPos(L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L - Math.sin(\u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445L), \u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L - 1.0, LL\u0445\u0445LL\u0445L\u0445\u0445\u0445L + Math.cos(\u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445L));
            RenderHelper.blockEsp(L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445L, Color.WHITE, true);
        }
    }

    @EventTarget
    public void onRender2D(EventRender2D \u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L) {
        Scaffold LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L;
        float L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L = \u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L.getResolution().getScaledWidth();
        float \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L = \u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L.getResolution().getScaledHeight();
        String LLLLL\u0445\u0445L\u0445\u0445\u0445L = LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L.getBlockCount() + " Blocks";
        GlStateManager.pushMatrix();
        GlStateManager.translate(23.0f, 15.0f, 0.0f);
        RectHelper.drawSkeetRectWithoutBorder(L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L / 2.0f + 88.0f - (float)Scaffold.mc.circleregular.getStringWidth(LLLLL\u0445\u0445L\u0445\u0445\u0445L), \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L / 2.0f - (float)Scaffold.mc.circleregular.getStringHeight(LLLLL\u0445\u0445L\u0445\u0445\u0445L) + 59.0f, L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L / 2.0f + (float)Scaffold.mc.circleregular.getStringHeight(LLLLL\u0445\u0445L\u0445\u0445\u0445L) + 2.0f, \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L / 2.0f - (float)Scaffold.mc.circleregular.getStringHeight(LLLLL\u0445\u0445L\u0445\u0445\u0445L) / 2.0f - 55.0f);
        Scaffold.mc.circleregular.drawStringWithOutline(LLLLL\u0445\u0445L\u0445\u0445\u0445L, L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L / 2.0f + 50.0f - (float)Scaffold.mc.circleregular.getStringWidth(LLLLL\u0445\u0445L\u0445\u0445\u0445L), \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L / 2.0f - 9.0f, -1);
        GlStateManager.popMatrix();
    }

    /*
     * Exception decompiling
     */
    private int getBlockCount() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl35 : IINC - null : trying to set 1 previously set to 0
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
    public BlockData getBlockData(BlockPos LL\u0445LLLL\u0445\u0445\u0445\u0445L) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl374 : ALOAD_2 - null : trying to set 1 previously set to 0
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

    private Vec3d getVectorToPlace(BlockData \u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445L) {
        Scaffold L\u0445LL\u0445LL\u0445\u0445\u0445\u0445L;
        BlockPos LL\u0445L\u0445LL\u0445\u0445\u0445\u0445L = \u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445L.pos;
        EnumFacing \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L = \u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445L.face;
        double L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L = (double)LL\u0445L\u0445LL\u0445\u0445\u0445\u0445L.getX() + 0.5;
        double \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L = (double)LL\u0445L\u0445LL\u0445\u0445\u0445\u0445L.getY() + 0.5;
        double LLL\u0445\u0445LL\u0445\u0445\u0445\u0445L = (double)LL\u0445L\u0445LL\u0445\u0445\u0445\u0445L.getZ() + 0.5;
        if (\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L == EnumFacing.UP || \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L == EnumFacing.DOWN) {
            L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L += 0.3;
            LLL\u0445\u0445LL\u0445\u0445\u0445\u0445L += 0.3;
        } else {
            \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L += 0.5;
        }
        if (\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L == EnumFacing.WEST || \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L == EnumFacing.EAST) {
            LLL\u0445\u0445LL\u0445\u0445\u0445\u0445L += (double)L\u0445LL\u0445LL\u0445\u0445\u0445\u0445L.placeOffset.getNumberValue();
        }
        if (\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L == EnumFacing.SOUTH || \u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445L == EnumFacing.NORTH) {
            L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L += (double)L\u0445LL\u0445LL\u0445\u0445\u0445\u0445L.placeOffset.getNumberValue();
        }
        return new Vec3d(L\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L, \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445L, LLL\u0445\u0445LL\u0445\u0445\u0445\u0445L);
    }

    private Vec3d getVectorToRotate(BlockData LLL\u0445L\u0445L\u0445\u0445\u0445\u0445L) {
        Scaffold \u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L;
        BlockPos \u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L = LLL\u0445L\u0445L\u0445\u0445\u0445\u0445L.pos;
        EnumFacing L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L = LLL\u0445L\u0445L\u0445\u0445\u0445\u0445L.face;
        double \u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L = (double)\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L.getX() + 0.5;
        double LL\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L = (double)\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L.getY() + 0.5;
        double \u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L = (double)\u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445L.getZ() + 0.5;
        if (L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L == EnumFacing.UP || L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L == EnumFacing.DOWN) {
            \u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L += 0.4;
            \u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L += 0.4;
        } else {
            LL\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L += 0.4;
        }
        if (L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L == EnumFacing.WEST || L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L == EnumFacing.EAST) {
            \u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L += (double)\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L.rotationOffset.getNumberValue();
        }
        if (L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L == EnumFacing.SOUTH || L\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L == EnumFacing.NORTH) {
            \u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L += (double)\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L.rotationOffset.getNumberValue();
        }
        return new Vec3d(\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L, LL\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L, \u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L);
    }

    public Block getBlockByPos(BlockPos \u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L) {
        return Scaffold.mc.world.getBlockState(\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L).getBlock();
    }

    static {
        rotationRandom = new BooleanSetting("Rotation Random", true, () -> true);
        rotationSpeed = new NumberSetting("Rotation Speed", 360.0f, 1.0f, 360.0f, 1.0f, () -> true);
    }

    private static class BlockData {
        public BlockPos pos;
        public EnumFacing face;

        private BlockData(BlockPos LLLLL\u0445LL\u0445\u0445LLL\u0445L, EnumFacing \u0445LLLL\u0445LL\u0445\u0445LLL\u0445L) {
            BlockData \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445LLL\u0445L;
            \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445LLL\u0445L.pos = LLLLL\u0445LL\u0445\u0445LLL\u0445L;
            \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445LLL\u0445L.face = \u0445LLLL\u0445LL\u0445\u0445LLL\u0445L;
        }
    }
}

