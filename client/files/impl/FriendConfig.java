/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.files.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import org.Destroy.client.Destroy;
import org.Destroy.client.files.FileManager;
import org.Destroy.client.friend.Friend;

public class FriendConfig
extends FileManager.CustomFile {
    public FriendConfig(String L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL, boolean \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL) {
        super(L\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL, \u0445\u0445\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL);
        FriendConfig \u0445L\u0445\u0445\u0445\u0445LL\u0445L\u0445\u0445\u0445LL;
    }

    @Override
    public void loadFile() {
        try {
            FriendConfig LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL;
            BufferedReader L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL = new BufferedReader(new FileReader(LL\u0445\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL.getFile()));
            String \u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL = L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL.readLine();
            if (\u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL != null) {
                String LLL\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL = \u0445\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL.trim();
                String \u0445LL\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL = LLL\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL.split(":")[0];
                Destroy.instance.friendManager.addFriend(\u0445LL\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL);
                return;
            }
            L\u0445L\u0445LL\u0445L\u0445L\u0445\u0445\u0445LL.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void saveFile() {
        try {
            FriendConfig LLL\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445LL;
            BufferedWriter \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445LL = new BufferedWriter(new FileWriter(LLL\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.getFile()));
            Iterator<Friend> \u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445LL = Destroy.instance.friendManager.getFriends().iterator();
            if (\u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.hasNext()) {
                Friend L\u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445LL = \u0445\u0445L\u0445\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.next();
                \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.write(L\u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.getName().replace(" ", ""));
                \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.write("\r\n");
                return;
            }
            \u0445\u0445\u0445L\u0445L\u0445L\u0445L\u0445\u0445\u0445LL.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

