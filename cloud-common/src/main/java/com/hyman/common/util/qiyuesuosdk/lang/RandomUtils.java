package com.hyman.common.util.qiyuesuosdk.lang;

import java.util.Random;

/**
 * 项目中已经引入多种三方工具包，如果可能，请尽量不要自定义工具类
 */
public class RandomUtils {

	 /**
	  * 生成随即密码
	  * @param pwd_len 生成的密码的总长度
	  * @return  密码的字符串
	  */
	 public static String genRandomNum(int pwd_len){
	  //35是因为数组是从0开始的，26个字母+10个数字
	  final int  maxNum = 36;
	  int i;  //生成的随机数
	  int count = 0; //生成的密码的长度
	  char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
	    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
	    'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	  StringBuffer pwd = new StringBuffer();
	  Random r = new Random();
	  while(count < pwd_len){
	   //生成随机数，取绝对值，防止生成负数，

	   i = Math.abs(r.nextInt(maxNum));  //生成的数最大为36-1

	   if (i >= 0 && i < str.length) {
	    pwd.append(str[i]);
	    count ++;
	   }
	  }

	  return pwd.toString();
	 }

}
