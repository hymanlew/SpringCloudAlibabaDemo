package com.hyman.common.util;

/**
 * Luhn算法工具类
 * <a href="https://zhuanlan.zhihu.com/p/44204595">银行卡号的编码规则及校验</a>
 * <p>
 * Luhn算法在ISO/IEC 7812-1中定义，使用Luhn算法进行字符串的校验以及生成校验数字
 * </p>
 */
@Deprecated
public class LuhnUtil {

    /**
     * 校验字符串
     * <p>
     * 1. 从右边第1个数字（校验数字）开始偶数位乘以2；<br>
     * 2. 把在步骤1种获得的乘积的各位数字与原号码中未乘2的各位数字相加；<br>
     * 3. 如果在步骤2得到的总和模10为0，则校验通过。
     * </p>
     *
     * @param withCheckDigitString 含校验数字的字符串
     * @return true - 校验通过<br>
     * false-校验不通过
     * @throws IllegalArgumentException 如果字符串为空或不是8~19位的数字
     */
    public static boolean checkString(String withCheckDigitString) {
        if (withCheckDigitString == null) {
            return false;
        }
        if (!(withCheckDigitString.length() >= 16 && withCheckDigitString.length() <= 19)) {
            return false;
        }
        // 6位IIN+最多12位自定义数字+1位校验数字
        // 注意ISO/IEC 7812-1:2017中重新定义8位IIN+最多10位自定义数字+1位校验数字
        // 这里为了兼容2017之前的版本，使用8~19位数字校验
        if (!withCheckDigitString.matches("^\\d{8,19}$")) {
            return false;
        }
        return sum(withCheckDigitString) % 10 == 0;
    }

    /**
     * 计算校验数字
     * <p>
     * 1. 从右边第1个数字（校验数字）开始偶数位乘以2；<br>
     * 2. 把在步骤1种获得的乘积的各位数字与原号码中未乘2的各位数字相加；<br>
     * 3. 用10减去在步骤2得到的总和模10，得到校验数字。
     * </p>
     *
     * @param withoutCheckDigitString 不含校验数字的字符串
     * @return 校验数字
     * @throws IllegalArgumentException 如果字符串为空或不是7~18位的数字
     */
    public static int computeCheckDigit(String withoutCheckDigitString) {
        if (withoutCheckDigitString == null) {
            throw new IllegalArgumentException();
        }
        // 6位IIN+最多12位自定义数字
        // 注意ISO/IEC 7812-1:2017中重新定义8位IIN+最多10位自定义数字
        // 这里为了兼容2017之前的版本，使用7~18位数字校验
        if (!withoutCheckDigitString.matches("^\\d{7,18}$")) {
            throw new IllegalArgumentException();
        }
        // 因为是不含校验数字的字符串，为了统一sum方法，在后面补0，不会影响计算
        return 10 - sum(withoutCheckDigitString + "0") % 10;
    }

    /**
     * 根据Luhn算法计算字符串各位数字之和
     * <p>
     * 1. 从右边第1个数字（校验数字）开始偶数位乘以2；<br>
     * 2. 把在步骤1种获得的乘积的各位数字与原号码中未乘2的各位数字相加。<br>
     * </p>
     *
     * @param str
     * @return
     */
    private static int sum(String str) {
        char[] strArray = str.toCharArray();
        int n = strArray.length;
        int sum = 0;
        for (int i = n; i >= 1; i--) {
            int a = strArray[n - i] - '0';
            // 偶数位乘以2
            if (i % 2 == 0) {
                a *= 2;
            }
            // 十位数和个位数相加，如果不是偶数位，不乘以2，则十位数为0
            sum = sum + a / 10 + a % 10;
        }
        return sum;
    }
}