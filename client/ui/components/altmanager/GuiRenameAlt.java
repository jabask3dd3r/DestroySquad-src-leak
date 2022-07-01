/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.altmanager;

import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.ui.button.GuiAltButton;
import org.Destroy.client.ui.components.altmanager.GuiAltManager;
import org.Destroy.client.ui.components.altmanager.PasswordField;

public class GuiRenameAlt
extends GuiScreen {
    private final GuiAltManager manager;
    private GuiTextField nameField;
    private PasswordField pwField;
    private String status = (Object)((Object)TextFormatting.GRAY) + "Waiting...";

    public GuiRenameAlt(GuiAltManager \u0445LL\u0445L\u0445\u0445\u0445LLLL) {
        GuiRenameAlt LLL\u0445L\u0445\u0445\u0445LLLL;
        LLL\u0445L\u0445\u0445\u0445LLLL.manager = \u0445LL\u0445L\u0445\u0445\u0445LLLL;
    }

    @Override
    public void actionPerformed(GuiButton \u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL) {
        switch (\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.id) {
            case 0: {
                GuiRenameAlt L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL;
                L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.manager.selectedAlt.setMask(L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.nameField.getText());
                L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.manager.selectedAlt.setPassword(L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.pwField.getText());
                L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.status = "Edited!";
                break;
            }
            case 1: {
                GuiRenameAlt L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL;
                L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.mc.displayGuiScreen(L\u0445\u0445\u0445L\u0445\u0445\u0445LLLL.manager);
            }
        }
    }

    @Override
    public void drawScreen(int LLL\u0445\u0445\u0445\u0445\u0445LLLL, int \u0445LL\u0445\u0445\u0445\u0445\u0445LLLL, float L\u0445L\u0445\u0445\u0445\u0445\u0445LLLL) {
        GuiRenameAlt \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL;
        ScaledResolution \u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLL = new ScaledResolution(\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.mc);
        RectHelper.drawBorderedRect(0.0f, 0.0f, \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.width, \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.height, 0.5f, new Color(17, 17, 17, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
        RenderHelper.drawImage(new ResourceLocation("neverhook/skeet.png"), 1.0f, 1.0f, \u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLL.getScaledWidth(), 1.0f, Color.white);
        \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.mc.fontRendererObj.drawStringWithShadow("Edit Alt", (float)\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.width / 2.0f, 10.0f, -1);
        \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.mc.fontRendererObj.drawStringWithShadow(\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.status, (float)\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.width / 2.0f, 20.0f, -1);
        \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.nameField.drawTextBox();
        \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.pwField.drawTextBox();
        if (\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.nameField.getText().isEmpty() && !\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.nameField.isFocused()) {
            \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.drawString(\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.mc.fontRendererObj, "Name", \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.width / 2 - 96, 66, -7829368);
        }
        if (\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.pwField.getText().isEmpty() && !\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.pwField.isFocused()) {
            \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.drawString(\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.mc.fontRendererObj, "Password", \u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLLL.width / 2 - 96, 106, -7829368);
        }
        super.drawScreen(LLL\u0445\u0445\u0445\u0445\u0445LLLL, \u0445LL\u0445\u0445\u0445\u0445\u0445LLLL, L\u0445L\u0445\u0445\u0445\u0445\u0445LLLL);
    }

    @Override
    public void initGui() {
        GuiRenameAlt L\u0445LLLLLL\u0445LLL;
        L\u0445LLLLLL\u0445LLL.buttonList.add(new GuiAltButton(0, L\u0445LLLLLL\u0445LLL.width / 2 - 100, L\u0445LLLLLL\u0445LLL.height / 4 + 92 + 12, "Edit"));
        L\u0445LLLLLL\u0445LLL.buttonList.add(new GuiAltButton(1, L\u0445LLLLLL\u0445LLL.width / 2 - 100, L\u0445LLLLLL\u0445LLL.height / 4 + 116 + 12, "Cancel"));
        L\u0445LLLLLL\u0445LLL.nameField = new GuiTextField(L\u0445LLLLLL\u0445LLL.eventButton, L\u0445LLLLLL\u0445LLL.mc.fontRendererObj, L\u0445LLLLLL\u0445LLL.width / 2 - 100, 60, 200, 20);
        L\u0445LLLLLL\u0445LLL.pwField = new PasswordField(L\u0445LLLLLL\u0445LLL.mc.fontRendererObj, L\u0445LLLLLL\u0445LLL.width / 2 - 100, 100, 200, 20);
    }

    @Override
    protected void keyTyped(char LLL\u0445LLLL\u0445LLL, int \u0445LL\u0445LLLL\u0445LLL) {
        GuiRenameAlt \u0445\u0445\u0445LLLLL\u0445LLL;
        \u0445\u0445\u0445LLLLL\u0445LLL.nameField.textboxKeyTyped(LLL\u0445LLLL\u0445LLL, \u0445LL\u0445LLLL\u0445LLL);
        \u0445\u0445\u0445LLLLL\u0445LLL.pwField.textboxKeyTyped(LLL\u0445LLLL\u0445LLL, \u0445LL\u0445LLLL\u0445LLL);
        if (LLL\u0445LLLL\u0445LLL == '\t' && (\u0445\u0445\u0445LLLLL\u0445LLL.nameField.isFocused() || \u0445\u0445\u0445LLLLL\u0445LLL.pwField.isFocused())) {
            \u0445\u0445\u0445LLLLL\u0445LLL.nameField.setFocused(!\u0445\u0445\u0445LLLLL\u0445LLL.nameField.isFocused());
            \u0445\u0445\u0445LLLLL\u0445LLL.pwField.setFocused(!\u0445\u0445\u0445LLLLL\u0445LLL.pwField.isFocused());
        }
        if (LLL\u0445LLLL\u0445LLL == '\r') {
            \u0445\u0445\u0445LLLLL\u0445LLL.actionPerformed((GuiButton)\u0445\u0445\u0445LLLLL\u0445LLL.buttonList.get(0));
        }
    }

    @Override
    protected void mouseClicked(int LL\u0445L\u0445LLL\u0445LLL, int \u0445L\u0445L\u0445LLL\u0445LLL, int L\u0445\u0445L\u0445LLL\u0445LLL) {
        GuiRenameAlt \u0445\u0445LL\u0445LLL\u0445LLL;
        try {
            super.mouseClicked(LL\u0445L\u0445LLL\u0445LLL, \u0445L\u0445L\u0445LLL\u0445LLL, L\u0445\u0445L\u0445LLL\u0445LLL);
        }
        catch (IOException L\u0445LL\u0445LLL\u0445LLL) {
            L\u0445LL\u0445LLL\u0445LLL.printStackTrace();
        }
        \u0445\u0445LL\u0445LLL\u0445LLL.nameField.mouseClicked(LL\u0445L\u0445LLL\u0445LLL, \u0445L\u0445L\u0445LLL\u0445LLL, L\u0445\u0445L\u0445LLL\u0445LLL);
        \u0445\u0445LL\u0445LLL\u0445LLL.pwField.mouseClicked(LL\u0445L\u0445LLL\u0445LLL, \u0445L\u0445L\u0445LLL\u0445LLL, L\u0445\u0445L\u0445LLL\u0445LLL);
    }
}

