/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import net.minecraft.network.play.server.SPacketPlayerPosLook;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventReceivePacket;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.movement.Jesus;
import org.Destroy.client.feature.impl.movement.Speed;
import org.Destroy.client.feature.impl.movement.Timer;
import org.Destroy.client.feature.impl.movement.WaterSpeed;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;

public class FlagDetector
extends Feature {
    public FlagDetector() {
        super("FlagDetector", "Automatic off modules for detect", Type.Combat);
        FlagDetector LL\u0445LL\u0445\u0445LL\u0445LL;
    }

    @EventTarget
    public void onReceivePacket(EventReceivePacket \u0445LL\u0445L\u0445\u0445LL\u0445LL) {
        FlagDetector LLL\u0445L\u0445\u0445LL\u0445LL;
        if (LLL\u0445L\u0445\u0445LL\u0445LL.getState() && \u0445LL\u0445L\u0445\u0445LL\u0445LL.getPacket() instanceof SPacketPlayerPosLook) {
            if (Destroy.instance.featureManager.getFeatureByClass(Speed.class).getState()) {
                LLL\u0445L\u0445\u0445LL\u0445LL.featureAlert("Speed");
                Destroy.instance.featureManager.getFeatureByClass(Speed.class).onDisable();
            } else if (Destroy.instance.featureManager.getFeatureByClass(WaterSpeed.class).getState()) {
                LLL\u0445L\u0445\u0445LL\u0445LL.featureAlert("WaterSpeed");
                Destroy.instance.featureManager.getFeatureByClass(WaterSpeed.class).onDisable();
            } else if (Destroy.instance.featureManager.getFeatureByClass(Jesus.class).getState() && FlagDetector.mc.player.isInLiquid()) {
                LLL\u0445L\u0445\u0445LL\u0445LL.featureAlert("Jesus");
                Destroy.instance.featureManager.getFeatureByClass(Jesus.class).onDisable();
            } else if (Destroy.instance.featureManager.getFeatureByClass(Timer.class).getState()) {
                LLL\u0445L\u0445\u0445LL\u0445LL.featureAlert("Timer");
                Destroy.instance.featureManager.getFeatureByClass(Timer.class).onDisable();
            }
        }
    }

    public void featureAlert(String L\u0445\u0445\u0445L\u0445\u0445LL\u0445LL) {
        NotificationManager.publicity(L\u0445\u0445\u0445L\u0445\u0445LL\u0445LL, "Disabling module to lag back", 5, NotificationType.WARNING);
    }
}

