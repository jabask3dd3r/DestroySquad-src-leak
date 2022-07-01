/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventAttackSilent;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class HitParticles
extends Feature {
    private final NumberSetting particleMultiplier;
    private final ListSetting particleMode;
    private final Random random = new Random();

    public HitParticles() {
        super("DamageParticles", "Spawns particles around the entity on hit", Type.Combat);
        HitParticles LLL\u0445\u0445L\u0445L\u0445\u0445L\u0445LLL;
        LLL\u0445\u0445L\u0445L\u0445\u0445L\u0445LLL.particleMode = new ListSetting("Particle Mode", "Criticals", () -> true, "Criticals", "Heart", "Flame", "Portal", "Redstone", "PORTAL");
        LLL\u0445\u0445L\u0445L\u0445\u0445L\u0445LLL.particleMultiplier = new NumberSetting("Particle Multiplier", 5.0f, 1.0f, 15.0f, 1.0f, () -> true);
        LLL\u0445\u0445L\u0445L\u0445\u0445L\u0445LLL.addSettings(LLL\u0445\u0445L\u0445L\u0445\u0445L\u0445LLL.particleMode, LLL\u0445\u0445L\u0445L\u0445\u0445L\u0445LLL.particleMultiplier);
    }

    @EventTarget
    public void onAttackSilent(EventAttackSilent LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL) {
        int LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL;
        HitParticles L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL;
        String L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL = L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.particleMode.getOptions();
        if (L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.equalsIgnoreCase("Redstone")) {
            float L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445LLL = 0.0f;
            if (L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445LLL < LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().height) {
                int LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445LLL = 0;
                if ((float)LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445LLL < L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.particleMultiplier.getNumberValue()) {
                    HitParticles.mc.effectRenderer.spawnEffectParticle(37, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posX, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posY + (double)L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445LLL, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posZ, (float)(L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.random.nextInt(6) - 3) / 5.0f, 0.1, (float)(L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.random.nextInt(6) - 3) / 5.0f, Block.getIdFromBlock(Blocks.REDSTONE_BLOCK));
                    ++LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445LLL;
                    return;
                }
                L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445LLL += 0.2f;
                return;
            }
        } else if (L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.equalsIgnoreCase("Heart")) {
            float L\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445LLL = 0.0f;
            if (L\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445LLL < LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().height) {
                int LLLL\u0445\u0445\u0445L\u0445\u0445L\u0445LLL = 0;
                if ((float)LLLL\u0445\u0445\u0445L\u0445\u0445L\u0445LLL < L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.particleMultiplier.getNumberValue()) {
                    HitParticles.mc.world.spawnParticle(EnumParticleTypes.HEART, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posX, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posY + (double)L\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445LLL, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posZ, (double)((float)(L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.random.nextInt(6) - 3) / 5.0f), 0.1, (double)((float)(L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.random.nextInt(6) - 3) / 5.0f), new int[0]);
                    ++LLLL\u0445\u0445\u0445L\u0445\u0445L\u0445LLL;
                    return;
                }
                L\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445LLL += 0.2f;
                return;
            }
        } else if (L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.equalsIgnoreCase("Flame")) {
            float LL\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LLL = 0.0f;
            if (LL\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LLL < LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().height) {
                int \u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445LLL = 0;
                if ((float)\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445LLL < L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.particleMultiplier.getNumberValue()) {
                    HitParticles.mc.world.spawnParticle(EnumParticleTypes.FLAME, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posX, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posY + (double)LL\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LLL, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posZ, (double)((float)(L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.random.nextInt(6) - 3) / 5.0f), 0.1, (double)((float)(L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.random.nextInt(6) - 3) / 5.0f), new int[0]);
                    ++\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445LLL;
                    return;
                }
                LL\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LLL += 0.2f;
                return;
            }
        } else if (L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.equalsIgnoreCase("Portal")) {
            float L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LLL = 0.0f;
            if (L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LLL < LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().height) {
                int \u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LLL = 0;
                if ((float)\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LLL < L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.particleMultiplier.getNumberValue()) {
                    HitParticles.mc.world.spawnParticle(EnumParticleTypes.PORTAL, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posX, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posY + (double)L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LLL, LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity().posZ, (double)((float)(L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.random.nextInt(6) - 3) / 5.0f), 0.1, (double)((float)(L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.random.nextInt(6) - 3) / 5.0f), new int[0]);
                    ++\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LLL;
                    return;
                }
                L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L\u0445LLL += 0.2f;
                return;
            }
        } else if (L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.equalsIgnoreCase("Criticals") && (float)(LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL = 0) < L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.particleMultiplier.getNumberValue()) {
            HitParticles.mc.player.onCriticalHit(LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL.getTargetEntity());
            ++LLL\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445LLL;
            return;
        }
    }
}

