/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.files.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import org.Destroy.client.files.FileManager;
import org.Destroy.client.ui.components.altmanager.alt.Alt;
import org.Destroy.client.ui.components.altmanager.alt.AltManager;

public class AltConfig
extends FileManager.CustomFile {
    public AltConfig(String \u0445L\u0445\u0445L\u0445LL\u0445\u0445LLLL, boolean L\u0445\u0445\u0445L\u0445LL\u0445\u0445LLLL) {
        super(\u0445L\u0445\u0445L\u0445LL\u0445\u0445LLLL, L\u0445\u0445\u0445L\u0445LL\u0445\u0445LLLL);
        AltConfig LL\u0445\u0445L\u0445LL\u0445\u0445LLLL;
    }

    @Override
    public void loadFile() throws IOException {
        AltConfig \u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445LLLL;
        BufferedReader LLL\u0445\u0445\u0445LL\u0445\u0445LLLL = new BufferedReader(new FileReader(\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445LLLL.getFile()));
        String \u0445LL\u0445\u0445\u0445LL\u0445\u0445LLLL = LLL\u0445\u0445\u0445LL\u0445\u0445LLLL.readLine();
        if (\u0445LL\u0445\u0445\u0445LL\u0445\u0445LLLL != null) {
            String[] L\u0445\u0445L\u0445\u0445LL\u0445\u0445LLLL = \u0445LL\u0445\u0445\u0445LL\u0445\u0445LLLL.split(":");
            if (L\u0445\u0445L\u0445\u0445LL\u0445\u0445LLLL.length > 2) {
                AltManager.registry.add(new Alt(L\u0445\u0445L\u0445\u0445LL\u0445\u0445LLLL[0], L\u0445\u0445L\u0445\u0445LL\u0445\u0445LLLL[1], L\u0445\u0445L\u0445\u0445LL\u0445\u0445LLLL[2], L\u0445\u0445L\u0445\u0445LL\u0445\u0445LLLL.length > 3 ? Alt.Status.valueOf(L\u0445\u0445L\u0445\u0445LL\u0445\u0445LLLL[3]) : Alt.Status.Unchecked));
            } else {
                AltManager.registry.add(new Alt(L\u0445\u0445L\u0445\u0445LL\u0445\u0445LLLL[0], L\u0445\u0445L\u0445\u0445LL\u0445\u0445LLLL[1]));
            }
            return;
        }
        LLL\u0445\u0445\u0445LL\u0445\u0445LLLL.close();
    }

    @Override
    public void saveFile() throws IOException {
        AltConfig \u0445\u0445LLLL\u0445L\u0445\u0445LLLL;
        PrintWriter LL\u0445LLL\u0445L\u0445\u0445LLLL = new PrintWriter(new FileWriter(\u0445\u0445LLLL\u0445L\u0445\u0445LLLL.getFile()));
        Iterator<Alt> \u0445\u0445\u0445LLL\u0445L\u0445\u0445LLLL = AltManager.registry.iterator();
        if (\u0445\u0445\u0445LLL\u0445L\u0445\u0445LLLL.hasNext()) {
            Alt L\u0445LLLL\u0445L\u0445\u0445LLLL = \u0445\u0445\u0445LLL\u0445L\u0445\u0445LLLL.next();
            if (L\u0445LLLL\u0445L\u0445\u0445LLLL.getMask().equals("")) {
                LL\u0445LLL\u0445L\u0445\u0445LLLL.println(L\u0445LLLL\u0445L\u0445\u0445LLLL.getUsername() + ":" + L\u0445LLLL\u0445L\u0445\u0445LLLL.getPassword() + ":" + L\u0445LLLL\u0445L\u0445\u0445LLLL.getUsername() + ":" + (Object)((Object)L\u0445LLLL\u0445L\u0445\u0445LLLL.getStatus()));
            } else {
                LL\u0445LLL\u0445L\u0445\u0445LLLL.println(L\u0445LLLL\u0445L\u0445\u0445LLLL.getUsername() + ":" + L\u0445LLLL\u0445L\u0445\u0445LLLL.getPassword() + ":" + L\u0445LLLL\u0445L\u0445\u0445LLLL.getMask() + ":" + (Object)((Object)L\u0445LLLL\u0445L\u0445\u0445LLLL.getStatus()));
            }
            return;
        }
        LL\u0445LLL\u0445L\u0445\u0445LLLL.close();
    }
}

