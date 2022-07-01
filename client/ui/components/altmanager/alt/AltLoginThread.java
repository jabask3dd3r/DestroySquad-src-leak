/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.altmanager.alt;

import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.net.Proxy;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.impl.misc.NameProtected;
import org.Destroy.client.ui.components.altmanager.GuiAltManager;
import org.Destroy.client.ui.components.altmanager.alt.Alt;
import org.Destroy.client.ui.components.altmanager.alt.AltManager;
import org.Destroy.client.ui.components.altmanager.althening.api.AltService;

public class AltLoginThread
extends Thread {
    private final Alt alt;
    private final Minecraft mc = Minecraft.getInstance();
    private String status;

    public AltLoginThread(Alt \u0445LLL\u0445LL\u0445\u0445L\u0445LLL) {
        AltLoginThread LLLL\u0445LL\u0445\u0445L\u0445LLL;
        LLLL\u0445LL\u0445\u0445L\u0445LLL.alt = \u0445LLL\u0445LL\u0445\u0445L\u0445LLL;
        LLLL\u0445LL\u0445\u0445L\u0445LLL.status = "Waiting...";
    }

    private Session createSession(String L\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL, String \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL) {
        try {
            GuiAltManager.altService.switchService(AltService.EnumAltService.MOJANG);
            YggdrasilAuthenticationService L\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
            YggdrasilUserAuthentication \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL = (YggdrasilUserAuthentication)L\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.createUserAuthentication(Agent.MINECRAFT);
            \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.setUsername(L\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL);
            \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.setPassword(\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL);
            try {
                \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.logIn();
                return new Session(\u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.getSelectedProfile().getName(), \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.getSelectedProfile().getId().toString(), \u0445\u0445L\u0445\u0445LL\u0445\u0445L\u0445LLL.getAuthenticatedToken(), "mojang");
            }
            catch (AuthenticationException \u0445LL\u0445\u0445LL\u0445\u0445L\u0445LLL) {
                return null;
            }
        }
        catch (Exception LL\u0445\u0445\u0445LL\u0445\u0445L\u0445LLL) {
            return null;
        }
    }

    public String getStatus() {
        AltLoginThread L\u0445\u0445LL\u0445L\u0445\u0445L\u0445LLL;
        return L\u0445\u0445LL\u0445L\u0445\u0445L\u0445LLL.status;
    }

    public void setStatus(String \u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445LLL) {
        L\u0445L\u0445L\u0445L\u0445\u0445L\u0445LLL.status = \u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445LLL;
    }

    @Override
    public void run() {
        AltLoginThread \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL;
        if (\u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.getPassword().equals("")) {
            \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.mc.session = new Session(\u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.getUsername(), "", "", "mojang");
            \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.status = "Logged in - " + (Object)((Object)ChatFormatting.RED) + (Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.ownName.getBoolValue() ? "Protected" : \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.getUsername()) + (Object)((Object)ChatFormatting.GREEN) + " " + (Object)((Object)ChatFormatting.BOLD) + "(non license)";
        } else {
            \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.status = "Logging in...";
            Session LLLL\u0445\u0445L\u0445\u0445L\u0445LLL = \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.createSession(\u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.getUsername(), \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.getPassword());
            if (LLLL\u0445\u0445L\u0445\u0445L\u0445LLL == null) {
                \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.status = "Connect failed!";
                if (\u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.getStatus().equals((Object)Alt.Status.Unchecked)) {
                    \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.setStatus(Alt.Status.NotWorking);
                }
            } else {
                AltManager.lastAlt = new Alt(\u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.getUsername(), \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.getPassword());
                \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.status = "Logged in - " + (Object)((Object)ChatFormatting.RED) + (Destroy.instance.featureManager.getFeatureByClass(NameProtected.class).getState() && NameProtected.ownName.getBoolValue() ? "Protected" : LLLL\u0445\u0445L\u0445\u0445L\u0445LLL.getUsername()) + "" + (Object)((Object)ChatFormatting.BOLD) + " (license)";
                \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.setMask(LLLL\u0445\u0445L\u0445\u0445L\u0445LLL.getUsername());
                \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.mc.session = LLLL\u0445\u0445L\u0445\u0445L\u0445LLL;
                if (\u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.getStatus().equals((Object)Alt.Status.Unchecked)) {
                    \u0445LLL\u0445\u0445L\u0445\u0445L\u0445LLL.alt.setStatus(Alt.Status.Working);
                }
            }
        }
    }
}

