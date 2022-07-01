/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventReceivePacket;
import org.Destroy.client.event.events.impl.packet.EventSendPacket;
import org.Destroy.client.event.events.impl.player.EventFullCube;
import org.Destroy.client.event.events.impl.player.EventPush;
import org.Destroy.client.event.events.impl.player.EventUpdateLiving;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class FreeCam
extends Feature {
    public NumberSetting speed;
    public BooleanSetting AntiAction = new BooleanSetting("AntiAction", true, () -> true);
    public BooleanSetting autoDamageDisable = new BooleanSetting("Auto Damage Disable", true, () -> true);
    private float old;
    private double oldX;
    private double oldY;
    private double oldZ;

    public FreeCam() {
        super("FreeCam", "FreeCam", Type.Misc);
        FreeCam L\u0445\u0445L\u0445L;
        L\u0445\u0445L\u0445L.speed = new NumberSetting("Flying Speed", 0.2f, 0.1f, 1.0f, 0.1f, () -> true);
        L\u0445\u0445L\u0445L.addSettings(L\u0445\u0445L\u0445L.speed, L\u0445\u0445L\u0445L.autoDamageDisable, L\u0445\u0445L\u0445L.AntiAction);
    }

    @Override
    public void onDisable() {
        FreeCam \u0445LL\u0445\u0445L;
        FreeCam.mc.player.capabilities.isFlying = false;
        FreeCam.mc.player.capabilities.setFlySpeed(\u0445LL\u0445\u0445L.old);
        FreeCam.mc.player.noClip = false;
        FreeCam.mc.renderGlobal.loadRenderers();
        FreeCam.mc.player.noClip = false;
        FreeCam.mc.player.setPositionAndRotation(\u0445LL\u0445\u0445L.oldX, \u0445LL\u0445\u0445L.oldY, \u0445LL\u0445\u0445L.oldZ, FreeCam.mc.player.rotationYaw, FreeCam.mc.player.rotationPitch);
        FreeCam.mc.world.removeEntityFromWorld(-69);
        FreeCam.mc.player.motionZ = 0.0;
        FreeCam.mc.player.motionX = 0.0;
        super.onDisable();
    }

    @Override
    public void onEnable() {
        FreeCam \u0445L\u0445\u0445\u0445L;
        \u0445L\u0445\u0445\u0445L.oldX = FreeCam.mc.player.posX;
        \u0445L\u0445\u0445\u0445L.oldY = FreeCam.mc.player.posY;
        \u0445L\u0445\u0445\u0445L.oldZ = FreeCam.mc.player.posZ;
        FreeCam.mc.player.noClip = true;
        EntityOtherPlayerMP L\u0445\u0445\u0445\u0445L = new EntityOtherPlayerMP(FreeCam.mc.world, FreeCam.mc.player.getGameProfile());
        L\u0445\u0445\u0445\u0445L.copyLocationAndAnglesFrom(FreeCam.mc.player);
        L\u0445\u0445\u0445\u0445L.posY -= 0.0;
        L\u0445\u0445\u0445\u0445L.rotationYawHead = FreeCam.mc.player.rotationYawHead;
        FreeCam.mc.world.addEntityToWorld(-69, L\u0445\u0445\u0445\u0445L);
        super.onEnable();
    }

    @EventTarget
    public void onFullCube(EventFullCube \u0445\u0445LLL) {
        \u0445\u0445LLL.setCancelled(true);
    }

    @EventTarget
    public void onPush(EventPush \u0445\u0445\u0445LL) {
        \u0445\u0445\u0445LL.setCancelled(true);
    }

    @EventTarget
    public void onUpdate(EventUpdateLiving \u0445\u0445L\u0445L) {
        FreeCam L\u0445L\u0445L;
        if (L\u0445L\u0445L.autoDamageDisable.getBoolValue() && FreeCam.mc.player.hurtTime > 0 && Destroy.instance.featureManager.getFeatureByClass(FreeCam.class).getState()) {
            Destroy.instance.featureManager.getFeatureByClass(FreeCam.class).getState();
        }
        FreeCam.mc.player.noClip = true;
        FreeCam.mc.player.onGround = false;
        FreeCam.mc.player.capabilities.setFlySpeed(L\u0445L\u0445L.speed.getNumberValue() / 5.0f);
        FreeCam.mc.player.capabilities.isFlying = true;
    }

    @EventTarget
    public void onPacket(EventSendPacket L\u0445\u0445\u0445L) {
        FreeCam.mc.player.setSprinting(false);
    }

    @EventTarget
    public void onReceivePacket(EventReceivePacket L\u0445LL) {
        FreeCam \u0445LLL;
        if (\u0445LLL.AntiAction.getBoolValue() && L\u0445LL.getPacket() instanceof SPacketPlayerPosLook) {
            L\u0445LL.setCancelled(true);
        }
    }

    @EventTarget
    public void onSendPacket(EventSendPacket LLL) {
        FreeCam \u0445\u0445\u0445L;
        if (\u0445\u0445\u0445L.AntiAction.getBoolValue()) {
            if (LLL.getPacket() instanceof CPacketPlayer) {
                LLL.setCancelled(true);
            }
            if (LLL.getPacket() instanceof CPacketPlayer.Position) {
                LLL.setCancelled(true);
            }
            if (LLL.getPacket() instanceof CPacketPlayer.PositionRotation) {
                LLL.setCancelled(true);
            }
            if (LLL.getPacket() instanceof CPacketEntityAction) {
                LLL.setCancelled(true);
            }
        }
    }
}

