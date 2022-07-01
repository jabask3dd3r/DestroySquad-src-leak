/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.files;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.Destroy.client.Destroy;
import org.Destroy.client.files.impl.AltConfig;
import org.Destroy.client.files.impl.CapeConfig;
import org.Destroy.client.files.impl.FriendConfig;
import org.Destroy.client.files.impl.HudConfig;
import org.Destroy.client.files.impl.MacroConfig;
import org.Destroy.client.files.impl.XrayConfig;

public class FileManager {
    public static File directory = new File(Destroy.instance.name);
    public static ArrayList<CustomFile> files = new ArrayList();

    public FileManager() {
        FileManager L\u0445LL\u0445LL\u0445\u0445\u0445L\u0445\u0445LL;
        files.add(new AltConfig("AltConfig", true));
        files.add(new FriendConfig("FriendConfig", true));
        files.add(new MacroConfig("MacroConfig", true));
        files.add(new HudConfig("HudConfig", true));
        files.add(new CapeConfig("CapeConfig", true));
        files.add(new XrayConfig("XrayConfig", true));
    }

    public void loadFiles() {
        Iterator<CustomFile> L\u0445L\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LL = files.iterator();
        if (L\u0445L\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LL.hasNext()) {
            CustomFile LLL\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LL = L\u0445L\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LL.next();
            try {
                if (LLL\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LL.loadOnStart()) {
                    LLL\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LL.loadFile();
                }
            }
            catch (Exception \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445LL) {
                \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445LL.printStackTrace();
            }
            return;
        }
    }

    public void saveFiles() {
        Iterator<CustomFile> L\u0445LLL\u0445L\u0445\u0445\u0445L\u0445\u0445LL = files.iterator();
        if (L\u0445LLL\u0445L\u0445\u0445\u0445L\u0445\u0445LL.hasNext()) {
            CustomFile LLLLL\u0445L\u0445\u0445\u0445L\u0445\u0445LL = L\u0445LLL\u0445L\u0445\u0445\u0445L\u0445\u0445LL.next();
            try {
                LLLLL\u0445L\u0445\u0445\u0445L\u0445\u0445LL.saveFile();
            }
            catch (Exception LL\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445LL) {
                // empty catch block
            }
            return;
        }
    }

    public CustomFile getFile(Class<?> \u0445LL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LL) {
        CustomFile \u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LL;
        Iterator<CustomFile> L\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LL = files.iterator();
        do {
            if (L\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LL.hasNext()) continue;
            return null;
        } while ((\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LL = L\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LL.next()).getClass() != \u0445LL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LL);
        return \u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LL;
    }

    public static abstract class CustomFile {
        private final File file;
        private final String name;
        private final boolean load;

        public CustomFile(String L\u0445LLLLL\u0445LL\u0445\u0445LLL, boolean \u0445\u0445LLLLL\u0445LL\u0445\u0445LLL) {
            CustomFile \u0445LLLLLL\u0445LL\u0445\u0445LLL;
            \u0445LLLLLL\u0445LL\u0445\u0445LLL.name = L\u0445LLLLL\u0445LL\u0445\u0445LLL;
            \u0445LLLLLL\u0445LL\u0445\u0445LLL.load = \u0445\u0445LLLLL\u0445LL\u0445\u0445LLL;
            \u0445LLLLLL\u0445LL\u0445\u0445LLL.file = new File(directory, L\u0445LLLLL\u0445LL\u0445\u0445LLL + ".json");
            if (!\u0445LLLLLL\u0445LL\u0445\u0445LLL.file.exists()) {
                try {
                    \u0445LLLLLL\u0445LL\u0445\u0445LLL.saveFile();
                }
                catch (Exception LLL\u0445LLL\u0445LL\u0445\u0445LLL) {
                    // empty catch block
                }
            }
        }

        public final File getFile() {
            CustomFile \u0445L\u0445\u0445LLL\u0445LL\u0445\u0445LLL;
            return \u0445L\u0445\u0445LLL\u0445LL\u0445\u0445LLL.file;
        }

        private boolean loadOnStart() {
            CustomFile LL\u0445L\u0445LL\u0445LL\u0445\u0445LLL;
            return LL\u0445L\u0445LL\u0445LL\u0445\u0445LLL.load;
        }

        public final String getName() {
            CustomFile LLL\u0445\u0445LL\u0445LL\u0445\u0445LLL;
            return LLL\u0445\u0445LL\u0445LL\u0445\u0445LLL.name;
        }

        public abstract void loadFile() throws Exception;

        public abstract void saveFile() throws Exception;
    }
}

