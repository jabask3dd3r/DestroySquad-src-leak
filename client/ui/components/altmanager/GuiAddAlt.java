/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.altmanager;

import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.net.Proxy;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.impl.misc.NameProtected;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.ui.button.GuiAltButton;
import org.Destroy.client.ui.components.altmanager.GuiAltManager;
import org.Destroy.client.ui.components.altmanager.PasswordField;
import org.Destroy.client.ui.components.altmanager.alt.Alt;
import org.Destroy.client.ui.components.altmanager.alt.AltManager;
import org.lwjgl.input.Keyboard;

public class GuiAddAlt
extends GuiScreen {
    private final GuiAltManager manager;
    private PasswordField password;
    private String status = (Object)((Object)TextFormatting.GRAY) + "Idle...";
    private GuiTextField username;

    GuiAddAlt(GuiAltManager \u0445\u0445L\u0445\u0445\u0445LLLLLL\u0445\u0445L) {
        GuiAddAlt L\u0445L\u0445\u0445\u0445LLLLLL\u0445\u0445L;
        L\u0445L\u0445\u0445\u0445LLLLLL\u0445\u0445L.manager = \u0445\u0445L\u0445\u0445\u0445LLLLLL\u0445\u0445L;
    }

    private static void setStatus(GuiAddAlt LLLLLL\u0445LLLLL\u0445\u0445L, String \u0445LLLLL\u0445LLLLL\u0445\u0445L) {
        LLLLLL\u0445LLLLL\u0445\u0445L.status = \u0445LLLLL\u0445LLLLL\u0445\u0445L;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void actionPerformed(GuiButton \u0445\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L) {
        switch (\u0445\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L.id) {
            case 0: {
                GuiAddAlt L\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L;
                AddAltThread \u0445LL\u0445LL\u0445LLLLL\u0445\u0445L = L\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L.new AddAltThread(L\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L.username.getText(), L\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L.password.getText());
                \u0445LL\u0445LL\u0445LLLLL\u0445\u0445L.start();
                break;
            }
            case 1: {
                GuiAddAlt L\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L;
                L\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L.mc.displayGuiScreen(L\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L.manager);
                break;
            }
            case 2: {
                void \u0445L\u0445\u0445LL\u0445LLLLL\u0445\u0445L;
                GuiAddAlt L\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L;
                try {
                    String L\u0445L\u0445LL\u0445LLLLL\u0445\u0445L = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                }
                catch (Exception \u0445\u0445L\u0445LL\u0445LLLLL\u0445\u0445L) {
                    return;
                }
                if (!\u0445L\u0445\u0445LL\u0445LLLLL\u0445\u0445L.contains(":")) break;
                String[] LL\u0445\u0445LL\u0445LLLLL\u0445\u0445L = \u0445L\u0445\u0445LL\u0445LLLLL\u0445\u0445L.split(":");
                L\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L.username.setText(LL\u0445\u0445LL\u0445LLLLL\u0445\u0445L[0]);
                L\u0445\u0445\u0445LL\u0445LLLLL\u0445\u0445L.password.setText(LL\u0445\u0445LL\u0445LLLLL\u0445\u0445L[1]);
            }
        }
    }

    @Override
    public void drawScreen(int L\u0445L\u0445\u0445L\u0445LLLLL\u0445\u0445L, int \u0445\u0445L\u0445\u0445L\u0445LLLLL\u0445\u0445L, float LL\u0445\u0445\u0445L\u0445LLLLL\u0445\u0445L) {
        GuiAddAlt \u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L;
        RectHelper.drawBorderedRect(0.0f, 0.0f, \u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.width, \u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.height, 0.5f, new Color(22, 22, 22, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
        RenderHelper.drawImage(new ResourceLocation("neverhook/skeet.png"), 1.0f, 1.0f, 958.0f, 1.0f, Color.white);
        \u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.username.drawTextBox();
        \u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.password.drawTextBox();
        \u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.mc.circleregular.drawCenteredString("Add Account", (float)\u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.width / 2.0f, 15.0f, -1);
        if (\u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.username.getText().isEmpty() && !\u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.username.isFocused()) {
            \u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.mc.circleregular.drawStringWithShadow("Username / E-Mail", \u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.width / 2 - 96, 66.0, -7829368);
        }
        if (\u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.password.getText().isEmpty() && !\u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.password.isFocused()) {
            \u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.mc.circleregular.drawStringWithShadow("Password", \u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.width / 2 - 96, 106.0, -7829368);
        }
        \u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.mc.circleregular.drawCenteredString(\u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.status, (float)\u0445LL\u0445\u0445L\u0445LLLLL\u0445\u0445L.width / 2.0f, 30.0f, -1);
        super.drawScreen(L\u0445L\u0445\u0445L\u0445LLLLL\u0445\u0445L, \u0445\u0445L\u0445\u0445L\u0445LLLLL\u0445\u0445L, LL\u0445\u0445\u0445L\u0445LLLLL\u0445\u0445L);
    }

    @Override
    public void initGui() {
        GuiAddAlt \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L;
        Keyboard.enableRepeatEvents(true);
        \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.buttonList.clear();
        \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.buttonList.add(new GuiAltButton(0, \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.width / 2 - 100, \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.height / 4 + 92 + 12, "Login"));
        \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.buttonList.add(new GuiAltButton(1, \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.width / 2 - 100, \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.height / 4 + 116 + 12, "Back"));
        \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.buttonList.add(new GuiAltButton(2, \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.width / 2 - 100, \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.height / 4 + 92 - 12, "Import User:Pass"));
        \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.username = new GuiTextField(\u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.eventButton, \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.mc.fontRendererObj, \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.width / 2 - 100, 60, 200, 20);
        \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.password = new PasswordField(\u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.mc.fontRendererObj, \u0445\u0445\u0445LL\u0445\u0445LLLLL\u0445\u0445L.width / 2 - 100, 100, 200, 20);
    }

    @Override
    protected void keyTyped(char \u0445\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L, int LLL\u0445\u0445\u0445\u0445LLLLL\u0445\u0445L) {
        GuiAddAlt L\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L;
        L\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L.username.textboxKeyTyped(\u0445\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L, LLL\u0445\u0445\u0445\u0445LLLLL\u0445\u0445L);
        L\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L.password.textboxKeyTyped(\u0445\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L, LLL\u0445\u0445\u0445\u0445LLLLL\u0445\u0445L);
        if (\u0445\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L == '\t' && (L\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L.username.isFocused() || L\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L.password.isFocused())) {
            L\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L.username.setFocused(!L\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L.username.isFocused());
            L\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L.password.setFocused(!L\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L.password.isFocused());
        }
        if (\u0445\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L == '\r') {
            L\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L.actionPerformed((GuiButton)L\u0445\u0445L\u0445\u0445\u0445LLLLL\u0445\u0445L.buttonList.get(0));
        }
    }

    @Override
    protected void mouseClicked(int \u0445\u0445L\u0445LLL\u0445LLLL\u0445\u0445L, int LL\u0445\u0445LLL\u0445LLLL\u0445\u0445L, int \u0445L\u0445\u0445LLL\u0445LLLL\u0445\u0445L) {
        GuiAddAlt L\u0445L\u0445LLL\u0445LLLL\u0445\u0445L;
        try {
            super.mouseClicked(\u0445\u0445L\u0445LLL\u0445LLLL\u0445\u0445L, LL\u0445\u0445LLL\u0445LLLL\u0445\u0445L, \u0445L\u0445\u0445LLL\u0445LLLL\u0445\u0445L);
        }
        catch (IOException \u0445LL\u0445LLL\u0445LLLL\u0445\u0445L) {
            \u0445LL\u0445LLL\u0445LLLL\u0445\u0445L.printStackTrace();
        }
        L\u0445L\u0445LLL\u0445LLLL\u0445\u0445L.username.mouseClicked(\u0445\u0445L\u0445LLL\u0445LLLL\u0445\u0445L, LL\u0445\u0445LLL\u0445LLLL\u0445\u0445L, \u0445L\u0445\u0445LLL\u0445LLLL\u0445\u0445L);
        L\u0445L\u0445LLL\u0445LLLL\u0445\u0445L.password.mouseClicked(\u0445\u0445L\u0445LLL\u0445LLLL\u0445\u0445L, LL\u0445\u0445LLL\u0445LLLL\u0445\u0445L, \u0445L\u0445\u0445LLL\u0445LLLL\u0445\u0445L);
    }

    private class AddAltThread
    extends Thread {
        private final String password;
        private final String username;

        AddAltThread(String \u0445\u0445LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445L, String \u0445L\u0445LLL\u0445\u0445\u0445L\u0445L\u0445\u0445L) {
            AddAltThread \u0445LLLLL\u0445\u0445\u0445L\u0445L\u0445\u0445L;
            \u0445LLLLL\u0445\u0445\u0445L\u0445L\u0445\u0445L.username = \u0445\u0445LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445L;
            \u0445LLLLL\u0445\u0445\u0445L\u0445L\u0445\u0445L.password = \u0445L\u0445LLL\u0445\u0445\u0445L\u0445L\u0445\u0445L;
            GuiAddAlt.setStatus(\u0445LLLLL\u0445\u0445\u0445L\u0445L\u0445\u0445L.GuiAddAlt.this, (Object)((Object)TextFormatting.GRAY) + "Idle...");
        }

        private void checkAndAddAlt(String L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L, String \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L) {
            AddAltThread \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L;
            try {
                YggdrasilAuthenticationService L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
                YggdrasilUserAuthentication \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L = (YggdrasilUserAuthentication)L\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.createUserAuthentication(Agent.MINECRAFT);
                \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.setUsername(L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L);
                \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.setPassword(\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L);
                try {
                    \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.logIn();
                    AltManager.registry.add(new Alt(L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L, \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L, \u0445\u0445L\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.getSelectedProfile().getName(), Alt.Status.Working));
                    GuiAddAlt.setStatus(\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.GuiAddAlt.this, "Added alt - " + (Object)((Object)ChatFormatting.RED) + (Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.ownName.getBoolValue() ? "Protected" : \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.username) + (Object)((Object)ChatFormatting.GREEN) + " \u00c2\u00a7a" + (Object)((Object)ChatFormatting.BOLD) + "(license)");
                }
                catch (AuthenticationException LLL\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L) {
                    GuiAddAlt.setStatus(\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.GuiAddAlt.this, (Object)((Object)TextFormatting.RED) + "Connect failed!");
                    LLL\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.printStackTrace();
                }
            }
            catch (Throwable LL\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L) {
                GuiAddAlt.setStatus(\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.GuiAddAlt.this, (Object)((Object)TextFormatting.RED) + "Error");
                LL\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.printStackTrace();
            }
        }

        @Override
        public void run() {
            AddAltThread \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L;
            if (\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.password.equals("")) {
                AltManager.registry.add(new Alt(\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.username, ""));
                GuiAddAlt.setStatus(\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.GuiAddAlt.this, "Added alt - " + (Object)((Object)ChatFormatting.RED) + (Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.ownName.getBoolValue() ? "Protected" : \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.username) + (Object)((Object)ChatFormatting.GREEN) + " \u00c2\u00a7c" + (Object)((Object)ChatFormatting.BOLD) + "(non license)");
            } else {
                GuiAddAlt.setStatus(\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.GuiAddAlt.this, (Object)((Object)TextFormatting.AQUA) + "Trying connect...");
                \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.checkAndAddAlt(\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.username, \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.password);
            }
        }
    }
}

