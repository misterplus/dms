package plus.misterplus.dms.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    private static final String SALT = "s2Q&8s^h";

    public static String md5(String plaintext){
        try {
            String toEncrypt = plaintext + SALT;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(toEncrypt.getBytes(StandardCharsets.UTF_8));
            byte[] digest = m.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                if (b < 0)
                    b += 256;
                if (b < 16)
                    sb.append(0);
                sb.append(Integer.toHexString(b));
            }
            return sb.substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
