/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import java.util.Random;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.game.EventTick;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.player.MovementHelper;

public class MotionFly
extends Feature {
    public MotionFly() {
        super("MotionFly", "Increases your speed in fly", Type.Movement);
        MotionFly LL\u0445L\u0445L\u0445\u0445LLLL;
    }

    @EventTarget
    public void onTick(EventTick LL\u0445\u0445\u0445L\u0445\u0445LLLL) {
        Random L\u0445\u0445\u0445\u0445L\u0445\u0445LLLL = new Random();
        if (!MotionFly.mc.player.isCollidedHorizontally && !MotionFly.mc.player.isCollidedVertically || !MotionFly.mc.player.isCollided) {
            MotionFly.mc.player.setSprinting(false);
            if (MotionFly.mc.player.motionY < -0.017) {
                MotionFly.mc.player.motionY = -0.01148;
                MovementHelper.setSpeed(2.275f);
                MotionFly.mc.player.capabilities.setFlySpeed(2.275f);
            }
            if (MotionFly.mc.player.motionY > 0.0) {
                MotionFly.mc.player.motionX = 0.0;
                MotionFly.mc.player.motionZ = 0.0;
                MovementHelper.setSpeed(0.1f);
            }
        }
    }
}

