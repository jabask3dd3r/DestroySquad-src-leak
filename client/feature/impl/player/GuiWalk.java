/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.player;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.client.settings.KeyBinding;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.lwjgl.input.Keyboard;

public class GuiWalk
extends Feature {
    public GuiWalk() {
        super("GuiWalk", "\nAllows walking in open containers", Type.Movement);
        GuiWalk \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
    }

    @EventTarget
    public void onUpdate(EventUpdate LLLLLLLLL\u0445\u0445\u0445\u0445L) {
        KeyBinding[] \u0445LLLLLLLL\u0445\u0445\u0445\u0445L = new KeyBinding[]{GuiWalk.mc.gameSettings.keyBindForward, GuiWalk.mc.gameSettings.keyBindBack, GuiWalk.mc.gameSettings.keyBindLeft, GuiWalk.mc.gameSettings.keyBindRight, GuiWalk.mc.gameSettings.keyBindJump, GuiWalk.mc.gameSettings.keyBindSprint};
        if (GuiWalk.mc.currentScreen instanceof GuiChat || GuiWalk.mc.currentScreen instanceof GuiEditSign) {
            return;
        }
        int \u0445L\u0445LLLLLL\u0445\u0445\u0445\u0445L = 0;
        KeyBinding[] \u0445\u0445LLLLLLL\u0445\u0445\u0445\u0445L = \u0445LLLLLLLL\u0445\u0445\u0445\u0445L;
        int LL\u0445LLLLLL\u0445\u0445\u0445\u0445L = \u0445\u0445LLLLLLL\u0445\u0445\u0445\u0445L.length;
        if (\u0445L\u0445LLLLLL\u0445\u0445\u0445\u0445L < LL\u0445LLLLLL\u0445\u0445\u0445\u0445L) {
            KeyBinding L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = \u0445\u0445LLLLLLL\u0445\u0445\u0445\u0445L[\u0445L\u0445LLLLLL\u0445\u0445\u0445\u0445L];
            L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.pressed = Keyboard.isKeyDown(L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.getKeyCode());
            ++\u0445L\u0445LLLLLL\u0445\u0445\u0445\u0445L;
            return;
        }
    }
}

