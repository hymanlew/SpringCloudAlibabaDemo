package com.hyman.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author
 * @Date: 2018/5/23 10:46
 * @Description:
 */
public class MD5 {

    //散列次数
    private static int digestCount = 3;
    //盐值
    private static  byte [] slat = "hyman".getBytes();

    private static cn.hutool.crypto.digest.MD5 md5 = new cn.hutool.crypto.digest.MD5(slat,digestCount);

    public static String hutoolMd5Encode(String input) {
        return md5.digestHex(input);
    }

    public static String md5Encode(String input) {
        try {
            MessageDigest alg = MessageDigest.getInstance("MD5");
            alg.update(input.getBytes());
            byte[] digesta = alg.digest();
            return byte2Hex(digesta);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean validatePassword(String plainPassword, String password) {
        String plain = hutoolMd5Encode(plainPassword);
        return password.equals(plain);
    }

    //转换下
    static String byte2Hex(byte[] paramArrayOfByte) {
        StringBuffer localStringBuffer = new StringBuffer();
        String str = "";
        for (int i = 0; i < paramArrayOfByte.length; ++i) {
            str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
            if (str.length() == 1) {
                localStringBuffer.append("0");
            }
            localStringBuffer.append(str);
        }
        return localStringBuffer.toString().toUpperCase();
    }
}
