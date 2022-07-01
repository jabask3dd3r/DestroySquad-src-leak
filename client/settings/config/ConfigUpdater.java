/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.settings.config;

import com.google.gson.JsonObject;

public interface ConfigUpdater {
    public JsonObject save();

    public void load(JsonObject var1);
}

