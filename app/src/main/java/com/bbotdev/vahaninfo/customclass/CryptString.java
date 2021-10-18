package com.bbotdev.vahaninfo.customclass;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptString {

    Cipher _cx;
    byte[] _key, _iv;

    public CryptString() throws NoSuchAlgorithmException, NoSuchPaddingException {
        _cx = Cipher.getInstance("AES/CBC/PKCS5Padding");
        _key = new byte[32]; //256 bit key space
        _iv = new byte[16]; //128 bit IV
    }

    public static final String md5(final String inputString) {
        final String MD5 = "MD5";
        try {
            MessageDigest digest = MessageDigest
                    .getInstance(MD5);
            digest.update(inputString.getBytes());
            byte[] messageDigest = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String SHA256(String text, int length) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        String resultStr;
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        md.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        StringBuffer result = new StringBuffer();
        for (byte b : digest) {
            result.append(String.format("%02x", b)); //convert to hex
        }

        if (length > result.toString().length()) {
            resultStr = result.toString();
        } else {
            resultStr = result.toString().substring(0, length);
        }

        return resultStr;

    }

    public static String generateRandomIV(int length) {
        SecureRandom ranGen = new SecureRandom();
        byte[] aesKey = new byte[16];
        ranGen.nextBytes(aesKey);
        StringBuffer result = new StringBuffer();
        for (byte b : aesKey) {
            result.append(String.format("%02x", b)); //convert to hex
        }
        if (length > result.toString().length()) {
            return result.toString();
        } else {
            return result.toString().substring(0, length);
        }
    }

    private String encryptDecrypt(String _inputText, String _encryptionKey,
                                  EncryptMode _mode, String _initVector) throws UnsupportedEncodingException,
            InvalidKeyException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException {
        String _out = "";

        int len = _encryptionKey.getBytes(StandardCharsets.UTF_8).length; // length of the key	provided

        if (_encryptionKey.getBytes(StandardCharsets.UTF_8).length > _key.length)
            len = _key.length;

        int ivlen = _initVector.getBytes(StandardCharsets.UTF_8).length;

        if (_initVector.getBytes(StandardCharsets.UTF_8).length > _iv.length)
            ivlen = _iv.length;

        System.arraycopy(_encryptionKey.getBytes(StandardCharsets.UTF_8), 0, _key, 0, len);
        System.arraycopy(_initVector.getBytes(StandardCharsets.UTF_8), 0, _iv, 0, ivlen);
        SecretKeySpec keySpec = new SecretKeySpec(_key, "AES");

        IvParameterSpec ivSpec = new IvParameterSpec(_iv); // Create a new
        if (_mode.equals(EncryptMode.ENCRYPT)) {
            _cx.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] results = _cx.doFinal(_inputText.getBytes(StandardCharsets.UTF_8));
            _out = Base64.encodeToString(results, Base64.DEFAULT);
        }

        // decryption
        if (_mode.equals(EncryptMode.DECRYPT)) {
            _cx.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            byte[] decodedValue = Base64.decode(_inputText.getBytes(),
                    Base64.DEFAULT);
            byte[] decryptedVal = _cx.doFinal(decodedValue);
            _out = new String(decryptedVal);
        }
        return _out;
    }

    /***
     * This function encrypts the plain text to cipher text using the key
     * provided. You'll have to use the same key for decryption
     *
     * @param _plainText
     *            Plain text to be encrypted
     * @param _key
     *            Encryption Key. You'll have to use the same key for decryption
     * @param _iv
     * 	    initialization Vector
     * @return returns encrypted (cipher) text
     * @throws InvalidKeyException
     * @throws UnsupportedEncodingException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */

    public String encrypt(String _plainText, String _key, String _iv)
            throws InvalidKeyException, UnsupportedEncodingException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException,
            BadPaddingException {
        return encryptDecrypt(_plainText, _key, EncryptMode.ENCRYPT, _iv);
    }

    public String encryptSimple(String _plainText, String _key, String _iv)
            throws InvalidKeyException, UnsupportedEncodingException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException,
            BadPaddingException, NoSuchAlgorithmException {
        return encryptDecrypt(_plainText, CryptString.SHA256(_key, 32), EncryptMode.ENCRYPT, _iv);
    }


    /***
     * This funtion decrypts the encrypted text to plain text using the key
     * provided. You'll have to use the same key which you used during
     * encryprtion
     *
     * @param _encryptedText
     *            Encrypted/Cipher text to be decrypted
     * @param _key
     *            Encryption key which you used during encryption
     * @param _iv
     * 	    initialization Vector
     * @return encrypted value
     * @throws InvalidKeyException
     * @throws UnsupportedEncodingException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public String decrypt(String _encryptedText, String _key, String _iv)
            throws InvalidKeyException, UnsupportedEncodingException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException,
            BadPaddingException {
        return encryptDecrypt(_encryptedText, _key, EncryptMode.DECRYPT, _iv);
    }

    public String decryptSimple(String _encryptedText, String _key, String _iv)
            throws InvalidKeyException, UnsupportedEncodingException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException,
            BadPaddingException, NoSuchAlgorithmException {
        return encryptDecrypt(_encryptedText, CryptString.SHA256(_key, 32), EncryptMode.DECRYPT, _iv);
    }

    private enum EncryptMode {
        ENCRYPT, DECRYPT
    }
}