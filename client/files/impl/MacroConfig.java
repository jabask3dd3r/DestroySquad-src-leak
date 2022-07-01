/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.files.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Iterator;
import org.Destroy.client.Destroy;
import org.Destroy.client.files.FileManager;
import org.Destroy.client.macro.Macro;
import org.lwjgl.input.Keyboard;

public class MacroConfig
extends FileManager.CustomFile {
    public MacroConfig(String LL\u0445LLL\u0445\u0445L\u0445\u0445LLL, boolean \u0445L\u0445LLL\u0445\u0445L\u0445\u0445LLL) {
        super(LL\u0445LLL\u0445\u0445L\u0445\u0445LLL, \u0445L\u0445LLL\u0445\u0445L\u0445\u0445LLL);
        MacroConfig \u0445\u0445LLLL\u0445\u0445L\u0445\u0445LLL;
    }

    @Override
    public void loadFile() {
        try {
            MacroConfig LLL\u0445\u0445L\u0445\u0445L\u0445\u0445LLL;
            FileInputStream LL\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL = new FileInputStream(LLL\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.getFile().getAbsolutePath());
            DataInputStream \u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL = new DataInputStream(LL\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL);
            BufferedReader L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL = new BufferedReader(new InputStreamReader(\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL));
            String \u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL = L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.readLine();
            if (\u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL != null) {
                String \u0445LLL\u0445L\u0445\u0445L\u0445\u0445LLL = \u0445\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.trim();
                String L\u0445LL\u0445L\u0445\u0445L\u0445\u0445LLL = \u0445LLL\u0445L\u0445\u0445L\u0445\u0445LLL.split(":")[0];
                String \u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445LLL = \u0445LLL\u0445L\u0445\u0445L\u0445\u0445LLL.split(":")[1];
                if (Destroy.instance.macroManager != null) {
                    Destroy.instance.macroManager.addMacro(new Macro(Keyboard.getKeyIndex(L\u0445LL\u0445L\u0445\u0445L\u0445\u0445LLL), \u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445LLL));
                }
                return;
            }
            L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void saveFile() {
        try {
            MacroConfig \u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL;
            BufferedWriter L\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL = new BufferedWriter(new FileWriter(\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL.getFile()));
            Iterator<Macro> L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL = Destroy.instance.macroManager.getMacros().iterator();
            if (L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.hasNext()) {
                Macro \u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL = L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.next();
                if (\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL != null) {
                    L\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL.write(Keyboard.getKeyName(\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL.getKey()) + ":" + \u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL.getValue());
                    L\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL.write("\r\n");
                }
                return;
            }
            L\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

