/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.altmanager.althening.api;

import java.lang.reflect.Field;

public class AltHelper {
    private String className;
    private Class<?> clazz;

    public AltHelper(String \u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445LL\u0445L) {
        AltHelper L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LL\u0445L;
        try {
            L\u0445\u0445L\u0445\u0445LL\u0445L\u0445LL\u0445L.clazz = Class.forName(\u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445LL\u0445L);
        }
        catch (ClassNotFoundException \u0445L\u0445L\u0445\u0445LL\u0445L\u0445LL\u0445L) {
            \u0445L\u0445L\u0445\u0445LL\u0445L\u0445LL\u0445L.printStackTrace();
        }
    }

    public void setStaticField(String \u0445LLLLL\u0445L\u0445L\u0445LL\u0445L, Object L\u0445LLLL\u0445L\u0445L\u0445LL\u0445L) throws NoSuchFieldException, IllegalAccessException {
        AltHelper LLLLLL\u0445L\u0445L\u0445LL\u0445L;
        Field \u0445\u0445LLLL\u0445L\u0445L\u0445LL\u0445L = LLLLLL\u0445L\u0445L\u0445LL\u0445L.clazz.getDeclaredField(\u0445LLLLL\u0445L\u0445L\u0445LL\u0445L);
        \u0445\u0445LLLL\u0445L\u0445L\u0445LL\u0445L.setAccessible(true);
        Field LL\u0445LLL\u0445L\u0445L\u0445LL\u0445L = Field.class.getDeclaredField("modifiers");
        LL\u0445LLL\u0445L\u0445L\u0445LL\u0445L.setAccessible(true);
        LL\u0445LLL\u0445L\u0445L\u0445LL\u0445L.setInt(\u0445\u0445LLLL\u0445L\u0445L\u0445LL\u0445L, \u0445\u0445LLLL\u0445L\u0445L\u0445LL\u0445L.getModifiers() & 0xFFFFFFEF);
        \u0445\u0445LLLL\u0445L\u0445L\u0445LL\u0445L.set(null, L\u0445LLLL\u0445L\u0445L\u0445LL\u0445L);
    }
}

