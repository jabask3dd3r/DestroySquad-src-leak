/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.notification;

import java.awt.Color;

public enum NotificationType {
    SUCCESS(new Color(100, 255, 100).getRGB()),
    INFO(new Color(225, 225, 255).getRGB()),
    ERROR(new Color(255, 100, 100).getRGB()),
    WARNING(new Color(255, 211, 53).getRGB());

    private final int color;

    private NotificationType(int L\u0445L\u0445LLLLLL\u0445LLL) {
        NotificationType \u0445LL\u0445LLLLLL\u0445LLL;
        \u0445LL\u0445LLLLLL\u0445LLL.color = L\u0445L\u0445LLLLLL\u0445LLL;
    }

    public int getColor() {
        NotificationType LLLL\u0445LLLLL\u0445LLL;
        return LLLL\u0445LLLLL\u0445LLL.color;
    }
}

