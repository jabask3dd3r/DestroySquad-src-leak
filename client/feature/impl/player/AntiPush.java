/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;

public class AntiPush
extends Feature {
    public static BooleanSetting water;
    public static BooleanSetting players;
    public static BooleanSetting blocks;

    public AntiPush() {
        super("NoPush", "\nRemoves knockback from players, water and blocks", Type.Player);
        AntiPush \u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445\u0445L;
        players = new BooleanSetting("Entity", true, () -> true);
        water = new BooleanSetting("Liquid", true, () -> true);
        blocks = new BooleanSetting("Blocks", true, () -> true);
        \u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445\u0445L.addSettings(players, water, blocks);
    }
}

