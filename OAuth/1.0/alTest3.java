import org.apache.commons.lang.RandomStringUtils;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class alTest3 {

    public static void main(String[] args){
      String method="GET";
      String baseUrl="http://aaa.bb.com";
      String url="http://aaa.bb.com?aaa=bbb&ccc=ddd";
      try {
        List<Parameter> paras = new ArrayList<Parameter>();
        paras.add(new Parameter("oauth_consumer_key","oauth_consumer_key"));
        paras.add(new Parameter("oauth_token","oauth_token"));
        paras.add(new Parameter("oauth_signature_method","HMAC-SHA1"));
        paras.add(new Parameter("oauth_version","1.0"));

        String nonce = RandomStringUtils.randomAlphanumeric(20);
        Long timeStamp = System.currentTimeMillis() / 1000L;

        paras.add(new Parameter("oauth_nonce",nonce));
        paras.add(new Parameter("oauth_timestamp",timeStamp+""));

        URL urltmp = new URL(url);
        String queryString = urltmp.getQuery();
        paras.addAll(Parameter.transQueryString(queryString));



        Collections.sort(paras);


        String baseString ="";
        for (Parameter p : paras ){
          baseString=baseString+p.getKey()+"="+p.getValue()+"&";
        }

        paras.clear();

        baseString=baseString.substring(0,baseString.length()-1);

        baseString = String.format("%s&%s&%s", method, URLEncoder.encode(baseUrl,"utf-8"), URLEncoder.encode(baseString,"utf-8"));

        String key="";
        try {
          String consumerSecret = URLEncoder.encode("consumerSecret","utf-8");
          String tokenSecret = URLEncoder.encode("tokenSecret","utf-8");
          key = consumerSecret + "&" + tokenSecret;
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }

        String signature = URLEncoder.encode(getHmacSHA1(baseString,key),"utf-8");


      }catch (Exception e){
        e.printStackTrace();
      }

    }

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
