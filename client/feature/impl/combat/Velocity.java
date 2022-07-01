/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import net.minecraft.init.MobEffects;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventReceivePacket;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class Velocity
extends Feature {
    public static BooleanSetting cancelOtherDamage;
    public static ListSetting velocityMode;
    public static BooleanSetting cancelEntityVelocity;
    public static BooleanSetting cancelExplosion;
    public static BooleanSetting useMotion;
    public static NumberSetting motionX;
    public static NumberSetting motionY;
    public static NumberSetting motionZ;
    public static BooleanSetting usePacketMotion;
    public static NumberSetting packetX;
    public static NumberSetting packetY;
    public static NumberSetting packetZ;
    public static NumberSetting hurt;

    public Velocity() {
        super("Velocity", "\nReduces knockback on impact", Type.Combat);
        Velocity \u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL;
        velocityMode = new ListSetting("Velocity Mode", "Packet", () -> true, "Packet", "Matrix", "Reverse", "Custom");
        cancelOtherDamage = new BooleanSetting("Cancel Other Damage", true, () -> true);
        \u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445LL.addSettings(velocityMode, cancelEntityVelocity, cancelExplosion, useMotion, usePacketMotion, hurt, packetX, packetY, packetZ, motionX, motionY, motionZ, cancelOtherDamage);
    }

    @EventTarget
    public void onReceivePacket(EventReceivePacket LL\u0445LLL\u0445\u0445L\u0445L\u0445LL) {
        String \u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL = velocityMode.getOptions();
        if (cancelOtherDamage.getBoolValue() && Velocity.mc.player.hurtTime > 0 && LL\u0445LLL\u0445\u0445L\u0445L\u0445LL.getPacket() instanceof SPacketEntityVelocity && (Velocity.mc.player.isPotionActive(MobEffects.POISON) || Velocity.mc.player.isPotionActive(MobEffects.WITHER) || Velocity.mc.player.isBurning())) {
            LL\u0445LLL\u0445\u0445L\u0445L\u0445LL.setCancelled(true);
        }
        if (\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL.equalsIgnoreCase("Reverse") && Velocity.mc.player.hurtTime > 0) {
            MovementHelper.strafePlayer(MovementHelper.getSpeed());
            Velocity.mc.player.speedInAir = 0.02f;
        }
        if (\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL.equalsIgnoreCase("Packet")) {
            if ((LL\u0445LLL\u0445\u0445L\u0445L\u0445LL.getPacket() instanceof SPacketEntityVelocity || LL\u0445LLL\u0445\u0445L\u0445L\u0445LL.getPacket() instanceof SPacketExplosion) && ((SPacketEntityVelocity)LL\u0445LLL\u0445\u0445L\u0445L\u0445LL.getPacket()).getEntityID() == Velocity.mc.player.getEntityId()) {
                LL\u0445LLL\u0445\u0445L\u0445L\u0445LL.setCancelled(true);
            }
        } else if (\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL.equals("Matrix")) {
            if (Velocity.mc.player.hurtTime > 8) {
                Velocity.mc.player.onGround = true;
            }
        } else if (\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445LL.equals("Custom")) {
            if (cancelEntityVelocity.getBoolValue() && LL\u0445LLL\u0445\u0445L\u0445L\u0445LL.getPacket() instanceof SPacketEntityVelocity || cancelExplosion.getBoolValue() && LL\u0445LLL\u0445\u0445L\u0445L\u0445LL.getPacket() instanceof SPacketExplosion) {
                LL\u0445LLL\u0445\u0445L\u0445L\u0445LL.setCancelled(true);
            } else if ((float)Velocity.mc.player.hurtTime > hurt.getNumberValue() || cancelExplosion.getBoolValue() && LL\u0445LLL\u0445\u0445L\u0445L\u0445LL.getPacket() instanceof SPacketExplosion) {
                SPacketEntityVelocity L\u0445LLLL\u0445\u0445L\u0445L\u0445LL = (SPacketEntityVelocity)LL\u0445LLL\u0445\u0445L\u0445L\u0445LL.getPacket();
                if (usePacketMotion.getBoolValue()) {
                    L\u0445LLLL\u0445\u0445L\u0445L\u0445LL.motionX = (int)((float)(L\u0445LLLL\u0445\u0445L\u0445L\u0445LL.motionX / 100) * packetX.getNumberValue());
                    L\u0445LLLL\u0445\u0445L\u0445L\u0445LL.motionY = (int)((float)(L\u0445LLLL\u0445\u0445L\u0445L\u0445LL.motionY / 100) * packetY.getNumberValue());
                    L\u0445LLLL\u0445\u0445L\u0445L\u0445LL.motionZ = (int)((float)(L\u0445LLLL\u0445\u0445L\u0445L\u0445LL.motionZ / 100) * packetZ.getNumberValue());
                }
                if (useMotion.getBoolValue()) {
                    Velocity.mc.player.motionX = (int)(Velocity.mc.player.motionX / 100.0 * (double)motionX.getNumberValue());
                    Velocity.mc.player.motionY = (int)(Velocity.mc.player.motionY / 100.0 * (double)motionY.getNumberValue());
                    Velocity.mc.player.motionZ = (int)(Velocity.mc.player.motionZ / 100.0 * (double)motionZ.getNumberValue());
                }
            }
        }
    }

    static {
        cancelEntityVelocity = new BooleanSetting("Cancel Entity Velocity", true, () -> Velocity.velocityMode.currentMode.equals("Custom"));
        cancelExplosion = new BooleanSetting("Cancel Explosion", true, () -> Velocity.velocityMode.currentMode.equals("Custom"));
        useMotion = new BooleanSetting("Use Motion", true, () -> Velocity.velocityMode.currentMode.equals("Custom"));
        motionX = new NumberSetting("Motion X", 0.0f, 0.0f, 100.0f, 1.0f, () -> Velocity.velocityMode.currentMode.equals("Custom") && useMotion.getBoolValue() && !cancelEntityVelocity.getBoolValue());
        motionY = new NumberSetting("Motion Y", 0.0f, 0.0f, 100.0f, 1.0f, () -> Velocity.velocityMode.currentMode.equals("Custom") && useMotion.getBoolValue() && !cancelEntityVelocity.getBoolValue());
        motionZ = new NumberSetting("Motion Z", 0.0f, 0.0f, 100.0f, 1.0f, () -> Velocity.velocityMode.currentMode.equals("Custom") && useMotion.getBoolValue() && !cancelEntityVelocity.getBoolValue());
        usePacketMotion = new BooleanSetting("Use Packet Motion", true, () -> Velocity.velocityMode.currentMode.equals("Custom"));
        packetX = new NumberSetting("Packet X", 0.0f, 0.0f, 100.0f, 1.0f, () -> Velocity.velocityMode.currentMode.equals("Custom") && !cancelEntityVelocity.getBoolValue() && usePacketMotion.getBoolValue());
        packetY = new NumberSetting("Packet Y", 0.0f, 0.0f, 100.0f, 1.0f, () -> Velocity.velocityMode.currentMode.equals("Custom") && !cancelEntityVelocity.getBoolValue() && usePacketMotion.getBoolValue());
        packetZ = new NumberSetting("Packet Z", 0.0f, 0.0f, 100.0f, 1.0f, () -> Velocity.velocityMode.currentMode.equals("Custom") && !cancelEntityVelocity.getBoolValue() && usePacketMotion.getBoolValue());
        hurt = new NumberSetting("Hurt", 0.0f, 0.0f, 10.0f, 1.0f, () -> Velocity.velocityMode.currentMode.equals("Custom"));
    }
}

