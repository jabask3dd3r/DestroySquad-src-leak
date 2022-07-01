/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class Tracers
extends Feature {
    public static BooleanSetting clientColor;
    public static BooleanSetting friend;
    public static BooleanSetting onlyPlayer;
    public static NumberSetting width;
    public static BooleanSetting seeOnly;

    public Tracers() {
        super("Tracers", "Draws a line to the players", Type.Visuals);
        Tracers \u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL;
        friend = new BooleanSetting("Friend Highlight", true, () -> true);
        width = new NumberSetting("Tracers Width", 1.0f, 0.1f, 5.0f, 0.1f, () -> true);
        \u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL.addSettings(friend, seeOnly, onlyPlayer, width);
    }

    public static double angleDifference(float \u0445\u0445L\u0445\u0445L\u0445\u0445LL, float LL\u0445\u0445\u0445L\u0445\u0445LL) {
        float \u0445L\u0445\u0445\u0445L\u0445\u0445LL = Math.abs(\u0445\u0445L\u0445\u0445L\u0445\u0445LL - LL\u0445\u0445\u0445L\u0445\u0445LL) % 360.0f;
        if (\u0445L\u0445\u0445\u0445L\u0445\u0445LL > 180.0f) {
            \u0445L\u0445\u0445\u0445L\u0445\u0445LL = 360.0f - \u0445L\u0445\u0445\u0445L\u0445\u0445LL;
        }
        return \u0445L\u0445\u0445\u0445L\u0445\u0445LL;
    }

    /*
     * Exception decompiling
     */
    @EventTarget
    public void onEvent3D(EventRender3D \u0445LLL\u0445\u0445\u0445\u0445LL) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl33 : GETSTATIC - null : trying to set 0 previously set to 1
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

    static {
        onlyPlayer = new BooleanSetting("Only Player", true, () -> true);
        seeOnly = new BooleanSetting("See Only", false, () -> true);
    }
}

