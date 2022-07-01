/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.RotationHelper;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.neverhook.client.event.events.impl.input.EventMouse;

public class ClipHelper
extends Feature {
    public static BooleanSetting disableBlockLight;
    public static NumberSetting maxDistance;

    public ClipHelper() {
        super("ClipHelper", "Clips along the axis, by clicking the mouse | NO ACTUAL", Type.Player);
        ClipHelper L\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L;
        maxDistance = new NumberSetting("Max Distance", 50.0f, 5.0f, 150.0f, 1.0f, () -> true);
        disableBlockLight = new BooleanSetting("Disable block light", true, () -> true);
        L\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445L.addSettings(maxDistance, disableBlockLight);
    }

    @EventTarget
    public void onMouse(EventMouse \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L) {
        Iterator \u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L = ClipHelper.mc.world.loadedEntityList.iterator();
        if (\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L.hasNext()) {
            Entity \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L = (Entity)\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L.next();
            BlockPos \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L = new BlockPos(0.0, ClipHelper.mc.player.posY, 0.0);
            BlockPos LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L = new BlockPos(0.0, \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L.posY, 0.0);
            if (RotationHelper.isLookingAtEntity(ClipHelper.mc.player.rotationYaw, ClipHelper.mc.player.rotationPitch, 0.15f, 0.15f, 0.15f, \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L, maxDistance.getNumberValue())) {
                int L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L = (int)\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L.posY;
                if (!\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L.equals(LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L) && ClipHelper.mc.gameSettings.thirdPersonView == 0 && \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L.getKey() == 2) {
                    ClipHelper.mc.player.setPositionAndUpdate(ClipHelper.mc.player.posX, L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L, ClipHelper.mc.player.posZ);
                    ChatHelper.addChatMessage("Clip to entity " + (Object)((Object)ChatFormatting.RED) + \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L.getName() + (Object)((Object)ChatFormatting.WHITE) + " on Y " + (Object)((Object)ChatFormatting.RED) + L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L);
                }
            }
            return;
        }
    }
}

