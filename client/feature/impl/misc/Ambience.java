/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import net.minecraft.network.play.server.SPacketTimeUpdate;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventReceivePacket;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class Ambience
extends Feature {
    private final NumberSetting time;
    private final ListSetting modeAmbri = new ListSetting("Ambience Mode", "Night", () -> true, "Day", "Night", "Morning", "Sunset", "Spin");
    private long spin = 0L;

    public Ambience() {
        super("WorldTime", "Allows you to change the time of day", Type.Misc);
        Ambience \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL;
        \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.time = new NumberSetting("TimeSpin Speed", 2.0f, 1.0f, 10.0f, 1.0f, () -> true);
        \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.addSettings(\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.modeAmbri, \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.time);
    }

    @EventTarget
    public void onReceivePacket(EventReceivePacket \u0445\u0445LLLL\u0445\u0445\u0445L\u0445LLL) {
        if (\u0445\u0445LLLL\u0445\u0445\u0445L\u0445LLL.getPacket() instanceof SPacketTimeUpdate) {
            \u0445\u0445LLLL\u0445\u0445\u0445L\u0445LLL.setCancelled(true);
        }
    }

    @EventTarget
    public void onUpdate(EventUpdate LLL\u0445LL\u0445\u0445\u0445L\u0445LLL) {
        Ambience \u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445LLL;
        String \u0445LL\u0445LL\u0445\u0445\u0445L\u0445LLL = \u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445LLL.modeAmbri.getOptions();
        \u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445LLL.setSuffix(\u0445LL\u0445LL\u0445\u0445\u0445L\u0445LLL);
        if (\u0445LL\u0445LL\u0445\u0445\u0445L\u0445LLL.equalsIgnoreCase("Spin")) {
            Ambience.mc.world.setWorldTime(\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445LLL.spin);
            \u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445LLL.spin = (long)((float)\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445LLL.spin + \u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445LLL.time.getNumberValue() * 100.0f);
        } else if (\u0445LL\u0445LL\u0445\u0445\u0445L\u0445LLL.equalsIgnoreCase("Day")) {
            Ambience.mc.world.setWorldTime(5000L);
        } else if (\u0445LL\u0445LL\u0445\u0445\u0445L\u0445LLL.equalsIgnoreCase("Night")) {
            Ambience.mc.world.setWorldTime(17000L);
        } else if (\u0445LL\u0445LL\u0445\u0445\u0445L\u0445LLL.equalsIgnoreCase("Morning")) {
            Ambience.mc.world.setWorldTime(0L);
        } else if (\u0445LL\u0445LL\u0445\u0445\u0445L\u0445LLL.equalsIgnoreCase("Sunset")) {
            Ambience.mc.world.setWorldTime(13000L);
        }
    }
}

