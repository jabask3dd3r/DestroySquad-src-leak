/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.packet.EventAttackSilent;
import org.Destroy.client.event.events.impl.packet.EventSendPacket;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.event.events.impl.render.EventRender3D;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.MathematicHelper;
import org.Destroy.client.helpers.math.RotationHelper;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.helpers.player.InventoryHelper;
import org.Destroy.client.helpers.player.KillAuraHelper;
import org.Destroy.client.helpers.player.MovementHelper;
import org.Destroy.client.helpers.render.RenderHelper;
import org.Destroy.client.helpers.world.EntityHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ColorSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.Destroy.client.ui.notification.NotificationManager;
import org.Destroy.client.ui.notification.NotificationType;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;

public class KillAura
extends Feature {
    public static TimerHelper oldTimerPvp = new TimerHelper();
    public static TimerHelper timer = new TimerHelper();
    public static BooleanSetting players;
    public static BooleanSetting animals;
    public static BooleanSetting team;
    public static BooleanSetting invis;
    public static BooleanSetting pets;
    public static BooleanSetting monsters;
    public static BooleanSetting armorStands;
    public static BooleanSetting walls;
    public static BooleanSetting bypass;
    public static ColorSetting targetHudColor;
    public static EntityLivingBase target;
    public static NumberSetting range;
    public static NumberSetting fov;
    public static BooleanSetting onlyCrit;
    public static NumberSetting hitChance;
    public static BooleanSetting shieldBreaker;
    public static NumberSetting breakerDelay;
    public static BooleanSetting autoDisable;
    public static BooleanSetting nakedPlayer;
    public static BooleanSetting sprinting;
    public static BooleanSetting weaponOnly;
    public static BooleanSetting clientLook;
    public static BooleanSetting visualYaw;
    public static BooleanSetting visualPitch;
    public static BooleanSetting shieldFixer;
    public static BooleanSetting randomRotation;
    public static NumberSetting randomYaw;
    public static NumberSetting randomPitch;
    public static BooleanSetting attackInInvetory;
    public static BooleanSetting autoShieldUnPress;
    public static NumberSetting critFallDistance;
    public static NumberSetting pitchValue;
    public static NumberSetting maxSpeedRotation;
    public static NumberSetting minSpeedRotation;
    public static NumberSetting attackCoolDown;
    public static BooleanSetting targetHud;
    public static BooleanSetting targetEsp;
    public static ListSetting targetEspMode;
    public static ColorSetting targetEspColor;
    public static NumberSetting points;
    public static NumberSetting circleRange;
    public static ListSetting rotationMode;
    public static ListSetting targetHudMode;
    public static ListSetting rotationStrafeMode;
    public static ListSetting sort;
    public static ListSetting swingMode;
    public static ListSetting clickMode;
    public static NumberSetting rotPredict;
    public static BooleanSetting raycast;
    private final TimerHelper blockTimer = new TimerHelper();
    private final TimerHelper shieldBreakerTimer = new TimerHelper();
    private double circleAnim;
    private boolean isBlocking;
    private int changeSlotCounter;
    private double direction = 1.0;
    private double yPos;
    private double progress = 0.0;
    private float delta = 0.0f;
    private long lastMS = System.currentTimeMillis();
    private long lastDeltaMS = 0L;

    public KillAura() {
        super("KillAura", "Automatically hits entities around you", Type.Combat);
        KillAura \u0445L\u0445L\u0445LLLLL\u0445LLLL;
        rotationMode = new ListSetting("Rotation", "Packet", () -> true, "Packet", "None", "SunRise");
        targetHudMode = new ListSetting("TargetHudMode", "Celestial", () -> targetHud.getBoolValue(), "Akrien", "Astolfo", "Flux", "Novoline Old", "Novoline New", "Lite", "Celestial");
        sort = new ListSetting("Priority", "Health", () -> true, "Distance", "Higher Armor", "Blocking Status", "Lowest Armor", "Health", "Angle", "HurtTime");
        clickMode = new ListSetting("PvP Mode", "1.9", () -> true, "1.9");
        visualYaw = new BooleanSetting("VisualYaw", "\u00d0\u009e\u00d1\u0082\u00d0\u00be\u00d0\u00b1\u00d1\u0080\u00d0\u00b0\u00d0\u00b6\u00d0\u00b5\u00d0\u00bd\u00d0\u00b8\u00d0\u00b5 \u00d0\u00b2\u00d0\u00b8\u00d0\u00b7\u00d1\u0083\u00d0\u00b0\u00d0\u00bb\u00d1\u008c\u00d0\u00bd\u00d0\u00be\u00d0\u00b9 \u00d1\u0080\u00d0\u00be\u00d1\u0082\u00d0\u00b0\u00d1\u0086\u00d0\u00b8\u00d0\u00b8", true, () -> KillAura.rotationMode.currentMode.equals("Packet"));
        visualPitch = new BooleanSetting("VisualPitch", "\u00d0\u009e\u00d1\u0082\u00d0\u00be\u00d0\u00b1\u00d1\u0080\u00d0\u00b0\u00d0\u00b6\u00d0\u00b5\u00d0\u00bd\u00d0\u00b8\u00d0\u00b5 \u00d0\u00b2\u00d0\u00b8\u00d0\u00b7\u00d1\u0083\u00d0\u00b0\u00d0\u00bb\u00d1\u008c\u00d0\u00bd\u00d0\u00be\u00d0\u00b9 \u00d1\u0080\u00d0\u00be\u00d1\u0082\u00d0\u00b0\u00d1\u0086\u00d0\u00b8\u00d0\u00b8", true, () -> KillAura.rotationMode.currentMode.equals("Packet"));
        fov = new NumberSetting("FOV", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d1\u0080\u00d0\u00b5\u00d0\u00b4\u00d0\u00b0\u00d0\u00ba\u00d1\u0082\u00d0\u00b8\u00d1\u0080\u00d0\u00be\u00d0\u00b2\u00d0\u00b0\u00d1\u0082\u00d1\u008c \u00d1\u0080\u00d0\u00b0\u00d0\u00b4\u00d0\u00b8\u00d1\u0083\u00d1\u0081 \u00d0\u00b2 \u00d0\u00ba\u00d0\u00be\u00d1\u0082\u00d0\u00be\u00d1\u0080\u00d0\u00be\u00d0\u00bc \u00d0\u00b2\u00d1\u008b \u00d0\u00bc\u00d0\u00be\u00d0\u00b6\u00d0\u00b5\u00d1\u0082\u00d0\u00b5 \u00d1\u0083\u00d0\u00b4\u00d0\u00b0\u00d1\u0080\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d0\u00b8\u00d0\u00b3\u00d1\u0080\u00d0\u00be\u00d0\u00ba\u00d0\u00b0", 180.0f, 5.0f, 180.0f, 5.0f, () -> true);
        attackCoolDown = new NumberSetting("Cool Down", "\u00d0\u00a0\u00d0\u00b5\u00d0\u00b4\u00d0\u00b0\u00d0\u00ba\u00d1\u0082\u00d0\u00b8\u00d1\u0080\u00d1\u0083\u00d0\u00b5\u00d1\u0082 \u00d1\u0081\u00d0\u00ba\u00d0\u00be\u00d1\u0080\u00d0\u00be\u00d1\u0081\u00d1\u0082\u00d1\u008c \u00d1\u0083\u00d0\u00b4\u00d0\u00b0\u00d1\u0080\u00d0\u00b0", 0.85f, 0.1f, 1.0f, 0.01f, () -> KillAura.clickMode.currentMode.equals("1.9"));
        hitChance = new NumberSetting("HitChance", "\u00d0\u00a8\u00d0\u00b0\u00d0\u00bd\u00d1\u0081 \u00d1\u0083\u00d0\u00b4\u00d0\u00b0\u00d1\u0080\u00d0\u00b0", 100.0f, 1.0f, 100.0f, 5.0f, () -> true);
        range = new NumberSetting("AttackRange", "\u00d0\u0094\u00d0\u00b8\u00d1\u0081\u00d1\u0082\u00d0\u00b0\u00d0\u00bd\u00d1\u0086\u00d0\u00b8\u00d1\u008f \u00d0\u00b2 \u00d0\u00ba\u00d0\u00be\u00d1\u0082\u00d0\u00be\u00d1\u0080\u00d0\u00be\u00d0\u00b9 \u00d0\u00b2\u00d1\u008b \u00d0\u00bc\u00d0\u00be\u00d0\u00b6\u00d0\u00b5\u00d1\u0082\u00d0\u00b5 \u00d1\u0083\u00d0\u00b4\u00d0\u00b0\u00d1\u0080\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d0\u00b8\u00d0\u00b3\u00d1\u0080\u00d0\u00be\u00d0\u00ba\u00d0\u00b0", 3.5f, 3.0f, 6.0f, 0.1f, () -> true);
        players = new BooleanSetting("AttackPlayers", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d0\u00b1\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d0\u00b8\u00d0\u00b3\u00d1\u0080\u00d0\u00be\u00d0\u00ba\u00d0\u00be\u00d0\u00b2", true, () -> true);
        armorStands = new BooleanSetting("Attack ArmorStands", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d0\u00b1\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d0\u00b0\u00d1\u0080\u00d0\u00bc\u00d0\u00be\u00d1\u0080-\u00d1\u0081\u00d1\u0082\u00d0\u00b5\u00d0\u00bd\u00d0\u00b4\u00d1\u008b", false, () -> true);
        monsters = new BooleanSetting("AttackMonsters", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d0\u00b1\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d0\u00bc\u00d0\u00be\u00d0\u00bd\u00d1\u0081\u00d1\u0082\u00d1\u0080\u00d0\u00be\u00d0\u00b2", false, () -> true);
        pets = new BooleanSetting("AttackPets", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d0\u00b1\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d0\u00bf\u00d1\u0080\u00d0\u00b8\u00d1\u0080\u00d1\u0083\u00d1\u0087\u00d0\u00b5\u00d0\u00bd\u00d0\u00bd\u00d1\u008b\u00d1\u0085 \u00d0\u00b6\u00d0\u00b8\u00d0\u00b2\u00d0\u00be\u00d1\u0082\u00d0\u00bd\u00d1\u008b\u00d1\u0085", false, () -> true);
        animals = new BooleanSetting("AttackAnimals", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d0\u00b1\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d0\u00b1\u00d0\u00b5\u00d0\u00b7\u00d0\u00be\u00d0\u00b1\u00d0\u00b8\u00d0\u00b4\u00d0\u00bd\u00d1\u008b\u00d1\u0085 \u00d0\u00bc\u00d0\u00be\u00d0\u00b1\u00d0\u00be\u00d0\u00b2", false, () -> true);
        team = new BooleanSetting("AttackTeams", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d0\u00b1\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d1\u0082\u00d0\u00b8\u00d0\u00bc\u00d0\u00b5\u00d0\u00b9\u00d1\u0082\u00d0\u00be\u00d0\u00b2 \u00d0\u00bd\u00d0\u00b0 \u00d0\u00bc\u00d0\u00b8\u00d0\u00bd\u00d0\u00b8-\u00d0\u00b8\u00d0\u00b3\u00d1\u0080\u00d0\u00b0\u00d1\u0085", false, () -> true);
        invis = new BooleanSetting("AttackInvisible", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d0\u00b1\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d0\u00bd\u00d0\u00b5\u00d0\u00b2\u00d0\u00b8\u00d0\u00b4\u00d0\u00b5\u00d0\u00bc\u00d1\u008b\u00d1\u0085 \u00d1\u0081\u00d1\u0083\u00d1\u0089\u00d0\u00b5\u00d1\u0081\u00d1\u0082\u00d0\u00b2", true, () -> true);
        nakedPlayer = new BooleanSetting("Ignore NakedPlayers", "\u00d0\u009d\u00d0\u00b5 \u00d0\u00b1\u00d1\u008c\u00d0\u00b5\u00d1\u0082 \u00d0\u00b3\u00d0\u00be\u00d0\u00bb\u00d1\u008b\u00d1\u0085 \u00d0\u00b8\u00d0\u00b3\u00d1\u0080\u00d0\u00be\u00d0\u00ba\u00d0\u00be\u00d0\u00b2", false, () -> true);
        walls = new BooleanSetting("Walls", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d0\u00b1\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d1\u0081\u00d0\u00ba\u00d0\u00b2\u00d0\u00be\u00d0\u00b7\u00d1\u008c \u00d1\u0081\u00d1\u0082\u00d0\u00b5\u00d0\u00bd\u00d1\u008b", true, () -> true);
        bypass = new BooleanSetting("Hit Through Walls Bypass", "\u00d0\u009e\u00d0\u00b1\u00d1\u0085\u00d0\u00be\u00d0\u00b4 \u00d1\u0083\u00d0\u00b4\u00d0\u00b0\u00d1\u0080\u00d0\u00be\u00d0\u00b2 \u00d1\u0081\u00d0\u00ba\u00d0\u00b2\u00d0\u00be\u00d0\u00b7\u00d1\u008c \u00d1\u0081\u00d1\u0082\u00d0\u00b5\u00d0\u00bd\u00d1\u0083", true, () -> true);
        sprinting = new BooleanSetting("Stop Sprinting", "\u00d0\u0090\u00d0\u00b2\u00d1\u0082\u00d0\u00be\u00d0\u00bc\u00d0\u00b0\u00d1\u0082\u00d0\u00b8\u00d1\u0087\u00d0\u00b5\u00d1\u0081\u00d0\u00ba\u00d0\u00b8 \u00d0\u00b2\u00d1\u008b\u00d0\u00ba\u00d0\u00bb\u00d1\u008e\u00d1\u0087\u00d0\u00b0\u00d0\u00b5\u00d1\u0082 \u00d1\u0081\u00d0\u00bf\u00d1\u0080\u00d0\u00b8\u00d0\u00bd\u00d1\u0082", false, () -> true);
        weaponOnly = new BooleanSetting("WeaponOnly", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d0\u00b1\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d1\u0082\u00d0\u00be\u00d0\u00bb\u00d1\u008c\u00d0\u00ba\u00d0\u00be \u00d1\u0081 \u00d0\u00be\u00d1\u0080\u00d1\u0083\u00d0\u00b6\u00d0\u00b8\u00d0\u00b5\u00d0\u00bc \u00d0\u00b2 \u00d1\u0080\u00d1\u0083\u00d0\u00ba\u00d0\u00b0\u00d1\u0085", false, () -> true);
        shieldBreaker = new BooleanSetting("ShieldBreaker", "\u00d0\u0090\u00d0\u00b2\u00d1\u0082\u00d0\u00be\u00d0\u00bc\u00d0\u00b0\u00d1\u0082\u00d0\u00b8\u00d1\u0087\u00d0\u00b5\u00d1\u0081\u00d0\u00ba\u00d0\u00b8 \u00d0\u00bb\u00d0\u00be\u00d0\u00bc\u00d0\u00b0\u00d0\u00b5\u00d1\u0082 \u00d1\u0089\u00d0\u00b8\u00d1\u0082 \u00d1\u0081\u00d0\u00be\u00d0\u00bf\u00d0\u00b5\u00d1\u0080\u00d0\u00bd\u00d0\u00b8\u00d0\u00ba\u00d1\u0083", true, () -> true);
        breakerDelay = new NumberSetting("BreakerDelay", "\u00d0\u00a0\u00d0\u00b5\u00d0\u00b3\u00d1\u0083\u00d0\u00bb\u00d0\u00b8\u00d1\u0080\u00d0\u00be\u00d0\u00b2\u00d0\u00ba\u00d0\u00b0 \u00d0\u00bb\u00d0\u00be\u00d0\u00bc\u00d0\u00b0\u00d0\u00bd\u00d0\u00b8\u00d1\u008f \u00d1\u0089\u00d0\u00b8\u00d1\u0082\u00d0\u00b0", 500.0f, 40.0f, 800.0f, 10.0f, () -> shieldBreaker.getBoolValue());
        shieldFixer = new BooleanSetting("ShieldSyncFix", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d0\u00b1\u00d0\u00b8\u00d1\u0082\u00d1\u008c \u00d0\u00b8\u00d0\u00b3\u00d1\u0080\u00d0\u00be\u00d0\u00ba\u00d0\u00be\u00d0\u00b2 \u00d1\u0087\u00d0\u00b5\u00d1\u0080\u00d0\u00b5\u00d0\u00b7 \u00d1\u0089\u00d0\u00b8\u00d1\u0082 (\u00d0\u00be\u00d0\u00b1\u00d1\u0085\u00d0\u00be\u00d0\u00b4)", true, () -> true);
        autoShieldUnPress = new BooleanSetting("ShieldDesync", "\u00d0\u0090\u00d0\u00b2\u00d1\u0082\u00d0\u00be\u00d0\u00bc\u00d0\u00b0\u00d1\u0082\u00d0\u00b8\u00d1\u0087\u00d0\u00b5\u00d1\u0081\u00d0\u00ba\u00d0\u00b8 \u00d0\u00be\u00d1\u0082\u00d0\u00b6\u00d0\u00b8\u00d0\u00bc\u00d0\u00b0\u00d0\u00b5\u00d1\u0082 \u00d1\u0089\u00d0\u00b8\u00d1\u0082 \u00d0\u00b5\u00d1\u0081\u00d0\u00bb\u00d0\u00b8 \u00d1\u0083 \u00d1\u0081\u00d0\u00be\u00d0\u00bf\u00d0\u00b5\u00d1\u0080\u00d0\u00bd\u00d0\u00b8\u00d0\u00ba\u00d0\u00b0 \u00d1\u0082\u00d0\u00be\u00d0\u00bf\u00d0\u00be\u00d1\u0080 \u00d0\u00b2 \u00d1\u0080\u00d1\u0083\u00d0\u00ba\u00d0\u00b0\u00d1\u0085", true, () -> true);
        autoDisable = new BooleanSetting("AutoDisable", "\u00d0\u0090\u00d0\u00b2\u00d1\u0082\u00d0\u00be\u00d0\u00bc\u00d0\u00b0\u00d1\u0082\u00d0\u00b8\u00d1\u0087\u00d0\u00b5\u00d1\u0081\u00d0\u00ba\u00d0\u00b8 \u00d0\u00b2\u00d1\u008b\u00d0\u00ba\u00d0\u00bb\u00d1\u008e\u00d1\u0087\u00d0\u00b0\u00d0\u00b5\u00d1\u0082 \u00d0\u00ba\u00d0\u00b8\u00d0\u00bb\u00d0\u00bb\u00d0\u00b0\u00d1\u0083\u00d1\u0080\u00d0\u00b0 \u00d0\u00bf\u00d1\u0080\u00d0\u00b8 \u00d1\u0081\u00d0\u00bc\u00d0\u00b5\u00d1\u0080\u00d1\u0082\u00d0\u00b8 \u00d0\u00b8 \u00d1\u0082.\u00d0\u00b4", false, () -> true);
        onlyCrit = new BooleanSetting("OnlyCritical", "\u00d0\u0091\u00d1\u008c\u00d0\u00b5\u00d1\u0082 \u00d0\u00b2 \u00d0\u00bd\u00d1\u0083\u00d0\u00b6\u00d0\u00bd\u00d1\u008b\u00d0\u00b9 \u00d0\u00bc\u00d0\u00be\u00d0\u00bc\u00d0\u00b5\u00d0\u00bd\u00d1\u0082 \u00d0\u00b4\u00d0\u00bb\u00d1\u008f \u00d0\u00ba\u00d1\u0080\u00d0\u00b8\u00d1\u0082\u00d0\u00b0", true, () -> true);
        critFallDistance = new NumberSetting("Criticals Fall Distance", "\u00d0\u00a0\u00d0\u00b5\u00d0\u00b3\u00d1\u0083\u00d0\u00bb\u00d0\u00b8\u00d1\u0080\u00d0\u00be\u00d0\u00b2\u00d0\u00ba\u00d0\u00b0 \u00d0\u00b4\u00d0\u00b8\u00d1\u0081\u00d1\u0082\u00d0\u00b0\u00d0\u00bd\u00d1\u0086\u00d0\u00b8\u00d0\u00b8 \u00d0\u00b4\u00d0\u00be \u00d0\u00b7\u00d0\u00b5\u00d0\u00bc\u00d0\u00bb\u00d0\u00b8 \u00d0\u00b4\u00d0\u00bb\u00d1\u008f \u00d0\u00ba\u00d1\u0080\u00d0\u00b8\u00d1\u0082\u00d0\u00b0", 0.2f, 0.1f, 1.0f, 0.01f, () -> onlyCrit.getBoolValue());
        targetHud = new BooleanSetting("TargetHUD", "\u00d0\u009e\u00d1\u0082\u00d0\u00be\u00d0\u00b1\u00d1\u0080\u00d0\u00b0\u00d0\u00b6\u00d0\u00b0\u00d0\u00b5\u00d1\u0082 \u00d1\u0085\u00d0\u00bf, \u00d0\u00b5\u00d0\u00b4\u00d1\u0083, \u00d0\u00b1\u00d1\u0080\u00d0\u00be\u00d0\u00bd\u00d1\u008e \u00d1\u0081\u00d0\u00be\u00d0\u00bf\u00d0\u00b5\u00d1\u0080\u00d0\u00bd\u00d0\u00b8\u00d0\u00ba\u00d0\u00b0 \u00d0\u00bd\u00d0\u00b0 \u00d1\u008d\u00d0\u00ba\u00d1\u0080\u00d0\u00b0\u00d0\u00bd\u00d0\u00b5", true, () -> true);
        targetHudColor = new ColorSetting("TargetHUD Color", new Color(-2305322, true).getRGB(), () -> targetHud.getBoolValue() && (KillAura.targetHudMode.currentMode.equals("Astolfo") || KillAura.targetHudMode.currentMode.equals("Novoline Old") || KillAura.targetHudMode.currentMode.equals("Novoline New") || KillAura.targetHudMode.currentMode.equals("Lite")));
        \u0445L\u0445L\u0445LLLLL\u0445LLLL.addSettings(rotationMode, swingMode, clickMode, sort, attackCoolDown, targetHud, targetHudMode, targetHudColor, targetEsp, targetEspMode, targetEspColor, circleRange, points, fov, range, hitChance, rotPredict, minSpeedRotation, maxSpeedRotation, pitchValue, randomRotation, randomYaw, randomPitch, visualYaw, visualPitch, clientLook, raycast, players, armorStands, monsters, animals, pets, invis, team, nakedPlayer, attackInInvetory, walls, bypass, sprinting, weaponOnly, autoShieldUnPress, shieldFixer, shieldBreaker, autoDisable, onlyCrit, critFallDistance, breakerDelay);
    }

    public static Color setAlpha(Color \u0445LL\u0445\u0445LLLLL\u0445LLLL, int L\u0445L\u0445\u0445LLLLL\u0445LLLL) {
        L\u0445L\u0445\u0445LLLLL\u0445LLLL = MathHelper.clamp(L\u0445L\u0445\u0445LLLLL\u0445LLLL, 0, 255);
        return new Color(\u0445LL\u0445\u0445LLLLL\u0445LLLL.getRed(), \u0445LL\u0445\u0445LLLLL\u0445LLLL.getGreen(), \u0445LL\u0445\u0445LLLLL\u0445LLLL.getBlue(), L\u0445L\u0445\u0445LLLLL\u0445LLLL);
    }

    public static float changer(float \u0445LLLL\u0445LLLL\u0445LLLL, float L\u0445LLL\u0445LLLL\u0445LLLL, float \u0445\u0445LLL\u0445LLLL\u0445LLLL, float LL\u0445LL\u0445LLLL\u0445LLLL) {
        if ((\u0445LLLL\u0445LLLL\u0445LLLL += L\u0445LLL\u0445LLLL\u0445LLLL) > LL\u0445LL\u0445LLLL\u0445LLLL) {
            \u0445LLLL\u0445LLLL\u0445LLLL = LL\u0445LL\u0445LLLL\u0445LLLL;
        }
        if (\u0445LLLL\u0445LLLL\u0445LLLL < \u0445\u0445LLL\u0445LLLL\u0445LLLL) {
            \u0445LLLL\u0445LLLL\u0445LLLL = \u0445\u0445LLL\u0445LLLL\u0445LLLL;
        }
        return \u0445LLLL\u0445LLLL\u0445LLLL;
    }

    public static void pre3D() {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glHint(3154, 4354);
        GL11.glDisable(2884);
    }

    public static void post3D() {
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @EventTarget
    public void onPreAttack(EventPreMotion \u0445LLL\u0445\u0445LLLL\u0445LLLL) {
        KillAura LLLL\u0445\u0445LLLL\u0445LLLL;
        if (KillAura.mc.currentScreen instanceof GuiContainer && !attackInInvetory.getBoolValue()) {
            return;
        }
        if (KillAura.mc.player.getHealth() > 0.0f) {
            float \u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLLL;
            if (autoDisable.getBoolValue()) {
                KillAuraHelper.toggleOffChecks();
            }
            String \u0445L\u0445\u0445L\u0445LLLL\u0445LLLL = rotationMode.getOptions();
            LLLL\u0445\u0445LLLL\u0445LLLL.setSuffix(\u0445L\u0445\u0445L\u0445LLLL\u0445LLLL + ", " + MathematicHelper.round(range.getNumberValue(), 1));
            target = KillAuraHelper.getSortEntities();
            if (target == null) {
                return;
            }
            float L\u0445\u0445\u0445L\u0445LLLL\u0445LLLL = KillAura.rotationMode.currentMode.equals("Packet") ? RotationHelper.Rotation.packetYaw : KillAura.mc.player.rotationYaw;
            float f2 = \u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLLL = KillAura.rotationMode.currentMode.equals("Packet") ? RotationHelper.Rotation.packetPitch : KillAura.mc.player.rotationPitch;
            if (!RotationHelper.isLookingAtEntity(L\u0445\u0445\u0445L\u0445LLLL\u0445LLLL, \u0445\u0445\u0445\u0445L\u0445LLLL\u0445LLLL, 0.06f, 0.06f, 0.06f, target, range.getNumberValue()) && raycast.getBoolValue()) {
                return;
            }
            if (!(KillAura.mc.player.getHeldItemMainhand().getItem() instanceof ItemSword) && !(KillAura.mc.player.getHeldItemMainhand().getItem() instanceof ItemAxe) && weaponOnly.getBoolValue()) {
                return;
            }
        } else if (autoDisable.getBoolValue()) {
            LLLL\u0445\u0445LLLL\u0445LLLL.getState();
            NotificationManager.publicity("KillAura", "KillAura was disabled because of Death!", 3, NotificationType.INFO);
        }
        if (MovementHelper.isBlockAboveHead() ? !(KillAura.mc.player.fallDistance >= critFallDistance.getNumberValue()) && KillAura.mc.player.getCooledAttackStrength(0.8f) == 1.0f && onlyCrit.getBoolValue() && !KillAura.mc.player.isOnLadder() && !KillAura.mc.player.isInLiquid() && !KillAura.mc.player.isInWeb : KillAura.mc.player.fallDistance != 0.0f && onlyCrit.getBoolValue() && !KillAura.mc.player.isOnLadder() && !KillAura.mc.player.isInWeb || KillAura.mc.world.getBlockState(KillAura.mc.player.getPosition()).getMaterial().isLiquid()) {
            return;
        }
        LLLL\u0445\u0445LLLL\u0445LLLL.attackEntitySuccess(target);
    }

    @Override
    public void onDisable() {
        KillAura \u0445\u0445\u0445L\u0445\u0445LLLL\u0445LLLL;
        target = null;
        if (\u0445\u0445\u0445L\u0445\u0445LLLL\u0445LLLL.isBlocking) {
            KillAura.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
            \u0445\u0445\u0445L\u0445\u0445LLLL\u0445LLLL.isBlocking = false;
        }
        super.onDisable();
    }

    @EventTarget
    public void onSendPacket(EventSendPacket \u0445L\u0445\u0445\u0445\u0445LLLL\u0445LLLL) {
        if (\u0445L\u0445\u0445\u0445\u0445LLLL\u0445LLLL.getPacket() instanceof CPacketUseEntity) {
            CPacketUseEntity \u0445\u0445L\u0445\u0445\u0445LLLL\u0445LLLL = (CPacketUseEntity)\u0445L\u0445\u0445\u0445\u0445LLLL\u0445LLLL.getPacket();
            if (\u0445\u0445L\u0445\u0445\u0445LLLL\u0445LLLL.getAction() == CPacketUseEntity.Action.INTERACT) {
                \u0445L\u0445\u0445\u0445\u0445LLLL\u0445LLLL.setCancelled(true);
            }
            if (\u0445\u0445L\u0445\u0445\u0445LLLL\u0445LLLL.getAction() == CPacketUseEntity.Action.INTERACT_AT) {
                \u0445L\u0445\u0445\u0445\u0445LLLL\u0445LLLL.setCancelled(true);
            }
        }
    }

    @EventTarget
    public void onUpdate(EventUpdate LL\u0445LLL\u0445LLL\u0445LLLL) {
        if (autoShieldUnPress.getBoolValue()) {
            if (target.getHeldItemMainhand().getItem() instanceof ItemAxe) {
                boolean L\u0445LLLL\u0445LLL\u0445LLLL;
                if ((double)KillAura.mc.player.getCooledAttackStrength(8.0f) < 0.9) {
                    boolean \u0445LLLLL\u0445LLL\u0445LLLL = true;
                } else {
                    L\u0445LLLL\u0445LLL\u0445LLLL = false;
                }
                KillAura.mc.gameSettings.keyBindUseItem.pressed = L\u0445LLLL\u0445LLL\u0445LLLL;
            } else {
                return;
            }
        }
    }

    @EventTarget
    public void onAttackSilent(EventAttackSilent \u0445\u0445\u0445LLL\u0445LLL\u0445LLLL) {
        if (KillAura.mc.player.isBlocking() && KillAura.mc.player.getHeldItemOffhand().getItem() instanceof ItemShield && shieldFixer.getBoolValue()) {
            KillAura.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos(-0.8, -0.8, -0.8), EnumFacing.DOWN));
            KillAura.mc.playerController.processRightClick(KillAura.mc.player, KillAura.mc.world, EnumHand.OFF_HAND);
        }
    }

    private void attackEntitySuccess(EntityLivingBase L\u0445\u0445\u0445LL\u0445LLL\u0445LLLL) {
        if (KillAura.mc.currentScreen instanceof GuiContainer && !attackInInvetory.getBoolValue()) {
            return;
        }
        if (L\u0445\u0445\u0445LL\u0445LLL\u0445LLLL.getHealth() > 0.0f) {
            switch (clickMode.getOptions()) {
                case "1.9": {
                    float LL\u0445\u0445LL\u0445LLL\u0445LLLL = attackCoolDown.getNumberValue();
                    if (KillAura.mc.player.getCooledAttackStrength(LL\u0445\u0445LL\u0445LLL\u0445LLLL) != 1.0f || !((float)ThreadLocalRandom.current().nextInt(100) < hitChance.getNumberValue())) break;
                    KillAura.mc.playerController.attackEntity(KillAura.mc.player, EntityHelper.rayCast(L\u0445\u0445\u0445LL\u0445LLL\u0445LLLL, range.getNumberValue()));
                    if (KillAura.swingMode.currentMode.equals("Client")) {
                        KillAura.mc.player.swingArm(EnumHand.MAIN_HAND);
                        break;
                    }
                    if (!KillAura.swingMode.currentMode.equals("Server")) break;
                    KillAura.mc.player.connection.sendPacket(new CPacketAnimation(EnumHand.MAIN_HAND));
                }
            }
        }
    }

    @EventTarget
    public void onRotations(EventPreMotion L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LLLL) {
        if (KillAura.mc.currentScreen instanceof GuiContainer && !attackInInvetory.getBoolValue()) {
            return;
        }
        String \u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LLLL = rotationMode.getOptions();
        if (target == null) {
            return;
        }
        if (target.getHealth() > 0.0f) {
            if (!(KillAura.mc.player.getHeldItemMainhand().getItem() instanceof ItemSword) && !(KillAura.mc.player.getHeldItemMainhand().getItem() instanceof ItemAxe) && weaponOnly.getBoolValue()) {
                return;
            }
            float[] \u0445\u0445L\u0445\u0445L\u0445LLL\u0445LLLL = RotationHelper.getRotations(target, randomRotation.getBoolValue(), maxSpeedRotation.getNumberValue(), minSpeedRotation.getNumberValue(), randomYaw.getNumberValue(), randomPitch.getNumberValue());
            float[] LL\u0445\u0445\u0445L\u0445LLL\u0445LLLL = RotationHelper.getRotations(target, false, maxSpeedRotation.getNumberValue(), minSpeedRotation.getNumberValue(), randomYaw.getNumberValue(), randomPitch.getNumberValue());
            if (\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LLLL.equalsIgnoreCase("Packet")) {
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LLLL.setYaw(\u0445\u0445L\u0445\u0445L\u0445LLL\u0445LLLL[0]);
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LLLL.setPitch(\u0445\u0445L\u0445\u0445L\u0445LLL\u0445LLLL[1]);
                if (visualYaw.getBoolValue()) {
                    KillAura.mc.player.renderYawOffset = \u0445\u0445L\u0445\u0445L\u0445LLL\u0445LLLL[0];
                    KillAura.mc.player.rotationYawHead = \u0445\u0445L\u0445\u0445L\u0445LLL\u0445LLLL[0];
                }
                if (visualPitch.getBoolValue()) {
                    KillAura.mc.player.rotationPitchHead = \u0445\u0445L\u0445\u0445L\u0445LLL\u0445LLLL[1];
                }
                if (clientLook.getBoolValue()) {
                    KillAura.mc.player.rotationYaw = LL\u0445\u0445\u0445L\u0445LLL\u0445LLLL[0];
                    KillAura.mc.player.rotationPitch = LL\u0445\u0445\u0445L\u0445LLL\u0445LLLL[1];
                }
            }
            if (\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445LLLL.equalsIgnoreCase("SunRise")) {
                float \u0445LL\u0445\u0445L\u0445LLL\u0445LLLL = 0.0f;
                float L\u0445L\u0445\u0445L\u0445LLL\u0445LLLL = 0.0f;
                \u0445LL\u0445\u0445L\u0445LLL\u0445LLLL = RotationHelper.updateRotation1(\u0445\u0445L\u0445\u0445L\u0445LLL\u0445LLLL[0], \u0445LL\u0445\u0445L\u0445LLL\u0445LLLL, 1.0f);
                L\u0445L\u0445\u0445L\u0445LLL\u0445LLLL = RotationHelper.updateRotation1(\u0445\u0445L\u0445\u0445L\u0445LLL\u0445LLLL[1], L\u0445L\u0445\u0445L\u0445LLL\u0445LLLL, 2.0f);
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LLLL.setYaw(\u0445LL\u0445\u0445L\u0445LLL\u0445LLLL);
                L\u0445\u0445\u0445\u0445L\u0445LLL\u0445LLLL.setPitch(L\u0445L\u0445\u0445L\u0445LLL\u0445LLLL);
                if (visualYaw.getBoolValue()) {
                    KillAura.mc.player.renderYawOffset = \u0445LL\u0445\u0445L\u0445LLL\u0445LLLL;
                    KillAura.mc.player.rotationYawHead = \u0445LL\u0445\u0445L\u0445LLL\u0445LLLL;
                }
                if (visualPitch.getBoolValue()) {
                    KillAura.mc.player.rotationPitchHead = L\u0445L\u0445\u0445L\u0445LLL\u0445LLLL;
                }
                if (clientLook.getBoolValue()) {
                    KillAura.mc.player.rotationYaw = \u0445LL\u0445\u0445L\u0445LLL\u0445LLLL;
                    KillAura.mc.player.rotationPitch = \u0445LL\u0445\u0445L\u0445LLL\u0445LLLL;
                }
            }
        }
    }

    @EventTarget
    public void onPreMotion(EventPreMotion L\u0445L\u0445L\u0445\u0445LLL\u0445LLLL) {
        float LL\u0445\u0445L\u0445\u0445LLL\u0445LLLL;
        if (target == null) {
            return;
        }
        if (!InventoryHelper.doesHotbarHaveAxe()) {
            return;
        }
        float \u0445\u0445L\u0445L\u0445\u0445LLL\u0445LLLL = KillAura.rotationMode.currentMode.equals("Packet") ? RotationHelper.Rotation.packetYaw : KillAura.mc.player.rotationYaw;
        float f2 = LL\u0445\u0445L\u0445\u0445LLL\u0445LLLL = KillAura.rotationMode.currentMode.equals("Packet") ? RotationHelper.Rotation.packetPitch : KillAura.mc.player.rotationPitch;
        if (shieldBreaker.getBoolValue() && (target.getHeldItemOffhand().getItem() instanceof ItemShield || target.getHeldItemMainhand().getItem() instanceof ItemShield)) {
            KillAura \u0445LL\u0445L\u0445\u0445LLL\u0445LLLL;
            if (target.isBlocking()) {
                if (target.canEntityBeSeen(KillAura.mc.player) && KillAura.mc.player.canEntityBeSeen(target) && RotationHelper.isLookingAtEntity(\u0445\u0445L\u0445L\u0445\u0445LLL\u0445LLLL, LL\u0445\u0445L\u0445\u0445LLL\u0445LLLL, 0.2f, 0.2f, 0.2f, target, range.getNumberValue())) {
                    if (\u0445LL\u0445L\u0445\u0445LLL\u0445LLLL.shieldBreakerTimer.hasReached(breakerDelay.getNumberValue())) {
                        if (KillAura.mc.player.inventory.currentItem != InventoryHelper.getAxe()) {
                            KillAura.mc.player.inventory.currentItem = InventoryHelper.getAxe();
                            KillAura.mc.player.connection.sendPacket(new CPacketHeldItemChange(KillAura.mc.player.inventory.currentItem));
                            KillAura.mc.player.resetCooldown();
                        }
                        \u0445LL\u0445L\u0445\u0445LLL\u0445LLLL.shieldBreakerTimer.reset();
                    }
                    if (KillAura.mc.player.inventory.currentItem == InventoryHelper.getAxe()) {
                        KillAura.mc.playerController.attackEntity(KillAura.mc.player, EntityHelper.rayCast(target, range.getNumberValue()));
                        KillAura.mc.player.swingArm(EnumHand.MAIN_HAND);
                        KillAura.mc.player.resetCooldown();
                        \u0445LL\u0445L\u0445\u0445LLL\u0445LLLL.changeSlotCounter = -1;
                    } else {
                        \u0445LL\u0445L\u0445\u0445LLL\u0445LLLL.changeSlotCounter = 0;
                    }
                }
            } else if (!(KillAura.mc.player.inventory.currentItem == InventoryHelper.getSwordAtHotbar() || \u0445LL\u0445L\u0445\u0445LLL\u0445LLLL.changeSlotCounter != -1 || InventoryHelper.getSwordAtHotbar() == -1 || target.isBlocking() && target.isHandActive() && target.isActiveItemStackBlocking())) {
                KillAura.mc.player.resetCooldown();
                KillAura.mc.player.inventory.currentItem = InventoryHelper.getSwordAtHotbar();
                KillAura.mc.player.connection.sendPacket(new CPacketHeldItemChange(KillAura.mc.player.inventory.currentItem));
                \u0445LL\u0445L\u0445\u0445LLL\u0445LLLL.changeSlotCounter = 0;
            }
        }
    }

    @EventTarget
    public void onUpdateA(EventUpdate L\u0445LL\u0445\u0445\u0445LLL\u0445LLLL) {
        if (KillAura.targetEspMode.currentMode.equals("Jello")) {
            KillAura \u0445LLL\u0445\u0445\u0445LLL\u0445LLLL;
            \u0445LLL\u0445\u0445\u0445LLL\u0445LLLL.delta = KillAura.changer(\u0445LLL\u0445\u0445\u0445LLL\u0445LLLL.delta, target != null ? 0.1f : -0.1f, 0.0f, 0.007843138f);
        }
    }

    @EventTarget
    public void onRender3D(EventRender3D L\u0445L\u0445L\u0445L\u0445LL\u0445LLLL) {
        if (target != null && targetEsp.getBoolValue()) {
            switch (KillAura.targetEspMode.currentMode) {
                case "Default": {
                    double L\u0445\u0445\u0445LLL\u0445LL\u0445LLLL = KillAura.target.lastTickPosX + (KillAura.target.posX - KillAura.target.lastTickPosX) * (double)KillAura.mc.timer.renderPartialTicks - KillAura.mc.getRenderManager().renderPosX;
                    double \u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLLL = KillAura.target.lastTickPosY + (KillAura.target.posY - KillAura.target.lastTickPosY) * (double)KillAura.mc.timer.renderPartialTicks - KillAura.mc.getRenderManager().renderPosY;
                    double LLLL\u0445LL\u0445LL\u0445LLLL = KillAura.target.lastTickPosZ + (KillAura.target.posZ - KillAura.target.lastTickPosZ) * (double)KillAura.mc.timer.renderPartialTicks - KillAura.mc.getRenderManager().renderPosZ;
                    double \u0445LLL\u0445LL\u0445LL\u0445LLLL = (double)target.getEyeHeight() + 0.35;
                    double L\u0445LL\u0445LL\u0445LL\u0445LLLL = target.isSneaking() ? 0.25 : 0.0;
                    GL11.glPushMatrix();
                    GlStateManager.enable(3042);
                    GlStateManager.blendFunc(770, 771);
                    GlStateManager.translate((L\u0445\u0445\u0445LLL\u0445LL\u0445LLLL -= 0.5) + 0.5, (\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLLL += \u0445LLL\u0445LL\u0445LL\u0445LLLL - L\u0445LL\u0445LL\u0445LL\u0445LLLL) + 0.5, (LLLL\u0445LL\u0445LL\u0445LLLL -= 0.5) + 0.5);
                    GlStateManager.rotate(-KillAura.target.rotationYaw % 360.0f, 0.0f, 1.0f, 0.0f);
                    GlStateManager.translate(-(L\u0445\u0445\u0445LLL\u0445LL\u0445LLLL + 0.5), -(\u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLLL + 0.5), -(LLLL\u0445LL\u0445LL\u0445LLLL + 0.5));
                    GlStateManager.disable(3553);
                    GlStateManager.enable(2848);
                    GlStateManager.disable(2929);
                    GlStateManager.depthMask(false);
                    RenderHelper.setColor(targetEspColor.getColorValue());
                    RenderHelper.drawColorBox(new AxisAlignedBB(L\u0445\u0445\u0445LLL\u0445LL\u0445LLLL, \u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLLL, LLLL\u0445LL\u0445LL\u0445LLLL, L\u0445\u0445\u0445LLL\u0445LL\u0445LLLL + 1.0, \u0445\u0445\u0445\u0445LLL\u0445LL\u0445LLLL + 0.05, LLLL\u0445LL\u0445LL\u0445LLLL + 1.0), 0.0f, 0.0f, 0.0f, 0.0f);
                    GlStateManager.disable(2848);
                    GlStateManager.enable(3553);
                    GlStateManager.enable(2929);
                    GlStateManager.depthMask(true);
                    GlStateManager.disable(3042);
                    GL11.glPopMatrix();
                    break;
                }
                case "Jello": {
                    KillAura \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL;
                    double LLL\u0445\u0445LL\u0445LL\u0445LLLL = \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.yPos;
                    if (\u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.delta > 0.0f) {
                        if (System.currentTimeMillis() - \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.lastMS >= 1000L) {
                            \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.direction = -\u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.direction;
                            \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.lastMS = System.currentTimeMillis();
                        }
                        long \u0445\u0445LL\u0445LL\u0445LL\u0445LLLL = \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.direction > 0.0 ? System.currentTimeMillis() - \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.lastMS : 1000L - (System.currentTimeMillis() - \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.lastMS);
                        \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.progress = (double)\u0445\u0445LL\u0445LL\u0445LL\u0445LLLL / 1000.0;
                        \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.lastDeltaMS = System.currentTimeMillis() - \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.lastMS;
                    } else {
                        \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.lastMS = System.currentTimeMillis() - \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.lastDeltaMS;
                    }
                    AxisAlignedBB \u0445LL\u0445\u0445LL\u0445LL\u0445LLLL = target.getEntityBoundingBox();
                    double L\u0445L\u0445\u0445LL\u0445LL\u0445LLLL = \u0445LL\u0445\u0445LL\u0445LL\u0445LLLL.maxX - \u0445LL\u0445\u0445LL\u0445LL\u0445LLLL.minX;
                    double \u0445\u0445L\u0445\u0445LL\u0445LL\u0445LLLL = \u0445LL\u0445\u0445LL\u0445LL\u0445LLLL.maxY - \u0445LL\u0445\u0445LL\u0445LL\u0445LLLL.minY;
                    double LL\u0445\u0445\u0445LL\u0445LL\u0445LLLL = KillAura.target.lastTickPosX + (KillAura.target.posX - KillAura.target.lastTickPosX) * (double)KillAura.mc.timer.renderPartialTicks;
                    double \u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLLL = KillAura.target.lastTickPosY + (KillAura.target.posY - KillAura.target.lastTickPosY) * (double)KillAura.mc.timer.renderPartialTicks;
                    double L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLLL = KillAura.target.lastTickPosZ + (KillAura.target.posZ - KillAura.target.lastTickPosZ) * (double)KillAura.mc.timer.renderPartialTicks;
                    \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.yPos = KillAura.easeInOutQuart(\u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.progress) * \u0445\u0445L\u0445\u0445LL\u0445LL\u0445LLLL;
                    double \u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLLL = (\u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.direction > 0.0 ? \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.yPos - LLL\u0445\u0445LL\u0445LL\u0445LLLL : LLL\u0445\u0445LL\u0445LL\u0445LLLL - \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.yPos) * -\u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.direction * 5.0;
                    Color LLLLL\u0445L\u0445LL\u0445LLLL = new Color(targetEspColor.getColorValue());
                    float \u0445LLLL\u0445L\u0445LL\u0445LLLL = (float)LLLLL\u0445L\u0445LL\u0445LLLL.getRed() / 255.0f;
                    float L\u0445LLL\u0445L\u0445LL\u0445LLLL = (float)LLLLL\u0445L\u0445LL\u0445LLLL.getGreen() / 255.0f;
                    float \u0445\u0445LLL\u0445L\u0445LL\u0445LLLL = (float)LLLLL\u0445L\u0445LL\u0445LLLL.getBlue() / 255.0f;
                    KillAura.pre3D();
                    GL11.glTranslated(-KillAura.mc.getRenderManager().renderPosX, -KillAura.mc.getRenderManager().renderPosY, -KillAura.mc.getRenderManager().renderPosZ);
                    GL11.glBegin(8);
                    int \u0445\u0445\u0445L\u0445LL\u0445LL\u0445LLLL = 0;
                    if (\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LLLL <= 360) {
                        double LL\u0445L\u0445LL\u0445LL\u0445LLLL = (double)\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LLLL * Math.PI / 180.0;
                        double \u0445L\u0445L\u0445LL\u0445LL\u0445LLLL = LL\u0445\u0445\u0445LL\u0445LL\u0445LLLL - Math.sin(LL\u0445L\u0445LL\u0445LL\u0445LLLL) * L\u0445L\u0445\u0445LL\u0445LL\u0445LLLL;
                        double L\u0445\u0445L\u0445LL\u0445LL\u0445LLLL = L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLLL + Math.cos(LL\u0445L\u0445LL\u0445LL\u0445LLLL) * L\u0445L\u0445\u0445LL\u0445LL\u0445LLLL;
                        GL11.glColor4f(\u0445LLLL\u0445L\u0445LL\u0445LLLL, L\u0445LLL\u0445L\u0445LL\u0445LLLL, \u0445\u0445LLL\u0445L\u0445LL\u0445LLLL, 0.0f);
                        GL11.glVertex3d(\u0445L\u0445L\u0445LL\u0445LL\u0445LLLL, \u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLLL + \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.yPos + \u0445\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLLL, L\u0445\u0445L\u0445LL\u0445LL\u0445LLLL);
                        GL11.glColor4f(\u0445LLLL\u0445L\u0445LL\u0445LLLL, L\u0445LLL\u0445L\u0445LL\u0445LLLL, \u0445\u0445LLL\u0445L\u0445LL\u0445LLLL, \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.delta * 255.0f);
                        GL11.glVertex3d(\u0445L\u0445L\u0445LL\u0445LL\u0445LLLL, \u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLLL + \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.yPos, L\u0445\u0445L\u0445LL\u0445LL\u0445LLLL);
                        ++\u0445\u0445\u0445L\u0445LL\u0445LL\u0445LLLL;
                        return;
                    }
                    GL11.glEnd();
                    \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.drawCircle(LL\u0445\u0445\u0445LL\u0445LL\u0445LLLL, \u0445L\u0445\u0445\u0445LL\u0445LL\u0445LLLL + \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.yPos, L\u0445\u0445\u0445\u0445LL\u0445LL\u0445LLLL, L\u0445L\u0445\u0445LL\u0445LL\u0445LLLL, \u0445LLLL\u0445L\u0445LL\u0445LLLL, L\u0445LLL\u0445L\u0445LL\u0445LLLL, \u0445\u0445LLL\u0445L\u0445LL\u0445LLLL, \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.delta * 130.0f);
                    KillAura.post3D();
                    break;
                }
                case "Sims": {
                    float LL\u0445LL\u0445L\u0445LL\u0445LLLL = 0.15f;
                    GL11.glPushMatrix();
                    double \u0445L\u0445LL\u0445L\u0445LL\u0445LLLL = KillAura.target.lastTickPosX + (KillAura.target.posX - KillAura.target.lastTickPosX) * (double)KillAura.mc.timer.renderPartialTicks;
                    double L\u0445\u0445LL\u0445L\u0445LL\u0445LLLL = KillAura.target.lastTickPosY + (KillAura.target.posY - KillAura.target.lastTickPosY) * (double)KillAura.mc.timer.renderPartialTicks;
                    double \u0445\u0445\u0445LL\u0445L\u0445LL\u0445LLLL = KillAura.target.lastTickPosZ + (KillAura.target.posZ - KillAura.target.lastTickPosZ) * (double)KillAura.mc.timer.renderPartialTicks;
                    GL11.glTranslated(\u0445L\u0445LL\u0445L\u0445LL\u0445LLLL, L\u0445\u0445LL\u0445L\u0445LL\u0445LLLL, \u0445\u0445\u0445LL\u0445L\u0445LL\u0445LLLL);
                    GL11.glRotatef(-KillAura.target.width, 0.0f, 1.0f, 0.0f);
                    KillAura.pre3D();
                    RenderHelper.setColor(targetEspColor.getColorValue());
                    GL11.glLineWidth(1.5f);
                    Cylinder LLL\u0445L\u0445L\u0445LL\u0445LLLL = new Cylinder();
                    GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                    LLL\u0445L\u0445L\u0445LL\u0445LLLL.draw(0.0f, LL\u0445LL\u0445L\u0445LL\u0445LLLL, 0.3f, 4, 1);
                    LLL\u0445L\u0445L\u0445LL\u0445LLLL.setDrawStyle(100012);
                    GL11.glTranslated(0.0, 0.0, 0.3f);
                    LLL\u0445L\u0445L\u0445LL\u0445LLLL.draw(LL\u0445LL\u0445L\u0445LL\u0445LLLL, 0.0f, 0.3f, 4, 1);
                    GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslated(0.0, 0.0, -0.3f);
                    LLL\u0445L\u0445L\u0445LL\u0445LLLL.draw(0.0f, LL\u0445LL\u0445L\u0445LL\u0445LLLL, 0.3f, 4, 1);
                    GL11.glTranslated(0.0, 0.0, 0.3f);
                    LLL\u0445L\u0445L\u0445LL\u0445LLLL.draw(LL\u0445LL\u0445L\u0445LL\u0445LLLL, 0.0f, 0.3f, 4, 1);
                    KillAura.post3D();
                    GL11.glPopMatrix();
                    break;
                }
                case "Astolfo": {
                    KillAura \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL;
                    if (target == null) break;
                    if (target.getHealth() > 0.0f) {
                        \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.circleAnim += (double)0.015f * Minecraft.frameTime / 10.0;
                        RenderHelper.drawCircle3D(target, \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.circleAnim + 0.001, L\u0445L\u0445L\u0445L\u0445LL\u0445LLLL.getPartialTicks(), (int)points.getNumberValue(), 4.0f, Color.black.getRGB());
                        RenderHelper.drawCircle3D(target, \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.circleAnim - 0.001, L\u0445L\u0445L\u0445L\u0445LL\u0445LLLL.getPartialTicks(), (int)points.getNumberValue(), 4.0f, Color.black.getRGB());
                        RenderHelper.drawCircle3D(target, \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.circleAnim, L\u0445L\u0445L\u0445L\u0445LL\u0445LLLL.getPartialTicks(), (int)points.getNumberValue(), 2.0f, targetEspColor.getColorValue());
                        \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.circleAnim = MathHelper.clamp(\u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.circleAnim, 0.0, (double)circleRange.getNumberValue());
                        break;
                    }
                    \u0445LL\u0445L\u0445L\u0445LL\u0445LLLL.circleAnim = 0.0;
                }
            }
        }
    }

    private void drawCircle(double LL\u0445L\u0445L\u0445\u0445LL\u0445LLLL, double \u0445L\u0445L\u0445L\u0445\u0445LL\u0445LLLL, double L\u0445\u0445L\u0445L\u0445\u0445LL\u0445LLLL, double \u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445LLLL, float LLL\u0445\u0445L\u0445\u0445LL\u0445LLLL, float \u0445LL\u0445\u0445L\u0445\u0445LL\u0445LLLL, float L\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLLL, float \u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLLL) {
        GL11.glLineWidth(3.0f);
        GL11.glBegin(2);
        GL11.glColor4f(LLL\u0445\u0445L\u0445\u0445LL\u0445LLLL, \u0445LL\u0445\u0445L\u0445\u0445LL\u0445LLLL, L\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLLL, \u0445\u0445L\u0445\u0445L\u0445\u0445LL\u0445LLLL);
        int L\u0445LL\u0445L\u0445\u0445LL\u0445LLLL = 0;
        if (L\u0445LL\u0445L\u0445\u0445LL\u0445LLLL <= 360) {
            double LLLL\u0445L\u0445\u0445LL\u0445LLLL = LL\u0445L\u0445L\u0445\u0445LL\u0445LLLL - Math.sin((double)L\u0445LL\u0445L\u0445\u0445LL\u0445LLLL * Math.PI / 180.0) * \u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445LLLL;
            double \u0445LLL\u0445L\u0445\u0445LL\u0445LLLL = L\u0445\u0445L\u0445L\u0445\u0445LL\u0445LLLL + Math.cos((double)L\u0445LL\u0445L\u0445\u0445LL\u0445LLLL * Math.PI / 180.0) * \u0445\u0445\u0445L\u0445L\u0445\u0445LL\u0445LLLL;
            GL11.glVertex3d(LLLL\u0445L\u0445\u0445LL\u0445LLLL, \u0445L\u0445L\u0445L\u0445\u0445LL\u0445LLLL, \u0445LLL\u0445L\u0445\u0445LL\u0445LLLL);
            ++L\u0445LL\u0445L\u0445\u0445LL\u0445LLLL;
            return;
        }
        GL11.glEnd();
    }

    public static double easeInOutQuart(double LLL\u0445L\u0445\u0445\u0445LL\u0445LLLL) {
        return LLL\u0445L\u0445\u0445\u0445LL\u0445LLLL < 0.5 ? 8.0 * LLL\u0445L\u0445\u0445\u0445LL\u0445LLLL * LLL\u0445L\u0445\u0445\u0445LL\u0445LLLL * LLL\u0445L\u0445\u0445\u0445LL\u0445LLLL * LLL\u0445L\u0445\u0445\u0445LL\u0445LLLL : 1.0 - Math.pow(-2.0 * LLL\u0445L\u0445\u0445\u0445LL\u0445LLLL + 2.0, 4.0) / 2.0;
    }

    static {
        clientLook = new BooleanSetting("Client Look", false, () -> true);
        randomRotation = new BooleanSetting("Random Rotation", true, () -> true);
        randomYaw = new NumberSetting("Random Yaw", 2.0f, 0.0f, 4.0f, 0.01f, () -> randomRotation.getBoolValue());
        randomPitch = new NumberSetting("Random Pitch", 2.0f, 0.0f, 4.0f, 0.01f, () -> randomRotation.getBoolValue());
        attackInInvetory = new BooleanSetting("Attack In Inventory", true, () -> true);
        pitchValue = new NumberSetting("Pitch Value", 0.16f, -4.0f, 4.0f, 0.01f, () -> true);
        maxSpeedRotation = new NumberSetting("Max Speed Rotation", 360.0f, 0.0f, 360.0f, 1.0f, () -> true);
        minSpeedRotation = new NumberSetting("Min Speed Rotation", 360.0f, 0.0f, 360.0f, 1.0f, () -> true);
        targetEsp = new BooleanSetting("TargetEsp", true, () -> false);
        targetEspMode = new ListSetting("TargetEsp Mode", "Jello", () -> targetEsp.getBoolValue(), "Default", "Sims", "Jello", "Astolfo");
        targetEspColor = new ColorSetting("TargetEsp Color", new Color(-1120281, true).getRGB(), () -> targetEsp.getBoolValue());
        points = new NumberSetting("Points", 32.0f, 2.0f, 64.0f, 1.0f, () -> KillAura.targetEspMode.currentMode.equals("Astolfo"));
        circleRange = new NumberSetting("Circle Range", 3.0f, 0.1f, 6.0f, 0.01f, () -> KillAura.targetEspMode.currentMode.equals("Astolfo"));
        swingMode = new ListSetting("SwingMod", "Server", () -> true, "Client", "None", "Server");
        rotPredict = new NumberSetting("Rotation Predict", 0.05f, 0.0f, 10.0f, 0.001f, () -> true);
        raycast = new BooleanSetting("Ray-Cast", true, () -> true);
    }
}

