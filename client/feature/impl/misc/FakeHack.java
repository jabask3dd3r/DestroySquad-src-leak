/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumHand;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.math.RotationHelper;
import org.Destroy.client.helpers.misc.ChatHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class FakeHack
extends Feature {
    public static ArrayList<String> fakeHackers = new ArrayList();
    private final BooleanSetting hackerSneak;
    private final BooleanSetting hackerSpin;
    private final NumberSetting hackerAttackDistance = new NumberSetting("Hacker Attack Range", 3.0f, 1.0f, 7.0f, 1.0f, () -> true);
    public float rot = 0.0f;

    public FakeHack() {
        super("FakeHack", "\u00d0\u009f\u00d0\u00be\u00d0\u00b7\u00d0\u00b2\u00d0\u00be\u00d0\u00bb\u00d1\u008f\u00d0\u00b5\u00d1\u0082 \u00d1\u0081\u00d0\u00b4\u00d0\u00b5\u00d0\u00bb\u00d0\u00b0\u00d1\u0082\u00d1\u008c \u00d0\u00bb\u00d0\u00b5\u00d0\u00b3\u00d0\u00b8\u00d1\u0082\u00d0\u00bd\u00d0\u00be\u00d0\u00b3\u00d0\u00be \u00d0\u00b8\u00d0\u00b3\u00d1\u0080\u00d0\u00be\u00d0\u00ba\u00d0\u00b0 \u00d1\u0087\u00d0\u00b8\u00d1\u0082\u00d0\u00b5\u00d1\u0080\u00d0\u00be\u00d0\u00bc", Type.Misc);
        FakeHack L\u0445LL\u0445LL\u0445LLL\u0445\u0445L;
        L\u0445LL\u0445LL\u0445LLL\u0445\u0445L.hackerSneak = new BooleanSetting("Hacker Sneaking", false, () -> true);
        L\u0445LL\u0445LL\u0445LLL\u0445\u0445L.hackerSpin = new BooleanSetting("Hacker Spin", false, () -> true);
        L\u0445LL\u0445LL\u0445LLL\u0445\u0445L.addSettings(L\u0445LL\u0445LL\u0445LLL\u0445\u0445L.hackerAttackDistance, L\u0445LL\u0445LL\u0445LLL\u0445\u0445L.hackerSneak, L\u0445LL\u0445LL\u0445LLL\u0445\u0445L.hackerSpin);
    }

    public static boolean isFakeHacker(EntityPlayer L\u0445L\u0445\u0445LL\u0445LLL\u0445\u0445L) {
        Iterator<String> LL\u0445\u0445\u0445LL\u0445LLL\u0445\u0445L = fakeHackers.iterator();
        if (LL\u0445\u0445\u0445LL\u0445LLL\u0445\u0445L.hasNext()) {
            String \u0445LL\u0445\u0445LL\u0445LLL\u0445\u0445L = LL\u0445\u0445\u0445LL\u0445LLL\u0445\u0445L.next();
            EntityPlayer LLL\u0445\u0445LL\u0445LLL\u0445\u0445L = FakeHack.mc.world.getPlayerEntityByName(\u0445LL\u0445\u0445LL\u0445LLL\u0445\u0445L);
            if (LLL\u0445\u0445LL\u0445LLL\u0445\u0445L == null) {
                return false;
            }
            return L\u0445L\u0445\u0445LL\u0445LLL\u0445\u0445L.isEntityEqual(LLL\u0445\u0445LL\u0445LLL\u0445\u0445L);
        }
        return false;
    }

    public static void removeHacker(EntityPlayer \u0445\u0445LLL\u0445L\u0445LLL\u0445\u0445L) {
        Iterator<String> LL\u0445LL\u0445L\u0445LLL\u0445\u0445L = fakeHackers.iterator();
        if (LL\u0445LL\u0445L\u0445LLL\u0445\u0445L.hasNext()) {
            String L\u0445LLL\u0445L\u0445LLL\u0445\u0445L = LL\u0445LL\u0445L\u0445LLL\u0445\u0445L.next();
            if (FakeHack.mc.world.getPlayerEntityByName(L\u0445LLL\u0445L\u0445LLL\u0445\u0445L) == null) {
                return;
            }
            if (\u0445\u0445LLL\u0445L\u0445LLL\u0445\u0445L.isEntityEqual(FakeHack.mc.world.getPlayerEntityByName(L\u0445LLL\u0445L\u0445LLL\u0445\u0445L))) {
                FakeHack.mc.world.getPlayerEntityByName(L\u0445LLL\u0445L\u0445LLL\u0445\u0445L).setSneaking(false);
                LL\u0445LL\u0445L\u0445LLL\u0445\u0445L.remove();
            }
            return;
        }
    }

    @Override
    public void onDisable() {
        FakeHack L\u0445\u0445\u0445L\u0445L\u0445LLL\u0445\u0445L;
        Iterator<String> LLLL\u0445\u0445L\u0445LLL\u0445\u0445L = fakeHackers.iterator();
        if (LLLL\u0445\u0445L\u0445LLL\u0445\u0445L.hasNext()) {
            String \u0445L\u0445\u0445L\u0445L\u0445LLL\u0445\u0445L = LLLL\u0445\u0445L\u0445LLL\u0445\u0445L.next();
            if (L\u0445\u0445\u0445L\u0445L\u0445LLL\u0445\u0445L.hackerSneak.getBoolValue()) {
                EntityPlayer LL\u0445\u0445L\u0445L\u0445LLL\u0445\u0445L = FakeHack.mc.world.getPlayerEntityByName(\u0445L\u0445\u0445L\u0445L\u0445LLL\u0445\u0445L);
                assert (LL\u0445\u0445L\u0445L\u0445LLL\u0445\u0445L != null);
                LL\u0445\u0445L\u0445L\u0445LLL\u0445\u0445L.setSneaking(false);
                LL\u0445\u0445L\u0445L\u0445LLL\u0445\u0445L.setSprinting(false);
            }
            return;
        }
        super.onDisable();
    }

    @Override
    public void onEnable() {
        FakeHack LL\u0445L\u0445\u0445L\u0445LLL\u0445\u0445L;
        ChatHelper.addChatMessage("To use this function write - .fakehack add (nick)");
        fakeHackers.clear();
        super.onEnable();
    }

    @EventTarget
    public void onPreUpdate(EventPreMotion L\u0445\u0445LLL\u0445\u0445LLL\u0445\u0445L) {
        Iterator<String> LLL\u0445LL\u0445\u0445LLL\u0445\u0445L = fakeHackers.iterator();
        if (LLL\u0445LL\u0445\u0445LLL\u0445\u0445L.hasNext()) {
            FakeHack \u0445L\u0445LLL\u0445\u0445LLL\u0445\u0445L;
            String LL\u0445LLL\u0445\u0445LLL\u0445\u0445L = LLL\u0445LL\u0445\u0445LLL\u0445\u0445L.next();
            EntityPlayer \u0445LLLLL\u0445\u0445LLL\u0445\u0445L = FakeHack.mc.world.getPlayerEntityByName(LL\u0445LLL\u0445\u0445LLL\u0445\u0445L);
            if (\u0445LLLLL\u0445\u0445LLL\u0445\u0445L == null) {
                return;
            }
            if (\u0445L\u0445LLL\u0445\u0445LLL\u0445\u0445L.hackerSneak.getBoolValue()) {
                \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.setSneaking(true);
                \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.setSprinting(true);
            } else {
                \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.setSneaking(false);
                \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.setSprinting(false);
            }
            float[] L\u0445LLLL\u0445\u0445LLL\u0445\u0445L = RotationHelper.getFacePosRemote(\u0445LLLLL\u0445\u0445LLL\u0445\u0445L, FakeHack.mc.player, true);
            float \u0445\u0445LLLL\u0445\u0445LLL\u0445\u0445L = \u0445L\u0445LLL\u0445\u0445LLL\u0445\u0445L.hackerAttackDistance.getNumberValue();
            if (!\u0445L\u0445LLL\u0445\u0445LLL\u0445\u0445L.hackerSpin.getBoolValue()) {
                if (\u0445LLLLL\u0445\u0445LLL\u0445\u0445L.getDistanceToEntity(FakeHack.mc.player) <= \u0445\u0445LLLL\u0445\u0445LLL\u0445\u0445L) {
                    \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.rotationYaw = L\u0445LLLL\u0445\u0445LLL\u0445\u0445L[0];
                    \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.rotationYawHead = L\u0445LLLL\u0445\u0445LLL\u0445\u0445L[0];
                    \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.rotationPitch = L\u0445LLLL\u0445\u0445LLL\u0445\u0445L[1];
                }
            } else {
                float \u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445\u0445L;
                float L\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445\u0445L = 30.0f;
                \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.rotationYaw = \u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445\u0445L = (float)Math.floor(\u0445L\u0445LLL\u0445\u0445LLL\u0445\u0445L.spinAim(L\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445\u0445L));
                \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.rotationYawHead = \u0445\u0445\u0445\u0445\u0445\u0445L\u0445LLL\u0445\u0445L;
            }
            if (FakeHack.mc.player.ticksExisted % 4 == 0 && \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.getDistanceToEntity(FakeHack.mc.player) <= \u0445\u0445LLLL\u0445\u0445LLL\u0445\u0445L) {
                \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.swingArm(EnumHand.MAIN_HAND);
                if (FakeHack.mc.player.getDistanceToEntity(\u0445LLLLL\u0445\u0445LLL\u0445\u0445L) <= \u0445\u0445LLLL\u0445\u0445LLL\u0445\u0445L) {
                    FakeHack.mc.player.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, 1.0f, 1.0f);
                }
            }
            if (FakeHack.mc.player.getDistanceToEntity(\u0445LLLLL\u0445\u0445LLL\u0445\u0445L) > \u0445\u0445LLLL\u0445\u0445LLL\u0445\u0445L && !\u0445L\u0445LLL\u0445\u0445LLL\u0445\u0445L.hackerSneak.getBoolValue() && !\u0445L\u0445LLL\u0445\u0445LLL\u0445\u0445L.hackerSpin.getBoolValue()) {
                float LLLLLL\u0445\u0445LLL\u0445\u0445L;
                \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.rotationYaw = LLLLLL\u0445\u0445LLL\u0445\u0445L = 75.0f;
                \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.rotationPitch = 0.0f;
                \u0445LLLLL\u0445\u0445LLL\u0445\u0445L.rotationYawHead = LLLLLL\u0445\u0445LLL\u0445\u0445L;
            }
            return;
        }
    }

    public float spinAim(float L\u0445LL\u0445L\u0445\u0445LLL\u0445\u0445L) {
        FakeHack \u0445LLL\u0445L\u0445\u0445LLL\u0445\u0445L;
        \u0445LLL\u0445L\u0445\u0445LLL\u0445\u0445L.rot += L\u0445LL\u0445L\u0445\u0445LLL\u0445\u0445L;
        return \u0445LLL\u0445L\u0445\u0445LLL\u0445\u0445L.rot;
    }
}

