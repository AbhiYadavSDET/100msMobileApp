package Utils;

import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;


public class RSAEncUtils {
    private static final String KEY_FACTORY_ALGORITHM = "RSA/ECB/PKCS1Padding";

    private static final String TAG = "EncUtils";
    String publicKey;


    public RSAEncUtils(String key) {
        this.publicKey = key;
    }

    private PublicKey generatePublicKey(String encodedPublicKey) {
        try {
            byte[] decodedKey = Base64.decodeBase64(encodedPublicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            System.out.println(TAG + "Invalid key specification.");
            throw new IllegalArgumentException(e);
        }
    }

    public String encrypt(final String plain) {
        return encrypt(plain, false);
    }

    public String encrypt(final String plain, boolean isToURLEncode) {
        PublicKey pbKey = generatePublicKey(publicKey);
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(KEY_FACTORY_ALGORITHM);

            cipher.init(Cipher.ENCRYPT_MODE, pbKey);
            byte[] encryptedBytes = cipher.doFinal(plain.getBytes());
            byte[] encodedValue = Base64.encodeBase64(encryptedBytes);
            String string = new String(encodedValue);
            if (isToURLEncode) {
                return urlEncode(string);
            }
            return string;
        } catch (InvalidKeyException e) {
            Log.info(e.getMessage());
        } catch (IllegalBlockSizeException e) {
            Log.info(e.getMessage());
        } catch (BadPaddingException e) {
            Log.info(e.getMessage());
        } catch (Exception e) {
            Log.info(e.getMessage());
        }
        return "";
    }

    /*
     * Encode password before making an api call to escape special characters
     */
    public static String urlEncode(String str) {
        if (str == null)
            return str;
        try {
            str = URLEncoder.encode(str, Charsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            Log.info(e.getMessage());
        }
        return str;
    }
}
