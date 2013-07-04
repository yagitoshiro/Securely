/**
 * Securely Titanium Security Project
 * Copyright (c) 2009-2013 by Benjamin Bahrenburg. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package bencoding.securely;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.InputStream;
//import javax.mail.internet.MimeUtility;
import android.util.Base64;

public class BlowfishCrypt {
  public static String encrypt(String seed, String cleartext) throws Exception{
    SecretKeySpec sksSpec = new SecretKeySpec(seed.getBytes(), "Blowfish");
    Cipher cipher = Cipher.getInstance("Blowfish");
    cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, sksSpec);
    byte[] bytes = cipher.doFinal(cleartext.getBytes());
    return Base64.encodeToString(bytes, 0, bytes.length, Base64.DEFAULT);
  }

  public static String decrypt(String seed, String encrypted) throws Exception{
    SecretKeySpec sksSpec = new SecretKeySpec(seed.getBytes(), "Blowfish");

    Cipher cipher = Cipher.getInstance("Blowfish");
    cipher.init(Cipher.DECRYPT_MODE, sksSpec);
    return new String(cipher.doFinal(Base64.decode(encrypted, Base64.DEFAULT)));
  }
}
