/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.altmanager.althening.api;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.Destroy.client.ui.components.altmanager.althening.api.AltHelper;

public class AltService {
    private final AltHelper userAuthentication = new AltHelper("com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication");
    private final AltHelper minecraftSession = new AltHelper("com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService");
    private EnumAltService currentService;

    public AltService() {
        AltService \u0445LL\u0445LLL\u0445L\u0445\u0445\u0445L\u0445L;
    }

    public void switchService(EnumAltService L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L\u0445L) throws NoSuchFieldException, IllegalAccessException {
        AltService \u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L\u0445L;
        if (\u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L\u0445L.currentService == L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L\u0445L) {
            return;
        }
        \u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L\u0445L.reflectionFields(L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L\u0445L.hostname);
        \u0445L\u0445\u0445LLL\u0445L\u0445\u0445\u0445L\u0445L.currentService = L\u0445\u0445\u0445LLL\u0445L\u0445\u0445\u0445L\u0445L;
    }

    private void reflectionFields(String L\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L) throws NoSuchFieldException, IllegalAccessException {
        AltService \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L;
        HashMap<String, URL> \u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L = new HashMap<String, URL>();
        String LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L = L\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.contains("thealtening") ? "http" : "https";
        \u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.put("ROUTE_AUTHENTICATE", \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.constantURL(LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + "://authserver." + L\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + ".com/authenticate"));
        \u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.put("ROUTE_INVALIDATE", \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.constantURL(LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + "://authserver" + L\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + "com/invalidate"));
        \u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.put("ROUTE_REFRESH", \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.constantURL(LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + "://authserver." + L\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + ".com/refresh"));
        \u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.put("ROUTE_VALIDATE", \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.constantURL(LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + "://authserver." + L\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + ".com/validate"));
        \u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.put("ROUTE_SIGNOUT", \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.constantURL(LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + "://authserver." + L\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + ".com/signout"));
        \u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.forEach((L\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445L, \u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445L) -> {
            try {
                AltService \u0445LL\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445L;
                \u0445LL\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445L.userAuthentication.setStaticField((String)L\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445L, \u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445L);
            }
            catch (Exception LLL\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445L) {
                LLL\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445L.printStackTrace();
            }
        });
        \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.userAuthentication.setStaticField("BASE_URL", LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + "://authserver." + L\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + ".com/");
        \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.minecraftSession.setStaticField("BASE_URL", LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + "://sessionserver." + L\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + ".com/session/minecraft/");
        \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.minecraftSession.setStaticField("JOIN_URL", \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.constantURL(LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + "://sessionserver." + L\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + ".com/session/minecraft/join"));
        \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.minecraftSession.setStaticField("CHECK_URL", \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.constantURL(LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + "://sessionserver." + L\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L + ".com/session/minecraft/hasJoined"));
        \u0445L\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.minecraftSession.setStaticField("WHITELISTED_DOMAINS", new String[]{".minecraft.net", ".mojang.com", ".thealtening.com"});
    }

    private URL constantURL(String \u0445LLLL\u0445L\u0445L\u0445\u0445\u0445L\u0445L) {
        try {
            return new URL(\u0445LLLL\u0445L\u0445L\u0445\u0445\u0445L\u0445L);
        }
        catch (MalformedURLException \u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L) {
            return null;
        }
    }

    public static enum EnumAltService {
        MOJANG("MOJANG", 0, "mojang"),
        THEALTENING("THEALTENING", 1, "thealtening");

        String hostname;

        private EnumAltService(String L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L, int \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L, String LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) {
            EnumAltService \u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L;
            \u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L.hostname = LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
        }
    }
}

