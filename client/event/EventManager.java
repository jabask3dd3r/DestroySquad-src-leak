/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.Event;
import org.Destroy.client.event.events.EventStoppable;
import org.Destroy.client.event.types.Priority;

public class EventManager {
    private static final Map<Class<? extends Event>, List<MethodData>> REGISTRY_MAP = new HashMap<Class<? extends Event>, List<MethodData>>();

    public EventManager() {
        EventManager \u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445\u0445LLL;
    }

    public static void register(Object L\u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445LLL) {
        int L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445LLL = 0;
        Method[] L\u0445L\u0445LL\u0445L\u0445\u0445\u0445\u0445LLL = L\u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445LLL.getClass().getDeclaredMethods();
        int LL\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445LLL = L\u0445L\u0445LL\u0445L\u0445\u0445\u0445\u0445LLL.length;
        if (L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445LLL < LL\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445LLL) {
            Method LL\u0445LLL\u0445L\u0445\u0445\u0445\u0445LLL = L\u0445L\u0445LL\u0445L\u0445\u0445\u0445\u0445LLL[L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445LLL];
            if (LL\u0445LLL\u0445L\u0445\u0445\u0445\u0445LLL == false) {
                EventManager.register(LL\u0445LLL\u0445L\u0445\u0445\u0445\u0445LLL, L\u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445LLL);
            }
            ++L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445LLL;
            return;
        }
    }

    public static void unregister(Object L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL) {
        Iterator<List<MethodData>> LLLLL\u0445\u0445L\u0445\u0445\u0445\u0445LLL = REGISTRY_MAP.values().iterator();
        if (LLLLL\u0445\u0445L\u0445\u0445\u0445\u0445LLL.hasNext()) {
            List<MethodData> LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL = LLLLL\u0445\u0445L\u0445\u0445\u0445\u0445LLL.next();
            LL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL.removeIf(LLLLLLLLLLLL\u0445LL -> LLLLLLLLLLLL\u0445LL.getSource().equals(L\u0445\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445LLL));
            return;
        }
        EventManager.cleanMap(true);
    }

    private static void register(Method \u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL, Object \u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL) {
        Class<?> L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL = \u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL.getParameterTypes()[0];
        final MethodData \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL = new MethodData(\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL, \u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL, \u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL.getAnnotation(EventTarget.class).value());
        if (!\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL.getTarget().isAccessible()) {
            \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL.getTarget().setAccessible(true);
        }
        if (REGISTRY_MAP.containsKey(L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL)) {
            if (!REGISTRY_MAP.get(L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL).contains(\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL)) {
                REGISTRY_MAP.get(L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL).add(\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL);
                EventManager.sortListValue(L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL);
            }
        } else {
            REGISTRY_MAP.put(L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL, (List<MethodData>)new CopyOnWriteArrayList<MethodData>(){
                private static final long serialVersionUID = 666L;
                {
                    1 \u0445L\u0445LL\u0445LLLL\u0445L\u0445\u0445L;
                    \u0445L\u0445LL\u0445LLLL\u0445L\u0445\u0445L.add(\u0445L\u0445LL\u0445LLLL\u0445L\u0445\u0445L.\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445LLL);
                }
            });
        }
    }

    public static void cleanMap(boolean L\u0445LLLLL\u0445\u0445\u0445\u0445\u0445LLL) {
        Iterator<Map.Entry<Class<? extends Event>, List<MethodData>>> LL\u0445LLLL\u0445\u0445\u0445\u0445\u0445LLL = REGISTRY_MAP.entrySet().iterator();
        while (LL\u0445LLLL\u0445\u0445\u0445\u0445\u0445LLL.hasNext()) {
            if (L\u0445LLLLL\u0445\u0445\u0445\u0445\u0445LLL && !LL\u0445LLLL\u0445\u0445\u0445\u0445\u0445LLL.next().getValue().isEmpty()) continue;
            LL\u0445LLLL\u0445\u0445\u0445\u0445\u0445LLL.remove();
            return;
        }
    }

    private static void sortListValue(Class<? extends Event> L\u0445LLL\u0445L\u0445\u0445\u0445\u0445\u0445LLL) {
        CopyOnWriteArrayList<MethodData> \u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445\u0445LLL = new CopyOnWriteArrayList<MethodData>();
        int LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL = 0;
        byte[] \u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL = Priority.VALUE_ARRAY;
        int \u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL = \u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL.length;
        if (LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL < \u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL) {
            byte LLLLL\u0445L\u0445\u0445\u0445\u0445\u0445LLL = \u0445LL\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445LLL[LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL];
            Iterator<MethodData> LL\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL = REGISTRY_MAP.get(L\u0445LLL\u0445L\u0445\u0445\u0445\u0445\u0445LLL).iterator();
            if (LL\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL.hasNext()) {
                MethodData \u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL = LL\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL.next();
                if (\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL.getPriority() == LLLLL\u0445L\u0445\u0445\u0445\u0445\u0445LLL) {
                    \u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445\u0445LLL.add(\u0445\u0445\u0445\u0445\u0445LL\u0445\u0445\u0445\u0445\u0445LLL);
                }
                return;
            }
            ++LLLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLL;
            return;
        }
        REGISTRY_MAP.put(L\u0445LLL\u0445L\u0445\u0445\u0445\u0445\u0445LLL, \u0445\u0445LLL\u0445L\u0445\u0445\u0445\u0445\u0445LLL);
    }

    /*
     * Exception decompiling
     */
    private static boolean isMethodBad(Method \u0445LLLLL\u0445\u0445\u0445\u0445\u0445\u0445LLL, Class<? extends Event> \u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445\u0445LLL) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: While processing lbl2 : IF_ICMPNE - null : Stack underflow
         *     at org.benf.cfr.reader.bytecode.analysis.stack.StackSim.getChange(StackSim.java:81)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:242)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1559)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:434)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static Event call(Event LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL) {
        List<MethodData> L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL = REGISTRY_MAP.get(LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL.getClass());
        if (L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL != null) {
            if (LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL instanceof EventStoppable) {
                EventStoppable LLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL = (EventStoppable)LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL;
                Iterator<MethodData> \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL = L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL.iterator();
                if (\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL.hasNext()) {
                    MethodData L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL = \u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL.next();
                    EventManager.invoke(L\u0445\u0445L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL, LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL);
                    if (!LLL\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL.isStopped()) {
                        return null;
                    }
                }
            } else {
                Iterator<MethodData> iterator = L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL.iterator();
                if (iterator.hasNext()) {
                    MethodData L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL = iterator.next();
                    EventManager.invoke(L\u0445L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL, LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL);
                    return null;
                }
            }
        }
        return LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445LLL;
    }

    private static void invoke(MethodData L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL, Event \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL) {
        try {
            L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL.getTarget().invoke(L\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL.getSource(), \u0445\u0445LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445LLL) {
            // empty catch block
        }
    }

    private static final class MethodData {
        private final Object source;
        private final Method target;
        private final byte priority;

        public MethodData(Object \u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LLL, Method LL\u0445\u0445LLLL\u0445\u0445\u0445\u0445LLL, byte \u0445L\u0445\u0445LLLL\u0445\u0445\u0445\u0445LLL) {
            MethodData L\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LLL;
            L\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LLL.source = \u0445\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LLL;
            L\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LLL.target = LL\u0445\u0445LLLL\u0445\u0445\u0445\u0445LLL;
            L\u0445L\u0445LLLL\u0445\u0445\u0445\u0445LLL.priority = \u0445L\u0445\u0445LLLL\u0445\u0445\u0445\u0445LLL;
        }

        public Object getSource() {
            MethodData \u0445\u0445LL\u0445LLL\u0445\u0445\u0445\u0445LLL;
            return \u0445\u0445LL\u0445LLL\u0445\u0445\u0445\u0445LLL.source;
        }

        public Method getTarget() {
            MethodData L\u0445\u0445L\u0445LLL\u0445\u0445\u0445\u0445LLL;
            return L\u0445\u0445L\u0445LLL\u0445\u0445\u0445\u0445LLL.target;
        }

        public byte getPriority() {
            MethodData \u0445LL\u0445\u0445LLL\u0445\u0445\u0445\u0445LLL;
            return \u0445LL\u0445\u0445LLL\u0445\u0445\u0445\u0445LLL.priority;
        }
    }
}

