/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.ClientHelper;
import org.Destroy.client.helpers.palette.PaletteHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;

public class BlockOverlay
extends Feature {
    public ListSetting colorMode = new ListSetting("Color Box Mode", "Client", () -> true, "Astolfo", "Rainbow", "Client", "Custom");
    public ColorSetting colorPicker = new ColorSetting("Color BlockOverlay", -1, () -> {
        BlockOverlay \u0445\u0445LL\u0445\u0445\u0445L\u0445LLLL\u0445L;
        return \u0445\u0445LL\u0445\u0445\u0445L\u0445LLLL\u0445L.colorMode.currentMode.equals("Custom");
    });
    public BooleanSetting outline = new BooleanSetting("Outline BlockOverlay", false, () -> true);

    public BlockOverlay() {
        super("BlockOutline", "Shows the blocks you have hovered over", Type.Visuals);
        BlockOverlay \u0445L\u0445LL\u0445\u0445L\u0445LLLL\u0445L;
        \u0445L\u0445LL\u0445\u0445L\u0445LLLL\u0445L.addSettings(\u0445L\u0445LL\u0445\u0445L\u0445LLLL\u0445L.colorMode, \u0445L\u0445LL\u0445\u0445L\u0445LLLL\u0445L.colorPicker, \u0445L\u0445LL\u0445\u0445L\u0445LLLL\u0445L.outline);
    }

    @EventTarget
    public void onRender3D(EventRender3D LL\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L) {
        BlockOverlay \u0445\u0445L\u0445L\u0445\u0445L\u0445LLLL\u0445L;
        int \u0445L\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L = 0;
        switch (\u0445\u0445L\u0445L\u0445\u0445L\u0445LLLL\u0445L.colorMode.currentMode) {
            case "Client": {
                \u0445L\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L = ClientHelper.getClientColor().getRGB();
                break;
            }
            case "Custom": {
                \u0445L\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L = \u0445\u0445L\u0445L\u0445\u0445L\u0445LLLL\u0445L.colorPicker.getColorValue();
                break;
            }
            case "Astolfo": {
                \u0445L\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L = PaletteHelper.astolfo(false, BlockOverlay.mc.objectMouseOver.getBlockPos().getY()).getRGB();
                break;
            }
            case "Rainbow": {
                \u0445L\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L = PaletteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
            }
        }
        if (BlockOverlay.mc.world.getBlockState(BlockOverlay.mc.objectMouseOver.getBlockPos()).getBlock() != Blocks.AIR) {
            GlStateManager.pushMatrix();
            RenderHelper.blockEsp(new BlockPos(BlockOverlay.mc.objectMouseOver.getBlockPos().getX(), BlockOverlay.mc.objectMouseOver.getBlockPos().getY(), BlockOverlay.mc.objectMouseOver.getBlockPos().getZ()), new Color(\u0445L\u0445\u0445L\u0445\u0445L\u0445LLLL\u0445L), \u0445\u0445L\u0445L\u0445\u0445L\u0445LLLL\u0445L.outline.getBoolValue());
            GlStateManager.popMatrix();
        }
    }
}

