/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.Destroy.client.Destroy;
import org.Destroy.client.helpers.input.MouseHelper;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.ScreenHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.settings.config.Config;
import org.Destroy.client.settings.config.ConfigManager;
import org.Destroy.client.ui.button.ConfigGuiButton;
import org.Destroy.client.ui.button.ImageButton;
import org.Destroy.client.ui.font.MCFontRenderer;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiConfig
extends GuiScreen {
    public static GuiTextField search;
    public static Config selectedConfig;
    public ScreenHelper screenHelper;
    protected ArrayList<ImageButton> imageButtons = new ArrayList();
    private int width;
    private int height;
    private float scrollOffset;

    public GuiConfig() {
        GuiConfig \u0445LLLLL\u0445LLLL\u0445LLL;
        \u0445LLLLL\u0445LLLL\u0445LLL.screenHelper = new ScreenHelper(0.0f, 0.0f);
    }

    @Override
    protected void actionPerformed(GuiButton L\u0445\u0445LLL\u0445LLLL\u0445LLL) throws IOException {
        GuiConfig \u0445L\u0445LLL\u0445LLLL\u0445LLL;
        if (L\u0445\u0445LLL\u0445LLLL\u0445LLL.id == 1) {
            Destroy.instance.configManager.saveConfig(search.getText());
            ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "saved config: " + (Object)((Object)ChatFormatting.RED) + "\"" + search.getText() + "\"");
            NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "created config: " + (Object)((Object)ChatFormatting.RED) + "\"" + search.getText() + "\"", 4, NotificationType.SUCCESS);
            ConfigManager.getLoadedConfigs().clear();
            Destroy.instance.configManager.load();
            search.setFocused(false);
            search.setText("");
        }
        if (selectedConfig != null) {
            if (L\u0445\u0445LLL\u0445LLLL\u0445LLL.id == 2) {
                if (Destroy.instance.configManager.loadConfig(selectedConfig.getName())) {
                    ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "loaded config: " + (Object)((Object)ChatFormatting.RED) + "\"" + selectedConfig.getName() + "\"");
                    NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "loaded config: " + (Object)((Object)ChatFormatting.RED) + "\"" + selectedConfig.getName() + "\"", 4, NotificationType.SUCCESS);
                } else {
                    ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "load config: " + (Object)((Object)ChatFormatting.RED) + "\"" + selectedConfig.getName() + "\"");
                    NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "load config: " + (Object)((Object)ChatFormatting.RED) + "\"" + selectedConfig.getName() + "\"", 4, NotificationType.ERROR);
                }
            } else if (L\u0445\u0445LLL\u0445LLLL\u0445LLL.id == 3) {
                if (Destroy.instance.configManager.saveConfig(selectedConfig.getName())) {
                    ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "saved config: " + (Object)((Object)ChatFormatting.RED) + "\"" + selectedConfig.getName() + "\"");
                    NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "saved config: " + (Object)((Object)ChatFormatting.RED) + "\"" + selectedConfig.getName() + "\"", 4, NotificationType.SUCCESS);
                    ConfigManager.getLoadedConfigs().clear();
                    Destroy.instance.configManager.load();
                } else {
                    ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "to save config: " + (Object)((Object)ChatFormatting.RED) + "\"" + search.getText() + "\"");
                    NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "to save config: " + (Object)((Object)ChatFormatting.RED) + "\"" + search.getText() + "\"", 4, NotificationType.ERROR);
                }
            } else if (L\u0445\u0445LLL\u0445LLLL\u0445LLL.id == 4) {
                if (Destroy.instance.configManager.deleteConfig(selectedConfig.getName())) {
                    ChatHelper.addChatMessage((Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "deleted config: " + (Object)((Object)ChatFormatting.RED) + "\"" + selectedConfig.getName() + "\"");
                    NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.GREEN) + "Successfully " + (Object)((Object)ChatFormatting.WHITE) + "deleted config: " + (Object)((Object)ChatFormatting.RED) + "\"" + selectedConfig.getName() + "\"", 4, NotificationType.SUCCESS);
                } else {
                    ChatHelper.addChatMessage((Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "to delete config: " + (Object)((Object)ChatFormatting.RED) + "\"" + selectedConfig.getName() + "\"");
                    NotificationManager.publicity("Config", (Object)((Object)ChatFormatting.RED) + "Failed " + (Object)((Object)ChatFormatting.WHITE) + "to delete config: " + (Object)((Object)ChatFormatting.RED) + "\"" + selectedConfig.getName() + "\"", 4, NotificationType.ERROR);
                }
            }
        }
        super.actionPerformed(L\u0445\u0445LLL\u0445LLLL\u0445LLL);
    }

    private boolean isHoveredConfig(int LLLL\u0445L\u0445LLLL\u0445LLL, int \u0445LLL\u0445L\u0445LLLL\u0445LLL, int L\u0445LL\u0445L\u0445LLLL\u0445LLL, int \u0445\u0445LL\u0445L\u0445LLLL\u0445LLL, int LL\u0445L\u0445L\u0445LLLL\u0445LLL, int \u0445L\u0445L\u0445L\u0445LLLL\u0445LLL) {
        return MouseHelper.isHovered(LLLL\u0445L\u0445LLLL\u0445LLL, \u0445LLL\u0445L\u0445LLLL\u0445LLL, LLLL\u0445L\u0445LLLL\u0445LLL + L\u0445LL\u0445L\u0445LLLL\u0445LLL, \u0445LLL\u0445L\u0445LLLL\u0445LLL + \u0445\u0445LL\u0445L\u0445LLLL\u0445LLL, LL\u0445L\u0445L\u0445LLLL\u0445LLL, \u0445L\u0445L\u0445L\u0445LLLL\u0445LLL);
    }

    @Override
    public void initGui() {
        GuiConfig L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL;
        L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.screenHelper = new ScreenHelper(0.0f, 0.0f);
        ScaledResolution \u0445\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL = new ScaledResolution(L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.mc);
        L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.width = \u0445\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.getScaledWidth() / 2;
        L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.height = \u0445\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.getScaledHeight() / 2;
        search = new GuiTextField(228, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.mc.fontRendererObj, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.width - 100, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.height + 62, 85, 13);
        L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.buttonList.add(new ConfigGuiButton(1, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.width - 105, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.height + 102, "Create"));
        L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.buttonList.add(new ConfigGuiButton(2, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.width - 40, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.height - 48, "Load"));
        L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.buttonList.add(new ConfigGuiButton(3, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.width - 40, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.height - 65, "Save"));
        L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.buttonList.add(new ConfigGuiButton(4, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.width - 40, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.height - 82, "Delete"));
        L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.imageButtons.clear();
        L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.imageButtons.add(new ImageButton(new ResourceLocation("neverhook/close-button.png"), L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.width + 106, L\u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLL.height - 135, 8, 8, "", 19));
        super.initGui();
    }

    @Override
    public void drawScreen(int L\u0445LL\u0445\u0445\u0445LLLL\u0445LLL, int \u0445\u0445LL\u0445\u0445\u0445LLLL\u0445LLL, float LL\u0445L\u0445\u0445\u0445LLLL\u0445LLL) {
        GuiConfig \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL;
        ScaledResolution \u0445L\u0445L\u0445\u0445\u0445LLLL\u0445LLL = new ScaledResolution(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.mc);
        \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.drawWorldBackground(0);
        \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.screenHelper.interpolate(\u0445L\u0445L\u0445\u0445\u0445LLLL\u0445LLL.getScaledWidth(), \u0445L\u0445L\u0445\u0445\u0445LLLL\u0445LLL.getScaledHeight(), 6.0);
        GL11.glPushMatrix();
        Iterator<Object> LL\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL = Destroy.instance.configManager.getContents().iterator();
        if (LL\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL.hasNext()) {
            Config LL\u0445\u0445L\u0445\u0445LLLL\u0445LLL = (Config)LL\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL.next();
            if (LL\u0445\u0445L\u0445\u0445LLLL\u0445LLL != null && Mouse.hasWheel() && \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.isHoveredConfig(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width - 100, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height - 122, 151, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height + 59, L\u0445LL\u0445\u0445\u0445LLLL\u0445LLL, \u0445\u0445LL\u0445\u0445\u0445LLLL\u0445LLL)) {
                int \u0445\u0445L\u0445L\u0445\u0445LLLL\u0445LLL = Mouse.getDWheel();
                if (\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445LLL < 0) {
                    \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.scrollOffset += 13.0f;
                    if (\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.scrollOffset < 0.0f) {
                        \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.scrollOffset = 0.0f;
                    }
                } else if (\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445LLL > 0) {
                    \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.scrollOffset -= 13.0f;
                    if (\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.scrollOffset < 0.0f) {
                        \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.scrollOffset = 0.0f;
                    }
                }
            }
            return;
        }
        GlStateManager.pushMatrix();
        RectHelper.drawSkeetRectWithoutBorder(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width - 70, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height - 80, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width + 80, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height + 20);
        RectHelper.drawSkeetButton(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width - 70, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height - 80, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width + 20, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height + 90);
        RenderHelper.drawImage(new ResourceLocation("neverhook/skeet.png"), \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width - 110, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height - 140, 230.0f, 1.0f, Color.WHITE);
        \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.mc.circleregular.drawStringWithOutline("Config System", \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width - 100, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height - 135, -1);
        search.drawTextBox();
        if (search.getText().isEmpty() && !search.isFocused()) {
            MCFontRenderer.drawStringWithOutline(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.mc.fontRendererObj, "...", (float)(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width - 97), (float)(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height + 65), PaletteHelper.getColor(200));
        }
        if ((LL\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL = \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.imageButtons.iterator()).hasNext()) {
            ImageButton \u0445L\u0445\u0445L\u0445\u0445LLLL\u0445LLL = (ImageButton)LL\u0445\u0445\u0445\u0445\u0445LLLL\u0445LLL.next();
            \u0445L\u0445\u0445L\u0445\u0445LLLL\u0445LLL.draw(L\u0445LL\u0445\u0445\u0445LLLL\u0445LLL, \u0445\u0445LL\u0445\u0445\u0445LLLL\u0445LLL, Color.WHITE);
            if (Mouse.isButtonDown(0)) {
                \u0445L\u0445\u0445L\u0445\u0445LLLL\u0445LLL.onClick(L\u0445LL\u0445\u0445\u0445LLLL\u0445LLL, \u0445\u0445LL\u0445\u0445\u0445LLLL\u0445LLL);
            }
            return;
        }
        int L\u0445\u0445L\u0445\u0445\u0445LLLL\u0445LLL = 0;
        GL11.glEnable(3089);
        RenderHelper.scissorRect(0.0f, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height - 119, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height + 60);
        Iterator iterator = Destroy.instance.configManager.getContents().iterator();
        if (iterator.hasNext()) {
            Config LLLL\u0445\u0445\u0445LLLL\u0445LLL = (Config)iterator.next();
            if (LLLL\u0445\u0445\u0445LLLL\u0445LLL != null) {
                int \u0445\u0445\u0445\u0445L\u0445\u0445LLLL\u0445LLL;
                if (\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.isHoveredConfig(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width - 96, (int)((float)(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height - 117 + L\u0445\u0445L\u0445\u0445\u0445LLLL\u0445LLL) - \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.scrollOffset), \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.mc.fontRendererObj.getStringWidth(LLLL\u0445\u0445\u0445LLLL\u0445LLL.getName()) + 5, 14, L\u0445LL\u0445\u0445\u0445LLLL\u0445LLL, \u0445\u0445LL\u0445\u0445\u0445LLLL\u0445LLL)) {
                    int L\u0445\u0445\u0445L\u0445\u0445LLLL\u0445LLL = -1;
                    if (Mouse.isButtonDown(0)) {
                        selectedConfig = new Config(LLLL\u0445\u0445\u0445LLLL\u0445LLL.getName());
                    }
                } else {
                    \u0445\u0445\u0445\u0445L\u0445\u0445LLLL\u0445LLL = PaletteHelper.getColor(200);
                }
                if (selectedConfig != null && LLLL\u0445\u0445\u0445LLLL\u0445LLL.getName().equals(selectedConfig.getName())) {
                    RectHelper.drawBorder(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width - 98, (float)(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height - 119 + L\u0445\u0445L\u0445\u0445\u0445LLLL\u0445LLL) - \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.scrollOffset, \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width + \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.mc.fontRendererObj.getStringWidth(LLLL\u0445\u0445\u0445LLLL\u0445LLL.getName()) - 90, (float)(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height - 107 + L\u0445\u0445L\u0445\u0445\u0445LLLL\u0445LLL) - \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.scrollOffset, 0.65f, new Color(255, 255, 255, 75).getRGB(), new Color(0, 0, 0, 255).getRGB(), true);
                }
                \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.mc.fontRendererObj.drawStringWithOutline(LLLL\u0445\u0445\u0445LLLL\u0445LLL.getName(), \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.width - 95, (float)(\u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.height - 117 + L\u0445\u0445L\u0445\u0445\u0445LLLL\u0445LLL) - \u0445LLL\u0445\u0445\u0445LLLL\u0445LLL.scrollOffset, \u0445\u0445\u0445\u0445L\u0445\u0445LLLL\u0445LLL);
                L\u0445\u0445L\u0445\u0445\u0445LLLL\u0445LLL += 15;
            }
            return;
        }
        GL11.glDisable(3089);
        GlStateManager.popMatrix();
        GL11.glPopMatrix();
        super.drawScreen(L\u0445LL\u0445\u0445\u0445LLLL\u0445LLL, \u0445\u0445LL\u0445\u0445\u0445LLLL\u0445LLL, LL\u0445L\u0445\u0445\u0445LLLL\u0445LLL);
    }

    @Override
    protected void mouseReleased(int \u0445L\u0445LLLL\u0445LLL\u0445LLL, int L\u0445\u0445LLLL\u0445LLL\u0445LLL, int \u0445\u0445\u0445LLLL\u0445LLL\u0445LLL) {
        GuiConfig LL\u0445LLLL\u0445LLL\u0445LLL;
        super.mouseReleased(\u0445L\u0445LLLL\u0445LLL\u0445LLL, L\u0445\u0445LLLL\u0445LLL\u0445LLL, \u0445\u0445\u0445LLLL\u0445LLL\u0445LLL);
    }

    @Override
    protected void mouseClicked(int \u0445LLL\u0445LL\u0445LLL\u0445LLL, int L\u0445LL\u0445LL\u0445LLL\u0445LLL, int \u0445\u0445LL\u0445LL\u0445LLL\u0445LLL) throws IOException {
        GuiConfig LLLL\u0445LL\u0445LLL\u0445LLL;
        search.mouseClicked(\u0445LLL\u0445LL\u0445LLL\u0445LLL, L\u0445LL\u0445LL\u0445LLL\u0445LLL, \u0445\u0445LL\u0445LL\u0445LLL\u0445LLL);
        if (LLLL\u0445LL\u0445LLL\u0445LLL.scrollOffset < 0.0f) {
            LLLL\u0445LL\u0445LLL\u0445LLL.scrollOffset = 0.0f;
        }
        super.mouseClicked(\u0445LLL\u0445LL\u0445LLL\u0445LLL, L\u0445LL\u0445LL\u0445LLL\u0445LLL, \u0445\u0445LL\u0445LL\u0445LLL\u0445LLL);
    }

    @Override
    protected void keyTyped(char LLLLL\u0445L\u0445LLL\u0445LLL, int \u0445LLLL\u0445L\u0445LLL\u0445LLL) throws IOException {
        GuiConfig \u0445\u0445\u0445\u0445\u0445LL\u0445LLL\u0445LLL;
        Iterator \u0445L\u0445LL\u0445L\u0445LLL\u0445LLL = Destroy.instance.configManager.getContents().iterator();
        if (\u0445L\u0445LL\u0445L\u0445LLL\u0445LLL.hasNext()) {
            Config \u0445L\u0445\u0445\u0445LL\u0445LLL\u0445LLL = (Config)\u0445L\u0445LL\u0445L\u0445LLL\u0445LLL.next();
            if (\u0445L\u0445\u0445\u0445LL\u0445LLL\u0445LLL != null) {
                if (\u0445LLLL\u0445L\u0445LLL\u0445LLL == 200) {
                    \u0445\u0445\u0445\u0445\u0445LL\u0445LLL\u0445LLL.scrollOffset += 13.0f;
                } else if (\u0445LLLL\u0445L\u0445LLL\u0445LLL == 208) {
                    \u0445\u0445\u0445\u0445\u0445LL\u0445LLL\u0445LLL.scrollOffset -= 13.0f;
                }
                if (\u0445\u0445\u0445\u0445\u0445LL\u0445LLL\u0445LLL.scrollOffset < 0.0f) {
                    \u0445\u0445\u0445\u0445\u0445LL\u0445LLL\u0445LLL.scrollOffset = 0.0f;
                }
            }
            return;
        }
        search.textboxKeyTyped(LLLLL\u0445L\u0445LLL\u0445LLL, \u0445LLLL\u0445L\u0445LLL\u0445LLL);
        search.setText(search.getText().replace(" ", ""));
        if ((LLLLL\u0445L\u0445LLL\u0445LLL == '\t' || LLLLL\u0445L\u0445LLL\u0445LLL == '\r') && search.isFocused()) {
            search.setFocused(!search.isFocused());
        }
        try {
            super.keyTyped(LLLLL\u0445L\u0445LLL\u0445LLL, \u0445LLLL\u0445L\u0445LLL\u0445LLL);
        }
        catch (IOException L\u0445\u0445\u0445\u0445LL\u0445LLL\u0445LLL) {
            L\u0445\u0445\u0445\u0445LL\u0445LLL\u0445LLL.printStackTrace();
        }
        super.keyTyped(LLLLL\u0445L\u0445LLL\u0445LLL, \u0445LLLL\u0445L\u0445LLL\u0445LLL);
    }

    @Override
    public void onGuiClosed() {
        GuiConfig LLL\u0445L\u0445L\u0445LLL\u0445LLL;
        selectedConfig = null;
        super.onGuiClosed();
    }

    public int getWidth() {
        GuiConfig \u0445\u0445L\u0445L\u0445L\u0445LLL\u0445LLL;
        return \u0445\u0445L\u0445L\u0445L\u0445LLL\u0445LLL.width;
    }

    public void setWidth(int LLLL\u0445\u0445L\u0445LLL\u0445LLL) {
        \u0445\u0445\u0445\u0445L\u0445L\u0445LLL\u0445LLL.width = LLLL\u0445\u0445L\u0445LLL\u0445LLL;
    }

    public int getHeight() {
        GuiConfig LL\u0445L\u0445\u0445L\u0445LLL\u0445LLL;
        return LL\u0445L\u0445\u0445L\u0445LLL\u0445LLL.height;
    }

    public void setHeight(int \u0445LL\u0445\u0445\u0445L\u0445LLL\u0445LLL) {
        LLL\u0445\u0445\u0445L\u0445LLL\u0445LLL.height = \u0445LL\u0445\u0445\u0445L\u0445LLL\u0445LLL;
    }

    static {
        selectedConfig = null;
    }
}

