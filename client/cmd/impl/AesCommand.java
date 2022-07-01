/*
 * Decompiled with CFR 0.152.
 */
package org.Destroy.client.cmd.impl;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.Destroy.client.cmd.CommandAbstract;

public class AesCommand
extends CommandAbstract {
    public AesCommand() {
        super("bind", "bind", ".aes encrypt | decrypt true | false (base64) key text", "aes");
        AesCommand \u0445\u0445LL\u0445LLL;
    }

    @Override
    public void execute(String ... L\u0445\u0445L\u0445LLL) {
    }

    public static String encryptAes(String \u0445\u0445LLL\u0445LL, String LL\u0445LL\u0445LL, boolean \u0445L\u0445LL\u0445LL) {
        try {
            byte[] L\u0445\u0445\u0445\u0445LLL = LL\u0445LL\u0445LL.getBytes();
            SecretKeySpec \u0445\u0445\u0445\u0445\u0445LLL = new SecretKeySpec(L\u0445\u0445\u0445\u0445LLL, "AES");
            Cipher LLLLL\u0445LL = Cipher.getInstance("AES/CBC/PKCS5Padding");
            LLLLL\u0445LL.init(1, \u0445\u0445\u0445\u0445\u0445LLL);
            byte[] \u0445LLLL\u0445LL = LLLLL\u0445LL.doFinal(\u0445\u0445LLL\u0445LL.getBytes());
            return \u0445L\u0445LL\u0445LL ? Base64.getEncoder().encodeToString(\u0445LLLL\u0445LL) : new String(\u0445LLLL\u0445LL);
        }
        catch (Exception L\u0445LLL\u0445LL) {
            L\u0445LLL\u0445LL.printStackTrace();
            return null;
        }
    }

    public static String encryptXor(String LL\u0445L\u0445\u0445LL, boolean \u0445L\u0445L\u0445\u0445LL, byte[] L\u0445\u0445L\u0445\u0445LL) {
        byte[] \u0445\u0445\u0445L\u0445\u0445LL = LL\u0445L\u0445\u0445LL.getBytes();
        byte[] LLL\u0445\u0445\u0445LL = new byte[LL\u0445L\u0445\u0445LL.length()];
        int \u0445\u0445LL\u0445\u0445LL = 0;
        if (\u0445\u0445LL\u0445\u0445LL < \u0445\u0445\u0445L\u0445\u0445LL.length) {
            int n2 = \u0445\u0445LL\u0445\u0445LL;
            LLL\u0445\u0445\u0445LL[n2] = (byte)(LLL\u0445\u0445\u0445LL[n2] ^ (byte)(\u0445\u0445\u0445L\u0445\u0445LL[\u0445\u0445LL\u0445\u0445LL] ^ L\u0445\u0445L\u0445\u0445LL[\u0445\u0445LL\u0445\u0445LL % L\u0445\u0445L\u0445\u0445LL.length] ^ 0x10));
            ++\u0445\u0445LL\u0445\u0445LL;
            return null;
        }
        return \u0445L\u0445L\u0445\u0445LL ? Base64.getEncoder().encodeToString(\u0445\u0445\u0445L\u0445\u0445LL) : new String(LLL\u0445\u0445\u0445LL);
    }

    public static String decryptXor(byte[] L\u0445\u0445LLL\u0445L, boolean \u0445\u0445\u0445LLL\u0445L, String LLL\u0445LL\u0445L) {
        byte[] \u0445LL\u0445LL\u0445L = new byte[L\u0445\u0445LLL\u0445L.length];
        byte[] L\u0445L\u0445LL\u0445L = LLL\u0445LL\u0445L.getBytes();
        int \u0445L\u0445LLL\u0445L = 0;
        if (\u0445L\u0445LLL\u0445L < L\u0445\u0445LLL\u0445L.length) {
            int n2 = \u0445L\u0445LLL\u0445L;
            \u0445LL\u0445LL\u0445L[n2] = (byte)(\u0445LL\u0445LL\u0445L[n2] ^ (byte)(L\u0445\u0445LLL\u0445L[\u0445L\u0445LLL\u0445L] ^ L\u0445L\u0445LL\u0445L[\u0445L\u0445LLL\u0445L % L\u0445L\u0445LL\u0445L.length] ^ 0x10));
            ++\u0445L\u0445LLL\u0445L;
            return null;
        }
        return \u0445\u0445\u0445LLL\u0445L ? Base64.getEncoder().encodeToString(\u0445LL\u0445LL\u0445L) : new String(L\u0445\u0445LLL\u0445L);
    }

    public static String decryptAes(String \u0445L\u0445\u0445\u0445L\u0445L, String L\u0445\u0445\u0445\u0445L\u0445L, boolean \u0445\u0445\u0445\u0445\u0445L\u0445L) {
        try {
            byte[] LLL\u0445\u0445L\u0445L = L\u0445\u0445\u0445\u0445L\u0445L.getBytes();
            SecretKeySpec \u0445LL\u0445\u0445L\u0445L = new SecretKeySpec(LLL\u0445\u0445L\u0445L, "AES");
            Cipher L\u0445L\u0445\u0445L\u0445L = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            L\u0445L\u0445\u0445L\u0445L.init(2, \u0445LL\u0445\u0445L\u0445L);
            byte[] \u0445\u0445L\u0445\u0445L\u0445L = L\u0445L\u0445\u0445L\u0445L.doFinal(\u0445\u0445\u0445\u0445\u0445L\u0445L ? Base64.getDecoder().decode(\u0445L\u0445\u0445\u0445L\u0445L) : \u0445L\u0445\u0445\u0445L\u0445L.getBytes());
            return new String(\u0445\u0445L\u0445\u0445L\u0445L);
        }
        catch (Exception LL\u0445\u0445\u0445L\u0445L) {
            LL\u0445\u0445\u0445L\u0445L.printStackTrace();
            return null;
        }
    }
}

