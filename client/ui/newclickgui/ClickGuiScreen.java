/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.newclickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.Scrollbar;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.render.ScreenHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.ui.button.ImageButton;
import org.Destroy.client.ui.clickgui.GuiSearcher;
import org.Destroy.client.ui.newclickgui.FeaturePanel;
import org.Destroy.client.ui.newclickgui.Panel;
import org.Destroy.client.ui.newclickgui.Theme;
import org.Destroy.client.ui.newclickgui.settings.Component;
import org.Destroy.client.ui.newclickgui.settings.KeybindButton;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class ClickGuiScreen
extends GuiScreen {
    public static GuiSearcher search;
    public ArrayList<Panel> panels = new ArrayList();
    public Theme hud = new Theme();
    public boolean exit = false;
    public boolean usingSetting = false;
    public int x = 30;
    public int y = 0;
    public ScreenHelper screenHelper;
    public ScreenHelper screenHelperSetting;
    public Scrollbar scrollbar = new Scrollbar();
    protected ArrayList<ImageButton> imageButtons = new ArrayList();

    public ClickGuiScreen() {
        ClickGuiScreen LLLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL;
        Type[] L\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL = Type.values();
        int \u0445\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL = L\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL.length;
        int LL\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LL = 0;
        if (LL\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LL < \u0445\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL) {
            Type \u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445\u0445LL = L\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL[LL\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LL];
            LLLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL.panels.add(new Panel(\u0445\u0445\u0445\u0445LL\u0445\u0445LL\u0445\u0445\u0445LL, LLLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL.x, LLLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL.y));
            LLLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL.y += LLLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL.height + 30;
            ++LL\u0445L\u0445L\u0445\u0445LL\u0445\u0445\u0445LL;
            throw null;
        }
        LLLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL.screenHelper = new ScreenHelper(0.0f, 0.0f);
        LLLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LL.screenHelperSetting = new ScreenHelper(0.0f, 0.0f);
    }

    @Override
    public void onGuiClosed() {
        ClickGuiScreen LLL\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LL;
        LLL\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LL.mc.entityRenderer.theShaderGroup = null;
        super.onGuiClosed();
    }

    @Override
    public void drawScreen(int LLLL\u0445LLL\u0445L\u0445\u0445\u0445LL, int \u0445LLL\u0445LLL\u0445L\u0445\u0445\u0445LL, float L\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL) {
        ClickGuiScreen \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL;
        ScaledResolution \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL = new ScaledResolution(\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.mc);
        if (!\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.exit && !\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.usingSetting) {
            \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.screenHelper.interpolate(\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth(), \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight(), 6.0);
        }
        Color LL\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL = Color.WHITE;
        Color \u0445L\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL = new Color(ClickGui.color.getColorValue());
        Color L\u0445\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL = new Color(ClickGui.colorTwo.getColorValue());
        double \u0445\u0445\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL = ClickGui.speed.getNumberValue();
        switch (ClickGui.clickGuiColor.currentMode) {
            case "Client": {
                LL\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL = ClientHelper.getClientColor();
                break;
            }
            case "Fade": {
                LL\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL = new Color(ClickGui.color.getColorValue());
                break;
            }
            case "Astolfo": {
                LL\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL = PaletteHelper.astolfo(true, \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.width);
                break;
            }
            case "Color Two": {
                LL\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL = new Color(PaletteHelper.fadeColor(\u0445L\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL.getRGB(), L\u0445\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445\u0445\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL / \u0445\u0445\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL + (double)((long)\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.height * 6L / 60L * 2L)) % 2.0 - 1.0)));
                break;
            }
            case "Rainbow": {
                LL\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL = PaletteHelper.rainbow(300, 1.0f, 1.0f);
                break;
            }
            case "Static": {
                LL\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL = \u0445L\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL;
            }
        }
        float LLL\u0445\u0445LLL\u0445L\u0445\u0445\u0445LL = 0.0f;
        Iterator<Panel> LL\u0445LL\u0445LL\u0445L\u0445\u0445\u0445LL = \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.panels.iterator();
        if (LL\u0445LL\u0445LL\u0445L\u0445\u0445\u0445LL.hasNext()) {
            Panel LLL\u0445LLLL\u0445L\u0445\u0445\u0445LL = LL\u0445LL\u0445LL\u0445L\u0445\u0445\u0445LL.next();
            if (!LLL\u0445LLLL\u0445L\u0445\u0445\u0445LL.isOpen()) {
                LLL\u0445LLLL\u0445L\u0445\u0445\u0445LL.x = 20;
                LLL\u0445LLLL\u0445L\u0445\u0445\u0445LL.y = (int)((float)\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.y + LLL\u0445\u0445LLL\u0445L\u0445\u0445\u0445LL);
                LLL\u0445\u0445LLL\u0445L\u0445\u0445\u0445LL += 30.0f;
            } else {
                LLL\u0445LLLL\u0445L\u0445\u0445\u0445LL.x = 140;
                int \u0445\u0445\u0445LLLLL\u0445L\u0445\u0445\u0445LL = LLL\u0445LLLL\u0445L\u0445\u0445\u0445LL.featurePanel.size() * 15;
                LLL\u0445LLLL\u0445L\u0445\u0445\u0445LL.y = \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight() / 2 - \u0445\u0445\u0445LLLLL\u0445L\u0445\u0445\u0445LL / 2 + \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.y - 30 * \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.panels.size();
            }
            return;
        }
        \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.drawDefaultBackground();
        float \u0445LL\u0445\u0445LLL\u0445L\u0445\u0445\u0445LL = (float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight() / 540.0f;
        GL11.glPushMatrix();
        GL11.glScalef(\u0445LL\u0445\u0445LLL\u0445L\u0445\u0445\u0445LL, \u0445LL\u0445\u0445LLL\u0445L\u0445\u0445\u0445LL, \u0445LL\u0445\u0445LLL\u0445L\u0445\u0445\u0445LL);
        RenderHelper.drawImage(new ResourceLocation("neverhook/anim1.png"), (float)(\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth() - 270) / \u0445LL\u0445\u0445LLL\u0445L\u0445\u0445\u0445LL, (float)(\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight() - 256) / \u0445LL\u0445\u0445LLL\u0445L\u0445\u0445\u0445LL, 215.0f / \u0445LL\u0445\u0445LLL\u0445L\u0445\u0445\u0445LL, 285.0f / \u0445LL\u0445\u0445LLL\u0445L\u0445\u0445\u0445LL, Color.WHITE);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth() / 2.0f, (float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight() / 2.0f, 0.0f);
        GL11.glScaled(\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.screenHelper.getX() / (float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth(), \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.screenHelper.getY() / (float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight(), 1.0);
        GL11.glTranslatef((float)(-\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth()) / 2.0f, (float)(-\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight()) / 2.0f, 0.0f);
        Iterator<Object> iterator = \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.panels.iterator();
        if (iterator.hasNext()) {
            Panel \u0445LL\u0445LLLL\u0445L\u0445\u0445\u0445LL = iterator.next();
            if (!\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.usingSetting && ClickGui.enableScroll.getBoolValue()) {
                \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.updateMouseWheel();
            }
            \u0445LL\u0445LLLL\u0445L\u0445\u0445\u0445LL.drawScreen(LLLL\u0445LLL\u0445L\u0445\u0445\u0445LL, \u0445LLL\u0445LLL\u0445L\u0445\u0445\u0445LL);
            return;
        }
        search.drawTextBox();
        RectHelper.drawGradientRect(\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.width - \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.mc.fontRenderer.getStringWidth("Search Feature...") - 90, \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.mc.fontRendererObj.FONT_HEIGHT + 90, \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth() - 10, \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.mc.fontRendererObj.FONT_HEIGHT + 92, LL\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL.getRGB(), LL\u0445L\u0445LLL\u0445L\u0445\u0445\u0445LL.darker().getRGB());
        if (search.getText().isEmpty() && !search.isFocused()) {
            \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.mc.fontRenderer.drawStringWithShadow("Search Feature...", \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.width - \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.mc.fontRenderer.getStringWidth("Search Feature...") - 50, \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.mc.fontRendererObj.FONT_HEIGHT + 77, -1);
        }
        if ((iterator = \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.imageButtons.iterator()).hasNext()) {
            ImageButton L\u0445L\u0445LLLL\u0445L\u0445\u0445\u0445LL = (ImageButton)iterator.next();
            L\u0445L\u0445LLLL\u0445L\u0445\u0445\u0445LL.draw(LLLL\u0445LLL\u0445L\u0445\u0445\u0445LL, \u0445LLL\u0445LLL\u0445L\u0445\u0445\u0445LL, Color.WHITE);
            if (Mouse.isButtonDown(0)) {
                L\u0445L\u0445LLLL\u0445L\u0445\u0445\u0445LL.onClick(LLLL\u0445LLL\u0445L\u0445\u0445\u0445LL, \u0445LLL\u0445LLL\u0445L\u0445\u0445\u0445LL);
            }
            return;
        }
        GL11.glPopMatrix();
        if (\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.usingSetting) {
            iterator = \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.panels.iterator();
            if (iterator.hasNext()) {
                Panel L\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL = (Panel)iterator.next();
                Iterator<FeaturePanel> \u0445\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445LL = L\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.featurePanel.iterator();
                if (\u0445\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445LL.hasNext()) {
                    FeaturePanel \u0445L\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL = \u0445\u0445\u0445LL\u0445LL\u0445L\u0445\u0445\u0445LL.next();
                    if (\u0445L\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.usingSettings) {
                        Iterator<Helper> \u0445LL\u0445L\u0445LL\u0445L\u0445\u0445\u0445LL;
                        \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.screenHelperSetting.interpolate(\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth(), \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight(), 8.0);
                        GlStateManager.pushMatrix();
                        GlStateManager.translate((float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth() / 2.0f, (float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight() / 2.0f, 0.0f);
                        GlStateManager.scale(\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.screenHelperSetting.getX() / (float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth(), \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.screenHelperSetting.getY() / (float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight(), 1.0f);
                        GlStateManager.translate((float)(-\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth()) / 2.0f, (float)(-\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight()) / 2.0f, 0.0f);
                        RectHelper.drawRoundedRect((float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth() / 2.0f - 151.0f, 49.0, 302.0, \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight() - 98, 4.0f, new Color(48, 48, 48, 255));
                        RectHelper.drawRoundedRect((float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth() / 2.0f - 150.0f, 50.0, 300.0, \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight() - 100, 4.0f, new Color(17, 17, 17));
                        RectHelper.drawRoundedRect(\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth() / 2 - 130, 74.0, 262.0, 1.0, 0.0f, new Color(49, 48, 48));
                        Helper.mc.circleregular.drawStringWithOutline(\u0445L\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.feature.getLabel() + " Settings", (float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth() / 2.0f - 37.0f, 56.0, Color.gray.getRGB());
                        GlStateManager.pushMatrix();
                        GlStateManager.enable(3089);
                        RenderHelper.scissorRect((float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth() / 2.0f - 150.0f, 76.0f, (float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth() / 2.0f + 155.0f, \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight() - 47);
                        if (\u0445L\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.yOffset + 25 > \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight() - 150) {
                            \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.scrollbar.setInformation((float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledWidth() / 2.0f - 147.0f, 76.0f, \u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight() - 53 - 125, \u0445L\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.scrollY, (float)\u0445L\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.yOffset - (float)\u0445\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL.getScaledHeight() / 2.0f - 125.0f, 0.0f);
                            \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.scrollbar.drawScrollBar();
                        }
                        if ((\u0445LL\u0445L\u0445LL\u0445L\u0445\u0445\u0445LL = \u0445L\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.components.iterator()).hasNext()) {
                            Component \u0445\u0445L\u0445LLLL\u0445L\u0445\u0445\u0445LL = \u0445LL\u0445L\u0445LL\u0445L\u0445\u0445\u0445LL.next();
                            if (\u0445\u0445L\u0445LLLL\u0445L\u0445\u0445\u0445LL.setting.isVisible()) {
                                \u0445\u0445L\u0445LLLL\u0445L\u0445\u0445\u0445LL.drawScreen(LLLL\u0445LLL\u0445L\u0445\u0445\u0445LL, \u0445LLL\u0445LLL\u0445L\u0445\u0445\u0445LL);
                            }
                            return;
                        }
                        \u0445LL\u0445L\u0445LL\u0445L\u0445\u0445\u0445LL = \u0445L\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.keybindButtons.iterator();
                        if (\u0445LL\u0445L\u0445LL\u0445L\u0445\u0445\u0445LL.hasNext()) {
                            KeybindButton LL\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL = (KeybindButton)\u0445LL\u0445L\u0445LL\u0445L\u0445\u0445\u0445LL.next();
                            LL\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.drawScreen();
                            return;
                        }
                        GlStateManager.disable(3089);
                        GlStateManager.popMatrix();
                        GlStateManager.popMatrix();
                    }
                    return;
                }
                return;
            }
        } else {
            \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.screenHelperSetting = new ScreenHelper(0.0f, 0.0f);
        }
        if (\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.exit) {
            \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.screenHelper.interpolate(0.0f, 0.0f, 2.0);
            if (\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.screenHelper.getY() < 300.0f) {
                \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.exit = false;
                \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.mc.displayGuiScreen(null);
                if (\u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.mc.currentScreen == null) {
                    \u0445\u0445\u0445\u0445LLLL\u0445L\u0445\u0445\u0445LL.mc.setIngameFocus();
                }
            }
        }
        super.drawScreen(LLLL\u0445LLL\u0445L\u0445\u0445\u0445LL, \u0445LLL\u0445LLL\u0445L\u0445\u0445\u0445LL, L\u0445LL\u0445LLL\u0445L\u0445\u0445\u0445LL);
    }

    public void updateMouseWheel() {
        ClickGuiScreen LLLL\u0445\u0445LL\u0445L\u0445\u0445\u0445LL;
        int \u0445LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445LL = Mouse.getDWheel();
        Iterator<Panel> LL\u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445LL = LLLL\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.panels.iterator();
        if (LL\u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.hasNext()) {
            Panel \u0445\u0445\u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445LL = LL\u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.next();
            if (\u0445LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445LL > 0) {
                LLLL\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.y += 3;
            }
            if (\u0445LLL\u0445\u0445LL\u0445L\u0445\u0445\u0445LL < 0) {
                LLLL\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.y -= 3;
            }
            return;
        }
    }

    @Override
    protected void mouseClicked(int \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL, int LLLLLL\u0445L\u0445L\u0445\u0445\u0445LL, int \u0445LLLLL\u0445L\u0445L\u0445\u0445\u0445LL) throws IOException {
        ClickGuiScreen L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL;
        search.setFocused(false);
        search.setText("");
        search.mouseClicked(\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL, LLLLLL\u0445L\u0445L\u0445\u0445\u0445LL, \u0445LLLLL\u0445L\u0445L\u0445\u0445\u0445LL);
        ScaledResolution L\u0445LLLL\u0445L\u0445L\u0445\u0445\u0445LL = new ScaledResolution(L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.mc);
        Iterator<Panel> LLL\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL = L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.panels.iterator();
        if (LLL\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL.hasNext()) {
            Panel \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL = LLL\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL.next();
            if (\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.isWithinHeader(\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL, LLLLLL\u0445L\u0445L\u0445\u0445\u0445LL) && \u0445LLLLL\u0445L\u0445L\u0445\u0445\u0445LL == 1 && !L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.usingSetting) {
                L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.panels.forEach(\u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL -> \u0445L\u0445L\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.setOpen(false));
                \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.setOpen(!\u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.isOpen());
            }
            \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL.mouseClicked(\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL, LLLLLL\u0445L\u0445L\u0445\u0445\u0445LL, \u0445LLLLL\u0445L\u0445L\u0445\u0445\u0445LL);
            return;
        }
        super.mouseClicked(\u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL, LLLLLL\u0445L\u0445L\u0445\u0445\u0445LL, \u0445LLLLL\u0445L\u0445L\u0445\u0445\u0445LL);
    }

    @Override
    protected void mouseReleased(int L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445\u0445LL, int \u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445\u0445LL, int LL\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445LL) {
        ClickGuiScreen \u0445LLL\u0445L\u0445L\u0445L\u0445\u0445\u0445LL;
        Iterator<Panel> \u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445LL = \u0445LLL\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.panels.iterator();
        if (\u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.hasNext()) {
            Panel LLLL\u0445L\u0445L\u0445L\u0445\u0445\u0445LL = \u0445LL\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.next();
            LLLL\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.mouseReleased(L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445\u0445LL, \u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445\u0445LL, LL\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445LL);
            return;
        }
        super.mouseReleased(L\u0445LL\u0445L\u0445L\u0445L\u0445\u0445\u0445LL, \u0445\u0445LL\u0445L\u0445L\u0445L\u0445\u0445\u0445LL, LL\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445LL);
    }

    @Override
    protected void keyTyped(char \u0445L\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL, int L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL) throws IOException {
        ClickGuiScreen LL\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL;
        Iterator<Panel> L\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445LL = LL\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL.panels.iterator();
        if (L\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.hasNext()) {
            Panel \u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445\u0445LL = L\u0445L\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.next();
            Iterator<FeaturePanel> LL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445LL = \u0445\u0445LLL\u0445\u0445L\u0445L\u0445\u0445\u0445LL.featurePanel.iterator();
            if (LL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.hasNext()) {
                FeaturePanel L\u0445LLL\u0445\u0445L\u0445L\u0445\u0445\u0445LL = LL\u0445\u0445L\u0445\u0445L\u0445L\u0445\u0445\u0445LL.next();
                if (LL\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL.usingSetting && L\u0445LLL\u0445\u0445L\u0445L\u0445\u0445\u0445LL.usingSettings) {
                    L\u0445LLL\u0445\u0445L\u0445L\u0445\u0445\u0445LL.keyTyped(\u0445L\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL, L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL);
                    return;
                }
                return;
            }
            return;
        }
        search.textboxKeyTyped(\u0445L\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL, L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL);
        if ((\u0445L\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL == '\t' || \u0445L\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL == '\r') && search.isFocused()) {
            search.setFocused(!search.isFocused());
        }
        if (L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL == 1 && !LL\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL.usingSetting) {
            LL\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL.exit = true;
        }
        if (LL\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL.exit) {
            return;
        }
        super.keyTyped(\u0445L\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL, L\u0445\u0445LL\u0445\u0445L\u0445L\u0445\u0445\u0445LL);
    }

    @Override
    public void initGui() {
        ClickGuiScreen LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL;
        LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.screenHelper = new ScreenHelper(0.0f, 0.0f);
        ScaledResolution \u0445LLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL = new ScaledResolution(LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.mc);
        LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.imageButtons.clear();
        LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.imageButtons.add(new ImageButton(new ResourceLocation("neverhook/brush.png"), \u0445LLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.getScaledWidth() - LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.mc.fontRendererObj.getStringWidth("Welcome") - 70, LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.mc.fontRendererObj.FONT_HEIGHT + 15, 35, 35, "", 18));
        LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.imageButtons.add(new ImageButton(new ResourceLocation("neverhook/config.png"), \u0445LLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.getScaledWidth() - LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.mc.fontRendererObj.getStringWidth("Welcome") - 19, LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.mc.fontRendererObj.FONT_HEIGHT + 15, 35, 35, "", 22));
        search = new GuiSearcher(1337, LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.mc.fontRendererObj, LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.width - LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.mc.fontRenderer.getStringWidth("Search Feature...") - 90, LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.mc.fontRendererObj.FONT_HEIGHT + 72, 150, 18);
        if (ClickGui.blur.getBoolValue()) {
            LLLL\u0445\u0445\u0445L\u0445L\u0445\u0445\u0445LL.mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        }
        super.initGui();
    }
}

