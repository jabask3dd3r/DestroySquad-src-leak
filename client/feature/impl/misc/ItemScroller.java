/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.settings.impl.NumberSetting;

public class ItemScroller
extends Feature {
    public static NumberSetting scrollerDelay;

    public ItemScroller() {
        super("ItemScroller", "\nAllows you to quickly loot chests", Type.Misc);
        ItemScroller LLL\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L;
        scrollerDelay = new NumberSetting("Scroller Delay", 0.0f, 0.0f, 1000.0f, 50.0f, () -> true);
        LLL\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L.addSettings(scrollerDelay);
    }

    @Override
    public void onEnable() {
        ItemScroller \u0445L\u0445\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L;
        int LL\u0445\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L = 0;
        if (LL\u0445\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L < 3) {
            ChatHelper.addChatMessage("Hold shift and left mouse button to quickly loot chests!");
            ++LL\u0445\u0445L\u0445\u0445LL\u0445LL\u0445\u0445L;
            return;
        }
        super.onEnable();
    }
}

