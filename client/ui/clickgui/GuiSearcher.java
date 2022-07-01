/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.clickgui;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiPageButtonList;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.math.MathHelper;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.impl.misc.NameProtected;
import org.Destroy.client.helpers.render.rect.RectHelper;

public class GuiSearcher
extends Gui {
    private final int id;
    private final FontRenderer fontRendererInstance;
    private final int width;
    private final int height;
    public int xPosition;
    public int yPosition;
    public int maxStringLength = 32;
    public boolean isFocused;
    private String text = "";
    private int cursorCounter;
    private boolean enableBackgroundDrawing = true;
    private boolean canLoseFocus = true;
    private boolean isEnabled = true;
    private int lineScrollOffset;
    private int cursorPosition;
    private int selectionEnd;
    private int enabledColor = 0xE0E0E0;
    private int disabledColor = 0x707070;
    private boolean visible = true;
    private GuiPageButtonList.GuiResponder guiResponder;
    private Predicate<String> validator = Predicates.alwaysTrue();

    public GuiSearcher(int LLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL, FontRenderer \u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL, int L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL, int \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL, int LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL, int \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL) {
        GuiSearcher \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.id = LLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.fontRendererInstance = \u0445LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.xPosition = L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.yPosition = \u0445\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.width = LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        \u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.height = \u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
    }

    public void setGuiResponder(GuiPageButtonList.GuiResponder LLL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL) {
        \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.guiResponder = LLL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
    }

    public void updateCursorCounter() {
        GuiSearcher LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        ++LL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.cursorCounter;
    }

    public String getText() {
        GuiSearcher \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        return \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.text;
    }

    public void setText(String LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL) {
        GuiSearcher \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        if (\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.validator.apply(LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL)) {
            \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.text = LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.length() > \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.maxStringLength ? LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.substring(0, \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.maxStringLength) : LL\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
            \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.setCursorPositionEnd();
        }
    }

    public String getSelectedText() {
        GuiSearcher L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL;
        int \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL = L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.cursorPosition < L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.selectionEnd ? L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.cursorPosition : L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.selectionEnd;
        int LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL = L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.cursorPosition < L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.selectionEnd ? L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.selectionEnd : L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.cursorPosition;
        return L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL.text.substring(\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL, LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LL);
    }

    public void setValidator(Predicate<String> \u0445\u0445LLLLLLLLLLL\u0445L) {
        L\u0445LLLLLLLLLLL\u0445L.validator = \u0445\u0445LLLLLLLLLLL\u0445L;
    }

    public void writeText(String LLLL\u0445LLLLLLLL\u0445L) {
        int L\u0445\u0445L\u0445LLLLLLLL\u0445L;
        GuiSearcher \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L;
        String \u0445LLL\u0445LLLLLLLL\u0445L = "";
        String L\u0445LL\u0445LLLLLLLL\u0445L = ChatAllowedCharacters.filterAllowedCharacters(LLLL\u0445LLLLLLLL\u0445L);
        int \u0445\u0445LL\u0445LLLLLLLL\u0445L = \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.cursorPosition < \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.selectionEnd ? \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.cursorPosition : \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.selectionEnd;
        int LL\u0445L\u0445LLLLLLLL\u0445L = \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.cursorPosition < \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.selectionEnd ? \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.selectionEnd : \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.cursorPosition;
        int \u0445L\u0445L\u0445LLLLLLLL\u0445L = \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.maxStringLength - \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.text.length() - (\u0445\u0445LL\u0445LLLLLLLL\u0445L - LL\u0445L\u0445LLLLLLLL\u0445L);
        if (!\u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.text.isEmpty()) {
            \u0445LLL\u0445LLLLLLLL\u0445L = \u0445LLL\u0445LLLLLLLL\u0445L + \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.text.substring(0, \u0445\u0445LL\u0445LLLLLLLL\u0445L);
        }
        if (\u0445L\u0445L\u0445LLLLLLLL\u0445L < L\u0445LL\u0445LLLLLLLL\u0445L.length()) {
            \u0445LLL\u0445LLLLLLLL\u0445L = \u0445LLL\u0445LLLLLLLL\u0445L + L\u0445LL\u0445LLLLLLLL\u0445L.substring(0, \u0445L\u0445L\u0445LLLLLLLL\u0445L);
            int L\u0445\u0445\u0445LLLLLLLLL\u0445L = \u0445L\u0445L\u0445LLLLLLLL\u0445L;
        } else {
            \u0445LLL\u0445LLLLLLLL\u0445L = \u0445LLL\u0445LLLLLLLL\u0445L + L\u0445LL\u0445LLLLLLLL\u0445L;
            L\u0445\u0445L\u0445LLLLLLLL\u0445L = L\u0445LL\u0445LLLLLLLL\u0445L.length();
        }
        if (!\u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.text.isEmpty() && LL\u0445L\u0445LLLLLLLL\u0445L < \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.text.length()) {
            \u0445LLL\u0445LLLLLLLL\u0445L = \u0445LLL\u0445LLLLLLLL\u0445L + \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.text.substring(LL\u0445L\u0445LLLLLLLL\u0445L);
        }
        if (\u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.validator.apply(\u0445LLL\u0445LLLLLLLL\u0445L)) {
            \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.text = \u0445LLL\u0445LLLLLLLL\u0445L;
            \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.moveCursorBy(\u0445\u0445LL\u0445LLLLLLLL\u0445L - \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.selectionEnd + L\u0445\u0445L\u0445LLLLLLLL\u0445L);
            \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.func_190516_a(\u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.id, \u0445\u0445\u0445\u0445LLLLLLLLL\u0445L.text);
        }
    }

    public void func_190516_a(int \u0445\u0445LLL\u0445LLLLLLL\u0445L, String LL\u0445LL\u0445LLLLLLL\u0445L) {
        GuiSearcher L\u0445LLL\u0445LLLLLLL\u0445L;
        if (L\u0445LLL\u0445LLLLLLL\u0445L.guiResponder != null) {
            L\u0445LLL\u0445LLLLLLL\u0445L.guiResponder.setEntryValue(\u0445\u0445LLL\u0445LLLLLLL\u0445L, LL\u0445LL\u0445LLLLLLL\u0445L);
        }
    }

    public void deleteWords(int \u0445\u0445L\u0445L\u0445LLLLLLL\u0445L) {
        GuiSearcher L\u0445L\u0445L\u0445LLLLLLL\u0445L;
        if (!L\u0445L\u0445L\u0445LLLLLLL\u0445L.text.isEmpty()) {
            if (L\u0445L\u0445L\u0445LLLLLLL\u0445L.selectionEnd != L\u0445L\u0445L\u0445LLLLLLL\u0445L.cursorPosition) {
                L\u0445L\u0445L\u0445LLLLLLL\u0445L.writeText("");
            } else {
                L\u0445L\u0445L\u0445LLLLLLL\u0445L.deleteFromCursor(L\u0445L\u0445L\u0445LLLLLLL\u0445L.getNthWordFromCursor(\u0445\u0445L\u0445L\u0445LLLLLLL\u0445L) - L\u0445L\u0445L\u0445LLLLLLL\u0445L.cursorPosition);
            }
        }
    }

    public void deleteFromCursor(int \u0445LL\u0445\u0445\u0445LLLLLLL\u0445L) {
        GuiSearcher LLL\u0445\u0445\u0445LLLLLLL\u0445L;
        if (!LLL\u0445\u0445\u0445LLLLLLL\u0445L.text.isEmpty()) {
            if (LLL\u0445\u0445\u0445LLLLLLL\u0445L.selectionEnd != LLL\u0445\u0445\u0445LLLLLLL\u0445L.cursorPosition) {
                LLL\u0445\u0445\u0445LLLLLLL\u0445L.writeText("");
            } else {
                boolean LL\u0445L\u0445\u0445LLLLLLL\u0445L = \u0445LL\u0445\u0445\u0445LLLLLLL\u0445L < 0;
                int \u0445L\u0445L\u0445\u0445LLLLLLL\u0445L = LL\u0445L\u0445\u0445LLLLLLL\u0445L ? LLL\u0445\u0445\u0445LLLLLLL\u0445L.cursorPosition + \u0445LL\u0445\u0445\u0445LLLLLLL\u0445L : LLL\u0445\u0445\u0445LLLLLLL\u0445L.cursorPosition;
                int L\u0445\u0445L\u0445\u0445LLLLLLL\u0445L = LL\u0445L\u0445\u0445LLLLLLL\u0445L ? LLL\u0445\u0445\u0445LLLLLLL\u0445L.cursorPosition : LLL\u0445\u0445\u0445LLLLLLL\u0445L.cursorPosition + \u0445LL\u0445\u0445\u0445LLLLLLL\u0445L;
                String \u0445\u0445\u0445L\u0445\u0445LLLLLLL\u0445L = "";
                if (\u0445L\u0445L\u0445\u0445LLLLLLL\u0445L >= 0) {
                    \u0445\u0445\u0445L\u0445\u0445LLLLLLL\u0445L = LLL\u0445\u0445\u0445LLLLLLL\u0445L.text.substring(0, \u0445L\u0445L\u0445\u0445LLLLLLL\u0445L);
                }
                if (L\u0445\u0445L\u0445\u0445LLLLLLL\u0445L < LLL\u0445\u0445\u0445LLLLLLL\u0445L.text.length()) {
                    \u0445\u0445\u0445L\u0445\u0445LLLLLLL\u0445L = \u0445\u0445\u0445L\u0445\u0445LLLLLLL\u0445L + LLL\u0445\u0445\u0445LLLLLLL\u0445L.text.substring(L\u0445\u0445L\u0445\u0445LLLLLLL\u0445L);
                }
                if (LLL\u0445\u0445\u0445LLLLLLL\u0445L.validator.apply(\u0445\u0445\u0445L\u0445\u0445LLLLLLL\u0445L)) {
                    LLL\u0445\u0445\u0445LLLLLLL\u0445L.text = \u0445\u0445\u0445L\u0445\u0445LLLLLLL\u0445L;
                    if (LL\u0445L\u0445\u0445LLLLLLL\u0445L) {
                        LLL\u0445\u0445\u0445LLLLLLL\u0445L.moveCursorBy(\u0445LL\u0445\u0445\u0445LLLLLLL\u0445L);
                    }
                    LLL\u0445\u0445\u0445LLLLLLL\u0445L.func_190516_a(LLL\u0445\u0445\u0445LLLLLLL\u0445L.id, LLL\u0445\u0445\u0445LLLLLLL\u0445L.text);
                }
            }
        }
    }

    public int getId() {
        GuiSearcher \u0445LLLLL\u0445LLLLLL\u0445L;
        return \u0445LLLLL\u0445LLLLLL\u0445L.id;
    }

    public int getNthWordFromCursor(int L\u0445\u0445LLL\u0445LLLLLL\u0445L) {
        GuiSearcher \u0445L\u0445LLL\u0445LLLLLL\u0445L;
        return \u0445L\u0445LLL\u0445LLLLLL\u0445L.getNthWordFromPos(L\u0445\u0445LLL\u0445LLLLLL\u0445L, \u0445L\u0445LLL\u0445LLLLLL\u0445L.getCursorPosition());
    }

    public int getNthWordFromPos(int \u0445L\u0445\u0445LL\u0445LLLLLL\u0445L, int L\u0445\u0445\u0445LL\u0445LLLLLL\u0445L) {
        GuiSearcher LL\u0445\u0445LL\u0445LLLLLL\u0445L;
        return LL\u0445\u0445LL\u0445LLLLLL\u0445L.getNthWordFromPosWS(\u0445L\u0445\u0445LL\u0445LLLLLL\u0445L, L\u0445\u0445\u0445LL\u0445LLLLLL\u0445L, true);
    }

    public int getNthWordFromPosWS(int L\u0445\u0445\u0445\u0445L\u0445LLLLLL\u0445L, int \u0445\u0445\u0445\u0445\u0445L\u0445LLLLLL\u0445L, boolean LLLLL\u0445\u0445LLLLLL\u0445L) {
        int \u0445LLLL\u0445\u0445LLLLLL\u0445L = \u0445\u0445\u0445\u0445\u0445L\u0445LLLLLL\u0445L;
        boolean L\u0445LLL\u0445\u0445LLLLLL\u0445L = L\u0445\u0445\u0445\u0445L\u0445LLLLLL\u0445L < 0;
        int LL\u0445\u0445\u0445L\u0445LLLLLL\u0445L = 0;
        int \u0445\u0445LLL\u0445\u0445LLLLLL\u0445L = Math.abs(L\u0445\u0445\u0445\u0445L\u0445LLLLLL\u0445L);
        if (LL\u0445\u0445\u0445L\u0445LLLLLL\u0445L < \u0445\u0445LLL\u0445\u0445LLLLLL\u0445L) {
            GuiSearcher \u0445L\u0445\u0445\u0445L\u0445LLLLLL\u0445L;
            if (!L\u0445LLL\u0445\u0445LLLLLL\u0445L) {
                int \u0445\u0445L\u0445\u0445L\u0445LLLLLL\u0445L = \u0445L\u0445\u0445\u0445L\u0445LLLLLL\u0445L.text.length();
                if ((\u0445LLLL\u0445\u0445LLLLLL\u0445L = \u0445L\u0445\u0445\u0445L\u0445LLLLLL\u0445L.text.indexOf(32, \u0445LLLL\u0445\u0445LLLLLL\u0445L)) == -1) {
                    \u0445LLLL\u0445\u0445LLLLLL\u0445L = \u0445\u0445L\u0445\u0445L\u0445LLLLLL\u0445L;
                } else if (LLLLL\u0445\u0445LLLLLL\u0445L && \u0445LLLL\u0445\u0445LLLLLL\u0445L < \u0445\u0445L\u0445\u0445L\u0445LLLLLL\u0445L && \u0445L\u0445\u0445\u0445L\u0445LLLLLL\u0445L.text.charAt(\u0445LLLL\u0445\u0445LLLLLL\u0445L) == ' ') {
                    ++\u0445LLLL\u0445\u0445LLLLLL\u0445L;
                    return 0;
                }
            } else {
                if (LLLLL\u0445\u0445LLLLLL\u0445L && \u0445LLLL\u0445\u0445LLLLLL\u0445L > 0 && \u0445L\u0445\u0445\u0445L\u0445LLLLLL\u0445L.text.charAt(\u0445LLLL\u0445\u0445LLLLLL\u0445L - 1) == ' ') {
                    --\u0445LLLL\u0445\u0445LLLLLL\u0445L;
                    return 0;
                }
                if (\u0445LLLL\u0445\u0445LLLLLL\u0445L > 0 && \u0445L\u0445\u0445\u0445L\u0445LLLLLL\u0445L.text.charAt(\u0445LLLL\u0445\u0445LLLLLL\u0445L - 1) != ' ') {
                    --\u0445LLLL\u0445\u0445LLLLLL\u0445L;
                    return 0;
                }
            }
            ++LL\u0445\u0445\u0445L\u0445LLLLLL\u0445L;
            return 0;
        }
        return \u0445LLLL\u0445\u0445LLLLLL\u0445L;
    }

    public void moveCursorBy(int LLLL\u0445\u0445\u0445LLLLLL\u0445L) {
        GuiSearcher \u0445\u0445\u0445\u0445L\u0445\u0445LLLLLL\u0445L;
        \u0445\u0445\u0445\u0445L\u0445\u0445LLLLLL\u0445L.setCursorPosition(\u0445\u0445\u0445\u0445L\u0445\u0445LLLLLL\u0445L.selectionEnd + LLLL\u0445\u0445\u0445LLLLLL\u0445L);
    }

    public void setCursorPositionZero() {
        GuiSearcher LL\u0445L\u0445\u0445\u0445LLLLLL\u0445L;
        LL\u0445L\u0445\u0445\u0445LLLLLL\u0445L.setCursorPosition(0);
    }

    public void setCursorPositionEnd() {
        GuiSearcher \u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL\u0445L;
        \u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL\u0445L.setCursorPosition(\u0445\u0445\u0445L\u0445\u0445\u0445LLLLLL\u0445L.text.length());
    }

    public boolean textboxKeyTyped(char \u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L, int L\u0445\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L) {
        GuiSearcher LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L;
        if (!LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.isFocused) {
            return false;
        }
        if (GuiScreen.isKeyComboCtrlA(L\u0445\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L)) {
            LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setCursorPositionEnd();
            LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setSelectionPos(0);
            return true;
        }
        if (GuiScreen.isKeyComboCtrlC(L\u0445\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L)) {
            GuiScreen.setClipboardString(LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.getSelectedText());
            return true;
        }
        if (GuiScreen.isKeyComboCtrlV(L\u0445\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L)) {
            if (LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.isEnabled) {
                LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.writeText(GuiScreen.getClipboardString());
            }
            return true;
        }
        if (GuiScreen.isKeyComboCtrlX(L\u0445\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L)) {
            GuiScreen.setClipboardString(LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.getSelectedText());
            if (LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.isEnabled) {
                LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.writeText("");
            }
            return true;
        }
        switch (L\u0445\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L) {
            case 14: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.isEnabled) {
                        LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.deleteWords(-1);
                    }
                } else if (LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.isEnabled) {
                    LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.deleteFromCursor(-1);
                }
                return true;
            }
            case 199: {
                if (GuiScreen.isShiftKeyDown()) {
                    LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setSelectionPos(0);
                } else {
                    LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setCursorPositionZero();
                }
                return true;
            }
            case 203: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setSelectionPos(LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.getNthWordFromPos(-1, LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.getSelectionEnd()));
                    } else {
                        LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setSelectionPos(LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.getSelectionEnd() - 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setCursorPosition(LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.getNthWordFromCursor(-1));
                } else {
                    LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.moveCursorBy(-1);
                }
                return true;
            }
            case 205: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setSelectionPos(LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.getNthWordFromPos(1, LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.getSelectionEnd()));
                    } else {
                        LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setSelectionPos(LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.getSelectionEnd() + 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setCursorPosition(LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.getNthWordFromCursor(1));
                } else {
                    LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.moveCursorBy(1);
                }
                return true;
            }
            case 207: {
                if (GuiScreen.isShiftKeyDown()) {
                    LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setSelectionPos(LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.text.length());
                } else {
                    LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.setCursorPositionEnd();
                }
                return true;
            }
            case 211: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.isEnabled) {
                        LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.deleteWords(1);
                    }
                } else if (LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.isEnabled) {
                    LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.deleteFromCursor(1);
                }
                return true;
            }
        }
        if (ChatAllowedCharacters.isAllowedCharacter((char)\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L)) {
            if (LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.isEnabled) {
                LL\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L.writeText(Character.toString(\u0445L\u0445\u0445\u0445\u0445\u0445LLLLLL\u0445L));
            }
            return true;
        }
        return false;
    }

    public boolean mouseClicked(int LL\u0445\u0445LLL\u0445LLLLL\u0445L, int \u0445L\u0445\u0445LLL\u0445LLLLL\u0445L, int L\u0445\u0445\u0445LLL\u0445LLLLL\u0445L) {
        GuiSearcher \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L;
        boolean \u0445\u0445\u0445\u0445LLL\u0445LLLLL\u0445L;
        boolean bl2 = \u0445\u0445\u0445\u0445LLL\u0445LLLLL\u0445L = LL\u0445\u0445LLL\u0445LLLLL\u0445L >= \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.xPosition && LL\u0445\u0445LLL\u0445LLLLL\u0445L < \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.xPosition + \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.width && \u0445L\u0445\u0445LLL\u0445LLLLL\u0445L >= \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.yPosition && \u0445L\u0445\u0445LLL\u0445LLLLL\u0445L < \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.yPosition + \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.height;
        if (\u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.canLoseFocus) {
            \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.setFocused(\u0445\u0445\u0445\u0445LLL\u0445LLLLL\u0445L);
        }
        if (\u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.isFocused && \u0445\u0445\u0445\u0445LLL\u0445LLLLL\u0445L && L\u0445\u0445\u0445LLL\u0445LLLLL\u0445L == 0) {
            int \u0445LL\u0445LLL\u0445LLLLL\u0445L = LL\u0445\u0445LLL\u0445LLLLL\u0445L - \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.xPosition;
            if (\u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.enableBackgroundDrawing) {
                \u0445LL\u0445LLL\u0445LLLLL\u0445L -= 4;
            }
            String L\u0445L\u0445LLL\u0445LLLLL\u0445L = \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.fontRendererInstance.trimStringToWidth(\u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.text.substring(\u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.lineScrollOffset), \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.getWidth());
            \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.setCursorPosition(\u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.fontRendererInstance.trimStringToWidth(L\u0445L\u0445LLL\u0445LLLLL\u0445L, \u0445LL\u0445LLL\u0445LLLLL\u0445L).length() + \u0445\u0445L\u0445LLL\u0445LLLLL\u0445L.lineScrollOffset);
            return true;
        }
        return false;
    }

    public void drawTextBox() {
        GuiSearcher \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L;
        if (\u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.getVisible()) {
            if (\u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.getEnableBackgroundDrawing()) {
                RectHelper.drawRect(\u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.xPosition, \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.yPosition, \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.xPosition + \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.width, \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.yPosition + \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.height, new Color(30, 30, 30, 185).getRGB());
                RectHelper.drawGradientRect(\u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.xPosition, \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.yPosition, \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.xPosition + \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.width, \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.yPosition + \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.height, new Color(30, 30, 30, 190).getRGB(), new Color(30, 30, 30, 190).getRGB());
            }
            int L\u0445\u0445LL\u0445L\u0445LLLLL\u0445L = -1;
            int \u0445\u0445\u0445LL\u0445L\u0445LLLLL\u0445L = \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.cursorPosition - \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.lineScrollOffset;
            int LLL\u0445L\u0445L\u0445LLLLL\u0445L = \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.selectionEnd - \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.lineScrollOffset;
            String \u0445LL\u0445L\u0445L\u0445LLLLL\u0445L = \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.fontRendererInstance.trimStringToWidth(\u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.text.substring(\u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.lineScrollOffset), \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.getWidth());
            boolean L\u0445L\u0445L\u0445L\u0445LLLLL\u0445L = \u0445\u0445\u0445LL\u0445L\u0445LLLLL\u0445L >= 0 && \u0445\u0445\u0445LL\u0445L\u0445LLLLL\u0445L <= \u0445LL\u0445L\u0445L\u0445LLLLL\u0445L.length();
            boolean \u0445\u0445L\u0445L\u0445L\u0445LLLLL\u0445L = \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.isFocused && \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.cursorCounter / 6 % 2 == 0 && L\u0445L\u0445L\u0445L\u0445LLLLL\u0445L;
            int LL\u0445\u0445L\u0445L\u0445LLLLL\u0445L = \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.enableBackgroundDrawing ? \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.xPosition + 4 : \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.xPosition;
            int \u0445L\u0445\u0445L\u0445L\u0445LLLLL\u0445L = \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.enableBackgroundDrawing ? \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.yPosition + (\u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.height - 8) / 2 : \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.yPosition;
            int L\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445L = LL\u0445\u0445L\u0445L\u0445LLLLL\u0445L;
            if (LLL\u0445L\u0445L\u0445LLLLL\u0445L > \u0445LL\u0445L\u0445L\u0445LLLLL\u0445L.length()) {
                LLL\u0445L\u0445L\u0445LLLLL\u0445L = \u0445LL\u0445L\u0445L\u0445LLLLL\u0445L.length();
            }
            if (!\u0445LL\u0445L\u0445L\u0445LLLLL\u0445L.isEmpty()) {
                String LL\u0445LL\u0445L\u0445LLLLL\u0445L;
                String string = LL\u0445LL\u0445L\u0445LLLLL\u0445L = L\u0445L\u0445L\u0445L\u0445LLLLL\u0445L ? \u0445LL\u0445L\u0445L\u0445LLLLL\u0445L.substring(0, \u0445\u0445\u0445LL\u0445L\u0445LLLLL\u0445L) : \u0445LL\u0445L\u0445L\u0445LLLLL\u0445L;
                if (Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.warpSpoof.getBoolValue() && LL\u0445LL\u0445L\u0445LLLLL\u0445L.startsWith("/warp")) {
                    LL\u0445LL\u0445L\u0445LLLLL\u0445L = "/warp ";
                }
                if (Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.loginSpoof.getBoolValue() && LL\u0445LL\u0445L\u0445LLLLL\u0445L.startsWith("/l")) {
                    LL\u0445LL\u0445L\u0445LLLLL\u0445L = "/l ";
                }
                L\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445L = \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.fontRendererInstance.drawStringWithShadow(LL\u0445LL\u0445L\u0445LLLLL\u0445L, LL\u0445\u0445L\u0445L\u0445LLLLL\u0445L, \u0445L\u0445\u0445L\u0445L\u0445LLLLL\u0445L, L\u0445\u0445LL\u0445L\u0445LLLLL\u0445L);
            }
            boolean \u0445\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445L = \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.cursorPosition < \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.text.length() || \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.text.length() >= \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.getMaxStringLength();
            int LLLL\u0445\u0445L\u0445LLLLL\u0445L = L\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445L;
            if (!L\u0445L\u0445L\u0445L\u0445LLLLL\u0445L) {
                LLLL\u0445\u0445L\u0445LLLLL\u0445L = \u0445\u0445\u0445LL\u0445L\u0445LLLLL\u0445L > 0 ? LL\u0445\u0445L\u0445L\u0445LLLLL\u0445L + \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.width : LL\u0445\u0445L\u0445L\u0445LLLLL\u0445L;
            } else if (\u0445\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445L) {
                LLLL\u0445\u0445L\u0445LLLLL\u0445L = L\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445L - 1;
                --L\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445L;
            }
            if (!\u0445LL\u0445L\u0445L\u0445LLLLL\u0445L.isEmpty() && L\u0445L\u0445L\u0445L\u0445LLLLL\u0445L && \u0445\u0445\u0445LL\u0445L\u0445LLLLL\u0445L < \u0445LL\u0445L\u0445L\u0445LLLLL\u0445L.length()) {
                L\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445L = \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.fontRendererInstance.drawStringWithShadow(\u0445LL\u0445L\u0445L\u0445LLLLL\u0445L.substring(\u0445\u0445\u0445LL\u0445L\u0445LLLLL\u0445L), L\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445L, \u0445L\u0445\u0445L\u0445L\u0445LLLLL\u0445L, L\u0445\u0445LL\u0445L\u0445LLLLL\u0445L);
            }
            if (\u0445\u0445L\u0445L\u0445L\u0445LLLLL\u0445L) {
                if (\u0445\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445L) {
                    Gui.drawRect(LLLL\u0445\u0445L\u0445LLLLL\u0445L, \u0445L\u0445\u0445L\u0445L\u0445LLLLL\u0445L - 1, LLLL\u0445\u0445L\u0445LLLLL\u0445L + 1, \u0445L\u0445\u0445L\u0445L\u0445LLLLL\u0445L + 1 + \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.fontRendererInstance.FONT_HEIGHT, -3092272);
                } else {
                    \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.fontRendererInstance.drawStringWithShadow("_", LLLL\u0445\u0445L\u0445LLLLL\u0445L, \u0445L\u0445\u0445L\u0445L\u0445LLLLL\u0445L, L\u0445\u0445LL\u0445L\u0445LLLLL\u0445L);
                }
            }
            if (LLL\u0445L\u0445L\u0445LLLLL\u0445L != \u0445\u0445\u0445LL\u0445L\u0445LLLLL\u0445L) {
                int \u0445L\u0445LL\u0445L\u0445LLLLL\u0445L = LL\u0445\u0445L\u0445L\u0445LLLLL\u0445L + \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.fontRendererInstance.getStringWidth(\u0445LL\u0445L\u0445L\u0445LLLLL\u0445L.substring(0, LLL\u0445L\u0445L\u0445LLLLL\u0445L));
                \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.drawCursorVertical(LLLL\u0445\u0445L\u0445LLLLL\u0445L, \u0445L\u0445\u0445L\u0445L\u0445LLLLL\u0445L - 1, \u0445L\u0445LL\u0445L\u0445LLLLL\u0445L - 1, \u0445L\u0445\u0445L\u0445L\u0445LLLLL\u0445L + 1 + \u0445LLL\u0445\u0445L\u0445LLLLL\u0445L.fontRendererInstance.FONT_HEIGHT);
            }
        }
    }

    private void drawCursorVertical(int \u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L, int LLLLL\u0445\u0445\u0445LLLLL\u0445L, int \u0445L\u0445LL\u0445\u0445\u0445LLLLL\u0445L, int \u0445\u0445\u0445LL\u0445\u0445\u0445LLLLL\u0445L) {
        GuiSearcher \u0445L\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L;
        if (\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L < \u0445L\u0445LL\u0445\u0445\u0445LLLLL\u0445L) {
            int LLL\u0445\u0445L\u0445\u0445LLLLL\u0445L = \u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L;
            \u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L = \u0445L\u0445LL\u0445\u0445\u0445LLLLL\u0445L;
            \u0445L\u0445LL\u0445\u0445\u0445LLLLL\u0445L = LLL\u0445\u0445L\u0445\u0445LLLLL\u0445L;
        }
        if (LLLLL\u0445\u0445\u0445LLLLL\u0445L < \u0445\u0445\u0445LL\u0445\u0445\u0445LLLLL\u0445L) {
            int \u0445\u0445L\u0445\u0445L\u0445\u0445LLLLL\u0445L = LLLLL\u0445\u0445\u0445LLLLL\u0445L;
            LLLLL\u0445\u0445\u0445LLLLL\u0445L = \u0445\u0445\u0445LL\u0445\u0445\u0445LLLLL\u0445L;
            \u0445\u0445\u0445LL\u0445\u0445\u0445LLLLL\u0445L = \u0445\u0445L\u0445\u0445L\u0445\u0445LLLLL\u0445L;
        }
        if (\u0445L\u0445LL\u0445\u0445\u0445LLLLL\u0445L > \u0445L\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L.xPosition + \u0445L\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L.width) {
            \u0445L\u0445LL\u0445\u0445\u0445LLLLL\u0445L = \u0445L\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L.xPosition + \u0445L\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L.width;
        }
        if (\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L > \u0445L\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L.xPosition + \u0445L\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L.width) {
            \u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L = \u0445L\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L.xPosition + \u0445L\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L.width;
        }
        Tessellator \u0445LL\u0445L\u0445\u0445\u0445LLLLL\u0445L = Tessellator.getInstance();
        BufferBuilder L\u0445L\u0445L\u0445\u0445\u0445LLLLL\u0445L = \u0445LL\u0445L\u0445\u0445\u0445LLLLL\u0445L.getBuffer();
        GlStateManager.color(0.0f, 0.0f, 255.0f, 255.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.enableColorLogic();
        GlStateManager.colorLogicOp(GlStateManager.LogicOp.OR_REVERSE);
        L\u0445L\u0445L\u0445\u0445\u0445LLLLL\u0445L.begin(7, DefaultVertexFormats.POSITION);
        L\u0445L\u0445L\u0445\u0445\u0445LLLLL\u0445L.pos(\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L, \u0445\u0445\u0445LL\u0445\u0445\u0445LLLLL\u0445L, 0.0).endVertex();
        L\u0445L\u0445L\u0445\u0445\u0445LLLLL\u0445L.pos(\u0445L\u0445LL\u0445\u0445\u0445LLLLL\u0445L, \u0445\u0445\u0445LL\u0445\u0445\u0445LLLLL\u0445L, 0.0).endVertex();
        L\u0445L\u0445L\u0445\u0445\u0445LLLLL\u0445L.pos(\u0445L\u0445LL\u0445\u0445\u0445LLLLL\u0445L, LLLLL\u0445\u0445\u0445LLLLL\u0445L, 0.0).endVertex();
        L\u0445L\u0445L\u0445\u0445\u0445LLLLL\u0445L.pos(\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLLLL\u0445L, LLLLL\u0445\u0445\u0445LLLLL\u0445L, 0.0).endVertex();
        \u0445LL\u0445L\u0445\u0445\u0445LLLLL\u0445L.draw();
        GlStateManager.disableColorLogic();
        GlStateManager.enableTexture2D();
    }

    public int getMaxStringLength() {
        GuiSearcher \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLLL\u0445L;
        return \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLLL\u0445L.maxStringLength;
    }

    public void setMaxStringLength(int \u0445L\u0445LLLLL\u0445LLLL\u0445L) {
        GuiSearcher \u0445\u0445LLLLLL\u0445LLLL\u0445L;
        \u0445\u0445LLLLLL\u0445LLLL\u0445L.maxStringLength = \u0445L\u0445LLLLL\u0445LLLL\u0445L;
        if (\u0445\u0445LLLLLL\u0445LLLL\u0445L.text.length() > \u0445L\u0445LLLLL\u0445LLLL\u0445L) {
            \u0445\u0445LLLLLL\u0445LLLL\u0445L.text = \u0445\u0445LLLLLL\u0445LLLL\u0445L.text.substring(0, \u0445L\u0445LLLLL\u0445LLLL\u0445L);
        }
    }

    public int getCursorPosition() {
        GuiSearcher L\u0445L\u0445LLLL\u0445LLLL\u0445L;
        return L\u0445L\u0445LLLL\u0445LLLL\u0445L.cursorPosition;
    }

    public void setCursorPosition(int L\u0445\u0445L\u0445LLL\u0445LLLL\u0445L) {
        GuiSearcher LL\u0445L\u0445LLL\u0445LLLL\u0445L;
        LL\u0445L\u0445LLL\u0445LLLL\u0445L.cursorPosition = L\u0445\u0445L\u0445LLL\u0445LLLL\u0445L;
        int LLL\u0445\u0445LLL\u0445LLLL\u0445L = LL\u0445L\u0445LLL\u0445LLLL\u0445L.text.length();
        LL\u0445L\u0445LLL\u0445LLLL\u0445L.cursorPosition = MathHelper.clamp(LL\u0445L\u0445LLL\u0445LLLL\u0445L.cursorPosition, 0, LLL\u0445\u0445LLL\u0445LLLL\u0445L);
        LL\u0445L\u0445LLL\u0445LLLL\u0445L.setSelectionPos(LL\u0445L\u0445LLL\u0445LLLL\u0445L.cursorPosition);
    }

    public boolean getEnableBackgroundDrawing() {
        GuiSearcher LL\u0445LL\u0445LL\u0445LLLL\u0445L;
        return LL\u0445LL\u0445LL\u0445LLLL\u0445L.enableBackgroundDrawing;
    }

    public void setEnableBackgroundDrawing(boolean \u0445\u0445L\u0445L\u0445LL\u0445LLLL\u0445L) {
        L\u0445L\u0445L\u0445LL\u0445LLLL\u0445L.enableBackgroundDrawing = \u0445\u0445L\u0445L\u0445LL\u0445LLLL\u0445L;
    }

    public void setTextColor(int LLL\u0445\u0445\u0445LL\u0445LLLL\u0445L) {
        L\u0445\u0445L\u0445\u0445LL\u0445LLLL\u0445L.enabledColor = LLL\u0445\u0445\u0445LL\u0445LLLL\u0445L;
    }

    public void setDisabledTextColour(int LL\u0445LLL\u0445L\u0445LLLL\u0445L) {
        \u0445\u0445LLLL\u0445L\u0445LLLL\u0445L.disabledColor = LL\u0445LLL\u0445L\u0445LLLL\u0445L;
    }

    public boolean isFocused() {
        GuiSearcher LLLLLLL\u0445\u0445LLLL\u0445L;
        return LLLLLLL\u0445\u0445LLLL\u0445L.isFocused;
    }

    public void setFocused(boolean L\u0445LL\u0445LL\u0445\u0445LLLL\u0445L) {
        GuiSearcher \u0445L\u0445\u0445LLL\u0445\u0445LLLL\u0445L;
        if (L\u0445LL\u0445LL\u0445\u0445LLLL\u0445L && !\u0445L\u0445\u0445LLL\u0445\u0445LLLL\u0445L.isFocused) {
            \u0445L\u0445\u0445LLL\u0445\u0445LLLL\u0445L.cursorCounter = 0;
        }
        \u0445L\u0445\u0445LLL\u0445\u0445LLLL\u0445L.isFocused = L\u0445LL\u0445LL\u0445\u0445LLLL\u0445L;
        if (Minecraft.getInstance().currentScreen != null) {
            Minecraft.getInstance().currentScreen.func_193975_a(L\u0445LL\u0445LL\u0445\u0445LLLL\u0445L);
        }
    }

    public void setEnabled(boolean L\u0445L\u0445\u0445LL\u0445\u0445LLLL\u0445L) {
        \u0445LL\u0445\u0445LL\u0445\u0445LLLL\u0445L.isEnabled = L\u0445L\u0445\u0445LL\u0445\u0445LLLL\u0445L;
    }

    public int getSelectionEnd() {
        GuiSearcher \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445LLLL\u0445L;
        return \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445LLLL\u0445L.selectionEnd;
    }

    public int getWidth() {
        GuiSearcher L\u0445LLL\u0445L\u0445\u0445LLLL\u0445L;
        return L\u0445LLL\u0445L\u0445\u0445LLLL\u0445L.getEnableBackgroundDrawing() ? L\u0445LLL\u0445L\u0445\u0445LLLL\u0445L.width - 8 : L\u0445LLL\u0445L\u0445\u0445LLLL\u0445L.width;
    }

    public void setSelectionPos(int L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L) {
        GuiSearcher \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L;
        int \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L = \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.text.length();
        if (L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L > \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L) {
            L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L = \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L;
        }
        if (L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L < 0) {
            L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L = 0;
        }
        \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.selectionEnd = L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L;
        if (\u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.fontRendererInstance != null) {
            if (\u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset > \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L) {
                \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset = \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L;
            }
            int L\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L = \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.getWidth();
            String \u0445\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L = \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.fontRendererInstance.trimStringToWidth(\u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.text.substring(\u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset), L\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L);
            int LL\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L = \u0445\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.length() + \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset;
            if (L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L == \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset) {
                \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset -= \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.fontRendererInstance.trimStringToWidth(\u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.text, L\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L, true).length();
            }
            if (L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L > LL\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L) {
                \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset += L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L - LL\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L;
            } else if (L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L <= \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset) {
                \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset -= \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset - L\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L;
            }
            \u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset = MathHelper.clamp(\u0445L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L.lineScrollOffset, 0, \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L);
        }
    }

    public void setCanLoseFocus(boolean \u0445LL\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L) {
        LLL\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L.canLoseFocus = \u0445LL\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L;
    }

    public boolean getVisible() {
        GuiSearcher \u0445L\u0445\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L;
        return \u0445L\u0445\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L.visible;
    }

    public void setVisible(boolean L\u0445LLLL\u0445\u0445\u0445LLLL\u0445L) {
        \u0445LLLLL\u0445\u0445\u0445LLLL\u0445L.visible = L\u0445LLLL\u0445\u0445\u0445LLLL\u0445L;
    }
}

