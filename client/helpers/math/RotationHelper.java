/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.math;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventSendPacket;
import org.Destroy.client.event.events.impl.player.EventPlayerState;
import org.Destroy.client.feature.impl.combat.KillAura;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.math.GCDCalcHelper;
import org.Destroy.client.helpers.math.MathematicHelper;

public class RotationHelper
implements Helper {
    public RotationHelper() {
        RotationHelper \u0445LLL\u0445LLLLL;
    }

    public static Vec3d getEyesPos() {
        return new Vec3d(RotationHelper.mc.player.posX, RotationHelper.mc.player.getEntityBoundingBox().minY + (double)RotationHelper.mc.player.getEyeHeight(), RotationHelper.mc.player.posZ);
    }

    public static boolean isLookingAtEntity(float L\u0445\u0445\u0445\u0445LLLLL, float \u0445\u0445\u0445\u0445\u0445LLLLL, float LLLLL\u0445LLLL, float \u0445LLLL\u0445LLLL, float L\u0445LLL\u0445LLLL, Entity \u0445\u0445LLL\u0445LLLL, double LL\u0445LL\u0445LLLL) {
        Vec3d \u0445L\u0445LL\u0445LLLL = RotationHelper.mc.player.getPositionEyes(1.0f);
        Vec3d L\u0445\u0445LL\u0445LLLL = Entity.getVectorForRotation(\u0445\u0445\u0445\u0445\u0445LLLLL, L\u0445\u0445\u0445\u0445LLLLL);
        Vec3d \u0445\u0445\u0445LL\u0445LLLL = \u0445L\u0445LL\u0445LLLL.addVector(L\u0445\u0445LL\u0445LLLL.xCoord * LL\u0445LL\u0445LLLL, L\u0445\u0445LL\u0445LLLL.yCoord * LL\u0445LL\u0445LLLL, L\u0445\u0445LL\u0445LLLL.zCoord * LL\u0445LL\u0445LLLL);
        RayTraceResult LLL\u0445L\u0445LLLL = RotationHelper.mc.world.rayTraceBlocks(\u0445L\u0445LL\u0445LLLL, \u0445\u0445\u0445LL\u0445LLLL, false, false, true);
        if (LLL\u0445L\u0445LLLL == null) {
            return false;
        }
        return \u0445\u0445LLL\u0445LLLL.getEntityBoundingBox().expand(LLLLL\u0445LLLL, \u0445LLLL\u0445LLLL, L\u0445LLL\u0445LLLL).calculateIntercept(\u0445L\u0445LL\u0445LLLL, \u0445\u0445\u0445LL\u0445LLLL) != null;
    }

    public static float[] getRotations(Entity L\u0445LLLL\u0445LLL, boolean \u0445\u0445LLLL\u0445LLL, float LL\u0445LLL\u0445LLL, float \u0445L\u0445LLL\u0445LLL, float L\u0445\u0445LLL\u0445LLL, float \u0445\u0445\u0445LLL\u0445LLL) {
        double LLL\u0445LL\u0445LLL = L\u0445LLLL\u0445LLL.posX + (L\u0445LLLL\u0445LLL.posX - L\u0445LLLL\u0445LLL.prevPosX) * (double)KillAura.rotPredict.getNumberValue() - RotationHelper.mc.player.posX - RotationHelper.mc.player.motionX * (double)KillAura.rotPredict.getNumberValue();
        double \u0445LL\u0445LL\u0445LLL = L\u0445LLLL\u0445LLL.posZ + (L\u0445LLLL\u0445LLL.posZ - L\u0445LLLL\u0445LLL.prevPosZ) * (double)KillAura.rotPredict.getNumberValue() - RotationHelper.mc.player.posZ - RotationHelper.mc.player.motionZ * (double)KillAura.rotPredict.getNumberValue();
        double L\u0445L\u0445LL\u0445LLL = L\u0445LLLL\u0445LLL.posY + (double)L\u0445LLLL\u0445LLL.getEyeHeight() - (RotationHelper.mc.player.posY + (double)RotationHelper.mc.player.getEyeHeight()) - (double)KillAura.pitchValue.getNumberValue() - (KillAura.walls.getBoolValue() && KillAura.bypass.getBoolValue() && !((EntityLivingBase)L\u0445LLLL\u0445LLL).canEntityBeSeen(RotationHelper.mc.player) ? -0.38 : 0.0);
        float \u0445\u0445L\u0445LL\u0445LLL = 0.0f;
        if (\u0445\u0445LLLL\u0445LLL) {
            \u0445\u0445L\u0445LL\u0445LLL = MathematicHelper.randomizeFloat(L\u0445\u0445LLL\u0445LLL, -L\u0445\u0445LLL\u0445LLL);
        }
        float LL\u0445\u0445LL\u0445LLL = 0.0f;
        if (\u0445\u0445LLLL\u0445LLL) {
            LL\u0445\u0445LL\u0445LLL = MathematicHelper.randomizeFloat(\u0445\u0445\u0445LLL\u0445LLL, -\u0445\u0445\u0445LLL\u0445LLL);
        }
        double \u0445L\u0445\u0445LL\u0445LLL = MathHelper.sqrt(LLL\u0445LL\u0445LLL * LLL\u0445LL\u0445LLL + \u0445LL\u0445LL\u0445LLL * \u0445LL\u0445LL\u0445LLL);
        float L\u0445\u0445\u0445LL\u0445LLL = (float)(Math.atan2(\u0445LL\u0445LL\u0445LLL, LLL\u0445LL\u0445LLL) * 180.0 / Math.PI - 90.0) + \u0445\u0445L\u0445LL\u0445LLL;
        float \u0445\u0445\u0445\u0445LL\u0445LLL = (float)(-(Math.atan2(L\u0445L\u0445LL\u0445LLL, \u0445L\u0445\u0445LL\u0445LLL) * 180.0 / Math.PI)) + LL\u0445\u0445LL\u0445LLL;
        L\u0445\u0445\u0445LL\u0445LLL = RotationHelper.mc.player.rotationYaw + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees(L\u0445\u0445\u0445LL\u0445LLL - RotationHelper.mc.player.rotationYaw));
        \u0445\u0445\u0445\u0445LL\u0445LLL = RotationHelper.mc.player.rotationPitch + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees(\u0445\u0445\u0445\u0445LL\u0445LLL - RotationHelper.mc.player.rotationPitch));
        \u0445\u0445\u0445\u0445LL\u0445LLL = MathHelper.clamp(\u0445\u0445\u0445\u0445LL\u0445LLL, -90.0f, 90.0f);
        L\u0445\u0445\u0445LL\u0445LLL = RotationHelper.updateRotation(RotationHelper.mc.player.rotationYaw, L\u0445\u0445\u0445LL\u0445LLL, MathematicHelper.randomizeFloat(\u0445L\u0445LLL\u0445LLL, LL\u0445LLL\u0445LLL));
        \u0445\u0445\u0445\u0445LL\u0445LLL = RotationHelper.updateRotation(RotationHelper.mc.player.rotationPitch, \u0445\u0445\u0445\u0445LL\u0445LLL, MathematicHelper.randomizeFloat(\u0445L\u0445LLL\u0445LLL, LL\u0445LLL\u0445LLL));
        return new float[]{L\u0445\u0445\u0445LL\u0445LLL, \u0445\u0445\u0445\u0445LL\u0445LLL};
    }

    public static float[] getRotationVector(Vec3d LL\u0445\u0445L\u0445\u0445LLL, boolean \u0445L\u0445\u0445L\u0445\u0445LLL, float L\u0445\u0445\u0445L\u0445\u0445LLL, float \u0445\u0445\u0445\u0445L\u0445\u0445LLL, float LLLL\u0445\u0445\u0445LLL) {
        Vec3d \u0445LLL\u0445\u0445\u0445LLL = RotationHelper.getEyesPos();
        double L\u0445LL\u0445\u0445\u0445LLL = LL\u0445\u0445L\u0445\u0445LLL.xCoord - \u0445LLL\u0445\u0445\u0445LLL.xCoord;
        double \u0445\u0445LL\u0445\u0445\u0445LLL = LL\u0445\u0445L\u0445\u0445LLL.yCoord - (RotationHelper.mc.player.posY + (double)RotationHelper.mc.player.getEyeHeight() + 0.5);
        double LL\u0445L\u0445\u0445\u0445LLL = LL\u0445\u0445L\u0445\u0445LLL.zCoord - \u0445LLL\u0445\u0445\u0445LLL.zCoord;
        double \u0445L\u0445L\u0445\u0445\u0445LLL = Math.sqrt(L\u0445LL\u0445\u0445\u0445LLL * L\u0445LL\u0445\u0445\u0445LLL + LL\u0445L\u0445\u0445\u0445LLL * LL\u0445L\u0445\u0445\u0445LLL);
        float L\u0445\u0445L\u0445\u0445\u0445LLL = 0.0f;
        if (\u0445L\u0445\u0445L\u0445\u0445LLL) {
            L\u0445\u0445L\u0445\u0445\u0445LLL = MathematicHelper.randomizeFloat(-L\u0445\u0445\u0445L\u0445\u0445LLL, L\u0445\u0445\u0445L\u0445\u0445LLL);
        }
        float \u0445\u0445\u0445L\u0445\u0445\u0445LLL = 0.0f;
        if (\u0445L\u0445\u0445L\u0445\u0445LLL) {
            \u0445\u0445\u0445L\u0445\u0445\u0445LLL = MathematicHelper.randomizeFloat(-\u0445\u0445\u0445\u0445L\u0445\u0445LLL, \u0445\u0445\u0445\u0445L\u0445\u0445LLL);
        }
        float LLL\u0445\u0445\u0445\u0445LLL = (float)(Math.toDegrees(Math.atan2(LL\u0445L\u0445\u0445\u0445LLL, L\u0445LL\u0445\u0445\u0445LLL)) - 90.0) + L\u0445\u0445L\u0445\u0445\u0445LLL;
        float \u0445LL\u0445\u0445\u0445\u0445LLL = (float)(-Math.toDegrees(Math.atan2(\u0445\u0445LL\u0445\u0445\u0445LLL, \u0445L\u0445L\u0445\u0445\u0445LLL))) + \u0445\u0445\u0445L\u0445\u0445\u0445LLL;
        LLL\u0445\u0445\u0445\u0445LLL = RotationHelper.mc.player.rotationYaw + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees(LLL\u0445\u0445\u0445\u0445LLL - RotationHelper.mc.player.rotationYaw));
        \u0445LL\u0445\u0445\u0445\u0445LLL = RotationHelper.mc.player.rotationPitch + GCDCalcHelper.getFixedRotation(MathHelper.wrapDegrees(\u0445LL\u0445\u0445\u0445\u0445LLL - RotationHelper.mc.player.rotationPitch));
        \u0445LL\u0445\u0445\u0445\u0445LLL = MathHelper.clamp(\u0445LL\u0445\u0445\u0445\u0445LLL, -90.0f, 90.0f);
        LLL\u0445\u0445\u0445\u0445LLL = RotationHelper.updateRotation(RotationHelper.mc.player.rotationYaw, LLL\u0445\u0445\u0445\u0445LLL, LLLL\u0445\u0445\u0445LLL);
        \u0445LL\u0445\u0445\u0445\u0445LLL = RotationHelper.updateRotation(RotationHelper.mc.player.rotationPitch, \u0445LL\u0445\u0445\u0445\u0445LLL, LLLL\u0445\u0445\u0445LLL);
        return new float[]{LLL\u0445\u0445\u0445\u0445LLL, \u0445LL\u0445\u0445\u0445\u0445LLL};
    }

    public static float getAngleEntity(Entity \u0445L\u0445\u0445LLL\u0445LL) {
        float L\u0445\u0445\u0445LLL\u0445LL = RotationHelper.mc.player.rotationYaw;
        double \u0445\u0445\u0445\u0445LLL\u0445LL = \u0445L\u0445\u0445LLL\u0445LL.posX - RotationHelper.mc.player.posX;
        double LLLL\u0445LL\u0445LL = \u0445L\u0445\u0445LLL\u0445LL.posZ - RotationHelper.mc.player.posZ;
        float \u0445LLL\u0445LL\u0445LL = (float)(Math.atan2(LLLL\u0445LL\u0445LL, \u0445\u0445\u0445\u0445LLL\u0445LL) * 180.0 / Math.PI - 90.0);
        return L\u0445\u0445\u0445LLL\u0445LL + MathHelper.wrapDegrees(\u0445LLL\u0445LL\u0445LL - L\u0445\u0445\u0445LLL\u0445LL);
    }

    public static float[] getFacePosRemote(EntityLivingBase LL\u0445LL\u0445L\u0445LL, Entity \u0445L\u0445LL\u0445L\u0445LL, boolean L\u0445\u0445LL\u0445L\u0445LL) {
        Vec3d \u0445\u0445\u0445LL\u0445L\u0445LL = new Vec3d(LL\u0445LL\u0445L\u0445LL.posX, LL\u0445LL\u0445L\u0445LL.posY, LL\u0445LL\u0445L\u0445LL.posZ);
        Vec3d LLL\u0445L\u0445L\u0445LL = new Vec3d(\u0445L\u0445LL\u0445L\u0445LL.posX, \u0445L\u0445LL\u0445L\u0445LL.posY, \u0445L\u0445LL\u0445L\u0445LL.posZ);
        double \u0445LL\u0445L\u0445L\u0445LL = LLL\u0445L\u0445L\u0445LL.xCoord - \u0445\u0445\u0445LL\u0445L\u0445LL.xCoord;
        double L\u0445L\u0445L\u0445L\u0445LL = LLL\u0445L\u0445L\u0445LL.yCoord - \u0445\u0445\u0445LL\u0445L\u0445LL.yCoord;
        double \u0445\u0445L\u0445L\u0445L\u0445LL = LLL\u0445L\u0445L\u0445LL.zCoord - \u0445\u0445\u0445LL\u0445L\u0445LL.zCoord;
        float LL\u0445\u0445L\u0445L\u0445LL = 0.0f;
        if (L\u0445\u0445LL\u0445L\u0445LL) {
            LL\u0445\u0445L\u0445L\u0445LL = MathematicHelper.randomizeFloat(-2.0f, 2.0f);
        }
        float \u0445L\u0445\u0445L\u0445L\u0445LL = 0.0f;
        if (L\u0445\u0445LL\u0445L\u0445LL) {
            \u0445L\u0445\u0445L\u0445L\u0445LL = MathematicHelper.randomizeFloat(-2.0f, 2.0f);
        }
        double L\u0445\u0445\u0445L\u0445L\u0445LL = MathHelper.sqrt(\u0445LL\u0445L\u0445L\u0445LL * \u0445LL\u0445L\u0445L\u0445LL + \u0445\u0445L\u0445L\u0445L\u0445LL * \u0445\u0445L\u0445L\u0445L\u0445LL);
        float \u0445\u0445\u0445\u0445L\u0445L\u0445LL = (float)(Math.atan2(\u0445\u0445L\u0445L\u0445L\u0445LL, \u0445LL\u0445L\u0445L\u0445LL) * 180.0 / Math.PI) - 90.0f + LL\u0445\u0445L\u0445L\u0445LL;
        float LLLL\u0445\u0445L\u0445LL = (float)(-(Math.atan2(L\u0445L\u0445L\u0445L\u0445LL, L\u0445\u0445\u0445L\u0445L\u0445LL) * 180.0 / Math.PI)) + \u0445L\u0445\u0445L\u0445L\u0445LL;
        return new float[]{MathHelper.wrapDegrees(\u0445\u0445\u0445\u0445L\u0445L\u0445LL), MathHelper.wrapDegrees(LLLL\u0445\u0445L\u0445LL)};
    }

    public static float updateRotation(float L\u0445LLLL\u0445\u0445LL, float \u0445\u0445LLLL\u0445\u0445LL, float LL\u0445LLL\u0445\u0445LL) {
        float \u0445L\u0445LLL\u0445\u0445LL = MathHelper.wrapDegrees(\u0445\u0445LLLL\u0445\u0445LL - L\u0445LLLL\u0445\u0445LL);
        if (\u0445L\u0445LLL\u0445\u0445LL > LL\u0445LLL\u0445\u0445LL) {
            \u0445L\u0445LLL\u0445\u0445LL = LL\u0445LLL\u0445\u0445LL;
        }
        if (\u0445L\u0445LLL\u0445\u0445LL < -LL\u0445LLL\u0445\u0445LL) {
            \u0445L\u0445LLL\u0445\u0445LL = -LL\u0445LLL\u0445\u0445LL;
        }
        return L\u0445LLLL\u0445\u0445LL + \u0445L\u0445LLL\u0445\u0445LL;
    }

    public static float updateRotation1(float L\u0445\u0445\u0445LL\u0445\u0445LL, float \u0445\u0445\u0445\u0445LL\u0445\u0445LL, float LLLL\u0445L\u0445\u0445LL) {
        float \u0445LLL\u0445L\u0445\u0445LL = MathHelper.wrapDegrees(\u0445\u0445\u0445\u0445LL\u0445\u0445LL - L\u0445\u0445\u0445LL\u0445\u0445LL);
        if (\u0445LLL\u0445L\u0445\u0445LL > LLLL\u0445L\u0445\u0445LL) {
            \u0445LLL\u0445L\u0445\u0445LL = LLLL\u0445L\u0445\u0445LL;
        }
        if (\u0445LLL\u0445L\u0445\u0445LL < -LLLL\u0445L\u0445\u0445LL) {
            \u0445LLL\u0445L\u0445\u0445LL = -LLLL\u0445L\u0445\u0445LL;
        }
        return L\u0445\u0445\u0445LL\u0445\u0445LL + \u0445LLL\u0445L\u0445\u0445LL;
    }

    public static class Rotation {
        public static boolean isReady = false;
        public static float packetPitch;
        public static float packetYaw;
        public static float lastPacketPitch;
        public static float lastPacketYaw;
        public static float renderPacketYaw;
        public static float lastRenderPacketYaw;
        public static float bodyYaw;
        public static float lastBodyYaw;
        public static int rotationCounter;
        public static boolean isAiming;

        public Rotation() {
            Rotation \u0445\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L;
        }

        public static double calcMove() {
            double \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L = Helper.mc.player.posX - Helper.mc.player.prevPosX;
            double LLL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L = Helper.mc.player.posZ - Helper.mc.player.prevPosZ;
            return Math.hypot(\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L, LLL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L);
        }

        /*
         * Exception decompiling
         */
        @EventTarget
        public void onPlayerState(EventPlayerState \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L) {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * 
             * org.benf.cfr.reader.util.ConfusedCFRException: While processing lbl1 : IFNE - null : Stack underflow
             *     at org.benf.cfr.reader.bytecode.analysis.stack.StackSim.getChange(StackSim.java:81)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:242)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1559)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:434)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
             *     at org.benf.cfr.reader.Main.main(Main.java:54)
             */
            throw new IllegalStateException("Decompilation failed");
        }

        @EventTarget
        public void onSendPacket(EventSendPacket \u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L) {
            if (\u0445LLL\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L.getPacket() instanceof CPacketAnimation) {
                rotationCounter = 10;
            }
        }
    }
}

