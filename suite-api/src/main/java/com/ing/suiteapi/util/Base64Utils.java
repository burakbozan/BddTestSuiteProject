package com.ing.suiteapi.util;

import java.util.Base64;

public class Base64Utils {

    // String'i Base64'e kodla
    public static String encodeStringToBase64(String input) {
        byte[] bytes = input.getBytes();
        byte[] encodedBytes = Base64.getEncoder().encode(bytes);
        return new String(encodedBytes);
    }

    // Base64'i byte dizisine çöz
    public static byte[] decodeBase64ToBytes(String base64) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        return decodedBytes;
    }

    // Base64'i String'e çöz
    public static String decodeBase64ToString(String base64) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        String originalString = "Hello, world!";
        
        // String'i Base64'e kodla
        String base64String = encodeStringToBase64(originalString);
        System.out.println("Base64 Encoded String: " + base64String);
        
        // Base64'i byte dizisine çöz
        byte[] decodedBytes = decodeBase64ToBytes(base64String);
        System.out.println("Decoded Bytes: " + new String(decodedBytes));
        
        // Base64'i String'e çöz
        String decodedString = decodeBase64ToString(base64String);
        System.out.println("Decoded String: " + decodedString);
    }
}
