/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.misc;

import org.Destroy.client.helpers.Helper;

public class TimerHelper
implements Helper {
    private long ms;

    public TimerHelper() {
        TimerHelper \u0445LLL\u0445\u0445\u0445LLL\u0445\u0445L;
        \u0445LLL\u0445\u0445\u0445LLL\u0445\u0445L.ms = \u0445LLL\u0445\u0445\u0445LLL\u0445\u0445L.getCurrentMS();
    }

    private long getCurrentMS() {
        return System.currentTimeMillis();
    }

    public boolean hasReached(float L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L) {
        TimerHelper LL\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L;
        return (float)(LL\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L.getCurrentMS() - LL\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L.ms) > L\u0445\u0445\u0445\u0445\u0445\u0445LLL\u0445\u0445L;
    }

    public void reset() {
        TimerHelper \u0445\u0445LLLLL\u0445LL\u0445\u0445L;
        \u0445\u0445LLLLL\u0445LL\u0445\u0445L.ms = \u0445\u0445LLLLL\u0445LL\u0445\u0445L.getCurrentMS();
    }

    public long getTime() {
        TimerHelper L\u0445\u0445LLLL\u0445LL\u0445\u0445L;
        return L\u0445\u0445LLLL\u0445LL\u0445\u0445L.getCurrentMS() - L\u0445\u0445LLLL\u0445LL\u0445\u0445L.ms;
    }
}

