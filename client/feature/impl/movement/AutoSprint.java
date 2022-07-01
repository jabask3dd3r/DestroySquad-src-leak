/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.movement;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;

public class AutoSprint
extends Feature {
    public AutoSprint() {
        super("AutoSprint", "Holds CTRL for you to run fast", Type.Movement);
        AutoSprint LLLL\u0445L\u0445\u0445\u0445L\u0445L\u0445LL;
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445LL) {
        if (AutoSprint.mc.player.movementInput.moveForward > 0.0f) {
            AutoSprint.mc.player.setSprinting(true);
        }
    }
}

