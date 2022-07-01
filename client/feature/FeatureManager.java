/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.feature.impl.combat.AntiBot;
import org.Destroy.client.feature.impl.combat.AutoArmor;
import org.Destroy.client.feature.impl.combat.AutoGApple;
import org.Destroy.client.feature.impl.combat.AutoPotion;
import org.Destroy.client.feature.impl.combat.AutoTotem;
import org.Destroy.client.feature.impl.combat.FastBow;
import org.Destroy.client.feature.impl.combat.FlagDetector;
import org.Destroy.client.feature.impl.combat.HitParticles;
import org.Destroy.client.feature.impl.combat.HitSounds;
import org.Destroy.client.feature.impl.combat.KeepSprint;
import org.Destroy.client.feature.impl.combat.KillAura;
import org.Destroy.client.feature.impl.combat.NoFriendDamage;
import org.Destroy.client.feature.impl.combat.TargetStrafe;
import org.Destroy.client.feature.impl.combat.Velocity;
import org.Destroy.client.feature.impl.ghost.Reach;
import org.Destroy.client.feature.impl.hud.ClickGui;
import org.Destroy.client.feature.impl.hud.ClientSounds;
import org.Destroy.client.feature.impl.hud.FeatureList;
import org.Destroy.client.feature.impl.hud.HUD;
import org.Destroy.client.feature.impl.hud.Notifications;
import org.Destroy.client.feature.impl.hud.WaterMark;
import org.Destroy.client.feature.impl.misc.Ambience;
import org.Destroy.client.feature.impl.misc.AutoFarm;
import org.Destroy.client.feature.impl.misc.AutoFish;
import org.Destroy.client.feature.impl.misc.DeathCoordinates;
import org.Destroy.client.feature.impl.misc.Disabler;
import org.Destroy.client.feature.impl.misc.FastWorldLoad;
import org.Destroy.client.feature.impl.misc.FreeCam;
import org.Destroy.client.feature.impl.misc.ItemScroller;
import org.Destroy.client.feature.impl.misc.NameProtected;
import org.Destroy.client.feature.impl.misc.PortalFeatures;
import org.Destroy.client.feature.impl.movement.AutoSprint;
import org.Destroy.client.feature.impl.movement.Flight;
import org.Destroy.client.feature.impl.movement.Jesus;
import org.Destroy.client.feature.impl.movement.LongJump;
import org.Destroy.client.feature.impl.movement.MotionFly;
import org.Destroy.client.feature.impl.movement.NoClip;
import org.Destroy.client.feature.impl.movement.NoFall;
import org.Destroy.client.feature.impl.movement.Speed;
import org.Destroy.client.feature.impl.movement.TeleportExploit;
import org.Destroy.client.feature.impl.movement.Timer;
import org.Destroy.client.feature.impl.movement.WallClimb;
import org.Destroy.client.feature.impl.movement.WaterSpeed;
import org.Destroy.client.feature.impl.player.AntiAFK;
import org.Destroy.client.feature.impl.player.AntiPush;
import org.Destroy.client.feature.impl.player.AutoRespawn;
import org.Destroy.client.feature.impl.player.AutoTool;
import org.Destroy.client.feature.impl.player.GuiWalk;
import org.Destroy.client.feature.impl.player.HurtClip;
import org.Destroy.client.feature.impl.player.InventoryManager;
import org.Destroy.client.feature.impl.player.MiddleClickFriend;
import org.Destroy.client.feature.impl.player.MiddleClickPearl;
import org.Destroy.client.feature.impl.player.NoDelay;
import org.Destroy.client.feature.impl.player.NoInteract;
import org.Destroy.client.feature.impl.player.NoSlowDownNew;
import org.Destroy.client.feature.impl.visual.Animations;
import org.Destroy.client.feature.impl.visual.BlockESP;
import org.Destroy.client.feature.impl.visual.BlockOverlay;
import org.Destroy.client.feature.impl.visual.CameraNoClip;
import org.Destroy.client.feature.impl.visual.Chams;
import org.Destroy.client.feature.impl.visual.ChestESP;
import org.Destroy.client.feature.impl.visual.ChinaHat;
import org.Destroy.client.feature.impl.visual.ChunkAnimator;
import org.Destroy.client.feature.impl.visual.Crosshair;
import org.Destroy.client.feature.impl.visual.CustomModels;
import org.Destroy.client.feature.impl.visual.EnchantmentColor;
import org.Destroy.client.feature.impl.visual.EntityESP;
import org.Destroy.client.feature.impl.visual.FogColor;
import org.Destroy.client.feature.impl.visual.FullBright;
import org.Destroy.client.feature.impl.visual.HitColor;
import org.Destroy.client.feature.impl.visual.ItemESP;
import org.Destroy.client.feature.impl.visual.ItemPhysics;
import org.Destroy.client.feature.impl.visual.MobESP;
import org.Destroy.client.feature.impl.visual.NameTags;
import org.Destroy.client.feature.impl.visual.NoRender;
import org.Destroy.client.feature.impl.visual.PersonViewer;
import org.Destroy.client.feature.impl.visual.Scoreboard;
import org.Destroy.client.feature.impl.visual.Snow;
import org.Destroy.client.feature.impl.visual.Tracers;
import org.Destroy.client.feature.impl.visual.ViewModel;
import org.Destroy.client.feature.impl.visual.WorldColor;
import org.Destroy.client.feature.impl.visual.XRay;

public class FeatureManager {
    public CopyOnWriteArrayList<Feature> features = new CopyOnWriteArrayList();

    public FeatureManager() {
        FeatureManager \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L;
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Disabler());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new ClickGui());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new HUD());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new FeatureList());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Notifications());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new WaterMark());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new ClientSounds());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new WorldColor());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new ChunkAnimator());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new HurtClip());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new FastBow());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new HitColor());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new CameraNoClip());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new FreeCam());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new NameProtected());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new ItemScroller());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new XRay());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new MiddleClickFriend());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new DeathCoordinates());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Ambience());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new PortalFeatures());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new FastWorldLoad());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AntiBot());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AutoArmor());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Velocity());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new KeepSprint());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Reach());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new NoFriendDamage());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new KillAura());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AutoTotem());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AutoGApple());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new HitParticles());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new TargetStrafe());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AutoPotion());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new FlagDetector());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new HitSounds());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AutoSprint());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new LongJump());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Timer());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Jesus());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new WallClimb());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Speed());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new WaterSpeed());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Flight());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new TeleportExploit());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new GuiWalk());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AutoRespawn());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AntiPush());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new MiddleClickPearl());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new NoClip());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new NoDelay());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AntiAFK());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new NoInteract());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AutoFarm());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AutoFish());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new AutoTool());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new InventoryManager());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new NoSlowDownNew());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new NoFall());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new MotionFly());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new EntityESP());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new BlockESP());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new NameTags());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new FullBright());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Animations());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new NoRender());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new ViewModel());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new ItemPhysics());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Scoreboard());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Chams());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Crosshair());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new EnchantmentColor());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new ItemESP());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new MobESP());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new BlockOverlay());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Tracers());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new ChestESP());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new PersonViewer());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new FogColor());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new ChinaHat());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new Snow());
        \u0445LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features.add(new CustomModels());
    }

    public List<Feature> getFeatureList() {
        FeatureManager LL\u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L;
        return LL\u0445\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.features;
    }

    public List<Feature> getFeaturesForCategory(Type \u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L) {
        FeatureManager LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L;
        ArrayList<Feature> L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L = new ArrayList<Feature>();
        Iterator<Feature> L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L = LL\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L.getFeatureList().iterator();
        if (L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L.hasNext()) {
            Feature \u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L = L\u0445L\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L.next();
            if (\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L.getType() == \u0445L\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L) {
                L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L.add(\u0445\u0445LL\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L);
            }
            return null;
        }
        return L\u0445\u0445L\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L;
    }

    public Feature getFeatureByClass(Class<? extends Feature> L\u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L) {
        FeatureManager \u0445LLLL\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L;
        Iterator<Feature> \u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L = \u0445LLLL\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L.getFeatureList().iterator();
        if (\u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L.hasNext()) {
            Feature LLLLL\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L = \u0445L\u0445LL\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L.next();
            if (LLLLL\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L != null && LLLLL\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L.getClass() == L\u0445LLL\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L) {
                return LLLLL\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L;
            }
            return null;
        }
        return null;
    }

    public Feature getFeatureByLabel(String \u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L) {
        FeatureManager LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L;
        Iterator<Feature> LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L = LL\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L.getFeatureList().iterator();
        if (LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L.hasNext()) {
            Feature \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L = LLLL\u0445\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L.next();
            if (\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L.getLabel().equals(\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L)) {
                return \u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445\u0445\u0445L\u0445L;
            }
            return null;
        }
        return null;
    }
}

