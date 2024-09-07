package org.app.appfilm.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

public class EncryptUtil {
  public String SHA256(String s) throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] encoded = digest.digest(s.getBytes(StandardCharsets.UTF_8));

    StringBuilder stringBuilder = new StringBuilder();
    for (byte b: encoded) {
      String hex = Integer.toHexString(0xff & b);
      if (hex.length() == 1) {
        stringBuilder.append('0');
      }
      stringBuilder.append(hex);
    }

    return stringBuilder.toString();
  }

  public static void main(String[] args) throws NoSuchAlgorithmException {
    String s = "Hello";
    byte[] b = s.getBytes(StandardCharsets.UTF_8);
    int lengthBit = b.length * 8;

    String bitOfLengthBit = Integer.toBinaryString(lengthBit);

    StringBuilder stringBuilder = new StringBuilder();
    for (byte eachByte : b) {
      StringBuilder bit = new StringBuilder(Integer.toBinaryString(eachByte));
      while (bit.length() < 8) {
        bit.insert(0, 0);
      }

      stringBuilder.append(bit + " ");
    }

    stringBuilder.append(1);
    int group = 1;

    while (stringBuilder.length() < 512 - bitOfLengthBit.length()) {
      if (group == 7) {
        stringBuilder.append(0 + " ");
        group = 0;
      } else {
        stringBuilder.append(0);
        group++;
      }
    }

    stringBuilder.append(bitOfLengthBit);

    String[] hashInit = {
        "0xff",
        "0xdd",
        "",
        ""

    };




    System.out.println(stringBuilder);
  }
}
