/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventReceivePacket;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;

public class AutoFish
extends Feature {
    public AutoFish() {
        super("AutoFish", "Automatically catches fish for you", Type.Misc);
        AutoFish LL\u0445LLLL\u0445\u0445L;
    }

    @EventTarget
    public void onReceivePacket(EventReceivePacket \u0445\u0445\u0445L\u0445LL\u0445\u0445L) {
        SPacketSoundEffect \u0445L\u0445L\u0445LL\u0445\u0445L;
        if (\u0445\u0445\u0445L\u0445LL\u0445\u0445L.getPacket() instanceof SPacketSoundEffect && (\u0445L\u0445L\u0445LL\u0445\u0445L = (SPacketSoundEffect)\u0445\u0445\u0445L\u0445LL\u0445\u0445L.getPacket()).getCategory() == SoundCategory.NEUTRAL && \u0445L\u0445L\u0445LL\u0445\u0445L.getSound() == SoundEvents.ENTITY_BOBBER_SPLASH && (AutoFish.mc.player.getHeldItemMainhand().getItem() instanceof ItemFishingRod || AutoFish.mc.player.getHeldItemOffhand().getItem() instanceof ItemFishingRod)) {
            AutoFish.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            AutoFish.mc.player.swingArm(EnumHand.MAIN_HAND);
            AutoFish.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            AutoFish.mc.player.swingArm(EnumHand.MAIN_HAND);
        }
    }
}

