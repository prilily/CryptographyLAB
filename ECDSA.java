import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class ECDSA {

    private static String src = "imooc security ecdsa";

    public static void main(String[] args) {
        jdkECDSA();//from ww w .jav a 2s .  co m
    }

    public static void jdkECDSA() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator
                    .getInstance("EC");
            keyPairGenerator.initialize(256);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            ECPublicKey ecPublicKey = (ECPublicKey) keyPair.getPublic();
            ECPrivateKey ecPrivateKey = (ECPrivateKey) keyPair.getPrivate();

            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
                    ecPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PrivateKey privateKey = keyFactory
                    .generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance("SHA1withECDSA");
            signature.initSign(privateKey);
            signature.update(src.getBytes());
            byte[] result = signature.sign();

            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                sb.append(String.format("%02X ", b));
            } 

            System.out.println("jdk ecdsa sign : "
                    + sb.toString());

            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
                    ecPublicKey.getEncoded());
            keyFactory = KeyFactory.getInstance("EC");
            PublicKey publicKey = keyFactory
                    .generatePublic(x509EncodedKeySpec);
            signature = Signature.getInstance("SHA1withECDSA");
            signature.initVerify(publicKey);
            signature.update(src.getBytes());
            boolean bool = signature.verify(result);
            System.out.println("jdk ecdsa verify : " + bool);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}