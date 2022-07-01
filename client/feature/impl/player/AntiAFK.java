/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import net.minecraft.network.play.client.CPacketPlayer;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.GCDCalcHelper;
import org.Destroy.client.helpers.math.MathematicHelper;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class AntiAFK
extends Feature {
    private final BooleanSetting sendMessage;
    private final BooleanSetting spin;
    private final BooleanSetting click = new BooleanSetting("Click", true, () -> true);
    public NumberSetting sendDelay;
    public BooleanSetting invalidRotation = new BooleanSetting("Invalid Rotation", true, () -> true);
    public BooleanSetting jump = new BooleanSetting("Jump", true, () -> true);
    public float rot = 0.0f;

    public AntiAFK() {
        super("AntiAFK", "Allows you to get into afk mode, without the risk of kicking", Type.Player);
        AntiAFK \u0445LL\u0445LL\u0445L\u0445\u0445LLLLL;
        \u0445LL\u0445LL\u0445L\u0445\u0445LLLLL.spin = new BooleanSetting("Spin", true, () -> true);
        \u0445LL\u0445LL\u0445L\u0445\u0445LLLLL.sendMessage = new BooleanSetting("Send Message", true, () -> true);
        \u0445LL\u0445LL\u0445L\u0445\u0445LLLLL.sendDelay = new NumberSetting("Send Delay", 500.0f, 100.0f, 1000.0f, 100.0f, \u0445LL\u0445LL\u0445L\u0445\u0445LLLLL.sendMessage::getBoolValue);
        \u0445LL\u0445LL\u0445L\u0445\u0445LLLLL.addSettings(\u0445LL\u0445LL\u0445L\u0445\u0445LLLLL.spin, \u0445LL\u0445LL\u0445L\u0445\u0445LLLLL.sendMessage, \u0445LL\u0445LL\u0445L\u0445\u0445LLLLL.click, \u0445LL\u0445LL\u0445L\u0445\u0445LLLLL.sendDelay, \u0445LL\u0445LL\u0445L\u0445\u0445LLLLL.invalidRotation, \u0445LL\u0445LL\u0445L\u0445\u0445LLLLL.jump);
    }

    @EventTarget
    public void onPreMotion(EventPreMotion LL\u0445LL\u0445\u0445L\u0445\u0445LLLLL) {
        if (!MovementHelper.isMoving()) {
            AntiAFK L\u0445LLL\u0445\u0445L\u0445\u0445LLLLL;
            if (L\u0445LLL\u0445\u0445L\u0445\u0445LLLLL.spin.getBoolValue()) {
                float LLLLL\u0445\u0445L\u0445\u0445LLLLL = GCDCalcHelper.getFixedRotation((float)(Math.floor(L\u0445LLL\u0445\u0445L\u0445\u0445LLLLL.spinAim(1.0f)) + (double)MathematicHelper.randomizeFloat(-4.0f, 1.0f)));
                LL\u0445LL\u0445\u0445L\u0445\u0445LLLLL.setYaw(LLLLL\u0445\u0445L\u0445\u0445LLLLL);
                AntiAFK.mc.player.renderYawOffset = LLLLL\u0445\u0445L\u0445\u0445LLLLL;
                AntiAFK.mc.player.rotationPitchHead = 0.0f;
                AntiAFK.mc.player.rotationYawHead = LLLLL\u0445\u0445L\u0445\u0445LLLLL;
            }
            if (AntiAFK.mc.player.ticksExisted % 60 == 0 && L\u0445LLL\u0445\u0445L\u0445\u0445LLLLL.invalidRotation.getBoolValue()) {
                AntiAFK.mc.player.connection.sendPacket(new CPacketPlayer.PositionRotation(AntiAFK.mc.player.posX + 1.0, AntiAFK.mc.player.posY + 1.0, AntiAFK.mc.player.posZ + 1.0, AntiAFK.mc.player.rotationYaw, AntiAFK.mc.player.rotationPitch, true));
            }
            if (AntiAFK.mc.player.ticksExisted % 60 == 0 && L\u0445LLL\u0445\u0445L\u0445\u0445LLLLL.click.getBoolValue()) {
                mc.clickMouse();
            }
            if (AntiAFK.mc.player.ticksExisted % 40 == 0 && L\u0445LLL\u0445\u0445L\u0445\u0445LLLLL.jump.getBoolValue()) {
                AntiAFK.mc.player.jump();
            }
            if (AntiAFK.mc.player.ticksExisted % 400 == 0 && L\u0445LLL\u0445\u0445L\u0445\u0445LLLLL.sendMessage.getBoolValue()) {
                AntiAFK.mc.player.sendChatMessage("/homehome");
            }
        }
    }

    public float spinAim(float L\u0445LL\u0445\u0445\u0445L\u0445\u0445LLLLL) {
        AntiAFK \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLLLL;
        \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLLLL.rot += L\u0445LL\u0445\u0445\u0445L\u0445\u0445LLLLL;
        return \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLLLL.rot;
    }
}

