/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.neverhook.client.event.events.impl.input.EventMouse;

public class MiddleClickPearl
extends Feature {
    public MiddleClickPearl() {
        super("MiddleClickPearl", "\nAutomatically throws an ender pearl when you press the mouse wheel", Type.Player);
        MiddleClickPearl L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL;
    }

    @EventTarget
    public void onMouseEvent(EventMouse L\u0445LLLL\u0445\u0445\u0445\u0445\u0445LLL) {
        int LLLLLL\u0445\u0445\u0445\u0445\u0445LLL;
        if (L\u0445LLLL\u0445\u0445\u0445\u0445\u0445LLL.getKey() == 2 && (LLLLLL\u0445\u0445\u0445\u0445\u0445LLL = 0) < 9) {
            ItemStack \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL = MiddleClickPearl.mc.player.inventory.getStackInSlot(LLLLLL\u0445\u0445\u0445\u0445\u0445LLL);
            if (\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL.getItem() == Items.ENDER_PEARL) {
                MiddleClickPearl.mc.player.connection.sendPacket(new CPacketHeldItemChange(LLLLLL\u0445\u0445\u0445\u0445\u0445LLL));
                MiddleClickPearl.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                MiddleClickPearl.mc.player.connection.sendPacket(new CPacketHeldItemChange(MiddleClickPearl.mc.player.inventory.currentItem));
            }
            ++LLLLLL\u0445\u0445\u0445\u0445\u0445LLL;
            return;
        }
    }

    @Override
    public void onDisable() {
        MiddleClickPearl \u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445LLL;
        MiddleClickPearl.mc.player.connection.sendPacket(new CPacketHeldItemChange(MiddleClickPearl.mc.player.inventory.currentItem));
        super.onDisable();
    }
}

