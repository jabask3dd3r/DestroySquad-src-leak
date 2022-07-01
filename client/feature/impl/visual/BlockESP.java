/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import java.util.Iterator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;

public class BlockESP
extends Feature {
    public static BooleanSetting enderChest;
    public static BooleanSetting chest;
    public static BooleanSetting clientColor;
    public static ColorSetting spawnerColor;
    public static BooleanSetting espOutline;
    public static ColorSetting chestColor;
    public static ColorSetting enderChestColor;
    public static ColorSetting shulkerColor;
    public static ColorSetting bedColor;
    private final BooleanSetting bed;
    private final BooleanSetting shulker;
    private final BooleanSetting spawner;

    public BlockESP() {
        super("BlockESP", "Highlights certain blocks", Type.Visuals);
        BlockESP \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L;
        chest = new BooleanSetting("Chest", true, () -> true);
        enderChest = new BooleanSetting("Ender Chest", false, () -> true);
        \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L.spawner = new BooleanSetting("Spawner", false, () -> true);
        \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L.shulker = new BooleanSetting("Shulker", false, () -> true);
        \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L.bed = new BooleanSetting("Bed", false, () -> true);
        chestColor = new ColorSetting("Chest Color", new Color(0xFFFFFF).getRGB(), chest::getBoolValue);
        enderChestColor = new ColorSetting("EnderChest Color", new Color(0xFFFFFF).getRGB(), enderChest::getBoolValue);
        shulkerColor = new ColorSetting("Shulker Color", new Color(0xFFFFFF).getRGB(), \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L.shulker::getBoolValue);
        spawnerColor = new ColorSetting("Spawner Color", new Color(0xFFFFFF).getRGB(), \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L.spawner::getBoolValue);
        bedColor = new ColorSetting("Bed Color", new Color(0xFFFFFF).getRGB(), \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L.bed::getBoolValue);
        clientColor = new BooleanSetting("Client Colors", false, () -> true);
        espOutline = new BooleanSetting("ESP Outline", false, () -> true);
        \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L.addSettings(espOutline, chest, enderChest, \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L.spawner, \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L.shulker, \u0445L\u0445\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445L\u0445L.bed, chestColor, enderChestColor, spawnerColor, shulkerColor, bedColor, clientColor);
    }

    @EventTarget
    public void onRender3D(EventRender3D \u0445\u0445L\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L) {
        Iterator \u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L\u0445L;
        Color LLLL\u0445LL\u0445\u0445\u0445L\u0445L\u0445L;
        Color LL\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L = clientColor.getBoolValue() ? ClientHelper.getClientColor() : new Color(chestColor.getColorValue());
        Color \u0445L\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L = clientColor.getBoolValue() ? ClientHelper.getClientColor() : new Color(enderChestColor.getColorValue());
        Color L\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L = clientColor.getBoolValue() ? ClientHelper.getClientColor() : new Color(shulkerColor.getColorValue());
        Color \u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L = clientColor.getBoolValue() ? ClientHelper.getClientColor() : new Color(bedColor.getColorValue());
        Color color = LLLL\u0445LL\u0445\u0445\u0445L\u0445L\u0445L = clientColor.getBoolValue() ? ClientHelper.getClientColor() : new Color(spawnerColor.getColorValue());
        if ((BlockESP.mc.player != null || BlockESP.mc.world != null) && (\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L\u0445L = BlockESP.mc.world.loadedTileEntityList.iterator()).hasNext()) {
            BlockESP L\u0445L\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L;
            TileEntity \u0445LL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L = (TileEntity)\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L\u0445L.next();
            BlockPos LLL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L = \u0445LL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L.getPos();
            if (\u0445LL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L instanceof TileEntityChest && chest.getBoolValue()) {
                RenderHelper.blockEsp(LLL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L, new Color(LL\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L.getRGB()), espOutline.getBoolValue());
            } else if (\u0445LL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L instanceof TileEntityEnderChest && enderChest.getBoolValue()) {
                RenderHelper.blockEsp(LLL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L, new Color(\u0445L\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L.getRGB()), espOutline.getBoolValue());
            } else if (\u0445LL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L instanceof TileEntityBed && L\u0445L\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L.bed.getBoolValue()) {
                RenderHelper.blockEsp(LLL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L, new Color(\u0445\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L.getRGB()), espOutline.getBoolValue());
            } else if (\u0445LL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L instanceof TileEntityShulkerBox && L\u0445L\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L.shulker.getBoolValue()) {
                RenderHelper.blockEsp(LLL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L, new Color(L\u0445\u0445\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L.getRGB()), espOutline.getBoolValue());
            } else if (\u0445LL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L instanceof TileEntityMobSpawner && L\u0445L\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L.spawner.getBoolValue()) {
                RenderHelper.blockEsp(LLL\u0445LLL\u0445\u0445\u0445L\u0445L\u0445L, new Color(LLLL\u0445LL\u0445\u0445\u0445L\u0445L\u0445L.getRGB()), espOutline.getBoolValue());
            }
            return;
        }
    }
}

