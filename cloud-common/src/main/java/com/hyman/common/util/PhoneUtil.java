package com.hyman.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @Author
 * @Date: 2018/8/6 11:37
 * @Description:
 */
public class PhoneUtil {
    /**
     * 手机号验证
     *
     * @param phone
     * @return
     */
    public static boolean checkPhone(Long phone) {
        if (phone == null) {
            return false;
        }
        String str = String.valueOf(phone);

        if (str.length() != 11) {
            return false;
        } else {
//            Matcher m = phonePattern.matcher(str);
//            boolean isMatch = m.matches();
//            if (isMatch) {
//                return true;
//            } else {
//                return false;
//            }
            return isPhoneLegal(str);
        }
    }

    static Pattern phonePattern;

    static {
        String regex = "^1[345678]\\d{9}$";

        phonePattern = Pattern.compile(regex);
    }

    /**
     * 大陆号码或香港号码均可
     */
    public static boolean isPhoneLegal(String str) throws PatternSyntaxException {
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);
    }

    /**
     * 正则：手机号（精确）
     * <p>移动：134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188、198</p>
     * <p>联通：130、131、132、145、155、156、175、176、185、186、166</p>
     * <p>电信：133、153、173、177、180、181、189、199</p>
     * <p>全球星：1349</p>
     * <p>虚拟运营商：170</p>
     * <p>2019年05月15日17:52:44 开放：171</p>
     */
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^1[3456789]\\d{9}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        boolean matches = m.matches();
        return matches;
    }

    /**
     * 香港手机号码8位数，5|6|8|9开头+7位任意数
     */
    public static boolean isHKPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^(5|6|8|9)\\d{7}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

}
