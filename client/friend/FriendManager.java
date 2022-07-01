/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.friend;

import java.util.ArrayList;
import java.util.List;
import org.Destroy.client.friend.Friend;

public class FriendManager {
    private final List<Friend> friends = new ArrayList<Friend>();

    public FriendManager() {
        FriendManager \u0445\u0445L\u0445LLLL\u0445\u0445\u0445L\u0445L;
    }

    public void addFriend(Friend \u0445L\u0445L\u0445LLL\u0445\u0445\u0445L\u0445L) {
        FriendManager LL\u0445L\u0445LLL\u0445\u0445\u0445L\u0445L;
        LL\u0445L\u0445LLL\u0445\u0445\u0445L\u0445L.friends.add(\u0445L\u0445L\u0445LLL\u0445\u0445\u0445L\u0445L);
    }

    public void addFriend(String \u0445LLLL\u0445LL\u0445\u0445\u0445L\u0445L) {
        FriendManager LLLLL\u0445LL\u0445\u0445\u0445L\u0445L;
        LLLLL\u0445LL\u0445\u0445\u0445L\u0445L.friends.add(new Friend(\u0445LLLL\u0445LL\u0445\u0445\u0445L\u0445L));
    }

    public boolean isFriend(String L\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L) {
        FriendManager LL\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L;
        return LL\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L.friends.stream().anyMatch(\u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L -> \u0445\u0445\u0445\u0445L\u0445\u0445L\u0445\u0445\u0445L\u0445L.getName().equals(L\u0445\u0445\u0445L\u0445LL\u0445\u0445\u0445L\u0445L));
    }

    public void removeFriend(String L\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445L) {
        FriendManager \u0445LL\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445L;
        \u0445LL\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445L.friends.removeIf(LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L -> LL\u0445LL\u0445\u0445L\u0445\u0445\u0445L\u0445L.getName().equalsIgnoreCase(L\u0445L\u0445\u0445\u0445LL\u0445\u0445\u0445L\u0445L));
    }

    public List<Friend> getFriends() {
        FriendManager L\u0445LLLL\u0445L\u0445\u0445\u0445L\u0445L;
        return L\u0445LLLL\u0445L\u0445\u0445\u0445L\u0445L.friends;
    }

    public Friend getFriend(String LL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L) {
        FriendManager \u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L;
        return \u0445\u0445L\u0445LL\u0445L\u0445\u0445\u0445L\u0445L.friends.stream().filter(LLL\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445L -> LLL\u0445\u0445L\u0445L\u0445\u0445\u0445L\u0445L.getName().equals(LL\u0445\u0445LL\u0445L\u0445\u0445\u0445L\u0445L)).findFirst().get();
    }
}

