/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;

public class NoInteract
extends Feature {
    public static BooleanSetting armorStands;
    public static BooleanSetting craftTable;
    public static BooleanSetting standing;
    public static BooleanSetting door;
    public static BooleanSetting hopper;
    public static BooleanSetting furnace;
    public static BooleanSetting dispenser;
    public static BooleanSetting anvil;
    public static BooleanSetting woodenslab;
    public static BooleanSetting lever;

    public NoInteract() {
        super("NoInteract", "Allows you not to press RMB on workbenches, stoves, etc.", Type.Player);
        NoInteract \u0445L\u0445LLLLLL\u0445\u0445LL;
        armorStands = new BooleanSetting("Armor Stand", true, () -> true);
        \u0445L\u0445LLLLLL\u0445\u0445LL.addSettings(armorStands, craftTable, standing, door, hopper, furnace, dispenser, anvil, woodenslab, lever);
    }

    static {
        craftTable = new BooleanSetting("Craft Table", true, () -> true);
        standing = new BooleanSetting("Standing Sign", true, () -> true);
        door = new BooleanSetting("Door", true, () -> true);
        hopper = new BooleanSetting("Hopper", true, () -> true);
        furnace = new BooleanSetting("Furnace", true, () -> true);
        dispenser = new BooleanSetting("Dispenser", true, () -> true);
        anvil = new BooleanSetting("Furnace", true, () -> true);
        woodenslab = new BooleanSetting("Wooden Slab", true, () -> true);
        lever = new BooleanSetting("Lever", true, () -> true);
    }
}

