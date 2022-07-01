/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumHandSide;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventTransformSideFirstPerson;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.NumberSetting;

public class ViewModel
extends Feature {
    public static NumberSetting rightx;
    public static NumberSetting righty;
    public static NumberSetting rightz;
    public static NumberSetting leftx;
    public static NumberSetting lefty;
    public static NumberSetting leftz;

    public ViewModel() {
        super("ViewModel", "Allows you to edit the position of items in your hand", Type.Visuals);
        ViewModel L\u0445L\u0445L\u0445LL\u0445LL\u0445L\u0445L;
        rightx = new NumberSetting("RightX", 0.0f, -2.0f, 2.0f, 0.1f, () -> true);
        righty = new NumberSetting("RightY", 0.2f, -2.0f, 2.0f, 0.1f, () -> true);
        rightz = new NumberSetting("RightZ", 0.2f, -2.0f, 2.0f, 0.1f, () -> true);
        leftx = new NumberSetting("LeftX", 0.0f, -2.0f, 2.0f, 0.1f, () -> true);
        lefty = new NumberSetting("LeftY", 0.2f, -2.0f, 2.0f, 0.1f, () -> true);
        leftz = new NumberSetting("LeftZ", 0.2f, -2.0f, 2.0f, 0.1f, () -> true);
        L\u0445L\u0445L\u0445LL\u0445LL\u0445L\u0445L.addSettings(rightx, righty, rightz, leftx, lefty, leftz);
    }

    @EventTarget
    public void onSidePerson(EventTransformSideFirstPerson LLLL\u0445\u0445LL\u0445LL\u0445L\u0445L) {
        if (LLLL\u0445\u0445LL\u0445LL\u0445L\u0445L.getEnumHandSide() == EnumHandSide.RIGHT) {
            GlStateManager.translate(rightx.getNumberValue(), righty.getNumberValue(), rightz.getNumberValue());
        }
        if (LLLL\u0445\u0445LL\u0445LL\u0445L\u0445L.getEnumHandSide() == EnumHandSide.LEFT) {
            GlStateManager.translate(-leftx.getNumberValue(), lefty.getNumberValue(), leftz.getNumberValue());
        }
    }
}

