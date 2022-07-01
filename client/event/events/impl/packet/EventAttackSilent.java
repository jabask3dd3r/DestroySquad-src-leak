/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.event.events.impl.packet;

import net.minecraft.entity.Entity;
import org.Destroy.client.event.events.callables.EventCancellable;

public class EventAttackSilent
extends EventCancellable {
    private final Entity targetEntity;

    public EventAttackSilent(Entity \u0445LL\u0445\u0445\u0445LL\u0445L\u0445\u0445LLL) {
        EventAttackSilent LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445LLL;
        LLL\u0445\u0445\u0445LL\u0445L\u0445\u0445LLL.targetEntity = \u0445LL\u0445\u0445\u0445LL\u0445L\u0445\u0445LLL;
    }

    public Entity getTargetEntity() {
        EventAttackSilent \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445LLL;
        return \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445LLL.targetEntity;
    }
}

