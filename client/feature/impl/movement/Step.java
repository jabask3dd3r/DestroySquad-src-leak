/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import net.minecraft.network.play.client.CPacketPlayer;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.motion.EventStep;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.movement.NoClip;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class Step
extends Feature {
    public static TimerHelper time = new TimerHelper();
    public static NumberSetting delay;
    public static NumberSetting heightStep;
    public static ListSetting stepMode;
    public BooleanSetting reverseStep;
    public boolean jump;
    boolean resetTimer;

    public Step() {
        super("Step", "Automatically climbs blocks", Type.Movement);
        Step \u0445\u0445\u0445L\u0445L\u0445LLLLL;
        stepMode = new ListSetting("Step Mode", "Motion", () -> true, "Motion", "Vanilla");
        delay = new NumberSetting("Step Delay", 0.0f, 0.0f, 1.0f, 0.1f, () -> true);
        heightStep = new NumberSetting("Height", 1.0f, 1.0f, 10.0f, 0.5f, () -> true);
        \u0445\u0445\u0445L\u0445L\u0445LLLLL.reverseStep = new BooleanSetting("Reverse Step", false, () -> true);
        \u0445\u0445\u0445L\u0445L\u0445LLLLL.addSettings(stepMode, heightStep, delay, \u0445\u0445\u0445L\u0445L\u0445LLLLL.reverseStep);
    }

    @EventTarget
    public void onStep(EventStep \u0445LLLL\u0445\u0445LLLLL) {
        Step LLLLL\u0445\u0445LLLLL;
        boolean L\u0445\u0445LL\u0445\u0445LLLLL;
        String L\u0445LLL\u0445\u0445LLLLL = stepMode.getOptions();
        float \u0445\u0445LLL\u0445\u0445LLLLL = delay.getNumberValue() * 1000.0f;
        float LL\u0445LL\u0445\u0445LLLLL = heightStep.getNumberValue();
        if (Destroy.instance.featureManager.getFeatureByClass(NoClip.class).getState()) {
            return;
        }
        double \u0445L\u0445LL\u0445\u0445LLLLL = Step.mc.player.getEntityBoundingBox().minY - Step.mc.player.posY;
        boolean bl2 = L\u0445\u0445LL\u0445\u0445LLLLL = \u0445L\u0445LL\u0445\u0445LLLLL >= 0.625;
        if (L\u0445\u0445LL\u0445\u0445LLLLL) {
            time.reset();
        }
        if (LLLLL\u0445\u0445LLLLL.resetTimer) {
            LLLLL\u0445\u0445LLLLL.resetTimer = false;
            Step.mc.timer.timerSpeed = 1.0f;
        }
        if (L\u0445LLL\u0445\u0445LLLLL.equalsIgnoreCase("Motion")) {
            if (Step.mc.player.isCollidedVertically && !Step.mc.gameSettings.keyBindJump.isPressed() && time.hasReached(\u0445\u0445LLL\u0445\u0445LLLLL)) {
                \u0445LLLL\u0445\u0445LLLLL.setStepHeight(LL\u0445LL\u0445\u0445LLLLL);
            }
            if (L\u0445\u0445LL\u0445\u0445LLLLL) {
                Step.mc.timer.timerSpeed = \u0445L\u0445LL\u0445\u0445LLLLL > 1.0 ? 0.12f : 0.4f;
                LLLLL\u0445\u0445LLLLL.resetTimer = true;
                LLLLL\u0445\u0445LLLLL.ncpStep(\u0445L\u0445LL\u0445\u0445LLLLL);
            }
        } else if (L\u0445LLL\u0445\u0445LLLLL.equalsIgnoreCase("Vanilla")) {
            Step.mc.player.stepHeight = heightStep.getNumberValue();
        }
    }

    private void ncpStep(double LLLLLLL\u0445LLLL) {
        double[] \u0445LLLLLL\u0445LLLL = new double[]{0.42, 0.333, 0.248, 0.083, -0.078};
        double L\u0445LLLLL\u0445LLLL = Step.mc.player.posX;
        double \u0445\u0445LLLLL\u0445LLLL = Step.mc.player.posZ;
        double LL\u0445LLLL\u0445LLLL = Step.mc.player.posY;
        if (LLLLLLL\u0445LLLL < 1.1) {
            double LLL\u0445\u0445\u0445\u0445LLLLL = 0.42;
            double \u0445LL\u0445\u0445\u0445\u0445LLLLL = 0.75;
            Step.mc.player.connection.sendPacket(new CPacketPlayer.Position(L\u0445LLLLL\u0445LLLL, LL\u0445LLLL\u0445LLLL + LLL\u0445\u0445\u0445\u0445LLLLL, \u0445\u0445LLLLL\u0445LLLL, false));
            if (LL\u0445LLLL\u0445LLLL + \u0445LL\u0445\u0445\u0445\u0445LLLLL < LL\u0445LLLL\u0445LLLL + LLLLLLL\u0445LLLL) {
                Step.mc.player.connection.sendPacket(new CPacketPlayer.Position(L\u0445LLLLL\u0445LLLL, LL\u0445LLLL\u0445LLLL + \u0445LL\u0445\u0445\u0445\u0445LLLLL, \u0445\u0445LLLLL\u0445LLLL, true));
            }
        } else if (LLLLLLL\u0445LLLL < 1.6) {
            int n2 = 0;
            double[] LLL\u0445\u0445\u0445\u0445LLLLL = \u0445LLLLLL\u0445LLLL;
            int \u0445\u0445L\u0445LLL\u0445LLLL = LLL\u0445\u0445\u0445\u0445LLLLL.length;
            if (n2 < \u0445\u0445L\u0445LLL\u0445LLLL) {
                double L\u0445L\u0445\u0445\u0445\u0445LLLLL = LLL\u0445\u0445\u0445\u0445LLLLL[n2];
                Step.mc.player.connection.sendPacket(new CPacketPlayer.Position(L\u0445LLLLL\u0445LLLL, LL\u0445LLLL\u0445LLLL += L\u0445L\u0445\u0445\u0445\u0445LLLLL, \u0445\u0445LLLLL\u0445LLLL, true));
                ++n2;
                return;
            }
        } else if (LLLLLLL\u0445LLLL < 2.1) {
            int n3 = 0;
            double[] LL\u0445\u0445\u0445\u0445\u0445LLLLL = new double[]{0.425, 0.821, 0.699, 0.599, 1.022, 1.372, 1.652, 1.869};
            double[] \u0445\u0445L\u0445LLL\u0445LLLL = LL\u0445\u0445\u0445\u0445\u0445LLLLL;
            int n4 = \u0445\u0445L\u0445LLL\u0445LLLL.length;
            if (n3 < n4) {
                double \u0445\u0445L\u0445\u0445\u0445\u0445LLLLL = \u0445\u0445L\u0445LLL\u0445LLLL[n3];
                Step.mc.player.connection.sendPacket(new CPacketPlayer.Position(L\u0445LLLLL\u0445LLLL, LL\u0445LLLL\u0445LLLL + \u0445\u0445L\u0445\u0445\u0445\u0445LLLLL, \u0445\u0445LLLLL\u0445LLLL, true));
                ++n3;
                return;
            }
        } else {
            int n5 = 0;
            double[] L\u0445\u0445\u0445\u0445\u0445\u0445LLLLL = new double[]{0.425, 0.821, 0.699, 0.599, 1.022, 1.372, 1.652, 1.869, 2.019, 1.907};
            double[] \u0445\u0445L\u0445LLL\u0445LLLL = L\u0445\u0445\u0445\u0445\u0445\u0445LLLLL;
            int n6 = \u0445\u0445L\u0445LLL\u0445LLLL.length;
            if (n5 < n6) {
                double \u0445L\u0445\u0445\u0445\u0445\u0445LLLLL = \u0445\u0445L\u0445LLL\u0445LLLL[n5];
                Step.mc.player.connection.sendPacket(new CPacketPlayer.Position(L\u0445LLLLL\u0445LLLL, LL\u0445LLLL\u0445LLLL + \u0445L\u0445\u0445\u0445\u0445\u0445LLLLL, \u0445\u0445LLLLL\u0445LLLL, true));
                ++n5;
                return;
            }
        }
    }

    @EventTarget
    public void onPreMotion(EventPreMotion L\u0445LL\u0445LL\u0445LLLL) {
        Step \u0445LLL\u0445LL\u0445LLLL;
        String \u0445\u0445LL\u0445LL\u0445LLLL = stepMode.getOptions();
        \u0445LLL\u0445LL\u0445LLLL.setSuffix(\u0445\u0445LL\u0445LL\u0445LLLL);
        if (Step.mc.player.motionY > 0.0) {
            \u0445LLL\u0445LL\u0445LLLL.jump = true;
        } else if (Step.mc.player.onGround) {
            \u0445LLL\u0445LL\u0445LLLL.jump = false;
        }
        if (\u0445LLL\u0445LL\u0445LLLL.reverseStep.getBoolValue() && !Step.mc.gameSettings.keyBindJump.isKeyDown() && !Step.mc.player.onGround && Step.mc.player.motionY < 0.0 && Step.mc.player.fallDistance < 1.0f && !\u0445LLL\u0445LL\u0445LLLL.jump) {
            Step.mc.player.motionY = -1.0;
        }
    }

    @Override
    public void onDisable() {
        Step \u0445\u0445\u0445L\u0445LL\u0445LLLL;
        Step.mc.player.stepHeight = 0.625f;
        Step.mc.timer.timerSpeed = 1.0f;
        super.onDisable();
    }
}

