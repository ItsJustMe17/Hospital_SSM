package com.wxy.common.util;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * 加密工具
 */
public class PasswordUtil {
	 /**
     * md5加密处理
     * @param s
     * @return
     */
    private static String md5(String s) {
        try {
            // MessageDigest是封装md5算法的工具对象还支持SHA算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            //通过digest拿到的任意字符串,得到的bates都是等长的
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static String toHex(byte[] bytes) {
        //toHex的字符串把二进制转换成十六进制
        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        //循环判断是为了补位操作
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    /**
     * 生成随机字符串 长度为 8
     * @return
     */
    public static String salt(){
        //使用UUID通用唯一识别码,取第一个-前面的值
        UUID uuid = UUID.randomUUID();
        String[] arr = uuid.toString().split("-");
        return arr[0];
    }

    /**
     * 对密码进行加密加盐操作
     * @param password
     * @return
     */
    public static String encodeDefaultSalt(String password){
        //加密
        String hexPwd = md5(password);
        //生成盐
        String salt = salt();
        System.out.println("salt ：" + salt);
        //加盐操作
        StringBuilder builder = new StringBuilder(hexPwd);
        builder.insert(18, salt);
        //返回加密加盐后的字符串
        return builder.toString();
    }


    public static String encode(String password, String salt){
        //加密
        String hexPwd = md5(password);
        //加盐操作
        StringBuilder builder = new StringBuilder(hexPwd);
        builder.insert(18, salt);
        //返回加密加盐后的字符串
        return builder.toString();
    }

    /**
     * 校对密码是否匹配，匹配则返回true
     * @param password
     * @param dbPassword
     * @return
     */
    public static boolean match(String password, String dbPassword){
        StringBuilder builder = new StringBuilder(dbPassword);
        //去盐操作，生成md5加密后原始字符
        builder.replace(18, 26, "");
        //加密新密码，生成md5加密字符
        password = md5(password);
        //校对加密字符与原始字符是否匹配
        return password.equals(builder.toString());
    }

    public static void main(String[] args) {
//        String password = "cndsHFHknvildhnoiseygh/;'.''..";
        String password = "123456";
        String encode = encodeDefaultSalt(password);
        System.out.println(encode);
        System.out.println(match(password, encode));
    }
}
