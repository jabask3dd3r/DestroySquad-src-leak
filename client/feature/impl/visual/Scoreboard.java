/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import net.minecraft.client.renderer.GlStateManager;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRenderScoreboard;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class Scoreboard
extends Feature {
    public static BooleanSetting noScore;
    public static BooleanSetting scoreboardPoints;
    public NumberSetting x;
    public NumberSetting y;

    public Scoreboard() {
        super("NoScoreboard", "Allows you to set up a scorboard on the server", Type.Visuals);
        Scoreboard LL\u0445LL\u0445LL\u0445LL;
        noScore = new BooleanSetting("No Scoreboard", true, () -> false);
        LL\u0445LL\u0445LL\u0445LL.x = new NumberSetting("Scoreboard X", 0.0f, -1000.0f, 1000.0f, 1.0f, () -> !noScore.getBoolValue());
        LL\u0445LL\u0445LL\u0445LL.y = new NumberSetting("Scoreboard Y", 0.0f, -500.0f, 500.0f, 1.0f, () -> !noScore.getBoolValue());
        LL\u0445LL\u0445LL\u0445LL.addSettings(noScore, scoreboardPoints, LL\u0445LL\u0445LL\u0445LL.x, LL\u0445LL\u0445LL\u0445LL.y);
    }

    @EventTarget
    public void onRenderScoreboard(EventRenderScoreboard \u0445LL\u0445L\u0445LL\u0445LL) {
        Scoreboard LLL\u0445L\u0445LL\u0445LL;
        if (\u0445LL\u0445L\u0445LL\u0445LL.isPre()) {
            GlStateManager.translate(-LLL\u0445L\u0445LL\u0445LL.x.getNumberValue(), LLL\u0445L\u0445LL\u0445LL.y.getNumberValue(), 12.0f);
        } else {
            GlStateManager.translate(LLL\u0445L\u0445LL\u0445LL.x.getNumberValue(), -LLL\u0445L\u0445LL\u0445LL.y.getNumberValue(), 12.0f);
        }
    }

    static {
        scoreboardPoints = new BooleanSetting("Points", false, () -> true);
    }
}

