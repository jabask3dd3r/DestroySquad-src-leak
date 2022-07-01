/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd.impl;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.block.Block;
import org.Destroy.client.Destroy;
import org.Destroy.client.cmd.CommandAbstract;
import org.Destroy.client.feature.impl.visual.XRay;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;

public class XrayCommand
extends CommandAbstract {
    public static ArrayList<Integer> blockIDS = new ArrayList();

    public XrayCommand() {
        super("xray", "xray", "\u00c2\u00a76.xray" + (Object)((Object)ChatFormatting.LIGHT_PURPLE) + " add \u00c2\u00a73<blockId> | \u00c2\u00a76.xray" + (Object)((Object)ChatFormatting.LIGHT_PURPLE) + " remove \u00c2\u00a73<blockId> | \u00c2\u00a76.xray" + (Object)((Object)ChatFormatting.LIGHT_PURPLE) + " list | \u00c2\u00a76.xray" + (Object)((Object)ChatFormatting.LIGHT_PURPLE) + " clear", "xray");
        XrayCommand L\u0445L\u0445LL\u0445LL\u0445\u0445\u0445LLL;
    }

    @Override
    public void execute(String ... \u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL) {
        if (\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.length >= 2) {
            if (!Destroy.instance.featureManager.getFeatureByClass(XRay.class).getState()) {
                ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Error " + (Object)((Object)ChatFormatting.WHITE) + "please enable XRay module!");
                NotificationManager.publicity("XrayManager", (Object)((Object)ChatFormatting.RED) + "Error " + (Object)((Object)ChatFormatting.WHITE) + "please enable XRay module!", 4, NotificationType.SUCCESS);
                return;
            }
            if (\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[0].equalsIgnoreCase("xray")) {
                if (\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[1].equalsIgnoreCase("add")) {
                    if (!\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[2].isEmpty()) {
                        if (!blockIDS.contains(Integer.parseInt(\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[2]))) {
                            blockIDS.add(Integer.parseInt(\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[2]));
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "added block: " + (Object)((Object)ChatFormatting.RED) + "\"" + Block.getBlockById(Integer.parseInt(\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[2])).getLocalizedName() + "\"");
                            NotificationManager.publicity("XrayManager", (Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "added block: " + (Object)((Object)ChatFormatting.RED) + "\"" + Block.getBlockById(Integer.parseInt(\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[2])).getLocalizedName() + "\"", 4, NotificationType.SUCCESS);
                        } else {
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Error " + (Object)((Object)ChatFormatting.WHITE) + "this block already have in list!");
                            NotificationManager.publicity("XrayManager", (Object)((Object)ChatFormatting.RED) + "Error " + (Object)((Object)ChatFormatting.WHITE) + "this block already have in list!", 4, NotificationType.SUCCESS);
                        }
                    }
                } else if (\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[1].equalsIgnoreCase("remove")) {
                    if (blockIDS.contains(new Integer(\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[2]))) {
                        blockIDS.remove(new Integer(\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[2]));
                        ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "removed block by id " + Integer.parseInt(\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[2]));
                        NotificationManager.publicity("XrayManager", (Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "removed block by id " + Integer.parseInt(\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[2]), 4, NotificationType.SUCCESS);
                    } else {
                        ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Error " + (Object)((Object)ChatFormatting.WHITE) + "this block doesn't contains in your list!");
                        NotificationManager.publicity("XrayManager", (Object)((Object)ChatFormatting.RED) + "Error " + (Object)((Object)ChatFormatting.WHITE) + "this block doesn't contains in your list!", 4, NotificationType.SUCCESS);
                    }
                } else if (\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[1].equalsIgnoreCase("list")) {
                    if (!blockIDS.isEmpty()) {
                        Iterator<Integer> \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = blockIDS.iterator();
                        if (\u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.hasNext()) {
                            Integer \u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445\u0445LLL = \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.next();
                            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + Block.getBlockById(\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445\u0445LLL).getLocalizedName() + (Object)((Object)ChatFormatting.LIGHT_PURPLE) + " ID: " + \u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445\u0445LLL);
                            return;
                        }
                    } else {
                        ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Error " + (Object)((Object)ChatFormatting.WHITE) + "your block list is empty!");
                        NotificationManager.publicity("XrayManager", (Object)((Object)ChatFormatting.RED) + "Error " + (Object)((Object)ChatFormatting.WHITE) + "your block list is empty!", 4, NotificationType.SUCCESS);
                    }
                } else if (\u0445\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL[1].equalsIgnoreCase("clear")) {
                    if (blockIDS.isEmpty()) {
                        ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Error " + (Object)((Object)ChatFormatting.WHITE) + "your block list is empty!");
                        NotificationManager.publicity("XrayManager", (Object)((Object)ChatFormatting.RED) + "Error " + (Object)((Object)ChatFormatting.WHITE) + "your block list is empty!", 4, NotificationType.SUCCESS);
                    } else {
                        blockIDS.clear();
                        ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "clear block list!");
                        NotificationManager.publicity("XrayManager", (Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "clear block list!", 4, NotificationType.SUCCESS);
                    }
                }
            }
        }
    }
}

