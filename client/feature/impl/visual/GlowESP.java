/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.vecmath.Vector3d;
import net.minecraft.client.renderer.GLAllocation;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GlowESP
extends Feature {
    public static ListSetting espMode;
    public static BooleanSetting tags;
    public static NumberSetting glowAlpha;
    private final int black = Color.BLACK.getRGB();
    private final ColorSetting colorEsp;
    public ListSetting csgoMode;

    public GlowESP() {
        super("GlowESP", "Glowing players", Type.Visuals);
        GlowESP \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LL\u0445L;
        espMode = new ListSetting("ESP Mode", "Glow", () -> true, "Glow");
        \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LL\u0445L.colorEsp = new ColorSetting("ESP Color", new Color(-849912, true).getRGB(), () -> !GlowESP.espMode.currentMode.equals("Glow"));
        glowAlpha = new NumberSetting("Glow Alpha", 1.0f, 0.2f, 1.0f, 0.1f, () -> GlowESP.espMode.currentMode.equals("Glow"));
        \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LL\u0445L.addSettings(espMode, \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LL\u0445L.csgoMode, \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LL\u0445L.colorEsp);
    }

    /*
     * Exception decompiling
     */
    @EventTarget
    public void onRender3D(EventRender3D LLLLLLLL\u0445L\u0445LL\u0445L) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl25 : ALOAD_3 - null : trying to set 1 previously set to 0
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

    private Vector3d vectorRender2D(int \u0445\u0445\u0445L\u0445LLL\u0445L\u0445LL\u0445L, double LLL\u0445\u0445LLL\u0445L\u0445LL\u0445L, double \u0445LL\u0445\u0445LLL\u0445L\u0445LL\u0445L, double L\u0445L\u0445\u0445LLL\u0445L\u0445LL\u0445L) {
        float \u0445\u0445L\u0445\u0445LLL\u0445L\u0445LL\u0445L = (float)LLL\u0445\u0445LLL\u0445L\u0445LL\u0445L;
        float LL\u0445\u0445\u0445LLL\u0445L\u0445LL\u0445L = (float)\u0445LL\u0445\u0445LLL\u0445L\u0445LL\u0445L;
        float \u0445L\u0445\u0445\u0445LLL\u0445L\u0445LL\u0445L = (float)L\u0445L\u0445\u0445LLL\u0445L\u0445LL\u0445L;
        IntBuffer L\u0445\u0445\u0445\u0445LLL\u0445L\u0445LL\u0445L = GLAllocation.createDirectIntBuffer(16);
        FloatBuffer \u0445\u0445\u0445\u0445\u0445LLL\u0445L\u0445LL\u0445L = GLAllocation.createDirectFloatBuffer(16);
        FloatBuffer LLLLL\u0445LL\u0445L\u0445LL\u0445L = GLAllocation.createDirectFloatBuffer(16);
        FloatBuffer \u0445LLLL\u0445LL\u0445L\u0445LL\u0445L = GLAllocation.createDirectFloatBuffer(4);
        GL11.glGetFloat(2982, \u0445\u0445\u0445\u0445\u0445LLL\u0445L\u0445LL\u0445L);
        GL11.glGetFloat(2983, LLLLL\u0445LL\u0445L\u0445LL\u0445L);
        GL11.glGetInteger(2978, L\u0445\u0445\u0445\u0445LLL\u0445L\u0445LL\u0445L);
        if (GLU.gluProject(\u0445\u0445L\u0445\u0445LLL\u0445L\u0445LL\u0445L, LL\u0445\u0445\u0445LLL\u0445L\u0445LL\u0445L, \u0445L\u0445\u0445\u0445LLL\u0445L\u0445LL\u0445L, \u0445\u0445\u0445\u0445\u0445LLL\u0445L\u0445LL\u0445L, LLLLL\u0445LL\u0445L\u0445LL\u0445L, L\u0445\u0445\u0445\u0445LLL\u0445L\u0445LL\u0445L, \u0445LLLL\u0445LL\u0445L\u0445LL\u0445L)) {
            return new Vector3d(\u0445LLLL\u0445LL\u0445L\u0445LL\u0445L.get(0) / (float)\u0445\u0445\u0445L\u0445LLL\u0445L\u0445LL\u0445L, ((float)Display.getHeight() - \u0445LLLL\u0445LL\u0445L\u0445LL\u0445L.get(1)) / (float)\u0445\u0445\u0445L\u0445LLL\u0445L\u0445LL\u0445L, \u0445LLLL\u0445LL\u0445L\u0445LL\u0445L.get(2));
        }
        return null;
    }
}

