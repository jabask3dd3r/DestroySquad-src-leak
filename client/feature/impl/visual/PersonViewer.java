/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.NumberSetting;

public class PersonViewer
extends Feature {
    public static NumberSetting viewerYaw;
    public static NumberSetting fovModifier;
    public static NumberSetting viewerPitch;

    public PersonViewer() {
        super("PersonViewer", "Allows you to change the position of the second and third person camera", Type.Visuals);
        PersonViewer LLL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
        fovModifier = new NumberSetting("FOV Modifier", 4.0f, 1.0f, 50.0f, 1.0f, () -> true);
        viewerYaw = new NumberSetting("Viewer Yaw", 10.0f, -50.0f, 50.0f, 5.0f, () -> true);
        viewerPitch = new NumberSetting("Viewer Pitch", 10.0f, -50.0f, 50.0f, 5.0f, () -> true);
        LLL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.addSettings(fovModifier, viewerYaw, viewerPitch);
    }
}

