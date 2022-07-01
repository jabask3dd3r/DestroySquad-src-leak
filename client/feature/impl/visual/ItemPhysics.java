/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.NumberSetting;

public class ItemPhysics
extends Feature {
    public static NumberSetting physicsSpeed;

    public ItemPhysics() {
        super("ItemPhysics", "Adds physics to items when they are thrown", Type.Visuals);
        ItemPhysics LLL\u0445LLLLLLLLLL;
        physicsSpeed = new NumberSetting("Physics Speed", 0.5f, 0.1f, 5.0f, 0.5f, () -> true);
        LLL\u0445LLLLLLLLLL.addSettings(physicsSpeed);
    }
}

