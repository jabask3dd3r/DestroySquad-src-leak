/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBow;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.RotationHelper;

public class AimBot
extends Feature {
    public AimBot() {
        super("AimBot", "", Type.Combat);
        AimBot \u0445L\u0445LLLLLL\u0445L\u0445\u0445LL;
    }

    @EventTarget
    public void onPreMotion(EventPreMotion LL\u0445LL\u0445LLL\u0445L\u0445\u0445LL) {
        Iterator LLL\u0445L\u0445LLL\u0445L\u0445\u0445LL = AimBot.mc.world.loadedEntityList.iterator();
        if (LLL\u0445L\u0445LLL\u0445L\u0445\u0445LL.hasNext()) {
            Entity L\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445LL = (Entity)LLL\u0445L\u0445LLL\u0445L\u0445\u0445LL.next();
            if (AimBot.mc.player.getHeldItemMainhand().getItem() instanceof ItemBow && AimBot.mc.player.getDistanceToEntity(L\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445LL) < 6.0f && L\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445LL != null) {
                float[] \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445\u0445LL = RotationHelper.getRotations(L\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445LL, false, 360.0f, 360.0f, 2.0f, 2.0f);
                LL\u0445LL\u0445LLL\u0445L\u0445\u0445LL.setYaw(\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445\u0445LL[0]);
                AimBot.mc.player.rotationYawHead = \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445\u0445LL[0];
                AimBot.mc.player.renderYawOffset = \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445\u0445LL[0];
            }
            return;
        }
    }
}

