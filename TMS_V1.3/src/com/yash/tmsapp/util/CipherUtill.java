package com.yash.tmsapp.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CipherUtill {
	/**
	 * This method will encrypt the provided text in encoded form
	 * @param textToEncrypt will receive the text that need to be encrypted
	 * @param key is a secret key that will be used for encryption and decryption
	 * @return encrypted code
	 * @throws Exception in case Algorithm not found or any other issue
	 */
	public static String encrypt(String textToEncrypt, String key) throws Exception { 
		String strData = "";
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(key.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(textToEncrypt.getBytes());
			strData=new String(encrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
	
	/**
	 * This method decrypt the encoded text into plain text
	 * @param encryptedText that need to be decoded into plain text
	 * @param key is a secret key that will be used for encryption and decryption
	 * @return decoded text
	 * @throws Exception Exception in case Algorithm not found or any other issue
	 */
	public static String decrypt(String encryptedText,String key) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(key.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted=cipher.doFinal(encryptedText.getBytes());
			strData=new String(decrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}


}
