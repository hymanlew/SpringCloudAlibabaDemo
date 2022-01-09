package com.hyman.common.util;

import cn.hutool.core.util.IdcardUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请使用cn.hutool.core.util.IdcardUtil替代
 *
 * @author
 * @see IdcardUtil
 */
@Deprecated
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IDCardUtil {

    private static Pattern DATE_PATTERN = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$"),
            NUMBERIC_PATTERN = Pattern.compile("[0-9]*");

    /**
     * 身份证验证
     *
     * @param idStr 身份证号
     * @return null表示正确，否则返回错误提示
     */
    public static String identitycardverification(@NotBlank String idStr) {
        // 身份证号使用小写x
        idStr = idStr.toLowerCase();
        String[] wf = {"1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] checkCode = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"};
        String iDCardNo = "";
        try {
            //判断号码的长度 15位或18位
            if (idStr.length() != 15 && idStr.length() != 18) {
                return "身份证号码长度应该为15位或18位";
            }
            if (idStr.length() == 18) {
                iDCardNo = idStr.substring(0, 17);
            } else if (idStr.length() == 15) {
                iDCardNo = idStr.substring(0, 6) + "19" + idStr.substring(6, 15);
            }
            if (isStrNum(iDCardNo) == false) {
                return "身份证15位号码都应为数字;18位号码除最后一位外,都应为数字";
            }
            //判断出生年月
            String strYear = iDCardNo.substring(6, 10);// 年份
            String strMonth = iDCardNo.substring(10, 12);// 月份
            String strDay = iDCardNo.substring(12, 14);// 月份
            if (isStrDate(strYear + "-" + strMonth + "-" + strDay) == false) {
                return "身份证生日无效";
            }
            GregorianCalendar gc = new GregorianCalendar();
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150 || (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                return "身份证生日不在有效范围";
            }
            if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
                return "身份证月份无效";
            }
            if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
                return "身份证日期无效";
            }
            //判断地区码
            Hashtable h = getAreaCode();
            if (h.get(iDCardNo.substring(0, 2)) == null) {
                return "身份证地区编码错误";
            }
            //判断最后一位
            int theLastOne = 0;
            for (int i = 0; i < 17; i++) {
                theLastOne = theLastOne + Integer.parseInt(String.valueOf(iDCardNo.charAt(i))) * Integer.parseInt(checkCode[i]);
            }
            int modValue = theLastOne % 11;
            String strVerifyCode = wf[modValue];
            iDCardNo = iDCardNo + strVerifyCode;
            if (idStr.length() == 18 && !iDCardNo.equals(idStr)) {
                return "身份证无效，不是合法的身份证号码";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 地区代码
     *
     * @return Hashtable
     */
    private static Hashtable getAreaCode() {
        return new Hashtable() {
            {
                put("11", "北京");
                put("12", "天津");
                put("13", "河北");
                put("14", "山西");
                put("15", "内蒙古");
                put("21", "辽宁");
                put("22", "吉林");
                put("23", "黑龙江");
                put("31", "上海");
                put("32", "江苏");
                put("33", "浙江");
                put("34", "安徽");
                put("35", "福建");
                put("36", "江西");
                put("37", "山东");
                put("41", "河南");
                put("42", "湖北");
                put("43", "湖南");
                put("44", "广东");
                put("45", "广西");
                put("46", "海南");
                put("50", "重庆");
                put("51", "四川");
                put("52", "贵州");
                put("53", "云南");
                put("54", "西藏");
                put("61", "陕西");
                put("62", "甘肃");
                put("63", "青海");
                put("64", "宁夏");
                put("65", "新疆");
                put("71", "台湾");
                put("81", "香港");
                put("82", "澳门");
                put("91", "国外");
            }
        };
    }

    /**
     * 判断字符串是否为数字
     */
    private static boolean isStrNum(String str) {
        Matcher isNum = NUMBERIC_PATTERN.matcher(str);
        return isNum.matches();
    }

    /**
     * 判断字符串是否为日期格式
     */
    public static boolean isStrDate(String strDate) {
        Matcher m = DATE_PATTERN.matcher(strDate);
        return m.matches();
    }

}
