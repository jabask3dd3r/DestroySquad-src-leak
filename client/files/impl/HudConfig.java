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
import org.Destroy.client.ui.components.draggable.DraggableModule;

public class HudConfig
extends FileManager.CustomFile {
    public HudConfig(String \u0445\u0445L\u0445\u0445LL\u0445\u0445LL\u0445LL, boolean LL\u0445\u0445\u0445LL\u0445\u0445LL\u0445LL) {
        super(\u0445\u0445L\u0445\u0445LL\u0445\u0445LL\u0445LL, LL\u0445\u0445\u0445LL\u0445\u0445LL\u0445LL);
        HudConfig L\u0445L\u0445\u0445LL\u0445\u0445LL\u0445LL;
    }

    @Override
    public void loadFile() {
        try {
            HudConfig L\u0445LL\u0445\u0445L\u0445\u0445LL\u0445LL;
            FileInputStream L\u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445LL = new FileInputStream(L\u0445LL\u0445\u0445L\u0445\u0445LL\u0445LL.getFile().getAbsolutePath());
            DataInputStream \u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445LL = new DataInputStream(L\u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445LL);
            BufferedReader LLLL\u0445\u0445L\u0445\u0445LL\u0445LL = new BufferedReader(new InputStreamReader(\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445LL));
            String \u0445LLL\u0445\u0445L\u0445\u0445LL\u0445LL = LLLL\u0445\u0445L\u0445\u0445LL\u0445LL.readLine();
            if (\u0445LLL\u0445\u0445L\u0445\u0445LL\u0445LL != null) {
                String \u0445\u0445L\u0445L\u0445L\u0445\u0445LL\u0445LL = \u0445LLL\u0445\u0445L\u0445\u0445LL\u0445LL.trim();
                String LL\u0445\u0445L\u0445L\u0445\u0445LL\u0445LL = \u0445\u0445L\u0445L\u0445L\u0445\u0445LL\u0445LL.split(":")[1];
                String \u0445L\u0445\u0445L\u0445L\u0445\u0445LL\u0445LL = \u0445\u0445L\u0445L\u0445L\u0445\u0445LL\u0445LL.split(":")[2];
                Iterator<DraggableModule> \u0445\u0445L\u0445\u0445\u0445L\u0445\u0445LL\u0445LL = Destroy.instance.draggableManager.getMods().iterator();
                if (\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445LL\u0445LL.hasNext()) {
                    DraggableModule L\u0445L\u0445L\u0445L\u0445\u0445LL\u0445LL = \u0445\u0445L\u0445\u0445\u0445L\u0445\u0445LL\u0445LL.next();
                    if (L\u0445L\u0445L\u0445L\u0445\u0445LL\u0445LL.getName().equals(\u0445\u0445L\u0445L\u0445L\u0445\u0445LL\u0445LL.split(":")[0])) {
                        L\u0445L\u0445L\u0445L\u0445\u0445LL\u0445LL.drag.setXPosition(Integer.parseInt(LL\u0445\u0445L\u0445L\u0445\u0445LL\u0445LL));
                        L\u0445L\u0445L\u0445L\u0445\u0445LL\u0445LL.drag.setYPosition(Integer.parseInt(\u0445L\u0445\u0445L\u0445L\u0445\u0445LL\u0445LL));
                    }
                    return;
                }
                return;
            }
            LLLL\u0445\u0445L\u0445\u0445LL\u0445LL.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void saveFile() {
        try {
            HudConfig \u0445\u0445LLLL\u0445\u0445\u0445LL\u0445LL;
            BufferedWriter L\u0445LLLL\u0445\u0445\u0445LL\u0445LL = new BufferedWriter(new FileWriter(\u0445\u0445LLLL\u0445\u0445\u0445LL\u0445LL.getFile()));
            Iterator<DraggableModule> L\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LL = Destroy.instance.draggableManager.getMods().iterator();
            if (L\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LL.hasNext()) {
                DraggableModule \u0445LLLLL\u0445\u0445\u0445LL\u0445LL = L\u0445\u0445LLL\u0445\u0445\u0445LL\u0445LL.next();
                L\u0445LLLL\u0445\u0445\u0445LL\u0445LL.write(\u0445LLLLL\u0445\u0445\u0445LL\u0445LL.getName() + ":" + \u0445LLLLL\u0445\u0445\u0445LL\u0445LL.drag.getXPosition() + ":" + \u0445LLLLL\u0445\u0445\u0445LL\u0445LL.drag.getYPosition());
                L\u0445LLLL\u0445\u0445\u0445LL\u0445LL.write("\r\n");
                return;
            }
            L\u0445LLLL\u0445\u0445\u0445LL\u0445LL.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

