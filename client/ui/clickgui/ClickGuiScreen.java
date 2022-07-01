/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.ScreenHelper;
import org.Destroy.client.helpers.render.rect.RectHelper;
import org.Destroy.client.ui.button.ImageButton;
import org.Destroy.client.ui.clickgui.GuiSearcher;
import org.Destroy.client.ui.clickgui.Panel;
import org.Destroy.client.ui.clickgui.component.Component;
import org.Destroy.client.ui.clickgui.component.ExpandableComponent;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class ClickGuiScreen
extends GuiScreen {
    public static boolean escapeKeyInUse;
    public static GuiSearcher search;
    public List<Panel> components = new ArrayList<Panel>();
    public ScreenHelper screenHelper;
    public boolean exit = false;
    public Type type;
    protected ArrayList<ImageButton> imageButtons = new ArrayList();
    private Component selectedPanel;

    public ClickGuiScreen() {
        ClickGuiScreen \u0445L\u0445\u0445LLL\u0445LLLL\u0445L;
        int \u0445\u0445\u0445\u0445LLL\u0445LLLL\u0445L = 20;
        int LLLL\u0445LL\u0445LLLL\u0445L = 20;
        int \u0445LLL\u0445LL\u0445LLLL\u0445L = 150;
        Type[] \u0445\u0445\u0445L\u0445LL\u0445LLLL\u0445L = Type.values();
        int LLL\u0445\u0445LL\u0445LLLL\u0445L = \u0445\u0445\u0445L\u0445LL\u0445LLLL\u0445L.length;
        int \u0445LL\u0445\u0445LL\u0445LLLL\u0445L = 0;
        if (\u0445LL\u0445\u0445LL\u0445LLLL\u0445L < LLL\u0445\u0445LL\u0445LLLL\u0445L) {
            Type \u0445LL\u0445LLL\u0445LLLL\u0445L;
            \u0445L\u0445\u0445LLL\u0445LLLL\u0445L.type = \u0445LL\u0445LLL\u0445LLLL\u0445L = \u0445\u0445\u0445L\u0445LL\u0445LLLL\u0445L[\u0445LL\u0445\u0445LL\u0445LLLL\u0445L];
            \u0445L\u0445\u0445LLL\u0445LLLL\u0445L.components.add(new Panel(\u0445LL\u0445LLL\u0445LLLL\u0445L, LLLL\u0445LL\u0445LLLL\u0445L, \u0445LLL\u0445LL\u0445LLLL\u0445L));
            \u0445L\u0445\u0445LLL\u0445LLLL\u0445L.selectedPanel = new Panel(\u0445LL\u0445LLL\u0445LLLL\u0445L, LLLL\u0445LL\u0445LLLL\u0445L, \u0445LLL\u0445LL\u0445LLLL\u0445L);
            \u0445LLL\u0445LL\u0445LLLL\u0445L += \u0445\u0445\u0445\u0445LLL\u0445LLLL\u0445L + 6;
            ++\u0445LL\u0445\u0445LL\u0445LLLL\u0445L;
            throw null;
        }
        \u0445L\u0445\u0445LLL\u0445LLLL\u0445L.screenHelper = new ScreenHelper(0.0f, 0.0f);
    }

    @Override
    public void initGui() {
        ClickGuiScreen LLL\u0445L\u0445L\u0445LLLL\u0445L;
        LLL\u0445L\u0445L\u0445LLLL\u0445L.screenHelper = new ScreenHelper(0.0f, 0.0f);
        ScaledResolution \u0445LL\u0445L\u0445L\u0445LLLL\u0445L = new ScaledResolution(LLL\u0445L\u0445L\u0445LLLL\u0445L.mc);
        LLL\u0445L\u0445L\u0445LLLL\u0445L.imageButtons.clear();
        LLL\u0445L\u0445L\u0445LLLL\u0445L.imageButtons.add(new ImageButton(new ResourceLocation("neverhook/brush.png"), \u0445LL\u0445L\u0445L\u0445LLLL\u0445L.getScaledWidth() - LLL\u0445L\u0445L\u0445LLLL\u0445L.mc.fontRendererObj.getStringWidth("Welcome") - 70, \u0445LL\u0445L\u0445L\u0445LLLL\u0445L.getScaledHeight() - LLL\u0445L\u0445L\u0445LLLL\u0445L.mc.fontRendererObj.FONT_HEIGHT - 50, 40, 40, "", 18));
        LLL\u0445L\u0445L\u0445LLLL\u0445L.imageButtons.add(new ImageButton(new ResourceLocation("neverhook/config.png"), \u0445LL\u0445L\u0445L\u0445LLLL\u0445L.getScaledWidth() - LLL\u0445L\u0445L\u0445LLLL\u0445L.mc.fontRendererObj.getStringWidth("Welcome") - 19, \u0445LL\u0445L\u0445L\u0445LLLL\u0445L.getScaledHeight() - LLL\u0445L\u0445L\u0445LLLL\u0445L.mc.fontRendererObj.FONT_HEIGHT - 50, 40, 40, "", 22));
        LLL\u0445L\u0445L\u0445LLLL\u0445L.imageButtons.add(new ImageButton(new ResourceLocation("neverhook/capeicon.png"), \u0445LL\u0445L\u0445L\u0445LLLL\u0445L.getScaledWidth() - LLL\u0445L\u0445L\u0445LLLL\u0445L.mc.fontRendererObj.getStringWidth("Welcome") - 115, \u0445LL\u0445L\u0445L\u0445LLLL\u0445L.getScaledHeight() - LLL\u0445L\u0445L\u0445LLLL\u0445L.mc.fontRendererObj.FONT_HEIGHT - 50, 40, 40, "", 23));
        search = new GuiSearcher(1337, LLL\u0445L\u0445L\u0445LLLL\u0445L.mc.fontRendererObj, LLL\u0445L\u0445L\u0445LLLL\u0445L.width - LLL\u0445L\u0445L\u0445LLLL\u0445L.mc.fontRenderer.getStringWidth("Search Feature...") - 90, \u0445LL\u0445L\u0445L\u0445LLLL\u0445L.getScaledHeight() - LLL\u0445L\u0445L\u0445LLLL\u0445L.mc.fontRendererObj.FONT_HEIGHT - 90, 150, 18);
        if (ClickGui.blur.getBoolValue()) {
            LLL\u0445L\u0445L\u0445LLLL\u0445L.mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        }
        super.initGui();
    }

    @Override
    public void drawScreen(int L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L, int \u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L, float LLL\u0445\u0445L\u0445\u0445LLLL\u0445L) {
        ClickGuiScreen \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L;
        ScaledResolution \u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L = new ScaledResolution(\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc);
        Color L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L = Color.WHITE;
        Color \u0445\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L = new Color(ClickGui.color.getColorValue());
        Color LL\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L = new Color(ClickGui.colorTwo.getColorValue());
        double \u0445L\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L = ClickGui.speed.getNumberValue();
        switch (ClickGui.clickGuiColor.currentMode) {
            case "Client": {
                L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L = ClientHelper.getClientColor();
                break;
            }
            case "Fade": {
                L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L = new Color(ClickGui.color.getColorValue());
                break;
            }
            case "Astolfo": {
                L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L = PaletteHelper.astolfo(true, \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.width);
                break;
            }
            case "Color Two": {
                L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L = new Color(PaletteHelper.fadeColor(\u0445\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L.getRGB(), LL\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L / \u0445L\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L + (double)((long)\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.height * 6L / 60L * 2L)) % 2.0 - 1.0)));
                break;
            }
            case "Rainbow": {
                L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L = PaletteHelper.rainbow(300, 1.0f, 1.0f);
                break;
            }
            case "Category": {
                L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L = new Color(\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.type.getColor());
                break;
            }
            case "Static": {
                L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L = \u0445\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L;
            }
        }
        Color L\u0445\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L = new Color(L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L.getRed(), L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L.getGreen(), L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L.getBlue(), 100);
        if (ClickGui.background.getBoolValue()) {
            \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.drawDefaultBackground();
            \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.drawGradientRect(0.0f, 0.0f, \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.width, \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.height, L\u0445\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L.getRGB(), L\u0445\u0445\u0445\u0445L\u0445\u0445LLLL\u0445L.brighter().getRGB());
        }
        if (!\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.exit) {
            \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.screenHelper.interpolate(\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.width, \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.height, 6.0 * Minecraft.frameTime / 6.0);
        }
        GlStateManager.pushMatrix();
        GL11.glTranslatef(\u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L.getScaledWidth() / 2, \u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L.getScaledHeight() / 2, 0.0f);
        GL11.glScaled(\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.screenHelper.getX() / (float)\u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L.getScaledWidth(), \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.screenHelper.getY() / (float)\u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L.getScaledHeight(), 1.0);
        GL11.glTranslatef((float)(-\u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L.getScaledWidth()) / 2.0f, (float)(-\u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L.getScaledHeight()) / 2.0f, 0.0f);
        Iterator<Object> \u0445LL\u0445L\u0445\u0445\u0445LLLL\u0445L = \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.components.iterator();
        if (\u0445LL\u0445L\u0445\u0445\u0445LLLL\u0445L.hasNext()) {
            Panel L\u0445LL\u0445L\u0445\u0445LLLL\u0445L = \u0445LL\u0445L\u0445\u0445\u0445LLLL\u0445L.next();
            L\u0445LL\u0445L\u0445\u0445LLLL\u0445L.drawComponent(\u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L, L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L, \u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L);
            return;
        }
        search.drawTextBox();
        RectHelper.drawGradientRect(\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.width - \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc.fontRenderer.getStringWidth("Search Feature...") - 90, \u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L.getScaledHeight() - \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc.fontRendererObj.FONT_HEIGHT - 92, \u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L.getScaledWidth() - 10, \u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L.getScaledHeight() - \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc.fontRendererObj.FONT_HEIGHT - 90, L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L.getRGB(), L\u0445L\u0445\u0445L\u0445\u0445LLLL\u0445L.darker().getRGB());
        if (search.getText().isEmpty() && !search.isFocused()) {
            \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc.fontRenderer.drawStringWithShadow("Search Feature...", \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.width - \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc.fontRenderer.getStringWidth("Search Feature...") - 50, \u0445LL\u0445\u0445L\u0445\u0445LLLL\u0445L.getScaledHeight() - \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc.fontRendererObj.FONT_HEIGHT - 84, -1);
        }
        if ((\u0445LL\u0445L\u0445\u0445\u0445LLLL\u0445L = \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.imageButtons.iterator()).hasNext()) {
            ImageButton LL\u0445L\u0445L\u0445\u0445LLLL\u0445L = (ImageButton)\u0445LL\u0445L\u0445\u0445\u0445LLLL\u0445L.next();
            LL\u0445L\u0445L\u0445\u0445LLLL\u0445L.draw(L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L, \u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L, Color.WHITE);
            if (Mouse.isButtonDown(0)) {
                LL\u0445L\u0445L\u0445\u0445LLLL\u0445L.onClick(L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L, \u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L);
            }
            return;
        }
        GlStateManager.popMatrix();
        \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.updateMouseWheel();
        if (\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.exit) {
            \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.screenHelper.interpolate(0.0f, 0.0f, 2.0);
            if (\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.screenHelper.getY() < 200.0f) {
                \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.exit = false;
                \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc.displayGuiScreen(null);
                if (\u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc.currentScreen == null) {
                    \u0445L\u0445L\u0445L\u0445\u0445LLLL\u0445L.mc.setIngameFocus();
                }
            }
        }
        super.drawScreen(L\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L, \u0445\u0445\u0445L\u0445L\u0445\u0445LLLL\u0445L, LLL\u0445\u0445L\u0445\u0445LLLL\u0445L);
    }

    public void updateMouseWheel() {
        ClickGuiScreen LLLL\u0445\u0445\u0445\u0445LLLL\u0445L;
        int \u0445LLL\u0445\u0445\u0445\u0445LLLL\u0445L = Mouse.getDWheel();
        Iterator<Panel> LL\u0445L\u0445\u0445\u0445\u0445LLLL\u0445L = LLLL\u0445\u0445\u0445\u0445LLLL\u0445L.components.iterator();
        if (LL\u0445L\u0445\u0445\u0445\u0445LLLL\u0445L.hasNext()) {
            Component \u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL\u0445L = LL\u0445L\u0445\u0445\u0445\u0445LLLL\u0445L.next();
            if (\u0445LLL\u0445\u0445\u0445\u0445LLLL\u0445L > 0) {
                \u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL\u0445L.setY(\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL\u0445L.getY() + 15);
            }
            if (\u0445LLL\u0445\u0445\u0445\u0445LLLL\u0445L < 0) {
                \u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL\u0445L.setY(\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LLLL\u0445L.getY() - 15);
            }
            return;
        }
    }

    @Override
    protected void keyTyped(char L\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L, int \u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L) throws IOException {
        ClickGuiScreen \u0445LL\u0445\u0445\u0445\u0445\u0445LLLL\u0445L;
        if (\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L == 1) {
            \u0445LL\u0445\u0445\u0445\u0445\u0445LLLL\u0445L.exit = true;
        }
        if (\u0445LL\u0445\u0445\u0445\u0445\u0445LLLL\u0445L.exit) {
            return;
        }
        \u0445LL\u0445\u0445\u0445\u0445\u0445LLLL\u0445L.selectedPanel.onKeyPress(\u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L);
        if (!escapeKeyInUse) {
            super.keyTyped(L\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L, \u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L);
        }
        search.textboxKeyTyped(L\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L, \u0445\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L);
        if ((L\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L == '\t' || L\u0445L\u0445\u0445\u0445\u0445\u0445LLLL\u0445L == '\r') && search.isFocused()) {
            search.setFocused(!search.isFocused());
        }
        escapeKeyInUse = false;
    }

    @Override
    protected void mouseClicked(int \u0445\u0445\u0445\u0445LLLL\u0445LLL\u0445L, int LLLL\u0445LLL\u0445LLL\u0445L, int \u0445LLL\u0445LLL\u0445LLL\u0445L) {
        ClickGuiScreen L\u0445\u0445\u0445LLLL\u0445LLL\u0445L;
        search.setFocused(false);
        search.setText("");
        search.mouseClicked(\u0445\u0445\u0445\u0445LLLL\u0445LLL\u0445L, LLLL\u0445LLL\u0445LLL\u0445L, \u0445LLL\u0445LLL\u0445LLL\u0445L);
        Iterator<Panel> L\u0445\u0445L\u0445LLL\u0445LLL\u0445L = L\u0445\u0445\u0445LLLL\u0445LLL\u0445L.components.iterator();
        if (L\u0445\u0445L\u0445LLL\u0445LLL\u0445L.hasNext()) {
            ExpandableComponent \u0445LL\u0445LLLL\u0445LLL\u0445L;
            Component \u0445L\u0445\u0445LLLL\u0445LLL\u0445L = L\u0445\u0445L\u0445LLL\u0445LLL\u0445L.next();
            int L\u0445L\u0445LLLL\u0445LLL\u0445L = \u0445L\u0445\u0445LLLL\u0445LLL\u0445L.getX();
            int \u0445\u0445L\u0445LLLL\u0445LLL\u0445L = \u0445L\u0445\u0445LLLL\u0445LLL\u0445L.getY();
            int LL\u0445\u0445LLLL\u0445LLL\u0445L = \u0445L\u0445\u0445LLLL\u0445LLL\u0445L.getHeight();
            if (\u0445L\u0445\u0445LLLL\u0445LLL\u0445L instanceof ExpandableComponent && (\u0445LL\u0445LLLL\u0445LLL\u0445L = (ExpandableComponent)\u0445L\u0445\u0445LLLL\u0445LLL\u0445L).isExpanded()) {
                LL\u0445\u0445LLLL\u0445LLL\u0445L = \u0445LL\u0445LLLL\u0445LLL\u0445L.getHeightWithExpand();
            }
            if (\u0445\u0445\u0445\u0445LLLL\u0445LLL\u0445L > L\u0445L\u0445LLLL\u0445LLL\u0445L && LLLL\u0445LLL\u0445LLL\u0445L > \u0445\u0445L\u0445LLLL\u0445LLL\u0445L && \u0445\u0445\u0445\u0445LLLL\u0445LLL\u0445L < L\u0445L\u0445LLLL\u0445LLL\u0445L + \u0445L\u0445\u0445LLLL\u0445LLL\u0445L.getWidth() && LLLL\u0445LLL\u0445LLL\u0445L < \u0445\u0445L\u0445LLLL\u0445LLL\u0445L + LL\u0445\u0445LLLL\u0445LLL\u0445L) {
                L\u0445\u0445\u0445LLLL\u0445LLL\u0445L.selectedPanel = \u0445L\u0445\u0445LLLL\u0445LLL\u0445L;
                \u0445L\u0445\u0445LLLL\u0445LLL\u0445L.onMouseClick(\u0445\u0445\u0445\u0445LLLL\u0445LLL\u0445L, LLLL\u0445LLL\u0445LLL\u0445L, \u0445LLL\u0445LLL\u0445LLL\u0445L);
            } else {
                return;
            }
        }
    }

    @Override
    protected void mouseReleased(int \u0445\u0445\u0445\u0445\u0445LLL\u0445LLL\u0445L, int LLLLL\u0445LL\u0445LLL\u0445L, int \u0445LLLL\u0445LL\u0445LLL\u0445L) {
        ClickGuiScreen L\u0445\u0445\u0445\u0445LLL\u0445LLL\u0445L;
        L\u0445\u0445\u0445\u0445LLL\u0445LLL\u0445L.selectedPanel.onMouseRelease(\u0445LLLL\u0445LL\u0445LLL\u0445L);
    }

    @Override
    public void onGuiClosed() {
        ClickGuiScreen \u0445L\u0445LL\u0445LL\u0445LLL\u0445L;
        \u0445L\u0445LL\u0445LL\u0445LLL\u0445L.screenHelper = new ScreenHelper(0.0f, 0.0f);
        \u0445L\u0445LL\u0445LL\u0445LLL\u0445L.mc.entityRenderer.theShaderGroup = null;
        super.onGuiClosed();
    }
}

