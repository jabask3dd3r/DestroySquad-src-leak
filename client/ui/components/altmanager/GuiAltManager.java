/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.components.altmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.util.text.TextFormatting;
import org.Destroy.client.ui.button.GuiAltButton;
import org.Destroy.client.ui.components.altmanager.GuiAddAlt;
import org.Destroy.client.ui.components.altmanager.GuiAltLogin;
import org.Destroy.client.ui.components.altmanager.GuiRenameAlt;
import org.Destroy.client.ui.components.altmanager.alt.Alt;
import org.Destroy.client.ui.components.altmanager.alt.AltLoginThread;
import org.Destroy.client.ui.components.altmanager.alt.AltManager;
import org.Destroy.client.ui.components.altmanager.althening.api.AltService;
import org.apache.commons.lang3.RandomStringUtils;

public class GuiAltManager
extends GuiScreen {
    public static final AltService altService = new AltService();
    public Alt selectedAlt = null;
    public String status = (Object)((Object)TextFormatting.DARK_GRAY) + "(" + (Object)((Object)TextFormatting.GRAY) + AltManager.registry.size() + (Object)((Object)TextFormatting.DARK_GRAY) + ")";
    private GuiAltButton login;
    private GuiAltButton remove;
    private GuiAltButton rename;
    private AltLoginThread loginThread;
    private float offset;
    private GuiTextField searchField;
    private ResourceLocation resourceLocation;

    public GuiAltManager() {
        GuiAltManager LLLLL\u0445\u0445\u0445L\u0445\u0445\u0445L;
    }

    private void getDownloadImageSkin(ResourceLocation LLL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L, String \u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L) {
        GuiAltManager \u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445L;
        TextureManager L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L = \u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445L.mc.getTextureManager();
        L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L.getTexture(LLL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L);
        ThreadDownloadImageData \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L = new ThreadDownloadImageData(null, String.format("https://minotar.net/avatar/%s/64.png", StringUtils.stripControlCodes(\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L)), DefaultPlayerSkin.getDefaultSkin(AbstractClientPlayer.getOfflineUUID(\u0445LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L)), new ImageBufferDownload());
        L\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L.loadTexture(LLL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L, \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L);
    }

    @Override
    public void actionPerformed(GuiButton \u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L) {
        switch (\u0445LL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.id) {
            case 0: {
                break;
            }
            case 1: {
                GuiAltManager LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.loginThread = new AltLoginThread(LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.selectedAlt);
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.loginThread.start();
                break;
            }
            case 2: {
                GuiAltManager LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
                if (LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.loginThread != null) {
                    LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.loginThread = null;
                }
                AltManager.registry.remove(LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.selectedAlt);
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.status = "Removed.";
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.selectedAlt = null;
                break;
            }
            case 3: {
                GuiAltManager LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.mc.displayGuiScreen(new GuiAddAlt(LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L));
                break;
            }
            case 4: {
                GuiAltManager LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.mc.displayGuiScreen(new GuiAltLogin(LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L));
                break;
            }
            case 5: {
                GuiAltManager LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
                String \u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L = "DestroyUse" + RandomStringUtils.randomNumeric(5);
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.loginThread = new AltLoginThread(new Alt(\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L, ""));
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.loginThread.start();
                AltManager.registry.add(new Alt(\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L, ""));
                break;
            }
            case 6: {
                GuiAltManager LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.mc.displayGuiScreen(new GuiRenameAlt(LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L));
                break;
            }
            case 7: {
                GuiAltManager LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.mc.displayGuiScreen(new GuiMainMenu());
                break;
            }
            case 8: {
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.status = "Refreshed!";
                break;
            }
            case 8931: {
                GuiAltManager LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.mc.displayGuiScreen(new GuiMultiplayer(LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L));
                break;
            }
            case 4545: {
                GuiAltManager LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L;
                LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.mc.displayGuiScreen(new GuiConnecting(LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L, LLL\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L.mc, new ServerData(I18n.format("selectServer.defaultName", new Object[0]), "play.hypixel.net", false)));
            }
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public void drawScreen(int \u0445LLL\u0445\u0445LL\u0445\u0445\u0445\u0445L, int L\u0445LL\u0445\u0445LL\u0445\u0445\u0445\u0445L, float \u0445\u0445LL\u0445\u0445LL\u0445\u0445\u0445\u0445L) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl846 : NEW - null : trying to set 7 previously set to 4
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:207)
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

    @Override
    public void initGui() {
        GuiAltManager LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L;
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.searchField = new GuiTextField(LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.eventButton, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.mc.fontRendererObj, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.width / 2 + 116, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.height - 22, 72, 16);
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.login = new GuiAltButton(1, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.width / 2 - 122, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.height - 48, 100, 20, "Login");
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.buttonList.add(LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.login);
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.remove = new GuiAltButton(2, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.width / 2 - 40, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.height - 24, 70, 20, "Remove");
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.buttonList.add(LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.remove);
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.buttonList.add(new GuiAltButton(3, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.width / 2 + 4 + 86, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.height - 48, 100, 20, "Add"));
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.buttonList.add(new GuiAltButton(4, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.width / 2 - 16, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.height - 48, 100, 20, "Direct Login"));
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.buttonList.add(new GuiAltButton(5, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.width / 2 - 122, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.height - 24, 78, 20, "Random"));
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.rename = new GuiAltButton(6, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.width / 2 + 38, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.height - 24, 70, 20, "Edit");
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.buttonList.add(LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.rename);
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.buttonList.add(new GuiAltButton(7, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.width / 2 - 190, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.height - 24, 60, 20, "Back"));
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.buttonList.add(new GuiAltButton(8, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.width / 2 - 190, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.height - 48, 60, 20, "Refresh"));
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.buttonList.add(new GuiAltButton(8931, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.width / 2 + 195, LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.height - 48, 100, 20, "MultiPlayer"));
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.login.enabled = false;
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.remove.enabled = false;
        LLL\u0445LL\u0445L\u0445\u0445\u0445\u0445L.rename.enabled = false;
    }

    @Override
    protected void keyTyped(char LLLL\u0445L\u0445L\u0445\u0445\u0445\u0445L, int \u0445LLL\u0445L\u0445L\u0445\u0445\u0445\u0445L) {
        GuiAltManager \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L;
        \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L.searchField.textboxKeyTyped(LLLL\u0445L\u0445L\u0445\u0445\u0445\u0445L, \u0445LLL\u0445L\u0445L\u0445\u0445\u0445\u0445L);
        if ((LLLL\u0445L\u0445L\u0445\u0445\u0445\u0445L == '\t' || LLLL\u0445L\u0445L\u0445\u0445\u0445\u0445L == '\r') && \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L.searchField.isFocused()) {
            \u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L.searchField.setFocused(!\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L.searchField.isFocused());
        }
        try {
            super.keyTyped(LLLL\u0445L\u0445L\u0445\u0445\u0445\u0445L, \u0445LLL\u0445L\u0445L\u0445\u0445\u0445\u0445L);
        }
        catch (IOException L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L) {
            L\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445\u0445L.printStackTrace();
        }
    }

    @Override
    protected void mouseClicked(int \u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L, int L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L, int \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L) {
        GuiAltManager LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
        LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.searchField.mouseClicked(\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L, L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L, \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L);
        if (LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.offset < 0.0f) {
            LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.offset = 0.0f;
        }
        double LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L = 38.0f - LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.offset;
        Iterator<Alt> L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L = LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getAlts().iterator();
        if (L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.hasNext()) {
            boolean \u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
            Alt LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L = L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.next();
            GuiAltManager guiAltManager = LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
            double d2 = \u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
            double d3 = L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
            if (LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L >= 0) {
                if (LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L == LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.selectedAlt) {
                    LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.actionPerformed(LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.login);
                    return;
                }
                LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.selectedAlt = LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L;
            }
            boolean bl2 = \u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L = (float)\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L >= (float)LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.width / 1.49f && (double)\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L <= (double)LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.width / 1.44 && (double)L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L >= LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L - (double)LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.offset - 4.0 && (double)L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L <= LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L - (double)LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.offset + 35.0;
            if (\u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L && LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L == LL\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.selectedAlt) {
                switch (LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.getStatus()) {
                    case Unchecked: {
                        LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.setStatus(Alt.Status.Working);
                        break;
                    }
                    case Working: {
                        LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.setStatus(Alt.Status.Banned);
                        break;
                    }
                    case Banned: {
                        LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.setStatus(Alt.Status.NotWorking);
                        break;
                    }
                    case NotWorking: {
                        LLLL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.setStatus(Alt.Status.Unchecked);
                    }
                }
            }
            LLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L += 40.0;
            return;
        }
        try {
            super.mouseClicked(\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L, L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L, \u0445\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L);
        }
        catch (IOException \u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L) {
            \u0445\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445\u0445L.printStackTrace();
        }
    }

    private List<Alt> getAlts() {
        Alt \u0445L\u0445LLLL\u0445\u0445\u0445\u0445\u0445L;
        GuiAltManager L\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L;
        ArrayList<Alt> \u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L = new ArrayList<Alt>();
        Iterator<Alt> LLL\u0445LLL\u0445\u0445\u0445\u0445\u0445L = AltManager.registry.iterator();
        do {
            if (!LLL\u0445LLL\u0445\u0445\u0445\u0445\u0445L.hasNext()) {
                return \u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L;
            }
            \u0445L\u0445LLLL\u0445\u0445\u0445\u0445\u0445L = LLL\u0445LLL\u0445\u0445\u0445\u0445\u0445L.next();
        } while (!L\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.searchField.getText().isEmpty() && !\u0445L\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.getMask().toLowerCase().contains(L\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.searchField.getText().toLowerCase()) && !\u0445L\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.getUsername().toLowerCase().contains(L\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.searchField.getText().toLowerCase()));
        \u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445\u0445L.add(\u0445L\u0445LLLL\u0445\u0445\u0445\u0445\u0445L);
        return null;
    }
}

