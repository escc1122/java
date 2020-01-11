package com.rsa;
import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;

public class Main2 {
  public static void main(String[] args) {
    myKeyPair adam = new myKeyPair();
    PublicKey publicKey = null;
    PrivateKey privateKey = null;
    try {
      String path = "D:/encrypt";
// Load the keys
      System.out.println("Loaded Key Pair");
      KeyPair loadedKeyPair =adam.LoadKeyPair(path, "RSA");     // Load the keys from files
      publicKey = loadedKeyPair.getPublic();
      privateKey = loadedKeyPair.getPrivate();
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }
    long start, end;

// Generate the plain text
    String plainText = "abc123!@#";
    for(int i=0 ; i<10 ; i++)
      plainText += plainText;

    System.out.println("Encryption:");
    start = Calendar.getInstance().getTimeInMillis();
    myEncryption encryption = new myEncryption();
    byte[] result = null;
    try {
// Encrypt
      result = encryption.encryptByRSA(plainText.getBytes("UTF-8"), (RSAPublicKey)publicKey);
      end = Calendar.getInstance().getTimeInMillis();
      System.out.println("Encrypted time: " + (end-start) + "ms\n");

// Decrypt
      System.out.println("Decryption:");
      start = Calendar.getInstance().getTimeInMillis();
      byte[] decryptResult = encryption.decryptByRSA(result, (RSAPrivateKey)privateKey);
      end = Calendar.getInstance().getTimeInMillis();
      System.out.println("Decrypted string: " + new String(decryptResult, "UTF-8"));
      System.out.println("Decrypted time: " + (end-start) + "ms\n");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
