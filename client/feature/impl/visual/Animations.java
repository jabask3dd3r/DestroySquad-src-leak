/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class Animations
extends Feature {
    public static NumberSetting speed;
    public static NumberSetting spinSpeed;
    public static BooleanSetting animation;
    public static BooleanSetting itemAnimation;
    public static BooleanSetting smallItem;
    public static ListSetting swordAnim;
    public static ListSetting itemAnim;
    public static NumberSetting x;
    public static NumberSetting y;
    public static NumberSetting z;
    public static NumberSetting rotate;
    public static NumberSetting rotate2;
    public static NumberSetting rotate3;
    public static NumberSetting angle;
    public static NumberSetting scale;
    public static NumberSetting smooth;

    public Animations() {
        super("SwingAnimations", "Adds an animation to the sword", Type.Visuals);
        Animations LL\u0445L\u0445\u0445LLL\u0445\u0445L\u0445L;
        animation = new BooleanSetting("Blocking Animation", false, () -> true);
        speed = new NumberSetting("Smooth Attack", 8.0f, 1.0f, 20.0f, 1.0f, () -> !Animations.swordAnim.currentMode.equals("Neutral"));
        spinSpeed = new NumberSetting("Spin Speed", 4.0f, 1.0f, 10.0f, 1.0f, () -> animation.getBoolValue() && Animations.swordAnim.currentMode.equals("Astolfo") || Animations.swordAnim.currentMode.equals("Spin") || itemAnimation.getBoolValue());
        smallItem = new BooleanSetting("Mini Item", false, () -> true);
        swordAnim = new ListSetting("Blocking Animation Mode", "Spin", () -> animation.getBoolValue(), "Spin", "Astolfo", "Custom", "Neutral");
        itemAnim = new ListSetting("Item Animation Mode", "360", () -> itemAnimation.getBoolValue(), "360", "Spin");
        LL\u0445L\u0445\u0445LLL\u0445\u0445L\u0445L.addSettings(animation, swordAnim, itemAnimation, itemAnim, speed, spinSpeed, x, y, z, rotate, rotate2, rotate3, angle, scale, smooth, smallItem);
    }

    @EventTarget
    public void onUpdate(EventUpdate LLL\u0445\u0445\u0445LLL\u0445\u0445L\u0445L) {
        Animations \u0445\u0445\u0445L\u0445\u0445LLL\u0445\u0445L\u0445L;
        \u0445\u0445\u0445L\u0445\u0445LLL\u0445\u0445L\u0445L.setSuffix(swordAnim.getCurrentMode());
    }

    static {
        itemAnimation = new BooleanSetting("Item Animation", false, () -> true);
        x = new NumberSetting("X", 0.0f, -1.0f, 1.0f, 0.01f, () -> Animations.swordAnim.currentMode.equals("Custom"));
        y = new NumberSetting("Y", 0.0f, -1.0f, 1.0f, 0.01f, () -> Animations.swordAnim.currentMode.equals("Custom"));
        z = new NumberSetting("Z", 0.0f, -1.0f, 1.0f, 0.01f, () -> Animations.swordAnim.currentMode.equals("Custom"));
        rotate = new NumberSetting("Rotate 1", 360.0f, -360.0f, 360.0f, 1.0f, () -> Animations.swordAnim.currentMode.equals("Custom"));
        rotate2 = new NumberSetting("Rotate 2", 0.0f, -360.0f, 360.0f, 1.0f, () -> Animations.swordAnim.currentMode.equals("Custom"));
        rotate3 = new NumberSetting("Rotate 3", 0.0f, -360.0f, 360.0f, 1.0f, () -> Animations.swordAnim.currentMode.equals("Custom"));
        angle = new NumberSetting("Angle", 0.0f, -50.0f, 100.0f, 1.0f, () -> Animations.swordAnim.currentMode.equals("Custom"));
        scale = new NumberSetting("Scale", 1.0f, -10.0f, 10.0f, 0.1f, () -> Animations.swordAnim.currentMode.equals("Custom"));
        smooth = new NumberSetting("Smooth", 3.0f, -10.0f, 10.0f, 0.1f, () -> Animations.swordAnim.currentMode.equals("Custom"));
    }
}

