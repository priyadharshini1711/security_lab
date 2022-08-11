import java.io.*;
import java.security.*;
public class GenerateDigitalSignature {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: nameOfFileToSign");
        } else try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(1024, random);
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey priv = pair.getPrivate();
            PublicKey pub = pair.getPublic();
            Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
            dsa.initSign(priv);
            FileInputStream fis = new FileInputStream("F:\\Digital Signature Demo\\digital.txt");
            BufferedInputStream bufin = new BufferedInputStream(fis);
            byte[] buffer = new byte[1024];
            int len;
            while (bufin.available() != 0) {
                len = bufin.read(buffer);
                dsa.update(buffer, 0, len);
            };
            bufin.close();
            byte[] realSig = dsa.sign();
            FileOutputStream sigfos = new FileOutputStream("F:\\Digital Signature Demo\\signature.txt");
            sigfos.write(realSig);
            sigfos.close();
            byte[] key = pub.getEncoded();
            FileOutputStream keyfos = new FileOutputStream("F:\\Digital Signature Demo\\publickey.txt");
            keyfos.write(key);
            keyfos.close();
        }
        catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
        }
    };
}