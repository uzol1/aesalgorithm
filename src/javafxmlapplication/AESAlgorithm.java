/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 *
 * @author ujjwal
 */
public class AESAlgorithm {
    public static String ALGO= "AES";
    
    public byte[] keyValue;
    
    public AESAlgorithm(String key) {
        
    keyValue = key.getBytes();
    }
    public Key generateKey() throws Exception{
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
keyValue = sha.digest(keyValue);
keyValue = Arrays.copyOf(keyValue, 16); // use only first 128 bit

        Key key= new SecretKeySpec(keyValue, ALGO);
        return key;
    
    }
    public String encrypt(String Data) throws Exception {
        Key key= generateKey();
        Cipher c= Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal= c.doFinal(Data.getBytes());
        String encryptedValue= new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }
   public String decrypt(String encryptedData) throws Exception{
        Key ky= generateKey();
   Cipher c=Cipher.getInstance(ALGO);
   c.init(Cipher.DECRYPT_MODE ,ky);
   byte[] decodedValue= new BASE64Decoder().decodeBuffer(encryptedData);
   byte[] decValue=c.doFinal(decodedValue);
   String decryptedValue = new String(decValue);
   return decryptedValue;
   } 
}
            
