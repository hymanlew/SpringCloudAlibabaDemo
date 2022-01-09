package com.hyman.common.util;

import com.hyman.common.exception.BaseException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.text.StringEscapeUtils;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.regex.Pattern;

/**
 * @author
 * @date 2018-10-10
 * @description: 加密，解密
 **/
public class EncryptionUtil {

    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;
    private static SecureRandom random = new SecureRandom();

    private static final String SHA1 = "SHA-1";

    public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
        return digest(input, SHA1, salt, iterations);
    }

    /**
     * 对字符串进行散列, 支持md5与sha1算法.
     */
    private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            if (salt != null) {
                digest.update(salt);
            }

            byte[] result = digest.digest(input);

            for (int i = 1; i < iterations; i++) {
                digest.reset();
                result = digest.digest(result);
            }
            return result;
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Hex编码.
     */
    public static String encodeHex(byte[] input) {
        return new String(Hex.encodeHex(input));
    }

    /**
     * Hex解码.
     */
    public static byte[] decodeHex(String input) {
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Html 解码.
     */
    public static String unescapeHtml(String htmlEscaped) {
        return StringEscapeUtils.unescapeHtml4(htmlEscaped);
    }

    /**
     * 生成随机的Byte[]作为salt.
     *
     * @param numBytes byte数组的大小
     */
    public static byte[] generateSalt(int numBytes) {
        Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);

        byte[] bytes = new byte[numBytes];
        random.nextBytes(bytes);
        return bytes;
    }

    /**
     * 验证密码
     *
     * @param plainPassword 明文密码
     * @param password      密文密码
     * @return 验证成功返回true
     */
    public static boolean validatePassword(String plainPassword, String password) {
        if (StringUtils.isBlank(password) || password.length() <16){
            throw new BaseException("您的密码不符合规定，请联系管理员处理");
        }
        String plain = unescapeHtml(plainPassword);
        byte[] salt = decodeHex(password.substring(0, 16));
        byte[] hashPassword = sha1(plain.getBytes(), salt, HASH_INTERATIONS);
        return password.equals(encodeHex(salt) + encodeHex(hashPassword));
    }


    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword) {
        String plain = unescapeHtml(plainPassword);
        byte[] salt = generateSalt(SALT_SIZE);
        byte[] hashPassword = sha1(plain.getBytes(), salt, HASH_INTERATIONS);
        return encodeHex(salt) + encodeHex(hashPassword);
    }

    public static Boolean isWeakPwd(String pwd){
        if (StringUtils.isBlank(pwd)){
            return true;
        }
        if (!Pattern.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$", pwd)){
            return true;
        }
        if (32 == pwd.toCharArray()[1] - pwd.toCharArray()[0] && "123456".equals(pwd.substring(2,pwd.length()))){
            return true;
        }
        return false;
    }
}

