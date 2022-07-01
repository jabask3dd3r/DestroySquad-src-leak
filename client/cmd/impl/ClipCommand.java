/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd.impl;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import org.Destroy.client.cmd.CommandAbstract;
import org.Destroy.client.helpers.misc.ChatHelper;

public class ClipCommand
extends CommandAbstract {
    Minecraft mc = Minecraft.getInstance();

    public ClipCommand() {
        super("vclip", "vclip // hclip", ".vclip // hclip ||" + (Object)((Object)ChatFormatting.DARK_AQUA) + " + / - <value> | <down>", "vclip", "hclip");
        ClipCommand \u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445\u0445L;
    }

    @Override
    public void execute(String ... \u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L) {
        ClipCommand LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L;
        if (\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.length > 1) {
            if (\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[0].equalsIgnoreCase("vclip")) {
                try {
                    if (\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[1].equals("down")) {
                        LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.setPositionAndUpdate(LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.posX, -2.0, LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.posZ);
                    }
                    if (\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[1].equals("+")) {
                        LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.setPositionAndUpdate(LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.posX, LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.posY + Double.parseDouble(\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[2]), LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.posZ);
                    }
                    if (\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[1].equals("-")) {
                        LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.setPositionAndUpdate(LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.posX, LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.posY - Double.parseDouble(\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[2]), LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.posZ);
                    }
                }
                catch (Exception LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L) {
                    // empty catch block
                }
            }
            if (\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[0].equalsIgnoreCase("hclip")) {
                double LLLL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L = LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.posX;
                double \u0445LLL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L = LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.posY;
                double L\u0445LL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L = LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.posZ;
                double \u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L = (double)LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.rotationYaw * 0.017453292;
                try {
                    if (\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[1].equals("+")) {
                        LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.setPositionAndUpdate(LLLL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L - Math.sin(\u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L) * Double.parseDouble(\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[2]), \u0445LLL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L, L\u0445LL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L + Math.cos(\u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L) * Double.parseDouble(\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[2]));
                    }
                    if (\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[1].equals("-")) {
                        LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.mc.player.setPositionAndUpdate(LLLL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L + Math.sin(\u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L) * Double.parseDouble(\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[2]), \u0445LLL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L, L\u0445LL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L - Math.cos(\u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L) * Double.parseDouble(\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L[2]));
                    }
                }
                catch (Exception LL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L) {}
            }
        } else {
            ChatHelper.addChatMessage(LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L.getUsage());
        }
    }
}

