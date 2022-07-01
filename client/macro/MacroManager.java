/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.macro;

import java.util.ArrayList;
import java.util.List;
import org.Destroy.client.macro.Macro;

public class MacroManager {
    public List<Macro> macros = new ArrayList<Macro>();

    public MacroManager() {
        MacroManager \u0445\u0445\u0445L\u0445L\u0445L\u0445LL\u0445L\u0445L;
    }

    public List<Macro> getMacros() {
        MacroManager L\u0445L\u0445\u0445L\u0445L\u0445LL\u0445L\u0445L;
        return L\u0445L\u0445\u0445L\u0445L\u0445LL\u0445L\u0445L.macros;
    }

    public void addMacro(Macro \u0445\u0445\u0445\u0445\u0445L\u0445L\u0445LL\u0445L\u0445L) {
        MacroManager L\u0445\u0445\u0445\u0445L\u0445L\u0445LL\u0445L\u0445L;
        L\u0445\u0445\u0445\u0445L\u0445L\u0445LL\u0445L\u0445L.macros.add(\u0445\u0445\u0445\u0445\u0445L\u0445L\u0445LL\u0445L\u0445L);
    }

    public void deleteMacroByKey(int \u0445L\u0445LL\u0445\u0445L\u0445LL\u0445L\u0445L) {
        MacroManager LL\u0445LL\u0445\u0445L\u0445LL\u0445L\u0445L;
        LL\u0445LL\u0445\u0445L\u0445LL\u0445L\u0445L.macros.removeIf(LLLL\u0445\u0445\u0445L\u0445LL\u0445L\u0445L -> LLLL\u0445\u0445\u0445L\u0445LL\u0445L\u0445L.getKey() == \u0445L\u0445LL\u0445\u0445L\u0445LL\u0445L\u0445L);
    }
}

