/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.altmanager;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ChatAllowedCharacters;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.lwjgl.opengl.GL11;

public class PasswordField
extends Gui {
    private final FontRenderer fontRenderer;
    private final int xPos;
    private final int yPos;
    private final int width;
    private final int height;
    private final boolean isEnabled = true;
    private final int disabledColor = 0x707070;
    public String text = "";
    public int maxStringLength = 50;
    public boolean isFocused = false;
    private int cursorCounter;
    private boolean enableBackgroundDrawing = true;
    private boolean canLoseFocus = true;
    private int field_73816_n = 0;
    private int cursorPosition = 0;
    private int selectionEnd = 0;
    private int enabledColor = 0xE0E0E0;
    private boolean field_73823_s = true;

    public PasswordField(FontRenderer L\u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL, int LLLL\u0445LL\u0445\u0445LL\u0445LLL, int L\u0445LL\u0445LL\u0445\u0445LL\u0445LLL, int LL\u0445L\u0445LL\u0445\u0445LL\u0445LLL, int L\u0445\u0445L\u0445LL\u0445\u0445LL\u0445LLL) {
        PasswordField LL\u0445\u0445LLL\u0445\u0445LL\u0445LLL;
        LL\u0445\u0445LLL\u0445\u0445LL\u0445LLL.fontRenderer = L\u0445\u0445\u0445LLL\u0445\u0445LL\u0445LLL;
        LL\u0445\u0445LLL\u0445\u0445LL\u0445LLL.xPos = LLLL\u0445LL\u0445\u0445LL\u0445LLL;
        LL\u0445\u0445LLL\u0445\u0445LL\u0445LLL.yPos = L\u0445LL\u0445LL\u0445\u0445LL\u0445LLL;
        LL\u0445\u0445LLL\u0445\u0445LL\u0445LLL.width = LL\u0445L\u0445LL\u0445\u0445LL\u0445LLL;
        LL\u0445\u0445LLL\u0445\u0445LL\u0445LLL.height = L\u0445\u0445L\u0445LL\u0445\u0445LL\u0445LLL;
    }

    public void updateCursorCounter() {
        PasswordField \u0445\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL;
        ++\u0445\u0445\u0445LL\u0445L\u0445\u0445LL\u0445LLL.cursorCounter;
    }

    public String getText() {
        PasswordField L\u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445LLL;
        return L\u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445LLL.text.replaceAll(" ", "");
    }

    public void setText(String L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLL) {
        PasswordField \u0445L\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLL;
        \u0445L\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLL.text = L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLL.length() > \u0445L\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLL.maxStringLength ? L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLL.substring(0, \u0445L\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLL.maxStringLength) : L\u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLL;
        \u0445L\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLL.setCursorPositionEnd();
    }

    public String getSelectedtext() {
        PasswordField \u0445\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LLL;
        int LLL\u0445LL\u0445\u0445\u0445LL\u0445LLL = \u0445\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LLL.cursorPosition < \u0445\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LLL.selectionEnd ? \u0445\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LLL.cursorPosition : \u0445\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LLL.selectionEnd;
        int L\u0445L\u0445LL\u0445\u0445\u0445LL\u0445LLL = \u0445\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LLL.cursorPosition < \u0445\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LLL.selectionEnd ? \u0445\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LLL.selectionEnd : \u0445\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LLL.cursorPosition;
        return \u0445\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LLL.text.substring(LLL\u0445LL\u0445\u0445\u0445LL\u0445LLL, L\u0445L\u0445LL\u0445\u0445\u0445LL\u0445LLL);
    }

    public void writeText(String \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL) {
        int \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL;
        PasswordField \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL;
        String \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = "";
        String \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = ChatAllowedCharacters.filterAllowedCharacters(\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL);
        int \u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.cursorPosition < \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.selectionEnd ? \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.cursorPosition : \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.selectionEnd;
        int L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.cursorPosition < \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.selectionEnd ? \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.selectionEnd : \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.cursorPosition;
        int \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.maxStringLength - \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.text.length() - (\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL - \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.selectionEnd);
        boolean \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = false;
        if (\u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.text.length() > 0) {
            \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL + \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.text.substring(0, \u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL);
        }
        if (\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL < \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.length()) {
            \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL + \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.substring(0, \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL);
            int \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445LLL = \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL;
        } else {
            \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL + \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL;
            \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.length();
        }
        if (\u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.text.length() > 0 && L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL < \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.text.length()) {
            \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL = \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL + \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.text.substring(L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL);
        }
        \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.text = \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.replaceAll(" ", "");
        \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.func_73784_d(\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL - \u0445LLL\u0445\u0445\u0445\u0445\u0445LL\u0445LLL.selectionEnd + \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445LLL);
    }

    public void func_73779_a(int \u0445L\u0445\u0445\u0445LLLL\u0445L\u0445LLL) {
        PasswordField \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445LLL;
        if (\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445LLL.text.length() != 0) {
            if (\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445LLL.selectionEnd != \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445LLL.cursorPosition) {
                \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445LLL.writeText("");
            } else {
                \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445LLL.deleteFromCursor(\u0445\u0445L\u0445\u0445LLLL\u0445L\u0445LLL.getNthWordFromCursor(\u0445L\u0445\u0445\u0445LLLL\u0445L\u0445LLL) - \u0445\u0445L\u0445\u0445LLLL\u0445L\u0445LLL.cursorPosition);
            }
        }
    }

    public void deleteFromCursor(int LL\u0445\u0445\u0445\u0445LLL\u0445L\u0445LLL) {
        PasswordField L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL;
        if (L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.text.length() != 0) {
            if (L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.selectionEnd != L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.cursorPosition) {
                L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.writeText("");
            } else {
                boolean \u0445\u0445LL\u0445\u0445LLL\u0445L\u0445LLL = LL\u0445\u0445\u0445\u0445LLL\u0445L\u0445LLL < 0;
                int LL\u0445L\u0445\u0445LLL\u0445L\u0445LLL = \u0445\u0445LL\u0445\u0445LLL\u0445L\u0445LLL ? L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.cursorPosition + LL\u0445\u0445\u0445\u0445LLL\u0445L\u0445LLL : L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.cursorPosition;
                int L\u0445\u0445L\u0445\u0445LLL\u0445L\u0445LLL = \u0445\u0445LL\u0445\u0445LLL\u0445L\u0445LLL ? L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.cursorPosition : L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.cursorPosition + LL\u0445\u0445\u0445\u0445LLL\u0445L\u0445LLL;
                String LLL\u0445\u0445\u0445LLL\u0445L\u0445LLL = "";
                if (LL\u0445L\u0445\u0445LLL\u0445L\u0445LLL >= 0) {
                    LLL\u0445\u0445\u0445LLL\u0445L\u0445LLL = L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.text.substring(0, LL\u0445L\u0445\u0445LLL\u0445L\u0445LLL);
                }
                if (L\u0445\u0445L\u0445\u0445LLL\u0445L\u0445LLL < L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.text.length()) {
                    LLL\u0445\u0445\u0445LLL\u0445L\u0445LLL = LLL\u0445\u0445\u0445LLL\u0445L\u0445LLL + L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.text.substring(L\u0445\u0445L\u0445\u0445LLL\u0445L\u0445LLL);
                }
                L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.text = LLL\u0445\u0445\u0445LLL\u0445L\u0445LLL;
                if (\u0445\u0445LL\u0445\u0445LLL\u0445L\u0445LLL) {
                    L\u0445L\u0445\u0445\u0445LLL\u0445L\u0445LLL.func_73784_d(LL\u0445\u0445\u0445\u0445LLL\u0445L\u0445LLL);
                }
            }
        }
    }

    public int getNthWordFromCursor(int L\u0445LL\u0445L\u0445LL\u0445L\u0445LLL) {
        PasswordField LLLL\u0445L\u0445LL\u0445L\u0445LLL;
        return LLLL\u0445L\u0445LL\u0445L\u0445LLL.getNthWordFromPos(L\u0445LL\u0445L\u0445LL\u0445L\u0445LLL, LLLL\u0445L\u0445LL\u0445L\u0445LLL.getCursorPosition());
    }

    public int getNthWordFromPos(int \u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL, int \u0445LLLL\u0445\u0445LL\u0445L\u0445LLL) {
        PasswordField \u0445L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL;
        return \u0445L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL.func_73798_a(\u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL, \u0445L\u0445\u0445\u0445L\u0445LL\u0445L\u0445LLL.getCursorPosition(), true);
    }

    public int func_73798_a(int LL\u0445LLLL\u0445L\u0445L\u0445LLL, int \u0445L\u0445LLLL\u0445L\u0445L\u0445LLL, boolean L\u0445\u0445LLLL\u0445L\u0445L\u0445LLL) {
        int \u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL = \u0445L\u0445LLLL\u0445L\u0445L\u0445LLL;
        boolean LLL\u0445LLL\u0445L\u0445L\u0445LLL = LL\u0445LLLL\u0445L\u0445L\u0445LLL < 0;
        int L\u0445LLLLL\u0445L\u0445L\u0445LLL = 0;
        int \u0445LL\u0445LLL\u0445L\u0445L\u0445LLL = Math.abs(LL\u0445LLLL\u0445L\u0445L\u0445LLL);
        if (L\u0445LLLLL\u0445L\u0445L\u0445LLL < \u0445LL\u0445LLL\u0445L\u0445L\u0445LLL) {
            PasswordField \u0445\u0445LLLLL\u0445L\u0445L\u0445LLL;
            if (!LLL\u0445LLL\u0445L\u0445L\u0445LLL) {
                int \u0445LLLLLL\u0445L\u0445L\u0445LLL = \u0445\u0445LLLLL\u0445L\u0445L\u0445LLL.text.length();
                if ((\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL = \u0445\u0445LLLLL\u0445L\u0445L\u0445LLL.text.indexOf(32, \u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL)) == -1) {
                    \u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL = \u0445LLLLLL\u0445L\u0445L\u0445LLL;
                } else if (L\u0445\u0445LLLL\u0445L\u0445L\u0445LLL && \u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL < \u0445LLLLLL\u0445L\u0445L\u0445LLL && \u0445\u0445LLLLL\u0445L\u0445L\u0445LLL.text.charAt(\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL) == ' ') {
                    ++\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL;
                    return 0;
                }
            } else {
                if (L\u0445\u0445LLLL\u0445L\u0445L\u0445LLL && \u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL > 0 && \u0445\u0445LLLLL\u0445L\u0445L\u0445LLL.text.charAt(\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL - 1) == ' ') {
                    --\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL;
                    return 0;
                }
                if (\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL > 0 && \u0445\u0445LLLLL\u0445L\u0445L\u0445LLL.text.charAt(\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL - 1) != ' ') {
                    --\u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL;
                    return 0;
                }
            }
            ++L\u0445LLLLL\u0445L\u0445L\u0445LLL;
            return 0;
        }
        return \u0445\u0445\u0445LLLL\u0445L\u0445L\u0445LLL;
    }

    public void func_73784_d(int L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LLL) {
        PasswordField \u0445L\u0445L\u0445LL\u0445L\u0445L\u0445LLL;
        \u0445L\u0445L\u0445LL\u0445L\u0445L\u0445LLL.setCursorPosition(\u0445L\u0445L\u0445LL\u0445L\u0445L\u0445LLL.selectionEnd + L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445LLL);
    }

    public void setCursorPositionZero() {
        PasswordField L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL;
        L\u0445L\u0445\u0445LL\u0445L\u0445L\u0445LLL.setCursorPosition(0);
    }

    public void setCursorPositionEnd() {
        PasswordField \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL;
        \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL.setCursorPosition(\u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445LLL.text.length());
    }

    public boolean textboxKeyTyped(char \u0445\u0445LLL\u0445L\u0445L\u0445L\u0445LLL, int LL\u0445LL\u0445L\u0445L\u0445L\u0445LLL) {
        PasswordField L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL;
        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.getClass();
        if (L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.isFocused) {
            switch (\u0445\u0445LLL\u0445L\u0445L\u0445L\u0445LLL) {
                case '\u0001': {
                    L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.setCursorPositionEnd();
                    L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.func_73800_i(0);
                    return true;
                }
                case '\u0003': {
                    GuiScreen.setClipboardString(L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.getSelectedtext());
                    return true;
                }
                case '\u0016': {
                    L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.writeText(GuiScreen.getClipboardString());
                    return true;
                }
                case '\u0018': {
                    GuiScreen.setClipboardString(L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.getSelectedtext());
                    L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.writeText("");
                    return true;
                }
            }
            switch (LL\u0445LL\u0445L\u0445L\u0445L\u0445LLL) {
                case 14: {
                    if (GuiScreen.isCtrlKeyDown()) {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.func_73779_a(-1);
                    } else {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.deleteFromCursor(-1);
                    }
                    return true;
                }
                case 199: {
                    if (GuiScreen.isShiftKeyDown()) {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.func_73800_i(0);
                    } else {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.setCursorPositionZero();
                    }
                    return true;
                }
                case 203: {
                    if (GuiScreen.isShiftKeyDown()) {
                        if (GuiScreen.isCtrlKeyDown()) {
                            L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.func_73800_i(L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.getNthWordFromPos(-1, L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.getSelectionEnd()));
                        } else {
                            L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.func_73800_i(L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.getSelectionEnd() - 1);
                        }
                    } else if (GuiScreen.isCtrlKeyDown()) {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.setCursorPosition(L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.getNthWordFromCursor(-1));
                    } else {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.func_73784_d(-1);
                    }
                    return true;
                }
                case 205: {
                    if (GuiScreen.isShiftKeyDown()) {
                        if (GuiScreen.isCtrlKeyDown()) {
                            L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.func_73800_i(L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.getNthWordFromPos(1, L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.getSelectionEnd()));
                        } else {
                            L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.func_73800_i(L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.getSelectionEnd() + 1);
                        }
                    } else if (GuiScreen.isCtrlKeyDown()) {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.setCursorPosition(L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.getNthWordFromCursor(1));
                    } else {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.func_73784_d(1);
                    }
                    return true;
                }
                case 207: {
                    if (GuiScreen.isShiftKeyDown()) {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.func_73800_i(L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.text.length());
                    } else {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.setCursorPositionEnd();
                    }
                    return true;
                }
                case 211: {
                    if (GuiScreen.isCtrlKeyDown()) {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.func_73779_a(1);
                    } else {
                        L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.deleteFromCursor(1);
                    }
                    return true;
                }
            }
            if (ChatAllowedCharacters.isAllowedCharacter((char)\u0445\u0445LLL\u0445L\u0445L\u0445L\u0445LLL)) {
                L\u0445LLL\u0445L\u0445L\u0445L\u0445LLL.writeText(Character.toString(\u0445\u0445LLL\u0445L\u0445L\u0445L\u0445LLL));
                return true;
            }
            return false;
        }
        return false;
    }

    public void mouseClicked(int L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LLL, int \u0445\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LLL, int LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445LLL) {
        PasswordField \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL;
        boolean \u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LLL;
        boolean bl2 = \u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LLL = L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LLL >= \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.xPos && L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LLL < \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.xPos + \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.width && \u0445\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LLL >= \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.yPos && \u0445\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LLL < \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.yPos + \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.height;
        if (\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.canLoseFocus) {
            \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.getClass();
            \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.setFocused(\u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445LLL);
        }
        if (\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.isFocused && LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445LLL == 0) {
            int \u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL = L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445LLL - \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.xPos;
            if (\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.enableBackgroundDrawing) {
                \u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL -= 4;
            }
            String LLLL\u0445\u0445L\u0445L\u0445L\u0445LLL = \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.fontRenderer.trimStringToWidth(\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.text.substring(\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.field_73816_n), \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.getWidth());
            \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.setCursorPosition(\u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.fontRenderer.trimStringToWidth(LLLL\u0445\u0445L\u0445L\u0445L\u0445LLL, \u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445LLL).length() + \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445LLL.field_73816_n);
        }
    }

    public void drawTextBox() {
        PasswordField L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL;
        if (L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.func_73778_q()) {
            if (L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.getEnableBackgroundDrawing()) {
                RectHelper.drawRect(L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.xPos, L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.yPos, L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.xPos + L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.width, L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.yPos + L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.height, new Color(30, 30, 30, 185).getRGB());
                RectHelper.drawGradientRect(L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.xPos, L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.yPos, L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.xPos + L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.width, L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.yPos + L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.height, new Color(1, 1, 1, 255).getRGB(), new Color(5, 5, 5, 255).getRGB());
            }
            L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.getClass();
            int \u0445\u0445L\u0445LL\u0445\u0445L\u0445L\u0445LLL = L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.enabledColor;
            int LL\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL = L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.cursorPosition - L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.field_73816_n;
            int \u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL = L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.selectionEnd - L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.field_73816_n;
            String L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL = L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.fontRenderer.trimStringToWidth(L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.text.substring(L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.field_73816_n), L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.getWidth());
            boolean \u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL = LL\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL >= 0 && LL\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL <= L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL.length();
            boolean LLLL\u0445L\u0445\u0445L\u0445L\u0445LLL = L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.isFocused && L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.cursorCounter / 6 % 2 == 0 && \u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL;
            int \u0445LLL\u0445L\u0445\u0445L\u0445L\u0445LLL = L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.enableBackgroundDrawing ? L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.xPos + 4 : L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.xPos;
            int L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL = L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.enableBackgroundDrawing ? L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.yPos + (L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.height - 8) / 2 : L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.yPos;
            int \u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL = \u0445LLL\u0445L\u0445\u0445L\u0445L\u0445LLL;
            if (\u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL > L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL.length()) {
                \u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL = L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL.length();
            }
            if (L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL.length() > 0) {
                if (\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL) {
                    L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL.substring(0, LL\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL);
                }
                \u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL = Minecraft.getInstance().fontRendererObj.drawStringWithShadow(L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.text.replaceAll("(?s).", "*"), \u0445LLL\u0445L\u0445\u0445L\u0445L\u0445LLL, L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL, \u0445\u0445L\u0445LL\u0445\u0445L\u0445L\u0445LLL);
            }
            boolean LL\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL = L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.cursorPosition < L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.text.length() || L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.text.length() >= L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.getMaxStringLength();
            int \u0445L\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL;
            if (!\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL) {
                \u0445L\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL = LL\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL > 0 ? \u0445LLL\u0445L\u0445\u0445L\u0445L\u0445LLL + L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.width : \u0445LLL\u0445L\u0445\u0445L\u0445L\u0445LLL;
            } else if (LL\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL) {
                \u0445L\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL = \u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL - 1;
                --\u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL;
            }
            if (L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL.length() > 0 && \u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL && LL\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL < L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL.length()) {
                Minecraft.getInstance().fontRendererObj.drawStringWithShadow(L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL.substring(LL\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL), \u0445\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL, L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL, \u0445\u0445L\u0445LL\u0445\u0445L\u0445L\u0445LLL);
            }
            if (LLLL\u0445L\u0445\u0445L\u0445L\u0445LLL) {
                if (LL\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL) {
                    Gui.drawRect(\u0445L\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL, L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL - 1, \u0445L\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL + 1, L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL + 1 + L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.fontRenderer.FONT_HEIGHT, -3092272);
                } else {
                    Minecraft.getInstance().fontRendererObj.drawStringWithShadow("_", \u0445L\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL, L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL, \u0445\u0445L\u0445LL\u0445\u0445L\u0445L\u0445LLL);
                }
            }
            if (\u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL != LL\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL) {
                int L\u0445L\u0445LL\u0445\u0445L\u0445L\u0445LLL = \u0445LLL\u0445L\u0445\u0445L\u0445L\u0445LLL + L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.fontRenderer.getStringWidth(L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL.substring(0, \u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445LLL));
                L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.drawCursorVertical(\u0445L\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL, L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL - 1, L\u0445L\u0445LL\u0445\u0445L\u0445L\u0445LLL - 1, L\u0445LL\u0445L\u0445\u0445L\u0445L\u0445LLL + 1 + L\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445LLL.fontRenderer.FONT_HEIGHT);
            }
        }
    }

    private void drawCursorVertical(int L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL, int \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL, int LLLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL, int \u0445LLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL) {
        if (L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL < LLLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL) {
            int \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL = L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL;
            L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL = LLLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL;
            LLLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL = \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL;
        }
        if (\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL < \u0445LLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL) {
            int LL\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL = \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL;
            \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL = \u0445LLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL;
            \u0445LLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL = LL\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL;
        }
        Tessellator L\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL = Tessellator.getInstance();
        BufferBuilder \u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL = L\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL.getBuffer();
        GL11.glColor4f(0.0f, 0.0f, 255.0f, 255.0f);
        GL11.glDisable(3553);
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        \u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL.begin(7, DefaultVertexFormats.POSITION);
        \u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL.pos(L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL, \u0445LLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL, 0.0).endVertex();
        \u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL.pos(LLLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL, \u0445LLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL, 0.0).endVertex();
        \u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL.pos(LLLL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL, \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL, 0.0).endVertex();
        \u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL.pos(L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL, \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445LLL, 0.0).endVertex();
        L\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445LLL.draw();
        GL11.glDisable(3058);
        GL11.glEnable(3553);
    }

    public int getMaxStringLength() {
        PasswordField LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445LLL;
        return LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445LLL.maxStringLength;
    }

    public void setMaxStringLength(int \u0445LLLLLLL\u0445\u0445L\u0445LLL) {
        PasswordField LLLLLLLL\u0445\u0445L\u0445LLL;
        LLLLLLLL\u0445\u0445L\u0445LLL.maxStringLength = \u0445LLLLLLL\u0445\u0445L\u0445LLL;
        if (LLLLLLLL\u0445\u0445L\u0445LLL.text.length() > \u0445LLLLLLL\u0445\u0445L\u0445LLL) {
            LLLLLLLL\u0445\u0445L\u0445LLL.text = LLLLLLLL\u0445\u0445L\u0445LLL.text.substring(0, \u0445LLLLLLL\u0445\u0445L\u0445LLL);
        }
    }

    public int getCursorPosition() {
        PasswordField \u0445L\u0445LLLLL\u0445\u0445L\u0445LLL;
        return \u0445L\u0445LLLLL\u0445\u0445L\u0445LLL.cursorPosition;
    }

    public void setCursorPosition(int \u0445\u0445L\u0445LLLL\u0445\u0445L\u0445LLL) {
        PasswordField L\u0445L\u0445LLLL\u0445\u0445L\u0445LLL;
        L\u0445L\u0445LLLL\u0445\u0445L\u0445LLL.cursorPosition = \u0445\u0445L\u0445LLLL\u0445\u0445L\u0445LLL;
        int LL\u0445\u0445LLLL\u0445\u0445L\u0445LLL = L\u0445L\u0445LLLL\u0445\u0445L\u0445LLL.text.length();
        if (L\u0445L\u0445LLLL\u0445\u0445L\u0445LLL.cursorPosition < 0) {
            L\u0445L\u0445LLLL\u0445\u0445L\u0445LLL.cursorPosition = 0;
        }
        if (L\u0445L\u0445LLLL\u0445\u0445L\u0445LLL.cursorPosition > LL\u0445\u0445LLLL\u0445\u0445L\u0445LLL) {
            L\u0445L\u0445LLLL\u0445\u0445L\u0445LLL.cursorPosition = LL\u0445\u0445LLLL\u0445\u0445L\u0445LLL;
        }
        L\u0445L\u0445LLLL\u0445\u0445L\u0445LLL.func_73800_i(L\u0445L\u0445LLLL\u0445\u0445L\u0445LLL.cursorPosition);
    }

    public boolean getEnableBackgroundDrawing() {
        PasswordField \u0445LLL\u0445LLL\u0445\u0445L\u0445LLL;
        return \u0445LLL\u0445LLL\u0445\u0445L\u0445LLL.enableBackgroundDrawing;
    }

    public void setEnableBackgroundDrawing(boolean L\u0445\u0445L\u0445LLL\u0445\u0445L\u0445LLL) {
        \u0445L\u0445L\u0445LLL\u0445\u0445L\u0445LLL.enableBackgroundDrawing = L\u0445\u0445L\u0445LLL\u0445\u0445L\u0445LLL;
    }

    public void func_73794_g(int LL\u0445\u0445\u0445LLL\u0445\u0445L\u0445LLL) {
        \u0445\u0445L\u0445\u0445LLL\u0445\u0445L\u0445LLL.enabledColor = LL\u0445\u0445\u0445LLL\u0445\u0445L\u0445LLL;
    }

    public boolean isFocused() {
        PasswordField LLLLL\u0445LL\u0445\u0445L\u0445LLL;
        return LLLLL\u0445LL\u0445\u0445L\u0445LLL.isFocused;
    }

    public void setFocused(boolean \u0445L\u0445LL\u0445LL\u0445\u0445L\u0445LLL) {
        PasswordField LL\u0445LL\u0445LL\u0445\u0445L\u0445LLL;
        if (\u0445L\u0445LL\u0445LL\u0445\u0445L\u0445LLL && !LL\u0445LL\u0445LL\u0445\u0445L\u0445LLL.isFocused) {
            LL\u0445LL\u0445LL\u0445\u0445L\u0445LLL.cursorCounter = 0;
        }
        LL\u0445LL\u0445LL\u0445\u0445L\u0445LLL.isFocused = \u0445L\u0445LL\u0445LL\u0445\u0445L\u0445LLL;
    }

    public int getSelectionEnd() {
        PasswordField \u0445LL\u0445L\u0445LL\u0445\u0445L\u0445LLL;
        return \u0445LL\u0445L\u0445LL\u0445\u0445L\u0445LLL.selectionEnd;
    }

    public int getWidth() {
        PasswordField LL\u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL;
        return LL\u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL.getEnableBackgroundDrawing() ? LL\u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL.width - 8 : LL\u0445\u0445L\u0445LL\u0445\u0445L\u0445LLL.width;
    }

    public void func_73800_i(int LLL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL) {
        PasswordField \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL;
        int \u0445LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL = \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.text.length();
        if (LLL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL > \u0445LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL) {
            LLL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL = \u0445LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL;
        }
        if (LLL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL < 0) {
            LLL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL = 0;
        }
        \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.selectionEnd = LLL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL;
        if (\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.fontRenderer != null) {
            if (\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n > \u0445LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL) {
                \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n = \u0445LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL;
            }
            int LL\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL = \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.getWidth();
            String \u0445L\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL = \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.fontRenderer.trimStringToWidth(\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.text.substring(\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n), LL\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL);
            int L\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL = \u0445L\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.length() + \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n;
            if (LLL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL == \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n) {
                \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n -= \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.fontRenderer.trimStringToWidth(\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.text, LL\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL, true).length();
            }
            if (LLL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL > L\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL) {
                \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n += LLL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL - L\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL;
            } else if (LLL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL <= \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n) {
                \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n -= \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n - LLL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL;
            }
            if (\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n < 0) {
                \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n = 0;
            }
            if (\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n > \u0445LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL) {
                \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.field_73816_n = \u0445LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL;
            }
        }
    }

    public void setCanLoseFocus(boolean \u0445\u0445LLLL\u0445L\u0445\u0445L\u0445LLL) {
        L\u0445LLLL\u0445L\u0445\u0445L\u0445LLL.canLoseFocus = \u0445\u0445LLLL\u0445L\u0445\u0445L\u0445LLL;
    }

    public boolean func_73778_q() {
        PasswordField \u0445\u0445\u0445LLL\u0445L\u0445\u0445L\u0445LLL;
        return \u0445\u0445\u0445LLL\u0445L\u0445\u0445L\u0445LLL.field_73823_s;
    }

    public void func_73790_e(boolean LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445LLL) {
        \u0445\u0445L\u0445LL\u0445L\u0445\u0445L\u0445LLL.field_73823_s = LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445LLL;
    }
}

