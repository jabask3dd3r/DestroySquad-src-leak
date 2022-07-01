/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.network.Packet;
import org.Destroy.client.helpers.misc.TimerHelper;

public interface Helper {
    public static final Minecraft mc = Minecraft.getInstance();
    public static final Gui gui = new Gui();
    public static final Random random = new Random();
    public static final TimerHelper timerHelper = new TimerHelper();
    public static final ScaledResolution sr = new ScaledResolution(mc);

    default public void sendPacket(Packet<?> \u0445L\u0445\u0445\u0445\u0445LLLLLLL) {
        Helper.mc.player.connection.sendPacket(\u0445L\u0445\u0445\u0445\u0445LLLLLLL);
    }
}

