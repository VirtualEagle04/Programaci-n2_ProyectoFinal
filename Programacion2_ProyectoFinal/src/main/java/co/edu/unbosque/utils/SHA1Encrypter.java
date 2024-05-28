package co.edu.unbosque.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Encrypter {
	
	public static String encryptSHA1(String input) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] bytes = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
	}
	
}
