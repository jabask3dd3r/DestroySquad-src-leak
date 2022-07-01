/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.game.EventTick;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class LongJump
extends Feature {
    public ListSetting mode;
    public NumberSetting boostMultiplier;
    public NumberSetting motionBoost;
    public BooleanSetting motionYBoost = new BooleanSetting("MotionY boost", false, () -> true);

    public LongJump() {
        super("LongJump", "Allows you to jump to a greater length, with damage.", Type.Movement);
        LongJump \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L;
        \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.mode = new ListSetting("LongJump Mode", "Matrix Pearle", () -> true, "Redesky", "Matrix Pearle");
        \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.boostMultiplier = new NumberSetting("Boost Speed", 0.3f, 0.1f, 1.0f, 0.1f, () -> {
            LongJump \u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L;
            return \u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L.mode.currentMode.equals("Redesky");
        });
        \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.motionBoost = new NumberSetting("Motion Boost", 0.6f, 0.1f, 8.0f, 0.1f, () -> {
            LongJump L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L;
            return L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L.mode.currentMode.equals("Redesky") && L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L.motionYBoost.getBoolValue();
        });
        \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.addSettings(\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.mode, \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.boostMultiplier, \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.motionYBoost, \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L.motionBoost);
    }

    @EventTarget
    public void onPreUpdate(EventTick LL\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L) {
        LongJump \u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L;
        String \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L = \u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L.mode.getOptions();
        \u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L.setSuffix(\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L);
        if (!\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L.getState()) {
            return;
        }
        if (\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L.equalsIgnoreCase("Redesky")) {
            if (LongJump.mc.player.hurtTime > 0) {
                LongJump.mc.timer.timerSpeed = 1.0f;
                if (LongJump.mc.player.fallDistance != 0.0f) {
                    LongJump.mc.player.motionY += 0.039;
                }
                if (LongJump.mc.player.onGround) {
                    LongJump.mc.player.jump();
                } else {
                    LongJump.mc.timer.timerSpeed = 0.2f;
                    LongJump.mc.player.motionY += 0.075;
                    LongJump.mc.player.motionX *= (double)1.065f;
                    LongJump.mc.player.motionZ *= (double)1.065f;
                }
            }
        } else if (\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L.equalsIgnoreCase("Matrix Pearle") && LongJump.mc.player.hurtTime > 0) {
            LongJump.mc.player.isAirBorne = false;
            LongJump.mc.player.jump();
            LongJump.mc.player.jumpMovementFactor = 0.79f;
            BlockPos \u0445LLLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L = new BlockPos(LongJump.mc.player.posX, LongJump.mc.player.posY - 1555555.0, LongJump.mc.player.posZ);
            Block L\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L = LongJump.mc.world.getBlockState(\u0445LLLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L).getBlock();
            if (LongJump.mc.world.getBlockState(new BlockPos(LongJump.mc.player.posX, LongJump.mc.player.posY + 1111111.111111111, LongJump.mc.player.posZ)).getBlock() == Block.getBlockById(0)) {
                LongJump.mc.player.motionY = 0.56f;
            }
        }
    }

    @Override
    public void onDisable() {
        LongJump \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L;
        LongJump.mc.timer.timerSpeed = 1.0f;
        super.onDisable();
    }
}

