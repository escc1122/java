/**
 * HMACSHA1 加密
 * Created by alma on 2016/7/15.
 */

public class HmacSHA1 {
    public static String getHmacSHA1(String data, String key) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String HMAC_SHA1_ALGORITHM = "HmacSHA1";
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes("utf-8"), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);

        byte[] result = mac.doFinal(data.getBytes("utf-8"));
        BASE64Encoder encoder = new BASE64Encoder();
        String checksum = encoder.encode(result);
        return checksum;
    }


}
