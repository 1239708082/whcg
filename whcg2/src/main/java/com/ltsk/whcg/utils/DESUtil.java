package com.ltsk.whcg.utils;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;

import org.apache.commons.lang.StringUtils;  
  
/** 
 *  
 * 加密工具类 
 * @author 
 * 
 */

public class DESUtil {
  
	final static String keyData = "andyfanltsk";
    /** 
     * 加密方法 
     * @param str       要加密的字符串(密码) 
     * @param keyData   密钥(用户名) 
     * @return 
     * @throws Exception 
     * @author 
     */  
    public static String encrypt(String str,String _keyData){
    	try {
            if(StringUtils.isNotBlank(str)){
                Security.addProvider(new com.sun.crypto.provider.SunJCE());  
                Key key = getKey(keyData.getBytes("utf-8"));  
                Cipher cipher = Cipher.getInstance("DES");  
                cipher.init(Cipher.ENCRYPT_MODE, key);  
                return byteArr2HexStr(cipher.doFinal(str.getBytes("utf-8")));  
            }else{
                return str;
            }   
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
    	      
    }  
  
    /** 
     * 解密方法 
     * @param str要解密的字符串 
     * @param keyData密钥 
     * @return 
     * @throws Exception 
     * @author  
     */  
    public static String decrypt(String str,String _keyData){
    	try {
            if (!StringUtils.isBlank(str)) {  
                Security.addProvider(new com.sun.crypto.provider.SunJCE());  
                Key key = getKey(keyData.getBytes("utf-8"));  
                Cipher cipher = Cipher.getInstance("DES");  
                cipher.init(Cipher.DECRYPT_MODE, key);  
                return new String(cipher.doFinal(hexStr2ByteArr(str)), "utf-8");  
            } else {  
                return str;  
            }  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
    }  
  
    private static String byteArr2HexStr(byte[] arrB) throws Exception {  
        int iLen = arrB.length;  
        StringBuffer sb = new StringBuffer(iLen * 2);  
        for (int i = 0; i < iLen; i++) {  
            int intTmp = arrB[i];  
            while (intTmp < 0) {  
                intTmp = intTmp + 256;  
            }  
            if (intTmp < 16) {  
                sb.append(0);  
            }  
            sb.append(Integer.toString(intTmp, 16));  
        }  
        return sb.toString();  
    }  
  
    private static byte[] hexStr2ByteArr(String strln) throws Exception {  
        byte[] arrB = strln.getBytes();  
        int iLen = arrB.length;  
        byte[] arrOut = new byte[iLen / 2];  
        for (int i = 0; i < iLen; i = i + 2) {  
            String strTmp = new String(arrB, i, 2);  
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);  
        }  
        return arrOut;  
    }  
  
    private static Key getKey(byte[] arrBTmp) throws Exception {  
        byte[] arrB = new byte[8];  
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {  
            arrB[i] = arrBTmp[i];  
        }  
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");  
        return key;  
    }  
}  