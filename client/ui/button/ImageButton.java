/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.ui.button;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import org.Destroy.client.helpers.input.MouseHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.ui.GuiCapeSelector;
import org.Destroy.client.ui.GuiConfig;
import org.Destroy.client.ui.components.draggable.GuiHudEditor;

public class ImageButton {
    protected int height;
    protected String description;
    protected int width;
    protected Minecraft mc;
    protected ResourceLocation image;
    protected int target;
    protected int x;
    protected int ani = 0;
    protected int y;

    public ImageButton(ResourceLocation L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL, int \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL, int LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL, int \u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL, int L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL, String \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL, int LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL) {
        ImageButton \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL;
        \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL.image = L\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL;
        \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL.x = \u0445\u0445\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL;
        \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL.y = LLL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL;
        \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL.width = \u0445LL\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL;
        \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL.height = L\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL;
        \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL.description = \u0445\u0445L\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL;
        \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL.target = LL\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445LL;
        \u0445L\u0445L\u0445\u0445\u0445\u0445\u0445L\u0445LL.mc = Minecraft.getInstance();
    }

    protected void hoverAnimation(int \u0445LL\u0445LLLLL\u0445\u0445LL, int L\u0445L\u0445LLLLL\u0445\u0445LL) {
        ImageButton LLL\u0445LLLLL\u0445\u0445LL;
        if (LLL\u0445LLLLL\u0445\u0445LL.isHovered(\u0445LL\u0445LLLLL\u0445\u0445LL, L\u0445L\u0445LLLLL\u0445\u0445LL)) {
            if (LLL\u0445LLLLL\u0445\u0445LL.ani < 3) {
                ++LLL\u0445LLLLL\u0445\u0445LL.ani;
            }
        } else if (LLL\u0445LLLLL\u0445\u0445LL.ani > 0) {
            --LLL\u0445LLLLL\u0445\u0445LL.ani;
        }
    }

    public void onClick(int \u0445\u0445\u0445L\u0445LLLL\u0445\u0445LL, int LLL\u0445\u0445LLLL\u0445\u0445LL) {
        ImageButton L\u0445\u0445L\u0445LLLL\u0445\u0445LL;
        if (L\u0445\u0445L\u0445LLLL\u0445\u0445LL.isHovered(\u0445\u0445\u0445L\u0445LLLL\u0445\u0445LL, LLL\u0445\u0445LLLL\u0445\u0445LL)) {
            int \u0445L\u0445L\u0445LLLL\u0445\u0445LL;
            GuiChest LL\u0445L\u0445LLLL\u0445\u0445LL;
            GuiChest \u0445\u0445LL\u0445LLLL\u0445\u0445LL;
            if (L\u0445\u0445L\u0445LLLL\u0445\u0445LL.target == 19) {
                Minecraft.getInstance().displayGuiScreen(null);
            }
            if (L\u0445\u0445L\u0445LLLL\u0445\u0445LL.target == 22) {
                Minecraft.getInstance().displayGuiScreen(new GuiConfig());
            }
            if (L\u0445\u0445L\u0445LLLL\u0445\u0445LL.target == 23) {
                Minecraft.getInstance().displayGuiScreen(new GuiCapeSelector());
            }
            if (L\u0445\u0445L\u0445LLLL\u0445\u0445LL.target == 18) {
                L\u0445\u0445L\u0445LLLL\u0445\u0445LL.mc.displayGuiScreen(new GuiHudEditor());
            }
            if (L\u0445\u0445L\u0445LLLL\u0445\u0445LL.target == 30 && (\u0445\u0445LL\u0445LLLL\u0445\u0445LL = (GuiChest)L\u0445\u0445L\u0445LLLL\u0445\u0445LL.mc.currentScreen) != null) {
                new Thread(() -> {
                    try {
                        int \u0445LLLLL\u0445LL\u0445\u0445LL = 0;
                        if (\u0445LLLLL\u0445LL\u0445\u0445LL < \u0445\u0445LL\u0445LLLL\u0445\u0445LL.getInventoryRows() * 9) {
                            ImageButton L\u0445LLLL\u0445LL\u0445\u0445LL;
                            ContainerChest LLLLLL\u0445LL\u0445\u0445LL = (ContainerChest)L\u0445LLLL\u0445LL\u0445\u0445LL.mc.player.openContainer;
                            if (LLLLLL\u0445LL\u0445\u0445LL != null) {
                                Thread.sleep(50L);
                                L\u0445LLLL\u0445LL\u0445\u0445LL.mc.playerController.windowClick(LLLLLL\u0445LL\u0445\u0445LL.windowId, \u0445LLLLL\u0445LL\u0445\u0445LL, 0, ClickType.QUICK_MOVE, L\u0445LLLL\u0445LL\u0445\u0445LL.mc.player);
                            }
                            ++\u0445LLLLL\u0445LL\u0445\u0445LL;
                            return;
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }).start();
            }
            if (L\u0445\u0445L\u0445LLLL\u0445\u0445LL.target == 31 && (LL\u0445L\u0445LLLL\u0445\u0445LL = (GuiChest)L\u0445\u0445L\u0445LLLL\u0445\u0445LL.mc.currentScreen) != null) {
                new Thread(() -> {
                    try {
                        int \u0445\u0445\u0445L\u0445\u0445LLL\u0445\u0445LL = LL\u0445L\u0445LLLL\u0445\u0445LL.getInventoryRows() * 9;
                        if (\u0445\u0445\u0445L\u0445\u0445LLL\u0445\u0445LL < LL\u0445L\u0445LLLL\u0445\u0445LL.getInventoryRows() * 9 + 44) {
                            Slot L\u0445\u0445L\u0445\u0445LLL\u0445\u0445LL = LLL\u0445\u0445\u0445LLL\u0445\u0445LL.inventorySlots.inventorySlots.get(\u0445\u0445\u0445L\u0445\u0445LLL\u0445\u0445LL);
                            if (L\u0445\u0445L\u0445\u0445LLL\u0445\u0445LL.getStack() != null) {
                                Thread.sleep(50L);
                                LL\u0445L\u0445LLLL\u0445\u0445LL.handleMouseClick(L\u0445\u0445L\u0445\u0445LLL\u0445\u0445LL, L\u0445\u0445L\u0445\u0445LLL\u0445\u0445LL.slotNumber, 0, ClickType.QUICK_MOVE);
                            }
                            ++\u0445\u0445\u0445L\u0445\u0445LLL\u0445\u0445LL;
                            return;
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }).start();
            }
            if (L\u0445\u0445L\u0445LLLL\u0445\u0445LL.target == 32 && (\u0445L\u0445L\u0445LLLL\u0445\u0445LL = 0) < 46) {
                if (L\u0445\u0445L\u0445LLLL\u0445\u0445LL.mc.player.inventoryContainer.getSlot(\u0445L\u0445L\u0445LLLL\u0445\u0445LL).getHasStack()) {
                    L\u0445\u0445L\u0445LLLL\u0445\u0445LL.mc.playerController.windowClick(L\u0445\u0445L\u0445LLLL\u0445\u0445LL.mc.player.inventoryContainer.windowId, \u0445L\u0445L\u0445LLLL\u0445\u0445LL, 1, ClickType.THROW, L\u0445\u0445L\u0445LLLL\u0445\u0445LL.mc.player);
                }
                ++\u0445L\u0445L\u0445LLLL\u0445\u0445LL;
                return;
            }
            if (L\u0445\u0445L\u0445LLLL\u0445\u0445LL.target == 55) {
                switch (GuiCapeSelector.Selector.getCapeName()) {
                    case "neverhookcape2": {
                        GuiCapeSelector.Selector.capeName = "nhplash4";
                        break;
                    }
                    case "nhplash4": {
                        GuiCapeSelector.Selector.capeName = "nhplash5";
                        break;
                    }
                    case "nhplash5": {
                        GuiCapeSelector.Selector.capeName = "nhplash6";
                        break;
                    }
                    case "nhplash6": {
                        GuiCapeSelector.Selector.capeName = "neverhookcape3";
                        break;
                    }
                    default: {
                        GuiCapeSelector.Selector.capeName = "neverhookcape2";
                    }
                }
            }
            if (L\u0445\u0445L\u0445LLLL\u0445\u0445LL.target == 56) {
                switch (GuiCapeSelector.Selector.getCapeName()) {
                    case "neverhookcape2": {
                        GuiCapeSelector.Selector.capeName = "nhplash4";
                        break;
                    }
                    case "nhplash4": {
                        GuiCapeSelector.Selector.capeName = "nhplash5";
                        break;
                    }
                    case "nhplash5": {
                        GuiCapeSelector.Selector.capeName = "nhplash6";
                        break;
                    }
                    case "nhplash6": {
                        GuiCapeSelector.Selector.capeName = "neverhookcape3";
                        break;
                    }
                    default: {
                        GuiCapeSelector.Selector.capeName = "neverhookcape2";
                    }
                }
            }
        }
    }

    public void draw(int \u0445\u0445LLL\u0445LLL\u0445\u0445LL, int LL\u0445LL\u0445LLL\u0445\u0445LL, Color \u0445L\u0445LL\u0445LLL\u0445\u0445LL) {
        ImageButton L\u0445LLL\u0445LLL\u0445\u0445LL;
        GlStateManager.pushMatrix();
        GlStateManager.disableBlend();
        L\u0445LLL\u0445LLL\u0445\u0445LL.hoverAnimation(\u0445\u0445LLL\u0445LLL\u0445\u0445LL, LL\u0445LL\u0445LLL\u0445\u0445LL);
        if (L\u0445LLL\u0445LLL\u0445\u0445LL.ani > 0) {
            RenderHelper.drawImage(L\u0445LLL\u0445LLL\u0445\u0445LL.image, L\u0445LLL\u0445LLL\u0445\u0445LL.x - L\u0445LLL\u0445LLL\u0445\u0445LL.ani, L\u0445LLL\u0445LLL\u0445\u0445LL.y - L\u0445LLL\u0445LLL\u0445\u0445LL.ani, L\u0445LLL\u0445LLL\u0445\u0445LL.width + L\u0445LLL\u0445LLL\u0445\u0445LL.ani * 2, L\u0445LLL\u0445LLL\u0445\u0445LL.height + L\u0445LLL\u0445LLL\u0445\u0445LL.ani * 2, new Color(156, 156, 156, 255));
        } else {
            RenderHelper.drawImage(L\u0445LLL\u0445LLL\u0445\u0445LL.image, L\u0445LLL\u0445LLL\u0445\u0445LL.x, L\u0445LLL\u0445LLL\u0445\u0445LL.y, L\u0445LLL\u0445LLL\u0445\u0445LL.width, L\u0445LLL\u0445LLL\u0445\u0445LL.height, \u0445L\u0445LL\u0445LLL\u0445\u0445LL);
        }
        GlStateManager.popMatrix();
    }

    protected boolean isHovered(int L\u0445\u0445\u0445L\u0445LLL\u0445\u0445LL, int \u0445\u0445\u0445\u0445L\u0445LLL\u0445\u0445LL) {
        ImageButton \u0445L\u0445\u0445L\u0445LLL\u0445\u0445LL;
        return MouseHelper.isHovered(\u0445L\u0445\u0445L\u0445LLL\u0445\u0445LL.x, \u0445L\u0445\u0445L\u0445LLL\u0445\u0445LL.y, \u0445L\u0445\u0445L\u0445LLL\u0445\u0445LL.x + \u0445L\u0445\u0445L\u0445LLL\u0445\u0445LL.width, \u0445L\u0445\u0445L\u0445LLL\u0445\u0445LL.y + \u0445L\u0445\u0445L\u0445LLL\u0445\u0445LL.height, L\u0445\u0445\u0445L\u0445LLL\u0445\u0445LL, \u0445\u0445\u0445\u0445L\u0445LLL\u0445\u0445LL);
    }
}

