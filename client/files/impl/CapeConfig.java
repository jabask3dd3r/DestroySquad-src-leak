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
import org.Destroy.client.files.FileManager;
import org.Destroy.client.ui.GuiCapeSelector;

public class CapeConfig
extends FileManager.CustomFile {
    public CapeConfig(String \u0445\u0445\u0445LLLL\u0445\u0445\u0445L\u0445L, boolean LLL\u0445LLL\u0445\u0445\u0445L\u0445L) {
        super(\u0445\u0445\u0445LLLL\u0445\u0445\u0445L\u0445L, LLL\u0445LLL\u0445\u0445\u0445L\u0445L);
        CapeConfig L\u0445\u0445LLLL\u0445\u0445\u0445L\u0445L;
    }

    @Override
    public void loadFile() {
        try {
            CapeConfig LLL\u0445\u0445LL\u0445\u0445\u0445L\u0445L;
            FileInputStream \u0445\u0445LL\u0445LL\u0445\u0445\u0445L\u0445L = new FileInputStream(LLL\u0445\u0445LL\u0445\u0445\u0445L\u0445L.getFile().getAbsolutePath());
            DataInputStream LL\u0445L\u0445LL\u0445\u0445\u0445L\u0445L = new DataInputStream(\u0445\u0445LL\u0445LL\u0445\u0445\u0445L\u0445L);
            BufferedReader \u0445L\u0445L\u0445LL\u0445\u0445\u0445L\u0445L = new BufferedReader(new InputStreamReader(LL\u0445L\u0445LL\u0445\u0445\u0445L\u0445L));
            String L\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L = \u0445L\u0445L\u0445LL\u0445\u0445\u0445L\u0445L.readLine();
            if (L\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L != null) {
                String L\u0445LL\u0445LL\u0445\u0445\u0445L\u0445L = L\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L.trim();
                if (GuiCapeSelector.Selector.getCapeName() != null) {
                    GuiCapeSelector.Selector.setCapeName(L\u0445LL\u0445LL\u0445\u0445\u0445L\u0445L);
                }
                return;
            }
            \u0445L\u0445L\u0445LL\u0445\u0445\u0445L\u0445L.close();
        }
        catch (Exception \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L) {
            \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L.printStackTrace();
        }
    }

    @Override
    public void saveFile() {
        try {
            CapeConfig L\u0445LLL\u0445L\u0445\u0445\u0445L\u0445L;
            BufferedWriter \u0445LLLL\u0445L\u0445\u0445\u0445L\u0445L = new BufferedWriter(new FileWriter(L\u0445LLL\u0445L\u0445\u0445\u0445L\u0445L.getFile()));
            \u0445LLLL\u0445L\u0445\u0445\u0445L\u0445L.write(GuiCapeSelector.Selector.getCapeName());
            \u0445LLLL\u0445L\u0445\u0445\u0445L\u0445L.write("\r\n");
            \u0445LLLL\u0445L\u0445\u0445\u0445L\u0445L.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

