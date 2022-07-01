/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.altmanager;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.ui.button.GuiAltButton;
import org.Destroy.client.ui.components.altmanager.PasswordField;
import org.Destroy.client.ui.components.altmanager.alt.Alt;
import org.Destroy.client.ui.components.altmanager.alt.AltLoginThread;
import org.lwjgl.input.Keyboard;

public final class GuiAltLogin
extends GuiScreen {
    private final GuiScreen previousScreen;
    private PasswordField password;
    private AltLoginThread thread;
    private GuiTextField username;

    public GuiAltLogin(GuiScreen \u0445L\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL) {
        GuiAltLogin LL\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL;
        LL\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.previousScreen = \u0445L\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL;
    }

    @Override
    protected void actionPerformed(GuiButton LLL\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL) {
        try {
            switch (LLL\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.id) {
                case 0: {
                    GuiAltLogin \u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL;
                    \u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.thread = new AltLoginThread(new Alt(\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.username.getText(), \u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.password.getText()));
                    \u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.thread.start();
                    break;
                }
                case 1: {
                    GuiAltLogin \u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL;
                    \u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.mc.displayGuiScreen(\u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.previousScreen);
                    break;
                }
                case 2: {
                    GuiAltLogin \u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL;
                    String \u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                    if (!\u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.contains(":")) break;
                    String[] LL\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL = \u0445L\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.split(":");
                    \u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.username.setText(LL\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL[0]);
                    \u0445\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL.password.setText(LL\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL[1]);
                }
            }
        }
        catch (Throwable L\u0445\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445LLL) {
            throw new RuntimeException();
        }
    }

    @Override
    public void drawScreen(int L\u0445LLLLL\u0445L\u0445\u0445\u0445LLL, int \u0445\u0445LLLLL\u0445L\u0445\u0445\u0445LLL, float LL\u0445LLLL\u0445L\u0445\u0445\u0445LLL) {
        GuiAltLogin \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL;
        RectHelper.drawBorderedRect(0.0f, 0.0f, \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.width, \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.height, 0.5f, new Color(22, 22, 22, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
        RenderHelper.drawImage(new ResourceLocation("neverhook/skeet.png"), 1.0f, 1.0f, 958.0f, 1.0f, Color.white);
        \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.username.drawTextBox();
        \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.password.drawTextBox();
        \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.mc.circleregular.drawStringWithShadow("Alt Login", (float)\u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.width / 2.0f, 20.0, -1);
        \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.mc.circleregular.drawStringWithShadow(\u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.thread == null ? (Object)((Object)TextFormatting.GRAY) + "Alts..." : \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.thread.getStatus(), (float)\u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.width / 2.0f, 29.0, -1);
        if (\u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.username.getText().isEmpty() && !\u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.username.isFocused()) {
            \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.mc.circleregular.drawStringWithShadow("Username / E-Mail", \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.width / 2 - 96, 66.0, -7829368);
        }
        if (\u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.password.getText().isEmpty() && !\u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.password.isFocused()) {
            \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.mc.circleregular.drawStringWithShadow("Password", \u0445LLLLLL\u0445L\u0445\u0445\u0445LLL.width / 2 - 96, 106.0, -7829368);
        }
        super.drawScreen(L\u0445LLLLL\u0445L\u0445\u0445\u0445LLL, \u0445\u0445LLLLL\u0445L\u0445\u0445\u0445LLL, LL\u0445LLLL\u0445L\u0445\u0445\u0445LLL);
    }

    @Override
    public void initGui() {
        GuiAltLogin LLLLLL\u0445LLLLL\u0445LL;
        int \u0445LLLLL\u0445LLLLL\u0445LL = LLLLLL\u0445LLLLL\u0445LL.height / 4 + 24;
        LLLLLL\u0445LLLLL\u0445LL.buttonList.add(new GuiAltButton(0, LLLLLL\u0445LLLLL\u0445LL.width / 2 - 100, \u0445LLLLL\u0445LLLLL\u0445LL + 72 + 12, "Login"));
        LLLLLL\u0445LLLLL\u0445LL.buttonList.add(new GuiAltButton(1, LLLLLL\u0445LLLLL\u0445LL.width / 2 - 100, \u0445LLLLL\u0445LLLLL\u0445LL + 72 + 12 + 24, "Back"));
        LLLLLL\u0445LLLLL\u0445LL.buttonList.add(new GuiAltButton(2, LLLLLL\u0445LLLLL\u0445LL.width / 2 - 100, \u0445LLLLL\u0445LLLLL\u0445LL + 72 + 12 - 24, "Import User:Pass"));
        LLLLLL\u0445LLLLL\u0445LL.username = new GuiTextField(\u0445LLLLL\u0445LLLLL\u0445LL, LLLLLL\u0445LLLLL\u0445LL.mc.fontRendererObj, LLLLLL\u0445LLLLL\u0445LL.width / 2 - 100, 60, 200, 20);
        LLLLLL\u0445LLLLL\u0445LL.password = new PasswordField(LLLLLL\u0445LLLLL\u0445LL.mc.fontRendererObj, LLLLLL\u0445LLLLL\u0445LL.width / 2 - 100, 100, 200, 20);
        LLLLLL\u0445LLLLL\u0445LL.username.setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    protected void keyTyped(char L\u0445L\u0445LL\u0445LLLLL\u0445LL, int \u0445\u0445L\u0445LL\u0445LLLLL\u0445LL) {
        GuiAltLogin \u0445LL\u0445LL\u0445LLLLL\u0445LL;
        try {
            super.keyTyped(L\u0445L\u0445LL\u0445LLLLL\u0445LL, \u0445\u0445L\u0445LL\u0445LLLLL\u0445LL);
        }
        catch (IOException LLL\u0445LL\u0445LLLLL\u0445LL) {
            LLL\u0445LL\u0445LLLLL\u0445LL.printStackTrace();
        }
        if (L\u0445L\u0445LL\u0445LLLLL\u0445LL == '\t') {
            if (!\u0445LL\u0445LL\u0445LLLLL\u0445LL.username.isFocused() && !\u0445LL\u0445LL\u0445LLLLL\u0445LL.password.isFocused()) {
                \u0445LL\u0445LL\u0445LLLLL\u0445LL.username.setFocused(true);
            } else {
                \u0445LL\u0445LL\u0445LLLLL\u0445LL.username.setFocused(\u0445LL\u0445LL\u0445LLLLL\u0445LL.password.isFocused());
                \u0445LL\u0445LL\u0445LLLLL\u0445LL.password.setFocused(!\u0445LL\u0445LL\u0445LLLLL\u0445LL.username.isFocused());
            }
        }
        if (L\u0445L\u0445LL\u0445LLLLL\u0445LL == '\r') {
            \u0445LL\u0445LL\u0445LLLLL\u0445LL.actionPerformed((GuiButton)\u0445LL\u0445LL\u0445LLLLL\u0445LL.buttonList.get(0));
        }
        \u0445LL\u0445LL\u0445LLLLL\u0445LL.username.textboxKeyTyped(L\u0445L\u0445LL\u0445LLLLL\u0445LL, \u0445\u0445L\u0445LL\u0445LLLLL\u0445LL);
        \u0445LL\u0445LL\u0445LLLLL\u0445LL.password.textboxKeyTyped(L\u0445L\u0445LL\u0445LLLLL\u0445LL, \u0445\u0445L\u0445LL\u0445LLLLL\u0445LL);
    }

    @Override
    protected void mouseClicked(int \u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445LL, int LLL\u0445\u0445L\u0445LLLLL\u0445LL, int \u0445LL\u0445\u0445L\u0445LLLLL\u0445LL) {
        GuiAltLogin L\u0445\u0445L\u0445L\u0445LLLLL\u0445LL;
        try {
            super.mouseClicked(\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445LL, LLL\u0445\u0445L\u0445LLLLL\u0445LL, \u0445LL\u0445\u0445L\u0445LLLLL\u0445LL);
        }
        catch (IOException \u0445L\u0445L\u0445L\u0445LLLLL\u0445LL) {
            \u0445L\u0445L\u0445L\u0445LLLLL\u0445LL.printStackTrace();
        }
        L\u0445\u0445L\u0445L\u0445LLLLL\u0445LL.username.mouseClicked(\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445LL, LLL\u0445\u0445L\u0445LLLLL\u0445LL, \u0445LL\u0445\u0445L\u0445LLLLL\u0445LL);
        L\u0445\u0445L\u0445L\u0445LLLLL\u0445LL.password.mouseClicked(\u0445\u0445\u0445L\u0445L\u0445LLLLL\u0445LL, LLL\u0445\u0445L\u0445LLLLL\u0445LL, \u0445LL\u0445\u0445L\u0445LLLLL\u0445LL);
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void updateScreen() {
        GuiAltLogin \u0445LLLL\u0445\u0445LLLLL\u0445LL;
        \u0445LLLL\u0445\u0445LLLLL\u0445LL.username.updateCursorCounter();
        \u0445LLLL\u0445\u0445LLLLL\u0445LL.password.updateCursorCounter();
    }
}

