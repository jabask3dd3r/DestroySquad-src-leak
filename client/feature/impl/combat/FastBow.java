/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import net.minecraft.item.ItemBow;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.NumberSetting;

public class FastBow
extends Feature {
    private final NumberSetting ticks = new NumberSetting("Bow Ticks", 1.5f, 1.5f, 10.0f, 0.5f, () -> true);

    public FastBow() {
        super("FastBow", "When holding down the RMB, the player shoots the bow quickly", Type.Combat);
        FastBow L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445LL;
        L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445LL.addSettings(L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445LL.ticks);
    }

    @EventTarget
    public void onUpdate(EventUpdate L\u0445LLLLLL\u0445\u0445L\u0445LL) {
        FastBow \u0445LLLLLLL\u0445\u0445L\u0445LL;
        if (FastBow.mc.player.inventory.getCurrentItem().getItem() instanceof ItemBow && FastBow.mc.player.isBowing() && (float)FastBow.mc.player.getItemInUseMaxCount() >= \u0445LLLLLLL\u0445\u0445L\u0445LL.ticks.getNumberValue()) {
            FastBow.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, FastBow.mc.player.getHorizontalFacing()));
            FastBow.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            FastBow.mc.player.stopActiveHand();
        }
    }
}

