/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.GCDCalcHelper;
import org.Destroy.client.helpers.math.MathematicHelper;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class AntiAim
extends Feature {
    public float rot = 0.0f;
    public NumberSetting spinSpeed;
    public ListSetting pitchMode;
    public ListSetting mode = new ListSetting("Yaw Mode", "Jitter", () -> true, "Freestanding", "Spin", "Jitter");
    public ListSetting degreeMode;

    public AntiAim() {
        super("AntiAim", "AntiAim like in CSGO / Krutilka", Type.Player);
        AntiAim \u0445\u0445LLL\u0445LLLL\u0445\u0445LLL;
        \u0445\u0445LLL\u0445LLLL\u0445\u0445LLL.spinSpeed = new NumberSetting("Spin Speed", 1.0f, 0.0f, 10.0f, 0.1f, () -> {
            AntiAim \u0445LLLLL\u0445LLL\u0445\u0445LLL;
            return \u0445LLLLL\u0445LLL\u0445\u0445LLL.degreeMode.currentMode.equals("Spin");
        });
        \u0445\u0445LLL\u0445LLLL\u0445\u0445LLL.pitchMode = new ListSetting("Custom Pitch", "Down", () -> true, "None", "Down", "Up", "Fake-Down", "Fake-Up");
        \u0445\u0445LLL\u0445LLLL\u0445\u0445LLL.degreeMode = new ListSetting("Degree Mode", "Spin", () -> true, "Random", "Spin");
        \u0445\u0445LLL\u0445LLLL\u0445\u0445LLL.addSettings(\u0445\u0445LLL\u0445LLLL\u0445\u0445LLL.mode, \u0445\u0445LLL\u0445LLLL\u0445\u0445LLL.spinSpeed, \u0445\u0445LLL\u0445LLLL\u0445\u0445LLL.pitchMode, \u0445\u0445LLL\u0445LLLL\u0445\u0445LLL.degreeMode);
    }

    @EventTarget
    public void onPreMotion(EventPreMotion \u0445LLL\u0445\u0445LLLL\u0445\u0445LLL) {
        AntiAim LLLL\u0445\u0445LLLL\u0445\u0445LLL;
        String L\u0445LL\u0445\u0445LLLL\u0445\u0445LLL = LLLL\u0445\u0445LLLL\u0445\u0445LLL.mode.getCurrentMode();
        LLLL\u0445\u0445LLLL\u0445\u0445LLL.setSuffix(L\u0445LL\u0445\u0445LLLL\u0445\u0445LLL);
        float \u0445\u0445LL\u0445\u0445LLLL\u0445\u0445LLL = LLLL\u0445\u0445LLLL\u0445\u0445LLL.spinSpeed.getNumberValue() * 10.0f;
        switch (LLLL\u0445\u0445LLLL\u0445\u0445LLL.pitchMode.currentMode) {
            case "Down": {
                \u0445LLL\u0445\u0445LLLL\u0445\u0445LLL.setPitch(90.0f);
                AntiAim.mc.player.rotationPitchHead = 90.0f;
                break;
            }
            case "Up": {
                \u0445LLL\u0445\u0445LLLL\u0445\u0445LLL.setPitch(-90.0f);
                AntiAim.mc.player.rotationPitchHead = -90.0f;
                break;
            }
            case "Fake-Down": {
                AntiAim.mc.player.rotationPitchHead = 90.0f;
                break;
            }
            case "Fake-Up": {
                AntiAim.mc.player.rotationPitchHead = -90.0f;
            }
        }
        if (LLLL\u0445\u0445LLLL\u0445\u0445LLL.mode.currentMode.equals("Jitter")) {
            float \u0445\u0445L\u0445L\u0445LLLL\u0445\u0445LLL = AntiAim.mc.player.rotationYaw + 180.0f + (AntiAim.mc.player.ticksExisted % 8 < 4 ? MathematicHelper.randomizeFloat(-90.0f, 90.0f) : -MathematicHelper.randomizeFloat(90.0f, -90.0f));
            \u0445LLL\u0445\u0445LLLL\u0445\u0445LLL.setYaw(GCDCalcHelper.getFixedRotation(\u0445\u0445L\u0445L\u0445LLLL\u0445\u0445LLL));
            AntiAim.mc.player.renderYawOffset = \u0445\u0445L\u0445L\u0445LLLL\u0445\u0445LLL;
            AntiAim.mc.player.rotationYawHead = \u0445\u0445L\u0445L\u0445LLLL\u0445\u0445LLL;
        } else if (L\u0445LL\u0445\u0445LLLL\u0445\u0445LLL.equals("Freestanding")) {
            float LL\u0445\u0445L\u0445LLLL\u0445\u0445LLL = (float)((double)(AntiAim.mc.player.rotationYaw + 5.0f) + Math.random() * 175.0);
            \u0445LLL\u0445\u0445LLLL\u0445\u0445LLL.setYaw(GCDCalcHelper.getFixedRotation(LL\u0445\u0445L\u0445LLLL\u0445\u0445LLL));
            AntiAim.mc.player.renderYawOffset = LL\u0445\u0445L\u0445LLLL\u0445\u0445LLL;
            AntiAim.mc.player.rotationYawHead = LL\u0445\u0445L\u0445LLLL\u0445\u0445LLL;
        } else if (L\u0445LL\u0445\u0445LLLL\u0445\u0445LLL.equalsIgnoreCase("Spin")) {
            float \u0445L\u0445\u0445L\u0445LLLL\u0445\u0445LLL = GCDCalcHelper.getFixedRotation((float)(Math.floor(LLLL\u0445\u0445LLLL\u0445\u0445LLL.spinAim(\u0445\u0445LL\u0445\u0445LLLL\u0445\u0445LLL)) + (double)MathematicHelper.randomizeFloat(-4.0f, 1.0f)));
            \u0445LLL\u0445\u0445LLLL\u0445\u0445LLL.setYaw(\u0445L\u0445\u0445L\u0445LLLL\u0445\u0445LLL);
            AntiAim.mc.player.renderYawOffset = \u0445L\u0445\u0445L\u0445LLLL\u0445\u0445LLL;
            AntiAim.mc.player.rotationYawHead = \u0445L\u0445\u0445L\u0445LLLL\u0445\u0445LLL;
        }
        if (AntiAim.mc.player.isSneaking()) {
            if (LLLL\u0445\u0445LLLL\u0445\u0445LLL.degreeMode.currentMode.equals("Spin")) {
                float L\u0445\u0445\u0445L\u0445LLLL\u0445\u0445LLL = GCDCalcHelper.getFixedRotation((float)(Math.floor(LLLL\u0445\u0445LLLL\u0445\u0445LLL.spinAim(\u0445\u0445LL\u0445\u0445LLLL\u0445\u0445LLL)) + (double)MathematicHelper.randomizeFloat(-4.0f, 1.0f)));
                \u0445LLL\u0445\u0445LLLL\u0445\u0445LLL.setYaw(L\u0445\u0445\u0445L\u0445LLLL\u0445\u0445LLL);
                AntiAim.mc.player.renderYawOffset = L\u0445\u0445\u0445L\u0445LLLL\u0445\u0445LLL;
                AntiAim.mc.player.rotationYawHead = L\u0445\u0445\u0445L\u0445LLLL\u0445\u0445LLL;
            } else if (LLLL\u0445\u0445LLLL\u0445\u0445LLL.degreeMode.currentMode.equals("Random")) {
                float \u0445\u0445\u0445\u0445L\u0445LLLL\u0445\u0445LLL = (float)((double)AntiAim.mc.player.rotationYaw + Math.floor(LLLL\u0445\u0445LLLL\u0445\u0445LLL.spinAim(\u0445\u0445LL\u0445\u0445LLLL\u0445\u0445LLL) + (AntiAim.mc.player.ticksExisted % 8 < 4 ? MathematicHelper.randomizeFloat(33.0f, 22.0f) : -MathematicHelper.randomizeFloat(33.0f, 22.0f))));
                \u0445LLL\u0445\u0445LLLL\u0445\u0445LLL.setYaw(\u0445\u0445\u0445\u0445L\u0445LLLL\u0445\u0445LLL);
                AntiAim.mc.player.renderYawOffset = \u0445\u0445\u0445\u0445L\u0445LLLL\u0445\u0445LLL;
                AntiAim.mc.player.rotationYawHead = \u0445\u0445\u0445\u0445L\u0445LLLL\u0445\u0445LLL;
            }
        }
    }

    public float spinAim(float \u0445L\u0445\u0445\u0445\u0445LLLL\u0445\u0445LLL) {
        AntiAim LL\u0445\u0445\u0445\u0445LLLL\u0445\u0445LLL;
        LL\u0445\u0445\u0445\u0445LLLL\u0445\u0445LLL.rot += \u0445L\u0445\u0445\u0445\u0445LLLL\u0445\u0445LLL;
        return LL\u0445\u0445\u0445\u0445LLLL\u0445\u0445LLL.rot;
    }
}

