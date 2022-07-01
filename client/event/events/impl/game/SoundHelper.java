/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import org.Destroy.client.Destroy;

public class SoundHelper {
    public SoundHelper() {
        SoundHelper \u0445L\u0445LL\u0445\u0445\u0445\u0445L\u0445LLLL;
    }

    public static void playSound(String LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LLLL) {
        new Thread(() -> {
            try {
                Clip \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLLL = AudioSystem.getClip();
                AudioInputStream L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLLL = AudioSystem.getAudioInputStream(Destroy.class.getResourceAsStream("/assets/minecraft/neverhook/songs/" + LLL\u0445L\u0445\u0445\u0445\u0445L\u0445LLLL));
                \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLLL.open(L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLLL);
                \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445LLLL.start();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }).start();
    }
}

