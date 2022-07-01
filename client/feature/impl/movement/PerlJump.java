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

public class PerlJump
extends Feature {
    public PerlJump() {
        super("FastPearlJump", "Allows you to jump to a greater length, with damage.", Type.Movement);
        PerlJump L\u0445LL\u0445\u0445\u0445\u0445LL\u0445LLLL;
    }

    @EventTarget
    public void onPreUpdate(EventTick \u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LLLL) {
        if (PerlJump.mc.player.hurtTime > 1) {
            PerlJump.mc.player.onGround = false;
            PerlJump.mc.player.jumpMovementFactor = 0.72f;
            if (PerlJump.mc.player.ticksExisted % 4 == 0) {
                BlockPos L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLLL = new BlockPos(PerlJump.mc.player.posX, PerlJump.mc.player.posY - 1555555.0, PerlJump.mc.player.posZ);
                Block \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLLL = PerlJump.mc.world.getBlockState(L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLLL).getBlock();
                if (PerlJump.mc.world.getBlockState(new BlockPos(PerlJump.mc.player.posX, PerlJump.mc.player.posY + 1111111.111111111, PerlJump.mc.player.posZ)).getBlock() == Block.getBlockById(0)) {
                    PerlJump.mc.player.motionY = 0.19f;
                }
            }
        }
    }
}

