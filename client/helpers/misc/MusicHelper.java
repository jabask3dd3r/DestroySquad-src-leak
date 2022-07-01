/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.misc;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import org.Destroy.client.Destroy;

public class MusicHelper {
    public MusicHelper() {
        MusicHelper L\u0445L\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL;
    }

    public static void playSound(String \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL) {
        new Thread(() -> {
            try {
                Clip L\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = AudioSystem.getClip();
                AudioInputStream \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = AudioSystem.getAudioInputStream(Destroy.class.getResourceAsStream("/assets/minecraft/neverhook/songs/" + \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL));
                L\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.open(\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL);
                L\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.start();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }).start();
    }
}

