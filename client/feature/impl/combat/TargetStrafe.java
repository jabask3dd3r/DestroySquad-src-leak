/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.combat.KillAura;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class TargetStrafe
extends Feature {
    public static NumberSetting range;
    public static NumberSetting spd;
    public static NumberSetting boostValue;
    public static NumberSetting boostTicks;
    public static NumberSetting speedIfUsing;
    public static BooleanSetting reversed;
    public static NumberSetting reversedDistance;
    public static BooleanSetting boost;
    public static BooleanSetting autoJump;
    public static BooleanSetting smartStrafe;
    public static BooleanSetting usingItemCheck;
    public static BooleanSetting autoShift;
    private float wrap = 0.0f;
    private boolean switchDir = true;

    public TargetStrafe() {
        super("TargetStrafe", "Strafe for Entity", Type.Movement);
        TargetStrafe LL\u0445LLL\u0445\u0445\u0445\u0445LLLLL;
        spd = new NumberSetting("Strafe Speed", 0.23f, 0.1f, 2.0f, 0.01f, () -> true);
        range = new NumberSetting("Strafe Distance", 2.4f, 0.1f, 6.0f, 0.1f, () -> true);
        boost = new BooleanSetting("DamageBoost", false, () -> true);
        boostValue = new NumberSetting("Boost Value", 0.5f, 0.1f, 4.0f, 0.01f, boost::getBoolValue);
        boostTicks = new NumberSetting("Boost Ticks", 8.0f, 0.0f, 9.0f, 1.0f, boost::getBoolValue);
        reversed = new BooleanSetting("Reversed", false, () -> true);
        reversedDistance = new NumberSetting("Reversed Distance", 3.0f, 1.0f, 6.0f, 0.1f, () -> reversed.getBoolValue());
        autoJump = new BooleanSetting("AutoJump", true, () -> true);
        autoShift = new BooleanSetting("AutoShift", false, () -> true);
        smartStrafe = new BooleanSetting("Smart Strafe", true, () -> true);
        usingItemCheck = new BooleanSetting("Using Item Check", false, () -> true);
        speedIfUsing = new NumberSetting("Speed if using", 0.1f, 0.1f, 2.0f, 0.01f, usingItemCheck::getBoolValue);
        LL\u0445LLL\u0445\u0445\u0445\u0445LLLLL.addSettings(boost, boostTicks, boostValue, reversed, reversedDistance, autoJump, autoShift, usingItemCheck, speedIfUsing, smartStrafe, spd, range);
    }

    @Override
    public void onEnable() {
        TargetStrafe \u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445LLLLL;
        \u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445LLLLL.wrap = 0.0f;
        \u0445\u0445\u0445LLL\u0445\u0445\u0445\u0445LLLLL.switchDir = true;
        super.onEnable();
    }

    private float toDegree(double \u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445LLLLL, double L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LLLLL) {
        return (float)(Math.atan2(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LLLLL - TargetStrafe.mc.player.posZ, \u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445LLLLL - TargetStrafe.mc.player.posX) * 180.0 / Math.PI) - 90.0f;
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLLL) {
        if (KillAura.target == null) {
            return;
        }
        if (TargetStrafe.mc.player.getDistanceToEntity(KillAura.target) <= KillAura.range.getNumberValue() && autoShift.getBoolValue()) {
            TargetStrafe L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLLL;
            TargetStrafe.mc.gameSettings.keyBindSneak.setPressed(L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLLL.getState() && KillAura.target != null && (double)TargetStrafe.mc.player.fallDistance > (double)KillAura.critFallDistance.getNumberValue() + 0.1);
        }
    }

    /*
     * Exception decompiling
     */
    @EventTarget
    public void onPreMotion(EventPreMotion \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLLL) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl226 : GETSTATIC - null : trying to set 0 previously set to 2
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:207)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1559)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:434)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

