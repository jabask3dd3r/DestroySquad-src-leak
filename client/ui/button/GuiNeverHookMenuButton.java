/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.button;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.SoundEvents;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.lwjgl.input.Mouse;

public class GuiNeverHookMenuButton
extends GuiButton {
    private int fade = 20;

    public GuiNeverHookMenuButton(int \u0445L\u0445L\u0445\u0445L\u0445\u0445LLLL, int L\u0445\u0445L\u0445\u0445L\u0445\u0445LLLL, int \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLLL, String LLL\u0445\u0445\u0445L\u0445\u0445LLLL) {
        LL\u0445L\u0445\u0445L\u0445\u0445LLLL(\u0445L\u0445L\u0445\u0445L\u0445\u0445LLLL, L\u0445\u0445L\u0445\u0445L\u0445\u0445LLLL, \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLLL, 200, 35, LLL\u0445\u0445\u0445L\u0445\u0445LLLL);
        GuiNeverHookMenuButton LL\u0445L\u0445\u0445L\u0445\u0445LLLL;
    }

    public GuiNeverHookMenuButton(int L\u0445\u0445LLL\u0445\u0445\u0445LLLL, int \u0445\u0445\u0445LLL\u0445\u0445\u0445LLLL, int LLL\u0445LL\u0445\u0445\u0445LLLL, int \u0445LL\u0445LL\u0445\u0445\u0445LLLL, int L\u0445L\u0445LL\u0445\u0445\u0445LLLL, String \u0445\u0445L\u0445LL\u0445\u0445\u0445LLLL) {
        super(L\u0445\u0445LLL\u0445\u0445\u0445LLLL, \u0445\u0445\u0445LLL\u0445\u0445\u0445LLLL, LLL\u0445LL\u0445\u0445\u0445LLLL, \u0445LL\u0445LL\u0445\u0445\u0445LLLL, L\u0445L\u0445LL\u0445\u0445\u0445LLLL, \u0445\u0445L\u0445LL\u0445\u0445\u0445LLLL);
        GuiNeverHookMenuButton \u0445L\u0445LLL\u0445\u0445\u0445LLLL;
    }

    public static int getMouseX() {
        return Mouse.getX() * sr.getScaledWidth() / Minecraft.getInstance().displayWidth;
    }

    public static int getMouseY() {
        return sr.getScaledHeight() - Mouse.getY() * sr.getScaledHeight() / Minecraft.getInstance().displayHeight - 1;
    }

    @Override
    public void drawButton(Minecraft L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL, int \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL, int LLLLL\u0445\u0445\u0445\u0445LLLL, float \u0445LLLL\u0445\u0445\u0445\u0445LLLL) {
        GuiNeverHookMenuButton \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL;
        if (\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.visible) {
            \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.hovered = \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL >= \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.xPosition && LLLLL\u0445\u0445\u0445\u0445LLLL >= \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.yPosition && \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL < \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.xPosition + \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.width && LLLLL\u0445\u0445\u0445\u0445LLLL < \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.yPosition + \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.height + 10;
            Color L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLL = new Color(155, 155, 155, 255);
            Color \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LLLL = new Color(\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.fade + 14, \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.fade + 14, \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.fade + 14, 55);
            if (\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.hovered) {
                if (\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.fade < 100) {
                    \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.fade += 8;
                }
                L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLL = Color.white;
            } else if (\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.fade > 20) {
                \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.fade -= 8;
            }
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            int LL\u0445\u0445\u0445L\u0445\u0445\u0445LLLL = \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.height + 11;
            RectHelper.drawSmoothRect(\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.xPosition, \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.yPosition, \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.width + \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.xPosition, LL\u0445\u0445\u0445L\u0445\u0445\u0445LLLL + \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.yPosition, \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445LLLL.getRGB());
            L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.bigButtonFontRender.drawCenteredString(\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.displayString, (float)\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.xPosition + (float)\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.width / 2.0f, \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.yPosition + (\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.height - 12), L\u0445L\u0445\u0445L\u0445\u0445\u0445LLLL.getRGB());
            \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.mouseDragged(L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL, \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL, LLLLL\u0445\u0445\u0445\u0445LLLL);
        }
    }

    @Override
    protected void mouseDragged(Minecraft L\u0445L\u0445L\u0445\u0445\u0445\u0445LLLL, int \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLLL, int LL\u0445\u0445L\u0445\u0445\u0445\u0445LLLL) {
    }

    @Override
    public void mouseReleased(int L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL, int \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL) {
    }

    @Override
    public boolean mousePressed(Minecraft LL\u0445L\u0445\u0445\u0445\u0445\u0445LLLL, int \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLLL, int L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLL) {
        GuiNeverHookMenuButton \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLL;
        return \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLL.enabled && \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLL.visible && \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLLL >= \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLL.xPosition && L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLL >= \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLL.yPosition && \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLLL < \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLL.xPosition + \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLL.width && L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLL < \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLL.yPosition + \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLLL.height + 10;
    }

    @Override
    public boolean isMouseOver() {
        GuiNeverHookMenuButton \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLLL;
        return \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLLL.hovered;
    }

    @Override
    public void drawButtonForegroundLayer(int L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLL, int \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLL) {
    }

    @Override
    public void playPressSound(SoundHandler L\u0445LLLLLLL\u0445LLL) {
        L\u0445LLLLLLL\u0445LLL.playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0f));
    }

    @Override
    public int getButtonWidth() {
        GuiNeverHookMenuButton \u0445L\u0445LLLLLL\u0445LLL;
        return \u0445L\u0445LLLLLL\u0445LLL.width;
    }

    @Override
    public void setWidth(int L\u0445L\u0445LLLLL\u0445LLL) {
        \u0445LL\u0445LLLLL\u0445LLL.width = L\u0445L\u0445LLLLL\u0445LLL;
    }
}

