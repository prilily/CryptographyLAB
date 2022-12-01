import java.security.*;
import javax.crypto.*;

public class Des_practise {

    public static void main(String args[]){
        try{
            KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
            SecretKey key=keyGenerator.generateKey();

            Cipher desCipher;

            desCipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
            desCipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plaintext="What is the temprarture".getBytes();

            byte[] encyptedText=desCipher.doFinal(plaintext);
            desCipher.init(Cipher.DECRYPT_MODE, key);

            byte[] decryptedText=desCipher.doFinal(encyptedText);

            System.out.println("The plain text is     "+new String(plaintext));
            System.out.println("The KEY used is       "+key );
            System.out.println("The encrypted text is "+encyptedText);
            System.out.println("The decrypted text is "+new String(decryptedText));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
