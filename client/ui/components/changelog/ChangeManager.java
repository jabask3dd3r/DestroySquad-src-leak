/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.changelog;

import java.util.ArrayList;
import org.Destroy.client.ui.components.changelog.ChangeLog;
import org.Destroy.client.ui.components.changelog.ChangeType;

public class ChangeManager {
    public static ArrayList<ChangeLog> changeLogs = new ArrayList();

    public ArrayList<ChangeLog> getChangeLogs() {
        return changeLogs;
    }

    public ChangeManager() {
        ChangeManager LLLLL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L;
        changeLogs.add(new ChangeLog("TeleportExploit", ChangeType.ADD));
        changeLogs.add(new ChangeLog("MemoryIndicator", ChangeType.ADD));
        changeLogs.add(new ChangeLog("TimerIndicator", ChangeType.ADD));
        changeLogs.add(new ChangeLog("NeverLose mode in WaterMark", ChangeType.RECODE));
        changeLogs.add(new ChangeLog("AntiBot", ChangeType.FIXED));
        changeLogs.add(new ChangeLog("AutoBaffSplash", ChangeType.IMPROVED));
        changeLogs.add(new ChangeLog("HitSounds", ChangeType.ADD));
        changeLogs.add(new ChangeLog("NoSlowDown", ChangeType.RECODE));
        changeLogs.add(new ChangeLog("StormHVH mod in Speed", ChangeType.ADD));
        changeLogs.add(new ChangeLog("Fixed many small bugs", ChangeType.FIXED));
        changeLogs.add(new ChangeLog("TargetHuds in KillAura", ChangeType.IMPROVED));
        changeLogs.add(new ChangeLog("Fonts in Modules", ChangeType.IMPROVED));
        changeLogs.add(new ChangeLog("Deleted Extra Mods in KillAura", ChangeType.DELETE));
        changeLogs.add(new ChangeLog("Settings your speed in WaterSpeed", ChangeType.ADD));
        changeLogs.add(new ChangeLog("Deleted Ghost in ClickGUI", ChangeType.DELETE));
        changeLogs.add(new ChangeLog("Removed many extra modules", ChangeType.DELETE));
        changeLogs.add(new ChangeLog("Fixed Scroll ClickGUI Modules", ChangeType.FIXED));
        changeLogs.add(new ChangeLog("AnimeGirl", ChangeType.NEW));
        changeLogs.add(new ChangeLog("Background in GuiMainMenu", ChangeType.NEW));
    }
}

