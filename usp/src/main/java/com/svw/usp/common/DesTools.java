/**
 * DesTools.java
 * Created at 2014-03-07
 * Created by wangkang
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.svw.usp.common;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * <p>
 * ClassName: DESTools
 * </p>
 * <p>
 * Description: 电科发短信平台加密工具类
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年9月12日
 * </p>
 */
public class DesTools {

    /**
     * <p>
     * Field KEY_ALGORITHM: 加密方式
     * </p>
     */
    public static final String KEY_ALGORITHM = "DES";

    /**
     * <p>
     * Field CIPHER_ALGORITHM: 加密方式
     * </p>
     */
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    /**
     * <p>
     * Field CHART_SET: 编码
     * </p>
     */
    public static final String CHART_SET = "UTF-8";

    /**
     * <p>
     * Field TWO: 常量2
     * </p>
     */
    public static final int TWO = 2;

    /**
     * <p>
     * Field Sixteen: 常量16
     * </p>
     */
    public static final int SIXTEEN = 16;

    /**
     * <p>
     * Field Z_16: 常量256
     * </p>
     */
    public static final int Z_16 = 0xFF;

    /**
     * <p>
     * Description: 生成key
     * </p>
     * 
     * @param key key
     * @return 秘钥
     * @throws Exception 异常
     */
    private static Key toKey(String key) throws Exception {
        DESKeySpec des = null;
        des = new DESKeySpec(key.getBytes(DesTools.CHART_SET));
        SecretKeyFactory keyFactory = null;
        keyFactory = SecretKeyFactory.getInstance("DES");
        return keyFactory.generateSecret(des);
    }

    /**
     * <p>
     * Description: 加密
     * </p>
     * 
     * @param content 内容
     * @param key 秘钥
     * @return 加密的内容
     * @throws Exception 密码
     */
    public static String encrypt(String content, String key) throws Exception {
        Key k = null;
        k = toKey(key);
        Cipher cipher = null;
        cipher = Cipher.getInstance("DES/ECB/PKCS5Padding"); //CBC,ECB
        cipher.init(Cipher.ENCRYPT_MODE, k);
        byte[] pasByte = null;
        pasByte = cipher.doFinal(content.getBytes(DesTools.CHART_SET));
        return toHexString(pasByte).toUpperCase();
    }

    /**
     * <p>
     * Description: 解密
     * </p>
     * 
     * @param content 内容
     * @param key 秘钥
     * @return 解密的内容
     * @throws Exception 异常
     */
    public static String decrypt(String content, String key) throws Exception {
        Key k = null;
        k = toKey(key);
        Cipher cipher = null;
        cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, k);
        byte[] pasByte = null;
        pasByte = cipher.doFinal(convertHexString(content));

        return new String(pasByte, DesTools.CHART_SET);
    }

    /**
     * <p>
     * Description: 内容编码
     * </p>
     * 
     * @param ss 内容
     * @return 编码后的内容
     */
    private static byte[] convertHexString(String ss) {
        byte[] digest = null;
        digest = new byte[ss.length() / DesTools.TWO];
        for (int i = 0; i < digest.length; i++) {
            String byteString = null;
            byteString = ss.substring(DesTools.TWO * i, DesTools.TWO * i + DesTools.TWO);
            int byteValue = 0;
            byteValue = Integer.parseInt(byteString, DesTools.SIXTEEN);
            digest[i] = ((byte) byteValue);
        }

        return digest;
    }

    /**
     * <p>
     * Description: 内容编码
     * </p>
     * 
     * @param b 内容
     * @return 编码后的内容
     */
    public static String toHexString(byte[] b) {
        StringBuffer hexString = null;
        hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = null;
            plainText = Integer.toHexString(DesTools.Z_16 & b[i]);
            if (plainText.length() < DesTools.TWO) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }
        return hexString.toString();
    }

    //    public static void main(String[] args) throws Exception {
    //        String keyStr = "12345678abcdefghABCDEFGH";
    //        String content = "18900000000";//"test1234 aaa 中文的";
    //        String security = encrypt(content, keyStr);
    //        System1.out.println("security:" + security);
    //        String content2 = decrypt(security, keyStr);
    //        System1.out.println("content2:" + content2);
    //    }
}
