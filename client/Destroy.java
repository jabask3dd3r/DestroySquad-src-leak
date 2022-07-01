/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client;

import java.io.IOException;
import java.util.Iterator;
import org.Destroy.client.cmd.CommandManager;
import org.Destroy.client.components.DiscordRPC;
import org.Destroy.client.components.SplashProgress;
import org.Destroy.client.event.EventManager;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.game.EventShutdownClient;
import org.Destroy.client.event.events.impl.input.EventInputKey;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.FeatureManager;
import org.Destroy.client.files.FileManager;
import org.Destroy.client.files.impl.FriendConfig;
import org.Destroy.client.files.impl.HudConfig;
import org.Destroy.client.files.impl.MacroConfig;
import org.Destroy.client.files.impl.XrayConfig;
import org.Destroy.client.friend.FriendManager;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.math.RotationHelper;
import org.Destroy.client.helpers.render.BlurUtil;
import org.Destroy.client.macro.Macro;
import org.Destroy.client.macro.MacroManager;
import org.Destroy.client.settings.config.ConfigManager;
import org.Destroy.client.ui.GuiCapeSelector;
import org.Destroy.client.ui.clickgui.ClickGuiScreen;
import org.Destroy.client.ui.components.changelog.ChangeManager;
import org.Destroy.client.ui.components.draggable.DraggableManager;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import viamcp.ViaMCP;

public class Destroy
implements Helper {
    public static Destroy instance = new Destroy();
    public String name = "Destroy";
    public String type = "Squad -";
    public String version = "https://vk.com/destroy_client";
    public FeatureManager featureManager = new FeatureManager();
    public ClickGuiScreen clickGui;
    public org.Destroy.client.ui.newclickgui.ClickGuiScreen newClickGui;
    public CommandManager commandManager;
    public ConfigManager configManager;
    public MacroManager macroManager;
    public FileManager fileManager;
    public DraggableManager draggableManager;
    public FriendManager friendManager;
    public RotationHelper.Rotation rotation;
    public BlurUtil blurUtil;
    public ChangeManager changeManager;

    public Destroy() {
        Destroy \u0445LLLLL\u0445LL\u0445\u0445\u0445\u0445\u0445L;
    }

    public void load() throws IOException {
        Destroy \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L;
        SplashProgress.setProgress(1);
        Display.setTitle(\u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.name + " " + \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.type + " " + \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.version);
        new DiscordRPC().init();
        Iterator<Feature> \u0445LL\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L22 = Destroy.instance.featureManager.features.iterator();
        if (\u0445LL\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L22.hasNext()) {
            Feature L\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L = \u0445LL\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L22.next();
            if (L\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.getState()) {
                // empty if block
            }
            return;
        }
        GuiCapeSelector.Selector.setCapeName("neverhookcape3");
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.fileManager = new FileManager();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.fileManager.loadFiles();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.featureManager = new FeatureManager();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.clickGui = new ClickGuiScreen();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.newClickGui = new org.Destroy.client.ui.newclickgui.ClickGuiScreen();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.commandManager = new CommandManager();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.configManager = new ConfigManager();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.macroManager = new MacroManager();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.draggableManager = new DraggableManager();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.friendManager = new FriendManager();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.rotation = new RotationHelper.Rotation();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.blurUtil = new BlurUtil();
        \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.changeManager = new ChangeManager();
        try {
            ViaMCP.getInstance().start();
        }
        catch (Exception \u0445LL\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L22) {
            // empty catch block
        }
        try {
            \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.fileManager.getFile(FriendConfig.class).loadFile();
        }
        catch (Exception \u0445LL\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L22) {
            // empty catch block
        }
        try {
            \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.fileManager.getFile(MacroConfig.class).loadFile();
        }
        catch (Exception \u0445LL\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L22) {
            // empty catch block
        }
        try {
            \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.fileManager.getFile(HudConfig.class).loadFile();
        }
        catch (Exception \u0445LL\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L22) {
            // empty catch block
        }
        try {
            \u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.fileManager.getFile(XrayConfig.class).loadFile();
        }
        catch (Exception \u0445LL\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L22) {
            // empty catch block
        }
        EventManager.register(\u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L.rotation);
        EventManager.register(\u0445\u0445\u0445LLL\u0445LL\u0445\u0445\u0445\u0445\u0445L);
    }

    @EventTarget
    public void shutDown(EventShutdownClient \u0445L\u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L) {
        Destroy LL\u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L;
        EventManager.unregister(LL\u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L);
        LL\u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.fileManager = new FileManager();
        LL\u0445\u0445LL\u0445LL\u0445\u0445\u0445\u0445\u0445L.fileManager.saveFiles();
        new DiscordRPC().shutdown();
    }

    @EventTarget
    public void onInputKey(EventInputKey L\u0445\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L) {
        Destroy \u0445L\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L;
        Iterator<Object> \u0445LL\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L = \u0445L\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L.featureManager.getFeatureList().iterator();
        if (\u0445LL\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L.hasNext()) {
            Feature \u0445\u0445LL\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L = \u0445LL\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L.next();
            if (\u0445\u0445LL\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L.getBind() == L\u0445\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L.getKey()) {
                \u0445\u0445LL\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L.toggle();
            }
            return;
        }
        \u0445LL\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L = \u0445L\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L.macroManager.getMacros().iterator();
        if (\u0445LL\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L.hasNext()) {
            Macro LL\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L = (Macro)\u0445LL\u0445\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L.next();
            if (LL\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L.getKey() == Keyboard.getEventKey() && Destroy.mc.player.getHealth() > 0.0f && Destroy.mc.player != null) {
                Destroy.mc.player.sendChatMessage(LL\u0445L\u0445L\u0445LL\u0445\u0445\u0445\u0445\u0445L.getValue());
            }
            return;
        }
    }
}

