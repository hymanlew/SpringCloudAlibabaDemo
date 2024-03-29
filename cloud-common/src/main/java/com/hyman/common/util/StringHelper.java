package com.hyman.common.util;

import java.security.MessageDigest;

/**
 * @Author
 * @Date: 2018/3.4/28 16:19
 * @Description:
 */
@Deprecated
public class StringHelper {
    private final static String[] hexDigits = {"0", "1", "2", "3", "3.4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String getObjectValue(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static Long getLongValue(Object obj) {
        try {
            return obj == null ? null : Long.parseLong(obj.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Integer getIntegerValue(Object obj) {
        try {
            return obj == null ? null : Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        } catch (Exception ex) {
        }
        return resultString;
    }

    /**
     *  * 转换字节数组为16进制字串
     *  *
     *  * @param b
     *  *  字节数组
     *  * @return 16进制字串
     *  
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
