/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.helpers.misc;

import java.awt.Color;
import net.minecraft.client.multiplayer.ServerData;
import org.Destroy.client.feature.impl.hud.FeatureList;
import org.Destroy.client.feature.impl.hud.HUD;
import org.Destroy.client.helpers.Helper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.ui.font.MCFontRenderer;

public class ClientHelper
implements Helper {
    public static ServerData serverData;

    public ClientHelper() {
        ClientHelper L\u0445LL\u0445L\u0445LL\u0445\u0445\u0445LLL;
    }

    public static Color getClientColor() {
        Color L\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = Color.white;
        Color \u0445\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = new Color(HUD.onecolor.getColorValue());
        Color LL\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = new Color(HUD.twocolor.getColorValue());
        double \u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = HUD.time.getNumberValue();
        String L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = HUD.colorList.getOptions();
        float \u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = 4.0f;
        if (L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Rainbow")) {
            L\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = PaletteHelper.rainbow((int)((double)(\u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL * 200.0f) * \u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL), FeatureList.rainbowSaturation.getNumberValue(), FeatureList.rainbowBright.getNumberValue());
        } else if (L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Astolfo")) {
            L\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = PaletteHelper.astolfo(false, (int)\u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL);
        } else if (L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Fade")) {
            L\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = new Color(PaletteHelper.fadeColor(\u0445\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL.getRGB(), \u0445\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL.darker().darker().getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL / \u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL + (double)(\u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL * 2.0f / 60.0f * 2.0f)) % 2.0 - 1.0)));
        } else if (L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Static")) {
            L\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = new Color(\u0445\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL.getRGB());
        } else if (L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Custom")) {
            L\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = new Color(PaletteHelper.fadeColor(\u0445\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL.getRGB(), LL\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL.getRGB(), (float)Math.abs(((double)System.currentTimeMillis() / \u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL / \u0445L\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL + (double)(\u0445\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL * 2.0f / 60.0f * 2.0f)) % 2.0 - 1.0)));
        } else if (L\u0445\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("None")) {
            L\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL = new Color(255, 255, 255);
        }
        return L\u0445L\u0445\u0445L\u0445LL\u0445\u0445\u0445LLL;
    }

    public static MCFontRenderer getFontRender() {
        MCFontRenderer LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.fontRenderer;
        String \u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = HUD.font.getOptions();
        if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Comfortaa")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.sfuiFontRender;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("SF UI")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.fontRenderer;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Verdana")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.verdanaFontRender;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("RobotoRegular")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.robotoRegularFontRender;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Lato")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.latoFontRender;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Open Sans")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.openSansFontRender;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Ubuntu")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.ubuntuFontRender;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("LucidaConsole")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.lucidaConsoleFontRenderer;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Calibri")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.calibri;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Product Sans")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.productsans;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("RaleWay")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.raleway;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Kollektif")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.kollektif;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("CircleRegular")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.circleregular;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("MontserratRegular")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.montserratRegular;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("MontserratLight")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.montserratLight;
        } else if (\u0445LL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.equalsIgnoreCase("Menlo")) {
            LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL = ClientHelper.mc.menlo;
        }
        return LLL\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL;
    }

    public static Color injectAlpha(Color L\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL, int \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL) {
        return new Color(L\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.getRed(), L\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.getGreen(), L\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL.getBlue(), \u0445\u0445\u0445\u0445L\u0445\u0445LL\u0445\u0445\u0445LLL);
    }
}

