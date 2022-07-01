/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.security.gui;

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
import org.Destroy.client.helpers.palette.PaletteHelper;
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

    public GuiSearcher(int \u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L, FontRenderer LL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L, int \u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L, int L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L, int \u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L, int LLLLLLL\u0445L\u0445L\u0445\u0445L) {
        GuiSearcher L\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L;
        L\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.id = \u0445\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L;
        L\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.fontRendererInstance = LL\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L;
        L\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.xPosition = \u0445L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L;
        L\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.yPosition = L\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L;
        L\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.width = \u0445\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L;
        L\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L.height = LLLLLLL\u0445L\u0445L\u0445\u0445L;
    }

    public void setGuiResponder(GuiPageButtonList.GuiResponder \u0445\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L) {
        L\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L.guiResponder = \u0445\u0445L\u0445LLL\u0445L\u0445L\u0445\u0445L;
    }

    public void updateCursorCounter() {
        GuiSearcher \u0445\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L;
        ++\u0445\u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L.cursorCounter;
    }

    public String getText() {
        GuiSearcher L\u0445LL\u0445LL\u0445L\u0445L\u0445\u0445L;
        return L\u0445LL\u0445LL\u0445L\u0445L\u0445\u0445L.text;
    }

    public void setText(String \u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L) {
        GuiSearcher L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L;
        if (L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L.validator.apply(\u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L)) {
            L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L.text = \u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L.length() > L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L.maxStringLength ? \u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L.substring(0, L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L.maxStringLength) : \u0445\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L;
            L\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445L.setCursorPositionEnd();
        }
    }

    public String getSelectedText() {
        GuiSearcher \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L;
        int L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L = \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.cursorPosition < \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.selectionEnd ? \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.cursorPosition : \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.selectionEnd;
        int \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L = \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.cursorPosition < \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.selectionEnd ? \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.selectionEnd : \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.cursorPosition;
        return \u0445L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L.text.substring(L\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L, \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445L);
    }

    public void setValidator(Predicate<String> L\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L) {
        \u0445L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L.validator = L\u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445L;
    }

    public void writeText(String \u0445\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L) {
        int \u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
        GuiSearcher L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
        String LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L = "";
        String \u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L = ChatAllowedCharacters.filterAllowedCharacters(\u0445\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L);
        int L\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L = L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.cursorPosition < L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.selectionEnd ? L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.cursorPosition : L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.selectionEnd;
        int \u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L = L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.cursorPosition < L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.selectionEnd ? L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.selectionEnd : L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.cursorPosition;
        int LLL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L = L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.maxStringLength - L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.text.length() - (L\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L - \u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L);
        if (!L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.text.isEmpty()) {
            LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L = LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L + L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.text.substring(0, L\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L);
        }
        if (LLL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L < \u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L.length()) {
            LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L = LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L + \u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L.substring(0, LLL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L);
            int \u0445LLL\u0445\u0445L\u0445L\u0445L\u0445\u0445L = LLL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
        } else {
            LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L = LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L + \u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
            \u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L = \u0445L\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L.length();
        }
        if (!L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.text.isEmpty() && \u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L < L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.text.length()) {
            LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L = LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L + L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.text.substring(\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L);
        }
        if (L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.validator.apply(LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L)) {
            L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.text = LL\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
            L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.moveCursorBy(L\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L - L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.selectionEnd + \u0445LL\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L);
            L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.func_190516_a(L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.id, L\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.text);
        }
    }

    public void func_190516_a(int L\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L, String \u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L) {
        GuiSearcher \u0445L\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L;
        if (\u0445L\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L.guiResponder != null) {
            \u0445L\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L.guiResponder.setEntryValue(L\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L, \u0445\u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445L);
        }
    }

    public void deleteWords(int L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L) {
        GuiSearcher \u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L;
        if (!\u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.text.isEmpty()) {
            if (\u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.selectionEnd != \u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.cursorPosition) {
                \u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.writeText("");
            } else {
                \u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.deleteFromCursor(\u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.getNthWordFromCursor(L\u0445\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L) - \u0445L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445L.cursorPosition);
            }
        }
    }

    public void deleteFromCursor(int LL\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L) {
        GuiSearcher \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
        if (!\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.text.isEmpty()) {
            if (\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.selectionEnd != \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.cursorPosition) {
                \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.writeText("");
            } else {
                boolean \u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L = LL\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L < 0;
                int LLL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L = \u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L ? \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.cursorPosition + LL\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L : \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.cursorPosition;
                int \u0445LL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L = \u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L ? \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.cursorPosition : \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.cursorPosition + LL\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
                String L\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L = "";
                if (LLL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L >= 0) {
                    L\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L = \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.text.substring(0, LLL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L);
                }
                if (\u0445LL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L < \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.text.length()) {
                    L\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L = L\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L + \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.text.substring(\u0445LL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L);
                }
                if (\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.validator.apply(L\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L)) {
                    \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.text = L\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L;
                    if (\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445L) {
                        \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.moveCursorBy(LL\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L);
                    }
                    \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.func_190516_a(\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.id, \u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445L.text);
                }
            }
        }
    }

    public int getId() {
        GuiSearcher LL\u0445LL\u0445\u0445\u0445L\u0445L\u0445\u0445L;
        return LL\u0445LL\u0445\u0445\u0445L\u0445L\u0445\u0445L.id;
    }

    public int getNthWordFromCursor(int \u0445LL\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L) {
        GuiSearcher LLL\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L;
        return LLL\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getNthWordFromPos(\u0445LL\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L, LLL\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getCursorPosition());
    }

    public int getNthWordFromPos(int LLLL\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L, int \u0445LLL\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L) {
        GuiSearcher \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L;
        return \u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L.getNthWordFromPosWS(LLLL\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L, \u0445LLL\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L, true);
    }

    public int getNthWordFromPosWS(int \u0445LLLLLLL\u0445\u0445L\u0445\u0445L, int L\u0445LLLLLL\u0445\u0445L\u0445\u0445L, boolean \u0445\u0445LLLLLL\u0445\u0445L\u0445\u0445L) {
        int LL\u0445LLLLL\u0445\u0445L\u0445\u0445L = L\u0445LLLLLL\u0445\u0445L\u0445\u0445L;
        boolean \u0445L\u0445LLLLL\u0445\u0445L\u0445\u0445L = \u0445LLLLLLL\u0445\u0445L\u0445\u0445L < 0;
        int \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L = 0;
        int L\u0445\u0445LLLLL\u0445\u0445L\u0445\u0445L = Math.abs(\u0445LLLLLLL\u0445\u0445L\u0445\u0445L);
        if (\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L < L\u0445\u0445LLLLL\u0445\u0445L\u0445\u0445L) {
            GuiSearcher LLLLLLLL\u0445\u0445L\u0445\u0445L;
            if (!\u0445L\u0445LLLLL\u0445\u0445L\u0445\u0445L) {
                int L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L = LLLLLLLL\u0445\u0445L\u0445\u0445L.text.length();
                if ((LL\u0445LLLLL\u0445\u0445L\u0445\u0445L = LLLLLLLL\u0445\u0445L\u0445\u0445L.text.indexOf(32, LL\u0445LLLLL\u0445\u0445L\u0445\u0445L)) == -1) {
                    LL\u0445LLLLL\u0445\u0445L\u0445\u0445L = L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L;
                } else if (\u0445\u0445LLLLLL\u0445\u0445L\u0445\u0445L && LL\u0445LLLLL\u0445\u0445L\u0445\u0445L < L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L && LLLLLLLL\u0445\u0445L\u0445\u0445L.text.charAt(LL\u0445LLLLL\u0445\u0445L\u0445\u0445L) == ' ') {
                    ++LL\u0445LLLLL\u0445\u0445L\u0445\u0445L;
                    return 0;
                }
            } else {
                if (\u0445\u0445LLLLLL\u0445\u0445L\u0445\u0445L && LL\u0445LLLLL\u0445\u0445L\u0445\u0445L > 0 && LLLLLLLL\u0445\u0445L\u0445\u0445L.text.charAt(LL\u0445LLLLL\u0445\u0445L\u0445\u0445L - 1) == ' ') {
                    --LL\u0445LLLLL\u0445\u0445L\u0445\u0445L;
                    return 0;
                }
                if (LL\u0445LLLLL\u0445\u0445L\u0445\u0445L > 0 && LLLLLLLL\u0445\u0445L\u0445\u0445L.text.charAt(LL\u0445LLLLL\u0445\u0445L\u0445\u0445L - 1) != ' ') {
                    --LL\u0445LLLLL\u0445\u0445L\u0445\u0445L;
                    return 0;
                }
            }
            ++\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L;
            return 0;
        }
        return LL\u0445LLLLL\u0445\u0445L\u0445\u0445L;
    }

    public void moveCursorBy(int \u0445\u0445LL\u0445LLL\u0445\u0445L\u0445\u0445L) {
        GuiSearcher L\u0445LL\u0445LLL\u0445\u0445L\u0445\u0445L;
        L\u0445LL\u0445LLL\u0445\u0445L\u0445\u0445L.setCursorPosition(L\u0445LL\u0445LLL\u0445\u0445L\u0445\u0445L.selectionEnd + \u0445\u0445LL\u0445LLL\u0445\u0445L\u0445\u0445L);
    }

    public void setCursorPositionZero() {
        GuiSearcher \u0445\u0445\u0445L\u0445LLL\u0445\u0445L\u0445\u0445L;
        \u0445\u0445\u0445L\u0445LLL\u0445\u0445L\u0445\u0445L.setCursorPosition(0);
    }

    public void setCursorPositionEnd() {
        GuiSearcher L\u0445L\u0445\u0445LLL\u0445\u0445L\u0445\u0445L;
        L\u0445L\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setCursorPosition(L\u0445L\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.text.length());
    }

    public boolean textboxKeyTyped(char LLLLL\u0445LL\u0445\u0445L\u0445\u0445L, int \u0445LLLL\u0445LL\u0445\u0445L\u0445\u0445L) {
        GuiSearcher \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L;
        if (!\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.isFocused) {
            return false;
        }
        if (GuiScreen.isKeyComboCtrlA(\u0445LLLL\u0445LL\u0445\u0445L\u0445\u0445L)) {
            \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setCursorPositionEnd();
            \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setSelectionPos(0);
            return true;
        }
        if (GuiScreen.isKeyComboCtrlC(\u0445LLLL\u0445LL\u0445\u0445L\u0445\u0445L)) {
            GuiScreen.setClipboardString(\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.getSelectedText());
            return true;
        }
        if (GuiScreen.isKeyComboCtrlV(\u0445LLLL\u0445LL\u0445\u0445L\u0445\u0445L)) {
            if (\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.isEnabled) {
                \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.writeText(GuiScreen.getClipboardString());
            }
            return true;
        }
        if (GuiScreen.isKeyComboCtrlX(\u0445LLLL\u0445LL\u0445\u0445L\u0445\u0445L)) {
            GuiScreen.setClipboardString(\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.getSelectedText());
            if (\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.isEnabled) {
                \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.writeText("");
            }
            return true;
        }
        switch (\u0445LLLL\u0445LL\u0445\u0445L\u0445\u0445L) {
            case 14: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.isEnabled) {
                        \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.deleteWords(-1);
                    }
                } else if (\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.isEnabled) {
                    \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.deleteFromCursor(-1);
                }
                return true;
            }
            case 199: {
                if (GuiScreen.isShiftKeyDown()) {
                    \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setSelectionPos(0);
                } else {
                    \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setCursorPositionZero();
                }
                return true;
            }
            case 203: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setSelectionPos(\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.getNthWordFromPos(-1, \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.getSelectionEnd()));
                    } else {
                        \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setSelectionPos(\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.getSelectionEnd() - 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setCursorPosition(\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.getNthWordFromCursor(-1));
                } else {
                    \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.moveCursorBy(-1);
                }
                return true;
            }
            case 205: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setSelectionPos(\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.getNthWordFromPos(1, \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.getSelectionEnd()));
                    } else {
                        \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setSelectionPos(\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.getSelectionEnd() + 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setCursorPosition(\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.getNthWordFromCursor(1));
                } else {
                    \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.moveCursorBy(1);
                }
                return true;
            }
            case 207: {
                if (GuiScreen.isShiftKeyDown()) {
                    \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setSelectionPos(\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.text.length());
                } else {
                    \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.setCursorPositionEnd();
                }
                return true;
            }
            case 211: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.isEnabled) {
                        \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.deleteWords(1);
                    }
                } else if (\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.isEnabled) {
                    \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.deleteFromCursor(1);
                }
                return true;
            }
        }
        if (ChatAllowedCharacters.isAllowedCharacter((char)LLLLL\u0445LL\u0445\u0445L\u0445\u0445L)) {
            if (\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.isEnabled) {
                \u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L\u0445\u0445L.writeText(Character.toString(LLLLL\u0445LL\u0445\u0445L\u0445\u0445L));
            }
            return true;
        }
        return false;
    }

    public boolean mouseClicked(int \u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L, int LLLL\u0445\u0445LL\u0445\u0445L\u0445\u0445L, int \u0445LLL\u0445\u0445LL\u0445\u0445L\u0445\u0445L) {
        GuiSearcher L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L;
        boolean L\u0445LL\u0445\u0445LL\u0445\u0445L\u0445\u0445L;
        boolean bl2 = L\u0445LL\u0445\u0445LL\u0445\u0445L\u0445\u0445L = \u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L >= L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.xPosition && \u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L < L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.xPosition + L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.width && LLLL\u0445\u0445LL\u0445\u0445L\u0445\u0445L >= L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.yPosition && LLLL\u0445\u0445LL\u0445\u0445L\u0445\u0445L < L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.yPosition + L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.height;
        if (L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.canLoseFocus) {
            L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.setFocused(L\u0445LL\u0445\u0445LL\u0445\u0445L\u0445\u0445L);
        }
        if (L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.isFocused && L\u0445LL\u0445\u0445LL\u0445\u0445L\u0445\u0445L && \u0445LLL\u0445\u0445LL\u0445\u0445L\u0445\u0445L == 0) {
            int LL\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L = \u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L - L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.xPosition;
            if (L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.enableBackgroundDrawing) {
                LL\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L -= 4;
            }
            String \u0445L\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L = L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.fontRendererInstance.trimStringToWidth(L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.text.substring(L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.lineScrollOffset), L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.getWidth());
            L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.setCursorPosition(L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.fontRendererInstance.trimStringToWidth(\u0445L\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L, LL\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L).length() + L\u0445\u0445\u0445L\u0445LL\u0445\u0445L\u0445\u0445L.lineScrollOffset);
            return true;
        }
        return false;
    }

    public void drawTextBox() {
        GuiSearcher LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L;
        if (LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.getVisible()) {
            if (LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.getEnableBackgroundDrawing()) {
                RectHelper.drawSmoothRect((float)LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.xPosition - 0.5f, (float)LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.yPosition - 0.5f, (float)(LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.xPosition + LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.width) + 0.5f, (float)(LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.yPosition + LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.height) + 1.0f, PaletteHelper.astolfo(false, LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.width).getRGB());
                RectHelper.drawRect(LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.xPosition, LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.yPosition, LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.xPosition + LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.width, LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.yPosition + LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.height, new Color(23, 22, 22).getRGB());
            }
            int \u0445LL\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = -1;
            int L\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.cursorPosition - LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.lineScrollOffset;
            int \u0445\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.selectionEnd - LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.lineScrollOffset;
            String LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.fontRendererInstance.trimStringToWidth(LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.text.substring(LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.lineScrollOffset), LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.getWidth());
            boolean \u0445L\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = L\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L >= 0 && L\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L <= LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L.length();
            boolean L\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.isFocused && LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.cursorCounter / 6 % 2 == 0 && \u0445L\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L;
            int \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.enableBackgroundDrawing ? LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.xPosition + 4 : LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.xPosition;
            int LLLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.enableBackgroundDrawing ? LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.yPosition + (LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.height - 8) / 2 : LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.yPosition;
            int \u0445LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L = \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L;
            if (\u0445\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L > LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L.length()) {
                \u0445\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L.length();
            }
            if (!LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L.isEmpty()) {
                String \u0445\u0445\u0445LLL\u0445L\u0445\u0445L\u0445\u0445L;
                String string = \u0445\u0445\u0445LLL\u0445L\u0445\u0445L\u0445\u0445L = \u0445L\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L ? LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L.substring(0, L\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L) : LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L;
                if (Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.warpSpoof.getBoolValue() && \u0445\u0445\u0445LLL\u0445L\u0445\u0445L\u0445\u0445L.startsWith("/warp")) {
                    \u0445\u0445\u0445LLL\u0445L\u0445\u0445L\u0445\u0445L = "/warp ";
                }
                if (Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.loginSpoof.getBoolValue() && \u0445\u0445\u0445LLL\u0445L\u0445\u0445L\u0445\u0445L.startsWith("/l")) {
                    \u0445\u0445\u0445LLL\u0445L\u0445\u0445L\u0445\u0445L = "/l ";
                }
                \u0445LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.fontRendererInstance.drawStringWithShadow(\u0445\u0445\u0445LLL\u0445L\u0445\u0445L\u0445\u0445L, \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L, LLLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L, \u0445LL\u0445LL\u0445L\u0445\u0445L\u0445\u0445L);
            }
            boolean L\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.cursorPosition < LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.text.length() || LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.text.length() >= LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.getMaxStringLength();
            int \u0445\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L = \u0445LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L;
            if (!\u0445L\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L) {
                \u0445\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L = L\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L > 0 ? \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L + LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.width : \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L;
            } else if (L\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L) {
                \u0445\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L = \u0445LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L - 1;
                --\u0445LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L;
            }
            if (!LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L.isEmpty() && \u0445L\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L && L\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L < LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L.length()) {
                \u0445LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L = LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.fontRendererInstance.drawStringWithShadow(LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L.substring(L\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L), \u0445LLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L, LLLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L, \u0445LL\u0445LL\u0445L\u0445\u0445L\u0445\u0445L);
            }
            if (L\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L) {
                if (L\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L) {
                    Gui.drawRect(\u0445\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L, LLLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L - 1, \u0445\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L + 1, LLLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L + 1 + LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.fontRendererInstance.FONT_HEIGHT, -3092272);
                } else {
                    LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.fontRendererInstance.drawStringWithShadow("_", \u0445\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L, LLLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L, \u0445LL\u0445LL\u0445L\u0445\u0445L\u0445\u0445L);
                }
            }
            if (\u0445\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L != L\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L) {
                int LLL\u0445LL\u0445L\u0445\u0445L\u0445\u0445L = \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L + LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.fontRendererInstance.getStringWidth(LL\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L.substring(0, \u0445\u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L));
                LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.drawCursorVertical(\u0445\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L, LLLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L - 1, LLL\u0445LL\u0445L\u0445\u0445L\u0445\u0445L - 1, LLLL\u0445L\u0445L\u0445\u0445L\u0445\u0445L + 1 + LL\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.fontRendererInstance.FONT_HEIGHT);
            }
        }
    }

    private void drawCursorVertical(int LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, int \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, int L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, int \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L) {
        GuiSearcher \u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L;
        if (LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L < L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L) {
            int \u0445LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L = LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L;
            LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L = L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L;
            L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L = \u0445LL\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L;
        }
        if (\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L < \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L) {
            int L\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L = \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L;
            \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L = \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L;
            \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L = L\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L;
        }
        if (L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L > \u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L.xPosition + \u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L.width) {
            L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L = \u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L.xPosition + \u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L.width;
        }
        if (LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L > \u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L.xPosition + \u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L.width) {
            LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L = \u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L.xPosition + \u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L.width;
        }
        Tessellator LLLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L = Tessellator.getInstance();
        BufferBuilder \u0445LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L = LLLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.getBuffer();
        GlStateManager.color(0.0f, 0.0f, 255.0f, 255.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.enableColorLogic();
        GlStateManager.colorLogicOp(GlStateManager.LogicOp.OR_REVERSE);
        \u0445LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.begin(7, DefaultVertexFormats.POSITION);
        \u0445LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.pos(LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, 0.0).endVertex();
        \u0445LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.pos(L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, 0.0).endVertex();
        \u0445LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.pos(L\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, 0.0).endVertex();
        \u0445LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.pos(LL\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, \u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445L, 0.0).endVertex();
        LLLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.draw();
        GlStateManager.disableColorLogic();
        GlStateManager.enableTexture2D();
    }

    public int getMaxStringLength() {
        GuiSearcher L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L;
        return L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.maxStringLength;
    }

    public void setMaxStringLength(int \u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L) {
        GuiSearcher L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L;
        L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.maxStringLength = \u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L;
        if (L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.text.length() > \u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L) {
            L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.text = L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L.text.substring(0, \u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L);
        }
    }

    public int getCursorPosition() {
        GuiSearcher \u0445\u0445LLLLL\u0445\u0445\u0445L\u0445\u0445L;
        return \u0445\u0445LLLLL\u0445\u0445\u0445L\u0445\u0445L.cursorPosition;
    }

    public void setCursorPosition(int \u0445LL\u0445LLL\u0445\u0445\u0445L\u0445\u0445L) {
        GuiSearcher LLL\u0445LLL\u0445\u0445\u0445L\u0445\u0445L;
        LLL\u0445LLL\u0445\u0445\u0445L\u0445\u0445L.cursorPosition = \u0445LL\u0445LLL\u0445\u0445\u0445L\u0445\u0445L;
        int L\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445L = LLL\u0445LLL\u0445\u0445\u0445L\u0445\u0445L.text.length();
        LLL\u0445LLL\u0445\u0445\u0445L\u0445\u0445L.cursorPosition = MathHelper.clamp(LLL\u0445LLL\u0445\u0445\u0445L\u0445\u0445L.cursorPosition, 0, L\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445L);
        LLL\u0445LLL\u0445\u0445\u0445L\u0445\u0445L.setSelectionPos(LLL\u0445LLL\u0445\u0445\u0445L\u0445\u0445L.cursorPosition);
    }

    public boolean getEnableBackgroundDrawing() {
        GuiSearcher \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445L;
        return \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445L.enableBackgroundDrawing;
    }

    public void setEnableBackgroundDrawing(boolean LL\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445L) {
        \u0445\u0445LL\u0445LL\u0445\u0445\u0445L\u0445\u0445L.enableBackgroundDrawing = LL\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445L;
    }

    public void setTextColor(int L\u0445L\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L) {
        \u0445LL\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L.enabledColor = L\u0445L\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L;
    }

    public void setDisabledTextColour(int LLLLL\u0445L\u0445\u0445\u0445L\u0445\u0445L) {
        \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L.disabledColor = LLLLL\u0445L\u0445\u0445\u0445L\u0445\u0445L;
    }

    public boolean isFocused() {
        GuiSearcher LL\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L;
        return LL\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.isFocused;
    }

    public void setFocused(boolean \u0445LL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L) {
        GuiSearcher LLL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L;
        if (\u0445LL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L && !LLL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L.isFocused) {
            LLL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L.cursorCounter = 0;
        }
        LLL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L.isFocused = \u0445LL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L;
        if (Minecraft.getInstance().currentScreen != null) {
            Minecraft.getInstance().currentScreen.func_193975_a(\u0445LL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L);
        }
    }

    public void setEnabled(boolean \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L) {
        L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L.isEnabled = \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L;
    }

    public int getSelectionEnd() {
        GuiSearcher \u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L;
        return \u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L.selectionEnd;
    }

    public int getWidth() {
        GuiSearcher L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L;
        return L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L.getEnableBackgroundDrawing() ? L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L.width - 8 : L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L.width;
    }

    public void setSelectionPos(int L\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L) {
        GuiSearcher \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L;
        int \u0445\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L = \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.text.length();
        if (L\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L > \u0445\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L) {
            L\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L = \u0445\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L;
        }
        if (L\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L < 0) {
            L\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L = 0;
        }
        \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.selectionEnd = L\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L;
        if (\u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.fontRendererInstance != null) {
            if (\u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset > \u0445\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L) {
                \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset = \u0445\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L;
            }
            int L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L = \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.getWidth();
            String \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L = \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.fontRendererInstance.trimStringToWidth(\u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.text.substring(\u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset), L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L);
            int LLLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L = \u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L.length() + \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset;
            if (L\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L == \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset) {
                \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset -= \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.fontRendererInstance.trimStringToWidth(\u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.text, L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445L, true).length();
            }
            if (L\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L > LLLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L) {
                \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset += L\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L - LLLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L;
            } else if (L\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L <= \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset) {
                \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset -= \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset - L\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L;
            }
            \u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset = MathHelper.clamp(\u0445LLLLL\u0445\u0445\u0445\u0445L\u0445\u0445L.lineScrollOffset, 0, \u0445\u0445LLLL\u0445\u0445\u0445\u0445L\u0445\u0445L);
        }
    }

    public void setCanLoseFocus(boolean \u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L) {
        LL\u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L.canLoseFocus = \u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445L;
    }

    public boolean getVisible() {
        GuiSearcher \u0445LLL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L;
        return \u0445LLL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.visible;
    }

    public void setVisible(boolean L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L) {
        \u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.visible = L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L;
    }
}

