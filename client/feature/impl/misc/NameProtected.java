/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;

public class NameProtected
extends Feature {
    public static BooleanSetting ownName;
    public static BooleanSetting otherNames;
    public static BooleanSetting skinSpoof;
    public static BooleanSetting tabSpoof;
    public static BooleanSetting scoreBoardSpoof;
    public static BooleanSetting warpSpoof;
    public static BooleanSetting loginSpoof;

    public NameProtected() {
        super("NameProtected", "Allows you to hide information about yourself and other players on a video or stream", Type.Misc);
        NameProtected L\u0445\u0445\u0445\u0445\u0445LLL\u0445L\u0445\u0445LL;
        ownName = new BooleanSetting("Own Name", true, () -> true);
        otherNames = new BooleanSetting("Other Names", false, () -> true);
        tabSpoof = new BooleanSetting("Tab Spoof", false, () -> true);
        skinSpoof = new BooleanSetting("Skin Spoof", false, () -> true);
        scoreBoardSpoof = new BooleanSetting("ScoreBoard Spoof", true, () -> true);
        warpSpoof = new BooleanSetting("Warp Spoof", false, () -> true);
        loginSpoof = new BooleanSetting("Login Spoof", false, () -> true);
        L\u0445\u0445\u0445\u0445\u0445LLL\u0445L\u0445\u0445LL.addSettings(ownName, otherNames, tabSpoof, skinSpoof, scoreBoardSpoof, warpSpoof, loginSpoof);
    }
}

