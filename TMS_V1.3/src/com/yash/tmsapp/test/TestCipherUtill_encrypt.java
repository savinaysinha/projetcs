package com.yash.tmsapp.test;

import com.yash.tmsapp.util.CipherUtill;

public class TestCipherUtill_encrypt {

	public static void main(String[] args) throws Exception {
		String encryptedText = CipherUtill.encrypt("This is my text", "S@cr@t!@#");
		System.out.println(encryptedText);

		
		
		String decriptedText = CipherUtill.decrypt("¯u‹ñž!TõÛÌºÊf{º", "S@cr@t!@#");
		System.out.println(decriptedText);
	}

}
