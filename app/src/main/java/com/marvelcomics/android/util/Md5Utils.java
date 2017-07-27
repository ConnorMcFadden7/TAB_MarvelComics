package com.marvelcomics.android.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by connormcfadden on 27/07/2017.
 */

public class Md5Utils {

  public static String toMd5(String s) {
    try {
      // Create MD5 Hash
      MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
      digest.update(s.getBytes());
      byte messageDigest[] = digest.digest();

      // Create Hex String
      StringBuffer hexString = new StringBuffer();
      for (int i = 0; i < messageDigest.length; i++)
        hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return "";
  }
}
