package com.dkf.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESTools {
	public static final String KEY_ALGORITHM = "DES";
	  public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";
	  public static final String CHART_SET = "UTF-8";

	 
	  private static Key toKey(String key) throws Exception
	  {
	    DESKeySpec des = new DESKeySpec(key.getBytes("UTF-8"));
	    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	    return keyFactory.generateSecret(des);
	  }

	  public static String encrypt(String content, String key) throws Exception
	  {
	    Key k = toKey(key);
	    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");//CBC,ECB
	//    IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
	//    cipher.init(1, k,iv);
	    cipher.init(1, k);

	    byte[] pasByte = cipher.doFinal(content.getBytes("UTF-8"));
	    return toHexString(pasByte).toUpperCase();
	  }

	  public static String decrypt(String content, String key) throws Exception
	  {
	    Key k = toKey(key);
	    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//	    IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
//	    cipher.init(1, k,iv);
	    cipher.init(2, k);
	    byte[] pasByte = cipher.doFinal(convertHexString(content));

	    return new String(pasByte, "UTF-8");
	  }

	  public static byte[] convertHexString(String ss) {
	    byte[] digest = new byte[ss.length() / 2];
	    for (int i = 0; i < digest.length; i++) {
	      String byteString = ss.substring(2 * i, 2 * i + 2);
	      int byteValue = Integer.parseInt(byteString, 16);
	      digest[i] = ((byte)byteValue);
	    }

	    return digest;
	  }

	  public static String toHexString(byte[] b) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < b.length; i++) {
	      String plainText = Integer.toHexString(0xFF & b[i]);
	      if (plainText.length() < 2)
	        plainText = "0" + plainText;
	      hexString.append(plainText);
	    }

	    return hexString.toString();
	  }
	  public static void main(String[] args)
	    throws Exception
	  {
	    String keyStr = "12345678abcdefghABCDEFGH";
	    String security1="udYPoA1PCIs=";
	    String content = "test1234 aaa 中文的";//"test1234 aaa 中文的";
	    String security = encrypt(content, keyStr);
	    System.out.println("security:"+security);
	   String content2=decrypt(security,keyStr);
	    System.out.println("content2:"+content2);
	   
	  }
}
