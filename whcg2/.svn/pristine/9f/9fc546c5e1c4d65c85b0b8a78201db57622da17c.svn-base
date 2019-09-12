package com.ltsk.whcg.utils;

 import java.security.MessageDigest;

/**
 * 实现MD5消息摘要,接要的结果以十六进制字符串的形式返回
 * 
 * @author Administrator
 * 
 */
public class MD5 {
	private static final String encryptionName = "MD5";

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 永远返回null
	 */
	public String decrypt(String encryptedString) {
		return null;
	}

	public String encrypt(String orgString) {
		String resultString = null;
		try {
			resultString = new String(orgString);
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(orgString.getBytes("UTF-8"));
			resultString = byteArrayToHexString(md.digest());
		} catch (Exception ex) {

		}
		return resultString;
	}

	public String getEncryptionName() {
		return encryptionName;
	}

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}