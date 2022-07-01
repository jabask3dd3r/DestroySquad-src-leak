/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.visual;

import java.util.Iterator;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.MobEffects;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.world.EnumSkyBlock;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.event.events.impl.render.EventRenderEntity;
import org.Destroy.client.event.events.impl.render.EventRenderWorldLight;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;

public class NoRender
extends Feature {
    public static BooleanSetting rain;
    public static BooleanSetting hurt;
    public static BooleanSetting pumpkin;
    public static BooleanSetting armor;
    public static BooleanSetting totem;
    public static BooleanSetting blindness;
    public static BooleanSetting cameraSmooth;
    public static BooleanSetting cameraBounds;
    public static BooleanSetting fire;
    public static BooleanSetting light;
    public static BooleanSetting fog;
    public static BooleanSetting armorStand;
    public static BooleanSetting bossBar;
    public static BooleanSetting tnt;
    public static BooleanSetting crystal;
    public static BooleanSetting fireworks;
    public static BooleanSetting swing;
    public static BooleanSetting sign;
    public static BooleanSetting frame;
    public static BooleanSetting banner;
    public static BooleanSetting glintEffect;
    public static BooleanSetting chatRect;

    public NoRender() {
        super("NoRender", "Removes certain render elements in the game", Type.Visuals);
        NoRender \u0445\u0445\u0445L\u0445LLLLL\u0445\u0445L;
        rain = new BooleanSetting("Rain", true, () -> true);
        hurt = new BooleanSetting("HurtCamera", true, () -> true);
        pumpkin = new BooleanSetting("Pumpkin", true, () -> true);
        armor = new BooleanSetting("Armor", false, () -> true);
        totem = new BooleanSetting("Totem", true, () -> true);
        blindness = new BooleanSetting("Blindness", true, () -> true);
        cameraSmooth = new BooleanSetting("Camera Smooth", true, () -> true);
        cameraBounds = new BooleanSetting("Camera Bounds", false, () -> true);
        fire = new BooleanSetting("Fire", true, () -> true);
        light = new BooleanSetting("Light", false, () -> true);
        fog = new BooleanSetting("Fog", false, () -> true);
        armorStand = new BooleanSetting("Armor Stand", false, () -> true);
        bossBar = new BooleanSetting("Boss Bar", true, () -> true);
        tnt = new BooleanSetting("Tnt", false, () -> true);
        crystal = new BooleanSetting("Crystal", false, () -> true);
        fireworks = new BooleanSetting("FireWorks", false, () -> true);
        swing = new BooleanSetting("Swing", false, () -> true);
        sign = new BooleanSetting("Sign", false, () -> true);
        frame = new BooleanSetting("Frame", false, () -> true);
        banner = new BooleanSetting("Banner", false, () -> true);
        glintEffect = new BooleanSetting("Glint Effect", false, () -> true);
        chatRect = new BooleanSetting("Chat Rect", false, () -> false);
        \u0445\u0445\u0445L\u0445LLLLL\u0445\u0445L.addSettings(rain, hurt, pumpkin, armor, totem, blindness, cameraSmooth, fire, light, fog, armorStand, bossBar, tnt, crystal, fireworks, swing, sign, frame, banner, glintEffect);
    }

    @EventTarget
    public void onEntityRenderer(EventRenderEntity LL\u0445\u0445\u0445LLLLL\u0445\u0445L) {
        NoRender \u0445\u0445L\u0445\u0445LLLLL\u0445\u0445L;
        if (!\u0445\u0445L\u0445\u0445LLLLL\u0445\u0445L.getState()) {
            return;
        }
        if (LL\u0445\u0445\u0445LLLLL\u0445\u0445L.getEntity() != null) {
            if (fireworks.getBoolValue() && LL\u0445\u0445\u0445LLLLL\u0445\u0445L.getEntity() instanceof EntityFireworkRocket) {
                LL\u0445\u0445\u0445LLLLL\u0445\u0445L.setCancelled(true);
            } else if (crystal.getBoolValue() && LL\u0445\u0445\u0445LLLLL\u0445\u0445L.getEntity() instanceof EntityEnderCrystal) {
                LL\u0445\u0445\u0445LLLLL\u0445\u0445L.setCancelled(true);
            } else if (tnt.getBoolValue() && LL\u0445\u0445\u0445LLLLL\u0445\u0445L.getEntity() instanceof EntityTNTPrimed) {
                LL\u0445\u0445\u0445LLLLL\u0445\u0445L.setCancelled(true);
            } else if (armorStand.getBoolValue() && LL\u0445\u0445\u0445LLLLL\u0445\u0445L.getEntity() instanceof EntityArmorStand) {
                LL\u0445\u0445\u0445LLLLL\u0445\u0445L.setCancelled(true);
            } else if (frame.getBoolValue() && LL\u0445\u0445\u0445LLLLL\u0445\u0445L.getEntity() instanceof EntityItemFrame) {
                LL\u0445\u0445\u0445LLLLL\u0445\u0445L.setCancelled(true);
            }
        }
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445\u0445LLL\u0445LLLL\u0445\u0445L) {
        Iterator LL\u0445LL\u0445LLLL\u0445\u0445L;
        if (banner.getBoolValue() && (LL\u0445LL\u0445LLLL\u0445\u0445L = NoRender.mc.world.loadedTileEntityList.iterator()).hasNext()) {
            TileEntity \u0445LLLL\u0445LLLL\u0445\u0445L = (TileEntity)LL\u0445LL\u0445LLLL\u0445\u0445L.next();
            if (\u0445LLLL\u0445LLLL\u0445\u0445L instanceof TileEntityBanner) {
                NoRender.mc.world.removeTileEntity(\u0445LLLL\u0445LLLL\u0445\u0445L.getPos());
            }
            return;
        }
        if (cameraSmooth.getBoolValue()) {
            NoRender.mc.gameSettings.smoothCamera = false;
        }
        if (rain.getBoolValue() && NoRender.mc.world.isRaining()) {
            NoRender.mc.world.setRainStrength(0.0f);
            NoRender.mc.world.setThunderStrength(0.0f);
        }
        if (blindness.getBoolValue() && NoRender.mc.player.isPotionActive(MobEffects.BLINDNESS) || NoRender.mc.player.isPotionActive(MobEffects.NAUSEA)) {
            NoRender.mc.player.removePotionEffect(MobEffects.NAUSEA);
            NoRender.mc.player.removePotionEffect(MobEffects.BLINDNESS);
        }
    }

    @EventTarget
    public void onWorldLight(EventRenderWorldLight \u0445LL\u0445L\u0445LLLL\u0445\u0445L) {
        NoRender LLL\u0445L\u0445LLLL\u0445\u0445L;
        if (!LLL\u0445L\u0445LLLL\u0445\u0445L.getState()) {
            return;
        }
        if (light.getBoolValue() && \u0445LL\u0445L\u0445LLLL\u0445\u0445L.getEnumSkyBlock() == EnumSkyBlock.SKY) {
            \u0445LL\u0445L\u0445LLLL\u0445\u0445L.setCancelled(true);
        }
    }
}

