/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.ghost;

import java.util.Iterator;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.lwjgl.opengl.Display;

public class Panic
extends Feature {
    public Panic() {
        super("SelfDestruct / Sleep", "\ndisable all active modules", Type.Combat);
        Panic LL\u0445LL\u0445LLLL;
    }

    @Override
    public void onEnable() {
        Panic L\u0445L\u0445L\u0445LLLL;
        Iterator<Feature> LL\u0445\u0445L\u0445LLLL = Destroy.instance.featureManager.features.iterator();
        if (LL\u0445\u0445L\u0445LLLL.hasNext()) {
            Feature \u0445LL\u0445L\u0445LLLL = LL\u0445\u0445L\u0445LLLL.next();
            if (\u0445LL\u0445L\u0445LLLL.getState()) {
                \u0445LL\u0445L\u0445LLLL.toggle();
                Destroy.instance.commandManager.getCommands().clear();
                Panic.mc.ingameGUI.getChatGUI().clearChatMessages(true);
            }
            \u0445LL\u0445L\u0445LLLL.setBind(0);
            return;
        }
        Panic.mc.player.jump();
        mc.displayGuiScreen(null);
        Display.setTitle("Minecraft 1.12.2");
        super.onEnable();
    }
}

