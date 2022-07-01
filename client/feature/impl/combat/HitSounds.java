/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import java.util.Random;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventAttackSilent;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.ListSetting;

public class HitSounds
extends Feature {
    private final ListSetting soundMode;
    private final Random random = new Random();
    private SoundHandler SoundHelper;

    public HitSounds() {
        super("HitSounds", "Sounds in hit of player", Type.Combat);
        HitSounds \u0445\u0445\u0445LLLLLLL\u0445\u0445\u0445\u0445L;
        \u0445\u0445\u0445LLLLLLL\u0445\u0445\u0445\u0445L.soundMode = new ListSetting("Mode", "Neverlose", () -> true, "Neverlose", "Metallic");
        \u0445\u0445\u0445LLLLLLL\u0445\u0445\u0445\u0445L.addSettings(\u0445\u0445\u0445LLLLLLL\u0445\u0445\u0445\u0445L.soundMode);
    }

    @EventTarget
    public void onAttackSilent(EventAttackSilent L\u0445\u0445\u0445LLLLLL\u0445\u0445\u0445\u0445L) {
        if (L\u0445\u0445\u0445LLLLLL\u0445\u0445\u0445\u0445L.getTargetEntity() instanceof EntityPlayer) {
            HitSounds \u0445L\u0445\u0445LLLLLL\u0445\u0445\u0445\u0445L;
            String LL\u0445\u0445LLLLLL\u0445\u0445\u0445\u0445L = \u0445L\u0445\u0445LLLLLL\u0445\u0445\u0445\u0445L.soundMode.getOptions();
            if (LL\u0445\u0445LLLLLL\u0445\u0445\u0445\u0445L.equalsIgnoreCase("Neverlose")) {
                SoundHandler.playSound("neverlose.wav");
            } else if (LL\u0445\u0445LLLLLL\u0445\u0445\u0445\u0445L.equalsIgnoreCase("Metallic")) {
                SoundHandler.playSound("metallic.wav");
            }
        }
    }
}

