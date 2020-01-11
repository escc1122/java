package com.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class Generatingkey {
  public static void main(String[] args) {
    myKeyPair adam = new myKeyPair();
    try {
      String path = "D:/encrypt";

      // Generate the key pair (public key and private key)
      KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
      SecureRandom random = new SecureRandom();
      random.setSeed("test".getBytes());
      keygen.initialize(1024, random);           // Generate 1024-bit keys 鑰匙的長度
      KeyPair generatedKeyPair = keygen.generateKeyPair();

// Store the keys
      System.out.println("Generated Key Pair");
      adam.dumpKeyPair(generatedKeyPair);        // Print the generated keys
      adam.SaveKeyPair(path, generatedKeyPair);  // Store the keys into two files

      // Load the keys
      System.out.println("Loaded Key Pair");
      KeyPair loadedKeyPair = adam.LoadKeyPair(path, "RSA");     // Load the keys from files
      adam.dumpKeyPair(loadedKeyPair);           // Print the loaded keys
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }
  }
}
