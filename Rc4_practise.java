package practise;

import javax.crypto.*;
import java.security.*;

public class Rc4_practise {
    private static final String algo="ARCFOUR";
    public static void main(String args[]){
        try{
            KeyGenerator keyGenerator=KeyGenerator.getInstance(algo);
            SecretKey key=keyGenerator.generateKey();
            Cipher rc4=Cipher.getInstance(algo);

            byte[] plaintext="what is the temprature ".getBytes();
            rc4.init(Cipher.ENCRYPT_MODE, key);

            byte[] enc=rc4.doFinal(plaintext);
            rc4.init(Cipher.DECRYPT_MODE, key);

            byte[] dec=rc4.doFinal(enc);

            System.out.println("The plain text is     "+new String(plaintext));
            System.out.println("The KEY used is       "+key );
            System.out.println("The encrypted text is "+enc);
            System.out.println("The decrypted text is "+new String(dec));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
