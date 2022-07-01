/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.server.SPacketKeepAlive;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventReceivePacket;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.apache.commons.lang3.RandomUtils;

public class Disabler
extends Feature {
    public long randomLong = 0L;
    public BooleanSetting MatrixDestruction = new BooleanSetting("MatrixDestruction", false, () -> true);
    public BooleanSetting MatrixFlagClear = new BooleanSetting("MatrixFlagClear", false, () -> true);
    public ListSetting mode = new ListSetting("Disabler Mode", "Matrix", () -> true, "Matrix");

    public Disabler() {
        super("Disabler", "Weakens the effect of anti-cheats on you", Type.Misc);
        Disabler LL\u0445\u0445LLLLL\u0445\u0445\u0445\u0445LL;
        LL\u0445\u0445LLLLL\u0445\u0445\u0445\u0445LL.addSettings(LL\u0445\u0445LLLLL\u0445\u0445\u0445\u0445LL.mode, LL\u0445\u0445LLLLL\u0445\u0445\u0445\u0445LL.MatrixDestruction, LL\u0445\u0445LLLLL\u0445\u0445\u0445\u0445LL.MatrixFlagClear);
    }

    @EventTarget
    public void onUpdate(EventUpdate LLLL\u0445LLLL\u0445\u0445\u0445\u0445LL) {
        Disabler \u0445\u0445\u0445\u0445LLLLL\u0445\u0445\u0445\u0445LL;
        \u0445\u0445\u0445\u0445LLLLL\u0445\u0445\u0445\u0445LL.setSuffix(\u0445\u0445\u0445\u0445LLLLL\u0445\u0445\u0445\u0445LL.mode.currentMode);
        if (\u0445\u0445\u0445\u0445LLLLL\u0445\u0445\u0445\u0445LL.mode.currentMode.equals("Matrix") && \u0445\u0445\u0445\u0445LLLLL\u0445\u0445\u0445\u0445LL.MatrixDestruction.getBoolValue() && Disabler.mc.player.ticksExisted % 6 == 0) {
            Disabler.mc.player.connection.sendPacket(new CPacketEntityAction(Disabler.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
        }
    }

    @EventTarget
    public void onReceivePacket(EventReceivePacket \u0445\u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LL) {
        Disabler L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LL;
        if (L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LL.mode.currentMode.equals("Matrix") && L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LL.MatrixFlagClear.getBoolValue()) {
            L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LL.randomLong = RandomUtils.nextLong(0L, 10L);
            if (\u0445\u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LL.getPacket() instanceof SPacketKeepAlive) {
                try {
                    Thread.sleep(50L * L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LL.randomLong);
                }
                catch (InterruptedException \u0445L\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LL) {
                    \u0445L\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LL.printStackTrace();
                }
            }
        }
    }
}

