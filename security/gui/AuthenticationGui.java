/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.security.gui;

import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.ui.button.GuiAltButton;
import org.Destroy.security.gui.GuiSearcher;

public class AuthenticationGui
extends GuiScreen {
    public static GuiSearcher uid;

    public AuthenticationGui() {
        AuthenticationGui \u0445\u0445L\u0445\u0445\u0445LLLL\u0445LLL;
    }

    @Override
    public void initGui() {
        AuthenticationGui \u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL;
        ScaledResolution LLLLLL\u0445LLL\u0445LLL = new ScaledResolution(\u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL.mc);
        \u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL.buttonList.clear();
        uid = new GuiSearcher(2, \u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL.mc.fontRendererObj, \u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL.width / 2 - 100, \u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL.height / 2 - 60, 200, 20);
        uid.setMaxStringLength(20);
        \u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL.buttonList.add(new GuiAltButton(1, \u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL.width / 2 - 100, \u0445\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL.height / 2 - 20, "Login"));
        super.initGui();
    }

    @Override
    public void drawScreen(int \u0445LL\u0445LL\u0445LLL\u0445LLL, int L\u0445L\u0445LL\u0445LLL\u0445LLL, float \u0445\u0445L\u0445LL\u0445LLL\u0445LLL) {
        AuthenticationGui LLL\u0445LL\u0445LLL\u0445LLL;
        ScaledResolution LL\u0445\u0445LL\u0445LLL\u0445LLL = new ScaledResolution(LLL\u0445LL\u0445LLL\u0445LLL.mc);
        RectHelper.drawRect(1.0, 1.4f, LL\u0445\u0445LL\u0445LLL\u0445LLL.getScaledWidth() - 1, (float)LL\u0445\u0445LL\u0445LLL\u0445LLL.getScaledHeight() - 1.7f, new Color(12, 12, 12).getRGB());
        RectHelper.drawRect((float)LL\u0445\u0445LL\u0445LLL\u0445LLL.getScaledWidth() / 2.0f - 120.0f, (float)LL\u0445\u0445LL\u0445LLL\u0445LLL.getScaledHeight() / 2.0f - 90.0f, LL\u0445\u0445LL\u0445LLL\u0445LLL.getScaledWidth() - 220, LL\u0445\u0445LL\u0445LLL\u0445LLL.getScaledHeight() - 150, new Color(16, 15, 15).getRGB());
        uid.drawTextBox();
        if (!AuthenticationGui.uid.isFocused) {
            LLL\u0445LL\u0445LLL\u0445LLL.mc.robotoRegularFontRender.drawStringWithShadow("Your key...", (float)LLL\u0445LL\u0445LLL\u0445LLL.width / 2.0f - 96.0f, (float)LLL\u0445LL\u0445LLL\u0445LLL.height / 2.0f - 53.0f, Color.GRAY.getRGB());
        }
        super.drawScreen(\u0445LL\u0445LL\u0445LLL\u0445LLL, L\u0445L\u0445LL\u0445LLL\u0445LLL, \u0445\u0445L\u0445LL\u0445LLL\u0445LLL);
    }

    @Override
    protected void keyTyped(char L\u0445\u0445L\u0445L\u0445LLL\u0445LLL, int \u0445\u0445\u0445L\u0445L\u0445LLL\u0445LLL) throws IOException {
        try {
            uid.textboxKeyTyped(L\u0445\u0445L\u0445L\u0445LLL\u0445LLL, \u0445\u0445\u0445L\u0445L\u0445LLL\u0445LLL);
        }
        catch (Exception L\u0445L\u0445\u0445L\u0445LLL\u0445LLL) {
            // empty catch block
        }
    }

    @Override
    protected void mouseClicked(int LLLLL\u0445\u0445LLL\u0445LLL, int \u0445LLLL\u0445\u0445LLL\u0445LLL, int L\u0445LLL\u0445\u0445LLL\u0445LLL) throws IOException {
        AuthenticationGui \u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LLL;
        uid.mouseClicked(LLLLL\u0445\u0445LLL\u0445LLL, \u0445LLLL\u0445\u0445LLL\u0445LLL, L\u0445LLL\u0445\u0445LLL\u0445LLL);
        super.mouseClicked(LLLLL\u0445\u0445LLL\u0445LLL, \u0445LLLL\u0445\u0445LLL\u0445LLL, L\u0445LLL\u0445\u0445LLL\u0445LLL);
    }

    @Override
    protected void actionPerformed(GuiButton L\u0445L\u0445L\u0445\u0445LLL\u0445LLL) throws IOException {
        AuthenticationGui \u0445LL\u0445L\u0445\u0445LLL\u0445LLL;
        if (L\u0445L\u0445L\u0445\u0445LLL\u0445LLL.id == 1) {
            \u0445LL\u0445L\u0445\u0445LLL\u0445LLL.mc.displayGuiScreen(new GuiMainMenu());
        }
        super.actionPerformed(L\u0445L\u0445L\u0445\u0445LLL\u0445LLL);
    }
}

