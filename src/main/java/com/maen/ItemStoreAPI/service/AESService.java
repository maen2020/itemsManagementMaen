package com.maen.ItemStoreAPI.service;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
public class AESService {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY = "1234567890abcdef";
    private static final String INIT_VECTOR = "abcdef1234567890";

    public String encrypted(String textValue){
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);

            byte[] encrypted = cipher.doFinal(textValue.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encrypted);
        }
        catch (Exception e){
            throw new RuntimeException("Error while encrypting: " + e.toString());
        }
    }
}
