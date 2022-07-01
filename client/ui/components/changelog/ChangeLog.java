/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.changelog;

import org.Destroy.client.ui.components.changelog.ChangeType;

public class ChangeLog {
    protected String changeName;
    protected ChangeType type;

    public ChangeLog(String L\u0445\u0445LL\u0445LL\u0445\u0445\u0445LL, ChangeType \u0445\u0445\u0445LL\u0445LL\u0445\u0445\u0445LL) {
        ChangeLog \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL;
        \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName = L\u0445\u0445LL\u0445LL\u0445\u0445\u0445LL;
        \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.type = \u0445\u0445\u0445LL\u0445LL\u0445\u0445\u0445LL;
        switch (\u0445\u0445\u0445LL\u0445LL\u0445\u0445\u0445LL) {
            case NEW: {
                \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName = "    \u00a77[\u00a76!\u00a77] New \u00a7f" + \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName;
                break;
            }
            case ADD: {
                \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName = "    \u00a77[\u00a7a+\u00a77] Added \u00a7f" + \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName;
                break;
            }
            case RECODE: {
                \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName = "    \u00a77[\u00a79*\u00a77] Recoded \u00a7f" + \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName;
                break;
            }
            case IMPROVED: {
                \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName = "    \u00a77[\u00a7d/\u00a77] Improved \u00a7f" + \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName;
                break;
            }
            case DELETE: {
                \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName = "    \u00a77[\u00a7c-\u00a77] Deleted \u00a7f" + \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName;
                break;
            }
            case FIXED: {
                \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName = "    \u00a77[\u00a7b/\u00a77] Fixed \u00a7f" + \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName;
                break;
            }
            case MOVED: {
                \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName = "    \u00a77[\u00a79->\u00a77] Moved \u00a7f" + \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName;
                break;
            }
            case RENAMED: {
                \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName = "    \u00a77[\u00a79!\u00a77] Renamed \u00a7f" + \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName;
                break;
            }
            case NONE: {
                \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName = " " + \u0445L\u0445LL\u0445LL\u0445\u0445\u0445LL.changeName;
            }
        }
    }

    public String getLogName() {
        ChangeLog LL\u0445\u0445L\u0445LL\u0445\u0445\u0445LL;
        return LL\u0445\u0445L\u0445LL\u0445\u0445\u0445LL.changeName;
    }

    public ChangeType getType() {
        ChangeLog \u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LL;
        return \u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LL.type;
    }
}

