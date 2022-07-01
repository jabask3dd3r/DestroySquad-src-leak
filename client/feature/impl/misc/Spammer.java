/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.misc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventUpdate;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.ListSetting;
import org.Destroy.client.settings.impl.NumberSetting;
import org.apache.commons.lang3.RandomStringUtils;

public class Spammer
extends Feature {
    private final NumberSetting delay;
    private final BooleanSetting randomSymbols;
    private final ListSetting spammerMode = new ListSetting("Spammer Mode", "Default", () -> true, "Default", "HvH?", "Direct");
    private int ticks;
    private int counter;

    public Spammer() {
        super("Spammer", "Automatically spam chat messages", Type.Misc);
        Spammer LLLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L;
        LLLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L.delay = new NumberSetting("Spammer Delay", 100.0f, 10.0f, 500.0f, 10.0f, () -> true);
        LLLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L.randomSymbols = new BooleanSetting("Random Symbols", true, () -> {
            Spammer L\u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445L;
            return L\u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445L.spammerMode.currentMode.equals("Custom");
        });
        LLLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L.addSettings(LLLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L.spammerMode, LLLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L.delay, LLLL\u0445\u0445LL\u0445L\u0445\u0445\u0445L.randomSymbols);
    }

    private List<EntityPlayer> getPlayerByTab() {
        ArrayList<EntityPlayer> \u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445L = new ArrayList<EntityPlayer>();
        Iterator<NetworkPlayerInfo> \u0445LL\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445L = Spammer.mc.player.connection.getPlayerInfoMap().iterator();
        if (\u0445LL\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445L.hasNext()) {
            NetworkPlayerInfo \u0445L\u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445L = \u0445LL\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445L.next();
            if (\u0445L\u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445L == null) {
                return null;
            }
            \u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445L.add(Spammer.mc.world.getPlayerEntityByName(\u0445L\u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445L.getGameProfile().getName()));
            return null;
        }
        return \u0445\u0445\u0445L\u0445\u0445LL\u0445L\u0445\u0445\u0445L;
    }

    @EventTarget
    public void onUpdate(EventUpdate \u0445L\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L) throws IOException {
        Iterator<EntityPlayer> iterator;
        Spammer LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L;
        String L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L = LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.spammerMode.getOptions();
        LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.setSuffix(L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L + ", " + (int)LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.delay.getNumberValue());
        if (L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.equalsIgnoreCase("Default")) {
            try {
                String \u0445LLLLL\u0445L\u0445L\u0445\u0445\u0445L = RandomStringUtils.randomAlphabetic(3);
                String L\u0445LLLL\u0445L\u0445L\u0445\u0445\u0445L = RandomStringUtils.randomPrint(5);
                LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.setSuffix("" + (int)LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.delay.getNumberValue());
                if (LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.ticks++ % (int)LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.delay.getNumberValue() == 0) {
                    Spammer.mc.player.sendChatMessage("![" + \u0445LLLLL\u0445L\u0445L\u0445\u0445\u0445L + "]`vk com/xware_client` [" + L\u0445LLLL\u0445L\u0445L\u0445\u0445\u0445L + "]");
                }
            }
            catch (Exception \u0445\u0445LLLL\u0445L\u0445L\u0445\u0445\u0445L) {
                \u0445\u0445LLLL\u0445L\u0445L\u0445\u0445\u0445L.printStackTrace();
            }
        } else if (L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.equalsIgnoreCase("HvH?")) {
            String LL\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L = RandomStringUtils.randomAlphabetic(3);
            String \u0445L\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L = RandomStringUtils.randomPrint(5);
            String L\u0445\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L = "";
            LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.setSuffix("" + (int)LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.delay.getNumberValue());
            if (LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.ticks++ % (int)LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.delay.getNumberValue() == 0) {
                switch (LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.counter) {
                    case 0: {
                        Spammer.mc.player.sendChatMessage(L\u0445\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L + "!Your client is a fucking dick)) Kid @ me a duel: \"/duel " + Spammer.mc.player.getName() + "\".  Map: Beach  [" + LL\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L + "] [" + \u0445L\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L + "]");
                        ++LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.counter;
                        break;
                    }
                    case 1: {
                        Spammer.mc.player.sendChatMessage(L\u0445\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L + "!Do you really think your client is better?) Throw me a duel: \"/duel " + Spammer.mc.player.getName() + "\". Map: Beach  [" + LL\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L + "] [" + \u0445L\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L + "]");
                        ++LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.counter;
                        break;
                    }
                    case 2: {
                        Spammer.mc.player.sendChatMessage(L\u0445\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L + "!How are you behaving you fucking bastard? Give me a duel: \"/duel " + Spammer.mc.player.getName() + "\".  Map: Beach  [" + LL\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L + "] [" + \u0445L\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L + "]");
                        LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.counter = 0;
                    }
                }
            }
        } else if (L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.equalsIgnoreCase("Custom")) {
            Scanner L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445L;
            String \u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L = RandomStringUtils.randomAlphabetic(3);
            String LLL\u0445LL\u0445L\u0445L\u0445\u0445\u0445L = RandomStringUtils.randomPrint(5);
            File \u0445LL\u0445LL\u0445L\u0445L\u0445\u0445\u0445L = new File(Spammer.mc.mcDataDir + "\\xware", "spammer.txt");
            if (!\u0445LL\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.exists()) {
                \u0445LL\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.createNewFile();
            }
            if ((L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445L = new Scanner(\u0445LL\u0445LL\u0445L\u0445L\u0445\u0445\u0445L)).hasNextLine()) {
                if (LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.ticks++ % (int)LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.delay.getNumberValue() == 0 && LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.counter == 0) {
                    if (LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.randomSymbols.getBoolValue()) {
                        Spammer.mc.player.sendChatMessage("! '" + L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.nextLine() + "' " + LLL\u0445LL\u0445L\u0445L\u0445\u0445\u0445L + \u0445\u0445\u0445LLL\u0445L\u0445L\u0445\u0445\u0445L);
                    } else {
                        Spammer.mc.player.sendChatMessage(L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.nextLine());
                    }
                    LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.counter = 0;
                }
                L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.close();
                return;
            }
        } else if (L\u0445\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.equalsIgnoreCase("Direct") && (iterator = LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.getPlayerByTab().iterator()).hasNext()) {
            EntityPlayer \u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445L = iterator.next();
            if (\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445L == null) {
                return;
            }
            if (LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.ticks++ % (int)LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.delay.getNumberValue() == 0 && \u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445L != Spammer.mc.player) {
                Spammer.mc.player.sendChatMessage("/msg " + \u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445L.getName() + "vk com/xware_client Best Legit Client, download! \n\n!");
            }
            return;
        }
    }
}

