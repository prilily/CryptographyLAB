package practise;

import java.security.*;
import java.secu rity.Security;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class ThreeDES {

    //DESede/ECB/Nopassing
    public static void main(String args[]){
        try{
            byte[] k="123456781234567812345678".getBytes(); 
            Security.addProvider(new BouncyCastleProvider());
            SecretKey key=new SecretKeySpec(k,"DESede/ECB/Nopadding");

            Cipher des3=Cipher.getInstance("DESede/ECB/Nopadding","BC");
            des3.init(Cipher.ENCRYPT_MODE,key);
            byte[] plaintext="what is the temprature".getBytes();
            byte[] enc=des3.doFinal(plaintext);

            des3.init(Cipher.DECRYPT_MODE, key);
            byte[] dec=des3.doFinal(enc);

            System.out.println("the plaintext is "+new String(plaintext));
            System.out.println("the 3des encrypted text is "+enc);
            System.out.println("the decrypted string is "+new String(dec));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
