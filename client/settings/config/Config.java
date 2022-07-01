/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.settings.config;

import com.google.gson.JsonObject;
import java.io.File;
import java.util.Iterator;
import org.Destroy.client.Destroy;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.settings.config.ConfigManager;
import org.Destroy.client.settings.config.ConfigUpdater;

public final class Config
implements ConfigUpdater {
    private final String name;
    private final File file;

    public Config(String \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L) {
        Config L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
        L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.name = \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
        L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.file = new File(ConfigManager.configDirectory, \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L + ".json");
        if (!L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.file.exists()) {
            try {
                L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.file.createNewFile();
            }
            catch (Exception L\u0445LLLLLLL\u0445\u0445\u0445\u0445\u0445L) {
                // empty catch block
            }
        }
    }

    public File getFile() {
        Config LL\u0445LLLLLL\u0445\u0445\u0445\u0445\u0445L;
        return LL\u0445LLLLLL\u0445\u0445\u0445\u0445\u0445L.file;
    }

    public String getName() {
        Config \u0445\u0445\u0445LLLLLL\u0445\u0445\u0445\u0445\u0445L;
        return \u0445\u0445\u0445LLLLLL\u0445\u0445\u0445\u0445\u0445L.name;
    }

    @Override
    public JsonObject save() {
        JsonObject LLLL\u0445LLLL\u0445\u0445\u0445\u0445\u0445L = new JsonObject();
        JsonObject \u0445LLL\u0445LLLL\u0445\u0445\u0445\u0445\u0445L = new JsonObject();
        JsonObject L\u0445LL\u0445LLLL\u0445\u0445\u0445\u0445\u0445L = new JsonObject();
        Iterator<Feature> L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445\u0445L = Destroy.instance.featureManager.getFeatureList().iterator();
        if (L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.hasNext()) {
            Feature L\u0445\u0445\u0445LLLLL\u0445\u0445\u0445\u0445\u0445L = L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.next();
            \u0445LLL\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.add(L\u0445\u0445\u0445LLLLL\u0445\u0445\u0445\u0445\u0445L.getLabel(), L\u0445\u0445\u0445LLLLL\u0445\u0445\u0445\u0445\u0445L.save());
            return null;
        }
        LLLL\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.add("Features", \u0445LLL\u0445LLLL\u0445\u0445\u0445\u0445\u0445L);
        return LLLL\u0445LLLL\u0445\u0445\u0445\u0445\u0445L;
    }

    @Override
    public void load(JsonObject \u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L) {
        if (\u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.has("Features")) {
            JsonObject \u0445L\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L = \u0445\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.getAsJsonObject("Features");
            Iterator<Feature> L\u0445LLL\u0445LLL\u0445\u0445\u0445\u0445\u0445L = Destroy.instance.featureManager.getFeatureList().iterator();
            if (L\u0445LLL\u0445LLL\u0445\u0445\u0445\u0445\u0445L.hasNext()) {
                Feature LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L = L\u0445LLL\u0445LLL\u0445\u0445\u0445\u0445\u0445L.next();
                LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.setState(false);
                LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.load(\u0445L\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.getAsJsonObject(LL\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.getLabel()));
                return;
            }
        }
    }
}

