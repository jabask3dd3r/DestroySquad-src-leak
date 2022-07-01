/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventFullCube;
import org.Destroy.client.event.events.impl.player.EventPush;
import org.Destroy.client.event.events.impl.player.EventUpdateLiving;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.settings.impl.NumberSetting;

public class NoClip
extends Feature {
    public static NumberSetting speed;

    public NoClip() {
        super("NoClip", "Allows you to walk through walls", Type.Movement);
        NoClip L\u0445\u0445LLL\u0445\u0445\u0445L\u0445LLLL;
        speed = new NumberSetting("Speed", 0.2f, 0.1f, 2.0f, 0.01f, () -> true);
        L\u0445\u0445LLL\u0445\u0445\u0445L\u0445LLLL.addSettings(speed);
    }

    @EventTarget
    public void onFullCube(EventFullCube L\u0445L\u0445LL\u0445\u0445\u0445L\u0445LLLL) {
        if (NoClip.mc.world != null) {
            L\u0445L\u0445LL\u0445\u0445\u0445L\u0445LLLL.setCancelled(true);
        }
    }

    @EventTarget
    public void onPush(EventPush L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445LLLL) {
        L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445LLLL.setCancelled(true);
    }

    @EventTarget
    public void onLivingUpdate(EventUpdateLiving L\u0445LL\u0445L\u0445\u0445\u0445L\u0445LLLL) {
        if (NoClip.mc.player != null) {
            NoClip.mc.player.noClip = true;
            NoClip.mc.player.motionY = 0.0;
            NoClip.mc.player.onGround = false;
            NoClip.mc.player.capabilities.isFlying = false;
            MovementHelper.setSpeed(speed.getNumberValue() == 0.0f ? MovementHelper.getBaseMoveSpeed() : speed.getNumberValue());
            if (NoClip.mc.gameSettings.keyBindJump.isKeyDown()) {
                NoClip.mc.player.motionY += 0.5;
            }
            if (NoClip.mc.gameSettings.keyBindSneak.isKeyDown()) {
                NoClip.mc.player.motionY -= 0.5;
            }
            L\u0445LL\u0445L\u0445\u0445\u0445L\u0445LLLL.setCancelled(true);
        }
    }
}

