/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import net.minecraft.block.Block;
import net.minecraft.entity.MoverType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class Jesus
extends Feature {
    public static ListSetting mode;
    public static NumberSetting speed;
    public static NumberSetting motionUp;
    public static NumberSetting boostSpeed;
    public static NumberSetting boostTicks;
    public static BooleanSetting boost;
    public static BlockPos blockPosIMP;
    public boolean start = false;
    public NumberSetting speedt;

    public Jesus() {
        super("Jesus", "Allows you to walk on water", Type.Movement);
        Jesus \u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL;
        mode = new ListSetting("LiquidWalkMode", "MatrixZoom", () -> true, "MatrixZoom", "SunRise");
        \u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL.speedt = new NumberSetting("Speed", 1.99f, 0.3f, 4.99f, 0.1f, () -> Jesus.mode.currentMode.equals("MatrixZoom"));
        \u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL.addSettings(mode, speed, boost, boostSpeed, boostTicks, motionUp, \u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445LL.speedt);
    }

    @EventTarget
    public void onPreMotion(EventPreMotion \u0445\u0445\u0445LLLLL\u0445LL\u0445LL) {
        Jesus L\u0445\u0445LLLLL\u0445LL\u0445LL;
        L\u0445\u0445LLLLL\u0445LL\u0445LL.setSuffix(mode.getCurrentMode());
        BlockPos LLL\u0445LLLL\u0445LL\u0445LL = new BlockPos(Jesus.mc.player.posX, Jesus.mc.player.posY - (double)0.25099f, Jesus.mc.player.posZ);
        Block \u0445LL\u0445LLLL\u0445LL\u0445LL = Jesus.mc.world.getBlockState(LLL\u0445LLLL\u0445LL\u0445LL).getBlock();
        switch (Jesus.mode.currentMode) {
            case "MatrixZoom": {
                if (Block.getIdFromBlock(\u0445LL\u0445LLLL\u0445LL\u0445LL) == 9 && !Jesus.mc.player.onGround) {
                    MovementHelper.setSpeed(L\u0445\u0445LLLLL\u0445LL\u0445LL.speedt.getNumberValue());
                    Jesus.mc.player.jumpMovementFactor = 0.51f;
                    if (Jesus.mc.world.getBlockState(new BlockPos(Jesus.mc.player.posX, Jesus.mc.player.posY + 4.001E-4, Jesus.mc.player.posZ)).getBlock() == Block.getBlockById(9)) {
                        Jesus.mc.player.fallDistance = 0.0f;
                        Jesus.mc.player.motionX = 0.0;
                        Jesus.mc.player.motionY = 0.03899f;
                        Jesus.mc.player.jumpMovementFactor = 0.02f;
                        Jesus.mc.player.motionZ = 0.0;
                        break;
                    }
                }
            }
            case "SunRise": {
                if (!Jesus.mc.player.isInWater()) break;
                Jesus.mc.player.motionY = 0.003;
                if (!Jesus.mc.player.isSprinting()) break;
                if (MovementHelper.isMoving()) {
                    Jesus.mc.gameSettings.keyBindJump.pressed = false;
                    Jesus.mc.player.fallDistance = 0.1f;
                    Jesus.mc.player.moveEntity(MoverType.PLAYER, 0.0, 0.112, 0.0);
                }
                float \u0445L\u0445LLLLL\u0445LL\u0445LL = Jesus.mc.player.rotationYaw * ((float)Math.PI / 180);
                Jesus.mc.player.moveEntity(MoverType.PLAYER, Jesus.mc.player.motionX -= (double)MathHelper.sin(\u0445L\u0445LLLLL\u0445LL\u0445LL) * 0.036, 0.0, Jesus.mc.player.motionZ += (double)MathHelper.cos(\u0445L\u0445LLLLL\u0445LL\u0445LL) * 0.036);
            }
        }
    }
}

