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
import net.minecraft.block.Block;
import org.Destroy.client.cmd.impl.XrayCommand;
import org.Destroy.client.files.FileManager;

public class XrayConfig
extends FileManager.CustomFile {
    public XrayConfig(String \u0445\u0445\u0445\u0445\u0445\u0445LLLLLL, boolean LLLLLL\u0445LLLLL) {
        super(\u0445\u0445\u0445\u0445\u0445\u0445LLLLLL, LLLLLL\u0445LLLLL);
        XrayConfig L\u0445\u0445\u0445\u0445\u0445LLLLLL;
    }

    @Override
    public void loadFile() {
        try {
            XrayConfig \u0445LLL\u0445L\u0445LLLLL;
            FileInputStream \u0445L\u0445\u0445LL\u0445LLLLL = new FileInputStream(\u0445LLL\u0445L\u0445LLLLL.getFile().getAbsolutePath());
            DataInputStream L\u0445\u0445\u0445LL\u0445LLLLL = new DataInputStream(\u0445L\u0445\u0445LL\u0445LLLLL);
            BufferedReader \u0445\u0445\u0445\u0445LL\u0445LLLLL = new BufferedReader(new InputStreamReader(L\u0445\u0445\u0445LL\u0445LLLLL));
            String LLLL\u0445L\u0445LLLLL = \u0445\u0445\u0445\u0445LL\u0445LLLLL.readLine();
            if (LLLL\u0445L\u0445LLLLL != null) {
                String \u0445\u0445L\u0445LL\u0445LLLLL = LLLL\u0445L\u0445LLLLL.trim();
                String LL\u0445\u0445LL\u0445LLLLL = \u0445\u0445L\u0445LL\u0445LLLLL.split(":")[1];
                XrayCommand.blockIDS.add(new Integer(LL\u0445\u0445LL\u0445LLLLL));
                return;
            }
            \u0445\u0445\u0445\u0445LL\u0445LLLLL.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void saveFile() {
        try {
            XrayConfig \u0445\u0445\u0445\u0445\u0445L\u0445LLLLL;
            BufferedWriter L\u0445\u0445\u0445\u0445L\u0445LLLLL = new BufferedWriter(new FileWriter(\u0445\u0445\u0445\u0445\u0445L\u0445LLLLL.getFile()));
            Iterator<Integer> L\u0445LLL\u0445\u0445LLLLL = XrayCommand.blockIDS.iterator();
            if (L\u0445LLL\u0445\u0445LLLLL.hasNext()) {
                Integer \u0445L\u0445\u0445\u0445L\u0445LLLLL = L\u0445LLL\u0445\u0445LLLLL.next();
                if (\u0445L\u0445\u0445\u0445L\u0445LLLLL != null) {
                    L\u0445\u0445\u0445\u0445L\u0445LLLLL.write("blockID:" + \u0445L\u0445\u0445\u0445L\u0445LLLLL + ":" + Block.getBlockById(\u0445L\u0445\u0445\u0445L\u0445LLLLL).getLocalizedName());
                    L\u0445\u0445\u0445\u0445L\u0445LLLLL.write("\r\n");
                }
                return;
            }
            L\u0445\u0445\u0445\u0445L\u0445LLLLL.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

