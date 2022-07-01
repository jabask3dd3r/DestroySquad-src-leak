/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.altmanager.alt;

import java.util.ArrayList;
import org.Destroy.client.ui.components.altmanager.alt.Alt;

public class AltManager {
    public static Alt lastAlt;
    public static ArrayList<Alt> registry;

    public AltManager() {
        AltManager L\u0445LLLLL\u0445\u0445\u0445\u0445\u0445\u0445LL;
    }

    public ArrayList<Alt> getRegistry() {
        return registry;
    }

    public void setLastAlt(Alt \u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445\u0445LL) {
        lastAlt = \u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445\u0445LL;
    }

    static {
        registry = new ArrayList();
    }
}

