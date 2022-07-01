/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.altmanager.alt;

public class Alt {
    private final String username;
    private String mask;
    private String password;
    private Status status;

    public Alt(String LLL\u0445L\u0445\u0445\u0445\u0445LLLL, String L\u0445L\u0445L\u0445\u0445\u0445\u0445LLLL) {
        L\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL(LLL\u0445L\u0445\u0445\u0445\u0445LLLL, L\u0445L\u0445L\u0445\u0445\u0445\u0445LLLL, Status.Unchecked);
        Alt L\u0445\u0445LL\u0445\u0445\u0445\u0445LLLL;
    }

    public Alt(String LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLL, String \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLL, Status \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLL) {
        \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLLL(LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLL, \u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLL, "", \u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLLL);
        Alt \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLLL;
    }

    public Alt(String \u0445\u0445\u0445L\u0445LLLL\u0445LLL, String \u0445LL\u0445\u0445LLLL\u0445LLL, String \u0445\u0445L\u0445\u0445LLLL\u0445LLL, Status LL\u0445\u0445\u0445LLLL\u0445LLL) {
        Alt \u0445L\u0445L\u0445LLLL\u0445LLL;
        \u0445L\u0445L\u0445LLLL\u0445LLL.username = \u0445\u0445\u0445L\u0445LLLL\u0445LLL;
        \u0445L\u0445L\u0445LLLL\u0445LLL.password = \u0445LL\u0445\u0445LLLL\u0445LLL;
        \u0445L\u0445L\u0445LLLL\u0445LLL.mask = \u0445\u0445L\u0445\u0445LLLL\u0445LLL;
        \u0445L\u0445L\u0445LLLL\u0445LLL.status = LL\u0445\u0445\u0445LLLL\u0445LLL;
    }

    public Status getStatus() {
        Alt LLL\u0445L\u0445LLL\u0445LLL;
        return LLL\u0445L\u0445LLL\u0445LLL.status;
    }

    public void setStatus(Status \u0445\u0445LL\u0445\u0445LLL\u0445LLL) {
        \u0445LLL\u0445\u0445LLL\u0445LLL.status = \u0445\u0445LL\u0445\u0445LLL\u0445LLL;
    }

    public String getMask() {
        Alt \u0445\u0445L\u0445\u0445\u0445LLL\u0445LLL;
        return \u0445\u0445L\u0445\u0445\u0445LLL\u0445LLL.mask;
    }

    public void setMask(String \u0445\u0445LLLL\u0445LL\u0445LLL) {
        L\u0445LLLL\u0445LL\u0445LLL.mask = \u0445\u0445LLLL\u0445LL\u0445LLL;
    }

    public String getPassword() {
        Alt \u0445\u0445L\u0445LL\u0445LL\u0445LLL;
        return \u0445\u0445L\u0445LL\u0445LL\u0445LLL.password;
    }

    public void setPassword(String \u0445L\u0445L\u0445L\u0445LL\u0445LLL) {
        \u0445\u0445LL\u0445L\u0445LL\u0445LLL.password = \u0445L\u0445L\u0445L\u0445LL\u0445LLL;
    }

    public String getUsername() {
        Alt L\u0445L\u0445\u0445L\u0445LL\u0445LLL;
        return L\u0445L\u0445\u0445L\u0445LL\u0445LLL.username;
    }

    public static enum Status {
        Working("Working"),
        Banned("Banned"),
        Unchecked("Unchecked"),
        NotWorking("Not Working");

        private final String formatted;

        private Status(String \u0445\u0445L\u0445LLL\u0445L\u0445\u0445L\u0445LL) {
            Status L\u0445L\u0445LLL\u0445L\u0445\u0445L\u0445LL;
            L\u0445L\u0445LLL\u0445L\u0445\u0445L\u0445LL.formatted = \u0445\u0445L\u0445LLL\u0445L\u0445\u0445L\u0445LL;
        }

        public String toFormatted() {
            Status \u0445LLL\u0445LL\u0445L\u0445\u0445L\u0445LL;
            return \u0445LLL\u0445LL\u0445L\u0445\u0445L\u0445LL.formatted;
        }
    }
}

