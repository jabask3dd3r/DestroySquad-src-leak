/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.input;

import java.util.regex.Pattern;

public class StringHelper {
    public StringHelper() {
        StringHelper L\u0445\u0445LLL\u0445LLL\u0445LLL;
    }

    public static String format(String \u0445LL\u0445LL\u0445LLL\u0445LLL) {
        return Pattern.compile("(?i)\u00c2\u00a7[0-9A-FK-OR]").matcher(\u0445LL\u0445LL\u0445LLL\u0445LLL).replaceAll("");
    }
}

