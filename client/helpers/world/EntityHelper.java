/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.world;

import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.Destroy.client.helpers.Helper;

public class EntityHelper
implements Helper {
    public EntityHelper() {
        EntityHelper L\u0445\u0445\u0445L\u0445LL\u0445L\u0445L;
    }

    public static double getDistance(double \u0445LL\u0445\u0445\u0445LL\u0445L\u0445L, double L\u0445L\u0445\u0445\u0445LL\u0445L\u0445L, double \u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445L, double LL\u0445\u0445\u0445\u0445LL\u0445L\u0445L, double \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L, double L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L) {
        double \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L = \u0445LL\u0445\u0445\u0445LL\u0445L\u0445L - LL\u0445\u0445\u0445\u0445LL\u0445L\u0445L;
        double LLLLLL\u0445L\u0445L\u0445L = L\u0445L\u0445\u0445\u0445LL\u0445L\u0445L - \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445L;
        double \u0445LLLLL\u0445L\u0445L\u0445L = \u0445\u0445L\u0445\u0445\u0445LL\u0445L\u0445L - L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L;
        return Math.sqrt(\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L * \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L + LLLLLL\u0445L\u0445L\u0445L * LLLLLL\u0445L\u0445L\u0445L + \u0445LLLLL\u0445L\u0445L\u0445L * \u0445LLLLL\u0445L\u0445L\u0445L);
    }

    public static double getDistance(double \u0445LLL\u0445L\u0445L\u0445L\u0445L, double L\u0445LL\u0445L\u0445L\u0445L\u0445L, double LL\u0445L\u0445L\u0445L\u0445L\u0445L, double L\u0445\u0445L\u0445L\u0445L\u0445L\u0445L) {
        double LLL\u0445\u0445L\u0445L\u0445L\u0445L = \u0445LLL\u0445L\u0445L\u0445L\u0445L - LL\u0445L\u0445L\u0445L\u0445L\u0445L;
        double \u0445LL\u0445\u0445L\u0445L\u0445L\u0445L = L\u0445LL\u0445L\u0445L\u0445L\u0445L - L\u0445\u0445L\u0445L\u0445L\u0445L\u0445L;
        return Math.hypot(LLL\u0445\u0445L\u0445L\u0445L\u0445L, \u0445LL\u0445\u0445L\u0445L\u0445L\u0445L);
    }

    public static Entity rayCast(Entity \u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445L, double LLLL\u0445LL\u0445\u0445L\u0445L) {
        Vec3d \u0445LLL\u0445LL\u0445\u0445L\u0445L = \u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445L.getPositionVector().add(new Vec3d(0.0, \u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445L.getEyeHeight(), 0.0));
        Vec3d L\u0445LL\u0445LL\u0445\u0445L\u0445L = EntityHelper.mc.player.getPositionVector().add(new Vec3d(0.0, EntityHelper.mc.player.getEyeHeight(), 0.0));
        AxisAlignedBB \u0445\u0445LL\u0445LL\u0445\u0445L\u0445L = EntityHelper.mc.player.getEntityBoundingBox().addCoord(\u0445LLL\u0445LL\u0445\u0445L\u0445L.xCoord - L\u0445LL\u0445LL\u0445\u0445L\u0445L.xCoord, \u0445LLL\u0445LL\u0445\u0445L\u0445L.yCoord - L\u0445LL\u0445LL\u0445\u0445L\u0445L.yCoord, \u0445LLL\u0445LL\u0445\u0445L\u0445L.zCoord - L\u0445LL\u0445LL\u0445\u0445L\u0445L.zCoord).expand(1.0, 1.0, 1.0);
        Entity LL\u0445L\u0445LL\u0445\u0445L\u0445L = null;
        Iterator<Entity> \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445L = EntityHelper.mc.world.getEntitiesWithinAABBExcludingEntity(EntityHelper.mc.player, \u0445\u0445LL\u0445LL\u0445\u0445L\u0445L).iterator();
        if (\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445L.hasNext()) {
            Entity L\u0445\u0445\u0445LLL\u0445\u0445L\u0445L = \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445L.next();
            if (L\u0445\u0445\u0445LLL\u0445\u0445L\u0445L.canBeCollidedWith() && L\u0445\u0445\u0445LLL\u0445\u0445L\u0445L instanceof EntityLivingBase) {
                float LLL\u0445LLL\u0445\u0445L\u0445L = L\u0445\u0445\u0445LLL\u0445\u0445L\u0445L.getCollisionBorderSize();
                AxisAlignedBB L\u0445L\u0445LLL\u0445\u0445L\u0445L = L\u0445\u0445\u0445LLL\u0445\u0445L\u0445L.getEntityBoundingBox().expand(LLL\u0445LLL\u0445\u0445L\u0445L, LLL\u0445LLL\u0445\u0445L\u0445L, LLL\u0445LLL\u0445\u0445L\u0445L);
                RayTraceResult \u0445L\u0445\u0445LLL\u0445\u0445L\u0445L = L\u0445L\u0445LLL\u0445\u0445L\u0445L.calculateIntercept(L\u0445LL\u0445LL\u0445\u0445L\u0445L, \u0445LLL\u0445LL\u0445\u0445L\u0445L);
                if (L\u0445L\u0445LLL\u0445\u0445L\u0445L.isVecInside(L\u0445LL\u0445LL\u0445\u0445L\u0445L)) {
                    if (LLLL\u0445LL\u0445\u0445L\u0445L >= 0.0) {
                        LL\u0445L\u0445LL\u0445\u0445L\u0445L = L\u0445\u0445\u0445LLL\u0445\u0445L\u0445L;
                        LLLL\u0445LL\u0445\u0445L\u0445L = 0.0;
                    }
                } else if (\u0445L\u0445\u0445LLL\u0445\u0445L\u0445L != null) {
                    double L\u0445\u0445LLLL\u0445\u0445L\u0445L = L\u0445LL\u0445LL\u0445\u0445L\u0445L.distanceTo(\u0445L\u0445\u0445LLL\u0445\u0445L\u0445L.hitVec);
                    if (LLLL\u0445LL\u0445\u0445L\u0445L == 0.0 || L\u0445\u0445LLLL\u0445\u0445L\u0445L < LLLL\u0445LL\u0445\u0445L\u0445L) {
                        LL\u0445L\u0445LL\u0445\u0445L\u0445L = L\u0445\u0445\u0445LLL\u0445\u0445L\u0445L;
                        LLLL\u0445LL\u0445\u0445L\u0445L = L\u0445\u0445LLLL\u0445\u0445L\u0445L;
                    }
                }
            }
            return null;
        }
        return LL\u0445L\u0445LL\u0445\u0445L\u0445L;
    }

    public static boolean isTeamWithYou(EntityLivingBase L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L) {
        if (EntityHelper.mc.player != null && L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L != null && EntityHelper.mc.player.getDisplayName() != null && L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L.getDisplayName() != null) {
            if (EntityHelper.mc.player.getTeam() != null && L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L.getTeam() != null && EntityHelper.mc.player.getTeam().isSameTeam(L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L.getTeam())) {
                return true;
            }
            String LL\u0445LL\u0445L\u0445\u0445L\u0445L = L\u0445\u0445LL\u0445L\u0445\u0445L\u0445L.getDisplayName().getFormattedText().replace("\u00c2\u00a7r", "");
            String \u0445L\u0445LL\u0445L\u0445\u0445L\u0445L = EntityHelper.mc.player.getDisplayName().getFormattedText().replace("\u00c2\u00a7r", "");
            return LL\u0445LL\u0445L\u0445\u0445L\u0445L.startsWith("\u00c2\u00a7" + \u0445L\u0445LL\u0445L\u0445\u0445L\u0445L.charAt(1));
        }
        return false;
    }

    public static boolean checkArmor(Entity \u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L) {
        return ((EntityLivingBase)\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445L).getTotalArmorValue() < 6;
    }

    public static int getPing(EntityPlayer L\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L) {
        return EntityHelper.mc.player.connection.getPlayerInfo(L\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L.getUniqueID()).getResponseTime();
    }

    public static double getDistanceOfEntityToBlock(Entity L\u0445LL\u0445\u0445L\u0445\u0445L\u0445L, BlockPos \u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445L) {
        return EntityHelper.getDistance(L\u0445LL\u0445\u0445L\u0445\u0445L\u0445L.posX, L\u0445LL\u0445\u0445L\u0445\u0445L\u0445L.posY, L\u0445LL\u0445\u0445L\u0445\u0445L\u0445L.posZ, \u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445L.getX(), \u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445L.getY(), \u0445\u0445LL\u0445\u0445L\u0445\u0445L\u0445L.getZ());
    }
}

