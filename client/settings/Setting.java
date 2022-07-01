/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.settings;

import java.util.function.Supplier;
import org.Destroy.client.settings.Configurable;

public class Setting
extends Configurable {
    protected String name;
    protected Supplier<Boolean> visible;

    public Setting() {
        Setting LL\u0445\u0445\u0445LLLL\u0445LL\u0445LL;
    }

    public boolean isVisible() {
        Setting \u0445\u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL;
        return \u0445\u0445\u0445\u0445\u0445LLLL\u0445LL\u0445LL.visible.get();
    }

    public void setVisible(Supplier<Boolean> LL\u0445LL\u0445LLL\u0445LL\u0445LL) {
        \u0445\u0445LLL\u0445LLL\u0445LL\u0445LL.visible = LL\u0445LL\u0445LLL\u0445LL\u0445LL;
    }

    public String getName() {
        Setting LLL\u0445L\u0445LLL\u0445LL\u0445LL;
        return LLL\u0445L\u0445LLL\u0445LL\u0445LL.name;
    }
}

