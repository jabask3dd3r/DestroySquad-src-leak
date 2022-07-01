/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.settings.config;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.Destroy.client.Destroy;
import org.Destroy.client.settings.config.Config;
import org.Destroy.client.settings.config.Manager;
import org.apache.commons.io.FilenameUtils;

public final class ConfigManager
extends Manager<Config> {
    public static final File configDirectory = new File(Destroy.instance.name, "configs");
    private static final ArrayList<Config> loadedConfigs = new ArrayList();

    public ConfigManager() {
        ConfigManager L\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L;
        L\u0445\u0445LLL\u0445L\u0445L\u0445\u0445L.setContents(ConfigManager.loadConfigs());
        configDirectory.mkdirs();
    }

    private static ArrayList<Config> loadConfigs() {
        File[] \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
        int \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L;
        int \u0445LLLL\u0445\u0445L\u0445L\u0445\u0445L;
        File[] L\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L = configDirectory.listFiles();
        if (L\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L != null && (\u0445LLLL\u0445\u0445L\u0445L\u0445\u0445L = 0) < (\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L = (\u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L = L\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445L).length)) {
            File LLL\u0445\u0445L\u0445L\u0445L\u0445\u0445L = \u0445L\u0445\u0445\u0445L\u0445L\u0445L\u0445\u0445L[\u0445LLLL\u0445\u0445L\u0445L\u0445\u0445L];
            if (FilenameUtils.getExtension(LLL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.getName()).equals("json")) {
                loadedConfigs.add(new Config(FilenameUtils.removeExtension(LLL\u0445\u0445L\u0445L\u0445L\u0445\u0445L.getName())));
            }
            ++\u0445LLLL\u0445\u0445L\u0445L\u0445\u0445L;
            return null;
        }
        return loadedConfigs;
    }

    public static ArrayList<Config> getLoadedConfigs() {
        return loadedConfigs;
    }

    public void load() {
        File[] L\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L;
        File[] LLLLLLL\u0445\u0445L\u0445\u0445L;
        int \u0445LLLLLL\u0445\u0445L\u0445\u0445L;
        int \u0445\u0445LLLLL\u0445\u0445L\u0445\u0445L;
        if (!configDirectory.exists()) {
            configDirectory.mkdirs();
        }
        if (configDirectory != null && (\u0445\u0445LLLLL\u0445\u0445L\u0445\u0445L = 0) < (\u0445LLLLLL\u0445\u0445L\u0445\u0445L = (LLLLLLL\u0445\u0445L\u0445\u0445L = (L\u0445L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L = configDirectory.listFiles(\u0445L\u0445L\u0445LLLL\u0445\u0445\u0445L -> !\u0445L\u0445L\u0445LLLL\u0445\u0445\u0445L.isDirectory() && FilenameUtils.getExtension(\u0445L\u0445L\u0445LLLL\u0445\u0445\u0445L.getName()).equals("json")))).length)) {
            File \u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L = LLLLLLL\u0445\u0445L\u0445\u0445L[\u0445\u0445LLLLL\u0445\u0445L\u0445\u0445L];
            Config \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L = new Config(FilenameUtils.removeExtension(\u0445LL\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445L.getName()).replace(" ", ""));
            loadedConfigs.add(\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445L);
            ++\u0445\u0445LLLLL\u0445\u0445L\u0445\u0445L;
            return;
        }
    }

    public boolean loadConfig(String \u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L) {
        ConfigManager \u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L;
        if (\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L == null) {
            return false;
        }
        Config \u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L = \u0445\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445L.findConfig(\u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445L);
        if (\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L == null) {
            return false;
        }
        try {
            FileReader L\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445L = new FileReader(\u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.getFile());
            JsonParser \u0445LLLL\u0445L\u0445\u0445L\u0445\u0445L = new JsonParser();
            JsonObject \u0445\u0445LLL\u0445L\u0445\u0445L\u0445\u0445L = (JsonObject)\u0445LLLL\u0445L\u0445\u0445L\u0445\u0445L.parse(L\u0445\u0445\u0445\u0445LL\u0445\u0445L\u0445\u0445L);
            \u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445L.load(\u0445\u0445LLL\u0445L\u0445\u0445L\u0445\u0445L);
            return true;
        }
        catch (FileNotFoundException \u0445L\u0445LL\u0445L\u0445\u0445L\u0445\u0445L) {
            return false;
        }
    }

    public boolean saveConfig(String \u0445LLL\u0445L\u0445\u0445\u0445L\u0445\u0445L) {
        ConfigManager \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L;
        if (\u0445LLL\u0445L\u0445\u0445\u0445L\u0445\u0445L == null) {
            return false;
        }
        Config L\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L = \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L.findConfig(\u0445LLL\u0445L\u0445\u0445\u0445L\u0445\u0445L);
        if (L\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L == null) {
            Config LLL\u0445LL\u0445\u0445\u0445L\u0445\u0445L = L\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L = new Config(\u0445LLL\u0445L\u0445\u0445\u0445L\u0445\u0445L);
            \u0445\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L.getContents().add(LLL\u0445LL\u0445\u0445\u0445L\u0445\u0445L);
        }
        String LL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L = new GsonBuilder().setPrettyPrinting().create().toJson(L\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.save());
        try {
            FileWriter \u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445L = new FileWriter(L\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445L.getFile());
            \u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445L.write(LL\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445L);
            \u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445L.close();
            return true;
        }
        catch (IOException \u0445L\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445L) {
            return false;
        }
    }

    public Config findConfig(String \u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L) {
        ConfigManager \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L;
        if (\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L == null) {
            return null;
        }
        Iterator \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L = \u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.getContents().iterator();
        if (\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L.hasNext()) {
            Config \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L = (Config)\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L.next();
            if (\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L.getName().equalsIgnoreCase(\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L)) {
                return \u0445L\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L;
            }
            return null;
        }
        if (new File(configDirectory, \u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L + ".json").exists()) {
            return new Config(\u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L);
        }
        return null;
    }

    public boolean deleteConfig(String LLL\u0445LLLLL\u0445\u0445\u0445L) {
        ConfigManager L\u0445\u0445LLLLLL\u0445\u0445\u0445L;
        if (LLL\u0445LLLLL\u0445\u0445\u0445L == null) {
            return false;
        }
        Config L\u0445L\u0445LLLLL\u0445\u0445\u0445L = L\u0445\u0445LLLLLL\u0445\u0445\u0445L.findConfig(LLL\u0445LLLLL\u0445\u0445\u0445L);
        if (L\u0445L\u0445LLLLL\u0445\u0445\u0445L != null) {
            File \u0445L\u0445LLLLLL\u0445\u0445\u0445L = L\u0445L\u0445LLLLL\u0445\u0445\u0445L.getFile();
            L\u0445\u0445LLLLLL\u0445\u0445\u0445L.getContents().remove(L\u0445L\u0445LLLLL\u0445\u0445\u0445L);
            return \u0445L\u0445LLLLLL\u0445\u0445\u0445L.exists() && \u0445L\u0445LLLLLL\u0445\u0445\u0445L.delete();
        }
        return false;
    }
}

