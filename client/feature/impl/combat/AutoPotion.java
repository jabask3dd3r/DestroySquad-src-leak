/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.feature.impl.combat;

import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import org.Destroy.client.event.EventTarget;
import org.Destroy.client.event.events.impl.player.EventPreMotion;
import org.Destroy.client.feature.Feature;
import org.Destroy.client.feature.impl.Type;
import org.Destroy.client.helpers.misc.TimerHelper;
import org.Destroy.client.settings.impl.BooleanSetting;
import org.Destroy.client.settings.impl.NumberSetting;

public class AutoPotion
extends Feature {
    public TimerHelper timerHelper = new TimerHelper();
    public NumberSetting delay;
    public BooleanSetting onlyGround = new BooleanSetting("Only Ground", true, () -> true);

    public AutoPotion() {
        super("AutoBaffSplash", "Automatically throws Splash potions in inventory", Type.Combat);
        AutoPotion L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL;
        L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL.delay = new NumberSetting("Throw Delay", 500.0f, 10.0f, 600.0f, 10.0f, () -> true);
        L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL.addSettings(L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL.delay, L\u0445\u0445\u0445\u0445\u0445\u0445\u0445L\u0445\u0445\u0445LL.onlyGround);
    }

    @Override
    public void onDisable() {
        AutoPotion \u0445LLLLLLL\u0445\u0445\u0445\u0445LL;
        super.onDisable();
    }

    /*
     * Exception decompiling
     */
    @EventTarget
    public void onPreMotion(EventPreMotion L\u0445\u0445LLLLL\u0445\u0445\u0445\u0445LL) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl84 : RETURN - null : trying to set 2 previously set to 1
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

    public void throwPot(Potions \u0445L\u0445\u0445LLLL\u0445\u0445\u0445\u0445LL) {
        AutoPotion LL\u0445\u0445LLLL\u0445\u0445\u0445\u0445LL;
        int L\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445LL = LL\u0445\u0445LLLL\u0445\u0445\u0445\u0445LL.getPotion(\u0445L\u0445\u0445LLLL\u0445\u0445\u0445\u0445LL);
        if (LL\u0445\u0445LLLL\u0445\u0445\u0445\u0445LL.timerHelper.hasReached(LL\u0445\u0445LLLL\u0445\u0445\u0445\u0445LL.delay.getNumberValue())) {
            AutoPotion.mc.player.connection.sendPacket(new CPacketHeldItemChange(L\u0445\u0445\u0445LLLL\u0445\u0445\u0445\u0445LL));
            AutoPotion.mc.playerController.updateController();
            AutoPotion.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            AutoPotion.mc.playerController.updateController();
            AutoPotion.mc.player.connection.sendPacket(new CPacketHeldItemChange(AutoPotion.mc.player.inventory.currentItem));
            LL\u0445\u0445LLLL\u0445\u0445\u0445\u0445LL.timerHelper.reset();
        }
    }

    public int getPotion(Potions \u0445\u0445\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL) {
        int \u0445L\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL = 0;
        if (\u0445L\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL < 9) {
            AutoPotion L\u0445\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL;
            AutoPotion autoPotion = L\u0445\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL;
            ItemStack itemStack = AutoPotion.mc.player.inventory.getStackInSlot(\u0445L\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL);
            if (\u0445\u0445\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL != false) {
                return \u0445L\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL;
            }
            ++\u0445L\u0445L\u0445LLL\u0445\u0445\u0445\u0445LL;
            return 0;
        }
        return -1;
    }

    public static enum Potions {
        STRENGTH,
        SPEED,
        FIRERES;


        private Potions() {
            Potions L\u0445LLLL\u0445L\u0445L\u0445\u0445L;
        }
    }
}

