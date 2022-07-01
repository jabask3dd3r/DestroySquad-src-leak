/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature;

import com.google.gson.JsonObject;
import java.util.Iterator;
import org.Destroy.client.Destroy;
import org.Destroy.client.event.EventManager;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.hud.ClientSounds;
import org.Destroy.client.feature.impl.hud.Notifications;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.misc.MusicHelper;
import org.Destroy.client.helpers.render.ScreenHelper;
import org.Destroy.client.settings.Configurable;
import org.Destroy.client.settings.Setting;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;

public class Feature
extends Configurable
implements Helper {
    public Type type;
    public boolean state;
    public boolean visible = true;
    public ScreenHelper screenHelper = new ScreenHelper(0.0f, 0.0f);
    private String label;
    private String suffix;
    private int bind;
    private String desc;

    public Feature(String L\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL, String \u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL, Type LL\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL) {
        Feature \u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL;
        \u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.label = L\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL;
        \u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.desc = \u0445\u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL;
        \u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.type = LL\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL;
        \u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.bind = 0;
        \u0445LL\u0445L\u0445L\u0445\u0445L\u0445\u0445LLL.state = false;
    }

    public JsonObject save() {
        Feature \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL;
        JsonObject LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL = new JsonObject();
        LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.addProperty("state", \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.getState());
        LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.addProperty("keyIndex", \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.getBind());
        LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.addProperty("visible", \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.isVisible());
        JsonObject \u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL = new JsonObject();
        Iterator<Setting> \u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL = \u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.getSettings().iterator();
        if (\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.hasNext()) {
            Setting L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL = \u0445L\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.next();
            if (\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.getSettings() != null) {
                if (L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL instanceof BooleanSetting) {
                    \u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.addProperty(L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.getName(), ((BooleanSetting)L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL).getBoolValue());
                } else if (L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL instanceof ListSetting) {
                    \u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.addProperty(L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.getName(), ((ListSetting)L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL).getCurrentMode());
                } else if (L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL instanceof NumberSetting) {
                    \u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.addProperty(L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.getName(), Float.valueOf(((NumberSetting)L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL).getNumberValue()));
                } else if (L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL instanceof ColorSetting) {
                    \u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.addProperty(L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.getName(), ((ColorSetting)L\u0445\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445LLL).getColorValue());
                }
            }
            LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL.add("Settings", \u0445LL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL);
            return null;
        }
        return LLL\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445LLL;
    }

    public void load(JsonObject \u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL) {
        if (\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL != null) {
            Iterator<Setting> L\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL;
            Feature L\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL;
            if (\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.has("state")) {
                L\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.setState(\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.get("state").getAsBoolean());
            }
            if (\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.has("visible")) {
                L\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.setVisible(\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.get("visible").getAsBoolean());
            }
            if (\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.has("keyIndex")) {
                L\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.setBind(\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.get("keyIndex").getAsInt());
            }
            if ((L\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL = L\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.getSettings().iterator()).hasNext()) {
                Setting \u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL = L\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL.next();
                JsonObject LL\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL = \u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.getAsJsonObject("Settings");
                if (\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL == null) {
                    return;
                }
                if (LL\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL == null) {
                    return;
                }
                if (!LL\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.has(\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.getName())) {
                    return;
                }
                if (\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL instanceof BooleanSetting) {
                    ((BooleanSetting)\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL).setBoolValue(LL\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.get(\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.getName()).getAsBoolean());
                } else if (\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL instanceof ListSetting) {
                    ((ListSetting)\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL).setListMode(LL\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.get(\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.getName()).getAsString());
                } else if (\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL instanceof NumberSetting) {
                    ((NumberSetting)\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL).setValueNumber(LL\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.get(\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.getName()).getAsFloat());
                } else if (\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL instanceof ColorSetting) {
                    ((ColorSetting)\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL).setColorValue(LL\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.get(\u0445L\u0445LLL\u0445\u0445\u0445L\u0445\u0445LLL.getName()).getAsInt());
                }
                return;
            }
        }
    }

    public ScreenHelper getScreenHelper() {
        Feature L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL;
        return L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445LLL.screenHelper;
    }

    public String getSuffix() {
        Feature \u0445LLL\u0445L\u0445\u0445\u0445L\u0445\u0445LLL;
        return \u0445LLL\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.suffix == null ? \u0445LLL\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.label : \u0445LLL\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.suffix;
    }

    public void setSuffix(String L\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL) {
        Feature \u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL;
        \u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.suffix = L\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL;
        \u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.suffix = \u0445L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.getLabel() + " - " + L\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445LLL;
    }

    public boolean isVisible() {
        Feature L\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445LLL;
        return L\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.visible;
    }

    public void setVisible(boolean \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445LLL) {
        L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445LLL.visible = \u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445LLL;
    }

    public boolean isHidden() {
        Feature \u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445LLL;
        return !\u0445\u0445LLL\u0445\u0445\u0445\u0445L\u0445\u0445LLL.visible;
    }

    public void setHidden(boolean LLL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445LLL) {
        \u0445\u0445\u0445LL\u0445\u0445\u0445\u0445L\u0445\u0445LLL.visible = !LLL\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445LLL;
    }

    public String getLabel() {
        Feature LL\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445LLL;
        return LL\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445LLL.label;
    }

    public void setLabel(String \u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL) {
        LLLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL.label = \u0445LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL;
    }

    public int getBind() {
        Feature \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL;
        return \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL.bind;
    }

    public void setBind(int L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL) {
        \u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL.bind = L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL;
    }

    public String getDesc() {
        Feature L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL;
        return L\u0445\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445LLL.desc;
    }

    public void setDesc(String \u0445\u0445LLLLLLL\u0445\u0445\u0445LLL) {
        L\u0445LLLLLLL\u0445\u0445\u0445LLL.desc = \u0445\u0445LLLLLLL\u0445\u0445\u0445LLL;
    }

    public Type getType() {
        Feature \u0445\u0445\u0445LLLLLL\u0445\u0445\u0445LLL;
        return \u0445\u0445\u0445LLLLLL\u0445\u0445\u0445LLL.type;
    }

    public void setCategory(Type LL\u0445\u0445LLLLL\u0445\u0445\u0445LLL) {
        \u0445\u0445L\u0445LLLLL\u0445\u0445\u0445LLL.type = LL\u0445\u0445LLLLL\u0445\u0445\u0445LLL;
    }

    public void onEnable() {
        Feature LLLL\u0445LLLL\u0445\u0445\u0445LLL;
        if (Destroy.instance.featureManager.getFeatureByClass(ClientSounds.class).getState()) {
            MusicHelper.playSound("enable.wav");
        }
        EventManager.register(LLLL\u0445LLLL\u0445\u0445\u0445LLL);
        if (!LLLL\u0445LLLL\u0445\u0445\u0445LLL.getLabel().contains("ClickGui") && !LLLL\u0445LLLL\u0445\u0445\u0445LLL.getLabel().contains("Client Font") && !LLLL\u0445LLLL\u0445\u0445\u0445LLL.getLabel().contains("Notifications") && Notifications.state.getBoolValue()) {
            NotificationManager.publicity(LLLL\u0445LLLL\u0445\u0445\u0445LLL.getLabel(), "was \u00a7aenabled\u00a7f!", 1, NotificationType.INFO);
        }
    }

    public void onDisable() {
        Feature \u0445\u0445LL\u0445LLLL\u0445\u0445\u0445LLL;
        if (Destroy.instance.featureManager.getFeatureByClass(ClientSounds.class).getState()) {
            MusicHelper.playSound("disable.wav");
        }
        EventManager.unregister(\u0445\u0445LL\u0445LLLL\u0445\u0445\u0445LLL);
        if (!\u0445\u0445LL\u0445LLLL\u0445\u0445\u0445LLL.getLabel().contains("ClickGui") && !\u0445\u0445LL\u0445LLLL\u0445\u0445\u0445LLL.getLabel().contains("Client Font") && !\u0445\u0445LL\u0445LLLL\u0445\u0445\u0445LLL.getLabel().contains("Notifications") && Notifications.state.getBoolValue()) {
            NotificationManager.publicity(\u0445\u0445LL\u0445LLLL\u0445\u0445\u0445LLL.getLabel(), "was \u00a7cdisabled!\u00a7f", 1, NotificationType.INFO);
        }
    }

    public void toggle() {
        Feature L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL;
        boolean bl2 = L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL.state = !L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL.state;
        if (L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL.state) {
            L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL.onEnable();
        } else {
            L\u0445\u0445L\u0445LLLL\u0445\u0445\u0445LLL.onDisable();
        }
    }

    public boolean getState() {
        Feature \u0445LL\u0445\u0445LLLL\u0445\u0445\u0445LLL;
        return \u0445LL\u0445\u0445LLLL\u0445\u0445\u0445LLL.state;
    }

    public void setState(boolean L\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445LLL) {
        Feature \u0445L\u0445\u0445\u0445LLLL\u0445\u0445\u0445LLL;
        if (L\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445LLL) {
            EventManager.register(\u0445L\u0445\u0445\u0445LLLL\u0445\u0445\u0445LLL);
        } else {
            EventManager.unregister(\u0445L\u0445\u0445\u0445LLLL\u0445\u0445\u0445LLL);
        }
        \u0445L\u0445\u0445\u0445LLLL\u0445\u0445\u0445LLL.state = L\u0445\u0445\u0445\u0445LLLL\u0445\u0445\u0445LLL;
    }
}

